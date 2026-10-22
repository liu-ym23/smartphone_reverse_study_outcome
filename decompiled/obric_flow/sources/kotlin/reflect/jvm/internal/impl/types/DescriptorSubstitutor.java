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
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 4) goto L9;
        int r11 = 3;
    L10:
        Object[] r12 = new Object[r11];
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
        r12[0] = "typeParameters";
    L18:
        if (r10 == 4) goto L20;
        r12[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
    L21:
        if (r10 == 4) goto L23;
        r12[2] = "substituteTypeParameters";
    L23:
        String r13 = String.format(r5, r12);
        if (r10 == 4) goto L27;
        throw new IllegalArgumentException(r13);
    L27:
        throw new IllegalStateException(r13);
    L20:
        r12[1] = "substituteTypeParameters";
        goto L21
    L13:
        r12[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        goto L18
    L14:
        r12[0] = "result";
        goto L18
    L15:
        r12[0] = "newContainingDeclaration";
        goto L18
    L16:
        r12[0] = "originalSubstitution";
        goto L18
    L9:
        r11 = 2;
        goto L10
    L5:
        r5 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> r5, TypeSubstitution r10, DeclarationDescriptor r11, List<TypeParameterDescriptor> r12) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        TypeSubstitutor r13 = substituteTypeParameters(r5, r10, r11, r12, null);
        if (r13 == null) goto L14;
        return r13;
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
        HashMap r5 = new HashMap();
        HashMap r11 = new HashMap();
        Iterator<TypeParameterDescriptor> r12 = r16.iterator();
        int r10 = 0;
    L13:
        if (r12.hasNext() == false) goto L15;
        TypeParameterDescriptor r14 = r12.next();
        TypeParameterDescriptorImpl r13 = TypeParameterDescriptorImpl.createForFurtherModification(r18, r14.getAnnotations(), r14.isReified(), r14.getVariance(), r14.getName(), r10, SourceElement.NO_SOURCE, r14.getStorageManager());
        r5.put(r14.getTypeConstructor(), new TypeProjectionImpl(r13.getDefaultType()));
        r11.put(r14, r13);
        r19.add(r13);
        r10 = r10 + 1;
        goto L13
    L15:
        TypeConstructorSubstitution r15 = TypeConstructorSubstitution.createByConstructorsMap(r5);
        TypeSubstitutor r21 = TypeSubstitutor.createChainedSubstitutor(r17, r15);
        TypeSubstitutor r22 = TypeSubstitutor.createChainedSubstitutor(r17.replaceWithNonApproximating(), r15);
        Iterator<TypeParameterDescriptor> r23 = r16.iterator();
    L17:
        if (r23.hasNext() == false) goto L36;
        TypeParameterDescriptor r24 = r23.next();
        TypeParameterDescriptorImpl r25 = (TypeParameterDescriptorImpl) r11.get(r24);
        Iterator<KotlinType> r26 = r24.getUpperBounds().iterator();
    L20:
        if (r26.hasNext() == false) goto L35;
        KotlinType r27 = r26.next();
        ClassifierDescriptor r28 = r27.getConstructor().mo1402getDeclarationDescriptor();
        if ((r28 instanceof TypeParameterDescriptor) == true) goto L24;
    L26:
        TypeSubstitutor r29 = r22;
    L27:
        KotlinType r30 = r29.substitute(r27, Variance.OUT_VARIANCE);
        if (r30 == null) goto L29;
        if (r30 == r27) goto L34;
        if (r20 == null) goto L34;
        r20[0] = true;
    L34:
        r25.addUpperBound(r30);
        goto L20
    L29:
        return null;
    L24:
        if (TypeUtilsKt.hasTypeParameterRecursiveBounds((TypeParameterDescriptor) r28) == false) goto L26;
        r29 = r21;
        goto L27
    L35:
        r25.setInitialized();
        goto L17
    L36:
        return r21;
    }
}
