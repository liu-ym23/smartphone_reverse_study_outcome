package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> r10 = ReflectProperties.lazySoft(new KCallableImpl$_annotations$1(this));
        Intrinsics.checkNotNullExpressionValue(r10, "lazySoft { descriptor.computeAnnotations() }");
        this._annotations = r10;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> r11 = ReflectProperties.lazySoft(new KCallableImpl$_parameters$1(this));
        Intrinsics.checkNotNullExpressionValue(r11, "lazySoft {\n        val d…ze()\n        result\n    }");
        this._parameters = r11;
        ReflectProperties.LazySoftVal<KTypeImpl> r12 = ReflectProperties.lazySoft(new KCallableImpl$_returnType$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "lazySoft {\n        KType…eturnType\n        }\n    }");
        this._returnType = r12;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> r13 = ReflectProperties.lazySoft(new KCallableImpl$_typeParameters$1(this));
        Intrinsics.checkNotNullExpressionValue(r13, "lazySoft {\n        descr…this, descriptor) }\n    }");
        this._typeParameters = r13;
    }

    public static final /* synthetic */ Type access$extractContinuationArgument(KCallableImpl r10) {
        return r10.extractContinuationArgument();
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> r10) {
        List<KParameter> r11 = getParameters();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L21;
        KParameter r14 = (KParameter) r13.next();
        if (r10.containsKey(r14) == false) goto L13;
        Object r15 = r10.get(r14);
        if (r15 != null) goto L18;
        throw new IllegalArgumentException("Annotation argument value cannot be null (" + r14 + ')');
    L18:
        r12.add(r15);
        goto L4
    L13:
        if (r14.isOptional() == false) goto L16;
        r15 = null;
        goto L18
    L16:
        if (r14.isVararg() == false) goto L20;
        r15 = defaultEmptyArray(r14.getType());
        goto L18
    L20:
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r14);
    L21:
        Caller<?> r16 = getDefaultCaller();
        if (r16 == null) goto L30;
        Object[] r17 = r12.toArray(new Object[0]);     // Catch: IllegalAccessException -> L26
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: IllegalAccessException -> L26
        return (R) r16.call(r17);
    L26:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L30:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    private final Object defaultEmptyArray(KType r10) {
        Class r11 = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(r10));
        if (r11.isArray() == false) goto L7;
        Object r12 = Array.newInstance(r11.getComponentType(), 0);
        Intrinsics.checkNotNullExpressionValue(r12, "type.jvmErasure.java.run…\"\n            )\n        }");
        return r12;
    L7:
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + r11.getSimpleName() + ", because it is not an array type");
    }

    private final Type extractContinuationArgument() {
        CallableMemberDescriptor r10 = getDescriptor();
        if ((r10 instanceof FunctionDescriptor) == false) goto L5;
        FunctionDescriptor r11 = (FunctionDescriptor) r10;
    L6:
        boolean r12 = true;
        if (r11 != null) goto L9;
    L11:
        r12 = false;
    L12:
        if (r12 == false) goto L31;
        Object r13 = CollectionsKt.lastOrNull(getCaller().getParameterTypes());
        if ((r13 instanceof ParameterizedType) == false) goto L16;
        ParameterizedType r14 = (ParameterizedType) r13;
    L17:
        if (r14 == null) goto L19;
        Type r15 = r14.getRawType();
    L21:
        if (Intrinsics.areEqual(r15, Continuation.class) == false) goto L32;
        Type[] r16 = r14.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(r16, "continuationType.actualTypeArguments");
        Object r17 = ArraysKt.single(r16);
        if ((r17 instanceof WildcardType) == false) goto L25;
        WildcardType r18 = (WildcardType) r17;
    L26:
        if (r18 == null) goto L33;
        Type[] r19 = r18.getLowerBounds();
        if (r19 != null) goto L30;
        return null;
    L30:
        return (Type) ArraysKt.first(r19);
    L33:
        return null;
    L25:
        r18 = null;
        goto L26
    L32:
        return null;
    L19:
        r15 = null;
        goto L21
    L16:
        r14 = null;
        goto L17
    L31:
        return null;
    L9:
        if (r11.isSuspend() != true) goto L11;
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        return (R) getCaller().call(r10);
    L5:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        if (isAnnotationConstructor() == false) goto L6;
        return callAnnotationConstructor(r10);
    L6:
        return callDefaultMethod$kotlin_reflection(r10, null);
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> r12, Continuation<?> r13) {
        Intrinsics.checkNotNullParameter(r12, "args");
        List<KParameter> r10 = getParameters();
        ArrayList r11 = new ArrayList(r10.size());
        ArrayList r14 = new ArrayList(1);
        Iterator<KParameter> r15 = r10.iterator();
        int r16 = 0;
        boolean r17 = false;
        int r18 = 0;
    L3:
        Object r19 = null;
        if (r15.hasNext() == false) goto L29;
        KParameter r20 = r15.next();
        if (r16 == 0) goto L11;
        if ((r16 % 32) != 0) goto L11;
        r14.add(Integer.valueOf(r18));
        r18 = 0;
    L11:
        if (r12.containsKey(r20) == false) goto L15;
        Object r21 = r12.get(r20);
    L13:
        r11.add(r21);
    L25:
        if (r20.getKind() != KParameter.Kind.VALUE) goto L3;
        r16 = r16 + 1;
        goto L3
    L15:
        if (r20.isOptional() == false) goto L22;
        if (UtilKt.isInlineClassType(r20.getType()) == true) goto L20;
        r19 = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(r20.getType()));
    L20:
        r11.add(r19);
        r18 = (1 << (r16 % 32)) | r18;
        r17 = true;
        goto L25
    L22:
        if (r20.isVararg() == false) goto L28;
        r21 = defaultEmptyArray(r20.getType());
        goto L13
    L28:
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r20);
    L29:
        if (r13 == null) goto L32;
        r11.add(r13);
    L32:
        if (r17 == true) goto L35;
        Object[] r110 = r11.toArray(new Object[0]);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return call(Arrays.copyOf(r110, r110.length));
    L35:
        r14.add(Integer.valueOf(r18));
        Caller<?> r111 = getDefaultCaller();
        if (r111 == null) goto L44;
        r11.addAll(r14);
        r11.add(null);
        Object[] r112 = r11.toArray(new Object[0]);     // Catch: IllegalAccessException -> L40
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: IllegalAccessException -> L40
        return (R) r111.call(r112);
    L40:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L44:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        List<Annotation> r10 = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_annotations()");
        return r10;
    }

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        ArrayList<KParameter> r10 = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_parameters()");
        return r10;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KTypeImpl r10 = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_returnType()");
        return r10;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> r10 = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_typeParameters()");
        return r10;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        DescriptorVisibility r10 = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(r10, "descriptor.visibility");
        return UtilKt.toKVisibility(r10);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        if (getDescriptor().getModality() != Modality.ABSTRACT) goto L5;
        return true;
    L5:
        return false;
    }

    protected final boolean isAnnotationConstructor() {
        if (Intrinsics.areEqual(getName(), "<init>") == true) goto L5;
    L7:
        return false;
    L5:
        if (getContainer().getJClass().isAnnotation() == false) goto L7;
        return true;
    }

    public abstract boolean isBound();

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        if (getDescriptor().getModality() != Modality.FINAL) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        if (getDescriptor().getModality() != Modality.OPEN) goto L5;
        return true;
    L5:
        return false;
    }
}
