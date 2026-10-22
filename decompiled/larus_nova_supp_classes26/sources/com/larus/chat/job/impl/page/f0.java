package com.larus.chat.job.impl.page;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.component.ChatJobLynxItemComponent;
import com.larus.platform.api.e4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f0 extends RecyclerView.RecycledViewPool {
    public final e0 a;
    public final int b;
    public final int c;

    public f0(e0 r2) {
        Intrinsics.checkNotNullParameter(r2, "reuseController");
        this.a = r2;
        this.b = 2;
        this.c = 5;
    }

    public final void putRecycledView(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "scrap");
        int r0 = r5.getItemViewType();
        int r1 = this.b;
        if (r0 == r1) goto L5;
    L19:
        super.putRecycledView(r5);
        return;
    L5:
        if (getRecycledViewCount(r1) < this.c) goto L19;
        e0 r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "holder");
        if ((r5 instanceof JobViewHolder) == false) goto L9;
        JobViewHolder r6 = (JobViewHolder) r5;
    L10:
        if (r6 == null) goto L21;
        r6.unbind();
        ChatJobLynxItemComponent r3 = r6.b;
        if (r3 == null) goto L17;
        e4 r4 = r3.m;
        if (r4 == null) goto L16;
        r4.destroy();
    L16:
        r3.m = null;
        r3.n = null;
        r3.o = null;
        r3.q = null;
        r3.l.removeAllViews();
    L17:
        r6.b = null;
        r2.a.remove(r6);
        return;
    L21:
        return;
    L9:
        r6 = null;
        goto L10
    }
}
