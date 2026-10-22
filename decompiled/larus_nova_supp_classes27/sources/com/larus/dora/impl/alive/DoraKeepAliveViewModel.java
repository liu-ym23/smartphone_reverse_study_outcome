package com.larus.dora.impl.alive;

import android.content.IntentSender;
import android.os.Build;
import android.os.PowerManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.util.b0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J,\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J \u0010$\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J2\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/larus/dora/impl/alive/DoraKeepAliveViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_ignoreBatteryOptimizationsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "ignoreBatteryOptimizationStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getIgnoreBatteryOptimizationStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_keepAliveCdmToggleStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "get_keepAliveCdmToggleStateFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "keepAliveCdmToggleStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getKeepAliveCdmToggleStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadIgnoreBatteryOptimization", "", "loopCheckIgnoreBatteryOptimization", "isIgnoringBatteryOptimizations", "enableOngoingNotification", "enabled", "isOngoingNotificationEnabled", "reportBatteryOptimizeSwitch", "on", "loadCdmState", "manager", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "associator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "macAddress", "", "sn", "isCdmKeepAliveEnabled", "enableCdm", "enable", "updateKeepAliveCdmStateAndReport", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraKeepAliveViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long LOOP_CHECK_DELAY_TIME_MILLIS = 500;
    private static final int LOOP_CHECK_TIMES = 4;
    private static final String TAG = "DoraKeepAliveViewModel";
    private final z0<Boolean> _ignoreBatteryOptimizationsStateFlow;
    private final MutableSharedFlow<Boolean> _keepAliveCdmToggleStateFlow;
    private final i1<Boolean> ignoreBatteryOptimizationStateFlow;
    private final d1<Boolean> keepAliveCdmToggleStateFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements oy8.c {
        public final /* synthetic */ IFlowCompanionDeviceManager a;
        public final /* synthetic */ DoraKeepAliveViewModel b;

        public final void a(CharSequence r3) {
            g49.d.d(DoraKeepAliveViewModel.TAG, "CDM onFailure: " + r3);
            DoraKeepAliveViewModel.access$updateKeepAliveCdmStateAndReport(this.b, false);
        }

        public final void b(IntentSender r2) {
            Intrinsics.checkNotNullParameter(r2, "intentSender");
            g49.d.d(DoraKeepAliveViewModel.TAG, "CDM onAssociationPending");
        }

        public final void c(String r3) {
            Intrinsics.checkNotNullParameter(r3, "macAddress");
            g49.d.d(DoraKeepAliveViewModel.TAG, "CDM onAssociationCreated");
            if (this.a.m(r3) == true) goto L5;
            this.a.g(r3);
        L5:
            DoraKeepAliveViewModel.access$updateKeepAliveCdmStateAndReport(this.b, true);
        }

        public b(IFlowCompanionDeviceManager r1, DoraKeepAliveViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.alive.DoraKeepAliveViewModel$loadCdmState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.alive.DoraKeepAliveViewModel$loadCdmState$1", f = "DoraKeepAliveViewModel.kt", i = {0}, l = {100}, m = "invokeSuspend", n = {"state"}, s = {"Z$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ oy8.e $associator;
        final /* synthetic */ String $macAddress;
        final /* synthetic */ IFlowCompanionDeviceManager $manager;
        final /* synthetic */ String $sn;
        boolean Z$0;
        int label;
        final /* synthetic */ DoraKeepAliveViewModel this$0;

        public AnonymousClass1(DoraKeepAliveViewModel r1, IFlowCompanionDeviceManager r2, String r3, String r4, oy8.e r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$manager = r2;
            this.$macAddress = r3;
            this.$sn = r4;
            this.$associator = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$manager, this.$macAddress, this.$sn, this.$associator, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            boolean r2 = this.Z$0;
            ResultKt.throwOnFailure(r8);
        L12:
            if (r2 == true) goto L15;
            this.this$0.enableCdm(true, this.$manager, this.$associator, this.$macAddress, this.$sn);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            boolean r9 = this.this$0.isCdmKeepAliveEnabled(this.$manager, this.$macAddress, this.$sn);
            g49.d.d(DoraKeepAliveViewModel.TAG, "loadCdmState: state=" + r9);
            MutableSharedFlow<Boolean> r3 = this.this$0.get_keepAliveCdmToggleStateFlow();
            Boolean r4 = Boxing.boxBoolean(r9);
            this.Z$0 = r9;
            this.label = 1;
            if (r3.emit(r4, this) != r0) goto L11;
            return r0;
        L11:
            r2 = r9;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.alive.DoraKeepAliveViewModel$loadIgnoreBatteryOptimization$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.alive.DoraKeepAliveViewModel$loadIgnoreBatteryOptimization$1", f = "DoraKeepAliveViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraKeepAliveViewModel this$0;

        public C01781(DoraKeepAliveViewModel r1, Continuation<? super C01781> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01781(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            boolean r6 = DoraKeepAliveViewModel.access$isIgnoringBatteryOptimizations(this.this$0);
            g49.d.d(DoraKeepAliveViewModel.TAG, "loadIgnoreBatteryOptimization: state=" + r6);
            z0 r2 = DoraKeepAliveViewModel.access$get_ignoreBatteryOptimizationsStateFlow$p(this.this$0);
            Boolean r7 = Boxing.boxBoolean(r6);
            this.label = 1;
            if (r2.emit(r7, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.alive.DoraKeepAliveViewModel$loopCheckIgnoreBatteryOptimization$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.alive.DoraKeepAliveViewModel$loopCheckIgnoreBatteryOptimization$1", f = "DoraKeepAliveViewModel.kt", i = {0, 0, 1, 1}, l = {51, 52}, m = "invokeSuspend", n = {"it", "state", "it", "state"}, s = {"I$2", "Z$0", "I$2", "Z$0"})
    public static final class C01791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ DoraKeepAliveViewModel this$0;

        public C01791(DoraKeepAliveViewModel r1, Continuation<? super C01791> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01791(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0091 -> B:20:0x0095). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            boolean r2 = this.Z$0;
            int r4 = this.I$2;
            int r5 = this.I$1;
            int r6 = this.I$0;
            DoraKeepAliveViewModel r7 = (DoraKeepAliveViewModel) this.L$0;
            ResultKt.throwOnFailure(r12);
            DoraKeepAliveViewModel r13 = r7;
            C01791 r8 = this;
        L21:
            if (r4 != 3) goto L23;
            DoraKeepAliveViewModel.access$reportBatteryOptimizeSwitch(r13, r2);
        L23:
            r4 = r5 + 1;
            int r3 = r6;
            C01791 r9 = r8;
        L11:
            if (r4 >= r3) goto L25;
            boolean r10 = DoraKeepAliveViewModel.access$isIgnoringBatteryOptimizations(r13);
            g49.d.d(DoraKeepAliveViewModel.TAG, "loopCheckIgnoreBatteryOptimization: state=" + r10);
            z0 r11 = DoraKeepAliveViewModel.access$get_ignoreBatteryOptimizationsStateFlow$p(r13);
            Boolean r14 = Boxing.boxBoolean(r10);
            r9.L$0 = r13;
            r9.I$0 = r3;
            r9.I$1 = r4;
            r9.I$2 = r4;
            r9.Z$0 = r10;
            r9.label = 1;
            if (r11.emit(r14, r9) != r0) goto L15;
            return r0;
        L15:
            DoraKeepAliveViewModel r15 = r13;
            int r16 = r4;
            r6 = r3;
            r2 = r10;
        L16:
            r9.L$0 = r15;
            r9.I$0 = r6;
            r9.I$1 = r16;
            r9.I$2 = r4;
            r9.Z$0 = r2;
            r9.label = 2;
            if (DelayKt.delay(DoraKeepAliveViewModel.LOOP_CHECK_DELAY_TIME_MILLIS, r9) != r0) goto L19;
            return r0;
        L19:
            C01791 r17 = r9;
            r5 = r16;
            r13 = r15;
            r8 = r17;
            goto L21
        L25:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r2 = this.Z$0;
            r4 = this.I$2;
            int r18 = this.I$1;
            r6 = this.I$0;
            r15 = (DoraKeepAliveViewModel) this.L$0;
            ResultKt.throwOnFailure(r12);
            r16 = r18;
            r9 = this;
            goto L16
        L10:
            ResultKt.throwOnFailure(r12);
            r13 = this.this$0;
            r3 = 4;
            r4 = 0;
            r9 = this;
            goto L11
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isIgnoringBatteryOptimizations() {
        AppHost.Companion r0 = AppHost.a;
        Object r1 = r0.getApplication().getSystemService("power");
        if ((r1 instanceof PowerManager) == false) goto L5;
        PowerManager r2 = (PowerManager) r1;
    L7:
        if (r2 != null) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        return false;
    L12:
        return r2.isIgnoringBatteryOptimizations(r0.getApplication().getPackageName());
    L5:
        r2 = null;
        goto L7
    }

    public final boolean isOngoingNotificationEnabled() {
        b0.a.getClass();
        return b0.j().getBoolean("dora_enable_ongoing_notification", true);
    }

    public DoraKeepAliveViewModel() {
        StateFlowImpl r0 = j1.a(Boolean.FALSE);
        this._ignoreBatteryOptimizationsStateFlow = r0;
        this.ignoreBatteryOptimizationStateFlow = r0;
        MutableSharedFlow<Boolean> r1 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._keepAliveCdmToggleStateFlow = r1;
        this.keepAliveCdmToggleStateFlow = r1;
    }

    public final void loadIgnoreBatteryOptimization() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01781(this, null), 2, null);
    }

    public final void loopCheckIgnoreBatteryOptimization() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01791(this, null), 2, null);
    }

    public final i1<Boolean> getIgnoreBatteryOptimizationStateFlow() {
        return this.ignoreBatteryOptimizationStateFlow;
    }

    public final d1<Boolean> getKeepAliveCdmToggleStateFlow() {
        return this.keepAliveCdmToggleStateFlow;
    }

    public final MutableSharedFlow<Boolean> get_keepAliveCdmToggleStateFlow() {
        return this._keepAliveCdmToggleStateFlow;
    }

    public static final /* synthetic */ z0 access$get_ignoreBatteryOptimizationsStateFlow$p(DoraKeepAliveViewModel r0) {
        return r0._ignoreBatteryOptimizationsStateFlow;
    }

    public static final /* synthetic */ boolean access$isIgnoringBatteryOptimizations(DoraKeepAliveViewModel r0) {
        return r0.isIgnoringBatteryOptimizations();
    }

    private final void reportBatteryOptimizeSwitch(boolean r5) {
        j49.b.a.c(2, r5);
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        if (r5 == false) goto L5;
        String r6 = "on";
    L6:
        DoraBuryPointManager.J(r0, "dm_battery_optimize_switch", MapsKt.mapOf(TuplesKt.to("battery_optimize_switch", r6)), false, 12);
        return;
    L5:
        r6 = "off";
        goto L6
    }

    private final void updateKeepAliveCdmStateAndReport(boolean r5) {
        this._keepAliveCdmToggleStateFlow.tryEmit(Boolean.valueOf(r5));
        j49.b.a.c(1, r5);
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dm_keep_alive_cdm_switch", MapsKt.mapOf(TuplesKt.to("keep_alive_cdm_switch", j49.b.l(r5))), false, 12);
    }

    public void enableOngoingNotification(boolean r3) {
        b0.a.getClass();
        b0.j().storeBoolean("dora_enable_ongoing_notification", r3);
    }

    public static final /* synthetic */ void access$reportBatteryOptimizeSwitch(DoraKeepAliveViewModel r0, boolean r1) {
        r0.reportBatteryOptimizeSwitch(r1);
    }

    public static final /* synthetic */ void access$updateKeepAliveCdmStateAndReport(DoraKeepAliveViewModel r0, boolean r1) {
        r0.updateKeepAliveCdmStateAndReport(r1);
    }

    public final boolean isCdmKeepAliveEnabled(IFlowCompanionDeviceManager r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "macAddress");
        Intrinsics.checkNotNullParameter(r5, "sn");
        if (r3 == null) goto L5;
        boolean r1 = r3.b(r4);
    L6:
        if (r1 == true) goto L11;
        if (r3 == null) goto L9;
        boolean r6 = r3.c(r5);
    L10:
        if (r6 == true) goto L11;
        return false;
    L9:
        r6 = false;
    L11:
        if (r3 == null) goto L13;
        boolean r7 = r3.m(r4);
    L14:
        if (r7 == false) goto L18;
        return true;
    L18:
        return false;
    L13:
        r7 = false;
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    public void loadCdmState(IFlowCompanionDeviceManager r12, oy8.e r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "macAddress");
        Intrinsics.checkNotNullParameter(r15, "sn");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r12, r14, r15, r13, null), 2, null);
    }

    public final void enableCdm(boolean r4, IFlowCompanionDeviceManager r5, oy8.e r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "macAddress");
        Intrinsics.checkNotNullParameter(r8, "sn");
        if (r5 == null) goto L39;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r4 == true) goto L9;
    L32:
        e = move-exception;
        g49.d.c(TAG, "Error disabling CDM ", e);
        return;
    L25:
        if (r5.m(r7) == false) goto L28;
        r5.d(r7);     // Catch: Exception -> L32
    L28:
        if (r5.b(r7) == false) goto L30;
        r5.a(r7);     // Catch: Exception -> L32
    L30:
        r5.k(r8);     // Catch: Exception -> L32
        updateKeepAliveCdmStateAndReport(false);     // Catch: Exception -> L32
        return;
    L9:
        if (r5.c(r8) == false) goto L11;
    L14:
        boolean r9 = true;
    L15:
        if (r9 == true) goto L35;
        r6.a(r7, r8, new b(r5, this));
        return;
    L35:
    L22:
        e = move-exception;
        g49.d.c(TAG, "Start observing failed , maybe re-associate needed?", e);
        updateKeepAliveCdmStateAndReport(false);
        return;
    L18:
        if (r5.m(r7) == true) goto L20;
        r5.g(r7);     // Catch: Exception -> L22
    L20:
        updateKeepAliveCdmStateAndReport(true);     // Catch: Exception -> L22
        return;
    L11:
        if (r5.b(r7) == true) goto L14;
        r9 = false;
        goto L15
    }
}
