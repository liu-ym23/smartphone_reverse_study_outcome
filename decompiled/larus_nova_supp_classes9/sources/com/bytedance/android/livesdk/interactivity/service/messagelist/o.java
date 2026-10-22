package com.bytedance.android.livesdk.interactivity.service.messagelist;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ m a;

    public o(m r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IMessageListManager.a r5 = (IMessageListManager.a) r4;
        if (r5 == null) goto L33;
        int r0 = n.a[r5.getType().ordinal()];
        if (r0 != 1) goto L8;
        this.a.a.notifyDataSetChanged();
        MessageListScrollManager r1 = this.a.b;
        RecyclerView.Adapter r2 = r1.l.getAdapter();
        if (r2 == null) goto L31;
        int r3 = r2.getItemCount() - 1;
        r1.l.scrollToPosition(r3);
        r1.d(r3);
    L31:
        this.a.b.onEvent(r5);
        return;
    L8:
        if (r0 != 2) goto L10;
        this.a.a.notifyItemInserted(r5.b);
        MessageListScrollManager r6 = this.a.b;
        if (r6.a != MessageListScrollManager.ScrollState.AutoScroll) goto L31;
        RecyclerView.Adapter r7 = r6.l.getAdapter();
        if (r7 == null) goto L31;
        int r8 = r7.getItemCount() - 1;
        if (r6.j == false) goto L26;
        r6.l.smoothScrollToPosition(r8);
    L27:
        r6.d(r8);
        goto L31
    L26:
        r6.l.scrollToPosition(r8);
        goto L27
    L10:
        if (r0 != 3) goto L12;
        this.a.a.notifyItemInserted(r5.b);
        goto L31
    L12:
        if (r0 != 4) goto L14;
        this.a.a.notifyDataSetChanged();
        goto L31
    L14:
        if (r0 != 5) goto L31;
        this.a.a.notifyItemRangeRemoved(r5.c, r5.d);
        goto L31
    }
}
