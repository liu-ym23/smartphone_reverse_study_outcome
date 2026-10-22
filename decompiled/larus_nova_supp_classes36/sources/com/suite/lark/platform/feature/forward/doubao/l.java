package com.suite.lark.platform.feature.forward.doubao;

import android.text.TextUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements SearchResultView.IOnBusinessConsumeItem {
    public final /* synthetic */ DoubaoForwardFragment a;

    public l(DoubaoForwardFragment r1) {
        this.a = r1;
    }

    public final SearchResultView.CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        ForwardV3ViewModel r0 = this.a.e;
        ForwardV3ViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        boolean r2 = com.ss.android.lark.forwardv3.x.b(r5, r0);
        ForwardV3ViewModel r3 = this.a.e;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        return new SearchResultView.CheckBoxBindStatus(r2, false, !com.ss.android.lark.forwardv3.x.c(r5, r1));
    L8:
        r1 = r3;
        goto L10
    }

    public final boolean onBusinessConsumeItemClick(SearchBaseInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        DoubaoForwardFragment r0 = this.a;
        ForwardV3ViewModel r1 = r0.e;
        ForwardV3ViewModel r2 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L6:
        if (com.ss.android.lark.forwardv3.x.b(r5, r1) == false) goto L36;
        ForwardV3ViewModel r3 = r0.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L11:
        if (com.ss.android.lark.forwardv3.x.a(r5, r3) == false) goto L17;
        ForwardV3ViewModel r6 = r0.e;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        UICallbackExecutor.execute(new j(r0, y9c.d.j(2131892185, "select_count", String.valueOf(r2.getMaxLimitSelectNum()))));
    L35:
        boolean r7 = true;
    L37:
        Log.i("NewForward", "recent visit consume item click: " + r7);
        return r7;
    L15:
        r2 = r6;
        goto L16
    L17:
        ForwardV3ViewModel r4 = r0.e;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L21:
        if (r4.disable(r5) == false) goto L23;
        UICallbackExecutor.execute(new j(r0, y9c.d.h(2131892225)));
        goto L35
    L23:
        ForwardV3ViewModel r8 = r0.e;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L27:
        if (r8.customDisable(r5) == false) goto L35;
        ForwardV3ViewModel r9 = r0.e;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        String r10 = r2.customDisableToastText();
        if (TextUtils.isEmpty(r10) == true) goto L35;
        UICallbackExecutor.execute(new j(r0, r10));
        goto L35
    L31:
        r2 = r9;
        goto L32
    L36:
        r7 = false;
        goto L37
    }
}
