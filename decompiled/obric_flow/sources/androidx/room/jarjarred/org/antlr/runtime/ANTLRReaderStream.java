package androidx.room.jarjarred.org.antlr.runtime;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRReaderStream extends ANTLRStringStream {
    public static final int INITIAL_BUFFER_SIZE = 1024;
    public static final int READ_BUFFER_SIZE = 1024;

    public ANTLRReaderStream() {
    }

    public void load(Reader r5, int r10, int r11) throws IOException {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r10 > 0) goto L7;
        r10 = 1024;
    L7:
        if (r11 > 0) goto L22;
        r11 = 1024;
    L22:
        this.data = new char[r10];     // Catch: Throwable -> L13
        int r12 = 0;
    L10:
        int r13 = r12 + r11;     // Catch: Throwable -> L13
        char[] r14 = this.data;     // Catch: Throwable -> L13
        if (r13 <= r14.length) goto L15;
        char[] r15 = new char[r14.length * 2];     // Catch: Throwable -> L13
        System.arraycopy(r14, 0, r15, 0, r14.length);     // Catch: Throwable -> L13
        this.data = r15;     // Catch: Throwable -> L13
    L15:
        int r16 = r5.read(this.data, r12, r11);     // Catch: Throwable -> L13
        r12 = r12 + r16;     // Catch: Throwable -> L13
        if (r16 != (-1)) goto L10;
        this.f619n = r12 + 1;     // Catch: Throwable -> L13
        r5.close();
        return;
    L13:
        th = move-exception;
        r5.close();
        throw th;
    }

    public ANTLRReaderStream(Reader r5) throws IOException {
        this(r5, 1024, 1024);
    }

    public ANTLRReaderStream(Reader r5, int r10) throws IOException {
        this(r5, r10, 1024);
    }

    public ANTLRReaderStream(Reader r5, int r10, int r11) throws IOException {
        load(r5, r10, r11);
    }
}
