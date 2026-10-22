package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Boolean hasStableParameterNames;
    private Boolean hasSynthesizedParameterNames;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 11) goto L6;
        if (r10 == 18) goto L6;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 11) goto L11;
        if (r10 == 18) goto L11;
        int r11 = 3;
    L12:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L14;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L21;
            case 9: goto L22;
            case 10: goto L20;
            case 11: goto L18;
            case 12: goto L19;
            case 13: goto L21;
            case 14: goto L17;
            case 15: goto L22;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L18;
            default: goto L14;
        };
    L14:
        r12[0] = "containingDeclaration";
    L24:
        if (r10 == 11) goto L28;
        if (r10 == 18) goto L27;
        r12[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
    L29:
        switch(r10) {
            case 4: goto L34;
            case 5: goto L34;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L35;
            case 12: goto L32;
            case 13: goto L32;
            case 14: goto L32;
            case 15: goto L32;
            case 16: goto L31;
            case 17: goto L31;
            case 18: goto L35;
            default: goto L30;
        };
    L30:
        r12[2] = "<init>";
        goto L35
    L31:
        r12[2] = "enhance";
        goto L35
    L32:
        r12[2] = "createDescriptor";
        goto L35
    L33:
        r12[2] = "createSubstitutedCopy";
        goto L35
    L34:
        r12[2] = "createJavaConstructor";
    L35:
        String r13 = String.format(r5, r12);
        if (r10 == 11) goto L40;
        if (r10 == 18) goto L40;
        throw new IllegalArgumentException(r13);
    L40:
        throw new IllegalStateException(r13);
    L27:
        r12[1] = "enhance";
        goto L29
    L28:
        r12[1] = "createSubstitutedCopy";
        goto L29
    L15:
        r12[0] = "enhancedReturnType";
        goto L24
    L16:
        r12[0] = "enhancedValueParameterTypes";
        goto L24
    L17:
        r12[0] = "sourceElement";
        goto L24
    L18:
        r12[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        goto L24
    L19:
        r12[0] = "newOwner";
        goto L24
    L20:
        r12[0] = "source";
        goto L24
    L21:
        r12[0] = "kind";
        goto L24
    L22:
        r12[0] = "annotations";
    L11:
        r11 = 2;
    L6:
        r5 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public JavaClassConstructorDescriptor(ClassDescriptor r5, JavaClassConstructorDescriptor r10, Annotations r11, boolean r12, CallableMemberDescriptor.Kind r13, SourceElement r14) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r14 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r5, r10, r11, r12, r13, r14);
        this.hasStableParameterNames = null;
        this.hasSynthesizedParameterNames = null;
    }

    public static JavaClassConstructorDescriptor createJavaConstructor(ClassDescriptor r10, Annotations r11, boolean r12, SourceElement r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r13 != null) goto L9;
        $$$reportNull$$$0(6);
    L9:
        return new JavaClassConstructorDescriptor(r10, null, r11, r12, CallableMemberDescriptor.Kind.DECLARATION, r13);
    }

    public JavaClassConstructorDescriptor createDescriptor(ClassDescriptor r10, JavaClassConstructorDescriptor r11, CallableMemberDescriptor.Kind r12, SourceElement r13, Annotations r14) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        if (r14 != null) goto L11;
        $$$reportNull$$$0(15);
    L11:
        return new JavaClassConstructorDescriptor(r10, r11, r14, this.isPrimary, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r5, FunctionDescriptor r10, CallableMemberDescriptor.Kind r11, Name r12, Annotations r13, SourceElement r14) {
        return createSubstitutedCopy(r5, r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType r5, List r10, KotlinType r11, Pair r12) {
        return enhance(r5, r10, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public void setHasStableParameterNames(boolean r5) {
        this.hasStableParameterNames = Boolean.valueOf(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public void setHasSynthesizedParameterNames(boolean r5) {
        this.hasSynthesizedParameterNames = Boolean.valueOf(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r5, FunctionDescriptor r10, CallableMemberDescriptor.Kind r11, Name r12, Annotations r13, SourceElement r14) {
        return createSubstitutedCopy(r5, r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaClassConstructorDescriptor enhance(KotlinType r13, List<KotlinType> r14, KotlinType r15, Pair<CallableDescriptor.UserDataKey<?>, ?> r16) {
        if (r14 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        if (r15 != null) goto L7;
        $$$reportNull$$$0(17);
    L7:
        JavaClassConstructorDescriptor r5 = createSubstitutedCopy(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
        if (r13 != null) goto L11;
        ReceiverParameterDescriptor r10 = null;
    L10:
        ReceiverParameterDescriptor r11 = r10;
        r5.initialize(r11, getDispatchReceiverParameter(), CollectionsKt.emptyList(), getTypeParameters(), UtilKt.copyValueParameters(r14, getValueParameters(), r5), r15, getModality(), getVisibility());
        if (r16 == null) goto L15;
        r5.putInUserDataMap(r16.getFirst(), r16.getSecond());
    L15:
        return r5;
    L11:
        r10 = DescriptorFactory.createExtensionReceiverParameterForCallable(r5, r13, Annotations.Companion.getEMPTY());
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public JavaClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(9);
    L8:
        if (r15 != null) goto L11;
        $$$reportNull$$$0(10);
    L11:
        if (r12 != CallableMemberDescriptor.Kind.DECLARATION) goto L13;
    L17:
        JavaClassConstructorDescriptor r16 = createDescriptor((ClassDescriptor) r10, (JavaClassConstructorDescriptor) r11, r12, r15, r14);
        r16.setHasStableParameterNames(hasStableParameterNames());
        r16.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
        return r16;
    L13:
        if (r12 == CallableMemberDescriptor.Kind.SYNTHESIZED) goto L17;
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + r10 + "\nkind: " + r12);
    }
}
