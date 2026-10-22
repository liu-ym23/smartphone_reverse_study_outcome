package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.newmethods.IsBizEntryInHomeSideBarResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.r5;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class h<P extends r5, R extends IsBizEntryInHomeSideBarResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public h() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
