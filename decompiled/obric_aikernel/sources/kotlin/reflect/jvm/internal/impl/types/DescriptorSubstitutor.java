package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public class DescriptorSubstitutor {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 4) goto L5;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 4) goto L9;
        int r12 = 3;
    L10:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L12;
        };
    L12:
        r13[0] = "typeParameters";
    L18:
        if (r10 == 4) goto L20;
        r13[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
    L21:
        if (r10 == 4) goto L23;
        r13[2] = "substituteTypeParameters";
    L23:
        String r14 = String.format(r11, r13);
        if (r10 == 4) goto L27;
        throw new IllegalArgumentException(r14);
    L27:
        throw new IllegalStateException(r14);
    L20:
        r13[1] = "substituteTypeParameters";
        goto L21
    L13:
        r13[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        goto L18
    L14:
        r13[0] = "result";
        goto L18
    L15:
        r13[0] = "newContainingDeclaration";
        goto L18
    L16:
        r13[0] = "originalSubstitution";
        goto L18
    L9:
        r12 = 2;
        goto L10
    L5:
        r11 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> r10, TypeSubstitution r11, DeclarationDescriptor r12, List<TypeParameterDescriptor> r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        TypeSubstitutor r14 = substituteTypeParameters(r10, r11, r12, r13, null);
        if (r14 == null) goto L14;
        return r14;
    L14:
        throw new AssertionError("Substitution failed");
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> r16, TypeSubstitution r17, DeclarationDescriptor r18, List<TypeParameterDescriptor> r19, boolean[] r20) {
        if (r16 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        if (r17 != null) goto L7;
        $$$reportNull$$$0(6);
    L7:
        if (r18 != null) goto L9;
        $$$reportNull$$$0(7);
    L9:
        if (r19 != null) goto L11;
        $$$reportNull$$$0(8);
    L11:
        HashMap r10 = new HashMap();
        HashMap r11 = new HashMap();
        Iterator<TypeParameterDescriptor> r12 = r16.iterator();
        int r13 = 0;
    L13:
        if (r12.hasNext() == false) goto L15;
        TypeParameterDescriptor r14 = r12.next();
        TypeParameterDescriptorImpl r15 = TypeParameterDescriptorImpl.createForFurtherModification(r18, r14.getAnnotations(), r14.isReified(), r14.getVariance(), r14.getName(), r13, SourceElement.NO_SOURCE, r14.getStorageManager());
        r10.put(r14.getTypeConstructor(), new TypeProjectionImpl(r15.getDefaultType()));
        r11.put(r14, r15);
        r19.add(r15);
        r13 = r13 + 1;
        goto L13
    L15:
        TypeConstructorSubstitution r21 = TypeConstructorSubstitution.createByConstructorsMap(r10);
        TypeSubstitutor r22 = TypeSubstitutor.createChainedSubstitutor(r17, r21);
        TypeSubstitutor r23 = TypeSubstitutor.createChainedSubstitutor(r17.replaceWithNonApproximating(), r21);
        Iterator<TypeParameterDescriptor> r24 = r16.iterator();
    L17:
        if (r24.hasNext() == false) goto L36;
        TypeParameterDescriptor r25 = r24.next();
        TypeParameterDescriptorImpl r26 = (TypeParameterDescriptorImpl) r11.get(r25);
        Iterator<KotlinType> r27 = r25.getUpperBounds().iterator();
    L20:
        if (r27.hasNext() == false) goto L35;
        KotlinType r28 = r27.next();
        ClassifierDescriptor r29 = r28.getConstructor().mo1323getDeclarationDescriptor();
        if ((r29 instanceof TypeParameterDescriptor) == true) goto L24;
    L26:
        TypeSubstitutor r30 = r23;
    L27:
        KotlinType r31 = r30.substitute(r28, Variance.OUT_VARIANCE);
        if (r31 == null) goto L29;
        if (r31 == r28) goto L34;
        if (r20 == null) goto L34;
        r20[0] = true;
    L34:
        r26.addUpperBound(r31);
        goto L20
    L29:
        return null;
    L24:
        if (TypeUtilsKt.hasTypeParameterRecursiveBounds((TypeParameterDescriptor) r29) == false) goto L26;
        r30 = r22;
        goto L27
    L35:
        r26.setInitialized();
        goto L17
    L36:
        return r22;
    }
}
