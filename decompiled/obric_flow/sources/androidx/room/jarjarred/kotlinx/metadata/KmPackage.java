package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmPackageExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J4\u0010 \u001a\u00020!2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\"\u001a\u00060\u001cj\u0002`\u001d2\n\u0010#\u001a\u00060\u001cj\u0002`\u001dH\u0016J\u001c\u0010$\u001a\u00020%2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006&"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmPackage;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainer;", "()V", "extensions", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmPackageExtension;", "functions", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunction;", "getFunctions", "()Ljava/util/List;", "properties", "Landroidx/room/jarjarred/kotlinx/metadata/KmProperty;", "getProperties", "typeAliases", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAlias;", "getTypeAliases", "accept", "", "visitor", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitFunction", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "name", "", "visitProperty", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "getterFlags", "setterFlags", "visitTypeAlias", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmPackage extends KmPackageVisitor implements KmDeclarationContainer {
    private final List<KmPackageExtension> extensions;
    private final List<KmFunction> functions;
    private final List<KmProperty> properties;
    private final List<KmTypeAlias> typeAliases;

    public KmPackage() {
        super(null, 1, null);
        this.functions = new ArrayList();
        this.properties = new ArrayList();
        this.typeAliases = new ArrayList(0);
        List<MetadataExtensions> r5 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((MetadataExtensions) r11.next()).createPackageExtension());
        goto L4
    L6:
        this.extensions = r10;
    }

    public final void accept(KmPackageVisitor r10) {
        Intrinsics.checkNotNullParameter(r10, "visitor");
        Iterator<T> r5 = getFunctions().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        KmFunction r11 = (KmFunction) r5.next();
        KmFunctionVisitor r12 = r10.visitFunction(r11.getFlags(), r11.getName());
        if (r12 == null) goto L4;
        r11.accept(r12);
        goto L4
    L8:
        Iterator<T> r13 = getProperties().iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        KmProperty r14 = (KmProperty) r13.next();
        KmPropertyVisitor r15 = r10.visitProperty(r14.getFlags(), r14.getName(), r14.getGetterFlags(), r14.getSetterFlags());
        if (r15 == null) goto L10;
        r14.accept(r15);
        goto L10
    L14:
        Iterator<T> r16 = getTypeAliases().iterator();
    L16:
        if (r16.hasNext() == false) goto L20;
        KmTypeAlias r17 = (KmTypeAlias) r16.next();
        KmTypeAliasVisitor r18 = r10.visitTypeAlias(r17.getFlags(), r17.getName());
        if (r18 == null) goto L16;
        r17.accept(r18);
        goto L16
    L20:
        Iterator<T> r19 = this.extensions.iterator();
    L22:
        if (r19.hasNext() == false) goto L26;
        KmPackageExtension r20 = (KmPackageExtension) r19.next();
        KmPackageExtensionVisitor r21 = r10.visitExtensions(r20.getType());
        if (r21 == null) goto L22;
        r20.accept(r21);
        goto L22
    L26:
        r10.visitEnd();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainer
    public List<KmFunction> getFunctions() {
        return this.functions;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainer
    public List<KmProperty> getProperties() {
        return this.properties;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainer
    public List<KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor, androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public /* bridge */ /* synthetic */ KmDeclarationContainerExtensionVisitor visitExtensions(KmExtensionType r5) {
        return visitExtensions(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return (KmFunctionVisitor) NodesKt.addTo(new KmFunction(r5, r10), getFunctions());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPropertyVisitor visitProperty(int r5, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return (KmPropertyVisitor) NodesKt.addTo(new KmProperty(r5, r10, r11, r12), getProperties());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmTypeAliasVisitor visitTypeAlias(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return (KmTypeAliasVisitor) NodesKt.addTo(new KmTypeAlias(r5, r10), getTypeAliases());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPackageVisitor, androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPackageExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmPackageExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }
}
