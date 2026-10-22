package com.bytedance.android.anya;

import com.bytedance.android.anya.BaseMVIDataStore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public interface n<DATA_STORE extends BaseMVIDataStore<?>> {
    <T> void a(t<DATA_STORE, T> r1, T r10);

    <T> T b(t<DATA_STORE, T> r1);
}
