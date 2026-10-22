package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: loaded from: classes3.dex */
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        BuiltInsBinaryVersion r11 = BuiltInsBinaryVersion.Companion.readFrom(r10);     // Catch: Throwable -> L10
        if (r11.isCompatible() == false) goto L6;
        ExtensionRegistryLite r12 = ExtensionRegistryLite.newInstance();     // Catch: Throwable -> L10
        BuiltInsProtoBuf.registerAllExtensions(r12);     // Catch: Throwable -> L10
        ProtoBuf.PackageFragment r13 = ProtoBuf.PackageFragment.parseFrom(r10, r12);     // Catch: Throwable -> L10
    L7:
        Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> r14 = TuplesKt.to(r13, r11);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r10, null);
        return r14;
    L6:
        r13 = null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }
}
