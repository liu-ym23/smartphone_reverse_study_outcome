package com.bytedance.android.annie.lynx.service.latch;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
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
public final class g implements com.bytedance.android.annie.lynx.service.latch.a {
    public final String a;
    public final Lazy b;
    public final Map<String, Pair<Boolean, Long>> c;
    public final f d;

    public static final class a {
    }

    public static final class b implements ILatchService.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ ILatchService.d b;
        public final /* synthetic */ g c;

        @Override // com.bytedance.android.annie.service.latch.ILatchService.a
        public final void a(ILatchService.c r12) {
            Intrinsics.checkNotNullParameter(r12, "perfMetric");
            j9.b r1 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r10 = this.a;
            JSONObject r11 = r12.b;
            JSONObject r13 = r12.a;
            JSONObject r14 = r12.c;
            JSONObject r15 = new JSONObject();
            g r16 = this.c;
            com.bytedance.android.annie.ng.a r17 = com.bytedance.android.annie.ng.g.c.get(r16.a);
            if (r17 == null) goto L8;
            o8.f r18 = r17.b;
            if (r18 == null) goto L8;
            String r19 = r18.a;
            if (r19 == null) goto L8;
        L9:
            r15.put("virtual_aid", r19);
            Unit r110 = Unit.INSTANCE;
            r1.b(null, "latch_timeline", r10, r11, r13, r14, r15, 1, this.b.e);
            return;
        L8:
            r19 = "88888";
            goto L9
        }

        @Override // com.bytedance.android.annie.service.latch.ILatchService.a
        public final void b(ILatchService.b r19) {
            Intrinsics.checkNotNullParameter(r19, "jsbPromiseMetric");
            j9.b r10 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r11 = this.a;
            JSONObject r12 = r19.a;
            JSONObject r13 = new JSONObject();
            g r14 = this.c;
            ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r15 = com.bytedance.android.annie.ng.g.c;
            com.bytedance.android.annie.ng.a r16 = r15.get(r14.a);
            if (r16 == null) goto L8;
            o8.f r17 = r16.b;
            if (r17 == null) goto L8;
            String r18 = r17.a;
            if (r18 == null) goto L8;
        L9:
            r13.put("virtual_aid", r18);
            Unit r20 = Unit.INSTANCE;
            r10.b(null, "latch_jsb_promise", r11, r12, null, null, r13, 1, this.b.e);
            Object r21 = r19.a.get("status_code");
            if ((r21 instanceof Integer) == false) goto L12;
            Integer r22 = (Integer) r21;
        L13:
            if (r22 != null) goto L16;
            return;
        L16:
            if (r22.intValue() != 1) goto L26;
            j9.b r23 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r24 = this.a;
            JSONObject r25 = r19.a;
            JSONObject r26 = r19.b;
            JSONObject r27 = r19.c;
            JSONObject r110 = new JSONObject();
            com.bytedance.android.annie.ng.a r1 = r15.get(this.c.a);
            if (r1 == null) goto L23;
            o8.f r28 = r1.b;
            if (r28 == null) goto L23;
            String r29 = r28.a;
            if (r29 == null) goto L23;
        L24:
            r110.put("virtual_aid", r29);
            r23.b(null, "latch_jsb_promise_fail", r24, r25, r26, r27, r110, 0, this.b.e);
            return;
        L23:
            r29 = "88888";
            goto L24
        L26:
            return;
        L12:
            r22 = null;
        L8:
            r18 = "88888";
            goto L9
        }

