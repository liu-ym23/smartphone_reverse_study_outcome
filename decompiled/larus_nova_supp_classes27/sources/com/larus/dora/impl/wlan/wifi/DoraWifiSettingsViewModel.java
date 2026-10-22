package com.larus.dora.impl.wlan.wifi;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.reflect.TypeToken;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.l0;
import com.larus.dora.impl.core.request.v2.DoraRequestXV2;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiSettingsState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_sharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiSettingsEvent;", "sharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadSavedWifiList", "", "deleteWifi", "entity", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "isLast", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DoraWifiSettingsViewModel";
    private final MutableSharedFlow<c> _sharedFlow;
    private final z0<k> _stateFlow;
    private final d1<c> sharedFlow;
    private final i1<k> stateFlow;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.wlan.wifi.DoraWifiSettingsViewModel$deleteWifi$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.wlan.wifi.DoraWifiSettingsViewModel$deleteWifi$1", f = "DoraWifiSettingsViewModel.kt", i = {0, 0}, l = {98, 65, 69, 73}, m = "invokeSuspend", n = {"ssid", "convertor$iv"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraWifiEntity $entity;
        final /* synthetic */ boolean $isLast;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DoraWifiSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.wlan.wifi.DoraWifiSettingsViewModel$deleteWifi$1$a */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends TypeToken<DoraWifiResponse<String>> {
            public a() {
            }
        }

        public AnonymousClass1(DoraWifiEntity r1, DoraWifiSettingsViewModel r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.$entity = r1;
            this.this$0 = r2;
            this.$isLast = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$entity, this.this$0, this.$isLast, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L13;
            if (r0 == 1) goto L12;
            if (r0 == 2) goto L11;
            if (r0 == 3) goto L11;
            if (r0 != 4) goto L10;
            ResultKt.throwOnFailure(r18);
        L55:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Object r1 = this.L$0;
            ResultKt.throwOnFailure(r18);
        L49:
            DoraWifiEntity r4 = this.$entity;
            DoraWifiSettingsViewModel r5 = this.this$0;
            Throwable r6 = Result.exceptionOrNull-impl(r1);
            if (r6 == null) goto L55;
            g49.d.b(DoraWifiSettingsViewModel.TAG, "deleteWifi: " + r4 + " failed, " + r6);
            MutableSharedFlow r3 = DoraWifiSettingsViewModel.access$get_sharedFlow$p(r5);
            c.a r7 = c.a.a;
            this.L$0 = r1;
            this.L$1 = null;
            this.label = 4;
            if (r3.emit(r7, this) != r2) goto L55;
            return r2;
        L12:
            w39.a r8 = (w39.a) this.L$1;
            String r11 = (String) this.L$0;
            ResultKt.throwOnFailure(r18);
            w39.a r13 = r8;
            Object r9 = r18;
        L19:
            com.larus.dora.impl.core.request.v2.a r10 = (com.larus.dora.impl.core.request.v2.a) r9;
            if ((r10 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L57;
            g49.d.b("DoraRequestXV2", "request<T>: failed, " + r10);
            Result.Companion r12 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(new Exception("Request failed: " + r10)));
        L29:
            DoraWifiSettingsViewModel r14 = this.this$0;
            DoraWifiEntity r15 = this.$entity;
            boolean r16 = this.$isLast;
            if (Result.isSuccess-impl(r1) == false) goto L49;
            DoraWifiResponse r17 = (DoraWifiResponse) r1;
            if (r17.getStatus() != 0) goto L46;
            k r20 = (k) DoraWifiSettingsViewModel.access$get_stateFlow$p(r14).getValue();
            boolean r110 = r20 instanceof k.b;
            g49.d.b(DoraWifiSettingsViewModel.TAG, "deleteWifi: " + r15 + " success, isPreviousSuccess=" + r110);
            if (r110 == false) goto L42;
            List<DoraWifiEntity> r21 = ((k.b) r20).a;
            ArrayList r22 = new ArrayList();
            Iterator<T> r23 = r21.iterator();
        L37:
            if (r23.hasNext() == false) goto L41;
            Object r111 = r23.next();
            if ((!Intrinsics.areEqual(((DoraWifiEntity) r111).c(), r11)) == false) goto L37;
            r22.add(r111);
            goto L37
        L41:
            z0 r24 = DoraWifiSettingsViewModel.access$get_stateFlow$p(r14);
            Intrinsics.checkNotNullParameter(r22, "apList");
            r24.setValue(new k.b(r22));
            DoraSystemInfoManager r25 = DoraSystemInfoManager.a;
            DoraSystemInfoManager.e();
        L42:
            if (r16 == false) goto L49;
            l0.d.set(false);
            kj4.a r26 = kj4.a.g();
            this.L$0 = r1;
            this.L$1 = null;
            this.label = 2;
            if (DoraAdapterExtKt.F(r26, false) != r2) goto L49;
            return r2;
        L46:
            g49.d.b(DoraWifiSettingsViewModel.TAG, "deleteWifi: " + r15 + " failed, " + r17);
            MutableSharedFlow r27 = DoraWifiSettingsViewModel.access$get_sharedFlow$p(r14);
            c.a r28 = c.a.a;
            this.L$0 = r1;
            this.L$1 = null;
            this.label = 3;
            if (r27.emit(r28, this) != r2) goto L49;
            return r2;
        L57:
            Type r112 = new a().getType();     // Catch: Throwable -> L26
            byte[] r30 = ((com.larus.dora.impl.core.request.v2.a.b) r10).a;     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L26
            Object r31 = r13.a(r30, r112);     // Catch: Throwable -> L26
            if (r31 != null) goto L24;
            g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L26
            Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L26
            r1 = Result.constructor-impl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L26
        L56:
            goto L29
        L24:
            r1 = Result.constructor-impl(r31);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            g49.d.c("DoraRequestXV2", "request<T>: parse error", th);
            Result.Companion r113 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L29
        L13:
            ResultKt.throwOnFailure(r18);
            String r33 = this.$entity.c();
            if (r33 != null) goto L16;
            r33 = "";
        L16:
            r11 = r33;
            g49.d.d(DoraWifiSettingsViewModel.TAG, "deleteWifi: " + this.$entity + " start");
            DoraRequestXV2 r34 = DoraRequestXV2.a;
            bl4.b r114 = new bl4.b(r11);
            Lazy<w39.d> r115 = w39.d.b;
            r13 = w39.d.a.a();
            this.L$0 = r11;
            this.L$1 = r13;
            this.label = 1;
            r9 = r34.a(r114, 5000, this);
            if (r9 != r2) goto L19;
            return r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.wlan.wifi.DoraWifiSettingsViewModel$loadSavedWifiList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.wlan.wifi.DoraWifiSettingsViewModel$loadSavedWifiList$1", f = "DoraWifiSettingsViewModel.kt", i = {0}, l = {98}, m = "invokeSuspend", n = {"convertor$iv"}, s = {"L$0"})
    public static final class C04401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraWifiSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.wlan.wifi.DoraWifiSettingsViewModel$loadSavedWifiList$1$a */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends TypeToken<DoraWifiResponse<DoraWifiList>> {
            public a() {
            }
        }

        public C04401(DoraWifiSettingsViewModel r1, Continuation<? super C04401> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04401(this.this$0, r3);
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
            w39.a r2 = (w39.a) this.L$0;
            ResultKt.throwOnFailure(r8);
        L12:
            com.larus.dora.impl.core.request.v2.a r9 = (com.larus.dora.impl.core.request.v2.a) r8;
            if ((r9 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L42;
            g49.d.b("DoraRequestXV2", "request<T>: failed, " + r9);
            Result.Companion r3 = Result.Companion;
            Object r10 = Result.constructor-impl(ResultKt.createFailure(new Exception("Request failed: " + r9)));
        L22:
            DoraWifiSettingsViewModel r4 = this.this$0;
            if (Result.isSuccess-impl(r10) == false) goto L36;
            DoraWifiList r5 = (DoraWifiList) ((DoraWifiResponse) r10).getData();
            if (r5 == null) goto L27;
            List<DoraWifiEntity> r6 = r5.getWifiList();
        L28:
            AtomicBoolean r7 = l0.d;
            if (r6 == null) goto L31;
            boolean r11 = true ^ r6.isEmpty();
        L32:
            r7.set(r11);
            g49.d.d(DoraWifiSettingsViewModel.TAG, "loadSavedWifiList: " + r6);
            z0 r12 = DoraWifiSettingsViewModel.access$get_stateFlow$p(r4);
            if (r6 != null) goto L35;
            r6 = CollectionsKt.emptyList();
        L35:
            r12.setValue(new k.b(CollectionsKt.filterNotNull(r6)));
            goto L36
        L31:
            r11 = false;
            goto L32
        L27:
            r6 = null;
        L36:
            Throwable r13 = Result.exceptionOrNull-impl(r10);
            if (r13 == null) goto L40;
            g49.d.c(DoraWifiSettingsViewModel.TAG, "loadSavedWifiList: failed", r13);
        L40:
            return Unit.INSTANCE;
        L42:
            Type r14 = new a().getType();     // Catch: Throwable -> L19
            byte[] r15 = ((com.larus.dora.impl.core.request.v2.a.b) r9).a;     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L19
            Object r16 = r2.a(r15, r14);     // Catch: Throwable -> L19
            if (r16 != null) goto L17;
            g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L19
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L19
            r10 = Result.constructor-impl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L19
        L41:
            goto L22
        L17:
            r10 = Result.constructor-impl(r16);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            g49.d.c("DoraRequestXV2", "request<T>: parse error", th);
            Result.Companion r18 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            g49.d.d(DoraWifiSettingsViewModel.TAG, "loadSavedWifiList: start");
            DoraRequestXV2 r20 = DoraRequestXV2.a;
            bl4.c r21 = new bl4.c();
            Lazy<w39.d> r22 = w39.d.b;
            w39.d r23 = w39.d.a.a();
            this.L$0 = r23;
            this.label = 1;
            r8 = r20.a(r21, 5000, this);
            if (r8 != r0) goto L11;
            return r0;
        L11:
            r2 = r23;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    public DoraWifiSettingsViewModel() {
        StateFlowImpl r0 = j1.a(k.a.a);
        this._stateFlow = r0;
        this.stateFlow = r0;
        MutableSharedFlow<c> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._sharedFlow = r1;
        this.sharedFlow = r1;
    }

    public final void loadSavedWifiList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04401(this, null), 2, null);
    }

    public final d1<c> getSharedFlow() {
        return this.sharedFlow;
    }

    public final i1<k> getStateFlow() {
        return this.stateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_sharedFlow$p(DoraWifiSettingsViewModel r0) {
        return r0._sharedFlow;
    }

    public static final /* synthetic */ z0 access$get_stateFlow$p(DoraWifiSettingsViewModel r0) {
        return r0._stateFlow;
    }

    public final void deleteWifi(DoraWifiEntity r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r8, this, r9, null), 2, null);
    }
}
