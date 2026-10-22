package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods.LiveGetGiftCommonInitDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<P extends JsonObject, R extends LiveGetGiftCommonInitDataResultModel> extends com.bytedance.ies.web.jsbridge2.g<P, R> {
    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
