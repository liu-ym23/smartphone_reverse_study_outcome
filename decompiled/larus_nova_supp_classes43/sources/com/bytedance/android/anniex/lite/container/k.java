package com.bytedance.android.anniex.lite.container;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$lastViewHashCodes$1;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements DialogInterface.OnKeyListener {
    public final /* synthetic */ AnnieXLitePageContainer a;

    public k(AnnieXLitePageContainer r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r10, int r11, KeyEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r12, "keyEvent");
        if (r11 == 4) goto L5;
        return false;
    L5:
        if (r12.getAction() != 1) goto L17;
        AnnieXBlankDetectorManager$lastViewHashCodes$1 r13 = AnnieXBlankDetectorManager.a;
        AnnieXBlankDetectorManager.c(this.a.getKitView(), this.a.getAnnieXContext().f.a);
        AnnieXLitePageContainer r14 = this.a;
        if (com.bytedance.android.anniex.lite.utils.c.h(r14, r14.getAnnieXContext()) == false) goto L10;
        return true;
    L10:
        if (this.a.canBackPress() == true) goto L18;
        HybridLogger.m("AnnieXLitePageContainer", "====intercept backPress=====", null, null, 12);
        na.b r15 = this.a.g;
        if (r15 == null) goto L14;
        r15.f();
    L14:
        return true;
    L18:
        return false;
    L17:
        return false;
    }
}
