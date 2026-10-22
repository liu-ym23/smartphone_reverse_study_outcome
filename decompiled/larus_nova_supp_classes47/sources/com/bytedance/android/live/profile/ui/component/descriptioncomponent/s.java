package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.view.View;
import com.bytedance.android.live.base.model.user.HonorWallElement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ HonorWallElement b;

    public s(p r1, HonorWallElement r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        p.j(this.a, this.b);
    }
}
