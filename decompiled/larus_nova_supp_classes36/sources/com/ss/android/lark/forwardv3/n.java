package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements SearchResultView.IOnBusinessConsumeItem {
    public final /* synthetic */ ForwardNewFragment a;

    public n(ForwardNewFragment r1) {
        this.a = r1;
    }

    public final SearchResultView.CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        ForwardV3ViewModel r0 = this.a.f;
        ForwardV3ViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        boolean r2 = x.b(r6, r0);
        ForwardV3ViewModel r3 = this.a.f;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L9:
        if (x.c(r6, r3) == true) goto L17;
        ForwardV3ViewModel r4 = this.a.f;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        if (r1.isExternalTargetDisabledByMessageCount(r6) == true) goto L17;
        boolean r5 = true;
    L18:
        Log.i("NewForward", "data id: " + r6.getId() + ",data is consumed by business: " + r2 + "data is enable: " + r5);
        return new SearchResultView.CheckBoxBindStatus(r2, false, r5);
    L13:
        r1 = r4;
    L17:
        r5 = false;
        goto L18
    }

    public final boolean onBusinessConsumeItemClick(SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        boolean r4 = ForwardNewFragment.S90(this.a, r3);
        Log.i("NewForward", "recent visit consume item click: " + r4);
        return r4;
    }
}
