package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.ConflatedFlow;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onSuccess$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $anchorIndex;
    final /* synthetic */ vr8.b $callback;
    final /* synthetic */ boolean $completed;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ int $conversationType;
    final /* synthetic */ long $cursorGeneration;
    final /* synthetic */ boolean $isAnchorRoute;
    final /* synthetic */ ConflatedFlow<LoadState> $loaderBarrier;
    final /* synthetic */ long $maxIndex;
    final /* synthetic */ int $messageLimit;
    final /* synthetic */ com.larus.bmhome.social.page.datasource.event.e $operation;
    final /* synthetic */ String $remoteTraceId;
    final /* synthetic */ List<Message> $result;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;
    final /* synthetic */ w this$1;

    public ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onSuccess$1(long r4, ChatMessageReceiverModel r6, vr8.b r7, com.larus.bmhome.social.page.datasource.event.e r8, boolean r9, long r10, int r12, List<Message> r13, w r14, String r15, String r16, int r17, boolean r18, long r19, ConflatedFlow<LoadState> r21, Continuation<? super ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onSuccess$1> r22) {
        this.$cursorGeneration = r4;
        this.this$0 = r6;
        this.$callback = r7;
        this.$operation = r8;
        this.$isAnchorRoute = r9;
        this.$anchorIndex = r10;
        this.$messageLimit = r12;
        this.$result = r13;
        this.this$1 = r14;
        this.$remoteTraceId = r15;
        this.$conversationId = r16;
        this.$conversationType = r17;
        this.$completed = r18;
        this.$maxIndex = r19;
        this.$loaderBarrier = r21;
        super(2, r22);
    }

    public final Continuation<Unit> create(Object r25, Continuation<?> r26) {
        return new ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onSuccess$1(this.$cursorGeneration, this.this$0, this.$callback, this.$operation, this.$isAnchorRoute, this.$anchorIndex, this.$messageLimit, this.$result, this.this$1, this.$remoteTraceId, this.$conversationId, this.$conversationType, this.$completed, this.$maxIndex, this.$loaderBarrier, r26);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L227;
        ResultKt.throwOnFailure(r26);
        if (this.$cursorGeneration == this.this$0.z.get()) goto L14;
        FLogger.a.i(this.this$0.k, "skip stale remote message list task: " + this.$cursorGeneration);
        vr8.b r1 = this.$callback;
        if (r1 == null) goto L12;
        com.larus.bmhome.social.page.datasource.event.e r2 = this.$operation;
        if ((r2 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L12;
        r1.b((com.larus.bmhome.social.page.datasource.event.e.a) r2);
    L12:
        return Unit.INSTANCE;
    L14:
        if (this.$isAnchorRoute == false) goto L16;
        FLogger.a.i(this.this$0.k, "search model, load data from server success! localIndex=" + this.$anchorIndex + " limit=" + this.$messageLimit + " messageSize=" + this.$result.size());
    L16:
        this.this$0.r("getMessageList success", this.$result);
        w r3 = this.this$1;
        List<Message> r4 = this.$result;
        r3.getClass();
        if (com.larus.platform.exp.p.e == true) goto L19;
    L61:
        boolean r5 = false;
    L63:
        if (r5 == false) goto L91;
        w r6 = this.this$1;
        r6.a = false;
        Iterator<T> r9 = this.$result.iterator();
        if (r9.hasNext() == true) goto L67;
        Long r10 = null;
    L73:
        if (r10 != null) goto L93;
        Function0<wc9.e> r7 = r6.d.f;
        if (r7 == null) goto L91;
        wc9.e r8 = (wc9.e) r7.invoke();
        if (r8 == null) goto L91;
        Long r11 = r8.q;
        if (r11 == null) goto L91;
        long r12 = r11.longValue();
        if (r12 > 0) goto L83;
    L85:
        boolean r13 = false;
    L86:
        if (r13 == true) goto L89;
        r11 = null;
    L89:
        if (r11 == null) goto L91;
        r10 = Long.valueOf((r11.longValue() * 1000) + 1);
        goto L93
    L83:
        if (r12 > 9223372036854775L) goto L85;
        r13 = true;
    L93:
        if (r10 != null) goto L95;
    L117:
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        com.larus.bmhome.social.page.datasource.event.e r15 = this.$operation;
        if ((r15 instanceof com.larus.bmhome.social.page.datasource.event.e.a.C0035a) == false) goto L206;
        List<Message> r16 = this.$result;
        long r17 = this.$maxIndex;
        if ((r16 instanceof Collection) == true) goto L122;
    L124:
        Iterator<T> r18 = r16.iterator();
    L126:
        if (r18.hasNext() == false) goto L135;
        Message r19 = (Message) r18.next();
        if (r19.getLocalIndex() > 0) goto L130;
    L132:
        boolean r20 = false;
    L133:
        if (r20 == false) goto L126;
        boolean r21 = true;
    L136:
        CopyOnWriteArrayList<Message> r22 = this.this$0.n;
        ListIterator<Message> r23 = r22.listIterator(r22.size());
    L138:
        if (r23.hasPrevious() == false) goto L172;
        Message r24 = r23.previous();
        Message r110 = r24;
        if (r110.getLocalIndex() <= 0) goto L169;
        Intrinsics.checkNotNull(r110);
        if (com.larus.bmhome.chat.bean.d.i0(r110) == false) goto L147;
        if (com.larus.bmhome.chat.bean.d.w(r110) == true) goto L147;
    L166:
        boolean r111 = false;
    L167:
        if (r111 == false) goto L169;
        boolean r112 = true;
    L170:
        if (r112 == false) goto L138;
    L173:
        Message r25 = r24;
        if (r25 == null) goto L176;
        Long r27 = Boxing.boxLong(r25.getLocalIndex());
    L177:
        int r28 = ra9.a.a;
        if (ga9.a.d("insert_visible_message_timestamp_interval", 900) <= 0) goto L192;
        Function0<wc9.e> r29 = this.this$0.f;
        if (r29 == null) goto L182;
        wc9.e r30 = (wc9.e) r29.invoke();
    L184:
        if (ic8.n.D(r30) == false) goto L192;
        if (this.this$0.i == true) goto L192;
        if (this.$completed == true) goto L192;
        if (r21 == true) goto L192;
        if (r27 == null) goto L192;
        boolean r31 = true;
    L193:
        r14.element = r31;
        if (r31 == false) goto L201;
        ChatMessageReceiverModel r32 = this.this$0;
        r32.B = r27;
        vr8.b r33 = this.$callback;
        if ((r33 instanceof vr8.g) == false) goto L198;
        vr8.g r34 = (vr8.g) r33;
    L199:
        if (r34 == null) goto L203;
        r32.C = r34;
    L203:
        if (r14.element == false) goto L208;
        FLogger.a.i(this.this$0.k, "use visible history boundary because append cursor cannot advance, requestMaxIndex=" + this.$maxIndex + ", visibleLocalIndex=" + r27);
    L208:
        final vr8.b r113 = this.$callback;
        if (r113 == null) goto L213;
        final com.larus.bmhome.social.page.datasource.event.e r114 = this.$operation;
        if ((r114 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L213;
        final List<Message> r115 = this.$result;
        final boolean r116 = this.$completed;
        v r117 = new v(r113, r114, r115, r116, r14);
    L214:
        w.a(this.this$1, this.$operation, this.$result);
        ConflatedFlow<LoadState> r35 = this.$loaderBarrier;
        if (this.$completed == false) goto L217;
        LoadState r36 = LoadState.COMPLETE;
    L218:
        r35.b(r36);
        this.this$0.N = true;
        ChatMessageReceiverModel.j(this.this$0, 0, this.$result, this.$completed, r117, this.$remoteTraceId, null, 32);
        ChatMessageReceiverModel r37 = this.this$0;
        vr8.b r38 = r37.O;
        if (r38 == null) goto L221;
        r37.b(r38, null);
    L221:
        this.this$0.O = null;
        IAppLaunchReporter r39 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r39 == null) goto L224;
        r39.b("load_message_from_db", MapsKt.mapOf(new Pair[]{TuplesKt.to("message_count", Boxing.boxInt(this.$result.size())), TuplesKt.to("im_callback", "onSuccess")}));
    L224:
        CompletableDeferred<Unit> r40 = this.this$0.s;
        Unit r41 = Unit.INSTANCE;
        r40.complete(r41);
        return r41;
    L217:
        r36 = LoadState.READY_TO_LOAD;
    L213:
        r117 = 0;
        goto L214
    L198:
        r34 = null;
        goto L199
    L201:
        this.this$0.m(!this.$completed);
        goto L203
    L182:
        r30 = null;
    L192:
        r31 = false;
        goto L193
    L176:
        r27 = null;
    L147:
        if (com.larus.bmhome.chat.bean.d.T(r110) == true) goto L166;
        if (com.larus.bmhome.chat.bean.d.p0(r110) == true) goto L166;
        if (com.larus.bmhome.chat.bean.d.C0(r110) == true) goto L154;
    L156:
        MessageStatus r118 = r110.getMessageStatus();
        if (r118 != null) goto L159;
    L161:
        boolean r119 = false;
    L162:
        if (r119 == false) goto L164;
    L165:
        r111 = true;
        goto L167
    L164:
        if (b0.f(r110) == false) goto L166;
    L159:
        if (r118.isVisible() != true) goto L161;
        r119 = true;
        goto L162
    L154:
        if (r110.getRegenVisible() == true) goto L156;
    L169:
        r112 = false;
        goto L170
    L172:
        r24 = null;
        goto L173
    L130:
        if (r19.getLocalIndex() >= r17) goto L132;
        r20 = true;
    L135:
        r21 = false;
        goto L136
    L122:
        if (r16.isEmpty() == false) goto L124;
    L206:
        if ((r15 instanceof com.larus.bmhome.social.page.datasource.event.e.b) == false) goto L208;
        this.this$0.m(true);
        goto L208
    L95:
        if (r10.longValue() <= 1000) goto L117;
        if (r10.longValue() >= Long.MAX_VALUE) goto L117;
        if (Intrinsics.areEqual(r10, this.this$0.y) == false) goto L101;
    L103:
        boolean r42 = false;
    L104:
        bi8.d r43 = bi8.d.a;
        String r44 = "request_index=" + r10 + ",remote_count=" + this.$result.size() + ",should_request=" + r42;
        Intrinsics.checkNotNullParameter(r44, "extra");
        com.larus.platform.service.g r120 = com.larus.platform.service.g.a;     // Catch: Throwable -> L107
        JSONObject r121 = new JSONObject();     // Catch: Throwable -> L107
        r121.put("event_name", "get_message_list");     // Catch: Throwable -> L107
        r121.put("event_type", "empty_first_page_load_more");     // Catch: Throwable -> L107
        r121.put("extra", r44);     // Catch: Throwable -> L107
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L107
        r120.monitorEventForSlardar("chat_message_list_monitor", r121, null, null);     // Catch: Throwable -> L107
    L108:
        FLogger.a.i("MessageListExtraPage", "loadMoreOnEmptyFirstPage cursor=" + r10 + " request=" + r42 + " rt=" + this.$remoteTraceId);
        if (r42 == false) goto L111;
    L112:
        w.a(this.this$1, this.$operation, this.$result);
        ChatMessageReceiverModel.j(this.this$0, 0, this.$result, false, null, this.$remoteTraceId, null, 32);
        if (r42 == false) goto L116;
        this.this$0.L.b(LoadState.LOADING);
        ChatMessageReceiverModel r122 = this.this$0;
        vr8.b r46 = r122.O;
        r122.O = null;
        ChatMessageReceiverModel.n(r122, this.$conversationId, this.$conversationType, r10.longValue(), false, this.this$0.G.b() * 2, 0, com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a, r46, null, false, 808);
    L116:
        return Unit.INSTANCE;
    L111:
        if (this.this$0.L.a() == LoadState.READY_TO_LOAD) goto L117;
    L101:
        if (this.this$0.L.a() != LoadState.READY_TO_LOAD) goto L103;
        r42 = true;
        goto L104
    L67:
        r10 = Long.valueOf(((Message) r9.next()).getLocalIndex());
    L69:
        if (r9.hasNext() == false) goto L73;
        Long r123 = Long.valueOf(((Message) r9.next()).getLocalIndex());
        if (r10.compareTo(r123) <= 0) goto L69;
        r10 = r123;
    L91:
        r10 = null;
        goto L93
    L19:
        if (r3.b == false) goto L61;
        if (r3.a == false) goto L61;
        List<Message> r47 = r4;
        if ((r47 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r48 = r47.iterator();
    L29:
        if (r48.hasNext() == false) goto L58;
        Message r49 = (Message) r48.next();
        if (com.larus.bmhome.chat.bean.d.i0(r49) == false) goto L36;
        if (com.larus.bmhome.chat.bean.d.w(r49) == true) goto L36;
    L55:
        boolean r50 = false;
    L56:
        if (r50 == false) goto L29;
        boolean r51 = false;
    L59:
        if (r51 == false) goto L61;
        r5 = true;
    L36:
        if (com.larus.bmhome.chat.bean.d.T(r49) == true) goto L55;
        if (com.larus.bmhome.chat.bean.d.p0(r49) == true) goto L55;
        if (com.larus.bmhome.chat.bean.d.C0(r49) == true) goto L43;
    L45:
        MessageStatus r52 = r49.getMessageStatus();
        if (r52 != null) goto L48;
    L50:
        boolean r53 = false;
    L51:
        if (r53 == false) goto L53;
    L54:
        r50 = true;
        goto L56
    L53:
        if (b0.f(r49) == false) goto L55;
    L48:
        if (r52.isVisible() != true) goto L50;
        r53 = true;
        goto L51
    L43:
        if (r49.getRegenVisible() == true) goto L45;
    L58:
        r51 = true;
        goto L59
    L25:
        if (r47.isEmpty() == false) goto L27;
    L227:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
