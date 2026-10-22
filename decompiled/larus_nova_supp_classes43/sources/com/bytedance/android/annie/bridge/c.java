package com.bytedance.android.annie.bridge;

import com.bytedance.android.annie.bridge.GetSettingsResultModel;
import com.bytedance.android.annie.bridge.m;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c<P extends m, R extends GetSettingsResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public c() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
