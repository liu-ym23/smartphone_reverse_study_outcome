package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class OperatorChecks extends AbstractModifierChecks {
    public static final OperatorChecks INSTANCE = null;
    private static final List<Checks> checks = null;

    static {
        INSTANCE = new OperatorChecks();
        Name r10 = OperatorNameConventions.GET;
        MemberKindCheck.MemberOrExtension r11 = MemberKindCheck.MemberOrExtension.INSTANCE;
        Check[] r12 = {r11, new ValueParameterCountCheck.AtLeast(1)};
        Name r13 = OperatorNameConventions.SET;
        Check[] r14 = {r11, new ValueParameterCountCheck.AtLeast(2)};
        Name r15 = OperatorNameConventions.GET_VALUE;
        NoDefaultAndVarargsCheck r16 = NoDefaultAndVarargsCheck.INSTANCE;
        IsKPropertyCheck r17 = IsKPropertyCheck.INSTANCE;
        Name r18 = OperatorNameConventions.CONTAINS;
        ValueParameterCountCheck.SingleValueParameter r19 = ValueParameterCountCheck.SingleValueParameter.INSTANCE;
        ReturnsCheck.ReturnsBoolean r20 = ReturnsCheck.ReturnsBoolean.INSTANCE;
        Name r110 = OperatorNameConventions.ITERATOR;
        ValueParameterCountCheck.NoValueParameters r21 = ValueParameterCountCheck.NoValueParameters.INSTANCE;
        checks = CollectionsKt.listOf(new Checks[]{new Checks(r10, r12, null, 4, null), new Checks(r13, r14, OperatorChecks$checks$1.INSTANCE), new Checks(r15, new Check[]{r11, r16, new ValueParameterCountCheck.AtLeast(2), r17}, null, 4, null), new Checks(OperatorNameConventions.SET_VALUE, new Check[]{r11, r16, new ValueParameterCountCheck.AtLeast(3), r17}, null, 4, null), new Checks(OperatorNameConventions.PROVIDE_DELEGATE, new Check[]{r11, r16, new ValueParameterCountCheck.Equals(2), r17}, null, 4, null), new Checks(OperatorNameConventions.INVOKE, new Check[]{r11}, null, 4, null), new Checks(r18, new Check[]{r11, r19, r16, r20}, null, 4, null), new Checks(r110, new Check[]{r11, r21}, null, 4, null), new Checks(OperatorNameConventions.NEXT, new Check[]{r11, r21}, null, 4, null), new Checks(OperatorNameConventions.HAS_NEXT, new Check[]{r11, r21, r20}, null, 4, null), new Checks(OperatorNameConventions.RANGE_TO, new Check[]{r11, r19, r16}, null, 4, null), new Checks(OperatorNameConventions.RANGE_UNTIL, new Check[]{r11, r19, r16}, null, 4, null), new Checks(OperatorNameConventions.EQUALS, new Check[]{MemberKindCheck.Member.INSTANCE}, OperatorChecks$checks$2.INSTANCE), new Checks(OperatorNameConventions.COMPARE_TO, new Check[]{r11, ReturnsCheck.ReturnsInt.INSTANCE, r19, r16}, null, 4, null), new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, new Check[]{r11, r19, r16}, null, 4, null), new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{r11, r21}, null, 4, null), new Checks(CollectionsKt.listOf(new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC}), new Check[]{r11}, OperatorChecks$checks$3.INSTANCE), new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, new Check[]{r11, ReturnsCheck.ReturnsUnit.INSTANCE, r19, r16}, null, 4, null), new Checks(OperatorNameConventions.COMPONENT_REGEX, new Check[]{r11, r21}, null, 4, null)});
    }

    private OperatorChecks() {
    }

    public static final /* synthetic */ boolean access$incDecCheckForExpectClass(OperatorChecks r10, FunctionDescriptor r11, ReceiverParameterDescriptor r12) {
        return r10.incDecCheckForExpectClass(r11, r12);
    }

    private final boolean incDecCheckForExpectClass(FunctionDescriptor r10, ReceiverParameterDescriptor r11) {
        ReceiverValue r12 = r11.getValue();
        Intrinsics.checkNotNullExpressionValue(r12, "receiver.value");
        if ((r12 instanceof ImplicitClassReceiver) == true) goto L5;
        return false;
    L5:
        ClassDescriptor r13 = ((ImplicitClassReceiver) r12).getClassDescriptor();
        if (r13.isExpect() == true) goto L8;
        return false;
    L8:
        ClassId r14 = DescriptorUtilsKt.getClassId(r13);
        if (r14 != null) goto L11;
        return false;
    L11:
        ClassifierDescriptor r15 = FindClassInModuleKt.findClassifierAcrossModuleDependencies(DescriptorUtilsKt.getModule(r13), r14);
        if ((r15 instanceof TypeAliasDescriptor) == true) goto L14;
        r15 = null;
    L14:
        TypeAliasDescriptor r16 = (TypeAliasDescriptor) r15;
        if (r16 != null) goto L17;
        return false;
    L17:
        KotlinType r17 = r10.getReturnType();
        if (r17 != null) goto L20;
        return false;
    L20:
        return TypeUtilsKt.isSubtypeOf(r17, r16.getExpandedType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
    public List<Checks> getChecks$descriptors() {
        return checks;
    }
}
