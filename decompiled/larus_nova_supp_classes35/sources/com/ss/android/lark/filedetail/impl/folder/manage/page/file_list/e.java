package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends LKUIPtrDefaultHandler2 {
    public final /* synthetic */ FileListView a;

    public final void onRefreshBegin(LKUIPtrFrameLayout r1) {
    }

    public e(FileListView r1) {
        this.a = r1;
    }

    public final void onLoadMoreBegin(LKUIPtrFrameLayout r1) {
        j.a r2 = this.a.i;
        if (r2 == null) goto L6;
        r2.onLoadMore();
        return;
    }

    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r1, View r2, View r3) {
        if (super.checkCanDoLoadMore(r1, r2, r3) == false) goto L11;
        j.a r4 = this.a.i;
        if (r4 == null) goto L7;
        boolean r5 = r4.o0();
    L8:
        if (r5 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r5 = false;
        goto L8
    L11:
        return false;
    }
}
