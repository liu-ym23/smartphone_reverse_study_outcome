package kotlin.reflect.jvm.internal;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class KTypeImpl implements KTypeBase {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ReflectProperties.LazySoftVal arguments$delegate;
    private final ReflectProperties.LazySoftVal classifier$delegate;
    private final ReflectProperties.LazySoftVal<Type> computeJavaType;
    private final KotlinType type;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    }

    public KTypeImpl(KotlinType r10, Function0<? extends Type> r11) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        this.type = r10;
        ReflectProperties.LazySoftVal<Type> r12 = null;
        if ((r11 instanceof ReflectProperties.LazySoftVal) == false) goto L5;
        ReflectProperties.LazySoftVal<Type> r13 = (ReflectProperties.LazySoftVal) r11;
    L6:
        if (r13 != null) goto L9;
        if (r11 == null) goto L10;
        r12 = ReflectProperties.lazySoft(r11);
    L10:
        this.computeJavaType = r12;
        this.classifier$delegate = ReflectProperties.lazySoft(new KTypeImpl$classifier$2(this));
        this.arguments$delegate = ReflectProperties.lazySoft(new KTypeImpl$arguments$2(this, r11));
        return;
    L9:
        r12 = r13;
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    public /* synthetic */ KTypeImpl(KotlinType r10, Function0 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ KClassifier access$convert(KTypeImpl r10, KotlinType r11) {
        return r10.convert(r11);
    }

    private final KClassifier convert(KotlinType r10) {
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r11 instanceof ClassDescriptor) == false) goto L33;
        Class<?> r12 = UtilKt.toJavaClass((ClassDescriptor) r11);
        if (r12 != null) goto L8;
        return null;
    L8:
        if (r12.isArray() == false) goto L23;
        TypeProjection r13 = (TypeProjection) CollectionsKt.singleOrNull(r10.getArguments());
        if (r13 == null) goto L21;
        KotlinType r14 = r13.getType();
        if (r14 == null) goto L21;
        KClassifier r15 = convert(r14);
        if (r15 == null) goto L19;
        return new KClassImpl(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(r15))));
    L19:
        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
    L21:
        return new KClassImpl(r12);
    L23:
        if (TypeUtils.isNullableType(r10) == true) goto L31;
        Class<?> r16 = ReflectClassUtilKt.getPrimitiveByWrapper(r12);
        if (r16 == null) goto L29;
        r12 = r16;
    L29:
        return new KClassImpl(r12);
    L31:
        return new KClassImpl(r12);
    L33:
        if ((r11 instanceof TypeParameterDescriptor) == false) goto L37;
        return new KTypeParameterImpl(null, (TypeParameterDescriptor) r11);
    L37:
        if ((r11 instanceof TypeAliasDescriptor) == true) goto L40;
        return null;
    L40:
        throw new NotImplementedError("An operation is not implemented: Type alias classifiers are not yet supported");
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof KTypeImpl) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.type, ((KTypeImpl) r10).type) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.type);
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        T r10 = this.arguments$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(r10, "<get-arguments>(...)");
        return (List) r10;
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return (KClassifier) this.classifier$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> r10 = this.computeJavaType;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.invoke();
    }

    public final KotlinType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    public final KTypeImpl makeNullableAsSpecified$kotlin_reflection(boolean r10) {
        if (FlexibleTypesKt.isFlexible(this.type) == false) goto L5;
    L7:
        KotlinType r11 = TypeUtils.makeNullableAsSpecified(this.type, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "makeNullableAsSpecified(type, nullable)");
        return new KTypeImpl(r11, this.computeJavaType);
    L5:
        if (isMarkedNullable() != r10) goto L7;
        return this;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this.type);
    }
}
