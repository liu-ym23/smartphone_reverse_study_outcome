package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf$PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        BuiltInsBinaryVersion r0 = BuiltInsBinaryVersion.Companion.readFrom(r3);     // Catch: Throwable -> L10
        if (r0.isCompatibleWithCurrentCompilerVersion() == false) goto L6;
        ExtensionRegistryLite r1 = ExtensionRegistryLite.newInstance();     // Catch: Throwable -> L10
        BuiltInsProtoBuf.registerAllExtensions(r1);     // Catch: Throwable -> L10
        ProtoBuf$PackageFragment r2 = ProtoBuf$PackageFragment.parseFrom(r3, r1);     // Catch: Throwable -> L10
    L7:
        Pair<ProtoBuf$PackageFragment, BuiltInsBinaryVersion> r4 = TuplesKt.to(r2, r0);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r3, null);
        return r4;
    L6:
        r2 = null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }
}
