package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.setting.api.ISettingApi;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements ao4.d {
    public p() {
    }

    public final void a(go2.g r1) {
        ISettingApi r2 = (ISettingApi) ApiUtils.getApi(ISettingApi.class);
        if (r2 == null) goto L7;
        r2.getUiModeService();
        return;
    }
}
