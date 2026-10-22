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
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 11) goto L11;
        if (r10 == 18) goto L11;
        int r12 = 3;
    L12:
        Object[] r13 = new Object[r12];
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
        r13[0] = "containingDeclaration";
    L24:
        if (r10 == 11) goto L28;
        if (r10 == 18) goto L27;
        r13[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
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
        r13[2] = "<init>";
        goto L35
    L31:
        r13[2] = "enhance";
        goto L35
    L32:
        r13[2] = "createDescriptor";
        goto L35
    L33:
        r13[2] = "createSubstitutedCopy";
        goto L35
    L34:
        r13[2] = "createJavaConstructor";
    L35:
        String r14 = String.format(r11, r13);
        if (r10 == 11) goto L40;
        if (r10 == 18) goto L40;
        throw new IllegalArgumentException(r14);
    L40:
        throw new IllegalStateException(r14);
    L27:
        r13[1] = "enhance";
        goto L29
    L28:
        r13[1] = "createSubstitutedCopy";
        goto L29
    L15:
        r13[0] = "enhancedReturnType";
        goto L24
    L16:
        r13[0] = "enhancedValueParameterTypes";
        goto L24
    L17:
        r13[0] = "sourceElement";
        goto L24
    L18:
        r13[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        goto L24
    L19:
        r13[0] = "newOwner";
        goto L24
    L20:
        r13[0] = "source";
        goto L24
    L21:
        r13[0] = "kind";
        goto L24
    L22:
        r13[0] = "annotations";
    L11:
        r12 = 2;
    L6:
        r11 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
    }

    protected JavaClassConstructorDescriptor(ClassDescriptor r10, JavaClassConstructorDescriptor r11, Annotations r12, boolean r13, CallableMemberDescriptor.Kind r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r10, r11, r12, r13, r14, r15);
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

    protected JavaClassConstructorDescriptor createDescriptor(ClassDescriptor r10, JavaClassConstructorDescriptor r11, CallableMemberDescriptor.Kind r12, SourceElement r13, Annotations r14) {
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
    protected /* bridge */ /* synthetic */ ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        return createSubstitutedCopy(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        return createSubstitutedCopy(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected JavaClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
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

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType r10, List r11, KotlinType r12, Pair r13) {
        return enhance(r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaClassConstructorDescriptor enhance(KotlinType r13, List<KotlinType> r14, KotlinType r15, Pair<CallableDescriptor.UserDataKey<?>, ?> r16) {
        if (r14 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        if (r15 != null) goto L7;
        $$$reportNull$$$0(17);
    L7:
        JavaClassConstructorDescriptor r10 = createSubstitutedCopy(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
        if (r13 != null) goto L10;
        ReceiverParameterDescriptor r11 = null;
    L11:
        r10.initialize(r11, getDispatchReceiverParameter(), CollectionsKt.emptyList(), getTypeParameters(), UtilKt.copyValueParameters(r14, getValueParameters(), r10), r15, getModality(), getVisibility());
        if (r16 == null) goto L14;
        r10.putInUserDataMap(r16.getFirst(), r16.getSecond());
    L14:
        return r10;
    L10:
        r11 = DescriptorFactory.createExtensionReceiverParameterForCallable(r10, r13, Annotations.Companion.getEMPTY());
        goto L11
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
    public void setHasStableParameterNames(boolean r10) {
        this.hasStableParameterNames = Boolean.valueOf(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public void setHasSynthesizedParameterNames(boolean r10) {
        this.hasSynthesizedParameterNames = Boolean.valueOf(r10);
    }
}
