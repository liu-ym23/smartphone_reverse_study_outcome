package com.larus.dora.impl.device.settings.recordMinutes;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.keva.Keva;
import com.larus.dora.api.DoraConfig;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import mj4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/impl/device/settings/recordMinutes/RecordMinutesSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_recordMinutesSettingStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/recordMinutes/RecordMinutesSetting;", "recordMinutesSettingStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getRecordMinutesSettingStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_recordMinutesActionSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/settings/recordMinutes/RecordMinutesAction;", "recordMinutesActionSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getRecordMinutesActionSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadRecordMinutesSetting", "", "updateRecordingDuringCallEnable", "isEnable", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesSettingViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "RecordMinutesSettingViewModel";
    private final MutableSharedFlow<Object> _recordMinutesActionSharedFlow;
    private final z0<b> _recordMinutesSettingStateFlow;
    private final d1<Object> recordMinutesActionSharedFlow;
    private final i1<b> recordMinutesSettingStateFlow;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.recordMinutes.RecordMinutesSettingViewModel$loadRecordMinutesSetting$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.recordMinutes.RecordMinutesSettingViewModel$loadRecordMinutesSetting$1", f = "RecordMinutesSettingViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RecordMinutesSettingViewModel this$0;

        public AnonymousClass1(RecordMinutesSettingViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            f r11 = kj4.a.g().c;
            r11.d.j(1, 4, new byte[]{25, 0}, 10000);
            int r12 = r11.q;
            g49.d.d(RecordMinutesSettingViewModel.TAG, "loadRecordMinutesSetting: res= " + r12);
            if (r12 == 1) goto L11;
            boolean r13 = true;
        L12:
            DoraConfig.a.storeBoolean("key_auto_record_in_call", r13);
            g49.d.d(RecordMinutesSettingViewModel.TAG, "loadRecordMinutesSetting: isRecordMinutesEnabled= " + r13);
            z0 r2 = RecordMinutesSettingViewModel.access$get_recordMinutesSettingStateFlow$p(this.this$0);
            b.C0054b r3 = new b.C0054b(r13);
            this.label = 1;
            if (r2.emit(r3, this) != r0) goto L16;
            return r0;
        L11:
            r13 = false;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.recordMinutes.RecordMinutesSettingViewModel$updateRecordingDuringCallEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.recordMinutes.RecordMinutesSettingViewModel$updateRecordingDuringCallEnable$1", f = "RecordMinutesSettingViewModel.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnable;
        final /* synthetic */ int $isEnableValue;
        int label;
        final /* synthetic */ RecordMinutesSettingViewModel this$0;

        public C03021(int r1, boolean r2, RecordMinutesSettingViewModel r3, Continuation<? super C03021> r4) {
            this.$isEnableValue = r1;
            this.$isEnable = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03021(this.$isEnableValue, this.$isEnable, this.this$0, r5);
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
            kj4.a r12 = kj4.a.g();
            if (r12 == null) goto L11;
            Integer r13 = Boxing.boxInt(r12.c.d.j(1, 4, new byte[]{25, 1, (byte) this.$isEnableValue}, 10000));
        L12:
            g49.d.d(RecordMinutesSettingViewModel.TAG, "setRecordingDuringCallEnable: ret= " + r13);
            if (r13 != null) goto L16;
        L20:
            MutableSharedFlow r14 = RecordMinutesSettingViewModel.access$get_recordMinutesActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.recordMinutes.a r2 = new com.larus.dora.impl.device.settings.recordMinutes.a();
            this.label = 1;
            if (r14.emit(r2, this) != r0) goto L24;
            return r0;
        L16:
            if (r13.intValue() != 0) goto L20;
            Keva r15 = DoraConfig.a;
            DoraConfig.a.storeBoolean("key_auto_record_in_call", this.$isEnable);
            if ((RecordMinutesSettingViewModel.access$get_recordMinutesSettingStateFlow$p(this.this$0).getValue() instanceof b.C0054b) == false) goto L24;
            z0 r16 = RecordMinutesSettingViewModel.access$get_recordMinutesSettingStateFlow$p(this.this$0);
            Object r3 = RecordMinutesSettingViewModel.access$get_recordMinutesSettingStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.recordMinutes.RecordMinutesSetting.Success");
            boolean r4 = this.$isEnable;
            ((b.C0054b) r3).getClass();
            r16.setValue(new b.C0054b(r4));
            goto L24
        L11:
            r13 = null;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    public RecordMinutesSettingViewModel() {
        StateFlowImpl r0 = j1.a(b.a.a);
        this._recordMinutesSettingStateFlow = r0;
        this.recordMinutesSettingStateFlow = e.b(r0);
        MutableSharedFlow<Object> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._recordMinutesActionSharedFlow = r1;
        this.recordMinutesActionSharedFlow = e.a(r1);
    }

    public final void loadRecordMinutesSetting() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final d1<Object> getRecordMinutesActionSharedFlow() {
        return this.recordMinutesActionSharedFlow;
    }

    public final i1<b> getRecordMinutesSettingStateFlow() {
        return this.recordMinutesSettingStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_recordMinutesActionSharedFlow$p(RecordMinutesSettingViewModel r0) {
        return r0._recordMinutesActionSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_recordMinutesSettingStateFlow$p(RecordMinutesSettingViewModel r0) {
        return r0._recordMinutesSettingStateFlow;
    }

    public final void updateRecordingDuringCallEnable(boolean r8) {
        g49.d.d(TAG, "updateRecordingDuringCallEnable: isEnable= " + r8);
        if (r8 == false) goto L5;
        int r0 = 2;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03021(r0, r8, this, null), 2, null);
        return;
    L5:
        r0 = 1;
        goto L6
    }
}
