package kotlin.reflect.jvm.internal.impl.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int r10);
    }

    static {
        byte[] r10 = new byte[0];
        EMPTY_BYTE_ARRAY = r10;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r10);
    }

    public static boolean isValidUtf8(byte[] r10) {
        return Utf8.isValidUtf8(r10);
    }

    public static String toStringUtf8(byte[] r10) {
        return new String(r10, "UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }
}
