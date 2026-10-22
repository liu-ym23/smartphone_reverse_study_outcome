package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeAliasConstructorDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,238:1\n1#2:239\n*E\n"})
public final class TypeAliasConstructorDescriptorImpl extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private final StorageManager storageManager;
    private final TypeAliasDescriptor typeAliasDescriptor;
    private ClassConstructorDescriptor underlyingConstructorDescriptor;
    private final NullableLazyValue withDispatchReceiver$delegate;

    @SourceDebugExtension({"SMAP\nTypeAliasConstructorDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n1559#2:239\n1590#2,4:240\n*S KotlinDebug\n*F\n+ 1 TypeAliasConstructorDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptorImpl$Companion\n*L\n209#1:239\n209#1:240,4\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ TypeSubstitutor access$getTypeSubstitutorForUnderlyingClass(Companion r5, TypeAliasDescriptor r10) {
            return r5.getTypeSubstitutorForUnderlyingClass(r10);
        }

        private final TypeSubstitutor getTypeSubstitutorForUnderlyingClass(TypeAliasDescriptor r5) {
            if (r5.getClassDescriptor() != null) goto L7;
            return null;
        L7:
            return TypeSubstitutor.create(r5.getExpandedType());
        }

        public final TypeAliasConstructorDescriptor createIfAvailable(StorageManager r13, TypeAliasDescriptor r14, ClassConstructorDescriptor r15) {
            Intrinsics.checkNotNullParameter(r13, "storageManager");
            Intrinsics.checkNotNullParameter(r14, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(r15, "constructor");
            TypeSubstitutor r12 = getTypeSubstitutorForUnderlyingClass(r14);
            ReceiverParameterDescriptor r5 = null;
            if (r12 != null) goto L5;
            return null;
        L5:
            ClassConstructorDescriptor r10 = r15.substitute(r12);
            if (r10 != null) goto L8;
            return null;
        L8:
            TypeAliasConstructorDescriptor r11 = null;
            TypeAliasConstructorDescriptorImpl r16 = new TypeAliasConstructorDescriptorImpl(r13, r14, r10, r11, r15.getAnnotations(), r15.getKind(), r14.getSource(), null);
            List<ValueParameterDescriptor> r17 = FunctionDescriptorImpl.getSubstitutedValueParameters(r16, r15.getValueParameters(), r12);
            if (r17 != null) goto L11;
            return null;
        L11:
            SimpleType r18 = SpecialTypesKt.withAbbreviation(FlexibleTypesKt.lowerIfFlexible(r10.getReturnType().unwrap()), r14.getDefaultType());
            ReceiverParameterDescriptor r19 = r15.getDispatchReceiverParameter();
            if (r19 == null) goto L14;
            r5 = DescriptorFactory.createExtensionReceiverParameterForCallable(r16, r12.safeSubstitute(r19.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY());
        L14:
            ReceiverParameterDescriptor r20 = r5;
            ClassDescriptor r110 = r14.getClassDescriptor();
            if (r110 == null) goto L24;
            List<ReceiverParameterDescriptor> r111 = r15.getContextReceiverParameters();
            ArrayList r21 = new ArrayList(CollectionsKt.h(r111));
            Iterator<T> r112 = r111.iterator();
            int r22 = 0;
        L18:
            if (r112.hasNext() == false) goto L23;
            Object r23 = r112.next();
            int r24 = r22 + 1;
            if (r22 >= 0) goto L22;
            CollectionsKt.throwIndexOverflow();
        L22:
            ReceiverParameterDescriptor r25 = (ReceiverParameterDescriptor) r23;
            KotlinType r26 = r12.safeSubstitute(r25.getType(), Variance.INVARIANT);
            ReceiverValue r27 = r25.getValue();
            Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
            r21.add(DescriptorFactory.createContextReceiverParameterForClass(r110, r26, ((ImplicitContextReceiver) r27).getCustomLabelName(), Annotations.Companion.getEMPTY(), r22));
            r22 = r24;
            goto L18
        L23:
            List<ReceiverParameterDescriptor> r28 = r21;
        L25:
            r16.initialize(r20, null, r28, r14.getDeclaredTypeParameters(), r17, r18, Modality.FINAL, r14.getVisibility());
            return r16;
        L24:
            r28 = CollectionsKt.emptyList();
            goto L25
        }

        private Companion() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
        Companion = new Companion(null);
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager r5, TypeAliasDescriptor r10, ClassConstructorDescriptor r11, TypeAliasConstructorDescriptor r12, Annotations r13, CallableMemberDescriptor.Kind r14, SourceElement r15, DefaultConstructorMarker r16) {
        this(r5, r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        return copy(r5, r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r5, FunctionDescriptor r10, CallableMemberDescriptor.Kind r11, Name r12, Annotations r13, SourceElement r14) {
        return createSubstitutedCopy(r5, r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        return getUnderlyingConstructorDescriptor().getConstructedClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType r5 = super.getReturnType();
        Intrinsics.checkNotNull(r5);
        return r5;
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
    public /* bridge */ /* synthetic */ ConstructorDescriptor substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    private TypeAliasConstructorDescriptorImpl(StorageManager r10, TypeAliasDescriptor r11, final ClassConstructorDescriptor r12, TypeAliasConstructorDescriptor r13, Annotations r14, CallableMemberDescriptor.Kind r15, SourceElement r16) {
        super(r11, r13, r14, SpecialNames.INIT, r15, r16);
        this.storageManager = r10;
        this.typeAliasDescriptor = r11;
        setActual(getTypeAliasDescriptor().isActual());
        this.withDispatchReceiver$delegate = r10.createNullableLazyValue(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, r12));
        this.underlyingConstructorDescriptor = r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        return copy(r5, r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public TypeAliasConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public TypeAliasConstructorDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "newOwner");
        Intrinsics.checkNotNullParameter(r10, "modality");
        Intrinsics.checkNotNullParameter(r11, "visibility");
        Intrinsics.checkNotNullParameter(r12, "kind");
        FunctionDescriptor r14 = newCopyBuilder().setOwner(r5).setModality(r10).setVisibility(r11).setKind(r12).setCopyOverrides(r13).build();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ FunctionDescriptor substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public TypeAliasConstructorDescriptor substitute(TypeSubstitutor r5) {
        Intrinsics.checkNotNullParameter(r5, "substitutor");
        FunctionDescriptor r10 = super.substitute(r5);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl r11 = (TypeAliasConstructorDescriptorImpl) r10;
        TypeSubstitutor r12 = TypeSubstitutor.create(r11.getReturnType());
        ClassConstructorDescriptor r13 = getUnderlyingConstructorDescriptor().getOriginal().substitute(r12);
        if (r13 != null) goto L6;
        return null;
    L6:
        r11.underlyingConstructorDescriptor = r13;
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor r5 = super.getOriginal();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) r5;
    }
}
