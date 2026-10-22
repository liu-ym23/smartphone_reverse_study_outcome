package androidx.room.util;

import com.bytedance.bdinstall.Api;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"convertByteToUUID", "Ljava/util/UUID;", "bytes", "", "convertUUIDToByte", Api.KEY_UUID, "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UUIDUtil {
    public static final UUID convertByteToUUID(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "bytes");
        ByteBuffer r5 = ByteBuffer.wrap(r4);
        return new UUID(r5.getLong(), r5.getLong());
    }

    public static final byte[] convertUUIDToByte(UUID r3) {
        Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
        ByteBuffer r0 = ByteBuffer.wrap(new byte[16]);
        r0.putLong(r3.getMostSignificantBits());
        r0.putLong(r3.getLeastSignificantBits());
        byte[] r4 = r0.array();
        Intrinsics.checkNotNullExpressionValue(r4, "buffer.array()");
        return r4;
    }
}
