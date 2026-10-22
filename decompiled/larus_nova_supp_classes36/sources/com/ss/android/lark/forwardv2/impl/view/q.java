package com.ss.android.lark.forwardv2.impl.view;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements y3c.a {
    public final /* synthetic */ iib.e a;
    public final /* synthetic */ d0 b;

    public final boolean canLoadMore() {
        return false;
    }

    public final boolean needHeader() {
        return true;
    }

    public final void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r1) {
    }

    public final void loadData(final IGetDataCallback<List<SearchBaseInfo>> r3) {
        final iib.e r0 = this.a;
        qqb.c.c(new p(this, r0, r3));
    }

    public q(d0 r1, com.ss.android.lark.forwardv2.impl.c r2) {
        this.b = r1;
        this.a = r2;
    }
}
