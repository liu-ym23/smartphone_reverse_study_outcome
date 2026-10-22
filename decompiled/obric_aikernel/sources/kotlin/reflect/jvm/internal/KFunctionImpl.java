package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ReflectProperties.LazyVal caller$delegate;
    private final KDeclarationContainerImpl container;
    private final ReflectProperties.LazyVal defaultCaller$delegate;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final Object rawBoundReceiver;
    private final String signature;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    }

    public KFunctionImpl(KDeclarationContainerImpl r10, String r11, String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "signature");
        this(r10, r11, r12, null, r13);
    }

    private KFunctionImpl(KDeclarationContainerImpl r10, final String r11, String r12, FunctionDescriptor r13, Object r14) {
        this.container = r10;
        this.signature = r12;
        this.rawBoundReceiver = r14;
        this.descriptor$delegate = ReflectProperties.lazySoft(r13, new KFunctionImpl$descriptor$2(this, r11));
        this.caller$delegate = ReflectProperties.lazy(new KFunctionImpl$caller$2(this));
        this.defaultCaller$delegate = ReflectProperties.lazy(new KFunctionImpl$defaultCaller$2(this));
    }

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl r10, String r11, String r12, FunctionDescriptor r13, Object r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L5;
        r14 = CallableReference.NO_RECEIVER;
    L5:
        this(r10, r11, r12, r13, r14);
    }

    public KFunctionImpl(KDeclarationContainerImpl r10, FunctionDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        String r12 = r11.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r12, "descriptor.name.asString()");
        this(r10, r12, RuntimeTypeMapper.INSTANCE.mapSignature(r11).asString(), r11, null, 16, null);
    }

    public static final /* synthetic */ CallerImpl access$createConstructorCaller(KFunctionImpl r10, Constructor r11, FunctionDescriptor r12, boolean r13) {
        return r10.createConstructorCaller(r11, r12, r13);
    }

    public static final /* synthetic */ CallerImpl.Method access$createInstanceMethodCaller(KFunctionImpl r10, Method r11) {
        return r10.createInstanceMethodCaller(r11);
    }

    public static final /* synthetic */ CallerImpl.Method access$createJvmStaticInObjectCaller(KFunctionImpl r10, Method r11) {
        return r10.createJvmStaticInObjectCaller(r11);
    }

    public static final /* synthetic */ CallerImpl.Method access$createStaticMethodCaller(KFunctionImpl r10, Method r11) {
        return r10.createStaticMethodCaller(r11);
    }

    public static final /* synthetic */ String access$getSignature$p(KFunctionImpl r10) {
        return r10.signature;
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> r10, FunctionDescriptor r11, boolean r12) {
        if (r12 == true) goto L10;
        if (InlineClassManglingRulesKt.shouldHideConstructorDueToInlineClassTypeValueParameters(r11) == false) goto L10;
        if (isBound() == false) goto L15;
        return new CallerImpl.AccessorForHiddenBoundConstructor(r10, getBoundReceiver());
    L15:
        return new CallerImpl.AccessorForHiddenConstructor(r10);
    L10:
        if (isBound() == false) goto L13;
        return new CallerImpl.BoundConstructor(r10, getBoundReceiver());
    L13:
        return new CallerImpl.Constructor(r10);
    }

    private final CallerImpl.Method createInstanceMethodCaller(Method r10) {
        if (isBound() == false) goto L6;
        return new CallerImpl.Method.BoundInstance(r10, getBoundReceiver());
    L6:
        return new CallerImpl.Method.Instance(r10);
    }

    private final CallerImpl.Method createJvmStaticInObjectCaller(Method r10) {
        if (isBound() == false) goto L6;
        return new CallerImpl.Method.BoundJvmStaticInObject(r10);
    L6:
        return new CallerImpl.Method.JvmStaticInObject(r10);
    }

    private final CallerImpl.Method createStaticMethodCaller(Method r10) {
        if (isBound() == false) goto L6;
        return new CallerImpl.Method.BoundStatic(r10, getBoundReceiver());
    L6:
        return new CallerImpl.Method.Static(r10);
    }

    private final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    public boolean equals(Object r10) {
        KFunctionImpl r11 = UtilKt.asKFunctionImpl(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getContainer(), r11.getContainer()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getName(), r11.getName()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.signature, r11.signature) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawBoundReceiver, r11.rawBoundReceiver) == false) goto L18;
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
        T r10 = this.caller$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(r10, "<get-caller>(...)");
        return (Caller) r10;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
        return getDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public FunctionDescriptor getDescriptor() {
        T r10 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(r10, "<get-descriptor>(...)");
        return (FunctionDescriptor) r10;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String r10 = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(r10, "descriptor.name.asString()");
        return r10;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r10) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object r10, Object r11) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object r10, Object r11, Object r12) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12);
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object r10, Object r11, Object r12, Object r13) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13);
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.jvm.functions.Function7
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // kotlin.jvm.functions.Function8
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // kotlin.jvm.functions.Function9
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // kotlin.jvm.functions.Function10
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // kotlin.jvm.functions.Function11
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    @Override // kotlin.jvm.functions.Function12
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111);
    }

    @Override // kotlin.jvm.functions.Function13
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112);
    }

    @Override // kotlin.jvm.functions.Function14
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113);
    }

    @Override // kotlin.jvm.functions.Function15
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114);
    }

    @Override // kotlin.jvm.functions.Function16
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115);
    }

    @Override // kotlin.jvm.functions.Function17
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // kotlin.jvm.functions.Function18
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // kotlin.jvm.functions.Function19
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r20) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r20);
    }

    @Override // kotlin.jvm.functions.Function20
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r20, Object r21) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r20, r21);
    }

    @Override // kotlin.jvm.functions.Function21
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r20, Object r21, Object r22) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r20, r21, r22);
    }

    @Override // kotlin.jvm.functions.Function22
    public Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r20, Object r21, Object r22, Object r23) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r20, r21, r22, r23);
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
}
