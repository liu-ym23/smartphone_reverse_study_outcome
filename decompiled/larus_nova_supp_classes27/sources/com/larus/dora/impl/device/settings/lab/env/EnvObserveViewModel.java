package com.larus.dora.impl.device.settings.lab.env;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.settings.lab.env.timer.TimerJob;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.i;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001dJ\u0016\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'J\u0016\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020'J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020'0/J\f\u00100\u001a\b\u0012\u0004\u0012\u00020'0/J\b\u00101\u001a\u00020\u0019H\u0002J\b\u00102\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\u000e\u00105\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001dR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_envObserveTimerStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveState;", "envObserveTimerState", "Lkotlinx/coroutines/flow/StateFlow;", "getEnvObserveTimerState", "()Lkotlinx/coroutines/flow/StateFlow;", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "doraService", "Lcom/larus/dora/api/IDoraService;", "getDoraService", "()Lcom/larus/dora/api/IDoraService;", "doraService$delegate", "mDoraDeviceMac", "", "initData", "", "updateCurrentDoraDeviceMac", "mac", "requestDeviceSyncInfo", "", "key", "value", "", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEnvEnable", "isChecked", "updateTimer", "updateStartTimer", "startHour", "", "startMinute", "updateEndTimer", "endHour", "endMinute", "startTimerStr", "endTimerStr", "startTimerInt", "", "endTimerInt", "updateTimeEnableState", "updateStartTimerInterval", "updateEndTimerInterval", "updateEnvEnableState", "updateEnvLight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnvObserveViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String END_TIME_SET = "dora_g_config_key_env_observe_timer_end";
    public static final String START_TIME_SET = "dora_g_config_key_env_observe_timer_start";
    public static final String TAG = "EnvObserveViewModel";
    private z0<y> _envObserveTimerStateFlow;
    private final Lazy doraPageConfig$delegate;
    private final Lazy doraService$delegate;
    private final i1<y> envObserveTimerState;
    private volatile String mDoraDeviceMac;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$initData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$initData$1", f = "EnvObserveViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EnvObserveViewModel this$0;

        public AnonymousClass1(EnvObserveViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L24:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            IDoraPageConfig r12 = EnvObserveViewModel.access$getDoraPageConfig(this.this$0);
            if (r12 == null) goto L11;
            boolean r4 = r12.d("dora_g_config_key_env_observe_enable", false);
        L12:
            IDoraPageConfig r13 = EnvObserveViewModel.access$getDoraPageConfig(this.this$0);
            if (r13 == null) goto L15;
            boolean r5 = r13.d("dora_g_config_key_env_observe_timer_enable", false);
        L16:
            IDoraPageConfig r14 = EnvObserveViewModel.access$getDoraPageConfig(this.this$0);
            if (r14 == null) goto L19;
            boolean r8 = r14.d("dora_g_config_key_env_observe_light_enable", false);
        L20:
            z0 r15 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0);
            y.b r2 = new y.b(r4, r5, EnvObserveViewModel.access$startTimerStr(this.this$0), EnvObserveViewModel.access$endTimerStr(this.this$0), r8, true);
            this.label = 1;
            if (r15.emit(r2, this) != r0) goto L24;
            return r0;
        L19:
            r8 = false;
            goto L20
        L15:
            r5 = false;
            goto L16
        L11:
            r4 = false;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$requestDeviceSyncInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel", f = "EnvObserveViewModel.kt", i = {}, l = {72}, m = "requestDeviceSyncInfo", n = {}, s = {})
    public static final class C02751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EnvObserveViewModel this$0;

        public C02751(EnvObserveViewModel r1, Continuation<? super C02751> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return EnvObserveViewModel.access$requestDeviceSyncInfo(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEndTimer$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEndTimer$1", f = "EnvObserveViewModel.kt", i = {0}, l = {167, 177}, m = "invokeSuspend", n = {"endTime"}, s = {"L$0"})
    public static final class C02761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $endHour;
        final /* synthetic */ int $endMinute;
        Object L$0;
        int label;
        final /* synthetic */ EnvObserveViewModel this$0;

        public C02761(int r1, int r2, EnvObserveViewModel r3, Continuation<? super C02761> r4) {
            this.$endHour = r1;
            this.$endMinute = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02761(this.$endHour, this.$endMinute, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
        L24:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            String r2 = (String) this.L$0;
            ResultKt.throwOnFailure(r14);
        L13:
            boolean r15 = ((Boolean) r14).booleanValue();
            Object r3 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.env.EnvObserveState.State");
            y.b r5 = (y.b) r3;
            if (r15 == false) goto L19;
            IDoraPageConfig r16 = EnvObserveViewModel.access$getDoraPageConfig(this.this$0);
            if (r16 == null) goto L18;
            r16.e(EnvObserveViewModel.END_TIME_SET, r2);
        L18:
            y.b r17 = y.b.a(r5, false, false, null, EnvObserveViewModel.access$endTimerStr(this.this$0), false, true, 23);
            EnvObserveViewModel.access$updateEndTimerInterval(this.this$0);
        L20:
            g49.d.d(EnvObserveViewModel.TAG, "user change end time result: " + r17);
            z0 r4 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0);
            this.L$0 = null;
            this.label = 2;
            if (r4.emit(r17, this) != r0) goto L24;
            return r0;
        L19:
            r17 = y.b.a(r5, false, false, null, null, false, false, 31);
            goto L20
        L10:
            ResultKt.throwOnFailure(r14);
            r2 = StringsKt.padStart(String.valueOf(this.$endHour), 2, '0') + ':' + StringsKt.padStart(String.valueOf(this.$endMinute), 2, '0');
            EnvObserveViewModel r18 = this.this$0;
            this.L$0 = r2;
            this.label = 1;
            r14 = EnvObserveViewModel.access$requestDeviceSyncInfo(r18, "environmental_observation_pause_timing_end_time", r2, this);
            if (r14 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEndTimerInterval$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEndTimerInterval$1", f = "EnvObserveViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C02771(Continuation<? super C02771> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02771(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            TimerJob.j.a().f(Boxing.boxInt(184));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEnvEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEnvEnable$1", f = "EnvObserveViewModel.kt", i = {}, l = {92, 111}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ EnvObserveViewModel this$0;

        public C02781(EnvObserveViewModel r1, boolean r2, Continuation<? super C02781> r3) {
            this.this$0 = r1;
            this.$isChecked = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02781(this.this$0, this.$isChecked, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r13);
        L32:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
        L17:
            boolean r14 = ((Boolean) r13).booleanValue();
            Object r2 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.env.EnvObserveState.State");
            y.b r4 = (y.b) r2;
            if (r14 == false) goto L27;
            IDoraPageConfig r15 = EnvObserveViewModel.access$getDoraPageConfig(this.this$0);
            if (r15 == null) goto L22;
            r15.a("dora_g_config_key_env_observe_enable", this.$isChecked);
        L22:
            y.b r16 = y.b.a(r4, this.$isChecked, false, null, null, false, true, 30);
            DoraBuryPointManager r3 = DoraBuryPointManager.a;
            if (this.$isChecked == false) goto L25;
            String r5 = "on";
        L26:
            DoraBuryPointManager.J(r3, "dora_observation_settings_change", MapsKt.mapOf(TuplesKt.to("dora_g_observation_switch", r5)), false, 12);
            EnvObserveViewModel.access$updateEnvEnableState(this.this$0);
        L28:
            z0 r6 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0);
            this.label = 2;
            if (r6.emit(r16, this) != r0) goto L32;
            return r0;
        L25:
            r5 = "off";
            goto L26
        L27:
            r16 = y.b.a(r4, false, false, null, null, false, false, 31);
            goto L28
        L10:
            ResultKt.throwOnFailure(r13);
            EnvObserveViewModel r17 = this.this$0;
            if (this.$isChecked == false) goto L13;
            String r7 = "1";
        L14:
            this.label = 1;
            r13 = EnvObserveViewModel.access$requestDeviceSyncInfo(r17, "environmental_observation_switch", r7, this);
            if (r13 != r0) goto L17;
            return r0;
        L13:
            r7 = "0";
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEnvEnableState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEnvEnableState$1", f = "EnvObserveViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C02791(Continuation<? super C02791> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02791(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            o49.b.b.a();
            EnvObserveChangeReason r3 = EnvObserveChangeReason.SWITCH_CHANGE;
            Intrinsics.checkNotNullParameter(r3, "reason");
            DoraEnvObserveManager.a.getClass();
            DoraEnvObserveManager.h(r3, 181);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEnvLight$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateEnvLight$1", f = "EnvObserveViewModel.kt", i = {}, l = {239, 254}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ EnvObserveViewModel this$0;

        public C02801(EnvObserveViewModel r1, boolean r2, Continuation<? super C02801> r3) {
            this.this$0 = r1;
            this.$isChecked = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02801(this.this$0, this.$isChecked, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            int r3 = 1;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r13);
        L44:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
        L17:
            boolean r14 = ((Boolean) r13).booleanValue();
            Object r2 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0).getValue();
            if ((r2 instanceof y.b) == false) goto L20;
            y.b r4 = (y.b) r2;
        L21:
            y.b r5 = r4;
            if (r5 != null) goto L25;
            g49.d.b(EnvObserveViewModel.TAG, "env observe timer stateFlow is Empty, plz check !!!");
            return Unit.INSTANCE;
        L25:
            if (r14 == false) goto L39;
            IDoraPageConfig r15 = EnvObserveViewModel.access$getDoraPageConfig(this.this$0);
            if (r15 == null) goto L29;
            r15.a("dora_g_config_key_env_observe_light_enable", this.$isChecked);
        L29:
            IDoraService r16 = EnvObserveViewModel.access$getDoraService(this.this$0);
            if (r16 == null) goto L38;
            com.larus.dora.impl.serviceimpl.r r17 = r16.g1();
            if (r17 == null) goto L38;
            if (this.$isChecked == true) goto L37;
            r3 = 2;
        L37:
            Boxing.boxInt(r17.e(r3));
        L38:
            y.b r18 = y.b.a(r5, false, false, null, null, this.$isChecked, true, 15);
        L40:
            z0 r6 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0);
            this.label = 2;
            if (r6.emit(r18, this) != r0) goto L44;
            return r0;
        L39:
            r18 = y.b.a(r5, false, false, null, null, false, false, 31);
            goto L40
        L20:
            r4 = null;
            goto L21
        L10:
            ResultKt.throwOnFailure(r13);
            EnvObserveViewModel r110 = this.this$0;
            if (this.$isChecked == false) goto L13;
            String r7 = "1";
        L14:
            this.label = 1;
            r13 = EnvObserveViewModel.access$requestDeviceSyncInfo(r110, "environmental_observation_lighting_switch", r7, this);
            if (r13 != r0) goto L17;
            return r0;
        L13:
            r7 = "0";
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateStartTimer$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateStartTimer$1", f = "EnvObserveViewModel.kt", i = {0}, l = {145, 155}, m = "invokeSuspend", n = {"startTime"}, s = {"L$0"})
    public static final class C02811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $startHour;
        final /* synthetic */ int $startMinute;
        Object L$0;
        int label;
        final /* synthetic */ EnvObserveViewModel this$0;

        public C02811(int r1, int r2, EnvObserveViewModel r3, Continuation<? super C02811> r4) {
            this.$startHour = r1;
            this.$startMinute = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02811(this.$startHour, this.$startMinute, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
        L24:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            String r2 = (String) this.L$0;
            ResultKt.throwOnFailure(r14);
        L13:
            boolean r15 = ((Boolean) r14).booleanValue();
            Object r3 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.env.EnvObserveState.State");
            y.b r5 = (y.b) r3;
            if (r15 == false) goto L19;
            IDoraPageConfig r16 = EnvObserveViewModel.access$getDoraPageConfig(this.this$0);
            if (r16 == null) goto L18;
            r16.e(EnvObserveViewModel.START_TIME_SET, r2);
        L18:
            y.b r17 = y.b.a(r5, false, false, EnvObserveViewModel.access$startTimerStr(this.this$0), null, false, true, 27);
            EnvObserveViewModel.access$updateStartTimerInterval(this.this$0);
        L20:
            g49.d.d(EnvObserveViewModel.TAG, "user change start time result: " + r17);
            z0 r4 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0);
            this.L$0 = null;
            this.label = 2;
            if (r4.emit(r17, this) != r0) goto L24;
            return r0;
        L19:
            r17 = y.b.a(r5, false, false, null, null, false, false, 31);
            goto L20
        L10:
            ResultKt.throwOnFailure(r14);
            r2 = StringsKt.padStart(String.valueOf(this.$startHour), 2, '0') + ':' + StringsKt.padStart(String.valueOf(this.$startMinute), 2, '0');
            EnvObserveViewModel r18 = this.this$0;
            this.L$0 = r2;
            this.label = 1;
            r14 = EnvObserveViewModel.access$requestDeviceSyncInfo(r18, "environmental_observation_pause_timing_start_time", r2, this);
            if (r14 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateStartTimerInterval$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateStartTimerInterval$1", f = "EnvObserveViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C02821(Continuation<? super C02821> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02821(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            TimerJob.j.a().f(Boxing.boxInt(183));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateTimeEnableState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateTimeEnableState$1", f = "EnvObserveViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C02831(Continuation<? super C02831> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02831(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            TimerJob.j.a().f(182);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateTimer$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel$updateTimer$1", f = "EnvObserveViewModel.kt", i = {}, l = {125, 134}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ EnvObserveViewModel this$0;

        public C02841(EnvObserveViewModel r1, boolean r2, Continuation<? super C02841> r3) {
            this.this$0 = r1;
            this.$isChecked = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02841(this.this$0, this.$isChecked, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r13);
        L28:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
        L17:
            boolean r14 = ((Boolean) r13).booleanValue();
            Object r2 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.env.EnvObserveState.State");
            y.b r4 = (y.b) r2;
            if (r14 == false) goto L23;
            IDoraPageConfig r15 = EnvObserveViewModel.access$getDoraPageConfig(this.this$0);
            if (r15 == null) goto L22;
            r15.a("dora_g_config_key_env_observe_timer_enable", this.$isChecked);
        L22:
            y.b r16 = y.b.a(r4, false, this.$isChecked, null, null, false, true, 29);
            EnvObserveViewModel.access$updateTimeEnableState(this.this$0);
        L24:
            z0 r3 = EnvObserveViewModel.access$get_envObserveTimerStateFlow$p(this.this$0);
            this.label = 2;
            if (r3.emit(r16, this) != r0) goto L28;
            return r0;
        L23:
            r16 = y.b.a(r4, false, false, null, null, false, false, 31);
            goto L24
        L10:
            ResultKt.throwOnFailure(r13);
            EnvObserveViewModel r17 = this.this$0;
            if (this.$isChecked == false) goto L13;
            String r5 = "1";
        L14:
            this.label = 1;
            r13 = EnvObserveViewModel.access$requestDeviceSyncInfo(r17, "environmental_observation_pause_timing_switch", r5, this);
            if (r13 != r0) goto L17;
            return r0;
        L13:
            r5 = "0";
            goto L14
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ IDoraService Mo() {
        return doraService_delegate$lambda$1();
    }

    public static /* synthetic */ IDoraPageConfig yo() {
        return doraPageConfig_delegate$lambda$0();
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$0() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private static final IDoraService doraService_delegate$lambda$1() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    private final String endTimerStr() {
        int r0 = j0.a;
        String r1 = j0.d(2131902547);
        IDoraPageConfig r2 = getDoraPageConfig();
        if (r2 == null) goto L8;
        String r3 = r2.f(END_TIME_SET, r1);
        if (r3 == null) goto L8;
        String r4 = r3;
    L9:
        List r5 = StringsKt.split$default(r4, new String[]{":"}, false, 0, 6, null);
        return StringsKt.padStart((String) ListProtector.get(r5, 0), 2, '0') + ':' + StringsKt.padStart((String) ListProtector.get(r5, 1), 2, '0');
    L8:
        r4 = r1;
        goto L9
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final IDoraService getDoraService() {
        return (IDoraService) this.doraService$delegate.getValue();
    }

    private final String startTimerStr() {
        int r0 = j0.a;
        String r1 = j0.d(2131902548);
        IDoraPageConfig r2 = getDoraPageConfig();
        if (r2 == null) goto L8;
        String r3 = r2.f(START_TIME_SET, r1);
        if (r3 == null) goto L8;
        String r4 = r3;
    L9:
        List r5 = StringsKt.split$default(r4, new String[]{":"}, false, 0, 6, null);
        return StringsKt.padStart((String) ListProtector.get(r5, 0), 2, '0') + ':' + StringsKt.padStart((String) ListProtector.get(r5, 1), 2, '0');
    L8:
        r4 = r1;
        goto L9
    }

    public EnvObserveViewModel() {
        StateFlowImpl r0 = j1.a(y.a.a);
        this._envObserveTimerStateFlow = r0;
        this.envObserveTimerState = r0;
        this.doraPageConfig$delegate = LazyKt.lazy(new z());
        this.doraService$delegate = LazyKt.lazy(new a0());
        initData();
    }

    private final void initData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void updateEndTimerInterval() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02771(null), 2, null);
    }

    private final void updateEnvEnableState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02791(null), 2, null);
    }

    private final void updateStartTimerInterval() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02821(null), 2, null);
    }

    private final void updateTimeEnableState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02831(null), 2, null);
    }

    public final List<Integer> endTimerInt() {
        List r0 = StringsKt.split$default(endTimerStr(), new String[]{":"}, false, 0, 6, null);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(CastIntegerProtector.parseInt((String) r2.next())));
        goto L4
    L6:
        return r1;
    }

    public final List<Integer> startTimerInt() {
        List r0 = StringsKt.split$default(startTimerStr(), new String[]{":"}, false, 0, 6, null);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(CastIntegerProtector.parseInt((String) r2.next())));
        goto L4
    L6:
        return r1;
    }

    public final i1<y> getEnvObserveTimerState() {
        return this.envObserveTimerState;
    }

    public static final /* synthetic */ String access$endTimerStr(EnvObserveViewModel r0) {
        return r0.endTimerStr();
    }

    public static final /* synthetic */ IDoraPageConfig access$getDoraPageConfig(EnvObserveViewModel r0) {
        return r0.getDoraPageConfig();
    }

    public static final /* synthetic */ IDoraService access$getDoraService(EnvObserveViewModel r0) {
        return r0.getDoraService();
    }

    public static final /* synthetic */ z0 access$get_envObserveTimerStateFlow$p(EnvObserveViewModel r0) {
        return r0._envObserveTimerStateFlow;
    }

    public static final /* synthetic */ String access$startTimerStr(EnvObserveViewModel r0) {
        return r0.startTimerStr();
    }

    public static final /* synthetic */ void access$updateEndTimerInterval(EnvObserveViewModel r0) {
        r0.updateEndTimerInterval();
    }

    public static final /* synthetic */ void access$updateEnvEnableState(EnvObserveViewModel r0) {
        r0.updateEnvEnableState();
    }

    public static final /* synthetic */ void access$updateStartTimerInterval(EnvObserveViewModel r0) {
        r0.updateStartTimerInterval();
    }

    public static final /* synthetic */ void access$updateTimeEnableState(EnvObserveViewModel r0) {
        r0.updateTimeEnableState();
    }

    public final void updateCurrentDoraDeviceMac(String r1) {
        this.mDoraDeviceMac = r1;
    }

    public final void updateEnvEnable(boolean r10) {
        g49.d.d(TAG, "user change env switch, isCheck: " + r10);
        DoraEnvObserveManager r0 = DoraEnvObserveManager.a;
        String r1 = this.mDoraDeviceMac;
        EnvObserveSettingAction r2 = EnvObserveSettingAction.ENV_SWITCH;
        r0.getClass();
        DoraEnvObserveManager.d(r1, r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02781(this, r10, null), 2, null);
    }

    public final void updateEnvLight(boolean r9) {
        g49.d.d(TAG, "user change env light switch, isCheck: " + r9 + ' ');
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02801(this, r9, null), 2, null);
    }

    public final void updateTimer(boolean r10) {
        g49.d.d(TAG, "user change timer switch, isCheck: " + r10);
        DoraEnvObserveManager r0 = DoraEnvObserveManager.a;
        String r1 = this.mDoraDeviceMac;
        EnvObserveSettingAction r2 = EnvObserveSettingAction.TIMER_SWITCH;
        r0.getClass();
        DoraEnvObserveManager.d(r1, r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02841(this, r10, null), 2, null);
    }

    public final void updateEndTimer(int r10, int r11) {
        g49.d.d(TAG, "user change end time, " + r10 + ':' + r11);
        DoraEnvObserveManager r0 = DoraEnvObserveManager.a;
        String r1 = this.mDoraDeviceMac;
        EnvObserveSettingAction r2 = EnvObserveSettingAction.END_TIME;
        r0.getClass();
        DoraEnvObserveManager.d(r1, r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02761(r10, r11, this, null), 2, null);
    }

    public final void updateStartTimer(int r10, int r11) {
        g49.d.d(TAG, "user change start time, " + r10 + ':' + r11);
        DoraEnvObserveManager r0 = DoraEnvObserveManager.a;
        String r1 = this.mDoraDeviceMac;
        EnvObserveSettingAction r2 = EnvObserveSettingAction.START_TIME;
        r0.getClass();
        DoraEnvObserveManager.d(r1, r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02811(r10, r11, this, null), 2, null);
    }

    private final Object requestDeviceSyncInfo(String r8, Object r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof C02751) == false) goto L7;
        C02751 r0 = (C02751) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L29:
        if (Result.isSuccess-impl(r12) == false) goto L42;
        Long r13 = ((i) r12).b();     // Catch: Throwable -> L39
        if (r13 != null) goto L34;
    L36:
        r4 = false;
    L37:
        return Boxing.boxBoolean(r4);
    L34:
        if (r13.longValue() != 0) goto L36;
    L39:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = ResultKt.createFailure(th);
    L42:
        if (Result.exceptionOrNull-impl(Result.constructor-impl(r12)) == null) goto L46;
        return Boxing.boxBoolean(false);
    L46:
        throw new KotlinNothingValueException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Iterator r15 = kj4.a.g().getDoraBindList().iterator();
    L16:
        if (r15.hasNext() == false) goto L20;
        Object r5 = r15.next();
        if (Intrinsics.areEqual(((DoraDevice) r5).mac, this.mDoraDeviceMac) == false) goto L16;
    L21:
        DoraDevice r6 = (DoraDevice) r5;
        if (r6 == null) goto L24;
        DoraNetworkApi r16 = DoraNetworkApi.a;
        List<? extends Pair<String, ? extends Object>> r17 = CollectionsKt.listOf(new Pair(r8, r9));
        r0.label = 1;
        r12 = r16.y(r6, r17, r0);
        if (r12 != r2) goto L29;
        return r2;
    L24:
        return Boxing.boxBoolean(false);
    L20:
        r5 = null;
    L7:
        r0 = new C02751(this, r10);
        goto L8
    }

    public static final /* synthetic */ Object access$requestDeviceSyncInfo(EnvObserveViewModel r0, String r1, Object r2, Continuation r3) {
        return r0.requestDeviceSyncInfo(r1, r2, r3);
    }
}
