package com.bytedance.android.annie.business.latch;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements l {
    public final String a;
    public final Lazy b;
    public final Map<String, Pair<Boolean, Long>> c;
    public final e d;

    public static final class a {
    }

    static {
    }

    public f(int r10) {
        Intrinsics.checkNotNullParameter("host", "mBizKey");
        this.a = "host";
        this.b = LazyKt.lazy(AnnieBusinessLatchServiceImpl$latch$2.INSTANCE);
        this.c = new LinkedHashMap();
        this.d = new e();
    }

    public static LatchProcessOptions I1(IAnnieBusinessLatchService.a r10) {
        LatchProcessOptions r0 = new LatchProcessOptions();
        String r1 = r10.a;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
        r0.b = r10.b;
        String r11 = r10.c;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.c = r11;
        Map<String, String> r12 = r10.g;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r0.f = r12;
        LatchProcessOptions.PrefetchPartial r13 = LatchProcessOptions.PrefetchPartial.LATCH;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r0.e = r13;
        r0.d = new com.bytedance.android.annie.business.latch.a(r10.e, r10.d, r10.f);
        return r0;
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final void P0(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        IAnnieBusinessLatchService.b r11 = null;
        HybridLogger.f("AnnieBusinessLatchService", "============releaseLatchProcess================", null, 12);
        String r12 = UriProtector.getQueryParameter(r10, "latch_id");
        if (r12 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r12)) == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L18;
        Integer r13 = StringsKt.toIntOrNull(r12);
        if (r13 == null) goto L19;
        Pair<IAnnieBusinessLatchService.b, String> r14 = this.d.a.remove(Integer.valueOf(r13.intValue()));
        if (r14 == null) goto L14;
        r11 = (IAnnieBusinessLatchService.b) r14.getFirst();
    L14:
        if (r11 == null) goto L20;
        r11.dispose();
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final String i(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        HybridLogger.f("AnnieBusinessLatchService", "============findUuid================", null, 12);
        String r11 = UriProtector.getQueryParameter(r10, "latch_id");
        if (r11 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r11)) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L16;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L17;
        int r13 = r12.intValue();
        Pair r14 = (Pair) ((LinkedHashMap) this.d.a).get(Integer.valueOf(r13));
        if (r14 != null) goto L14;
        return null;
    L14:
        return (String) r14.getSecond();
    L17:
        return null;
    L16:
        return null;
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final void d(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.constructor-impl(UriProtector.parse(r10).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r13) == false) goto L10;
        r13 = null;
    L10:
        String r14 = (String) r13;
        if (r14 == null) goto L16;
        this.c.put(r14, new Pair(Boolean.TRUE, Long.valueOf(SystemClock.elapsedRealtime())));
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final Pair<IAnnieBusinessLatchService.PrefetchStrategy, String> k(Uri r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "uri");
        Intrinsics.checkNotNullParameter(r20, com.bytedance.android.ec.core.event.a.KEY_URL);
        h r10 = h.a;
        String r11 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r19, "uri");
        Intrinsics.checkNotNullParameter(r20, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        String r12 = UriProtector.getQueryParameter(r19, "enable_prefetch");     // Catch: Throwable -> L21
        String r0 = UriProtector.getQueryParameter(r19, "enable_latch");     // Catch: Throwable -> L21
        boolean r13 = false;
        if (r12 != null) goto L6;
    L9:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L19;
        if (r0 != null) goto L14;
    L15:
        r13 = true;
    L16:
        if (r13 == true) goto L18;
        r12 = r0;
        goto L19
    L18:
        r12 = UriProtector.getQueryParameter(UriProtector.parse(r20), "use_latch_ng");     // Catch: Throwable -> L21
        goto L19
    L14:
        if (StringsKt.isBlank(r0) == false) goto L16;
    L19:
        Object r15 = Result.constructor-impl(r12);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r15) == false) goto L26;
        r15 = null;
    L26:
        String r16 = (String) r15;
        if (Intrinsics.areEqual(r16, "1") == true) goto L29;
        String r17 = "check if scheme append enable_latch or enable_prefetch.";
    L30:
        y9.i<Integer> r18 = AnnieConfigSettingKeys.ENABLE_ANNIE_LATCH;
        Integer r21 = r18.a();
        if (r21 != null) goto L34;
    L35:
        r17 = "check if current appVersion support Latch.";
    L36:
        String r110 = r17;
        if (Intrinsics.areEqual(r16, "1") == false) goto L45;
        Integer r22 = r18.a();
        if (r22 != null) goto L42;
    L43:
        r16 = "";
        goto L45
    L42:
        if (r22.intValue() != 1) goto L43;
    L45:
        if (Intrinsics.areEqual(r16, "1") == false) goto L54;
        IAnnieBusinessLatchService.PrefetchStrategy r111 = IAnnieBusinessLatchService.PrefetchStrategy.Latch;
        j9.b r23 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r24 = new JSONObject();
        r24.put("optimize_type", 1);
        Unit r25 = Unit.INSTANCE;
        JSONObject r26 = new JSONObject();
        com.bytedance.android.annie.ng.a r27 = com.bytedance.android.annie.ng.g.c.get(r11);
        if (r27 == null) goto L52;
        o8.f r28 = r27.b;
        if (r28 == null) goto L52;
        String r29 = r28.a;
        if (r29 == null) goto L52;
    L53:
        r26.put("virtual_aid", r29);
        j9.b.a.a(r23, null, "latch_ng_start", r20, r24, null, null, r26, 0, 256);
        ((IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null)).d(r20, true);
    L56:
        return new Pair(r111, r110);
    L52:
        r29 = "88888";
        goto L53
    L54:
        r111 = IAnnieBusinessLatchService.PrefetchStrategy.Nothing;
        goto L56
    L34:
        if (r21.intValue() == 1) goto L36;
    L29:
        r17 = "";
        goto L30
    L6:
        if (StringsKt.isBlank(r12) == true) goto L9;
        r14 = false;
    L21:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public static String H1(Uri r10, String r11, String r12) {
        Uri.Builder r0 = UriProtector.parse(r11).buildUpon();
        String r13 = UriProtector.getQueryParameter(r10, "loader_name");
        boolean r14 = true;
        if (r13 == null) goto L5;
        r0.appendQueryParameter("loader_name", r13);
        boolean r1 = true;
    L6:
        String r15 = UriProtector.getQueryParameter(r10, "lock_resource");
        if (r15 == null) goto L15;
        r0.appendQueryParameter("lock_resource", r15);
        String r16 = UriProtector.getQueryParameter(r10, "forest_session_id");
        if (r16 != null) goto L11;
    L16:
        if (r14 == true) goto L18;
        return r11;
    L18:
        return r0.build().toString();
    L11:
        if (StringsKt.isBlank(r16) == true) goto L14;
        r12 = r16;
    L14:
        r0.appendQueryParameter("forest_session_id", r12);
        goto L16
    L15:
        r14 = r1;
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final IAnnieBusinessLatchService.a e(long r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "display");
        Intrinsics.checkNotNullParameter(r12, "errMsg");
        HybridLogger.f("AnnieBusinessLatchService", "============createLatchProcessOptions================", null, 12);
        IAnnieBusinessLatchService.a r0 = new IAnnieBusinessLatchService.a();
        r0.b = r10;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.c = r11;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r0.a = r12;
        r0.e = r13;
        String r14 = this.a;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r0.f = r14;
        return r0;
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final int w1(Context r10, String r11, Uri r12, IAnnieBusinessLatchService.a r13) {
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r13, "latchProcessOptions");
        if (r11 != null) goto L6;
        return -1;
    L6:
        Long r14 = null;
        HybridLogger.f("AnnieBusinessLatchService", "============prefetch================", null, 12);
        String r0 = UUID.randomUUID().toString();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r13.d = r0;
        int r1 = com.bytedance.android.latch.b.c;
        com.bytedance.android.latch.b.a.a(r13.g, "enableRegisterXBridge", true);
        com.bytedance.android.latch.b.a.a(r13.g, "enableCheckVersion", AnnieConfigSettingKeys.LATCH_ENABLE_CHECK_VERSION.a().booleanValue());
        e r15 = this.d;
        kx.a r16 = (kx.a) this.b.getValue();
        String r17 = H1(r12, r11, r0);
        String r18 = UriProtector.getQueryParameter(r12, "open_time");
        if (r18 != null) goto L9;
    L14:
        g r19 = new g(r16.c(r10, r11, new b(r10, r12, r17, r14), I1(r13)));
        r15.getClass();
        Intrinsics.checkNotNullParameter(r19, "process");
        Intrinsics.checkNotNullParameter(r0, "uuid");
        int r20 = r15.b.incrementAndGet();
        r15.a.put(Integer.valueOf(r20), TuplesKt.to(r19, r0));
        return r20;
    L9:
        if ((true ^ StringsKt.isBlank(r18)) == true) goto L12;
        r18 = null;
    L12:
        if (r18 == null) goto L14;
        r14 = StringsKt.toLongOrNull(r18);
        goto L14
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final IAnnieBusinessLatchService.b C0(Context r10, String r11, String r12, Uri r13, long r14, IAnnieBusinessLatchService.a r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "originUrl");
        Intrinsics.checkNotNullParameter(r12, "uuid");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r15, "latchProcessOptions");
        HybridLogger r0 = HybridLogger.a;
        IAnnieBusinessLatchService.b r17 = null;
        HybridLogger.f("AnnieBusinessLatchService", "============attachPage: enableLatch: " + r16 + "================", null, 12);
        if (r16 == false) goto L5;
        if (r10 != null) goto L8;
        String r18 = "context is null";
    L10:
        if (r18.length() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L16;
        kx.a r19 = (kx.a) this.b.getValue();
        LatchProcessOptions r20 = I1(r15);
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r20.a = r18;
        Unit r21 = Unit.INSTANCE;
        return new g(r19.a(r20));
    L16:
        String r22 = H1(r13, r11, r12);
        String r23 = UriProtector.getQueryParameter(r13, "latch_id");
        if (r23 != null) goto L19;
    L24:
        Integer r24 = null;
    L25:
        if (r24 == null) goto L31;
        Pair<IAnnieBusinessLatchService.b, String> r25 = this.d.a.remove(Integer.valueOf(r24.intValue()));
        if (r25 == null) goto L29;
        r17 = (IAnnieBusinessLatchService.b) r25.getFirst();
    L29:
        if (r17 == null) goto L31;
        return r17;
    L31:
        kx.a r26 = (kx.a) this.b.getValue();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r22);
        return new g(r26.c(r10, r22, new com.bytedance.android.annie.lynx.service.latch.c(r10, r13, r22, Long.valueOf(r14)), I1(r15)));
    L19:
        if ((!StringsKt.isBlank(r23)) == true) goto L22;
        r23 = null;
    L22:
        if (r23 == null) goto L24;
        r24 = StringsKt.toIntOrNull(r23);
        goto L25
    L12:
        r1 = false;
        goto L13
    L8:
        r18 = "";
        goto L10
    L5:
        return new g(((kx.a) this.b.getValue()).a(I1(r15)));
    }
}
