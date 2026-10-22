package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.impl.WriteContext;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.serialization.JvmStringTable;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"writeProtoBufData", "Lkotlin/Pair;", "", "", "message", "Landroidx/room/jarjarred/kotlinx/metadata/internal/protobuf/MessageLite;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JvmWriteUtilsKt {
    public static final Pair<String[], String[]> writeProtoBufData(MessageLite r5, WriteContext r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r10, "c");
        StringTable r11 = r10.getStrings();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.metadata.jvm.serialization.JvmStringTable");
        JvmStringTable r12 = (JvmStringTable) r11;
        String[] r13 = JvmProtoBufUtil.writeData(r5, r12);
        Object[] r14 = r12.getStrings().toArray(new String[0]);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new Pair(r13, r14);
    }
}
