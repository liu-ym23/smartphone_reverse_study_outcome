package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class ExposingBufferByteArrayOutputStream extends ByteArrayOutputStream {
    public ExposingBufferByteArrayOutputStream(int r10) {
        super(r10);
    }

    public final byte[] getBuffer() {
        byte[] r10 = ((ByteArrayOutputStream) this).buf;
        Intrinsics.checkNotNullExpressionValue(r10, "buf");
        return r10;
    }
}
