package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.view.SizeDetectFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseBannerComponent_ViewBinding implements Unbinder {
    public BaseBannerComponent a;

    public final void unbind() {
        BaseBannerComponent r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mBannerRoot = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public BaseBannerComponent_ViewBinding(BaseBannerComponent r4, View r5) {
        this.a = r4;
        r4.mBannerRoot = (SizeDetectFrameLayout) Utils.findRequiredViewAsType(r5, 2131363948, "field 'mBannerRoot'", SizeDetectFrameLayout.class);
    }
}
