package com.ss.android.lark.integrator.ccm.config.viewbinder;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements RequestListener {
    public final /* synthetic */ DocCardViewBinder.DocCardViewHolder a;

    public f(DocCardViewBinder.DocCardViewHolder r1) {
        this.a = r1;
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target r3, boolean r4) {
        tt5.a.f("DocCardViewBinder", r1, false);
        this.a.thumbImageView.setVisibility(8);
        this.a.thumbLoadFailView.setImageResource(2131233586);
        this.a.thumbLoadFailView.setVisibility(0);
        return true;
    }

    public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        this.a.thumbImageView.setVisibility(0);
        this.a.thumbLoadFailView.setVisibility(8);
        return false;
    }
}
