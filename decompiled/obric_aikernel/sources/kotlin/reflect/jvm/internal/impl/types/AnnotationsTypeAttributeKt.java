package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationsTypeAttributeKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private static final ReadOnlyProperty annotationsAttribute$delegate = null;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinPackage(AnnotationsTypeAttributeKt.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};
        ReadOnlyProperty r10 = TypeAttributes.Companion.generateNullableAccessor(Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class));
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        annotationsAttribute$delegate = r10;
    }

    public static final Annotations getAnnotations(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        AnnotationsTypeAttribute r11 = getAnnotationsAttribute(r10);
        if (r11 == null) goto L7;
        Annotations r12 = r11.getAnnotations();
        if (r12 == null) goto L7;
        return r12;
    L7:
        return Annotations.Companion.getEMPTY();
    }

    public static final AnnotationsTypeAttribute getAnnotationsAttribute(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (AnnotationsTypeAttribute) annotationsAttribute$delegate.getValue(r10, $$delegatedProperties[0]);
    }
}
