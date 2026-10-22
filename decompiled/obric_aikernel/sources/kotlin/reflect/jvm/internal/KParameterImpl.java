package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ReflectProperties.LazySoftVal annotations$delegate;
    private final KCallableImpl<?> callable;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final int index;
    private final KParameter.Kind kind;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public KParameterImpl(KCallableImpl<?> r10, int r11, KParameter.Kind r12, Function0<? extends ParameterDescriptor> r13) {
        Intrinsics.checkNotNullParameter(r10, "callable");
        Intrinsics.checkNotNullParameter(r12, "kind");
        Intrinsics.checkNotNullParameter(r13, "computeDescriptor");
        this.callable = r10;
        this.index = r11;
        this.kind = r12;
        this.descriptor$delegate = ReflectProperties.lazySoft(r13);
        this.annotations$delegate = ReflectProperties.lazySoft(new KParameterImpl$annotations$2(this));
    }

    public static final /* synthetic */ ParameterDescriptor access$getDescriptor(KParameterImpl r10) {
        return r10.getDescriptor();
    }

    private final ParameterDescriptor getDescriptor() {
        T r10 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(r10, "<get-descriptor>(...)");
        return (ParameterDescriptor) r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof KParameterImpl) == false) goto L9;
        KParameterImpl r11 = (KParameterImpl) r10;
        if (Intrinsics.areEqual(this.callable, r11.callable) == false) goto L9;
        if (getIndex() != r11.getIndex()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        T r10 = this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(r10, "<get-annotations>(...)");
        return (List) r10;
    }

    public final KCallableImpl<?> getCallable() {
        return this.callable;
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.KParameter
    public KParameter.Kind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.KParameter
    public String getName() {
        ParameterDescriptor r10 = getDescriptor();
        if ((r10 instanceof ValueParameterDescriptor) == false) goto L5;
        ValueParameterDescriptor r11 = (ValueParameterDescriptor) r10;
    L6:
        if (r11 != null) goto L9;
        return null;
    L9:
        if (r11.getContainingDeclaration().hasSynthesizedParameterNames() == false) goto L11;
        return null;
    L11:
        Name r12 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "valueParameter.name");
        if (r12.isSpecial() == false) goto L15;
        return null;
    L15:
        return r12.asString();
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlin.reflect.KParameter
    public KType getType() {
        KotlinType r10 = getDescriptor().getType();
        Intrinsics.checkNotNullExpressionValue(r10, "descriptor.type");
        return new KTypeImpl(r10, new KParameterImpl$type$1(this));
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + Integer.valueOf(getIndex()).hashCode();
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        ParameterDescriptor r10 = getDescriptor();
        if ((r10 instanceof ValueParameterDescriptor) == false) goto L5;
        ValueParameterDescriptor r11 = (ValueParameterDescriptor) r10;
    L6:
        if (r11 != null) goto L10;
        return false;
    L10:
        return DescriptorUtilsKt.declaresOrInheritsDefaultValue(r11);
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        ParameterDescriptor r10 = getDescriptor();
        if ((r10 instanceof ValueParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ValueParameterDescriptor) r10).getVarargElementType() == null) goto L7;
        return true;
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
