package androidx.room.util;

import androidx.annotation.RestrictTo;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"convertByteToUUID", "Ljava/util/UUID;", "bytes", "", "convertUUIDToByte", "uuid", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "UUIDUtil")
public final class UUIDUtil {
    public static final UUID convertByteToUUID(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        ByteBuffer r10 = ByteBuffer.wrap(r5);
        return new UUID(r10.getLong(), r10.getLong());
    }

    public static final byte[] convertUUIDToByte(UUID r5) {
        Intrinsics.checkNotNullParameter(r5, "uuid");
        ByteBuffer r10 = ByteBuffer.wrap(new byte[16]);
        r10.putLong(r5.getMostSignificantBits());
        r10.putLong(r5.getLeastSignificantBits());
        return r10.array();
    }
}
