package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/binder2/FeedExpiredFoldHintViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "closeListener", "Lcom/ss/android/lark/feed/shared/page/binder2/ExpiredFoldCloseListener;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/feed/shared/page/binder2/ExpiredFoldCloseListener;)V", "expiredFoldHintView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "expiredCloseImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "expiredClickFilterTextView", "Landroid/widget/TextView;", "expiredFoldTitleTextView", "expiredContentTextView", "bind", BuildConfig.FLAVOR, "bindExpiredFoldView", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedExpiredFoldHintViewHolder extends RecyclerView.ViewHolder {
    public final b a;
    public final ConstraintLayout b;
    public final AppCompatImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public FeedExpiredFoldHintViewHolder(View r2, teb.g r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "closeListener");
        super(r2);
        this.a = r3;
        this.b = r2.findViewById(2131384684);
        this.c = r2.findViewById(2131375144);
        this.d = (TextView) r2.findViewById(2131390588);
        this.e = (TextView) r2.findViewById(2131390590);
        this.f = (TextView) r2.findViewById(2131390589);
    }
}
