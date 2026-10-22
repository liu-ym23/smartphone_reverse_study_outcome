package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferUtil {
    public ByteBufferUtil() {
    }

    public static int getSizePrefix(ByteBuffer r10) {
        return r10.getInt(r10.position());
    }

    public static ByteBuffer removeSizePrefix(ByteBuffer r10) {
        ByteBuffer r11 = r10.duplicate();
        r11.position(r11.position() + 4);
        return r11;
    }
}
