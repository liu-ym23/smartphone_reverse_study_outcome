package org.apache.poi.util;

import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public final class TempFile {
    private static TempFileCreationStrategy strategy;

    static {
        strategy = new DefaultTempFileCreationStrategy();
    }

    public static File createTempFile(String r1, String r2) {
        return strategy.createTempFile(r1, r2);
    }
}
