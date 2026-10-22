package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedTypeAliasDescriptor extends AbstractTypeAliasDescriptor implements DeserializedMemberDescriptor {
    private Collection<? extends TypeAliasConstructorDescriptor> constructors;
    private final DeserializedContainerSource containerSource;
    private SimpleType defaultTypeImpl;
    private SimpleType expandedType;
    private final NameResolver nameResolver;
    private final ProtoBuf.TypeAlias proto;
    private final StorageManager storageManager;
    private List<? extends TypeParameterDescriptor> typeConstructorParameters;
    private final TypeTable typeTable;
    private SimpleType underlyingType;
    private final VersionRequirementTable versionRequirementTable;

    public DeserializedTypeAliasDescriptor(StorageManager r13, DeclarationDescriptor r14, Annotations r15, Name r16, DescriptorVisibility r17, ProtoBuf.TypeAlias r18, NameResolver r19, TypeTable r20, VersionRequirementTable r21, DeserializedContainerSource r22) {
        Intrinsics.checkNotNullParameter(r13, "storageManager");
        Intrinsics.checkNotNullParameter(r14, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r15, "annotations");
        Intrinsics.checkNotNullParameter(r16, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r17, "visibility");
        Intrinsics.checkNotNullParameter(r18, "proto");
        Intrinsics.checkNotNullParameter(r19, "nameResolver");
        Intrinsics.checkNotNullParameter(r20, "typeTable");
        Intrinsics.checkNotNullParameter(r21, "versionRequirementTable");
        SourceElement r10 = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(r10, "NO_SOURCE");
        super(r14, r15, r16, r10, r17);
        this.storageManager = r13;
        this.proto = r18;
        this.nameResolver = r19;
        this.typeTable = r20;
        this.versionRequirementTable = r21;
        this.containerSource = r22;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public ClassDescriptor getClassDescriptor() {
        if (KotlinTypeKt.isError(getExpandedType()) == true) goto L10;
        ClassifierDescriptor r10 = getExpandedType().getConstructor().mo1323getDeclarationDescriptor();
        if ((r10 instanceof ClassDescriptor) == true) goto L8;
        return null;
    L8:
        return (ClassDescriptor) r10;
    L10:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public SimpleType getDefaultType() {
        SimpleType r10 = this.defaultTypeImpl;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultTypeImpl");
        return null;
    L6:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public SimpleType getExpandedType() {
        SimpleType r10 = this.expandedType;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("expandedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public ProtoBuf.TypeAlias getProto() {
        return this.proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    protected StorageManager getStorageManager() {
        return this.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    protected List<TypeParameterDescriptor> getTypeConstructorTypeParameters() {
        List r10 = this.typeConstructorParameters;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("typeConstructorParameters");
        return null;
    L6:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor
    public SimpleType getUnderlyingType() {
        SimpleType r10 = this.underlyingType;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
        return null;
    }

    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    public final void initialize(List<? extends TypeParameterDescriptor> r10, SimpleType r11, SimpleType r12) {
        Intrinsics.checkNotNullParameter(r10, "declaredTypeParameters");
        Intrinsics.checkNotNullParameter(r11, "underlyingType");
        Intrinsics.checkNotNullParameter(r12, "expandedType");
        initialize(r10);
        this.underlyingType = r11;
        this.expandedType = r12;
        this.typeConstructorParameters = TypeParameterUtilsKt.computeConstructorTypeParameters(this);
        this.defaultTypeImpl = computeDefaultType();
        this.constructors = getTypeAliasConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public TypeAliasDescriptor substitute(TypeSubstitutor r13) {
        Intrinsics.checkNotNullParameter(r13, "substitutor");
        if (r13.isEmpty() == false) goto L5;
        return this;
    L5:
        StorageManager r10 = getStorageManager();
        DeclarationDescriptor r11 = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r11, "containingDeclaration");
        Annotations r12 = getAnnotations();
        Intrinsics.checkNotNullExpressionValue(r12, "annotations");
        Name r14 = getName();
        Intrinsics.checkNotNullExpressionValue(r14, ActivityLifecycle.NAME);
        DeserializedTypeAliasDescriptor r15 = new DeserializedTypeAliasDescriptor(r10, r11, r12, r14, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<TypeParameterDescriptor> r16 = getDeclaredTypeParameters();
        SimpleType r17 = getUnderlyingType();
        Variance r18 = Variance.INVARIANT;
        KotlinType r19 = r13.safeSubstitute(r17, r18);
        Intrinsics.checkNotNullExpressionValue(r19, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        SimpleType r20 = TypeSubstitutionKt.asSimpleType(r19);
        KotlinType r110 = r13.safeSubstitute(getExpandedType(), r18);
        Intrinsics.checkNotNullExpressionValue(r110, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        r15.initialize(r16, r20, TypeSubstitutionKt.asSimpleType(r110));
        return r15;
    }
}
