package com.bytedance.bdinstall.service;

import com.bytedance.bdinstall.nu.Action;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface NUApi {
    String getCustomParam(String r10, String r11);

    boolean isAutoMode();

    boolean isSupport();

    void mapCustomParams(Map<String, String> r10);

    Action setNUMode(boolean r10);
}
