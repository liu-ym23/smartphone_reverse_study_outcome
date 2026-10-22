package com.suite.lark.platform.feature.forward.doubao;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements y3c.a {
    public final /* synthetic */ DoubaoForwardFragment a;

    public final boolean canLoadMore() {
        return false;
    }

    public final boolean needHeader() {
        return false;
    }

    public final void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public k(DoubaoForwardFragment r1) {
        this.a = r1;
    }

    public final void loadData(IGetDataCallback<List<SearchBaseInfo>> r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        DoubaoForwardFragment r0 = this.a;
        r0.j = r6;
        ForwardV3ViewModel r7 = r0.e;
        ForwardV3ViewModel r1 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L5:
        r7.loadRecommendData(this.a.i, true);
        ForwardV3ViewModel r8 = this.a.e;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        r1.loadRecommendData(this.a.i, false);
        return;
    L8:
        r1 = r8;
        goto L9
    }
}
