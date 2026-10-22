package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t extends RecyclerView.OnScrollListener {
    public IndexRecyclerViewAdapter.b a;
    public final /* synthetic */ int b;
    public final /* synthetic */ IndexRecyclerViewAdapter c;
    public final /* synthetic */ u d;

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        super.onScrollStateChanged(r3, r4);
        if (r4 != 0) goto L5;
        this.a = null;
    L5:
        this.d.getClass();
        int r5 = r3.getLayoutManager().findFirstVisibleItemPosition() - this.b;
        boolean r6 = false;
        if (r5 >= 0) goto L11;
        IndexBar r7 = this.d.c;
        if (r7 == null) goto L25;
        r7.setFocusIndex(0);
        return;
    L25:
        return;
    L11:
        IndexRecyclerViewAdapter.b r0 = this.a;
        if (r0 == null) goto L19;
        int r1 = r0.c;
        if (r5 >= r0.d) goto L17;
        if (r1 > r5) goto L17;
        r6 = true;
    L17:
        if (r6 == false) goto L19;
        return;
    L19:
        IndexRecyclerViewAdapter r8 = this.c;
        r8.getClass();
        IndexRecyclerViewAdapter.b r9 = new IndexRecyclerViewAdapter.a(r8).a(r5);
        this.a = r9;
        if (r9 == null) goto L26;
        int r10 = r9.a;
        u r11 = this.d;
        int r12 = r10 + (r11.e ? 1 : 0);
        IndexBar r13 = r11.c;
        if (r13 == null) goto L27;
        r13.setFocusIndex(r12);
        return;
    L27:
        return;
    }

    public t(u r1, int r2, IndexRecyclerViewAdapter r3) {
        this.d = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        super.onScrolled(r1, r2, r3);
    }
}
