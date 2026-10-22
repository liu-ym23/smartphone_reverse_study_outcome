package com.larus.dora.obric.device_management.setting.common.name;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.l0;
import com.larus.dora.impl.util.o;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u001fJ\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/common/name/DoraObricDeviceNameViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/obric/device_management/setting/common/name/DoraObricDeviceNameUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_action", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/obric/device_management/setting/common/name/DoraObricDeviceNameAction;", "action", "Lkotlinx/coroutines/flow/SharedFlow;", "getAction", "()Lkotlinx/coroutines/flow/SharedFlow;", "initialize", "", "arguments", "Landroid/os/Bundle;", "onBackClicked", "inputName", "", "onSaveClicked", "saveBudsNameOnBack", "saveBudsNameWithConfirm", "syncBudsName", "", "newDeviceName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncBudsNameWithRetry", "isTargetDeviceCurrent", "", "sendDeviceNameUpdateBroadcast", "macAddress", "emitAction", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceNameViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String KEY_DEVICE_NAME = "key_device_name";
    public static final String KEY_DOUBLE_CONFIRM = "key_double_confirm";
    public static final String KEY_MAC_ADDRESS = "key_mac_address";
    private static final String KEY_PRODUCT_MAC = "product_mac";
    public static final int NAME_MAX_LENGTH = 20;
    private static final int SAVE_RETRY_COUNT = 3;
    private static final long SAVE_RETRY_DELAY_MS = 100;
    private static final String TAG = "DoraObricDeviceNameViewModel";
    private final MutableSharedFlow<com.larus.dora.obric.device_management.setting.common.name.a> _action;
    private final z0<i> _uiState;
    private final d1<com.larus.dora.obric.device_management.setting.common.name.a> action;
    private final i1<i> uiState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$emitAction$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$emitAction$1", f = "DoraObricDeviceNameViewModel.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.dora.obric.device_management.setting.common.name.a $action;
        int label;
        final /* synthetic */ DoraObricDeviceNameViewModel this$0;

        public AnonymousClass1(DoraObricDeviceNameViewModel r1, com.larus.dora.obric.device_management.setting.common.name.a r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$action = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$action, r4);
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
            MutableSharedFlow r5 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a r2 = this.$action;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$saveBudsNameOnBack$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$saveBudsNameOnBack$1", f = "DoraObricDeviceNameViewModel.kt", i = {5, 5, 5, 6}, l = {94, 95, 99, 105, 106, 110, 116, 119}, m = "invokeSuspend", n = {"state", "newDeviceName", "macAddress", "macAddress"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class C04851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $inputName;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DoraObricDeviceNameViewModel this$0;

        public C04851(DoraObricDeviceNameViewModel r1, String r2, Continuation<? super C04851> r3) {
            this.this$0 = r1;
            this.$inputName = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04851(this.this$0, this.$inputName, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L14;
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r10);
        L62:
            return Unit.INSTANCE;
        L7:
            String r1 = (String) this.L$0;
            ResultKt.throwOnFailure(r10);
        L58:
            DoraObricDeviceNameViewModel.access$sendDeviceNameUpdateBroadcast(this.this$0, r1);
            MutableSharedFlow r11 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.C0102a r2 = com.larus.dora.obric.device_management.setting.common.name.a.C0102a.a;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 8;
            if (r11.emit(r2, this) != r0) goto L62;
            return r0;
        L8:
            r1 = (String) this.L$2;
            String r4 = (String) this.L$1;
            i r5 = (i) this.L$0;
            ResultKt.throwOnFailure(r10);
        L52:
            int r12 = ((Number) r10).intValue();
            g49.d.d(DoraObricDeviceNameViewModel.TAG, "syncBudsName " + r4 + ", ret = " + r12);
            t39.c r3 = j49.b.a;
            j49.b.f(r5.a, r4, r12);
            if (r12 != 0) goto L55;
            l0.a(r1, r4);
            goto L58
        L55:
            MutableSharedFlow r13 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.d r6 = com.larus.dora.obric.device_management.setting.common.name.a.d.a;
            this.L$0 = r1;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 7;
            if (r13.emit(r6, this) != r0) goto L58;
            return r0;
        L9:
            ResultKt.throwOnFailure(r10);
        L47:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r10);
        L43:
            MutableSharedFlow r14 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.C0102a r7 = com.larus.dora.obric.device_management.setting.common.name.a.C0102a.a;
            this.label = 5;
            if (r14.emit(r7, this) != r0) goto L47;
            return r0;
        L11:
            ResultKt.throwOnFailure(r10);
        L33:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r10);
        L26:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r10);
        L22:
            MutableSharedFlow r15 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.C0102a r8 = com.larus.dora.obric.device_management.setting.common.name.a.C0102a.a;
            this.label = 2;
            if (r15.emit(r8, this) != r0) goto L26;
            return r0;
        L14:
            ResultKt.throwOnFailure(r10);
            r5 = (i) this.this$0.getUiState().getValue();
            r4 = StringsKt.trim(this.$inputName).toString();
            boolean r9 = false;
            if (r4.length() != 0) goto L17;
            boolean r16 = true;
        L18:
            if (r16 == false) goto L28;
            MutableSharedFlow r17 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.b r18 = com.larus.dora.obric.device_management.setting.common.name.a.b.a;
            this.label = 1;
            if (r17.emit(r18, this) != r0) goto L22;
            return r0;
        L28:
            if (Intrinsics.areEqual(r4, r5.a) == false) goto L34;
            MutableSharedFlow r110 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.C0102a r20 = com.larus.dora.obric.device_management.setting.common.name.a.C0102a.a;
            this.label = 3;
            if (r110.emit(r20, this) != r0) goto L33;
            return r0;
        L34:
            String r111 = r5.b;
            if (r111 != null) goto L37;
        L38:
            r9 = true;
        L39:
            if (r9 == false) goto L48;
            g49.d.e(DoraObricDeviceNameViewModel.TAG, "saveBudsNameOnBack skipped, macAddress is empty");
            MutableSharedFlow r112 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.d r21 = com.larus.dora.obric.device_management.setting.common.name.a.d.a;
            this.label = 4;
            if (r112.emit(r21, this) != r0) goto L43;
            return r0;
        L48:
            DoraObricDeviceNameViewModel r22 = this.this$0;
            this.L$0 = r5;
            this.L$1 = r4;
            this.L$2 = r111;
            this.label = 6;
            Object r23 = DoraObricDeviceNameViewModel.access$syncBudsName(r22, r4, this);
            if (r23 != r0) goto L51;
            return r0;
        L51:
            r1 = r111;
            r10 = r23;
            goto L52
        L37:
            if (StringsKt.isBlank(r111) == false) goto L39;
        L17:
            r16 = false;
            goto L18
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$saveBudsNameWithConfirm$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$saveBudsNameWithConfirm$1", f = "DoraObricDeviceNameViewModel.kt", i = {3, 3, 3}, l = {128, 133, 139, 143, 149, 151}, m = "invokeSuspend", n = {"state", "newDeviceName", "macAddress"}, s = {"L$0", "L$1", "L$2"})
    public static final class C04861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $inputName;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DoraObricDeviceNameViewModel this$0;

        public C04861(DoraObricDeviceNameViewModel r1, String r2, Continuation<? super C04861> r3) {
            this.this$0 = r1;
            this.$inputName = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04861(this.this$0, this.$inputName, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L11;
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r9);
        L52:
            return Unit.INSTANCE;
        L7:
            String r1 = (String) this.L$2;
            String r3 = (String) this.L$1;
            i r4 = (i) this.L$0;
            ResultKt.throwOnFailure(r9);
        L43:
            int r10 = ((Number) r9).intValue();
            g49.d.d(DoraObricDeviceNameViewModel.TAG, "syncBudsName " + r3 + ", ret = " + r10);
            t39.c r2 = j49.b.a;
            j49.b.f(r4.a, r3, r10);
            if (r10 != 0) goto L48;
            l0.a(r1, r3);
            DoraObricDeviceNameViewModel.access$sendDeviceNameUpdateBroadcast(this.this$0, r1);
            MutableSharedFlow r11 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.C0102a r5 = com.larus.dora.obric.device_management.setting.common.name.a.C0102a.a;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 5;
            if (r11.emit(r5, this) != r0) goto L52;
            return r0;
        L48:
            MutableSharedFlow r12 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.d r6 = com.larus.dora.obric.device_management.setting.common.name.a.d.a;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 6;
            if (r12.emit(r6, this) != r0) goto L52;
            return r0;
        L8:
            ResultKt.throwOnFailure(r9);
        L38:
            return Unit.INSTANCE;
        L9:
            ResultKt.throwOnFailure(r9);
        L27:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r9);
        L20:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r9);
            r4 = (i) this.this$0.getUiState().getValue();
            r3 = StringsKt.trim(this.$inputName).toString();
            boolean r7 = false;
            if (r3.length() != 0) goto L14;
            boolean r13 = true;
        L15:
            if (r13 == false) goto L22;
            MutableSharedFlow r14 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.b r8 = com.larus.dora.obric.device_management.setting.common.name.a.b.a;
            this.label = 1;
            if (r14.emit(r8, this) != r0) goto L20;
            return r0;
        L22:
            if (r3.getBytes(Charsets.UTF_8).length <= 20) goto L28;
            MutableSharedFlow r15 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.c r16 = com.larus.dora.obric.device_management.setting.common.name.a.c.a;
            this.label = 2;
            if (r15.emit(r16, this) != r0) goto L27;
            return r0;
        L28:
            String r17 = r4.b;
            if (r17 != null) goto L31;
        L32:
            r7 = true;
        L33:
            if (r7 == false) goto L39;
            g49.d.e(DoraObricDeviceNameViewModel.TAG, "saveBudsNameWithConfirm skipped, macAddress is empty");
            MutableSharedFlow r18 = DoraObricDeviceNameViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.setting.common.name.a.d r20 = com.larus.dora.obric.device_management.setting.common.name.a.d.a;
            this.label = 3;
            if (r18.emit(r20, this) != r0) goto L38;
            return r0;
        L39:
            DoraObricDeviceNameViewModel r21 = this.this$0;
            this.L$0 = r4;
            this.L$1 = r3;
            this.L$2 = r17;
            this.label = 4;
            Object r22 = DoraObricDeviceNameViewModel.access$syncBudsNameWithRetry(r21, r3, this);
            if (r22 != r0) goto L42;
            return r0;
        L42:
            r1 = r17;
            r9 = r22;
            goto L43
        L31:
            if (StringsKt.isBlank(r17) == false) goto L33;
        L14:
            r13 = false;
            goto L15
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$syncBudsName$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$syncBudsName$2", f = "DoraObricDeviceNameViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ String $newDeviceName;
        int label;
        final /* synthetic */ DoraObricDeviceNameViewModel this$0;

        public AnonymousClass2(DoraObricDeviceNameViewModel r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$newDeviceName = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$newDeviceName, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (DoraObricDeviceNameViewModel.access$isTargetDeviceCurrent(this.this$0) == true) goto L9;
            g49.d.e(DoraObricDeviceNameViewModel.TAG, "syncBudsName: target device is not current");
            return Boxing.boxInt(-1);
        L9:
            return Boxing.boxInt(kj4.a.g().q(this.$newDeviceName));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$syncBudsNameWithRetry$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel$syncBudsNameWithRetry$2", f = "DoraObricDeviceNameViewModel.kt", i = {0, 0}, l = {178}, m = "invokeSuspend", n = {"ret", "index"}, s = {"I$0", "I$1"})
    public static final class C04872 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ String $newDeviceName;
        int I$0;
        int I$1;
        int label;
        final /* synthetic */ DoraObricDeviceNameViewModel this$0;

        public C04872(DoraObricDeviceNameViewModel r1, String r2, Continuation<? super C04872> r3) {
            this.this$0 = r1;
            this.$newDeviceName = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04872(this.this$0, this.$newDeviceName, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:21:0x0058). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$1;
            int r3 = this.I$0;
            ResultKt.throwOnFailure(r7);
            int r8 = r3;
            C04872 r4 = this;
        L21:
            r2 = r2 + 1;
        L14:
            if (r2 >= 3) goto L23;
            r8 = kj4.a.g().q(r4.$newDeviceName);
            if (r8 == 0) goto L23;
            r4.I$0 = r8;
            r4.I$1 = r2;
            r4.label = 1;
            if (DelayKt.delay(DoraObricDeviceNameViewModel.SAVE_RETRY_DELAY_MS, r4) != r0) goto L21;
            return r0;
        L23:
            return Boxing.boxInt(r8);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            if (DoraObricDeviceNameViewModel.access$isTargetDeviceCurrent(this.this$0) == true) goto L12;
            g49.d.e(DoraObricDeviceNameViewModel.TAG, "syncBudsNameWithRetry: target device is not current");
            return Boxing.boxInt(-1);
        L12:
            r8 = 0;
            r4 = this;
            r2 = 0;
            goto L14
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isTargetDeviceCurrent() {
        String r0 = ((i) this.uiState.getValue()).b;
        if (r0 != null) goto L6;
        return false;
    L6:
        DoraDevice r1 = DoraAdapterExtKt.h(kj4.a.g());
        if (r1 == null) goto L9;
        String r2 = r1.mac;
    L11:
        return Intrinsics.areEqual(r2, r0);
    L9:
        r2 = null;
        goto L11
    }

    public DoraObricDeviceNameViewModel() {
        StateFlowImpl r0 = j1.a(new i(0));
        this._uiState = r0;
        this.uiState = kotlinx.coroutines.flow.e.b(r0);
        MutableSharedFlow<com.larus.dora.obric.device_management.setting.common.name.a> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._action = r1;
        this.action = kotlinx.coroutines.flow.e.a(r1);
    }

    public final d1<com.larus.dora.obric.device_management.setting.common.name.a> getAction() {
        return this.action;
    }

    public final i1<i> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_action$p(DoraObricDeviceNameViewModel r0) {
        return r0._action;
    }

    public static final /* synthetic */ boolean access$isTargetDeviceCurrent(DoraObricDeviceNameViewModel r0) {
        return r0.isTargetDeviceCurrent();
    }

    private final void emitAction(com.larus.dora.obric.device_management.setting.common.name.a r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r7, null), 3, null);
    }

    private final void saveBudsNameOnBack(String r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04851(this, r7, null), 3, null);
    }

    private final void saveBudsNameWithConfirm(String r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04861(this, r7, null), 3, null);
    }

    private final void sendDeviceNameUpdateBroadcast(String r3) {
        Intent r0 = new Intent("action.DEVICE_UPDATE_NAME");
        r0.putExtra("mac", r3);
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r0);
    }

    public final void initialize(Bundle r9) {
        DoraDevice r0 = DoraAdapterExtKt.h(kj4.a.g());
        String r1 = null;
        if (r9 == null) goto L6;
        String r2 = r9.getString(KEY_MAC_ADDRESS);
        if (r2 == null) goto L6;
    L13:
        boolean r3 = true;
        if (r2 != null) goto L16;
    L18:
        r2 = null;
    L19:
        boolean r4 = false;
        if (r2 == null) goto L31;
        Iterator r5 = DoraAdapterExtKt.k(kj4.a.g()).iterator();
    L23:
        if (r5.hasNext() == false) goto L27;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((DoraDevice) r6).mac, r2) == false) goto L23;
    L28:
        DoraDevice r7 = (DoraDevice) r6;
        if (r7 == null) goto L31;
        r0 = r7;
    L37:
        if (r9 == null) goto L40;
        String r8 = r9.getString(KEY_DEVICE_NAME);
        if (r8 == null) goto L40;
    L49:
        if (r2 != null) goto L52;
        if (r0 == null) goto L53;
        r1 = r0.mac;
    L53:
        String r10 = o.b(r1, r8);
        z0<i> r11 = this._uiState;
        if (r9 == null) goto L56;
        r4 = r9.getBoolean(KEY_DOUBLE_CONFIRM);
    L56:
        r11.setValue(new i(r10, r1, r4));
        return;
    L52:
        r1 = r2;
    L40:
        if (r9 == null) goto L42;
        r8 = r9.getString("device_name");
    L43:
        if (r8 != null) goto L49;
        if (r0 == null) goto L46;
        r8 = r0.name;
    L47:
        if (r8 != null) goto L49;
        r8 = "";
        goto L49
    L46:
        r8 = null;
        goto L47
    L42:
        r8 = null;
        goto L43
    L27:
        r6 = null;
    L31:
        if (r2 == null) goto L34;
        r3 = false;
    L34:
        if (r3 == true) goto L37;
        r0 = null;
        goto L37
    L16:
        if ((!StringsKt.isBlank(r2)) == false) goto L18;
    L6:
        if (r9 == null) goto L8;
        r2 = r9.getString("mac");
    L9:
        if (r2 != null) goto L13;
        if (r9 == null) goto L12;
        r2 = r9.getString("product_mac");
        goto L13
    L12:
        r2 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public final void onBackClicked(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inputName");
        if (((i) this.uiState.getValue()).c == false) goto L5;
        emitAction(com.larus.dora.obric.device_management.setting.common.name.a.C0102a.a);
        return;
    L5:
        saveBudsNameOnBack(r2);
    }

    public final void onSaveClicked(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inputName");
        if (((i) this.uiState.getValue()).c == false) goto L5;
        saveBudsNameWithConfirm(r2);
        return;
    L5:
        saveBudsNameOnBack(r2);
    }

    public static final /* synthetic */ void access$sendDeviceNameUpdateBroadcast(DoraObricDeviceNameViewModel r0, String r1) {
        r0.sendDeviceNameUpdateBroadcast(r1);
    }

    private final Object syncBudsName(String r4, Continuation<? super Integer> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r4, null), r5);
    }

    private final Object syncBudsNameWithRetry(String r4, Continuation<? super Integer> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C04872(this, r4, null), r5);
    }

    public static final /* synthetic */ Object access$syncBudsName(DoraObricDeviceNameViewModel r0, String r1, Continuation r2) {
        return r0.syncBudsName(r1, r2);
    }

    public static final /* synthetic */ Object access$syncBudsNameWithRetry(DoraObricDeviceNameViewModel r0, String r1, Continuation r2) {
        return r0.syncBudsNameWithRetry(r1, r2);
    }
}
