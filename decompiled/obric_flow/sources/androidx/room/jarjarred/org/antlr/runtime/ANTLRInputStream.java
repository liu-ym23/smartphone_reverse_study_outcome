package androidx.room.jarjarred.org.antlr.runtime;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRInputStream extends ANTLRReaderStream {
    public ANTLRInputStream() {
    }

    public ANTLRInputStream(InputStream r5) throws IOException {
        this(r5, null);
    }

    public ANTLRInputStream(InputStream r5, int r10) throws IOException {
        this(r5, r10, null);
    }

    public ANTLRInputStream(InputStream r5, String r10) throws IOException {
        this(r5, 1024, r10);
    }

    public ANTLRInputStream(InputStream r5, int r10, String r11) throws IOException {
        this(r5, r10, 1024, r11);
    }

    public ANTLRInputStream(InputStream r5, int r10, int r11, String r12) throws IOException {
        if (r12 == null) goto L5;
        InputStreamReader r13 = new InputStreamReader(r5, r12);
    L6:
        load(r13, r10, r11);
        return;
    L5:
        r13 = new InputStreamReader(r5);
        goto L6
    }
}
