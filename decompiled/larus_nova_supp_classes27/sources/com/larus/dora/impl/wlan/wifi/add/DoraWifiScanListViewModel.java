package com.larus.dora.impl.wlan.wifi.add;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.reflect.TypeToken;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.l0;
import com.larus.dora.impl.core.request.v2.DoraRequestXV2;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import com.larus.dora.impl.wlan.wifi.DoraWifiList;
import com.larus.dora.impl.wlan.wifi.DoraWifiResponse;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiScanListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiAddState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_connectWifiSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiConnectEvent;", "connectWifiSharedFlow", "getConnectWifiSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "scanWifi", "", "connectWifi", "wifiEntity", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "pwd", "", "doConnectWifi", "(Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectWifi", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiScanListViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DoraWifiAddViewModel";
    private final MutableSharedFlow<h> _connectWifiSharedFlow;
    private final z0<g> _stateFlow;
    private final MutableSharedFlow<h> connectWifiSharedFlow;
    private final i1<g> stateFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ vk4.f a;
        public final /* synthetic */ c b;

        public b(vk4.f r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r2) {
            Throwable r3 = (Throwable) r2;
            vk4.f r4 = this.a;
            c r0 = this.b;
            ((CopyOnWriteArraySet) r4.b).remove(r0);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements vk4.j {
        public final /* synthetic */ vk4.f a;
        public final /* synthetic */ kotlinx.coroutines.i<h> b;

        public c(vk4.f r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(int r1, String r2, String r3, int r4, int r5, int r6, String r7, long r8, String r10) {
            g49.d.d(DoraWifiScanListViewModel.TAG, "connectWifi: onWlanStateChanged, status=" + r4);
            if (r4 != 1) goto L5;
            ((CopyOnWriteArraySet) this.a.b).remove(this);
            this.b.resumeWith(Result.constructor-impl(new h.a(r6)));
            return;
        L5:
            if (r4 != 3) goto L11;
            ((CopyOnWriteArraySet) this.a.b).remove(this);
            kotlinx.coroutines.i<h> r9 = this.b;
            Result.Companion r11 = Result.Companion;
            r9.resumeWith(Result.constructor-impl(h.b.a));
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListViewModel$connectWifi$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListViewModel$connectWifi$1", f = "DoraWifiScanListViewModel.kt", i = {2}, l = {69, 70, 72, 76}, m = "invokeSuspend", n = {"event"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pwd;
        final /* synthetic */ DoraWifiEntity $wifiEntity;
        Object L$0;
        int label;
        final /* synthetic */ DoraWifiScanListViewModel this$0;

        public AnonymousClass1(DoraWifiEntity r1, DoraWifiScanListViewModel r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$wifiEntity = r1;
            this.this$0 = r2;
            this.$pwd = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$wifiEntity, this.this$0, this.$pwd, r5);
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
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r9);
        L31:
            DoraWifiScanListViewModel.access$disconnectWifi(this.this$0);
        L33:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            h r2 = (h) this.L$0;
            ResultKt.throwOnFailure(r9);
        L27:
            if ((r2 instanceof h.b) == false) goto L33;
            l0.d.set(true);
            kj4.a r10 = kj4.a.g();
            this.L$0 = null;
            this.label = 4;
            if (DoraAdapterExtKt.F(r10, true) != r0) goto L31;
            return r0;
        L12:
            ResultKt.throwOnFailure(r9);
        L20:
            h r11 = (h) r9;
            if (r11 != null) goto L23;
            r11 = new h.a(0);
        L23:
            r2 = r11;
            g49.d.d(DoraWifiScanListViewModel.TAG, "connectWifi: result = " + r2);
            MutableSharedFlow r12 = DoraWifiScanListViewModel.access$get_connectWifiSharedFlow$p(this.this$0);
            this.L$0 = r2;
            this.label = 3;
            if (r12.emit(r2, this) != r0) goto L27;
            return r0;
        L13:
            ResultKt.throwOnFailure(r9);
        L17:
            DoraWifiScanListViewModel r13 = this.this$0;
            DoraWifiEntity r3 = this.$wifiEntity;
            String r7 = this.$pwd;
            this.label = 2;
            r9 = DoraWifiScanListViewModel.access$doConnectWifi(r13, r3, r7, this);
            if (r9 != r0) goto L20;
            return r0;
        L14:
            ResultKt.throwOnFailure(r9);
            g49.d.d(DoraWifiScanListViewModel.TAG, "connectWifi: " + this.$wifiEntity);
            MutableSharedFlow r14 = DoraWifiScanListViewModel.access$get_connectWifiSharedFlow$p(this.this$0);
            h.c r4 = h.c.a;
            this.label = 1;
            if (r14.emit(r4, this) != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListViewModel$disconnectWifi$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListViewModel$disconnectWifi$1", f = "DoraWifiScanListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C04411(Continuation<? super C04411> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C04411(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            ak4.a r4 = vk4.f.c;
            g49.d.d(DoraWifiScanListViewModel.TAG, "disconnectWifi: ret=" + vk4.f.a.a.b(1, "", ""));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListViewModel$scanWifi$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListViewModel$scanWifi$1", f = "DoraWifiScanListViewModel.kt", i = {0}, l = {153}, m = "invokeSuspend", n = {"convertor$iv"}, s = {"L$0"})
    public static final class C04421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraWifiScanListViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.wlan.wifi.add.DoraWifiScanListViewModel$scanWifi$1$a */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends TypeToken<DoraWifiResponse<DoraWifiList>> {
            public a() {
            }
        }

        public C04421(DoraWifiScanListViewModel r1, Continuation<? super C04421> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04421(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w39.a r2 = (w39.a) this.L$0;
            ResultKt.throwOnFailure(r12);
        L12:
            com.larus.dora.impl.core.request.v2.a r13 = (com.larus.dora.impl.core.request.v2.a) r12;
            if ((r13 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L62;
            g49.d.b("DoraRequestXV2", "request<T>: failed, " + r13);
            Result.Companion r4 = Result.Companion;
            Object r14 = Result.constructor-impl(ResultKt.createFailure(new Exception("Request failed: " + r13)));
        L22:
            DoraWifiScanListViewModel r5 = this.this$0;
            if (Result.isSuccess-impl(r14) == false) goto L56;
            DoraWifiResponse r6 = (DoraWifiResponse) r14;
            if (r6.getStatus() != 0) goto L55;
            g49.d.d(DoraWifiScanListViewModel.TAG, "scanWifi: success, " + r6);
            DoraWifiList r7 = (DoraWifiList) r6.getData();
            if (r7 == null) goto L46;
            List<DoraWifiEntity> r8 = r7.getWifiList();
            if (r8 == null) goto L46;
            ArrayList r9 = new ArrayList();
            Iterator<T> r10 = r8.iterator();
        L32:
            if (r10.hasNext() == false) goto L47;
            Object r11 = r10.next();
            DoraWifiEntity r15 = (DoraWifiEntity) r11;
            if (r15 != null) goto L36;
        L38:
            boolean r16 = false;
        L39:
            if (r16 == true) goto L41;
        L43:
            boolean r17 = false;
        L44:
            if (r17 == false) goto L32;
            r9.add(r11);
            goto L32
        L41:
            if (r15.a() < 5000) goto L43;
            r17 = true;
            goto L44
        L36:
            if (r15.b() != 2) goto L38;
            r16 = true;
        L47:
            if (r9 != null) goto L49;
        L52:
            if (r3 == false) goto L54;
            DoraWifiScanListViewModel.access$get_stateFlow$p(r5).setValue(g.b.a);
            goto L56
        L54:
            DoraWifiScanListViewModel.access$get_stateFlow$p(r5).setValue(new g.c(CollectionsKt.filterNotNull(r9)));
            goto L56
        L49:
            if (r9.isEmpty() == true) goto L52;
            r3 = false;
        L46:
            r9 = null;
            goto L47
        L55:
            g49.d.b(DoraWifiScanListViewModel.TAG, "scanWifi: failed, " + r6);
            DoraWifiScanListViewModel.access$get_stateFlow$p(r5).setValue(g.b.a);
        L56:
            DoraWifiScanListViewModel r18 = this.this$0;
            Throwable r110 = Result.exceptionOrNull-impl(r14);
            if (r110 == null) goto L60;
            g49.d.b(DoraWifiScanListViewModel.TAG, "scanWifi: failed, " + r110);
            DoraWifiScanListViewModel.access$get_stateFlow$p(r18).setValue(g.b.a);
        L60:
            return Unit.INSTANCE;
        L62:
            Type r20 = new a().getType();     // Catch: Throwable -> L19
            byte[] r111 = ((com.larus.dora.impl.core.request.v2.a.b) r13).a;     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L19
            Object r112 = r2.a(r111, r20);     // Catch: Throwable -> L19
            if (r112 != null) goto L17;
            g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L19
            Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L19
            r14 = Result.constructor-impl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L19
        L61:
            goto L22
        L17:
            r14 = Result.constructor-impl(r112);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            g49.d.c("DoraRequestXV2", "request<T>: parse error", th);
            Result.Companion r21 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            DoraWifiScanListViewModel.access$get_stateFlow$p(this.this$0).setValue(g.d.a);
            g49.d.d(DoraWifiScanListViewModel.TAG, "scanWifi: start");
            DoraRequestXV2 r114 = DoraRequestXV2.a;
            bl4.d r22 = new bl4.d();
            Lazy<w39.d> r23 = w39.d.b;
            w39.d r24 = w39.d.a.a();
            this.L$0 = r24;
            this.label = 1;
            r12 = r114.a(r22, j0.G2_OTA_DISCONNECT_WATCHDOG_MS, this);
            if (r12 != r0) goto L11;
            return r0;
        L11:
            r2 = r24;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    public DoraWifiScanListViewModel() {
        StateFlowImpl r0 = j1.a(g.a.a);
        this._stateFlow = r0;
        this.stateFlow = r0;
        MutableSharedFlow<h> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._connectWifiSharedFlow = r1;
        this.connectWifiSharedFlow = r1;
        scanWifi();
    }

    private final void disconnectWifi() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04411(null), 2, null);
    }

    public final void scanWifi() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04421(this, null), 2, null);
    }

    public final MutableSharedFlow<h> getConnectWifiSharedFlow() {
        return this.connectWifiSharedFlow;
    }

    public final i1<g> getStateFlow() {
        return this.stateFlow;
    }

    public static final /* synthetic */ void access$disconnectWifi(DoraWifiScanListViewModel r0) {
        r0.disconnectWifi();
    }

    public static final /* synthetic */ MutableSharedFlow access$get_connectWifiSharedFlow$p(DoraWifiScanListViewModel r0) {
        return r0._connectWifiSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_stateFlow$p(DoraWifiScanListViewModel r0) {
        return r0._stateFlow;
    }

    public final void connectWifi(DoraWifiEntity r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "wifiEntity");
        Intrinsics.checkNotNullParameter(r9, "pwd");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r8, this, r9, null), 2, null);
    }

    private final Object doConnectWifi(DoraWifiEntity r3, String r4, Continuation<? super h> r5) {
        return TimeoutKt.c(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, new DoraWifiScanListViewModel$doConnectWifi$$inlined$suspendCoroutineWithTimeoutOrNull$1(null, r3, r4), r5);
    }

    public static final /* synthetic */ Object access$doConnectWifi(DoraWifiScanListViewModel r0, DoraWifiEntity r1, String r2, Continuation r3) {
        return r0.doConnectWifi(r1, r2, r3);
    }
}
