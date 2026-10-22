package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.jsbridge.methods.LiveScreenRecordActionResultModel;
import com.bytedance.android.livesdk.jsbridge.methods.k1;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class h<P extends k1, R extends LiveScreenRecordActionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public h() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
