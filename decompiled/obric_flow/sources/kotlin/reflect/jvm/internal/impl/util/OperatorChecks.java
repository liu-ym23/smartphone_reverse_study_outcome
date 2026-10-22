package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.CollectionsKt;
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
        Name r5 = OperatorNameConventions.GET;
        MemberKindCheck.MemberOrExtension r10 = MemberKindCheck.MemberOrExtension.INSTANCE;
        Checks r11 = new Checks(r5, new Check[]{r10, new ValueParameterCountCheck.AtLeast(1)}, null, 4, null);
        Checks r12 = new Checks(OperatorNameConventions.SET, new Check[]{r10, new ValueParameterCountCheck.AtLeast(2)}, OperatorChecks$checks$1.INSTANCE);
        Name r17 = OperatorNameConventions.GET_VALUE;
        NoDefaultAndVarargsCheck r13 = NoDefaultAndVarargsCheck.INSTANCE;
        ValueParameterCountCheck.AtLeast r14 = new ValueParameterCountCheck.AtLeast(2);
        IsKPropertyCheck r15 = IsKPropertyCheck.INSTANCE;
        Checks r16 = new Checks(r17, new Check[]{r10, r13, r14, r15}, null, 4, null);
        Checks r27 = new Checks(OperatorNameConventions.SET_VALUE, new Check[]{r10, r13, new ValueParameterCountCheck.AtLeast(3), r15}, null, 4, null);
        Checks r18 = new Checks(OperatorNameConventions.PROVIDE_DELEGATE, new Check[]{r10, r13, new ValueParameterCountCheck.Equals(2), r15}, null, 4, null);
        Checks r28 = new Checks(OperatorNameConventions.INVOKE, new Check[]{r10}, null, 4, null);
        Name r19 = OperatorNameConventions.CONTAINS;
        ValueParameterCountCheck.SingleValueParameter r20 = ValueParameterCountCheck.SingleValueParameter.INSTANCE;
        ReturnsCheck.ReturnsBoolean r21 = ReturnsCheck.ReturnsBoolean.INSTANCE;
        Checks r110 = new Checks(r19, new Check[]{r10, r20, r13, r21}, null, 4, null);
        Name r29 = OperatorNameConventions.ITERATOR;
        ValueParameterCountCheck.NoValueParameters r33 = ValueParameterCountCheck.NoValueParameters.INSTANCE;
        checks = CollectionsKt.listOf(new Checks[]{r11, r12, r16, r27, r18, r28, r110, new Checks(r29, new Check[]{r10, r33}, null, 4, null), new Checks(OperatorNameConventions.NEXT, new Check[]{r10, r33}, null, 4, null), new Checks(OperatorNameConventions.HAS_NEXT, new Check[]{r10, r33, r21}, null, 4, null), new Checks(OperatorNameConventions.RANGE_TO, new Check[]{r10, r20, r13}, null, 4, null), new Checks(OperatorNameConventions.RANGE_UNTIL, new Check[]{r10, r20, r13}, null, 4, null), new Checks(OperatorNameConventions.EQUALS, new Check[]{MemberKindCheck.Member.INSTANCE}, OperatorChecks$checks$2.INSTANCE), new Checks(OperatorNameConventions.COMPARE_TO, new Check[]{r10, ReturnsCheck.ReturnsInt.INSTANCE, r20, r13}, null, 4, null), new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, new Check[]{r10, r20, r13}, null, 4, null), new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{r10, r33}, null, 4, null), new Checks(CollectionsKt.listOf(new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC}), new Check[]{r10}, OperatorChecks$checks$3.INSTANCE), new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, new Check[]{r10, ReturnsCheck.ReturnsUnit.INSTANCE, r20, r13}, null, 4, null), new Checks(OperatorNameConventions.COMPONENT_REGEX, new Check[]{r10, r33}, null, 4, null)});
    }

    private OperatorChecks() {
    }

    public static final /* synthetic */ boolean access$incDecCheckForExpectClass(OperatorChecks r5, FunctionDescriptor r10, ReceiverParameterDescriptor r11) {
        return r5.incDecCheckForExpectClass(r10, r11);
    }

    private final boolean incDecCheckForExpectClass(FunctionDescriptor r5, ReceiverParameterDescriptor r10) {
        ReceiverValue r11 = r10.getValue();
        if ((r11 instanceof ImplicitClassReceiver) == true) goto L5;
        return false;
    L5:
        ClassDescriptor r12 = ((ImplicitClassReceiver) r11).getClassDescriptor();
        if (r12.isExpect() == true) goto L8;
        return false;
    L8:
        ClassId r13 = DescriptorUtilsKt.getClassId(r12);
        if (r13 != null) goto L11;
        return false;
    L11:
        ClassifierDescriptor r14 = FindClassInModuleKt.findClassifierAcrossModuleDependencies(DescriptorUtilsKt.getModule(r12), r13);
        if ((r14 instanceof TypeAliasDescriptor) == false) goto L14;
        TypeAliasDescriptor r15 = (TypeAliasDescriptor) r14;
    L15:
        if (r15 != null) goto L17;
        return false;
    L17:
        KotlinType r16 = r5.getReturnType();
        if (r16 != null) goto L20;
        return false;
    L20:
        return TypeUtilsKt.isSubtypeOf(r16, r15.getExpandedType());
    L14:
        r15 = null;
        goto L15
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
    public List<Checks> getChecks$descriptors() {
        return checks;
    }
}
