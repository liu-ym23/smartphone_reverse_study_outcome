package com.ss.android.lark.contact.impl.group.manage;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends LKUIPtrDefaultHandler2 {
    public final /* synthetic */ MyManageGroupView a;

    public final void onRefreshBegin(LKUIPtrFrameLayout r1) {
    }

    public g(MyManageGroupView r1) {
        this.a = r1;
    }

    public final void onLoadMoreBegin(LKUIPtrFrameLayout r1) {
        this.a.c.Z7();
    }

    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r1, View r2, View r3) {
        if (super.checkCanDoLoadMore(r1, r2, r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.c.canLoadMore() == false) goto L7;
        return true;
    }
}
