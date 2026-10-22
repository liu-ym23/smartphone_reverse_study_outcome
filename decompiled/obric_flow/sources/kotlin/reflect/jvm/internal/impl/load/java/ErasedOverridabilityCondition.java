package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nErasedOverridabilityCondition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErasedOverridabilityCondition.kt\norg/jetbrains/kotlin/load/java/ErasedOverridabilityCondition\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,63:1\n1229#2,2:64\n*S KotlinDebug\n*F\n+ 1 ErasedOverridabilityCondition.kt\norg/jetbrains/kotlin/load/java/ErasedOverridabilityCondition\n*L\n44#1:64,2\n*E\n"})
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            r5[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public ErasedOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r5, CallableDescriptor r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r5, "superDescriptor");
        Intrinsics.checkNotNullParameter(r10, "subDescriptor");
        if ((r10 instanceof JavaMethodDescriptor) == false) goto L42;
        JavaMethodDescriptor r12 = (JavaMethodDescriptor) r10;
        if (r12.getTypeParameters().isEmpty() == false) goto L42;
        OverridingUtil.OverrideCompatibilityInfo r13 = OverridingUtil.getBasicOverridabilityProblem(r5, r10);
        if (r13 == null) goto L10;
        OverridingUtil.OverrideCompatibilityInfo.Result r14 = r13.getResult();
    L11:
        if (r14 != null) goto L13;
        Sequence r15 = SequencesKt.map(CollectionsKt.asSequence(r12.getValueParameters()), ErasedOverridabilityCondition$isOverridable$signatureTypes$1.INSTANCE);
        KotlinType r16 = r12.getReturnType();
        Intrinsics.checkNotNull(r16);
        Sequence r17 = SequencesKt.plus(r15, r16);
        ReceiverParameterDescriptor r18 = r12.getExtensionReceiverParameter();
        if (r18 == null) goto L17;
        KotlinType r19 = r18.getType();
    L18:
        Iterator r20 = SequencesKt.d(CollectionsKt.listOfNotNull(r19), r17).iterator();
    L20:
        if (r20.hasNext() == false) goto L27;
        KotlinType r21 = (KotlinType) r20.next();
        if (r21.getArguments().isEmpty() == true) goto L20;
        if ((r21.unwrap() instanceof RawTypeImpl) == true) goto L20;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L27:
        CallableDescriptor r22 = r5.substitute(new RawSubstitution(null, 1, null).buildSubstitutor());
        if (r22 != null) goto L32;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L32:
        if ((r22 instanceof SimpleFunctionDescriptor) == false) goto L37;
        SimpleFunctionDescriptor r23 = (SimpleFunctionDescriptor) r22;
        if (r23.getTypeParameters().isEmpty() == true) goto L37;
        r22 = r23.newCopyBuilder().setTypeParameters(CollectionsKt.emptyList()).build();
        Intrinsics.checkNotNull(r22);
    L37:
        if (WhenMappings.$EnumSwitchMapping$0[OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(r22, r10, false).getResult().ordinal()] != 1) goto L40;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L40:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L17:
        r19 = null;
        goto L18
    L13:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L10:
        r14 = null;
    L42:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
