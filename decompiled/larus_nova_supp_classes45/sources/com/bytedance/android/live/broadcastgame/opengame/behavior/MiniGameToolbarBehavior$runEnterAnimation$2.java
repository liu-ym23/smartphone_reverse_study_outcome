package com.bytedance.android.live.broadcastgame.opengame.behavior;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.view.SimpleDraweeView;
import j40.m1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class MiniGameToolbarBehavior$runEnterAnimation$2 implements ImageOriginListener {
    public final /* synthetic */ MiniGameToolbarBehavior a;

    public MiniGameToolbarBehavior$runEnterAnimation$2(MiniGameToolbarBehavior r1) {
        this.a = r1;
    }

    public final void onImageLoaded(String r7, int r8, boolean r9) {
        if (((Boolean) m1.a.getValue()).booleanValue() == false) goto L5;
        UtilityKotlinExtentionsKt.s(0, false, false, new MiniGameToolbarBehavior$runEnterAnimation$2$onImageLoaded$1(this), 7);
        return;
    L5:
        SimpleDraweeView r11 = this.a.c;
        if (r11 == null) goto L10;
        r11.setVisibility(8);
        return;
    }
}
