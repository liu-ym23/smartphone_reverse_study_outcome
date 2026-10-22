package com.bytedance.android.live.browser.jsbridge.method.dialog;

import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.WebDialogFragmentForAnnie;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends g<a, Object> {
    public final BaseWebDialogFragment a;

    public static final class a {

        @SerializedName("enable_to_full")
        int enableToFull;

        @SerializedName("enable_to_half")
        int enableToHalf;

        @SerializedName("show_close_icon")
        int showCloseIcon;

        public a() {
        }
    }

    public b(WebDialogFragmentForAnnie r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, CallContext r5) throws Exception {
        a r6 = (a) r4;
        BaseWebDialogFragment r7 = this.a;
        boolean r1 = false;
        if (r6.enableToHalf != 1) goto L5;
        boolean r0 = true;
    L6:
        r7.V90(r0);
        BaseWebDialogFragment r8 = this.a;
        if (r6.enableToFull != 1) goto L9;
        boolean r2 = true;
    L10:
        r8.U90(r2);
        BaseWebDialogFragment r9 = this.a;
        if (r6.showCloseIcon != 1) goto L13;
        r1 = true;
    L13:
        r9.X90(r1);
        return null;
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }
}
