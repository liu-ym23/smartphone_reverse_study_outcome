package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAliasConstructorDescriptorImpl extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private final StorageManager storageManager;
    private final TypeAliasDescriptor typeAliasDescriptor;
    private ClassConstructorDescriptor underlyingConstructorDescriptor;
    private final NullableLazyValue withDispatchReceiver$delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ TypeSubstitutor access$getTypeSubstitutorForUnderlyingClass(Companion r10, TypeAliasDescriptor r11) {
            return r10.getTypeSubstitutorForUnderlyingClass(r11);
        }

        private final TypeSubstitutor getTypeSubstitutorForUnderlyingClass(TypeAliasDescriptor r10) {
            if (r10.getClassDescriptor() != null) goto L7;
            return null;
        L7:
            return TypeSubstitutor.create(r10.getExpandedType());
        }

        public final TypeAliasConstructorDescriptor createIfAvailable(StorageManager r13, TypeAliasDescriptor r14, ClassConstructorDescriptor r15) {
            Intrinsics.checkNotNullParameter(r13, "storageManager");
            Intrinsics.checkNotNullParameter(r14, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(r15, "constructor");
            TypeSubstitutor r12 = getTypeSubstitutorForUnderlyingClass(r14);
            ReceiverParameterDescriptor r10 = null;
            if (r12 != null) goto L5;
            return null;
        L5:
            ClassConstructorDescriptor r11 = r15.substitute(r12);
            if (r11 != null) goto L8;
            return null;
        L8:
            Annotations r16 = r15.getAnnotations();
            CallableMemberDescriptor.Kind r17 = r15.getKind();
            Intrinsics.checkNotNullExpressionValue(r17, "constructor.kind");
            SourceElement r18 = r14.getSource();
            Intrinsics.checkNotNullExpressionValue(r18, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptorImpl r19 = new TypeAliasConstructorDescriptorImpl(r13, r14, r11, null, r16, r17, r18, null);
            List<ValueParameterDescriptor> r20 = FunctionDescriptorImpl.getSubstitutedValueParameters(r19, r15.getValueParameters(), r12);
            if (r20 != null) goto L11;
            return null;
        L11:
            SimpleType r110 = FlexibleTypesKt.lowerIfFlexible(r11.getReturnType().unwrap());
            SimpleType r21 = r14.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(r21, "typeAliasDescriptor.defaultType");
            SimpleType r22 = SpecialTypesKt.withAbbreviation(r110, r21);
            ReceiverParameterDescriptor r111 = r15.getDispatchReceiverParameter();
            if (r111 == null) goto L14;
            r10 = DescriptorFactory.createExtensionReceiverParameterForCallable(r19, r12.safeSubstitute(r111.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY());
        L14:
            ReceiverParameterDescriptor r23 = r10;
            ClassDescriptor r112 = r14.getClassDescriptor();
            if (r112 == null) goto L21;
            List<ReceiverParameterDescriptor> r113 = r15.getContextReceiverParameters();
            Intrinsics.checkNotNullExpressionValue(r113, "constructor.contextReceiverParameters");
            ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator<T> r114 = r113.iterator();
        L18:
            if (r114.hasNext() == false) goto L20;
            r24.add(DescriptorFactory.createContextReceiverParameterForClass(r112, r12.safeSubstitute(((ReceiverParameterDescriptor) r114.next()).getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY()));
            goto L18
        L20:
            List<ReceiverParameterDescriptor> r25 = r24;
        L22:
            r19.initialize(r23, null, r25, r14.getDeclaredTypeParameters(), r20, r22, Modality.FINAL, r14.getVisibility());
            return r19;
        L21:
            r25 = CollectionsKt.emptyList();
            goto L22
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
        Companion = new Companion(null);
    }

    private TypeAliasConstructorDescriptorImpl(StorageManager r10, TypeAliasDescriptor r11, final ClassConstructorDescriptor r12, TypeAliasConstructorDescriptor r13, Annotations r14, CallableMemberDescriptor.Kind r15, SourceElement r16) {
        super(r11, r13, r14, SpecialNames.INIT, r15, r16);
        this.storageManager = r10;
        this.typeAliasDescriptor = r11;
        setActual(getTypeAliasDescriptor().isActual());
        this.withDispatchReceiver$delegate = r10.createNullableLazyValue(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, r12));
        this.underlyingConstructorDescriptor = r12;
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager r10, TypeAliasDescriptor r11, ClassConstructorDescriptor r12, TypeAliasConstructorDescriptor r13, Annotations r14, CallableMemberDescriptor.Kind r15, SourceElement r16, DefaultConstructorMarker r17) {
        this(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        return copy(r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        return copy(r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public TypeAliasConstructorDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "newOwner");
        Intrinsics.checkNotNullParameter(r11, "modality");
        Intrinsics.checkNotNullParameter(r12, "visibility");
        Intrinsics.checkNotNullParameter(r13, "kind");
        FunctionDescriptor r15 = newCopyBuilder().setOwner(r10).setModality(r11).setVisibility(r12).setKind(r13).setCopyOverrides(r14).build();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) r15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        return createSubstitutedCopy(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected TypeAliasConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        Intrinsics.checkNotNullParameter(r10, "newOwner");
        Intrinsics.checkNotNullParameter(r12, "kind");
        Intrinsics.checkNotNullParameter(r14, "annotations");
        Intrinsics.checkNotNullParameter(r15, "source");
        CallableMemberDescriptor.Kind r16 = CallableMemberDescriptor.Kind.DECLARATION;
        if (r12 == r16) goto L6;
        CallableMemberDescriptor.Kind r17 = CallableMemberDescriptor.Kind.SYNTHESIZED;
    L6:
        return new TypeAliasConstructorDescriptorImpl(this.storageManager, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, r14, r16, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor r10 = getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(r10, "underlyingConstructorDescriptor.constructedClass");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor r10 = super.getOriginal();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType r10 = super.getReturnType();
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ ConstructorDescriptor substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ FunctionDescriptor substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public TypeAliasConstructorDescriptor substitute(TypeSubstitutor r10) {
        Intrinsics.checkNotNullParameter(r10, "substitutor");
        FunctionDescriptor r11 = super.substitute(r10);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl r12 = (TypeAliasConstructorDescriptorImpl) r11;
        TypeSubstitutor r13 = TypeSubstitutor.create(r12.getReturnType());
        Intrinsics.checkNotNullExpressionValue(r13, "create(substitutedTypeAliasConstructor.returnType)");
        ClassConstructorDescriptor r14 = getUnderlyingConstructorDescriptor().getOriginal().substitute(r13);
        if (r14 != null) goto L6;
        return null;
    L6:
        r12.underlyingConstructorDescriptor = r14;
        return r12;
    }
}
