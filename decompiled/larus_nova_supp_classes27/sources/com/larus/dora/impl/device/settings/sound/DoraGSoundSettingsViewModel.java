package com.larus.dora.impl.device.settings.sound;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.dora.impl.util.t0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0013\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/device/settings/sound/DoraGSoundSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_antiSoundLeakStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakState;", "antiSoundLeakStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getAntiSoundLeakStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_antiSoundLeakSwitchFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakSwitchResult;", "antiSoundLeakSwitchFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getAntiSoundLeakSwitchFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "doraLinkCallback", "com/larus/dora/impl/device/settings/sound/DoraGSoundSettingsViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/device/settings/sound/DoraGSoundSettingsViewModel$doraLinkCallback$1;", "onCleared", "", "setAntiSoundLeakEnabled", "enable", "", "refreshData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGSoundSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "GSoundSettingsVM-TAG";
    private final z0<com.larus.dora.impl.device.settings.sound.a> _antiSoundLeakStateFlow;
    private final MutableSharedFlow<com.larus.dora.impl.device.settings.sound.b> _antiSoundLeakSwitchFlow;
    private final i1<com.larus.dora.impl.device.settings.sound.a> antiSoundLeakStateFlow;
    private final d1<com.larus.dora.impl.device.settings.sound.b> antiSoundLeakSwitchFlow;
    private final b doraLinkCallback;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends t0 {
        public final /* synthetic */ DoraGSoundSettingsViewModel a;

        public b(DoraGSoundSettingsViewModel r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r1, int r2, int r3) {
            if (r3 != 2) goto L6;
            DoraGSoundSettingsViewModel.access$refreshData(this.a);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.DoraGSoundSettingsViewModel$refreshData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.DoraGSoundSettingsViewModel$refreshData$1", f = "DoraGSoundSettingsViewModel.kt", i = {0, 1}, l = {67, 70}, m = "invokeSuspend", n = {"state", "state"}, s = {"I$0", "I$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int label;
        final /* synthetic */ DoraGSoundSettingsViewModel this$0;

        public AnonymousClass1(DoraGSoundSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r5);
        L18:
            int r6 = r2;
        L22:
            g49.d.d(DoraGSoundSettingsViewModel.TAG, "DoraGSoundSettingsViewModel.refreshData.isBudsAntiSoundLeakEnable: " + r6);
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r5);
            r6 = kj4.a.g().h();
            if (r6 == 0) goto L19;
            if (r6 != 1) goto L22;
            z0 r3 = DoraGSoundSettingsViewModel.access$get_antiSoundLeakStateFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.sound.a.b r4 = com.larus.dora.impl.device.settings.sound.a.b.a;
            this.I$0 = r6;
            this.label = 1;
            if (r3.emit(r4, this) != r0) goto L17;
            return r0;
        L17:
            r2 = r6;
            goto L18
        L19:
            z0 r7 = DoraGSoundSettingsViewModel.access$get_antiSoundLeakStateFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.sound.a.C0056a r8 = com.larus.dora.impl.device.settings.sound.a.C0056a.a;
            this.I$0 = r6;
            this.label = 2;
            if (r7.emit(r8, this) != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.DoraGSoundSettingsViewModel$setAntiSoundLeakEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.DoraGSoundSettingsViewModel$setAntiSoundLeakEnabled$1", f = "DoraGSoundSettingsViewModel.kt", i = {0, 1, 2}, l = {51, 52, 55}, m = "invokeSuspend", n = {"ret", "ret", "ret"}, s = {"I$0", "I$0", "I$0"})
    public static final class C03031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int I$0;
        int label;
        final /* synthetic */ DoraGSoundSettingsViewModel this$0;

        public C03031(boolean r1, DoraGSoundSettingsViewModel r2, Continuation<? super C03031> r3) {
            this.$enable = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03031(this.$enable, this.this$0, r4);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r6);
        L35:
            g49.d.d(DoraGSoundSettingsViewModel.TAG, "DoraGSoundSettingsViewModel.setAntiSoundLeakEnabled: ret: " + r2 + ", enable: " + this.$enable);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r2 = this.I$0;
            ResultKt.throwOnFailure(r6);
        L26:
            DoraSystemInfoManager r7 = DoraSystemInfoManager.a;
            if (this.$enable == false) goto L29;
            String r8 = "1";
        L30:
            DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("anti_sound_leak_mode", r8)));
            goto L35
        L29:
            r8 = "0";
            goto L30
        L11:
            int r3 = this.I$0;
            ResultKt.throwOnFailure(r6);
        L22:
            MutableSharedFlow r9 = DoraGSoundSettingsViewModel.access$get_antiSoundLeakSwitchFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.sound.b.C0057b r4 = new com.larus.dora.impl.device.settings.sound.b.C0057b(this.$enable ? 1 : 0);
            this.I$0 = r3;
            this.label = 2;
            if (r9.emit(r4, this) != r0) goto L25;
            return r0;
        L25:
            r2 = r3;
            goto L26
        L12:
            ResultKt.throwOnFailure(r6);
            int r10 = kj4.a.g().n(this.$enable);
            if (r10 != 0) goto L31;
            z0 r5 = DoraGSoundSettingsViewModel.access$get_antiSoundLeakStateFlow$p(this.this$0);
            if (this.$enable == false) goto L17;
            Object r11 = com.larus.dora.impl.device.settings.sound.a.b.a;
        L18:
            this.I$0 = r10;
            this.label = 1;
            if (r5.emit(r11, this) != r0) goto L21;
            return r0;
        L21:
            r3 = r10;
            goto L22
        L17:
            r11 = com.larus.dora.impl.device.settings.sound.a.C0056a.a;
            goto L18
        L31:
            MutableSharedFlow r12 = DoraGSoundSettingsViewModel.access$get_antiSoundLeakSwitchFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.sound.b.a r13 = new com.larus.dora.impl.device.settings.sound.b.a(this.$enable ? 1 : 0, r10);
            this.I$0 = r10;
            this.label = 3;
            if (r12.emit(r13, this) != r0) goto L34;
            return r0;
        L34:
            r2 = r10;
            goto L35
        }
    }

    static {
        Companion = new a();
    }

    public DoraGSoundSettingsViewModel() {
        StateFlowImpl r0 = j1.a(com.larus.dora.impl.device.settings.sound.a.C0056a.a);
        this._antiSoundLeakStateFlow = r0;
        this.antiSoundLeakStateFlow = r0;
        MutableSharedFlow<com.larus.dora.impl.device.settings.sound.b> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._antiSoundLeakSwitchFlow = r1;
        this.antiSoundLeakSwitchFlow = r1;
        b r2 = new b(this);
        this.doraLinkCallback = r2;
        refreshData();
        kj4.a.g().registerDoraLinkCallback(r2);
    }

    private final void refreshData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
    }

    public final i1<com.larus.dora.impl.device.settings.sound.a> getAntiSoundLeakStateFlow() {
        return this.antiSoundLeakStateFlow;
    }

    public final d1<com.larus.dora.impl.device.settings.sound.b> getAntiSoundLeakSwitchFlow() {
        return this.antiSoundLeakSwitchFlow;
    }

    public static final /* synthetic */ z0 access$get_antiSoundLeakStateFlow$p(DoraGSoundSettingsViewModel r0) {
        return r0._antiSoundLeakStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_antiSoundLeakSwitchFlow$p(DoraGSoundSettingsViewModel r0) {
        return r0._antiSoundLeakSwitchFlow;
    }

    public static final /* synthetic */ void access$refreshData(DoraGSoundSettingsViewModel r0) {
        r0.refreshData();
    }

    public final void setAntiSoundLeakEnabled(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03031(r7, this, null), 2, null);
    }
}
