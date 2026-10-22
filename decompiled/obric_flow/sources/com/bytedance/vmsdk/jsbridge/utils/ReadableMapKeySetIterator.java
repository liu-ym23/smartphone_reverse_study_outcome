package com.bytedance.vmsdk.jsbridge.utils;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ReadableMapKeySetIterator {
    boolean hasNextKey();

    String nextKey();
}
