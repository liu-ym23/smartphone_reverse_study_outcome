package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements p0 {
    public final /* synthetic */ BasePanelViewHolderItem a;

    public e(BasePanelViewHolderItem r1) {
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

    public final void c(py.k r2, int r3, int r4, boolean r5) {
        if (r3 == 0) goto L6;
        if (r4 == 0) goto L7;
        ViewGroup.LayoutParams r6 = this.a.r.getLayoutParams();
        BasePanelViewHolderItem r7 = this.a;
        r6.width = (int) (r3 * (r7.q / r4));
        r7.r.setLayoutParams(r6);
        return;
    L7:
        return;
    }
}
