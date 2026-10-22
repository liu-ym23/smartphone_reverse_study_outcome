package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    private final Collection<JavaAnnotation> annotations;
    private final boolean isDeprecatedInJavaDoc;
    private final WildcardType reflectType;

    public ReflectJavaWildcardType(WildcardType r10) {
        Intrinsics.checkNotNullParameter(r10, "reflectType");
        this.reflectType = r10;
        this.annotations = CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public ReflectJavaType getBound() {
        Type[] r10 = getReflectType().getUpperBounds();
        Type[] r11 = getReflectType().getLowerBounds();
        if (r10.length > 1) goto L16;
        if (r11.length > 1) goto L16;
        if (r11.length != 1) goto L10;
        ReflectJavaType.Factory r12 = ReflectJavaType.Factory;
        Intrinsics.checkNotNullExpressionValue(r11, "lowerBounds");
        Object r13 = ArraysKt.single(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "lowerBounds.single()");
        return r12.create((Type) r13);
    L10:
        if (r10.length != 1) goto L18;
        Intrinsics.checkNotNullExpressionValue(r10, "upperBounds");
        Type r14 = (Type) ArraysKt.single(r10);
        if (Intrinsics.areEqual(r14, Object.class) == true) goto L19;
        ReflectJavaType.Factory r15 = ReflectJavaType.Factory;
        Intrinsics.checkNotNullExpressionValue(r14, "ub");
        return r15.create(r14);
    L19:
        return null;
    L18:
        return null;
    L16:
        throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public /* bridge */ /* synthetic */ JavaType getBound() {
        return getBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public /* bridge */ /* synthetic */ Type getReflectType() {
        return getReflectType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    protected WildcardType getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        Type[] r10 = getReflectType().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r10, "reflectType.upperBounds");
        return !Intrinsics.areEqual(ArraysKt.firstOrNull(r10), Object.class);
    }
}
