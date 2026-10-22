package com.larus.voicecall.impl.component.core;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.NetworkUtils;
import com.google.gson.reflect.TypeToken;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IAudioService;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.a1;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.bmhome.utils.a4;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.y0;
import com.larus.im.service.audio.z0;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.CommandType;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.component.vlm.m1;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeNoticeDialogHelper;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 À\u00012\u00020\u00012\u00020\u0002:\u0002À\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010q\u001a\u00020jH\u0016J\b\u0010r\u001a\u00020jH\u0016J\b\u0010s\u001a\u00020jH\u0016J\u0010\u0010t\u001a\u00020j2\u0006\u0010u\u001a\u00020vH\u0016J\b\u0010w\u001a\u00020jH\u0002J\b\u0010x\u001a\u00020jH\u0002J\b\u0010y\u001a\u00020jH\u0016J.\u0010z\u001a\u00020j2\u0006\u0010{\u001a\u00020i2\u0006\u0010|\u001a\u00020%2\u0014\u0010}\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020j\u0018\u00010hH\u0016J\b\u0010~\u001a\u00020jH\u0002J\u0011\u0010\u007f\u001a\u00020j2\u0007\u0010\u0080\u0001\u001a\u00020iH\u0002J\t\u0010\u0081\u0001\u001a\u00020jH\u0002J\t\u0010\u0082\u0001\u001a\u00020jH\u0016J\t\u0010\u0083\u0001\u001a\u00020jH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020j2\u0007\u0010\u0085\u0001\u001a\u00020%H\u0002J\t\u0010\u0086\u0001\u001a\u00020jH\u0002J\u0010\u0010\u0087\u0001\u001a\u00020jH\u0082@¢\u0006\u0003\u0010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020jH\u0002J\t\u0010\u008a\u0001\u001a\u00020jH\u0002J\t\u0010\u008b\u0001\u001a\u00020jH\u0002J\t\u0010\u008c\u0001\u001a\u00020jH\u0002J\t\u0010\u008d\u0001\u001a\u00020jH\u0016J\t\u0010\u008e\u0001\u001a\u00020jH\u0016J\t\u0010\u008f\u0001\u001a\u00020jH\u0002J\t\u0010\u0090\u0001\u001a\u00020jH\u0002J\u0012\u0010\u0091\u0001\u001a\u00020j2\u0007\u0010\u0092\u0001\u001a\u00020iH\u0002J\t\u0010\u0093\u0001\u001a\u00020jH\u0002J\t\u0010\u0094\u0001\u001a\u00020jH\u0002J/\u0010\u0095\u0001\u001a\u00020j2\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0098\u0001\u001a\u00020f2\b\u0010\u0099\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u009a\u0001\u001a\u00020fH\u0016J\t\u0010\u009b\u0001\u001a\u00020jH\u0016J\u0013\u0010\u009c\u0001\u001a\u00020j2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J\u0015\u0010\u009f\u0001\u001a\u00020j2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0002J\t\u0010¢\u0001\u001a\u00020jH\u0016J\t\u0010£\u0001\u001a\u00020jH\u0016J\t\u0010¤\u0001\u001a\u00020jH\u0016J\t\u0010¥\u0001\u001a\u00020jH\u0016J\u0012\u0010¦\u0001\u001a\u00020j2\u0007\u0010§\u0001\u001a\u00020iH\u0016J\u0012\u0010¨\u0001\u001a\u00020j2\u0007\u0010§\u0001\u001a\u00020iH\u0016J\u001f\u0010©\u0001\u001a\u00020j2\t\u0010ª\u0001\u001a\u0004\u0018\u00010i2\t\u0010«\u0001\u001a\u0004\u0018\u00010iH\u0016J\u001f\u0010¬\u0001\u001a\u00020j2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010i2\t\u0010ª\u0001\u001a\u0004\u0018\u00010iH\u0016J\u0012\u0010®\u0001\u001a\u00020j2\u0007\u0010§\u0001\u001a\u00020iH\u0016J\u0012\u0010¯\u0001\u001a\u00020j2\u0007\u0010°\u0001\u001a\u00020iH\u0016J0\u0010±\u0001\u001a\u00020j2%\u0010g\u001a!\u0012\u0015\u0012\u00130i¢\u0006\u000e\b²\u0001\u0012\t\b³\u0001\u0012\u0004\b\b({\u0012\u0004\u0012\u00020j\u0018\u00010hH\u0016J\t\u0010´\u0001\u001a\u00020jH\u0016J\t\u0010µ\u0001\u001a\u00020jH\u0016J\u0013\u0010¶\u0001\u001a\u00020j2\b\u0010·\u0001\u001a\u00030¸\u0001H\u0016J\u001e\u0010¹\u0001\u001a\u00020j2\u0007\u0010\u009d\u0001\u001a\u00020i2\n\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001H\u0016J\u0015\u0010¼\u0001\u001a\u00020j2\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0002J\t\u0010¿\u0001\u001a\u00020jH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\n\u001a\u0004\b<\u0010=R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\n\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\n\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bK\u0010LR\u001d\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\n\u001a\u0004\bP\u0010QR\u001d\u0010S\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\n\u001a\u0004\bU\u0010VR\u001b\u0010X\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\n\u001a\u0004\bZ\u0010[R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010g\u001a\u0010\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020j\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010l\u001a\u0004\u0018\u00010m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\n\u001a\u0004\bn\u0010o¨\u0006Á\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/core/RealtimeCoreComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "<init>", "()V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "osDestroyed", NameKeys.UnloadStrategy_No_Strategy, "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "traceAbility", "Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "getTraceAbility", "()Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "traceAbility$delegate", "videoAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVideoAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "videoAbility$delegate", "interviewAbility", "Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "getInterviewAbility", "()Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "interviewAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "imAbility", "Lcom/larus/voicecall/impl/component/im/IRealtimeIMAbility;", "getImAbility", "()Lcom/larus/voicecall/impl/component/im/IRealtimeIMAbility;", "imAbility$delegate", "feedbackAbility", "Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "getFeedbackAbility", "()Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "feedbackAbility$delegate", "stateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "stateManager$delegate", "interceptorManager", "Lcom/larus/voicecall/impl/RealtimeCallCheckManager;", "isGoSettingsDialogShown", "startRealtimeCallConnection", "networkUnavailableTipsTimeMs", NameKeys.UnloadStrategy_No_Strategy, "networkUnavailableTipsInterval", "isQueryBegin", "currentUIState", NameKeys.UnloadStrategy_No_Strategy, "onMicGranted", "Lkotlin/Function1;", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "isViewCrated", "disclaimerConfig", "Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "getDisclaimerConfig", "()Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "disclaimerConfig$delegate", "onAttach", "onVContextReady", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "checkArgumentParam", "setDisclaimer", "tryCheckBluetoothPermission", "requestMicAccess", "caller", "forceRequest", "callback", "setCallServiceListener", "doPerformBack", "endMethod", "checkPermission", "onResume", "connectWhenMicAccess", "onUpdatePermission", "haPermission", "startConnection", "startConnectInnerEnsureViewCreated", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConnectInner", "tryPreloadVideoCapture", "toastNetworkUnavailable", "networkUnavailableOnRTC", "hotAreaClick", "retryConnect", "listenOnRetryCommands", "retryDuplexCommand", "retryConnectOrResume", "clickMethod", "interruptAsrForSend", "tryInterrupt", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "adjustTheVolumeWhenCallStarted", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "handleCommandReplyItem", "commandType", "Lcom/larus/voicecall/api/bean/CommandType;", "mute", "unMute", "playerMute", "playerUnMute", "sendLocationAuthSucceedTrigger", "extra", "sendLocationAuthFailTrigger", "sendAuthSuccessTrigger", "questionId", "answerId", "sendAuthDenyTrigger", "refuseText", "sendSubtitleImageTrigger", "updateLocationContext", "source", "registerMicGrantListener", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "onFragmentViewDestroyed", "onDestroy", "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "otherEvent", LynxAccessibilityModule.MSG_CONTENT, NameKeys.UnloadStrategy_No_Strategy, "modifyCallIdBy", "connectInfo", "Lkotlinx/serialization/json/JsonObject;", "releaseListeners", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCoreComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.core.a {
    public static final /* synthetic */ int P = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public com.larus.voicecall.impl.l F;
    public boolean G;
    public boolean H;
    public volatile long I;
    public final long J;
    public boolean K;
    public int L;
    public Function1<? super String, Unit> M;
    public boolean N;
    public final Lazy O;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public boolean t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Function0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<ChatParam> {
        public c() {
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(l0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final void onCreate() {
        this.t = false;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.F = new com.larus.voicecall.impl.l(com.larus.ui.arch.component.internal.attach.a.b(this, this), X3(), ((h88.a) E3()).k, ((h88.b) W3()).a, ((h88.a) E3()).d, ((h88.a) E3()).f);
        X3().E();
        if (com.larus.voicecall.impl.l.a.a(getActivity()) == false) goto L5;
        X3().E();
        d4();
    L5:
        RealtimeCallUtil r0 = RealtimeCallUtil.a;
        String r1 = ((h88.a) E3()).d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        RealtimeCallUtil.w = r1;
        RealtimeCallUtil.x = ((h88.a) E3()).f;
    }

    public final void onDestroy() {
        this.t = true;
        RealtimeCallUtil.a.getClass();
        Intrinsics.checkNotNullParameter(NameKeys.UnloadStrategy_No_Strategy, "<set-?>");
        RealtimeCallUtil.w = NameKeys.UnloadStrategy_No_Strategy;
        RealtimeCallUtil.x = NameKeys.UnloadStrategy_No_Strategy;
        RealtimeCallUtil.y = NameKeys.UnloadStrategy_No_Strategy;
        com.larus.voicecall.impl.component.feedback.e r0 = (com.larus.voicecall.impl.component.feedback.e) this.D.getValue();
        if (r0 == null) goto L6;
        r0.j60();
    L6:
        if (Q3().q().y0() == false) goto L8;
        RealtimeCallUtil.c(((h88.a) E3()).f);
    L8:
        RealtimeCallParam r1 = H3();
        RealtimeCallParam.k r2 = r1.p;
        r2.j = ((h88.b) W3()).o;
        Q3().e(r1);
        Q3().b();
        ((com.larus.audio.call.a) Q3()).e = null;
        ((com.larus.audio.call.a) Q3()).p = null;
        ((com.larus.audio.call.a) Q3()).q = null;
        ((com.larus.audio.call.a) Q3()).b = null;
        ((com.larus.audio.call.a) Q3()).h = null;
        ((com.larus.audio.call.a) Q3()).f = null;
        ((com.larus.audio.call.a) Q3()).i = null;
        ((com.larus.audio.call.a) Q3()).a = null;
        ((com.larus.audio.call.a) Q3()).g = null;
        RealtimeCallService r3 = Q3();
        b r4 = b.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.s = r4;
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.n.getValue();
    }

    public final e3a.a E3() {
        return (e3a.a) this.o.getValue();
    }

    public final com.larus.voicecall.impl.component.bottom.b G3() {
        return (com.larus.voicecall.impl.component.bottom.b) this.x.getValue();
    }

    public final RealtimeCallParam H3() {
        return (RealtimeCallParam) this.q.getValue();
    }

    public final RealtimeCallService Q3() {
        return (RealtimeCallService) this.r.getValue();
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void UQ() {
        if (Build.VERSION.SDK_INT < 31) goto L13;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.y() == true) goto L13;
        if (i2.b.d("android.permission.BLUETOOTH_CONNECT") == false) goto L11;
        FLogger.a.i("RealtimeCoreComponent", "user has BLUETOOTH_CONNECT permission");
        return;
    L11:
        Intrinsics.checkNotNullParameter(this, "<this>");
        i2.q(com.larus.ui.arch.component.internal.attach.a.b(this, this), CollectionsKt.listOf("android.permission.BLUETOOTH_CONNECT"), new c0());
        return;
    L13:
        FLogger.a.i("RealtimeCoreComponent", "NO NEED BLUETOOTH_CONNECT permission");
    }

    public final g3a.a V3() {
        return (g3a.a) this.w.getValue();
    }

    public final e3a.b W3() {
        return (e3a.b) this.p.getValue();
    }

    public final IRealtimeCallTracer X3() {
        return (IRealtimeCallTracer) this.s.getValue();
    }

    public final void d4() {
        if (this.H == false) goto L5;
        return;
    L5:
        this.H = true;
        FLogger r1 = FLogger.a;
        r1.i("RealtimeCoreComponent", "[startConnection] success");
        RealtimeCallUtil.a.getClass();
        if (((Boolean) RealtimeCallUtil.i0.getValue()).booleanValue() == true) goto L8;
    L13:
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), Dispatchers.getMain().getImmediate(), null, new RealtimeCoreComponent$startConnection$1(this, null), 2, null);
        return;
    L8:
        if (RealtimeCallUtil.L(((h88.b) W3()).e) == true) goto L13;
        r1.i("jyt_test", "tryPreloadVideoCapture start");
        RealtimeCallService r2 = Q3();
        RealtimeCallParam r4 = H3();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "param");
        Intrinsics.checkNotNullParameter(r4, "param");
        RealtimeCallService.s(r4);
        com.larus.voicecall.impl.x r3 = r2.u;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "param");
        r3.C(r4, false, "preloadMediaSession", Long.valueOf(((LLMCallController) r3).t.c()));
        ((LLMCallController) r3).h = true;
        com.larus.voicecall.impl.component.vlm.b r0 = (com.larus.voicecall.impl.component.vlm.b) this.z.getValue();
        if (r0 == null) goto L12;
        r0.my();
    L12:
        r1.i("jyt_test", "tryPreloadVideoCapture end");
        goto L13
    }

    public final void h4() {
        j3a.a r0 = (j3a.a) this.A.getValue();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L12;
        FLogger.a.i("RealtimeCoreComponent", "hasPendingHangUpEvent, ignore interrupt");
        return;
    L12:
        int r3 = ((h88.b) W3()).k;
        if (r3 != 5) goto L15;
    L20:
        com.larus.voicecall.impl.component.bottom.b r4 = G3();
        if (r4 == null) goto L33;
        VoiceCallBottomLayout r5 = r4.BT();
        if (r5 == null) goto L33;
        Job r6 = r5.b;
        if (r6 != null) goto L27;
    L29:
        boolean r7 = false;
    L31:
        if ((!r7) != true) goto L33;
    L34:
        if (r1 == false) goto L36;
        a4.a.getClass();
        a4.a(a4.b);
        RealtimeCallService r8 = Q3();
        RealtimeCallParam r9 = H3();
        int r10 = com.larus.audio.call.a.r;
        r8.t(r9, false);
        return;
    L36:
        FLogger.a.i("RealtimeCoreComponent", "tryInterrupt failed");
        return;
    L27:
        if (r6.isActive() != true) goto L29;
        r7 = true;
    L33:
        r1 = false;
        goto L34
    L15:
        if (r3 == 4) goto L20;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l == null) goto L36;
        if (r3 != 9) goto L36;
    L5:
        if (r0.YR() != true) goto L7;
        r2 = true;
        goto L9
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void i40() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        AudioManager r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService(LynxResourceModule.AUDIO_TYPE);
    L7:
        if ((r2 instanceof AudioManager) == false) goto L9;
        r1 = (AudioManager) r2;
    L9:
        if (r1 == null) goto L22;
        int r3 = r1.getStreamMaxVolume(3);
        int r4 = r1.getStreamVolume(3);
        float r5 = (r4 * 1.0f) / r3;
        int r6 = z2.a.v3().a();
        if (r6 < 0) goto L13;
        r1.setStreamVolume(0, r6 * r3, 0);
    L13:
        int r7 = r1.getStreamMaxVolume(0);
        int r8 = r1.getStreamVolume(0);
        int r9 = (int) (r7 * r5);
        if (r9 == r8) goto L17;
        r1.setStreamVolume(0, r9, 0);
    L17:
        if (r9 == r8) goto L20;
        FLogger.a.i("RealtimeCoreComponent", "cur media volume is ok，do not modify cur call volume=" + r8 + " maxCallVolume=" + r7 + " curMediaVolume=" + r4 + " maxMediaVolume=" + r3 + "  targetMediaVolume=" + r9);
        return;
    L20:
        FLogger.a.i("RealtimeCoreComponent", "cur media volume is bad，modify volume cur call volume=" + r8 + " maxCallVolume=" + r7 + " curMediaVolume=" + r4 + " maxMediaVolume=" + r3 + "  targetMediaVolume=" + r9);
        return;
    L22:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void lN() {
        c4("automatic_click");
    }

    public final void onResume() {
        com.larus.voicecall.impl.l r0 = this.F;
        if (r0 == null) goto L18;
        boolean r3 = ((h88.a) E3()).m;
        Pair<Boolean, Boolean> r4 = com.larus.voicecall.impl.l.i;
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == true) goto L12;
    L16:
        r0.h = false;
        goto L18
    L12:
        if (r0.h == true) goto L16;
        com.larus.voicecall.impl.l.i = TuplesKt.to(Boolean.FALSE, Boolean.valueOf(r3));
        CompletableDeferred<Integer> r6 = r0.g;
        if (r6 == null) goto L16;
        r6.complete(1);
        goto L16
    L7:
        if (((Boolean) r4.getFirst()).booleanValue() != true) goto L9;
        r5 = true;
    L18:
        if (this.G == false) goto L32;
        this.G = false;
        Pair<Boolean, Boolean> r1 = com.larus.voicecall.impl.l.i;
        if (com.larus.voicecall.impl.l.a.b(getActivity()) == false) goto L33;
        m3a.a r2 = (m3a.a) this.v.getValue();
        if (r2 == null) goto L24;
        r2.O1(true);
    L24:
        g3a.a r7 = V3();
        if (r7 == null) goto L27;
        r7.O1(true);
    L27:
        com.larus.voicecall.impl.component.bottom.b r8 = G3();
        if (r8 == null) goto L30;
        r8.O1(true);
    L30:
        X3().g();
        d4();
        return;
    L33:
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void oo() {
        Intrinsics.checkNotNullParameter("RealtimeFirstPartComponent", "source");
        Q3().y("RealtimeFirstPartComponent");
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.core.a.class);
    }

    public RealtimeCoreComponent() {
        this.n = LazyKt.lazy(new m0(this));
        this.o = LazyKt.lazy(new g(this));
        this.p = LazyKt.lazy(new h(this));
        this.q = LazyKt.lazy(new i(this));
        this.r = LazyKt.lazy(new j(this));
        this.s = LazyKt.lazy(new k(this));
        this.u = LazyKt.lazy(new l(this));
        this.v = LazyKt.lazy(new n(this));
        this.w = LazyKt.lazy(new o(this));
        this.x = LazyKt.lazy(new p(this));
        this.y = LazyKt.lazy(new n0(this));
        this.z = LazyKt.lazy(new o0(this));
        this.A = LazyKt.lazy(new p0(this));
        this.B = LazyKt.lazy(new q0(this));
        this.C = LazyKt.lazy(new com.larus.voicecall.impl.component.core.c(this));
        this.D = LazyKt.lazy(new com.larus.voicecall.impl.component.core.d(this));
        this.E = LazyKt.lazy(new e(this));
        this.I = -1;
        this.J = TimeUnit.SECONDS.toMillis(3);
        this.L = -1;
        this.O = LazyKt.lazy(new f());
    }

    public final void A0() {
        getActivity();
        E3();
        W3();
        Q3();
        com.larus.voicecall.impl.component.window.b r0 = (com.larus.voicecall.impl.component.window.b) this.u.getValue();
        m3a.a r1 = (m3a.a) this.v.getValue();
        V3();
        G3();
        n3a.a r2 = (n3a.a) this.y.getValue();
        com.larus.voicecall.impl.component.feedback.e r3 = (com.larus.voicecall.impl.component.feedback.e) this.D.getValue();
    }

    public final void A2() {
        ((com.larus.audio.call.a) Q3()).i = null;
        ((com.larus.audio.call.a) Q3()).h = null;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void Ix() {
        if (((h88.b) W3()).k != 6) goto L5;
    L15:
        c4("user_click");
        return;
    L5:
        if (((h88.b) W3()).n == true) goto L15;
        if (((h88.b) W3()).k == 3) goto L10;
        ((w3a.k) this.E.getValue()).d(w3a.n.a);
        h4();
        return;
    L10:
        if (((h88.b) W3()).k == 3) goto L12;
        return;
    L12:
        if (this.K == false) goto L18;
        a4.a.getClass();
        a4.a(a4.b);
        Q3().a(H3());
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void R1() {
        RealtimeCallService r0 = Q3();
        RealtimeCallParam r1 = H3();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "param");
        Intrinsics.checkNotNullParameter(r1, "param");
        FLogger.a.i("RealtimeCallService", "unMute");
        r0.u.U(r1);
    }

    public final void a4() {
    L8:
        th = move-exception;
        FLogger.a.e("RealtimeCoreComponent", th.getMessage(), th);
        return;
    L3:
        if (y0.e(((h88.b) W3()).e) == true) goto L5;
        return;
    L5:
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L14;
        e4();     // Catch: Throwable -> L8
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void cJ() {
        ((h88.b) W3()).v = false;
        RealtimeCallService r0 = Q3();
        RealtimeCallParam r2 = H3();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "param");
        FLogger.a.i("RealtimeCallService", "playerUnMute");
        r0.k().e0().c(false);
    }

    public final void e4() {
        if (y0.e(((h88.b) W3()).e) == true) goto L5;
    L9:
        this.I = System.currentTimeMillis();
        getActivity().runOnUiThread(new a0(this));
        return;
    L5:
        if (this.I <= 0) goto L9;
        if ((System.currentTimeMillis() - this.I) >= this.J) goto L9;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void mute() {
        IRealtimeCallTracer r0 = X3();
        RealtimeCallParam r1 = H3();
        InstanceCallState.a r2 = InstanceCallState.Companion;
        int r3 = ((h88.b) W3()).k;
        r2.getClass();
        r0.l0(r1, InstanceCallState.a.a(r3));
        RealtimeCallService r4 = Q3();
        RealtimeCallParam r5 = H3();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r5, "param");
        FLogger.a.i("RealtimeCallService", "mute");
        r4.u.G(r5);
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void nr() {
        ((h88.b) W3()).v = true;
        RealtimeCallService r0 = Q3();
        RealtimeCallParam r2 = H3();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "param");
        FLogger.a.i("RealtimeCallService", "playerMute");
        r0.k().e0().c(true);
    }

    public static Unit B3(RealtimeCoreComponent r2) {
        if (y0.e(((h88.b) r2.W3()).e) == false) goto L5;
        AudioServiceDelegate.a.getAudioConfig().r("rtc_reconnected");
    L5:
        r2.getActivity().runOnUiThread(new g0());
        return Unit.INSTANCE;
    }

    public final void D3(String r3) {
        if (com.larus.utils.o0.d(r3) == false) goto L6;
        RealtimeCallParam r0 = W3().a();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.H = r3;
        ((h88.b) W3()).o = r3;
    L6:
        if (z2.a.realtimeCallUseUplinkHangUp() == false) goto L23;
        j3a.a r4 = (j3a.a) this.A.getValue();
        boolean r1 = false;
        if (r4 != null) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == true) goto L20;
        com.larus.voicecall.impl.component.scene.a r6 = (com.larus.voicecall.impl.component.scene.a) this.B.getValue();
        if (r6 != null) goto L17;
    L19:
        if (r1 == false) goto L23;
    L17:
        if (r6.wm() != true) goto L19;
        r1 = true;
    L20:
        com.larus.voicecall.impl.component.scene.a r7 = (com.larus.voicecall.impl.component.scene.a) this.B.getValue();
        if (r7 == null) goto L23;
        r7.bQ();
        goto L23
    L10:
        if (r4.su() != true) goto L12;
        r5 = true;
    L23:
        com.larus.voicecall.impl.component.window.b r8 = (com.larus.voicecall.impl.component.window.b) this.u.getValue();
        if (r8 == null) goto L27;
        r8.zg();
        return;
    }

    public final void D9(z0.a r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        if ((r11 instanceof pf9.o) == false) goto L11;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z() == false) goto L9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r0 == null) goto L9;
        r0.postDelayed(new k0(this), 500);
    L9:
        Lazy r1 = RealtimeNoticeDialogHelper.a;
        String r12 = ((pf9.o) r11).e;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        RealtimeNoticeDialogHelper.c = r12;
        return;
    L11:
        if ((r11 instanceof pf9.g0) == false) goto L16;
        h4();
        FLogger.a.i("RealtimeCoreComponent", "on received FlowLLMRetryNewRoundEvent");
        if (this.L == 3) goto L70;
        t19.s.a.g(getContext(), 2131900515, false);
        return;
    L70:
        return;
    L16:
        if ((r11 instanceof pf9.z) == false) goto L19;
        this.K = true;
        return;
    L19:
        if ((r11 instanceof pf9.a0) == false) goto L22;
        this.K = false;
        return;
    L22:
        if ((r11 instanceof pf9.q) == false) goto L74;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L58
        Iterator r13 = ((pf9.q) r11).a.iterator();     // Catch: Throwable -> L58
    L25:
        if (r13.hasNext() == false) goto L56;
        pf9.p r3 = (pf9.p) r13.next();     // Catch: Throwable -> L58
        CommandType r4 = new CommandType();     // Catch: Throwable -> L58
        Long r5 = r3.a;     // Catch: Throwable -> L58
        if (r5 == null) goto L29;
        int r6 = (int) r5.longValue();     // Catch: Throwable -> L58
    L30:
        r4.setCommandType(r6);     // Catch: Throwable -> L58
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L58
        Map r8 = r3.b;     // Catch: Throwable -> L58
        if (r8 == null) goto L36;
        Iterator r9 = r8.entrySet().iterator();     // Catch: Throwable -> L58
    L34:
        if (r9.hasNext() == false) goto L36;
        Map.Entry r10 = (Map.Entry) r9.next();     // Catch: Throwable -> L58
        r7.putOpt((String) r10.getKey(), r10.getValue());     // Catch: Throwable -> L58
    L36:
        zd9.h r14 = zd9.h.a;     // Catch: Throwable -> L58
        String r15 = r7.toString();     // Catch: Throwable -> L58
        if (r15 != null) goto L39;
    L42:
        boolean r16 = true;
    L43:
        if (r16 == false) goto L63;
    L54:
        Object r17 = null;
    L55:
        r4.setParam((ChatParam) r17);     // Catch: Throwable -> L58
        Z3(r4);     // Catch: Throwable -> L58
        goto L25
    L63:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L47
        r14.getClass();     // Catch: Throwable -> L47
        r17 = Result.constructor-impl(zd9.h.b.fromJson(r15, new c().getType()));     // Catch: Throwable -> L47
    L49:
        Throwable r19 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L58
        if (r19 == null) goto L53;
        com.larus.im.internal.delegate.c0 r20 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L58
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L58
        r21.append("fromJson failed, stack: ");     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r19, "<this>");     // Catch: Throwable -> L58
        r21.append(ExceptionsKt.stackTraceToString(r19));     // Catch: Throwable -> L58
        r20.e("GsonHolder", r21.toString());     // Catch: Throwable -> L58
    L53:
        if (Result.isFailure-impl(r17) == false) goto L55;
    L47:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L58
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L49
    L39:
        if (StringsKt.isBlank(r15) == true) goto L42;
        r16 = false;
        goto L43
    L29:
        r6 = -1;
        goto L30
    L56:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L58
        return;
    L58:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }

    public final void I6(jd9.c r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r4, "state");
        X3().h(r4);
        ouc.d0 r5 = r4.b;
        if (r5 == null) goto L26;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        String r6 = sf9.a.c(r5, "roomId", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L16
        if (r6 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L25;
        e3a.b r2 = W3();     // Catch: Throwable -> L16
        r2.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r6, "<set-?>");     // Catch: Throwable -> L16
        ((h88.b) r2).c = r6;     // Catch: Throwable -> L16
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L27;
        FLogger.a.e("RealtimeCoreComponent", "get roomId failed", r8);
        return;
    L27:
        return;
    L25:
        return;
    L8:
        if (StringsKt.isBlank(r6) == true) goto L11;
        r1 = false;
    L16:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public final void Z3(CommandType r9) {
        if (r9.getCommandType() != 30) goto L8;
        RealtimeCallParam r10 = W3().a();
        r10.getClass();
        Intrinsics.checkNotNullParameter("mute_overtime", "<set-?>");
        r10.H = "mute_overtime";
        FLogger.a.i("RealtimeCoreComponent", "stop realtime call for command!");
        t19.s r2 = t19.s.a;
        Application r3 = AppHost.a.getApplication();
        Intrinsics.checkNotNullParameter(this, "<this>");
        t19.s.j(r2, r3, com.larus.ui.arch.component.internal.attach.a.b(this, this).getResources().getString(2131900529), null, false, 28);
        Function1 r11 = ((com.larus.audio.call.a) Q3()).g;
        if (r11 == null) goto L9;
        r11.invoke(NameKeys.UnloadStrategy_No_Strategy);
        return;
    L9:
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void ZQ(String r5) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        RealtimeCallService r1 = Q3();
        RealtimeCallParam r2 = H3();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "extra");
        LLMCallController.w(r1.u, Reflection.getOrCreateKotlinClass(a1.class)).j2(r2, r5);
    }

    public final void c4(String r5) {
        e3a.b r0 = W3();
        int r1 = ((h88.b) r0).k;
        if (r1 != 6) goto L5;
    L11:
        X3().i0();
        n3a.a r2 = (n3a.a) this.y.getValue();
        if (r2 == null) goto L14;
        r2.u00(r5);
    L14:
        RealtimeCallParam.d r6 = r0.a().l;
        String r3 = UUID.randomUUID().toString();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r6.a = r3;
        if (((h88.b) r0).n == false) goto L26;
        ((h88.b) r0).n = false;
        g3a.a r7 = V3();
        if (r7 == null) goto L26;
        VoiceCallContentLayout r8 = r7.dg();
        if (r8 == null) goto L26;
        if (r8.a.w.getVisibility() != 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == false) goto L26;
        com.larus.voicecall.impl.utils.c.d(r8.a.w, false);
        goto L26
    L23:
        r4 = false;
    L26:
        Q3().v(r0.a());
        return;
    L5:
        if (r1 == 16) goto L11;
        if (((h88.b) r0).n == false) goto L28;
        a4.a.getClass();
        a4.a(a4.b);
        Q3().u(r0.a());
        ((h88.b) r0).n = false;
        return;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void fG(String r5) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        RealtimeCallService r1 = Q3();
        RealtimeCallParam r2 = H3();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "extra");
        r1.l().o2(r2, r5);
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void ft(String r5) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        RealtimeCallService r1 = Q3();
        RealtimeCallParam r2 = H3();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "extra");
        r1.l().x1(r2, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.voicecall.impl.component.core.b0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r1 = null;
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new RealtimeCoreComponent$checkArgumentParam$1(this, null), 3, null);
    L6:
        this.N = true;
        ((com.larus.audio.call.a) Q3()).e = new q(this);
        ((com.larus.audio.call.a) Q3()).p = new r(this);
        ((com.larus.audio.call.a) Q3()).q = new s(this);
        ((com.larus.audio.call.a) Q3()).b = new t();
        ((com.larus.audio.call.a) Q3()).h = new u(this);
        ((com.larus.audio.call.a) Q3()).f = new v(this);
        ((com.larus.audio.call.a) Q3()).i = new w(this);
        ((com.larus.audio.call.a) Q3()).a = new y(this);
        ((com.larus.audio.call.a) Q3()).g = new z(this);
        if (com.larus.audio.call.f.f() == false) goto L9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), Dispatchers.getMain(), null, new RealtimeCoreComponent$listenOnRetryCommands$1(this, null), 2, null);
    L9:
        com.larus.platform.model.chat.q r10 = (com.larus.platform.model.chat.q) this.O.getValue();
        if (r10 != null) goto L12;
    L14:
        boolean r11 = false;
    L15:
        if (r11 == false) goto L21;
        com.larus.voicecall.impl.component.bottom.b r12 = G3();
        if (r12 == null) goto L21;
        VoiceCallBottomLayout r13 = r12.BT();
        if (r13 == null) goto L21;
        r13.p9(true);
    L21:
        g3a.a r14 = V3();
        if (r14 == null) goto L24;
        VoiceCallContentLayout r15 = r14.dg();
    L25:
        if (r15 == null) goto L29;
        LinearLayout r0 = r15.getMicAccessButton();
        if (r0 == null) goto L29;
        r0.setOnClickListener(new com.larus.voicecall.impl.component.core.b(this));
    L29:
        if (r15 == null) goto L33;
        LinearLayout r2 = r15.getDoubleLineMicAccessButton();
        if (r2 == null) goto L33;
        r2.setOnClickListener(new m(this));
    L33:
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.k() == true) goto L38;
        if (r15 == null) goto L37;
        r1 = r15.getHotArea();
    L37:
        e1.d(r1, new x(this));
    L45:
        Pair<Boolean, Boolean> r16 = com.larus.voicecall.impl.l.i;
        boolean r17 = com.larus.voicecall.impl.l.a.b(getActivity());
        m3a.a r3 = (m3a.a) this.v.getValue();
        if (r3 == null) goto L48;
        r3.O1(r17);
    L48:
        g3a.a r4 = V3();
        if (r4 == null) goto L51;
        r4.O1(r17);
    L51:
        com.larus.voicecall.impl.component.bottom.b r5 = G3();
        if (r5 == null) goto L55;
        r5.O1(r17);
    L55:
        if (com.larus.voicecall.impl.l.a.a(getActivity()) == true) goto L61;
        com.larus.voicecall.impl.l r18 = this.F;
        if (r18 == 0) goto L61;
        r18.a(((h88.a) E3()).m, new b0(this));
    L61:
        if (RealtimeCallUtil.z() == false) goto L64;
        UQ();
        return;
    L64:
        return;
    L38:
        g3a.a r19 = V3();
        if (r19 == null) goto L41;
        r1 = r19.iB();
    L41:
        if (r1 == null) goto L43;
        e1.x(r1);
    L43:
        if (r1 == null) goto L45;
        e1.d(r1, new i0(this));
        goto L45
    L24:
        r15 = null;
        goto L25
    L12:
        if (r10.b() != true) goto L14;
        r11 = true;
        goto L15
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void yK(m1 r1) {
        this.M = r1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.voicecall.impl.component.core.l0] */
    public static final Object C3(final RealtimeCoreComponent r4, Continuation r5) {
        if (r4.N == false) goto L15;
        boolean r6 = z2.a.S();
        FLogger r0 = FLogger.a;
        r0.i("RealtimeCoreComponent", "startConnectInner,realtimeDelayStartConnect:" + r6);
        if (r6 == false) goto L11;
        final long r1 = SystemClock.elapsedRealtime();
        IAudioService r7 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r7 == null) goto L20;
        LiveData r8 = r7.hasInit();
        if (r8 == null) goto L20;
        r8.observe(r4.getActivity(), new d(new l0(r4, r1)));
    L20:
        return Unit.INSTANCE;
    L11:
        r4.a4();
        r0.i("jyt_test", "before start call 1");
        r4.Q3().d(r4.H3());
        r0.i("jyt_test", "after start call 1");
        IAudioService r9 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r9 == null) goto L20;
        r9.b0();
        goto L20
    L15:
        Object r10 = BuildersKt.withContext(Dispatchers.getIO(), new RealtimeCoreComponent$startConnectInnerEnsureViewCreated$2(r4, null), r5);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r10;
    L19:
        return Unit.INSTANCE;
    }

    public static Unit h3(RealtimeCoreComponent r8, long r9) {
        DecimalFormat r0 = new DecimalFormat("00");
        long r1 = 60;
        String r2 = r8.getActivity().getString(2131898475) + ' ' + r0.format((r9 / r1) % r1) + ':' + r0.format(r9 % r1);
        com.larus.voicecall.impl.component.bottom.b r3 = r8.G3();
        if (r3 == null) goto L15;
        VoiceCallBottomLayout r4 = r3.BT();
        if (r4 == null) goto L15;
        Intrinsics.checkNotNullParameter(r2, "showText");
        com.larus.av_call.view.c r5 = r4.a;
        com.larus.av_call.view.c r6 = null;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r5 = null;
    L9:
        e1.x(r5.o());
        com.larus.av_call.view.c r7 = r4.a;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L13:
        r6.o().setText(r2);
        goto L15
    L12:
        r6 = r7;
    L15:
        if (r9 != 0) goto L20;
        t19.s.a.g(AppHost.a.getApplication(), 2131898478, false);
        com.larus.voicecall.impl.component.window.b r10 = (com.larus.voicecall.impl.component.window.b) r8.u.getValue();
        if (r10 == null) goto L20;
        r10.zg();
    L20:
        return Unit.INSTANCE;
    }

    public static Unit p3(final RealtimeCoreComponent r2, final byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.getActivity().runOnUiThread(new e0(r2, r3));
        return Unit.INSTANCE;
    }

    public static Unit z3(final RealtimeCoreComponent r2, final r58.d r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.getActivity().runOnUiThread(new f0(r2, r3));
        return Unit.INSTANCE;
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void RS(String r4, String r5) {
        RealtimeCallService r0 = Q3();
        RealtimeCallParam r1 = H3();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        r0.l().Y1(r1, r4, r5);
    }

    @Override // com.larus.voicecall.impl.component.core.a
    public final void xG(String r4, String r5) {
        RealtimeCallService r0 = Q3();
        RealtimeCallParam r1 = H3();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        r0.l().V0(r1, r4, r5);
    }

    public final void z2(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (Intrinsics.areEqual(r2, "OTHER_EVENT_RTC_ROOM_ID_GET") == false) goto L18;
        if (r3 != null) goto L6;
        return;
    L6:
        if ((r3 instanceof String) == false) goto L8;
        String r4 = (String) r3;
    L9:
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L20;
        e3a.b r6 = W3();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        ((h88.b) r6).c = r4;
        return;
    L20:
        return;
    L11:
        if (StringsKt.isBlank(r4) == true) goto L14;
        r5 = false;
        goto L15
    L8:
        r4 = null;
        goto L9
    }

    public static Unit m3(RealtimeCoreComponent r5, long r6, Boolean r8) {
        FLogger r0 = FLogger.a;
        r0.e("RealtimeCoreComponent", "IAudioService init states. hasInit=" + r8 + " appStart=" + AppHost.a.getAppStartTime() + " osDestroyed=" + r5.t);
        if (r8.booleanValue() == false) goto L18;
        if (r5.t == true) goto L18;
        IAudioService r1 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r1 == null) goto L11;
        LiveData r2 = r1.hasInit();
        if (r2 == null) goto L11;
        r2.removeObservers(r5.getActivity());
    L11:
        long r3 = SystemClock.elapsedRealtime() - r6;
        String r7 = "wait audio init cost:" + r3 + ",hasInit:" + r8;
        r0.i("RealtimeCoreComponent", r7);
        if (r3 <= 10) goto L14;
        yp9.d.b.a("RealtimeCoreComponent", r7);
    L14:
        Lazy r9 = c4a.i.a;
        c4a.i.b(r5.H3().k, r5.E3(), ((h88.b) r5.W3()).e);
        r5.a4();
        r0.i("jyt_test", "before start call 2");
        r5.Q3().d(r5.H3());
        r0.i("jyt_test", "after start call 2");
        IAudioService r10 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r10 == null) goto L18;
        r10.b0();
    L18:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.voicecall.impl.component.core.d0, java.lang.Object] */
    @Override // com.larus.voicecall.impl.component.core.a
    public final void tF(final String r8, boolean r9, final Function1<? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r8, "caller");
        if (r9 == true) goto L12;
        Pair<Boolean, Boolean> r11 = com.larus.voicecall.impl.l.i;
        if (com.larus.voicecall.impl.l.a.a(getActivity()) == false) goto L12;
        if (r10 == null) goto L8;
        r10.invoke(Boolean.TRUE);
    L8:
        Function1<? super String, Unit> r12 = this.M;
        if (r12 == null) goto L18;
        r12.invoke(r8);
        return;
    L18:
        return;
    L12:
        com.larus.voicecall.impl.l r13 = this.F;
        if (r13 == null) goto L19;
        ?? r0 = new d0(this, r10, r8);
        Intrinsics.checkNotNullParameter(r0, "callback");
        i2 r14 = i2.b;
        Fragment r1 = r13.a;
        ArrayList r2 = CollectionsKt.arrayListOf(new String[]{"android.permission.RECORD_AUDIO"});
        com.larus.voicecall.impl.n r3 = new com.larus.voicecall.impl.n(r0);
        JSONObject r5 = new JSONObject();
        r5.put("enter_method", "call");
        Unit r15 = Unit.INSTANCE;
        g1.a.a(r1, r2, r3, null, r5, 8);
        IRealtimeCallTracer r16 = r13.b;
        if (r16 == null) goto L20;
        r16.z(r13.c, r13.d, r13.e, r13.f);
        return;
    L20:
        return;
    }

    public final void o1(MajorState r3, int r4, MajorState r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "currentMajorState");
        Intrinsics.checkNotNullParameter(r5, "newMajorState");
        if (r6 != 2) goto L5;
    L22:
        RealtimeCallService r7 = Q3();
        RealtimeCallParam r8 = H3();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
    L24:
        if (r6 != 14) goto L26;
        return;
    L26:
        if (r4 == 15) goto L30;
        this.L = r6;
        return;
    L30:
        return;
    L5:
        if (r6 == 3) goto L22;
        if (r6 != 6) goto L24;
        MajorState.f r9 = Q3().h();
        if ((r9 instanceof MajorState.f) == true) goto L12;
    L14:
        com.larus.voicecall.impl.component.bottom.b r10 = G3();
        if (r10 == null) goto L24;
        VoiceCallBottomLayout r11 = r10.BT();
        if (r11 == null) goto L24;
        r11.p9(r11.v);
        com.larus.av_call.view.c r12 = r11.a;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r12 = null;
    L21:
        r12.o().setText(2131899692);
        goto L24
    L12:
        if (r9.d != 10) goto L14;
        t19.s.a.g(AppHost.a.getApplication(), 2131910634, false);
        goto L14
    }
}
