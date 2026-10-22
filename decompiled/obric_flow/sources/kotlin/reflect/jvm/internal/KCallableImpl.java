package kotlin.reflect.jvm.internal;

import androidx.core.app.NotificationCompat;
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
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u00109\u001a\u00028\u00002\u0016\u0010:\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010;J#\u0010<\u001a\u00028\u00002\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0=H\u0002¢\u0006\u0002\u0010>J#\u0010?\u001a\u00028\u00002\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0=H\u0016¢\u0006\u0002\u0010>J3\u0010@\u001a\u00028\u00002\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0=2\f\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010BH\u0000¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020/H\u0002J\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0015\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010JR,\u0010\u0005\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b \t*\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \t*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \t*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00110\u00110\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0013 \t*\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0012\u0010)\u001a\u00020&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0016R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002030\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0016R\u0016\u00105\u001a\u0004\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006K"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_absentArguments", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_annotations", "", "", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", NotificationCompat.CATEGORY_CALL, "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "getAbsentArguments", "()[Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKCallableImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KCallableImpl.kt\nkotlin/reflect/jvm/internal/KCallableImpl\n+ 2 util.kt\nkotlin/reflect/jvm/internal/UtilKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,243:1\n224#2,5:244\n224#2,2:249\n226#2,3:252\n224#2,5:255\n224#2,5:260\n224#2,2:269\n226#2,3:273\n26#3:251\n1549#4:265\n1620#4,3:266\n37#5,2:271\n*S KotlinDebug\n*F\n+ 1 KCallableImpl.kt\nkotlin/reflect/jvm/internal/KCallableImpl\n*L\n106#1:244,5\n148#1:249,2\n148#1:252,3\n187#1:255,5\n195#1:260,5\n215#1:269,2\n215#1:273,3\n149#1:251\n201#1:265\n201#1:266,3\n216#1:271,2\n*E\n"})
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<Object[]> _absentArguments;
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;

    public KCallableImpl() {
        this._annotations = ReflectProperties.lazySoft(new KCallableImpl$_annotations$1(this));
        this._parameters = ReflectProperties.lazySoft(new KCallableImpl$_parameters$1(this));
        this._returnType = ReflectProperties.lazySoft(new KCallableImpl$_returnType$1(this));
        this._typeParameters = ReflectProperties.lazySoft(new KCallableImpl$_typeParameters$1(this));
        this._absentArguments = ReflectProperties.lazySoft(new KCallableImpl$_absentArguments$1(this));
    }

    public static final /* synthetic */ Object access$defaultEmptyArray(KCallableImpl r5, KType r10) {
        return r5.defaultEmptyArray(r10);
    }

    public static final /* synthetic */ Type access$extractContinuationArgument(KCallableImpl r5) {
        return r5.extractContinuationArgument();
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> r5) {
        List<KParameter> r10 = getParameters();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L21;
        KParameter r13 = (KParameter) r12.next();
        if (r5.containsKey(r13) == false) goto L13;
        Object r14 = r5.get(r13);
        if (r14 != null) goto L18;
        throw new IllegalArgumentException("Annotation argument value cannot be null (" + r13 + ')');
    L18:
        r11.add(r14);
        goto L4
    L13:
        if (r13.isOptional() == false) goto L16;
        r14 = null;
        goto L18
    L16:
        if (r13.isVararg() == false) goto L20;
        r14 = defaultEmptyArray(r13.getType());
        goto L18
    L20:
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r13);
    L21:
        Caller<?> r15 = getDefaultCaller();
        if (r15 == null) goto L30;
        return (R) r15.call(r11.toArray(new Object[0]));
    L26:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L30:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    private final Object defaultEmptyArray(KType r5) {
        Class r10 = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(r5));
        if (r10.isArray() == false) goto L7;
        return Array.newInstance(r10.getComponentType(), 0);
    L7:
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + r10.getSimpleName() + ", because it is not an array type");
    }

    private final Type extractContinuationArgument() {
        if (isSuspend() == false) goto L22;
        Object r5 = CollectionsKt.lastOrNull(getCaller().getParameterTypes());
        if ((r5 instanceof ParameterizedType) == false) goto L7;
        ParameterizedType r10 = (ParameterizedType) r5;
    L8:
        if (r10 == null) goto L10;
        Type r11 = r10.getRawType();
    L12:
        if (Intrinsics.areEqual(r11, Continuation.class) == false) goto L23;
        Object r12 = ArraysKt.single(r10.getActualTypeArguments());
        if ((r12 instanceof WildcardType) == false) goto L16;
        WildcardType r13 = (WildcardType) r12;
    L17:
        if (r13 == null) goto L24;
        Type[] r14 = r13.getLowerBounds();
        if (r14 != null) goto L21;
        return null;
    L21:
        return (Type) ArraysKt.first(r14);
    L24:
        return null;
    L16:
        r13 = null;
        goto L17
    L23:
        return null;
    L10:
        r11 = null;
        goto L12
    L7:
        r10 = null;
        goto L8
    L22:
        return null;
    }

    private final Object[] getAbsentArguments() {
        return (Object[]) this._absentArguments.invoke().clone();
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... r5) {
        Intrinsics.checkNotNullParameter(r5, "args");
        return (R) getCaller().call(r5);
    L5:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "args");
        if (isAnnotationConstructor() == false) goto L6;
        return callAnnotationConstructor(r5);
    L6:
        return callDefaultMethod$kotlin_reflection(r5, null);
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "args");
        List<KParameter> r5 = getParameters();
        boolean r12 = false;
        if (r5.isEmpty() == true) goto L51;
        int r13 = (isSuspend() ? 1 : 0) + r5.size();
        Object[] r14 = getAbsentArguments();
        if (isSuspend() == false) goto L16;
        r14[r5.size()] = r11;
    L16:
        Iterator<KParameter> r15 = r5.iterator();
        int r16 = 0;
    L18:
        if (r15.hasNext() == false) goto L32;
        KParameter r17 = r15.next();
        if (r10.containsKey(r17) == false) goto L23;
        r14[r17.getIndex()] = r10.get(r17);
    L28:
        if (r17.getKind() != KParameter.Kind.VALUE) goto L18;
        r16 = r16 + 1;
        goto L18
    L23:
        if (r17.isOptional() == false) goto L26;
        int r18 = (r16 / 32) + r13;
        Object r19 = r14[r18];
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Int");
        r14[r18] = Integer.valueOf(((Integer) r19).intValue() | (1 << (r16 % 32)));
        r12 = true;
        goto L28
    L26:
        if (r17.isVararg() == true) goto L28;
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r17);
    L32:
        if (r12 == false) goto L47;
        Caller<?> r20 = getDefaultCaller();
        if (r20 == null) goto L46;
        return (R) r20.call(r14);
    L42:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L46:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    L47:
        return (R) getCaller().call(Arrays.copyOf(r14, r13));
    L35:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L51:
        Caller<?> r21 = getCaller();     // Catch: IllegalAccessException -> L10
        if (isSuspend() == false) goto L7;
        Continuation[] r22 = {r11};     // Catch: IllegalAccessException -> L10
    L8:
        return (R) r21.call(r22);
    L7:
        r22 = new Continuation[0];     // Catch: IllegalAccessException -> L10
    L10:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this._annotations.invoke();
    }

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return this._parameters.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return this._returnType.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        return this._typeParameters.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        return UtilKt.toKVisibility(getDescriptor().getVisibility());
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        if (getDescriptor().getModality() != Modality.ABSTRACT) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAnnotationConstructor() {
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
