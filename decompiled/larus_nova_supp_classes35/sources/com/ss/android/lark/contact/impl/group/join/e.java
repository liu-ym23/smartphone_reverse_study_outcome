package com.ss.android.lark.contact.impl.group.join;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends LKUIPtrDefaultHandler2 {
    public final /* synthetic */ MyJoinGroupView a;

    public final void onRefreshBegin(LKUIPtrFrameLayout r1) {
    }

    public e(MyJoinGroupView r1) {
        this.a = r1;
    }

    public final void onLoadMoreBegin(LKUIPtrFrameLayout r1) {
        this.a.b.v1();
    }

    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r1, View r2, View r3) {
        if (super.checkCanDoLoadMore(r1, r2, r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a.b.canLoadMore() == false) goto L7;
        return true;
    }
}
