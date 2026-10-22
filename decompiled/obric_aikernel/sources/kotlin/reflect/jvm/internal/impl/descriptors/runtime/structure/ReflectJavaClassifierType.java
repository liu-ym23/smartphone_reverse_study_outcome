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
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    private final JavaClassifier classifier;
    private final Type reflectType;

    public ReflectJavaClassifierType(Type r10) {
        Intrinsics.checkNotNullParameter(r10, "reflectType");
        this.reflectType = r10;
        Type r11 = getReflectType();
        if ((r11 instanceof Class) == false) goto L6;
        JavaClassifier r12 = new ReflectJavaClass((Class) r11);
    L11:
        this.classifier = r12;
        return;
    L6:
        if ((r11 instanceof TypeVariable) == false) goto L9;
        r12 = new ReflectJavaTypeParameter((TypeVariable) r11);
        goto L11
    L9:
        if ((r11 instanceof ParameterizedType) == false) goto L14;
        Type r13 = ((ParameterizedType) r11).getRawType();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.Class<*>");
        r12 = new ReflectJavaClass((Class) r13);
        goto L11
    L14:
        throw new IllegalStateException("Not a classifier type (" + r11.getClass() + "): " + r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
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
        List<Type> r10 = ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.Factory r11 = ReflectJavaType.Factory;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(r11.create((Type) r13.next()));
        goto L4
    L6:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public boolean isRaw() {
        Type r10 = getReflectType();
        if ((r10 instanceof Class) == false) goto L12;
        TypeVariable[] r11 = ((Class) r10).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "getTypeParameters()");
        if (r11.length != 0) goto L7;
        boolean r12 = true;
    L9:
        if ((!r12) == true) goto L11;
        return false;
    L11:
        return true;
    L7:
        r12 = false;
        goto L9
    L12:
        return false;
    }
}
