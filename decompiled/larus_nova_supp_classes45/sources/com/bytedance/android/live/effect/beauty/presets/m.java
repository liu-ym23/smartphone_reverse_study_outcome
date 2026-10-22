package com.bytedance.android.live.effect.beauty.presets;

import android.view.animation.Animation;
import com.bytedance.android.live.core.utils.f2;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements Animation.AnimationListener {
    public final /* synthetic */ LiveBeautyPresetsFragment a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public m(LiveBeautyPresetsFragment r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r4) {
        f2.c("重置成功", 0);
        LiveBeautyPresetsFragment r5 = this.a;
        int r1 = LiveBeautyPresetsFragment.C;
        r5.W90(false);
        LiveBeautyPresetsFragment r6 = this.a;
        if (((ArrayList) r6.T90().a).size() >= this.a.A.intValue()) goto L5;
        boolean r2 = true;
    L6:
        r6.X90(r2);
        if (this.a.U90().c == false) goto L9;
        this.a.U90().B2(false);
        return;
    L9:
        this.a.U90().A2(this.a.T90().a, PresetOperationType.SELECT_PRESET, -1);
        return;
    L5:
        r2 = false;
        goto L6
    }
}
