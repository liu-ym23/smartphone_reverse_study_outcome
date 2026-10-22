package com.bytedance.android.live.profile.ui.component;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v implements p0 {
    public final /* synthetic */ s a;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public v(s r1) {
        this.a = r1;
    }

    public final void b(py.k r1, Exception r2) {
        int r3 = s.t;
        ALogger.e("ProfileShopComponent", "heartDiamondInfo load failed, imageModel is ".concat(String.valueOf(r1)));
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
        HSImageView r5 = this.a.j;
        if (r5 == null) goto L5;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L6:
        if (r6 == null) goto L8;
        r6.width = r2;
    L8:
        if (r6 == null) goto L10;
        r6.height = r3;
    L10:
        HSImageView r7 = this.a.j;
        if (r7 == null) goto L13;
        r7.setLayoutParams(r6);
    L13:
        this.a.l.set(true);
        this.a.getClass();
        return;
    L5:
        r6 = null;
        goto L6
    }
}
