package kotlinx.metadata.internal.protobuf;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements z {
    protected int memoizedHashCode;

    public b() {
        this.memoizedHashCode = 0;
    }

    public static void checkByteStringIsUtf8(e r5) throws IllegalArgumentException {
        if (r5.i() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    @Override // kotlinx.metadata.internal.protobuf.z
    public byte[] toByteArray() {
        int r5 = getSerializedSize();     // Catch: IOException -> L7
        byte[] r10 = new byte[r5];     // Catch: IOException -> L7
        g r11 = new g(r10, r5);     // Catch: IOException -> L7
        writeTo(r11);     // Catch: IOException -> L7
        if ((r5 - r11.f19168c) != 0) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");     // Catch: IOException -> L7
    L7:
        e = move-exception;
        throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
    }

    public e toByteString() {
        int r5 = getSerializedSize();     // Catch: IOException -> L8
        byte[] r10 = new byte[r5];     // Catch: IOException -> L8
        g r11 = new g(r10, r5);     // Catch: IOException -> L8
        writeTo(r11);     // Catch: IOException -> L8
        if ((r5 - r11.f19168c) != 0) goto L7;
        return new x(r10);
    L7:
        throw new IllegalStateException("Did not write as much data as expected.");     // Catch: IOException -> L8
    L8:
        e = move-exception;
        throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
    }

    public void writeDelimitedTo(OutputStream r5) throws IOException {
        int r10 = getSerializedSize();
        int r11 = g.f(r10) + r10;
        if (r11 <= 4096) goto L5;
        r11 = 4096;
    L5:
        g r12 = g.j(r5, r11);
        r12.v(r10);
        writeTo(r12);
        r12.i();
    }

    public void writeTo(OutputStream r5) throws IOException {
        int r10 = getSerializedSize();
        if (r10 <= 4096) goto L5;
        r10 = 4096;
    L5:
        g r11 = g.j(r5, r10);
        writeTo(r11);
        r11.i();
    }
}
