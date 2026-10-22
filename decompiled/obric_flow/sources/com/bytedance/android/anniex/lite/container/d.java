package com.bytedance.android.anniex.lite.container;

import android.content.DialogInterface;
import android.view.KeyEvent;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3239a;

    public d(f r5) {
        this.f3239a = r5;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r5, int r10, KeyEvent r11) {
        Intrinsics.checkNotNullParameter(r5, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r11, "keyEvent");
        if (r10 == 4) goto L5;
        return false;
    L5:
        if (r11.getAction() != 1) goto L16;
        Lazy r12 = com.bytedance.android.anniex.detect.a.f3206a;
        this.f3239a.getKitView();
        rd.b r13 = this.f3239a.getAnnieXContext().f.f21723a;
        ((com.bytedance.android.anniex.detect.b) com.bytedance.android.anniex.detect.a.f3206a.getValue()).getClass();
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXBlankDetect", "总开关关闭，无需白屏检测", null, 12);
        f r14 = this.f3239a;
        a4.a r15 = r14.getAnnieXContext();
        Intrinsics.checkNotNullParameter(r14, "pageContainer");
        Intrinsics.checkNotNullParameter(r15, "annieXContext");
        if (xq.b.k() == false) goto L11;
        tc.c r16 = tc.c.f22119c;
        if (tc.c.f22119c.a(com.bytedance.android.anniex.base.service.a.class, r14.getBid()) == null) goto L11;
        throw new ClassCastException();
    L11:
        this.f3239a.getContainerModel();
        return false;
    L16:
        return false;
    }
}
