package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.builtins;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"readBuiltinsPackageFragment", "Lkotlin/Pair;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/builtins/BuiltInsBinaryVersion;", "Ljava/io/InputStream;", "metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        BuiltInsBinaryVersion r10 = BuiltInsBinaryVersion.Companion.readFrom(r5);     // Catch: Throwable -> L6
        if (r10.isCompatible() == false) goto L8;
        ExtensionRegistryLite r11 = ExtensionRegistryLite.newInstance();     // Catch: Throwable -> L6
        BuiltInsProtoBuf.registerAllExtensions(r11);     // Catch: Throwable -> L6
        ProtoBuf.PackageFragment r12 = ProtoBuf.PackageFragment.parseFrom(r5, r11);     // Catch: Throwable -> L6
    L9:
        Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> r13 = TuplesKt.to(r12, r10);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r5, null);
        return r13;
    L8:
        r12 = null;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }
}