        public b(String r1, ILatchService.d r10, g r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // com.bytedance.android.annie.service.latch.ILatchService.a
        public final void c(int r23, int r24, String r25, String r26, int r27, String r28, Map<String, ? extends Object> r29) {
            Intrinsics.checkNotNullParameter(r25, "transferType");
            Intrinsics.checkNotNullParameter(r26, "errMessage");
            Intrinsics.checkNotNullParameter(r28, "engineType");
            Intrinsics.checkNotNullParameter(r29, "extras");
            j9.b r10 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r13 = this.a;
            JSONObject r14 = new JSONObject();
            r14.put("cached", r24);
            r14.put("status_code", r23);
            r14.put("transfer_type", r25);
            r14.put("err_msg", r26);
            r14.put("timeout", r27);
            r14.put("engine_type", r28);
            Iterator<Map.Entry<String, ? extends Object>> r11 = r29.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<String, ? extends Object> r12 = r11.next();
            r14.put(r12.getKey(), r12.getValue());
            goto L4
        L6:
            Unit r15 = Unit.INSTANCE;
            JSONObject r16 = new JSONObject();
            g r17 = this.c;
            com.bytedance.android.annie.ng.a r18 = com.bytedance.android.annie.ng.g.c.get(r17.a);
            String r19 = "88888";
            if (r18 == null) goto L12;
            o8.f r20 = r18.b;
            if (r20 == null) goto L12;
            String r21 = r20.a;
            if (r21 == null) goto L12;
        L13:
            r16.put("virtual_aid", r21);
            r10.b(null, "latch_result_all", r13, r14, null, null, r16, 1, this.b.e);
            if (r23 == 1) goto L31;
            j9.b r110 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r111 = this.a;
            JSONObject r112 = new JSONObject();
            r112.put("status_code", r23);
            r112.put("err_msg", r26);
            r112.put("timeout", r27);
            Iterator<Map.Entry<String, ? extends Object>> r1 = r29.entrySet().iterator();
        L17:
            if (r1.hasNext() == false) goto L19;
            Map.Entry<String, ? extends Object> r22 = r1.next();
            r112.put(r22.getKey(), r22.getValue());
            goto L17
        L19:
            Unit r30 = Unit.INSTANCE;
            JSONObject r31 = new JSONObject();
            g r32 = this.c;
            com.bytedance.android.annie.ng.a r33 = com.bytedance.android.annie.ng.g.c.get(r32.a);
            if (r33 == null) goto L27;
            o8.f r34 = r33.b;
            if (r34 == null) goto L27;
            String r35 = r34.a;
            if (r35 == null) goto L27;
            r19 = r35;
        L27:
            r31.put("virtual_aid", r19);
            r110.b(null, "latch_result_error", r111, r112, null, null, r31, 0, this.b.e);
            return;
        L31:
            return;
        L12:
            r21 = "88888";
            goto L13
        }
    }

