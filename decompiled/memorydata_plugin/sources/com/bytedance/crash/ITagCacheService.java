package com.bytedance.crash;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ITagCacheService {
    Map<String, String> getAll(String r1);

    void removeTag(String r1, String r2);

    void saveTag(String r1, String r2, String r3);
}
