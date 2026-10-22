package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012J.\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304032\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u00020)H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010;\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0013\u0010<\u001a\u00020)2\b\u0010=\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010>\u001a\u00020\u0014H\u0016J\b\u0010?\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\"\u0010\u001cR\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "isDefault", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final Lazy caller$delegate;
    private final KDeclarationContainerImpl container;
    private final Lazy defaultCaller$delegate;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final Object rawBoundReceiver;
    private final String signature;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;"))};
    }

    public /* synthetic */ KFunctionImpl(KDeclarationContainerImpl r10, String r11, String r12, FunctionDescriptor r13, Object r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = CallableReference.NO_RECEIVER;
    L5:
        this(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ CallerImpl access$createConstructorCaller(KFunctionImpl r5, Constructor r10, FunctionDescriptor r11, boolean r12) {
        return r5.createConstructorCaller(r10, r11, r12);
    }

    public static final /* synthetic */ CallerImpl.Method access$createInstanceMethodCaller(KFunctionImpl r5, Method r10) {
        return r5.createInstanceMethodCaller(r10);
    }

    public static final /* synthetic */ CallerImpl.Method access$createJvmStaticInObjectCaller(KFunctionImpl r5, Method r10) {
        return r5.createJvmStaticInObjectCaller(r10);
    }

    public static final /* synthetic */ CallerImpl.Method access$createStaticMethodCaller(KFunctionImpl r5, Method r10) {
        return r5.createStaticMethodCaller(r10);
    }

    public static final /* synthetic */ String access$getSignature$p(KFunctionImpl r5) {
        return r5.signature;
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> r5, FunctionDescriptor r10, boolean r11) {
        if (r11 == true) goto L10;
        if (InlineClassManglingRulesKt.shouldHideConstructorDueToInlineClassTypeValueParameters(r10) == false) goto L10;
        if (isBound() == false) goto L15;
        return new CallerImpl.AccessorForHiddenBoundConstructor(r5, getBoundReceiver());
    L15:
        return new CallerImpl.AccessorForHiddenConstructor(r5);
    L10:
        if (isBound() == false) goto L13;
        return new CallerImpl.BoundConstructor(r5, getBoundReceiver());
    L13:
        return new CallerImpl.Constructor(r5);
    }

    private final CallerImpl.Method createInstanceMethodCaller(Method r5) {
        if (isBound() == false) goto L6;
        return new CallerImpl.Method.BoundInstance(r5, getBoundReceiver());
    L6:
        return new CallerImpl.Method.Instance(r5);
    }

    private final CallerImpl.Method createJvmStaticInObjectCaller(Method r5) {
        if (isBound() == false) goto L6;
        return new CallerImpl.Method.BoundJvmStaticInObject(r5);
    L6:
        return new CallerImpl.Method.JvmStaticInObject(r5);
    }

    private final CallerImpl.Method createStaticMethodCaller(Method r5) {
        if (isBound() == false) goto L6;
        return new CallerImpl.Method.BoundStatic(r5, getBoundReceiver());
    L6:
        return new CallerImpl.Method.Static(r5);
    }

    private final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    public boolean equals(Object r5) {
        KFunctionImpl r10 = UtilKt.asKFunctionImpl(r5);
        if (r10 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getContainer(), r10.getContainer()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getName(), r10.getName()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.signature, r10.signature) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawBoundReceiver, r10.rawBoundReceiver) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        return (Caller) this.caller$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
        return getDescriptor();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return getDescriptor().getName().asString();
    }

    public int hashCode() {
        int r5 = getContainer().hashCode() * 31;
        int r10 = (getName().hashCode() + r5) * 31;
        return this.signature.hashCode() + r10;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return !Intrinsics.areEqual(this.rawBoundReceiver, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public FunctionDescriptor getDescriptor() {
        return (FunctionDescriptor) this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r5) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5);
    }

    private KFunctionImpl(KDeclarationContainerImpl r5, final String r10, String r11, FunctionDescriptor r12, Object r13) {
        this.container = r5;
        this.signature = r11;
        this.rawBoundReceiver = r13;
        this.descriptor$delegate = ReflectProperties.lazySoft(r12, new KFunctionImpl$descriptor$2(this, r10));
        LazyThreadSafetyMode r14 = LazyThreadSafetyMode.PUBLICATION;
        this.caller$delegate = LazyKt.lazy(r14, new KFunctionImpl$caller$2(this));
        this.defaultCaller$delegate = LazyKt.lazy(r14, new KFunctionImpl$defaultCaller$2(this));
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public Object mo2invoke(Object r5, Object r10) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object r5, Object r10, Object r11) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11);
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object r5, Object r10, Object r11, Object r12) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12);
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14);
    }

    @Override // kotlin.jvm.functions.Function7
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.jvm.functions.Function8
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16);
    }

    public KFunctionImpl(KDeclarationContainerImpl r10, String r11, String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "signature");
        this(r10, r11, r12, null, r13);
    }

    @Override // kotlin.jvm.functions.Function9
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public KFunctionImpl(KDeclarationContainerImpl r10, FunctionDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Object r12 = null;
        this(r10, r11.getName().asString(), RuntimeTypeMapper.INSTANCE.mapSignature(r11).asString(), r11, r12, 16, null);
    }

    @Override // kotlin.jvm.functions.Function10
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // kotlin.jvm.functions.Function11
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // kotlin.jvm.functions.Function12
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    @Override // kotlin.jvm.functions.Function13
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111);
    }

    @Override // kotlin.jvm.functions.Function14
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112);
    }

    @Override // kotlin.jvm.functions.Function15
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113);
    }

    @Override // kotlin.jvm.functions.Function16
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114);
    }

    @Override // kotlin.jvm.functions.Function17
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115);
    }

    @Override // kotlin.jvm.functions.Function18
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // kotlin.jvm.functions.Function19
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r20) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r20);
    }

    @Override // kotlin.jvm.functions.Function20
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r20, Object r21) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r20, r21);
    }

    @Override // kotlin.jvm.functions.Function21
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r20, Object r21, Object r22) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r20, r21, r22);
    }

    @Override // kotlin.jvm.functions.Function22
    public Object invoke(Object r5, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r20, Object r21, Object r22, Object r23) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r20, r21, r22, r23);
    }
}
