package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import ak6.g;
import androidx.recyclerview.widget.RecyclerView;
import c32.d;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.jvm.internal.Intrinsics;
import qb2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class WordAssociationResultViewHolder$bind$2 implements e {
    public final /* synthetic */ WordAssociationResultViewHolder a;
    public final /* synthetic */ d b;

    @Override // qb2.e
    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(final g r3) {
        Intrinsics.checkNotNullParameter(r3, "rendResult");
        this.a.a.setText(r3.a);
        ((RecyclerView.ViewHolder) this.a).itemView.setOnClickListener(x0.a(new WordAssociationResultViewHolder$bind$2$onSpanRendFinish$1(this, r3)));
    }

    public WordAssociationResultViewHolder$bind$2(WordAssociationResultViewHolder r1, d r2) {
        this.a = r1;
        this.b = r2;
    }
}
