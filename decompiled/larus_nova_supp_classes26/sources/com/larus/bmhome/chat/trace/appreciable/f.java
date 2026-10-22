package com.larus.bmhome.chat.trace.appreciable;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.chat.trace.imspan.IMSpanManager;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common.apphost.AppHost;
import com.larus.extension.account_auth.api.FlowAccountAuthServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMError;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.platform.service.m3;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.message.IObricAppreciablePoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;
import wa8.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final f a = null;
    public static final HashSet<String> b = null;
    public static final HashSet<String> c = null;
    public static final HashSet<String> d = null;
    public static final HashSet<String> e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Map<String, g> h = null;

    public f() {
    }

    static {
        a = new f();
        b = new HashSet();
        c = new HashSet();
        d = new HashSet();
        e = new HashSet();
        f = LazyKt.lazy(new b());
        g = LazyKt.lazy(new c());
        h = new LinkedHashMap();
    }

    public static void c(Message r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        LruCache<String, ChatPageTrace.ChatPageRecord> r1 = ChatPageTrace.a;
        Intrinsics.checkNotNullParameter(r4, "data");
        String r0 = ChatPageTrace.a(r4.getConversationId());
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        ChatPageTrace.ChatPageRecord r6 = (ChatPageTrace.ChatPageRecord) ChatPageTrace.a.remove(String.valueOf(r5));
        if (r6 == null) goto L22;
        FLogger.a.i("ChatPageTrace", "onViewBind, cvsId=".concat(r0));
        r6.setOnDataBindTime(Long.valueOf(SystemClock.elapsedRealtime()));
        String r7 = r6.getBotId();
        if (r7 != null) goto L10;
    L13:
        boolean r8 = true;
    L14:
        if (r8 == false) goto L16;
        r6.setBotId(BotInfoCache.INSTANCE.getBotId(r0));
    L16:
        ChatControlTrace r9 = ChatControlTrace.b;
        r9.getClass();
        wc9.e r2 = (wc9.e) ChatControlTrace.o.get(r0);
        if (r2 == null) goto L19;
        Integer r3 = r2.v;
    L20:
        BotInfoCache r10 = BotInfoCache.INSTANCE;
        r6.setChatType(r9.g(r3, r10.getBotType(r0), r10.isOwnBot(r0)));
        r6.setBindMessageType(r4.getContentType());
        r6.report();
        return;
    L19:
        r3 = null;
        goto L20
    L10:
        if (r7.length() == 0) goto L13;
        r8 = false;
        goto L14
    }

    public static void g(String r23, ISDKPointCallback.EndMsg r24) {
        Intrinsics.checkNotNullParameter(r23, "sendMsgId");
        Intrinsics.checkNotNullParameter(r24, "endMsg");
        FLogger r3 = FLogger.a;
        r3.i("AppreciablePoint", "onSDKReceiveEnd, sendMsgId=" + r23 + ", endMsg=" + r24);
        nq9.f r4 = m3.a.o();
        if (r4 == null) goto L5;
        r4.e(r23, r24);
    L5:
        String r5 = r24.getId();
        int r8 = r24.getContentType();
        boolean r10 = false;
        if (r5.length() <= 0) goto L8;
        boolean r9 = true;
    L9:
        if (r9 == true) goto L11;
        return;
    L11:
        if (r24.getHasSuggest() == false) goto L13;
        r5 = com.larus.bmhome.social.userchat.model.b0.k(r5, 1);
        r8 = 2;
    L13:
        int r1 = r24.getStatus();
        long r11 = SystemClock.elapsedRealtime();
        r3.i("AppreciablePoint", "onSDKReceiveEnd, sendMsgId=" + r23 + ", endMsg=" + r5 + ", endMsgContentType=" + r8 + ", endMsgStatus=" + r1);
        CommonParamManager.CommonParam r6 = CommonParamManager.c(r23);
        if (r6 == null) goto L16;
        String r7 = r6.getEndReceiveMsgId();
    L17:
        if (r7 != null) goto L59;
        Intrinsics.checkNotNullParameter(r23, "sendMsgId");
        Intrinsics.checkNotNullParameter(r5, "endReceiveMsgId");
        r3.i("CommonParamManager", "updateEndReceiveMsgId, sendMsgId=" + r23 + ", endReceiveMsgId=" + r5);
        CommonParamManager.CommonParam r12 = (CommonParamManager.CommonParam) CommonParamManager.a.get(r23);
        if (r12 == null) goto L22;
        r12.setEndReceiveMsgId(r5);
    L22:
        int r13 = ChatMessageResultTrace.a;
        Intrinsics.checkNotNullParameter(r23, "sendMsgId");
        if (CommonParamManager.c(r23) == null) goto L25;
        new ChatMessageResultTrace.ReceiveRecord(null, Integer.valueOf(r8), Integer.valueOf(r1), null, null, null, null, 121, null).report(r23, r11);
    L25:
        if (r6 == null) goto L27;
        String r14 = r6.getLocalSendMsgId();
    L28:
        if (r14 != null) goto L30;
        r14 = "";
    L30:
        if (r1 != 0) goto L54;
        ChatMessageCostTrace.a.getClass();
        Intrinsics.checkNotNullParameter(r23, "sendMsgId");
        Intrinsics.checkNotNullParameter(r5, "endMsgId");
        Object r2 = ChatMessageCostTrace.c.get(r23);
        if ((r2 instanceof ChatMessageCostTrace.AllFirstStep) == false) goto L34;
        ChatMessageCostTrace.AllFirstStep r15 = (ChatMessageCostTrace.AllFirstStep) r2;
    L35:
        if (r15 == null) goto L50;
        ConcurrentHashMap<String, ChatMessageCostTrace.ChildStepRecord> r16 = r15.getChildSteps();
        if (r16 == null) goto L50;
        ChatMessageCostTrace.ChildStepRecord r17 = r16.get(r5);
        if (r17 == null) goto L50;
        if ((r17 instanceof ChatMessageCostTrace.ContentCompleteStep) == true) goto L44;
        r17 = null;
    L44:
        if (r17 == null) goto L50;
        Long r18 = r17.getDurationRender();
        if (com.larus.platform.exp.s.f == true) goto L48;
    L49:
        r3.i("ChatMessageCostTrace", "checkAllComplete trigger allComplete");
        ChatMessageCostTrace.c(r23, r5, Long.valueOf(r17.getStepTime()), r18);
        goto L50
    L48:
        if (r17.getRenderTimingResolved() == true) goto L49;
    L50:
        if (r6 == null) goto L52;
        r10 = Intrinsics.areEqual(r6.getLeavedChatPage(), Boolean.TRUE);
    L52:
        if (r10 == false) goto L57;
        IMSpanManager.c(r14, null, null);
        return;
    L57:
        return;
    L34:
        r15 = null;
        goto L35
    L54:
        LruCache<String, String> r0 = IMSpanManager.a;
        IMSpanManager.c(r14, Integer.valueOf(r1), null);
        return;
    L27:
        r14 = null;
        goto L28
    L59:
        return;
    L16:
        r7 = null;
        goto L17
    L8:
        r9 = false;
        goto L9
    }

    public static void j(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "localMessageId");
        ChatMessageCostTrace.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "localMessageId");
        LruCache<String, ChatMessageCostTrace.StepRecord> r0 = ChatMessageCostTrace.c;
        Objects.toString(r0.get(r4));
        Object r1 = r0.get(r4);
        if ((r1 instanceof ChatMessageCostTrace.SdkSendStep) == false) goto L5;
        ChatMessageCostTrace.SdkSendStep r2 = (ChatMessageCostTrace.SdkSendStep) r1;
    L6:
        if (r2 == null) goto L9;
        FLogger.a.i("ChatMessageCostTrace", "onSendMsgOnScreen localId=" + r4 + ", contentType=" + r5);
        ChatMessageCostTrace.SendMsgOnScreenStep r3 = new ChatMessageCostTrace.SendMsgOnScreenStep(Integer.valueOf(r5));
        r0.put(r4, r3);
        r3.report(r4);
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v30, types: [com.larus.bmhome.chat.trace.appreciable.l, java.lang.Object] */
    public static void m(Message r27, String r28) {
        String r0 = r27.getMessageId();
        String r1 = "";
        if (r0 != null) goto L5;
        String r15 = "";
    L6:
        int r9 = r27.getContentType();
        String r2 = r27.getReplyId();
        if (r2 != null) goto L9;
        String r14 = "";
    L10:
        Map r3 = r27.getExt();
        if (r3 == null) goto L13;
        String r4 = (String) r3.get("general_agent");
    L14:
        boolean r5 = Intrinsics.areEqual(r4, "1");
        if (com.larus.im.bean.message.a.f0(r27) == true) goto L19;
        if (r5 == true) goto L19;
        boolean r11 = false;
    L21:
        if (com.larus.bmhome.chat.bean.d.G0(r27) == true) goto L30;
        int r6 = r27.getMessageStatusLocal();
        if (r6 == 20) goto L27;
        if (r6 == 21) goto L27;
        if (r6 == 24) goto L27;
        boolean r7 = false;
    L28:
        if (r7 == false) goto L30;
        boolean r8 = true;
    L32:
        if (r8 == false) goto L67;
        ChatMessageCostTrace.a.getClass();
        Intrinsics.checkNotNullParameter(r27, "msg");
        String r10 = r27.getMessageId();
        if (r10 != null) goto L36;
        r10 = "";
    L36:
        LruCache<String, CommonParamManager.CommonParam> r12 = CommonParamManager.a;
        CommonParamManager.CommonParam r13 = CommonParamManager.c(r27.getReplyId());
        if (r13 == null) goto L39;
        Long r16 = r13.getSendStartTime();
    L41:
        if (r10.length() != 0) goto L43;
        boolean r17 = true;
    L44:
        if (r17 == true) goto L67;
        if (r13 == null) goto L67;
        if (r16 == null) goto L67;
        String r18 = com.larus.im.bean.message.a.F(r27);
        Map r19 = r27.getBusinessExt();
        if (r19 == null) goto L51;
        String r110 = (String) r19.get("current_perf_mark");
    L52:
        if (r18 != null) goto L54;
    L57:
        boolean r111 = true;
    L58:
        if (r111 == true) goto L67;
        if (r110 == null) goto L67;
        if (ChatMessageCostTrace.b.contains(r110) == false) goto L67;
        if (Intrinsics.areEqual(r13.getLatestPerfMarkRenderTokens().put(r10, r18), r18) == true) goto L67;
        FLogger.a.d("ChatMessageCostTrace", "recordPerfMarkIfNeeded " + r10 + ' ' + r18 + ' ' + r110);
        long r20 = SystemClock.elapsedRealtime() - r16.longValue();
        if (r20 < 0) goto L67;
        r13.getPerfMarkDurations().putIfAbsent(r110, Long.valueOf(r20));
        goto L67
    L54:
        if (r18.length() == 0) goto L57;
        r111 = false;
        goto L58
    L51:
        r110 = null;
        goto L52
    L43:
        r17 = false;
        goto L44
    L39:
        r16 = null;
    L67:
        int r21 = r27.getMessageStatusLocal();
        if (r21 != 20) goto L70;
        String r22 = r14;
        String r23 = r15;
        ChatRenderTrace.b.getClass();
        ChatRenderTrace.q(r27);
        HashSet<String> r24 = d;
        if (r24.contains(r23) == true) goto L184;
        if (com.larus.im.bean.message.a.r0(r27) == true) goto L184;
        if (r9 == 8) goto L184;
        r24.add(r23);
        ChatMessageCostTrace.d(ChatMessageCostTrace.a, r22, r23, r9, null, r27, !r11, 8);
        com.larus.bmhome.chat.trace.container.b r25 = com.larus.bmhome.chat.trace.container.b.a;
        com.larus.bmhome.chat.trace.container.b.m(r27);
    L184:
        if (r11 == false) goto L199;
        lo8.a.b(r27);
        if (com.larus.bmhome.chat.bean.d.f0(r27) == true) goto L199;
        String r26 = com.larus.bmhome.chat.bean.d.r(r27);
        if (r26 != null) goto L190;
    L193:
        boolean r112 = true;
    L194:
        if (r112 == true) goto L199;
        JSONObject r29 = lo8.a.a(r27, r28);
        if (r29 == null) goto L199;
        ChatMessageCostTrace.a.getClass();
        ChatMessageCostTrace.e(r22, r29);
        goto L199
    L190:
        if (r26.length() == 0) goto L193;
        r112 = false;
    L199:
        if (com.larus.im.bean.message.a.C0(r27) == true) goto L201;
        return;
    L201:
        if (com.larus.bmhome.chat.bean.d.e0(r27) == true) goto L203;
        return;
    L203:
        if (com.larus.bmhome.chat.bean.d.f0(r27) == true) goto L223;
        lo8.a.c(r27);
        return;
    L223:
        return;
    L70:
        if (r21 != 21) goto L72;
        ChatRenderTrace.b.getClass();
        ChatRenderTrace.q(r27);
        if (((Set) g.getValue()).contains(Integer.valueOf(r27.getContentType())) == false) goto L111;
        HashSet<String> r30 = d;
        if (r30.contains(r15) == true) goto L111;
        r30.add(r15);
        ChatMessageCostTrace.d(ChatMessageCostTrace.a, r14, r15, r9, null, r27, !r11, 8);
        com.larus.bmhome.chat.trace.container.b r31 = com.larus.bmhome.chat.trace.container.b.a;
        com.larus.bmhome.chat.trace.container.b.m(r27);
    L111:
        if (r11 == false) goto L126;
        lo8.a.b(r27);
        if (com.larus.bmhome.chat.bean.d.f0(r27) == true) goto L126;
        String r32 = com.larus.bmhome.chat.bean.d.r(r27);
        if (r32 != null) goto L117;
    L120:
        boolean r113 = true;
    L121:
        if (r113 == true) goto L126;
        JSONObject r33 = lo8.a.a(r27, r28);
        if (r33 == null) goto L126;
        ChatMessageCostTrace.a.getClass();
        ChatMessageCostTrace.e(r14, r33);
        goto L126
    L117:
        if (r32.length() == 0) goto L120;
        r113 = false;
    L126:
        if (com.larus.im.bean.message.a.C0(r27) == false) goto L133;
        if (com.larus.bmhome.chat.bean.d.e0(r27) == false) goto L133;
        if (com.larus.bmhome.chat.bean.d.f0(r27) == true) goto L133;
        lo8.a.c(r27);
    L133:
        if (com.larus.bmhome.chat.bean.d.Q0(r27) == true) goto L213;
        HashSet<String> r34 = e;
        if (r34.contains(r15) == true) goto L214;
        r34.add(r15);
        ChatMessageCostTrace r35 = ChatMessageCostTrace.a;
        r35.getClass();
        Intrinsics.checkNotNullParameter(r14, "sendMsgId");
        Intrinsics.checkNotNullParameter(r15, "receiveMsgId");
        Intrinsics.checkNotNullParameter(r27, r7);
        long r114 = SystemClock.elapsedRealtime();
        Object r36 = ChatMessageCostTrace.c.get(r14);
        if ((r36 instanceof ChatMessageCostTrace.AllFirstStep) == false) goto L139;
        ChatMessageCostTrace.AllFirstStep r37 = (ChatMessageCostTrace.AllFirstStep) r36;
    L140:
        if (r37 == null) goto L150;
        ConcurrentHashMap<String, ChatMessageCostTrace.ChildStepRecord> r115 = r37.getChildSteps();
        if (r115.get(r15) != null) goto L144;
        ChatMessageCostTrace.d(r35, r14, r15, r9, Long.valueOf(r114), r27, false, 32);
    L144:
        ChatMessageCostTrace.ChildStepRecord r38 = r115.get(r15);
        if ((r38 instanceof ChatMessageCostTrace.ContentFirstStep) == false) goto L147;
        ChatMessageCostTrace.ContentFirstStep r39 = (ChatMessageCostTrace.ContentFirstStep) r38;
    L148:
        if (r39 == null) goto L150;
        String r40 = null;
        final String r41 = r14;
        final String r42 = r15;
        ChatMessageCostTrace.ContentCompleteStep r43 = new ChatMessageCostTrace.ContentCompleteStep(r14, r15, Integer.valueOf(r9), null, null, null, null, 120, null);
        final long r44 = r114;
        r43.setStepTime(r44);
        r43.setIndex(r39.getIndex());
        r115.put(r42, r43);
        r43.report(r41);
    L151:
        ?? r45 = new l(r41, r42, r44);
        List r46 = ChatMessageCostTrace.d.get();
        if (r46 == null) goto L154;
        r46.add(r45);
    L156:
        if (com.larus.im.bean.message.a.C0(r27) == false) goto L215;
        HashMap<String, lo8.a.C0116a> r47 = lo8.a.a;
        Intrinsics.checkNotNullParameter(r27, "msg");
        LruCache<String, CommonParamManager.CommonParam> r48 = CommonParamManager.a;
        CommonParamManager.CommonParam r49 = CommonParamManager.c(r27.getReplyId());
        if (r49 == null) goto L216;
        Long r50 = r49.getSendStartTime();
        if (r50 == null) goto L217;
        long r51 = r50.longValue();
        HashMap<String, lo8.a.C0116a> r52 = lo8.a.a;
        lo8.a.C0116a r53 = r52.get(r27.getMessageId());
        if (r53 == null) goto L218;
        Long r54 = r53.b;
        if (r54 == null) goto L219;
        long r55 = r54.longValue();
        if (r55 < 0) goto L225;
        lo8.a.C0116a r56 = r52.get(r27.getMessageId());
        if (r56 == null) goto L171;
        r56.b = -1L;
    L171:
        long r57 = r55 - r51;
        long r58 = SystemClock.elapsedRealtime() - r51;
        JSONObject r59 = new JSONObject();
        r59.put(MusicAppletPage.KEY_MESSAGE_ID, r27.getMessageId());
        CommonParamManager.CommonParam r60 = CommonParamManager.c(r27.getReplyId());
        if (r60 == null) goto L174;
        String r116 = r60.getChatType();
    L175:
        r59.put("chat_type", r116);
        r59.put("current_page", r28);
        r59.put("first_token_duration", r57);
        r59.put("total_duration", r58);
        com.larus.platform.service.o.a.reportEvent("thinking_progress_main_text_duration", r59);
        com.larus.bmhome.utils.c.a("thinking_progress_main_text_duration", r59, true);
        return;
    L174:
        r116 = r40;
        goto L175
    L225:
        return;
    L219:
        return;
    L218:
        return;
    L217:
        return;
    L216:
        return;
    L215:
        return;
    L154:
        r45.invoke(r40);
        goto L156
    L147:
        r39 = null;
    L150:
        r44 = r114;
        r41 = r14;
        r42 = r15;
        r40 = null;
        goto L151
    L139:
        r37 = null;
        goto L140
    L214:
        return;
    L213:
        return;
    L72:
        if (r21 == 24) goto L104;
        switch(r21) {
            case 10: goto L92;
            case 11: goto L75;
            case 12: goto L92;
            case 13: goto L92;
            default: goto L224;
        };
    L75:
        HashSet<String> r61 = c;
        if (CollectionsKt.contains(r61, r27.getLocalMessageId()) == false) goto L78;
    L87:
        HashSet<String> r62 = b;
        if (r62.contains(r15) == false) goto L90;
        return;
    L90:
        if (com.larus.bmhome.chat.bean.d.G0(r27) == false) goto L207;
        r62.add(r15);
        ChatMessageCostTrace.a.getClass();
        ChatMessageCostTrace.f(r15, r9);
        return;
    L207:
        return;
    L78:
        if (com.larus.bmhome.chat.bean.d.G0(r27) == false) goto L87;
        String r63 = r27.getLocalMessageId();
        if (r63 != null) goto L82;
        r63 = "";
    L82:
        r61.add(r63);
        String r64 = r27.getLocalMessageId();
        if (r64 == null) goto L86;
        r1 = r64;
    L86:
        j(r1, r27.getContentType());
        goto L87
    L92:
        HashSet<String> r65 = c;
        if (CollectionsKt.contains(r65, r27.getLocalMessageId()) == false) goto L95;
        return;
    L95:
        if (com.larus.bmhome.chat.bean.d.G0(r27) == false) goto L210;
        String r66 = r27.getLocalMessageId();
        if (r66 != null) goto L99;
        r66 = "";
    L99:
        r65.add(r66);
        String r67 = r27.getLocalMessageId();
        if (r67 == null) goto L103;
        r1 = r67;
    L103:
        j(r1, r27.getContentType());
        return;
    L210:
        return;
    L224:
        return;
    L104:
        ChatRenderTrace.b.getClass();
        ChatRenderTrace.q(r27);
        return;
    L27:
        r7 = true;
    L30:
        r8 = false;
    L19:
        r11 = true;
        goto L21
    L13:
        r4 = null;
        goto L14
    L9:
        r14 = r2;
        goto L10
    L5:
        r15 = r0;
        goto L6
    }

    public static void d(List r3, String r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r3, "list");
        if (r5 != null) goto L9;
        Iterator r6 = CollectionsKt.take(r3, 5).iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        Message r7 = (Message) r6.next();
        a.getClass();
        m(r7, r4);
        goto L6
    L8:
        return;
    L9:
        final ArrayList r1 = new ArrayList();
        ChatMessageCostTrace.a.getClass();
        ChatMessageCostTrace.d.set(r1);
        Iterator r8 = CollectionsKt.take(r3, 5).iterator();     // Catch: Throwable -> L25
    L12:
        if (r8.hasNext() == false) goto L15;
        Message r0 = (Message) r8.next();     // Catch: Throwable -> L25
        a.getClass();     // Catch: Throwable -> L25
        m(r0, r4);     // Catch: Throwable -> L25
        goto L12
    L15:
        ChatMessageCostTrace.a.getClass();
        ChatMessageCostTrace.d.remove();
        if (r1.isEmpty() == false) goto L19;
        return;
    L19:
        if (((Boolean) r5.invoke(new e(r1))).booleanValue() == true) goto L24;
        Iterator r9 = r1.iterator();
    L22:
        if (r9.hasNext() == false) goto L34;
        ((Function1) r9.next()).invoke(null);
        goto L22
    L34:
        return;
    L24:
        return;
    L25:
        th = move-exception;
        ChatMessageCostTrace.a.getClass();
        ChatMessageCostTrace.d.remove();
        throw th;
    }

    public static void a(String r3, String r4, String r5, long r6) {
        LruCache<String, ChatPageTrace.ChatPageRecord> r0 = ChatPageTrace.a;
        FLogger.a.i("ChatPageTrace", "onCreated, cvsId=" + r3 + ", botId=" + r4 + ", previousPage=" + r5);
        ChatPageTrace.ChatPageRecord r7 = (ChatPageTrace.ChatPageRecord) ChatPageTrace.a.get(String.valueOf(r6));
        if (r7 == null) goto L6;
        r7.setOnCreateTime(Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    }

    public static void b(String r6, String r7, String r8, long r9) {
        LruCache<String, ChatPageTrace.ChatPageRecord> r0 = ChatPageTrace.a;
        FLogger.a.i("ChatPageTrace", "onPageLoad, cvsId=" + r6 + ", botId=" + r7 + ", previousPage=" + r8);
        String r10 = ChatPageTrace.a(r6);
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        ChatPageTrace.ChatPageRecord r11 = (ChatPageTrace.ChatPageRecord) ChatPageTrace.a.get(String.valueOf(r9));
        if (r11 == null) goto L15;
        r11.setOnPageLoadTime(Long.valueOf(SystemClock.elapsedRealtime()));
        if (o0.d(r7) == false) goto L10;
        r11.setBotId(r7);
    L10:
        r11.setPreviousPage(r8);
        if (com.larus.platform.exp.c.e == false) goto L13;
        r11.setHasLocal(1);
        return;
    L13:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatPageTrace$onPageLoad$1$1(r11, r10, null), 2, null);
        return;
    }

    public static void e(String r26, String r27, int r28, IIMError r29, Map r30) {
        Intrinsics.checkNotNullParameter(r26, "localSendMsgId");
        String r4 = null;
        if (r27 == null) goto L5;
        int r5 = 0;
    L20:
        FLogger r6 = FLogger.a;
        r6.i("AppreciablePoint", "onSDKAck, localId=" + r26 + ", msgId=" + r27 + ", contentType=" + r28 + " status = " + r5);
        if (r27 == null) goto L31;
        b.remove(r27);
        LruCache<String, CommonParamManager.CommonParam> r9 = CommonParamManager.a;
        Intrinsics.checkNotNullParameter(r26, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r27, "sendMsgId");
        r6.i("CommonParamManager", "updateSendMsgId, from=" + r26 + " to=" + r27);
        LruCache<String, CommonParamManager.CommonParam> r3 = CommonParamManager.a;
        CommonParamManager.CommonParam r7 = (CommonParamManager.CommonParam) r3.remove(r26);
        if (r7 == null) goto L25;
        r3.put(r27, r7);
        r7.setAckTime(Long.valueOf(SystemClock.elapsedRealtime()));
        r7.setSendMsgId(r27);
    L25:
        AudioServiceDelegate.a.N().d(r27, r26);
        com.larus.bmhome.chat.trace.container.b r8 = com.larus.bmhome.chat.trace.container.b.a;
        com.larus.bmhome.chat.trace.container.b.n(r26, r27);
        HashMap<String, lo8.a.C0116a> r10 = lo8.a.a;
        Intrinsics.checkNotNullParameter(r26, "localMsgId");
        Intrinsics.checkNotNullParameter(r27, "msgId");
        Map<String, String> r11 = lo8.a.b;
        if (r11.containsKey(r26) == false) goto L28;
        r11.put(r26, r27);
    L28:
        IObricAppreciablePoint.a.getClass();
        IObricAppreciablePoint r12 = IObricAppreciablePoint.a.b;
        if (r12 == null) goto L31;
        r12.a(r26, r27);
    L31:
        int r13 = ChatMessageResultTrace.a;
        if (r27 != null) goto L34;
        String r14 = r26;
    L35:
        Intrinsics.checkNotNullParameter(r14, "sendMsgId");
        if (r29 == null) goto L38;
        Integer r20 = Integer.valueOf(r29.getCode());
    L39:
        if (r29 == null) goto L41;
        Integer r21 = Integer.valueOf(r29.getCode());
    L42:
        if (r29 == null) goto L44;
        String r22 = r29.getTips();
    L45:
        if (r29 == null) goto L49;
        Throwable r15 = r29.getException();
        if (r15 == null) goto L49;
        String r23 = r15.getMessage();
    L51:
        if (r30 == null) goto L56;
        String r16 = (String) r30.get("spring_guide_card_id");
        if (r16 == null) goto L56;
        String r17 = r16;
    L57:
        if (r30 == null) goto L62;
        String r18 = (String) r30.get("is_spring_guide");
        if (r18 == null) goto L62;
        String r19 = r18;
    L63:
        if (r30 == null) goto L68;
        String r24 = (String) r30.get("common_venue_guide_card_id");
        if (r24 == null) goto L68;
        String r110 = r24;
    L69:
        if (r30 == null) goto L74;
        String r25 = (String) r30.get("is_common_venue_guide");
        if (r25 == null) goto L74;
        String r111 = r25;
    L75:
        if (r30 == null) goto L80;
        String r2 = (String) r30.get("delay_request_interval_ms");
        if (r2 == null) goto L80;
        String r112 = r2;
    L81:
        new ChatMessageResultTrace.SendRecord(null, Integer.valueOf(r28), Integer.valueOf(r5), null, null, r17, r19, r110, r111, r112, r20, r21, r22, r23, 25, null).report(r14);
        if (r5 == 0) goto L90;
        LruCache<String, String> r31 = IMSpanManager.a;
        if (r29 == null) goto L86;
        Integer r32 = Integer.valueOf(r29.getCode());
    L87:
        if (r29 == null) goto L89;
        r4 = r29.getTips();
    L89:
        IMSpanManager.c(r26, r32, r4);
        goto L90
    L86:
        r32 = null;
    L90:
        nq9.f r33 = m3.a.o();
        if (r33 == null) goto L94;
        r33.f(r26, r27);
        return;
    L94:
        return;
    L80:
        r112 = "";
    L74:
        r111 = "";
    L68:
        r110 = "";
    L62:
        r19 = "";
    L56:
        r17 = "";
    L49:
        r23 = null;
        goto L51
    L44:
        r22 = null;
        goto L45
    L41:
        r21 = null;
        goto L42
    L38:
        r20 = null;
        goto L39
    L34:
        r14 = r27;
        goto L35
    L5:
        if (r29 == null) goto L7;
        String r34 = r29.getTips();
    L9:
        if (Intrinsics.areEqual(r34, "Timeout") == false) goto L11;
        r5 = 2;
        goto L20
    L11:
        if (r29 == null) goto L19;
        Map r35 = r29.getExt();
        if (r35 == null) goto L15;
        String r36 = (String) r35.get("key_is_business_error");
    L17:
        if (Intrinsics.areEqual(r36, "1") == false) goto L19;
        r5 = 7;
        goto L20
    L15:
        r36 = null;
    L19:
        r5 = 1;
        goto L20
    L7:
        r34 = null;
        goto L9
    }

    public static void h(String r18, int r19, String r20, String r21, ModelItemIdentity r22) {
        Intrinsics.checkNotNullParameter(r21, "sendFuncChannel");
        if (r18 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r22, t0.e) == false) goto L8;
        String r2 = "task";
    L23:
        boolean r4 = false;
        if (r19 != 1) goto L27;
        if (r20 == null) goto L27;
        int r7 = r20.length();
    L28:
        ChatMessageCostTrace.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r21, "sendFuncChannel");
        Intrinsics.checkNotNullParameter(r2, "queryType");
        CommonParamManager.CommonParam r3 = CommonParamManager.c(r18);
        if (r3 == null) goto L31;
        r3.setSendMsgOnBusinessTime(Long.valueOf(SystemClock.elapsedRealtime()));
    L31:
        CommonParamManager.CommonParam r5 = CommonParamManager.c(r18);
        if (r5 == null) goto L34;
        r5.setSendFuncChannel(r21);
    L34:
        FLogger.a.i("ChatMessageCostTrace", "onSdkSendMsg localSendMsgId=".concat(r18));
        LruCache<String, ChatMessageCostTrace.StepRecord> r1 = ChatMessageCostTrace.c;
        Object r6 = r1.get(r18);
        Long r9 = null;
        if ((r6 instanceof ChatMessageCostTrace.SendStartStep) == false) goto L37;
        ChatMessageCostTrace.SendStartStep r8 = (ChatMessageCostTrace.SendStartStep) r6;
    L38:
        if (r8 == null) goto L57;
        r1.remove(r18);
        ChatMessageCostTrace.SdkSendStep r10 = new ChatMessageCostTrace.SdkSendStep(Integer.valueOf(r19), null, null, null, 0, 30, null);
        r1.put(r18, r10);
        CommonParamManager.CommonParam r11 = CommonParamManager.c(r18);
        if (r11 == null) goto L42;
        Long r12 = r11.getSendStartTime();
    L43:
        r10.setStartSendTimeInMillSec(Long.valueOf(ChatMessageCostTrace.g(r12)));
        r10.setSendEndTimeInMillSec(Long.valueOf(ChatMessageCostTrace.g(Long.valueOf(r10.getStepTime()))));
        r10.setQueryType(r2);
        r10.setTextLength(r7);
        if (r11 == null) goto L54;
        Long r13 = r10.getDuration(r18);
        if (r13 != null) goto L48;
    L53:
        r11.setSendToSdkTimeDuration(r9);
        goto L54
    L48:
        if (r13.longValue() <= 0) goto L51;
        r4 = true;
    L51:
        if (Boolean.valueOf(r4).booleanValue() == false) goto L53;
        r9 = r13;
    L54:
        r10.report(r18);
        return;
    L42:
        r12 = null;
        goto L43
    L57:
        return;
    L37:
        r8 = null;
    L27:
        r7 = 0;
        goto L28
    L8:
        if (Intrinsics.areEqual(r22, t0.d) == false) goto L11;
        r2 = "pro";
        goto L23
    L11:
        if (Intrinsics.areEqual(r22, t0.b) == false) goto L14;
        r2 = "deepthinking";
        goto L23
    L14:
        if (Intrinsics.areEqual(r22, t0.c) == false) goto L17;
        r2 = "autocot";
        goto L23
    L17:
        if (Intrinsics.areEqual(r22, t0.a) == false) goto L19;
        r2 = "normal";
        goto L23
    L19:
        if (r22 == null) goto L22;
        r2 = r22.getKey();
        if (r2 != null) goto L23;
    L22:
        r2 = "";
        goto L23
    }

    public static void i(String r3, String r4, int r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r4, "scene");
        int r2 = p.a;
        Intrinsics.checkNotNullParameter(r3, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r6 == null) goto L5;
    L24:
        JSONObject r8 = new JSONObject();
        r8.put("status", r7);
        r8.put("content_type", r5);
        r8.put("error_type", r6);
        JSONObject r9 = a.b(CommonParamManager.c(r3), r8);
        FLogger.a.i("ChatMessageFailedBeforeACKTrace", "onSendFailed, event=message_send_result, param=" + r9);
        com.larus.platform.service.o.a.reportEvent("message_send_result", r9);
        com.larus.bmhome.utils.c.a("message_send_result", r9, true);
        LruCache<String, String> r10 = IMSpanManager.a;
        IMSpanManager.b(r3, "message_send_result", r9);
        return;
    L5:
        switch(r4.hashCode()) {
            case 3143036: goto L19;
            case 92896879: goto L15;
            case 109413407: goto L12;
            case 109641682: goto L8;
            default: goto L23;
        };
    L23:
        String r11 = "msg_send_failed";
    L22:
        r6 = r11;
        goto L24
    L8:
        if (r4.equals("speak") == false) goto L23;
        r11 = "asr_recog_failed";
        goto L22
    L12:
        if (r4.equals("shoot") == false) goto L23;
    L17:
        r11 = "img_upload_failed";
        goto L22
    L15:
        if (r4.equals("album") == true) goto L17;
    L19:
        if (r4.equals(ShareType.FILE) == false) goto L23;
        r11 = "file_upload_failed";
        goto L22
    }

    public static void k(f r36, String r37, String r38, String r39, long r40, String r42) {
        r36.getClass();
        Intrinsics.checkNotNullParameter(r39, "channel");
        Intrinsics.checkNotNullParameter(r42, "schema");
        LruCache<String, ChatPageTrace.ChatPageRecord> r4 = ChatPageTrace.a;
        Intrinsics.checkNotNullParameter(r39, "channel");
        Intrinsics.checkNotNullParameter(r42, ShareType.URL);
        FLogger.a.i("ChatPageTrace", "onStart, cvsId=" + r37 + ", botId=" + r38);
        String r2 = ChatPageTrace.a(r37);
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r15 = r2;
        ChatPageTrace.ChatPageRecord r14 = new ChatPageTrace.ChatPageRecord(r39, null, null, Long.valueOf(r40), r42, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 520093670, null);
        long r3 = SystemClock.elapsedRealtime();
        AppHost.Companion r5 = AppHost.a;
        r14.setDistanceToAppStart(Long.valueOf(r3 - ((Number) r5.getAppStartTime().getFirst()).longValue()));
        r14.setOnStartTime(Long.valueOf(SystemClock.elapsedRealtime()));
        r14.setCvsId(r15);
        r14.setBotId(r38);
        if (r5.isPlugin() == false) goto L12;
        r14.setAuthStatusCode(Integer.valueOf(FlowAccountAuthServiceDelegate.b.a()));
        if (ChatPageTrace.b == false) goto L10;
        int r1 = 1;
    L11:
        r14.setFirstEnter(r1);
        goto L12
    L10:
        r1 = 0;
    L12:
        ChatPageTrace.a.put(String.valueOf(r40), r14);
        ChatPageTrace.b = false;
        com.larus.bmhome.chat.trace.container.b r6 = com.larus.bmhome.chat.trace.container.b.a;
        com.larus.bmhome.chat.trace.container.b.r(r37, r39);
    }

    public static /* synthetic */ void f(f r2, String r3, String r4, int r5, IIMError r6, Map r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 8) == 0) goto L9;
        r6 = null;
    L9:
        if ((r8 & 16) == 0) goto L11;
        r7 = null;
    L11:
        r2.getClass();
        e(r3, r4, r5, r6, r7);
    }

    public static void l(f r63, final String r64, final String r65, final String r66, int r67, List r68, Map r69, String r70, Long r71, int r72) {
        if ((r72 & 8) == 0) goto L5;
        final int r5 = 1;
    L7:
        if ((r72 & 16) == 0) goto L9;
        List r6 = null;
    L11:
        if ((r72 & 32) == 0) goto L13;
        Map r1 = null;
    L15:
        if ((r72 & 64) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r72 & 128) == 0) goto L21;
        Long r8 = null;
    L22:
        r63.getClass();
        Intrinsics.checkNotNullParameter(r64, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r65, "cvsId");
        Intrinsics.checkNotNullParameter(r66, "scene");
        ReplyOption r0 = com.larus.bmhome.instruction.c.a.a(BotInfoCache.INSTANCE.getBotId(r65), ActiveSwitchType.DEEPTHINK.getValue());
        Object r14 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        int r15 = com.larus.bmhome.view.actionbar.custom.cache.e.c(r0);
        ChatMessageCostTrace.a.getClass();
        Intrinsics.checkNotNullParameter(r64, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r65, "cvsId");
        Intrinsics.checkNotNullParameter(r66, "scene");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L31
        if (r1 == null) goto L28;
        String r3 = (String) r1.get("pocket_map");     // Catch: Throwable -> L31
        if (r3 == null) goto L28;
        Map r4 = ChatMessageCostTrace.b(r3);     // Catch: Throwable -> L31
    L29:
        Object r9 = Result.constructor-impl(r4);     // Catch: Throwable -> L31
    L34:
        if (Result.isFailure-impl(r9) == false) goto L36;
        r9 = null;
    L36:
        Map r10 = (Map) r9;
        if (r10 == null) goto L41;
        Object r16 = r10.get("pocket_id");
        if (r16 == null) goto L41;
        String r17 = r16.toString();
    L42:
        boolean r18 = false;
        if (r10 != null) goto L45;
    L47:
        boolean r11 = false;
    L49:
        if (r11 == false) goto L55;
        c0.a.getClass();
        AppHost.Companion r12 = AppHost.a;
        long r13 = r12.getAppClock().currentTimeMillis();
        FLogger r19 = FLogger.a;
        r19.i("SpringMainVenueMessageTimeRecorder", "[getLastSendMsgByUserMillisDiff] currentTimeMillis = " + r13 + ", lastSendMsgByUserMs = " + c0.b);
        Long r20 = c0.b;
        if (r20 == null) goto L53;
        int r21 = (int) (r13 - r20.longValue());
    L54:
        String r22 = String.valueOf(r21);
        long r23 = r12.getAppClock().currentTimeMillis();
        r19.i("SpringMainVenueMessageTimeRecorder", "[updateLastSendMsgByUserMillis] currentTimeMillis = " + r23 + ", lastSendMsgByUserMs = " + c0.b);
        c0.b = Long.valueOf(r23);
        String r24 = "spring_guide_2026";
        String r25 = r22;
    L56:
        if (r1 == null) goto L58;
        String r26 = (String) r1.get("delay_request_interval_ms");
    L59:
        if (r1 == null) goto L61;
        String r27 = (String) r1.get("pocket_entry_to_send_msg_cost");
    L62:
        final long r110 = System.currentTimeMillis();
        if (r8 == null) goto L65;
        long r28 = r110 - r8.longValue();
    L66:
        ChatMessageCostTrace.SendStartStep r29 = new ChatMessageCostTrace.SendStartStep(Integer.valueOf(r5), Long.valueOf(r28), Integer.valueOf(r15));
        FLogger r30 = FLogger.a;
        r30.i("ChatMessageCostTrace", "onStartSendMsg localSendMsgId=" + r64);
        ChatMessageCostTrace.c.put(r64, r29);
        LruCache<String, CommonParamManager.CommonParam> r31 = CommonParamManager.a;
        long r111 = r29.getStepTime();
        Intrinsics.checkNotNullParameter(r66, "scene");
        Intrinsics.checkNotNullParameter(r64, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r65, "cvsId");
        Intrinsics.checkNotNullParameter(r25, "intervalMs");
        CommonParamManager.CommonParam r112 = new CommonParamManager.CommonParam(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, -1, 63, null);
        CommonParamManager.a.put(r64, r112);
        if (r7 != 0) goto L69;
    L75:
        String r113 = CommonParamManager.b();
    L76:
        r112.setScene(r66);
        r112.setSendStartEpochMs(Long.valueOf(r110));
        r112.setCTraceId(r113);
        Map r114 = MapsKt.createMapBuilder();
        r114.put("c_trace_id", r113);
        r114.put("scene", r66);
        r112.setMessageTrackCommonTags(MapsKt.build(r114));
        if (r17 != 0) goto L79;
        String r32 = "";
    L80:
        r112.setSpringGuideCardId(r32);
        r112.setSpringGuide(r24);
        r112.setDelayRequestIntervalMs(r26);
        r112.setIntervalMs(r25);
        r112.setEntryToSendMsgCost(r27);
        r112.setSendMsgContentType(Integer.valueOf(r5));
        r112.setLocalSendMsgId(r64);
        r112.setCvsId(r65);
        BotInfoCache r33 = BotInfoCache.INSTANCE;
        r112.setBotId(r33.getBotId(r65));
        ChatControlTrace r34 = ChatControlTrace.b;
        r34.getClass();
        wc9.e r35 = (wc9.e) ChatControlTrace.o.get(r65);
        if (r35 == null) goto L83;
        String r36 = ic8.n.i(r35);
    L84:
        r112.setConvType(r36);
        if (r35 == null) goto L87;
        Integer r37 = r35.v;
    L88:
        r112.setChatType(r34.g(r37, r33.getBotType(r65), r33.isOwnBot(r65)));
        r112.setSendStartTime(Long.valueOf(r111));
        r30.i("CommonParamManager", "createAndSave, param=" + r112);
        r29.report(r64);
        final List r38 = r6;
        com.larus.utils.t0.a(new d(r64, r65, r66, r5, r38, r110));
        IObricAppreciablePoint.a.getClass();
        IObricAppreciablePoint r39 = IObricAppreciablePoint.a.b;
        if (r39 == null) goto L91;
        r39.b(r64);
    L91:
        com.larus.bmhome.chat.trace.container.b r40 = com.larus.bmhome.chat.trace.container.b.a;
        CommonParamManager.CommonParam r41 = CommonParamManager.c(r64);
        if (r41 == null) goto L94;
        String r42 = r41.getConvType();
    L95:
        if (r42 != null) goto L97;
        r42 = "";
    L97:
        com.larus.bmhome.chat.trace.container.b.o(r64, r42);
        HashMap<String, lo8.a.C0116a> r43 = lo8.a.a;
        Intrinsics.checkNotNullParameter(r64, "localMsgId");
        lo8.a.b.put(r64, null);
        return;
    L94:
        r42 = null;
        goto L95
    L87:
        r37 = null;
        goto L88
    L83:
        r36 = null;
        goto L84
    L79:
        r32 = r17;
        goto L80
    L69:
        if (r7.length() <= 0) goto L71;
        r18 = true;
    L71:
        if (r18 == false) goto L73;
        r113 = r7;
    L74:
        if (r113 != null) goto L76;
    L73:
        r113 = null;
        goto L74
    L65:
        r28 = -1;
        goto L66
    L61:
        r27 = null;
        goto L62
    L58:
        r26 = null;
        goto L59
    L53:
        r21 = -1;
        goto L54
    L55:
        r24 = "";
        r25 = r24;
        goto L56
    L45:
        if ((!r10.isEmpty()) != true) goto L47;
        r11 = true;
    L41:
        r17 = null;
    L28:
        r4 = null;
    L31:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L21:
        r8 = r71;
        goto L22
    L17:
        r7 = r70;
        goto L19
    L13:
        r1 = r69;
        goto L15
    L9:
        r6 = r68;
        goto L11
    L5:
        r5 = r67;
        goto L7
    }
}
