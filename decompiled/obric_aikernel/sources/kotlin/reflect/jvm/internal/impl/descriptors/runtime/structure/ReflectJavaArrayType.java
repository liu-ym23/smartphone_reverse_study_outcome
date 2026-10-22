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

    public ReflectJavaArrayType(Type r10) {
        Intrinsics.checkNotNullParameter(r10, "reflectType");
        this.reflectType = r10;
        Type r11 = getReflectType();
        if ((r11 instanceof GenericArrayType) == false) goto L7;
        ReflectJavaType.Factory r12 = ReflectJavaType.Factory;
        Type r13 = ((GenericArrayType) r11).getGenericComponentType();
        String r14 = "genericComponentType";
    L5:
        Intrinsics.checkNotNullExpressionValue(r13, r14);
        this.componentType = r12.create(r13);
        this.annotations = CollectionsKt.emptyList();
        return;
    L7:
        if ((r11 instanceof Class) == false) goto L14;
        Class r15 = (Class) r11;
        if (r15.isArray() == false) goto L14;
        r12 = ReflectJavaType.Factory;
        r13 = r15.getComponentType();
        r14 = "getComponentType()";
    L14:
        throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public /* bridge */ /* synthetic */ JavaType getComponentType() {
        return getComponentType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    protected Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }
}
