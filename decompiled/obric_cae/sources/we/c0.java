package we;

import java.io.Closeable;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 implements Closeable {
    public abstract long a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        xe.c.f(k());
    }

    @Nullable
    public abstract t i();

    public abstract jf.f k();

    public final String n() {
        jf.f r8 = k();
        t r10 = i();     // Catch: Throwable -> L14
        if (r10 == null) goto L10;
        Charset r11 = xe.c.f13888i;     // Catch: Throwable -> L14
        String r12 = r10.f13262c;     // Catch: IllegalArgumentException -> L17 Throwable -> L14
        if (r12 == null) goto L11;
        r11 = Charset.forName(r12);     // Catch: IllegalArgumentException -> L17 Throwable -> L14
    L11:
        String r13 = r8.b0(xe.c.b(r8, r11));     // Catch: Throwable -> L14
        xe.c.f(r8);
        return r13;
    L10:
        r11 = xe.c.f13888i;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        xe.c.f(r8);
        throw th;
    }
}
