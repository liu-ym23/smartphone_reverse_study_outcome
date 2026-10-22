package com.bytedance.android.live.core.setting;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.LoginGuideConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CoreSettingUtil {
    public static String getLoginImageForFollow() {
        LoginGuideConfig r0 = LiveInfraSettingKeys.LOGIN_GUIDE.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getImageUrlFromFollow();
    }

    public static String getLoginPromptForFollow() {
        LoginGuideConfig r0 = LiveInfraSettingKeys.LOGIN_GUIDE.getValue();
        if (r0 == null) goto L9;
        if (TextUtils.isEmpty(r0.getFromFollow()) == true) goto L9;
        return r0.getFromFollow();
    L9:
        return com.bytedance.android.live.core.utils.s1.B(2131915994);
    }

    private CoreSettingUtil() {
    }
}
