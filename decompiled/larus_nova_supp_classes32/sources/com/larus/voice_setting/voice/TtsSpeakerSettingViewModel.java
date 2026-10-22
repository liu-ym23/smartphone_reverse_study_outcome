package com.larus.voice_setting.voice;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.kunminx.architecture.domain.message.MutableResult;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.audio.bean.VoiceListTabInfo;
import com.larus.audio.ttsV2.ITtsBackgroundPlayControlService;
import com.larus.bmhome.auth.SpeechLanguage;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.larus.voice_setting.voice.base.api.GetVoiceTabApi;
import com.larus.voice_setting.voice.dialog.v2.api.VoiceMaterialApi;
import com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel;
import com.larus.voice_setting.voice.editvoice.VoicePitchAndRateManager;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009e\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u00103\u001a\b\u0012\u0004\u0012\u00020504J\f\u00106\u001a\b\u0012\u0004\u0012\u00020504J\u0006\u0010K\u001a\u00020LJ\u0010\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020\u0014H\u0002J\u000e\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020 J\u0006\u0010Q\u001a\u00020 J\u0006\u0010R\u001a\u00020 J\u0006\u0010S\u001a\u00020LJ \u0010T\u001a\u00020L2\u0006\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u00072\b\b\u0002\u0010W\u001a\u00020\u0007J,\u0010X\u001a\b\u0012\u0004\u0012\u0002050Y2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\\J\u0006\u0010,\u001a\u00020LJ6\u0010]\u001a\b\u0012\u0004\u0012\u00020^0Y2\u0006\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010_J \u0010`\u001a\u00020L2\u0006\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u00072\b\b\u0002\u0010W\u001a\u00020\u0007J$\u0010a\u001a\b\u0012\u0004\u0012\u00020^0Y2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010bJ,\u0010c\u001a\b\u0012\u0004\u0012\u00020^0Y2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010d\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010eJ\u001c\u0010q\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020s0rj\b\u0012\u0004\u0012\u00020s`t0\u0010J\"\u0010u\u001a\u0004\u0018\u00010s2\b\u0010v\u001a\u0004\u0018\u00010\u00072\f\u0010w\u001a\b\u0012\u0004\u0012\u00020s0=H\u0002J\u001a\u0010x\u001a\u00020L2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u000205J+\u0010|\u001a\u00020L2\u0006\u0010[\u001a\u00020\u00072\u0006\u0010}\u001a\u0002052\b\u0010~\u001a\u0004\u0018\u0001052\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0018\u0010\u0081\u0001\u001a\u00020L2\u0006\u0010[\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u000205J\u0012\u0010\u0083\u0001\u001a\u00020 2\t\u0010\u0082\u0001\u001a\u0004\u0018\u000105J\u001e\u0010\u0084\u0001\u001a\u00020L2\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001052\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001J\u0012\u0010\u0088\u0001\u001a\u00020 2\t\u0010\u0082\u0001\u001a\u0004\u0018\u000105J\u0007\u0010\u0089\u0001\u001a\u00020LJf\u0010\u008a\u0001\u001a\u00020L2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010z2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00072\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u00072\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u0001052\u0007\u0010\u0094\u0001\u001a\u00020 2\t\b\u0002\u0010\u0095\u0001\u001a\u00020 J\u0013\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u0007H\u0002J%\u0010\u0098\u0001\u001a\u00020L2\t\u0010\u0082\u0001\u001a\u0004\u0018\u0001052\b\u0010[\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0003\u0010\u0099\u0001J\u0011\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0002J\u0011\u0010\u009b\u0001\u001a\u00030\u009c\u0001*\u0005\u0018\u00010\u0092\u0001H\u0002J\u0007\u0010\u009d\u0001\u001a\u00020LR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0011\u0010$\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u0017\u0010&\u001a\u00020\u00148F¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020 0\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0012\"\u0004\b.\u0010/R \u00100\u001a\b\u0012\u0004\u0012\u00020 0\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u00102R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u001408X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0012R(\u0010;\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=\u0018\u00010<08X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010?\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=\u0018\u00010<0\u0010¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0012R\u001c\u0010A\u001a\u0010\u0012\f\u0012\n B*\u0004\u0018\u00010 0 08X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020 0\u0010¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0012R\u001a\u0010E\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\"\"\u0004\bG\u0010HR\u0012\u0010I\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010JR\u001b\u0010f\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bh\u0010iR\u001b\u0010l\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010k\u001a\u0004\bn\u0010o¨\u0006\u009f\u0001"}, d2 = {"Lcom/larus/voice_setting/voice/TtsSpeakerSettingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "tag", NameKeys.UnloadStrategy_No_Strategy, "speakerVoiceEditModel", "Lcom/larus/voice_setting/voice/editvoice/SpeakerVoiceEditModel;", "getSpeakerVoiceEditModel", "()Lcom/larus/voice_setting/voice/editvoice/SpeakerVoiceEditModel;", "_voiceUpdate", "Lcom/kunminx/architecture/domain/message/MutableResult;", "Lcom/larus/bmhome/bot/bean/VoiceUpdateResult;", "voiceUpdate", "Landroidx/lifecycle/LiveData;", "getVoiceUpdate", "()Landroidx/lifecycle/LiveData;", "PAGE_SIZE", NameKeys.UnloadStrategy_No_Strategy, "index", "_loadMoreState", "Lcom/larus/utils/livedata/NonStickyLiveData;", "loadMoreState", "getLoadMoreState", "()Lcom/larus/utils/livedata/NonStickyLiveData;", "_publicVoiceLiveData", "Lcom/larus/voice_setting/voice/bean/VoiceListResponse;", "publicVoiceLiveData", "getPublicVoiceLiveData", "voiceCanEdit", NameKeys.UnloadStrategy_No_Strategy, "getVoiceCanEdit", "()Z", "isMultiVoiceMixMode", "showSelectedVoiceOnTop", "getShowSelectedVoiceOnTop", "selectVoiceMode", "getSelectVoiceMode$annotations", "()V", "getSelectVoiceMode", "()I", "_deleteSelectVoice", "deleteSelectVoice", "getDeleteSelectVoice", "setDeleteSelectVoice", "(Landroidx/lifecycle/LiveData;)V", "isFallBackToSystemVoice", "setFallBackToSystemVoice", "(Lcom/larus/utils/livedata/NonStickyLiveData;)V", "getPreloadRecommendVoiceList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/im/bean/bot/SpeakerVoice;", "getPreloadOtherVoiceList", "_languageItemStyle", "Landroidx/lifecycle/MutableLiveData;", "languageItemStyle", "getLanguageItemStyle", "_voiceListTabInfo", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/audio/bean/VoiceListTabInfo;", "voiceListTabInfo", "getVoiceListTabInfo", "_ttsBackgroundPlayChecked", "kotlin.jvm.PlatformType", "ttsBackgroundPlayChecked", "getTtsBackgroundPlayChecked", "showTtsBackgroundPlayToggle", "getShowTtsBackgroundPlayToggle", "setShowTtsBackgroundPlayToggle", "(Z)V", "ttsBackgroundPlayInitial", "Ljava/lang/Boolean;", "loadTtsBackgroundPlaySetting", NameKeys.UnloadStrategy_No_Strategy, "resolveExperimentDefaultEnabled", "experimentMode", "updateTtsBackgroundPlayChecked", "checked", "isTtsBackgroundPlayDirty", "saveTtsBackgroundPlaySettingIfNeeded", "requestVoiceTab", "requestPublicVoiceList", "isFromTts", "userId", "languageCode", "requestVoiceDetail", "Lcom/larus/network/http/Async;", "voiceId", "botId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryList", "Lcom/larus/voice_setting/voice/bean/UgcVoiceResponse;", "(ZLjava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMorePublicVoice", "queryRecommendVoiceList", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryOtherVoiceList", "id", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "botService", "Lcom/larus/im/service/IBotService;", "getBotService", "()Lcom/larus/im/service/IBotService;", "botService$delegate", "Lkotlin/Lazy;", "conversationService", "Lcom/larus/im/service/IConversationService;", "getConversationService", "()Lcom/larus/im/service/IConversationService;", "conversationService$delegate", "getTtsSpeakerGroups", "Ljava/util/ArrayList;", "Lcom/larus/audio/bean/TtsSpeakerGroup;", "Lkotlin/collections/ArrayList;", "getLanguageGroup", "language", "ttsSpeakerGroups", "updateVoice", "oldBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "newVoice", "handleVoiceUpdateResult", "expectedVoice", "originalVoice", "result", "Lcom/larus/im/bean/bot/BotUpdateResult;", "modifyVoiceStyleLocal", "voice", "isSingleUgcVoice", "refreshLanguageItemStyle", "speakerVoice", "editPos", "Lcom/larus/platform/model/EditPos;", "canAddMixVoice", "tryRequestVoiceMaterial", "trySaveUserSelectVoice", "botInfo", "enterFrom", "clickFrom", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "enterMethod", "trackParams", "Lorg/json/JSONObject;", "nonVoice", "isFromVoiceCloneScheme", "showSuccessToast", "generateVoiceEditInfo", "Lcom/larus/voice_setting/voice/mix/res/VoiceEditInfo;", "updateBotInfo", "(Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAsrLanguageByLanguageCode", "toTrackParamsJsonObject", "Lkotlinx/serialization/json/JsonObject;", "saveVoicePitchAndRate", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsSpeakerSettingViewModel extends AndroidViewModel {
    private static final a Companion = null;
    private static final int TTS_BACKGROUND_PLAY_EXPERIMENT_DEFAULT_OFF = 0;
    private static final int TTS_BACKGROUND_PLAY_EXPERIMENT_DEFAULT_ON = 1;
    private static final int TTS_BACKGROUND_PLAY_EXPERIMENT_UNAVAILABLE = -1;
    private static final long VOICE_UPDATE_RETRY_DELAY_MS = 300;
    private final int PAGE_SIZE;
    private NonStickyLiveData<Boolean> _deleteSelectVoice;
    private final MutableLiveData<Integer> _languageItemStyle;
    private final NonStickyLiveData<Integer> _loadMoreState;
    private NonStickyLiveData<r2a.i> _publicVoiceLiveData;
    private final MutableLiveData<Boolean> _ttsBackgroundPlayChecked;
    private final MutableLiveData<Map<String, List<VoiceListTabInfo>>> _voiceListTabInfo;
    private final MutableResult<ub8.h> _voiceUpdate;
    private final Lazy botService$delegate;
    private final Lazy conversationService$delegate;
    private LiveData<Boolean> deleteSelectVoice;
    private int index;
    private NonStickyLiveData<Boolean> isFallBackToSystemVoice;
    private final LiveData<Integer> languageItemStyle;
    private final NonStickyLiveData<Integer> loadMoreState;
    private final LiveData<r2a.i> publicVoiceLiveData;
    private boolean showTtsBackgroundPlayToggle;
    private final SpeakerVoiceEditModel speakerVoiceEditModel;
    private final String tag;
    private final LiveData<Boolean> ttsBackgroundPlayChecked;
    private Boolean ttsBackgroundPlayInitial;
    private final LiveData<Map<String, List<VoiceListTabInfo>>> voiceListTabInfo;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IIMCallback<Boolean> {
        public b() {
        }

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            ((Boolean) r1).booleanValue();
        }
    }

    public static final class c implements IIMCallback<uc9.t> {
        public final /* synthetic */ TtsSpeakerSettingViewModel a;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public c(TtsSpeakerSettingViewModel r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r6) {
            Intrinsics.checkNotNullParameter(r6, "error");
            TtsSpeakerSettingViewModel.access$get_voiceUpdate$p(this.a).postValue(new ub8.h(true, null, Long.valueOf(r6.getCode()), r6.getTips()));
        }

        public final void onSuccess(Object r5) {
            uc9.t r6 = (uc9.t) r5;
            Intrinsics.checkNotNullParameter(r6, "result");
            MutableResult r0 = TtsSpeakerSettingViewModel.access$get_voiceUpdate$p(this.a);
            BotModel r7 = r6.b;
            if (r7 == null) goto L9;
            SpeakerVoice r8 = r7.getVoiceType();
            if (r8 == null) goto L10;
            r0.postValue(new ub8.h(true, r8, null, null));
            return;
        L10:
            return;
        }
    }

    public static final class d implements IIMCallback<uc9.t> {
        public final /* synthetic */ TtsSpeakerSettingViewModel a;
        public final /* synthetic */ BotModel b;
        public final /* synthetic */ SpeakerVoice c;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public final void onFailure(IIMError r6) {
            Intrinsics.checkNotNullParameter(r6, "error");
            TtsSpeakerSettingViewModel.access$get_voiceUpdate$p(this.a).postValue(new ub8.h(true, null, Long.valueOf(r6.getCode()), r6.getTips()));
        }

        public final void onSuccess(Object r5) {
            uc9.t r6 = (uc9.t) r5;
            Intrinsics.checkNotNullParameter(r6, "result");
            if (z2.a.a1() == false) goto L8;
            TtsSpeakerSettingViewModel r0 = this.a;
            String r1 = this.b.getBotId();
            if (r1 != null) goto L7;
            r1 = NameKeys.UnloadStrategy_No_Strategy;
        L7:
            TtsSpeakerSettingViewModel.access$handleVoiceUpdateResult(r0, r1, this.c, this.b.getVoiceType(), r6);
            return;
        L8:
            MutableResult r2 = TtsSpeakerSettingViewModel.access$get_voiceUpdate$p(this.a);
            BotModel r7 = r6.b;
            if (r7 == null) goto L16;
            SpeakerVoice r8 = r7.getVoiceType();
            if (r8 == null) goto L17;
            r2.postValue(new ub8.h(true, r8, null, null));
            return;
        L17:
            return;
        }

        public d(TtsSpeakerSettingViewModel r1, BotModel r2, SpeakerVoice r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$handleVoiceUpdateResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$handleVoiceUpdateResult$1", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ SpeakerVoice $expectedVoice;
        final /* synthetic */ SpeakerVoice $originalVoice;
        final /* synthetic */ SpeakerVoice $serverVoice;
        int label;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$handleVoiceUpdateResult$1$a */
        public static final class a implements IIMCallback<BotModel> {
            public final /* synthetic */ TtsSpeakerSettingViewModel a;
            public final /* synthetic */ SpeakerVoice b;
            public final /* synthetic */ SpeakerVoice c;
            public final /* synthetic */ SpeakerVoice d;

            public final boolean mustInMain() {
                return !com.larus.im.internal.delegate.y0.a();
            }

            public final void onFailure(IIMError r7) {
                Intrinsics.checkNotNullParameter(r7, "error");
                FLogger.a.e(TtsSpeakerSettingViewModel.access$getTag$p(this.a), "[updateVoice] retry getBot failed, expected=" + this.b.getId() + ", code=" + r7.getCode());
                MutableResult r0 = TtsSpeakerSettingViewModel.access$get_voiceUpdate$p(this.a);
                SpeakerVoice r1 = this.c;
                if (r1 != null) goto L5;
                r1 = this.d;
            L5:
                r0.postValue(new ub8.h(false, r1, Long.valueOf(r7.getCode()), r7.getTips()));
            }

            public final void onSuccess(Object r7) {
                BotModel r8 = (BotModel) r7;
                Intrinsics.checkNotNullParameter(r8, "result");
                SpeakerVoice r9 = r8.getVoiceType();
                FLogger r0 = FLogger.a;
                String r1 = TtsSpeakerSettingViewModel.access$getTag$p(this.a);
                StringBuilder r2 = new StringBuilder("[updateVoice] retry getBot, expected=");
                r2.append(this.b.getId());
                r2.append(", actual=");
                if (r9 == null) goto L5;
                String r4 = r9.getId();
            L6:
                r2.append(r4);
                r0.i(r1, r2.toString());
                boolean r3 = true;
                if (r9 == null) goto L22;
                SpeakerVoice r5 = this.b;
                String r6 = r5.getId();
                if (r6 != null) goto L11;
            L14:
                boolean r10 = true;
            L15:
                if (r10 == false) goto L17;
            L19:
                boolean r11 = false;
            L20:
                if (r11 == false) goto L22;
                SpeakerVoice r12 = r9;
            L23:
                MutableResult r13 = TtsSpeakerSettingViewModel.access$get_voiceUpdate$p(this.a);
                if (r12 != null) goto L27;
                r3 = false;
            L27:
                if (r12 != null) goto L33;
                if (r9 != null) goto L32;
                r9 = this.c;
                if (r9 != null) goto L32;
                r9 = this.d;
            L32:
                r12 = r9;
            L33:
                r13.postValue(new ub8.h(r3, r12, null, null));
                return;
            L17:
                if (Intrinsics.areEqual(r9.getId(), r5.getId()) == false) goto L19;
                r11 = true;
                goto L20
            L11:
                if (r6.length() == 0) goto L14;
                r10 = false;
            L22:
                r12 = null;
                goto L23
            L5:
                r4 = null;
                goto L6
            }

            public a(TtsSpeakerSettingViewModel r1, SpeakerVoice r2, SpeakerVoice r3, SpeakerVoice r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }
        }

        public AnonymousClass1(TtsSpeakerSettingViewModel r1, String r2, SpeakerVoice r3, SpeakerVoice r4, SpeakerVoice r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$botId = r2;
            this.$expectedVoice = r3;
            this.$serverVoice = r4;
            this.$originalVoice = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$botId, this.$expectedVoice, this.$serverVoice, this.$originalVoice, r9);
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
        L11:
            TtsSpeakerSettingViewModel.access$getBotService(this.this$0).getBot(this.$botId, true, "default_write", true, new a(this.this$0, this.$expectedVoice, this.$serverVoice, this.$originalVoice));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            this.label = 1;
            if (DelayKt.delay(TtsSpeakerSettingViewModel.VOICE_UPDATE_RETRY_DELAY_MS, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$queryMorePublicVoice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$queryMorePublicVoice$1", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFromTts;
        final /* synthetic */ String $languageCode;
        final /* synthetic */ String $userId;
        int label;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        public C01281(TtsSpeakerSettingViewModel r1, boolean r2, String r3, String r4, Continuation<? super C01281> r5) {
            this.this$0 = r1;
            this.$isFromTts = r2;
            this.$userId = r3;
            this.$languageCode = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01281(this.this$0, this.$isFromTts, this.$userId, this.$languageCode, r8);
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
        L11:
            com.larus.network.http.y r11 = (com.larus.network.http.a) r10;
            if ((r11 instanceof com.larus.network.http.y) == false) goto L33;
            com.larus.network.http.y r12 = r11;
            r2a.g r2 = (r2a.g) ((com.larus.network.http.a) r12).b;
            if (r2 == null) goto L25;
            List<SpeakerVoice> r3 = r2.b();
            if (r3 == null) goto L25;
            TtsSpeakerSettingViewModel r4 = this.this$0;
            r2a.i r5 = (r2a.i) TtsSpeakerSettingViewModel.access$get_publicVoiceLiveData$p(r4).getValue();
            if (r5 == null) goto L23;
            List<SpeakerVoice> r6 = r5.b;
            if (r6 == null) goto L23;
            List r7 = CollectionsKt.toMutableList(r6);
            if (r7 == null) goto L23;
        L24:
            r7.addAll(r3);
            TtsSpeakerSettingViewModel.access$get_publicVoiceLiveData$p(r4).postValue(new r2a.i(3, r7));
        L23:
            r7 = new ArrayList();
        L25:
            r2a.g r13 = (r2a.g) ((com.larus.network.http.a) r12).b;
            if (r13 == null) goto L28;
            boolean r14 = Intrinsics.areEqual(r13.a(), Boxing.boxBoolean(true));
        L29:
            if (r14 == false) goto L31;
            TtsSpeakerSettingViewModel.access$get_loadMoreState$p(this.this$0).postValue(Boxing.boxInt(0));
        L36:
            return Unit.INSTANCE;
        L31:
            TtsSpeakerSettingViewModel.access$get_loadMoreState$p(this.this$0).postValue(Boxing.boxInt(2));
            goto L36
        L28:
            r14 = false;
            goto L29
        L33:
            if ((r11 instanceof com.larus.network.http.f) == false) goto L36;
            TtsSpeakerSettingViewModel.access$get_loadMoreState$p(this.this$0).postValue(Boxing.boxInt(1));
            goto L36
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            TtsSpeakerSettingViewModel r8 = this.this$0;
            boolean r9 = this.$isFromTts;
            String r15 = this.$userId;
            String r16 = this.$languageCode;
            TtsSpeakerSettingViewModel.access$setIndex$p(r8, TtsSpeakerSettingViewModel.access$getIndex$p(r8) + 1);
            int r17 = TtsSpeakerSettingViewModel.access$getIndex$p(this.this$0);
            this.label = 1;
            r10 = TtsSpeakerSettingViewModel.access$queryList(r8, r9, r15, r16, r17, this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$queryOtherVoiceList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel", f = "TtsSpeakerSettingViewModel.kt", i = {0, 0}, l = {363}, m = "queryOtherVoiceList", n = {"id", "index"}, s = {"L$0", "I$0"})
    public static final class C01291 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        public C01291(TtsSpeakerSettingViewModel r1, Continuation<? super C01291> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return TtsSpeakerSettingViewModel.access$queryOtherVoiceList(this.this$0, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$queryRecommendVoiceList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {353}, m = "queryRecommendVoiceList", n = {}, s = {})
    public static final class C01301 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        public C01301(TtsSpeakerSettingViewModel r1, Continuation<? super C01301> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return TtsSpeakerSettingViewModel.access$queryRecommendVoiceList(this.this$0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$requestPublicVoiceList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$requestPublicVoiceList$1", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFromTts;
        final /* synthetic */ String $languageCode;
        final /* synthetic */ String $userId;
        int label;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        public C01311(TtsSpeakerSettingViewModel r1, boolean r2, String r3, String r4, Continuation<? super C01311> r5) {
            this.this$0 = r1;
            this.$isFromTts = r2;
            this.$userId = r3;
            this.$languageCode = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01311(this.this$0, this.$isFromTts, this.$userId, this.$languageCode, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            com.larus.network.http.y r13 = (com.larus.network.http.a) r12;
            if ((r13 instanceof com.larus.network.http.y) == false) goto L29;
            com.larus.network.http.y r14 = r13;
            r2a.g r2 = (r2a.g) ((com.larus.network.http.a) r14).b;
            if (r2 == null) goto L22;
            List<SpeakerVoice> r3 = r2.b();
            if (r3 == null) goto L22;
            boolean r4 = this.$isFromTts;
            TtsSpeakerSettingViewModel r5 = this.this$0;
            if (r4 == false) goto L20;
            UgcVoiceLoader r6 = UgcVoiceLoader.a;
            List<SpeakerVoice> r7 = UgcVoiceLoader.g;
            ((CopyOnWriteArrayList) r7).clear();
            CopyOnWriteArrayList r8 = (CopyOnWriteArrayList) r7;
            r8.addAll(r3);
        L21:
            TtsSpeakerSettingViewModel.access$get_publicVoiceLiveData$p(r5).postValue(new r2a.i(3, r3));
            goto L22
        L20:
            UgcVoiceLoader r9 = UgcVoiceLoader.a;
            List<SpeakerVoice> r10 = UgcVoiceLoader.h;
            ((CopyOnWriteArrayList) r10).clear();
            CopyOnWriteArrayList r11 = (CopyOnWriteArrayList) r10;
            r11.addAll(r3);
        L22:
            r2a.g r15 = (r2a.g) ((com.larus.network.http.a) r14).b;
            if (r15 == null) goto L25;
            boolean r16 = Intrinsics.areEqual(r15.a(), Boxing.boxBoolean(true));
        L26:
            if (r16 == false) goto L28;
            TtsSpeakerSettingViewModel.access$get_loadMoreState$p(this.this$0).postValue(Boxing.boxInt(0));
        L31:
            return Unit.INSTANCE;
        L28:
            TtsSpeakerSettingViewModel.access$get_loadMoreState$p(this.this$0).postValue(Boxing.boxInt(2));
            goto L31
        L25:
            r16 = false;
            goto L26
        L29:
            TtsSpeakerSettingViewModel.access$get_publicVoiceLiveData$p(this.this$0).postValue(new r2a.i(1, new ArrayList()));
            goto L31
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            TtsSpeakerSettingViewModel.access$setIndex$p(this.this$0, 1);
            TtsSpeakerSettingViewModel r17 = this.this$0;
            boolean r18 = this.$isFromTts;
            String r19 = this.$userId;
            String r20 = this.$languageCode;
            this.label = 1;
            r12 = TtsSpeakerSettingViewModel.queryList$default(r17, r18, r19, r20, 0, this, 8, null);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$requestVoiceTab$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$requestVoiceTab$1", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        public C01321(TtsSpeakerSettingViewModel r1, Continuation<? super C01321> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01321(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            LinkedHashMap r3 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L14:
            dm9.a.b r15 = (dm9.a) r14;
            if ((r15 instanceof dm9.a.b) == false) goto L46;
            q2a.d r16 = (q2a.d) r15.a.getData();
            if (r16 == null) goto L29;
            Map<String, List<VoiceListTabInfo>> r17 = r16.a();
            if (r17 == null) goto L29;
            r3 = new LinkedHashMap(MapsKt.mapCapacity(r17.size()));
            Iterator<T> r18 = r17.entrySet().iterator();
        L22:
            if (r18.hasNext() == false) goto L29;
            Map.Entry r2 = (Map.Entry) r18.next();
            Object r4 = r2.getKey();
            List r5 = (List) r2.getValue();
            if (r5 == null) goto L27;
            List r6 = CollectionsKt.filterNotNull(r5);
            if (r6 == null) goto L27;
        L28:
            r3.put(r4, r6);
        L27:
            r6 = CollectionsKt.emptyList();
        L29:
            if (r3 != null) goto L31;
            FLogger.a.i(TtsSpeakerSettingViewModel.access$getTag$p(this.this$0), "requestVoiceTab tabInfo is null");
        L31:
            q2a.c.a.getClass();
            q2a.c.d = r3;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L39
            if (r3 != null) goto L36;
            ((Keva) q2a.c.b.getValue()).storeString("key_voice_list_tab_info", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L39
        L37:
            Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
        L41:
            Throwable r111 = Result.exceptionOrNull-impl(r110);
            if (r111 == null) goto L44;
            FLogger.a.e("GetVoiceTabRepo", "[saveVoiceTabToKeva] save voice tab to keva failed", r111);
        L44:
            TtsSpeakerSettingViewModel.access$get_voiceListTabInfo$p(this.this$0).postValue(r3);
        L50:
            return Unit.INSTANCE;
        L36:
            ((Keva) q2a.c.b.getValue()).storeString("key_voice_list_tab_info", ((Gson) q2a.c.c.getValue()).toJson(r3));     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r110 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L41
        L46:
            if ((r15 instanceof dm9.a.a) == false) goto L48;
            FLogger r8 = FLogger.a;
            String r9 = TtsSpeakerSettingViewModel.access$getTag$p(this.this$0);
            StringBuilder r10 = new StringBuilder("requestVoiceTab code: ");
            dm9.a.a r112 = (dm9.a.a) r15;
            r10.append(r112.a);
            r10.append(", msg: ");
            r10.append(r112.b);
            r10.append(", error: ");
            r10.append(r112.c);
            r8.e(r9, r10.toString(), r112.c);
        L48:
            TtsSpeakerSettingViewModel.access$get_voiceListTabInfo$p(this.this$0).postValue(null);
            goto L50
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            q2a.c.a.getClass();
            Map r113 = q2a.c.a();
            if (r113 == null) goto L11;
            TtsSpeakerSettingViewModel.access$get_voiceListTabInfo$p(this.this$0).postValue(r113);
        L11:
            GetVoiceTabApi.a r114 = GetVoiceTabApi.a;
            TtsSpeakerSettingViewModel$requestVoiceTab$1$response$1 r11 = new TtsSpeakerSettingViewModel$requestVoiceTab$1$response$1(null);
            this.label = 1;
            r114.getClass();
            FlowHttpConnection r115 = FlowHttpConnection.a;
            r14 = FlowHttpConnection.g("Audio", GetVoiceTabApi.class, r11, false, null, null, null, this, 248);
            if (r14 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {610}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        public C01331(TtsSpeakerSettingViewModel r1, Continuation<? super C01331> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01331(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L11:
            dm9.a.b r14 = (dm9.a) r13;
            if ((r14 instanceof dm9.a.b) == false) goto L30;
            s2a.a r15 = (s2a.a) r14.a.getData();
            if (r15 != null) goto L16;
            FLogger.a.i(TtsSpeakerSettingViewModel.access$getTag$p(this.this$0), "[tryRequestVoiceMaterial]: data is null");
        L16:
            t2a.c.a.getClass();
            t2a.c.d = r15;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
            if (r15 != null) goto L21;
            ((Keva) t2a.c.b.getValue()).storeString("key_voice_material_response", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L24
        L22:
            Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            Throwable r17 = Result.exceptionOrNull-impl(r16);
            if (r17 == null) goto L33;
            FLogger.a.e("VoiceMaterialRepo", "saveVoiceMaterialResponse error", r17);
        L33:
            return Unit.INSTANCE;
        L21:
            ((Keva) t2a.c.b.getValue()).storeString("key_voice_material_response", ((Gson) t2a.c.c.getValue()).toJson(r15));     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r16 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L26
        L30:
            if ((r14 instanceof dm9.a.a) == false) goto L35;
            FLogger r4 = FLogger.a;
            String r5 = TtsSpeakerSettingViewModel.access$getTag$p(this.this$0);
            StringBuilder r6 = new StringBuilder("[tryRequestVoiceMaterial]: code = ");
            dm9.a.a r18 = (dm9.a.a) r14;
            r6.append(r18.a);
            r6.append(", msg = ");
            r6.append(r18.b);
            r4.e(r5, r6.toString(), r18.c);
            goto L33
        L35:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            VoiceMaterialApi.a r19 = VoiceMaterialApi.a;
            TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1 r7 = new TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1(null);
            this.label = 1;
            r19.getClass();
            FlowHttpConnection r110 = FlowHttpConnection.a;
            r13 = FlowHttpConnection.g("Audio", VoiceMaterialApi.class, r7, false, null, null, null, this, 248);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$trySaveUserSelectVoice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$trySaveUserSelectVoice$1", f = "TtsSpeakerSettingViewModel.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {667, 689, 706, 733, 742, 749, 864, 866}, m = "invokeSuspend", n = {"findBotResult", "updateLocalBotResult", "findBotResult", "updateLocalBotResult", "result", "voice", "findBotResult", "updateLocalBotResult", "result", "voice", "findBotResult", "updateLocalBotResult", "result", "voice", "findBotResult", "updateLocalBotResult", "result", "voice", "context", "findBotResult", "updateLocalBotResult", "result", "voice"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
    public static final class C01341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $botInfo;
        final /* synthetic */ String $clickFrom;
        final /* synthetic */ String $enterFrom;
        final /* synthetic */ String $enterMethod;
        final /* synthetic */ boolean $isFromVoiceCloneScheme;
        final /* synthetic */ SpeakerVoice $nonVoice;
        final /* synthetic */ RecommendFrom $recommendFrom;
        final /* synthetic */ boolean $showSuccessToast;
        final /* synthetic */ JSONObject $trackParams;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$trySaveUserSelectVoice$1$6, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$trySaveUserSelectVoice$1$6", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $context;
            int label;

            public AnonymousClass6(Activity r1, Continuation<? super AnonymousClass6> r2) {
                this.$context = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass6(this.$context, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                t19.s r4 = t19.s.a;
                Activity r0 = this.$context;
                r4.getClass();
                t19.s.b(r0, 2131907872, false);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$trySaveUserSelectVoice$1$7, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$trySaveUserSelectVoice$1$7", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {750}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $context;
            int label;

            public AnonymousClass7(Activity r1, Continuation<? super AnonymousClass7> r2) {
                this.$context = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass7(this.$context, r3);
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
                t19.s r5 = t19.s.a;
                Activity r2 = this.$context;
                r5.getClass();
                t19.s.o(r2, 2131911121, false);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                this.label = 1;
                if (DelayKt.delay(TtsSpeakerSettingViewModel.VOICE_UPDATE_RETRY_DELAY_MS, this) != r0) goto L11;
                return r0;
            }
        }

        public C01341(TtsSpeakerSettingViewModel r1, String r2, BotModel r3, RecommendFrom r4, JSONObject r5, String r6, String r7, boolean r8, SpeakerVoice r9, boolean r10, Continuation<? super C01341> r11) {
            this.this$0 = r1;
            this.$enterMethod = r2;
            this.$botInfo = r3;
            this.$recommendFrom = r4;
            this.$trackParams = r5;
            this.$enterFrom = r6;
            this.$clickFrom = r7;
            this.$showSuccessToast = r8;
            this.$nonVoice = r9;
            this.$isFromVoiceCloneScheme = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
            return new C01341(this.this$0, this.$enterMethod, this.$botInfo, this.$recommendFrom, this.$trackParams, this.$enterFrom, this.$clickFrom, this.$showSuccessToast, this.$nonVoice, this.$isFromVoiceCloneScheme, r14);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r37) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean r10 = true;
            String r12 = null;
            switch(this.label) {
                case 0: goto L13;
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r37);
        L202:
            return Unit.INSTANCE;
        L7:
            final SpeakerVoice r0 = (SpeakerVoice) this.L$3;
            p2a.m r1 = (p2a.m) this.L$2;
            Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$1;
            final Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r37);
        L112:
            int r4 = y2a.a.a;
            JSONObject r5 = new JSONObject();
            boolean r6 = this.$isFromVoiceCloneScheme;
            final String r7 = this.$enterMethod;
            final BotModel r9 = this.$botInfo;
            r5.put("is_scheme", y2a.b.b(r6));
            r5.put("enter_method", y2a.b.a(r7));
            if ((r1 instanceof p2a.j) == false) goto L116;
            r5.put("result", "Fail");
            r5.put("reason", "ConfSaveFailed");
        L182:
            Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
            com.larus.platform.service.g.a.monitorEventForSlardar("voice_settings_change_end", r5, null, null);
            com.larus.platform.service.o.a.reportEvent("voice_settings_change_end", r5);
            goto L202
        L116:
            if (z2.a.enableGetBotListAfterSaveVoice() == false) goto L179;
            Object r11 = r3.element;
            if (r11 != null) goto L120;
        L165:
            if (r11 != null) goto L167;
        L169:
            if (r11 == null) goto L171;
        L173:
            if (r11 == null) goto L175;
        L177:
            Unit r13 = Unit.INSTANCE;
            goto L182
        L175:
            if (r2.element == true) goto L177;
            r5.put("result", "Fail");
            r5.put("reason", "UpdateBotFail + GetBotFail");
            f2a.c r14 = com.larus.voice_setting.voice.utils.k.a.b("UpdateBotFail + GetBotFail");
            r14.e(new u1(r7, r9, r0));
            r14.c.b = CollectionsKt.listOf("VoiceChange");
            f2a.c.c(r14, null, 15);
            goto L177
        L171:
            if (r2.element == false) goto L173;
            r5.put("result", "Success");
            r5.put("reason", "UpdateBotSuccess + GetBotFail");
            f2a.c r15 = com.larus.voice_setting.voice.utils.k.a.b("UpdateBotSuccess + GetBotFail");
            r15.e(new t1(r7, r9, r0));
            r15.c.b = CollectionsKt.listOf("VoiceChange");
            f2a.c.c(r15, null, 15);
            goto L177
        L167:
            if (r2.element == true) goto L169;
            r5.put("result", "Fail");
            r5.put("reason", "UpdateBotFail + GetBotSuccess");
            f2a.c r16 = com.larus.voice_setting.voice.utils.k.a.b("UpdateBotFail + GetBotSuccess");
            r16.e(new s1(r7, r9, r0));
            r16.c.b = CollectionsKt.listOf("VoiceChange");
            f2a.c.c(r16, null, 15);
            goto L177
        L120:
            if (r2.element == false) goto L165;
            float r17 = 0.0f;
            if (r0 == null) goto L124;
            float r18 = r0.getPitchF64();
        L125:
            SpeakerVoice r19 = ((BotModel) r3.element).getVoiceType();
            if (r19 == null) goto L128;
            float r110 = r19.getPitchF64();
        L129:
            boolean r20 = com.larus.bmhome.utils.b0.a(r18, r110);
            if (r0 == null) goto L132;
            float r111 = r0.getSpeechRateF64();
        L133:
            SpeakerVoice r112 = ((BotModel) r3.element).getVoiceType();
            if (r112 == null) goto L136;
            r17 = r112.getSpeechRateF64();
        L136:
            boolean r21 = com.larus.bmhome.utils.b0.a(r111, r17);
            if (r0 == null) goto L139;
            String r113 = r0.getStyleId();
        L140:
            SpeakerVoice r114 = ((BotModel) r3.element).getVoiceType();
            if (r114 == null) goto L143;
            String r115 = r114.getStyleId();
        L145:
            if (Intrinsics.areEqual(r113, r115) == false) goto L149;
            if (r20 == false) goto L149;
            if (r21 == false) goto L149;
            r5.put("result", "Success");
        L149:
            r5.put("result", "Fail");
            StringBuilder r22 = new StringBuilder("ConfSaveAndUpdateBotNotEqual");
            if (r0 == null) goto L152;
            String r116 = r0.getStyleId();
        L153:
            SpeakerVoice r117 = ((BotModel) r3.element).getVoiceType();
            if (r117 == null) goto L156;
            String r118 = r117.getStyleId();
        L158:
            if (Intrinsics.areEqual(r116, r118) == true) goto L160;
            r22.append(" + StyleIdNotEqual");
        L160:
            if (r20 == true) goto L162;
            r22.append(" + PitchNotEqual");
        L162:
            if (r21 == true) goto L164;
            r22.append(" + SpeechRateNotEqual");
        L164:
            r5.put("reason", r22.toString());
            f2a.c r23 = com.larus.voice_setting.voice.utils.k.a.b("Conf Save And Update Bot Not Equal");
            r23.e(new r1(r7, r9, r0, r3));
            r23.c.b = CollectionsKt.listOf("VoiceChange");
            f2a.c.c(r23, null, 15);
            Unit r24 = Unit.INSTANCE;
            goto L177
        L156:
            r118 = null;
            goto L158
        L152:
            r116 = null;
            goto L153
        L143:
            r115 = null;
            goto L145
        L139:
            r113 = null;
            goto L140
        L132:
            r111 = 0.0f;
            goto L133
        L128:
            r110 = 0.0f;
            goto L129
        L124:
            r18 = 0.0f;
            goto L125
        L179:
            if (r2.element == false) goto L181;
            r5.put("result", "Success");
            goto L182
        L181:
            r5.put("result", "Fail");
            r5.put("reason", "UpdateBotFail");
            goto L182
        L8:
            Ref.ObjectRef r25 = (Ref.ObjectRef) this.L$5;
            Activity r26 = (Activity) this.L$4;
            SpeakerVoice r27 = (SpeakerVoice) this.L$3;
            p2a.m r28 = (p2a.m) this.L$2;
            Ref.BooleanRef r29 = (Ref.BooleanRef) this.L$1;
            Ref.ObjectRef r30 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r37);
            Ref.ObjectRef r119 = r25;
            Object r31 = r37;
        L105:
            r119.element = r31;
            Activity r120 = r26;
            r0 = r27;
            r1 = r28;
            r2 = r29;
            r3 = r30;
        L108:
            if (this.$showSuccessToast == false) goto L112;
            MainCoroutineDispatcher r32 = Dispatchers.getMain();
            AnonymousClass7 r33 = new AnonymousClass7(r120, null);
            this.L$0 = r3;
            this.L$1 = r2;
            this.L$2 = r1;
            this.L$3 = r0;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 6;
            if (BuildersKt.withContext(r32, r33, this) != r8) goto L112;
            return r8;
        L9:
            r0 = (SpeakerVoice) this.L$3;
            r1 = (p2a.m) this.L$2;
            r2 = (Ref.BooleanRef) this.L$1;
            r3 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r37);
        L92:
            FLogger r34 = FLogger.a;
            String r35 = TtsSpeakerSettingViewModel.access$getTag$p(this.this$0);
            StringBuilder r36 = new StringBuilder("[trySaveUserSelectVoice] save voice error ");
            p2a.j r38 = (p2a.j) r1;
            r36.append(r38.a);
            r36.append(", code = ");
            r36.append(r38.b);
            r36.append(", message = ");
            r36.append(r38.c);
            r34.e(r35, r36.toString());
            goto L112
        L10:
            SpeakerVoice r39 = (SpeakerVoice) this.L$3;
            p2a.m r40 = (p2a.m) this.L$2;
            Ref.BooleanRef r41 = (Ref.BooleanRef) this.L$1;
            Ref.ObjectRef r42 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r37);
            SpeakerVoice r43 = r39;
            p2a.m r44 = r40;
            r119 = r42;
            Ref.BooleanRef r45 = r41;
        L65:
            com.larus.voice_setting.voice.base.g1 r121 = com.larus.voice_setting.voice.base.g1.a;
            BotModel r46 = this.$botInfo;
            if (r46 == null) goto L68;
            String r122 = r46.getBotId();
        L69:
            RecommendFrom r47 = this.$recommendFrom;
            if (r47 == null) goto L72;
            String r210 = r47.a;
        L73:
            if (r47 == null) goto L75;
            String r211 = r47.b;
        L76:
            if (r43 == null) goto L82;
            List r48 = r43.getMixVoiceList();
            if (r48 == null) goto L82;
            MixVoice r49 = (MixVoice) CollectionsKt.firstOrNull(r48);
            if (r49 == null) goto L82;
            String r310 = r49.getTabName();
        L83:
            if (r43 == null) goto L85;
            String r50 = "1";
        L86:
            String r311 = r50;
            ouc.d0 r312 = TtsSpeakerSettingViewModel.access$toTrackParamsJsonObject(this.this$0, this.$trackParams);
            String r51 = this.$enterFrom;
            p2a.d.a.a(r121, r43, r122, false, r51, r51, this.$clickFrom, r210, r211, null, null, null, null, null, null, null, this.$enterMethod, r310, null, null, r311, r312, 851456);
            r120 = AppHost.a.a().getCurrentActivity();
            if ((r44 instanceof p2a.j) == false) goto L94;
            f2a.c r52 = com.larus.voice_setting.voice.utils.k.a.a("Mixed Voice Requester fail");
            final String r53 = this.$enterMethod;
            final BotModel r54 = this.$botInfo;
            r52.e(new q1(r53, r54));
            r52.c.b = CollectionsKt.listOf("VoiceChange");
            f2a.c.c(r52, null, 15);
            MainCoroutineDispatcher r55 = Dispatchers.getMain();
            AnonymousClass6 r56 = new AnonymousClass6(r120, null);
            this.L$0 = r119;
            this.L$1 = r45;
            this.L$2 = r44;
            this.L$3 = r43;
            this.L$4 = null;
            this.label = 4;
            if (BuildersKt.withContext(r55, r56, this) != r8) goto L91;
            return r8;
        L91:
            r2 = r45;
            r1 = r44;
            r0 = r43;
            r3 = r119;
            goto L92
        L94:
            if (z2.a.enableGetBotListAfterSaveVoice() == false) goto L106;
            IBotRepoService r57 = zh8.a.e;
            BotModel r58 = this.$botInfo;
            if (r58 == null) goto L98;
            String r59 = r58.getBotId();
        L99:
            if (r59 != null) goto L101;
            r59 = NameKeys.UnloadStrategy_No_Strategy;
        L101:
            this.L$0 = r119;
            this.L$1 = r45;
            this.L$2 = r44;
            this.L$3 = r43;
            this.L$4 = r120;
            this.L$5 = r119;
            this.label = 5;
            Ref.BooleanRef r60 = r45;
            p2a.m r123 = r44;
            SpeakerVoice r124 = r43;
            r31 = IBotRepoService.b.a(r57, r59, true, "default_write", false, this, 24);
            if (r31 != r8) goto L104;
            return r8;
        L104:
            r29 = r60;
            r30 = r119;
            r26 = r120;
            r27 = r124;
            r28 = r123;
            goto L105
        L98:
            r59 = null;
            goto L99
        L106:
            r2 = r45;
            r3 = r119;
            r0 = r43;
            r1 = r44;
            goto L108
        L85:
            r50 = "0";
        L82:
            r310 = null;
            goto L83
        L75:
            r211 = null;
            goto L76
        L72:
            r210 = null;
            goto L73
        L68:
            r122 = null;
            goto L69
        L11:
            Ref.BooleanRef r61 = (Ref.BooleanRef) this.L$4;
            final SpeakerVoice r62 = (SpeakerVoice) this.L$3;
            p2a.m r63 = (p2a.m) this.L$2;
            Ref.BooleanRef r64 = (Ref.BooleanRef) this.L$1;
            Ref.ObjectRef r65 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r37);
            Ref.BooleanRef r125 = r61;
            Object r66 = r37;
        L51:
            final String r67 = this.$enterMethod;
            final BotModel r126 = this.$botInfo;
            Boolean r68 = (Boolean) r66;
            boolean r127 = r68.booleanValue();
            f2a.d r128 = com.larus.voice_setting.voice.utils.k.a;
            if (r127 == false) goto L54;
            String r129 = "Update Local Bot Success";
        L55:
            f2a.c r130 = r128.b(r129);
            r130.e(new p1(r67, r126, r62));
            r130.c.b = CollectionsKt.listOf("VoiceChange");
            f2a.c.c(r130, null, 15);
            r125.element = r68.booleanValue();
            AudioServiceDelegate.a.i0().f(r62);
            r125 = r64;
        L56:
            if (r62 == null) goto L64;
            TtsSpeakerSettingViewModel r69 = this.this$0;
            BotModel r70 = this.$botInfo;
            if (r70 == null) goto L60;
            String r71 = r70.getBotId();
        L61:
            this.L$0 = r65;
            this.L$1 = r125;
            this.L$2 = r63;
            this.L$3 = r62;
            this.L$4 = null;
            this.label = 3;
            if (TtsSpeakerSettingViewModel.access$updateBotInfo(r69, r62, r71, this) != r8) goto L64;
            return r8;
        L60:
            r71 = null;
        L64:
            r43 = r62;
            r119 = r65;
            r45 = r125;
            r44 = r63;
            goto L65
        L54:
            r129 = "Update Local Bot Fail";
            goto L55
        L12:
            Ref.BooleanRef r72 = (Ref.BooleanRef) this.L$1;
            Ref.ObjectRef r73 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r37);
            r125 = r72;
            r65 = r73;
            Object r74 = r37;
        L35:
            r63 = (p2a.m) r74;
            r62 = (SpeakerVoice) r63.a;
            FLogger r75 = FLogger.a;
            String r76 = TtsSpeakerSettingViewModel.access$getTag$p(this.this$0);
            StringBuilder r77 = new StringBuilder("[trySaveUserSelectVoice] save voice is Nullable(");
            if (r62 == null) goto L39;
            r10 = false;
        L39:
            r77.append(r10);
            r77.append(')');
            r75.i(r76, r77.toString());
            if ((r63 instanceof p2a.o) == false) goto L56;
            f2a.c r78 = com.larus.voice_setting.voice.utils.k.a.b("Mixed Voice Requester Success");
            final String r79 = this.$enterMethod;
            final BotModel r80 = this.$botInfo;
            r78.e(new n1(r79, r80, r62));
            r78.c.b = CollectionsKt.listOf("VoiceChange");
            f2a.c.c(r78, null, 15);
            IBotRepoService r81 = zh8.a.e;
            BotModel r82 = this.$botInfo;
            if (r82 == null) goto L44;
            String r83 = r82.getBotId();
        L45:
            if (r83 != null) goto L47;
            r83 = NameKeys.UnloadStrategy_No_Strategy;
        L47:
            Function1 r84 = new o1(r62);
            this.L$0 = r65;
            this.L$1 = r125;
            this.L$2 = r63;
            this.L$3 = r62;
            this.L$4 = r125;
            this.label = 2;
            r66 = r81.l1(r83, r84, this);
            if (r66 != r8) goto L50;
            return r8;
        L50:
            r64 = r125;
            goto L51
        L44:
            r83 = null;
            goto L45
        L13:
            ResultKt.throwOnFailure(r37);
            if (z2.a.o3().a == false) goto L183;
            final w2a.f r85 = TtsSpeakerSettingViewModel.access$generateVoiceEditInfo(this.this$0, this.$enterMethod);
            Ref.ObjectRef r131 = new Ref.ObjectRef();
            r125 = new Ref.BooleanRef();
            f2a.c r86 = com.larus.voice_setting.voice.utils.k.a.b("Send Request");
            final BotModel r87 = this.$botInfo;
            final String r88 = this.$enterMethod;
            r86.e(new m1(r85, r87, r88));
            r86.c.b = CollectionsKt.listOf("VoiceChange");
            f2a.c.c(r86, null, 15);
            p2a.i r89 = p2a.i.b;
            BotModel r90 = this.$botInfo;
            if (r90 == null) goto L20;
            SpeakerVoice r91 = r90.getVoiceType();
            if (r91 == null) goto L20;
            String r92 = r91.getId();
        L21:
            BotModel r93 = this.$botInfo;
            if (r93 == null) goto L24;
            String r94 = r93.getBotId();
        L25:
            BotModel r95 = this.$botInfo;
            if (r95 == null) goto L30;
            SpeakerVoice r96 = r95.getVoiceType();
            if (r96 == null) goto L30;
            String r97 = r96.getLanguageCode();
        L31:
            this.L$0 = r131;
            this.L$1 = r125;
            this.label = 1;
            r74 = r89.y2(r85, r92, r94, r97, this);
            if (r74 != r8) goto L34;
            return r8;
        L34:
            r65 = r131;
        L30:
            r97 = null;
            goto L31
        L24:
            r94 = null;
        L20:
            r92 = null;
            goto L21
        L183:
            SpeakerVoice r98 = this.$nonVoice;
            if (r98 == null) goto L186;
            String r99 = r98.getId();
        L188:
            if (Intrinsics.areEqual(r99, VoiceDisplayScene.NONE) == false) goto L195;
            TtsSpeakerSettingViewModel r100 = this.this$0;
            BotModel r101 = this.$botInfo;
            if (r101 == null) goto L192;
            r12 = r101.getBotId();
        L192:
            this.label = 7;
            if (TtsSpeakerSettingViewModel.access$updateBotInfo(r100, r98, r12, this) != r8) goto L202;
            return r8;
        L195:
            TtsSpeakerSettingViewModel r102 = this.this$0;
            BotModel r103 = this.$botInfo;
            if (r103 == null) goto L198;
            r12 = r103.getBotId();
        L198:
            this.label = 8;
            if (TtsSpeakerSettingViewModel.access$updateBotInfo(r102, r98, r12, this) != r8) goto L202;
            return r8;
        L186:
            r99 = null;
            goto L188
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$updateBotInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel", f = "TtsSpeakerSettingViewModel.kt", i = {0}, l = {897, 898}, m = "updateBotInfo", n = {"voice"}, s = {"L$0"})
    public static final class C01351 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        public C01351(TtsSpeakerSettingViewModel r1, Continuation<? super C01351> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return TtsSpeakerSettingViewModel.access$updateBotInfo(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$updateBotInfo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$updateBotInfo$2", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ wc9.e $cvs;
        final /* synthetic */ SpeakerVoice $voice;
        int label;
        final /* synthetic */ TtsSpeakerSettingViewModel this$0;

        public AnonymousClass2(SpeakerVoice r1, wc9.e r2, TtsSpeakerSettingViewModel r3, Continuation<? super AnonymousClass2> r4) {
            this.$voice = r1;
            this.$cvs = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$voice, this.$cvs, this.this$0, r5);
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
            int r5 = com.larus.bmhome.bot.a.a;
            SpeakerVoice r6 = this.$voice;
            Integer r0 = null;
            if (r6 == null) goto L21;
            String r7 = r6.getLanguageCode();
            if (r7 == null) goto L22;
            wc9.e r1 = this.$cvs;
            TtsSpeakerSettingViewModel r2 = this.this$0;
            if (r1 == null) goto L11;
            r0 = r1.v;
        L11:
            String r8 = TtsSpeakerSettingViewModel.access$findAsrLanguageByLanguageCode(r2, r7);
            if (r0 != null) goto L15;
        L17:
            IChatRepoService r3 = zh8.a.a;
            zh8.a.c.C0(r8);
            return Unit.INSTANCE;
        L15:
            if (r0.intValue() != 1) goto L17;
            AudioServiceDelegate.a.g0(r8);
            goto L17
        L22:
            return null;
        L21:
            return null;
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ArrayList Mo(TtsSpeakerSettingViewModel r0, AudioUserConfig r1) {
        return getTtsSpeakerGroups$lambda$7(r0, r1);
    }

    public static /* synthetic */ com.larus.im.service.o No() {
        return botService_delegate$lambda$4();
    }

    public static /* synthetic */ com.larus.im.service.r Oo() {
        return conversationService_delegate$lambda$5();
    }

    public static /* synthetic */ void getSelectVoiceMode$annotations() {
    }

    private final boolean resolveExperimentDefaultEnabled(int r3) {
        if (r3 != 0) goto L5;
        return false;
    L5:
        if (r3 != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public static /* synthetic */ ArrayList yo(TtsSpeakerSettingViewModel r0, com.larus.bmhome.auth.c1 r1) {
        return getTtsSpeakerGroups$lambda$9(r0, r1);
    }

    private final com.larus.im.service.o getBotService() {
        return (com.larus.im.service.o) this.botService$delegate.getValue();
    }

    private final com.larus.im.service.r getConversationService() {
        return (com.larus.im.service.r) this.conversationService$delegate.getValue();
    }

    public final void deleteSelectVoice() {
        this._deleteSelectVoice.postValue(Boolean.TRUE);
    }

    public final List<SpeakerVoice> getPreloadOtherVoiceList() {
        UgcVoiceLoader r0 = UgcVoiceLoader.a;
        return UgcVoiceLoader.h;
    }

    public final List<SpeakerVoice> getPreloadRecommendVoiceList() {
        UgcVoiceLoader r0 = UgcVoiceLoader.a;
        return UgcVoiceLoader.g;
    }

    public final int getSelectVoiceMode() {
        return this.speakerVoiceEditModel.g;
    }

    public final boolean getShowSelectedVoiceOnTop() {
        return this.speakerVoiceEditModel.f;
    }

    public final LiveData<ArrayList<p68.h>> getTtsSpeakerGroups() {
        if (FeatureKitDelegate.b.w0().b() == true) goto L9;
        if (z2.a.a1() == true) goto L9;
        return Transformations.distinctUntilChanged(Transformations.map(AuthModelDelegate.b.j(), new l1(this)));
    L9:
        return Transformations.distinctUntilChanged(Transformations.map(AudioServiceDelegate.a.p(), new k1(this)));
    }

    public final boolean getVoiceCanEdit() {
        return this.speakerVoiceEditModel.h;
    }

    public final boolean isMultiVoiceMixMode() {
        return this.speakerVoiceEditModel.e;
    }

    public final boolean isTtsBackgroundPlayDirty() {
        Boolean r0 = this.ttsBackgroundPlayInitial;
        Boolean r1 = (Boolean) this._ttsBackgroundPlayChecked.getValue();
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        if (Intrinsics.areEqual(r0, r1) == true) goto L8;
        return true;
    L8:
        return false;
    }

    public final void loadTtsBackgroundPlaySetting() {
        String r0 = AccountService.a.getUserId();
        com.larus.audio.ttsV2.f.a.getClass();
        boolean r1 = com.larus.audio.ttsV2.f.a(r0);
        int r2 = z2.a.getTtsBackgroundPlayExperimentMode();
        if (r1 == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        this.showTtsBackgroundPlayToggle = r3;
        if (r3 == true) goto L13;
        this.ttsBackgroundPlayInitial = Boolean.FALSE;
        return;
    L13:
        boolean r4 = resolveExperimentDefaultEnabled(r2);
        if (r1 == false) goto L17;
        r4 = ITtsBackgroundPlayControlService.a.b();
    L17:
        if (this.ttsBackgroundPlayInitial != null) goto L19;
        this.ttsBackgroundPlayInitial = Boolean.valueOf(r4);
    L19:
        this._ttsBackgroundPlayChecked.setValue(Boolean.valueOf(r4));
        return;
    L5:
        if (r2 != (-1)) goto L8;
        r3 = false;
        goto L9
    }

    public final boolean saveTtsBackgroundPlaySettingIfNeeded() {
        if (this.showTtsBackgroundPlayToggle == true) goto L5;
        return true;
    L5:
        Boolean r0 = this.ttsBackgroundPlayInitial;
        Boolean r2 = (Boolean) this._ttsBackgroundPlayChecked.getValue();
        if (r0 == null) goto L20;
        if (r2 == null) goto L20;
        if (Intrinsics.areEqual(r0, r2) == true) goto L20;
        com.larus.audio.ttsV2.f r1 = com.larus.audio.ttsV2.f.a;
        boolean r3 = r2.booleanValue();
        String r4 = AccountService.a.getUserId();
        r1.getClass();
        boolean r5 = com.larus.audio.ttsV2.f.c(r3, r4);
        if (r5 == false) goto L14;
        this.ttsBackgroundPlayInitial = r2;
    L14:
        com.larus.platform.service.o r6 = com.larus.platform.service.o.a;
        JSONObject r7 = new JSONObject();
        r7.put("current_page", "bot_voice_change");
        if (r2.booleanValue() == false) goto L17;
        String r8 = "on";
    L18:
        r7.put("to_status", r8);
        r7.put("success", r5 ? 1 : 0);
        Unit r9 = Unit.INSTANCE;
        r6.reportEvent("read_background_switch_result", r7);
        return r5;
    L17:
        r8 = "off";
    L20:
        return true;
    }

    public final void saveVoicePitchAndRate() {
        List<MixVoice> r1 = this.speakerVoiceEditModel.g().a;
        ArrayList r2 = null;
        if (r1 == null) goto L14;
        List<MixVoice> r3 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        MixVoice r6 = (MixVoice) r5.next();
        int r7 = r6.getPercentage();
        SpeakerVoice r8 = r6.getVoiceItem();
        if (r8 == null) goto L10;
        SpeakerVoice r9 = SpeakerVoice.copy$default(r8, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, Integer.MAX_VALUE, null);
    L11:
        r4.add(new MixVoice(r9, r7, false, r6.getTabName(), 4, null));
        goto L6
    L10:
        r9 = null;
        goto L11
    L12:
        r2 = r4;
    L14:
        if (r2 == null) goto L18;
        boolean r10 = true;
        if (r2.size() != 1) goto L18;
    L19:
        if (r10 == false) goto L28;
        VoicePitchAndRateManager r11 = VoicePitchAndRateManager.a;
        com.larus.voice_setting.voice.editvoice.b1 r12 = (com.larus.voice_setting.voice.editvoice.b1) this.speakerVoiceEditModel.C.getValue();
        if (r12 != null) goto L23;
        r12 = new com.larus.voice_setting.voice.editvoice.b1(0);
    L23:
        r11.getClass();
        VoicePitchAndRateManager.d(r2, r12);
        return;
    L28:
        return;
    L18:
        r10 = false;
        goto L19
    }

    private static final com.larus.im.service.o botService_delegate$lambda$4() {
        return com.larus.im.d.a();
    }

    private static final com.larus.im.service.r conversationService_delegate$lambda$5() {
        return com.larus.im.d.d();
    }

    public final void requestVoiceTab() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01321(this, null), 2, null);
    }

    public final void tryRequestVoiceMaterial() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01331(this, null), 2, null);
    }

    public final LiveData<Boolean> getDeleteSelectVoice() {
        return this.deleteSelectVoice;
    }

    public final LiveData<Integer> getLanguageItemStyle() {
        return this.languageItemStyle;
    }

    public final NonStickyLiveData<Integer> getLoadMoreState() {
        return this.loadMoreState;
    }

    public final LiveData<r2a.i> getPublicVoiceLiveData() {
        return this.publicVoiceLiveData;
    }

    public final boolean getShowTtsBackgroundPlayToggle() {
        return this.showTtsBackgroundPlayToggle;
    }

    public final SpeakerVoiceEditModel getSpeakerVoiceEditModel() {
        return this.speakerVoiceEditModel;
    }

    public final LiveData<Boolean> getTtsBackgroundPlayChecked() {
        return this.ttsBackgroundPlayChecked;
    }

    public final LiveData<Map<String, List<VoiceListTabInfo>>> getVoiceListTabInfo() {
        return this.voiceListTabInfo;
    }

    public final LiveData<ub8.h> getVoiceUpdate() {
        return this._voiceUpdate;
    }

    public final NonStickyLiveData<Boolean> isFallBackToSystemVoice() {
        return this.isFallBackToSystemVoice;
    }

    public TtsSpeakerSettingViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.tag = "TtsSpeakerSettingViewModel";
        this.speakerVoiceEditModel = new SpeakerVoiceEditModel(ViewModelKt.getViewModelScope(this));
        this._voiceUpdate = new MutableResult();
        this.PAGE_SIZE = 20;
        this.index = 1;
        NonStickyLiveData<Integer> r0 = new NonStickyLiveData();
        this._loadMoreState = r0;
        this.loadMoreState = r0;
        NonStickyLiveData<r2a.i> r1 = new NonStickyLiveData();
        this._publicVoiceLiveData = r1;
        this.publicVoiceLiveData = r1;
        NonStickyLiveData<Boolean> r3 = new NonStickyLiveData();
        this._deleteSelectVoice = r3;
        this.deleteSelectVoice = r3;
        this.isFallBackToSystemVoice = new NonStickyLiveData();
        MutableLiveData<Integer> r4 = new MutableLiveData(1);
        this._languageItemStyle = r4;
        this.languageItemStyle = r4;
        MutableLiveData<Map<String, List<VoiceListTabInfo>>> r5 = new MutableLiveData();
        this._voiceListTabInfo = r5;
        this.voiceListTabInfo = r5;
        MutableLiveData<Boolean> r6 = new MutableLiveData(Boolean.FALSE);
        this._ttsBackgroundPlayChecked = r6;
        this.ttsBackgroundPlayChecked = Transformations.distinctUntilChanged(r6);
        this.botService$delegate = LazyKt.lazy(new i1());
        this.conversationService$delegate = LazyKt.lazy(new j1());
    }

    public static final /* synthetic */ com.larus.im.service.o access$getBotService(TtsSpeakerSettingViewModel r0) {
        return r0.getBotService();
    }

    public static final /* synthetic */ int access$getIndex$p(TtsSpeakerSettingViewModel r0) {
        return r0.index;
    }

    public static final /* synthetic */ String access$getTag$p(TtsSpeakerSettingViewModel r0) {
        return r0.tag;
    }

    public static final /* synthetic */ NonStickyLiveData access$get_loadMoreState$p(TtsSpeakerSettingViewModel r0) {
        return r0._loadMoreState;
    }

    public static final /* synthetic */ NonStickyLiveData access$get_publicVoiceLiveData$p(TtsSpeakerSettingViewModel r0) {
        return r0._publicVoiceLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_voiceListTabInfo$p(TtsSpeakerSettingViewModel r0) {
        return r0._voiceListTabInfo;
    }

    public static final /* synthetic */ MutableResult access$get_voiceUpdate$p(TtsSpeakerSettingViewModel r0) {
        return r0._voiceUpdate;
    }

    private final String findAsrLanguageByLanguageCode(String r5) {
        Object r1 = null;
        if (AppHost.a.isOversea() == true) goto L5;
    L15:
        com.larus.bmhome.auth.c1 r0 = (com.larus.bmhome.auth.c1) AuthModelDelegate.b.j().getValue();
        if (r0 == null) goto L36;
        com.larus.bmhome.auth.b r2 = (com.larus.bmhome.auth.b) r0.d;
        if (r2 == null) goto L37;
        List r3 = r2.q();
        if (r3 == null) goto L38;
        Iterator r4 = r3.iterator();
    L23:
        if (r4.hasNext() == false) goto L27;
        Object r6 = r4.next();
        if (Intrinsics.areEqual(((SpeechLanguage) r6).c(), r5) == false) goto L23;
        r1 = r6;
    L27:
        SpeechLanguage r7 = (SpeechLanguage) r1;
        if (r7 == null) goto L39;
        String r8 = r7.a();
        if (r8 != null) goto L32;
        return r5;
    L32:
        return r8;
    L39:
        return r5;
    L38:
        return r5;
    L37:
        return r5;
    L36:
        return r5;
    L5:
        if (Intrinsics.areEqual(r5, "multi") == false) goto L15;
        String r9 = com.larus.utils.b0.a;
        AppLocaleUtils.a.getClass();
        String r10 = com.larus.utils.b0.c(AppLocaleUtils.c());
        if (r10.length() <= 0) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == true) goto L13;
        r10 = null;
    L13:
        if (r10 == null) goto L15;
        return r10;
    L9:
        r11 = false;
        goto L10
    }

    private final w2a.f generateVoiceEditInfo(String r45) {
        w2a.f r1 = this.speakerVoiceEditModel.g();
        List<MixVoice> r2 = r1.a;
        if (r2 == null) goto L13;
        List<MixVoice> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        MixVoice r6 = (MixVoice) r5.next();
        int r8 = r6.getPercentage();
        SpeakerVoice r9 = r6.getVoiceItem();
        if (r9 == null) goto L10;
        SpeakerVoice r7 = SpeakerVoice.copy$default(r9, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, Integer.MAX_VALUE, null);
    L11:
        r4.add(new MixVoice(r7, r8, false, r6.getTabName(), 4, null));
        goto L6
    L10:
        r7 = null;
        goto L11
    L12:
        ArrayList r14 = r4;
    L15:
        return new w2a.f(r14, r1.b, r1.c, r1.d, r1.e, null, null, r1.h, r1.i, r45, 96);
    L13:
        r14 = null;
        goto L15
    }

    private final ouc.d0 toTrackParamsJsonObject(JSONObject r2) {
        if (r2 == null) goto L17;
        String r3 = r2.toString();
        if (r3 == null) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(ouc.k.n(ouc.a.d.e(r3)));     // Catch: Throwable -> L8
    L11:
        if (Result.exceptionOrNull-impl(r4) == null) goto L15;
        r4 = new ouc.d0(MapsKt.emptyMap());
    L15:
        return (ouc.d0) r4;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        return new ouc.d0(MapsKt.emptyMap());
    }

    public final boolean canAddMixVoice(SpeakerVoice r5) {
        SpeakerVoiceEditModel r0 = this.speakerVoiceEditModel;
        if (r5 != null) goto L5;
        r0.getClass();
        return false;
    L5:
        Integer r2 = (Integer) r0.l.getValue();
        if (r2 != null) goto L9;
    L10:
        Integer r1 = (Integer) r0.l.getValue();
        if (r1 != null) goto L14;
        return false;
    L14:
        if (r1.intValue() == 1) goto L16;
        return false;
    L16:
        if (r5.getAllowMix() == false) goto L21;
    L17:
        return true;
    L21:
        return false;
    L9:
        if (r2.intValue() == 0) goto L17;
        goto L10
    }

    public final boolean isSingleUgcVoice(SpeakerVoice r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        List r1 = r5.getMixVoiceList();
        if (r1 == null) goto L8;
        int r2 = r1.size();
    L10:
        if (r2 <= 1) goto L12;
        return false;
    L12:
        this.speakerVoiceEditModel.getClass();
        SpeakerVoice r6 = SpeakerVoiceEditModel.i(r5);
        String r3 = null;
        if (r6 == null) goto L15;
        String r4 = r6.getCreatorId();
    L17:
        if (com.larus.utils.o0.d(r4) == false) goto L24;
        if (r6 == null) goto L21;
        r3 = r6.getCreatorId();
    L21:
        if (Intrinsics.areEqual(r3, AccountService.a.getUserId()) == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L15:
        r4 = null;
        goto L17
    L8:
        r2 = 0;
        goto L10
    }

    public final void setDeleteSelectVoice(LiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.deleteSelectVoice = r2;
    }

    public final void setFallBackToSystemVoice(NonStickyLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isFallBackToSystemVoice = r2;
    }

    public final void setShowTtsBackgroundPlayToggle(boolean r1) {
        this.showTtsBackgroundPlayToggle = r1;
    }

    public final void updateTtsBackgroundPlayChecked(boolean r2) {
        this._ttsBackgroundPlayChecked.setValue(Boolean.valueOf(r2));
    }

    public static final /* synthetic */ String access$findAsrLanguageByLanguageCode(TtsSpeakerSettingViewModel r0, String r1) {
        return r0.findAsrLanguageByLanguageCode(r1);
    }

    public static final /* synthetic */ w2a.f access$generateVoiceEditInfo(TtsSpeakerSettingViewModel r0, String r1) {
        return r0.generateVoiceEditInfo(r1);
    }

    public static final /* synthetic */ void access$setIndex$p(TtsSpeakerSettingViewModel r0, int r1) {
        r0.index = r1;
    }

    public static final /* synthetic */ ouc.d0 access$toTrackParamsJsonObject(TtsSpeakerSettingViewModel r0, JSONObject r1) {
        return r0.toTrackParamsJsonObject(r1);
    }

    private final p68.h getLanguageGroup(String r4, List<p68.h> r5) {
        Iterator<T> r6 = r5.iterator();
        p68.h r0 = null;
    L4:
        if (r6.hasNext() == false) goto L8;
        p68.h r1 = (p68.h) r6.next();
        if (Intrinsics.areEqual(r1.a, r4) == false) goto L4;
        r0 = r1;
        goto L4
    L8:
        return r0;
    }

    private static final ArrayList getTtsSpeakerGroups$lambda$7(TtsSpeakerSettingViewModel r5, AudioUserConfig r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        List r7 = r6.getNewVoiceList();
        if (r7 != null) goto L5;
        r7 = CollectionsKt.emptyList();
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        SpeakerVoice r1 = (SpeakerVoice) r8.next();
        p68.h r2 = r5.getLanguageGroup(r1.getLanguage(), r0);
        if (r2 != null) goto L14;
        String r3 = r1.getLanguage();
        if (r3 != null) goto L13;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        r2 = new p68.h(r3, new ArrayList());
        r0.add(r2);
    L14:
        r2.b.add(r1);
        goto L7
    L15:
        return r0;
    }

    private static final ArrayList getTtsSpeakerGroups$lambda$9(TtsSpeakerSettingViewModel r5, com.larus.bmhome.auth.c1 r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        com.larus.bmhome.auth.b r7 = (com.larus.bmhome.auth.b) r6.d;
        if (r7 == null) goto L5;
        List r8 = r7.p();
    L6:
        if (r8 != null) goto L8;
        r8 = CollectionsKt.emptyList();
    L8:
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L18;
        SpeakerVoice r1 = (SpeakerVoice) r9.next();
        p68.h r2 = r5.getLanguageGroup(r1.getLanguage(), r0);
        if (r2 != null) goto L17;
        String r3 = r1.getLanguage();
        if (r3 != null) goto L16;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        r2 = new p68.h(r3, new ArrayList());
        r0.add(r2);
    L17:
        r2.b.add(r1);
        goto L10
    L18:
        return r0;
    L5:
        r8 = null;
        goto L6
    }

    public final void modifyVoiceStyleLocal(String r3, SpeakerVoice r4) {
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r4, "voice");
        getBotService().modifyVoiceStyleLocal(r3, r4, new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final void refreshLanguageItemStyle(SpeakerVoice r4, EditPos r5) {
        boolean r0 = true;
        ?? r1 = 0;
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L17;
        if (r4 != null) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == false) goto L17;
        this._languageItemStyle.setValue(0);
        return;
    L11:
        if (r4.getStatus() != 4) goto L13;
    L17:
        MutableLiveData<Integer> r6 = this._languageItemStyle;
        if (r5 == null) goto L20;
        r1 = r5.b();
    L20:
        r6.setValue(Integer.valueOf(r1));
        return;
    L5:
        if (lq9.g0.b(r4) != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void updateVoice(BotModel r6, SpeakerVoice r7) {
        Intrinsics.checkNotNullParameter(r7, "newVoice");
        if (r6 == null) goto L20;
        boolean r0 = Intrinsics.areEqual(r7.getId(), VoiceDisplayScene.NONE);
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r0 == false) goto L11;
        com.larus.im.service.o r8 = getBotService();
        String r9 = r6.getBotId();
        if (r9 == null) goto L10;
        r1 = r9;
    L10:
        r8.muteBot(r1, new c(this));
        return;
    L11:
        com.larus.im.service.o r2 = getBotService();
        String r3 = r6.getBotId();
        if (r3 != null) goto L14;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L14:
        String r4 = r7.getId();
        if (r4 == null) goto L18;
        r1 = r4;
    L18:
        r2.modifyBotVoice(r3, r1, r7.isUgcVoice(), new d(this, r6, r7));
        return;
    }

    private final Object queryRecommendVoiceList(int r16, String r17, Continuation<? super com.larus.network.http.a<r2a.g>> r18) {
        if ((r18 instanceof C01301) == false) goto L7;
        C01301 r2 = (C01301) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        C01301 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L22:
        return (com.larus.network.http.a) r1;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (com.larus.voice_setting.voice.utils.l.a() == false) goto L17;
        String r6 = "multi";
    L18:
        JSONObject r7 = new JSONObject();
        r7.put("page_index", r16);
        r7.put("page_size", this.PAGE_SIZE);
        r7.put("recommend_type", 1);
        r7.put("language_code", r6);
        Unit r8 = Unit.INSTANCE;
        r13.label = 1;
        r1 = HttpExtKt.k("Audio", r2a.g.class, "/alice/user_voice/recommend", r7, null, null, false, null, null, null, r13, 1008);
        if (r1 != r4) goto L22;
        return r4;
    L17:
        r6 = r17;
    L7:
        r2 = new C01301(this, r18);
        goto L8
    }

    private final Object updateBotInfo(SpeakerVoice r6, String r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof C01351) == false) goto L7;
        C01351 r0 = (C01351) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L25:
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (SpeakerVoice) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L22:
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass2 r4 = new AnonymousClass2(r6, (wc9.e) r9, this, null);
        r0.L$0 = null;
        r0.label = 2;
        r9 = BuildersKt.withContext(r10, r4, r0);
        if (r9 != r2) goto L25;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        IConversationRepoService r11 = RepoDispatcherDelegate.b.f();
        if (r7 != null) goto L19;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r0.L$0 = r6;
        r0.label = 1;
        r9 = r11.a(r7, r0);
        if (r9 != r2) goto L22;
        return r2;
    L7:
        r0 = new C01351(this, r8);
        goto L8
    }

    public final void queryMorePublicVoice(boolean r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "userId");
        Intrinsics.checkNotNullParameter(r13, "languageCode");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C01281(this, r11, r12, r13, null), 2, null);
    }

    public final void requestPublicVoiceList(boolean r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "userId");
        Intrinsics.checkNotNullParameter(r13, "languageCode");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C01311(this, r11, r12, r13, null), 2, null);
    }

    public static final /* synthetic */ Object access$queryRecommendVoiceList(TtsSpeakerSettingViewModel r0, int r1, String r2, Continuation r3) {
        return r0.queryRecommendVoiceList(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$updateBotInfo(TtsSpeakerSettingViewModel r0, SpeakerVoice r1, String r2, Continuation r3) {
        return r0.updateBotInfo(r1, r2, r3);
    }

    private final void handleVoiceUpdateResult(String r15, SpeakerVoice r16, SpeakerVoice r17, uc9.t r18) {
        BotModel r1 = r18.b;
        String r2 = null;
        if (r1 == null) goto L5;
        SpeakerVoice r4 = r1.getVoiceType();
    L7:
        if (r18.a == true) goto L11;
        this._voiceUpdate.postValue(new ub8.h(false, r17, null, null));
        return;
    L11:
        if (r4 == null) goto L13;
        String r0 = r4.getId();
    L15:
        if (Intrinsics.areEqual(r0, r16.getId()) == false) goto L18;
        this._voiceUpdate.postValue(new ub8.h(true, r4, null, null));
        return;
    L18:
        FLogger r3 = FLogger.a;
        String r5 = this.tag;
        StringBuilder r6 = new StringBuilder("[updateVoice] voice mismatch, expected=");
        r6.append(r16.getId());
        r6.append(", actual=");
        if (r4 == null) goto L21;
        r2 = r4.getId();
    L21:
        r6.append(r2);
        r6.append(", retry getBot");
        r3.i(r5, r6.toString());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r15, r16, r4, r17, null), 3, null);
        return;
    L13:
        r0 = null;
        goto L15
    L5:
        r4 = null;
        goto L7
    }

    private final Object queryOtherVoiceList(int r18, String r19, String r20, Continuation<? super com.larus.network.http.a<r2a.g>> r21) {
        int r1 = r18;
        String r2 = r19;
        if ((r21 instanceof C01291) == false) goto L7;
        C01291 r4 = (C01291) r21;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        C01291 r15 = r4;
        Object r3 = r15.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r15.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        r1 = r15.I$0;
        r2 = (String) r15.L$0;
        ResultKt.throwOnFailure(r3);
    L17:
        com.larus.network.http.a r8 = (com.larus.network.http.a) r3;
        FLogger.a.i("TTSViewModel", "[queryOtherVoiceList] index:" + r1 + ", id:" + r2 + ", list:" + r8.b);
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        JSONObject r9 = new JSONObject();
        r9.put("page_index", r1);
        r9.put("page_size", this.PAGE_SIZE);
        r9.put("visit_id", r2);
        r9.put("language_code", r20);
        Unit r10 = Unit.INSTANCE;
        r15.L$0 = r2;
        r15.I$0 = r1;
        r15.label = 1;
        r3 = HttpExtKt.k("Audio", r2a.g.class, "/alice/user_voice/list", r9, null, null, false, null, null, null, r15, 1008);
        if (r3 != r6) goto L17;
        return r6;
    L7:
        r4 = new C01291(this, r21);
        goto L8
    }

    public final Object requestVoiceDetail(String r13, String r14, String r15, Continuation<? super com.larus.network.http.a<SpeakerVoice>> r16) {
        JSONObject r3 = new JSONObject();
        r3.put("voice_id", r13);
        r3.put("bot_language", r14);
        r3.put("bot_id", r15);
        Unit r4 = Unit.INSTANCE;
        return HttpExtKt.k("Audio", SpeakerVoice.class, "/alice/audio/conf_detail", r3, null, null, false, null, null, null, r16, 1008);
    }

    public static final /* synthetic */ void access$handleVoiceUpdateResult(TtsSpeakerSettingViewModel r0, String r1, SpeakerVoice r2, SpeakerVoice r3, uc9.t r4) {
        r0.handleVoiceUpdateResult(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Object access$queryOtherVoiceList(TtsSpeakerSettingViewModel r0, int r1, String r2, String r3, Continuation r4) {
        return r0.queryOtherVoiceList(r1, r2, r3, r4);
    }

    private final Object queryList(boolean r1, String r2, String r3, int r4, Continuation<? super com.larus.network.http.a<r2a.g>> r5) {
        if (r1 == false) goto L6;
        return queryRecommendVoiceList(r4, r3, r5);
    L6:
        return queryOtherVoiceList(r4, r2, r3, r5);
    }

    public static /* synthetic */ void updateVoice$default(TtsSpeakerSettingViewModel r0, BotModel r1, SpeakerVoice r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.updateVoice(r1, r2);
    }

    public static final /* synthetic */ Object access$queryList(TtsSpeakerSettingViewModel r0, boolean r1, String r2, String r3, int r4, Continuation r5) {
        return r0.queryList(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void queryMorePublicVoice$default(TtsSpeakerSettingViewModel r0, boolean r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r0.queryMorePublicVoice(r1, r2, r3);
    }

    public static /* synthetic */ void requestPublicVoiceList$default(TtsSpeakerSettingViewModel r0, boolean r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r0.requestPublicVoiceList(r1, r2, r3);
    }

    public static /* synthetic */ Object queryList$default(TtsSpeakerSettingViewModel r6, boolean r7, String r8, String r9, int r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        int r4 = 1;
    L7:
        return r6.queryList(r7, r8, r9, r4, r11);
    L5:
        r4 = r10;
        goto L7
    }

    public final void trySaveUserSelectVoice(BotModel r17, String r18, String r19, RecommendFrom r20, String r21, JSONObject r22, SpeakerVoice r23, boolean r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r18, "enterFrom");
        Intrinsics.checkNotNullParameter(r21, "enterMethod");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C01341(this, r21, r17, r20, r22, r18, r19, r25, r23, r24, null), 2, null);
    }

    public static /* synthetic */ void trySaveUserSelectVoice$default(TtsSpeakerSettingViewModel r11, BotModel r12, String r13, String r14, RecommendFrom r15, String r16, JSONObject r17, SpeakerVoice r18, boolean r19, boolean r20, int r21, Object r22) {
        if ((r21 & 256) == 0) goto L5;
        boolean r10 = true;
    L6:
        r11.trySaveUserSelectVoice(r12, r13, r14, r15, r16, r17, r18, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }
}
