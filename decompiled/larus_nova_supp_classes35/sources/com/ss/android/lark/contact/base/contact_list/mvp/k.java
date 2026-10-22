package com.ss.android.lark.contact.base.contact_list.mvp;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k extends RecyclerView.OnScrollListener {
    public IndexRecyclerViewAdapter.b a;
    public final /* synthetic */ ExternalContactView2.b b;

    public k(ExternalContactView2.b r1) {
        this.b = r1;
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        super.onScrollStateChanged(r3, r4);
        if (r4 != 0) goto L5;
        this.a = null;
    L5:
        this.b.getClass();
        int r5 = r3.getLayoutManager().findFirstVisibleItemPosition();
        IndexRecyclerViewAdapter.b r0 = this.a;
        if (r0 == null) goto L14;
        int r1 = r0.c;
        if (r5 >= r0.d) goto L11;
        if (r1 > r5) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L11:
        r2 = false;
    L14:
        this.b.getClass();
        IndexRecyclerViewAdapter r6 = r3.getAdapter();
        r6.getClass();
        IndexRecyclerViewAdapter.b r7 = new IndexRecyclerViewAdapter.a(r6).a(r5);
        this.a = r7;
        if (r7 == null) goto L20;
        int r8 = r7.a;
        IndexBar r9 = this.b.c;
        if (r9 == null) goto L21;
        r9.setFocusIndex(r8);
        return;
    L21:
        return;
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        super.onScrolled(r1, r2, r3);
    }
}
