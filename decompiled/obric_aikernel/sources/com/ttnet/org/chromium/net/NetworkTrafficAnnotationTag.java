package com.ttnet.org.chromium.net;

import androidx.annotation.VisibleForTesting;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkTrafficAnnotationTag {
    public static final NetworkTrafficAnnotationTag MISSING_TRAFFIC_ANNOTATION = null;
    public static final NetworkTrafficAnnotationTag NO_TRAFFIC_ANNOTATION_YET = null;
    public static final NetworkTrafficAnnotationTag TRAFFIC_ANNOTATION_FOR_TESTS = null;
    private final int mHashCode;

    static {
        NO_TRAFFIC_ANNOTATION_YET = createComplete("undefined", "Nothing here yet.");
        MISSING_TRAFFIC_ANNOTATION = createComplete("undefined", "Function called without traffic annotation.");
        TRAFFIC_ANNOTATION_FOR_TESTS = createComplete("test", "Traffic annotation for unit, browser and other tests");
    }

    private NetworkTrafficAnnotationTag(String r10) {
        this.mHashCode = iterativeHash(r10);
    }

    public static NetworkTrafficAnnotationTag createComplete(String r10, String r11) {
        return new NetworkTrafficAnnotationTag(r10);
    }

    @VisibleForTesting
    static int iterativeHash(String r10) {
        byte[] r11 = r10.getBytes(StandardCharsets.UTF_8);
        int r12 = r11.length;
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L6;
        r13 = ((r13 * 31) + ((long) r11[r14])) % 138003713;
        r14 = r14 + 1;
        goto L3
    L6:
        return (int) r13;
    }

    public int getHashCode() {
        return this.mHashCode;
    }
}