    static {
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void initPrefetch() {
        Map<String, com.bytedance.android.latch.prefetch.internal.g> r0 = LatchPrefetchProcessorHolder.a;
        LatchPrefetchProcessorHolder.a(((com.bytedance.android.annie.service.resource.f) Annie.getService$default(com.bytedance.android.annie.service.resource.f.class, null, 2, null)).r());
    }

    public g(int r10) {
        Intrinsics.checkNotNullParameter("host", "mBizKey");
        this.a = "host";
        this.b = LazyKt.lazy(LatchServiceImpl$latch$2.INSTANCE);
        this.c = new LinkedHashMap();
        this.d = new f();
    }

    public final LatchProcessOptions H1(ILatchService.d r10) {
        LatchProcessOptions r0 = new LatchProcessOptions();
        String r1 = r10.a;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.a = r1;
        r0.b = r10.b;
        ILatchService.a r11 = r10.d;
        if (r11 == null) goto L5;
        h r12 = new h(r11, this);
    L6:
        r0.d = r12;
        String r13 = r10.c;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r0.c = r13;
        Map<String, String> r14 = r10.g;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r0.f = r14;
        if (r10.f == false) goto L9;
        LatchProcessOptions.PrefetchPartial r15 = LatchProcessOptions.PrefetchPartial.NATIVE;
    L10:
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r0.e = r15;
        return r0;
    L9:
        r15 = LatchProcessOptions.PrefetchPartial.LATCH;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final boolean O0(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        return r10 instanceof gx.a;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void Q0(String r13) {
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        j r1 = j.a;
        String r10 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r10, "bizKey");
        LinkedList r0 = (LinkedList) ((LinkedHashMap) j.b).get(r13);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L20;
        j9.b r11 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r12 = new JSONObject();
        r12.put("optimize_type", 2);
        Unit r14 = Unit.INSTANCE;
        JSONObject r15 = new JSONObject();
        r15.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, SystemClock.elapsedRealtime() - ((Number) r0.removeFirst()).longValue());
        JSONObject r16 = new JSONObject();
        com.bytedance.android.annie.ng.a r17 = com.bytedance.android.annie.ng.g.c.get(r10);
        if (r17 == null) goto L16;
        o8.f r18 = r17.b;
        if (r18 == null) goto L16;
        String r19 = r18.a;
        if (r19 == null) goto L16;
    L17:
        r16.put("virtual_aid", r19);
        j9.b.a.a(r11, null, "latch_ng_callback", r13, r12, r15, null, r16, 0, 256);
        return;
    L16:
        r19 = "88888";
        goto L17
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final String R0(View r10) {
        if ((r10 instanceof gx.a) == false) goto L5;
        gx.a r11 = (gx.a) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.getUrl();
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void S0(String r14) {
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_URL);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(UriProtector.parse(r14).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        String r10 = (String) r1;
        if (r10 != null) goto L13;
        return;
    L13:
        Pair<Boolean, Long> r11 = this.c.remove(r10);
        if (r11 != null) goto L16;
        return;
    L16:
        boolean r12 = ((Boolean) r11.component1()).booleanValue();
        long r13 = ((Number) r11.component2()).longValue();
        j9.b r15 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r16 = new JSONObject();
        if (r12 == false) goto L19;
        int r17 = 3;
    L20:
        r16.put("optimize_type", r17);
        Unit r18 = Unit.INSTANCE;
        JSONObject r19 = new JSONObject();
        r19.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, SystemClock.elapsedRealtime() - r13);
        JSONObject r110 = new JSONObject();
        com.bytedance.android.annie.ng.a r20 = com.bytedance.android.annie.ng.g.c.get(this.a);
        if (r20 == null) goto L26;
        o8.f r21 = r20.b;
        if (r21 == null) goto L26;
        String r22 = r21.a;
        if (r22 == null) goto L26;
    L27:
        r110.put("virtual_aid", r22);
        j9.b.a.a(r15, null, "latch_ng_callback", r14, r16, r19, null, r110, 0, 256);
        return;
    L26:
        r22 = "88888";
        goto L27
    L19:
        r17 = 4;
    L5:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final boolean c(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        return r10 instanceof LynxView;
    L5:
        return false;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final String i(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
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

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void s(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        String r11 = UriProtector.getQueryParameter(r10, "latch_id");
        if (r11 == null) goto L17;
        ILatchService.e r1 = null;
        if ((!StringsKt.isBlank(r11)) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L18;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L19;
        Pair<ILatchService.e, String> r13 = this.d.a.remove(Integer.valueOf(r12.intValue()));
        if (r13 == null) goto L14;
        r1 = (ILatchService.e) r13.getFirst();
    L14:
        if (r1 == null) goto L20;
        r1.dispose();
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void d(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(UriProtector.parse(r10).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r12) == false) goto L10;
        r12 = null;
    L10:
        String r13 = (String) r12;
        if (r13 == null) goto L16;
        this.c.put(r13, new Pair(Boolean.valueOf(r11), Long.valueOf(SystemClock.elapsedRealtime())));
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final Pair<ILatchService.PrefetchStrategy, String> k(Uri r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "uri");
        Intrinsics.checkNotNullParameter(r21, com.bytedance.android.ec.core.event.a.KEY_URL);
        j r10 = j.a;
        String r11 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r20, "uri");
        Intrinsics.checkNotNullParameter(r21, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        String r12 = UriProtector.getQueryParameter(r20, "enable_prefetch");     // Catch: Throwable -> L23
        String r0 = UriProtector.getQueryParameter(r20, "enable_latch");     // Catch: Throwable -> L23
        if (r12 != null) goto L6;
    L9:
        boolean r13 = true;
    L10:
        if (r13 == false) goto L21;
        if (r0 != null) goto L14;
    L17:
        boolean r14 = true;
    L18:
        if (r14 == true) goto L20;
        r12 = r0;
        goto L21
    L20:
        r12 = UriProtector.getQueryParameter(UriProtector.parse(r21), "use_latch_ng");     // Catch: Throwable -> L23
        goto L21
    L14:
        if (StringsKt.isBlank(r0) == true) goto L17;
        r14 = false;
    L21:
        Object r15 = Result.constructor-impl(r12);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r15) == false) goto L28;
        r15 = null;
    L28:
        String r16 = (String) r15;
        if (Intrinsics.areEqual(r16, "1") == true) goto L31;
        String r17 = "check if scheme append enable_latch or enable_prefetch.";
    L32:
        y9.i<Integer> r18 = AnnieConfigSettingKeys.ENABLE_LATCH;
        Integer r19 = r18.a();
        if (r19 != null) goto L36;
    L37:
        r17 = "check if current appVersion support Latch.";
    L38:
        String r110 = r17;
        if (Intrinsics.areEqual(r16, "1") == false) goto L46;
        Integer r22 = r18.a();
        if (r22 != null) goto L44;
    L45:
        r16 = "";
        goto L46
    L44:
        if (r22.intValue() != 1) goto L45;
    L46:
        if (r16 == null) goto L81;
        String r23 = "88888";
        switch(r16.hashCode()) {
            case 48: goto L78;
            case 49: goto L66;
            case 50: goto L51;
            default: goto L81;
        };
    L51:
        if (r16.equals("2") == false) goto L81;
        ILatchService.PrefetchStrategy r111 = ILatchService.PrefetchStrategy.Prefetch;
        j9.b r24 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r25 = new JSONObject();
        r25.put("optimize_type", 2);
        Unit r26 = Unit.INSTANCE;
        JSONObject r27 = new JSONObject();
        com.bytedance.android.annie.ng.a r28 = com.bytedance.android.annie.ng.g.c.get(r11);
        if (r28 == null) goto L61;
        o8.f r29 = r28.b;
        if (r29 == null) goto L61;
        String r30 = r29.a;
        if (r30 == null) goto L61;
        r23 = r30;
    L61:
        r27.put("virtual_aid", r23);
        j9.b.a.a(r24, null, "latch_ng_start", r21, r25, null, null, r27, 0, 256);
        LinkedHashMap r31 = (LinkedHashMap) j.b;
        Object r32 = r31.get(r21);
        if (r32 != null) goto L64;
        r32 = new LinkedList();
        r31.put(r21, r32);
    L64:
        ((LinkedList) r32).push(Long.valueOf(SystemClock.elapsedRealtime()));
        ((ILatchService) Annie.getService$default(ILatchService.class, null, 2, null)).d(r21, false);
    L83:
        return new Pair(r111, r110);
    L66:
        if (r16.equals("1") == false) goto L81;
        ILatchService.PrefetchStrategy r112 = ILatchService.PrefetchStrategy.Latch;
        j9.b r33 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r34 = new JSONObject();
        r34.put("optimize_type", 1);
        Unit r35 = Unit.INSTANCE;
        JSONObject r36 = new JSONObject();
        com.bytedance.android.annie.ng.a r37 = com.bytedance.android.annie.ng.g.c.get(r11);
        if (r37 == null) goto L76;
        o8.f r38 = r37.b;
        if (r38 == null) goto L76;
        String r39 = r38.a;
        if (r39 == null) goto L76;
        r23 = r39;
    L76:
        r36.put("virtual_aid", r23);
        j9.b.a.a(r33, null, "latch_ng_start", r21, r34, null, null, r36, 0, 256);
        ((ILatchService) Annie.getService$default(ILatchService.class, null, 2, null)).d(r21, true);
        r111 = r112;
        goto L83
    L78:
        if (r16.equals("0") == false) goto L81;
        r111 = ILatchService.PrefetchStrategy.Nothing;
    L81:
        r111 = ILatchService.PrefetchStrategy.Prefetch;
        goto L83
    L36:
        if (r19.intValue() == 1) goto L38;
    L31:
        r17 = "";
        goto L32
    L6:
        if (StringsKt.isBlank(r12) == true) goto L9;
        r13 = false;
    L23:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final int d1(Context r10, String r11, Uri r12, ILatchService.d r13) {
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r13, "latchProcessOptions");
        if (r11 != null) goto L6;
        return -1;
    L6:
        String r0 = UUID.randomUUID().toString();
        boolean r14 = false;
        boolean r1 = r12.getBooleanQueryParameter("enableLatchXBridge", false);
        r13.e = r0;
        int r15 = com.bytedance.android.latch.b.c;
        com.bytedance.android.latch.b.a.a(r13.g, "enableRegisterXBridge", r1);
        com.bytedance.android.latch.b.a.a(r13.g, "enableCheckVersion", AnnieConfigSettingKeys.LATCH_ENABLE_CHECK_VERSION.a().booleanValue());
        f r16 = this.d;
        ex.a r17 = (ex.a) this.b.getValue();
        Uri.Builder r18 = UriProtector.parse(r11).buildUpon();
        String r19 = UriProtector.getQueryParameter(r12, "loader_name");
        if (r19 == null) goto L9;
        r18.appendQueryParameter("loader_name", r19);
        r14 = true;
    L9:
        String r20 = UriProtector.getQueryParameter(r12, "lock_resource");
        if (r20 == null) goto L18;
        r18.appendQueryParameter("lock_resource", r20);
        String r21 = UriProtector.getQueryParameter(r12, "forest_session_id");
        if (r21 != null) goto L14;
    L17:
        r14 = true;
        goto L18
    L14:
        if (StringsKt.isBlank(r21) == false) goto L16;
        r21 = r0;
    L16:
        r18.appendQueryParameter("forest_session_id", r21);
    L18:
        if (r14 == false) goto L20;
        String r22 = r18.build().toString();
    L21:
        String r23 = UriProtector.getQueryParameter(r12, "open_time");
        Long r24 = null;
        if (r23 != null) goto L24;
    L29:
        i r110 = new i(r17.b(r10, r11, new c(r10, r12, r22, r24), H1(r13)));
        r16.getClass();
        Intrinsics.checkNotNullParameter(r110, "process");
        Intrinsics.checkNotNullParameter(r0, "uuid");
        int r25 = r16.b.incrementAndGet();
        r16.a.put(Integer.valueOf(r25), TuplesKt.to(r110, r0));
        return r25;
    L24:
        if ((!StringsKt.isBlank(r23)) == true) goto L27;
        r23 = null;
    L27:
        if (r23 == null) goto L29;
        r24 = StringsKt.toLongOrNull(r23);
        goto L29
    L20:
        r22 = r11;
        goto L21
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final ILatchService.d e(long r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "display");
        Intrinsics.checkNotNullParameter(r12, "errMsg");
        ILatchService.d r0 = new ILatchService.d();
        r0.b = r10;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.c = r11;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r0.a = r12;
        r0.f = AnnieConfigSettingKeys.LATCH_PREFER_NATIVE_PREFETCH.a().booleanValue();
        r0.d = new b(r13, r0, this);
        return r0;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final ILatchService.e u0(Context r10, String r11, Uri r12, long r13, ILatchService.d r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r14, "latchProcessOptions");
        if (r15 == false) goto L5;
        if (r10 != null) goto L8;
        String r16 = "context is null";
    L12:
        if (r16.length() <= 0) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == false) goto L18;
        ex.a r17 = (ex.a) this.b.getValue();
        LatchProcessOptions r18 = H1(r14);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r18.a = r16;
        Unit r19 = Unit.INSTANCE;
        return new i(r17.a(r18));
    L18:
        String r110 = UriProtector.getQueryParameter(r12, "latch_id");
        ILatchService.e r1 = null;
        if (r110 != null) goto L21;
    L26:
        Integer r111 = null;
    L27:
        if (r111 == null) goto L33;
        Pair<ILatchService.e, String> r112 = this.d.a.remove(Integer.valueOf(r111.intValue()));
        if (r112 == null) goto L31;
        r1 = (ILatchService.e) r112.getFirst();
    L31:
        if (r1 == null) goto L33;
        return r1;
    L33:
        ex.a r113 = (ex.a) this.b.getValue();
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        return new i(r113.b(r10, r11, new c(r10, r12, r11, Long.valueOf(r13)), H1(r14)));
    L21:
        if ((true ^ StringsKt.isBlank(r110)) == true) goto L24;
        r110 = null;
    L24:
        if (r110 == null) goto L26;
        r111 = StringsKt.toIntOrNull(r110);
        goto L27
    L14:
        r0 = false;
        goto L15
    L8:
        if (r11 != null) goto L10;
        r16 = "url is null";
        goto L12
    L10:
        r16 = "";
        goto L12
    L5:
        return new i(((ex.a) this.b.getValue()).a(H1(r14)));
    }
}
