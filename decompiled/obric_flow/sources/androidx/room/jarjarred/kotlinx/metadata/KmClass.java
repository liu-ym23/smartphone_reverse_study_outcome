package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.ExtensionUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmClassExtension;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.MetadataExtensions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0012\u001a\u00020\u00112\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u00142\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0018\u001a\u00020\u00172\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010\u001d\u001a\u00020\u001c2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\n\u001a\u00020\b2\n\u0010\u001a\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u001b\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010 \u001a\u00020\u001f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010!J\u001b\u0010#\u001a\u00020\"2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010&J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010&J\u001b\u0010)\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b)\u0010&J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010&J\u001b\u0010+\u001a\u00020\u00142\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b+\u0010\u0016J\u001b\u0010,\u001a\u00020\u00142\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0017¢\u0006\u0004\b,\u0010\u0016J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b3\u00104J\u0015\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0001¢\u0006\u0004\b6\u00107R&\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R&\u0010\n\u001a\u00060\bj\u0002`\t8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010&R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020B0A8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020G0A8\u0006¢\u0006\f\n\u0004\bH\u0010D\u001a\u0004\bI\u0010FR \u0010K\u001a\b\u0012\u0004\u0012\u00020J0A8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bK\u0010D\u001a\u0004\bL\u0010FR \u0010N\u001a\b\u0012\u0004\u0012\u00020M0A8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bN\u0010D\u001a\u0004\bO\u0010FR \u0010Q\u001a\b\u0012\u0004\u0012\u00020P0A8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bQ\u0010D\u001a\u0004\bR\u0010FR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020S0A8\u0006¢\u0006\f\n\u0004\bT\u0010D\u001a\u0004\bU\u0010FR$\u0010V\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010=\u001a\u0004\bW\u0010?\"\u0004\bX\u0010&R\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\b0A8\u0006¢\u0006\f\n\u0004\bY\u0010D\u001a\u0004\bZ\u0010FR\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020\b0A8\u0006¢\u0006\f\n\u0004\b[\u0010D\u001a\u0004\b\\\u0010FR!\u0010]\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0A8\u0006¢\u0006\f\n\u0004\b]\u0010D\u001a\u0004\b^\u0010FR$\u0010_\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010=\u001a\u0004\b`\u0010?\"\u0004\ba\u0010&R$\u0010b\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR&\u0010h\u001a\b\u0012\u0004\u0012\u00020G0A8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bh\u0010D\u0012\u0004\bj\u0010\u0004\u001a\u0004\bi\u0010FR\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020k0A8\u0006¢\u0006\f\n\u0004\bl\u0010D\u001a\u0004\bm\u0010FR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020o0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010D¨\u0006q"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmClass;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainer;", "<init>", "()V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "name", "", "visit", "(ILjava/lang/String;)V", "id", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "visitTypeParameter", "(ILjava/lang/String;ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitSupertype", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "visitFunction", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "getterFlags", "setterFlags", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "visitProperty", "(ILjava/lang/String;II)Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "visitTypeAlias", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "visitConstructor", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "visitCompanionObject", "(Ljava/lang/String;)V", "visitNestedClass", "visitEnumEntry", "visitSealedSubclass", "visitInlineClassUnderlyingPropertyName", "visitInlineClassUnderlyingType", "visitContextReceiverType", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "visitVersionRequirement", "()Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmClassExtensionVisitor;", "visitor", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;)V", "I", "getFlags", "()I", "setFlags", "(I)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameter;", "typeParameters", "Ljava/util/List;", "getTypeParameters", "()Ljava/util/List;", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "supertypes", "getSupertypes", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunction;", "functions", "getFunctions", "Landroidx/room/jarjarred/kotlinx/metadata/KmProperty;", "properties", "getProperties", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAlias;", "typeAliases", "getTypeAliases", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructor;", "constructors", "getConstructors", "companionObject", "getCompanionObject", "setCompanionObject", "nestedClasses", "getNestedClasses", "enumEntries", "getEnumEntries", "sealedSubclasses", "getSealedSubclasses", "inlineClassUnderlyingPropertyName", "getInlineClassUnderlyingPropertyName", "setInlineClassUnderlyingPropertyName", "inlineClassUnderlyingType", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "getInlineClassUnderlyingType", "()Ljava/lang/Object;", "setInlineClassUnderlyingType", "(Ljava/lang/Object;)V", "contextReceiverTypes", "getContextReceiverTypes", "getContextReceiverTypes$annotations", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirement;", "versionRequirements", "getVersionRequirements", "", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmClassExtension;", "extensions", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmClass extends KmClassVisitor implements KmDeclarationContainer {
    private String companionObject;
    private final List<KmConstructor> constructors;
    private final List<KmType> contextReceiverTypes;
    private final List<String> enumEntries;
    private final List<KmClassExtension> extensions;
    private int flags;
    private final List<KmFunction> functions;
    private String inlineClassUnderlyingPropertyName;
    private KmType inlineClassUnderlyingType;
    public String name;
    private final List<String> nestedClasses;
    private final List<KmProperty> properties;
    private final List<String> sealedSubclasses;
    private final List<KmType> supertypes;
    private final List<KmTypeAlias> typeAliases;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmVersionRequirement> versionRequirements;

    public KmClass() {
        super(null, 1, null);
        this.flags = FlagsKt.flagsOf(new Flag[0]);
        this.typeParameters = new ArrayList(0);
        this.supertypes = new ArrayList(1);
        this.functions = new ArrayList();
        this.properties = new ArrayList();
        this.typeAliases = new ArrayList(0);
        this.constructors = new ArrayList(1);
        this.nestedClasses = new ArrayList(0);
        this.enumEntries = new ArrayList(0);
        this.sealedSubclasses = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        List<MetadataExtensions> r5 = MetadataExtensions.Companion.getINSTANCES();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((MetadataExtensions) r11.next()).createClassExtension());
        goto L4
    L6:
        this.extensions = r10;
    }

    @ExperimentalContextReceivers
    public static /* synthetic */ void getContextReceiverTypes$annotations() {
    }

    public final void accept(KmClassVisitor r10) {
        Intrinsics.checkNotNullParameter(r10, "visitor");
        r10.visit(this.flags, getName());
        Iterator<T> r5 = this.typeParameters.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        KmTypeParameter r11 = (KmTypeParameter) r5.next();
        KmTypeParameterVisitor r12 = r10.visitTypeParameter(r11.getFlags(), r11.getName(), r11.getId(), r11.getVariance());
        if (r12 == null) goto L4;
        r11.accept(r12);
        goto L4
    L8:
        Iterator<T> r13 = this.supertypes.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        KmType r14 = (KmType) r13.next();
        KmTypeVisitor r15 = r10.visitSupertype(r14.getFlags());
        if (r15 == null) goto L10;
        r14.accept(r15);
        goto L10
    L14:
        Iterator<T> r16 = getFunctions().iterator();
    L16:
        if (r16.hasNext() == false) goto L20;
        KmFunction r17 = (KmFunction) r16.next();
        KmFunctionVisitor r18 = r10.visitFunction(r17.getFlags(), r17.getName());
        if (r18 == null) goto L16;
        r17.accept(r18);
        goto L16
    L20:
        Iterator<T> r19 = getProperties().iterator();
    L22:
        if (r19.hasNext() == false) goto L26;
        KmProperty r20 = (KmProperty) r19.next();
        KmPropertyVisitor r21 = r10.visitProperty(r20.getFlags(), r20.getName(), r20.getGetterFlags(), r20.getSetterFlags());
        if (r21 == null) goto L22;
        r20.accept(r21);
        goto L22
    L26:
        Iterator<T> r22 = getTypeAliases().iterator();
    L28:
        if (r22.hasNext() == false) goto L32;
        KmTypeAlias r23 = (KmTypeAlias) r22.next();
        KmTypeAliasVisitor r24 = r10.visitTypeAlias(r23.getFlags(), r23.getName());
        if (r24 == null) goto L28;
        r23.accept(r24);
        goto L28
    L32:
        Iterator<T> r25 = this.constructors.iterator();
    L34:
        if (r25.hasNext() == false) goto L38;
        KmConstructor r26 = (KmConstructor) r25.next();
        KmConstructorVisitor r27 = r10.visitConstructor(r26.getFlags());
        if (r27 == null) goto L34;
        r26.accept(r27);
        goto L34
    L38:
        String r28 = this.companionObject;
        if (r28 == null) goto L41;
        r10.visitCompanionObject(r28);
    L41:
        Iterator<T> r29 = this.nestedClasses.iterator();
    L43:
        if (r29.hasNext() == false) goto L45;
        r10.visitNestedClass((String) r29.next());
        goto L43
    L45:
        Iterator<T> r30 = this.enumEntries.iterator();
    L47:
        if (r30.hasNext() == false) goto L49;
        r10.visitEnumEntry((String) r30.next());
        goto L47
    L49:
        Iterator<T> r31 = this.sealedSubclasses.iterator();
    L51:
        if (r31.hasNext() == false) goto L53;
        r10.visitSealedSubclass((String) r31.next());
        goto L51
    L53:
        String r32 = this.inlineClassUnderlyingPropertyName;
        if (r32 == null) goto L56;
        r10.visitInlineClassUnderlyingPropertyName(r32);
    L56:
        KmType r33 = this.inlineClassUnderlyingType;
        if (r33 == null) goto L61;
        KmTypeVisitor r34 = r10.visitInlineClassUnderlyingType(r33.getFlags());
        if (r34 == null) goto L61;
        r33.accept(r34);
    L61:
        Iterator<T> r35 = this.contextReceiverTypes.iterator();
    L63:
        if (r35.hasNext() == false) goto L67;
        KmType r36 = (KmType) r35.next();
        KmTypeVisitor r37 = r10.visitContextReceiverType(r36.getFlags());
        if (r37 == null) goto L63;
        r36.accept(r37);
        goto L63
    L67:
        Iterator<T> r38 = this.versionRequirements.iterator();
    L69:
        if (r38.hasNext() == false) goto L73;
        KmVersionRequirement r39 = (KmVersionRequirement) r38.next();
        KmVersionRequirementVisitor r40 = r10.visitVersionRequirement();
        if (r40 == null) goto L69;
        r39.accept(r40);
        goto L69
    L73:
        Iterator<T> r41 = this.extensions.iterator();
    L75:
        if (r41.hasNext() == false) goto L79;
        KmClassExtension r42 = (KmClassExtension) r41.next();
        KmClassExtensionVisitor r43 = r10.visitExtensions(r42.getType());
        if (r43 == null) goto L75;
        r42.accept(r43);
        goto L75
    L79:
        r10.visitEnd();
    }

    public final String getCompanionObject() {
        return this.companionObject;
    }

    public final List<KmConstructor> getConstructors() {
        return this.constructors;
    }

    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final List<String> getEnumEntries() {
        return this.enumEntries;
    }

    public final int getFlags() {
        return this.flags;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainer
    public List<KmFunction> getFunctions() {
        return this.functions;
    }

    public final String getInlineClassUnderlyingPropertyName() {
        return this.inlineClassUnderlyingPropertyName;
    }

    public final KmType getInlineClassUnderlyingType() {
        return this.inlineClassUnderlyingType;
    }

    public final String getName() {
        String r5 = this.name;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final List<String> getNestedClasses() {
        return this.nestedClasses;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainer
    public List<KmProperty> getProperties() {
        return this.properties;
    }

    public final List<String> getSealedSubclasses() {
        return this.sealedSubclasses;
    }

    public final List<KmType> getSupertypes() {
        return this.supertypes;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainer
    public List<KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setCompanionObject(String r5) {
        this.companionObject = r5;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
    }

    public final void setInlineClassUnderlyingPropertyName(String r5) {
        this.inlineClassUnderlyingPropertyName = r5;
    }

    public final void setInlineClassUnderlyingType(KmType r5) {
        this.inlineClassUnderlyingType = r5;
    }

    public final void setName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.name = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visit(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        this.flags = r5;
        setName(r10);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitCompanionObject(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.companionObject = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmConstructorVisitor visitConstructor(int r5) {
        return (KmConstructorVisitor) NodesKt.addTo(new KmConstructor(r5), this.constructors);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int r5) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(r5), this.contextReceiverTypes);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitEnumEntry(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.enumEntries.add(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor, androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public /* bridge */ /* synthetic */ KmDeclarationContainerExtensionVisitor visitExtensions(KmExtensionType r5) {
        return visitExtensions(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return (KmFunctionVisitor) NodesKt.addTo(new KmFunction(r5, r10), getFunctions());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitInlineClassUnderlyingPropertyName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.inlineClassUnderlyingPropertyName = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmTypeVisitor visitInlineClassUnderlyingType(int r5) {
        KmType r10 = new KmType(r5);
        this.inlineClassUnderlyingType = r10;
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitNestedClass(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.nestedClasses.add(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPropertyVisitor visitProperty(int r5, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return (KmPropertyVisitor) NodesKt.addTo(new KmProperty(r5, r10, r11, r12), getProperties());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitSealedSubclass(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.sealedSubclasses.add(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmTypeVisitor visitSupertype(int r5) {
        return (KmTypeVisitor) NodesKt.addTo(new KmType(r5), this.supertypes);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmTypeAliasVisitor visitTypeAlias(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return (KmTypeAliasVisitor) NodesKt.addTo(new KmTypeAlias(r5, r10), getTypeAliases());
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmTypeParameterVisitor visitTypeParameter(int r5, String r10, int r11, KmVariance r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "variance");
        return (KmTypeParameterVisitor) NodesKt.addTo(new KmTypeParameter(r5, r10, r11, r12), this.typeParameters);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmVersionRequirementVisitor visitVersionRequirement() {
        return (KmVersionRequirementVisitor) NodesKt.addTo(new KmVersionRequirement(), this.versionRequirements);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor, androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmClassExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmClassExtensionVisitor) ExtensionUtilsKt.singleOfType(this.extensions, r5);
    }
}
