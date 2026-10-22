package com.bytedance.android.live.profit.format.voicechat.view;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends BaseControllerListener<Object> {
    public g() {
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if (r3 == null) goto L5;
        r3.start();
        return;
    }
}
