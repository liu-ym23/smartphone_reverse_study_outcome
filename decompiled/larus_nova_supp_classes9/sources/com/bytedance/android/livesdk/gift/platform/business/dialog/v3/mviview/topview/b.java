package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements p0 {
    public final /* synthetic */ GiftMVIActivityTopView a;

    public b(GiftMVIActivityTopView r1) {
        this.a = r1;
    }

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void b(py.k r1, Exception r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
        if (r2 == 0) goto L17;
        if (r3 == 0) goto L18;
        HSImageView r5 = this.a.o;
        if (r5 == null) goto L7;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L8:
        int r7 = (int) com.bytedance.android.live.revenue.common.i.a(15);
        if (r6 == null) goto L11;
        r6.height = r7;
    L11:
        if (r6 == null) goto L13;
        r6.width = (int) ((r7 / r3) * r2);
    L13:
        HSImageView r8 = this.a.o;
        if (r8 == null) goto L19;
        r8.setLayoutParams(r6);
        return;
    L19:
        return;
    L7:
        r6 = null;
        goto L8
    L18:
        return;
    }
}
