package org.apache.poi.util;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes7.dex */
public class RandomSingleton {
    private static final SecureRandom INSTANCE = null;

    static {
        INSTANCE = new SecureRandom();
    }

    public static SecureRandom getInstance() {
        return INSTANCE;
    }
}
