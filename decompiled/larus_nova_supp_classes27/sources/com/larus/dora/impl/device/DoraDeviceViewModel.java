package com.larus.dora.impl.device;

import android.app.Application;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.SystemClock;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.network.util.ScreenStateManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Deprecated(message = "This view model is deprecated. See DoraDynamicViewModelV2.")
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t*\u000358<\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010>\u001a\u00020?H\u0014J\n\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0016\u0010B\u001a\u0002002\f\u0010C\u001a\b\u0012\u0004\u0012\u00020,0DH\u0002J\u0006\u0010E\u001a\u00020?J\u000e\u0010F\u001a\u00020?2\u0006\u0010G\u001a\u00020AJ\u000e\u0010H\u001a\u00020?2\u0006\u0010I\u001a\u00020,J\u001c\u0010J\u001a\u00020?2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020,0DH\u0083@¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u00020?2\u0006\u0010M\u001a\u00020A2\b\b\u0002\u0010F\u001a\u000200J\u000e\u0010N\u001a\u00020?2\u0006\u0010I\u001a\u00020,J\u000e\u0010O\u001a\u00020?2\u0006\u0010M\u001a\u00020AJ\u000e\u0010P\u001a\u00020?2\u0006\u0010M\u001a\u00020AJ\u0006\u0010Q\u001a\u00020?J\u001a\u0010R\u001a\u00020?2\u0012\b\u0002\u0010S\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010TJ\u0006\u0010U\u001a\u00020?J\u0010\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u000200H\u0002J\u000e\u0010X\u001a\u00020?2\u0006\u0010Y\u001a\u00020,J\b\u0010Z\u001a\u00020?H\u0002J\u0006\u0010[\u001a\u00020?R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109R\u000e\u0010:\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=¨\u0006]"}, d2 = {"Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "deviceStateSeq", "", "_deviceStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/DeviceState;", "deviceStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getDeviceStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_deviceIntentSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/DeviceAction;", "deviceIntentSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getDeviceIntentSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_sodaBannerSharedFlow", "Lcom/larus/dora/impl/network/ActivityStatus;", "sodaBannerSharedFlow", "getSodaBannerSharedFlow", "_deviceFeatureStateFlow", "Lcom/larus/dora/impl/device/DeviceFeature;", "deviceFeatureStateFlow", "getDeviceFeatureStateFlow", "scanTimeoutJob", "Lkotlinx/coroutines/Job;", "connectOrScanJob", "doraScanCallback", "Landroid/bluetooth/le/ScanCallback;", "loadDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "hasLaunchOnBoarding", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastConnectDevice", "Lcom/larus/dora/impl/DoraSimpleDevice;", "getLastConnectDevice", "()Lcom/larus/dora/impl/DoraSimpleDevice;", "disconnectedRetryJob", "bots", "", "", "getBots", "()Ljava/util/Map;", "isSwitchingDevice", "", "()Z", "setSwitchingDevice", "(Z)V", "doraLinkCallback", "com/larus/dora/impl/device/DoraDeviceViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/device/DoraDeviceViewModel$doraLinkCallback$1;", "doraBudsCallback", "com/larus/dora/impl/device/DoraDeviceViewModel$doraBudsCallback$1", "Lcom/larus/dora/impl/device/DoraDeviceViewModel$doraBudsCallback$1;", "isScreenOn", "screenListener", "com/larus/dora/impl/device/DoraDeviceViewModel$screenListener$1", "Lcom/larus/dora/impl/device/DoraDeviceViewModel$screenListener$1;", "onCleared", "", "getCurrentConnectedDoraOrNull", "Lcom/bytedance/dora/device/DoraDevice;", "connectBtConnectedDora", "btConnectedDevices", "", "load", "autoConnect", "autoConnectDevice", "startConnectOrScan", "from", "scanForDora", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchOnboarding", "device", "stopConnectAndScan", "checkBindState", "replaceBind", "disconnectSpp", "checkSodaBanner", "activitiesStatus", "", "startDisconnectedRetry", "stopDisconnectedRetry", "resetTryState", "reportBotSwitch", "botName", "loadDeviceFeature", "syncUserSettings", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long DISCONNECTED_RETRY_TIMEOUT = 15000;
    private static final long SCAN_FOR_A_LONG_TIME = 12000;
    private static final long SCAN_NO_LIMIT_TIME = 3000;
    private static final String TAG = "DoraDeviceViewModel";
    private final z0<com.larus.dora.impl.device.b> _deviceFeatureStateFlow;
    private final MutableSharedFlow<com.larus.dora.impl.device.a> _deviceIntentSharedFlow;
    private final z0<com.larus.dora.impl.device.c> _deviceStateFlow;
    private final MutableSharedFlow<com.larus.dora.impl.network.a> _sodaBannerSharedFlow;
    private final Map<String, String> bots;
    private Job connectOrScanJob;
    private final i1<com.larus.dora.impl.device.b> deviceFeatureStateFlow;
    private final d1<com.larus.dora.impl.device.a> deviceIntentSharedFlow;
    private final i1<com.larus.dora.impl.device.c> deviceStateFlow;
    private long deviceStateSeq;
    private Job disconnectedRetryJob;
    private final DoraDeviceViewModel$doraBudsCallback$1 doraBudsCallback;
    private final DoraDeviceViewModel$doraLinkCallback$1 doraLinkCallback;
    private ScanCallback doraScanCallback;
    private AtomicBoolean hasLaunchOnBoarding;
    private boolean isScreenOn;
    private boolean isSwitchingDevice;
    private final ExecutorCoroutineDispatcher loadDispatcher;
    private Job scanTimeoutJob;
    private final c screenListener;
    private final d1<com.larus.dora.impl.network.a> sodaBannerSharedFlow;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$1", f = "DoraDeviceViewModel.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DoraDeviceViewModel a;

            public a(DoraDeviceViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r6, Continuation r7) {
                Map r8 = (Map) r6;
                com.larus.dora.impl.device.c r9 = (com.larus.dora.impl.device.c) DoraDeviceViewModel.access$get_deviceStateFlow$p(this.a).getValue();
                if ((r9 instanceof com.larus.dora.impl.device.c.a) == false) goto L11;
                String r10 = (String) CollectionsKt.firstOrNull(r8.keySet());
                if (r10 != null) goto L7;
                r10 = "";
            L7:
                com.larus.dora.impl.device.c.a r11 = (com.larus.dora.impl.device.c.a) r9;
                if (Intrinsics.areEqual(r11.b.sn, r10) == false) goto L11;
                z0 r12 = DoraDeviceViewModel.access$get_deviceStateFlow$p(this.a);
                long r0 = DoraDeviceViewModel.access$getDeviceStateSeq$p(this.a);
                DoraDeviceViewModel.access$setDeviceStateSeq$p(this.a, 1 + r0);
                DoraDevice r13 = r11.b;
                Intrinsics.checkNotNullParameter(r13, "device");
                r12.setValue(new com.larus.dora.impl.device.c.a(r0, r13));
            L11:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(DoraDeviceViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            b1 r6 = com.larus.dora.impl.ota.b.c;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$autoConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$autoConnect$1", f = "DoraDeviceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $autoConnectDevice;
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01801(DoraDeviceViewModel r1, DoraDevice r2, Continuation<? super C01801> r3) {
            this.this$0 = r1;
            this.$autoConnectDevice = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01801(this.this$0, this.$autoConnectDevice, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r6);
            List r7 = kj4.a.g().getDeviceList();
            if (r7 != null) goto L7;
            r7 = CollectionsKt.emptyList();
        L7:
            List r8 = CollectionsKt.filterNotNull(r7);
            DoraDevice r0 = this.$autoConnectDevice;
            ArrayList r1 = new ArrayList();
            Iterator r9 = r8.iterator();
        L9:
            if (r9.hasNext() == false) goto L13;
            Object r2 = r9.next();
            if (Intrinsics.areEqual(((DoraDevice) r2).mac, r0.mac) == false) goto L9;
            r1.add(r2);
            goto L9
        L13:
            DoraDeviceViewModel.access$getHasLaunchOnBoarding$p(this.this$0).set(false);
            if (r1.isEmpty() == false) goto L16;
            g49.d.d(DoraDeviceViewModel.TAG, "autoConnect: autoConnectDevice not in historyDoraList");
            this.this$0.launchOnboarding(this.$autoConnectDevice, true);
        L18:
            return Unit.INSTANCE;
        L16:
            DoraDevice r10 = (DoraDevice) CollectionsKt.first(r1);
            g49.d.d(DoraDeviceViewModel.TAG, "autoConnect: autoConnectDevice in historyDoraList, " + r10);
            g49.d.d(DoraDeviceViewModel.TAG, "autoConnect: connect " + r10.sn + ", result=" + com.larus.dora.impl.core.t.a(r10));
            goto L18
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class b extends ScanCallback {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ Ref.LongRef c;
        public final /* synthetic */ Set<String> d;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> e;
        public final /* synthetic */ DoraDeviceViewModel f;

        public final String toString() {
            return "ScanCallback@" + Integer.toHexString(hashCode());
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.b(DoraDeviceViewModel.TAG, "onScanFailed# " + r3);
        }

        public final void a(DoraDevice r4, String r5) {
            g49.d.d(DoraDeviceViewModel.TAG, r5 + "#onDeviceFound: " + o59.a.h(r4) + ", stopScan#" + this);
            Job r6 = DoraDeviceViewModel.access$getScanTimeoutJob$p(this.f);
            if (r6 == null) goto L5;
            Job.DefaultImpls.cancel$default(r6, null, 1, null);
        L5:
            kj4.a.g().stopScan(this);
            DoraDeviceViewModel.launchOnboarding$default(this.f, r4, false, 2, null);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r6, ScanResult r7) {
            DoraDevice r8 = kj4.a.g().convertScanResultToDoraDevice(r7);
            StringBuilder r9 = new StringBuilder("onScanResult# ");
            if (r8 == null) goto L5;
            String r0 = o59.a.h(r8);
        L6:
            r9.append(r0);
            r9.append(",hasInputMac=");
            r9.append(this.a);
            r9.append(", scanNoLimit=");
            r9.append(this.b.element);
            g49.d.d(DoraDeviceViewModel.TAG, r9.toString());
            if (r8 == null) goto L34;
            String r10 = r8.mac;
            if (r10 == null) goto L41;
            long r1 = this.c.element;
            if (r1 <= 0) goto L15;
            com.larus.dora.impl.core.z r4 = com.larus.dora.impl.core.z.a;
            com.larus.dora.impl.core.z.d(r1);
            this.c.element = 0;
        L15:
            if (this.a == false) goto L27;
            if (this.b.element == true) goto L27;
            if (this.d.contains(r10) == false) goto L22;
            a(r8, "onScanResult#1");
            return;
        L22:
            if (o59.a.t(r8) == false) goto L36;
            Ref.ObjectRef<DoraDevice> r11 = this.e;
            if (r11.element != null) goto L37;
            r11.element = r8;
            return;
        L37:
            return;
        L36:
            return;
        L27:
            if (o59.a.t(r8) == false) goto L29;
        L32:
            a(r8, "onScanResult#2");
            return;
        L29:
            if (this.b.element == true) goto L31;
            return;
        L31:
            if (this.d.contains(r10) == true) goto L32;
            return;
        L41:
            return;
        L34:
            return;
        L5:
            r0 = null;
            goto L6
        }

        public b(boolean r1, Ref.BooleanRef r2, Ref.LongRef r3, Set<String> r4, Ref.ObjectRef<DoraDevice> r5, DoraDeviceViewModel r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class c implements ScreenStateManager.b {
        public final /* synthetic */ DoraDeviceViewModel a;

        public final void onScreenOff() {
            g49.d.d(DoraDeviceViewModel.TAG, "onScreenOff");
            DoraDeviceViewModel.access$setScreenOn$p(this.a, false);
        }

        public final void onScreenOn() {
            g49.d.d(DoraDeviceViewModel.TAG, "onScreenOn");
            DoraDeviceViewModel.access$setScreenOn$p(this.a, true);
        }

        public final void onUserPresent() {
            g49.d.d(DoraDeviceViewModel.TAG, "onUserPresent");
            DoraDeviceViewModel.access$setScreenOn$p(this.a, true);
        }

        public c(DoraDeviceViewModel r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$checkBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$checkBindState$1", f = "DoraDeviceViewModel.kt", i = {2, 3}, l = {436, 438, 445, 447}, m = "invokeSuspend", n = {"bindData", "bindData"}, s = {"L$2", "L$2"})
    public static final class C01811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01811(DoraDeviceViewModel r1, DoraDevice r2, Continuation<? super C01811> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01811(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            com.larus.dora.impl.network.b r2 = (com.larus.dora.impl.network.b) this.L$2;
            DoraDeviceViewModel r3 = (DoraDeviceViewModel) this.L$1;
            Object r4 = this.L$0;
            ResultKt.throwOnFailure(r15);
        L46:
            com.larus.dora.impl.network.b r9 = r2;
            Object r16 = r4;
        L47:
            r3.checkSodaBanner(r9.a());
        L48:
            Throwable r17 = Result.exceptionOrNull-impl(r16);
            if (r17 == null) goto L52;
            g49.d.c(DoraDeviceViewModel.TAG, "checkBindState: failure", r17);
            t19.s r18 = t19.s.a;
            Application r5 = AppHost.a.getApplication();
            r18.getClass();
            t19.s.b(r5, 2131908080, false);
        L52:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r15);
            r16 = ((Result) r15).unbox-impl();
        L22:
            r3 = this.this$0;
            DoraDevice r8 = this.$device;
            if (Result.isSuccess-impl(r16) == false) goto L48;
            r9 = (com.larus.dora.impl.network.b) r16;
            Integer r10 = r9.b();
            if (r10 == null) goto L27;
            int r11 = r10.intValue();
        L28:
            g49.d.d(DoraDeviceViewModel.TAG, "checkBindState: bindCode=" + r11);
            Object r12 = DoraDeviceViewModel.access$get_deviceStateFlow$p(r3).getValue();
            DoraDevice r13 = null;
            if ((r12 instanceof com.larus.dora.impl.device.c.a) == false) goto L31;
            com.larus.dora.impl.device.c.a r14 = (com.larus.dora.impl.device.c.a) r12;
        L32:
            if (r14 == null) goto L35;
            r13 = r14.b;
        L35:
            if (Intrinsics.areEqual(r13, r8) == false) goto L47;
            if (r11 == 1) goto L42;
            if (r11 != 2) goto L47;
            MutableSharedFlow r6 = DoraDeviceViewModel.access$get_deviceIntentSharedFlow$p(r3);
            com.larus.dora.impl.device.a.b r7 = new com.larus.dora.impl.device.a.b(r8);
            this.L$0 = r16;
            this.L$1 = r3;
            this.L$2 = r9;
            this.label = 3;
            if (r6.emit(r7, this) != r0) goto L45;
            return r0;
        L45:
            r4 = r16;
            r2 = r9;
            goto L46
        L42:
            kj4.a r20 = kj4.a.g();
            this.L$0 = r16;
            this.L$1 = r3;
            this.L$2 = r9;
            this.label = 4;
            if (DoraAdapterExtKt.b(r20) != r0) goto L45;
            return r0;
        L31:
            r14 = null;
            goto L32
        L27:
            r11 = 0;
            goto L28
        L13:
            ResultKt.throwOnFailure(r15);
        L19:
            DoraNetworkApi r110 = DoraNetworkApi.a;
            DoraDevice r21 = this.$device;
            this.label = 2;
            r16 = r110.e(r21, true, this);
            if (r16 != r0) goto L22;
            return r0;
        L14:
            ResultKt.throwOnFailure(r15);
            if (DoraDeviceViewModel.access$isScreenOn$p(this.this$0) == true) goto L19;
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$checkSodaBanner$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$checkSodaBanner$1", f = "DoraDeviceViewModel.kt", i = {}, l = {492}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01821(DoraDeviceViewModel r1, Continuation<? super C01821> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01821(this.this$0, r3);
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
            MutableSharedFlow r6 = DoraDeviceViewModel.access$get_sodaBannerSharedFlow$p(this.this$0);
            com.larus.dora.impl.network.a r2 = new com.larus.dora.impl.network.a(1, false);
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$checkSodaBanner$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$checkSodaBanner$2", f = "DoraDeviceViewModel.kt", i = {}, l = {500}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.dora.impl.network.a $status;
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public AnonymousClass2(DoraDeviceViewModel r1, com.larus.dora.impl.network.a r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$status = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$status, r4);
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
            MutableSharedFlow r5 = DoraDeviceViewModel.access$get_sodaBannerSharedFlow$p(this.this$0);
            com.larus.dora.impl.network.a r2 = this.$status;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$disconnectSpp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$disconnectSpp$1", f = "DoraDeviceViewModel.kt", i = {}, l = {484}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01831(DoraDeviceViewModel r1, Continuation<? super C01831> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01831(this.this$0, r3);
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
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            com.larus.dora.impl.device.c r5 = (com.larus.dora.impl.device.c) DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r5 instanceof com.larus.dora.impl.device.c.a) == false) goto L14;
            kj4.a r2 = kj4.a.g();
            DoraDevice r6 = ((com.larus.dora.impl.device.c.a) r5).b;
            this.label = 1;
            if (DoraAdapterExtKt.e(r2, r6) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$launchOnboarding$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$launchOnboarding$1", f = "DoraDeviceViewModel.kt", i = {}, l = {414}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoConnect;
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01841(DoraDeviceViewModel r1, DoraDevice r2, boolean r3, Continuation<? super C01841> r4) {
            this.this$0 = r1;
            this.$device = r2;
            this.$autoConnect = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01841(this.this$0, this.$device, this.$autoConnect, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L13:
            DoraDeviceViewModel.access$stopDisconnectedRetry(this.this$0, true);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            if (DoraDeviceViewModel.access$getHasLaunchOnBoarding$p(this.this$0).compareAndSet(false, true) == false) goto L15;
            g49.d.d(DoraDeviceViewModel.TAG, "launchOnboarding: " + this.$device.sn);
            MutableSharedFlow r7 = DoraDeviceViewModel.access$get_deviceIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.a.C0031a r2 = new com.larus.dora.impl.device.a.C0031a(this.$device, this.$autoConnect);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$load$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$load$1", f = "DoraDeviceViewModel.kt", i = {}, l = {248, 253, 258}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01851(DoraDeviceViewModel r1, Continuation<? super C01851> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01851(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);
        L27:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r10);
        L19:
            DoraDeviceViewModel.access$loadDeviceFeature(this.this$0);
            goto L27
        L12:
            ResultKt.throwOnFailure(r10);
            g49.d.d(DoraDeviceViewModel.TAG, "load: start");
            if (DoraAdapterExtKt.r(kj4.a.g()) == false) goto L23;
            DoraDevice r11 = DoraDeviceViewModel.access$getCurrentConnectedDoraOrNull(this.this$0);
            if (r11 == null) goto L20;
            g49.d.d(DoraDeviceViewModel.TAG, "load: emit DeviceState.Connected, " + r11);
            z0 r2 = DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0);
            long r5 = DoraDeviceViewModel.access$getDeviceStateSeq$p(this.this$0);
            DoraDeviceViewModel.access$setDeviceStateSeq$p(this.this$0, 1 + r5);
            com.larus.dora.impl.device.c.a r3 = new com.larus.dora.impl.device.c.a(r5, r11);
            this.label = 1;
            if (r2.emit(r3, this) != r0) goto L19;
            return r0;
        L20:
            g49.d.d(DoraDeviceViewModel.TAG, "load: emit DeviceState.Disconnected");
            z0 r12 = DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0);
            com.larus.dora.impl.device.c.b r4 = new com.larus.dora.impl.device.c.b(false, DoraDeviceViewModel.access$getLastConnectDevice(this.this$0));
            this.label = 2;
            if (r12.emit(r4, this) != r0) goto L27;
            return r0;
        L23:
            g49.d.d(DoraDeviceViewModel.TAG, "load: emit DeviceState.Scan");
            z0 r13 = DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0);
            com.larus.dora.impl.device.c.d r6 = com.larus.dora.impl.device.c.d.a;
            this.label = 3;
            if (r13.emit(r6, this) != r0) goto L27;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$loadDeviceFeature$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$loadDeviceFeature$1", f = "DoraDeviceViewModel.kt", i = {1, 1}, l = {551, 554}, m = "invokeSuspend", n = {"proactiveSettings", "i"}, s = {"L$0", "I$0"})
    public static final class C01861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01861(DoraDeviceViewModel r1, Continuation<? super C01861> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01861(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007f -> B:21:0x0082). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            int r2 = this.I$0;
            DoraPushSummaryConfig r4 = (DoraPushSummaryConfig) this.L$0;
            ResultKt.throwOnFailure(r9);
            C01861 r10 = this;
        L21:
            r2 = r2 + 1;
        L12:
            if (r2 >= 3) goto L23;
            sk4.e r5 = kj4.a.g().requestProtocolInfo();
            g49.d.d(DoraDeviceViewModel.TAG, "loadDeviceFeature: tryCount=" + r2 + ", " + r5);
            if (r5 == null) goto L18;
            z0 r3 = DoraDeviceViewModel.access$get_deviceFeatureStateFlow$p(r10.this$0);
            com.larus.dora.impl.device.b.C0033b r6 = new com.larus.dora.impl.device.b.C0033b(r5, r4);
            r10.L$0 = null;
            r10.label = 1;
            if (r3.emit(r6, r10) != r0) goto L23;
            return r0;
        L18:
            r10.L$0 = r4;
            r10.I$0 = r2;
            r10.label = 2;
            if (DelayKt.delay(1000, r10) != r0) goto L21;
            return r0;
        L23:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
            goto L23
        L10:
            ResultKt.throwOnFailure(r9);
            DoraSetting.a.getClass();
            r2 = 0;
            r4 = DoraSetting.e();
            r10 = this;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$replaceBind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$replaceBind$1", f = "DoraDeviceViewModel.kt", i = {}, l = {461, 467}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01871(DoraDevice r1, DoraDeviceViewModel r2, Continuation<? super C01871> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01871(this.$device, this.this$0, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r11);
        L28:
            Object r12 = r2;
        L30:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L34;
            g49.d.c(DoraDeviceViewModel.TAG, "replaceBind: failure", r13);
            t19.s r14 = t19.s.a;
            Application r3 = AppHost.a.getApplication();
            r14.getClass();
            t19.s.b(r3, 2131908080, false);
        L34:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
            r12 = ((Result) r11).unbox-impl();
        L13:
            DoraDeviceViewModel r4 = this.this$0;
            DoraDevice r6 = this.$device;
            if (Result.isSuccess-impl(r12) == false) goto L30;
            int r7 = ((Number) r12).intValue();
            g49.d.d(DoraDeviceViewModel.TAG, "replaceBind: replaceBindCode=" + r7);
            Object r5 = DoraDeviceViewModel.access$get_deviceStateFlow$p(r4).getValue();
            DoraDevice r9 = null;
            if ((r5 instanceof com.larus.dora.impl.device.c.a) == false) goto L18;
            com.larus.dora.impl.device.c.a r8 = (com.larus.dora.impl.device.c.a) r5;
        L19:
            if (r8 == null) goto L22;
            r9 = r8.b;
        L22:
            if (Intrinsics.areEqual(r9, r6) == false) goto L30;
            if (r7 != 1) goto L29;
            kj4.a r10 = kj4.a.g();
            this.L$0 = r12;
            this.label = 2;
            if (DoraAdapterExtKt.b(r10) != r0) goto L27;
            return r0;
        L27:
            r2 = r12;
            goto L28
        L29:
            t19.s r15 = t19.s.a;
            Application r16 = AppHost.a.getApplication();
            r15.getClass();
            t19.s.b(r16, 2131904024, false);
            Unit r17 = Unit.INSTANCE;
            goto L30
        L18:
            r8 = null;
            goto L19
        L10:
            ResultKt.throwOnFailure(r11);
            DoraNetworkApi r18 = DoraNetworkApi.a;
            DoraDevice r20 = this.$device;
            this.label = 1;
            r12 = r18.w(r20, this);
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$scanForDora$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel", f = "DoraDeviceViewModel.kt", i = {}, l = {405}, m = "scanForDora", n = {}, s = {})
    public static final class C01881 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01881(DoraDeviceViewModel r1, Continuation<? super C01881> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraDeviceViewModel.access$scanForDora(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$scanForDora$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$scanForDora$3", f = "DoraDeviceViewModel.kt", i = {}, l = {384, 400, 403}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<DoraDevice> $firstScannedDoraDevice;
        final /* synthetic */ Ref.BooleanRef $scanNoLimit;
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public AnonymousClass3(Ref.ObjectRef<DoraDevice> r1, Ref.BooleanRef r2, DoraDeviceViewModel r3, Continuation<? super AnonymousClass3> r4) {
            this.$firstScannedDoraDevice = r1;
            this.$scanNoLimit = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass3(this.$firstScannedDoraDevice, this.$scanNoLimit, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r9);
        L33:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r9);
        L29:
            g49.d.d(DoraDeviceViewModel.TAG, "scanTimeoutJob: scanning 12000s");
            MutableSharedFlow r10 = DoraDeviceViewModel.access$get_deviceIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.a.c r2 = com.larus.dora.impl.device.a.c.a;
            this.label = 3;
            if (r10.emit(r2, this) != r0) goto L33;
            return r0;
        L11:
            ResultKt.throwOnFailure(r9);
        L15:
            StringBuilder r11 = new StringBuilder("scanTimeoutJob: scanning 3000s, has ");
            DoraDevice r3 = (DoraDevice) this.$firstScannedDoraDevice.element;
            if (r3 == null) goto L18;
            String r4 = o59.a.h(r3);
        L19:
            r11.append(r4);
            g49.d.d(DoraDeviceViewModel.TAG, r11.toString());
            DoraDevice r12 = (DoraDevice) this.$firstScannedDoraDevice.element;
            if (r12 == null) goto L26;
            DoraDeviceViewModel r5 = this.this$0;
            if (DoraDeviceViewModel.access$getDoraScanCallback$p(r5) == null) goto L24;
            g49.d.d(DoraDeviceViewModel.TAG, "scanTimeoutJob: stopScan#" + DoraDeviceViewModel.access$getDoraScanCallback$p(r5));
            kj4.a.g().stopScan(DoraDeviceViewModel.access$getDoraScanCallback$p(r5));
            DoraDeviceViewModel.access$setDoraScanCallback$p(r5, null);
        L24:
            g49.d.d(DoraDeviceViewModel.TAG, "scanTimeoutJob: launchOnboarding " + o59.a.h(r12));
            DoraDeviceViewModel.launchOnboarding$default(r5, r12, false, 2, null);
            return Unit.INSTANCE;
        L26:
            this.$scanNoLimit.element = true;
            this.label = 2;
            if (DelayKt.delay(DoraDeviceViewModel.SCAN_FOR_A_LONG_TIME, this) != r0) goto L29;
            return r0;
        L18:
            r4 = null;
            goto L19
        L12:
            ResultKt.throwOnFailure(r9);
            this.label = 1;
            if (DelayKt.delay(DoraDeviceViewModel.SCAN_NO_LIMIT_TIME, this) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$startConnectOrScan$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$startConnectOrScan$1", f = "DoraDeviceViewModel.kt", i = {0}, l = {290, 307, 313}, m = "invokeSuspend", n = {"currentConnectedDora"}, s = {"L$0"})
    public static final class C01891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $from;
        Object L$0;
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01891(String r1, DoraDeviceViewModel r2, Continuation<? super C01891> r3) {
            this.$from = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01891(this.$from, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r110) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            ResultKt.throwOnFailure(r110);
        L37:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r110);
        L32:
            return Unit.INSTANCE;
        L11:
            DoraDevice r3 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r110);
        L18:
            this.this$0.checkBindState(r3);
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r110);
            g49.d.d(DoraDeviceViewModel.TAG, "startConnectOrScan: start, from " + this.$from);
            DoraDevice r4 = DoraDeviceViewModel.access$getCurrentConnectedDoraOrNull(this.this$0);
            if (r4 == null) goto L20;
            g49.d.d(DoraDeviceViewModel.TAG, "startConnectOrScan: hasConnected " + o59.a.h(r4));
            z0 r5 = DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0);
            long r9 = DoraDeviceViewModel.access$getDeviceStateSeq$p(this.this$0);
            DoraDeviceViewModel.access$setDeviceStateSeq$p(this.this$0, 1 + r9);
            com.larus.dora.impl.device.c.a r6 = new com.larus.dora.impl.device.c.a(r9, r4);
            this.L$0 = r4;
            this.label = 1;
            if (r5.emit(r6, this) != r1) goto L17;
            return r1;
        L17:
            r3 = r4;
            goto L18
        L20:
            Set<String> r7 = com.larus.dora.impl.core.j.a(AppHost.a.getApplication());
            Set<String> r8 = r7;
            ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r11 = r8.iterator();
        L22:
            if (r11.hasNext() == false) goto L24;
            r10.add(com.larus.dora.impl.util.h.a((String) r11.next()));
            goto L22
        L24:
            g49.d.d(DoraDeviceViewModel.TAG, "startConnectOrScan: btConnectedDevices=" + CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null));
            if (DoraDeviceViewModel.access$connectBtConnectedDora(this.this$0, r7) == false) goto L33;
            DoraDevice r12 = DoraDeviceViewModel.access$getCurrentConnectedDoraOrNull(this.this$0);
            if (r12 == null) goto L33;
            g49.d.d(DoraDeviceViewModel.TAG, "startConnectOrScan: connectedSuccess " + o59.a.h(r12));
            z0 r13 = DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0);
            long r14 = DoraDeviceViewModel.access$getDeviceStateSeq$p(this.this$0);
            DoraDeviceViewModel.access$setDeviceStateSeq$p(this.this$0, 1 + r14);
            com.larus.dora.impl.device.c.a r15 = new com.larus.dora.impl.device.c.a(r14, r12);
            this.label = 2;
            if (r13.emit(r15, this) != r1) goto L32;
            return r1;
        L33:
            DoraDeviceViewModel r16 = this.this$0;
            this.label = 3;
            if (DoraDeviceViewModel.access$scanForDora(r16, r7, this) != r1) goto L37;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$startDisconnectedRetry$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$startDisconnectedRetry$1", f = "DoraDeviceViewModel.kt", i = {}, l = {515, 520}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDeviceViewModel this$0;

        public C01901(DoraDeviceViewModel r1, Continuation<? super C01901> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01901(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L15:
            com.larus.dora.impl.device.c r7 = (com.larus.dora.impl.device.c) this.this$0.getDeviceStateFlow().getValue();
            if ((r7 instanceof com.larus.dora.impl.device.c.b) == false) goto L21;
            DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0).setValue(com.larus.dora.impl.device.c.b.a((com.larus.dora.impl.device.c.b) r7, false));
            MutableSharedFlow r8 = DoraDeviceViewModel.access$get_deviceIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.a.d r2 = com.larus.dora.impl.device.a.d.a;
            this.label = 2;
            if (r8.emit(r2, this) != r0) goto L21;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            g49.d.d(DoraDeviceViewModel.TAG, "startDisconnectedRetry");
            com.larus.dora.impl.device.c r9 = (com.larus.dora.impl.device.c) DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r9 instanceof com.larus.dora.impl.device.c.b) == false) goto L21;
            DoraDeviceViewModel.access$get_deviceStateFlow$p(this.this$0).setValue(com.larus.dora.impl.device.c.b.a((com.larus.dora.impl.device.c.b) r9, true));
            this.this$0.startConnectOrScan("startDisconnectedRetry");
            this.label = 1;
            if (DelayKt.delay(15000, this) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.DoraDeviceViewModel$syncUserSettings$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.DoraDeviceViewModel$syncUserSettings$1", f = "DoraDeviceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C01911(Continuation<? super C01911> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01911(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (kj4.a.g().hasDoraDevice() == false) goto L8;
            DoraUserSettingsManager.j(DoraUserSettingsManager.a, "DoraDeviceFragmentCreated");
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ CharSequence yo(DoraDevice r0) {
        return connectBtConnectedDora$lambda$0(r0);
    }

    private final DoraSimpleDevice getLastConnectDevice() {
        com.larus.dora.impl.util.b0.a.getClass();
        return com.larus.dora.impl.util.b0.l();
    }

    public final void disconnectSpp() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C01831(this, null), 2, null);
    }

    public final void startDisconnectedRetry() {
        Job r0 = this.disconnectedRetryJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.disconnectedRetryJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01901(this, null), 3, null);
    }

    public DoraDeviceViewModel() {
        StateFlowImpl r0 = j1.a(com.larus.dora.impl.device.c.C0034c.a);
        this._deviceStateFlow = r0;
        this.deviceStateFlow = r0;
        MutableSharedFlow<com.larus.dora.impl.device.a> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceIntentSharedFlow = r3;
        this.deviceIntentSharedFlow = r3;
        MutableSharedFlow<com.larus.dora.impl.network.a> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._sodaBannerSharedFlow = r2;
        this.sodaBannerSharedFlow = r2;
        StateFlowImpl r4 = j1.a(com.larus.dora.impl.device.b.a.a);
        this._deviceFeatureStateFlow = r4;
        this.deviceFeatureStateFlow = r4;
        this.loadDispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory(TAG)));
        this.hasLaunchOnBoarding = new AtomicBoolean(false);
        int r5 = com.larus.utils.j0.a;
        this.bots = MapsKt.mapOf(new Pair[]{TuplesKt.to("7234781073513644036", com.larus.utils.j0.d(2131902196)), TuplesKt.to("7387318857767075855", com.larus.utils.j0.d(2131902199)), TuplesKt.to("7385474971206008832", com.larus.utils.j0.d(2131902198)), TuplesKt.to("7385382352102621219", com.larus.utils.j0.d(2131902197))});
        IDoraLinkCallback r1 = new DoraDeviceViewModel$doraLinkCallback$1(this);
        this.doraLinkCallback = r1;
        mj4.h r6 = new DoraDeviceViewModel$doraBudsCallback$1(this);
        this.doraBudsCallback = r6;
        this.isScreenOn = true;
        c r7 = new c(this);
        this.screenListener = r7;
        g49.d.d("DoraDeviceFragment", this + " init");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        kj4.a.g().registerDoraLinkCallback(r1);
        kj4.a.g().k(r6);
        ScreenStateManager r8 = ScreenStateManager.a;
        ScreenStateManager.a(r7);
    }

    private final DoraDevice getCurrentConnectedDoraOrNull() {
        DoraDevice r0 = DoraAdapterExtKt.h(kj4.a.g());
        if (r0 != null) goto L5;
        return null;
    L5:
        if (kj4.a.g().getDoraLinkState(r0) != 2) goto L9;
        return r0;
    L9:
        return null;
    }

    private final void loadDeviceFeature() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01861(this, null), 2, null);
    }

    public final void load() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.loadDispatcher, null, new C01851(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        g49.d.d(TAG, this + " onCleared");
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
        kj4.a.g().E(this.doraBudsCallback);
        ScreenStateManager.a.b(this.screenListener);
    }

    public final void syncUserSettings() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01911(null), 2, null);
    }

    public final Map<String, String> getBots() {
        return this.bots;
    }

    public final i1<com.larus.dora.impl.device.b> getDeviceFeatureStateFlow() {
        return this.deviceFeatureStateFlow;
    }

    public final d1<com.larus.dora.impl.device.a> getDeviceIntentSharedFlow() {
        return this.deviceIntentSharedFlow;
    }

    public final i1<com.larus.dora.impl.device.c> getDeviceStateFlow() {
        return this.deviceStateFlow;
    }

    public final d1<com.larus.dora.impl.network.a> getSodaBannerSharedFlow() {
        return this.sodaBannerSharedFlow;
    }

    public final boolean isSwitchingDevice() {
        return this.isSwitchingDevice;
    }

    public static final /* synthetic */ DoraDevice access$getCurrentConnectedDoraOrNull(DoraDeviceViewModel r0) {
        return r0.getCurrentConnectedDoraOrNull();
    }

    public static final /* synthetic */ long access$getDeviceStateSeq$p(DoraDeviceViewModel r2) {
        return r2.deviceStateSeq;
    }

    public static final /* synthetic */ ScanCallback access$getDoraScanCallback$p(DoraDeviceViewModel r0) {
        return r0.doraScanCallback;
    }

    public static final /* synthetic */ AtomicBoolean access$getHasLaunchOnBoarding$p(DoraDeviceViewModel r0) {
        return r0.hasLaunchOnBoarding;
    }

    public static final /* synthetic */ DoraSimpleDevice access$getLastConnectDevice(DoraDeviceViewModel r0) {
        return r0.getLastConnectDevice();
    }

    public static final /* synthetic */ Job access$getScanTimeoutJob$p(DoraDeviceViewModel r0) {
        return r0.scanTimeoutJob;
    }

    public static final /* synthetic */ z0 access$get_deviceFeatureStateFlow$p(DoraDeviceViewModel r0) {
        return r0._deviceFeatureStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_deviceIntentSharedFlow$p(DoraDeviceViewModel r0) {
        return r0._deviceIntentSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_deviceStateFlow$p(DoraDeviceViewModel r0) {
        return r0._deviceStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_sodaBannerSharedFlow$p(DoraDeviceViewModel r0) {
        return r0._sodaBannerSharedFlow;
    }

    public static final /* synthetic */ boolean access$isScreenOn$p(DoraDeviceViewModel r0) {
        return r0.isScreenOn;
    }

    public static final /* synthetic */ void access$loadDeviceFeature(DoraDeviceViewModel r0) {
        r0.loadDeviceFeature();
    }

    private final boolean connectBtConnectedDora(Set<String> r13) {
        boolean r1 = false;
        if (r13.isEmpty() == false) goto L6;
        g49.d.e(TAG, "connectBtConnectedDora: btConnectedDevices is empty");
        return false;
    L6:
        List r0 = DoraAdapterExtKt.j(kj4.a.g());
        if (r0 != null) goto L9;
        r0 = CollectionsKt.emptyList();
    L9:
        List r2 = CollectionsKt.filterNotNull(r0);
        if (r2.isEmpty() == false) goto L13;
        g49.d.e(TAG, "connectBtConnectedDora: historyDoraList is empty");
        return false;
    L13:
        List r3 = r2;
        g49.d.d(TAG, "connectBtConnectedDora: historyDoraList=" + CollectionsKt.joinToString$default(r3, ",", null, null, 0, null, new v0(), 30, null));
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        Object r6 = r5.next();
        if (r13.contains(((DoraDevice) r6).mac) == false) goto L15;
        r4.add(r6);
        goto L15
    L20:
        if ((!r4.isEmpty()) == false) goto L26;
        Iterator r14 = r4.iterator();
    L23:
        if (r14.hasNext() == false) goto L26;
        DoraDevice r7 = (DoraDevice) r14.next();
        g49.d.d(TAG, "connectBtConnectedDora: connect " + r7.sn + " start");
        r1 = com.larus.dora.impl.core.t.a(r7);
        g49.d.d(TAG, "connectBtConnectedDora: connect " + r7.sn + ", result=" + r1);
        if (r1 == false) goto L23;
    L26:
        return r1;
    }

    private static final CharSequence connectBtConnectedDora$lambda$0(DoraDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return "{name=" + r2.name + ", sn=" + r2.sn + ", " + com.larus.dora.impl.util.h.a(r2.mac) + ", mode=" + r2.mode + '}';
    }

    private final void stopDisconnectedRetry(boolean r3) {
        if (r3 == false) goto L6;
        com.larus.dora.impl.device.c r4 = (com.larus.dora.impl.device.c) this._deviceStateFlow.getValue();
        if ((r4 instanceof com.larus.dora.impl.device.c.b) == false) goto L6;
        this._deviceStateFlow.setValue(com.larus.dora.impl.device.c.b.a((com.larus.dora.impl.device.c.b) r4, false));
    L6:
        Job r5 = this.disconnectedRetryJob;
        if (r5 == null) goto L9;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L9:
        this.disconnectedRetryJob = null;
    }

    public final void autoConnect(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "autoConnectDevice");
        this.connectOrScanJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.loadDispatcher, null, new C01801(this, r8, null), 2, null);
    }

    public final void checkBindState(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01811(this, r8, null), 2, null);
    }

    public final void checkSodaBanner(List<com.larus.dora.impl.network.a> r11) {
        List<com.larus.dora.impl.network.a> r0 = r11;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01821(this, null), 3, null);
        return;
    L13:
        Iterator<com.larus.dora.impl.network.a> r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L21;
        com.larus.dora.impl.network.a r2 = r12.next();
        if (r2 == null) goto L15;
        if (r2.getType() != 1) goto L15;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, r2, null), 3, null);
        goto L15
    L21:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public final void replaceBind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C01871(r8, this, null), 2, null);
    }

    public final void reportBotSwitch(String r5) {
        Intrinsics.checkNotNullParameter(r5, "botName");
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dm_bot_switch", MapsKt.mapOf(TuplesKt.to("bot_name", r5)), false, 12);
    }

    public final void setSwitchingDevice(boolean r1) {
        this.isSwitchingDevice = r1;
    }

    public final void startConnectOrScan(String r8) {
        Intrinsics.checkNotNullParameter(r8, "from");
        this.connectOrScanJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.loadDispatcher, null, new C01891(r8, this, null), 2, null);
    }

    public final void stopConnectAndScan(String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        g49.d.d(TAG, r5 + "->stopConnectAndScan");
        Job r0 = this.scanTimeoutJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.connectOrScanJob;
        if (r1 == null) goto L9;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L9:
        if (this.doraScanCallback == null) goto L12;
        g49.d.d(TAG, r5 + "->stopConnectAndScan: stopScan#" + this.doraScanCallback);
        kj4.a.g().stopScan(this.doraScanCallback);
        this.doraScanCallback = null;
        return;
    }

    public static final /* synthetic */ boolean access$connectBtConnectedDora(DoraDeviceViewModel r0, Set r1) {
        return r0.connectBtConnectedDora(r1);
    }

    public static final /* synthetic */ void access$setDeviceStateSeq$p(DoraDeviceViewModel r0, long r1) {
        r0.deviceStateSeq = r1;
    }

    public static final /* synthetic */ void access$setDoraScanCallback$p(DoraDeviceViewModel r0, ScanCallback r1) {
        r0.doraScanCallback = r1;
    }

    public static final /* synthetic */ void access$setScreenOn$p(DoraDeviceViewModel r0, boolean r1) {
        r0.isScreenOn = r1;
    }

    public static final /* synthetic */ void access$stopDisconnectedRetry(DoraDeviceViewModel r0, boolean r1) {
        r0.stopDisconnectedRetry(r1);
    }

    private final Object scanForDora(Set<String> r22, Continuation<? super Unit> r23) {
        if ((r23 instanceof C01881) == false) goto L7;
        C01881 r1 = (C01881) r23;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        C01881 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L25:
        g49.d.d(TAG, "scanForDora: method end");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        g49.d.d(TAG, "scanForDora: start");
        boolean r4 = !r22.isEmpty();
        this.hasLaunchOnBoarding.set(false);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        Ref.LongRef r5 = new Ref.LongRef();
        r5.element = SystemClock.elapsedRealtime();
        Job r6 = this.scanTimeoutJob;
        if (r6 == null) goto L18;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L18:
        if (this.doraScanCallback == null) goto L20;
        g49.d.d(TAG, "scanForDora: stopScan#" + this.doraScanCallback);
        kj4.a.g().stopScan(this.doraScanCallback);
    L20:
        this.doraScanCallback = new b(r4, r13, r5, r22, r12, this);
        g49.d.d(TAG, "scanForDora: startScan#" + this.doraScanCallback);
        kj4.a.g().scan(CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"}), this.doraScanCallback);
        Job r7 = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.loadDispatcher, null, new AnonymousClass3(r12, r13, this, null), 2, null);
        this.scanTimeoutJob = r7;
        if (r7 == null) goto L25;
        r8.label = 1;
        if (r7.join(r8) != r9) goto L25;
        return r9;
    L7:
        r1 = new C01881(this, r23);
        goto L8
    }

    public final void launchOnboarding(DoraDevice r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01841(this, r8, r9, null), 3, null);
    }

    public static final /* synthetic */ Object access$scanForDora(DoraDeviceViewModel r0, Set r1, Continuation r2) {
        return r0.scanForDora(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkSodaBanner$default(DoraDeviceViewModel r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.checkSodaBanner(r1);
    }

    public static /* synthetic */ void launchOnboarding$default(DoraDeviceViewModel r0, DoraDevice r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.launchOnboarding(r1, r2);
    }
}
