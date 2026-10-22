package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningButtonListViewHolder extends RecyclerView.ViewHolder {
    public ac0.a a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final bc0.a f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TuningButtonListViewHolder a;

        public a(TuningButtonListViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            TuningButtonListViewHolder r4 = this.a;
            bc0.a r0 = r4.f;
            ac0.a r1 = r4.a;
            Switch r5 = (Switch) r4.d.getValue();
            if (r5 == null) goto L5;
            boolean r6 = r5.isChecked();
        L6:
            r0.b(r1, !r6);
            return;
        L5:
            r6 = false;
            goto L6
        }
    }

    public TuningButtonListViewHolder(final View r2, bc0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "tuningButtonCallback");
        super(r2);
        this.f = r3;
        this.b = LazyKt.lazy(new TuningButtonListViewHolder$btnListItemTitle$2(r2));
        Lazy r4 = LazyKt.lazy(new TuningButtonListViewHolder$btnListItemSwitchContainer$2(r2));
        this.c = r4;
        this.d = LazyKt.lazy(new TuningButtonListViewHolder$btnListItemSwitch$2(r2));
        this.e = LazyKt.lazy(new TuningButtonListViewHolder$btnListItemDivider$2(r2));
        FrameLayout r5 = (FrameLayout) r4.getValue();
        if (r5 == null) goto L6;
        r5.setOnClickListener(new a(this));
        return;
    }
}
