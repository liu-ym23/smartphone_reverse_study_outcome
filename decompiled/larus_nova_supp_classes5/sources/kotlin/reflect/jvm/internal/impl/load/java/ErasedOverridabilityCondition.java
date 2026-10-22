package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {
    public ErasedOverridabilityCondition() {
    }

    public static /* synthetic */ KotlinType accessor$ErasedOverridabilityCondition$lambda0(ValueParameterDescriptor r0) {
        return isOverridable$lambda$0(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    private static final KotlinType isOverridable$lambda$0(ValueParameterDescriptor r0) {
        return r0.getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r6, CallableDescriptor r7, ClassDescriptor r8) {
        Intrinsics.checkNotNullParameter(r6, "superDescriptor");
        Intrinsics.checkNotNullParameter(r7, "subDescriptor");
        if ((r7 instanceof JavaMethodDescriptor) == false) goto L48;
        JavaMethodDescriptor r9 = (JavaMethodDescriptor) r7;
        if ((!r9.getTypeParameters().isEmpty()) == true) goto L48;
        OverridingUtil.OverrideCompatibilityInfo r0 = OverridingUtil.getBasicOverridabilityProblem(r6, r7);
        if (r0 == null) goto L10;
        OverridingUtil$OverrideCompatibilityInfo$Result r1 = r0.getResult();
    L11:
        if (r1 != null) goto L13;
        Sequence r2 = SequencesKt.map(CollectionsKt.asSequence(r9.getValueParameters()), ErasedOverridabilityCondition$.Lambda.0.INSTANCE);
        KotlinType r3 = r9.getReturnType();
        Intrinsics.checkNotNull(r3);
        Sequence r4 = SequencesKt.plus(r2, r3);
        ReceiverParameterDescriptor r10 = r9.getExtensionReceiverParameter();
        if (r10 == null) goto L17;
        KotlinType r11 = r10.getType();
    L18:
        Iterator r12 = SequencesKt.plus(r4, CollectionsKt.listOfNotNull(r11)).iterator();
    L20:
        if (r12.hasNext() == false) goto L29;
        KotlinType r5 = (KotlinType) r12.next();
        if ((!r5.getArguments().isEmpty()) == true) goto L24;
    L26:
        boolean r13 = false;
    L27:
        if (r13 == false) goto L20;
        boolean r14 = true;
    L30:
        if (r14 == true) goto L32;
        CallableDescriptor r15 = r6.substitute(new RawSubstitution(null, 1, null).buildSubstitutor());
        if (r15 != null) goto L38;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L38:
        if ((r15 instanceof SimpleFunctionDescriptor) == false) goto L43;
        SimpleFunctionDescriptor r16 = (SimpleFunctionDescriptor) r15;
        if ((!r16.getTypeParameters().isEmpty()) == false) goto L43;
        r15 = r16.newCopyBuilder().setTypeParameters(CollectionsKt.emptyList()).build();
        Intrinsics.checkNotNull(r15);
    L43:
        if (WhenMappings.$EnumSwitchMapping$0[OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(r15, r7, false).getResult().ordinal()] != 1) goto L46;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L46:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L32:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L24:
        if ((r5.unwrap() instanceof RawTypeImpl) == true) goto L26;
        r13 = true;
        goto L27
    L29:
        r14 = false;
        goto L30
    L17:
        r11 = null;
        goto L18
    L13:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L10:
        r1 = null;
    L48:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
