package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRFileStream extends ANTLRInputStream {
    protected String fileName;

    public ANTLRFileStream(String r5) throws IOException {
        this(r5, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRInputStream, androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public String getSourceName() {
        return this.fileName;
    }

    public void load(String r5, String r10) throws IOException {
        char[] r11 = Utils.readFile(r5, r10);
        this.data = r11;
        this.f652n = r11.length;
    }

    public ANTLRFileStream(String r5, String r10) throws IOException {
        this.fileName = r5;
        load(r5, r10);
    }
}
