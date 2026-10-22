package com.bytedance.android.annie.service.preload;

import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.service.resource.e;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.android.annie.param.a d;

    public a(String r1, Uri r10, String r11, com.bytedance.android.annie.param.a r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final void a() {
        String r12 = this.a;
        Uri r10 = this.b;
        String r11 = this.c;
        com.bytedance.android.annie.param.a r13 = this.d;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L42
        Uri r15 = UriProtector.parse(r12);     // Catch: Throwable -> L42
        if (n.f(r12) == true) goto L11;
        PreLoadUtils.a.getClass();     // Catch: Throwable -> L42
        String r16 = UriProtector.getQueryParameter(r15, "forest_download_engine");     // Catch: Throwable -> L42
        if (r16 != null) goto L9;
        r16 = UriProtector.getQueryParameter(r10, "forest_download_engine");     // Catch: Throwable -> L42
    L9:
        if (Intrinsics.areEqual(r16, "downloader") == true) goto L11;
        boolean r17 = true;
    L12:
        PreLoadUtils r18 = PreLoadUtils.a;     // Catch: Throwable -> L42
        r18.getClass();     // Catch: Throwable -> L42
        String r19 = UriProtector.getQueryParameter(r15, "lock_resource");     // Catch: Throwable -> L42
        if (r19 != null) goto L16;
        r19 = UriProtector.getQueryParameter(r10, "lock_resource");     // Catch: Throwable -> L42
    L16:
        if (n.i(Intrinsics.areEqual(r19, "1")) == false) goto L26;
        String r20 = UriProtector.getQueryParameter(r15, "forest_session_id");     // Catch: Throwable -> L42
        if (r20 != null) goto L20;
        r20 = UriProtector.getQueryParameter(r10, "forest_session_id");     // Catch: Throwable -> L42
    L20:
        if (r20 != null) goto L23;
        r20 = "";
    L23:
        if (StringsKt.isBlank(r20) == false) goto L25;
        r20 = r13.getUuid();     // Catch: Throwable -> L42
    L25:
        String r21 = r20;
    L29:
        if (Intrinsics.areEqual(r10.getHost(), "webcast_lynxview") == true) goto L31;
        PreLoadUtils.b(r12);     // Catch: Throwable -> L42
        boolean r0 = !Intrinsics.areEqual(r11, "main");     // Catch: Throwable -> L42
        String r110 = r13.getMonitorID();     // Catch: Throwable -> L42
        IHybridComponent.HybridType r111 = IHybridComponent.HybridType.H5;     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r111, "hybridType");     // Catch: Throwable -> L42
        int r112 = ((e) Annie.getService$default(e.class, null, 2, null)).A1(r12, r0, r110, r21, r111, r17);     // Catch: Throwable -> L42
    L38:
        if (r112 == 0) goto L40;
        x8.a.b("preload", "forest init failed", true);     // Catch: Throwable -> L42
    L40:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r22 = Result.exceptionOrNull-impl(r1);
        if (r22 == null) goto L50;
        x8.a.c("preload", r22, true);
        return;
    L50:
        return;
    L31:
        if (Intrinsics.areEqual(r11, "main") == false) goto L33;
        Pair r23 = new Pair(null, null);     // Catch: Throwable -> L42
    L34:
        Pair r113 = r23;
        JSONObject r114 = (JSONObject) r113.getSecond();     // Catch: Throwable -> L42
        String r24 = r13.getBizKey();     // Catch: Throwable -> L42
        String r115 = r13.getMonitorID();     // Catch: Throwable -> L42
        IHybridComponent.HybridType r25 = IHybridComponent.HybridType.LYNX;     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter("json", "source");     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r24, "bizKey");     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r25, "hybridType");     // Catch: Throwable -> L42
        r112 = ((e) Annie.getService$default(e.class, null, 2, null)).m(r12, r114, "json", r115, r21, r25, r24, r17);     // Catch: Throwable -> L42
        if (r112 != 302) goto L38;
        PreLoadUtils.d(r18, r112, "config json format error " + r113.getSecond(), r12, (Long) r113.getFirst(), null, null, 48);     // Catch: Throwable -> L42
        goto L38
    L33:
        r23 = PreLoadUtils.a(r18, r12, r13, r21);     // Catch: Throwable -> L42
        goto L34
    L26:
        r21 = null;
    L11:
        r17 = false;
    L42:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
