package com.bytedance.bdinstall;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class AbsDeviceTokenService implements DeviceTokenService {
    AbsDeviceTokenService() {
    }

    protected abstract String getDeviceToken();

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public Map<String, String> getRequestHeader() {
        String r10 = getDeviceToken();
        HashMap r11 = new HashMap();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r11.put("x-tt-dt", r10);
        return r11;
    }
}
