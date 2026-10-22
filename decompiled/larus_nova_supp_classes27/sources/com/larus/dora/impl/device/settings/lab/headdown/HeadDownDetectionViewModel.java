package com.larus.dora.impl.device.settings.lab.headdown;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.audio.IFlowTtsClientService;
import com.larus.business.debug.base.audio.module.TTSModule;
import com.larus.dora.api.IDoraService;
import com.larus.home.impl.sdk.s;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.m;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import t39.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001$\b\u0000\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020'J\u0006\u0010*\u001a\u00020'J\u0006\u0010+\u001a\u00020'J\b\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020'H\u0002J\b\u0010/\u001a\u00020'H\u0002JN\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020226\u00103\u001a2\u0012\u0013\u0012\u001102¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u001102¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020'04H\u0082@¢\u0006\u0002\u00109J9\u0010:\u001a\u00020'2\u0006\u00101\u001a\u0002022!\u00103\u001a\u001d\u0012\u0013\u0012\u001102¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020'0;H\u0082@¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020 J\b\u0010?\u001a\u00020'H\u0002J\u000e\u0010@\u001a\u00020'H\u0082@¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020'H\u0002J\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020'H\u0002J\b\u0010G\u001a\u00020'H\u0002J\b\u0010H\u001a\u00020'H\u0002J\b\u0010I\u001a\u00020'H\u0002J\b\u0010J\u001a\u00020'H\u0002J\b\u0010K\u001a\u00020'H\u0002J\b\u0010L\u001a\u00020'H\u0002J\u0010\u0010M\u001a\u00020'2\u0006\u0010D\u001a\u00020\u001eH\u0002J\b\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u000202H\u0002J\b\u0010Q\u001a\u00020'H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006S"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_effects", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionEffect;", "effects", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffects", "()Lkotlinx/coroutines/flow/SharedFlow;", "healthService", "Lcom/larus/dora/api/IDoraService$Health;", "getHealthService", "()Lcom/larus/dora/api/IDoraService$Health;", "healthService$delegate", "Lkotlin/Lazy;", "wearStateListener", "Lcom/larus/dora/api/wrapper/WearStateListener;", "prepareJob", "Lkotlinx/coroutines/Job;", "calibrationJob", "prepareTtsTaskId", "", "isStarted", "", "isHealthCallbackRegistered", "isWaitingCalibrationResult", "healthCallback", "com/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionViewModel$healthCallback$1", "Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionViewModel$healthCallback$1;", "startIfNeeded", "", "resetFlow", "onPrimaryActionClicked", "onNavigateBackClicked", "onNeedWearDialogConfirmed", "retryCalibration", "startCalibrationFlow", "startPreparing", "startCalibrating", "runSmoothCountdown", "totalSeconds", "", "onTick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "remainingSeconds", "progress", "(ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runSecondCountdown", "Lkotlin/Function1;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWearState", "isWearing", "stopLongHeadDownCalibration", "syncStopLongHeadDownCalibration", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSuccess", "showFailure", "reason", "Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownCalibrationFailureReason;", "cancelPreparing", "cancelCalibrating", "registerWearStateListener", "unregisterWearStateListener", "registerHealthCallback", "unregisterHealthCallback", "playPrepareTTS", "stopPrepareTTS", "getTargetLoudness", "", "getLoudNormAlgoType", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadDownDetectionViewModel extends ViewModel {
    private static final long CALIBRATION_RESULT_GRACE_MS = 12000;
    private static final int CALIBRATION_SECONDS = 5;
    public static final a Companion = null;
    private static final int LONG_HEAD_DOWN_CALIBRATING = 3;
    private static final int LONG_HEAD_DOWN_FAILURE_MOTION = 4;
    private static final int LONG_HEAD_DOWN_FAILURE_NOT_WEARING = 5;
    private static final int LONG_HEAD_DOWN_FAILURE_TIMEOUT = 6;
    private static final int LONG_HEAD_DOWN_QUERY_CALIBRATED = 1;
    private static final int LONG_HEAD_DOWN_QUERY_UNCALIBRATED = 0;
    private static final int LONG_HEAD_DOWN_SUCCESS = 2;
    private static final int PREPARE_SECONDS = 5;
    private static final long SECOND_COUNTDOWN_INTERVAL_MS = 1000;
    private static final long SMOOTH_PROGRESS_INTERVAL_MS = 50;
    private static final String TAG = "HeadDownDetectionVM";
    private final MutableSharedFlow<com.larus.dora.impl.device.settings.lab.headdown.b> _effects;
    private final z0<i> _uiState;
    private Job calibrationJob;
    private final d1<com.larus.dora.impl.device.settings.lab.headdown.b> effects;
    private final b healthCallback;
    private final Lazy healthService$delegate;
    private boolean isHealthCallbackRegistered;
    private boolean isStarted;
    private boolean isWaitingCalibrationResult;
    private Job prepareJob;
    private String prepareTtsTaskId;
    private final i1<i> uiState;
    private m wearStateListener;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements q {
        public final /* synthetic */ HeadDownDetectionViewModel a;

        @Override // t39.q
        public final void a(boolean r1) {
        }

        public b(HeadDownDetectionViewModel r1) {
            this.a = r1;
        }

        @Override // t39.q
        public final void b(int r6) {
            switch(r6) {
                case 0: goto L25;
                case 1: goto L25;
                case 2: goto L20;
                case 3: goto L14;
                case 4: goto L11;
                case 5: goto L8;
                case 6: goto L5;
                default: goto L3;
            };
        L3:
            g49.d.e(HeadDownDetectionViewModel.TAG, "Ignore unknown long head down calibration status=" + r6);
            return;
        L25:
            return;
        L5:
            if (HeadDownDetectionViewModel.access$isWaitingCalibrationResult$p(this.a) == false) goto L27;
            HeadDownDetectionViewModel.access$showFailure(this.a, HeadDownCalibrationFailureReason.TIMEOUT);
            return;
        L27:
            return;
        L8:
            if (HeadDownDetectionViewModel.access$isWaitingCalibrationResult$p(this.a) == false) goto L29;
            HeadDownDetectionViewModel.access$showFailure(this.a, HeadDownCalibrationFailureReason.NOT_WEARING);
            return;
        L29:
            return;
        L11:
            if (HeadDownDetectionViewModel.access$isWaitingCalibrationResult$p(this.a) == false) goto L31;
            HeadDownDetectionViewModel.access$showFailure(this.a, HeadDownCalibrationFailureReason.MOTION);
            return;
        L31:
            return;
        L14:
            if (HeadDownDetectionViewModel.access$isWaitingCalibrationResult$p(this.a) == false) goto L33;
            z0 r7 = HeadDownDetectionViewModel.access$get_uiState$p(this.a);
        L16:
            Object r0 = r7.getValue();
            if (r7.compareAndSet(r0, i.a((i) r0, new com.larus.dora.impl.device.settings.lab.headdown.a.C0049a(5), false, 2)) == false) goto L16;
            return;
        L33:
            return;
        L20:
            if (HeadDownDetectionViewModel.access$isWaitingCalibrationResult$p(this.a) == false) goto L34;
            HeadDownDetectionViewModel.access$showSuccess(this.a);
            return;
        }
    }

    public static final class c implements m {
        public final /* synthetic */ HeadDownDetectionViewModel a;

        public c(HeadDownDetectionViewModel r1) {
            this.a = r1;
        }

        @Override // h49.m
        public final void a(boolean r2, boolean r3) {
            HeadDownDetectionViewModel r0 = this.a;
            if (r2 == true) goto L7;
            if (r3 == true) goto L7;
            boolean r4 = false;
        L8:
            r0.updateWearState(r4);
            return;
        L7:
            r4 = true;
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$runSecondCountdown$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel", f = "HeadDownDetectionViewModel.kt", i = {0, 0}, l = {274}, m = "runSecondCountdown", n = {"onTick", "remaining"}, s = {"L$0", "I$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HeadDownDetectionViewModel this$0;

        public AnonymousClass1(HeadDownDetectionViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return HeadDownDetectionViewModel.access$runSecondCountdown(this.this$0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$runSmoothCountdown$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel", f = "HeadDownDetectionViewModel.kt", i = {0, 0, 0}, l = {262}, m = "runSmoothCountdown", n = {"onTick", "totalSeconds", "progress"}, s = {"L$0", "I$0", "I$1"})
    public static final class C02881 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HeadDownDetectionViewModel this$0;

        public C02881(HeadDownDetectionViewModel r1, Continuation<? super C02881> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return HeadDownDetectionViewModel.access$runSmoothCountdown(this.this$0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$startCalibrating$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$startCalibrating$1", f = "HeadDownDetectionViewModel.kt", i = {}, l = {230, 237, 245}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HeadDownDetectionViewModel this$0;

        public C02891(HeadDownDetectionViewModel r1, Continuation<? super C02891> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02891(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r11);
        L34:
            if (HeadDownDetectionViewModel.access$isWaitingCalibrationResult$p(this.this$0) == false) goto L37;
            g49.d.e(HeadDownDetectionViewModel.TAG, "Long head down calibration timed out");
            HeadDownDetectionViewModel.access$showFailure(this.this$0, HeadDownCalibrationFailureReason.TIMEOUT);
        L37:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r11);
        L29:
            if (HeadDownDetectionViewModel.access$isWaitingCalibrationResult$p(this.this$0) == false) goto L34;
            this.label = 3;
            if (DelayKt.delay(HeadDownDetectionViewModel.CALIBRATION_RESULT_GRACE_MS, this) != r0) goto L34;
            return r0;
        L11:
            ResultKt.throwOnFailure(r11);
        L20:
            int r12 = ((Number) r11).intValue();
        L22:
            if (r12 == 0) goto L25;
            g49.d.e(HeadDownDetectionViewModel.TAG, "startLongHeadDownCalibration failed, ret=" + r12);
            HeadDownDetectionViewModel.access$showFailure(this.this$0, HeadDownCalibrationFailureReason.TIMEOUT);
            return Unit.INSTANCE;
        L25:
            final HeadDownDetectionViewModel r13 = this.this$0;
            Function1 r2 = new k(r13);
            this.label = 2;
            if (HeadDownDetectionViewModel.access$runSecondCountdown(r13, 5, r2, this) != r0) goto L29;
            return r0;
        L12:
            ResultKt.throwOnFailure(r11);
            z0 r14 = HeadDownDetectionViewModel.access$get_uiState$p(this.this$0);
        L13:
            Object r3 = r14.getValue();
            if (r14.compareAndSet(r3, i.a((i) r3, new com.larus.dora.impl.device.settings.lab.headdown.a.C0049a(5), false, 2)) == false) goto L13;
            HeadDownDetectionViewModel.access$setWaitingCalibrationResult$p(this.this$0, true);
            IDoraService.f r15 = HeadDownDetectionViewModel.access$getHealthService(this.this$0);
            if (r15 == null) goto L21;
            this.label = 1;
            r11 = r15.d(this);
            if (r11 != r0) goto L20;
            return r0;
        L21:
            r12 = -1;
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$startPreparing$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$startPreparing$1", f = "HeadDownDetectionViewModel.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HeadDownDetectionViewModel this$0;

        public C02901(HeadDownDetectionViewModel r1, Continuation<? super C02901> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02901(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            HeadDownDetectionViewModel.access$startCalibrating(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            final HeadDownDetectionViewModel r5 = this.this$0;
            Function2 r2 = new l(r5);
            this.label = 1;
            if (HeadDownDetectionViewModel.access$runSmoothCountdown(r5, 5, r2, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$stopLongHeadDownCalibration$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$stopLongHeadDownCalibration$1", f = "HeadDownDetectionViewModel.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HeadDownDetectionViewModel this$0;

        public C02911(HeadDownDetectionViewModel r1, Continuation<? super C02911> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02911(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            HeadDownDetectionViewModel r5 = this.this$0;
            this.label = 1;
            if (HeadDownDetectionViewModel.access$syncStopLongHeadDownCalibration(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel$syncStopLongHeadDownCalibration$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headdown.HeadDownDetectionViewModel", f = "HeadDownDetectionViewModel.kt", i = {}, l = {316}, m = "syncStopLongHeadDownCalibration", n = {}, s = {})
    public static final class C02921 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HeadDownDetectionViewModel this$0;

        public C02921(HeadDownDetectionViewModel r1, Continuation<? super C02921> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return HeadDownDetectionViewModel.access$syncStopLongHeadDownCalibration(this.this$0, this);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ IDoraService.f yo() {
        return healthService_delegate$lambda$0();
    }

    private final void cancelCalibrating() {
        Job r0 = this.calibrationJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.calibrationJob = null;
        this.isWaitingCalibrationResult = false;
    }

    private final void cancelPreparing() {
        Job r0 = this.prepareJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.prepareJob = null;
        stopPrepareTTS("cancelPreparing");
    }

    private final IDoraService.f getHealthService() {
        return (IDoraService.f) this.healthService$delegate.getValue();
    }

    private final int getLoudNormAlgoType() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        s r2 = r0.s0();
        if (r2 == null) goto L9;
        if (r2.isDoraConnected() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return 1;
    L12:
        m58.q r4 = m58.h.d;
        if (r4 == null) goto L19;
        TTSModule r5 = r4.d();
        if (r5 == null) goto L19;
        if (r5.e() != true) goto L19;
        r1 = true;
    L19:
        if (r1 == false) goto L22;
        return 1;
    L22:
        return z2.a.getLoudnessConfig().c;
    L9:
        r3 = false;
        goto L10
    }

    private final float getTargetLoudness() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        s r2 = r0.s0();
        if (r2 == null) goto L9;
        if (r2.isDoraConnected() != true) goto L9;
        boolean r3 = true;
    L10:
        Float r4 = null;
        if (r3 == false) goto L26;
        m58.q r5 = m58.h.d;
        if (r5 == null) goto L25;
        TTSModule r6 = r5.d();
        if (r6 == null) goto L25;
        Float r7 = Float.valueOf(r6.a());
        if (r7.floatValue() != 0.0f) goto L20;
        r1 = true;
    L20:
        if ((!r1) == false) goto L22;
        r4 = r7;
    L22:
        if (r4 == null) goto L25;
        return r4.floatValue();
    L25:
        return z2.a.getLoudnessConfig().b;
    L26:
        m58.q r8 = m58.h.d;
        if (r8 == null) goto L39;
        TTSModule r9 = r8.d();
        if (r9 == null) goto L39;
        Float r10 = Float.valueOf(r9.b());
        if (r10.floatValue() != 0.0f) goto L34;
        r1 = true;
    L34:
        if ((!r1) == false) goto L36;
        r4 = r10;
    L36:
        if (r4 == null) goto L39;
        return r4.floatValue();
    L39:
        return z2.a.getLoudnessConfig().a;
    L9:
        r3 = false;
        goto L10
    }

    private static final IDoraService.f healthService_delegate$lambda$0() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.w();
    }

    private final void playPrepareTTS() {
        IFlowTtsClientService r1 = (IFlowTtsClientService) ServiceManager.get().getService(IFlowTtsClientService.class);
        if (r1 != null) goto L6;
        g49.d.d(TAG, "play prepare tts failed, due to tts client is null");
        return;
    L6:
        r1.f("HeadDownDetection play prepare tts");
        r1.j(z2.a.J());
        this.prepareTtsTaskId = "HeadDownPrepare" + System.currentTimeMillis();
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        String r3 = null;
        if (r2 == null) goto L9;
        String r4 = r2.v0();
    L10:
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L20;
        e10 r6 = e10.a;
        r4 = e10.f().a();
        if (r4 != null) goto L20;
        r4 = "";
    L20:
        String r7 = r4;
        g49.d.d(TAG, "playPrepareTTS taskId=" + this.prepareTtsTaskId);
        String r8 = this.prepareTtsTaskId;
        int r9 = j0.a;
        String r10 = j0.d(2131902613);
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L23;
        r3 = r11.z();
    L23:
        IFlowTtsClientService.b.a(r1, r8, null, r10, r7, null, null, null, r3, getTargetLoudness(), getLoudNormAlgoType(), 14578);
        return;
    L12:
        if (r4.length() == 0) goto L15;
        r5 = false;
        goto L16
    L9:
        r4 = null;
        goto L10
    }

    private final void registerHealthCallback() {
        if (this.isHealthCallbackRegistered == false) goto L5;
        return;
    L5:
        IDoraService.f r0 = getHealthService();
        if (r0 != null) goto L19;
        return;
    L19:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        r0.a(this.healthCallback);     // Catch: Throwable -> L10
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L13:
        if (Result.isSuccess-impl(r2) == false) goto L15;
        Unit r3 = (Unit) r2;
        this.isHealthCallbackRegistered = true;
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L21;
        g49.d.c(TAG, "registerHealthCallback failed", r4);
        return;
    L21:
        return;
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    private final void registerWearStateListener() {
        if (this.wearStateListener == null) goto L5;
        return;
    L5:
        c r0 = new c(this);
        CopyOnWriteArraySet r1 = t69.g.a;
        t69.g.a.add(r0);
        this.wearStateListener = r0;
    }

    private final void retryCalibration() {
        if (((i) this._uiState.getValue()).b == true) goto L8;
        this._effects.tryEmit(com.larus.dora.impl.device.settings.lab.headdown.b.c.a);
        z0<i> r0 = this._uiState;
    L5:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, i.a((i) r1, new com.larus.dora.impl.device.settings.lab.headdown.a.b(HeadDownCalibrationFailureReason.NOT_WEARING), false, 2)) == false) goto L5;
        return;
    L8:
        startPreparing();
    }

    private final void startCalibrationFlow() {
        if (((i) this._uiState.getValue()).b == true) goto L6;
        this._effects.tryEmit(com.larus.dora.impl.device.settings.lab.headdown.b.c.a);
        return;
    L6:
        startPreparing();
    }

    private final void unregisterHealthCallback() {
        if (this.isHealthCallbackRegistered == true) goto L5;
        return;
    L5:
        IDoraService.f r0 = getHealthService();
        if (r0 != null) goto L17;
        return;
    L17:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        r0.c(this.healthCallback);     // Catch: Throwable -> L10
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L15;
        g49.d.c(TAG, "unregisterHealthCallback failed", r3);
    L15:
        this.isHealthCallbackRegistered = false;
        return;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    private final void unregisterWearStateListener() {
        m r0 = this.wearStateListener;
        if (r0 == null) goto L5;
        CopyOnWriteArraySet r1 = t69.g.a;
        t69.g.a.remove(r0);
    L5:
        this.wearStateListener = null;
    }

    public final void onNavigateBackClicked() {
        i r0 = (i) this._uiState.getValue();
        if (r0.b() == true) goto L5;
        return;
    L5:
        com.larus.dora.impl.device.settings.lab.headdown.a r1 = r0.a;
        if (Intrinsics.areEqual(r1, com.larus.dora.impl.device.settings.lab.headdown.a.c.a) == false) goto L8;
    L24:
        this._effects.tryEmit(com.larus.dora.impl.device.settings.lab.headdown.b.a.a);
        return;
    L8:
        if (Intrinsics.areEqual(r1, com.larus.dora.impl.device.settings.lab.headdown.a.e.a) == true) goto L24;
        if ((r1 instanceof com.larus.dora.impl.device.settings.lab.headdown.a.b) == true) goto L24;
        if ((r1 instanceof com.larus.dora.impl.device.settings.lab.headdown.a.d) == false) goto L19;
        cancelPreparing();
        cancelCalibrating();
        z0<i> r2 = this._uiState;
    L15:
        Object r3 = r2.getValue();
        if (r2.compareAndSet(r3, i.a((i) r3, com.larus.dora.impl.device.settings.lab.headdown.a.c.a, false, 2)) == false) goto L15;
        return;
    L19:
        if ((r1 instanceof com.larus.dora.impl.device.settings.lab.headdown.a.C0049a) == false) goto L30;
        cancelCalibrating();
        stopLongHeadDownCalibration();
        z0<i> r4 = this._uiState;
    L21:
        Object r5 = r4.getValue();
        if (r4.compareAndSet(r5, i.a((i) r5, com.larus.dora.impl.device.settings.lab.headdown.a.c.a, false, 2)) == false) goto L21;
        return;
    }

    public final void onPrimaryActionClicked() {
        com.larus.dora.impl.device.settings.lab.headdown.a r0 = ((i) this._uiState.getValue()).a;
        if (Intrinsics.areEqual(r0, com.larus.dora.impl.device.settings.lab.headdown.a.c.a) == false) goto L6;
        startCalibrationFlow();
        return;
    L6:
        if (Intrinsics.areEqual(r0, com.larus.dora.impl.device.settings.lab.headdown.a.e.a) == false) goto L9;
        this._effects.tryEmit(com.larus.dora.impl.device.settings.lab.headdown.b.a.a);
        return;
    L9:
        if ((r0 instanceof com.larus.dora.impl.device.settings.lab.headdown.a.b) == false) goto L12;
        retryCalibration();
        return;
    L12:
        if ((r0 instanceof com.larus.dora.impl.device.settings.lab.headdown.a.d) == false) goto L14;
        return;
    L14:
        if ((r0 instanceof com.larus.dora.impl.device.settings.lab.headdown.a.C0049a) == false) goto L17;
        return;
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final void startIfNeeded() {
        if (this.isStarted == false) goto L5;
        return;
    L5:
        this.isStarted = true;
        registerWearStateListener();
        registerHealthCallback();
        CopyOnWriteArraySet r0 = t69.g.a;
        updateWearState(t69.g.b());
    }

    public HeadDownDetectionViewModel() {
        StateFlowImpl r0 = j1.a(new i(false, 3));
        this._uiState = r0;
        this.uiState = kotlinx.coroutines.flow.e.b(r0);
        MutableSharedFlow<com.larus.dora.impl.device.settings.lab.headdown.b> r1 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this._effects = r1;
        this.effects = kotlinx.coroutines.flow.e.a(r1);
        this.healthService$delegate = LazyKt.lazy(new j());
        this.prepareTtsTaskId = "";
        this.healthCallback = new b(this);
    }

    private final void showSuccess() {
        cancelPreparing();
        cancelCalibrating();
        z0<i> r0 = this._uiState;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, i.a((i) r1, com.larus.dora.impl.device.settings.lab.headdown.a.e.a, false, 2)) == false) goto L3;
    }

    private final void startCalibrating() {
        stopPrepareTTS("startCalibrating");
        cancelCalibrating();
        this.calibrationJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02891(this, null), 3, null);
    }

    private final void startPreparing() {
        cancelPreparing();
        cancelCalibrating();
        playPrepareTTS();
        this.prepareJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02901(this, null), 3, null);
    }

    private final void stopLongHeadDownCalibration() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02911(this, null), 3, null);
    }

    public void onCleared() {
        cancelPreparing();
        cancelCalibrating();
        unregisterHealthCallback();
        unregisterWearStateListener();
        super.onCleared();
    }

    public final void onNeedWearDialogConfirmed() {
        cancelPreparing();
        cancelCalibrating();
        z0<i> r0 = this._uiState;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, i.a((i) r1, com.larus.dora.impl.device.settings.lab.headdown.a.c.a, false, 2)) == false) goto L3;
    }

    public final void resetFlow() {
        cancelPreparing();
        cancelCalibrating();
        z0<i> r0 = this._uiState;
        CopyOnWriteArraySet r2 = t69.g.a;
        r0.setValue(new i(t69.g.b(), 1));
    }

    public final d1<com.larus.dora.impl.device.settings.lab.headdown.b> getEffects() {
        return this.effects;
    }

    public final i1<i> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ IDoraService.f access$getHealthService(HeadDownDetectionViewModel r0) {
        return r0.getHealthService();
    }

    public static final /* synthetic */ z0 access$get_uiState$p(HeadDownDetectionViewModel r0) {
        return r0._uiState;
    }

    public static final /* synthetic */ boolean access$isWaitingCalibrationResult$p(HeadDownDetectionViewModel r0) {
        return r0.isWaitingCalibrationResult;
    }

    public static final /* synthetic */ void access$showSuccess(HeadDownDetectionViewModel r0) {
        r0.showSuccess();
    }

    public static final /* synthetic */ void access$startCalibrating(HeadDownDetectionViewModel r0) {
        r0.startCalibrating();
    }

    private final void showFailure(HeadDownCalibrationFailureReason r7) {
        cancelPreparing();
        cancelCalibrating();
        z0<i> r0 = this._uiState;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, i.a((i) r1, new com.larus.dora.impl.device.settings.lab.headdown.a.b(r7), false, 2)) == false) goto L3;
    }

    private final void stopPrepareTTS(String r5) {
        String r0 = this.prepareTtsTaskId;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        return;
    L11:
        g49.d.d(TAG, "stopPrepareTTS taskId=" + r0 + ", reason=" + r5);
        IFlowTtsClientService r2 = (IFlowTtsClientService) ServiceManager.get().getService(IFlowTtsClientService.class);
        if (r2 == null) goto L14;
        r2.g(r0, false, r5);
    L14:
        this.prepareTtsTaskId = "";
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final Object syncStopLongHeadDownCalibration(Continuation<? super Unit> r5) {
        if ((r5 instanceof C02921) == false) goto L7;
        C02921 r0 = (C02921) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L19:
        int r7 = ((Number) r6).intValue();
    L21:
        g49.d.d(TAG, "stopLongHeadDownCalibration ret=" + r7);
        if (r7 == 0) goto L25;
        g49.d.e(TAG, "stopLongHeadDownCalibration failed, ret=" + r7);
    L25:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        IDoraService.f r8 = getHealthService();
        if (r8 == null) goto L20;
        r0.label = 1;
        r6 = r8.g(r0);
        if (r6 != r2) goto L19;
        return r2;
    L20:
        r7 = -1;
    L7:
        r0 = new C02921(this, r5);
        goto L8
    }

    public final void updateWearState(boolean r7) {
        i r0 = (i) this._uiState.getValue();
        z0<i> r1 = this._uiState;
    L3:
        Object r2 = r1.getValue();
        if (r1.compareAndSet(r2, i.a((i) r2, null, r7, 1)) == false) goto L3;
        if (r0.b == false) goto L27;
        if (r7 == true) goto L28;
        com.larus.dora.impl.device.settings.lab.headdown.a r8 = r0.a;
        if ((r8 instanceof com.larus.dora.impl.device.settings.lab.headdown.a.d) == false) goto L15;
        cancelPreparing();
        cancelCalibrating();
        z0<i> r3 = this._uiState;
    L11:
        Object r9 = r3.getValue();
        if (r3.compareAndSet(r9, i.a((i) r9, com.larus.dora.impl.device.settings.lab.headdown.a.c.a, false, 2)) == false) goto L11;
        this._effects.tryEmit(com.larus.dora.impl.device.settings.lab.headdown.b.C0050b.a);
        return;
    L15:
        if ((r8 instanceof com.larus.dora.impl.device.settings.lab.headdown.a.C0049a) == false) goto L30;
        cancelCalibrating();
        stopLongHeadDownCalibration();
        z0<i> r10 = this._uiState;
    L17:
        Object r4 = r10.getValue();
        if (r10.compareAndSet(r4, i.a((i) r4, com.larus.dora.impl.device.settings.lab.headdown.a.c.a, false, 2)) == false) goto L17;
        this._effects.tryEmit(com.larus.dora.impl.device.settings.lab.headdown.b.C0050b.a);
        return;
    L30:
        return;
    L28:
        return;
    }

    public static final /* synthetic */ void access$setWaitingCalibrationResult$p(HeadDownDetectionViewModel r0, boolean r1) {
        r0.isWaitingCalibrationResult = r1;
    }

    public static final /* synthetic */ void access$showFailure(HeadDownDetectionViewModel r0, HeadDownCalibrationFailureReason r1) {
        r0.showFailure(r1);
    }

    public static final /* synthetic */ Object access$syncStopLongHeadDownCalibration(HeadDownDetectionViewModel r0, Continuation r1) {
        return r0.syncStopLongHeadDownCalibration(r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0044 -> B:21:0x0055). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0052 -> B:21:0x0055). Please report as a decompilation issue!!! */
    private final Object runSecondCountdown(int r8, Function1<? super Integer, Unit> r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = r0.I$0;
        r9 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        r8 = r8 - 1;
    L15:
        if ((-1) >= r8) goto L23;
        r9.invoke(Boxing.boxInt(r8));
        if (r8 <= 0) goto L21;
        r0.L$0 = r9;
        r0.I$0 = r8;
        r0.label = 1;
        if (DelayKt.delay(SECOND_COUNTDOWN_INTERVAL_MS, r0) != r2) goto L21;
        return r2;
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005b -> B:23:0x0070). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006e -> B:22:0x006f). Please report as a decompilation issue!!! */
    private final Object runSmoothCountdown(int r10, Function2<? super Integer, ? super Integer, Unit> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof C02881) == false) goto L7;
        C02881 r0 = (C02881) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r14 = r0.I$1;
        int r15 = r0.I$0;
        Function2<? super Integer, ? super Integer, Unit> r4 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L22:
        Function2<? super Integer, ? super Integer, Unit> r16 = r4;
    L23:
        r14 = r14 - 1;
    L15:
        if ((-1) >= r14) goto L25;
        r16.invoke(Boxing.boxInt((int) Math.ceil(((double) (r14 * r15)) / 100.0d)), Boxing.boxInt(r14));
        if (r14 <= 0) goto L23;
        r0.L$0 = r16;
        r0.I$0 = r15;
        r0.I$1 = r14;
        r0.label = 1;
        if (DelayKt.delay(SMOOTH_PROGRESS_INTERVAL_MS, r0) != r2) goto L21;
        return r2;
    L21:
        r4 = r16;
        goto L22
    L25:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r16 = r11;
        r15 = r10;
        r14 = 100;
    L7:
        r0 = new C02881(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object access$runSecondCountdown(HeadDownDetectionViewModel r0, int r1, Function1 r2, Continuation r3) {
        return r0.runSecondCountdown(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$runSmoothCountdown(HeadDownDetectionViewModel r0, int r1, Function2 r2, Continuation r3) {
        return r0.runSmoothCountdown(r1, r2, r3);
    }
}
