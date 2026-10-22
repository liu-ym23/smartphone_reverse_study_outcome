package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReflectJavaTypeParameter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaTypeParameter.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaTypeParameter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,50:1\n11335#2:51\n11670#2,3:52\n*S KotlinDebug\n*F\n+ 1 ReflectJavaTypeParameter.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaTypeParameter\n*L\n29#1:51\n29#1:52,3\n*E\n"})
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    private final TypeVariable<?> typeVariable;

    public ReflectJavaTypeParameter(TypeVariable<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "typeVariable");
        this.typeVariable = r5;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ReflectJavaTypeParameter) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.typeVariable, ((ReflectJavaTypeParameter) r5).typeVariable) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ JavaAnnotation findAnnotation(FqName r5) {
        return findAnnotation(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        TypeVariable<?> r5 = this.typeVariable;
        if ((r5 instanceof AnnotatedElement) == true) goto L7;
        return null;
    L7:
        return (AnnotatedElement) r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        return Name.identifier(this.typeVariable.getName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public /* bridge */ /* synthetic */ Collection getUpperBounds() {
        return getUpperBounds();
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public String toString() {
        return ReflectJavaTypeParameter.class.getName() + ": " + this.typeVariable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        AnnotatedElement r10 = getElement();
        if (r10 == null) goto L7;
        Annotation[] r11 = r10.getDeclaredAnnotations();
        if (r11 == null) goto L7;
        return ReflectJavaAnnotationOwnerKt.findAnnotation(r11, r5);
    L7:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        AnnotatedElement r5 = getElement();
        if (r5 == null) goto L9;
        Annotation[] r10 = r5.getDeclaredAnnotations();
        if (r10 == null) goto L9;
        List<ReflectJavaAnnotation> r11 = ReflectJavaAnnotationOwnerKt.getAnnotations(r10);
        if (r11 == null) goto L9;
        return r11;
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] r5 = this.typeVariable.getBounds();
        ArrayList r10 = new ArrayList(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(new ReflectJavaClassifierType(r5[r12]));
        r12 = r12 + 1;
        goto L3
    L5:
        ReflectJavaClassifierType r13 = (ReflectJavaClassifierType) CollectionsKt.singleOrNull(r10);
        if (r13 == null) goto L8;
        Type r14 = r13.getReflectType();
    L10:
        if (Intrinsics.areEqual(r14, Object.class) == true) goto L12;
        return r10;
    L12:
        return CollectionsKt.emptyList();
    L8:
        r14 = null;
        goto L10
    }
}
