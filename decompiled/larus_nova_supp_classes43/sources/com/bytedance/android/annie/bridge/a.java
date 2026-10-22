package com.bytedance.android.annie.bridge;

import com.bytedance.android.annie.bridge.ChooseAndUploadParamModel;
import com.bytedance.android.annie.bridge.ChooseAndUploadResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<P extends ChooseAndUploadParamModel, R extends ChooseAndUploadResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
