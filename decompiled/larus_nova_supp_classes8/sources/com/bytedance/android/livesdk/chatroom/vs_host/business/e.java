package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements wr1.b {
    public final LiveBlurAnimView a;

    @Override // wr1.b
    public final LiveBlurAnimView getView() {
        return this.a;
    }

    public e(Context r5) {
        this.a = new LiveBlurAnimView(r5, null, 6, 0);
    }

    @Override // wr1.b
    public final void b(float r2) {
        LiveBlurAnimView r0 = this.a;
        r0.d = r2;
        HSImageView r1 = r0.b;
        if (r1 == null) goto L6;
        r1.setAlpha(r2);
        return;
    }

    @Override // wr1.b
    public final void a(py.k r8, int r9, ImageView.ScaleType r10) {
        Intrinsics.checkNotNullParameter(r10, "scaleType");
        LiveBlurAnimView r1 = this.a;
        int r2 = LiveBlurAnimView.e;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "scaleType");
        switch(com.bytedance.android.livesdk.vs.c.a[r10.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        ScalingUtils.ScaleType r11 = ScalingUtils.ScaleType.CENTER_CROP;
    L12:
        r1.c = 15;
        r1.d = 1.0f;
        HSImageView r3 = r1.a;
        if (r3 == null) goto L17;
        ImageLoader.bindImage(r3, r8, r3.getWidth(), r3.getHeight(), new l3(r1.c));
        GenericDraweeHierarchy r4 = r3.getHierarchy();
        if (r4 == null) goto L17;
        r4.setActualImageScaleType(r11);
    L17:
        HSImageView r5 = r1.b;
        if (r5 == null) goto L31;
        ImageLoader.bindImage(r5, r8, r5.getWidth(), r5.getHeight());
        GenericDraweeHierarchy r12 = r5.getHierarchy();
        if (r12 == null) goto L22;
        r12.setActualImageScaleType(r11);
    L22:
        if (r9 == 0) goto L29;
        GenericDraweeHierarchy r13 = r5.getHierarchy();
        if (r13 == null) goto L26;
        r13.setPlaceholderImage(r9, r11);
    L26:
        GenericDraweeHierarchy r14 = r5.getHierarchy();
        if (r14 == null) goto L29;
        r14.setFailureImage(r9, r11);
    L29:
        r5.setAlpha(1.0f);
        return;
    L31:
        return;
    L5:
        r11 = ScalingUtils.ScaleType.CENTER_INSIDE;
        goto L12
    L6:
        r11 = ScalingUtils.ScaleType.CENTER_CROP;
        goto L12
    L7:
        r11 = ScalingUtils.ScaleType.CENTER;
        goto L12
    L8:
        r11 = ScalingUtils.ScaleType.FIT_END;
        goto L12
    L9:
        r11 = ScalingUtils.ScaleType.FIT_CENTER;
        goto L12
    L10:
        r11 = ScalingUtils.ScaleType.FIT_START;
        goto L12
    L11:
        r11 = ScalingUtils.ScaleType.FIT_XY;
        goto L12
    }
}
