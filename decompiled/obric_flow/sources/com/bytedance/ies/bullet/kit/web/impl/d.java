package com.bytedance.ies.bullet.kit.web.impl;

import android.os.SystemClock;
import com.bytedance.android.monitorV2.webview.k;
import com.bytedance.ies.bullet.core.kit.bridge.Callback;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.salamander.anniex.b0;
import com.bytedance.salamander.anniex.o;
import com.bytedance.salamander.anniex.r;
import com.bytedance.salamander.anniex.s;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.bytedance.sdk.xbridge.cn.protocol.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5509c;
    public Object d;
    public final /* synthetic */ Object e;

    public d(com.bytedance.sdk.xbridge.cn.platform.web.c r5, Callback r10) {
        this.f5509c = 0;
        this.e = r10;
        super(r5);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.e
    public final JSONObject a() {
        switch(this.f5509c) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        JSONObject r5 = (JSONObject) this.d;
        if (r5 == null) goto L9;
        return r5;
    L9:
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.e
    public final void b(Object r18) {
        Object r5 = this.e;
        int r10 = 7;
        switch(this.f5509c) {
            case 0: goto L43;
            default: goto L4;
        };
    L4:
        JSONObject r11 = (JSONObject) r18;
        Intrinsics.checkNotNullParameter(r11, "data");
        com.bytedance.sdk.xbridge.cn.platform.web.e r12 = (com.bytedance.sdk.xbridge.cn.platform.web.e) r5;
        com.bytedance.sdk.xbridge.cn.platform.web.c r13 = (com.bytedance.sdk.xbridge.cn.platform.web.c) this.d;
        r12.e(r12.c(r13, r11), null);
        int r14 = r13.f938k;
        JSONObject r15 = r13.I;
        String r16 = r13.f932a;
        if (r14 != 1) goto L17;
        k r17 = k.d;
        SSWebView r19 = r12.j();
        x4.e r110 = new x4.e();
        r110.f22965a = r16;
        r110.f22966b = 0;
        long r111 = System.currentTimeMillis();
        long r112 = r13.f;
        r110.e = r111 - r112;
        r110.f = SystemClock.elapsedRealtime() - (System.currentTimeMillis() - r112);
        if (r13.f937j == r112) goto L9;
        long r113 = SystemClock.elapsedRealtime() - (System.currentTimeMillis() - r13.f937j);
    L10:
        r110.g = r113;
        if (Intrinsics.areEqual(r110.f22965a, "x.request") == false) goto L16;
        if (r15 == null) goto L14;
        String r20 = r15.optString("url");
    L15:
        r110.f22968h = r20;
        goto L16
    L14:
        r20 = null;
    L16:
        r110.d = r13.N;
        Unit r21 = Unit.INSTANCE;
        r17.m(r19, r110);
        o r22 = c4.a.f1115a.a(r12.a().f7409j);
        s r23 = new s();
        com.bytedance.ies.bullet.service.base.c r24 = new com.bytedance.ies.bullet.service.base.c(r10);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        Integer.parseInt(r13.N);
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        com.bytedance.sdk.xbridge.cn.auth.g r25 = new com.bytedance.sdk.xbridge.cn.auth.g(r10);
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r22.f(r23);
        return;
    L9:
        r113 = SystemClock.elapsedRealtime();
        goto L10
    L17:
        ConcurrentHashMap r26 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r27 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r27 == null) goto L20;
        xc.d r28 = (xc.d) r27.a(xc.d.class);
    L20:
        k r114 = k.d;
        SSWebView r115 = r12.j();
        b0 r116 = new b0(10, (byte) 0);
        r116.d = r16;
        int r29 = r13.f938k;
        r116.f7246b = r29;
        String r30 = r13.f939l;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L23
        r30 = new JSONObject().putOpt("message", r30).putOpt("code", Integer.valueOf(r29)).toString();     // Catch: Throwable -> L23
    L25:
        r116.f7247c = r30;
        Unit r31 = Unit.INSTANCE;
        r114.i(r115, r116);
        o r32 = c4.a.f1115a.a(r12.a().f7409j);
        r r33 = new r();
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        Intrinsics.checkNotNullParameter(r13.f939l, "<set-?>");
        ConcurrentHashMap r34 = yc.a.f23246a;     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L33
        xc.e r35 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L33
        if (r35 == null) goto L35;
        xc.d r36 = (xc.d) r35.a(xc.d.class);     // Catch: Throwable -> L33
        if (r36 == null) goto L35;
        Boolean r37 = r36.J0();     // Catch: Throwable -> L33
        if (r37 == null) goto L35;
        boolean r38 = r37.booleanValue();     // Catch: Throwable -> L33
    L36:
        if (r38 == false) goto L38;
        r15.toString();     // Catch: Throwable -> L33
    L38:
        Result.m124constructorimpl(r31);     // Catch: Throwable -> L33
    L41:
        r32.e(r33);
        o r39 = c4.a.f1115a.a(r12.a().f7409j);
        s r40 = new s();
        int r41 = 7;
        com.bytedance.ies.bullet.service.base.c r42 = new com.bytedance.ies.bullet.service.base.c(r41);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        Integer.parseInt(r13.N);
        Intrinsics.checkNotNullParameter(r42, "<set-?>");
        Intrinsics.checkNotNullParameter(new com.bytedance.sdk.xbridge.cn.auth.g(r41), "<set-?>");
        r39.f(r40);
        return;
    L35:
        r38 = true;
    L33:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L23:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L25
    L43:
        JSONObject r45 = (JSONObject) r18;
        Intrinsics.checkNotNullParameter(r45, "data");
        this.d = r45;
        Callback r46 = (Callback) r5;
        if (r46 == null) goto L52;
        r46.invoke(new Object[]{r45});
        return;
    }

    public d(com.bytedance.sdk.xbridge.cn.platform.web.c r5, com.bytedance.sdk.xbridge.cn.platform.web.e r10) {
        this.f5509c = 1;
        this.d = r5;
        this.e = r10;
        super(r5);
    }
}
