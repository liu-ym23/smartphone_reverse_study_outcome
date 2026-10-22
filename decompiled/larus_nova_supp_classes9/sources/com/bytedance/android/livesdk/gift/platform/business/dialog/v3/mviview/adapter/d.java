package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.p0;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements p0 {
    public final /* synthetic */ BasePanelViewHolderItem a;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public d(BasePanelViewHolderItem r1) {
        this.a = r1;
    }

    public final void b(py.k r1, Exception r2) {
        this.a.D.setVisibility(8);
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
        this.a.D.setVisibility(0);
    }
}
