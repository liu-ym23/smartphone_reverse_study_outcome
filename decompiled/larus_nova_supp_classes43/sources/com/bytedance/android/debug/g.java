package com.bytedance.android.debug;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements p0 {
    public final /* synthetic */ DebugGiftPreviewDebugWidget a;

    public g(DebugGiftPreviewDebugWidget r1) {
        this.a = r1;
    }

    public final /* synthetic */ void a(ImageInfo r1, Animatable r10) {
    }

    public final /* synthetic */ void b(py.k r1, Exception r10) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public final void c(py.k r10, int r11, int r12, boolean r13) {
        if (r11 == 0) goto L20;
        if (r12 == 0) goto L21;
        HSImageView r14 = this.a.g;
        if (r14 == null) goto L7;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
    L8:
        HSImageView r16 = this.a.g;
        if (r16 == null) goto L11;
        int r17 = r16.getWidth();
    L12:
        if (r15 == null) goto L14;
        r15.height = (int) ((r17 / r11) * r12);
    L14:
        if (r15 == null) goto L16;
        r15.width = r17;
    L16:
        HSImageView r18 = this.a.g;
        if (r18 == null) goto L22;
        r18.setLayoutParams(r15);
        return;
    L22:
        return;
    L11:
        r17 = 0;
        goto L12
    L7:
        r15 = null;
        goto L8
    L21:
        return;
    }
}
