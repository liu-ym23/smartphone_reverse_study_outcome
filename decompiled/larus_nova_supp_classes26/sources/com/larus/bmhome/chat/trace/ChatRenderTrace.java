package com.larus.bmhome.chat.trace;

import android.os.Bundle;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageRenderCompleteRequest;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.OmniSDKHelper;
import com.larus.im.internal.jni.callback.NativeIMCallback;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.internal.legacy.y3;
import com.larus.im.internal.legacy.z3;
import com.larus.im.internal.tracking.TypeWriterRecorder;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0016J\u001e\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00192\u0006\u0010/\u001a\u00020\u000eH\u0016J \u00102\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000eH\u0016J&\u00105\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001cH\u0016J&\u00107\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001cH\u0016J\u0018\u00108\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0016J \u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u001c2\u0006\u0010/\u001a\u00020\u000eH\u0016J \u0010;\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000eH\u0016J\u001e\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00192\u0006\u0010/\u001a\u00020\u000eH\u0016J\u0006\u0010?\u001a\u00020.J\u0006\u0010@\u001a\u00020.J\u0006\u0010A\u001a\u00020.J\u0006\u0010B\u001a\u00020.J\u0006\u0010C\u001a\u00020.J\u0010\u0010D\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0016J\u0018\u0010E\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0016J\u0010\u0010F\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0016J\u001e\u0010G\u001a\u00020.2\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001cH\u0016J\u0018\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u001cH\u0016J\b\u0010J\u001a\u00020.H\u0016J\u0010\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0016JA\u0010N\u001a\u00020O*\u00020M2.\u0010P\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010R0\u00190Q\"\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010R0\u0019H\u0002¢\u0006\u0002\u0010SJ\u000e\u0010T\u001a\u00020.2\u0006\u0010L\u001a\u00020MJ\u0016\u0010U\u001a\u00020.2\u0006\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u000eJ\u0010\u0010X\u001a\u00020.2\u0006\u0010Y\u001a\u00020\u000eH\u0016J(\u0010Z\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u000eH\u0016J&\u0010^\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\u000eJ$\u0010a\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020\u000eH\u0016J\"\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020\u000eJ\u0006\u0010c\u001a\u00020.J\u0006\u0010d\u001a\u00020.J\b\u0010e\u001a\u00020.H\u0016J\u0010\u0010f\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010g\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010h\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010i\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010j\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010k\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010l\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010m\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010n\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010o\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010p\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0012\u0010q\u001a\u00020\u00052\b\u0010r\u001a\u0004\u0018\u00010\u000eH\u0002Js\u0010t\u001a\u00020.2\u0006\u0010u\u001a\u00020\u00052\u0006\u0010v\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u00052\u0006\u0010y\u001a\u00020\u00052\u0006\u0010z\u001a\u00020\u00052\b\u0010{\u001a\u0004\u0018\u00010\u000e2\b\u0010|\u001a\u0004\u0018\u00010\u000e2\b\u0010}\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u007f2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f¢\u0006\u0003\u0010\u0081\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001c0\rX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001d\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001f\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u001e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001c\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+R\u0010\u0010s\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lcom/larus/bmhome/chat/trace/ChatRenderTrace;", "Lcom/larus/platform/spi/IAIChatRenderTraceService;", "<init>", "()V", "CHARACTER_TYPE_SINGLE", "", "CHARACTER_TYPE_MULTI", "CHARACTER_TYPE_MIXED", "DEFAULT_RENDER_STUCK_INTERVAL", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "replyMap", "", "", "replyEndMap", "messageMap", "lastRenderTime", "audioMap", "templatePromptMap", "autoFillPromptMap", "renderTimes", "hangTask", "Lkotlinx/coroutines/Job;", "creationInfoMap", "Lkotlin/Pair;", "templateInfoMap", "sendMessageTrackExtMap", "", "actionbarRecommendInfoMap", "Lkotlin/Triple;", "actionbarOptionInfoMap", "latestReportedRenderTokens", "Ljava/util/concurrent/ConcurrentHashMap;", "deepThinkOptimizeConfig", "Lcom/larus/platform/model/chat/DeepThinkOptimizeConfig;", "getDeepThinkOptimizeConfig", "()Lcom/larus/platform/model/chat/DeepThinkOptimizeConfig;", "deepThinkOptimizeConfig$delegate", "Lkotlin/Lazy;", "springTraceDataMap", "messageRenderHangInterval", "getMessageRenderHangInterval", "()J", "messageRenderHangInterval$delegate", "setTemplatePromptString", "", "cvsId", "string", "getCreationInfo", "setCreationInfo", "creationId", "creationType", "setSendMessageTrackExtMap", "sendMessageTrackMap", "updateSendMessageTrackExtMap", "removeSendMessageTrackExtMap", "key", "getSendMessageTrackExtMap", "setTemplateInfo", "templateId", "templateType", "getTemplateInfo", "resetTemplateInfo", "resetCreationInfo", "resetSendMessageTrackMap", "resetTemplatePromptString", "resetAutoFillPromptString", "getTemplatePromptString", "setAutoFillPromptString", "getAutoFillPromptString", "setSpringTraceDataMap", "traceDataMap", "getSpringTraceDataMap", "clearSpringTraceDataMap", "onRender", "data", "Lcom/larus/im/bean/message/Message;", "trackBundleOf", "Landroid/os/Bundle;", "pairs", "", "", "(Lcom/larus/im/bean/message/Message;[Lkotlin/Pair;)Landroid/os/Bundle;", "reportMessageRenderCompleteIfNeeded", "markReplyEnd", "questionId", "endMessageId", "onReceiveAudioData", "taskId", "setActionbarRecommendInfo", "actionBarItemId", "recommendRequestID", "actionbarRecommendFrom", "setActionbarOptionInfo", "actionbarOptionId", "actionbarOptionText", "getActionbarRecommendInfo", "getActionbarOptionInfo", "resetActionRecommendInfo", "resetActionbarOptionInfo", "clear", "handleMessageRender", "handleReplyRender", "onMessageRenderBegin", "onMessageRender", "onMessageRenderFinish", "checkMessageRenderStuck", "onSendMessageRender", "onAudioMessageRender", "onReplyRenderBegin", "onReplyRenderFinish", "onReplyRenderFinishWithSuggest", "getCharacterType", "content", "lastMessageId", "onScrollAbnormalState", "scrollRange", "scrollOffset", "viewPortHeight", "scrollYDistance", "anchorViewTop", "anchorPosition", "messageId", "conversationId", "contentType", "isSmoothOpt", "", "isAbnormalScroll", "(IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRenderTrace implements IAIChatRenderTraceService {
    public static final ChatRenderTrace b = null;
    public static final CoroutineScope c = null;
    public static final Map<String, Long> d = null;
    public static final Map<String, String> e = null;
    public static final Map<String, Long> f = null;
    public static final Map<String, Long> g = null;
    public static final Map<String, Long> h = null;
    public static final Map<String, String> i = null;
    public static final Map<String, String> j = null;
    public static final Map<String, Integer> k = null;
    public static final Map<String, Job> l = null;
    public static final Map<String, Pair<String, String>> m = null;
    public static final Map<String, Pair<String, String>> n = null;
    public static final Map<String, Map<String, String>> o = null;
    public static final Map<String, Triple<Long, String, String>> p = null;
    public static final Map<String, Triple<Long, Long, String>> q = null;
    public static final ConcurrentHashMap<String, String> r = null;
    public static final Lazy s = null;
    public static final ConcurrentHashMap<String, String> t = null;
    public static final Lazy u = null;

    public static final class a implements IIMCallback<Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            ChatRenderTrace.r.remove(this.a, this.b);
        }

        public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            ((Boolean) r1).booleanValue();
        }

        public a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    private ChatRenderTrace() {
    }

    static {
        b = new ChatRenderTrace();
        c = CoroutineScopeKt.MainScope();
        d = new LinkedHashMap();
        e = new LinkedHashMap();
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        h = new LinkedHashMap();
        i = new LinkedHashMap();
        j = new LinkedHashMap();
        k = new LinkedHashMap();
        l = new LinkedHashMap();
        m = new LinkedHashMap();
        n = new LinkedHashMap();
        o = new LinkedHashMap();
        p = new LinkedHashMap();
        q = new LinkedHashMap();
        r = new ConcurrentHashMap();
        s = LazyKt.lazy(new x());
        t = new ConcurrentHashMap();
        u = LazyKt.lazy(new y());
    }

    public final void l() {
        t.clear();
    }

    public final Map<String, String> i() {
        return t;
    }

    public static Triple a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "cvsId");
        return (Triple) ((LinkedHashMap) p).get(r1);
    }

    public static int b(String r7) {
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return -1;
    L9:
        int r1 = 0;
        int r3 = 0;
    L11:
        if (r1 >= r7.length()) goto L19;
        if (String.valueOf(r7.charAt(r1)).getBytes(Charsets.UTF_8).length != 1) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        r3 = r3 + 1;
    L18:
        r1 = r1 + 1;
        goto L11
    L15:
        r4 = false;
        goto L16
    L19:
        double r5 = (((double) r3) * 1.0d) / ((double) r7.length());
        if (r5 < 0.9d) goto L23;
        return 0;
    L23:
        if (r5 <= 0.1d) goto L25;
        return 2;
    L25:
        return 1;
    L5:
        r0 = false;
        goto L6
    }

    public static void o(Message r11) {
        if (r11.getContentType() != 1) goto L5;
    L7:
        Integer r0 = (Integer) ((LinkedHashMap) k).get(r11.getMessageId());
        if (r0 == null) goto L10;
        int r1 = r0.intValue();
    L11:
        String r3 = "";
        if (r1 == 1) goto L16;
        if ((r1 % 100) == 0) goto L16;
    L44:
        Map<String, Job> r2 = l;
        Job r5 = (Job) TypeIntrinsics.asMutableMap(r2).remove(r11.getMessageId());
        if (r5 == null) goto L48;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L48:
        if (r11.getMessageStatusLocal() != 20) goto L50;
    L51:
        String r4 = r11.getMessageId();
        if (r4 == null) goto L55;
        r3 = r4;
    L55:
        r2.put(r3, BuildersKt.launch$default(c, null, null, new ChatRenderTrace$onMessageRender$1(r11, r1, null), 3, null));
        return;
    L50:
        if (com.larus.bmhome.chat.bean.d.Q0(r11) == true) goto L51;
        return;
    L16:
        if (com.larus.im.bean.message.a.b0(r11) == false) goto L18;
        String r6 = com.larus.im.bean.message.a.e(r11);
    L21:
        com.larus.platform.service.o r7 = com.larus.platform.service.o.a;
        Pair[] r8 = new Pair[10];
        r8[0] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r11.getMessageId());
        r8[1] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r11.getConversationId());
        r8[2] = TuplesKt.to("is_onboarding", Integer.valueOf(com.larus.bmhome.chat.bean.d.z0(r11) ? 1 : 0));
        BotInfoCache r9 = BotInfoCache.INSTANCE;
        String r10 = r11.getConversationId();
        if (r10 != null) goto L24;
        r10 = "";
    L24:
        r8[3] = TuplesKt.to("bot_id", r9.getBotId(r10));
        String r12 = r11.getConversationId();
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        r8[4] = TuplesKt.to("model_type", Long.valueOf(r9.getModelType(r12)));
        r8[5] = TuplesKt.to("character_count", Integer.valueOf(r6.length()));
        r8[6] = TuplesKt.to("character_type", Integer.valueOf(b(r6)));
        r8[7] = TuplesKt.to("render_times", Integer.valueOf(r1));
        Map r13 = r11.getExt();
        if (r13 == null) goto L30;
        String r14 = (String) r13.get("general_agent");
    L31:
        String r15 = "1";
        if (Intrinsics.areEqual(r14, "1") == false) goto L34;
        Object r16 = "1";
    L35:
        r8[8] = TuplesKt.to("general_agent", r16);
        Map r17 = r11.getExt();
        if (r17 == null) goto L38;
        String r18 = (String) r17.get("is_async_task");
    L40:
        if (Intrinsics.areEqual(r18, "1") == true) goto L43;
        r15 = TriggerSendLoading.NO_LOADING;
    L43:
        r8[9] = TuplesKt.to("is_async_task", r15);
        r7.b("stream_message_render", r(r11, r8));
        goto L44
    L38:
        r18 = null;
        goto L40
    L34:
        r16 = TriggerSendLoading.NO_LOADING;
        goto L35
    L30:
        r14 = null;
        goto L31
    L18:
        r6 = com.larus.im.bean.message.a.O(r11);
        if (r6 != null) goto L21;
        r6 = "";
        goto L21
    L10:
        r1 = 0;
        goto L11
    L5:
        if (r11.getContentType() == 9999) goto L7;
    }

    public static void p(Message r26) {
        Intrinsics.checkNotNullParameter(r26, "data");
        String r0 = r26.getMessageId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Map<String, Integer> r2 = k;
        Integer r3 = (Integer) ((LinkedHashMap) r2).get(r26.getMessageId());
        if (r3 == null) goto L14;
        int r4 = r3.intValue();
    L15:
        String r5 = r26.getMessageId();
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r2.put(r5, Integer.valueOf(r4 + 1));
        String r14 = "duration";
        if (com.larus.bmhome.chat.bean.d.H0(r26) == false) goto L34;
        Map<String, Long> r6 = h;
        if (r6.containsKey(r26.getMessageId()) == false) goto L42;
        int r7 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r26, "message");
        String r8 = com.larus.im.bean.message.a.K(r26);
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == true) goto L42;
        long r10 = AppHost.a.getAppClock().currentTimeMillis();
        Long r11 = (Long) TypeIntrinsics.asMutableMap(r6).remove(r26.getMessageId());
        if (r11 == null) goto L42;
        com.larus.platform.service.o.a.b("audio_data_to_render", com.larus.utils.f.c(new Pair[]{TuplesKt.to("duration", Long.valueOf(r10 - r11.longValue())), TuplesKt.to("taskId", r26.getMessageId())}));
        goto L42
    L25:
        if (r8.length() == 0) goto L28;
        r9 = false;
    L42:
        String r25 = "";
        r14 = "duration";
    L226:
        String r12 = r26.getReplyId();
        if (r12 != null) goto L229;
    L232:
        boolean r13 = true;
    L233:
        if (r13 == true) goto L310;
        Map<String, Long> r15 = d;
        boolean r16 = r15.containsKey(r26.getReplyId());
        MessageStatus r17 = r26.getMessageStatus();
        MessageStatus r18 = MessageStatus.MessageStatus_AVAILABLE;
        if (r17 == r18) goto L238;
    L240:
        boolean r19 = false;
    L242:
        if (r26.getMessageStatus() == r18) goto L244;
    L246:
        boolean r20 = false;
    L248:
        if (r26.getContentType() != 2) goto L250;
        boolean r110 = true;
    L251:
        Map<String, String> r21 = e;
        if (Intrinsics.areEqual(((LinkedHashMap) r21).get(r26.getReplyId()), r26.getMessageId()) == true) goto L254;
    L256:
        boolean r22 = false;
    L257:
        if (r16 == true) goto L278;
        if (r19 == false) goto L278;
        String r23 = r26.getReplyId();
        if (r23 != null) goto L262;
    L265:
        boolean r24 = true;
    L266:
        if (r24 == false) goto L268;
        return;
    L268:
        if (com.larus.bmhome.chat.bean.d.r0(r26) == true) goto L311;
        String r27 = r26.getReplyId();
        if (r27 != null) goto L273;
        r27 = r25;
    L273:
        AppHost.Companion r28 = AppHost.a;
        r15.put(r27, Long.valueOf(r28.getAppClock().currentTimeMillis()));
        String r29 = r26.getMessageId();
        if (r29 != null) goto L276;
        String r111 = r25;
    L277:
        r15.put(r111, Long.valueOf(r28.getAppClock().currentTimeMillis()));
        return;
    L276:
        r111 = r29;
        goto L277
    L311:
        return;
    L262:
        if (r23.length() == 0) goto L265;
        r24 = false;
    L278:
        if (r20 == false) goto L304;
        if (r16 == true) goto L281;
        return;
    L281:
        if (r22 == false) goto L294;
        String r30 = r26.getReplyId();
        if (r30 != null) goto L285;
    L288:
        boolean r31 = true;
    L289:
        if (r31 == true) goto L312;
        long r32 = AppHost.a.getAppClock().currentTimeMillis();
        Long r33 = (Long) TypeIntrinsics.asMutableMap(r15).remove(r26.getReplyId());
        if (r33 == null) goto L306;
        long r34 = r32 - r33.longValue();
        TypeIntrinsics.asMutableMap(r21).remove(r26.getReplyId());
        com.larus.platform.service.o.a.b("message_all_render_finish", com.larus.utils.f.c(new Pair[]{TuplesKt.to(r14, Long.valueOf(r34)), TuplesKt.to("reply_id", r26.getReplyId())}));
        return;
    L306:
        return;
    L312:
        return;
    L285:
        if (r30.length() == 0) goto L288;
        r31 = false;
        goto L289
    L294:
        String r35 = r14;
        if (r110 == false) goto L308;
        long r36 = AppHost.a.getAppClock().currentTimeMillis();
        Long r37 = (Long) TypeIntrinsics.asMutableMap(r15).remove(r26.getReplyId());
        if (r37 == null) goto L309;
        com.larus.platform.service.o.a.b("message_all_render_finish_suggest", com.larus.utils.f.c(new Pair[]{TuplesKt.to(r35, Long.valueOf(r36 - r37.longValue())), TuplesKt.to("reply_id", r26.getReplyId())}));
        return;
    L309:
        return;
    L308:
        return;
    L304:
        return;
    L254:
        if (com.larus.bmhome.chat.bean.d.Q0(r26) == true) goto L256;
        r22 = true;
        goto L257
    L250:
        r110 = false;
        goto L251
    L244:
        if (r26.getMessageStatusLocal() != 21) goto L246;
        r20 = true;
        goto L248
    L238:
        if (r26.getMessageStatusLocal() != 20) goto L240;
        r19 = true;
        goto L242
    L310:
        return;
    L229:
        if (r12.length() == 0) goto L232;
        r13 = false;
        goto L233
    L34:
        String r38 = r26.getReplyId();
        if (r38 != null) goto L37;
    L40:
        boolean r39 = true;
    L41:
        if (r39 == true) goto L42;
        Map<String, Long> r40 = f;
        boolean r41 = r40.containsKey(r26.getMessageId());
        MessageStatus r42 = r26.getMessageStatus();
        MessageStatus r43 = MessageStatus.MessageStatus_AVAILABLE;
        if (r42 == r43) goto L46;
    L48:
        boolean r44 = false;
    L50:
        if (r26.getMessageStatus() == r43) goto L52;
    L60:
        boolean r45 = false;
    L62:
        if (r41 == true) goto L81;
        if (r44 == false) goto L81;
        String r46 = r26.getMessageId();
        if (r46 != null) goto L67;
    L70:
        boolean r47 = true;
    L71:
        if (r47 == false) goto L73;
    L207:
        r44 = r44;
        r25 = "";
        r14 = "duration";
    L208:
        if (r44 == true) goto L212;
        if (com.larus.bmhome.chat.bean.d.Q0(r26) == false) goto L226;
    L212:
        if (r26.getContentType() != 1) goto L214;
    L216:
        Map<String, Long> r48 = g;
        Long r49 = (Long) ((LinkedHashMap) r48).get(r26.getMessageId());
        long r50 = AppHost.a.getAppClock().currentTimeMillis();
        if (r49 != null) goto L219;
    L221:
        Long r51 = Long.valueOf(r50);
        String r52 = r26.getMessageId();
        if (r52 != null) goto L224;
        r52 = r25;
    L224:
        r48.put(r52, r51);
    L225:
        o(r26);
        goto L226
    L219:
        if ((r50 - r49.longValue()) <= 1000) goto L221;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ChatRenderTrace$checkMessageRenderStuck$1(r26, r50, r49, null), 3, null);
        goto L221
    L214:
        if (r26.getContentType() == 9999) goto L216;
    L73:
        if (com.larus.bmhome.chat.bean.d.r0(r26) == true) goto L207;
        if (com.larus.im.bean.message.a.r0(r26) == true) goto L207;
        String r53 = r26.getMessageId();
        if (r53 != null) goto L80;
        r53 = "";
    L80:
        r40.put(r53, Long.valueOf(AppHost.a.getAppClock().currentTimeMillis()));
        goto L207
    L67:
        if (r46.length() == 0) goto L70;
        r47 = false;
    L81:
        if (r41 == false) goto L207;
        if (r45 == false) goto L207;
        long r112 = AppHost.a.getAppClock().currentTimeMillis();
        Long r54 = (Long) TypeIntrinsics.asMutableMap(r40).remove(r26.getMessageId());
        if (r54 == null) goto L205;
        long r113 = r112 - r54.longValue();
        if (r26.getContentType() == 1) goto L90;
        if (r26.getContentType() != 9999) goto L205;
    L90:
        if (com.larus.im.bean.message.a.b0(r26) == false) goto L92;
        String r55 = com.larus.im.bean.message.a.e(r26);
    L95:
        com.larus.platform.service.o r56 = com.larus.platform.service.o.a;
        Pair[] r114 = new Pair[7];
        r114[0] = TuplesKt.to("duration", Long.valueOf(r113));
        r114[1] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r26.getMessageId());
        r114[2] = TuplesKt.to("character_count", Integer.valueOf(r55.length()));
        r114[3] = TuplesKt.to("character_type", Integer.valueOf(b(r55)));
        r114[4] = TuplesKt.to("render_times", ((LinkedHashMap) r2).get(r26.getMessageId()));
        Map r57 = r26.getExt();
        String r210 = null;
        if (r57 == null) goto L98;
        String r58 = (String) r57.get("general_agent");
    L99:
        String r59 = "1";
        if (Intrinsics.areEqual(r58, "1") == false) goto L102;
        Object r60 = "1";
    L103:
        r114[5] = TuplesKt.to("general_agent", r60);
        Map r61 = r26.getExt();
        if (r61 == null) goto L106;
        String r62 = (String) r61.get("is_async_task");
    L108:
        if (Intrinsics.areEqual(r62, "1") == true) goto L111;
        r59 = TriggerSendLoading.NO_LOADING;
    L111:
        r114[6] = TuplesKt.to("is_async_task", r59);
        r56.b("message_render_finish", r(r26, r114));
        Map r63 = r26.getExt();
        if (r63 == null) goto L123;
        String r64 = (String) r63.get("bot_state");
        if (r64 == null) goto L123;
        if (r64.length() <= 0) goto L118;
        boolean r65 = true;
    L119:
        if (r65 == true) goto L122;
        r64 = null;
    L122:
        if (r64 == null) goto L123;
    L300:
        String r66 = new JSONObject(r64).optString("agent_id", "");     // Catch: Exception -> L126
    L128:
        Map r67 = r26.getExt();
        if (r67 == null) goto L131;
        String r68 = (String) r67.get("tea_tags_time_cost");
    L132:
        Map r69 = r26.getExt();
        if (r69 == null) goto L136;
        String r70 = (String) r69.get("intention");
        if (r70 == null) goto L136;
    L137:
        if (r68 != null) goto L139;
    L142:
        boolean r211 = true;
    L143:
        if (r211 == false) goto L145;
        Map r71 = new LinkedHashMap();
    L146:
        int r72 = r55.length();
        Map r73 = r26.getExt();
        r25 = "";
        if (r73 == null) goto L153;
        String r74 = (String) r73.get("answer_statistic_chars");
        if (r74 == null) goto L153;
        Integer r75 = StringsKt.toIntOrNull(r74);
        if (r75 == null) goto L153;
        int r76 = r75.intValue();
    L154:
        Pair[] r115 = new Pair[22];
        r115[0] = TuplesKt.to("duration", Long.valueOf(r113));
        r115[1] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r26.getMessageId());
        LruCache<String, CommonParamManager.CommonParam> r77 = CommonParamManager.a;
        CommonParamManager.CommonParam r78 = CommonParamManager.c(r26.getMessageId());
        if (r78 == null) goto L157;
        String r79 = r78.getScene();
    L158:
        r115[2] = TuplesKt.to("scene", r79);
        r115[3] = TuplesKt.to("content_type", Integer.valueOf(r26.getContentType()));
        ChatControlTrace r80 = ChatControlTrace.b;
        r80.getClass();
        LruCache<String, wc9.e> r116 = ChatControlTrace.o;
        String r117 = r26.getConversationId();
        if (r117 != null) goto L161;
        String r118 = r25;
    L162:
        wc9.e r119 = (wc9.e) r116.get(r118);
        if (r119 == null) goto L165;
        String r120 = ic8.n.f(r119);
    L166:
        r115[4] = TuplesKt.to("chat_type", r120);
        r115[5] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r26.getConversationId());
        r115[6] = TuplesKt.to("is_onboarding", Integer.valueOf(com.larus.bmhome.chat.bean.d.z0(r26) ? 1 : 0));
        BotInfoCache r121 = BotInfoCache.INSTANCE;
        String r122 = r26.getConversationId();
        if (r122 != null) goto L169;
        r122 = r25;
    L169:
        Map r123 = r71;
        r115[7] = TuplesKt.to("bot_id", r121.getBotId(r122));
        String r81 = r26.getConversationId();
        if (r81 != null) goto L172;
        r81 = r25;
    L172:
        r115[8] = TuplesKt.to("model_type", Long.valueOf(r121.getModelType(r81)));
        r115[9] = TuplesKt.to("character_count", Integer.valueOf(r72));
        r115[10] = TuplesKt.to("character_type", Integer.valueOf(b(r55)));
        r115[11] = TuplesKt.to("render_times", ((LinkedHashMap) k).get(r26.getMessageId()));
        if (r26.getMessageStatusLocal() != 23) goto L175;
    L178:
        int r82 = 1;
    L179:
        r115[12] = TuplesKt.to("is_interrupted", Integer.valueOf(r82));
        if (r26.getMessageStatusLocal() != 21) goto L182;
        String r83 = "finished";
    L183:
        r115[13] = TuplesKt.to("result", r83);
        r115[14] = TuplesKt.to("agent_id", r66);
        Map r84 = r26.getExt();
        if (r84 == null) goto L186;
        String r85 = (String) r84.get("intention");
    L187:
        r115[15] = TuplesKt.to("intention", r85);
        Map r86 = r26.getExt();
        if (r86 == null) goto L190;
        r210 = (String) r86.get("llm_model_type");
    L190:
        r115[16] = TuplesKt.to("llmModelType", r210);
        r115[17] = TuplesKt.to("server_count", Integer.valueOf(r76));
        r115[18] = TuplesKt.to("intention", r70);
        r115[19] = TuplesKt.to("replied_message_id", r26.getReplyId());
        r115[20] = TuplesKt.to("local_message_id", r26.getLocalMessageId());
        com.larus.bmhome.chat.trace.a r87 = r80.gc(ChatControlTrace.y);
        if (r87 == null) goto L194;
        String r88 = r87.j;
        if (r88 == null) goto L194;
    L195:
        r115[21] = TuplesKt.to("current_page", r88);
        Bundle r89 = r(r26, r115);
        if ((!r123.isEmpty()) == false) goto L198;
        com.larus.utils.f.a(r89, r123);
    L198:
        int r90 = com.larus.im.d.a;
        com.larus.im.internal.stream.b r91 = com.larus.im.internal.stream.b.a;
        String r92 = r26.getMessageId();
        if (r92 != null) goto L201;
        r92 = r25;
    L201:
        Intrinsics.checkNotNullParameter(r92, "msgId");
        TypeWriterRecorder.a.getClass();
        Map r93 = TypeWriterRecorder.e(r92);
        if (r93 == null) goto L204;
        com.larus.utils.f.a(r89, r93);
    L204:
        com.larus.platform.service.o.a.b("stream_message_render_finished", r89);
    L206:
        o(r26);
    L194:
        r88 = "chat";
        goto L195
    L186:
        r85 = null;
        goto L187
    L182:
        r83 = "failed";
        goto L183
    L175:
        if (r26.getMessageStatusLocal() == 13) goto L178;
        r82 = 0;
        goto L179
    L165:
        r120 = null;
        goto L166
    L161:
        r118 = r117;
        goto L162
    L157:
        r79 = null;
    L153:
        r76 = 0;
        goto L154
    L145:
        r71 = com.larus.bmhome.chat.trace.appreciable.z.a(r68, "ChatRenderTrace#onMessageRenderFinish");
        goto L146
    L139:
        if (r68.length() == 0) goto L142;
        r211 = false;
    L136:
        r70 = "default";
        goto L137
    L131:
        r68 = null;
    L126:
        e = move-exception;
        FLogger.a.e("ChatRenderTrace", "Failed to parse agent_id from bot_state", e);
        r66 = "";
        goto L128
    L118:
        r65 = false;
    L123:
        r64 = "{}";
        goto L300
    L106:
        r62 = null;
        goto L108
    L102:
        r60 = TriggerSendLoading.NO_LOADING;
        goto L103
    L98:
        r58 = null;
        goto L99
    L92:
        r55 = com.larus.im.bean.message.a.O(r26);
        if (r55 != null) goto L95;
        r55 = "";
    L205:
        r25 = "";
        goto L206
    L52:
        if (r26.getMessageStatusLocal() == 21) goto L58;
        if (r26.getMessageStatusLocal() == 23) goto L58;
        if (r26.getMessageStatusLocal() != 22) goto L60;
    L58:
        if (com.larus.bmhome.chat.bean.d.Q0(r26) == true) goto L60;
        r45 = true;
        goto L62
    L46:
        if (r26.getMessageStatusLocal() != 20) goto L48;
        r44 = true;
        goto L50
    L37:
        if (r38.length() == 0) goto L40;
        r39 = false;
        goto L41
    L14:
        r4 = 0;
        goto L15
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static void q(Message r17) {
        Intrinsics.checkNotNullParameter(r17, "data");
        String r0 = r17.getMessageId();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L48;
        String r3 = com.larus.im.bean.message.a.F(r17);
        if (r3 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r.put(r0, r3), r3) == false) goto L20;
        return;
    L20:
        String r6 = r17.getReplyId();
        ChatMessageCostTrace.a.getClass();
        boolean r7 = ChatMessageCostTrace.a(r6);
        CommonParamManager.CommonParam r8 = CommonParamManager.c(r6);
        if (r8 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("reportMessageRenderComplete messageId=");
        r11.append(r0);
        r11.append(" sendMsgId=");
        r11.append(r6);
        r11.append(" status=");
        r11.append(r17.getMessageStatusLocal());
        r11.append(" renderToken=");
        r11.append(r3);
        r11.append(" perfMark=");
        Map r1 = r17.getBusinessExt();
        if (r1 == null) goto L29;
        String r4 = (String) r1.get("current_perf_mark");
    L30:
        r11.append(r4);
        r11.append(" bizTrackContextValid=");
        r11.append(r7);
        r11.append(" hasEnterBackground=");
        r11.append(r9);
        r10.i("ChatMessageCostTrace", r11.toString());
        NativeMessageServiceImpl r5 = com.larus.im.d.e();
        long r12 = System.currentTimeMillis();
        Pair[] r13 = new Pair[2];
        String r14 = "1";
        if (r7 == false) goto L33;
        Object r15 = "1";
    L34:
        r13[0] = TuplesKt.to("biz_track_context_valid", r15);
        if (r9 == true) goto L38;
        r14 = TriggerSendLoading.NO_LOADING;
    L38:
        r13[1] = TuplesKt.to("has_enter_background", r14);
        Map r16 = MapsKt.mapOf(r13);
        TypeWriterRecorder.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "msgId");
        TypeWriterRecorder.d r18 = (TypeWriterRecorder.d) TypeWriterRecorder.d.get(r0);
        if (r18 != null) goto L41;
        Map r19 = MapsKt.emptyMap();
    L45:
        MessageRenderCompleteRequest r20 = new MessageRenderCompleteRequest(r3, r12, MapsKt.plus(r16, r19));
        a r21 = new a(r0, r3);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r20, "request");
        OmniSDKHelper.getOmniSDK$default(OmniSDKHelper.INSTANCE, NativeMessageServiceImpl.r(), false, 2, null).withMessageService(new z3(r20, new NativeIMCallback("reportMessageRenderComplete", "timestamp:" + r20.getRenderCompleteTimestamp() + ",tagKeys:" + r20.getTags().keySet(), r21, new y3())));
        return;
    L41:
        long r110 = r18.h;
        if (r110 > 0) goto L44;
        r19 = MapsKt.emptyMap();
        goto L45
    L44:
        r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to("typewriter_callback_timestamp_ms", String.valueOf(r110)), TuplesKt.to("loading_delay_blocking_duration", String.valueOf(r18.D)), TuplesKt.to("render_path", "typewriter")});
        goto L45
    L33:
        r15 = TriggerSendLoading.NO_LOADING;
        goto L34
    L29:
        r4 = null;
        goto L30
    L23:
        if (r8.getHasEnterBackground() != true) goto L25;
        r9 = true;
        goto L26
    L48:
        return;
    L7:
        r2 = false;
        goto L9
    }

    public final Map<String, String> d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        return (Map) ((LinkedHashMap) o).get(r2);
    }

    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        String r3 = (String) ((LinkedHashMap) i).get(r2);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public final void h(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "traceDataMap");
        ConcurrentHashMap<String, String> r0 = t;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<String, String> r2 = r6.next();
        if (r2.getKey() != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r1.put(r2.getKey(), r2.getValue());
        goto L4
    L8:
        if (r2.getValue() == null) goto L10;
        r3 = true;
        goto L11
    L13:
        r0.putAll(r1);
    }

    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        h.put(r4, Long.valueOf(AppHost.a.getAppClock().currentTimeMillis()));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final String k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        String r3 = (String) ((LinkedHashMap) j).get(r2);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public static Bundle r(Message r4, Pair... r5) {
        Bundle r1 = com.larus.utils.f.c(new Pair[0]);
        com.larus.utils.f.a(r1, com.larus.im.bean.message.a.U(r4));
        Map r6 = MapsKt.mapOf((Pair[]) Arrays.copyOf(r5, r5.length));
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r8.next();
        if (r2.getValue() == null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r7.put(r2.getKey(), r2.getValue());
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        com.larus.utils.f.a(r1, r7);
        return r1;
    }

    public final void c(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "sendMessageTrackMap");
        o.put(r2, r3);
    }

    public final void e(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        Intrinsics.checkNotNullParameter(r4, "sendMessageTrackMap");
        Map<String, Map<String, String>> r0 = o;
        Map r1 = (Map) ((LinkedHashMap) r0).get(r3);
        if (r1 == null) goto L5;
        Map<String, String> r2 = MapsKt.toMutableMap(r1);
    L6:
        if (r2 == null) goto L8;
        r2.putAll(r4);
    L8:
        if (r2 == null) goto L11;
        r4 = r2;
    L11:
        r0.put(r3, r4);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "string");
        i.put(r2, r3);
    }

    public final void m(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "string");
        j.put(r2, r3);
    }

    public final void n(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        Intrinsics.checkNotNullParameter(r4, "key");
        Map<String, Map<String, String>> r0 = o;
        Map r1 = (Map) ((LinkedHashMap) r0).get(r3);
        if (r1 == null) goto L9;
        Map<String, String> r2 = MapsKt.toMutableMap(r1);
        if (r2 == null) goto L10;
        r2.remove(r4);
        r0.put(r3, r2);
        return;
    L10:
        return;
    }
}
