package com.larus.dora.impl.onboarding.othersmart;

import android.content.res.AssetFileDescriptor;
import android.media.SoundPool;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n*\u0004DGJs\b\u0016\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010L\u001a\u00020\u00122\u0006\u0010M\u001a\u00020$H\u0096@¢\u0006\u0002\u0010NJ\u0018\u0010O\u001a\u00020\u00122\b\b\u0002\u0010M\u001a\u00020$H\u0082@¢\u0006\u0002\u0010NJ\f\u0010P\u001a\u00020$*\u000204H\u0002J*\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u0002042\b\b\u0002\u0010T\u001a\u00020\u00122\u000e\b\u0002\u0010U\u001a\b\u0012\u0004\u0012\u00020R0VH\u0002J\u0010\u0010W\u001a\u00020R2\b\b\u0002\u0010T\u001a\u00020\u0012J\u0006\u0010X\u001a\u00020RJ\u0010\u0010Y\u001a\u00020R2\b\b\u0002\u0010T\u001a\u00020\u0012J\u0010\u0010Z\u001a\u00020R2\b\b\u0002\u0010T\u001a\u00020\u0012J\u0010\u0010[\u001a\u00020R2\b\b\u0002\u0010T\u001a\u00020\u0012J\u0006\u0010\\\u001a\u00020RJ\u0006\u0010]\u001a\u00020RJ\u0006\u0010^\u001a\u00020RJ\u0006\u0010_\u001a\u00020RJ\u0006\u0010`\u001a\u00020RJ\u0006\u0010a\u001a\u00020\u0012J\u0006\u0010b\u001a\u00020RJ\u0006\u0010c\u001a\u00020RJ\u0006\u0010d\u001a\u00020RJ\u0006\u0010e\u001a\u00020RJ\u0006\u0010f\u001a\u00020RJ\u000e\u0010g\u001a\u00020R2\u0006\u0010h\u001a\u000204J \u0010i\u001a\u00020R2\u0006\u0010j\u001a\u00020$2\u0006\u0010h\u001a\u0002042\b\b\u0002\u0010k\u001a\u00020lJ\u000e\u0010m\u001a\u00020R2\u0006\u0010j\u001a\u00020$J\b\u0010u\u001a\u00020RH\u0002J\b\u0010v\u001a\u00020RH\u0002J\u000e\u0010x\u001a\u00020R2\u0006\u0010y\u001a\u00020$J\u000e\u0010z\u001a\u00020R2\u0006\u0010{\u001a\u00020$J\u0010\u0010|\u001a\u00020R2\u0006\u0010}\u001a\u00020~H\u0002J\b\u0010\u007f\u001a\u00020RH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020R2\u0006\u0010{\u001a\u00020$H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020R2\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u0010\u0010\u0083\u0001\u001a\u00020R2\u0007\u0010\u0082\u0001\u001a\u000204J\t\u0010\u0084\u0001\u001a\u00020RH\u0014J\u0010\u0010\u0085\u0001\u001a\u00020R2\u0007\u0010\u0086\u0001\u001a\u00020$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R#\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u001b\u0010)\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020$02X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0004\n\u0002\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\fR\u0011\u0010?\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0010\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ER\u0010\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0004\n\u0002\u0010HR\u0010\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0004\n\u0002\u0010KR\u0014\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001b0oX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u00020sX\u0082\u0004¢\u0006\u0004\n\u0002\u0010tR\u0010\u0010w\u001a\u0004\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseViewModel;", "<init>", "()V", "vuiModeDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "_wakeupQueryUiStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/onboarding/othersmart/WakeupQueryUiState;", "wakeupQueryUiStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getWakeupQueryUiStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_deviceStateFlow", "Lcom/larus/dora/impl/onboarding/othersmart/DeviceState;", "deviceStateFlow", "getDeviceStateFlow", "_queryStateFlow", "", "queryStateFlow", "getQueryStateFlow", "_avatarUiStateFlow", "Lcom/larus/dora/impl/onboarding/othersmart/AvatarUiState;", "avatarUiStateFlow", "getAvatarUiStateFlow", "_ttsDataSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "ttsDataSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getTtsDataSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_isDoraSupportOnboarding", "Ljava/lang/Boolean;", "onboardingTTSList", "", "", "getOnboardingTTSList", "()Ljava/util/List;", "onboardingTTSList$delegate", "Lkotlin/Lazy;", "isOnboardingNoSkip", "()Z", "isOnboardingNoSkip$delegate", "isOpeningRemarksTTSPlayed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isWakeupTTSPlayed", "isRadioTTSPlayed", "isQueryStopTeachTTSPlayed", "pageEntryTTSPlayedKeys", "", "currentVuiMode", "", "player", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBgMusicPlayer;", "soundPool", "Landroid/media/SoundPool;", "soundId", "Ljava/lang/Integer;", "mediaManager", "Lcom/larus/call_plugins_doubao_common/manager/DoraRealtimeCallMediaManager;", "_isMusicPlayingStateFlow", "isMusicPlayingStateFlow", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "doraLinkCallback", "com/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel$doraLinkCallback$1;", "doraVoiceCallback", "com/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel$doraVoiceCallback$1", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel$doraVoiceCallback$1;", "globalAudioObserveCallback", "com/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel$globalAudioObserveCallback$1", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel$globalAudioObserveCallback$1;", "isDoraSupportOnboarding", "caller", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureSetVoiWakeupEnable", "vuiText", "setVUIMode", "", "mode", "skipLastMode", "onSuccess", "Lkotlin/Function0;", "enterOnboardingMode", "enterKeyOnlyMode", "enterVoiceOnlyMode", "enterRadioOnlyMode", "enterKeyLongPressOnlyMode", "exitOnboardingMode", "registerDoraCallback", "unregisterDoraCallback", "playBackgroundMusic", "stopBackgroundMusic", "isBackgroundMusicPlaying", "loadKeyEventSoundEffect", "playKeyEventSoundEffect", "releaseSoundPool", "playOpeningRemarksTTS", "playWakeupTTS", "playRadioTTS", "ttsResId", "playPageEntryTTSIfNeeded", "pageKey", "delayMs", "", "releasePageEntryTTS", "ttsDataCacheList", "", "ttsDataLoopJob", "Lkotlinx/coroutines/Job;", "dlayerCallback", "com/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel$dlayerCallback$1", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel$dlayerCallback$1;", "onTTSPlayEnd", "loopTTSData", "playTtsJob", "playTTS", "ttsText", "stopTTS", "reason", "handleMusicPlayModel", "musicModel", "Lcom/larus/avlink/model/DoraOnboardingMusicModel;", "addSamiListener", "removeSamiListener", "playQueryStopTeachTTS", "queryStopTtsResId", "gotoQueryMusicStopTeachStateIfNecessary", "onCleared", "realDoCleared", "from", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraExternalOnboardingViewModel extends DoraOnboardingBaseViewModel {
    private static final a Companion = null;
    private static final String TAG = "DoraExternalOnboardingViewModel";
    private final z0<AvatarUiState> _avatarUiStateFlow;
    private final z0<com.larus.dora.impl.onboarding.othersmart.a> _deviceStateFlow;
    private Boolean _isDoraSupportOnboarding;
    private z0<Boolean> _isMusicPlayingStateFlow;
    private final z0<Boolean> _queryStateFlow;
    private final MutableSharedFlow<byte[]> _ttsDataSharedFlow;
    private final z0<r0> _wakeupQueryUiStateFlow;
    private final i1<AvatarUiState> avatarUiStateFlow;
    private int currentVuiMode;
    private final i1<com.larus.dora.impl.onboarding.othersmart.a> deviceStateFlow;
    private final DoraExternalOnboardingViewModel$dlayerCallback$1 dlayerCallback;
    private final DoraExternalOnboardingViewModel$doraLinkCallback$1 doraLinkCallback;
    private final DoraExternalOnboardingViewModel$doraVoiceCallback$1 doraVoiceCallback;
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
    private final Set<String> pageEntryTTSPlayedKeys;
    private Job playTtsJob;
    private com.larus.dora.impl.onboarding.r player;
    private final i1<Boolean> queryStateFlow;
    private Integer soundId;
    private SoundPool soundPool;
    private final List<byte[]> ttsDataCacheList;
    private Job ttsDataLoopJob;
    private final d1<byte[]> ttsDataSharedFlow;
    private final ExecutorCoroutineDispatcher vuiModeDispatcher;
    private final i1<r0> wakeupQueryUiStateFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements o78.b {
        public final /* synthetic */ DoraExternalOnboardingViewModel a;

        public b(DoraExternalOnboardingViewModel r1) {
            this.a = r1;
        }

        public final void c(String r1, Map r2) {
            o78.b.a.a(r1);
        }

        public final void a(String r2, GlobalAudioStateEnum r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "playbackState");
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "onPlaybackStateChanged: scene=" + r2 + ", playbackState=" + r3);
            z0 r5 = DoraExternalOnboardingViewModel.access$get_isMusicPlayingStateFlow$p(this.a);
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
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "onError: scene=" + r3 + ", code=" + r4 + ", internalCode=" + r5);
        }

        public final void d(String r1, String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "scene");
            Intrinsics.checkNotNullParameter(r2, "uniId");
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "onPlayTriggered: scene=" + r1);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$ensureSetVoiWakeupEnable$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel", f = "DoraExternalOnboardingViewModel.kt", i = {0, 0, 0}, l = {346}, m = "ensureSetVoiWakeupEnable", n = {"caller", "ret", "tryIndex"}, s = {"L$0", "I$0", "I$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public AnonymousClass1(DoraExternalOnboardingViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraExternalOnboardingViewModel.access$ensureSetVoiWakeupEnable(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$exitOnboardingMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$exitOnboardingMode$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {421, 422}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04111(DoraExternalOnboardingViewModel r1, Continuation<? super C04111> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04111(this.this$0, r3);
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
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "STOP_VUIStopMode_STOP_ONBOARDING: " + r6);
            if (r6 == false) goto L22;
            DoraExternalOnboardingViewModel.access$setCurrentVuiMode$p(this.this$0, -1);
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
            DoraExternalOnboardingViewModel r9 = this.this$0;
            this.label = 1;
            r5 = r9.isDoraSupportOnboarding("exitOnboardingMode", this);
            if (r5 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$isDoraSupportOnboarding$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$isDoraSupportOnboarding$2", f = "DoraExternalOnboardingViewModel.kt", i = {0, 1, 1, 2}, l = {882, 314, 321}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "device", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$3", "L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $caller;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public AnonymousClass2(DoraExternalOnboardingViewModel r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$caller = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$caller, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r7 = true;
            boolean r8 = false;
            if (r1 == 0) goto L20;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L14;
            if (r1 != 3) goto L13;
            DoraExternalOnboardingViewModel r2 = (DoraExternalOnboardingViewModel) this.L$3;
            String r3 = (String) this.L$2;
            DoraExternalOnboardingViewModel r4 = (DoraExternalOnboardingViewModel) this.L$1;
            kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L10
        L55:
            r7 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L10
            DoraExternalOnboardingViewModel r9 = r2;
            String r6 = r3;
        L56:
            Boolean r15 = Boxing.boxBoolean(r7);     // Catch: Throwable -> L10
            String r10 = r6;
        L60:
            DoraExternalOnboardingViewModel.access$set_isDoraSupportOnboarding$p(r9, r15);     // Catch: Throwable -> L10
            r9 = r4;
        L61:
            g49.d.d(DoraExternalOnboardingViewModel.TAG, r10 + "_isDoraSupportOnboarding: " + DoraExternalOnboardingViewModel.access$get_isDoraSupportOnboarding$p(r9));     // Catch: Throwable -> L10
            Boolean r16 = DoraExternalOnboardingViewModel.access$get_isDoraSupportOnboarding$p(r9);     // Catch: Throwable -> L10
            if (r16 == null) goto L64;
            r8 = r16.booleanValue();     // Catch: Throwable -> L10
        L64:
            Boolean r17 = Boxing.boxBoolean(r8);     // Catch: Throwable -> L10
            r5.unlock(null);
            return r17;
        L10:
            th = th;
            kotlinx.coroutines.sync.a r11 = r5;
        L68:
            r11.unlock(null);
            throw th;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            DoraDevice r12 = (DoraDevice) this.L$3;
            r6 = (String) this.L$2;
            r9 = (DoraExternalOnboardingViewModel) this.L$1;
            kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L17
        L42:
            boolean r18 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L17
        L43:
            if (r18 == false) goto L58;
            if (r12 != null) goto L46;
        L48:
            boolean r110 = false;
        L49:
            if (r110 == false) goto L51;
            g49.d.d(DoraExternalOnboardingViewModel.TAG, r6 + "_isDoraSupportOnboarding: vendor h == ");     // Catch: Throwable -> L17
            r4 = r9;
            r5 = r13;
            goto L56
        L51:
            this.L$0 = r13;     // Catch: Throwable -> L17
            this.L$1 = r9;     // Catch: Throwable -> L17
            this.L$2 = r6;     // Catch: Throwable -> L17
            this.L$3 = r9;     // Catch: Throwable -> L17
            this.label = 3;     // Catch: Throwable -> L17
            r14 = DoraExternalOnboardingViewModel.access$ensureSetVoiWakeupEnable(r9, r6, this);     // Catch: Throwable -> L17
            if (r14 != r0) goto L54;
            return r0;
        L54:
            r3 = r6;
            r2 = r9;
            r4 = r2;
            r5 = r13;
            goto L55
        L46:
            if (r12.vendorId != 4096) goto L48;
            r110 = true;
            goto L49
        L58:
            r15 = Boxing.boxBoolean(false);     // Catch: Throwable -> L17
            r10 = r6;
            r4 = r9;
            r5 = r13;
            goto L60
        L19:
            r10 = (String) this.L$2;
            r9 = (DoraExternalOnboardingViewModel) this.L$1;
            r13 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r14);
        L25:
            if (DoraExternalOnboardingViewModel.access$get_isDoraSupportOnboarding$p(r9) != null) goto L27;
        L30:
            DoraDevice r111 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L17
            if (r111 != null) goto L33;
        L35:
            boolean r112 = false;
        L36:
            if (r112 == false) goto L38;
            r6 = r10;
            r12 = r111;
            r18 = true;
            goto L43
        L38:
            kj4.a r113 = kj4.a.g();     // Catch: Throwable -> L17
            this.L$0 = r13;     // Catch: Throwable -> L17
            this.L$1 = r9;     // Catch: Throwable -> L17
            this.L$2 = r10;     // Catch: Throwable -> L17
            this.L$3 = r111;     // Catch: Throwable -> L17
            this.label = 2;     // Catch: Throwable -> L17
            Object r20 = DoraAdapterExtKt.u(r113);     // Catch: Throwable -> L17
            if (r20 != r0) goto L41;
            return r0;
        L41:
            String r114 = r10;
            r12 = r111;
            r14 = r20;
            r6 = r114;
            goto L42
        L33:
            if (r111.vendorId != 4096) goto L35;
            r112 = true;
            goto L36
        L27:
            if (Intrinsics.areEqual(DoraExternalOnboardingViewModel.access$get_isDoraSupportOnboarding$p(r9), Boxing.boxBoolean(false)) == true) goto L30;
            r5 = r13;
            goto L61
        L20:
            ResultKt.throwOnFailure(r14);
            kotlinx.coroutines.sync.a r115 = this.this$0.getMutex();
            DoraExternalOnboardingViewModel r21 = this.this$0;
            String r22 = this.$caller;
            this.L$0 = r115;
            this.L$1 = r21;
            this.L$2 = r22;
            this.label = 1;
            if (r115.a(null, this) != r0) goto L23;
            return r0;
        L23:
            r13 = r115;
            r9 = r21;
            r10 = r22;
        L17:
            th = th;
            goto L68
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$loadKeyEventSoundEffect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$loadKeyEventSoundEffect$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04121(DoraExternalOnboardingViewModel r1, Continuation<? super C04121> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04121(this.this$0, r3);
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
            DoraExternalOnboardingViewModel r7 = this.this$0;
            long r0 = System.currentTimeMillis();
            DoraExternalOnboardingViewModel.access$setSoundPool$p(r7, new SoundPool.Builder().build());
            AssetFileDescriptor r2 = AppHost.a.getApplication().getAssets().openFd("dora_onboarding_opt_success.mp3");
            SoundPool r3 = DoraExternalOnboardingViewModel.access$getSoundPool$p(r7);
            if (r3 == null) goto L7;
            Integer r4 = Boxing.boxInt(r3.load(r2, 1));
        L8:
            DoraExternalOnboardingViewModel.access$setSoundId$p(r7, r4);
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "loadKeyEventSoundEffect: soundId=" + DoraExternalOnboardingViewModel.access$getSoundId$p(this.this$0) + ", consumeTime=" + (System.currentTimeMillis() - r0));
            return Unit.INSTANCE;
        L7:
            r4 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$loopTTSData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$loopTTSData$1", f = "DoraExternalOnboardingViewModel.kt", i = {0, 0, 1, 1}, l = {662, 665}, m = "invokeSuspend", n = {"$this$launch", "i", "$this$launch", "i"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class C04131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04131(DoraExternalOnboardingViewModel r1, Continuation<? super C04131> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04131 r0 = new C04131(this.this$0, r4);
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
            C04131 r11 = this;
        L35:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
            CoroutineScope r8 = r4;
            C04131 r5 = r11;
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
            C04131 r9 = r5;
            r4 = r12;
            r11 = r9;
        L21:
            DoraExternalOnboardingViewModel r6 = r11.this$0;
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L29
            if ((!DoraExternalOnboardingViewModel.access$getTtsDataCacheList$p(r6).isEmpty()) == false) goto L35;
            MutableSharedFlow r13 = DoraExternalOnboardingViewModel.access$get_ttsDataSharedFlow$p(r6);     // Catch: Throwable -> L29
            Object r14 = CollectionsKt.random(DoraExternalOnboardingViewModel.access$getTtsDataCacheList$p(r6), Random.Default);     // Catch: Throwable -> L29
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
            C04131 r3 = r11;
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

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playBackgroundMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playBackgroundMusic$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04141(DoraExternalOnboardingViewModel r1, Continuation<? super C04141> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04141(this.this$0, r3);
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
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "playBackgroundMusic");
            if (DoraExternalOnboardingViewModel.access$getPlayer$p(this.this$0) == null) goto L21;
            com.larus.dora.impl.onboarding.r r6 = DoraExternalOnboardingViewModel.access$getPlayer$p(this.this$0);
            if (r6 == null) goto L18;
            int r2 = com.larus.dora.impl.onboarding.r.h;
            r6.d(null);
        L18:
            com.larus.dora.impl.onboarding.r r7 = DoraExternalOnboardingViewModel.access$getPlayer$p(this.this$0);
            if (r7 == null) goto L21;
            r7.b();
        L21:
            DoraExternalOnboardingViewModel.access$setPlayer$p(this.this$0, new com.larus.dora.impl.onboarding.r());
            com.larus.dora.impl.onboarding.r r8 = DoraExternalOnboardingViewModel.access$getPlayer$p(this.this$0);
            if (r8 == null) goto L25;
            com.larus.dora.impl.onboarding.r.c(r8, AppHost.a.getApplication());
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DoraExternalOnboardingViewModel r9 = this.this$0;
            this.label = 1;
            r5 = r9.isDoraSupportOnboarding("playBackgroundMusic", this);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playOpeningRemarksTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playOpeningRemarksTTS$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {513}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04151(DoraExternalOnboardingViewModel r1, Continuation<? super C04151> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04151(this.this$0, r3);
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
            List r8 = DoraExternalOnboardingViewModel.access$getOnboardingTTSList(this.this$0);
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
            this.this$0.playTTS(r9);
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
            if (DoraExternalOnboardingViewModel.access$isOpeningRemarksTTSPlayed$p(this.this$0).compareAndSet(false, true) == false) goto L25;
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playPageEntryTTSIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playPageEntryTTSIfNeeded$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {563}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMs;
        final /* synthetic */ String $pageKey;
        final /* synthetic */ int $ttsResId;
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04161(DoraExternalOnboardingViewModel r1, String r2, long r3, int r5, Continuation<? super C04161> r6) {
            this.this$0 = r1;
            this.$pageKey = r2;
            this.$delayMs = r3;
            this.$ttsResId = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C04161(this.this$0, this.$pageKey, this.$delayMs, this.$ttsResId, r9);
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
        L20:
            DoraExternalOnboardingViewModel r9 = this.this$0;
            int r2 = com.larus.utils.j0.a;
            r9.playTTS(com.larus.utils.j0.d(this.$ttsResId));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            Set r10 = DoraExternalOnboardingViewModel.access$getPageEntryTTSPlayedKeys$p(this.this$0);
            DoraExternalOnboardingViewModel r3 = this.this$0;
            String r4 = this.$pageKey;
            monitor-enter(r10);
            boolean r5 = DoraExternalOnboardingViewModel.access$getPageEntryTTSPlayedKeys$p(r3).add(r4);     // Catch: Throwable -> L22
            monitor-exit(r10);
            if (r5 == true) goto L15;
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "playPageEntryTTSIfNeeded skip: pageKey=" + this.$pageKey);
            return Unit.INSTANCE;
        L15:
            long r6 = this.$delayMs;
            if (r6 <= 0) goto L20;
            this.label = 1;
            if (DelayKt.delay(r6, this) != r0) goto L20;
            return r0;
        L22:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playQueryStopTeachTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playQueryStopTeachTTS$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $queryStopTtsResId;
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04171(DoraExternalOnboardingViewModel r1, int r2, Continuation<? super C04171> r3) {
            this.this$0 = r1;
            this.$queryStopTtsResId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04171(this.this$0, this.$queryStopTtsResId, r4);
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
            if (DoraExternalOnboardingViewModel.access$isQueryStopTeachTTSPlayed$p(this.this$0).compareAndSet(false, true) == false) goto L18;
            List r5 = DoraExternalOnboardingViewModel.access$getOnboardingTTSList(this.this$0);
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
            this.this$0.playTTS(r6);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playRadioTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playRadioTTS$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $ttsResId;
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04181(DoraExternalOnboardingViewModel r1, int r2, Continuation<? super C04181> r3) {
            this.this$0 = r1;
            this.$ttsResId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04181(this.this$0, this.$ttsResId, r4);
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
            if (DoraExternalOnboardingViewModel.access$isRadioTTSPlayed$p(this.this$0).compareAndSet(false, true) == false) goto L18;
            List r5 = DoraExternalOnboardingViewModel.access$getOnboardingTTSList(this.this$0);
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
            this.this$0.playTTS(r6);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playTTS$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $ttsText;
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04191(String r1, DoraExternalOnboardingViewModel r2, Continuation<? super C04191> r3) {
            this.$ttsText = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04191(this.$ttsText, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L24;
            ResultKt.throwOnFailure(r7);
            Object r8 = ServiceManager.get().getService(IDoraService.class);
            String r1 = null;
            if ((r8 instanceof DoraServiceImpl) == false) goto L7;
            DoraServiceImpl r9 = (DoraServiceImpl) r8;
        L8:
            if (r9 == null) goto L12;
            BotModel r10 = r9.F;
            if (r10 == null) goto L12;
            SpeakerVoice r11 = r10.getVoiceType();
        L13:
            if (r11 == null) goto L16;
            String r0 = r11.getStyleId();
            if (r0 == null) goto L16;
        L17:
            if (r11 == null) goto L19;
            r1 = r11.getAudioMetrics();
        L19:
            if (r1 != null) goto L21;
            r1 = "";
        L21:
            String r12 = String.valueOf(AudioServiceDelegate.a.a0().b());
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "playTTS: " + this.$ttsText + ", " + r0);
            b59.a r2 = b59.a.b.a;
            DoraExternalOnboardingViewModel r3 = this.this$0;
            String r4 = this.$ttsText;
            ((CopyOnWriteArraySet) r2.a).add(DoraExternalOnboardingViewModel.access$getDlayerCallback$p(r3));
            r2.a(r4, r0, r1, r12);
            return Unit.INSTANCE;
        L16:
            r0 = "BV001_streaming";
        L12:
            r11 = null;
            goto L13
        L7:
            r9 = null;
            goto L8
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playWakeupTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$playWakeupTTS$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04201(DoraExternalOnboardingViewModel r1, Continuation<? super C04201> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04201(this.this$0, r3);
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
            if (DoraExternalOnboardingViewModel.access$isWakeupTTSPlayed$p(this.this$0).compareAndSet(false, true) == false) goto L18;
            List r5 = DoraExternalOnboardingViewModel.access$getOnboardingTTSList(this.this$0);
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
            this.this$0.playTTS(r6);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$releaseSoundPool$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$releaseSoundPool$1", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SoundPool $poolToRelease;
        private /* synthetic */ Object L$0;
        int label;

        public C04211(SoundPool r1, Continuation<? super C04211> r2) {
            this.$poolToRelease = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04211 r0 = new C04211(this.$poolToRelease, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r3);
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "releaseSoundPool: releasing SoundPool on IO dispatcher");
            SoundPool r5 = this.$poolToRelease;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
            r5.release();     // Catch: Throwable -> L7
            Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r7 = Result.exceptionOrNull-impl(r6);
            if (r7 == null) goto L13;
            g49.d.c(DoraExternalOnboardingViewModel.TAG, "releaseSoundPool: error releasing SoundPool", r7);
        L13:
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$setVUIMode$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$setVUIMode$2", f = "DoraExternalOnboardingViewModel.kt", i = {}, l = {367, 372}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04222 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $mode;
        final /* synthetic */ Function0<Unit> $onSuccess;
        final /* synthetic */ boolean $skipLastMode;
        int label;
        final /* synthetic */ DoraExternalOnboardingViewModel this$0;

        public C04222(DoraExternalOnboardingViewModel r1, int r2, boolean r3, Function0<Unit> r4, Continuation<? super C04222> r5) {
            this.this$0 = r1;
            this.$mode = r2;
            this.$skipLastMode = r3;
            this.$onSuccess = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04222(this.this$0, this.$mode, this.$skipLastMode, this.$onSuccess, r8);
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
        L24:
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "START_" + DoraExternalOnboardingViewModel.access$vuiText(this.this$0, this.$mode) + ": result=" + ((Boolean) r9).booleanValue());
            DoraExternalOnboardingViewModel.access$setCurrentVuiMode$p(this.this$0, this.$mode);
            this.$onSuccess.invoke();
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
        L14:
            if (((Boolean) r9).booleanValue() == false) goto L26;
            if (DoraExternalOnboardingViewModel.access$getCurrentVuiMode$p(this.this$0) == this.$mode) goto L18;
        L21:
            kj4.a r10 = kj4.a.g();
            int r2 = this.$mode;
            this.label = 2;
            r9 = DoraAdapterExtKt.L(r10, r2);
            if (r9 != r0) goto L24;
            return r0;
        L18:
            if (this.$skipLastMode == true) goto L21;
            g49.d.d(DoraExternalOnboardingViewModel.TAG, "START_" + DoraExternalOnboardingViewModel.access$vuiText(this.this$0, this.$mode) + ", already in " + DoraExternalOnboardingViewModel.access$vuiText(this.this$0, this.$mode));
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r9);
            DoraExternalOnboardingViewModel r11 = this.this$0;
            String r3 = "START_" + DoraExternalOnboardingViewModel.access$vuiText(this.this$0, this.$mode);
            this.label = 1;
            r9 = r11.isDoraSupportOnboarding(r3, this);
            if (r9 != r0) goto L14;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ List No() {
        return onboardingTTSList_delegate$lambda$1();
    }

    public static /* synthetic */ Unit Oo(DoraExternalOnboardingViewModel r0) {
        return stopBackgroundMusic$lambda$5(r0);
    }

    public static /* synthetic */ Unit Po() {
        return enterOnboardingMode$lambda$4();
    }

    public static /* synthetic */ boolean Qo() {
        return isOnboardingNoSkip_delegate$lambda$2();
    }

    public static /* synthetic */ Unit So(DoraExternalOnboardingViewModel r0, z98.f r1) {
        return addSamiListener$lambda$12(r0, r1);
    }

    public static /* synthetic */ Thread To(Runnable r0) {
        return vuiModeDispatcher$lambda$0(r0);
    }

    public static /* synthetic */ Unit Wo() {
        return setVUIMode$lambda$3();
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
        if (r2 != 7) goto L11;
        return "VUIMode_RADIO_ONLY";
    L11:
        if (r2 == 11) goto L13;
        return "VUIMode_UNKNOWN";
    L13:
        return "VUIMode_ONBOARDING_KEY_LONG_PRESS_ONLY";
    }

    public final void enterKeyOnlyMode() {
        setVUIMode$default(this, 5, false, null, 6, null);
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel
    public Object isDoraSupportOnboarding(String r1, Continuation<? super Boolean> r2) {
        return isDoraSupportOnboarding$suspendImpl(this, r1, r2);
    }

    private final void addSamiListener() {
        com.larus.dora.impl.onboarding.d.b(new o(this));
    }

    private static final Unit enterOnboardingMode$lambda$4() {
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
        this.ttsDataLoopJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04131(this, null), 3, null);
    }

    private final void onTTSPlayEnd() {
        this.ttsDataCacheList.clear();
        Job r0 = this.ttsDataLoopJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this._avatarUiStateFlow.tryEmit(AvatarUiState.WAITING);
        z0<r0> r1 = this._wakeupQueryUiStateFlow;
    L6:
        Object r2 = r1.getValue();
        Object r3 = (r0) r2;
        if ((r3 instanceof r0.d) == false) goto L10;
        r3 = new r0.d(true);
    L13:
        if (r1.compareAndSet(r2, r3) == false) goto L6;
        return;
    L10:
        if ((r3 instanceof r0.g) == false) goto L13;
        r3 = new r0.g(true);
        goto L13
    }

    private static final List onboardingTTSList_delegate$lambda$1() {
        Lazy r0 = g69.b.a;
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

    public final void exitOnboardingMode() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.vuiModeDispatcher, null, new C04111(this, null), 2, null);
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
        monitor-enter(this);
        SoundPool r0 = this.soundPool;     // Catch: Throwable -> L13
        if (r0 != null) goto L7;
        g49.d.d(TAG, "releaseSoundPool: soundPool is null or already released, skip");     // Catch: Throwable -> L13
        r0 = null;
    L8:
        monitor-exit(this);
        if (r0 != null) goto L11;
        return;
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04211(r0, null), 2, null);
        return;
    L7:
        this.soundPool = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void stopBackgroundMusic() {
        g49.d.d(TAG, "stopBackgroundMusic");
        com.larus.dora.impl.onboarding.r r0 = this.player;
        if (r0 == null) goto L6;
        com.larus.dora.impl.onboarding.r.e(r0, new n(this), 1);
        return;
    }

    public final void unregisterDoraCallback() {
        g49.d.d(TAG, "unregisterDoraCallback");
        kj4.a.g().unRegisterDoraVoiceCallback(this.doraVoiceCallback);
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel$doraVoiceCallback$1] */
    public DoraExternalOnboardingViewModel() {
        this.vuiModeDispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new q()));
        StateFlowImpl r0 = j1.a(new r0.g(false));
        this._wakeupQueryUiStateFlow = r0;
        this.wakeupQueryUiStateFlow = r0;
        StateFlowImpl r1 = j1.a(com.larus.dora.impl.onboarding.othersmart.a.b.a);
        this._deviceStateFlow = r1;
        this.deviceStateFlow = r1;
        Boolean r2 = Boolean.FALSE;
        StateFlowImpl r3 = j1.a(r2);
        this._queryStateFlow = r3;
        this.queryStateFlow = r3;
        StateFlowImpl r4 = j1.a(AvatarUiState.WAITING);
        this._avatarUiStateFlow = r4;
        this.avatarUiStateFlow = r4;
        MutableSharedFlow<byte[]> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._ttsDataSharedFlow = r5;
        this.ttsDataSharedFlow = r5;
        this.onboardingTTSList$delegate = LazyKt.lazy(new r());
        this.isOnboardingNoSkip$delegate = LazyKt.lazy(new s());
        this.isOpeningRemarksTTSPlayed = new AtomicBoolean(false);
        this.isWakeupTTSPlayed = new AtomicBoolean(false);
        this.isRadioTTSPlayed = new AtomicBoolean(false);
        this.isQueryStopTeachTTSPlayed = new AtomicBoolean(false);
        this.pageEntryTTSPlayedKeys = new LinkedHashSet();
        this.currentVuiMode = -1;
        StateFlowImpl r6 = j1.a(r2);
        this._isMusicPlayingStateFlow = r6;
        this.isMusicPlayingStateFlow = r6;
        this.mutex = kotlinx.coroutines.sync.b.a();
        IDoraLinkCallback r7 = new DoraExternalOnboardingViewModel$doraLinkCallback$1(this);
        this.doraLinkCallback = r7;
        this.doraVoiceCallback = new DoraExternalOnboardingViewModel$doraVoiceCallback$1(this);
        b r8 = new b(this);
        this.globalAudioObserveCallback = r8;
        g49.d.d(TAG, "##init##");
        enterOnboardingMode$default(this, false, 1, null);
        GlobalAudioObserver.a.b(r8);
        kj4.a.g().registerDoraLinkCallback(r7);
        this.ttsDataCacheList = new ArrayList();
        this.dlayerCallback = new DoraExternalOnboardingViewModel$dlayerCallback$1(this);
    }

    public final void loadKeyEventSoundEffect() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04121(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
        if (getDoraOnboardingDevice() == null) goto L11;
        DoraOnboardingDevice r0 = getDoraOnboardingDevice();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L11;
    L12:
        boolean r2 = com.larus.dora.impl.onboarding.d.a;
        com.larus.dora.impl.onboarding.d.b = false;
        return;
    L7:
        if (r0.i != 4096) goto L9;
        r1 = true;
    L11:
        realDoCleared("DoraOnboardingViewModel onCleared()");
        goto L12
    }

    public final void playBackgroundMusic() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04141(this, null), 3, null);
    }

    public final void playOpeningRemarksTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04151(this, null), 2, null);
    }

    public final void playWakeupTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04201(this, null), 2, null);
    }

    private static final Unit setVUIMode$lambda$3() {
        return Unit.INSTANCE;
    }

    public final i1<AvatarUiState> getAvatarUiStateFlow() {
        return this.avatarUiStateFlow;
    }

    public final i1<com.larus.dora.impl.onboarding.othersmart.a> getDeviceStateFlow() {
        return this.deviceStateFlow;
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

    public final i1<r0> getWakeupQueryUiStateFlow() {
        return this.wakeupQueryUiStateFlow;
    }

    public final i1<Boolean> isMusicPlayingStateFlow() {
        return this.isMusicPlayingStateFlow;
    }

    public static final /* synthetic */ int access$getCurrentVuiMode$p(DoraExternalOnboardingViewModel r0) {
        return r0.currentVuiMode;
    }

    public static final /* synthetic */ DoraExternalOnboardingViewModel$dlayerCallback$1 access$getDlayerCallback$p(DoraExternalOnboardingViewModel r0) {
        return r0.dlayerCallback;
    }

    public static final /* synthetic */ com.larus.call_plugins_doubao_common.manager.r access$getMediaManager$p(DoraExternalOnboardingViewModel r0) {
        return r0.mediaManager;
    }

    public static final /* synthetic */ List access$getOnboardingTTSList(DoraExternalOnboardingViewModel r0) {
        return r0.getOnboardingTTSList();
    }

    public static final /* synthetic */ Set access$getPageEntryTTSPlayedKeys$p(DoraExternalOnboardingViewModel r0) {
        return r0.pageEntryTTSPlayedKeys;
    }

    public static final /* synthetic */ com.larus.dora.impl.onboarding.r access$getPlayer$p(DoraExternalOnboardingViewModel r0) {
        return r0.player;
    }

    public static final /* synthetic */ Integer access$getSoundId$p(DoraExternalOnboardingViewModel r0) {
        return r0.soundId;
    }

    public static final /* synthetic */ SoundPool access$getSoundPool$p(DoraExternalOnboardingViewModel r0) {
        return r0.soundPool;
    }

    public static final /* synthetic */ List access$getTtsDataCacheList$p(DoraExternalOnboardingViewModel r0) {
        return r0.ttsDataCacheList;
    }

    public static final /* synthetic */ z0 access$get_avatarUiStateFlow$p(DoraExternalOnboardingViewModel r0) {
        return r0._avatarUiStateFlow;
    }

    public static final /* synthetic */ z0 access$get_deviceStateFlow$p(DoraExternalOnboardingViewModel r0) {
        return r0._deviceStateFlow;
    }

    public static final /* synthetic */ Boolean access$get_isDoraSupportOnboarding$p(DoraExternalOnboardingViewModel r0) {
        return r0._isDoraSupportOnboarding;
    }

    public static final /* synthetic */ z0 access$get_isMusicPlayingStateFlow$p(DoraExternalOnboardingViewModel r0) {
        return r0._isMusicPlayingStateFlow;
    }

    public static final /* synthetic */ z0 access$get_queryStateFlow$p(DoraExternalOnboardingViewModel r0) {
        return r0._queryStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_ttsDataSharedFlow$p(DoraExternalOnboardingViewModel r0) {
        return r0._ttsDataSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_wakeupQueryUiStateFlow$p(DoraExternalOnboardingViewModel r0) {
        return r0._wakeupQueryUiStateFlow;
    }

    public static final /* synthetic */ AtomicBoolean access$isOpeningRemarksTTSPlayed$p(DoraExternalOnboardingViewModel r0) {
        return r0.isOpeningRemarksTTSPlayed;
    }

    public static final /* synthetic */ AtomicBoolean access$isQueryStopTeachTTSPlayed$p(DoraExternalOnboardingViewModel r0) {
        return r0.isQueryStopTeachTTSPlayed;
    }

    public static final /* synthetic */ AtomicBoolean access$isRadioTTSPlayed$p(DoraExternalOnboardingViewModel r0) {
        return r0.isRadioTTSPlayed;
    }

    public static final /* synthetic */ AtomicBoolean access$isWakeupTTSPlayed$p(DoraExternalOnboardingViewModel r0) {
        return r0.isWakeupTTSPlayed;
    }

    public static final /* synthetic */ void access$loopTTSData(DoraExternalOnboardingViewModel r0) {
        r0.loopTTSData();
    }

    public static final /* synthetic */ void access$onTTSPlayEnd(DoraExternalOnboardingViewModel r0) {
        r0.onTTSPlayEnd();
    }

    private final void handleMusicPlayModel(z98.f r6) {
        z0<r0> r0 = this._wakeupQueryUiStateFlow;
    L3:
        Object r1 = r0.getValue();
        Object r2 = (r0) r1;
        if ((r2 instanceof r0.d) == false) goto L7;
        g49.d.d(TAG, "handleMusicChatResponse: change UiState QueryTopic -> QueryMusic");
        r2 = new r0.b(r6);
    L10:
        if (r0.compareAndSet(r1, r2) == false) goto L3;
        return;
    L7:
        if ((r2 instanceof r0.e) == false) goto L10;
        g49.d.d(TAG, "handleMusicChatResponse: change UiState QueryTopicReenter -> QueryMusic");
        r2 = new r0.b(r6);
        goto L10
    }

    private final void playQueryStopTeachTTS(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04171(this, r7, null), 2, null);
    }

    private final void removeSamiListener(String r3) {
        g49.d.d(TAG, "removeSamiListener: reason=" + r3);
        com.larus.dora.impl.onboarding.d.b(null);
    }

    private static final Unit stopBackgroundMusic$lambda$5(DoraExternalOnboardingViewModel r1) {
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

    public final void enterKeyLongPressOnlyMode(boolean r8) {
        removeSamiListener("enterKeyLongPressOnlyMode");
        stopTTS("enterKeyLongPressOnlyMode");
        setVUIMode$default(this, 11, r8, null, 4, null);
    }

    public final void enterOnboardingMode(boolean r3) {
        boolean r0 = com.larus.dora.impl.onboarding.d.a;
        if (com.larus.dora.impl.onboarding.d.b == false) goto L7;
        if (r3 == true) goto L7;
        g49.d.d(TAG, "enterOnboardingMode: already in onboarding, skip");
        return;
    L7:
        setVUIMode(4, r3, new m());
    }

    public final void enterRadioOnlyMode(boolean r8) {
        removeSamiListener("enterRadioOnlyMode");
        stopTTS("enterRadioOnlyMode");
        setVUIMode$default(this, 7, r8, null, 4, null);
    }

    public final void enterVoiceOnlyMode(boolean r8) {
        removeSamiListener("enterVoiceOnlyMode");
        addSamiListener();
        setVUIMode$default(this, 6, r8, null, 4, null);
    }

    public final void gotoQueryMusicStopTeachStateIfNecessary(int r5) {
        z0<r0> r0 = this._wakeupQueryUiStateFlow;
    L3:
        Object r1 = r0.getValue();
        Object r2 = (r0) r1;
        if ((r2 instanceof r0.b) == false) goto L7;
        g49.d.d(TAG, "gotoQueryMusicStopTeachStateIfNecessary: change UiState QueryMusic -> QueryMusicStopTeach");
        playQueryStopTeachTTS(r5);
        r2 = r0.c.b;
    L7:
        if (r0.compareAndSet(r1, r2) == false) goto L3;
    }

    public final void playRadioTTS(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04181(this, r7, null), 2, null);
    }

    public final void playTTS(String r10) {
        Intrinsics.checkNotNullParameter(r10, "ttsText");
        Job r0 = this.playTtsJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.playTtsJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04191(r10, this, null), 2, null);
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

    public final void releasePageEntryTTS(String r3) {
        Intrinsics.checkNotNullParameter(r3, "pageKey");
        Set<String> r0 = this.pageEntryTTSPlayedKeys;
        monitor-enter(r0);
        this.pageEntryTTSPlayedKeys.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void stopTTS(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        g49.d.d(TAG, "stopTTS: reason=" + r3);
        Job r4 = this.playTtsJob;
        if (r4 == null) goto L5;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L5:
        this.playTtsJob = null;
        com.larus.call_plugins_doubao_common.manager.r r5 = this.mediaManager;
        if (r5 == null) goto L8;
        com.larus.call_plugins_doubao_common.manager.n0.b(r5);
    L8:
        onTTSPlayEnd();
        b59.a r6 = b59.a.b.a;
        ((CopyOnWriteArraySet) r6.a).remove(this.dlayerCallback);
        monitor-enter(r6);
        g49.d.d("Dlayer", "stop");     // Catch: Throwable -> L13
        r6.b.SAMICoreDestroyHandle();     // Catch: Throwable -> L13
        monitor-exit(r6);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$setCurrentVuiMode$p(DoraExternalOnboardingViewModel r0, int r1) {
        r0.currentVuiMode = r1;
    }

    public static final /* synthetic */ void access$setMediaManager$p(DoraExternalOnboardingViewModel r0, com.larus.call_plugins_doubao_common.manager.r r1) {
        r0.mediaManager = r1;
    }

    public static final /* synthetic */ void access$setPlayer$p(DoraExternalOnboardingViewModel r0, com.larus.dora.impl.onboarding.r r1) {
        r0.player = r1;
    }

    public static final /* synthetic */ void access$setSoundId$p(DoraExternalOnboardingViewModel r0, Integer r1) {
        r0.soundId = r1;
    }

    public static final /* synthetic */ void access$setSoundPool$p(DoraExternalOnboardingViewModel r0, SoundPool r1) {
        r0.soundPool = r1;
    }

    public static final /* synthetic */ void access$set_isDoraSupportOnboarding$p(DoraExternalOnboardingViewModel r0, Boolean r1) {
        r0._isDoraSupportOnboarding = r1;
    }

    public static final /* synthetic */ String access$vuiText(DoraExternalOnboardingViewModel r0, int r1) {
        return r0.vuiText(r1);
    }

    private static final Unit addSamiListener$lambda$12(DoraExternalOnboardingViewModel r1, z98.f r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.handleMusicPlayModel(r2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0073 -> B:27:0x00b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00aa -> B:26:0x00af). Please report as a decompilation issue!!! */
    private final Object ensureSetVoiWakeupEnable(String r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r12 = r0.I$1;
        int r5 = r0.I$0;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L26:
        String r13 = r6;
        Object r7 = r2;
        AnonymousClass1 r8 = r0;
        int r14 = r5;
        Object r15 = r7;
    L27:
        r12 = r12 + 1;
    L16:
        if (r12 >= 4) goto L28;
        r14 = DoraAdapterExtKt.M(kj4.a.g(), true);
        g49.d.d(TAG, r13 + "_isDoraSupportOnboarding: enable voice wakeup (try " + r12 + "/3) ret=" + r14);
        if (r14 == 0) goto L28;
        if (r12 >= 3) goto L27;
        g49.d.e(TAG, r13 + "_isDoraSupportOnboarding: enable voice wakeup failed (try " + r12 + "/3, ret=" + r14 + "), retry after 300ms");
        r8.L$0 = r13;
        r8.I$0 = r14;
        r8.I$1 = r12;
        r8.label = 1;
        if (DelayKt.delay(300, r8) != r15) goto L25;
        return r15;
    L25:
        r6 = r13;
        Object r16 = r15;
        r5 = r14;
        r0 = r8;
        r2 = r16;
    L28:
        if (r14 == 0) goto L30;
        g49.d.b(TAG, r13 + "_isDoraSupportOnboarding: enable voice wakeup failed after 3 tries, last ret=" + r14);
    L30:
        if (r14 == 0) goto L34;
        r4 = false;
    L34:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r13 = r9;
        r15 = r2;
        r12 = 1;
        r8 = r0;
        r14 = -1;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    public static final /* synthetic */ Object access$ensureSetVoiWakeupEnable(DoraExternalOnboardingViewModel r0, String r1, Continuation r2) {
        return r0.ensureSetVoiWakeupEnable(r1, r2);
    }

    public static /* synthetic */ Object isDoraSupportOnboarding$suspendImpl(DoraExternalOnboardingViewModel r3, String r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r3, r4, null), r5);
    }

    private final void setVUIMode(int r11, boolean r12, Function0<Unit> r13) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C04222(this, r11, r12, r13, null), 2, null);
    }

    public final void playPageEntryTTSIfNeeded(String r12, int r13, long r14) {
        Intrinsics.checkNotNullParameter(r12, "pageKey");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04161(this, r12, r14, r13, null), 2, null);
    }

    public static /* synthetic */ void enterKeyLongPressOnlyMode$default(DoraExternalOnboardingViewModel r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.enterKeyLongPressOnlyMode(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterKeyLongPressOnlyMode");
    }

    public static /* synthetic */ void enterOnboardingMode$default(DoraExternalOnboardingViewModel r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.enterOnboardingMode(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterOnboardingMode");
    }

    public static /* synthetic */ void enterRadioOnlyMode$default(DoraExternalOnboardingViewModel r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.enterRadioOnlyMode(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterRadioOnlyMode");
    }

    public static /* synthetic */ void enterVoiceOnlyMode$default(DoraExternalOnboardingViewModel r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.enterVoiceOnlyMode(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterVoiceOnlyMode");
    }

    public static /* synthetic */ Object ensureSetVoiWakeupEnable$default(DoraExternalOnboardingViewModel r0, String r1, Continuation r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = "";
    L7:
        return r0.ensureSetVoiWakeupEnable(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureSetVoiWakeupEnable");
    }

    public static /* synthetic */ void playPageEntryTTSIfNeeded$default(DoraExternalOnboardingViewModel r0, String r1, int r2, long r3, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 4) == 0) goto L6;
        r3 = 500;
    L6:
        r0.playPageEntryTTSIfNeeded(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playPageEntryTTSIfNeeded");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setVUIMode$default(DoraExternalOnboardingViewModel r0, int r1, boolean r2, Function0 r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = false;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = new p();
    L9:
        r0.setVUIMode(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setVUIMode");
    }
}
