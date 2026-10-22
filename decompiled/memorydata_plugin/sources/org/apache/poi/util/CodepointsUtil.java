package org.apache.poi.util;

import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public class CodepointsUtil {
    public static Iterator<String> iteratorFor(String r1) {
        return r1.codePoints().mapToObj($$Lambda$CodepointsUtil$cn2YTDyiN3TMalxfpr9ha7GcuXI.INSTANCE).iterator();
    }

    static /* synthetic */ String lambda$iteratorFor$0(int r1) {
        return new StringBuilder().appendCodePoint(r1).toString();
    }
}
