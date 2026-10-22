package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.BinaryVersion;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.VersionSpecificBehaviorKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"internalNameOf", "", "packageFqName", "className", "serializeToByteArray", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmModuleProtoBuf$Module;", "version", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/BinaryVersion;", "flags", "", "metadata.jvm"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ModuleMappingKt {
    public static final /* synthetic */ String access$internalNameOf(String r5, String r10) {
        return internalNameOf(r5, r10);
    }

    private static final String internalNameOf(String r5, String r10) {
        if (r5.length() != 0) goto L6;
        return r10;
    L6:
        return StringsKt.E(r5, '.', '/') + '/' + r10;
    }

    public static final byte[] serializeToByteArray(JvmModuleProtoBuf.Module r10, BinaryVersion r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "version");
        ByteArrayOutputStream r5 = new ByteArrayOutputStream(4096);
        DataOutputStream r13 = new DataOutputStream(r5);
        int[] r14 = r11.toArray();
        r13.writeInt(r14.length);
        int r15 = r14.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L6;
        r13.writeInt(r14[r16]);
        r16 = r16 + 1;
        goto L3
    L6:
        if (VersionSpecificBehaviorKt.isKotlin1Dot4OrLater(r11) == false) goto L8;
        r13.writeInt(r12);
    L8:
        r10.writeTo(r13);
        r13.flush();
        return r5.toByteArray();
    }
}
