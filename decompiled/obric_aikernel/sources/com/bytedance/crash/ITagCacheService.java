package com.bytedance.crash;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ITagCacheService {
    Map<String, String> getAll(String r10);

    void removeTag(String r10, String r11);

    void saveTag(String r10, String r11, String r12);
}
