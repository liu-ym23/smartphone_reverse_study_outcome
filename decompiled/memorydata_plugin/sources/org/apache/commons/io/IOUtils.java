package org.apache.commons.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: loaded from: classes6.dex */
public class IOUtils {
    public static final char DIR_SEPARATOR = 0;
    public static final byte[] EMPTY_BYTE_ARRAY = null;

    @Deprecated
    public static final String LINE_SEPARATOR = null;
    public static final String LINE_SEPARATOR_UNIX = null;
    public static final String LINE_SEPARATOR_WINDOWS = null;
    private static final ThreadLocal<byte[]> SKIP_BYTE_BUFFER = null;
    private static final ThreadLocal<char[]> SKIP_CHAR_BUFFER = null;

    static {
        DIR_SEPARATOR = File.separatorChar;
        EMPTY_BYTE_ARRAY = new byte[0];
        LINE_SEPARATOR = System.lineSeparator();
        LINE_SEPARATOR_UNIX = StandardLineSeparator.LF.getString();
        LINE_SEPARATOR_WINDOWS = StandardLineSeparator.CRLF.getString();
        SKIP_BYTE_BUFFER = ThreadLocal.withInitial($$Lambda$9BAXxIVvTQTfZLonlFIMrHz1T5w.INSTANCE);
        SKIP_CHAR_BUFFER = ThreadLocal.withInitial($$Lambda$IOUtils$zxbPsNmCQijkaISempsHC1EJows.INSTANCE);
    }

    public static byte[] byteArray() {
        return byteArray(8192);
    }

    public static byte[] byteArray(int r0) {
        return new byte[r0];
    }

    private static char[] charArray() {
        return charArray(8192);
    }

    private static char[] charArray(int r0) {
        return new char[r0];
    }

    public static void close(Closeable r2, IOConsumer<IOException> r3) {
        Closeable r4 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        IOConsumer r5 = (IOConsumer) ZeusTransformUtils.wrapperContextForParams(r3, IOConsumer.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        r4.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        if (r5 == null) goto L13;
        r5.accept(e);
        return;
    L13:
        return;
    }

    public static /* synthetic */ char[] lambda$zxbPsNmCQijkaISempsHC1EJows() {
        return charArray();
    }

    public static int length(byte[] r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.length;
    }

    public static int length(Object[] r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.length;
    }
}
