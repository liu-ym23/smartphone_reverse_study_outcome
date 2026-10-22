package androidx.room.jarjarred.kotlinx.metadata.impl;

import androidx.room.jarjarred.kotlinx.metadata.ExperimentalContextReceivers;
import androidx.room.jarjarred.kotlinx.metadata.KmClassExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmVariance;
import androidx.room.jarjarred.kotlinx.metadata.KmVersionRequirementVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization.StringTable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010 J=\u0010$\u001a\u0004\u0018\u00010#2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000e\u001a\u00020\f2\n\u0010!\u001a\u00060\tj\u0002`\n2\n\u0010\"\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b$\u0010%J%\u0010'\u001a\u0004\u0018\u00010&2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010*J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b,\u0010*J\u001b\u0010-\u001a\u00020\u000f2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016¢\u0006\u0004\b-\u0010*J\u0017\u0010.\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010*J\u001d\u0010/\u001a\u0004\u0018\u00010\u00182\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b/\u0010\u001aJ\u001b\u00100\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0017¢\u0006\u0004\b0\u0010\u001aJ\u0011\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b2\u00103J\u0019\u00107\u001a\u0004\u0018\u0001062\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u000fH\u0016¢\u0006\u0004\b9\u0010:R\u001a\u0010<\u001a\u00020;8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010A\u001a\u00020@8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006E"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/impl/ClassWriter;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/StringTable;", "stringTable", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContextExtension;", "contextExtensions", "<init>", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;Ljava/util/List;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "name", "", "visit", "(ILjava/lang/String;)V", "id", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "visitTypeParameter", "(ILjava/lang/String;ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitSupertype", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "visitConstructor", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "visitFunction", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "getterFlags", "setterFlags", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "visitProperty", "(ILjava/lang/String;II)Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "visitTypeAlias", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "visitCompanionObject", "(Ljava/lang/String;)V", "visitNestedClass", "visitEnumEntry", "visitSealedSubclass", "visitInlineClassUnderlyingPropertyName", "visitInlineClassUnderlyingType", "visitContextReceiverType", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "visitVersionRequirement", "()Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmClassExtensionVisitor;", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class$Builder;", "t", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Class$Builder;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "c", "Landroidx/room/jarjarred/kotlinx/metadata/impl/WriteContext;", "getC", "()Lkotlinx/metadata/impl/e;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class ClassWriter extends KmClassVisitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WriteContext f597c;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ProtoBuf.Class.Builder f598t;

    public ClassWriter(StringTable r5, List<? extends WriteContextExtension> r10) {
        Intrinsics.checkNotNullParameter(r5, "stringTable");
        Intrinsics.checkNotNullParameter(r10, "contextExtensions");
        super(null, 1, null);
        ProtoBuf.Class.Builder r11 = ProtoBuf.Class.newBuilder();
        Intrinsics.checkNotNull(r11);
        this.f598t = r11;
        this.f597c = new WriteContext(r5, r10);
    }

    public final WriteContext getC() {
        return this.f597c;
    }

    public final ProtoBuf.Class.Builder getT() {
        return this.f598t;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visit(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        if (r5 == ProtoBuf.Class.getDefaultInstance().getFlags()) goto L5;
        this.f598t.setFlags(r5);
    L5:
        this.f598t.setFqName(this.f597c.getClassName(r10));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitCompanionObject(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f598t.setCompanionObjectName(this.f597c.get(r5));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmConstructorVisitor visitConstructor(int r5) {
        return WritersKt.access$writeConstructor(this.f597c, r5, new AnonymousClass1(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int r5) {
        return WritersKt.access$writeType(this.f597c, r5, new C01051(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitEnd() {
        ProtoBuf.VersionRequirementTable r5 = this.f597c.getVersionRequirements().serialize();
        if (r5 == null) goto L6;
        this.f598t.setVersionRequirementTable(r5);
        return;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitEnumEntry(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        ProtoBuf.Class.Builder r10 = this.f598t;
        ProtoBuf.EnumEntry.Builder r11 = ProtoBuf.EnumEntry.newBuilder();
        r11.setName(this.f597c.get(r5));
        r10.addEnumEntry(r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor, androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public /* bridge */ /* synthetic */ KmDeclarationContainerExtensionVisitor visitExtensions(KmExtensionType r5) {
        return visitExtensions(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return WritersKt.access$writeFunction(this.f597c, r5, r10, new C01071(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitInlineClassUnderlyingPropertyName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f598t.setInlineClassUnderlyingPropertyName(this.f597c.get(r5));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmTypeVisitor visitInlineClassUnderlyingType(int r5) {
        return WritersKt.access$writeType(this.f597c, r5, new C01081(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitNestedClass(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f598t.addNestedClassName(this.f597c.get(r5));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPropertyVisitor visitProperty(int r10, String r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "name");
        return WritersKt.writeProperty(this.f597c, r10, r11, r12, r13, new C01091(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitSealedSubclass(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f598t.addSealedSubclassFqName(this.f597c.getClassName(r5));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmTypeVisitor visitSupertype(int r5) {
        return WritersKt.access$writeType(this.f597c, r5, new C01101(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmTypeAliasVisitor visitTypeAlias(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return WritersKt.access$writeTypeAlias(this.f597c, r5, r10, new C01111(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmTypeParameterVisitor visitTypeParameter(int r10, String r11, int r12, KmVariance r13) {
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r13, "variance");
        return WritersKt.access$writeTypeParameter(this.f597c, r10, r11, r12, r13, new C01121(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return WritersKt.access$writeVersionRequirement(this.f597c, new C01131(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor, androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmClassExtensionVisitor visitExtensions(final KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmClassExtensionVisitor) ExtensionUtilsKt.applySingleExtension(r5, new C01061(r5, this));
    }

    public /* synthetic */ ClassWriter(StringTable r5, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        this(r5, r10);
    }
}
