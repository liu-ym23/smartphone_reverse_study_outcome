package okhttp3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStreamReader f20756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nu.l f20757c;
    public final Charset d;

    public t0(nu.l r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r10, "charset");
        this.f20757c = r5;
        this.d = r10;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f20755a = true;
        InputStreamReader r5 = this.f20756b;
        if (r5 == null) goto L5;
        r5.close();
        return;
    L5:
        this.f20757c.close();
    }

    @Override // java.io.Reader
    public final int read(char[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "cbuf");
        if (this.f20755a == true) goto L11;
        InputStreamReader r12 = this.f20756b;
        if (r12 != null) goto L9;
        nu.l r13 = this.f20757c;
        r12 = new InputStreamReader(r13.I(), Util.readBomAsCharset(r13, this.d));
        this.f20756b = r12;
    L9:
        return r12.read(r5, r10, r11);
    L11:
        throw new IOException("Stream closed");
    }
}
