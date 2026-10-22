package org.terracotta.utilities.io.buffer;

import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes8.dex */
public final class DumpUtility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharsetEncoder f20294a = null;

    public static final class FieldInaccessibleException extends UnsupportedOperationException {
        private static final long serialVersionUID = -2136579828792539023L;

        public FieldInaccessibleException(String r1, Throwable r2) {
            super(r1, r2);
        }
    }

    static {
        f20294a = StandardCharsets.US_ASCII.newEncoder();
    }
}
