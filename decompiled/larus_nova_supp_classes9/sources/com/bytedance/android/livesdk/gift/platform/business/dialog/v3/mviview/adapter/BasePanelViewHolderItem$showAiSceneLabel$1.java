package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.AnimatorSet;
import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.m0;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BasePanelViewHolderItem$showAiSceneLabel$1 implements p0 {
    public final /* synthetic */ BasePanelViewHolderItem a;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public BasePanelViewHolderItem$showAiSceneLabel$1(BasePanelViewHolderItem r1) {
        this.a = r1;
    }

    public final void b(py.k r1, Exception r2) {
        this.a.D.setVisibility(8);
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
        this.a.D.setScaleX(0.0f);
        this.a.D.setScaleY(0.0f);
        boolean r5 = false;
        this.a.D.setVisibility(0);
        m0 r6 = this.a.L;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSweepHelper");
    L5:
        rz1.b r7 = r6.c;
        AnimatorSet r8 = r7.a;
        if (r8 == null) goto L8;
        boolean r9 = r8.isRunning();
    L9:
        if (r9 == true) goto L15;
        AnimatorSet r10 = r7.b;
        if (r10 == null) goto L13;
        boolean r11 = r10.isRunning();
    L14:
        if (r11 == true) goto L15;
    L16:
        if (r5 == false) goto L18;
        BasePanelViewHolderItem.q(this.a);
        return;
    L18:
        m0 r13 = this.a.L;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSweepHelper");
    L21:
        r13.a(new BasePanelViewHolderItem$showAiSceneLabel$1$onSuccess$1(this));
        return;
    L13:
        r11 = false;
    L15:
        r5 = true;
        goto L16
    L8:
        r9 = false;
        goto L9
    }
}
