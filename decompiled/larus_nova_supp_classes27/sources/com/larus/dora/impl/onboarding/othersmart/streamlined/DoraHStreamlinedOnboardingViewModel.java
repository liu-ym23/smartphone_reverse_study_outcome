package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.app.Application;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.onboarding.OnboardingAvatarProvider;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.SimplifiedTopic;
import com.larus.dora.impl.settings.c1;
import com.larus.dora.impl.settings.f1;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\u0013\n\u0002\b\r*\u0003x\u008b\u0001\u0018\u0000 \u0096\u00012\u00020\u0001:\u0002\u0096\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010<\u001a\u00020\u000eH\u0002J\b\u0010=\u001a\u000202H\u0002J\b\u0010>\u001a\u00020\u000eH\u0002J\b\u0010?\u001a\u00020\u001bH\u0002J\b\u0010@\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\u0010\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u001fH\u0002J\u0010\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u001fH\u0002J\u0010\u0010F\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u001fH\u0002J\u0018\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0014H\u0002J\u0017\u0010K\u001a\u0004\u0018\u0001022\u0006\u0010L\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010MJ\u001e\u0010N\u001a\u00020\u000e2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010J\u001a\u00020\u0014H\u0002J\u0018\u0010P\u001a\u0002022\u0006\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001bH\u0002J\u0012\u0010S\u001a\u00020\u000e2\b\u0010T\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010U\u001a\u00020\u000e2\b\u0010V\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010W\u001a\u00020\u000eH\u0002J \u0010X\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\u001b2\u0006\u0010Z\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020\u0014H\u0002J\u0010\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u000202H\u0002J\b\u0010^\u001a\u00020\u000eH\u0002J\u0018\u0010_\u001a\u00020\u000e2\u0006\u0010]\u001a\u0002022\u0006\u0010`\u001a\u00020\u001bH\u0002J\b\u0010a\u001a\u00020\u000eH\u0002J\u000e\u0010b\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u001bJ\u0010\u0010c\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020\u00142\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010g\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010g\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\u001bH\u0002J\u0017\u0010h\u001a\u00020\u00142\n\b\u0002\u0010]\u001a\u0004\u0018\u000102¢\u0006\u0002\u0010iJ\u0006\u0010j\u001a\u00020\u000eJ\u0006\u0010k\u001a\u00020\u000eJ\u000e\u0010l\u001a\u00020\u000e2\u0006\u0010m\u001a\u00020\u001fJ\u0010\u0010n\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020\u001bH\u0002J\u000e\u0010p\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010qJ\b\u0010r\u001a\u00020\u000eH\u0002J\u0006\u0010s\u001a\u00020\u000eJ\u0006\u0010t\u001a\u00020\u000eJ\u0006\u0010u\u001a\u00020\u000eJ\u0006\u0010v\u001a\u00020\u000eJ\u0010\u0010|\u001a\u0004\u0018\u00010\u001bH\u0082@¢\u0006\u0002\u0010qJ\u0006\u0010}\u001a\u00020\u000eJ\u0006\u0010~\u001a\u00020\u000eJ\u0014\u0010\u007f\u001a\u00020\u000e2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u001bH\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0081\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010\u0082\u0001\u001a\u00020\u00142\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001bH\u0002J\u0014\u0010\u0084\u0001\u001a\u00020\u00142\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001bH\u0002J\u0014\u0010\u0085\u0001\u001a\u00020\u000e2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001bH\u0002J\t\u0010\u0087\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\u001b2\u0007\u0010\u0089\u0001\u001a\u00020\u001bH\u0002J\u0007\u0010\u008d\u0001\u001a\u00020\u000eJ\u0007\u0010\u008e\u0001\u001a\u00020\u000eJ\u001a\u0010\u008f\u0001\u001a\u00020\u000e2\u0007\u0010\u0089\u0001\u001a\u00020\u001b2\b\b\u0002\u0010R\u001a\u00020\u001bJ\u0012\u0010\u0090\u0001\u001a\u00020\u000e2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u0014J\u0012\u0010\u0092\u0001\u001a\u00020\u000e2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u0014J\u0012\u0010\u0093\u0001\u001a\u00020\u000e2\u0007\u0010\u0091\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0094\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0095\u0001\u001a\u00020\u000eH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000bR\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u00103R\u000e\u00106\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0004\n\u0002\u0010yR\u000e\u0010z\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008c\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel;", "<init>", "()V", "_simplifiedTopicsFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/dora/impl/settings/SimplifiedTopic;", "simplifiedTopicsFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getSimplifiedTopicsFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_tickerFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "tickerFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getTickerFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_navigateToInterruptEvent", "", "navigateToInterruptEvent", "getNavigateToInterruptEvent", "_navigateNextEvent", "navigateNextEvent", "getNavigateNextEvent", "_avatarUrlFlow", "", "avatarUrlFlow", "getAvatarUrlFlow", "_interruptUiState", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedInterruptUiState;", "interruptUiState", "getInterruptUiState", "_queryTextFlow", "queryTextFlow", "getQueryTextFlow", "_typewriterText", "typewriterText", "getTypewriterText", "_typewriterVisibility", "typewriterVisibility", "getTypewriterVisibility", "pendingBuffer", "Ljava/lang/StringBuilder;", "displayedBuffer", "typewriterJob", "Lkotlinx/coroutines/Job;", "replyLoadingTimeoutJob", "replyLoadingTimeoutRoundToken", "", "Ljava/lang/Long;", "currentRoundToken", "activeRoundToken", "allowAsrEndNavigateToInterrupt", "isVoiceCallbackRegistered", "tickerJob", "avatarFetchJob", "asrResultListener", "Lcom/larus/dora/impl/plugin/IDoraAsrListener;", "resetTypewriterState", "nextRoundToken", "invalidateActiveRound", "getReplyLoadingText", "getReplyFallbackText", "getMusicPlaybackText", "publishInterruptUiState", "newState", "bridgeQueryTextState", "state", "bridgeLegacyTypewriterState", "startNewRound", "queryState", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/StreamlinedQueryUiState;", "shouldPlayEntryAnimation", "requireActiveRoundToken", "caller", "(Ljava/lang/String;)Ljava/lang/Long;", "startVoiceQueryRound", "initialText", "startPresetQueryRound", "queryText", "source", "updateActiveQueryText", "text", "submitActiveVoiceQuery", "finalText", "showReplyLoading", "updateReplyContent", "fullText", "displayedText", "isCompleted", "ensureReplyLoadingTimeout", "roundToken", "cancelReplyLoadingTimeout", "showReplyFallback", "fallbackText", "showMusicPlaybackReply", "appendTypewriterText", "handleTypewriterMessageUpdate", "msg", "Lcom/larus/im/bean/message/Message;", "isMusicPlaylistWidgetMessage", "updateTypewriterText", "consumeEntryAnimation", "(Ljava/lang/Long;)Z", "onInterruptPageShown", "onInterruptPageBack", "restoreInterruptUiState", "savedState", "stopCurrentVuiSession", "reason", "navigateToInterruptOnAsrEndIfAllowed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTypewriter", "mockTypewriterForTest", "startTicker", "stopTicker", "fetchAvatarUrl", "globalMessageObserver", "com/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel$globalMessageObserver$1", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel$globalMessageObserver$1;", "isObserverRegistered", "registeredConversationId", "getMainConversationId", "registerMessageObserver", "unregisterMessageObserver", "prepareVoiceQuery", "isShowingPresetClickQuery", "shouldPrepareVoiceRoundOnAsrStart", "shouldReplacePresetClickRoundWithVoiceQuery", "kw", "shouldRestartVoiceRoundForIncomingQuery", "handleAsrQueryUpdate", "asrText", "registerAsrResultListener", "resolvePresetQueryText", "queryKey", "voiceCallback", "com/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel$voiceCallback$1", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel$voiceCallback$1;", "registerVoiceCallback", "unregisterVoiceCallback", "sendQueryAndNext", "skipToInterrupt", "useSharedElement", "skipAndNext", "emitNavigateToInterrupt", "isNetworkAvailable", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedOnboardingViewModel extends DoraExternalOnboardingViewModel {
    public static final a Companion = null;
    private static final String MUSIC_WIDGET_ID_PLAYLIST = "widget__playlist";
    private static final String QUERY_SOURCE_CLICK = "click";
    private static final String QUERY_SOURCE_VOICE = "voice";
    private static final long REPLY_LOADING_TIMEOUT_MS = 30000;
    public static final String TAG = "DoraHStreamlinedOnboardingViewModel";
    private final z0<String> _avatarUrlFlow;
    private final z0<o> _interruptUiState;
    private final MutableSharedFlow<Boolean> _navigateNextEvent;
    private final MutableSharedFlow<Boolean> _navigateToInterruptEvent;
    private final z0<String> _queryTextFlow;
    private final z0<List<SimplifiedTopic>> _simplifiedTopicsFlow;
    private final MutableSharedFlow<Unit> _tickerFlow;
    private final z0<String> _typewriterText;
    private final z0<Boolean> _typewriterVisibility;
    private Long activeRoundToken;
    private boolean allowAsrEndNavigateToInterrupt;
    private m69.e asrResultListener;
    private Job avatarFetchJob;
    private final i1<String> avatarUrlFlow;
    private long currentRoundToken;
    private final StringBuilder displayedBuffer;
    private final DoraHStreamlinedOnboardingViewModel$globalMessageObserver$1 globalMessageObserver;
    private final i1<o> interruptUiState;
    private boolean isObserverRegistered;
    private boolean isVoiceCallbackRegistered;
    private final d1<Boolean> navigateNextEvent;
    private final d1<Boolean> navigateToInterruptEvent;
    private final StringBuilder pendingBuffer;
    private final i1<String> queryTextFlow;
    private String registeredConversationId;
    private Job replyLoadingTimeoutJob;
    private Long replyLoadingTimeoutRoundToken;
    private final i1<List<SimplifiedTopic>> simplifiedTopicsFlow;
    private final d1<Unit> tickerFlow;
    private Job tickerJob;
    private Job typewriterJob;
    private final i1<String> typewriterText;
    private final i1<Boolean> typewriterVisibility;
    private final DoraHStreamlinedOnboardingViewModel$voiceCallback$1 voiceCallback;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$emitNavigateToInterrupt$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$emitNavigateToInterrupt$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {968}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $useSharedElement;
        int label;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public AnonymousClass1(DoraHStreamlinedOnboardingViewModel r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$useSharedElement = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$useSharedElement, r4);
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
            MutableSharedFlow r5 = DoraHStreamlinedOnboardingViewModel.access$get_navigateToInterruptEvent$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(this.$useSharedElement);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$ensureReplyLoadingTimeout$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$ensureReplyLoadingTimeout$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $roundToken;
        int label;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public C04231(DoraHStreamlinedOnboardingViewModel r1, long r2, Continuation<? super C04231> r4) {
            this.this$0 = r1;
            this.$roundToken = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04231(this.this$0, this.$roundToken, r5);
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
        L11:
            Long r6 = DoraHStreamlinedOnboardingViewModel.access$getActiveRoundToken$p(this.this$0);
            long r2 = this.$roundToken;
            if (r6 == null) goto L17;
            if (r6.longValue() != r2) goto L17;
            if ((((o) DoraHStreamlinedOnboardingViewModel.access$get_interruptUiState$p(this.this$0).getValue()).d instanceof o0.c) == false) goto L21;
            g49.d.e(DoraHStreamlinedOnboardingViewModel.TAG, "reply loading timeout, roundToken=" + this.$roundToken);
            DoraHStreamlinedOnboardingViewModel r7 = this.this$0;
            DoraHStreamlinedOnboardingViewModel.access$showReplyFallback(r7, this.$roundToken, DoraHStreamlinedOnboardingViewModel.access$getReplyFallbackText(r7));
            return Unit.INSTANCE;
        L21:
            return Unit.INSTANCE;
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            if (DelayKt.delay(30000, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$fetchAvatarUrl$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$fetchAvatarUrl$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {678}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public C04241(DoraHStreamlinedOnboardingViewModel r1, Continuation<? super C04241> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04241(this.this$0, r3);
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
            DoraHStreamlinedOnboardingViewModel.access$get_avatarUrlFlow$p(this.this$0).setValue(r5);
        L19:
            DoraHStreamlinedOnboardingViewModel.access$setAvatarFetchJob$p(this.this$0, null);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$getMainConversationId$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {719}, m = "getMainConversationId", n = {}, s = {})
    public static final class C04251 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public C04251(DoraHStreamlinedOnboardingViewModel r1, Continuation<? super C04251> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraHStreamlinedOnboardingViewModel.access$getMainConversationId(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$mockTypewriterForTest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$mockTypewriterForTest$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {645}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public C04261(DoraHStreamlinedOnboardingViewModel r1, Continuation<? super C04261> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04261(this.this$0, r3);
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
        L11:
            this.this$0.appendTypewriterText("豆包正在为您解答，这是一段测试用的流式返回消息。打字机效果应该会平滑输出这些内容，而不会卡顿或闪烁。");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            if (DelayKt.delay(1000, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$registerMessageObserver$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$registerMessageObserver$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {726}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public C04281(DoraHStreamlinedOnboardingViewModel r1, Continuation<? super C04281> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04281(this.this$0, r3);
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
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            String r6 = (String) r5;
            if (DoraHStreamlinedOnboardingViewModel.access$isObserverRegistered$p(this.this$0) == true) goto L16;
            g49.d.d(DoraHStreamlinedOnboardingViewModel.TAG, "registerMessageObserver canceled: observer already unregistered");
            return Unit.INSTANCE;
        L16:
            if (r6 != null) goto L18;
        L21:
            if (r2 == false) goto L24;
            DoraHStreamlinedOnboardingViewModel.access$setObserverRegistered$p(this.this$0, false);
            g49.d.e(DoraHStreamlinedOnboardingViewModel.TAG, "registerMessageObserver failed: mainConversationId is null or empty");
            return Unit.INSTANCE;
        L24:
            DoraHStreamlinedOnboardingViewModel.access$setRegisteredConversationId$p(this.this$0, r6);
            g49.d.d(DoraHStreamlinedOnboardingViewModel.TAG, "registerMessageObserver: conversationId=" + r6);
            com.larus.im.d.e().registerOnMessageChangedObserver(r6, DoraHStreamlinedOnboardingViewModel.access$getGlobalMessageObserver$p(this.this$0));
            return Unit.INSTANCE;
        L18:
            if (r6.length() == 0) goto L21;
            r2 = false;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DoraHStreamlinedOnboardingViewModel r7 = this.this$0;
            this.label = 1;
            r5 = DoraHStreamlinedOnboardingViewModel.access$getMainConversationId(r7, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$skipAndNext$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$skipAndNext$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {959}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $useSharedElement;
        int label;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public C04291(DoraHStreamlinedOnboardingViewModel r1, boolean r2, Continuation<? super C04291> r3) {
            this.this$0 = r1;
            this.$useSharedElement = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04291(this.this$0, this.$useSharedElement, r4);
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
            MutableSharedFlow r5 = DoraHStreamlinedOnboardingViewModel.access$get_navigateNextEvent$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(this.$useSharedElement);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$startTicker$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$startTicker$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {0, 1}, l = {654, 655}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    public static final class C04301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public C04301(DoraHStreamlinedOnboardingViewModel r1, Continuation<? super C04301> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04301 r0 = new C04301(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0054 -> B:12:0x0031). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = r2;
        L11:
            C04301 r3 = this;
        L13:
            if (CoroutineScopeKt.isActive(r8) == false) goto L21;
            r3.L$0 = r8;
            r3.label = 1;
            if (DelayKt.delay(3000, r3) != r0) goto L17;
            return r0;
        L17:
            MutableSharedFlow r4 = DoraHStreamlinedOnboardingViewModel.access$get_tickerFlow$p(r3.this$0);
            Unit r5 = Unit.INSTANCE;
            r3.L$0 = r8;
            r3.label = 2;
            if (r4.emit(r5, r3) != r0) goto L13;
            return r0;
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r7);
            r8 = r6;
            r3 = this;
            goto L17
        L10:
            ResultKt.throwOnFailure(r7);
            r8 = (CoroutineScope) this.L$0;
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$startTypewriter$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$startTypewriter$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {629}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $roundToken;
        int label;
        final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

        public C04311(DoraHStreamlinedOnboardingViewModel r1, long r2, Continuation<? super C04311> r4) {
            this.this$0 = r1;
            this.$roundToken = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04311(this.this$0, this.$roundToken, r5);
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
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 == 1) goto L8;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
        L9:
            Long r3 = DoraHStreamlinedOnboardingViewModel.access$getActiveRoundToken$p(this.this$0);
            long r4 = this.$roundToken;
            if (r3 == null) goto L19;
            if (r3.longValue() != r4) goto L19;
            if (DoraHStreamlinedOnboardingViewModel.access$getDisplayedBuffer$p(this.this$0).length() >= DoraHStreamlinedOnboardingViewModel.access$getPendingBuffer$p(this.this$0).length()) goto L19;
            DoraHStreamlinedOnboardingViewModel.access$getDisplayedBuffer$p(this.this$0).append(DoraHStreamlinedOnboardingViewModel.access$getPendingBuffer$p(this.this$0).charAt(DoraHStreamlinedOnboardingViewModel.access$getDisplayedBuffer$p(this.this$0).length()));
            DoraHStreamlinedOnboardingViewModel r5 = this.this$0;
            DoraHStreamlinedOnboardingViewModel.access$updateReplyContent(r5, DoraHStreamlinedOnboardingViewModel.access$getPendingBuffer$p(r5).toString(), DoraHStreamlinedOnboardingViewModel.access$getDisplayedBuffer$p(this.this$0).toString(), false);
            this.label = 1;
            if (DelayKt.delay(100, this) != r0) goto L9;
            return r0;
        L19:
            Long r6 = DoraHStreamlinedOnboardingViewModel.access$getActiveRoundToken$p(this.this$0);
            long r7 = this.$roundToken;
            if (r6 != null) goto L23;
        L24:
            g49.d.d(DoraHStreamlinedOnboardingViewModel.TAG, "startTypewriter stop: roundToken changed from " + this.$roundToken + " to " + DoraHStreamlinedOnboardingViewModel.access$getActiveRoundToken$p(this.this$0));
            return Unit.INSTANCE;
        L23:
            if (r6.longValue() != r7) goto L24;
            DoraHStreamlinedOnboardingViewModel r8 = this.this$0;
            String r10 = DoraHStreamlinedOnboardingViewModel.access$getPendingBuffer$p(r8).toString();
            String r11 = DoraHStreamlinedOnboardingViewModel.access$getDisplayedBuffer$p(this.this$0).toString();
            if (DoraHStreamlinedOnboardingViewModel.access$getDisplayedBuffer$p(this.this$0).length() > 0) goto L30;
            r2 = false;
        L30:
            DoraHStreamlinedOnboardingViewModel.access$updateReplyContent(r8, r10, r11, r2);
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new a();
    }

    private final String getReplyFallbackText() {
        return "暂时没能拿到回复，你可以再试一次。";
    }

    public final void onInterruptPageShown() {
        this.allowAsrEndNavigateToInterrupt = false;
    }

    private final void cancelReplyLoadingTimeout() {
        Job r0 = this.replyLoadingTimeoutJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.replyLoadingTimeoutJob = null;
        this.replyLoadingTimeoutRoundToken = null;
    }

    private final String getMusicPlaybackText() {
        return AppHost.a.getApplication().getString(2131903757);
    }

    private final String getReplyLoadingText() {
        return AppHost.a.getApplication().getString(2131903674);
    }

    private final void invalidateActiveRound() {
        this.currentRoundToken++;
        this.activeRoundToken = null;
    }

    private final boolean isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailable(AppHost.a.getApplication());
    }

    private final boolean isShowingPresetClickQuery() {
        n0 r0 = ((o) this._interruptUiState.getValue()).b;
        if ((r0 instanceof n0.c) == false) goto L5;
        n0.c r1 = (n0.c) r0;
    L7:
        if (r1 != null) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r1.c, QUERY_SOURCE_CLICK) == false) goto L21;
        String r2 = r1.b;
        if (r2 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L22;
        return true;
    L22:
        return false;
    L14:
        if (StringsKt.isBlank(r2) == true) goto L17;
        r3 = false;
        goto L18
    L21:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    private final long nextRoundToken() {
        long r0 = this.currentRoundToken + 1;
        this.currentRoundToken = r0;
        return r0;
    }

    private final void registerAsrResultListener() {
        if (this.asrResultListener == null) goto L5;
        return;
    L5:
        m69.e r0 = new C04271(this);
        m69.a r1 = m69.a.a;
        m69.a.b(r0);
        this.asrResultListener = r0;
    }

    private final void resetTypewriterState() {
        g49.d.d(TAG, "resetTypewriterState");
        Job r0 = this.typewriterJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.typewriterJob = null;
        cancelReplyLoadingTimeout();
        invalidateActiveRound();
        StringsKt.clear(this.pendingBuffer);
        StringsKt.clear(this.displayedBuffer);
        publishInterruptUiState(new o(n0.a.a, o0.b.a, 4));
    }

    private final boolean shouldPrepareVoiceRoundOnAsrStart() {
        if (this.activeRoundToken != null) goto L6;
        return true;
    L6:
        return !isShowingPresetClickQuery();
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
        this.avatarFetchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04241(this, null), 2, null);
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

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel
    public void onCleared() {
        m69.e r0 = this.asrResultListener;
        if (r0 == null) goto L5;
        m69.a r1 = m69.a.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        m69.a.b.remove(r0);
    L5:
        this.asrResultListener = null;
        super.onCleared();
    }

    public final void registerMessageObserver() {
        if (this.isObserverRegistered == false) goto L5;
        return;
    L5:
        this.isObserverRegistered = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04281(this, null), 3, null);
    }

    public final void registerVoiceCallback() {
        if (this.isVoiceCallbackRegistered == false) goto L5;
        return;
    L5:
        kj4.a.g().registerDoraVoiceCallback(this.voiceCallback);
        this.isVoiceCallbackRegistered = true;
    }

    public final void startTicker() {
        Job r0 = this.tickerJob;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        this.tickerJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C04301(this, null), 2, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void stopTicker() {
        Job r0 = this.tickerJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.tickerJob = null;
    }

    public final void unregisterMessageObserver() {
        if (this.isObserverRegistered == true) goto L5;
        return;
    L5:
        String r0 = this.registeredConversationId;
        boolean r1 = false;
        this.isObserverRegistered = false;
        if (r0 != null) goto L8;
    L9:
        r1 = true;
    L11:
        if (r1 == false) goto L14;
        g49.d.e(TAG, "unregisterMessageObserver failed: registeredConversationId is null or empty");
        this.registeredConversationId = null;
        return;
    L14:
        g49.d.d(TAG, "unregisterMessageObserver: conversationId=" + r0);
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r0, this.globalMessageObserver);
        this.registeredConversationId = null;
        return;
    L8:
        if (r0.length() != 0) goto L11;
        goto L9
    }

    public final void unregisterVoiceCallback() {
        if (this.isVoiceCallbackRegistered == true) goto L5;
        return;
    L5:
        kj4.a.g().unRegisterDoraVoiceCallback(this.voiceCallback);
        this.isVoiceCallbackRegistered = false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$globalMessageObserver$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$voiceCallback$1] */
    public DoraHStreamlinedOnboardingViewModel() {
        StateFlowImpl r0 = j1.a(CollectionsKt.emptyList());
        this._simplifiedTopicsFlow = r0;
        this.simplifiedTopicsFlow = r0;
        MutableSharedFlow<Unit> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._tickerFlow = r4;
        this.tickerFlow = r4;
        MutableSharedFlow<Boolean> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._navigateToInterruptEvent = r5;
        this.navigateToInterruptEvent = r5;
        MutableSharedFlow<Boolean> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._navigateNextEvent = r1;
        this.navigateNextEvent = r1;
        StateFlowImpl r2 = j1.a(null);
        this._avatarUrlFlow = r2;
        this.avatarUrlFlow = r2;
        StateFlowImpl r3 = j1.a(new o(null, null, 15));
        this._interruptUiState = r3;
        this.interruptUiState = r3;
        StateFlowImpl r6 = j1.a("");
        this._queryTextFlow = r6;
        this.queryTextFlow = r6;
        StateFlowImpl r7 = j1.a("");
        this._typewriterText = r7;
        this.typewriterText = r7;
        StateFlowImpl r8 = j1.a(Boolean.FALSE);
        this._typewriterVisibility = r8;
        this.typewriterVisibility = r8;
        this.pendingBuffer = new StringBuilder();
        this.displayedBuffer = new StringBuilder();
        this.allowAsrEndNavigateToInterrupt = true;
        DoraSetting.a.getClass();
        int r9 = com.larus.utils.l0.a;
        List r10 = (List) com.larus.utils.l0.a(f1.d, new c1());
        if (r10 != null) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        r0.setValue(r10);
        String r11 = OnboardingAvatarProvider.c;
        if (r11 == null) goto L8;
        r2.setValue(r11);
    L8:
        registerAsrResultListener();
        this.globalMessageObserver = new DoraHStreamlinedOnboardingViewModel$globalMessageObserver$1(this);
        this.voiceCallback = new DoraHStreamlinedOnboardingViewModel$voiceCallback$1(this);
    }

    private final void showMusicPlaybackReply() {
        String r0 = getMusicPlaybackText();
        Long r1 = requireActiveRoundToken("showMusicPlaybackReply");
        if (r1 == null) goto L9;
        long r3 = r1.longValue();
        cancelReplyLoadingTimeout();
        StringsKt.clear(this.pendingBuffer);
        StringsKt.clear(this.displayedBuffer);
        Job r2 = this.typewriterJob;
        if (r2 == null) goto L7;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L7:
        this.typewriterJob = null;
        publishInterruptUiState(o.a((o) this._interruptUiState.getValue(), r3, null, new o0.a(r3, r0), 6));
        return;
    }

    private final void showReplyLoading() {
        Long r0 = requireActiveRoundToken("showReplyLoading");
        if (r0 == null) goto L6;
        long r2 = r0.longValue();
        ensureReplyLoadingTimeout(r2);
        publishInterruptUiState(o.a((o) this._interruptUiState.getValue(), r2, null, new o0.c(r2, getReplyLoadingText()), 6));
        return;
    }

    private final void startTypewriter() {
        Long r0 = requireActiveRoundToken("startTypewriter");
        if (r0 == null) goto L6;
        long r1 = r0.longValue();
        this.typewriterJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04311(this, r1, null), 3, null);
        return;
    }

    public final void mockTypewriterForTest() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04261(this, null), 3, null);
    }

    public final void onInterruptPageBack() {
        resetTypewriterState();
        stopTTS("onInterruptPageBack");
        stopCurrentVuiSession("onInterruptPageBack");
        this.allowAsrEndNavigateToInterrupt = true;
    }

    public final i1<String> getAvatarUrlFlow() {
        return this.avatarUrlFlow;
    }

    public final i1<o> getInterruptUiState() {
        return this.interruptUiState;
    }

    public final d1<Boolean> getNavigateNextEvent() {
        return this.navigateNextEvent;
    }

    public final d1<Boolean> getNavigateToInterruptEvent() {
        return this.navigateToInterruptEvent;
    }

    public final i1<String> getQueryTextFlow() {
        return this.queryTextFlow;
    }

    public final i1<List<SimplifiedTopic>> getSimplifiedTopicsFlow() {
        return this.simplifiedTopicsFlow;
    }

    public final d1<Unit> getTickerFlow() {
        return this.tickerFlow;
    }

    public final i1<String> getTypewriterText() {
        return this.typewriterText;
    }

    public final i1<Boolean> getTypewriterVisibility() {
        return this.typewriterVisibility;
    }

    public static final /* synthetic */ Long access$getActiveRoundToken$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0.activeRoundToken;
    }

    public static final /* synthetic */ StringBuilder access$getDisplayedBuffer$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0.displayedBuffer;
    }

    public static final /* synthetic */ DoraHStreamlinedOnboardingViewModel$globalMessageObserver$1 access$getGlobalMessageObserver$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0.globalMessageObserver;
    }

    public static final /* synthetic */ StringBuilder access$getPendingBuffer$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0.pendingBuffer;
    }

    public static final /* synthetic */ String access$getReplyFallbackText(DoraHStreamlinedOnboardingViewModel r0) {
        return r0.getReplyFallbackText();
    }

    public static final /* synthetic */ z0 access$get_avatarUrlFlow$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0._avatarUrlFlow;
    }

    public static final /* synthetic */ z0 access$get_interruptUiState$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0._interruptUiState;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_navigateNextEvent$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0._navigateNextEvent;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_navigateToInterruptEvent$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0._navigateToInterruptEvent;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_tickerFlow$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0._tickerFlow;
    }

    public static final /* synthetic */ boolean access$isObserverRegistered$p(DoraHStreamlinedOnboardingViewModel r0) {
        return r0.isObserverRegistered;
    }

    public static final /* synthetic */ boolean access$shouldPrepareVoiceRoundOnAsrStart(DoraHStreamlinedOnboardingViewModel r0) {
        return r0.shouldPrepareVoiceRoundOnAsrStart();
    }

    private final void bridgeLegacyTypewriterState(o r2) {
        o0 r3 = r2.d;
        if (Intrinsics.areEqual(r3, o0.b.a) == false) goto L6;
        this._typewriterText.setValue("");
        this._typewriterVisibility.setValue(Boolean.FALSE);
        return;
    L6:
        if ((r3 instanceof o0.c) == false) goto L9;
        this._typewriterText.setValue(((o0.c) r3).b);
        this._typewriterVisibility.setValue(Boolean.TRUE);
        return;
    L9:
        if ((r3 instanceof o0.d) == false) goto L12;
        this._typewriterText.setValue(((o0.d) r3).c);
        this._typewriterVisibility.setValue(Boolean.TRUE);
        return;
    L12:
        if ((r3 instanceof o0.a) == false) goto L16;
        this._typewriterText.setValue(((o0.a) r3).b);
        this._typewriterVisibility.setValue(Boolean.TRUE);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    private final void bridgeQueryTextState(o r4) {
        z0<String> r0 = this._queryTextFlow;
        n0 r5 = r4.b;
        String r2 = "";
        if (Intrinsics.areEqual(r5, n0.a.a) == false) goto L6;
    L14:
        r0.setValue(r2);
        return;
    L6:
        if ((r5 instanceof n0.b) == false) goto L9;
        r2 = ((n0.b) r5).c;
        goto L14
    L9:
        if ((r5 instanceof n0.c) == false) goto L17;
        String r6 = ((n0.c) r5).b;
        if (r6 == null) goto L14;
        r2 = r6;
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    }

    private final void emitNavigateToInterrupt(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r7, null), 3, null);
    }

    private final void ensureReplyLoadingTimeout(long r8) {
        Long r0 = this.replyLoadingTimeoutRoundToken;
        if (r0 != null) goto L6;
    L14:
        cancelReplyLoadingTimeout();
        this.replyLoadingTimeoutRoundToken = Long.valueOf(r8);
        this.replyLoadingTimeoutJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04231(this, r8, null), 3, null);
        return;
    L6:
        if (r0.longValue() != r8) goto L14;
        Job r1 = this.replyLoadingTimeoutJob;
        boolean r2 = false;
        if (r1 != null) goto L10;
    L12:
        if (r2 == false) goto L14;
        return;
    L10:
        if (r1.isActive() != true) goto L12;
        r2 = true;
        goto L12
    }

    private final Object getMainConversationId(Continuation<? super String> r5) {
        if ((r5 instanceof C04251) == false) goto L7;
        C04251 r0 = (C04251) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        wc9.e r7 = (wc9.e) r6;
        if (r7 != null) goto L22;
        return null;
    L22:
        return r7.a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        IChatRepoService r8 = zh8.a.a;
        IConversationRepoService r9 = zh8.a.b;
        r0.label = 1;
        r6 = r9.f(r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new C04251(this, r5);
        goto L8
    }

    private final void handleAsrQueryUpdate(String r4) {
        if (r4 == null) goto L4;
        String r0 = StringsKt.trim(r4).toString();
    L5:
        g49.d.a(TAG, "handleAsrQueryUpdate: asrText=" + r4 + ", normalizedText=" + r0);
        if (r0 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L15;
        return;
    L15:
        if (this.activeRoundToken != null) goto L18;
        prepareVoiceQuery(r0);
        return;
    L18:
        if (shouldReplacePresetClickRoundWithVoiceQuery(r0) == false) goto L21;
        prepareVoiceQuery(r0);
        return;
    L21:
        if (shouldRestartVoiceRoundForIncomingQuery(r0) == false) goto L23;
        prepareVoiceQuery(r0);
        return;
    L23:
        updateActiveQueryText(r0);
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r5 = false;
        goto L12
    L4:
        r0 = null;
        goto L5
    }

    private final void handleTypewriterMessageUpdate(Message r4) {
        if (this.activeRoundToken != null) goto L7;
        g49.d.d(TAG, "handleTypewriterMessageUpdate ignored: no active round, msgId=" + r4.getMessageId());
        return;
    L7:
        if (Intrinsics.areEqual(r4.getSenderId(), AccountService.a.getUserId()) == false) goto L10;
        g49.d.d(TAG, "handleTypewriterMessageUpdate ignored: self message, msgId=" + r4.getMessageId() + ", localId=" + r4.getLocalMessageId());
        return;
    L10:
        int r0 = r4.getContentType();
        if (r0 != 1) goto L13;
        updateTypewriterText(r4);
        return;
    L13:
        if (r0 != 3) goto L15;
        showMusicPlaybackReply();
        return;
    L15:
        if (r0 == 100) goto L18;
        showReplyLoading();
        return;
    L18:
        if (isMusicPlaylistWidgetMessage(r4) == false) goto L20;
        showMusicPlaybackReply();
        return;
    L20:
        showReplyLoading();
    }

    private final boolean isMusicPlaylistWidgetMessage(Message r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        String r4 = r3.getContent();     // Catch: Throwable -> L7
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Object r5 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(new JSONObject(r4).optString("widget_id"), MUSIC_WIDGET_ID_PLAYLIST)));     // Catch: Throwable -> L7
    L9:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L13;
        r5 = r1;
    L13:
        return ((Boolean) r5).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    private final Object navigateToInterruptOnAsrEndIfAllowed(Continuation<? super Unit> r3) {
        if (this.allowAsrEndNavigateToInterrupt == true) goto L6;
        g49.d.d(TAG, "navigateToInterruptOnAsrEndIfAllowed ignored: auto navigation disabled");
        return Unit.INSTANCE;
    L6:
        this.allowAsrEndNavigateToInterrupt = false;
        Object r4 = this._navigateToInterruptEvent.emit(Boxing.boxBoolean(true), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r4;
    L10:
        return Unit.INSTANCE;
    }

    private final void prepareVoiceQuery(String r4) {
        resetTypewriterState();
        startVoiceQueryRound$default(this, r4, false, 2, null);
        registerMessageObserver();
    }

    private final void publishInterruptUiState(o r2) {
        this._interruptUiState.setValue(r2);
        bridgeQueryTextState(r2);
        bridgeLegacyTypewriterState(r2);
    }

    private final Long requireActiveRoundToken(String r3) {
        Long r0 = this.activeRoundToken;
        if (r0 != null) goto L5;
        g49.d.d(TAG, r3 + " ignored: no active round");
    L5:
        return r0;
    }

    private final String resolvePresetQueryText(String r3) {
        int r0 = com.larus.utils.j0.a;
        String r1 = com.larus.utils.j0.e(r3);
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        r1 = null;
    L9:
        if (r1 != null) goto L12;
        return r3;
    L12:
        return r1;
    L5:
        r2 = false;
        goto L6
    }

    private final boolean shouldReplacePresetClickRoundWithVoiceQuery(String r3) {
        if (isShowingPresetClickQuery() == true) goto L5;
        return false;
    L5:
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r4 = false;
        goto L11
    }

    private final boolean shouldRestartVoiceRoundForIncomingQuery(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        return false;
    L11:
        n0 r5 = ((o) this._interruptUiState.getValue()).b;
        if ((r5 instanceof n0.c) == false) goto L14;
        n0.c r6 = (n0.c) r5;
    L15:
        if (r6 != null) goto L18;
        return false;
    L18:
        return Intrinsics.areEqual(r6.c, QUERY_SOURCE_VOICE);
    L14:
        r6 = null;
        goto L15
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L9
    }

    private final void stopCurrentVuiSession(String r3) {
        g49.d.d(TAG, "stopCurrentVuiSession: reason=" + r3);
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L8;
        SessionService r5 = r4.d();
        if (r5 == null) goto L9;
        r5.q(BaiduNaviStatus.WRONG_AK_PARAM);
        return;
    L9:
        return;
    }

    private final void submitActiveVoiceQuery(String r9) {
        Long r0 = requireActiveRoundToken("submitActiveVoiceQuery");
        if (r0 == null) goto L38;
        long r2 = r0.longValue();
        o r1 = (o) this._interruptUiState.getValue();
        n0 r3 = r1.b;
        String r4 = null;
        if (r9 == null) goto L7;
        String r10 = StringsKt.trim(r9).toString();
    L8:
        boolean r5 = true;
        if (r10 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == false) goto L18;
        r10 = null;
    L18:
        if (r10 == null) goto L20;
    L35:
        r4 = r10;
    L36:
        publishInterruptUiState(o.a(r1, r2, new n0.c(r2, r4, QUERY_SOURCE_VOICE), null, 12));
        return;
    L20:
        if (Intrinsics.areEqual(r3, n0.a.a) == true) goto L36;
        if ((r3 instanceof n0.b) == false) goto L31;
        r10 = ((n0.b) r3).c;
        if (r10.length() == 0) goto L28;
        r5 = false;
    L28:
        if (r5 == true) goto L36;
    L31:
        if ((r3 instanceof n0.c) == false) goto L34;
        r4 = ((n0.c) r3).b;
        goto L36
    L34:
        throw new NoWhenBranchMatchedException();
    L11:
        if (r10.length() == 0) goto L14;
        r7 = false;
        goto L15
    L7:
        r10 = null;
        goto L8
    }

    private final void updateActiveQueryText(String r9) {
        Long r0 = requireActiveRoundToken("updateActiveQueryText");
        if (r0 == null) goto L29;
        long r2 = r0.longValue();
        if (r9 == null) goto L7;
        String r10 = StringsKt.trim(r9).toString();
    L8:
        if (r10 != null) goto L11;
        r10 = "";
    L11:
        if (r10.length() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L16;
        return;
    L16:
        o r3 = (o) this._interruptUiState.getValue();
        n0 r4 = r3.b;
        if (Intrinsics.areEqual(r4, n0.a.a) == false) goto L20;
        n0 r5 = new n0.b(r2, QUERY_SOURCE_VOICE, r10);
    L25:
        publishInterruptUiState(o.a(r3, r2, r5, null, 12));
        return;
    L20:
        if ((r4 instanceof n0.b) == false) goto L23;
        n0.b r6 = (n0.b) r4;
        long r7 = r6.a;
        String r8 = r6.b;
        Intrinsics.checkNotNullParameter(r8, "source");
        Intrinsics.checkNotNullParameter(r10, "text");
        r5 = new n0.b(r7, r8, r10);
        goto L25
    L23:
        if ((r4 instanceof n0.c) == false) goto L28;
        n0.c r11 = (n0.c) r4;
        long r12 = r11.a;
        String r13 = r11.c;
        Intrinsics.checkNotNullParameter(r13, "source");
        r5 = new n0.c(r12, r10, r13);
        goto L25
    L28:
        throw new NoWhenBranchMatchedException();
    L13:
        r1 = false;
        goto L14
    L7:
        r10 = null;
        goto L8
    }

    private final void updateTypewriterText(String r8) {
        boolean r1 = true;
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r8, this.pendingBuffer.toString()) == true) goto L33;
        String r2 = this.pendingBuffer.toString();
        if (r8.length() <= r2.length()) goto L16;
        if (StringsKt.startsWith$default(r8, r2, false, 2, null) == false) goto L16;
        this.pendingBuffer.append(r8.substring(r2.length()));
    L21:
        Job r9 = this.typewriterJob;
        if (r9 == null) goto L29;
        if (r9 != null) goto L25;
    L27:
        r1 = false;
    L28:
        if (r1 == false) goto L29;
        return;
    L25:
        if (r9.isActive() != true) goto L27;
    L29:
        startTypewriter();
        return;
    L16:
        if (r8.length() <= r2.length()) goto L18;
    L20:
        g49.d.e(TAG, "updateTypewriterText: content changed drastically, reset. old=" + r2 + ", new=" + r8);
        StringsKt.clear(this.pendingBuffer);
        this.pendingBuffer.append(r8);
        StringsKt.clear(this.displayedBuffer);
        updateReplyContent(r8, "", false);
        goto L21
    L18:
        if (StringsKt.startsWith$default(r2, r8, false, 2, null) == false) goto L20;
        return;
    L33:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void appendTypewriterText(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.pendingBuffer.append(r3);
        Job r4 = this.typewriterJob;
        if (r4 == null) goto L10;
        boolean r0 = false;
        if (r4 != null) goto L7;
    L9:
        if (r0 == false) goto L10;
        return;
    L7:
        if (r4.isActive() != true) goto L9;
        r0 = true;
    L10:
        startTypewriter();
    }

    public final boolean consumeEntryAnimation(Long r8) {
        o r1 = (o) this._interruptUiState.getValue();
        if (r1.c == true) goto L5;
        return false;
    L5:
        if (r8 != null) goto L7;
    L9:
        publishInterruptUiState(o.a(r1, 0, null, null, 11));
        return true;
    L7:
        if (r1.a == r8.longValue()) goto L9;
        return false;
    }

    public final void restoreInterruptUiState(o r9) {
        Intrinsics.checkNotNullParameter(r9, "savedState");
        cancelReplyLoadingTimeout();
        Job r0 = this.typewriterJob;
        boolean r1 = true;
        Long r2 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.typewriterJob = null;
        StringsKt.clear(this.pendingBuffer);
        StringsKt.clear(this.displayedBuffer);
        this.currentRoundToken = Math.max(this.currentRoundToken, r9.a);
        Long r3 = Long.valueOf(r9.a);
        if (r3.longValue() > 0) goto L9;
        r1 = false;
    L9:
        if (r1 == false) goto L11;
        r2 = r3;
    L11:
        this.activeRoundToken = r2;
        o0 r4 = r9.d;
        if (Intrinsics.areEqual(r4, o0.b.a) == false) goto L14;
    L24:
        publishInterruptUiState(r9);
        return;
    L14:
        if ((r4 instanceof o0.c) == false) goto L17;
        ensureReplyLoadingTimeout(r9.a);
        goto L24
    L17:
        if ((r4 instanceof o0.d) == false) goto L20;
        o0.d r5 = (o0.d) r4;
        this.pendingBuffer.append(r5.b);
        this.displayedBuffer.append(r5.c);
        goto L24
    L20:
        if ((r4 instanceof o0.a) == false) goto L23;
        o0.a r6 = (o0.a) r4;
        this.pendingBuffer.append(r6.b);
        this.displayedBuffer.append(r6.b);
        goto L24
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public final void skipAndNext(boolean r8) {
        resetTypewriterState();
        stopTTS("skipAndNext");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04291(this, r8, null), 3, null);
    }

    public final void skipToInterrupt(boolean r2) {
        resetTypewriterState();
        stopTTS("skipToInterrupt");
        emitNavigateToInterrupt(r2);
    }

    private final void updateTypewriterText(Message r6) {
        String r0 = com.larus.im.bean.message.a.O(r6);
        String r1 = null;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L12:
        String r3 = com.larus.im.bean.message.a.B(r6);
        if (r3.length() > 0) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        r1 = r3;
    L18:
        if (r1 != null) goto L22;
        r0 = com.larus.im.bean.message.a.K(r6);
        if (r0 != null) goto L23;
        return;
    L23:
        updateTypewriterText(r0);
        return;
    L22:
        r0 = r1;
        goto L23
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 != null) goto L23;
    L7:
        r4 = false;
        goto L8
    }

    public static final /* synthetic */ void access$ensureReplyLoadingTimeout(DoraHStreamlinedOnboardingViewModel r0, long r1) {
        r0.ensureReplyLoadingTimeout(r1);
    }

    public static final /* synthetic */ Object access$getMainConversationId(DoraHStreamlinedOnboardingViewModel r0, Continuation r1) {
        return r0.getMainConversationId(r1);
    }

    public static final /* synthetic */ void access$handleAsrQueryUpdate(DoraHStreamlinedOnboardingViewModel r0, String r1) {
        r0.handleAsrQueryUpdate(r1);
    }

    public static final /* synthetic */ void access$handleTypewriterMessageUpdate(DoraHStreamlinedOnboardingViewModel r0, Message r1) {
        r0.handleTypewriterMessageUpdate(r1);
    }

    public static final /* synthetic */ Object access$navigateToInterruptOnAsrEndIfAllowed(DoraHStreamlinedOnboardingViewModel r0, Continuation r1) {
        return r0.navigateToInterruptOnAsrEndIfAllowed(r1);
    }

    public static final /* synthetic */ Long access$requireActiveRoundToken(DoraHStreamlinedOnboardingViewModel r0, String r1) {
        return r0.requireActiveRoundToken(r1);
    }

    public static final /* synthetic */ void access$setAvatarFetchJob$p(DoraHStreamlinedOnboardingViewModel r0, Job r1) {
        r0.avatarFetchJob = r1;
    }

    public static final /* synthetic */ void access$setObserverRegistered$p(DoraHStreamlinedOnboardingViewModel r0, boolean r1) {
        r0.isObserverRegistered = r1;
    }

    public static final /* synthetic */ void access$setRegisteredConversationId$p(DoraHStreamlinedOnboardingViewModel r0, String r1) {
        r0.registeredConversationId = r1;
    }

    public static final /* synthetic */ void access$submitActiveVoiceQuery(DoraHStreamlinedOnboardingViewModel r0, String r1) {
        r0.submitActiveVoiceQuery(r1);
    }

    private final void showReplyFallback(long r8, String r10) {
        Long r0 = this.activeRoundToken;
        if (r0 != null) goto L6;
    L7:
        g49.d.d(TAG, "showReplyFallback ignored: inactive roundToken=" + r8 + ", active=" + this.activeRoundToken);
        return;
    L6:
        if (r0.longValue() != r8) goto L7;
        cancelReplyLoadingTimeout();
        publishInterruptUiState(o.a((o) this._interruptUiState.getValue(), r8, null, new o0.a(r8, r10), 6));
    }

    private final long startNewRound(n0 r10, boolean r11) {
        long r6 = nextRoundToken();
        this.activeRoundToken = Long.valueOf(r6);
        publishInterruptUiState(new o(r6, r10, r11, new o0.c(r6, getReplyLoadingText())));
        return r6;
    }

    private final long startPresetQueryRound(String r6, String r7) {
        return startNewRound(new n0.c(this.currentRoundToken + 1, r6, r7), true);
    }

    private final void startVoiceQueryRound(String r6, boolean r7) {
        if (r6 == null) goto L4;
        String r8 = StringsKt.trim(r6).toString();
    L5:
        if (r8 != null) goto L7;
        r8 = "";
    L7:
        startNewRound(new n0.b(this.currentRoundToken + 1, QUERY_SOURCE_VOICE, r8), r7);
        return;
    L4:
        r8 = null;
        goto L5
    }

    public final void sendQueryAndNext(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "queryKey");
        Intrinsics.checkNotNullParameter(r9, "source");
        g49.d.d(TAG, "sendQueryAndNext: queryKey=" + r8 + ", source=" + r9);
        if (isNetworkAvailable() == true) goto L6;
        t19.s r10 = t19.s.a;
        Application r11 = AppHost.a.getApplication();
        r10.getClass();
        t19.s.s(r11, 2131908080);
        return;
    L6:
        resetTypewriterState();
        String r0 = resolvePresetQueryText(r8);
        if (r9.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r9 = QUERY_SOURCE_CLICK;
    L12:
        long r5 = startPresetQueryRound(r0, r9);
        registerMessageObserver();
        stopTTS("sendQueryAndNext");
        IDoraAVLinkService r12 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r12 != null) goto L15;
        g49.d.e(TAG, "sendQueryAndNext failed: IDoraAVLinkService is null");
        showReplyFallback(r5, getReplyFallbackText());
    L16:
        this.allowAsrEndNavigateToInterrupt = false;
        emitNavigateToInterrupt(true);
        return;
    L15:
        r12.x(r8);
        ensureReplyLoadingTimeout(r5);
        goto L16
    L9:
        r2 = false;
        goto L10
    }

    public static final /* synthetic */ void access$showReplyFallback(DoraHStreamlinedOnboardingViewModel r0, long r1, String r3) {
        r0.showReplyFallback(r1, r3);
    }

    private final void updateReplyContent(String r8, String r9, boolean r10) {
        Long r0 = requireActiveRoundToken("updateReplyContent");
        if (r0 == null) goto L10;
        long r2 = r0.longValue();
        cancelReplyLoadingTimeout();
        if (r10 == false) goto L7;
        o0 r5 = new o0.a(r2, r9);
    L8:
        publishInterruptUiState(o.a((o) this._interruptUiState.getValue(), r2, null, r5, 6));
        return;
    L7:
        r5 = new o0.d(r2, r8, r9);
        goto L8
    }

    public static final /* synthetic */ void access$updateReplyContent(DoraHStreamlinedOnboardingViewModel r0, String r1, String r2, boolean r3) {
        r0.updateReplyContent(r1, r2, r3);
    }

    public static /* synthetic */ boolean consumeEntryAnimation$default(DoraHStreamlinedOnboardingViewModel r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.consumeEntryAnimation(r1);
    }

    public static /* synthetic */ void prepareVoiceQuery$default(DoraHStreamlinedOnboardingViewModel r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.prepareVoiceQuery(r1);
    }

    public static /* synthetic */ void skipAndNext$default(DoraHStreamlinedOnboardingViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.skipAndNext(r1);
    }

    public static /* synthetic */ void skipToInterrupt$default(DoraHStreamlinedOnboardingViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.skipToInterrupt(r1);
    }

    public static /* synthetic */ void sendQueryAndNext$default(DoraHStreamlinedOnboardingViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = QUERY_SOURCE_CLICK;
    L5:
        r0.sendQueryAndNext(r1, r2);
    }

    public static /* synthetic */ void startVoiceQueryRound$default(DoraHStreamlinedOnboardingViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = true;
    L8:
        r0.startVoiceQueryRound(r1, r2);
    }
}
