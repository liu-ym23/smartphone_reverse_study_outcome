package com.ss.android.lark.contact.customized.externalcontact.view.list;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeContactListAdapter;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$initExternalContactView$actionHandler$1;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l extends a<mtb.d> {
    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final boolean b(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        return false;
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> c(l9b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return null;
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final int f(CommonRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        return 0;
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, mtb.d> d() {
        return new OfficeContactListAdapter();
    }

    public l() {
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.list.a
    public final void g(List<? extends mtb.d> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, mtb.d> r0 = e();
        if ((r0 instanceof OfficeContactListAdapter) == false) goto L5;
        OfficeContactListAdapter r1 = (OfficeContactListAdapter) r0;
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
        if ((r2 instanceof OfficeContactListAdapter) == false) goto L5;
        OfficeContactListAdapter r4 = (OfficeContactListAdapter) r2;
    L6:
        if (r4 == null) goto L9;
        r4.e = new k(r3);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
