package com.bytedance.android.annie.bridge;

import com.bytedance.android.annie.bridge.SetContainerResultModel;
import com.bytedance.android.annie.bridge.s;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class d<P extends s, R extends SetContainerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public d() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
