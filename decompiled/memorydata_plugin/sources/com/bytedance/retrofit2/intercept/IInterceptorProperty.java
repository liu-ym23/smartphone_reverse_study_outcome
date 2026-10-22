package com.bytedance.retrofit2.intercept;

/* JADX INFO: loaded from: classes2.dex */
public interface IInterceptorProperty {
    default boolean shouldRunInMergeMode() {
        return false;
    }

    default boolean shouldRunInPureMode() {
        return false;
    }
}
