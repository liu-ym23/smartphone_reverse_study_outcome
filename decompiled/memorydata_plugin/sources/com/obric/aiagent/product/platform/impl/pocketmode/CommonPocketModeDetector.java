package com.obric.aiagent.product.platform.impl.pocketmode;

import android.app.Application;
import android.app.KeyguardManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.platform.a.a;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.obric.aiagent.product.platform.impl.vibratefeedback.SystemHiddenApiHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.da;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/pocketmode/CommonPocketModeDetector;", "Lcom/obric/aiagent/product/platform/api/pocketmode/IPocketModeDetector;", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "checkAsync", "isCheckPassed", "", "awaitCheckPassed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUserActionBlocked", "needVibrate", "isAppBackground", "showToastAction", "Lkotlin/Function0;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CommonPocketModeDetector implements IPocketModeDetector {
    private static final int CHECK_RESULT_COVERED = 1;
    private static final int CHECK_RESULT_INVALID = -1;
    private static final int CHECK_RESULT_UNCOVERED = 0;
    public static final Companion Companion = null;
    private static final long FORCE_UNREGISTER_DELAY = 200;
    private static final float PROXIMITY_THRESHOLD = 5.0f;
    private static final String TAG = "CommonPocketModeDetector";
    private static w<Boolean> checkDeferred;
    private static boolean checkPass;
    private static final Runnable forceUnregisterRunnable = null;
    private static final Lazy<KeyguardManager> keyguardManager$delegate = null;
    private static volatile int selfCheckResult;
    private static final Lazy<Sensor> sensor$delegate = null;
    private static final CommonPocketModeDetector$Companion$sensorEventListener$1 sensorEventListener = null;
    private static final Lazy<SensorManager> sensorManager$delegate = null;
    private static boolean sensorRegistered;

    @Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001%\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/aiagent/product/platform/impl/pocketmode/CommonPocketModeDetector$Companion;", "", "<init>", "()V", "TAG", "", "PROXIMITY_THRESHOLD", "", "CHECK_RESULT_INVALID", "", "CHECK_RESULT_UNCOVERED", "CHECK_RESULT_COVERED", "FORCE_UNREGISTER_DELAY", "", "selfCheckResult", "sensor", "Landroid/hardware/Sensor;", "getSensor", "()Landroid/hardware/Sensor;", "sensor$delegate", "Lkotlin/Lazy;", "sensorManager", "Landroid/hardware/SensorManager;", "getSensorManager", "()Landroid/hardware/SensorManager;", "sensorManager$delegate", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "checkDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "forceUnregisterRunnable", "Ljava/lang/Runnable;", "sensorEventListener", "com/obric/aiagent/product/platform/impl/pocketmode/CommonPocketModeDetector$Companion$sensorEventListener$1", "Lcom/obric/aiagent/product/platform/impl/pocketmode/CommonPocketModeDetector$Companion$sensorEventListener$1;", "sensorRegistered", "checkPass", "startSelfCheck", "", "register", "unregister", "findSensor", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ Sensor access$findSensor(Companion r0) {
            return r0.findSensor();
        }

        public static final /* synthetic */ KeyguardManager access$getKeyguardManager(Companion r0) {
            return r0.getKeyguardManager();
        }

        public static final /* synthetic */ Sensor access$getSensor(Companion r0) {
            return r0.getSensor();
        }

        public static final /* synthetic */ SensorManager access$getSensorManager(Companion r0) {
            return r0.getSensorManager();
        }

        public static final /* synthetic */ void access$startSelfCheck(Companion r0) {
            r0.startSelfCheck();
        }

        public static final /* synthetic */ void access$unregister(Companion r0) {
            r0.unregister();
        }

        private final Sensor findSensor() {
            List<Sensor> r5 = getSensorManager().getSensorList(8);
            if (r5 != null) goto L5;
        L19:
            d.f5954a.b(CommonPocketModeDetector.TAG, "can't find proper sensor");
            return null;
        L5:
            if (r5.isEmpty() == true) goto L19;
            if (r5.size() == 1) goto L10;
            Iterator<Sensor> r0 = r5.iterator();
        L13:
            if (r0.hasNext() == false) goto L18;
            Sensor r1 = (Sensor) ZeusTransformUtils.preCheckCast(r0.next(), Sensor.class, "com.obric.memorydata.plugin");
            if (r1.isWakeUpSensor() == false) goto L13;
            return r1;
        L18:
            return (Sensor) ZeusTransformUtils.preCheckCast(r5.get(0), Sensor.class, "com.obric.memorydata.plugin");
        L10:
            return (Sensor) ZeusTransformUtils.preCheckCast(r5.get(0), Sensor.class, "com.obric.memorydata.plugin");
        }

        private final KeyguardManager getKeyguardManager() {
            return (KeyguardManager) ZeusTransformUtils.preCheckCast(CommonPocketModeDetector.access$getKeyguardManager$delegate$cp().getValue(), KeyguardManager.class, "com.obric.memorydata.plugin");
        }

        private final Sensor getSensor() {
            return (Sensor) ZeusTransformUtils.preCheckCast(CommonPocketModeDetector.access$getSensor$delegate$cp().getValue(), Sensor.class, "com.obric.memorydata.plugin");
        }

        private final SensorManager getSensorManager() {
            return (SensorManager) ZeusTransformUtils.preCheckCast(CommonPocketModeDetector.access$getSensorManager$delegate$cp().getValue(), SensorManager.class, "com.obric.memorydata.plugin");
        }

        private final void register() {
            com.obric.aiagent.product.a.d.f5969a.a((Runnable) ZeusTransformUtils.preCheckCast(new CommonPocketModeDetector$Companion$register$$inlined$postInForeground$default$2(), Runnable.class, "com.obric.memorydata.plugin"));
        }

        private final void startSelfCheck() {
            CommonPocketModeDetector.access$setSelfCheckResult$cp(-1);
            com.obric.aiagent.product.a.d.f5969a.a().removeCallbacks(CommonPocketModeDetector.access$getForceUnregisterRunnable$cp());
            if (getSensor() != null) goto L8;
            d.f5954a.c(CommonPocketModeDetector.TAG, "startSelfCheck: proximity sensor is null, treat as uncovered");
            CommonPocketModeDetector.access$setSelfCheckResult$cp(0);
            w r3 = CommonPocketModeDetector.access$getCheckDeferred$cp();
            if (r3 == null) goto L10;
            r3.a(true);
            return;
        L10:
            return;
        L8:
            register();
            com.obric.aiagent.product.a.d.f5969a.a().postDelayed(CommonPocketModeDetector.access$getForceUnregisterRunnable$cp(), 200);
        }

        private final void unregister() {
            com.obric.aiagent.product.a.d.f5969a.a((Runnable) ZeusTransformUtils.preCheckCast(new CommonPocketModeDetector$Companion$unregister$$inlined$postInForeground$default$2(), Runnable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector$awaitCheckPassed$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector", f = "CommonPocketModeDetector.kt", i = {}, l = {189}, m = "awaitCheckPassed$suspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CommonPocketModeDetector this$0;

        AnonymousClass1(CommonPocketModeDetector r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return CommonPocketModeDetector.awaitCheckPassed$suspendImpl(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector$Companion$sensorEventListener$1] */
    static {
        Companion = new Companion(null);
        selfCheckResult = -1;
        sensor$delegate = LazyKt.lazy($$Lambda$CommonPocketModeDetector$YKkhTzJ0JNyHl4ZGyRaOFMTxAI.INSTANCE);
        sensorManager$delegate = LazyKt.lazy($$Lambda$CommonPocketModeDetector$aqdx3Ngi2j2Pmo_QO6mKRW8DdUg.INSTANCE);
        keyguardManager$delegate = LazyKt.lazy($$Lambda$CommonPocketModeDetector$pvQwxxRu4Xdw_mrymwKgeQ2bLmc.INSTANCE);
        forceUnregisterRunnable = $$Lambda$CommonPocketModeDetector$f25WdgS53C764DB8gR3IfaRUICQ.INSTANCE;
        sensorEventListener = new CommonPocketModeDetector$Companion$sensorEventListener$1();
    }

    public CommonPocketModeDetector() {
    }

    public static final /* synthetic */ w access$getCheckDeferred$cp() {
        return checkDeferred;
    }

    public static final /* synthetic */ Runnable access$getForceUnregisterRunnable$cp() {
        return forceUnregisterRunnable;
    }

    public static final /* synthetic */ Lazy access$getKeyguardManager$delegate$cp() {
        return keyguardManager$delegate;
    }

    public static final /* synthetic */ int access$getSelfCheckResult$cp() {
        return selfCheckResult;
    }

    public static final /* synthetic */ Lazy access$getSensor$delegate$cp() {
        return sensor$delegate;
    }

    public static final /* synthetic */ CommonPocketModeDetector$Companion$sensorEventListener$1 access$getSensorEventListener$cp() {
        return sensorEventListener;
    }

    public static final /* synthetic */ Lazy access$getSensorManager$delegate$cp() {
        return sensorManager$delegate;
    }

    public static final /* synthetic */ boolean access$getSensorRegistered$cp() {
        return sensorRegistered;
    }

    public static final /* synthetic */ void access$setSelfCheckResult$cp(int r0) {
        selfCheckResult = r0;
    }

    public static final /* synthetic */ void access$setSensorRegistered$cp(boolean r0) {
        sensorRegistered = r0;
    }

    static /* synthetic */ Object awaitCheckPassed$suspendImpl(CommonPocketModeDetector r8, Continuation<? super Boolean> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        Boolean r3 = null;
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L16;
        ResultKt.throwOnFailure(r11);     // Catch: CancellationException -> L13
    L29:
        r3 = (Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L13
    L32:
        d.b r13 = d.f5954a;
        if (r3 != null) goto L36;
        r13.c(TAG, "awaitCheckPassed: timeout, return true");
        return Boxing.boxBoolean(true);
    L36:
        r13.b(TAG, "awaitCheckPassed: result = " + r3);
        return r3;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r11);
        d.b r14 = d.f5954a;
        StringBuilder r4 = new StringBuilder().append("awaitCheckPassed start, checkDeferred.isCompleted = ");
        w<Boolean> r6 = checkDeferred;
        if (r6 == null) goto L20;
        Boolean r7 = Boxing.boxBoolean(r6.q_());
    L21:
        r14.b(TAG, r4.append(r7).append(", checkPass = ").append(checkPass).append(", selfCheckResult = ").append(selfCheckResult).toString());
        w<Boolean> r15 = checkDeferred;
        if (r15 != null) goto L26;
        return Boxing.boxBoolean(true);
    L26:
        Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new CommonPocketModeDetector$awaitCheckPassed$result$1(r15, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L13
        r0.label = 1;     // Catch: CancellationException -> L13
        r11 = da.b(100, r16, r0);     // Catch: CancellationException -> L13
        if (r11 != r12) goto L29;
        return r12;
    L20:
        r7 = null;
    L13:
        e = move-exception;
        d.f5954a.a(TAG, "awaitCheckPassed: deferred cancelled", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L7:
        r0 = new AnonymousClass1(r8, r10);
        goto L8
    }

    private static final void forceUnregisterRunnable$lambda$3() {
        d.f5954a.d(TAG, "force unregister sensor listener, is there something wrong?!");
        Companion.access$unregister(Companion);
    }

    private static final KeyguardManager keyguardManager_delegate$lambda$2() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("keyguard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$YKkhTzJ0JNyHl4ZGyRaOFMTx-AI, reason: not valid java name */
    public static /* synthetic */ Sensor m178lambda$YKkhTzJ0JNyHl4ZGyRaOFMTxAI() {
        return sensor_delegate$lambda$0();
    }

    public static /* synthetic */ SensorManager lambda$aqdx3Ngi2j2Pmo_QO6mKRW8DdUg() {
        return sensorManager_delegate$lambda$1();
    }

    public static /* synthetic */ void lambda$f25WdgS53C764DB8gR3IfaRUICQ() {
        forceUnregisterRunnable$lambda$3();
    }

    public static /* synthetic */ KeyguardManager lambda$pvQwxxRu4Xdw_mrymwKgeQ2bLmc() {
        return keyguardManager_delegate$lambda$2();
    }

    private static final SensorManager sensorManager_delegate$lambda$1() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("sensor");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.hardware.SensorManager");
        return (SensorManager) ZeusTransformUtils.preCheckCast(r0, SensorManager.class, "com.obric.memorydata.plugin");
    }

    private static final Sensor sensor_delegate$lambda$0() {
        return Companion.access$findSensor(Companion);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public Object awaitCheckPassed(Continuation<? super Boolean> r3) {
        return awaitCheckPassed$suspendImpl(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void checkAsync() {
        Companion r0 = Companion;
        checkPass = false;
        if (Companion.access$getKeyguardManager(r0).isKeyguardLocked() == true) goto L5;
        checkDeferred = y.a(true);
        checkPass = true;
        return;
    L5:
        if (isPocketModeManuallyDismissed() == false) goto L7;
    L13:
        checkDeferred = y.a(true);
        checkPass = true;
        d.f5954a.b(TAG, "checkAsync() key guard locked, pocket mode not enable");
        return;
    L7:
        if (isPocketModeEnabled() == false) goto L13;
        w<Boolean> r5 = checkDeferred;
        if (r5 == null) goto L12;
        bx.a.a((bx) ZeusTransformUtils.preCheckCast(r5, bx.class, "com.obric.memorydata.plugin"), null, 1, null);
    L12:
        checkDeferred = y.a(null, 1, null);
        Companion.access$startSelfCheck(r0);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void init() {
        d.f5954a.b(TAG, "call init()");
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isCheckPassed() {
        d.f5954a.b(TAG, "isCheckPassed, checkPass = " + checkPass + ", selfCheckResult = " + selfCheckResult + ", isPocketModeEnabled = " + isPocketModeEnabled() + ", isPocketModeManuallyDismissed = " + isPocketModeManuallyDismissed());
        boolean r1 = true;
        if (checkPass == true) goto L9;
        if (selfCheckResult != 1) goto L9;
        r1 = false;
    L9:
        selfCheckResult = -1;
        return r1;
    L11:
        th = move-exception;
        selfCheckResult = -1;
        throw th;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void onUserActionBlocked(boolean r4, boolean r5, Function0<Unit> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "showToastAction");
        d.f5954a.b(TAG, "onUserActionBlocked() needVibrate:" + r4 + ", isAppBackground:" + r5);
        if (r4 == false) goto L5;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(FeedbackType.WARNING.getTypeName());
    L5:
        if (r5 == false) goto L7;
        showProximityNearAlert();
        return;
    L7:
        r7.invoke();
    }
}
