package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ OfficeExternalContactFragment a;

    public j(OfficeExternalContactFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        k9b.a r11 = (k9b.a) r10;
        OfficeExternalContactFragment r0 = this.a;
        String r1 = r11.a;
        r0.p = r1;
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r2 = r0.k;
        SubPageEntryAdapter r3 = null;
        if (r2 == null) goto L10;
        String r4 = r11.b;
        String r12 = r11.c;
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r4, "userName");
        Intrinsics.checkNotNullParameter(r12, "avatarKey");
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r5 = r2.a;
        if ((r5 instanceof SubPageEntryAdapter) == false) goto L7;
        SubPageEntryAdapter r6 = (SubPageEntryAdapter) r5;
    L8:
        if (r6 == null) goto L10;
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r4, "userName");
        Intrinsics.checkNotNullParameter(r12, "avatarKey");
        r6.b = r1;
        r6.c = r4;
        r6.d = r12;
        r6.notifyItemChanged(0);
        goto L10
    L7:
        r6 = null;
    L10:
        OfficeExternalContactFragment r13 = this.a;
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r7 = r13.k;
        if (r7 == null) goto L18;
        l9b.a r14 = r13.V90();
        Intrinsics.checkNotNullParameter(r14, "config");
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r8 = r7.a;
        if ((r8 instanceof SubPageEntryAdapter) == false) goto L15;
        r3 = (SubPageEntryAdapter) r8;
    L15:
        if (r3 == null) goto L19;
        Intrinsics.checkNotNullParameter(r14, "config");
        r3.a = r14;
        r3.notifyItemChanged(0);
        return;
    L19:
        return;
    }
}
