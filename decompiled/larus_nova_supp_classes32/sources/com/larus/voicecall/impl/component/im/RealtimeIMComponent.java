package com.larus.voicecall.impl.component.im;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.j;
import com.larus.im.observer.MessageListState;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import pf9.a0;
import pf9.f0;
import pf9.i;
import pf9.k0;
import pf9.m;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001+\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020.H\u0016J\u0012\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020.2\u0006\u00104\u001a\u000207H\u0002J\b\u00108\u001a\u00020.H\u0002J\u0018\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020.H\u0016J\b\u0010>\u001a\u00020.H\u0016J\b\u0010?\u001a\u00020.H\u0002J\b\u0010@\u001a\u00020'H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,¨\u0006B"}, d2 = {"Lcom/larus/voicecall/impl/component/im/RealtimeIMComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/im/IRealtimeIMAbility;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "asrTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "imAsrMsgNum", "Ljava/util/concurrent/CopyOnWriteArraySet;", "imTtsMsgNum", "imTtsPreQueryMsgMap", "vuiAsrMsgIdSet", "vuiChatRespMsgIdSet", "vuiTtsRespMsgNum", NameKeys.UnloadStrategy_No_Strategy, "isFirstTTSResponse", NameKeys.UnloadStrategy_No_Strategy, "currentQuestionId", "currentAnswerId", "messageChangedObserver", "com/larus/voicecall/impl/component/im/RealtimeIMComponent$messageChangedObserver$1", "Lcom/larus/voicecall/impl/component/im/RealtimeIMComponent$messageChangedObserver$1;", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onVContextReady", "onCreate", "handleTtsResponseResult", "ttsContentScene", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "onReplyUpdate", "Lcom/larus/im/service/audio/event/FlowLLMReplyUpdateEvent;", "onQueryEndEvent", "onMessageReceived", "cid", "msg", "Lcom/larus/im/bean/message/Message;", "onDestroy", "onConvIdUpdate", "tryUpdateConv", "isAsrMsgNotZero", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeIMComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.im.a {
    public static final /* synthetic */ int C = 0;
    public String A;
    public final b B;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final ConcurrentHashMap<String, Long> r;
    public final CopyOnWriteArraySet<String> s;
    public final CopyOnWriteArraySet<String> t;
    public final ConcurrentHashMap<String, String> u;
    public final CopyOnWriteArraySet<String> v;
    public final CopyOnWriteArraySet<String> w;
    public int x;
    public boolean y;
    public String z;

    public static final class a {
    }

    public static final class b implements nf9.b {
        public final /* synthetic */ RealtimeIMComponent a;

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public b(RealtimeIMComponent r1) {
            this.a = r1;
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            RealtimeIMComponent.h3(this.a, r1, r2);
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            RealtimeIMComponent.h3(this.a, r1, r2);
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.component.im.a
    public final boolean Pk() {
        if (this.s.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final e3a.a m3() {
        return (e3a.a) this.n.getValue();
    }

    public final e3a.b p3() {
        return (e3a.b) this.o.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.im.a.class);
    }

    public RealtimeIMComponent() {
        this.n = LazyKt.lazy(new com.larus.voicecall.impl.component.im.b(this));
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new d(this));
        this.q = LazyKt.lazy(new e(this));
        this.r = new ConcurrentHashMap();
        this.s = new CopyOnWriteArraySet();
        this.t = new CopyOnWriteArraySet();
        this.u = new ConcurrentHashMap();
        this.v = new CopyOnWriteArraySet();
        this.w = new CopyOnWriteArraySet();
        this.y = true;
        this.z = NameKeys.UnloadStrategy_No_Strategy;
        this.A = NameKeys.UnloadStrategy_No_Strategy;
        this.B = new b(this);
    }

    public final void A0() {
        m3();
        p3();
        RealtimeCallService r0 = (RealtimeCallService) this.p.getValue();
    }

    @Override // com.larus.voicecall.impl.component.im.a
    public final void i60() {
        if (((h88.a) m3()).k0 == false) goto L6;
        z3();
        return;
    }

    public final void onCreate() {
        com.larus.im.d.e().registerOnMessageChangedObserver(((h88.a) m3()).j, this.B);
    }

    public final void onDestroy() {
        com.larus.im.d.e().unregisterOnMessageChangedObserver(((h88.a) m3()).j, this.B);
        z3();
    }

    public final void z3() {
        String r0 = ((h88.a) m3()).j;
        String r1 = ((h88.a) m3()).f;
        FLogger.a.i("RealtimeIMComponent", "tryUpdateConv, originCvsId=" + r0 + ",cvsId=" + r1);
        if (j.e() == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 != null) goto L13;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        String r3 = r0;
        RealtimeCallUtil r4 = RealtimeCallUtil.a;
        String r5 = ((h88.a) m3()).d;
        String r6 = ((h88.a) m3()).f;
        String r7 = ((h88.b) p3()).a;
        IRealtimeCallTracer r8 = (IRealtimeCallTracer) this.q.getValue();
        CopyOnWriteArraySet<String> r9 = this.s;
        CopyOnWriteArraySet<String> r10 = this.t;
        ConcurrentHashMap<String, String> r11 = this.u;
        CopyOnWriteArraySet<String> r12 = this.v;
        CopyOnWriteArraySet<String> r13 = this.w;
        int r14 = this.x;
        AudioSessionType r15 = ((h88.b) p3()).e;
        r4.getClass();
        RealtimeCallUtil.H(r5, r3, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return;
    L5:
        if (j.g(r0) == false) goto L7;
        r2 = true;
        goto L8
    }

    public final void D9(z0.a r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        boolean r0 = r7 instanceof f0;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        boolean r3 = false;
        if (r0 == false) goto L38;
        f0 r8 = (f0) r7;
        String r5 = null;
        if (i.c(r8) == false) goto L22;
        k0 r2 = r8.b;
        if (r2 == null) goto L9;
        String r4 = r2.f;
    L10:
        if (r4 == null) goto L13;
        r1 = r4;
    L13:
        this.A = r1;
        if (r1.length() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L22;
        if (Intrinsics.areEqual(this.A, "0") == true) goto L22;
        this.w.add(this.A);
        goto L22
    L16:
        r6 = false;
        goto L17
    L9:
        r4 = null;
    L22:
        if (i.j(r8) == false) goto L65;
        m r9 = r8.c;
        if (r9 == null) goto L63;
        Map r10 = r9.a;
        if (r10 == null) goto L63;
        r5 = (String) r10.get("tts_content_scene");
    L63:
        FLogger.a.i("RealtimeIMComponent", "handleTtsResponseResult, " + r5);     // Catch: Exception -> L35
        if (Intrinsics.areEqual(r5, "normal") == true) goto L32;
        return;
    L32:
        if (this.y == false) goto L67;
        this.y = false;     // Catch: Exception -> L35
        this.x++;     // Catch: Exception -> L35
        return;
    L67:
        return;
    L35:
        e = move-exception;
        FLogger.a.e("RealtimeIMComponent", e.getMessage());
        return;
    L65:
        return;
    L38:
        if ((r7 instanceof z) == false) goto L45;
        String r11 = ((z) r7).a;
        if (r11 == null) goto L43;
        r1 = r11;
    L43:
        this.z = r1;
        return;
    L45:
        if ((r7 instanceof a0) == false) goto L70;
        this.y = true;
        if (this.z.length() <= 0) goto L49;
        r3 = true;
    L49:
        if (r3 == false) goto L71;
        this.v.add(this.z);     // Catch: Exception -> L59
        if (this.r.get(this.z) == null) goto L57;
        IRealtimeCallTracer r12 = (IRealtimeCallTracer) this.q.getValue();     // Catch: Exception -> L59
        Long r13 = this.r.get(this.z);     // Catch: Exception -> L59
        if (r13 == null) goto L55;
        long r14 = r13.longValue();     // Catch: Exception -> L59
    L56:
        IRealtimeCallTracer.a.a(r12, r14, System.currentTimeMillis());     // Catch: Exception -> L59
        this.r.remove(this.z);     // Catch: Exception -> L59
        return;
    L55:
        r14 = 0;
        goto L56
    L57:
        this.r.put(this.z, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L59
        return;
    L59:
        e = move-exception;
        FLogger.a.e("RealtimeIMComponent", "ASREnded error: " + e.getMessage());
        return;
    L71:
        return;
    }

    public static final void h3(RealtimeIMComponent r8, String r9, Message r10) {
        r8.getClass();
    L67:
        e = move-exception;
        FLogger.a.e("RealtimeIMComponent", e.getMessage());
        return;
    L4:
        if (Intrinsics.areEqual(r9, ((h88.a) r8.m3()).f) == true) goto L6;
        return;
    L6:
        if (r10.getMessageStatusLocal() != 11) goto L16;
        FLogger r11 = FLogger.a;     // Catch: Exception -> L67
        StringBuilder r4 = new StringBuilder("Query Info: messageId=");     // Catch: Exception -> L67
        r4.append(r10.getMessageId());     // Catch: Exception -> L67
        r4.append(", createTime=");     // Catch: Exception -> L67
        r4.append(r10.getCreateTime());     // Catch: Exception -> L67
        r4.append(", logId=");     // Catch: Exception -> L67
        Map r3 = r10.getExt();     // Catch: Exception -> L67
        if (r3 == null) goto L10;
        String r5 = (String) r3.get("inner_log_id");     // Catch: Exception -> L67
    L11:
        r4.append(r5);     // Catch: Exception -> L67
        r4.append(", text=");     // Catch: Exception -> L67
        String r6 = com.larus.im.bean.message.a.O(r10);     // Catch: Exception -> L67
        if (r6 == null) goto L14;
        String r7 = g2a.d.b(r6);     // Catch: Exception -> L67
    L15:
        r4.append(r7);     // Catch: Exception -> L67
        r11.d("RealtimeIMComponent", r4.toString());     // Catch: Exception -> L67
        goto L16
    L14:
        r7 = null;
        goto L15
    L10:
        r5 = null;
    L16:
        RealtimeCallUtil.a.getClass();     // Catch: Exception -> L67
        Intrinsics.checkNotNullParameter(r10, "msg");     // Catch: Exception -> L67
        boolean r12 = com.larus.bmhome.chat.bean.d.G0(r10);     // Catch: Exception -> L67
        String r13 = NameKeys.UnloadStrategy_No_Strategy;
        if (r12 == false) goto L38;
        Map r14 = r10.getExt();     // Catch: Exception -> L67
        if (r14 == null) goto L22;
        String r15 = (String) r14.get("local_call_id");     // Catch: Exception -> L67
    L24:
        if (Intrinsics.areEqual(r15, ((h88.b) r8.p3()).a) == false) goto L38;
        String r16 = r10.getMessageId();     // Catch: Exception -> L67
        if (r16 == null) goto L29;
        r13 = r16;
    L29:
        r8.s.add(r13);     // Catch: Exception -> L67
        if (r8.r.get(r13) == null) goto L36;
        IRealtimeCallTracer r17 = (IRealtimeCallTracer) r8.q.getValue();     // Catch: Exception -> L67
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L67
        Long r18 = r8.r.get(r13);     // Catch: Exception -> L67
        if (r18 == null) goto L34;
        long r19 = r18.longValue();     // Catch: Exception -> L67
    L35:
        IRealtimeCallTracer.a.a(r17, r1, r19);     // Catch: Exception -> L67
        r8.r.remove(r13);     // Catch: Exception -> L67
        return;
    L34:
        r19 = 0;
        goto L35
    L36:
        r8.r.put(r13, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L67
        return;
    L22:
        r15 = null;
    L38:
        if (com.larus.im.bean.message.a.r0(r10) == false) goto L40;
    L65:
        FLogger.a.i("RealtimeIMComponent", "msgStatusLocal=" + r10.getMessageStatusLocal() + ", isServerLoading=" + com.larus.im.bean.message.a.r0(r10) + ", msgStatus=" + r10.getMessageStatus());     // Catch: Exception -> L67
        return;
    L40:
        if (r10.getMessageStatusLocal() == (-1)) goto L65;
        MessageStatus r20 = r10.getMessageStatus();     // Catch: Exception -> L67
        if (r20 == null) goto L46;
        boolean r21 = true;
        if (r20.isVisible() != true) goto L46;
    L47:
        if (r21 == false) goto L65;
        if (r8.s.contains(r10.getReplyId()) == false) goto L59;
        FLogger.a.i("RealtimeIMComponent", "msgId=" + r10.getMessageId() + ", replyId=" + r10.getReplyId() + ", state=" + r10.getMessageStatus());     // Catch: Exception -> L67
        r8.t.add(r10.getMessageId());     // Catch: Exception -> L67
        String r22 = r10.getReplyId();     // Catch: Exception -> L67
        if (r22 == null) goto L59;
        ConcurrentHashMap<String, String> r2 = r8.u;     // Catch: Exception -> L67
        String r23 = r10.getMessageId();     // Catch: Exception -> L67
        if (r23 == null) goto L57;
        r13 = r23;
    L57:
        r2.put(r22, r13);     // Catch: Exception -> L67
    L59:
        if (r10.getMessageStatusLocal() != 21) goto L74;
        AppHost.Companion r24 = AppHost.a;     // Catch: Exception -> L67
        if (r24.isTestChannel() == false) goto L63;
    L64:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new RealtimeIMComponent$onMessageReceived$2(r8, r10, null), 2, null);     // Catch: Exception -> L67
        return;
    L63:
        if (Intrinsics.areEqual(r24.getBuildChannel(), "auto_test") == true) goto L64;
        return;
    L74:
        return;
    L46:
        r21 = false;
        goto L47
    }
}
