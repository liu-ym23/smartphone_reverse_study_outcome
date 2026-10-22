package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.newmethods.RequestOrientationPermissionResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.cb;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class r<P extends cb, R extends RequestOrientationPermissionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public r() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
