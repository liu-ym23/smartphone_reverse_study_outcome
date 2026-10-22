package com.larus.dora.impl.device.settings.sound;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraGAmbientVolumeConfig;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.util.e0;
import com.larus.dora.impl.util.t0;
import com.larus.utils.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u001f\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0014J\u0006\u0010#\u001a\u00020\"J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\"J\u000e\u0010*\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010+J&\u0010-\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0082@¢\u0006\u0002\u00100J.\u00101\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00102\u001a\u00020\rH\u0082@¢\u0006\u0002\u00103J\u000f\u00104\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u00105J\u000f\u00106\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u00105J\n\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020\rH\u0002J\u0018\u0010:\u001a\u00020\"2\u0006\u0010%\u001a\u00020\r2\u0006\u0010;\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006="}, d2 = {"Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_soundSettingsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/sound/SoundSettingsState;", "soundSettingsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getSoundSettingsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_updateAmbientVolumeSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "updateAmbientVolumeSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUpdateAmbientVolumeSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_speakerVolStateFlow", "Lcom/larus/dora/impl/device/settings/sound/SpeakerVolState;", "speakerVolStateFlow", "getSpeakerVolStateFlow", "_antiSoundLeakStateFlow", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakState;", "antiSoundLeakStateFlow", "getAntiSoundLeakStateFlow", "_antiSoundLeakSwitchFlow", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakSwitchResult;", "antiSoundLeakSwitchFlow", "getAntiSoundLeakSwitchFlow", "doraLinkCallback", "com/larus/dora/impl/device/settings/sound/SoundSettingsViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel$doraLinkCallback$1;", "onCleared", "", "load", "setAmbientVolumeSwitch", "enabled", "updateAmbientVolumeEnabled", "setAntiSoundLeakEnabled", "enable", "loadVoice", "loadAmbientVolumeState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAntiSoundLeakState", "updateAmbientVolumeSwitchInternal", "markUserModified", "report", "(ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAntiSoundLeakSwitchInternal", "emitResult", "(ZZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveAmbientVolumeSwitch", "()Ljava/lang/Boolean;", "resolveAntiSoundLeakSwitch", "currentDeviceMac", "", "currentDeviceIsG2", "reportAmbientVolumeSwitch", "isSuccess", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SoundSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String EVENT_AMBIENT_VOLUME_SWITCH = "dora_adaptive_volume_settings";
    private static final String PARAM_IS_SUCCESS = "is_success";
    private static final String PARAM_SETTINGS_DETAIL = "settings_detail";
    private static final String TAG = "SoundSettingsViewModel";
    private static final String VALUE_OFF = "off";
    private static final String VALUE_ON = "on";
    private final z0<com.larus.dora.impl.device.settings.sound.a> _antiSoundLeakStateFlow;
    private final MutableSharedFlow<com.larus.dora.impl.device.settings.sound.b> _antiSoundLeakSwitchFlow;
    private final z0<l> _soundSettingsStateFlow;
    private final z0<m> _speakerVolStateFlow;
    private final MutableSharedFlow<Boolean> _updateAmbientVolumeSharedFlow;
    private final i1<com.larus.dora.impl.device.settings.sound.a> antiSoundLeakStateFlow;
    private final d1<com.larus.dora.impl.device.settings.sound.b> antiSoundLeakSwitchFlow;
    private final b doraLinkCallback;
    private final i1<l> soundSettingsStateFlow;
    private final i1<m> speakerVolStateFlow;
    private final d1<Boolean> updateAmbientVolumeSharedFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends t0 {
        public final /* synthetic */ SoundSettingsViewModel a;

        public b(SoundSettingsViewModel r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r1, int r2, int r3) {
            if (r3 != 2) goto L6;
            this.a.load();
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$load$1", f = "SoundSettingsViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public AnonymousClass1(SoundSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            SoundSettingsViewModel r5 = this.this$0;
            this.label = 1;
            if (SoundSettingsViewModel.access$loadAmbientVolumeState(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$load$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$load$2", f = "SoundSettingsViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public AnonymousClass2(SoundSettingsViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            SoundSettingsViewModel r5 = this.this$0;
            this.label = 1;
            if (SoundSettingsViewModel.access$loadAntiSoundLeakState(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$loadAmbientVolumeState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel", f = "SoundSettingsViewModel.kt", i = {}, l = {109, 119, 121, 123}, m = "loadAmbientVolumeState", n = {}, s = {})
    public static final class C03041 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public C03041(SoundSettingsViewModel r1, Continuation<? super C03041> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return SoundSettingsViewModel.access$loadAmbientVolumeState(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$loadAntiSoundLeakState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel", f = "SoundSettingsViewModel.kt", i = {1, 2}, l = {130, 143, 144}, m = "loadAntiSoundLeakState", n = {"state", "state"}, s = {"I$0", "I$0"})
    public static final class C03051 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public C03051(SoundSettingsViewModel r1, Continuation<? super C03051> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return SoundSettingsViewModel.access$loadAntiSoundLeakState(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$loadVoice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$loadVoice$1", f = "SoundSettingsViewModel.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public C03061(SoundSettingsViewModel r1, Continuation<? super C03061> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03061(this.this$0, r3);
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
            byte r6 = kj4.a.g().z();
            z0 r2 = SoundSettingsViewModel.access$get_speakerVolStateFlow$p(this.this$0);
            m.c r3 = new m.c(r6);
            this.label = 1;
            if (r2.emit(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$setAmbientVolumeSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$setAmbientVolumeSwitch$1", f = "SoundSettingsViewModel.kt", i = {}, l = {75, 80}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        int label;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public C03071(SoundSettingsViewModel r1, boolean r2, Continuation<? super C03071> r3) {
            this.this$0 = r1;
            this.$enabled = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03071(this.this$0, this.$enabled, r4);
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
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L13:
            boolean r6 = ((Boolean) r5).booleanValue();
            MutableSharedFlow r2 = SoundSettingsViewModel.access$get_updateAmbientVolumeSharedFlow$p(this.this$0);
            Boolean r7 = Boxing.boxBoolean(r6);
            this.label = 2;
            if (r2.emit(r7, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            SoundSettingsViewModel r8 = this.this$0;
            boolean r3 = this.$enabled;
            this.label = 1;
            r5 = SoundSettingsViewModel.access$updateAmbientVolumeSwitchInternal(r8, r3, true, true, this);
            if (r5 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$setAntiSoundLeakEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$setAntiSoundLeakEnabled$1", f = "SoundSettingsViewModel.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public C03081(SoundSettingsViewModel r1, boolean r2, Continuation<? super C03081> r3) {
            this.this$0 = r1;
            this.$enable = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03081(this.this$0, this.$enable, r4);
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
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            SoundSettingsViewModel r2 = this.this$0;
            boolean r9 = this.$enable;
            this.label = 1;
            if (SoundSettingsViewModel.access$updateAntiSoundLeakSwitchInternal(r2, r9, true, true, true, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$updateAmbientVolumeSwitchInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel", f = "SoundSettingsViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {156, 159}, m = "updateAmbientVolumeSwitchInternal", n = {"enabled", "markUserModified", "report", "enabled", "markUserModified", "report", "isSuccess"}, s = {"Z$0", "Z$1", "Z$2", "Z$0", "Z$1", "Z$2", "I$0"})
    public static final class C03091 extends ContinuationImpl {
        int I$0;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public C03091(SoundSettingsViewModel r1, Continuation<? super C03091> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return SoundSettingsViewModel.access$updateAmbientVolumeSwitchInternal(this.this$0, false, false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel$updateAntiSoundLeakSwitchInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel", f = "SoundSettingsViewModel.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {190, 195, 209}, m = "updateAntiSoundLeakSwitchInternal", n = {"enable", "markUserModified", "report", "emitResult", "ret", "isSuccess", "enable", "report", "ret", "isSuccess", "enable", "ret", "isSuccess"}, s = {"Z$0", "Z$1", "Z$2", "Z$3", "I$0", "I$1", "Z$0", "Z$1", "I$0", "I$1", "Z$0", "I$0", "I$1"})
    public static final class C03101 extends ContinuationImpl {
        int I$0;
        int I$1;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        boolean Z$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SoundSettingsViewModel this$0;

        public C03101(SoundSettingsViewModel r1, Continuation<? super C03101> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return SoundSettingsViewModel.access$updateAntiSoundLeakSwitchInternal(this.this$0, false, false, false, false, this);
        }
    }

    static {
        Companion = new a();
    }

    private final boolean currentDeviceIsG2() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.O() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public SoundSettingsViewModel() {
        StateFlowImpl r0 = j1.a(l.b.a);
        this._soundSettingsStateFlow = r0;
        this.soundSettingsStateFlow = r0;
        MutableSharedFlow<Boolean> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._updateAmbientVolumeSharedFlow = r3;
        this.updateAmbientVolumeSharedFlow = r3;
        StateFlowImpl r4 = j1.a(m.b.a);
        this._speakerVolStateFlow = r4;
        this.speakerVolStateFlow = r4;
        StateFlowImpl r5 = j1.a(com.larus.dora.impl.device.settings.sound.a.C0056a.a);
        this._antiSoundLeakStateFlow = r5;
        this.antiSoundLeakStateFlow = r5;
        MutableSharedFlow<com.larus.dora.impl.device.settings.sound.b> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._antiSoundLeakSwitchFlow = r1;
        this.antiSoundLeakSwitchFlow = r1;
        b r2 = new b(this);
        this.doraLinkCallback = r2;
        kj4.a.g().registerDoraLinkCallback(r2);
        load();
        loadVoice();
    }

    private final String currentDeviceMac() {
        DoraDevice r0 = DoraAdapterExtKt.h(kj4.a.g());
        if (r0 == null) goto L13;
        String r1 = r0.mac;
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r1;
    L9:
        r2 = false;
        goto L10
    L13:
        return null;
    }

    private final Boolean resolveAmbientVolumeSwitch() {
        if (currentDeviceIsG2() == true) goto L5;
        return null;
    L5:
        String r0 = currentDeviceMac();
        if (r0 == null) goto L8;
        b0.a.getClass();
        e0 r1 = b0.g(r0);
    L9:
        if (r1 == null) goto L13;
        boolean r2 = true;
        if (r1.a != true) goto L13;
    L14:
        if (r2 == false) goto L17;
        return null;
    L17:
        if (DoraAdapterExtKt.y(kj4.a.g()) == true) goto L19;
        return null;
    L19:
        DoraSetting.a.getClass();
        DoraGAmbientVolumeConfig r3 = (DoraGAmbientVolumeConfig) l0.a(null, new com.larus.dora.impl.settings.k());
        if (r3 != null) goto L22;
        return null;
    L22:
        return r3.getAmbientVolumeSwitch();
    L13:
        r2 = false;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    private final Boolean resolveAntiSoundLeakSwitch() {
        if (currentDeviceIsG2() == true) goto L5;
        return null;
    L5:
        String r0 = currentDeviceMac();
        if (r0 == null) goto L8;
        b0.a.getClass();
        e0 r1 = b0.g(r0);
    L9:
        if (r1 == null) goto L13;
        boolean r2 = true;
        if (r1.a != true) goto L13;
    L14:
        if (r2 == false) goto L16;
        return null;
    L16:
        DoraSetting.a.getClass();
        DoraGAmbientVolumeConfig r3 = (DoraGAmbientVolumeConfig) l0.a(null, new com.larus.dora.impl.settings.k());
        if (r3 != null) goto L19;
        return null;
    L19:
        return r3.getAntiSoundLeakSwitch();
    L13:
        r2 = false;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    public final void load() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(this, null), 2, null);
    }

    public final void loadVoice() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03061(this, null), 2, null);
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

    public final i1<l> getSoundSettingsStateFlow() {
        return this.soundSettingsStateFlow;
    }

    public final i1<m> getSpeakerVolStateFlow() {
        return this.speakerVolStateFlow;
    }

    public final d1<Boolean> getUpdateAmbientVolumeSharedFlow() {
        return this.updateAmbientVolumeSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_speakerVolStateFlow$p(SoundSettingsViewModel r0) {
        return r0._speakerVolStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_updateAmbientVolumeSharedFlow$p(SoundSettingsViewModel r0) {
        return r0._updateAmbientVolumeSharedFlow;
    }

    private final Object loadAmbientVolumeState(Continuation<? super Unit> r9) {
        if ((r9 instanceof C03041) == false) goto L7;
        C03041 r0 = (C03041) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r10);
    L47:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
    L42:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r10);
    L32:
        int r11 = ((Number) r10).intValue();
        if (r11 < 0) goto L43;
        z0<l> r5 = this._soundSettingsStateFlow;
        if (r11 == 1) goto L38;
        r4 = false;
    L38:
        l.c r6 = new l.c(r4);
        r0.label = 3;
        if (r5.emit(r6, r0) != r2) goto L42;
        return r2;
    L43:
        z0<l> r12 = this._soundSettingsStateFlow;
        l.a r7 = l.a.a;
        r0.label = 4;
        if (r12.emit(r7, r0) != r2) goto L47;
        return r2;
    L19:
        ResultKt.throwOnFailure(r10);
    L26:
        if (((Boolean) r10).booleanValue() == true) goto L28;
    L29:
        kj4.a r13 = kj4.a.g();
        r0.label = 2;
        r10 = DoraAdapterExtKt.l(r13);
        if (r10 != r2) goto L32;
        return r2;
    L28:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r10);
        Boolean r14 = resolveAmbientVolumeSwitch();
        if (r14 == null) goto L29;
        boolean r15 = r14.booleanValue();
        r0.label = 1;
        r10 = updateAmbientVolumeSwitchInternal(r15, false, false, r0);
        if (r10 != r2) goto L26;
        return r2;
    L7:
        r0 = new C03041(this, r9);
        goto L8
    }

    private final Object loadAntiSoundLeakState(Continuation<? super Unit> r12) {
        if ((r12 instanceof C03051) == false) goto L7;
        C03051 r0 = (C03051) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r3 = r0.I$0;
        ResultKt.throwOnFailure(r13);
    L35:
        int r14 = r3;
    L39:
        g49.d.d(TAG, "SoundSettingsViewModel.loadAntiSoundLeakState: " + r14);
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r13);
    L24:
        if (((Boolean) r13).booleanValue() == true) goto L26;
    L27:
        r14 = kj4.a.g().h();
        if (r14 == 0) goto L36;
        if (r14 != 1) goto L39;
        z0<com.larus.dora.impl.device.settings.sound.a> r4 = this._antiSoundLeakStateFlow;
        com.larus.dora.impl.device.settings.sound.a.b r5 = com.larus.dora.impl.device.settings.sound.a.b.a;
        r0.I$0 = r14;
        r0.label = 2;
        if (r4.emit(r5, r0) != r7) goto L34;
        return r7;
    L34:
        r3 = r14;
        goto L35
    L36:
        z0<com.larus.dora.impl.device.settings.sound.a> r6 = this._antiSoundLeakStateFlow;
        com.larus.dora.impl.device.settings.sound.a.C0056a r8 = com.larus.dora.impl.device.settings.sound.a.C0056a.a;
        r0.I$0 = r14;
        r0.label = 3;
        if (r6.emit(r8, r0) != r7) goto L34;
        return r7;
    L26:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r13);
        Boolean r15 = resolveAntiSoundLeakSwitch();
        if (r15 == null) goto L27;
        boolean r9 = r15.booleanValue();
        r0.label = 1;
        r13 = updateAntiSoundLeakSwitchInternal(r9, false, false, false, r0);
        if (r13 != r7) goto L24;
        return r7;
    L7:
        r0 = new C03051(this, r12);
        goto L8
    }

    public final void setAmbientVolumeSwitch(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03071(this, r7, null), 2, null);
    }

    public final void setAntiSoundLeakEnabled(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03081(this, r7, null), 2, null);
    }

    public final void updateAmbientVolumeEnabled(boolean r3) {
        this._soundSettingsStateFlow.setValue(new l.c(r3));
    }

    public static final /* synthetic */ Object access$loadAmbientVolumeState(SoundSettingsViewModel r0, Continuation r1) {
        return r0.loadAmbientVolumeState(r1);
    }

    public static final /* synthetic */ Object access$loadAntiSoundLeakState(SoundSettingsViewModel r0, Continuation r1) {
        return r0.loadAntiSoundLeakState(r1);
    }

    private final void reportAmbientVolumeSwitch(boolean r4, boolean r5) {
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        Pair[] r1 = new Pair[2];
        if (r4 == false) goto L5;
        String r6 = VALUE_ON;
    L6:
        r1[0] = TuplesKt.to(PARAM_SETTINGS_DETAIL, r6);
        r1[1] = TuplesKt.to(PARAM_IS_SUCCESS, Integer.valueOf(r5 ? 1 : 0));
        r0.L(EVENT_AMBIENT_VOLUME_SWITCH, MapsKt.mapOf(r1));
        return;
    L5:
        r6 = VALUE_OFF;
        goto L6
    }

    private final Object updateAmbientVolumeSwitchInternal(boolean r9, boolean r10, boolean r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof C03091) == false) goto L7;
        C03091 r0 = (C03091) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r14 = r0.I$0;
        boolean r15 = r0.Z$2;
        boolean r16 = r0.Z$1;
        boolean r5 = r0.Z$0;
        ResultKt.throwOnFailure(r13);
    L28:
        if (r16 == false) goto L32;
        String r17 = currentDeviceMac();
        if (r17 == null) goto L32;
        b0.a.getClass();
        b0.z(r17);
    L32:
        if (r15 == false) goto L38;
        DoraSystemInfoManager r18 = DoraSystemInfoManager.a;
        if (r5 == false) goto L36;
        String r110 = "1";
    L37:
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("adaptive_ambient_sound", r110)));
        reportAmbientVolumeSwitch(r5, true);
        goto L38
    L36:
        r110 = "0";
    L38:
        int r111 = r14;
    L41:
        if (r111 == 0) goto L44;
        r4 = true;
    L44:
        return Boxing.boxBoolean(r4);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r0.Z$2;
        r10 = r0.Z$1;
        r9 = r0.Z$0;
        ResultKt.throwOnFailure(r13);
    L20:
        if (((Number) r13).intValue() != 0) goto L22;
        r111 = 1;
    L23:
        if (r111 == 0) goto L39;
        z0<l> r6 = this._soundSettingsStateFlow;
        l.c r7 = new l.c(r9);
        r0.Z$0 = r9;
        r0.Z$1 = r10;
        r0.Z$2 = r11;
        r0.I$0 = r111;
        r0.label = 2;
        if (r6.emit(r7, r0) != r2) goto L27;
        return r2;
    L27:
        r5 = r9;
        r14 = r111;
        boolean r8 = r11;
        r16 = r10;
        r15 = r8;
        goto L28
    L39:
        if (r11 == false) goto L41;
        reportAmbientVolumeSwitch(r9, false);
        goto L41
    L22:
        r111 = 0;
        goto L23
    L16:
        ResultKt.throwOnFailure(r13);
        kj4.a r112 = kj4.a.g();
        r0.Z$0 = r9;
        r0.Z$1 = r10;
        r0.Z$2 = r11;
        r0.label = 1;
        r13 = DoraAdapterExtKt.H(r112, r9 ? 1 : 0);
        if (r13 != r2) goto L20;
        return r2;
    L7:
        r0 = new C03091(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object access$updateAmbientVolumeSwitchInternal(SoundSettingsViewModel r0, boolean r1, boolean r2, boolean r3, Continuation r4) {
        return r0.updateAmbientVolumeSwitchInternal(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [boolean] */
    private final Object updateAntiSoundLeakSwitchInternal(boolean r9, boolean r10, boolean r11, boolean r12, Continuation<? super Boolean> r13) {
        if ((r13 instanceof C03101) == false) goto L7;
        C03101 r0 = (C03101) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        int r15 = r0.I$1;
        int r16 = r0.I$0;
        boolean r17 = r0.Z$0;
        ResultKt.throwOnFailure(r14);
    L53:
        int r5 = r15;
        int r18 = r16;
        r9 = r17;
    L54:
        g49.d.d(TAG, "SoundSettingsViewModel.updateAntiSoundLeakSwitchInternal: ret=" + r18 + ", enable=" + r9);
        if (r5 == 0) goto L58;
        r4 = true;
    L58:
        return Boxing.boxBoolean(r4);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r20 = r0.I$1;
        int r110 = r0.I$0;
        r11 = r0.Z$1;
        boolean r111 = r0.Z$0;
        ResultKt.throwOnFailure(r14);
        ?? r112 = r111;
    L40:
        r5 = r20;
        r18 = r110;
        r9 = r112;
    L42:
        if (r11 == false) goto L54;
        DoraSystemInfoManager r113 = DoraSystemInfoManager.a;
        if (r9 == 0) goto L46;
        String r114 = "1";
    L47:
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("anti_sound_leak_mode", r114)));
        goto L54
    L46:
        r114 = "0";
        goto L47
    L17:
        r20 = r0.I$1;
        int r115 = r0.I$0;
        r12 = r0.Z$3;
        r11 = r0.Z$2;
        boolean r6 = r0.Z$1;
        boolean r7 = r0.Z$0;
        ResultKt.throwOnFailure(r14);
        r18 = r115;
        r10 = r6;
        ?? r8 = r7;
    L31:
        if (r10 == false) goto L35;
        String r116 = currentDeviceMac();
        if (r116 == null) goto L35;
        b0.a.getClass();
        b0.z(r116);
    L35:
        if (r12 == false) goto L41;
        MutableSharedFlow<com.larus.dora.impl.device.settings.sound.b> r117 = this._antiSoundLeakSwitchFlow;
        com.larus.dora.impl.device.settings.sound.b.C0057b r118 = new com.larus.dora.impl.device.settings.sound.b.C0057b(r8);
        r0.Z$0 = r8;
        r0.Z$1 = r11;
        r0.I$0 = r18;
        r0.I$1 = r20;
        r0.label = 2;
        if (r117.emit(r118, r0) != r2) goto L39;
        return r2;
    L39:
        r110 = r18;
        r112 = r8;
        goto L40
    L41:
        r5 = r20;
        r9 = r8;
        goto L42
    L18:
        ResultKt.throwOnFailure(r14);
        r18 = kj4.a.g().n(r9);
        if (r18 != 0) goto L21;
        r5 = 1;
    L22:
        if (r5 == 0) goto L48;
        z0<com.larus.dora.impl.device.settings.sound.a> r21 = this._antiSoundLeakStateFlow;
        if (r9 == 0) goto L26;
        Object r22 = com.larus.dora.impl.device.settings.sound.a.b.a;
    L27:
        r0.Z$0 = r9;
        r0.Z$1 = r10;
        r0.Z$2 = r11;
        r0.Z$3 = r12;
        r0.I$0 = r18;
        r0.I$1 = r5;
        r0.label = 1;
        if (r21.emit(r22, r0) != r2) goto L30;
        return r2;
    L30:
        r8 = r9 == true ? 1 : 0;
        r20 = r5;
        goto L31
    L26:
        r22 = com.larus.dora.impl.device.settings.sound.a.C0056a.a;
        goto L27
    L48:
        if (r12 == false) goto L54;
        MutableSharedFlow<com.larus.dora.impl.device.settings.sound.b> r119 = this._antiSoundLeakSwitchFlow;
        com.larus.dora.impl.device.settings.sound.b.a r120 = new com.larus.dora.impl.device.settings.sound.b.a(r9 == true ? 1 : 0, r18);
        r0.Z$0 = r9;
        r0.I$0 = r18;
        r0.I$1 = r5;
        r0.label = 3;
        if (r119.emit(r120, r0) != r2) goto L52;
        return r2;
    L52:
        r17 = r9 == true ? 1 : 0;
        r16 = r18;
        r15 = r5;
        goto L53
    L21:
        r5 = 0;
    L7:
        r0 = new C03101(this, r13);
        goto L8
    }

    public static final /* synthetic */ Object access$updateAntiSoundLeakSwitchInternal(SoundSettingsViewModel r0, boolean r1, boolean r2, boolean r3, boolean r4, Continuation r5) {
        return r0.updateAntiSoundLeakSwitchInternal(r1, r2, r3, r4, r5);
    }
}
