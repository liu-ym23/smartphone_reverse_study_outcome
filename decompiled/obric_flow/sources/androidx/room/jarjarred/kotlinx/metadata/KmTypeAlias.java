package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeAliasExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\r\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"R&\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b:\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130-8\u0006¢\u0006\f\n\u0004\b=\u00100\u001a\u0004\b>\u00102R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020?0-8\u0006¢\u0006\f\n\u0004\b@\u00100\u001a\u0004\bA\u00102R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00100¨\u0006E"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAlias;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "<init>", "(ILjava/lang/String;)V", "id", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "visitTypeParameter", "(ILjava/lang/String;ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitUnderlyingType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitExpandedType", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "annotation", "", "visitAnnotation", "(Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "visitVersionRequirement", "()Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "visitor", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;)V", "I", "getFlags", "()I", "setFlags", "(I)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameter;", "typeParameters", "Ljava/util/List;", "getTypeParameters", "()Ljava/util/List;", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "underlyingType", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getUnderlyingType", "()Ljava/lang/Object;", "setUnderlyingType", "(Ljava/lang/Object;)V", "expandedType", "getExpandedType", "setExpandedType", "annotations", "getAnnotations", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirement;", "versionRequirements", "getVersionRequirements", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeAliasExtension;", "extensions", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmTypeAlias extends KmTypeAliasVisitor {
    private final List<KmAnnotation> annotations;
    public KmType expandedType;
    private final List<KmTypeAliasExtension> extensions;
    private int flags;
    private String name;
    private final List<KmTypeParameter> typeParameters;
    public KmType underlyingType;
    private final List<KmVersionRequirement> versionRequirements;

    public KmTypeAlias(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        super(null, 1, null);
        this.flags = r5;
        this.name = r10;
        this.typeParameters = new ArrayList(0);
        this.annotations = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> r11 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        KmTypeAliasExtension r14 = ((MetadataExtensions) r13.next()).createTypeAliasExtension();
        if (r14 == null) goto L4;
        r12.add(r14);
        goto L4
    L8:
        this.extensions = r12;
    }

    public final void accept(KmTypeAliasVisitor r10) {
        Intrinsics.checkNotNullParameter(r10, "visitor");
        Iterator<T> r5 = this.typeParameters.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        KmTypeParameter r11 = (KmTypeParameter) r5.next();
        KmTypeParameterVisitor r12 = r10.visitTypeParameter(r11.getFlags(), r11.getName(), r11.getId(), r11.getVariance());
        if (r12 == null) goto L4;
        r11.accept(r12);
        goto L4
    L8:
        KmTypeVisitor r13 = r10.visitUnderlyingType(getUnderlyingType().getFlags());
        if (r13 == null) goto L11;
        getUnderlyingType().accept(r13);
    L11:
        KmTypeVisitor r14 = r10.visitExpandedType(getExpandedType().getFlags());
        if (r14 == null) goto L14;
        getExpandedType().accept(r14);
    L14:
        Iterator<T> r15 = this.annotations.iterator();
    L16:
        if (r15.hasNext() == false) goto L18;
        r10.visitAnnotation((KmAnnotation) r15.next());
        goto L16
    L18:
        Iterator<T> r16 = this.versionRequirements.iterator();
    L20:
        if (r16.hasNext() == false) goto L24;
        KmVersionRequirement r17 = (KmVersionRequirement) r16.next();
        KmVersionRequirementVisitor r18 = r10.visitVersionRequirement();
        if (r18 == null) goto L20;
        r17.accept(r18);
        goto L20
    L24:
        Iterator<T> r19 = this.extensions.iterator();
    L26:
        if (r19.hasNext() == false) goto L30;
        KmTypeAliasExtension r20 = (KmTypeAliasExtension) r19.next();
        KmTypeAliasExtensionVisitor r21 = r10.visitExtensions(r20.getType());
        if (r21 == null) goto L26;
        r20.accept(r21);
        goto L26
    L30:
        r10.visitEnd();
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final KmType getExpandedType() {
        KmType r5 = this.expandedType;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("expandedType");
        return null;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final String getName() {
        return this.name;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final KmType getUnderlyingType() {
        KmType r5 = this.underlyingType;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
        return null;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setExpandedType(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.expandedType = r5;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
    }

    public final void setName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.name = r5;
    }

    public final void setUnderlyingType(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.underlyingType = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
    public void visitAnnotation(KmAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        this.annotations.add(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
    public KmTypeVisitor visitExpandedType(int r5) {
        KmType r10 = new KmType(r5);
        setExpandedType(r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
    public KmTypeAliasExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmTypeAliasExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
    public KmTypeParameterVisitor visitTypeParameter(int r5, String r10, int r11, KmVariance r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "variance");
        return (KmTypeParameterVisitor) NodesKt.addTo(new KmTypeParameter(r5, r10, r11, r12), this.typeParameters);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
    public KmTypeVisitor visitUnderlyingType(int r5) {
        KmType r10 = new KmType(r5);
        setUnderlyingType(r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeAliasVisitor
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }
}
