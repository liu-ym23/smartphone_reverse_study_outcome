package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public ReflectJavaMember() {
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ReflectJavaMember) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getMember(), ((ReflectJavaMember) r10).getMember()) == false) goto L7;
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

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public ReflectJavaClass getContainingClass() {
        Class<?> r10 = getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r10, "member.declaringClass");
        return new ReflectJavaClass(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public /* bridge */ /* synthetic */ JavaClass getContainingClass() {
        return getContainingClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        Member r10 = getMember();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) r10;
    }

    public abstract Member getMember();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        String r10 = getMember().getName();
        if (r10 == null) goto L5;
        Name r11 = Name.identifier(r10);
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return SpecialNames.NO_NAME_PROVIDED;
    L5:
        r11 = null;
        goto L6
    }

    protected final List<JavaValueParameter> getValueParameters(Type[] r12, Annotation[][] r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "parameterTypes");
        Intrinsics.checkNotNullParameter(r13, "parameterAnnotations");
        ArrayList r10 = new ArrayList(r12.length);
        List<String> r11 = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        if (r11 == null) goto L5;
        int r15 = r11.size() - r12.length;
    L6:
        int r16 = r12.length;
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L22;
        ReflectJavaType r18 = ReflectJavaType.Factory.create(r12[r17]);
        if (r11 == null) goto L15;
        String r19 = (String) CollectionsKt.getOrNull(r11, r17 + r15);
        if (r19 == null) goto L14;
    L16:
        if (r14 == true) goto L18;
    L20:
        boolean r20 = false;
    L21:
        r10.add(new ReflectJavaValueParameter(r18, r13[r17], r19, r20));
        r17 = r17 + 1;
        goto L7
    L18:
        if (r17 != ArraysKt.getLastIndex(r12)) goto L20;
        r20 = true;
        goto L21
    L14:
        throw new IllegalStateException(("No parameter with index " + r17 + '+' + r15 + " (name=" + getName() + " type=" + r18 + ") in " + this).toString());
    L15:
        r19 = null;
        goto L16
    L22:
        return r10;
    L5:
        r15 = 0;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }
}
