package com.bytedance.android.anniex.utils;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.lynx.impl.g;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.tasm.behavior.ui.krypton.CanvasRuntimeMediator;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static void a(AnnieXLynxView r5) {
        Intrinsics.checkNotNullParameter(r5, "annieXLynxView");
        g r10 = new g();
        LynxKryptonHelper r11 = LynxKryptonUtils.getLynxKryptonHelper(r5);
        if (r11 == null) goto L8;
        r11.f10496b.put(g.class, r10);
        CanvasRuntimeMediator r12 = r11.f10495a;
        if (r12 == null) goto L9;
        r12.f10493a.put(g.class, r10);
        return;
    L9:
        return;
    }
}
