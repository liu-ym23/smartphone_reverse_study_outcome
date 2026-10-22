package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface FunctionDescriptor extends CallableMemberDescriptor {

    public interface CopyBuilder<D extends FunctionDescriptor> {
        D build();

        <V> CopyBuilder<D> putUserData(CallableDescriptor.UserDataKey<V> r1, V r2);

        CopyBuilder<D> setAdditionalAnnotations(Annotations r1);

        CopyBuilder<D> setCopyOverrides(boolean r1);

        CopyBuilder<D> setDispatchReceiverParameter(ReceiverParameterDescriptor r1);

        CopyBuilder<D> setDropOriginalInContainingParts();

        CopyBuilder<D> setExtensionReceiverParameter(ReceiverParameterDescriptor r1);

        CopyBuilder<D> setHiddenForResolutionEverywhereBesideSupercalls();

        CopyBuilder<D> setHiddenToOvercomeSignatureClash();

        CopyBuilder<D> setKind(CallableMemberDescriptor.Kind r1);

        CopyBuilder<D> setModality(Modality r1);

        CopyBuilder<D> setName(Name r1);

        CopyBuilder<D> setOriginal(CallableMemberDescriptor r1);

        CopyBuilder<D> setOwner(DeclarationDescriptor r1);

        CopyBuilder<D> setPreserveSourceElement();

        CopyBuilder<D> setReturnType(KotlinType r1);

        CopyBuilder<D> setSignatureChange();

        CopyBuilder<D> setSubstitution(TypeSubstitution r1);

        CopyBuilder<D> setTypeParameters(List<TypeParameterDescriptor> r1);

        CopyBuilder<D> setValueParameters(List<ValueParameterDescriptor> r1);

        CopyBuilder<D> setVisibility(DescriptorVisibility r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    DeclarationDescriptor getContainingDeclaration();

    FunctionDescriptor getInitialSignatureDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    FunctionDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    Collection<? extends FunctionDescriptor> getOverriddenDescriptors();

    boolean isHiddenForResolutionEverywhereBesideSupercalls();

    boolean isHiddenToOvercomeSignatureClash();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    boolean isTailrec();

    CopyBuilder<? extends FunctionDescriptor> newCopyBuilder();

    FunctionDescriptor substitute(TypeSubstitutor r1);
}
