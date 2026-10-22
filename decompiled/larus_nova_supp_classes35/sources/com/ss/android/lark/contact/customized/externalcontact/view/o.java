package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o {
    public OfficeFloatingBarItemDecoration a;

    public o() {
    }

    public static IndexRecyclerViewAdapter a(RecyclerView r3) {
        ConcatAdapter r4 = r3.getAdapter();
        if ((r4 instanceof ConcatAdapter) == false) goto L13;
        ConcatAdapter r0 = r4;
        if (r0.getAdapters().size() <= 1) goto L9;
        return (IndexRecyclerViewAdapter) ListProtector.get(r0.getAdapters(), 1);
    L9:
        if (r0.getAdapters().size() != 1) goto L13;
        return (IndexRecyclerViewAdapter) ListProtector.get(r0.getAdapters(), 0);
    L13:
        return (IndexRecyclerViewAdapter) r4;
    }

    public static int b(RecyclerView r3) {
        ConcatAdapter r4 = r3.getAdapter();
        if ((r4 instanceof ConcatAdapter) == false) goto L8;
        ConcatAdapter r5 = r4;
        if (r5.getAdapters().size() <= 1) goto L8;
        return ((RecyclerView.Adapter) ListProtector.get(r5.getAdapters(), 0)).getItemCount();
    L8:
        return 0;
    }
}
