package com.larus.setting.impl;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.services.apm.api.EnsureManager;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.IUserSettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.ModelItem;
import com.larus.network.http.AsyncLiveData;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.model.UserConfigItem;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallConfigServiceDelegate;
import com.tencent.open.log.TraceLevel;
import hq9.y4;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b.\u0018\u0000 \u009f\u00012\u00020\u0001:\u0002\u009f\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\"0!J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0!J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u0014J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0014J\u0006\u0010-\u001a\u00020\u0014J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0014J\u0006\u00101\u001a\u00020\u0014J\u0006\u00102\u001a\u00020\u0014J\u000e\u00103\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J\u000e\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020\u0014J\u0018\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u0014H\u0002J\u0006\u0010E\u001a\u00020\u0014J\u0006\u0010F\u001a\u00020\u0014J\u0006\u0010G\u001a\u00020\u0014J\u0006\u0010H\u001a\u00020\u0014J\u0006\u0010I\u001a\u00020\u0014J\u0006\u0010J\u001a\u00020\u0014J\u0006\u0010K\u001a\u00020\u0014J\u0006\u0010L\u001a\u00020\u0014J\u0006\u0010M\u001a\u00020\u0014J\u0006\u0010N\u001a\u00020\u0014J\u0006\u0010O\u001a\u00020\u0014J\u0006\u0010P\u001a\u00020\u0014J\u0006\u0010Q\u001a\u00020\u0014J\u0006\u0010R\u001a\u00020\u0014J\u000e\u0010S\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J\u000e\u0010T\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J\u0018\u0010U\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010WJ\u0018\u0010X\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010WJ\u0018\u0010Y\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010WJ\u0018\u0010Z\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010WJ\u0018\u0010[\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010WJ\u0018\u0010\\\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010WJ\u000e\u0010]\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J\u000e\u0010^\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J\u000e\u0010_\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J6\u0010`\u001a\u00020%2\u0006\u0010a\u001a\u00020\u00142\u0006\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\u00142\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u0014J\u000e\u0010g\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J\u000e\u0010h\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J\u0006\u0010i\u001a\u00020\u0014J\u000e\u0010j\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0014J\u0006\u0010k\u001a\u00020\u0014J\u000e\u0010l\u001a\u00020\u001f2\u0006\u0010m\u001a\u00020\u0014J2\u0010n\u001a\u00020\u001f2\u000e\b\u0002\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\b\b\u0002\u0010p\u001a\u00020\u00102\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010rJ\u0006\u0010s\u001a\u00020%J\u0006\u0010t\u001a\u00020%J\u0007\u0010\u008d\u0001\u001a\u00020\u0014J\u000f\u0010\u008e\u0001\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0014J\u0007\u0010\u0091\u0001\u001a\u00020\u0014J\u000f\u0010\u0092\u0001\u001a\u00020\u001f2\u0006\u0010m\u001a\u00020\u0014J\u000f\u0010\u0095\u0001\u001a\u00020%2\u0006\u0010u\u001a\u00020'J\u0007\u0010\u0096\u0001\u001a\u00020'J\u000f\u0010\u0099\u0001\u001a\u00020\u001f2\u0006\u0010u\u001a\u00020'J\u0007\u0010\u009a\u0001\u001a\u00020\u0014J\u000f\u0010\u009b\u0001\u001a\u00020\u001f2\u0006\u0010m\u001a\u00020\u0014J\u0007\u0010\u009c\u0001\u001a\u00020\u0014J\u0018\u0010\u009d\u0001\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0014H\u0086@¢\u0006\u0003\u0010\u009e\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0012R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0012R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0012R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0012R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0012R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0012R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0012R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0012R$\u0010v\u001a\u00020\u00142\u0006\u0010u\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010{\u001a\u00020\u00142\u0006\u0010u\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010x\"\u0004\b}\u0010zR%\u0010~\u001a\u00020\u00142\u0006\u0010u\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010x\"\u0005\b\u0080\u0001\u0010zR'\u0010\u0081\u0001\u001a\u00020\u00142\u0006\u0010u\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010x\"\u0005\b\u0083\u0001\u0010zR)\u0010\u0084\u0001\u001a\u00020\u00102\u0006\u0010u\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R'\u0010\u0089\u0001\u001a\u00020\u00142\u0006\u0010u\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010x\"\u0005\b\u008a\u0001\u0010zR\u0019\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u0012R\u0019\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0012R\u0019\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0012R\u0019\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0012¨\u0006 \u0001"}, d2 = {"Lcom/larus/setting/impl/SettingModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "voiceModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/im/bean/bot/ModelItem;", "kotlin.jvm.PlatformType", "_userInfoLiveData", "Lcom/larus/network/http/AsyncLiveData;", "Lcom/larus/profile/api/bean/ProfileInfoResponse;", "authorizationCountLiveData", "", "getAuthorizationCountLiveData", "()Landroidx/lifecycle/MutableLiveData;", "personalizedRecommend", "", "getPersonalizedRecommend", "pictureLocation", "getPictureLocation", "relatedVideoEnableLiveData", "getRelatedVideoEnableLiveData", "faceMemoryEnableLiveData", "getFaceMemoryEnableLiveData", "realtimeDenoiseLiveData", "getRealtimeDenoiseLiveData", "bindObservers", "", "getVoiceModels", "Landroidx/lifecycle/LiveData;", "", "getVoiceModel", "selectVoiceModel", "Lkotlinx/coroutines/Job;", "modelName", "", "isStreamMode", "toggleStream", "toggle", "answerWithSuggestLiveData", "getAnswerWithSuggestLiveData", "isPromptEnabled", "togglePromptEnabled", "saveChatHistory", "getSaveChatHistory", "isSaveChatHistoryEnabled", "isRealtimeVoiceFeatureTrainAuthorize", "toggleSaveChatHistoryEnabled", "toggleVoiceFeatureTrainAuthorizeChange", "checked", "mobVoiceFeatureAuthResult", "requestSuccess", "isOpen", "optOutVoice", "getOptOutVoice", "allowTrainByText", "getAllowTrainByText", "allowTrainByUpload", "getAllowTrainByUpload", "allowTrainByVideo", "getAllowTrainByVideo", "allowTraining", "getAllowTraining", "scheduledJobNotify", "getScheduledJobNotify", "isAllowTraining", "isOptOutVoiceEnabled", "isAllowTrainByText", "isAllowTrainByVideo", "isAllowTrainByUpload", "isPersonalizedRecommendEnabled", "isFindByPhoneEnabled", "isFindByDoubaoUserNameEnabled", "isSystemNotifyEnable", "isAppNotifyEnable", "isAppNotifyDetailEnable", "isAppNotifyDetailAdminDisabled", "isScheduledJobNotifyEnable", "isPictureLocationEnabled", "toggleAllowTrainingEnabled", "toggleOptOutVoiceEnabled", "toggleFindByPhoneEnabled", "itemView", "Lcom/larus/bmhome/view/item/ItemTextToggle;", "toggleFindByDoubaoUserNameEnabled", "toggleSystemNotifyEnabled", "toggleAppNotifyEnabled", "toggleAppNotifyDetailEnabled", "toggleScheduledJobNotifyEnabled", "toggleAllowTrainByText", "toggleAllowTrainByVideo", "toggleAllowTrainByUpload", "savePrivacySettings", "allowVoice", "allowText", "allowVideo", "allowUpload", "changedKey", "notifyServer", "personalizedRecommendEnabled", "pictureLocationEnabled", "isPromptStyleVertical", "togglePromptStyleVertical", "isInterruptEnabled", "toggleInterruptEnabled", "enable", "updateUserConfigs", "configKeys", "pullReason", "onComplete", "Lkotlin/Function0;", "fetchAuthorizationCount", "queryUserInfo", "value", "sugAllEnabled", "getSugAllEnabled", "()Z", "setSugAllEnabled", "(Z)V", "sugSearchEnabled", "getSugSearchEnabled", "setSugSearchEnabled", "realtimeCallEnabled", "getRealtimeCallEnabled", "setRealtimeCallEnabled", "showCardSearch", "getShowCardSearch", "setShowCardSearch", "engineType", "getEngineType", "()I", "setEngineType", "(I)V", "isHighlightGoWebview", "setHighlightGoWebview", "inputSuggestEnableLiveData", "getInputSuggestEnableLiveData", "isInputSuggestEnable", "setInputSuggestEnable", "highlightEngineEnableLiveData", "getHighlightEngineEnableLiveData", "isHighlightEnabled", "setHighlightEnable", "highlightEngineLiveData", "getHighlightEngineLiveData", "saveHighlightEngine", "getHighlightEngine", "answerWithVideoLiveData", "getAnswerWithVideoLiveData", "saveAnswerWithVideo", "isRelatedVideoEnabled", "saveRelatedVideoEnabled", "getFaceMemoryEnabled", "setFaceMemoryEnabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SettingModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final String TAG = "SettingModel";
    private final AsyncLiveData<fs9.t> _userInfoLiveData;
    private final MutableLiveData<Boolean> allowTrainByText;
    private final MutableLiveData<Boolean> allowTrainByUpload;
    private final MutableLiveData<Boolean> allowTrainByVideo;
    private final MutableLiveData<Boolean> allowTraining;
    private final MutableLiveData<Boolean> answerWithSuggestLiveData;
    private final MutableLiveData<Boolean> answerWithVideoLiveData;
    private final MutableLiveData<Integer> authorizationCountLiveData;
    private final MutableLiveData<Boolean> faceMemoryEnableLiveData;
    private final MutableLiveData<Boolean> highlightEngineEnableLiveData;
    private final MutableLiveData<Boolean> highlightEngineLiveData;
    private final MutableLiveData<Boolean> inputSuggestEnableLiveData;
    private final MutableLiveData<Boolean> optOutVoice;
    private final MutableLiveData<Boolean> personalizedRecommend;
    private final MutableLiveData<Boolean> pictureLocation;
    private final MutableLiveData<Boolean> realtimeDenoiseLiveData;
    private final MutableLiveData<Boolean> relatedVideoEnableLiveData;
    private final ISettingRepoService repo;
    private final MutableLiveData<Boolean> saveChatHistory;
    private final MutableLiveData<Boolean> scheduledJobNotify;
    private final MutableLiveData<ModelItem> voiceModel;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$bindObservers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$bindObservers$1", f = "SettingModel.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SettingModel this$0;

        /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$bindObservers$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ SettingModel a;

            /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$bindObservers$1$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0021a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[UserConfigKey.values().length];
                    r0[UserConfigKey.PERSONAL_RECOMMEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[UserConfigKey.PICTURE_LOCATION_SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[UserConfigKey.RELATED_VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[UserConfigKey.FACE_MEMORY_SWITCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    a = r0;
                }
            }

            public a(SettingModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                int r4 = C0021a.a[((UserConfigKey) r2).ordinal()];
                if (r4 != 1) goto L5;
                this.a.getPersonalizedRecommend().postValue(Boxing.boxBoolean(true));
            L16:
                return Unit.INSTANCE;
            L5:
                if (r4 != 2) goto L7;
                this.a.getPictureLocation().postValue(Boxing.boxBoolean(true));
                goto L16
            L7:
                if (r4 != 3) goto L9;
                this.a.getRelatedVideoEnableLiveData().postValue(Boxing.boxBoolean(true));
                goto L16
            L9:
                if (r4 != 4) goto L16;
                this.a.getFaceMemoryEnableLiveData().postValue(Boxing.boxBoolean(true));
                goto L16
            }
        }

        public AnonymousClass1(SettingModel r1, Continuation<? super AnonymousClass1> r2) {
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            kotlinx.coroutines.flow.d1 r6 = UserSettingDelegate.b.i();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$fetchAuthorizationCount$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$fetchAuthorizationCount$1", f = "SettingModel.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01141(SettingModel r1, Continuation<? super C01141> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01141(this.this$0, r3);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            com.larus.network.http.y r15 = (com.larus.network.http.a) r14;
            if ((r15 instanceof com.larus.network.http.y) == false) goto L17;
            AuthorizationInfoResponse r16 = (AuthorizationInfoResponse) ((com.larus.network.http.a) r15).b;
            if (r16 == null) goto L17;
            int r17 = r16.getTotalCount();
            this.this$0.getAuthorizationCountLiveData().postValue(Boxing.boxInt(r17));
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            JSONObject r4 = new JSONObject();
            this.label = 1;
            r14 = HttpExtKt.k("Social", AuthorizationInfoResponse.class, "/alice/user/list_auth_info", r4, null, null, false, null, null, null, this, 1008);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$personalizedRecommendEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$personalizedRecommendEnabled$1", f = "SettingModel.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01151(SettingModel r1, boolean r2, Continuation<? super C01151> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01151(this.this$0, this.$toggle, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getPersonalizedRecommend().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.U(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$pictureLocationEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$pictureLocationEnabled$1", f = "SettingModel.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01161(SettingModel r1, boolean r2, Continuation<? super C01161> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01161(this.this$0, this.$toggle, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getPictureLocation().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.x(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$queryUserInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$queryUserInfo$1", f = "SettingModel.kt", i = {}, l = {417}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01171(SettingModel r1, Continuation<? super C01171> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01171(this.this$0, r3);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            com.larus.network.http.y r15 = (com.larus.network.http.a) r14;
            if ((r15 instanceof com.larus.network.http.y) == false) goto L23;
            com.larus.network.http.y r2 = r15;
            fs9.t r3 = (fs9.t) ((com.larus.network.http.a) r2).b;
            if (r3 == null) goto L18;
            r38.b r4 = r3.b();
            if (r4 == null) goto L18;
            IAccountService.a.l(r4);
        L18:
            fs9.t r5 = (fs9.t) ((com.larus.network.http.a) r2).b;
            if (r5 == null) goto L23;
            fs9.o r6 = r5.a();
            if (r6 == null) goto L23;
            IAccountService.a.j(r6.b());
        L23:
            SettingModel.access$get_userInfoLiveData$p(this.this$0).postValue(r15);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            JSONObject r7 = new JSONObject();
            r7.put("visit_id", ILoginService.a.getAccountInfo().c);
            Unit r8 = Unit.INSTANCE;
            this.label = 1;
            r14 = HttpExtKt.k("Social", fs9.t.class, "/alice/profile/self", r7, null, null, false, null, null, null, this, 1008);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$saveAnswerWithVideo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$saveAnswerWithVideo$1", f = "SettingModel.kt", i = {}, l = {507}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $value;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01181(String r1, SettingModel r2, Continuation<? super C01181> r3) {
            this.$value = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01181(this.$value, this.this$0, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getAnswerWithVideoLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            UserSettingDelegate r6 = UserSettingDelegate.b;
            String r2 = this.$value;
            this.label = 1;
            r4 = r6.d(r2, true, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$saveHighlightEngine$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$saveHighlightEngine$1", f = "SettingModel.kt", i = {}, l = {495}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $value;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01191(String r1, SettingModel r2, Continuation<? super C01191> r3) {
            this.$value = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01191(this.$value, this.this$0, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getHighlightEngineLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            UserSettingDelegate r6 = UserSettingDelegate.b;
            String r2 = this.$value;
            this.label = 1;
            r4 = r6.h(r2, true, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$savePrivacySettings$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$savePrivacySettings$1", f = "SettingModel.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $allowText;
        final /* synthetic */ boolean $allowUpload;
        final /* synthetic */ boolean $allowVideo;
        final /* synthetic */ boolean $allowVoice;
        final /* synthetic */ int $changedKey;
        final /* synthetic */ boolean $notifyServer;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01201(SettingModel r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, int r7, Continuation<? super C01201> r8) {
            this.this$0 = r1;
            this.$allowVoice = r2;
            this.$allowText = r3;
            this.$allowVideo = r4;
            this.$allowUpload = r5;
            this.$notifyServer = r6;
            this.$changedKey = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C01201(this.this$0, this.$allowVoice, this.$allowText, this.$allowVideo, this.$allowUpload, this.$notifyServer, this.$changedKey, r11);
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
        L11:
            boolean r12 = ((Boolean) r11).booleanValue();
            int r2 = this.$changedKey;
            if (r2 != 4) goto L14;
            this.this$0.getOptOutVoice().postValue(Boxing.boxBoolean(r12));
        L25:
            return Unit.INSTANCE;
        L14:
            if (r2 != 71) goto L16;
            this.this$0.getAllowTrainByText().postValue(Boxing.boxBoolean(r12));
            goto L25
        L16:
            if (r2 != 73) goto L18;
            this.this$0.getAllowTrainByVideo().postValue(Boxing.boxBoolean(r12));
            goto L25
        L18:
            if (r2 != 74) goto L25;
            this.this$0.getAllowTrainByUpload().postValue(Boxing.boxBoolean(r12));
            goto L25
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            ISettingRepoService r3 = SettingModel.access$getRepo$p(this.this$0);
            boolean r4 = this.$allowVoice;
            boolean r5 = this.$allowText;
            boolean r6 = this.$allowVideo;
            boolean r7 = this.$allowUpload;
            boolean r8 = this.$notifyServer;
            this.label = 1;
            r11 = r3.B0(r4, r5, r6, r7, r8, this);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$saveRelatedVideoEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$saveRelatedVideoEnabled$1", f = "SettingModel.kt", i = {}, l = {516}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01211(SettingModel r1, boolean r2, Continuation<? super C01211> r3) {
            this.this$0 = r1;
            this.$enable = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01211(this.this$0, this.$enable, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getRelatedVideoEnableLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$enable;
            this.label = 1;
            r4 = r6.n0(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$selectVoiceModel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$selectVoiceModel$1", f = "SettingModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $modelName;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01221(SettingModel r1, String r2, Continuation<? super C01221> r3) {
            this.this$0 = r1;
            this.$modelName = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01221(this.this$0, this.$modelName, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r12);
            SettingModel.access$getRepo$p(this.this$0).z0(this.$modelName);
            MutableLiveData r13 = SettingModel.access$getVoiceModel$p(this.this$0);
            ModelItem r10 = new ModelItem(null, 0, null, null, null, null, 63, null);
            r10.setModelName(this.$modelName);
            r13.postValue(r10);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$setFaceMemoryEnabled$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$setFaceMemoryEnabled$2", f = "SettingModel.kt", i = {}, l = {525}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ boolean $checked;
        int label;
        final /* synthetic */ SettingModel this$0;

        public AnonymousClass2(SettingModel r1, boolean r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$checked = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$checked, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            boolean r5 = ((Boolean) r4).booleanValue();
            FLogger.a.i(SettingModel.TAG, "saveFaceMemoryEnabled: " + r5);
            this.this$0.getFaceMemoryEnableLiveData().postValue(Boxing.boxBoolean(r5));
            return Boxing.boxBoolean(r5);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$checked;
            this.label = 1;
            r4 = r6.X(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$setHighlightEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$setHighlightEnable$1", f = "SettingModel.kt", i = {}, l = {485}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01231(SettingModel r1, boolean r2, Continuation<? super C01231> r3) {
            this.this$0 = r1;
            this.$enable = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01231(this.this$0, this.$enable, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getHighlightEngineEnableLiveData().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$enable;
            this.label = 1;
            r4 = r6.l(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$setInputSuggestEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$setInputSuggestEnable$1", f = "SettingModel.kt", i = {}, l = {474}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01241(SettingModel r1, boolean r2, Continuation<? super C01241> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01241(this.this$0, this.$toggle, r4);
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
            MutableLiveData<Boolean> r2 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(r5);
        L12:
            r2.postValue(r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableLiveData<Boolean> r6 = this.this$0.getInputSuggestEnableLiveData();
            ISettingRepoService r3 = SettingModel.access$getRepo$p(this.this$0);
            boolean r4 = this.$toggle;
            this.L$0 = r6;
            this.label = 1;
            Object r7 = r3.R(r4, this);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r6;
            r5 = r7;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleAllowTrainByText$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleAllowTrainByText$1", f = "SettingModel.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01251(SettingModel r1, boolean r2, Continuation<? super C01251> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01251(this.this$0, this.$toggle, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getAllowTrainByText().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.N0(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleAllowTrainByUpload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleAllowTrainByUpload$1", f = "SettingModel.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01261(SettingModel r1, boolean r2, Continuation<? super C01261> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01261(this.this$0, this.$toggle, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getAllowTrainByUpload().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.d0(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleAllowTrainByVideo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleAllowTrainByVideo$1", f = "SettingModel.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01271(SettingModel r1, boolean r2, Continuation<? super C01271> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01271(this.this$0, this.$toggle, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getAllowTrainByVideo().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.v(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleAllowTrainingEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleAllowTrainingEnabled$1", f = "SettingModel.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01281(SettingModel r1, boolean r2, Continuation<? super C01281> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01281(this.this$0, this.$toggle, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getAllowTraining().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.W0(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleAppNotifyDetailEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleAppNotifyDetailEnabled$1", f = "SettingModel.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemTextToggle $itemView;
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01291(SettingModel r1, ItemTextToggle r2, boolean r3, Continuation<? super C01291> r4) {
            this.this$0 = r1;
            this.$itemView = r2;
            this.$toggle = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01291(this.this$0, this.$itemView, this.$toggle, r5);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L26:
            if (((Boolean) r7).booleanValue() == true) goto L31;
            ItemTextToggle r8 = this.$itemView;
            if (r8 == null) goto L31;
            r8.setRestoring(true);
            this.$itemView.getToggleView().setChecked(this.this$0.isAppNotifyDetailEnable());
            t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
        L31:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            if (this.this$0.isAppNotifyDetailAdminDisabled() == false) goto L19;
            ItemTextToggle r9 = this.$itemView;
            if (r9 == null) goto L13;
            r9.setRestoring(true);
            r9.getToggleView().setChecked(false);
        L13:
            int r10 = com.larus.utils.j0.a;
            String r2 = com.larus.utils.j0.e("AdminConsole_PrivacySettings_MsgPreviewAdminOff_Toast");
            if (Intrinsics.areEqual(r2, "AdminConsole_PrivacySettings_MsgPreviewAdminOff_Toast") == true) goto L17;
            t19.s.j(t19.s.a, AppHost.a.getApplication(), r2, null, false, 28);
        L17:
            return Unit.INSTANCE;
        L19:
            if (this.$toggle == false) goto L21;
            String r11 = "on";
        L22:
            tx9.q2.c("content_preview", r11);
            ISettingRepoService r12 = SettingModel.access$getRepo$p(this.this$0);
            boolean r3 = this.$toggle;
            this.label = 1;
            r7 = r12.N(r3, this);
            if (r7 != r0) goto L26;
            return r0;
        L21:
            r11 = "off";
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleAppNotifyEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleAppNotifyEnabled$1", f = "SettingModel.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemTextToggle $itemView;
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01301(boolean r1, SettingModel r2, ItemTextToggle r3, Continuation<? super C01301> r4) {
            this.$toggle = r1;
            this.this$0 = r2;
            this.$itemView = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01301(this.$toggle, this.this$0, this.$itemView, r5);
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
        L16:
            if (((Boolean) r4).booleanValue() == true) goto L21;
            ItemTextToggle r5 = this.$itemView;
            if (r5 == null) goto L21;
            r5.setRestoring(true);
            this.$itemView.getToggleView().setChecked(this.this$0.isAppNotifyEnable());
            t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            if (this.$toggle == false) goto L11;
            String r6 = "on";
        L12:
            tx9.q2.c("banner", r6);
            ISettingRepoService r7 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r7.O(r2, this);
            if (r4 != r0) goto L16;
            return r0;
        L11:
            r6 = "off";
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleFindByDoubaoUserNameEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleFindByDoubaoUserNameEnabled$1", f = "SettingModel.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemTextToggle $itemView;
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01311(SettingModel r1, boolean r2, ItemTextToggle r3, Continuation<? super C01311> r4) {
            this.this$0 = r1;
            this.$toggle = r2;
            this.$itemView = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01311(this.this$0, this.$toggle, this.$itemView, r5);
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
            if (((Boolean) r4).booleanValue() == true) goto L17;
            ItemTextToggle r5 = this.$itemView;
            if (r5 == null) goto L17;
            r5.setRestoring(true);
            this.$itemView.getToggleView().setChecked(this.this$0.isFindByDoubaoUserNameEnabled());
            t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.u0(r2, this);
            if (r4 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleFindByPhoneEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleFindByPhoneEnabled$1", f = "SettingModel.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemTextToggle $itemView;
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01321(SettingModel r1, boolean r2, ItemTextToggle r3, Continuation<? super C01321> r4) {
            this.this$0 = r1;
            this.$toggle = r2;
            this.$itemView = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01321(this.this$0, this.$toggle, this.$itemView, r5);
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
            if (((Boolean) r4).booleanValue() == true) goto L17;
            ItemTextToggle r5 = this.$itemView;
            if (r5 == null) goto L17;
            r5.setRestoring(true);
            this.$itemView.getToggleView().setChecked(this.this$0.isFindByPhoneEnabled());
            t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.w0(r2, this);
            if (r4 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleOptOutVoiceEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleOptOutVoiceEnabled$1", f = "SettingModel.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01331(SettingModel r1, boolean r2, Continuation<? super C01331> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01331(this.this$0, this.$toggle, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getOptOutVoice().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.F0(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$togglePromptEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$togglePromptEnabled$1", f = "SettingModel.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01341(SettingModel r1, boolean r2, Continuation<? super C01341> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01341(this.this$0, this.$toggle, r4);
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
            MutableLiveData<Boolean> r2 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(r5);
        L12:
            r2.postValue(r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableLiveData<Boolean> r6 = this.this$0.getAnswerWithSuggestLiveData();
            ISettingRepoService r3 = SettingModel.access$getRepo$p(this.this$0);
            boolean r4 = this.$toggle;
            this.L$0 = r6;
            this.label = 1;
            Object r7 = r3.Q(r4, this);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r6;
            r5 = r7;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleSaveChatHistoryEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleSaveChatHistoryEnabled$1", f = "SettingModel.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01351(SettingModel r1, boolean r2, Continuation<? super C01351> r3) {
            this.this$0 = r1;
            this.$toggle = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01351(this.this$0, this.$toggle, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getSaveChatHistory().postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r6.P(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleScheduledJobNotifyEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleScheduledJobNotifyEnabled$1", f = "SettingModel.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemTextToggle $itemView;
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01361(boolean r1, SettingModel r2, ItemTextToggle r3, Continuation<? super C01361> r4) {
            this.$toggle = r1;
            this.this$0 = r2;
            this.$itemView = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01361(this.$toggle, this.this$0, this.$itemView, r5);
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
        L15:
            boolean r5 = ((Boolean) r4).booleanValue();
            this.this$0.getScheduledJobNotify().postValue(Boxing.boxBoolean(this.this$0.isScheduledJobNotifyEnable()));
            if (r5 == true) goto L21;
            ItemTextToggle r6 = this.$itemView;
            if (r6 == null) goto L21;
            r6.setRestoring(true);
            this.$itemView.getToggleView().setChecked(this.this$0.isScheduledJobNotifyEnable());
            t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            if (this.$toggle == false) goto L11;
            String r7 = "on";
        L12:
            tx9.q2.c("scheduled_job", r7);
            ISettingRepoService r8 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r8.v0(r2, this);
            if (r4 != r0) goto L15;
            return r0;
        L11:
            r7 = "off";
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleSystemNotifyEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleSystemNotifyEnabled$1", f = "SettingModel.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemTextToggle $itemView;
        final /* synthetic */ boolean $toggle;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01371(boolean r1, SettingModel r2, ItemTextToggle r3, Continuation<? super C01371> r4) {
            this.$toggle = r1;
            this.this$0 = r2;
            this.$itemView = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01371(this.$toggle, this.this$0, this.$itemView, r5);
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
        L16:
            if (((Boolean) r4).booleanValue() == true) goto L21;
            ItemTextToggle r5 = this.$itemView;
            if (r5 == null) goto L21;
            r5.setRestoring(true);
            this.$itemView.getToggleView().setChecked(this.this$0.isSystemNotifyEnable());
            t19.s.a.g(AppHost.a.getApplication(), 2131908080, false);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            if (this.$toggle == false) goto L11;
            String r6 = "on";
        L12:
            tx9.q2.c("push", r6);
            ISettingRepoService r7 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$toggle;
            this.label = 1;
            r4 = r7.D0(r2, this);
            if (r4 != r0) goto L16;
            return r0;
        L11:
            r6 = "off";
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$toggleVoiceFeatureTrainAuthorizeChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$toggleVoiceFeatureTrainAuthorizeChange$1", f = "SettingModel.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $checked;
        int label;
        final /* synthetic */ SettingModel this$0;

        public C01381(SettingModel r1, boolean r2, Continuation<? super C01381> r3) {
            this.this$0 = r1;
            this.$checked = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01381(this.this$0, this.$checked, r4);
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
            boolean r5 = ((Boolean) r4).booleanValue();
            if (this.$checked == true) goto L15;
            if (r5 == false) goto L15;
            VoiceCallConfigServiceDelegate.b.m();
        L15:
            if (r5 == false) goto L17;
            this.this$0.getRealtimeDenoiseLiveData().postValue(Boxing.boxBoolean(this.$checked));
        L17:
            SettingModel.access$mobVoiceFeatureAuthResult(this.this$0, r5, this.$checked);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ISettingRepoService r6 = SettingModel.access$getRepo$p(this.this$0);
            boolean r2 = this.$checked;
            this.label = 1;
            r4 = r6.M(r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.setting.impl.SettingModel$updateUserConfigs$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.SettingModel$updateUserConfigs$1", f = "SettingModel.kt", i = {}, l = {385}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Integer> $configKeys;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pullReason;
        int label;

        public C01391(List<Integer> r1, int r2, Function0<Unit> r3, Continuation<? super C01391> r4) {
            this.$configKeys = r1;
            this.$pullReason = r2;
            this.$onComplete = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01391(this.$configKeys, this.$pullReason, this.$onComplete, r5);
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
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7
        L15:
            y4 r7 = (y4) r6;     // Catch: Throwable -> L7
            if (r7 == null) goto L18;
            ArrayList<UserConfigItem> r8 = r7.a();     // Catch: Throwable -> L7
        L19:
            if (r8 == null) goto L21;
            UserSettingDelegate.b.c(r8);     // Catch: Throwable -> L7
        L21:
            Function0<Unit> r9 = this.$onComplete;
            if (r9 == null) goto L25;
            r9.invoke();
        L25:
            return Unit.INSTANCE;
        L18:
            r8 = null;
            goto L19
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r6);
            IUserSettingRepoService r10 = RepoDispatcherDelegate.b.h();     // Catch: Throwable -> L7
            List<Integer> r2 = this.$configKeys;     // Catch: Throwable -> L7
            int r3 = this.$pullReason;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r6 = r10.e(r2, r3, "settings_page", this);     // Catch: Throwable -> L7
            if (r6 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            Function0<Unit> r4 = this.$onComplete;
            if (r4 == null) goto L29;
            r4.invoke();
        L29:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ List Mo(com.larus.bmhome.auth.c1 r0) {
        return getVoiceModels$lambda$2(r0);
    }

    public static /* synthetic */ List yo(AudioUserConfig r0) {
        return getVoiceModels$lambda$1(r0);
    }

    public final int getEngineType() {
        return this.repo.K();
    }

    public final boolean getFaceMemoryEnabled() {
        return this.repo.m();
    }

    public final String getHighlightEngine() {
        return UserSettingDelegate.b.e();
    }

    public final boolean getRealtimeCallEnabled() {
        return this.repo.g();
    }

    public final boolean getShowCardSearch() {
        return this.repo.P0();
    }

    public final boolean getSugAllEnabled() {
        return this.repo.A();
    }

    public final boolean getSugSearchEnabled() {
        return this.repo.h();
    }

    public final LiveData<List<ModelItem>> getVoiceModels() {
        if (FeatureKitDelegate.b.w0().b() == false) goto L6;
        return Transformations.distinctUntilChanged(Transformations.map(AudioServiceDelegate.a.p(), new i3()));
    L6:
        return Transformations.distinctUntilChanged(Transformations.map(AuthModelDelegate.b.j(), new j3()));
    }

    public final boolean isAllowTrainByText() {
        return this.repo.V();
    }

    public final boolean isAllowTrainByUpload() {
        return this.repo.h0();
    }

    public final boolean isAllowTrainByVideo() {
        return this.repo.J();
    }

    public final boolean isAllowTraining() {
        return this.repo.D();
    }

    public final boolean isAppNotifyDetailAdminDisabled() {
        UserConfigItem r0 = UserSettingDelegate.b.b(UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH);
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L7:
        return Intrinsics.areEqual(r1, "1");
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isAppNotifyDetailEnable() {
        return this.repo.j0();
    }

    public final boolean isAppNotifyEnable() {
        return this.repo.j();
    }

    public final boolean isFindByDoubaoUserNameEnabled() {
        return this.repo.t0();
    }

    public final boolean isFindByPhoneEnabled() {
        return this.repo.i0();
    }

    public final boolean isHighlightEnabled() {
        return this.repo.o();
    }

    public final boolean isHighlightGoWebview() {
        return this.repo.E0();
    }

    public final boolean isInputSuggestEnable() {
        return this.repo.p();
    }

    public final boolean isInterruptEnabled() {
        return this.repo.E();
    }

    public final boolean isOptOutVoiceEnabled() {
        return this.repo.B();
    }

    public final boolean isPersonalizedRecommendEnabled() {
        return this.repo.R0();
    }

    public final boolean isPictureLocationEnabled() {
        return this.repo.H();
    }

    public final boolean isPromptEnabled() {
        return this.repo.i();
    }

    public final boolean isPromptStyleVertical() {
        Integer r0 = (Integer) this.repo.w().getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public final boolean isRealtimeVoiceFeatureTrainAuthorize() {
        return this.repo.x0();
    }

    public final boolean isRelatedVideoEnabled() {
        return this.repo.q0();
    }

    public final boolean isSaveChatHistoryEnabled() {
        return this.repo.c0();
    }

    public final boolean isScheduledJobNotifyEnable() {
        return this.repo.s0();
    }

    public final boolean isStreamMode() {
        return this.repo.I();
    }

    public final boolean isSystemNotifyEnable() {
        return this.repo.l0();
    }

    private final void bindObservers() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final Job fetchAuthorizationCount() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01141(this, null), 2, null);
    }

    public final Job queryUserInfo() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01171(this, null), 3, null);
    }

    public final MutableLiveData<Boolean> getAllowTrainByText() {
        return this.allowTrainByText;
    }

    public final MutableLiveData<Boolean> getAllowTrainByUpload() {
        return this.allowTrainByUpload;
    }

    public final MutableLiveData<Boolean> getAllowTrainByVideo() {
        return this.allowTrainByVideo;
    }

    public final MutableLiveData<Boolean> getAllowTraining() {
        return this.allowTraining;
    }

    public final MutableLiveData<Boolean> getAnswerWithSuggestLiveData() {
        return this.answerWithSuggestLiveData;
    }

    public final MutableLiveData<Boolean> getAnswerWithVideoLiveData() {
        return this.answerWithVideoLiveData;
    }

    public final MutableLiveData<Integer> getAuthorizationCountLiveData() {
        return this.authorizationCountLiveData;
    }

    public final MutableLiveData<Boolean> getFaceMemoryEnableLiveData() {
        return this.faceMemoryEnableLiveData;
    }

    public final MutableLiveData<Boolean> getHighlightEngineEnableLiveData() {
        return this.highlightEngineEnableLiveData;
    }

    public final MutableLiveData<Boolean> getHighlightEngineLiveData() {
        return this.highlightEngineLiveData;
    }

    public final MutableLiveData<Boolean> getInputSuggestEnableLiveData() {
        return this.inputSuggestEnableLiveData;
    }

    public final MutableLiveData<Boolean> getOptOutVoice() {
        return this.optOutVoice;
    }

    public final MutableLiveData<Boolean> getPersonalizedRecommend() {
        return this.personalizedRecommend;
    }

    public final MutableLiveData<Boolean> getPictureLocation() {
        return this.pictureLocation;
    }

    public final MutableLiveData<Boolean> getRealtimeDenoiseLiveData() {
        return this.realtimeDenoiseLiveData;
    }

    public final MutableLiveData<Boolean> getRelatedVideoEnableLiveData() {
        return this.relatedVideoEnableLiveData;
    }

    public final MutableLiveData<Boolean> getSaveChatHistory() {
        return this.saveChatHistory;
    }

    public final MutableLiveData<Boolean> getScheduledJobNotify() {
        return this.scheduledJobNotify;
    }

    public final LiveData<ModelItem> getVoiceModel() {
        return this.voiceModel;
    }

    public SettingModel(Application r12) {
        Intrinsics.checkNotNullParameter(r12, "application");
        super(r12);
        ISettingRepoService r13 = RepoDispatcherDelegate.b.c();
        this.repo = r13;
        ModelItem r10 = new ModelItem(null, 0, null, null, null, null, 63, null);
        r10.setModelName(r13.Z(r13.r0()));
        this.voiceModel = new MutableLiveData(r10);
        this._userInfoLiveData = new AsyncLiveData();
        this.authorizationCountLiveData = new MutableLiveData();
        this.personalizedRecommend = new MutableLiveData();
        this.pictureLocation = new MutableLiveData();
        this.relatedVideoEnableLiveData = new MutableLiveData();
        this.faceMemoryEnableLiveData = new MutableLiveData();
        this.realtimeDenoiseLiveData = new MutableLiveData();
        bindObservers();
        this.answerWithSuggestLiveData = new MutableLiveData();
        this.saveChatHistory = new MutableLiveData();
        this.optOutVoice = new MutableLiveData();
        this.allowTrainByText = new MutableLiveData();
        this.allowTrainByUpload = new MutableLiveData();
        this.allowTrainByVideo = new MutableLiveData();
        this.allowTraining = new MutableLiveData();
        this.scheduledJobNotify = new MutableLiveData();
        this.inputSuggestEnableLiveData = new MutableLiveData();
        this.highlightEngineEnableLiveData = new MutableLiveData();
        this.highlightEngineLiveData = new MutableLiveData();
        this.answerWithVideoLiveData = new MutableLiveData();
    }

    public static final /* synthetic */ ISettingRepoService access$getRepo$p(SettingModel r0) {
        return r0.repo;
    }

    public static final /* synthetic */ MutableLiveData access$getVoiceModel$p(SettingModel r0) {
        return r0.voiceModel;
    }

    public static final /* synthetic */ AsyncLiveData access$get_userInfoLiveData$p(SettingModel r0) {
        return r0._userInfoLiveData;
    }

    private static final List getVoiceModels$lambda$1(AudioUserConfig r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        List r2 = r1.getVoiceList();
        if (r2 == null) goto L5;
        List r3 = CollectionsKt.filterNotNull(r2);
    L6:
        if (r3 == null) goto L8;
        return r3;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r3 = null;
        goto L6
    }

    private static final List getVoiceModels$lambda$2(com.larus.bmhome.auth.c1 r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        com.larus.bmhome.auth.b r2 = (com.larus.bmhome.auth.b) r1.d;
        if (r2 == null) goto L7;
        List r3 = r2.x();
        if (r3 == null) goto L7;
        List r4 = CollectionsKt.filterNotNull(r3);
    L8:
        if (r4 == null) goto L10;
        return r4;
    L10:
        return CollectionsKt.emptyList();
    L7:
        r4 = null;
        goto L8
    }

    public final Job personalizedRecommendEnabled(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01151(this, r7, null), 3, null);
    }

    public final Job pictureLocationEnabled(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01161(this, r7, null), 3, null);
    }

    public final void saveAnswerWithVideo(String r8) {
        Intrinsics.checkNotNullParameter(r8, "value");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01181(r8, this, null), 3, null);
    }

    public final Job saveHighlightEngine(String r8) {
        Intrinsics.checkNotNullParameter(r8, "value");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01191(r8, this, null), 3, null);
    }

    public final void saveRelatedVideoEnabled(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01211(this, r7, null), 3, null);
    }

    public final Job selectVoiceModel(String r8) {
        Intrinsics.checkNotNullParameter(r8, "modelName");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01221(this, r8, null), 2, null);
    }

    public final void setEngineType(int r2) {
        this.repo.n(r2);
    }

    public final void setHighlightEnable(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01231(this, r7, null), 3, null);
    }

    public final void setHighlightGoWebview(boolean r2) {
        this.repo.K0(r2);
    }

    public final Job setInputSuggestEnable(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01241(this, r7, null), 3, null);
    }

    public final void setRealtimeCallEnabled(boolean r3) {
        if (FeatureKitDelegate.b.A0().b() == false) goto L5;
        this.repo.I0(r3);
        return;
    L5:
        EnsureManager.ensureNotReachHere("set realtime call enable error! value:" + r3);
        this.repo.I0(false);
    }

    public final void setShowCardSearch(boolean r2) {
        this.repo.M0(r2);
    }

    public final void setSugAllEnabled(boolean r2) {
        this.repo.U0(r2);
    }

    public final void setSugSearchEnabled(boolean r2) {
        this.repo.W(r2);
    }

    public final Job toggleAllowTrainByText(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01251(this, r7, null), 3, null);
    }

    public final Job toggleAllowTrainByUpload(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01261(this, r7, null), 3, null);
    }

    public final Job toggleAllowTrainByVideo(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01271(this, r7, null), 3, null);
    }

    public final Job toggleAllowTrainingEnabled(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01281(this, r7, null), 3, null);
    }

    public final void toggleInterruptEnabled(boolean r2) {
        this.repo.z(r2);
    }

    public final Job toggleOptOutVoiceEnabled(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01331(this, r7, null), 3, null);
    }

    public final void togglePromptEnabled(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01341(this, r7, null), 3, null);
    }

    public final void togglePromptStyleVertical(boolean r2) {
        MutableLiveData r0 = this.repo.w();
        if (r2 == false) goto L5;
        int r3 = 1;
    L6:
        r0.postValue(Integer.valueOf(r3));
        return;
    L5:
        r3 = 2;
        goto L6
    }

    public final Job toggleSaveChatHistoryEnabled(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01351(this, r7, null), 3, null);
    }

    public final void toggleStream(boolean r2) {
        this.repo.a0(r2);
    }

    public final Job toggleVoiceFeatureTrainAuthorizeChange(boolean r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01381(this, r7, null), 3, null);
    }

    private final void mobVoiceFeatureAuthResult(boolean r6, boolean r7) {
        by7.a r0 = new by7.a("voice_feature_auth_setting_result");
        TrackParams.a r1 = TrackParams.Companion;
        JSONObject r2 = new JSONObject();
        r2.put("current_page", "setting");
        r2.put("previous_page", "setting");
        if (r6 == false) goto L5;
        String r8 = "1";
    L6:
        r2.put("success", r8);
        if (r7 == false) goto L9;
        String r9 = "on";
    L10:
        r2.put("to_status", r9);
        Unit r10 = Unit.INSTANCE;
        String r11 = r2.toString();
        r1.getClass();
        TrackParams r12 = new TrackParams().merge(r11);
        r0.a.merge(r12);
        r0.b();
        return;
    L9:
        r9 = " off";
        goto L10
    L5:
        r8 = "0";
        goto L6
    }

    public final Object setFaceMemoryEnabled(boolean r7, Continuation<? super Boolean> r8) {
        return BuildersKt.async$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, r7, null), 3, null).await(r8);
    }

    public final Job toggleAppNotifyDetailEnabled(boolean r7, ItemTextToggle r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01291(this, r8, r7, null), 3, null);
    }

    public final Job toggleAppNotifyEnabled(boolean r7, ItemTextToggle r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01301(r7, this, r8, null), 3, null);
    }

    public final Job toggleFindByDoubaoUserNameEnabled(boolean r7, ItemTextToggle r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01311(this, r7, r8, null), 3, null);
    }

    public final Job toggleFindByPhoneEnabled(boolean r7, ItemTextToggle r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01321(this, r7, r8, null), 3, null);
    }

    public final Job toggleScheduledJobNotifyEnabled(boolean r7, ItemTextToggle r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01361(r7, this, r8, null), 3, null);
    }

    public final Job toggleSystemNotifyEnabled(boolean r7, ItemTextToggle r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01371(r7, this, r8, null), 3, null);
    }

    public static final /* synthetic */ void access$mobVoiceFeatureAuthResult(SettingModel r0, boolean r1, boolean r2) {
        r0.mobVoiceFeatureAuthResult(r1, r2);
    }

    public final void updateUserConfigs(List<Integer> r8, int r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r8, "configKeys");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01391(r8, r9, r10, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateUserConfigs$default(SettingModel r0, List r1, int r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        UserConfigKey.Companion.getClass();
        r1 = UserConfigKey.a.b();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = UserConfigPullReason.STARTUP.getValue();
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        r0.updateUserConfigs(r1, r2, r3);
    }

    public final Job savePrivacySettings(boolean r14, boolean r15, boolean r16, boolean r17, int r18, boolean r19) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01201(this, r14, r15, r16, r17, r19, r18, null), 3, null);
    }
}
