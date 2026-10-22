package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.common_ui.video.VideoPlayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k extends BaseControllerListener<Object> {
    public final /* synthetic */ VideoPlayView a;

    public k(VideoPlayView r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        this.a.M();
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        this.a.M();
    }
}
