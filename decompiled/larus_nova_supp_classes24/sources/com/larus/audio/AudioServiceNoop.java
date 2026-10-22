package com.larus.audio;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.d1;
import com.larus.audio.asr.a0;
import com.larus.audio.asr.c0;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.audio.bean.CacheConfig;
import com.larus.audio.bean.ConversationCellIcon;
import com.larus.bmhome.chat.component.title.o1;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarNormalHolder;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import hq9.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0018\u001a\u00020\u00052\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001eH\u0016J-\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00112\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010$H\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u0011H\u0016J\b\u0010*\u001a\u00020\u0011H\u0016J\b\u0010+\u001a\u00020\u0011H\u0016J\u001c\u0010,\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0096@¢\u0006\u0002\u0010/J$\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u0002010.2\f\u00103\u001a\b\u0012\u0004\u0012\u0002010.H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0011H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000201H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0011H\u0016J3\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010\u00072\b\u0010>\u001a\u0004\u0018\u0001012\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\tH\u0016¢\u0006\u0002\u0010@J$\u0010;\u001a\u0004\u0018\u00010<2\b\u0010A\u001a\u0004\u0018\u00010B2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\tH\u0016J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J\b\u0010D\u001a\u00020\u0011H\u0016J\b\u0010E\u001a\u000201H\u0016J \u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u0007H\u0016J\b\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\u0011H\u0016J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u0007H\u0016J0\u0010S\u001a\u00020\u00112\b\u0010T\u001a\u0004\u0018\u00010\u00072\b\u0010U\u001a\u0004\u0018\u00010\u00072\b\u0010V\u001a\u0004\u0018\u00010\u00072\b\u0010W\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010X\u001a\u00020\u0011H\u0016J\b\u0010Y\u001a\u00020\u0011H\u0016J\b\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\\\u001a\u00020\u00112\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010]\u001a\u00020\u0011H\u0016J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J\b\u0010_\u001a\u00020\u0011H\u0016J\u0010\u0010`\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u0011H\u0016J\b\u0010b\u001a\u00020\u0011H\u0016J\b\u0010c\u001a\u00020\u0011H\u0016J\b\u0010d\u001a\u00020\u0011H\u0016J\b\u0010e\u001a\u00020\u0011H\u0016J\u0010\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u0011H\u0016J\b\u0010h\u001a\u00020\u0005H\u0016J\u0010\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0016J\u0010\u0010k\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0016J\u0012\u0010l\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0012\u0010m\u001a\u0004\u0018\u00010\u00072\u0006\u0010n\u001a\u00020\u0007H\u0016J\n\u0010o\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010p\u001a\u00020\u0011H\u0016J\u0010\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020sH\u0016J\u0016\u0010t\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010uJ\u0010\u0010v\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u0011H\u0016J\b\u0010x\u001a\u00020\u0011H\u0016J\u001c\u0010y\u001a\u00020\u00052\f\u0010z\u001a\b\u0012\u0004\u0012\u00020|0{H\u0096@¢\u0006\u0002\u0010}J\u0012\u0010~\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0011\u0010\u007f\u001a\u00020\u00052\u0007\u0010\u0080\u0001\u001a\u00020\u0007H\u0016J\n\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\n\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0016J\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J\n\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J\n\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0016J\n\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0016J\n\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\n\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J\n\u0010\u009f\u0001\u001a\u00030 \u0001H\u0016J\n\u0010¡\u0001\u001a\u00030¢\u0001H\u0016J\n\u0010£\u0001\u001a\u00030¤\u0001H\u0016J\u0015\u0010¥\u0001\u001a\u00020\u00052\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\u0015\u0010¨\u0001\u001a\u00020\u00052\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0016J\t\u0010«\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010¬\u0001\u001a\u00020\u00052\u0007\u0010\u00ad\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010®\u0001\u001a\u00020\u00052\u0007\u0010¯\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010°\u0001\u001a\u00020\u00052\u0007\u0010¯\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010±\u0001\u001a\u00020\u00052\b\u0010²\u0001\u001a\u00030³\u0001H\u0016J\u0014\u0010´\u0001\u001a\u00020\u00072\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006¶\u0001"}, d2 = {"Lcom/larus/audio/AudioServiceNoop;", "Lcom/larus/audio/IAudioService;", "<init>", "()V", "initAll", "", "samiUrl", "", "removeQueryKeyList", "", "initSami", "initRTC", "init", "appKey", "appToken", "hasInit", "Landroidx/lifecycle/LiveData;", "", "updateInitState", "loadAudioUserSetting", "addAudioPlayStateChangeCallback", "callback", "Lcom/larus/audio/audiov3/tts/AudioPlayStateChangeCallback;", "removeAudioPlayStateCallback", "preLoadAudio", "audioList", "Ljava/util/ArrayList;", "Lcom/larus/audio/bean/DownloadBean;", "Lkotlin/collections/ArrayList;", "getAudioConfigLiveData", "Lcom/larus/audio/bean/AudioUserConfig;", "updateAudioConfigFromLaunch", "config", "updateRtcLaunchInfoFromLaunch", "useTestDomain", "streamAppDetails", "", "(Ljava/lang/Boolean;Ljava/util/Map;)V", "requestAudioConfig", "requestPGCVoiceList", "caller", "isAutoPlayHardDowngrade", "isAutoPlaySoftDowngrade", "isManualPlayHardDowngrade", "collectAudioDowngradeStateChanged", "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDowngradeAudioIconId", "", "downgradeIconIdAction", "normalIconIdAction", "setSoftDowngradeUserUpdated", "isUserUpdated", "getTargetLoudness", "", "getLoudNormAlgoType", "disconnectSamiConnection", "isNotRecording", "findRealtimeCallBotTagInfo", "Lcom/larus/im/bean/bot/ShowTagInfo;", "botId", "botType", "tagInfoList", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/larus/im/bean/bot/ShowTagInfo;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "getTranslucentPages", "isInRealtimeCall", "getDebugStopIndex", "saveStreamPcm", "data", "", "isDora", "uuid", "deleteScreamOs", "isTopRealtimeCallActivity", "connectionOperator", "Lcom/larus/audio/IRealtimeConnectionOperator;", "getMySoundsMobHelper", "Lcom/larus/audio/ISoundsMob;", "deleteSharkMessageTtsCache", "cacheKey", "enableTtsCache", "messageId", "voiceStyleId", "extra", "selectedText", "isDoraWakeUp", "isDoraConnected", "getDoraAppeaseMinPlayingTime", "", "realtimeCallBotEnabled", "showRealTimeCallNotice", "getRunningAsrTaskIds", "isSamiFrontierInit", "setUserRealtimeCalled", "called", "hasUserRealtimeCalled", "hasEnableUserCalledLibra", "isAiNoteRecording", "isWaitingStart", "setWaitingStart", "value", "stopAiNoteRecording", "getSamiUrl", "hostAppKey", "getDoubaoQuicUrl", "getSamiConnectedPool", "getRtcAppIdByStreamApp", "streamApp", "getDoubaoRtcAppId", "useRTCTestDomain", "soundMobHelperOnExitPage", "source", "Lcom/larus/audio/SoundsSource;", "ensureRTCInitialized", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasUserCalled", "defaultValue", "canShowCallRedDot", "registerRecordStatusFlowObserve", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/audio/bean/RECORD_STATUS;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConnectedPool", "saveAsrMainBotLanguage", "language", "getAudioConfig", "Lcom/larus/audio/IAudioConfig;", "getDoraManager", "Lcom/larus/audio/IDoraManager;", "getAudioTraceManager", "Lcom/larus/audio/IAudioTraceManager;", "getAudioTraceBusinessManager", "Lcom/larus/audio/IAudioTraceBusinessManager;", "getAudioPlayerManager", "Lcom/larus/audio/IAudioPlayerManager;", "getTtsQualityTrace", "Lcom/larus/audio/ITtsQualityTrace;", "getAsrCoroutine", "Lcom/larus/audio/IAsrCoroutine;", "getAudioDowngradeManager", "Lcom/larus/audio/IAudioDowngradeManager;", "getAiNoteManager", "Lcom/larus/audio/IAiNote;", "getLoudnessHelper", "Lcom/larus/audio/ILoudnessHelper;", "getAudioLoadManager", "Lcom/larus/audio/IAudioLoadManager;", "getTtsClientManager", "Lcom/larus/audio/ITtsClientManager;", "getAsrGlobal", "Lcom/larus/audio/IAsrGlobal;", "getAsrClientManager", "Lcom/larus/audio/IAsrClientManager;", "getTtsInterrupter", "Lcom/larus/audio/ITtsInterrupter;", "getSamiReportInitiator", "Lcom/larus/audio/ISamiReportInitiator;", "getConnectPoolManager", "Lcom/larus/audio/IAudioConnectionPoolManager;", "getVoiceQualityChecker", "Lcom/larus/audio/IVoiceQualityChecker;", "setAudioDebugService", "debugService", "Lcom/larus/audio/audiov3/IAudioDebugService;", "setAudioAutoTestService", "autoTestService", "Lcom/larus/audio/audiov3/AudioSdkAutotestDepend;", "getQuicWSSHost", "shouldCloseAudioOnBackground", "shouldDisconnect", "disconnectAudioConnection", "reason", "reconnectAudioConnection", "addStatusInterceptor", "interceptor", "Lcom/larus/audio/IAudioService$StatusInterceptor;", "getAppKeyByBizKey", "bizKey", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioServiceNoop implements IAudioService {

    public static final class a implements j0 {
        public a() {
        }

        public final void a(String r1) {
        }

        public final boolean g() {
            return false;
        }

        public final void h() {
        }

        public final void i(String r1, String r2) {
        }

        public final boolean isRecording() {
            return false;
        }

        public final void j(p68.c r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
        }

        public final void k(p68.c r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
        }

        public final boolean l() {
            return false;
        }
    }

    public static final class b implements k0 {
        public b() {
        }

        public final void a() {
        }

        public final void b(d1 r1) {
        }

        public final void c(d1 r1) {
        }

        public final void d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
        }

        public final void e() {
        }

        public final void f(boolean r1) {
        }

        public final boolean g(String r1, String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "taskId");
            return false;
        }
    }

    public static final class c implements l0 {
        public c() {
        }

        @Override // com.larus.audio.l0
        public final Object a(Message r1, String r2, String r3, String r4, Long r5, boolean r6, String r7, boolean r8, n58.b r9, Continuation<? super p68.a> r10) {
            return new p68.a.C0119a("", "", 0, Boxing.boxInt(0));
        }
    }

    public static final class d implements o0 {
        public d() {
        }

        @Override // com.larus.audio.o0
        public final void a(String r1, Function1<? super byte[], Unit> r2, Function1<? super String, Unit> r3, Function1<? super com.larus.audio.b, Unit> r4, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r5, Function1<? super String, Unit> r6, a0 r7) {
        }

        @Override // com.larus.audio.o0
        public final void b() {
        }

        @Override // com.larus.audio.o0
        public final void c() {
        }

        @Override // com.larus.audio.o0
        public final String d() {
            return "";
        }

        @Override // com.larus.audio.o0
        public final void e(Message r3, String r4, String r5, String r6, String r7, JSONObject r8, boolean r9, String r10, boolean r11, Long r12, n58.b r13, String r14, long r15, Integer r17, Long r19, h68.d r110, Function0<Unit> r20, long r21, c0 r23) {
            Intrinsics.checkNotNullParameter(r4, "taskId");
            Intrinsics.checkNotNullParameter(r5, "conversationId");
            Intrinsics.checkNotNullParameter(r8, "extraConfig");
            Intrinsics.checkNotNullParameter(r20, "onRealStart");
            Intrinsics.checkNotNullParameter(r23, "traceInfo");
        }

        @Override // com.larus.audio.o0
        public final void f() {
        }

        @Override // com.larus.audio.o0
        public final void g(String r1, String r2, String r3, String r4, com.larus.audio.asr.y r5, boolean r6, String r7, boolean r8, Long r9, n58.b r10, long r11, Function0 r13, h68.d r14) {
            Intrinsics.checkNotNullParameter(r1, "taskId");
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            Intrinsics.checkNotNullParameter(r5, "config");
            Intrinsics.checkNotNullParameter("ai_doc", "bizScene");
            Intrinsics.checkNotNullParameter(r13, "onRealStart");
        }

        @Override // com.larus.audio.o0
        public final String getTaskId() {
            return null;
        }

        @Override // com.larus.audio.o0
        public final String h() {
            return "";
        }
    }

    public static final class e implements p0 {
        public final MutableLiveData a;

        public final int A() {
            return -1;
        }

        public final boolean B(boolean r2) {
            Intrinsics.checkNotNullParameter("voice_call", "scene");
            Intrinsics.checkNotNullParameter("navigation_bar", "entrance");
            return false;
        }

        public final String C() {
            return "";
        }

        public final boolean D(boolean r1) {
            return false;
        }

        public final boolean a() {
            return false;
        }

        public final int b() {
            return 0;
        }

        public final boolean c() {
            return false;
        }

        public final ShowTagInfo f(BotModel r1, List<ShowTagInfo> r2) {
            return null;
        }

        public final boolean i() {
            return true;
        }

        public final boolean m() {
            return false;
        }

        public final boolean n(BotModel r1) {
            return false;
        }

        public final boolean o(String r1, String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "scene");
            Intrinsics.checkNotNullParameter(r2, "entrance");
            return false;
        }

        public final ConversationCellIcon q(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "botId");
            return null;
        }

        public final void r(String r2) {
            Intrinsics.checkNotNullParameter(r2, "trigger");
        }

        public final void t() {
        }

        public final boolean v() {
            return false;
        }

        public final void w(boolean r1) {
        }

        public final void x() {
        }

        public final void y() {
        }

        public final boolean z() {
            return false;
        }

        public final MutableLiveData p() {
            return new MutableLiveData(new AudioUserConfig(null, null, null, null, false, null, null, false, null, false, 1023, null));
        }

        public e() {
            this.a = new MutableLiveData(null);
        }

        public final MutableLiveData s() {
            return this.a;
        }

        public final Object u(String r1, Continuation<? super Boolean> r2) {
            return Boxing.boxBoolean(false);
        }
    }

    public static final class f implements r0 {
        public f() {
        }

        public final void a(Map<String, String> r1) {
        }
    }

    public static final class g implements s0 {
        public g() {
        }

        public final void h() {
        }

        public final void i() {
        }

        public final void j(ArrayList<p68.b> r1) {
        }

        public final void k(String r1, String r2, String r3, float r4, float r5, String r6, p68.e r7) {
            Intrinsics.checkNotNullParameter(r6, "botId");
            Intrinsics.checkNotNullParameter(r7, "listener");
        }

        public final void l(String r1, String r2, String r3, p68.e r4, String r5, String r6) {
        }

        public final void stopAudio() {
        }
    }

    public static final class h implements t0 {
        public h() {
        }

        public final void k(n68.a r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public final void m(n68.a r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public final void n(PlayStateEnum r1) {
        }

        public final PlayStateEnum l() {
            return PlayStateEnum.PLAY_STATE_STOPPED;
        }
    }

    public static final class i implements u0 {
        public i() {
        }

        @Override // com.larus.audio.u0
        public final void a(v r1) {
        }
    }

    public static final class j implements v0 {
        public j() {
        }

        @Override // com.larus.audio.v0
        public final com.larus.trace.tracespan.span.b a(String r1, JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "commonParams");
            return null;
        }

        @Override // com.larus.audio.v0
        public final String b(String r1) {
            return null;
        }

        @Override // com.larus.audio.v0
        public final String c(String r1) {
            return null;
        }

        @Override // com.larus.audio.v0
        public final void d(String r1, String r2) {
        }

        @Override // com.larus.audio.v0
        public final void e(String r1) {
        }

        @Override // com.larus.audio.v0
        public final String f() {
            return null;
        }

        @Override // com.larus.audio.v0
        public final void g(String r1, String r2) {
        }
    }

    public static final class k implements q0 {
        public k() {
        }

        public final String o(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appKey");
            return null;
        }
    }

    public static final class l implements x0 {
        public l() {
        }

        public final boolean a() {
            return false;
        }

        public final boolean b() {
            return false;
        }

        public final String c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "srcUrl");
            return "";
        }

        public final boolean d() {
            return false;
        }

        public final lq9.p e() {
            lq9.p r0 = lq9.p.f;
            return lq9.p.f;
        }
    }

    public static final class m implements y0 {
        public m() {
        }

        @Override // com.larus.audio.y0
        public final float b() {
            return 0.0f;
        }

        @Override // com.larus.audio.y0
        public final int c() {
            return 1;
        }
    }

    public static final class n implements a1 {
        public n() {
        }

        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "method");
        }

        public final void f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "method");
        }

        public final void h(Message r1) {
        }

        public final void a(SoundsSource r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
        }

        public final void c(SoundsSource r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
        }

        public final void d(SoundsSource r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
        }

        public final void e(SoundsSource r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
        }

        public final void g(byte[] r2, SoundsSource r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "source");
        }
    }

    public static final class o implements z0 {
        public o() {
        }

        public final void a() {
        }

        public final String d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appKey");
            return "";
        }
    }

    public static final class p implements d1 {
        public p() {
        }

        public final boolean a() {
            return false;
        }

        public final void b(String r1) {
        }

        public final void cancel(String r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "stopReason");
        }

        public final void d(String r1, String r2, String r3, boolean r4, Map<String, String> r5, boolean r6, p68.i r7, boolean r8, Function0<Unit> r9, Function1<? super String, Unit> r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r9, "next");
            Intrinsics.checkNotNullParameter(r10, "failed");
        }

        public final void f(SpeakerVoice r1) {
        }

        public final boolean g() {
            return false;
        }

        public final void h(Message r1) {
        }

        public final BotModel i() {
            return null;
        }

        public final void j(String r1, String r2, String r3, boolean r4, p68.i r5, String r6, CacheConfig r7, boolean r8, boolean r9, String r10, String r11, Map r12) {
        }

        public final void k() {
        }

        public final void l(BotModel r1) {
        }

        public final Object c(Map<String, String> r1, String r2, Continuation<? super Map<String, String>> r3) {
            return MapsKt.emptyMap();
        }

        public final Object e(Map<String, String> r1, String r2, Continuation<? super Map<String, String>> r3) {
            return MapsKt.emptyMap();
        }
    }

    public static final class q implements e1 {
        public boolean a;

        public q() {
        }

        @Override // com.larus.audio.e1
        public final void b(LifecycleOwner r2, MutableLiveData r3, Fragment r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "owner");
            Intrinsics.checkNotNullParameter(r3, "ttsSwitch");
            Intrinsics.checkNotNullParameter(r4, "fragment");
            Intrinsics.checkNotNullParameter(r5, "cvsId");
        }

        @Override // com.larus.audio.e1
        public final boolean d() {
            return this.a;
        }

        @Override // com.larus.audio.e1
        public final void a(boolean r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.e1
        public final boolean c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            return false;
        }
    }

    public static final class r implements f1 {
        public r() {
        }

        @Override // com.larus.audio.f1
        public final void a() {
        }

        @Override // com.larus.audio.f1
        public final void b() {
        }
    }

    public static final class s implements g1 {
        public s() {
        }

        @Override // com.larus.audio.g1
        public final void a() {
        }

        @Override // com.larus.audio.g1
        public final void b() {
        }

        @Override // com.larus.audio.g1
        public final void c(String r1, String r2, String r3, p78.a r4) {
        }
    }

    public AudioServiceNoop() {
    }

    public final int A() {
        return LKUIToast.DURATION_MAX;
    }

    public final ShowTagInfo B(String r1, Integer r2, List<ShowTagInfo> r3) {
        return null;
    }

    public final boolean C() {
        return false;
    }

    public final boolean D() {
        return false;
    }

    public final void E(Boolean r1, Map<String, String> r2) {
    }

    public final void G(m58.q r1) {
    }

    public final void H(com.obric.assistant.audio.m r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
    }

    public final void J(String r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
    }

    public final String M(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hostAppKey");
        return "";
    }

    public final void R(String r1, List<String> r2) {
        Intrinsics.checkNotNullParameter(r1, "samiUrl");
    }

    public final void S(com.larus.init.task.firstframe.q r1) {
    }

    public final boolean U() {
        return false;
    }

    public final void W() {
    }

    public final void Y(AudioUserConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    public final String Z(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appKey");
        return null;
    }

    public final float b() {
        return 0.0f;
    }

    public final void b0() {
    }

    public final int c() {
        return 1;
    }

    public final void c0(byte[] r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "uuid");
    }

    public final String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hostAppKey");
        return "";
    }

    public final void d0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    public final boolean e() {
        return false;
    }

    public final boolean e0() {
        return false;
    }

    public final ShowTagInfo f(BotModel r1, List<ShowTagInfo> r2) {
        return null;
    }

    public final void f0(SoundsSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public final boolean g() {
        return false;
    }

    public final void g0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "language");
    }

    public final boolean h(String r1, String r2, String r3, String r4) {
        return false;
    }

    public final boolean i() {
        return true;
    }

    public final void init(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appKey");
        Intrinsics.checkNotNullParameter(r3, "appToken");
    }

    public final boolean isDoraConnected() {
        return false;
    }

    public final void j(ArrayList<p68.b> r1) {
    }

    public final void j0() {
    }

    public final void k(n68.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public final boolean k0() {
        return false;
    }

    public final boolean l() {
        return false;
    }

    public final boolean m() {
        return false;
    }

    public final String m0() {
        return "";
    }

    public final boolean n(BotModel r1) {
        return false;
    }

    public final String o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appKey");
        return null;
    }

    public final void p0(boolean r1) {
    }

    public final boolean q0() {
        return false;
    }

    public final String r() {
        return null;
    }

    public final void s0(com.larus.bot.impl.feature.edit.feature.firstmet.g r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public final void t(boolean r1) {
    }

    public final void t0() {
    }

    public final boolean u() {
        return false;
    }

    public final String u0() {
        return "";
    }

    public final void v(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
    }

    public final void v0() {
    }

    public final void w() {
    }

    public final long w0() {
        return 750;
    }

    public final String x0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "streamApp");
        return null;
    }

    public final void y(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    public final boolean y0() {
        return false;
    }

    public final x0 F() {
        return new l();
    }

    public final e1 L() {
        return new q();
    }

    public final v0 N() {
        return new j();
    }

    public final a1 O() {
        return new n();
    }

    public final j0 P() {
        return new a();
    }

    public final l0 T() {
        return new c();
    }

    public final r0 V() {
        return new f();
    }

    public final g1 X() {
        return new s();
    }

    public final y0 a0() {
        return new m();
    }

    public final p0 getAudioConfig() {
        return new e();
    }

    public final o0 h0() {
        return new d();
    }

    public final LiveData<Boolean> hasInit() {
        return new MutableLiveData(Boolean.FALSE);
    }

    public final d1 i0() {
        return new p();
    }

    public final u0 l0() {
        return new i();
    }

    public final z0 n0() {
        return new o();
    }

    public final s0 o0() {
        return new g();
    }

    public final LiveData<AudioUserConfig> p() {
        return new MutableLiveData(new AudioUserConfig(null, null, null, null, false, null, null, false, null, false, 1023, null));
    }

    public final t0 r0() {
        return new h();
    }

    public final f1 s() {
        return new r();
    }

    public final k0 x() {
        return new b();
    }

    public final q0 z() {
        return new k();
    }

    public final List<String> I() {
        return CollectionsKt.emptyList();
    }

    public final List<String> a() {
        return CollectionsKt.emptyList();
    }

    public final Object K(String r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }

    public final Object Q(CustomActionBarNormalHolder.handleLottieJob.1.1.a r1, Continuation r2) {
        return Unit.INSTANCE;
    }

    public final Object q(o1 r1, Continuation r2) {
        return Unit.INSTANCE;
    }
}
