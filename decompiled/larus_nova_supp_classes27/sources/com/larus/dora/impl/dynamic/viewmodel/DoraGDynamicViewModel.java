package com.larus.dora.impl.dynamic.viewmodel;

import android.app.Application;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyBindResult;
import com.larus.dora.impl.network.DoraNetworkApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewmodel/DoraGDynamicViewModel;", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "<init>", "()V", "handleConnectRequest", "", "mac", "", "checkBindState", "device", "Lcom/bytedance/dora/device/DoraDevice;", "scanBleInfo", "timeout", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGDynamicViewModel extends DoraDynamicViewModelV2 {

    public static final class a extends ScanCallback {
        public final /* synthetic */ CompletableDeferred<Unit> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> c;

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.d("DoraDynamicViewModelV2", "connect request, scan failed, err: " + r3);
            this.a.complete(Unit.INSTANCE);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r2, ScanResult r3) {
            DoraDevice r4 = kj4.a.g().convertScanResultToDoraDevice(r3);
            g49.d.d("DoraDynamicViewModelV2", "connect request, new scan result: " + r4);
            if (r4 == null) goto L5;
            String r5 = r4.mac;
        L7:
            if (Intrinsics.areEqual(r5, this.b) == false) goto L10;
            this.c.element = r4;
            kj4.a.g().stopScan(this);
            this.a.complete(Unit.INSTANCE);
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L7
        }

        public a(CompletableDeferred<Unit> r1, String r2, Ref.ObjectRef<DoraDevice> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$checkBindState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$checkBindState$1", f = "DoraGDynamicViewModel.kt", i = {2, 3, 4}, l = {118, 120, 126, 130, 132, 138}, m = "invokeSuspend", n = {"bindData", "bindData", "bindData"}, s = {"L$3", "L$2", "L$2"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ DoraGDynamicViewModel this$0;

        public AnonymousClass1(DoraGDynamicViewModel r1, DoraDevice r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r16);
        L54:
            return Unit.INSTANCE;
        L7:
            com.larus.dora.impl.network.b r0 = (com.larus.dora.impl.network.b) this.L$2;
            DoraGDynamicViewModel r1 = (DoraGDynamicViewModel) this.L$1;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r16);
        L46:
            com.larus.dora.impl.network.b r14 = r0;
            DoraGDynamicViewModel r12 = r1;
            Object r11 = r2;
        L47:
            r12.checkSodaBanner(r14.a());
        L48:
            DoraGDynamicViewModel r3 = this.this$0;
            Throwable r4 = Result.exceptionOrNull-impl(r11);
            if (r4 == null) goto L54;
            g49.d.c("DoraDynamicViewModelV2", "checkBindState: failure", r4);
            MutableSharedFlow<DoraDynamicViewModelV2.d> r5 = r3.get_deviceIntentSharedFlow();
            DoraDynamicViewModelV2.d.c r6 = new DoraDynamicViewModelV2.d.c(AppHost.a.getApplication().getString(2131908080));
            this.L$0 = r11;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 6;
            if (r5.emit(r6, this) != r8) goto L54;
            return r8;
        L8:
            com.larus.dora.impl.network.b r7 = (com.larus.dora.impl.network.b) this.L$3;
            DoraDevice r9 = (DoraDevice) this.L$2;
            DoraGDynamicViewModel r10 = (DoraGDynamicViewModel) this.L$1;
            Object r13 = this.L$0;
            ResultKt.throwOnFailure(r16);
            r14 = r7;
            Object r15 = r16;
        L34:
            DoraDevice r17 = (DoraDevice) r15;
            if (r17 == null) goto L37;
            r9.mode = r17.mode;
            r9.version = r17.version;
        L37:
            MutableSharedFlow<DoraDynamicViewModelV2.d> r18 = r10.get_deviceIntentSharedFlow();
            DoraDynamicViewModelV2.d.a r20 = new DoraDynamicViewModelV2.d.a(r9);
            this.L$0 = r13;
            this.L$1 = r10;
            this.L$2 = r14;
            this.L$3 = null;
            this.label = 4;
            if (r18.emit(r20, this) != r8) goto L40;
            return r8;
        L40:
            r1 = r10;
            r2 = r13;
        L41:
            r0 = r14;
            goto L46
        L9:
            ResultKt.throwOnFailure(r16);
            Object r21 = ((Result) r16).unbox-impl();
        L10:
            r11 = r21;
            r12 = this.this$0;
            DoraDevice r110 = this.$device;
            if (Result.isSuccess-impl(r11) == false) goto L48;
            r14 = (com.larus.dora.impl.network.b) r11;
            Integer r22 = r14.b();
            if (r22 == null) goto L25;
            int r23 = r22.intValue();
        L26:
            g49.d.d("DoraDynamicViewModelV2", "checkBindState: bindCode=" + r23);
            if (r23 == 1) goto L42;
            if (r23 != 2) goto L47;
            String r24 = r110.mac;
            this.L$0 = r11;
            this.L$1 = r12;
            this.L$2 = r110;
            this.L$3 = r14;
            this.label = 3;
            r15 = DoraGDynamicViewModel.scanBleInfo$default(r12, r24, 0, this, 2, null);
            if (r15 != r8) goto L33;
            return r8;
        L33:
            r13 = r11;
            r10 = r12;
            r9 = r110;
            goto L34
        L42:
            kj4.a r25 = kj4.a.g();
            this.L$0 = r11;
            this.L$1 = r12;
            this.L$2 = r14;
            this.label = 5;
            if (DoraAdapterExtKt.b(r25) != r8) goto L45;
            return r8;
        L45:
            r2 = r11;
            r1 = r12;
            goto L41
        L25:
            r23 = 0;
            goto L26
        L11:
            ResultKt.throwOnFailure(r16);
        L17:
            DoraNetworkApi r26 = DoraNetworkApi.a;
            DoraDevice r27 = this.$device;
            this.label = 2;
            r21 = r26.e(r27, true, this);
            if (r21 != r8) goto L10;
            return r8;
        L12:
            ResultKt.throwOnFailure(r16);
            if (this.this$0.isScreenOn() == true) goto L17;
            this.label = 1;
            if (DelayKt.delay(500, this) != r8) goto L17;
            return r8;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$handleConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$handleConnectRequest$1", f = "DoraGDynamicViewModel.kt", i = {1}, l = {39, 43, 68, 75}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class C03521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        Object L$0;
        int label;
        final /* synthetic */ DoraGDynamicViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$handleConnectRequest$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$handleConnectRequest$1$1", f = "DoraGDynamicViewModel.kt", i = {}, l = {76, 89, 98}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DoraDevice $device;
            int label;
            final /* synthetic */ DoraGDynamicViewModel this$0;

            public C00791(DoraGDynamicViewModel r1, DoraDevice r2, Continuation<? super C00791> r3) {
                this.this$0 = r1;
                this.$device = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00791(this.this$0, this.$device, r4);
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
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L11;
                if (r1 == 2) goto L10;
                if (r1 != 3) goto L9;
                ResultKt.throwOnFailure(r12);
            L33:
                return Unit.INSTANCE;
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                ResultKt.throwOnFailure(r12);
            L25:
                return Unit.INSTANCE;
            L11:
                ResultKt.throwOnFailure(r12);
            L15:
                DoraDevice r13 = (DoraDevice) r12;
                if (r13 != null) goto L19;
                g49.d.d("DoraDynamicViewModelV2", "connect request, scan new device info error");
                return Unit.INSTANCE;
            L19:
                DoraDevice r4 = this.$device;
                r4.mode = r13.mode;
                r4.version = r13.version;
                if (o59.a.v(r4) == true) goto L27;
                g49.d.d("DoraDynamicViewModelV2", "connect request, this device don't sup factory, connect spp ");
                DoraGDynamicViewModel r14 = this.this$0;
                DoraDevice r2 = this.$device;
                this.label = 2;
                if (r14.onlyConnect(r2, this) != r0) goto L25;
                return r0;
            L27:
                if (this.$device.isFactory() == false) goto L29;
                g49.d.d("DoraDynamicViewModelV2", "connect request, device is factory, replace bind it");
                this.this$0.replaceBind(this.$device);
                goto L33
            L29:
                MutableSharedFlow<DoraDynamicViewModelV2.d> r15 = this.this$0.get_deviceIntentSharedFlow();
                DoraDynamicViewModelV2.d.a r3 = new DoraDynamicViewModelV2.d.a(this.$device);
                this.label = 3;
                if (r15.emit(r3, this) != r0) goto L33;
                return r0;
            L12:
                ResultKt.throwOnFailure(r12);
                DoraGDynamicViewModel r16 = this.this$0;
                String r5 = this.$device.mac;
                this.label = 1;
                r12 = DoraGDynamicViewModel.scanBleInfo$default(r16, r5, 0, this, 2, null);
                if (r12 != r0) goto L15;
                return r0;
            }
        }

        public C03521(DoraGDynamicViewModel r1, String r2, Continuation<? super C03521> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03521(this.this$0, this.$mac, r4);
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
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            if (r1 != 4) goto L11;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L48
        L50:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L48
        L42:
            return Unit.INSTANCE;
        L14:
            DoraDevice r2 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L48
        L27:
            OnlyBindResult r11 = (OnlyBindResult) r10;     // Catch: Throwable -> L48
            if (CollectionsKt.listOf(new OnlyBindResult[]{OnlyBindResult.SERVER_BIND_NETWORK_ERROR, OnlyBindResult.SERVER_BIND_UNKNOWN}).contains(r11) == false) goto L32;
            s r12 = s.a;     // Catch: Throwable -> L48
            Application r3 = AppHost.a.getApplication();     // Catch: Throwable -> L48
            r12.getClass();     // Catch: Throwable -> L48
            s.b(r3, 2131908080, false);     // Catch: Throwable -> L48
            this.this$0.updateUi(new DoraDynamicViewModelV2.g.c(r2));     // Catch: Throwable -> L48
            return Unit.INSTANCE;
        L32:
            if (r11 != OnlyBindResult.SERVER_BIND_FAILED) goto L37;
            s r13 = s.a;     // Catch: Throwable -> L48
            AppHost.Companion r4 = AppHost.a;     // Catch: Throwable -> L48
            Application r5 = r4.getApplication();     // Catch: Throwable -> L48
            String r6 = r4.getApplication().getString(2131903938, new Object[]{o59.a.g(r2)});     // Catch: Throwable -> L48
            r13.getClass();     // Catch: Throwable -> L48
            s.c(r5, r6);     // Catch: Throwable -> L48
            this.this$0.updateUi(new DoraDynamicViewModelV2.g.c(r2));     // Catch: Throwable -> L48
            return Unit.INSTANCE;
        L37:
            if (r11 != OnlyBindResult.SUCCESS) goto L43;
            g49.d.d("DoraDynamicViewModelV2", "connect request, bind success, connect spp");     // Catch: Throwable -> L48
            DoraGDynamicViewModel r14 = this.this$0;     // Catch: Throwable -> L48
            this.L$0 = null;     // Catch: Throwable -> L48
            this.label = 3;     // Catch: Throwable -> L48
            if (r14.onlyConnect(r2, this) != r0) goto L42;
            return r0;
        L43:
            g49.d.d("DoraDynamicViewModelV2", "cur device need unbind ");     // Catch: Throwable -> L48
            CoroutineDispatcher r15 = Dispatchers.getIO();     // Catch: Throwable -> L48
            C00791 r7 = new C00791(this.this$0, r2, null);     // Catch: Throwable -> L48
            this.L$0 = null;     // Catch: Throwable -> L48
            this.label = 4;     // Catch: Throwable -> L48
            if (BuildersKt.withContext(r15, r7, this) != r0) goto L50;
            return r0;
        L16:
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L48
        L22:
            r2 = (DoraDevice) r10;     // Catch: Throwable -> L48
            if (r2 == null) goto L47;
            CoroutineDispatcher r16 = Dispatchers.getIO();     // Catch: Throwable -> L48
            DoraGDynamicViewModel$handleConnectRequest$1$bindResult$1 r8 = new DoraGDynamicViewModel$handleConnectRequest$1$bindResult$1(r2, null);     // Catch: Throwable -> L48
            this.L$0 = r2;     // Catch: Throwable -> L48
            this.label = 2;     // Catch: Throwable -> L48
            r10 = BuildersKt.withContext(r16, r8, this);     // Catch: Throwable -> L48
            if (r10 != r0) goto L27;
            return r0;
        L47:
            throw new Throwable("device is null");     // Catch: Throwable -> L48
        L18:
            ResultKt.throwOnFailure(r10);
            this.this$0.get_connectionState().setValue(new e59.b.C0125b(this.$mac));
            CoroutineDispatcher r17 = Dispatchers.getIO();     // Catch: Throwable -> L48
            DoraGDynamicViewModel$handleConnectRequest$1$device$1 r9 = new DoraGDynamicViewModel$handleConnectRequest$1$device$1(this.$mac, null);     // Catch: Throwable -> L48
            this.label = 1;     // Catch: Throwable -> L48
            r10 = BuildersKt.withContext(r17, r9, this);     // Catch: Throwable -> L48
            if (r10 != r0) goto L22;
            return r0;
        L48:
            s r18 = s.a;
            Application r20 = AppHost.a.getApplication();
            r18.getClass();
            s.b(r20, 2131903672, false);
            this.this$0.get_connectionState().setValue(new e59.b.c(this.$mac));
            goto L50
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$scanBleInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel", f = "DoraGDynamicViewModel.kt", i = {0, 0, 0}, l = {174}, m = "scanBleInfo", n = {"newDevice", "scanCallback", "startScanTs"}, s = {"L$0", "L$1", "J$0"})
    public static final class C03531 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDynamicViewModel this$0;

        public C03531(DoraGDynamicViewModel r1, Continuation<? super C03531> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return DoraGDynamicViewModel.access$scanBleInfo(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$scanBleInfo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraGDynamicViewModel$scanBleInfo$2", f = "DoraGDynamicViewModel.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $done;
        int label;

        public AnonymousClass2(CompletableDeferred<Unit> r1, Continuation<? super AnonymousClass2> r2) {
            this.$done = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$done, r3);
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
            CompletableDeferred<Unit> r5 = this.$done;
            this.label = 1;
            if (r5.await(this) != r0) goto L12;
            return r0;
        }
    }

    public DoraGDynamicViewModel() {
    }

    @Override // com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2
    public void checkBindState(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r8, null), 2, null);
    }

    @Override // com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2
    public void handleConnectRequest(String r10) {
        Job r0 = getConnectingJob();
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        setConnectingJob(BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03521(this, r10, null), 3, null));
    }

    private final Object scanBleInfo(String r10, long r11, Continuation<? super DoraDevice> r13) {
        if ((r13 instanceof C03531) == false) goto L7;
        C03531 r0 = (C03531) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r12 = r0.J$0;
        a r15 = (a) r0.L$1;
        Ref.ObjectRef r4 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        g49.d.d("DoraDynamicViewModelV2", "scan ble info cost: " + (System.currentTimeMillis() - r12));
        kj4.a.g().stopScan(r15);
        return r4.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        long r5 = System.currentTimeMillis();
        CompletableDeferred r6 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        a r8 = new a(r6, r10, r7);
        kj4.a.g().scan(CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"}), r8);
        AnonymousClass2 r16 = new AnonymousClass2(r6, null);
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.J$0 = r5;
        r0.label = 1;
        if (TimeoutKt.c(r11, r16, r0) != r2) goto L17;
        return r2;
    L17:
        r12 = r5;
        r4 = r7;
        r15 = r8;
    L7:
        r0 = new C03531(this, r13);
        goto L8
    }

    public static final /* synthetic */ Object access$scanBleInfo(DoraGDynamicViewModel r0, String r1, long r2, Continuation r4) {
        return r0.scanBleInfo(r1, r2, r4);
    }

    public static /* synthetic */ Object scanBleInfo$default(DoraGDynamicViewModel r0, String r1, long r2, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = 10000;
    L6:
        return r0.scanBleInfo(r1, r2, r4);
    }
}
