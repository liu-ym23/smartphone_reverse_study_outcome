package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class h0 extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f1971b;

    public h0() {
        this.f1971b = new StringBuilder(128);
        this.f1970a = "FragmentManager";
    }

    public final void a() {
        StringBuilder r8 = this.f1971b;
        if (r8.length() <= 0) goto L6;
        Log.d(this.f1970a, r8.toString());
        r8.delete(0, r8.length());
        return;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] r8, int r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        char r13 = r8[r10 + r12];
        if (r13 != '\n') goto L7;
        a();
    L8:
        r12 = r12 + 1;
        goto L3
    L7:
        this.f1971b.append(r13);
        goto L8
    }
}
