package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    private final Collection<JavaAnnotation> annotations;
    private final ReflectJavaType componentType;
    private final boolean isDeprecatedInJavaDoc;
    private final Type reflectType;

    public ReflectJavaArrayType(Type r5) {
        Intrinsics.checkNotNullParameter(r5, "reflectType");
        this.reflectType = r5;
        Type r10 = getReflectType();
        if ((r10 instanceof GenericArrayType) == false) goto L6;
        ReflectJavaType r11 = ReflectJavaType.Factory.create(((GenericArrayType) r10).getGenericComponentType());
    L10:
        this.componentType = r11;
        this.annotations = CollectionsKt.emptyList();
        return;
    L6:
        if ((r10 instanceof Class) == false) goto L13;
        Class r12 = (Class) r10;
        if (r12.isArray() == false) goto L13;
        r11 = ReflectJavaType.Factory.create(r12.getComponentType());
    L13:
        throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public /* bridge */ /* synthetic */ JavaType getComponentType() {
        return getComponentType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }
}
