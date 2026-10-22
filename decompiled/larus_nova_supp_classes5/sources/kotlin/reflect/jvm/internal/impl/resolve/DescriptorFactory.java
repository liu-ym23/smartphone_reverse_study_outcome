package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DescriptorFactory {
    private static /* synthetic */ void $$$reportNull$$$0(int r11) {
        if (r11 == 12) goto L7;
        if (r11 == 23) goto L7;
        if (r11 == 25) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r11 == 12) goto L13;
        if (r11 == 23) goto L13;
        if (r11 == 25) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
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
            case 26: goto L19;
            case 27: goto L18;
            case 28: goto L18;
            case 29: goto L18;
            case 30: goto L17;
            case 31: goto L26;
            case 32: goto L17;
            case 33: goto L26;
            case 34: goto L17;
            case 35: goto L26;
            default: goto L16;
        };
    L16:
        r6[0] = "propertyDescriptor";
    L28:
        if (r11 == 12) goto L34;
        if (r11 == 23) goto L33;
        if (r11 == 25) goto L32;
        r6[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
    L35:
        switch(r11) {
            case 3: goto L49;
            case 4: goto L49;
            case 5: goto L49;
            case 6: goto L49;
            case 7: goto L49;
            case 8: goto L49;
            case 9: goto L49;
            case 10: goto L49;
            case 11: goto L49;
            case 12: goto L50;
            case 13: goto L48;
            case 14: goto L48;
            case 15: goto L47;
            case 16: goto L47;
            case 17: goto L47;
            case 18: goto L47;
            case 19: goto L47;
            case 20: goto L46;
            case 21: goto L46;
            case 22: goto L45;
            case 23: goto L50;
            case 24: goto L44;
            case 25: goto L50;
            case 26: goto L43;
            case 27: goto L42;
            case 28: goto L41;
            case 29: goto L40;
            case 30: goto L39;
            case 31: goto L39;
            case 32: goto L38;
            case 33: goto L38;
            case 34: goto L37;
            case 35: goto L37;
            default: goto L36;
        };
    L36:
        r6[2] = "createDefaultSetter";
        goto L50
    L37:
        r6[2] = "createContextReceiverParameterForClass";
        goto L50
    L38:
        r6[2] = "createContextReceiverParameterForCallable";
        goto L50
    L39:
        r6[2] = "createExtensionReceiverParameterForCallable";
        goto L50
    L40:
        r6[2] = "isEnumSpecialMethod";
        goto L50
    L41:
        r6[2] = "isEnumValueOfMethod";
        goto L50
    L42:
        r6[2] = "isEnumValuesMethod";
        goto L50
    L43:
        r6[2] = "createEnumEntriesProperty";
        goto L50
    L44:
        r6[2] = "createEnumValueOfMethod";
        goto L50
    L45:
        r6[2] = "createEnumValuesMethod";
        goto L50
    L46:
        r6[2] = "createPrimaryConstructorForObject";
        goto L50
    L47:
        r6[2] = "createGetter";
        goto L50
    L48:
        r6[2] = "createDefaultGetter";
        goto L50
    L49:
        r6[2] = "createSetter";
    L50:
        String r4 = String.format(r3, r6);
        if (r11 == 12) goto L56;
        if (r11 == 23) goto L56;
        if (r11 == 25) goto L56;
        throw new IllegalArgumentException(r4);
    L56:
        throw new IllegalStateException(r4);
    L32:
        r6[1] = "createEnumValueOfMethod";
        goto L35
    L33:
        r6[1] = "createEnumValuesMethod";
        goto L35
    L34:
        r6[1] = "createSetter";
        goto L35
    L17:
        r6[0] = "owner";
        goto L28
    L18:
        r6[0] = "descriptor";
        goto L28
    L19:
        r6[0] = "enumClass";
        goto L28
    L20:
        r6[0] = "source";
        goto L28
    L21:
        r6[0] = "containingClass";
        goto L28
    L22:
        r6[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        goto L28
    L23:
        r6[0] = "visibility";
        goto L28
    L24:
        r6[0] = "sourceElement";
        goto L28
    L25:
        r6[0] = "parameterAnnotations";
        goto L28
    L26:
        r6[0] = "annotations";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public static PropertyDescriptor createEnumEntriesProperty(ClassDescriptor r26) {
        if (r26 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        ModuleDescriptor r0 = DescriptorUtils.getContainingModule(r26);
        ClassDescriptor r14 = StdlibClassFinderKt.getStdlibClassFinder(r0).findEnumEntriesClass(r0);
        if (r14 != null) goto L7;
        return null;
    L7:
        Annotations.Companion r16 = Annotations.Companion;
        Annotations r1 = r16.getEMPTY();
        Modality r17 = Modality.FINAL;
        DescriptorVisibility r18 = DescriptorVisibilities.PUBLIC;
        Name r5 = StandardNames.ENUM_ENTRIES;
        CallableMemberDescriptor.Kind r19 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        PropertyDescriptorImpl r2 = PropertyDescriptorImpl.create(r26, r1, r17, r18, false, r5, r19, r26.getSource(), false, false, false, false, false, false);
        PropertyGetterDescriptorImpl r3 = new PropertyGetterDescriptorImpl(r2, r16.getEMPTY(), r17, r18, false, false, false, r19, null, r26.getSource());
        r2.initialize(r3, null);
        r2.setType(KotlinTypeFactory.simpleType(TypeAttributes.Companion.getEmpty(), r14.getTypeConstructor(), Collections.singletonList(new TypeProjectionImpl(r26.getDefaultType())), false), Collections.emptyList(), null, null, Collections.emptyList());
        r3.initialize(r2.getReturnType());
        return r2;
    }

    public static SimpleFunctionDescriptor createEnumValueOfMethod(ClassDescriptor r18) {
        if (r18 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        Annotations.Companion r1 = Annotations.Companion;
        SimpleFunctionDescriptorImpl r2 = SimpleFunctionDescriptorImpl.create(r18, r1.getEMPTY(), StandardNames.ENUM_VALUE_OF, CallableMemberDescriptor.Kind.SYNTHESIZED, r18.getSource());
        ValueParameterDescriptorImpl r3 = new ValueParameterDescriptorImpl(r2, null, 0, r1.getEMPTY(), Name.identifier("value"), DescriptorUtilsKt.getBuiltIns(r18).getStringType(), false, false, false, null, r18.getSource());
        SimpleFunctionDescriptorImpl r0 = r2.initialize(null, null, Collections.emptyList(), Collections.emptyList(), Collections.singletonList(r3), r18.getDefaultType(), Modality.FINAL, DescriptorVisibilities.PUBLIC);
        if (r0 != null) goto L8;
        $$$reportNull$$$0(25);
    L8:
        return r0;
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

    private static boolean isEnumSpecialMethod(FunctionDescriptor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(29);
    L5:
        if (r2.getKind() == CallableMemberDescriptor.Kind.SYNTHESIZED) goto L7;
    L9:
        return false;
    L7:
        if (DescriptorUtils.isEnumClass(r2.getContainingDeclaration()) == false) goto L9;
        return true;
    }

    public static boolean isEnumValueOfMethod(FunctionDescriptor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(28);
    L5:
        if (r2.getName().equals(StandardNames.ENUM_VALUE_OF) == true) goto L7;
    L9:
        return false;
    L7:
        if (isEnumSpecialMethod(r2) == false) goto L9;
        return true;
    }

    public static boolean isEnumValuesMethod(FunctionDescriptor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        if (r2.getName().equals(StandardNames.ENUM_VALUES) == true) goto L7;
    L9:
        return false;
    L7:
        if (isEnumSpecialMethod(r2) == false) goto L9;
        return true;
    }

    public static PropertyGetterDescriptorImpl createDefaultGetter(PropertyDescriptor r2, Annotations r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(14);
    L7:
        return createGetter(r2, r3, true, false, false);
    }

    public static ClassConstructorDescriptorImpl createPrimaryConstructorForObject(ClassDescriptor r2, SourceElement r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(21);
    L7:
        return new DefaultClassConstructorDescriptor(r2, r3, false);
    }

    public static PropertySetterDescriptorImpl createDefaultSetter(PropertyDescriptor r8, Annotations r9, Annotations r10) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r10 != null) goto L9;
        $$$reportNull$$$0(2);
    L9:
        return createSetter(r8, r9, r10, true, false, false, r8.getSource());
    }

    public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(CallableDescriptor r3, KotlinType r4, Annotations r5) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        if (r5 != null) goto L7;
        $$$reportNull$$$0(31);
    L7:
        if (r4 != null) goto L10;
        return null;
    L10:
        return new ReceiverParameterDescriptorImpl(r3, new ExtensionReceiver(r3, r4, null), r5);
    }

    public static ReceiverParameterDescriptor createContextReceiverParameterForCallable(CallableDescriptor r3, KotlinType r4, Name r5, Annotations r6, int r7) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(32);
    L4:
        if (r6 != null) goto L7;
        $$$reportNull$$$0(33);
    L7:
        if (r4 != null) goto L10;
        return null;
    L10:
        return new ReceiverParameterDescriptorImpl(r3, new ContextReceiver(r3, r4, r5, null), r6, NameUtils.contextReceiverName(r7));
    }

    public static ReceiverParameterDescriptor createContextReceiverParameterForClass(ClassDescriptor r3, KotlinType r4, Name r5, Annotations r6, int r7) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(34);
    L4:
        if (r6 != null) goto L7;
        $$$reportNull$$$0(35);
    L7:
        if (r4 != null) goto L10;
        return null;
    L10:
        return new ReceiverParameterDescriptorImpl(r3, new ContextClassReceiver(r3, r4, r5, null), r6, NameUtils.contextReceiverName(r7));
    }

    public static PropertyGetterDescriptorImpl createGetter(PropertyDescriptor r7, Annotations r8, boolean r9, boolean r10, boolean r11) {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        if (r8 != null) goto L7;
        $$$reportNull$$$0(16);
    L7:
        return createGetter(r7, r8, r9, r10, r11, r7.getSource());
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

    public static PropertySetterDescriptorImpl createSetter(PropertyDescriptor r9, Annotations r10, Annotations r11, boolean r12, boolean r13, boolean r14, SourceElement r15) {
        if (r9 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(4);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(5);
    L8:
        if (r15 != null) goto L11;
        $$$reportNull$$$0(6);
    L11:
        return createSetter(r9, r10, r11, r12, r13, r14, r9.getVisibility(), r15);
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
}
