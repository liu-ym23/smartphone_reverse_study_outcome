package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.GetDeviceStatsResultModel;
import com.bytedance.android.annie.bridge.method.e0;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<P extends e0, R extends GetDeviceStatsResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
