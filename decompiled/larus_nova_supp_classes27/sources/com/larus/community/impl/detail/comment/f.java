package com.larus.community.impl.detail.comment;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.community.impl.detail.b0;
import com.larus.platform.model.comment.api.CommentItemCustomType;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements rq9.e {
    public final Function0<Unit> a;

    public final int a() {
        return 2131561997;
    }

    public final CommentItemCustomType c() {
        return CommentItemCustomType.FAIL;
    }

    public f(b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "retryClick");
        this.a = r2;
    }

    public final void b(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        LinearLayout r3 = (LinearLayout) r2.itemView.findViewById(2131378830);
        if (r3 == null) goto L6;
        e1.x(r3);
        e1.d(r3, new e(this));
        return;
    }
}
