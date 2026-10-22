package com.larus.canvas.feature.component.instruction.ui;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.holder.progressloading.RadiusCardView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/ui/CanvasOptionListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "optionCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "optionName", "Landroid/widget/TextView;", "optionCardMask", "Landroid/widget/FrameLayout;", "optionCoverLoading", "Landroid/widget/ProgressBar;", "optionCoverMask", "optionIconContainer", "optionIconLoading", "optionIcon", "darkIconLoadingDrawable", "Landroid/graphics/drawable/Drawable;", "lightIconLoadingDrawable", "bindData", "", "data", "Lcom/larus/canvas/feature/component/instruction/ui/CanvasOptionListItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasOptionListHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int k = 0;
    public final SimpleDraweeView a;
    public final TextView b;
    public final FrameLayout c;
    public final ProgressBar d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final ProgressBar g;
    public final SimpleDraweeView h;
    public final Drawable i;
    public final Drawable j;

    public CanvasOptionListHolder(RadiusCardView r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.a = r3.findViewById(2131375035);
        this.b = (TextView) r3.findViewById(2131391040);
        this.c = (FrameLayout) r3.findViewById(2131381593);
        this.d = (ProgressBar) r3.findViewById(2131381595);
        this.e = (FrameLayout) r3.findViewById(2131374975);
        this.f = (FrameLayout) r3.findViewById(2131381598);
        this.g = (ProgressBar) r3.findViewById(2131381599);
        this.h = r3.findViewById(2131375036);
        this.i = ContextCompat.getDrawable(r3.getContext(), 2131241078);
        this.j = ContextCompat.getDrawable(r3.getContext(), 2131241079);
    }
}
