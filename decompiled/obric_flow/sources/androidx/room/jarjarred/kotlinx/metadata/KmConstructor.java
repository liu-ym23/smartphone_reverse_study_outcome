package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmConstructorExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006!"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmConstructor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "(I)V", "extensions", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmConstructorExtension;", "getFlags", "()I", "setFlags", "valueParameters", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameter;", "getValueParameters", "()Ljava/util/List;", "versionRequirements", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirement;", "getVersionRequirements", "accept", "", "visitor", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitValueParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "name", "", "visitVersionRequirement", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmConstructor extends KmConstructorVisitor {
    private final List<KmConstructorExtension> extensions;
    private int flags;
    private final List<KmValueParameter> valueParameters;
    private final List<KmVersionRequirement> versionRequirements;

    public KmConstructor(int r5) {
        super(null, 1, null);
        this.flags = r5;
        this.valueParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> r10 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((MetadataExtensions) r12.next()).createConstructorExtension());
        goto L4
    L6:
        this.extensions = r11;
    }

    public final void accept(KmConstructorVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        Iterator<T> r10 = this.valueParameters.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        KmValueParameter r11 = (KmValueParameter) r10.next();
        KmValueParameterVisitor r12 = r5.visitValueParameter(r11.getFlags(), r11.getName());
        if (r12 == null) goto L4;
        r11.accept(r12);
        goto L4
    L8:
        Iterator<T> r13 = this.versionRequirements.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        KmVersionRequirement r14 = (KmVersionRequirement) r13.next();
        KmVersionRequirementVisitor r15 = r5.visitVersionRequirement();
        if (r15 == null) goto L10;
        r14.accept(r15);
        goto L10
    L14:
        Iterator<T> r16 = this.extensions.iterator();
    L16:
        if (r16.hasNext() == false) goto L20;
        KmConstructorExtension r17 = (KmConstructorExtension) r16.next();
        KmConstructorExtensionVisitor r18 = r5.visitExtensions(r17.getType());
        if (r18 == null) goto L16;
        r17.accept(r18);
        goto L16
    L20:
        r5.visitEnd();
    }

    public final int getFlags() {
        return this.flags;
    }

    public final List<KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
    public KmConstructorExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmConstructorExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
    public KmValueParameterVisitor visitValueParameter(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return (KmValueParameterVisitor) NodesKt.addTo(new KmValueParameter(r5, r10), this.valueParameters);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }
}
