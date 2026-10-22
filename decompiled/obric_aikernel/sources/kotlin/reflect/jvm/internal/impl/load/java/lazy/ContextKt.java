package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextKt {
    private static final LazyJavaResolverContext child(LazyJavaResolverContext r10, DeclarationDescriptor r11, JavaTypeParameterListOwner r12, int r13, Lazy<JavaTypeQualifiersByElementType> r14) {
        JavaResolverComponents r15 = r10.getComponents();
        if (r12 == null) goto L5;
        TypeParameterResolver r16 = new LazyJavaTypeParameterResolver(r10, r11, r12, r13);
    L7:
        return new LazyJavaResolverContext(r15, r16, r14);
    L5:
        r16 = r10.getTypeParameterResolver();
        goto L7
    }

    public static final LazyJavaResolverContext child(LazyJavaResolverContext r10, TypeParameterResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeParameterResolver");
        return new LazyJavaResolverContext(r10.getComponents(), r11, r10.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final LazyJavaResolverContext childForClassOrPackage(final LazyJavaResolverContext r10, final ClassOrPackageFragmentDescriptor r11, JavaTypeParameterListOwner r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "containingDeclaration");
        return child(r10, r11, r12, r13, LazyKt.lazy(LazyThreadSafetyMode.NONE, new AnonymousClass1(r10, r11)));
    }

    public static /* synthetic */ LazyJavaResolverContext childForClassOrPackage$default(LazyJavaResolverContext r10, ClassOrPackageFragmentDescriptor r11, JavaTypeParameterListOwner r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        return childForClassOrPackage(r10, r11, r12, r13);
    }

    public static final LazyJavaResolverContext childForMethod(LazyJavaResolverContext r10, DeclarationDescriptor r11, JavaTypeParameterListOwner r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r12, "typeParameterOwner");
        return child(r10, r11, r12, r13, r10.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ LazyJavaResolverContext childForMethod$default(LazyJavaResolverContext r10, DeclarationDescriptor r11, JavaTypeParameterListOwner r12, int r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = 0;
    L6:
        return childForMethod(r10, r11, r12, r13);
    }

    public static final JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(LazyJavaResolverContext r10, Annotations r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "additionalAnnotations");
        return r10.getComponents().getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(r10.getDefaultTypeQualifiers(), r11);
    }

    public static final LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(final LazyJavaResolverContext r10, final Annotations r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "additionalAnnotations");
        if (r11.isEmpty() == false) goto L6;
        return r10;
    L6:
        return new LazyJavaResolverContext(r10.getComponents(), r10.getTypeParameterResolver(), LazyKt.lazy(LazyThreadSafetyMode.NONE, new C04161(r10, r11)));
    }

    public static final LazyJavaResolverContext replaceComponents(LazyJavaResolverContext r10, JavaResolverComponents r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "components");
        return new LazyJavaResolverContext(r11, r10.getTypeParameterResolver(), r10.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }
}
