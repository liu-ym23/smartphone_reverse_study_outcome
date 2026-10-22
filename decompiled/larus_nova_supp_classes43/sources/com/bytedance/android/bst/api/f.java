package com.bytedance.android.bst.api;

import android.view.View;
import com.bytedance.android.bst.api.ab.EmptyBstAbPageControlService;
import com.bytedance.android.bst.api.ab.IBstAbPageControl;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.inner.ALogger;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static volatile boolean a;
    public static final f b = null;

    public f() {
    }

    static {
        b = new f();
    }

    @Deprecated(message = "已废弃，请勿使用", replaceWith = @ReplaceWith(expression = "无可替代接口", imports = {}))
    @JvmStatic
    public static final IBstAbPageControl e() {
        IBstAbPageControl r0 = (IBstAbPageControl) yc.b.a(IBstAbPageControl.class);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new EmptyBstAbPageControlService();
    }

    public static final synchronized uc.c g() {
        monitor-enter(f.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (a == true) goto L7;
        ExtKt.b("BstSDK", "use normal inject");     // Catch: Throwable -> L13
        com.bytedance.android.bst.api.claymore.a.a();     // Catch: Throwable -> L13
        a = true;     // Catch: Throwable -> L13
    L7:
        uc.c r1 = (uc.c) yc.b.a(uc.c.class);     // Catch: Throwable -> L13
        if (r1 != null) goto L11;
        r1 = uc.a.b;     // Catch: Throwable -> L13
    L11:
        monitor-exit(f.class);
        return r1;
    }

    public static void a(d r1) {
        g().g(r1);
    }

    @Deprecated(message = "已废弃，请勿使用", replaceWith = @ReplaceWith(expression = "autoShowTrack", imports = {}))
    @JvmStatic
    public static final void b(b r0) {
        if (r0.a != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L5:
        g().bindView();
    }

    public static void c(d r1) {
        g().e(r1);
    }

    @JvmStatic
    public static final String f(String r0) {
        g().h();
        return null;
    }

    @JvmStatic
    public static final void d(View r10, Object r11) {
        if (ExtKt.getActivity(r10) != null) goto L6;
        BstSDK$createLynxInjectRawData$1 r12 = BstSDK$createLynxInjectRawData$1.INSTANCE;
        ALogger r13 = ALogger.d;
        r13.getClass();
        r13.o("BTMSDK_BST_".concat("BstSDK"), false, r12, null);
        return;
    L6:
        g().f();
    }
}
