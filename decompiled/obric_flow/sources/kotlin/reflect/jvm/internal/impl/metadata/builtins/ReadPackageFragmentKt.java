package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nreadPackageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 readPackageFragment.kt\norg/jetbrains/kotlin/metadata/builtins/ReadPackageFragmentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        BuiltInsBinaryVersion r10 = BuiltInsBinaryVersion.Companion.readFrom(r5);     // Catch: Throwable -> L6
        if (r10.isCompatibleWithCurrentCompilerVersion() == false) goto L8;
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
