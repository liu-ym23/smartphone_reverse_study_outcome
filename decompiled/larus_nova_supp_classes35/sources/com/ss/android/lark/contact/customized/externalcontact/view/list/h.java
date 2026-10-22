package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$initExternalContactView$actionHandler$1;
import com.ss.android.lark.contact.customized.externalcontact.view.SubPageEntryAdapter;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mtb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends a<m> {
    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, m> d() {
        return new OfficeEnterpriseContactListAdapter();
    }

    public h() {
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final boolean b(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        return r2 instanceof SubPageEntryAdapter.SubPageEntryViewHolder;
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> c(l9b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return new SubPageEntryAdapter(r2);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final int f(CommonRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        RecyclerView.ViewHolder r3 = r2.findViewHolderForAdapterPosition(0);
        if (r3 == null) goto L8;
        View r4 = r3.itemView;
        if (r4 != null) goto L7;
        return 0;
    L7:
        return r4.getHeight();
    L8:
        return 0;
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final void g(List<? extends m> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, m> r0 = e();
        if ((r0 instanceof OfficeEnterpriseContactListAdapter) == false) goto L5;
        OfficeEnterpriseContactListAdapter r1 = (OfficeEnterpriseContactListAdapter) r0;
    L6:
        if (r1 == null) goto L9;
        r1.B2(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final void a(IndexRecyclerViewAdapter r2, OfficeExternalContactFragment$initExternalContactView$actionHandler$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "handler");
        if ((r2 instanceof OfficeEnterpriseContactListAdapter) == false) goto L6;
        OfficeEnterpriseContactListAdapter r4 = (OfficeEnterpriseContactListAdapter) r2;
        return;
    }
}
