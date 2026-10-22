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
    public static final LazyJavaResolverContext child(LazyJavaResolverContext r5, TypeParameterResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeParameterResolver");
        return new LazyJavaResolverContext(r5.getComponents(), r10, r5.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final LazyJavaResolverContext childForClassOrPackage(final LazyJavaResolverContext r5, final ClassOrPackageFragmentDescriptor r10, JavaTypeParameterListOwner r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "containingDeclaration");
        return child(r5, r10, r11, r12, LazyKt.lazy(LazyThreadSafetyMode.NONE, new AnonymousClass1(r5, r10)));
    }

    public static /* synthetic */ LazyJavaResolverContext childForClassOrPackage$default(LazyJavaResolverContext r5, ClassOrPackageFragmentDescriptor r10, JavaTypeParameterListOwner r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        return childForClassOrPackage(r5, r10, r11, r12);
    }

    public static final LazyJavaResolverContext childForMethod(LazyJavaResolverContext r5, DeclarationDescriptor r10, JavaTypeParameterListOwner r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r11, "typeParameterOwner");
        return child(r5, r10, r11, r12, r5.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ LazyJavaResolverContext childForMethod$default(LazyJavaResolverContext r5, DeclarationDescriptor r10, JavaTypeParameterListOwner r11, int r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = 0;
    L6:
        return childForMethod(r5, r10, r11, r12);
    }

    public static final JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(LazyJavaResolverContext r5, Annotations r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "additionalAnnotations");
        return r5.getComponents().getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(r5.getDefaultTypeQualifiers(), r10);
    }

    public static final LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(final LazyJavaResolverContext r5, final Annotations r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "additionalAnnotations");
        if (r10.isEmpty() == false) goto L6;
        return r5;
    L6:
        return new LazyJavaResolverContext(r5.getComponents(), r5.getTypeParameterResolver(), LazyKt.lazy(LazyThreadSafetyMode.NONE, new C02271(r5, r10)));
    }

    public static final LazyJavaResolverContext replaceComponents(LazyJavaResolverContext r5, JavaResolverComponents r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "components");
        return new LazyJavaResolverContext(r10, r5.getTypeParameterResolver(), r5.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    private static final LazyJavaResolverContext child(LazyJavaResolverContext r5, DeclarationDescriptor r10, JavaTypeParameterListOwner r11, int r12, Lazy<JavaTypeQualifiersByElementType> r13) {
        JavaResolverComponents r14 = r5.getComponents();
        if (r11 == null) goto L5;
        TypeParameterResolver r15 = new LazyJavaTypeParameterResolver(r5, r10, r11, r12);
    L7:
        return new LazyJavaResolverContext(r14, r15, r13);
    L5:
        r15 = r5.getTypeParameterResolver();
        goto L7
    }
}
