package androidx.room.jarjarred.kotlinx.metadata.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"wrapAsPublic", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature$Field;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmMemberSignature$Method;", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JvmMemberSignatureKt {
    public static final JvmMethodSignature wrapAsPublic(androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature.Method r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new JvmMethodSignature(r5.getName(), r5.getDesc());
    }

    public static final JvmFieldSignature wrapAsPublic(androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature.Field r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new JvmFieldSignature(r5.getName(), r5.getDesc());
    }
}
