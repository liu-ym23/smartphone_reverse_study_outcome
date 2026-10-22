package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public interface UnownedUserData {
    default boolean informOnDetachmentFromHost() {
        return true;
    }

    default void onDetachedFromHost(UnownedUserDataHost r10) {
    }
}
