package com.bytedance.sdk.xbridge.cn.platform.lynx;

import android.view.View;
import com.bytedance.salamander.anniex.o;
import com.bytedance.salamander.anniex.r;
import com.bytedance.salamander.anniex.s;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends com.bytedance.sdk.xbridge.cn.protocol.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callback f7372c;
    public final b d;
    public final c e;
    public Object f;

    public g(Callback r5, b r10, c r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeCall");
        Intrinsics.checkNotNullParameter(r11, "lynxBridgeContext");
        super(r10);
        this.f7372c = r5;
        this.d = r10;
        this.e = r11;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.e
    public final JSONObject a() {
        Object r5 = this.f;
        if (r5 == null) goto L33;
        boolean r10 = r5 instanceof JavaOnlyMap;
        j r11 = null;
        JSONObject r12 = null;
        if (r10 == false) goto L15;
        if (r10 == false) goto L8;
        JavaOnlyMap r13 = (JavaOnlyMap) r5;
    L9:
        if (r13 == null) goto L11;
        r12 = r13.a();
    L11:
        if (r12 == null) goto L13;
        return r12;
    L13:
        return new JSONObject();
    L8:
        r13 = null;
        goto L9
    L15:
        boolean r14 = r5 instanceof j;
        if (r14 == false) goto L33;
        if (r14 == false) goto L19;
        r11 = (j) r5;
    L19:
        if (r11 == null) goto L31;
        HashMap r15 = r11.f7378b;
        if (r15 != null) goto L23;
        JSONObject r16 = r11.f7379c;
        if (r16 == null) goto L29;
        Intrinsics.checkNotNull(r16);
        return r16;
    L29:
        return new JSONObject();
    L23:
        return new JSONObject(r15);
    L31:
        return new JSONObject();
    L33:
        return new JSONObject();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.e
    public final void b(Object r18) {
        Intrinsics.checkNotNullParameter(r18, "data");
        this.f = r18;
        boolean r5 = r18 instanceof j;
        Callback r10 = this.f7372c;
        if (r5 == false) goto L10;
        if (r10 == null) goto L12;
        PiperData r11 = ((j) r18).f7377a;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("piperData");
        r11 = null;
    L9:
        r10.invoke(new Object[]{r11});
    L12:
        b r12 = this.d;
        if (StringsKt.isBlank(r12.d) == true) goto L15;
        String r13 = r12.d;
    L17:
        if (Intrinsics.areEqual(r13, "Loki") == true) goto L67;
        c r14 = this.e;
        LynxView r15 = (LynxView) ((View) r14.e.get());
        if (r15 == null) goto L68;
        int r16 = r12.f938k;
        String r17 = r12.f932a;
        String r19 = r14.f1186a;
        if (r16 != 1) goto L24;
        com.bytedance.android.monitorV2.lynx.d r20 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        x4.g r21 = new x4.g();
        r21.f22971b = r17;
        r21.f22972c = System.currentTimeMillis() - r12.f;
        Unit r22 = Unit.INSTANCE;
        r20.getClass();
        com.bytedance.android.monitorV2.lynx.d.i(r15, r21);
        o r23 = c4.a.f1115a.a(r19);
        s r24 = new s();
        com.bytedance.ies.bullet.service.base.c r25 = new com.bytedance.ies.bullet.service.base.c(7);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        com.bytedance.sdk.xbridge.cn.auth.g r26 = new com.bytedance.sdk.xbridge.cn.auth.g(7);
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r23.f(r24);
        return;
    L24:
        ConcurrentHashMap r27 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r110 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r110 == null) goto L31;
        xc.d r111 = (xc.d) r110.a(xc.d.class);
        if (r111 == null) goto L31;
        Boolean r112 = r111.E0();
        if (r112 == null) goto L31;
        boolean r113 = r112.booleanValue();
    L32:
        if (r113 == false) goto L35;
        this.f7458a.getClass();
    L35:
        com.bytedance.android.monitorV2.lynx.d r114 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        x4.f r115 = new x4.f();
        r115.d = r17;
        int r28 = r12.f938k;
        r115.f22969b = r28;
        String r116 = r12.f939l;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L38
        r116 = new JSONObject().putOpt("message", r116).putOpt("code", Integer.valueOf(r28)).toString();     // Catch: Throwable -> L38
    L40:
        r115.f22970c = r116;
        Unit r29 = Unit.INSTANCE;
        r114.getClass();
        com.bytedance.android.monitorV2.lynx.d.h(r15, r115);
        o r30 = c4.a.f1115a.a(r19);
        r r31 = new r();
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        Intrinsics.checkNotNullParameter(r12.f939l, "<set-?>");
        ConcurrentHashMap r32 = yc.a.f23246a;     // Catch: Throwable -> L48
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L48
        xc.e r33 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L48
        if (r33 == null) goto L50;
        xc.d r34 = (xc.d) r33.a(xc.d.class);     // Catch: Throwable -> L48
        if (r34 == null) goto L50;
        Boolean r35 = r34.J0();     // Catch: Throwable -> L48
        if (r35 == null) goto L50;
        boolean r36 = r35.booleanValue();     // Catch: Throwable -> L48
    L51:
        if (r36 == false) goto L58;
        ReadableMap r37 = r12.L;     // Catch: Throwable -> L48
        if (r37 == null) goto L55;
        ReadableMap r118 = r37;
    L56:
        if (r118 == null) goto L58;
        new JSONObject(r118.asHashMap()).toString();     // Catch: Throwable -> L48
        goto L58
    L55:
        r118 = null;
    L58:
        Result.m124constructorimpl(r29);     // Catch: Throwable -> L48
    L61:
        r30.e(r31);
        o r38 = c4.a.f1115a.a(r19);
        s r39 = new s();
        com.bytedance.ies.bullet.service.base.c r40 = new com.bytedance.ies.bullet.service.base.c(7);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        Intrinsics.checkNotNullParameter(new com.bytedance.sdk.xbridge.cn.auth.g(7), "<set-?>");
        r38.f(r39);
        return;
    L50:
        r36 = true;
    L48:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L38:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L31:
        r113 = true;
        goto L32
    L68:
        return;
    L67:
        return;
    L15:
        r13 = r12.e;
        goto L17
    L10:
        if (r10 == null) goto L12;
        r10.invoke(new Object[]{r18});
        goto L12
    }
}
