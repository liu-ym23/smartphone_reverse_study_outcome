package com.larus.bmhome.chat.trace;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatTtsPlayTraceService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010)\u001a\u00020*2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\tH\u0016J.\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J*\u00101\u001a\u00020*2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u00102\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0018\u00010\u000bH\u0016J\u0018\u00103\u001a\u00020*2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0016J\u0018\u00104\u001a\u00020*2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000bH\u0016JB\u00106\u001a\u00020*2\u0006\u0010-\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\b\u00108\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0016J\u001e\u0010;\u001a\u00020*2\b\u0010<\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001bH\u0002J\u001a\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u001bH\u0002J\u0018\u0010@\u001a\u0004\u0018\u00010\r2\u0006\u0010<\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010AJ\u0018\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010AJ\b\u0010E\u001a\u00020\u001fH\u0002J \u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010JJ\u0012\u0010K\u001a\u00020*2\b\u0010L\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010M\u001a\u00020*H\u0002J\b\u0010N\u001a\u00020*H\u0002J\b\u0010O\u001a\u00020*H\u0002J\u0010\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020\rH\u0002J\u0018\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/larus/bmhome/chat/trace/ChatTTSPlayTrace;", "Lcom/larus/platform/spi/IAIChatTtsPlayTraceService;", "<init>", "()V", "TAG", "", "iTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "chatMessageAdapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "socialMessageGetter", "Lkotlin/Function0;", "", "Lcom/larus/im/bean/message/Message;", "currentTaskId", "currentPlayMessageID", "value", "endMethod", "setEndMethod", "(Ljava/lang/String;)V", "startMethod", "setStartMethod", "startPlayTime", "", "endPlayTime", "chatTypeGetter", "extraCommonParams", "Lorg/json/JSONObject;", "voiceID", "toTtsSpeakerId", "haveStartPlay", "", "currentPlayChatMessage", "setCurrentPlayChatMessage", "(Lcom/larus/im/bean/message/Message;)V", "currentPlaySocialMessage", "intentionDialectSet", "", "ttsDialectSet", "trackChatMessageInvoker", "traceSocialMessageInvoker", "bindPageMessageListSource", "", "adapter", "onSentenceStart", "taskId", "sentenceTxt", "sentenceInst", "sentenceRes", "bindSocialMessageListSource", "getter", "setChatTypeFetcher", "setExtraCommonParams", "commonParamsGetter", "startTTS", "startTTSReason", "messageID", "ttsSpeaker", "traceInfo", "mobTTSStart", "msgId", "mobFailedReportTtsStart", "reason", "js", "findMessage", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findConv", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "needSendFinishTTS", "findBot", "Lcom/larus/im/bean/bot/BotModel;", "botId", "forceNew", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTTS", "stopTTSReason", "findChatMessage", "findSocialMessage", "trackFinishTTS", "trackSocialTTS", "message", "trackChatTTS", "chatMessage", "playTotalDuration", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTTSPlayTrace implements IAIChatTtsPlayTraceService {
    public static final ChatTTSPlayTrace b = null;
    public static by7.e c;
    public static wq8.b d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static long i;
    public static Function0<String> j;
    public static boolean k;
    public static Message l;
    public static final Set<String> m = null;
    public static final Set<String> n = null;
    public static final a0 o = null;
    public static final b0 p = null;

    public static final class a implements n68.a {
        public static final a a = null;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.trace.ChatTTSPlayTrace$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0011a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PlayStateEnum.values().length];
                r0[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        static {
            a = new a();
        }

        public a() {
        }

        public final void d(PlayStateEnum r1) {
        }

        public final void e(TtsErrorType r1) {
        }

        public final void c(PlayStateEnum r4) {
            FLogger.a.i("ChatTTSPlayTrace", "play tts callback:" + r4);
            if (r4 != null) goto L5;
            int r5 = -1;
        L7:
            if (r5 != 1) goto L9;
            ChatTTSPlayTrace.k = false;
            ChatTTSPlayTrace r6 = ChatTTSPlayTrace.b;
            if (ChatTTSPlayTrace.l == null) goto L15;
            r6.getClass();
            Message r7 = (Message) ChatTTSPlayTrace.o.invoke();
        L16:
            ChatTTSPlayTrace.p.getClass();
            return;
        L15:
            r6.getClass();
            ChatTTSPlayTrace.f();
            Message r8 = (Message) ChatTTSPlayTrace.o.invoke();
            goto L16
        L9:
            if (r5 != 2) goto L19;
            ChatTTSPlayTrace.b.getClass();
            AudioServiceDelegate.a.O().b("auto_end");
            ChatTTSPlayTrace.g = "auto_end";
            return;
        L19:
            return;
        L5:
            r5 = C0011a.a[r4.ordinal()];
            goto L7
        }

        public final void a(boolean r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
        }

        public final void b(boolean r1, String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
        }
    }

    private ChatTTSPlayTrace() {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.chat.trace.b0] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.bmhome.chat.trace.c0] */
    static {
        b = new ChatTTSPlayTrace();
        g = "";
        h = "";
        i = -1;
        k = true;
        m = new LinkedHashSet();
        n = new LinkedHashSet();
        o = new a0();
        p = new b0();
        a r0 = a.a;
        AudioServiceDelegate.a.r0().m(r0);
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().z(new c0());
    }

    public static void f() {
        wq8.b r0 = d;     // Catch: Exception -> L13
        if (r0 == null) goto L23;
        List<Message> r1 = r0.getCurrentList();     // Catch: Exception -> L13
        if (r1 == null) goto L24;
        Iterator<T> r2 = r1.iterator();     // Catch: Exception -> L13
    L8:
        if (r2.hasNext() == false) goto L25;
        Message r3 = (Message) r2.next();     // Catch: Exception -> L13
        if (Intrinsics.areEqual(r3.getMessageId(), f) == false) goto L8;
        b.getClass();     // Catch: Exception -> L13
        AudioServiceDelegate.a.O().h(r3);     // Catch: Exception -> L13
        l = r3;     // Catch: Exception -> L13
        goto L8
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L13:
        e = move-exception;
        AudioServiceDelegate.a.O().h(null);
        l = null;
        FLogger.a.d("ChatTTSPlayTrace", "findchatMessage crash---" + e);
    }

    public final void a(String r4) {
        FLogger.a.i("ChatTTSPlayTrace", "[TTS][INTERRUPTED] " + r4);
        if (k == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        AudioServiceDelegate.a.O().b(r4);
        g = r4;
    }

    public final void b(com.larus.bmhome.chat.component.list.h0 r1) {
        j = r1;
    }

    public final void c(by7.e r1, wq8.b r2) {
        d = r2;
        c = r1;
    }

    public static final void e(ChatTTSPlayTrace r1, String r2, JSONObject r3) {
        r1.getClass();
        com.larus.platform.service.o r4 = com.larus.platform.service.o.a;
        r3.put("fail_reason", r2);
        Unit r5 = Unit.INSTANCE;
        r4.reportEvent("start_tts_report_failed", r3);
    }

    public final void d(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        int r0 = c68.b.a;
        c68.b.d("ChatTTSPlayTrace", "TraceOnSentenceStart: taskId:" + r3 + ", currentTaskId:" + e + ", sentenceTxt:" + r4 + ", sentenceInst:" + r5 + ", sentenceRes:" + r6);
        if (Intrinsics.areEqual(e, r3) == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L7;
        m.add(r5);
    L7:
        if (r6 == null) goto L10;
        n.add(r6);
        return;
    }

    public final void g(String r7, String r8, String r9, String r10, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r7, "taskId");
        e = r7;
        f = r9;
        i = System.currentTimeMillis();
        if (r8 != null) goto L5;
        String r13 = "";
    L6:
        AudioServiceDelegate r14 = AudioServiceDelegate.a;
        r14.O().f(r13);
        h = r13;
        k = true;
        r14.O().h(null);
        l = null;
        m.clear();
        n.clear();
        f();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatTTSPlayTrace$mobTTSStart$1(r9, r12, null), 2, null);
        FLogger.a.i("ChatTTSPlayTrace", "startTTS: startReason：" + r8 + "---messageID:" + r9);
        return;
    L5:
        r13 = r8;
        goto L6
    }
}
