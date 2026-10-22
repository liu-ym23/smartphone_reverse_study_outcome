package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReflectJavaClassifierType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaClassifierType.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClassifierType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,64:1\n1#2:65\n1549#3:66\n1620#3,3:67\n*S KotlinDebug\n*F\n+ 1 ReflectJavaClassifierType.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClassifierType\n*L\n50#1:66\n50#1:67,3\n*E\n"})
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    private final JavaClassifier classifier;
    private final Type reflectType;

    public ReflectJavaClassifierType(Type r5) {
        Intrinsics.checkNotNullParameter(r5, "reflectType");
        this.reflectType = r5;
        Type r10 = getReflectType();
        if ((r10 instanceof Class) == false) goto L6;
        JavaClassifier r11 = new ReflectJavaClass((Class) r10);
    L11:
        this.classifier = r11;
        return;
    L6:
        if ((r10 instanceof TypeVariable) == false) goto L9;
        r11 = new ReflectJavaTypeParameter((TypeVariable) r10);
        goto L11
    L9:
        if ((r10 instanceof ParameterizedType) == false) goto L14;
        Type r12 = ((ParameterizedType) r10).getRawType();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Class<*>");
        r11 = new ReflectJavaClass((Class) r12);
        goto L11
    L14:
        throw new IllegalStateException("Not a classifier type (" + r10.getClass() + "): " + r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException("Type not found: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public List<JavaType> getTypeArguments() {
        List<Type> r5 = ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.Factory r10 = ReflectJavaType.Factory;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(r10.create((Type) r12.next()));
        goto L4
    L6:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public boolean isRaw() {
        Type r5 = getReflectType();
        if ((r5 instanceof Class) == true) goto L5;
        return false;
    L5:
        if (((Class) r5).getTypeParameters().length != 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
        return false;
    L10:
        return true;
    L7:
        r10 = false;
        goto L8
    }
}
