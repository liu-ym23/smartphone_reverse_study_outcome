package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkBizHybridCardController$updateAnim$1$controller$1 extends BaseControllerListener<Object> {
    public final /* synthetic */ HSImageView a;

    public MultiLinkBizHybridCardController$updateAnim$1$controller$1(HSImageView r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        HSImageView r3 = this.a;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        ViewParent r4 = this.a.getParent();
        if (r4 == null) goto L9;
        ((ViewGroup) r4).removeView(this.a);
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        Intrinsics.checkNotNullParameter(r1, "id");
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        je0.b.a((AnimatedDrawable2) r3, new MultiLinkBizHybridCardController$updateAnim$1$controller$1$onFinalImageSet$1(this));
        return;
    }
}
