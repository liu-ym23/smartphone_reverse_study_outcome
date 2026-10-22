package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeContactPageLayoutBinding;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends LKUIPtrDefaultHandler2 {
    public final /* synthetic */ OfficeExternalContactFragment a;

    public final void onRefreshBegin(LKUIPtrFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
    }

    public f(OfficeExternalContactFragment r1) {
        this.a = r1;
    }

    public final void onLoadMoreBegin(LKUIPtrFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        OfficeExternalContactFragment r3 = this.a;
        int r0 = OfficeExternalContactFragment.r;
        r3.X90().loadMore();
        ContactDbFragmentOfficeContactPageLayoutBinding r4 = this.a.d;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L5:
        r4.d.refreshComplete();
    }

    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "footer");
        if (super.checkCanDoLoadMore(r2, r3, r4) == false) goto L7;
        OfficeExternalContactFragment r5 = this.a;
        int r6 = OfficeExternalContactFragment.r;
        if (r5.X90().canLoadMore() == false) goto L7;
        return true;
    L7:
        return false;
    }
}
