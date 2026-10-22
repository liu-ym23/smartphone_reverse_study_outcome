package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    private final TypeVariable<?> typeVariable;

    public ReflectJavaTypeParameter(TypeVariable<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "typeVariable");
        this.typeVariable = r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ReflectJavaTypeParameter) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.typeVariable, ((ReflectJavaTypeParameter) r10).typeVariable) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName r10) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ JavaAnnotation findAnnotation(FqName r10) {
        return findAnnotation(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        TypeVariable<?> r10 = this.typeVariable;
        if ((r10 instanceof AnnotatedElement) == true) goto L7;
        return null;
    L7:
        return (AnnotatedElement) r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        Name r10 = Name.identifier(this.typeVariable.getName());
        Intrinsics.checkNotNullExpressionValue(r10, "identifier(typeVariable.name)");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public /* bridge */ /* synthetic */ Collection getUpperBounds() {
        return getUpperBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] r10 = this.typeVariable.getBounds();
        Intrinsics.checkNotNullExpressionValue(r10, "typeVariable.bounds");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(new ReflectJavaClassifierType(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        ReflectJavaClassifierType r14 = (ReflectJavaClassifierType) CollectionsKt.singleOrNull(r11);
        if (r14 == null) goto L8;
        Type r15 = r14.getReflectType();
    L10:
        if (Intrinsics.areEqual(r15, Object.class) == true) goto L12;
        return r11;
    L12:
        return CollectionsKt.emptyList();
    L8:
        r15 = null;
        goto L10
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    public String toString() {
        return ReflectJavaTypeParameter.class.getName() + ": " + this.typeVariable;
    }
}
