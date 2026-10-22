package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0011\u001a\u00060\tj\u0002`\n2\n\u0010\u0012\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020!8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020&8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/PackageWriter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/StringTable;", "stringTable", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContextExtension;", "contextExtensions", "<init>", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;Ljava/util/List;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "visitFunction", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "getterFlags", "setterFlags", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "visitProperty", "(ILjava/lang/String;II)Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "visitTypeAlias", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmPackageExtensionVisitor;", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package$Builder;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Package$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Package$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "getC", "()Lkotlinx/metadata/impl/e;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class PackageWriter extends KmPackageVisitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WriteContext f603c;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ProtoBuf.Package.Builder f604t;

    public PackageWriter(StringTable r5, List<? extends WriteContextExtension> r10) {
        Intrinsics.checkNotNullParameter(r5, "stringTable");
        Intrinsics.checkNotNullParameter(r10, "contextExtensions");
        super(null, 1, null);
        ProtoBuf.Package.Builder r11 = ProtoBuf.Package.newBuilder();
        Intrinsics.checkNotNull(r11);
        this.f604t = r11;
        this.f603c = new WriteContext(r5, r10);
    }

    public final WriteContext getC() {
        return this.f603c;
    }

    public final ProtoBuf.Package.Builder getT() {
        return this.f604t;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor
    public void visitEnd() {
        ProtoBuf.VersionRequirementTable r5 = this.f603c.getVersionRequirements().serialize();
        if (r5 == null) goto L6;
        this.f604t.setVersionRequirementTable(r5);
        return;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor, androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public /* bridge */ /* synthetic */ KmDeclarationContainerExtensionVisitor visitExtensions(KmExtensionType r5) {
        return visitExtensions(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return WritersKt.access$writeFunction(this.f603c, r5, r10, new C01161(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPropertyVisitor visitProperty(int r10, String r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "name");
        return WritersKt.writeProperty(this.f603c, r10, r11, r12, r13, new C01171(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmTypeAliasVisitor visitTypeAlias(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return WritersKt.access$writeTypeAlias(this.f603c, r5, r10, new C01181(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor, androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPackageExtensionVisitor visitExtensions(final KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmPackageExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new AnonymousClass1(r5, this));
    }

    public /* synthetic */ PackageWriter(StringTable r5, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        this(r5, r10);
    }
}
