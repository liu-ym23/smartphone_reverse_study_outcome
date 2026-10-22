package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ LikeEggTemplatePreviewDialog b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LikeEggTemplatePreviewDialog r0 = this.b;
        int r1 = LikeEggTemplatePreviewDialog.W;
        r0.W0().p();
    }

    public a(RecyclerView r1, LikeEggTemplatePreviewDialog r2) {
        this.a = r1;
        this.b = r2;
    }
}
