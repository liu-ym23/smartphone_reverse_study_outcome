package com.bytedance.android.livesdk.gift.platform.format.panel.viewholder;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.facebook.imagepipeline.image.ImageInfo;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements p0 {
    public final /* synthetic */ FormatGiftDialogViewHolder a;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(k r1) {
    }

    public b(FormatGiftDialogViewHolder r1) {
        this.a = r1;
    }

    public final void b(k r1, Exception r2) {
        this.a.j.setVisibility(8);
    }

    public final void c(k r1, int r2, int r3, boolean r4) {
        ViewGroup.LayoutParams r5 = this.a.j.getLayoutParams();
        r5.width = (int) (r5.height * (r2 / r3));
        this.a.j.setLayoutParams(r5);
        this.a.j.setVisibility(0);
    }
}
