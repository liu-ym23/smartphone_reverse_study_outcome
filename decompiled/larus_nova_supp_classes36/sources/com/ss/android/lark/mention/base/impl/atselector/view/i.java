package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends LKUIPtrDefaultHandler2 {
    public final /* synthetic */ AtView a;

    public final void onRefreshBegin(LKUIPtrFrameLayout r1) {
    }

    public i(AtView r1) {
        this.a = r1;
    }

    public final void onLoadMoreBegin(LKUIPtrFrameLayout r1) {
        this.a.mSearchEt.clearFocus();
        KeyboardUtils.hideKeyboard(this.a.b);
        this.a.i.onLoadMore();
    }

    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r2, View r3, View r4) {
        if (this.a.i.o0() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkCanDoLoadMore(r2, r3, r4) == false) goto L7;
        return true;
    }
}
