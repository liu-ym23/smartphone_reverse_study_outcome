package androidx.room.util;

import androidx.annotation.RestrictTo;
import com.bytedance.bdinstall.Api;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "UUIDUtil")
public final class UUIDUtil {
    public static final UUID convertByteToUUID(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        ByteBuffer r11 = ByteBuffer.wrap(r10);
        return new UUID(r11.getLong(), r11.getLong());
    }

    public static final byte[] convertUUIDToByte(UUID r10) {
        Intrinsics.checkNotNullParameter(r10, Api.KEY_UUID);
        ByteBuffer r11 = ByteBuffer.wrap(new byte[16]);
        r11.putLong(r10.getMostSignificantBits());
        r11.putLong(r10.getLeastSignificantBits());
        byte[] r12 = r11.array();
        Intrinsics.checkNotNullExpressionValue(r12, "buffer.array()");
        return r12;
    }
}
