package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferUtil {
    public ByteBufferUtil() {
    }

    public static int getSizePrefix(ByteBuffer r5) {
        return r5.getInt(r5.position());
    }

    public static ByteBuffer removeSizePrefix(ByteBuffer r5) {
        ByteBuffer r10 = r5.duplicate();
        r10.position(r10.position() + 4);
        return r10;
    }
}
