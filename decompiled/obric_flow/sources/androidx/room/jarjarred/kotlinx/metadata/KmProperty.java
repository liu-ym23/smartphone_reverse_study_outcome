package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmPropertyExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\t\u0010\nJ3\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00112\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0017¢\u0006\u0004\b\u0014\u0010\u0013J#\u0010\u0016\u001a\u00020\u00152\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00112\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0001¢\u0006\u0004\b#\u0010$R&\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\b/\u0010'\"\u0004\b0\u0010)R&\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001d\u00105\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R&\u0010@\u001a\b\u0012\u0004\u0012\u000209038\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b@\u00106\u0012\u0004\bB\u0010C\u001a\u0004\bA\u00108R$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010=\"\u0004\bH\u0010?R\"\u0010I\u001a\u0002098\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bI\u0010;\u001a\u0004\bJ\u0010=\"\u0004\bK\u0010?R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020L038\u0006¢\u0006\f\n\u0004\bM\u00106\u001a\u0004\bN\u00108R\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u00106¨\u0006R"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmProperty;", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "getterFlags", "setterFlags", "<init>", "(ILjava/lang/String;II)V", "id", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "visitTypeParameter", "(ILjava/lang/String;ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitReceiverParameterType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitContextReceiverType", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitSetterParameter", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitReturnType", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "visitVersionRequirement", "()Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;", "visitor", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;)V", "I", "getFlags", "()I", "setFlags", "(I)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getGetterFlags", "setGetterFlags", "getSetterFlags", "setSetterFlags", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameter;", "typeParameters", "Ljava/util/List;", "getTypeParameters", "()Ljava/util/List;", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "receiverParameterType", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getReceiverParameterType", "()Ljava/lang/Object;", "setReceiverParameterType", "(Ljava/lang/Object;)V", "contextReceiverTypes", "getContextReceiverTypes", "getContextReceiverTypes$annotations", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameter;", "setterParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameter;", "getSetterParameter", "setSetterParameter", "returnType", "getReturnType", "setReturnType", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirement;", "versionRequirements", "getVersionRequirements", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmPropertyExtension;", "extensions", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmProperty extends KmPropertyVisitor {
    private final List<KmType> contextReceiverTypes;
    private final List<KmPropertyExtension> extensions;
    private int flags;
    private int getterFlags;
    private String name;
    private KmType receiverParameterType;
    public KmType returnType;
    private int setterFlags;
    private KmValueParameter setterParameter;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmVersionRequirement> versionRequirements;

    public KmProperty(int r5, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        super(null, 1, null);
        this.flags = r5;
        this.name = r10;
        this.getterFlags = r11;
        this.setterFlags = r12;
        this.typeParameters = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> r13 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r14.add(((MetadataExtensions) r15.next()).createPropertyExtension());
        goto L4
    L6:
        this.extensions = r14;
    }

    @ExperimentalContextReceivers
    public static /* synthetic */ void getContextReceiverTypes$annotations() {
    }

    public final void accept(KmPropertyVisitor r10) {
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
        KmType r13 = this.receiverParameterType;
        if (r13 == null) goto L13;
        KmTypeVisitor r14 = r10.visitReceiverParameterType(r13.getFlags());
        if (r14 == null) goto L13;
        r13.accept(r14);
    L13:
        Iterator<T> r15 = this.contextReceiverTypes.iterator();
    L15:
        if (r15.hasNext() == false) goto L19;
        KmType r16 = (KmType) r15.next();
        KmTypeVisitor r17 = r10.visitContextReceiverType(r16.getFlags());
        if (r17 == null) goto L15;
        r16.accept(r17);
        goto L15
    L19:
        KmValueParameter r18 = this.setterParameter;
        if (r18 == null) goto L24;
        KmValueParameterVisitor r19 = r10.visitSetterParameter(r18.getFlags(), r18.getName());
        if (r19 == null) goto L24;
        r18.accept(r19);
    L24:
        KmTypeVisitor r20 = r10.visitReturnType(getReturnType().getFlags());
        if (r20 == null) goto L27;
        getReturnType().accept(r20);
    L27:
        Iterator<T> r21 = this.versionRequirements.iterator();
    L29:
        if (r21.hasNext() == false) goto L33;
        KmVersionRequirement r22 = (KmVersionRequirement) r21.next();
        KmVersionRequirementVisitor r23 = r10.visitVersionRequirement();
        if (r23 == null) goto L29;
        r22.accept(r23);
        goto L29
    L33:
        Iterator<T> r24 = this.extensions.iterator();
    L35:
        if (r24.hasNext() == false) goto L39;
        KmPropertyExtension r25 = (KmPropertyExtension) r24.next();
        KmPropertyExtensionVisitor r26 = r10.visitExtensions(r25.getType());
        if (r26 == null) goto L35;
        r25.accept(r26);
        goto L35
    L39:
        r10.visitEnd();
    }

    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final int getGetterFlags() {
        return this.getterFlags;
    }

    public final String getName() {
        return this.name;
    }

    public final KmType getReceiverParameterType() {
        return this.receiverParameterType;
    }

    public final KmType getReturnType() {
        KmType r5 = this.returnType;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("returnType");
        return null;
    }

    public final int getSetterFlags() {
        return this.setterFlags;
    }

    public final KmValueParameter getSetterParameter() {
        return this.setterParameter;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
    }

    public final void setGetterFlags(int r5) {
        this.getterFlags = r5;
    }

    public final void setName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.name = r5;
    }

    public final void setReceiverParameterType(KmType r5) {
        this.receiverParameterType = r5;
    }

    public final void setReturnType(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.returnType = r5;
    }

    public final void setSetterFlags(int r5) {
        this.setterFlags = r5;
    }

    public final void setSetterParameter(KmValueParameter r5) {
        this.setterParameter = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int r5) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(r5), this.contextReceiverTypes);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
    public KmPropertyExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmPropertyExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
    public KmTypeVisitor visitReceiverParameterType(int r5) {
        KmType r10 = new KmType(r5);
        this.receiverParameterType = r10;
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
    public KmTypeVisitor visitReturnType(int r5) {
        KmType r10 = new KmType(r5);
        setReturnType(r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
    public KmValueParameterVisitor visitSetterParameter(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmValueParameter r11 = new KmValueParameter(r5, r10);
        this.setterParameter = r11;
        return r11;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
    public KmTypeParameterVisitor visitTypeParameter(int r5, String r10, int r11, KmVariance r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "variance");
        return (KmTypeParameterVisitor) NodesKt.addTo(new KmTypeParameter(r5, r10, r11, r12), this.typeParameters);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }
}
