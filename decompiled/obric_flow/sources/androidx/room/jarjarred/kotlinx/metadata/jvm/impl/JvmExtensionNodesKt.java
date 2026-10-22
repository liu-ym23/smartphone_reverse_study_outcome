package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmClass;
import androidx.room.jarjarred.kotlinx.metadata.KmClassExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmFunction;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackage;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmProperty;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmType;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameter;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeExtension;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmClassExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmConstructorExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPackageExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPropertyExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeParameterExtensionVisitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0006*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\b*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\n*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\f*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u000e*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0010*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmClass;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmClassExtension;", "getJvm", "(Ljava/lang/Object;)Ljava/lang/Object;", "jvm", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructor;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmConstructorExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunction;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmFunctionExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmPackageExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/KmProperty;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmPropertyExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmTypeExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameter;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmTypeParameterExtension;", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JvmExtensionNodesKt {
    public static final JvmClassExtension getJvm(KmClass r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KmClassExtensionVisitor r10 = r5.visitExtensions(JvmClassExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.metadata.jvm.impl.JvmClassExtension");
        return (JvmClassExtension) r10;
    }

    public static final JvmPackageExtension getJvm(KmPackage r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KmPackageExtensionVisitor r10 = r5.visitExtensions(JvmPackageExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.metadata.jvm.impl.JvmPackageExtension");
        return (JvmPackageExtension) r10;
    }

    public static final JvmFunctionExtension getJvm(KmFunction r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KmFunctionExtensionVisitor r10 = r5.visitExtensions(JvmFunctionExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.metadata.jvm.impl.JvmFunctionExtension");
        return (JvmFunctionExtension) r10;
    }

    public static final JvmPropertyExtension getJvm(KmProperty r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KmPropertyExtensionVisitor r10 = r5.visitExtensions(JvmPropertyExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.metadata.jvm.impl.JvmPropertyExtension");
        return (JvmPropertyExtension) r10;
    }

    public static final JvmConstructorExtension getJvm(KmConstructor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KmConstructorExtensionVisitor r10 = r5.visitExtensions(JvmConstructorExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.metadata.jvm.impl.JvmConstructorExtension");
        return (JvmConstructorExtension) r10;
    }

    public static final JvmTypeParameterExtension getJvm(KmTypeParameter r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KmTypeParameterExtensionVisitor r10 = r5.visitExtensions(JvmTypeParameterExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.metadata.jvm.impl.JvmTypeParameterExtension");
        return (JvmTypeParameterExtension) r10;
    }

    public static final JvmTypeExtension getJvm(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KmTypeExtension r10 = r5.visitExtensions(JvmTypeExtensionVisitor.TYPE);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.metadata.jvm.impl.JvmTypeExtension");
        return (JvmTypeExtension) r10;
    }
}
