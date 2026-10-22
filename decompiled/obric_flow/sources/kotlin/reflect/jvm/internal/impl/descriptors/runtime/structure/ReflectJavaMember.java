package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReflectJavaMember.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaMember\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public ReflectJavaMember() {
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ReflectJavaMember) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getMember(), ((ReflectJavaMember) r5).getMember()) == false) goto L7;
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

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public /* bridge */ /* synthetic */ JavaClass getContainingClass() {
        return getContainingClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        Member r5 = getMember();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) r5;
    }

    public abstract Member getMember();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        String r5 = getMember().getName();
        if (r5 == null) goto L5;
        Name r10 = Name.identifier(r5);
    L6:
        if (r10 == null) goto L8;
        return r10;
    L8:
        return SpecialNames.NO_NAME_PROVIDED;
    L5:
        r10 = null;
        goto L6
    }

    public final List<JavaValueParameter> getValueParameters(Type[] r12, Annotation[][] r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "parameterTypes");
        Intrinsics.checkNotNullParameter(r13, "parameterAnnotations");
        ArrayList r5 = new ArrayList(r12.length);
        List<String> r10 = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        if (r10 == null) goto L5;
        int r11 = r10.size() - r12.length;
    L6:
        int r15 = r12.length;
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L22;
        ReflectJavaType r17 = ReflectJavaType.Factory.create(r12[r16]);
        if (r10 == null) goto L15;
        String r18 = (String) CollectionsKt.getOrNull(r10, r16 + r11);
        if (r18 == null) goto L14;
    L16:
        if (r14 == true) goto L18;
    L20:
        boolean r19 = false;
    L21:
        r5.add(new ReflectJavaValueParameter(r17, r13[r16], r18, r19));
        r16 = r16 + 1;
        goto L7
    L18:
        if (r16 != ArraysKt.getLastIndex(r12)) goto L20;
        r19 = true;
        goto L21
    L14:
        throw new IllegalStateException(("No parameter with index " + r16 + '+' + r11 + " (name=" + getName() + " type=" + r17 + ") in " + this).toString());
    L15:
        r18 = null;
        goto L16
    L22:
        return r5;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        int r5 = getModifiers();
        if (Modifier.isPublic(r5) == false) goto L6;
        return Visibilities.Public.INSTANCE;
    L6:
        if (Modifier.isPrivate(r5) == false) goto L9;
        return Visibilities.Private.INSTANCE;
    L9:
        if (Modifier.isProtected(r5) == false) goto L15;
        if (Modifier.isStatic(r5) == false) goto L19;
        return JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
    L19:
        return JavaVisibilities.ProtectedAndPackage.INSTANCE;
    L15:
        return JavaVisibilities.PackageVisibility.INSTANCE;
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
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

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public ReflectJavaClass getContainingClass() {
        return new ReflectJavaClass(getMember().getDeclaringClass());
    }
}
