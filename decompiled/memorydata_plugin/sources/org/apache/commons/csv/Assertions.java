package org.apache.commons.csv;

/* JADX INFO: loaded from: classes6.dex */
final class Assertions {
    static void notNull(Object r2, String r3) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Parameter '" + r3 + "' must not be null!");
    }
}
