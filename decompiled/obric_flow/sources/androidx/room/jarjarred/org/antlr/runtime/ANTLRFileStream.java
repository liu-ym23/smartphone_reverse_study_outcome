package androidx.room.jarjarred.org.antlr.runtime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRFileStream extends ANTLRStringStream {
    protected String fileName;

    public ANTLRFileStream(String r5) throws IOException {
        this(r5, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream, androidx.room.jarjarred.org.antlr.runtime.IntStream
    public String getSourceName() {
        return this.fileName;
    }

    public void load(String r5, String r10) throws IOException {
        if (r5 != null) goto L4;
        return;
    L4:
        int r11 = (int) new File(r5).length();
        FileInputStream r12 = new FileInputStream(r5);
        if (r10 == null) goto L7;
        InputStreamReader r13 = new InputStreamReader(r12, r10);
    L14:
        char[] r14 = new char[r11];     // Catch: Throwable -> L11
        this.data = r14;     // Catch: Throwable -> L11
        this.f619n = r13.read(r14);     // Catch: Throwable -> L11
        r13.close();
        return;
    L11:
        th = move-exception;
        r13.close();
        throw th;
    L7:
        r13 = new InputStreamReader(r12);
        goto L14
    }

    public ANTLRFileStream(String r5, String r10) throws IOException {
        this.fileName = r5;
        load(r5, r10);
    }
}
