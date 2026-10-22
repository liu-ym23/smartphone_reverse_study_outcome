package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.ss.android.lark.widget.ptr.LKUIPtrDefaultHandler2;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m extends LKUIPtrDefaultHandler2 {
    public final /* synthetic */ l a;

    public final void onRefreshBegin(LKUIPtrFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
    }

    public m(l r1) {
        this.a = r1;
    }

    public final void onLoadMoreBegin(LKUIPtrFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        l.a r3 = this.a.c;
        if (r3 == null) goto L6;
        r3.T();
        return;
    }

    public final boolean checkCanDoLoadMore(LKUIPtrFrameLayout r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "footer");
        if (super.checkCanDoLoadMore(r2, r3, r4) == false) goto L13;
        l.a r5 = this.a.c;
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r5.canLoadMore() != true) goto L9;
        r6 = true;
        goto L10
    L13:
        return false;
    }
}
