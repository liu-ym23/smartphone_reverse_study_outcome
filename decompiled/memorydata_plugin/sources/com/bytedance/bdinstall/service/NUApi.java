package com.bytedance.bdinstall.service;

import com.bytedance.bdinstall.nu.Action;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface NUApi {
    String getCustomParam(String r1, String r2);

    boolean isAutoMode();

    boolean isSupport();

    void mapCustomParams(Map<String, String> r1);

    Action setNUMode(boolean r1);
}
