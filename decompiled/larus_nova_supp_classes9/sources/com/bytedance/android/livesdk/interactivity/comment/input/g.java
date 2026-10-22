package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ OGCFixedCommentAdapter a;
    public final /* synthetic */ OGCFixedCommentViewHolder b;

    public g(OGCFixedCommentAdapter r1, OGCFixedCommentViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.b.getAdapterPosition() <= (this.a.getItemCount() - 1)) goto L5;
        return;
    L5:
        if (this.b.getAdapterPosition() < 0) goto L11;
        Pair r4 = (Pair) ListProtector.get(this.a.a, this.b.getAdapterPosition());
        if (((Number) r4.getFirst()).intValue() != 1) goto L12;
        this.a.f.a((String) r4.getSecond());
        OGCFixedCommentAdapter r5 = this.a;
        this.b.getAdapterPosition();
        r5.getClass();
        return;
    L12:
        return;
    }
}
