package com.larus.common_ui.photoviewer.transition;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.f;
import l19.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "transitionLayout", "Lcom/larus/common_ui/photoviewer/transition/TransitionLayout;", "getTransitionLayout", "()Lcom/larus/common_ui/photoviewer/transition/TransitionLayout;", "onTransitionBegin", "", "state", "", "onTransitionChanged", "factor", "", "onTransitionEnd", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TransitionViewHolder extends RecyclerView.ViewHolder implements f {
    public final View a;

    @Override // l19.f
    public void onTransitionBegin(int r1) {
    }

    @Override // l19.f
    public void onTransitionChanged(int r1, float r2) {
    }

    @Override // l19.f
    public void onTransitionEnd(int r1) {
    }

    public final TransitionLayout T3() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.common_ui.photoviewer.transition.TransitionLayout");
        return (TransitionLayout) r0;
    }

    public TransitionViewHolder(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        TransitionLayout r0 = new TransitionLayout(r6.getContext(), null, 6, 0);
        r0.addView(r6, -1, -1);
        TransitionPhotoDraweeView r2 = j.a(r6);
        if (r2 == null) goto L5;
        r2.setHorizontalNestedScrollEnabled(true);
        r0.setDelegateDragTransitionView(r2);
    L5:
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        super(r0);
        this.a = r6;
        T3().c(this);
    }
}
