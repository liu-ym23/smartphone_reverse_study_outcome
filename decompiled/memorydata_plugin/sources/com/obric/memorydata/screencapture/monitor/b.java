package com.obric.memorydata.screencapture.monitor;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Looper;
import android.view.Choreographer;
import android.view.InputEvent;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020$0-J\u0018\u0010/\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0002J\u001e\u00100\u001a\u0004\u0018\u00010\u00012\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020$0-H\u0002J,\u00101\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020$0-H\u0002J\u0006\u00102\u001a\u00020$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\u000fR\u001f\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\u000fR\u001f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/memorydata/screencapture/monitor/InputManagerReflect;", "", "<init>", "()V", "TAG", "", "inputManager", "Landroid/hardware/input/InputManager;", "getInputManager", "()Landroid/hardware/input/InputManager;", "inputManager$delegate", "Lkotlin/Lazy;", "inputEventListenerClass", "Ljava/lang/Class;", "getInputEventListenerClass", "()Ljava/lang/Class;", "inputEventListenerClass$delegate", "inputChannelClass", "getInputChannelClass", "inputChannelClass$delegate", "simpleBatchedInputEventReceiverClass", "getSimpleBatchedInputEventReceiverClass", "simpleBatchedInputEventReceiverClass$delegate", "simpleBatchedInputEventReceiverConstructor", "Ljava/lang/reflect/Constructor;", "getSimpleBatchedInputEventReceiverConstructor", "()Ljava/lang/reflect/Constructor;", "simpleBatchedInputEventReceiverConstructor$delegate", "disposeInputMonitorMethod", "Ljava/lang/reflect/Method;", "disposeInputEventReceiverMethod", "getInputChannelMethod", "monitorGestureInputMethod", "inputMonitorInstance", "inputEventReceiverInstance", "monitorInput", "", ActivityLifecycle.NAME, "displayId", "", "looper", "Landroid/os/Looper;", "choreographer", "Landroid/view/Choreographer;", "onInputEvent", "Lkotlin/Function1;", "Landroid/view/InputEvent;", "monitorGestureInput", "createInputEventListener", "createInputEventReceiver", "dispose", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12802b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;
    private static final Lazy e = null;
    private static final Lazy f = null;
    private static Method g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Object k;
    private static Object l;

    static {
        f12801a = new b();
        f12802b = LazyKt.lazy(LazyThreadSafetyMode.NONE, $$Lambda$b$lfwVTLqG0_B_EmPm6P4_sfUaAOM.INSTANCE);
        c = LazyKt.lazy(LazyThreadSafetyMode.NONE, $$Lambda$b$kbuu5NY04tU39yIoWdgO4pG6tLw.INSTANCE);
        d = LazyKt.lazy(LazyThreadSafetyMode.NONE, $$Lambda$b$Gpklr3jDHqWDYi9KUQjGoUw1Q6g.INSTANCE);
        e = LazyKt.lazy(LazyThreadSafetyMode.NONE, $$Lambda$b$aY3WVicadJOXTIqt1xYk_N471bE.INSTANCE);
        f = LazyKt.lazy(LazyThreadSafetyMode.NONE, $$Lambda$b$9pNLw87D6Ocd7_LI8VoKBm7cu8.INSTANCE);
    }

    private b() {
    }

    private final Object a(Function1<? super InputEvent, Unit> r5) {
        final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        InvocationHandler r0 = new $$Lambda$b$b44dKfRC1jzgIYN8LjEia2AT1Bc(r6);     // Catch: Exception -> L5
        return Proxy.newProxyInstance(c().getClassLoader(), new Class[]{c()}, r0);
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("InputManagerReflect", "createInputEventListener error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private static final Object a(Function1 r2, Object r3, Method r4, Object[] r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.getName(), "onInputEvent") == false) goto L13;
        if (r5 == null) goto L13;
        if (r5.length != 0) goto L8;
        boolean r7 = true;
    L10:
        if ((!r7) == false) goto L13;
        Object r8 = r5[0];
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.InputEvent");
        r6.invoke((InputEvent) ZeusTransformUtils.preCheckCast(r8, InputEvent.class, "com.obric.memorydata.plugin"));
        goto L13
    L8:
        r7 = false;
    L13:
        return false;
    }

    private final void a(Looper r11, Choreographer r12, Function1<? super InputEvent, Unit> r13) {
        Object r14 = a((Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L26
        Object r0 = k;     // Catch: Exception -> L26
        boolean r2 = true;
        if (r0 == null) goto L12;
        Method r4 = i;     // Catch: Exception -> L26
        if (r4 == null) goto L12;
        if (r14 == null) goto L12;
        if (r4 == null) goto L10;
        Object r1 = r4.invoke(r0, new Object[0]);     // Catch: Exception -> L26
    L11:
        l = f().newInstance(new Object[]{r1, r11, r12, r14});     // Catch: Exception -> L26
        return;
    L10:
        r1 = null;
    L12:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L26
        StringBuilder r10 = new StringBuilder().append("createInputEventReceiver failed, inputMonitorReady=");     // Catch: Exception -> L26
        if (k == null) goto L15;
        boolean r15 = true;
    L16:
        StringBuilder r16 = r10.append(r15).append(", getInputChannelMethodReady=");     // Catch: Exception -> L26
        if (i == null) goto L19;
        boolean r17 = true;
    L20:
        StringBuilder r18 = r16.append(r17).append(", inputEventListenerReady=");     // Catch: Exception -> L26
        if (r14 != null) goto L24;
        r2 = false;
    L24:
        IRunLog.a.b(r5, "InputManagerReflect", r18.append(r2).toString(), null, 4, null);     // Catch: Exception -> L26
        return;
    L19:
        r17 = false;
        goto L20
    L15:
        r15 = false;
    L26:
        e = move-exception;
        RunLog.INSTANCE.error("InputManagerReflect", "createInputEventReceiver error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(String r8, int r9) {
        Class<?> r0 = b().getClass();     // Catch: Exception -> L24
        if (j != null) goto L6;
        j = r0.getMethod("monitorGestureInput", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L24
    L6:
        if (k == null) goto L8;
    L9:
        a();     // Catch: Exception -> L24
    L10:
        Method r1 = j;     // Catch: Exception -> L24
        Method r2 = null;
        if (r1 == null) goto L13;
        Object r7 = r1.invoke(b(), new Object[]{r8, Integer.valueOf(r9)});     // Catch: Exception -> L24
    L14:
        k = r7;     // Catch: Exception -> L24
        if (r7 == null) goto L17;
        Class<?> r10 = r7.getClass();     // Catch: Exception -> L24
    L19:
        if (i != null) goto L29;
        if (r10 == null) goto L22;
        r2 = r10.getMethod("getInputChannel", new Class[0]);     // Catch: Exception -> L24
    L22:
        i = r2;     // Catch: Exception -> L24
        return;
    L29:
        return;
    L17:
        r10 = null;
        goto L19
    L13:
        r7 = null;
        goto L14
    L8:
        if (l == null) goto L10;
    L24:
        e = move-exception;
        RunLog.INSTANCE.error("InputManagerReflect", "monitorGestureInput error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final InputManager b() {
        return (InputManager) ZeusTransformUtils.preCheckCast(f12802b.getValue(), InputManager.class, "com.obric.memorydata.plugin");
    }

    private final Class<?> c() {
        Object r2 = c.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "getValue(...)");
        return (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin");
    }

    private final Class<?> d() {
        Object r2 = d.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "getValue(...)");
        return (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin");
    }

    private final Class<?> e() {
        Object r2 = e.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "getValue(...)");
        return (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin");
    }

    private final Constructor<?> f() {
        Object r2 = f.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "getValue(...)");
        return (Constructor) ZeusTransformUtils.preCheckCast(r2, Constructor.class, "com.obric.memorydata.plugin");
    }

    private static final InputManager g() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.hardware.input.InputManager");
        return (InputManager) ZeusTransformUtils.preCheckCast(r0, InputManager.class, "com.obric.memorydata.plugin");
    }

    private static final Class h() {
        return ZeusTransformUtils.forName("android.view.BatchedInputEventReceiver$SimpleBatchedInputEventReceiver$InputEventListener", "com.obric.memorydata.plugin");
    }

    private static final Class i() {
        return ZeusTransformUtils.forName("android.view.InputChannel", "com.obric.memorydata.plugin");
    }

    private static final Class j() {
        return ZeusTransformUtils.forName("android.view.BatchedInputEventReceiver$SimpleBatchedInputEventReceiver", "com.obric.memorydata.plugin");
    }

    private static final Constructor k() {
        b r0 = f12801a;
        return r0.e().getConstructor(new Class[]{r0.d(), Looper.class, Choreographer.class, r0.c()});
    }

    /* JADX INFO: renamed from: lambda$9pNLw87D6-Ocd7_LI8VoKBm7cu8, reason: not valid java name */
    public static /* synthetic */ Constructor m1175lambda$9pNLw87D6Ocd7_LI8VoKBm7cu8() {
        return k();
    }

    public static /* synthetic */ Class lambda$Gpklr3jDHqWDYi9KUQjGoUw1Q6g() {
        return i();
    }

    public static /* synthetic */ Class lambda$aY3WVicadJOXTIqt1xYk_N471bE() {
        return j();
    }

    public static /* synthetic */ Object lambda$b44dKfRC1jzgIYN8LjEia2AT1Bc(Function1 r0, Object r1, Method r2, Object[] r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Class lambda$kbuu5NY04tU39yIoWdgO4pG6tLw() {
        return h();
    }

    public static /* synthetic */ InputManager lambda$lfwVTLqG0_B_EmPm6P4_sfUaAOM() {
        return g();
    }

    public final synchronized void a() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r6)
            java.lang.reflect.Method r0 = com.obric.memorydata.screencapture.monitor.b.h     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L1d
            java.lang.Object r0 = com.obric.memorydata.screencapture.monitor.b.l     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 == 0) goto L1a
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 == 0) goto L1a
            java.lang.String r3 = "dispose"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            goto L1b
        L1a:
            r0 = r2
        L1b:
            com.obric.memorydata.screencapture.monitor.b.h = r0     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
        L1d:
            java.lang.reflect.Method r0 = com.obric.memorydata.screencapture.monitor.b.h     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 == 0) goto L28
            java.lang.Object r3 = com.obric.memorydata.screencapture.monitor.b.l     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r0.invoke(r3, r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
        L28:
            com.obric.memorydata.screencapture.monitor.b.l = r2     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.reflect.Method r0 = com.obric.memorydata.screencapture.monitor.b.g     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 != 0) goto L44
            java.lang.Object r0 = com.obric.memorydata.screencapture.monitor.b.k     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 == 0) goto L41
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 == 0) goto L41
            java.lang.String r3 = "dispose"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            goto L42
        L41:
            r0 = r2
        L42:
            com.obric.memorydata.screencapture.monitor.b.g = r0     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
        L44:
            java.lang.reflect.Method r0 = com.obric.memorydata.screencapture.monitor.b.g     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 == 0) goto L4f
            java.lang.Object r3 = com.obric.memorydata.screencapture.monitor.b.k     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r0.invoke(r3, r1)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
        L4f:
            com.obric.memorydata.screencapture.monitor.b.k = r2     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            goto L68
        L52:
            r0 = move-exception
            goto L6a
        L54:
            r0 = move-exception
            com.obric.memorydata.middleware.api.log.RunLog r1 = com.obric.memorydata.middleware.api.log.RunLog.INSTANCE     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "InputManagerReflect"
            java.lang.String r3 = "dispose error"
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            java.lang.String r5 = "com.obric.memorydata.plugin"
            java.lang.Object r0 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r0, r4, r5)     // Catch: java.lang.Throwable -> L52
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: java.lang.Throwable -> L52
            r1.error(r2, r3, r0)     // Catch: java.lang.Throwable -> L52
        L68:
            monitor-exit(r6)
            return
        L6a:
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.memorydata.screencapture.monitor.b.a():void");
    }

    public final synchronized void a(String r3, int r4, Looper r5, Choreographer r6, Function1<? super InputEvent, Unit> r7) {
        monitor-enter(this);
        Function1<? super InputEvent, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r5, "looper");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r6, "choreographer");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r8, "onInputEvent");     // Catch: Throwable -> L6
        a(r3, r4);     // Catch: Throwable -> L6
        a(r5, r6, r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
