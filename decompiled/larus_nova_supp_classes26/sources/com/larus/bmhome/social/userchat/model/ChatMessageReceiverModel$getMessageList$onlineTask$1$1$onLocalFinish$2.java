package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.ConflatedFlow;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onLocalFinish$2", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onLocalFinish$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $anchorIndex;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ long $cursorGeneration;
    final /* synthetic */ boolean $isAnchorRoute;
    final /* synthetic */ boolean $isFromInit;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ ConflatedFlow<LoadState> $loaderBarrier;
    final /* synthetic */ String $localTraceId;
    final /* synthetic */ int $messageLimit;
    final /* synthetic */ com.larus.bmhome.social.page.datasource.event.e $operation;
    final /* synthetic */ List<Message> $result;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;
    final /* synthetic */ w this$1;

    public ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onLocalFinish$2(long r4, ChatMessageReceiverModel r6, List<Message> r7, String r8, w r9, boolean r10, com.larus.bmhome.social.page.datasource.event.e r11, ConflatedFlow<LoadState> r12, boolean r13, String r14, boolean r15, long r16, int r18, Continuation<? super ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onLocalFinish$2> r19) {
        this.$cursorGeneration = r4;
        this.this$0 = r6;
        this.$result = r7;
        this.$localTraceId = r8;
        this.this$1 = r9;
        this.$isRefresh = r10;
        this.$operation = r11;
        this.$loaderBarrier = r12;
        this.$isFromInit = r13;
        this.$conversationId = r14;
        this.$isAnchorRoute = r15;
        this.$anchorIndex = r16;
        this.$messageLimit = r18;
        super(2, r19);
    }

    public final Continuation<Unit> create(Object r20, Continuation<?> r21) {
        return new ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onLocalFinish$2(this.$cursorGeneration, this.this$0, this.$result, this.$localTraceId, this.this$1, this.$isRefresh, this.$operation, this.$loaderBarrier, this.$isFromInit, this.$conversationId, this.$isAnchorRoute, this.$anchorIndex, this.$messageLimit, r21);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L104;
        ResultKt.throwOnFailure(r18);
        if (this.$cursorGeneration == this.this$0.z.get()) goto L9;
        FLogger.a.i(this.this$0.k, "skip stale local message list task: " + this.$cursorGeneration);
        return Unit.INSTANCE;
    L9:
        if (this.$result.isEmpty() == false) goto L15;
        FLogger r1 = FLogger.a;
        StringBuilder r9 = new StringBuilder("refreshTrace end=no_data_change rt=");
        r9.append(this.$localTraceId);
        r9.append(" source=local cost=");
        ChatMessageReceiverModel r10 = this.this$0;
        String r11 = this.$localTraceId;
        r10.getClass();
        r9.append(ChatMessageReceiverModel.x(r11));
        r1.w("MsgRefreshFlow_ChatMessageReceiverModel", r9.toString());
        IAppLaunchReporter r2 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r2 == null) goto L13;
        r2.b("load_message_from_db", MapsKt.mapOf(new Pair[]{TuplesKt.to("message_count", Boxing.boxInt(0)), TuplesKt.to("im_callback", "onLocalFinish")}));
    L13:
        CompletableDeferred<Unit> r3 = this.this$0.s;
        Unit r4 = Unit.INSTANCE;
        r3.complete(r4);
        return r4;
    L15:
        ArrayList r5 = new ArrayList(this.$result);
        w r12 = this.this$1;
        r12.getClass();
        String r13 = null;
        if (com.larus.platform.exp.p.e == true) goto L18;
    L74:
        boolean r14 = false;
    L75:
        if (r14 == false) goto L78;
        this.this$1.a = true;
    L78:
        if (this.$isRefresh == false) goto L96;
        w.a(this.this$1, this.$operation, this.$result);
        this.$loaderBarrier.b(LoadState.READY_TO_LOAD);
        FLogger r15 = FLogger.a;
        r15.i(this.this$0.k, "onLoadFromLocal, isFromInit=" + this.$isFromInit);
        this.this$0.N = true;
        if (this.$isFromInit == false) goto L94;
        String r16 = this.$conversationId;
        CompletableDeferred<Boolean> r17 = wr8.d.a;
        wc9.e r19 = wr8.d.b.a();
        if (r19 == null) goto L85;
        r13 = r19.a;
    L85:
        if (Intrinsics.areEqual(r16, r13) == false) goto L94;
        ChatMessageReceiverModel r110 = this.this$0;
        String r111 = this.$localTraceId;
        r110.getClass();
        r15.i(r110.k, "overridePreloadData msgList size " + r5.size());
        r110.l(r5);
        if (r5.isEmpty() == true) goto L96;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r112 = r5.iterator();
    L91:
        if (r112.hasNext() == false) goto L93;
        r20.add(r110.v((Message) r112.next()));
        goto L91
    L93:
        r110.u.d(r20);
        r110.n.clear();
        r110.n.addAll(r20);
        r110.o.clear();
        ChatMessageReceiverModel.w(r110.o, r20);
        r110.o();
        ChatMessageReceiverModel.u(r110, null, "overridePreloadData", r111, null, 19);
    L94:
        ChatMessageReceiverModel.j(this.this$0, 0, r5, false, null, this.$localTraceId, null, 32);
    L96:
        if (this.$isAnchorRoute == false) goto L98;
        FLogger.a.i(this.this$0.k, "search model, load data from local success! localIndex=" + this.$anchorIndex + " limit=" + this.$messageLimit + " messageSize=" + r5.size() + '}');
    L98:
        IAppLaunchReporter r21 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r21 == null) goto L101;
        r21.b("load_message_from_db", MapsKt.mapOf(new Pair[]{TuplesKt.to("message_count", Boxing.boxInt(r5.size())), TuplesKt.to("im_callback", "onLocalFinish")}));
    L101:
        this.this$0.r("getMessageList local", r5);
        CompletableDeferred<Unit> r6 = this.this$0.s;
        Unit r7 = Unit.INSTANCE;
        r6.complete(r7);
        return r7;
    L18:
        if (r12.b == false) goto L74;
        if (r12.c == true) goto L74;
        ChatMessageReceiverModel r22 = r12.d;
        if (r22.i == true) goto L74;
        Function0<wc9.e> r23 = r22.f;
        if (r23 == null) goto L26;
        wc9.e r24 = (wc9.e) r23.invoke();
    L28:
        if (ic8.n.v(r24) == false) goto L74;
        if ((!r5.isEmpty()) == false) goto L74;
        if (r5.isEmpty() == true) goto L71;
        Iterator r25 = r5.iterator();
    L36:
        if (r25.hasNext() == false) goto L71;
        Message r113 = (Message) r25.next();
        if (com.larus.bmhome.chat.bean.d.W0(r113) == false) goto L40;
    L68:
        boolean r114 = true;
    L69:
        if (r114 == true) goto L36;
        boolean r26 = false;
    L72:
        if (r26 == false) goto L74;
        r14 = true;
        goto L75
    L40:
        if (com.larus.bmhome.chat.bean.d.i0(r113) == false) goto L45;
        if (com.larus.bmhome.chat.bean.d.w(r113) == true) goto L45;
    L64:
        boolean r115 = false;
    L65:
        if (r115 == false) goto L68;
        r114 = false;
    L45:
        if (com.larus.bmhome.chat.bean.d.T(r113) == true) goto L64;
        if (com.larus.bmhome.chat.bean.d.p0(r113) == true) goto L64;
        if (com.larus.bmhome.chat.bean.d.C0(r113) == true) goto L52;
    L54:
        MessageStatus r116 = r113.getMessageStatus();
        if (r116 != null) goto L57;
    L59:
        boolean r117 = false;
    L60:
        if (r117 == false) goto L62;
    L63:
        r115 = true;
        goto L65
    L62:
        if (b0.f(r113) == false) goto L64;
    L57:
        if (r116.isVisible() != true) goto L59;
        r117 = true;
        goto L60
    L52:
        if (r113.getRegenVisible() == true) goto L54;
    L71:
        r26 = true;
        goto L72
    L26:
        r24 = null;
        goto L28
    L104:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
