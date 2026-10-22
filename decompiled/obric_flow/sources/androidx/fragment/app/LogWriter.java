package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
final class LogWriter extends Writer {
    private StringBuilder mBuilder;
    private final String mTag;

    public LogWriter(String r5) {
        this.mBuilder = new StringBuilder(128);
        this.mTag = r5;
    }

    private void flushBuilder() {
        if (this.mBuilder.length() <= 0) goto L6;
        Log.d(this.mTag, this.mBuilder.toString());
        StringBuilder r5 = this.mBuilder;
        r5.delete(0, r5.length());
        return;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        flushBuilder();
    }

    @Override // java.io.Writer
    public void write(char[] r5, int r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        char r13 = r5[r10 + r12];
        if (r13 != '\n') goto L7;
        flushBuilder();
    L8:
        r12 = r12 + 1;
        goto L3
    L7:
        this.mBuilder.append(r13);
        goto L8
    }
}
