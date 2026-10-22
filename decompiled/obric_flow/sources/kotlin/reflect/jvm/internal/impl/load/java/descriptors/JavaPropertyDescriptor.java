package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class JavaPropertyDescriptor extends PropertyDescriptorImpl implements JavaCallableMemberDescriptor {
    private KotlinType inType;
    private final boolean isStaticFinal;
    private final Pair<CallableDescriptor.UserDataKey<?>, ?> singleUserData;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 21) goto L5;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 21) goto L9;
        int r11 = 3;
    L10:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L12;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L24;
            case 11: goto L23;
            case 12: goto L22;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L18;
            case 16: goto L21;
            case 17: goto L17;
            case 18: goto L22;
            case 19: goto L16;
            case 20: goto L15;
            case 21: goto L14;
            case 22: goto L13;
            default: goto L12;
        };
    L12:
        r12[0] = "containingDeclaration";
    L28:
        if (r10 == 21) goto L30;
        r12[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
    L31:
        switch(r10) {
            case 7: goto L36;
            case 8: goto L36;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L35;
            case 14: goto L35;
            case 15: goto L35;
            case 16: goto L35;
            case 17: goto L35;
            case 18: goto L35;
            case 19: goto L34;
            case 20: goto L34;
            case 21: goto L37;
            case 22: goto L33;
            default: goto L32;
        };
    L32:
        r12[2] = "<init>";
        goto L37
    L33:
        r12[2] = "setInType";
        goto L37
    L34:
        r12[2] = "enhance";
        goto L37
    L35:
        r12[2] = "createSubstitutedCopy";
        goto L37
    L36:
        r12[2] = "create";
    L37:
        String r13 = String.format(r5, r12);
        if (r10 == 21) goto L41;
        throw new IllegalArgumentException(r13);
    L41:
        throw new IllegalStateException(r13);
    L30:
        r12[1] = "enhance";
        goto L31
    L13:
        r12[0] = "inType";
        goto L28
    L14:
        r12[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        goto L28
    L15:
        r12[0] = "enhancedReturnType";
        goto L28
    L16:
        r12[0] = "enhancedValueParameterTypes";
        goto L28
    L17:
        r12[0] = "newName";
        goto L28
    L18:
        r12[0] = "newVisibility";
        goto L28
    L19:
        r12[0] = "newModality";
        goto L28
    L20:
        r12[0] = "newOwner";
        goto L28
    L21:
        r12[0] = "kind";
        goto L28
    L22:
        r12[0] = "source";
        goto L28
    L23:
        r12[0] = "name";
        goto L28
    L24:
        r12[0] = "visibility";
        goto L28
    L25:
        r12[0] = "modality";
        goto L28
    L26:
        r12[0] = "annotations";
        goto L28
    L9:
        r11 = 2;
        goto L10
    L5:
        r5 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public JavaPropertyDescriptor(DeclarationDescriptor r18, Annotations r19, Modality r20, DescriptorVisibility r21, boolean r22, Name r23, SourceElement r24, PropertyDescriptor r25, CallableMemberDescriptor.Kind r26, boolean r27, Pair<CallableDescriptor.UserDataKey<?>, ?> r28) {
        if (r18 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if (r19 != null) goto L7;
        $$$reportNull$$$0(1);
    L7:
        if (r20 != null) goto L9;
        $$$reportNull$$$0(2);
    L9:
        if (r21 != null) goto L11;
        $$$reportNull$$$0(3);
    L11:
        if (r23 != null) goto L13;
        $$$reportNull$$$0(4);
    L13:
        if (r24 != null) goto L15;
        $$$reportNull$$$0(5);
    L15:
        if (r26 != null) goto L17;
        $$$reportNull$$$0(6);
    L17:
        super(r18, r25, r19, r20, r21, r22, r23, r26, r24, false, false, false, false, false, false);
        this.inType = null;
        this.isStaticFinal = r27;
        this.singleUserData = r28;
    }

    public static JavaPropertyDescriptor create(DeclarationDescriptor r13, Annotations r14, Modality r15, DescriptorVisibility r16, boolean r17, Name r18, SourceElement r19, boolean r20) {
        if (r13 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r14 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r15 != null) goto L8;
        $$$reportNull$$$0(9);
    L8:
        if (r16 != null) goto L10;
        $$$reportNull$$$0(10);
    L10:
        if (r18 != null) goto L12;
        $$$reportNull$$$0(11);
    L12:
        if (r19 != null) goto L15;
        $$$reportNull$$$0(12);
    L15:
        return new JavaPropertyDescriptor(r13, r14, r15, r16, r17, r18, r19, null, CallableMemberDescriptor.Kind.DECLARATION, r20, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    public PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r14, Modality r15, DescriptorVisibility r16, PropertyDescriptor r17, CallableMemberDescriptor.Kind r18, Name r19, SourceElement r20) {
        if (r14 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        if (r15 != null) goto L7;
        $$$reportNull$$$0(14);
    L7:
        if (r16 != null) goto L9;
        $$$reportNull$$$0(15);
    L9:
        if (r18 != null) goto L11;
        $$$reportNull$$$0(16);
    L11:
        if (r19 != null) goto L13;
        $$$reportNull$$$0(17);
    L13:
        if (r20 != null) goto L16;
        $$$reportNull$$$0(18);
    L16:
        return new JavaPropertyDescriptor(r14, getAnnotations(), r15, r16, isVar(), r19, r20, r17, r18, this.isStaticFinal, this.singleUserData);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaCallableMemberDescriptor enhance(KotlinType r19, List<KotlinType> r20, KotlinType r21, Pair<CallableDescriptor.UserDataKey<?>, ?> r22) {
        if (r20 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        if (r21 != null) goto L8;
        $$$reportNull$$$0(20);
    L8:
        if (getOriginal() != this) goto L10;
        PropertyDescriptor r5 = null;
    L11:
        PropertyDescriptor r13 = r5;
        JavaPropertyDescriptor r15 = new JavaPropertyDescriptor(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), r13, getKind(), this.isStaticFinal, r22);
        PropertyGetterDescriptorImpl r16 = getGetter();
        if (r16 == null) goto L18;
        Annotations r10 = r16.getAnnotations();
        Modality r11 = r16.getModality();
        DescriptorVisibility r12 = r16.getVisibility();
        boolean r14 = r16.isDefault();
        boolean r17 = r16.isExternal();
        boolean r18 = r16.isInline();
        CallableMemberDescriptor.Kind r110 = getKind();
        if (r5 != null) goto L16;
        PropertyGetterDescriptor r111 = null;
    L17:
        PropertyGetterDescriptorImpl r23 = r15;
        PropertyGetterDescriptorImpl r112 = new PropertyGetterDescriptorImpl(r15, r10, r11, r12, r14, r17, r18, r110, r111, r16.getSource());
        r23.setInitialSignatureDescriptor(r16.getInitialSignatureDescriptor());
        r23.initialize(r21);
    L19:
        PropertySetterDescriptor r113 = getSetter();
        if (r113 == null) goto L26;
        Annotations r24 = r113.getAnnotations();
        Modality r25 = r113.getModality();
        DescriptorVisibility r26 = r113.getVisibility();
        boolean r114 = r113.isDefault();
        boolean r115 = r113.isExternal();
        boolean r116 = r113.isInline();
        CallableMemberDescriptor.Kind r117 = getKind();
        if (r5 != null) goto L24;
        PropertySetterDescriptor r118 = null;
    L25:
        PropertySetterDescriptorImpl r119 = new PropertySetterDescriptorImpl(r15, r24, r25, r26, r114, r115, r116, r117, r118, r113.getSource());
        r119.setInitialSignatureDescriptor(r119.getInitialSignatureDescriptor());
        r119.initialize(r113.getValueParameters().get(0));
        PropertySetterDescriptorImpl r120 = r119;
    L27:
        r15.initialize(r23, r120, getBackingField(), getDelegateField());
        r15.setSetterProjectedOut(isSetterProjectedOut());
        Function0<NullableLazyValue<ConstantValue<?>>> r27 = this.compileTimeInitializerFactory;
        if (r27 == null) goto L30;
        r15.setCompileTimeInitializer(this.compileTimeInitializer, r27);
    L30:
        r15.setOverriddenDescriptors(getOverriddenDescriptors());
        if (r19 != null) goto L33;
        ReceiverParameterDescriptor r28 = null;
    L34:
        r15.setType(r21, getTypeParameters(), getDispatchReceiverParameter(), r28, CollectionsKt.emptyList());
        return r15;
    L33:
        r28 = DescriptorFactory.createExtensionReceiverParameterForCallable(this, r19, Annotations.Companion.getEMPTY());
        goto L34
    L24:
        r118 = r5.getSetter();
        goto L25
    L26:
        r120 = null;
        goto L27
    L16:
        r111 = r5.getGetter();
        goto L17
    L18:
        r23 = null;
        goto L19
    L10:
        r5 = getOriginal();
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r5) {
        Pair<CallableDescriptor.UserDataKey<?>, ?> r10 = this.singleUserData;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.getFirst().equals(r5) == true) goto L7;
        return null;
    L7:
        return (V) this.singleUserData.getSecond();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        KotlinType r5 = getType();
        if (this.isStaticFinal == true) goto L5;
    L11:
        return false;
    L5:
        if (ConstUtil.canBeUsedForConstVal(r5) == false) goto L11;
        if (TypeEnhancementKt.hasEnhancedNullability(r5) == true) goto L9;
    L10:
        return true;
    L9:
        if (KotlinBuiltIns.isString(r5) == false) goto L11;
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    public void setInType(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(22);
    L4:
        this.inType = r5;
    }
}
