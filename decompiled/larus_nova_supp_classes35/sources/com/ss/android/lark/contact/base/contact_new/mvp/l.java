package com.ss.android.lark.contact.base.contact_new.mvp;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l extends LKUIPtrDefaultHandler2 {
    public final /* synthetic */ NewContactView a;

    public final void onRefreshBegin(LKUIPtrFrameLayout r1) {
    }

    public l(NewContactView r1) {
        this.a = r1;
    }

    public final void onLoadMoreBegin(LKUIPtrFrameLayout r1) {
        this.a.b.T();
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
