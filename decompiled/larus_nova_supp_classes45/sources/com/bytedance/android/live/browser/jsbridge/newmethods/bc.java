package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.WebDialogFragmentForAnnie;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class bc extends v<cc, SetContainerResultModel> {
    public final BaseWebDialogFragment a;

    public bc(WebDialogFragmentForAnnie r1) {
        this.a = r1;
    }

    public final void invoke(Object r2, CallContext r3) {
        cc r4 = (cc) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        BaseWebDialogFragment r5 = this.a;
        if (r5 == null) goto L9;
        cc.a r6 = r4.a();
        if (r6 == null) goto L7;
        Boolean r7 = r6.a();
    L8:
        r5.S90(!Intrinsics.areEqual(r7, Boolean.TRUE));
        goto L9
    L7:
        r7 = null;
    L9:
        SetContainerResultModel r8 = new SetContainerResultModel();
        r8.a(SetContainerResultModel.Code.Success);
        Unit r9 = Unit.INSTANCE;
        finishWithResult(r8);
    }
}
