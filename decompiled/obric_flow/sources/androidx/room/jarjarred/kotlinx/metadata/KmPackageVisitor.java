package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainerVisitor;", "delegate", "<init>", "(Lkotlinx/metadata/impl/d;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmPackageExtensionVisitor;", "", "visitEnd", "()V", "getDelegate", "()Lkotlinx/metadata/impl/d;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmPackageVisitor extends KmDeclarationContainerVisitor {
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmPackageVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public /* bridge */ /* synthetic */ KmDeclarationContainerVisitor getDelegate() {
        return getDelegate();
    }

    public void visitEnd() {
        KmPackageVisitor r5 = getDelegate();
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public /* bridge */ /* synthetic */ KmDeclarationContainerExtensionVisitor visitExtensions(KmExtensionType r5) {
        return visitExtensions(r5);
    }

    @JvmOverloads
    public KmPackageVisitor(KmPackageVisitor r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPackageVisitor getDelegate() {
        return (KmPackageVisitor) super.getDelegate();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPackageExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        KmPackageVisitor r10 = getDelegate();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitExtensions(r5);
    }

    public /* synthetic */ KmPackageVisitor(KmPackageVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
