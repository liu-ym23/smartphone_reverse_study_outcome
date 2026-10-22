package com.bytedance.android.livesdk.interactivity.square.common;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ f a;

    public h(f r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IModelListDataManager.a r5 = (IModelListDataManager.a) r4;
        if (r5 == null) goto L31;
        int r0 = g.a[r5.getType().ordinal()];
        if (r0 != 1) goto L8;
        this.a.e.notifyDataSetChanged();
        this.a.a.c();
    L29:
        this.a.a.onEvent(r5);
        return;
    L8:
        if (r0 != 2) goto L10;
        this.a.e.notifyItemInserted(r5.b);
        BaseModelListScrollManager r1 = this.a.a;
        if (r1.a != BaseModelListScrollManager.ScrollState.AutoScroll) goto L29;
        RecyclerView.Adapter r2 = r1.j.getAdapter();
        if (r2 == null) goto L29;
        int r3 = r2.getItemCount() - 1;
        if (r1.i == false) goto L26;
        r1.j.smoothScrollToPosition(r3);
    L27:
        r1.b(r3);
        goto L29
    L26:
        r1.j.scrollToPosition(r3);
        goto L27
    L10:
        if (r0 != 3) goto L12;
        this.a.e.notifyItemInserted(r5.b);
        goto L29
    L12:
        if (r0 != 4) goto L14;
        this.a.e.notifyDataSetChanged();
        goto L29
    L14:
        if (r0 != 5) goto L29;
        this.a.e.notifyItemRangeRemoved(r5.c, r5.d);
        goto L29
    }
}
