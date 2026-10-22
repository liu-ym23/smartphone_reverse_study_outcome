package com.bytedance.android.live.lynx.open;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.ies.web.jsbridge2.b {
    public OpenLynxBridgeModule n;
    public LynxView o;
    public final Context p;
    public final Function0<String> q;

    /* JADX INFO: renamed from: com.bytedance.android.live.lynx.open.a$a, reason: collision with other inner class name */
    public static final class C0124a {
    }

    static {
    }

    public final void j(o r2) {
        Intrinsics.checkNotNullParameter(r2, "environment");
    }

    public final View g() {
        LynxView r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
    L5:
        return r0;
    }

    public final String h() {
        return (String) this.q.invoke();
    }

    public Context getContext(o r2) {
        Intrinsics.checkNotNullParameter(r2, "environment");
        return this.p;
    }

    public final void k(String r5) {
        JSONObject r0 = new JSONObject(r5);
        Object r6 = r0.remove("__event_id");
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        if (r7 != null) goto L8;
        return;
    L8:
        Object r1 = r0.remove("__params");
        if (r1 == null) goto L20;
        JSONObject r2 = new JSONObject();
        r2.put("code", 1);
        r2.put("data", r1);
        WritableMap r3 = kl0.b.d(r2);
        if (r3 == null) goto L21;
        JavaOnlyArray r4 = JavaOnlyArray.of(new Object[]{r3});
        LynxView r8 = this.o;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("lynxView");
    L15:
        com.lynx.jsbridge.c r9 = r8.getJSModule("BDLynxAPIModule");
        if (r9 == null) goto L22;
        JavaOnlyArray r10 = new JavaOnlyArray();
        r10.pushString(r7);
        r10.pushArray(r4);
        r9.a("emit", r10);
        return;
    L22:
        return;
    L21:
        return;
    }

    public a(Context r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "androidContext");
        Intrinsics.checkNotNullParameter(r3, "url");
        this.p = r2;
        this.q = r3;
    }

    public final void m(String r3, c0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        OpenLynxBridgeModule r0 = this.n;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeModule");
    L7:
        r0.invokeCallback$livehybrid_impl_saasRelease(new JSONObject(r3), r4);
    }

    public final c0 r(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "namespace");
        Intrinsics.checkNotNullParameter(r5, "callbackId");
        c0.a r0 = new c0.a();
        r0.c = r2;
        r0.d = r3;
        r0.e = r5;
        r0.f = r4;
        c0 r6 = new c0(r0);
        o(r6);
        return r6;
    }
}
