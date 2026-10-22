package androidx.core.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
public class LogWriter extends Writer {
    private StringBuilder mBuilder;
    private final String mTag;

    public LogWriter(String r10) {
        this.mBuilder = new StringBuilder(128);
        this.mTag = r10;
    }

    private void flushBuilder() {
        if (this.mBuilder.length() <= 0) goto L6;
        Log.d(this.mTag, this.mBuilder.toString());
        StringBuilder r10 = this.mBuilder;
        r10.delete(0, r10.length());
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
    public void write(char[] r10, int r11, int r12) {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        char r14 = r10[r11 + r13];
        if (r14 != '\n') goto L7;
        flushBuilder();
    L8:
        r13 = r13 + 1;
        goto L3
    L7:
        this.mBuilder.append(r14);
        goto L8
    }
}
