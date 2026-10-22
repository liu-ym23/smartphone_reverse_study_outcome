package com.larus.dora.impl.onboarding.lite;

import android.content.res.AssetFileDescriptor;
import android.media.SoundPool;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.OnboardingAvatarProvider;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n*\u0003CFh\u0018\u0000 {2\u00020\u0001:\u0001{B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010JJ\f\u0010K\u001a\u00020\u0016*\u000203H\u0002J \u0010L\u001a\u00020M2\u0006\u0010N\u001a\u0002032\u000e\b\u0002\u0010O\u001a\b\u0012\u0004\u0012\u00020M0PH\u0002J\b\u0010Q\u001a\u00020MH\u0002J\u0006\u0010R\u001a\u00020MJ\u0006\u0010S\u001a\u00020MJ\u0006\u0010T\u001a\u00020MJ\u0006\u0010U\u001a\u00020MJ\u0006\u0010V\u001a\u00020MJ\u0006\u0010W\u001a\u00020MJ\u0006\u0010X\u001a\u00020MJ\u0006\u0010Y\u001a\u00020MJ\u0006\u0010Z\u001a\u00020MJ\u0006\u0010[\u001a\u00020MJ\u0006\u0010\\\u001a\u00020\u000eJ\u0006\u0010]\u001a\u00020MJ\u0006\u0010^\u001a\u00020MJ\u0006\u0010_\u001a\u00020MJ\u0006\u0010`\u001a\u00020MJ\u0006\u0010a\u001a\u00020MJ\u000e\u0010b\u001a\u00020M2\u0006\u0010c\u001a\u000203J\b\u0010j\u001a\u00020MH\u0002J\b\u0010k\u001a\u00020MH\u0002J\u0010\u0010l\u001a\u00020M2\u0006\u0010m\u001a\u00020\u0016H\u0002J\u000e\u0010n\u001a\u00020M2\u0006\u0010o\u001a\u00020\u0016J\u0010\u0010p\u001a\u00020M2\u0006\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u00020MH\u0002J\u0010\u0010t\u001a\u00020M2\u0006\u0010o\u001a\u00020\u0016H\u0002J\u0010\u0010u\u001a\u00020M2\u0006\u0010v\u001a\u000203H\u0002J\u000e\u0010w\u001a\u00020M2\u0006\u0010v\u001a\u000203J\b\u0010x\u001a\u00020MH\u0014J\u000e\u0010y\u001a\u00020M2\u0006\u0010z\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R#\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b/\u00100R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\fR\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010GR\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001b0eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0004\n\u0002\u0010i¨\u0006|"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseViewModel;", "<init>", "()V", "vuiModeDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "_wakeupQueryUiStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/onboarding/lite/WakeupQueryUiState;", "wakeupQueryUiStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getWakeupQueryUiStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_queryStateFlow", "", "queryStateFlow", "getQueryStateFlow", "_avatarUiStateFlow", "Lcom/larus/dora/impl/onboarding/lite/AvatarUiState;", "avatarUiStateFlow", "getAvatarUiStateFlow", "_avatarUrlFlow", "", "avatarUrlFlow", "getAvatarUrlFlow", "_ttsDataSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "ttsDataSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getTtsDataSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_isDoraSupportOnboarding", "Ljava/lang/Boolean;", "onboardingTTSList", "", "getOnboardingTTSList", "()Ljava/util/List;", "onboardingTTSList$delegate", "Lkotlin/Lazy;", "isOpeningRemarksTTSPlayed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isWakeupTTSPlayed", "isRadioTTSPlayed", "isQueryStopTeachTTSPlayed", "avatarFetchJob", "Lkotlinx/coroutines/Job;", "isOnboardingNoSkip", "()Z", "isOnboardingNoSkip$delegate", "currentVuiMode", "", "player", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBgMusicPlayer;", "soundPool", "Landroid/media/SoundPool;", "soundId", "Ljava/lang/Integer;", "mediaManager", "Lcom/larus/call_plugins_doubao_common/manager/DoraRealtimeCallMediaManager;", "_isMusicPlayingStateFlow", "isMusicPlayingStateFlow", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "doraVoiceCallback", "com/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel$doraVoiceCallback$1", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel$doraVoiceCallback$1;", "globalAudioObserveCallback", "com/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel$globalAudioObserveCallback$1", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel$globalAudioObserveCallback$1;", "isDoraSupportOnboarding", "caller", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vuiText", "setVUIMode", "", "mode", "onSuccess", "Lkotlin/Function0;", "enterOnboardingMode", "enterKeyOnlyMode", "enterVoiceOnlyMode", "enterRadioOnlyMode", "enterKeyLongPressOnlyMode", "exitOnboardingMode", "registerDoraCallback", "unregisterDoraCallback", "fetchAvatarUrl", "playBackgroundMusic", "stopBackgroundMusic", "isBackgroundMusicPlaying", "loadKeyEventSoundEffect", "playKeyEventSoundEffect", "releaseSoundPool", "playOpeningRemarksTTS", "playWakeupTTS", "playRadioTTS", "ttsResId", "ttsDataCacheList", "", "ttsDataLoopJob", "dlayerCallback", "com/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel$dlayerCallback$1", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel$dlayerCallback$1;", "onTTSPlayEnd", "loopTTSData", "playTTS", "ttsText", "stopTTS", "reason", "handleMusicPlayModel", "musicModel", "Lcom/larus/avlink/model/DoraOnboardingMusicModel;", "addSamiListener", "removeSamiListener", "playQueryStopTeachTTS", "queryStopTtsResId", "gotoQueryMusicStopTeachStateIfNecessary", "onCleared", "realDoCleared", "from", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingViewModel extends DoraOnboardingBaseViewModel {
    private static final a Companion = null;
    private static final String TAG = "DoraOnboardingViewModel";
    private final z0<AvatarUiState> _avatarUiStateFlow;
    private final z0<String> _avatarUrlFlow;
    private Boolean _isDoraSupportOnboarding;
    private z0<Boolean> _isMusicPlayingStateFlow;
    private final z0<Boolean> _queryStateFlow;
    private final MutableSharedFlow<byte[]> _ttsDataSharedFlow;
    private final z0<y0> _wakeupQueryUiStateFlow;
    private Job avatarFetchJob;
    private final i1<AvatarUiState> avatarUiStateFlow;
    private final i1<String> avatarUrlFlow;
    private int currentVuiMode;
    private final DoraLiteOnboardingViewModel$dlayerCallback$1 dlayerCallback;
    private final DoraLiteOnboardingViewModel$doraVoiceCallback$1 doraVoiceCallback;
    private final b globalAudioObserveCallback;
    private final i1<Boolean> isMusicPlayingStateFlow;
    private final Lazy isOnboardingNoSkip$delegate;
    private AtomicBoolean isOpeningRemarksTTSPlayed;
    private AtomicBoolean isQueryStopTeachTTSPlayed;
    private AtomicBoolean isRadioTTSPlayed;
    private AtomicBoolean isWakeupTTSPlayed;
    private com.larus.call_plugins_doubao_common.manager.r mediaManager;
    private final kotlinx.coroutines.sync.a mutex;
    private final Lazy onboardingTTSList$delegate;
    private com.larus.dora.impl.onboarding.r player;
    private final i1<Boolean> queryStateFlow;
    private Integer soundId;
    private SoundPool soundPool;
    private final List<byte[]> ttsDataCacheList;
    private Job ttsDataLoopJob;
    private final d1<byte[]> ttsDataSharedFlow;
    private final ExecutorCoroutineDispatcher vuiModeDispatcher;
    private final i1<y0> wakeupQueryUiStateFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements o78.b {
        public final /* synthetic */ DoraLiteOnboardingViewModel a;

        public b(DoraLiteOnboardingViewModel r1) {
            this.a = r1;
        }

        public final void c(String r1, Map r2) {
            o78.b.a.a(r1);
        }

        public final void a(String r2, GlobalAudioStateEnum r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "playbackState");
            g49.d.d(DoraLiteOnboardingViewModel.TAG, "onPlaybackStateChanged: scene=" + r2 + ", playbackState=" + r3);
            z0 r5 = DoraLiteOnboardingViewModel.access$get_isMusicPlayingStateFlow$p(this.a);
            if (r3 != GlobalAudioStateEnum.PLAYING) goto L5;
            boolean r6 = true;
        L6:
            r5.tryEmit(Boolean.valueOf(r6));
            return;
        L5:
            r6 = false;
            goto L6
        }

        public final void b(String r3, Integer r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r3, "scene");
            g49.d.d(DoraLiteOnboardingViewModel.TAG, "onError: scene=" + r3 + ", code=" + r4 + ", internalCode=" + r5);
        }

        public final void d(String r1, String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "scene");
            Intrinsics.checkNotNullParameter(r2, "uniId");
            g49.d.d(DoraLiteOnboardingViewModel.TAG, "onPlayTriggered: scene=" + r1);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$exitOnboardingMode$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$exitOnboardingMode$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {362, 363}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public AnonymousClass1(DoraLiteOnboardingViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L18:
            boolean r6 = ((Boolean) r5).booleanValue();
            g49.d.d(DoraLiteOnboardingViewModel.TAG, "STOP_VUIStopMode_STOP_ONBOARDING: " + r6);
            if (r6 == false) goto L22;
            DoraLiteOnboardingViewModel.access$setCurrentVuiMode$p(this.this$0, -1);
            boolean r7 = com.larus.dora.impl.onboarding.d.a;
            com.larus.dora.impl.onboarding.d.b = false;
        L22:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L14:
            if (((Boolean) r5).booleanValue() == false) goto L22;
            kj4.a r8 = kj4.a.g();
            this.label = 2;
            r5 = DoraAdapterExtKt.O(r8, 5);
            if (r5 != r0) goto L18;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            DoraLiteOnboardingViewModel r9 = this.this$0;
            this.label = 1;
            r5 = r9.isDoraSupportOnboarding("exitOnboardingMode", this);
            if (r5 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$fetchAvatarUrl$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$fetchAvatarUrl$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04021(DoraLiteOnboardingViewModel r1, Continuation<? super C04021> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04021(this.this$0, r3);
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
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            String r5 = (String) r4;
            if (r5 != null) goto L14;
        L17:
            if (r2 == true) goto L19;
            DoraLiteOnboardingViewModel.access$get_avatarUrlFlow$p(this.this$0).setValue(r5);
        L19:
            DoraLiteOnboardingViewModel.access$setAvatarFetchJob$p(this.this$0, null);
            return Unit.INSTANCE;
        L14:
            if (r5.length() == 0) goto L17;
            r2 = false;
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            OnboardingAvatarProvider r6 = OnboardingAvatarProvider.a;
            this.label = 1;
            r4 = r6.a(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$isDoraSupportOnboarding$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel", f = "DoraLiteOnboardingViewModel.kt", i = {0, 0, 1, 1}, l = {773, 289}, m = "isDoraSupportOnboarding", n = {"caller", "$this$withLock_u24default$iv", "caller", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C04031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04031(DoraLiteOnboardingViewModel r1, Continuation<? super C04031> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.isDoraSupportOnboarding(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$loadKeyEventSoundEffect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$loadKeyEventSoundEffect$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04041(DoraLiteOnboardingViewModel r1, Continuation<? super C04041> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04041(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r6);
            DoraLiteOnboardingViewModel r7 = this.this$0;
            long r0 = System.currentTimeMillis();
            DoraLiteOnboardingViewModel.access$setSoundPool$p(r7, new SoundPool.Builder().build());
            AssetFileDescriptor r2 = AppHost.a.getApplication().getAssets().openFd("dora_onboarding_opt_success.mp3");
            SoundPool r3 = DoraLiteOnboardingViewModel.access$getSoundPool$p(r7);
            if (r3 == null) goto L7;
            Integer r4 = Boxing.boxInt(r3.load(r2, 1));
        L8:
            DoraLiteOnboardingViewModel.access$setSoundId$p(r7, r4);
            g49.d.d(DoraLiteOnboardingViewModel.TAG, "loadKeyEventSoundEffect: soundId=" + DoraLiteOnboardingViewModel.access$getSoundId$p(this.this$0) + ", consumeTime=" + (System.currentTimeMillis() - r0));
            return Unit.INSTANCE;
        L7:
            r4 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$loopTTSData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$loopTTSData$1", f = "DoraLiteOnboardingViewModel.kt", i = {0, 0, 1, 1}, l = {575, 578}, m = "invokeSuspend", n = {"$this$launch", "i", "$this$launch", "i"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class C04051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04051(DoraLiteOnboardingViewModel r1, Continuation<? super C04051> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04051 r0 = new C04051(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0062 -> B:35:0x0081). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:35:0x0081). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            int r2 = this.I$0;
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
            C04051 r11 = this;
        L35:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
            CoroutineScope r8 = r4;
            C04051 r5 = r11;
            CoroutineScope r12 = r8;
        L32:
            r2 = r2 + 1;
        L16:
            if (r2 >= 1001) goto L34;
            r5.L$0 = r12;
            r5.I$0 = r2;
            r5.label = 1;
            if (DelayKt.delay(60, r5) != r0) goto L20;
            return r0;
        L20:
            C04051 r9 = r5;
            r4 = r12;
            r11 = r9;
        L21:
            DoraLiteOnboardingViewModel r6 = r11.this$0;
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L29
            if ((!DoraLiteOnboardingViewModel.access$getTtsDataCacheList$p(r6).isEmpty()) == false) goto L35;
            MutableSharedFlow r13 = DoraLiteOnboardingViewModel.access$get_ttsDataSharedFlow$p(r6);     // Catch: Throwable -> L29
            Object r14 = CollectionsKt.random(DoraLiteOnboardingViewModel.access$getTtsDataCacheList$p(r6), Random.Default);     // Catch: Throwable -> L29
            r11.L$0 = r4;     // Catch: Throwable -> L29
            r11.I$0 = r2;     // Catch: Throwable -> L29
            r11.label = 2;     // Catch: Throwable -> L29
            if (r13.emit(r14, r11) != r0) goto L35;
            return r0;
        L34:
            return Unit.INSTANCE;
        L29:
            th = move-exception;
            Object r15 = r0;
            C04051 r3 = r11;
            Throwable th = th;
            CoroutineScope r16 = r4;
            int r17 = r2;
            Object r18 = r15;
        L31:
            Result.Companion r20 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            r12 = r16;
            int r21 = r17;
            r5 = r3;
            r0 = r18;
            r2 = r21;
        L9:
            th = th;
            r16 = r4;
            r17 = r2;
            r18 = r0;
            r3 = this;
            goto L31
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            r2 = this.I$0;
            r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            r11 = this;
            goto L21
        L14:
            ResultKt.throwOnFailure(r10);
            r12 = (CoroutineScope) this.L$0;
            r2 = 0;
            r5 = this;
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playBackgroundMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playBackgroundMusic$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04061(DoraLiteOnboardingViewModel r1, Continuation<? super C04061> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04061(this.this$0, r3);
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
            if (((Boolean) r5).booleanValue() == false) goto L25;
            g49.d.d(DoraLiteOnboardingViewModel.TAG, "playBackgroundMusic");
            if (DoraLiteOnboardingViewModel.access$getPlayer$p(this.this$0) == null) goto L21;
            com.larus.dora.impl.onboarding.r r6 = DoraLiteOnboardingViewModel.access$getPlayer$p(this.this$0);
            if (r6 == null) goto L18;
            int r2 = com.larus.dora.impl.onboarding.r.h;
            r6.d(null);
        L18:
            com.larus.dora.impl.onboarding.r r7 = DoraLiteOnboardingViewModel.access$getPlayer$p(this.this$0);
            if (r7 == null) goto L21;
            r7.b();
        L21:
            DoraLiteOnboardingViewModel.access$setPlayer$p(this.this$0, new com.larus.dora.impl.onboarding.r());
            com.larus.dora.impl.onboarding.r r8 = DoraLiteOnboardingViewModel.access$getPlayer$p(this.this$0);
            if (r8 == null) goto L25;
            com.larus.dora.impl.onboarding.r.c(r8, AppHost.a.getApplication());
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DoraLiteOnboardingViewModel r9 = this.this$0;
            this.label = 1;
            r5 = r9.isDoraSupportOnboarding("playBackgroundMusic", this);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playOpeningRemarksTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playOpeningRemarksTTS$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {458}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04071(DoraLiteOnboardingViewModel r1, Continuation<? super C04071> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04071(this.this$0, r3);
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
            boolean r2 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L13:
            List r8 = DoraLiteOnboardingViewModel.access$getOnboardingTTSList(this.this$0);
            if (r8 == null) goto L16;
            String r9 = (String) CollectionsKt.getOrNull(r8, 0);
        L17:
            if (r9 != null) goto L19;
        L20:
            r2 = true;
        L21:
            if (r2 == false) goto L23;
            int r10 = com.larus.utils.j0.a;
            r9 = com.larus.utils.j0.d(2131903748);
        L23:
            DoraLiteOnboardingViewModel.access$playTTS(this.this$0, r9);
        L25:
            return Unit.INSTANCE;
        L19:
            if (r9.length() != 0) goto L21;
        L16:
            r9 = null;
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            if (DoraLiteOnboardingViewModel.access$isOpeningRemarksTTSPlayed$p(this.this$0).compareAndSet(false, true) == false) goto L25;
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playQueryStopTeachTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playQueryStopTeachTTS$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $queryStopTtsResId;
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04081(DoraLiteOnboardingViewModel r1, int r2, Continuation<? super C04081> r3) {
            this.this$0 = r1;
            this.$queryStopTtsResId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04081(this.this$0, this.$queryStopTtsResId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r4);
            boolean r0 = false;
            if (DoraLiteOnboardingViewModel.access$isQueryStopTeachTTSPlayed$p(this.this$0).compareAndSet(false, true) == false) goto L18;
            List r5 = DoraLiteOnboardingViewModel.access$getOnboardingTTSList(this.this$0);
            if (r5 == null) goto L9;
            String r6 = (String) CollectionsKt.getOrNull(r5, 3);
        L10:
            if (r6 != null) goto L12;
        L13:
            r0 = true;
        L14:
            if (r0 == false) goto L16;
            int r7 = com.larus.utils.j0.a;
            r6 = com.larus.utils.j0.d(this.$queryStopTtsResId);
        L16:
            DoraLiteOnboardingViewModel.access$playTTS(this.this$0, r6);
            goto L18
        L12:
            if (r6.length() != 0) goto L14;
        L9:
            r6 = null;
        L18:
            return Unit.INSTANCE;
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playRadioTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playRadioTTS$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $ttsResId;
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04091(DoraLiteOnboardingViewModel r1, int r2, Continuation<? super C04091> r3) {
            this.this$0 = r1;
            this.$ttsResId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04091(this.this$0, this.$ttsResId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r4);
            boolean r0 = false;
            if (DoraLiteOnboardingViewModel.access$isRadioTTSPlayed$p(this.this$0).compareAndSet(false, true) == false) goto L18;
            List r5 = DoraLiteOnboardingViewModel.access$getOnboardingTTSList(this.this$0);
            if (r5 == null) goto L9;
            String r6 = (String) CollectionsKt.getOrNull(r5, 2);
        L10:
            if (r6 != null) goto L12;
        L13:
            r0 = true;
        L14:
            if (r0 == false) goto L16;
            int r7 = com.larus.utils.j0.a;
            r6 = com.larus.utils.j0.d(this.$ttsResId);
        L16:
            DoraLiteOnboardingViewModel.access$playTTS(this.this$0, r6);
            goto L18
        L12:
            if (r6.length() != 0) goto L14;
        L9:
            r6 = null;
        L18:
            return Unit.INSTANCE;
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playWakeupTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$playWakeupTTS$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public C04101(DoraLiteOnboardingViewModel r1, Continuation<? super C04101> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04101(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r4);
            boolean r0 = false;
            if (DoraLiteOnboardingViewModel.access$isWakeupTTSPlayed$p(this.this$0).compareAndSet(false, true) == false) goto L18;
            List r5 = DoraLiteOnboardingViewModel.access$getOnboardingTTSList(this.this$0);
            if (r5 == null) goto L9;
            String r6 = (String) CollectionsKt.getOrNull(r5, 1);
        L10:
            if (r6 != null) goto L12;
        L13:
            r0 = true;
        L14:
            if (r0 == false) goto L16;
            int r7 = com.larus.utils.j0.a;
            r6 = com.larus.utils.j0.d(2131903749);
        L16:
            DoraLiteOnboardingViewModel.access$playTTS(this.this$0, r6);
            goto L18
        L12:
            if (r6.length() != 0) goto L14;
        L9:
            r6 = null;
        L18:
            return Unit.INSTANCE;
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$setVUIMode$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$setVUIMode$2", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {318, 323}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $mode;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ DoraLiteOnboardingViewModel this$0;

        public AnonymousClass2(DoraLiteOnboardingViewModel r1, int r2, Function0<Unit> r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$mode = r2;
            this.$onSuccess = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.$mode, this.$onSuccess, r5);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L22:
            boolean r10 = ((Boolean) r9).booleanValue();
            g49.d.d(DoraLiteOnboardingViewModel.TAG, "START_" + DoraLiteOnboardingViewModel.access$vuiText(this.this$0, this.$mode) + ": result=" + r10);
            if (r10 == false) goto L26;
            DoraLiteOnboardingViewModel.access$setCurrentVuiMode$p(this.this$0, this.$mode);
            this.$onSuccess.invoke();
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
        L14:
            if (((Boolean) r9).booleanValue() == false) goto L26;
            if (DoraLiteOnboardingViewModel.access$getCurrentVuiMode$p(this.this$0) != this.$mode) goto L19;
            g49.d.d(DoraLiteOnboardingViewModel.TAG, "START_" + DoraLiteOnboardingViewModel.access$vuiText(this.this$0, this.$mode) + ", already in " + DoraLiteOnboardingViewModel.access$vuiText(this.this$0, this.$mode));
            return Unit.INSTANCE;
        L19:
            kj4.a r11 = kj4.a.g();
            int r2 = this.$mode;
            this.label = 2;
            r9 = DoraAdapterExtKt.L(r11, r2);
            if (r9 != r0) goto L22;
            return r0;
        L10:
            ResultKt.throwOnFailure(r9);
            DoraLiteOnboardingViewModel r12 = this.this$0;
            String r3 = "START_" + DoraLiteOnboardingViewModel.access$vuiText(this.this$0, this.$mode);
            this.label = 1;
            r9 = r12.isDoraSupportOnboarding(r3, this);
            if (r9 != r0) goto L14;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit No() {
        return setVUIMode$lambda$5();
    }

    public static /* synthetic */ Unit Oo() {
        return enterOnboardingMode$lambda$6();
    }

    public static /* synthetic */ List Po() {
        return onboardingTTSList_delegate$lambda$1();
    }

    public static /* synthetic */ boolean Qo() {
        return isOnboardingNoSkip_delegate$lambda$2();
    }

    public static /* synthetic */ Unit So(DoraLiteOnboardingViewModel r0, z98.f r1) {
        return addSamiListener$lambda$13(r0, r1);
    }

    public static /* synthetic */ Thread To(Runnable r0) {
        return vuiModeDispatcher$lambda$0(r0);
    }

    public static /* synthetic */ Unit Wo(DoraLiteOnboardingViewModel r0) {
        return stopBackgroundMusic$lambda$7(r0);
    }

    private final String vuiText(int r2) {
        if (r2 != 4) goto L5;
        return "VUIMode_START_ONBOARDING";
    L5:
        if (r2 != 5) goto L7;
        return "VUIMode_KEY_ONLY";
    L7:
        if (r2 != 6) goto L9;
        return "VUIMode_VOICE_ONLY";
    L9:
        if (r2 == 7) goto L11;
        return "VUIMode_UNKNOWN";
    L11:
        return "VUIMode_RADIO_ONLY";
    }

    public final void enterKeyOnlyMode() {
        setVUIMode$default(this, 5, null, 2, null);
    }

    private final void addSamiListener() {
        com.larus.dora.impl.onboarding.d.b(new z(this));
    }

    private final void enterOnboardingMode() {
        setVUIMode(4, new d0());
    }

    private static final Unit enterOnboardingMode$lambda$6() {
        boolean r0 = com.larus.dora.impl.onboarding.d.a;
        com.larus.dora.impl.onboarding.d.b = true;
        return Unit.INSTANCE;
    }

    private final List<String> getOnboardingTTSList() {
        return (List) this.onboardingTTSList$delegate.getValue();
    }

    private static final boolean isOnboardingNoSkip_delegate$lambda$2() {
        DoraSetting.a.getClass();
        int r0 = com.larus.utils.l0.a;
        boolean r1 = ((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new com.larus.dora.impl.settings.i())).booleanValue();
        g49.d.d(TAG, "isOnboardingNoSkip=" + r1);
        return r1;
    }

    private final void loopTTSData() {
        Job r0 = this.ttsDataLoopJob;
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.isActive() != true) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L12;
        Job r2 = this.ttsDataLoopJob;
        if (r2 == null) goto L12;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L12:
        this.ttsDataLoopJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04051(this, null), 3, null);
    }

    private final void onTTSPlayEnd() {
        this.ttsDataCacheList.clear();
        Job r0 = this.ttsDataLoopJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this._avatarUiStateFlow.tryEmit(AvatarUiState.WAITING);
        z0<y0> r1 = this._wakeupQueryUiStateFlow;
    L6:
        Object r2 = r1.getValue();
        Object r3 = (y0) r2;
        if ((r3 instanceof y0.d) == false) goto L10;
        r3 = new y0.d(true);
    L13:
        if (r1.compareAndSet(r2, r3) == false) goto L6;
        return;
    L10:
        if ((r3 instanceof y0.g) == false) goto L13;
        r3 = new y0.g(true);
        goto L13
    }

    private static final List onboardingTTSList_delegate$lambda$1() {
        Lazy r0 = f69.b.a;
        DoraSetting.a.getClass();
        if (DoraSetting.h() == false) goto L5;
        g49.d.d("DoraOnboardingResHelper", "getOnboardingTTSList enableNewOnboarding is true");
        int r1 = com.larus.utils.l0.a;
        List r2 = (List) com.larus.utils.l0.a(CollectionsKt.emptyList(), new com.larus.dora.impl.settings.q0());
    L6:
        g49.d.d("DoraOnboardingResHelper", "getOnboardingTTSList list is " + r2);
        return r2;
    L5:
        g49.d.d("DoraOnboardingResHelper", "getOnboardingTTSList enableNewOnboarding is false");
        r2 = CollectionsKt.emptyList();
        goto L6
    }

    public final void enterKeyLongPressOnlyMode() {
        removeSamiListener("enterKeyLongPressOnlyMode");
        stopTTS("enterKeyLongPressOnlyMode");
        setVUIMode$default(this, 11, null, 2, null);
    }

    public final void enterRadioOnlyMode() {
        removeSamiListener("enterRadioOnlyMode");
        stopTTS("enterRadioOnlyMode");
        setVUIMode$default(this, 7, null, 2, null);
    }

    public final void exitOnboardingMode() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.vuiModeDispatcher, null, new AnonymousClass1(this, null), 2, null);
    }

    public final void fetchAvatarUrl() {
        OnboardingAvatarProvider r0 = OnboardingAvatarProvider.a;
        String r1 = OnboardingAvatarProvider.c;
        if (r1 != null) goto L5;
        r1 = (String) this._avatarUrlFlow.getValue();
    L5:
        boolean r2 = false;
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        Job r4 = this.avatarFetchJob;
        if (r4 != null) goto L20;
    L22:
        if (r2 == false) goto L24;
        return;
    L24:
        this.avatarFetchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04021(this, null), 2, null);
        return;
    L20:
        if (r4.isActive() != true) goto L22;
        r2 = true;
        goto L22
    L14:
        if (Intrinsics.areEqual(this._avatarUrlFlow.getValue(), r1) == true) goto L26;
        this._avatarUrlFlow.setValue(r1);
        return;
    L26:
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public final boolean isBackgroundMusicPlaying() {
        if (this.player == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOnboardingNoSkip() {
        return ((Boolean) this.isOnboardingNoSkip$delegate.getValue()).booleanValue();
    }

    public final void playKeyEventSoundEffect() {
        g49.d.d(TAG, "playKeyEventSoundEffect");
        Integer r0 = this.soundId;
        if (r0 == null) goto L8;
        int r2 = r0.intValue();
        SoundPool r1 = this.soundPool;
        if (r1 == null) goto L9;
        r1.play(r2, 1.0f, 1.0f, 1, 0, 1.0f);
        return;
    L9:
        return;
    }

    public final void registerDoraCallback() {
        g49.d.d(TAG, "registerDoraCallback");
        kj4.a.g().registerDoraVoiceCallback(this.doraVoiceCallback);
    }

    public final void releaseSoundPool() {
        g49.d.d(TAG, "releaseSoundPool");
        SoundPool r0 = this.soundPool;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.soundPool = null;
    }

    public final void stopBackgroundMusic() {
        g49.d.d(TAG, "stopBackgroundMusic");
        com.larus.dora.impl.onboarding.r r0 = this.player;
        if (r0 == null) goto L6;
        com.larus.dora.impl.onboarding.r.e(r0, new x(this), 1);
        return;
    }

    public final void unregisterDoraCallback() {
        g49.d.d(TAG, "unregisterDoraCallback");
        kj4.a.g().unRegisterDoraVoiceCallback(this.doraVoiceCallback);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$doraVoiceCallback$1] */
    public DoraLiteOnboardingViewModel() {
        this.vuiModeDispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new a0()));
        StateFlowImpl r0 = j1.a(new y0.g(false));
        this._wakeupQueryUiStateFlow = r0;
        this.wakeupQueryUiStateFlow = r0;
        Boolean r1 = Boolean.FALSE;
        StateFlowImpl r2 = j1.a(r1);
        this._queryStateFlow = r2;
        this.queryStateFlow = r2;
        StateFlowImpl r3 = j1.a(AvatarUiState.WAITING);
        this._avatarUiStateFlow = r3;
        this.avatarUiStateFlow = r3;
        StateFlowImpl r4 = j1.a(null);
        this._avatarUrlFlow = r4;
        this.avatarUrlFlow = r4;
        MutableSharedFlow<byte[]> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._ttsDataSharedFlow = r5;
        this.ttsDataSharedFlow = r5;
        this.onboardingTTSList$delegate = LazyKt.lazy(new b0());
        this.isOpeningRemarksTTSPlayed = new AtomicBoolean(false);
        this.isWakeupTTSPlayed = new AtomicBoolean(false);
        this.isRadioTTSPlayed = new AtomicBoolean(false);
        this.isQueryStopTeachTTSPlayed = new AtomicBoolean(false);
        this.isOnboardingNoSkip$delegate = LazyKt.lazy(new c0());
        this.currentVuiMode = -1;
        StateFlowImpl r6 = j1.a(r1);
        this._isMusicPlayingStateFlow = r6;
        this.isMusicPlayingStateFlow = r6;
        this.mutex = kotlinx.coroutines.sync.b.a();
        this.doraVoiceCallback = new DoraLiteOnboardingViewModel$doraVoiceCallback$1(this);
        b r7 = new b(this);
        this.globalAudioObserveCallback = r7;
        g49.d.d(TAG, "##init##");
        enterOnboardingMode();
        GlobalAudioObserver.a.b(r7);
        String r8 = OnboardingAvatarProvider.c;
        if (r8 == null) goto L5;
        r4.setValue(r8);
    L5:
        this.ttsDataCacheList = new ArrayList();
        this.dlayerCallback = new DoraLiteOnboardingViewModel$dlayerCallback$1(this);
    }

    public final void enterVoiceOnlyMode() {
        addSamiListener();
        setVUIMode$default(this, 6, null, 2, null);
    }

    public final void loadKeyEventSoundEffect() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04041(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        if (getDoraOnboardingDevice() == null) goto L10;
        DoraOnboardingDevice r0 = getDoraOnboardingDevice();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L10;
        return;
    L7:
        if (r0.i != 4096) goto L9;
        r1 = true;
    L10:
        realDoCleared("DoraOnboardingViewModel onCleared()");
    }

    public final void playBackgroundMusic() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04061(this, null), 3, null);
    }

    public final void playOpeningRemarksTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04071(this, null), 2, null);
    }

    public final void playWakeupTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04101(this, null), 2, null);
    }

    private static final Unit setVUIMode$lambda$5() {
        return Unit.INSTANCE;
    }

    public final i1<AvatarUiState> getAvatarUiStateFlow() {
        return this.avatarUiStateFlow;
    }

    public final i1<String> getAvatarUrlFlow() {
        return this.avatarUrlFlow;
    }

    public final kotlinx.coroutines.sync.a getMutex() {
        return this.mutex;
    }

    public final i1<Boolean> getQueryStateFlow() {
        return this.queryStateFlow;
    }

    public final d1<byte[]> getTtsDataSharedFlow() {
        return this.ttsDataSharedFlow;
    }

    public final i1<y0> getWakeupQueryUiStateFlow() {
        return this.wakeupQueryUiStateFlow;
    }

    public final i1<Boolean> isMusicPlayingStateFlow() {
        return this.isMusicPlayingStateFlow;
    }

    public static final /* synthetic */ int access$getCurrentVuiMode$p(DoraLiteOnboardingViewModel r0) {
        return r0.currentVuiMode;
    }

    public static final /* synthetic */ com.larus.call_plugins_doubao_common.manager.r access$getMediaManager$p(DoraLiteOnboardingViewModel r0) {
        return r0.mediaManager;
    }

    public static final /* synthetic */ List access$getOnboardingTTSList(DoraLiteOnboardingViewModel r0) {
        return r0.getOnboardingTTSList();
    }

    public static final /* synthetic */ com.larus.dora.impl.onboarding.r access$getPlayer$p(DoraLiteOnboardingViewModel r0) {
        return r0.player;
    }

    public static final /* synthetic */ Integer access$getSoundId$p(DoraLiteOnboardingViewModel r0) {
        return r0.soundId;
    }

    public static final /* synthetic */ SoundPool access$getSoundPool$p(DoraLiteOnboardingViewModel r0) {
        return r0.soundPool;
    }

    public static final /* synthetic */ List access$getTtsDataCacheList$p(DoraLiteOnboardingViewModel r0) {
        return r0.ttsDataCacheList;
    }

    public static final /* synthetic */ z0 access$get_avatarUiStateFlow$p(DoraLiteOnboardingViewModel r0) {
        return r0._avatarUiStateFlow;
    }

    public static final /* synthetic */ z0 access$get_avatarUrlFlow$p(DoraLiteOnboardingViewModel r0) {
        return r0._avatarUrlFlow;
    }

    public static final /* synthetic */ z0 access$get_isMusicPlayingStateFlow$p(DoraLiteOnboardingViewModel r0) {
        return r0._isMusicPlayingStateFlow;
    }

    public static final /* synthetic */ z0 access$get_queryStateFlow$p(DoraLiteOnboardingViewModel r0) {
        return r0._queryStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_ttsDataSharedFlow$p(DoraLiteOnboardingViewModel r0) {
        return r0._ttsDataSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_wakeupQueryUiStateFlow$p(DoraLiteOnboardingViewModel r0) {
        return r0._wakeupQueryUiStateFlow;
    }

    public static final /* synthetic */ AtomicBoolean access$isOpeningRemarksTTSPlayed$p(DoraLiteOnboardingViewModel r0) {
        return r0.isOpeningRemarksTTSPlayed;
    }

    public static final /* synthetic */ AtomicBoolean access$isQueryStopTeachTTSPlayed$p(DoraLiteOnboardingViewModel r0) {
        return r0.isQueryStopTeachTTSPlayed;
    }

    public static final /* synthetic */ AtomicBoolean access$isRadioTTSPlayed$p(DoraLiteOnboardingViewModel r0) {
        return r0.isRadioTTSPlayed;
    }

    public static final /* synthetic */ AtomicBoolean access$isWakeupTTSPlayed$p(DoraLiteOnboardingViewModel r0) {
        return r0.isWakeupTTSPlayed;
    }

    public static final /* synthetic */ void access$loopTTSData(DoraLiteOnboardingViewModel r0) {
        r0.loopTTSData();
    }

    public static final /* synthetic */ void access$onTTSPlayEnd(DoraLiteOnboardingViewModel r0) {
        r0.onTTSPlayEnd();
    }

    private final void handleMusicPlayModel(z98.f r6) {
        z0<y0> r0 = this._wakeupQueryUiStateFlow;
    L3:
        Object r1 = r0.getValue();
        Object r2 = (y0) r1;
        if ((r2 instanceof y0.d) == false) goto L7;
        g49.d.d(TAG, "handleMusicChatResponse: change UiState QueryTopic -> QueryMusic");
        r2 = new y0.b(r6);
    L10:
        if (r0.compareAndSet(r1, r2) == false) goto L3;
        return;
    L7:
        if ((r2 instanceof y0.e) == false) goto L10;
        g49.d.d(TAG, "handleMusicChatResponse: change UiState QueryTopicReenter -> QueryMusic");
        r2 = new y0.b(r6);
        goto L10
    }

    private final void playQueryStopTeachTTS(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04081(this, r7, null), 2, null);
    }

    private final void playTTS(String r7) {
        Object r0 = ServiceManager.get().getService(IDoraService.class);
        String r2 = null;
        if ((r0 instanceof DoraServiceImpl) == false) goto L5;
        DoraServiceImpl r1 = (DoraServiceImpl) r0;
    L6:
        if (r1 == null) goto L10;
        BotModel r3 = r1.F;
        if (r3 == null) goto L10;
        SpeakerVoice r4 = r3.getVoiceType();
    L11:
        if (r4 == null) goto L14;
        String r5 = com.larus.dora.impl.util.r.a(r4);
        if (r5 == null) goto L14;
    L15:
        if (r4 == null) goto L17;
        r2 = r4.getAudioMetrics();
    L17:
        if (r2 != null) goto L19;
        r2 = "";
    L19:
        String r6 = String.valueOf(AudioServiceDelegate.a.a0().b());
        g49.d.d(TAG, "playTTS: " + r7 + ", " + r5);
        b59.a r8 = b59.a.b.a;
        ((CopyOnWriteArraySet) r8.a).add(this.dlayerCallback);
        r8.a(r7, r5, r2, r6);
        return;
    L14:
        r5 = "BV001_streaming";
    L10:
        r4 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    private final void removeSamiListener(String r3) {
        g49.d.d(TAG, "removeSamiListener: reason=" + r3);
        com.larus.dora.impl.onboarding.d.b(null);
    }

    private static final Unit stopBackgroundMusic$lambda$7(DoraLiteOnboardingViewModel r1) {
        com.larus.dora.impl.onboarding.r r0 = r1.player;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        r1.player = null;
        return Unit.INSTANCE;
    }

    private static final Thread vuiModeDispatcher$lambda$0(Runnable r2) {
        return new PthreadThreadV2(r2, "dora_onboarding#VUIMode");
    }

    public final void gotoQueryMusicStopTeachStateIfNecessary(int r5) {
        z0<y0> r0 = this._wakeupQueryUiStateFlow;
    L3:
        Object r1 = r0.getValue();
        Object r2 = (y0) r1;
        if ((r2 instanceof y0.b) == false) goto L7;
        g49.d.d(TAG, "gotoQueryMusicStopTeachStateIfNecessary: change UiState QueryMusic -> QueryMusicStopTeach");
        playQueryStopTeachTTS(r5);
        r2 = y0.c.b;
    L7:
        if (r0.compareAndSet(r1, r2) == false) goto L3;
    }

    public final void playRadioTTS(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04091(this, r7, null), 2, null);
    }

    public final void realDoCleared(String r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        g49.d.d(TAG, "##onCleared## from=" + r3);
        removeSamiListener("onCleared from=" + r3);
        com.larus.call_plugins_doubao_common.manager.r r0 = this.mediaManager;
        if (r0 == null) goto L5;
        r0.k();
    L5:
        exitOnboardingMode();
        boolean r1 = com.larus.dora.impl.onboarding.d.a;
        com.larus.dora.impl.onboarding.d.b = false;
        stopTTS("onCleared from=" + r3);
        GlobalAudioObserver.a.a(this.globalAudioObserveCallback);
        com.larus.dora.impl.onboarding.r r4 = this.player;
        if (r4 == null) goto L8;
        r4.b();
    L8:
        this.player = null;
    }

    public final void stopTTS(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        g49.d.d(TAG, "stopTTS: reason=" + r3);
        com.larus.call_plugins_doubao_common.manager.r r4 = this.mediaManager;
        if (r4 == null) goto L5;
        com.larus.call_plugins_doubao_common.manager.n0.b(r4);
    L5:
        onTTSPlayEnd();
        b59.a r5 = b59.a.b.a;
        ((CopyOnWriteArraySet) r5.a).remove(this.dlayerCallback);
        monitor-enter(r5);
        g49.d.d("Dlayer", "stop");     // Catch: Throwable -> L10
        r5.b.SAMICoreDestroyHandle();     // Catch: Throwable -> L10
        monitor-exit(r5);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$playTTS(DoraLiteOnboardingViewModel r0, String r1) {
        r0.playTTS(r1);
    }

    public static final /* synthetic */ void access$setAvatarFetchJob$p(DoraLiteOnboardingViewModel r0, Job r1) {
        r0.avatarFetchJob = r1;
    }

    public static final /* synthetic */ void access$setCurrentVuiMode$p(DoraLiteOnboardingViewModel r0, int r1) {
        r0.currentVuiMode = r1;
    }

    public static final /* synthetic */ void access$setMediaManager$p(DoraLiteOnboardingViewModel r0, com.larus.call_plugins_doubao_common.manager.r r1) {
        r0.mediaManager = r1;
    }

    public static final /* synthetic */ void access$setPlayer$p(DoraLiteOnboardingViewModel r0, com.larus.dora.impl.onboarding.r r1) {
        r0.player = r1;
    }

    public static final /* synthetic */ void access$setSoundId$p(DoraLiteOnboardingViewModel r0, Integer r1) {
        r0.soundId = r1;
    }

    public static final /* synthetic */ void access$setSoundPool$p(DoraLiteOnboardingViewModel r0, SoundPool r1) {
        r0.soundPool = r1;
    }

    public static final /* synthetic */ String access$vuiText(DoraLiteOnboardingViewModel r0, int r1) {
        return r0.vuiText(r1);
    }

    private static final Unit addSamiListener$lambda$13(DoraLiteOnboardingViewModel r1, z98.f r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.handleMusicPlayModel(r2);
        return Unit.INSTANCE;
    }

    private final void setVUIMode(int r7, Function0<Unit> r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new AnonymousClass2(this, r7, r8, null), 2, null);
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel
    public Object isDoraSupportOnboarding(String r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof C04031) == false) goto L7;
        C04031 r0 = (C04031) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        boolean r5 = false;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L30:
        if (((Boolean) r12).booleanValue() == false) goto L45;
        DoraDevice r14 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L15
        if (r14 != null) goto L34;
    L36:
        boolean r7 = false;
    L37:
        if (r7 == false) goto L39;
        g49.d.d(TAG, r6 + "_isDoraSupportOnboarding: vendor dora == ");     // Catch: Throwable -> L15
    L44:
        Boolean r15 = Boxing.boxBoolean(r4);     // Catch: Throwable -> L15
    L46:
        this._isDoraSupportOnboarding = r15;     // Catch: Throwable -> L15
        kotlinx.coroutines.sync.a r16 = r13;
        r10 = r6;
    L48:
        g49.d.d(TAG, r10 + "_isDoraSupportOnboarding: " + this._isDoraSupportOnboarding);     // Catch: Throwable -> L54
        Boolean r17 = this._isDoraSupportOnboarding;     // Catch: Throwable -> L54
        if (r17 == null) goto L51;
        r5 = r17.booleanValue();     // Catch: Throwable -> L54
    L51:
        Boolean r18 = Boxing.boxBoolean(r5);     // Catch: Throwable -> L54
        r16.unlock(null);
        return r18;
    L54:
        th = move-exception;
        kotlinx.coroutines.sync.a r8 = r16;
        th = th;
        r13 = r8;
    L56:
        r13.unlock(null);
        throw th;
    L39:
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L15
        r9.append(r6);     // Catch: Throwable -> L15
        r9.append("_isDoraSupportOnboarding: vendor dora != ");     // Catch: Throwable -> L15
        if (r14 == null) goto L42;
        Integer r110 = Boxing.boxInt(r14.vendorId);     // Catch: Throwable -> L15
    L43:
        r9.append(r110);     // Catch: Throwable -> L15
        g49.d.d(TAG, r9.toString());     // Catch: Throwable -> L15
        r4 = false;
        goto L44
    L42:
        r110 = null;
        goto L43
    L34:
        if (r14.vendorId != 1) goto L36;
        r7 = true;
        goto L37
    L45:
        r15 = Boxing.boxBoolean(false);     // Catch: Throwable -> L15
    L15:
        th = th;
        goto L56
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r111 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r20 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
        r16 = r111;
        r10 = r20;
    L58:
        if (this._isDoraSupportOnboarding != null) goto L48;
        kj4.a r21 = kj4.a.g();     // Catch: Throwable -> L54
        r0.L$0 = r10;     // Catch: Throwable -> L54
        r0.L$1 = r16;     // Catch: Throwable -> L54
        r0.label = 2;     // Catch: Throwable -> L54
        Object r22 = DoraAdapterExtKt.u(r21);     // Catch: Throwable -> L54
        if (r22 != r2) goto L28;
        return r2;
    L28:
        r6 = r10;
        r13 = r16;
        r12 = r22;
        goto L30
    L20:
        ResultKt.throwOnFailure(r12);
        r16 = this.mutex;
        r0.L$0 = r10;
        r0.L$1 = r16;
        r0.label = 1;
        if (r16.a(null, r0) != r2) goto L58;
        return r2;
    L7:
        r0 = new C04031(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setVUIMode$default(DoraLiteOnboardingViewModel r0, int r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new y();
    L5:
        r0.setVUIMode(r1, r2);
    }
}
