package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmFunctionExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\r\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0017¢\u0006\u0004\b\u0012\u0010\u0011J#\u0010\u0014\u001a\u00020\u00132\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\b$\u0010%R&\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001d\u00102\u001a\b\u0012\u0004\u0012\u000201008\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R&\u0010=\u001a\b\u0012\u0004\u0012\u000206008\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b=\u00103\u0012\u0004\b?\u0010@\u001a\u0004\b>\u00105R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020A008\u0006¢\u0006\f\n\u0004\bB\u00103\u001a\u0004\bC\u00105R\"\u0010D\u001a\u0002068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bD\u00108\u001a\u0004\bE\u0010:\"\u0004\bF\u0010<R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020G008\u0006¢\u0006\f\n\u0004\bH\u00103\u001a\u0004\bI\u00105R$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u00103¨\u0006R"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmFunction;", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "<init>", "(ILjava/lang/String;)V", "id", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "visitTypeParameter", "(ILjava/lang/String;ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitReceiverParameterType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitContextReceiverType", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitValueParameter", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitReturnType", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "visitVersionRequirement", "()Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "visitContract", "()Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "visitor", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;)V", "I", "getFlags", "()I", "setFlags", "(I)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameter;", "typeParameters", "Ljava/util/List;", "getTypeParameters", "()Ljava/util/List;", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "receiverParameterType", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getReceiverParameterType", "()Ljava/lang/Object;", "setReceiverParameterType", "(Ljava/lang/Object;)V", "contextReceiverTypes", "getContextReceiverTypes", "getContextReceiverTypes$annotations", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameter;", "valueParameters", "getValueParameters", "returnType", "getReturnType", "setReturnType", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirement;", "versionRequirements", "getVersionRequirements", "Landroidx/room/jarjarred/kotlinx/metadata/KmContract;", "contract", "Landroidx/room/jarjarred/kotlinx/metadata/KmContract;", "getContract", "setContract", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmFunctionExtension;", "extensions", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmFunction extends KmFunctionVisitor {
    private final List<KmType> contextReceiverTypes;
    private KmContract contract;
    private final List<KmFunctionExtension> extensions;
    private int flags;
    private String name;
    private KmType receiverParameterType;
    public KmType returnType;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmValueParameter> valueParameters;
    private final List<KmVersionRequirement> versionRequirements;

    public KmFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        super(null, 1, null);
        this.flags = r5;
        this.name = r10;
        this.typeParameters = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.valueParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> r11 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(((MetadataExtensions) r13.next()).createFunctionExtension());
        goto L4
    L6:
        this.extensions = r12;
    }

    @ExperimentalContextReceivers
    public static /* synthetic */ void getContextReceiverTypes$annotations() {
    }

    public final void accept(KmFunctionVisitor r10) {
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
        Iterator<T> r18 = this.valueParameters.iterator();
    L21:
        if (r18.hasNext() == false) goto L25;
        KmValueParameter r19 = (KmValueParameter) r18.next();
        KmValueParameterVisitor r20 = r10.visitValueParameter(r19.getFlags(), r19.getName());
        if (r20 == null) goto L21;
        r19.accept(r20);
        goto L21
    L25:
        KmTypeVisitor r21 = r10.visitReturnType(getReturnType().getFlags());
        if (r21 == null) goto L28;
        getReturnType().accept(r21);
    L28:
        Iterator<T> r22 = this.versionRequirements.iterator();
    L30:
        if (r22.hasNext() == false) goto L34;
        KmVersionRequirement r23 = (KmVersionRequirement) r22.next();
        KmVersionRequirementVisitor r24 = r10.visitVersionRequirement();
        if (r24 == null) goto L30;
        r23.accept(r24);
        goto L30
    L34:
        KmContract r25 = this.contract;
        if (r25 == null) goto L39;
        KmContractVisitor r26 = r10.visitContract();
        if (r26 == null) goto L39;
        r25.accept(r26);
    L39:
        Iterator<T> r27 = this.extensions.iterator();
    L41:
        if (r27.hasNext() == false) goto L45;
        KmFunctionExtension r28 = (KmFunctionExtension) r27.next();
        KmFunctionExtensionVisitor r29 = r10.visitExtensions(r28.getType());
        if (r29 == null) goto L41;
        r28.accept(r29);
        goto L41
    L45:
        r10.visitEnd();
    }

    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final KmContract getContract() {
        return this.contract;
    }

    public final int getFlags() {
        return this.flags;
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

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final List<KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setContract(KmContract r5) {
        this.contract = r5;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
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

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int r5) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(r5), this.contextReceiverTypes);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
    public KmContractVisitor visitContract() {
        KmContract r5 = new KmContract();
        this.contract = r5;
        return r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
    public KmFunctionExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmFunctionExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
    public KmTypeVisitor visitReceiverParameterType(int r5) {
        KmType r10 = new KmType(r5);
        this.receiverParameterType = r10;
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
    public KmTypeVisitor visitReturnType(int r5) {
        KmType r10 = new KmType(r5);
        setReturnType(r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
    public KmTypeParameterVisitor visitTypeParameter(int r5, String r10, int r11, KmVariance r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "variance");
        return (KmTypeParameterVisitor) NodesKt.addTo(new KmTypeParameter(r5, r10, r11, r12), this.typeParameters);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
    public KmValueParameterVisitor visitValueParameter(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return (KmValueParameterVisitor) NodesKt.addTo(new KmValueParameter(r5, r10), this.valueParameters);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }
}
