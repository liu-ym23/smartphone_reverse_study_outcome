package com.bytedance.android.livesdk.gift.fastgift;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ PopupGiftDialogFragment a;
    public final /* synthetic */ Ref.IntRef b;

    public c0(PopupGiftDialogFragment r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        Ref.IntRef r5 = this.b;
        int r6 = r5.element + 1;
        r5.element = r6;
        if (r6 != 2) goto L19;
        HSImageView r7 = this.a.S90(2131382758);
        if (r7 == null) goto L11;
        DraweeController r8 = r7.getController();
        if (r8 == null) goto L11;
        Animatable r9 = r8.getAnimatable();
        if (r9 == null) goto L11;
        r9.start();
    L11:
        HSImageView r10 = this.a.S90(2131382757);
        if (r10 == null) goto L20;
        DraweeController r11 = r10.getController();
        if (r11 == null) goto L21;
        Animatable r13 = r11.getAnimatable();
        if (r13 == null) goto L22;
        r13.start();
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }
}
