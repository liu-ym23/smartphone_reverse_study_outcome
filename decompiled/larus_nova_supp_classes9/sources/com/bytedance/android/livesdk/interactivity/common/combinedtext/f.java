package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.graphics.drawable.Animatable;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ ClipImageView a;
    public final /* synthetic */ py.k b;
    public final /* synthetic */ DisplayImageListView.b c;

    public f(ClipImageView r1, py.k r2, DisplayImageListView.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
        r3 = null;
    L5:
        AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
        if (r5 == null) goto L11;
        com.bytedance.android.live.core.utils.fresco.c.b(r5);
        HSImageView r6 = this.a;
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.height = UtilityKotlinExtentionsKt.i(this.b.getHeight());
        r7.width = UtilityKotlinExtentionsKt.i(this.b.getWidth());
        Unit r8 = Unit.INSTANCE;
        r6.setLayoutParams(r7);
        DisplayImageListView.b r9 = this.c;
        int r10 = r9.a + 1;
        r9.a = r10;
        if (r10 != r9.b) goto L12;
        r9.c.invoke();
        return;
    L12:
        return;
    }
}
