package com.ss.android.lark.contact.customized.newcontact.view;

import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements l.a {
    public final /* synthetic */ OfficeNewContactFragment a;

    @Override // com.ss.android.lark.contact.customized.newcontact.view.l.a
    public final void T() {
        OfficeNewContactFragment r0 = this.a;
        int r1 = OfficeNewContactFragment.h;
        r0.S90().loadMore();
    }

    @Override // com.ss.android.lark.contact.customized.newcontact.view.l.a
    public final boolean canLoadMore() {
        OfficeNewContactFragment r0 = this.a;
        int r1 = OfficeNewContactFragment.h;
        return r0.S90().canLoadMore();
    }

    public f(OfficeNewContactFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.contact.customized.newcontact.view.l.a
    public final void j0(NewContactView.a r3) {
        Intrinsics.checkNotNullParameter(r3, "viewData");
        OfficeNewContactFragment r0 = this.a;
        int r1 = OfficeNewContactFragment.h;
        r0.S90().onFriendRequestDeleted(r3);
    }

    @Override // com.ss.android.lark.contact.customized.newcontact.view.l.a
    public final void t0(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "chatApplicationId");
        OfficeNewContactFragment r0 = this.a;
        int r1 = OfficeNewContactFragment.h;
        r0.S90().onClickFriendRequest(r3, r4);
    }
}
