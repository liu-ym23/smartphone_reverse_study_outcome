package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            r10[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public ErasedOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r10, CallableDescriptor r11, ClassDescriptor r12) {
        Intrinsics.checkNotNullParameter(r10, "superDescriptor");
        Intrinsics.checkNotNullParameter(r11, "subDescriptor");
        if ((r11 instanceof JavaMethodDescriptor) == false) goto L48;
        JavaMethodDescriptor r13 = (JavaMethodDescriptor) r11;
        List<TypeParameterDescriptor> r14 = r13.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "subDescriptor.typeParameters");
        if ((!r14.isEmpty()) == true) goto L48;
        OverridingUtil.OverrideCompatibilityInfo r15 = OverridingUtil.getBasicOverridabilityProblem(r10, r11);
        if (r15 == null) goto L10;
        OverridingUtil.OverrideCompatibilityInfo.Result r16 = r15.getResult();
    L11:
        if (r16 != null) goto L13;
        List<ValueParameterDescriptor> r17 = r13.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "subDescriptor.valueParameters");
        Sequence r18 = SequencesKt.map(CollectionsKt.asSequence(r17), ErasedOverridabilityCondition$isOverridable$signatureTypes$1.INSTANCE);
        KotlinType r19 = r13.getReturnType();
        Intrinsics.checkNotNull(r19);
        Sequence r20 = SequencesKt.plus(r18, r19);
        ReceiverParameterDescriptor r21 = r13.getExtensionReceiverParameter();
        if (r21 == null) goto L17;
        KotlinType r22 = r21.getType();
    L18:
        Iterator r23 = SequencesKt.plus(r20, CollectionsKt.listOfNotNull(r22)).iterator();
    L20:
        if (r23.hasNext() == false) goto L29;
        KotlinType r24 = (KotlinType) r23.next();
        if ((!r24.getArguments().isEmpty()) == true) goto L24;
    L26:
        boolean r25 = false;
    L27:
        if (r25 == false) goto L20;
        boolean r26 = true;
    L30:
        if (r26 == true) goto L32;
        CallableDescriptor r27 = r10.substitute(new RawSubstitution(null, 1, null).buildSubstitutor());
        if (r27 != null) goto L38;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L38:
        if ((r27 instanceof SimpleFunctionDescriptor) == false) goto L42;
        SimpleFunctionDescriptor r28 = (SimpleFunctionDescriptor) r27;
        List<TypeParameterDescriptor> r29 = r28.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r29, "erasedSuper.typeParameters");
        if ((!r29.isEmpty()) == false) goto L42;
        r27 = r28.newCopyBuilder().setTypeParameters(CollectionsKt.emptyList()).build();
        Intrinsics.checkNotNull(r27);
    L42:
        OverridingUtil.OverrideCompatibilityInfo.Result r30 = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(r27, r11, false).getResult();
        Intrinsics.checkNotNullExpressionValue(r30, "DEFAULT.isOverridableByW…Descriptor, false).result");
        if (WhenMappings.$EnumSwitchMapping$0[r30.ordinal()] != 1) goto L46;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L46:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L32:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L24:
        if ((r24.unwrap() instanceof RawTypeImpl) == true) goto L26;
        r25 = true;
        goto L27
    L29:
        r26 = false;
        goto L30
    L17:
        r22 = null;
        goto L18
    L13:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L10:
        r16 = null;
    L48:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
