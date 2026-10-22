package com.bytedance.bdinstall.storage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ICache {
    void cacheString(String r10, String r11);

    void clear(List<String> r10);

    String getCachedString(String r10);

    String[] loadAccId(String[] r10, String[] r11);

    String loadClientUdid(String r10, String r11);

    String loadDeviceId(String r10, String r11);

    String loadOpenUdid(String r10, String r11);

    String loadSerialNumber(String r10, String r11);

    String loadUdid(String r10, String r11);
}
