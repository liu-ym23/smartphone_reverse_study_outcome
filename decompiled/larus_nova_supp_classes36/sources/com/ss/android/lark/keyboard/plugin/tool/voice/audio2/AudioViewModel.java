package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.audio.voiceinput.CancelAsrTimeoutState;
import com.ss.android.lark.audio.voiceinput.VoiceInputConstants;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0013J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170!J\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000fJ\"\u0010%\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170!J\u0006\u0010&\u001a\u00020\u000fJ\u0014\u0010'\u001a\u00020\u00172\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)J\b\u0010*\u001a\u00020\u0017H\u0014J\u0014\u0010+\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170)J\u0016\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020\u0017J\u0006\u00102\u001a\u00020\u0017J\u0006\u00103\u001a\u00020\u0017J\u0006\u00104\u001a\u00020\u000fJ1\u00105\u001a\u00020\u0017\"\u0004\b\u0000\u001062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H60\b2\u0006\u00108\u001a\u0002H62\u0006\u00109\u001a\u00020:H\u0002¢\u0006\u0002\u0010;R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mEnabledFeatures", "", "Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;", "_currentFeature", "Landroidx/lifecycle/MutableLiveData;", "lastFeature", "getLastFeature", "()Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;", "setLastFeature", "(Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;)V", "_isAudioPluginSelected", "", "asrTimeOutChecker", "Lkotlinx/coroutines/Job;", "asrSessionState", "", "waitForLastAsrRequest", "Lkotlinx/coroutines/channels/Channel;", "initFeatures", "", "enableRecord", "enableRecognize", "enableWithText", "updateCurrentFeature", "featIndex", "addCurrentFeatureObserver", "owner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lkotlin/Function1;", "getCurrentFeature", "onAudioPluginSelectChange", "isSelect", "addAudioPluginSelectChangeObserver", "isAudioPluginSelected", "delayTriggerAsrTimeOut", "onAsrTimeOut", "Lkotlin/Function0;", "onCleared", "whenOnRecordTimeTooShort", "action", "cancelAsrTimeOut", "cancelAsrTimeoutState", "Lcom/ss/android/lark/audio/voiceinput/CancelAsrTimeoutState;", "hasAsrText", "onAsrLastRequest", "onAudioRecordStart", "triggerAsrSessionEnd", "isAsrSessionRunning", "updateMutableLiveData", "T", "data", "value", "dataName", "", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;Ljava/lang/String;)V", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioViewModel extends ViewModel {
    public static final int ASR_SESSION_END = 1003;
    public static final int ASR_SESSION_IDLE = 1000;
    public static final int ASR_SESSION_RECORDING = 1001;
    public static final int ASR_SESSION_WAIT_RECOGNIZING = 1002;
    public static final a Companion = null;
    private static final String TAG = "AudioViewModel";
    private final MutableLiveData<AudioPluginFeature> _currentFeature;
    private final MutableLiveData<Boolean> _isAudioPluginSelected;
    private int asrSessionState;
    private Job asrTimeOutChecker;
    private AudioPluginFeature lastFeature;
    private final List<AudioPluginFeature> mEnabledFeatures;
    private Channel<Boolean> waitForLastAsrRequest;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            Function1<Boolean, Unit> r0 = this.a;
            Intrinsics.checkNotNull(r3);
            r0.invoke(r3);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ Function1<AudioPluginFeature, Unit> a;

        public c(Function1<? super AudioPluginFeature, Unit> r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            AudioPluginFeature r3 = (AudioPluginFeature) r2;
            Function1<AudioPluginFeature, Unit> r0 = this.a;
            Intrinsics.checkNotNull(r3);
            r0.invoke(r3);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$delayTriggerAsrTimeOut$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$delayTriggerAsrTimeOut$1", f = "AudioViewModel.kt", i = {}, l = {119, 120}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onAsrTimeOut;
        int label;
        final /* synthetic */ AudioViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$delayTriggerAsrTimeOut$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$delayTriggerAsrTimeOut$1$1", f = "AudioViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $onAsrTimeOut;
            int label;
            final /* synthetic */ AudioViewModel this$0;

            public C01571(AudioViewModel r1, Function0<Unit> r2, Continuation<? super C01571> r3) {
                this.this$0 = r1;
                this.$onAsrTimeOut = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C01571(this.this$0, this.$onAsrTimeOut, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r2);
                if (this.this$0.isAsrSessionRunning() == false) goto L7;
                this.$onAsrTimeOut.invoke();
            L9:
                return Unit.INSTANCE;
            L7:
                Log.i(AudioViewModel.TAG, "delayTriggerAsrTimeOut cancel show toast by session end. " + AudioViewModel.access$getAsrSessionState$p(this.this$0));
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(AudioViewModel r1, Function0<Unit> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$onAsrTimeOut = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$onAsrTimeOut, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ResultKt.throwOnFailure(r7);     // Catch: Exception -> L19
        L22:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r7);     // Catch: Exception -> L19
        L16:
            MainCoroutineDispatcher r8 = Dispatchers.getMain().getImmediate();     // Catch: Exception -> L19
            C01571 r2 = new C01571(this.this$0, this.$onAsrTimeOut, null);     // Catch: Exception -> L19
            this.label = 2;     // Catch: Exception -> L19
            if (BuildersKt.withContext(r8, r2, this) != r0) goto L22;
            return r0;
        L12:
            ResultKt.throwOnFailure(r7);
            long r4 = ((Number) VoiceInputConstants.a.getValue()).longValue();     // Catch: Exception -> L19
            this.label = 1;     // Catch: Exception -> L19
            if (DelayKt.delay(r4, this) != r0) goto L16;
            return r0;
        L19:
            e = move-exception;
            Log.i(AudioViewModel.TAG, "delayTriggerAsrTimeOut / Exception" + e);
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$whenOnRecordTimeTooShort$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$whenOnRecordTimeTooShort$1", f = "AudioViewModel.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;
        final /* synthetic */ AudioViewModel this$0;

        public C04121(AudioViewModel r1, Function0<Unit> r2, Continuation<? super C04121> r3) {
            this.this$0 = r1;
            this.$action = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04121(this.this$0, this.$action, r4);
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
            Object r5 = ((kotlinx.coroutines.channels.g) r4).a;
        L11:
            kotlinx.coroutines.channels.g.c r2 = kotlinx.coroutines.channels.g.b;
            if ((!(r5 instanceof kotlinx.coroutines.channels.g.c)) == false) goto L19;
            Boolean r6 = (Boolean) kotlinx.coroutines.channels.g.b(r5);
            if (r6 == null) goto L19;
            Function0<Unit> r3 = this.$action;
            if (r6.booleanValue() == true) goto L19;
            r3.invoke();
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Channel r7 = AudioViewModel.access$getWaitForLastAsrRequest$p(this.this$0);
            this.label = 1;
            r5 = r7.receiveCatching-JP2dKIU(this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public final AudioPluginFeature getCurrentFeature() {
        AudioPluginFeature r0 = (AudioPluginFeature) this._currentFeature.getValue();
        if (r0 != null) goto L6;
        Log.w(TAG, "getCurrentFeature / _currentFeature.value is null");
        return (AudioPluginFeature) ListProtector.get(this.mEnabledFeatures, 0);
    L6:
        return r0;
    }

    public final boolean isAsrSessionRunning() {
        int r0 = this.asrSessionState;
        boolean r2 = true;
        if (r0 == 1000) goto L5;
        boolean r1 = true;
    L7:
        if (r0 != 1003) goto L11;
        r2 = false;
    L11:
        return r1 & r2;
    L5:
        r1 = false;
        goto L7
    }

    public final boolean isAudioPluginSelected() {
        return Intrinsics.areEqual(this._isAudioPluginSelected.getValue(), Boolean.TRUE);
    }

    public final void onAsrLastRequest() {
        this.asrSessionState = ASR_SESSION_WAIT_RECOGNIZING;
    }

    public final void onAudioRecordStart() {
        this.asrSessionState = ASR_SESSION_RECORDING;
    }

    public void onCleared() {
        cancelAsrTimeOut(CancelAsrTimeoutState.CancelByCleared, false);
    }

    public final void triggerAsrSessionEnd() {
        this.asrSessionState = ASR_SESSION_END;
    }

    public AudioViewModel() {
        this.mEnabledFeatures = new ArrayList();
        this._currentFeature = new MutableLiveData();
        this._isAudioPluginSelected = new MutableLiveData();
        this.asrSessionState = ASR_SESSION_IDLE;
        this.waitForLastAsrRequest = ChannelKt.Channel$default(0, null, null, 7, null);
    }

    public final AudioPluginFeature getLastFeature() {
        return this.lastFeature;
    }

    public static final /* synthetic */ int access$getAsrSessionState$p(AudioViewModel r0) {
        return r0.asrSessionState;
    }

    public static final /* synthetic */ Channel access$getWaitForLastAsrRequest$p(AudioViewModel r0) {
        return r0.waitForLastAsrRequest;
    }

    public final void delayTriggerAsrTimeOut(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "onAsrTimeOut");
        Job r0 = this.asrTimeOutChecker;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.asrTimeOutChecker = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r10, null), 2, null);
    }

    public final void onAudioPluginSelectChange(boolean r3) {
        updateMutableLiveData(this._isAudioPluginSelected, Boolean.valueOf(r3), "isAudioPluginSelected");
    }

    public final void setLastFeature(AudioPluginFeature r1) {
        this.lastFeature = r1;
    }

    public final void updateCurrentFeature(int r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        Log.e(TAG, "setFeature / featIndex out of range");
        AudioPluginFeature r4 = (AudioPluginFeature) ListProtector.get(this.mEnabledFeatures, 0);
    L11:
        this.lastFeature = (AudioPluginFeature) this._currentFeature.getValue();
        updateMutableLiveData(this._currentFeature, r4, "currentFeature");
        return;
    L10:
        r4 = (AudioPluginFeature) ListProtector.get(this.mEnabledFeatures, r3);
        goto L11
    L5:
        if (r3 >= this.mEnabledFeatures.size()) goto L7;
        r1 = true;
        goto L8
    }

    public final void whenOnRecordTimeTooShort(Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "action");
        if (this._currentFeature.getValue() != AudioPluginFeature.RECOGNIZE) goto L5;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04121(this, r9, null), 3, null);
        return;
    L5:
        r9.invoke();
    }

    public final void addAudioPluginSelectChangeObserver(LifecycleOwner r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this._isAudioPluginSelected.observe(r3, new b(r4));
    }

    public final void addCurrentFeatureObserver(LifecycleOwner r3, Function1<? super AudioPluginFeature, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this._currentFeature.observe(r3, new c(r4));
    }

    public final void cancelAsrTimeOut(CancelAsrTimeoutState r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "cancelAsrTimeoutState");
        Job r0 = this.asrTimeOutChecker;
        if (r0 == null) goto L7;
        Log.i(TAG, "cancelAsrTimeOut by " + r9.info());
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        if (KeyboardVoiceFGUtils.h() == true) goto L7;
        String r1 = fwa.a.a;
        fwa.a.a(false, r9.info());
    L7:
        this.asrTimeOutChecker = null;
        this.asrSessionState = ASR_SESSION_END;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L10
        Result.constructor-impl(BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AudioViewModel$cancelAsrTimeOut$2$1(this, r10, null), 3, null));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    private final <T> void updateMutableLiveData(MutableLiveData<T> r6, T r7, String r8) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L7;
        Log.i(TAG, "updateMutableLiveData / Data: " + r8 + ", origin value: " + r6.getValue() + ", new value: " + r7);
        if (Intrinsics.areEqual(r6.getValue(), r7) == true) goto L9;
        r6.setValue(r7);
        return;
    L9:
        return;
    L7:
        Log.w(TAG, "updateMutableLiveData / Not in main looper, data: " + r8 + ", origin value: " + r6.getValue() + ", new value: " + r7);
        r6.postValue(r7);
    }

    public final void initFeatures(boolean r2, boolean r3, boolean r4) {
        if (r4 == false) goto L4;
        this.mEnabledFeatures.add(AudioPluginFeature.WITH_TEXT);
    L4:
        if (r2 == false) goto L6;
        this.mEnabledFeatures.add(AudioPluginFeature.RECORD);
    L6:
        if (r3 == false) goto L9;
        this.mEnabledFeatures.add(AudioPluginFeature.RECOGNIZE);
    L9:
        if (this.mEnabledFeatures.size() != 0) goto L11;
        Log.e(TAG, "initFeatures / No feature enabled");
        this.mEnabledFeatures.add(AudioPluginFeature.RECORD);
    L11:
        AudioPluginFeature.a r5 = AudioPluginFeature.Companion;
        int r6 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        int r7 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.e();
        r5.getClass();
        AudioPluginFeature r8 = AudioPluginFeature.WITH_TEXT;
        if (r7 == r8.getIndex()) goto L21;
        r8 = AudioPluginFeature.RECORD;
        if (r7 == r8.getIndex()) goto L21;
        AudioPluginFeature r9 = AudioPluginFeature.RECOGNIZE;
        if (r7 != r9.getIndex()) goto L21;
        r8 = r9;
    L21:
        if (this.mEnabledFeatures.contains(r8) == true) goto L23;
        updateCurrentFeature(0);
        return;
    L23:
        updateMutableLiveData(this._currentFeature, r8, "currentFeature");
    }

    public static /* synthetic */ void initFeatures$default(AudioViewModel r1, boolean r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        r1.initFeatures(r2, r3, r4);
    }
}
