package com.bytedance.bdinstall;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface DeviceTokenService {
    Map<String, String> getRequestHeader();

    void updateToken(String r1, Env r2);
}
