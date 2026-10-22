package com.bytedance.apm6.memory.listener;

import com.bytedance.apm6.memory.bean.MemoryCollectInfo;

/* JADX INFO: loaded from: classes.dex */
public interface IMemoryDataListener {
    void onMemoryCallback(MemoryCollectInfo r10);
}
