package kotlin.reflect.jvm.internal.impl.resolve;

import com.bytedance.crash.entity.EventBody;
import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public class DescriptorFactory {

    private static class DefaultClassConstructorDescriptor extends ClassConstructorDescriptorImpl {
        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            Object[] r11 = new Object[3];
            if (r10 == 1) goto L5;
            r11[0] = "containingClass";
        L6:
            r11[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            r11[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
        L5:
            r11[0] = "source";
            goto L6
        }

        public DefaultClassConstructorDescriptor(ClassDescriptor r10, SourceElement r11, boolean r12) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r11 != null) goto L6;
            $$$reportNull$$$0(1);
        L6:
            super(r10, null, Annotations.Companion.getEMPTY(), true, CallableMemberDescriptor.Kind.DECLARATION, r11);
            initialize(Collections.emptyList(), DescriptorUtils.getDefaultConstructorVisibility(r10, r12));
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r11) {
        if (r11 == 12) goto L7;
        if (r11 == 23) goto L7;
        if (r11 == 25) goto L7;
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r11 == 12) goto L13;
        if (r11 == 23) goto L13;
        if (r11 == 25) goto L13;
        int r12 = 3;
    L14:
        Object[] r13 = new Object[r12];
        switch(r11) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L16;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L16;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L24;
            case 12: goto L22;
            case 13: goto L16;
            case 14: goto L26;
            case 15: goto L16;
            case 16: goto L26;
            case 17: goto L16;
            case 18: goto L26;
            case 19: goto L24;
            case 20: goto L21;
            case 21: goto L20;
            case 22: goto L19;
            case 23: goto L22;
            case 24: goto L19;
            case 25: goto L22;
            case 26: goto L18;
            case 27: goto L18;
            case 28: goto L18;
            case 29: goto L17;
            case 30: goto L26;
            case 31: goto L17;
            case 32: goto L26;
            case 33: goto L17;
            case 34: goto L26;
            default: goto L16;
        };
    L16:
        r13[0] = "propertyDescriptor";
    L28:
        if (r11 == 12) goto L34;
        if (r11 == 23) goto L33;
        if (r11 == 25) goto L32;
        r13[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
    L35:
        switch(r11) {
            case 3: goto L48;
            case 4: goto L48;
            case 5: goto L48;
            case 6: goto L48;
            case 7: goto L48;
            case 8: goto L48;
            case 9: goto L48;
            case 10: goto L48;
            case 11: goto L48;
            case 12: goto L49;
            case 13: goto L47;
            case 14: goto L47;
            case 15: goto L46;
            case 16: goto L46;
            case 17: goto L46;
            case 18: goto L46;
            case 19: goto L46;
            case 20: goto L45;
            case 21: goto L45;
            case 22: goto L44;
            case 23: goto L49;
            case 24: goto L43;
            case 25: goto L49;
            case 26: goto L42;
            case 27: goto L41;
            case 28: goto L40;
            case 29: goto L39;
            case 30: goto L39;
            case 31: goto L38;
            case 32: goto L38;
            case 33: goto L37;
            case 34: goto L37;
            default: goto L36;
        };
    L36:
        r13[2] = "createDefaultSetter";
        goto L49
    L37:
        r13[2] = "createContextReceiverParameterForClass";
        goto L49
    L38:
        r13[2] = "createContextReceiverParameterForCallable";
        goto L49
    L39:
        r13[2] = "createExtensionReceiverParameterForCallable";
        goto L49
    L40:
        r13[2] = "isEnumSpecialMethod";
        goto L49
    L41:
        r13[2] = "isEnumValueOfMethod";
        goto L49
    L42:
        r13[2] = "isEnumValuesMethod";
        goto L49
    L43:
        r13[2] = "createEnumValueOfMethod";
        goto L49
    L44:
        r13[2] = "createEnumValuesMethod";
        goto L49
    L45:
        r13[2] = "createPrimaryConstructorForObject";
        goto L49
    L46:
        r13[2] = "createGetter";
        goto L49
    L47:
        r13[2] = "createDefaultGetter";
        goto L49
    L48:
        r13[2] = "createSetter";
    L49:
        String r14 = String.format(r10, r13);
        if (r11 == 12) goto L55;
        if (r11 == 23) goto L55;
        if (r11 == 25) goto L55;
        throw new IllegalArgumentException(r14);
    L55:
        throw new IllegalStateException(r14);
    L32:
        r13[1] = "createEnumValueOfMethod";
        goto L35
    L33:
        r13[1] = "createEnumValuesMethod";
        goto L35
    L34:
        r13[1] = "createSetter";
        goto L35
    L17:
        r13[0] = "owner";
        goto L28
    L18:
        r13[0] = "descriptor";
        goto L28
    L19:
        r13[0] = "enumClass";
        goto L28
    L20:
        r13[0] = "source";
        goto L28
    L21:
        r13[0] = "containingClass";
        goto L28
    L22:
        r13[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        goto L28
    L23:
        r13[0] = "visibility";
        goto L28
    L24:
        r13[0] = "sourceElement";
        goto L28
    L25:
        r13[0] = "parameterAnnotations";
        goto L28
    L26:
        r13[0] = "annotations";
    L13:
        r12 = 2;
    L7:
        r10 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public static ReceiverParameterDescriptor createContextReceiverParameterForCallable(CallableDescriptor r10, KotlinType r11, Annotations r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(31);
    L4:
        if (r12 != null) goto L7;
        $$$reportNull$$$0(32);
    L7:
        if (r11 != null) goto L10;
        return null;
    L10:
        return new ReceiverParameterDescriptorImpl(r10, new ContextReceiver(r10, r11, null), r12);
    }

    public static ReceiverParameterDescriptor createContextReceiverParameterForClass(ClassDescriptor r10, KotlinType r11, Annotations r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(33);
    L4:
        if (r12 != null) goto L7;
        $$$reportNull$$$0(34);
    L7:
        if (r11 != null) goto L10;
        return null;
    L10:
        return new ReceiverParameterDescriptorImpl(r10, new ContextClassReceiver(r10, r11, null), r12);
    }

    public static PropertyGetterDescriptorImpl createDefaultGetter(PropertyDescriptor r10, Annotations r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(14);
    L7:
        return createGetter(r10, r11, true, false, false);
    }

    public static PropertySetterDescriptorImpl createDefaultSetter(PropertyDescriptor r10, Annotations r11, Annotations r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L9;
        $$$reportNull$$$0(2);
    L9:
        return createSetter(r10, r11, r12, true, false, false, r10.getSource());
    }

    public static SimpleFunctionDescriptor createEnumValueOfMethod(ClassDescriptor r18) {
        if (r18 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        Annotations.Companion r10 = Annotations.Companion;
        SimpleFunctionDescriptorImpl r11 = SimpleFunctionDescriptorImpl.create(r18, r10.getEMPTY(), StandardNames.ENUM_VALUE_OF, CallableMemberDescriptor.Kind.SYNTHESIZED, r18.getSource());
        ValueParameterDescriptorImpl r12 = new ValueParameterDescriptorImpl(r11, null, 0, r10.getEMPTY(), Name.identifier(EventBody.KEY_VALUE), DescriptorUtilsKt.getBuiltIns(r18).getStringType(), false, false, false, null, r18.getSource());
        SimpleFunctionDescriptorImpl r13 = r11.initialize(null, null, Collections.emptyList(), Collections.emptyList(), Collections.singletonList(r12), r18.getDefaultType(), Modality.FINAL, DescriptorVisibilities.PUBLIC);
        if (r13 != null) goto L8;
        $$$reportNull$$$0(25);
    L8:
        return r13;
    }

    public static SimpleFunctionDescriptor createEnumValuesMethod(ClassDescriptor r13) {
        if (r13 != null) goto L4;
        $$$reportNull$$$0(22);
    L4:
        SimpleFunctionDescriptorImpl r14 = SimpleFunctionDescriptorImpl.create(r13, Annotations.Companion.getEMPTY(), StandardNames.ENUM_VALUES, CallableMemberDescriptor.Kind.SYNTHESIZED, r13.getSource()).initialize(null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), DescriptorUtilsKt.getBuiltIns(r13).getArrayType(Variance.INVARIANT, r13.getDefaultType()), Modality.FINAL, DescriptorVisibilities.PUBLIC);
        if (r14 != null) goto L7;
        $$$reportNull$$$0(23);
    L7:
        return r14;
    }

    public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(CallableDescriptor r10, KotlinType r11, Annotations r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(29);
    L4:
        if (r12 != null) goto L7;
        $$$reportNull$$$0(30);
    L7:
        if (r11 != null) goto L10;
        return null;
    L10:
        return new ReceiverParameterDescriptorImpl(r10, new ExtensionReceiver(r10, r11, null), r12);
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor r10, Annotations r11, boolean r12, boolean r13, boolean r14) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(16);
    L7:
        return createGetter(r10, r11, r12, r13, r14, r10.getSource());
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor r12, Annotations r13, boolean r14, boolean r15, boolean r16, SourceElement r17) {
        if (r12 != null) goto L4;
        $$$reportNull$$$0(17);
    L4:
        if (r13 != null) goto L6;
        $$$reportNull$$$0(18);
    L6:
        if (r17 != null) goto L9;
        $$$reportNull$$$0(19);
    L9:
        return new PropertyGetterDescriptorImpl(r12, r13, r12.getModality(), r12.getVisibility(), r14, r15, r16, CallableMemberDescriptor.Kind.DECLARATION, null, r17);
    }

    public static ClassConstructorDescriptorImpl createPrimaryConstructorForObject(ClassDescriptor r10, SourceElement r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(21);
    L7:
        return new DefaultClassConstructorDescriptor(r10, r11, false);
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor r13, Annotations r14, Annotations r15, boolean r16, boolean r17, boolean r18, DescriptorVisibility r19, SourceElement r20) {
        if (r13 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        if (r14 != null) goto L7;
        $$$reportNull$$$0(8);
    L7:
        if (r15 != null) goto L9;
        $$$reportNull$$$0(9);
    L9:
        if (r19 != null) goto L11;
        $$$reportNull$$$0(10);
    L11:
        if (r20 != null) goto L13;
        $$$reportNull$$$0(11);
    L13:
        PropertySetterDescriptorImpl r12 = new PropertySetterDescriptorImpl(r13, r14, r13.getModality(), r19, r16, r17, r18, CallableMemberDescriptor.Kind.DECLARATION, null, r20);
        r12.initialize(PropertySetterDescriptorImpl.createSetterParameter(r12, r13.getType(), r15));
        return r12;
    }

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor r10, Annotations r11, Annotations r12, boolean r13, boolean r14, boolean r15, SourceElement r16) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(4);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(5);
    L8:
        if (r16 != null) goto L11;
        $$$reportNull$$$0(6);
    L11:
        return createSetter(r10, r11, r12, r13, r14, r15, r10.getVisibility(), r16);
    }

    private static boolean isEnumSpecialMethod(FunctionDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(28);
    L5:
        if (r10.getKind() == CallableMemberDescriptor.Kind.SYNTHESIZED) goto L7;
    L9:
        return false;
    L7:
        if (DescriptorUtils.isEnumClass(r10.getContainingDeclaration()) == false) goto L9;
        return true;
    }

    public static boolean isEnumValueOfMethod(FunctionDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        if (r10.getName().equals(StandardNames.ENUM_VALUE_OF) == true) goto L7;
    L9:
        return false;
    L7:
        if (isEnumSpecialMethod(r10) == false) goto L9;
        return true;
    }

    public static boolean isEnumValuesMethod(FunctionDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(26);
    L5:
        if (r10.getName().equals(StandardNames.ENUM_VALUES) == true) goto L7;
    L9:
        return false;
    L7:
        if (isEnumSpecialMethod(r10) == false) goto L9;
        return true;
    }
}
