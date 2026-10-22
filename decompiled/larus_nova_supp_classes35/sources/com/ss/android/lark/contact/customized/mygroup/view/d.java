package com.ss.android.lark.contact.customized.mygroup.view;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends LKUIPtrDefaultHandler2 {
    public final /* synthetic */ OfficeMyJoinGroupFragment a;

    public final void onRefreshBegin(LKUIPtrFrameLayout r1) {
    }

    public d(OfficeMyJoinGroupFragment r1) {
        this.a = r1;
    }

    public final void onLoadMoreBegin(LKUIPtrFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        OfficeMyJoinGroupFragment r3 = this.a;
        int r0 = OfficeMyJoinGroupFragment.i;
        r3.S90().loadMore();
    }

    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "footer");
        if (super.checkCanDoLoadMore(r2, r3, r4) == false) goto L7;
        OfficeMyJoinGroupFragment r5 = this.a;
        int r6 = OfficeMyJoinGroupFragment.i;
        if (r5.S90().canLoadMore() == false) goto L7;
        return true;
    L7:
        return false;
    }
}
