package nu;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f20325b;

    public /* synthetic */ h(l r5, int r10) {
        this.f20324a = r10;
        this.f20325b = r5;
    }

    private final void b() {
    }

    @Override // java.io.InputStream
    public final int available() {
        switch(this.f20324a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        x r5 = (x) this.f20325b;
        if (r5.f20350b == true) goto L9;
        return (int) Math.min(r5.f20349a.f20328b, Integer.MAX_VALUE);
    L9:
        throw new IOException("closed");
    L11:
        return (int) Math.min(((j) this.f20325b).f20328b, Integer.MAX_VALUE);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch(this.f20324a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((x) this.f20325b).close();
        return;
    }

    @Override // java.io.InputStream
    public final int read() {
        switch(this.f20324a) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        x r5 = (x) this.f20325b;
        if (r5.f20350b == true) goto L14;
        j r10 = r5.f20349a;
        if (r10.f20328b != 0) goto L12;
        if (r5.f20351c.read(r10, 8192) != (-1)) goto L12;
        return -1;
    L12:
        return r10.readByte() & UByte.MAX_VALUE;
    L14:
        throw new IOException("closed");
    L15:
        j r11 = (j) this.f20325b;
        if (r11.f20328b > 0) goto L21;
        return -1;
    L21:
        return r11.readByte() & UByte.MAX_VALUE;
    }

    public final String toString() {
        switch(this.f20324a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ((x) this.f20325b) + ".inputStream()";
    L7:
        return ((j) this.f20325b) + ".inputStream()";
    }

    @Override // java.io.InputStream
    public final int read(byte[] r10, int r11, int r12) {
        switch(this.f20324a) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "data");
        x r13 = (x) this.f20325b;
        if (r13.f20350b == true) goto L14;
        f4.a.d(r10.length, r11, r12);
        j r5 = r13.f20349a;
        if (r5.f20328b != 0) goto L12;
        if (r13.f20351c.read(r5, 8192) != (-1)) goto L12;
        return -1;
    L12:
        return r5.read(r10, r11, r12);
    L14:
        throw new IOException("closed");
    L15:
        Intrinsics.checkNotNullParameter(r10, "sink");
        return ((j) this.f20325b).read(r10, r11, r12);
    }
}
