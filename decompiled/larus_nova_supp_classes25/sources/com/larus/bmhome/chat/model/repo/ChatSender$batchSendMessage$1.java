package com.larus.bmhome.chat.model.repo;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$batchSendMessage$1", f = "ChatSender.kt", i = {1}, l = {325, 327}, m = "invokeSuspend", n = {"cvs"}, s = {"L$3"})
public final class ChatSender$batchSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cTraceId;
    final /* synthetic */ IIMCallback<List<Message>> $callback;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ boolean $needInterrupt;
    final /* synthetic */ boolean $sameScene;
    final /* synthetic */ String $scene;
    final /* synthetic */ Long $sendClickTimestamp;
    final /* synthetic */ String $sendFuncChannel;
    final /* synthetic */ List<ic8.w> $strategies;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    final /* synthetic */ ChatSender this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.repo.ChatSender$batchSendMessage$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$batchSendMessage$1$3", f = "ChatSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatSender this$0;

        public AnonymousClass3(ChatSender r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
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
            this.this$0.a.d.d.i6("batchSendMessage", false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSender$batchSendMessage$1(boolean r1, List<? extends ic8.w> r2, ChatSender r3, String r4, String r5, String r6, Long r7, IIMCallback<List<Message>> r8, String r9, boolean r10, Continuation<? super ChatSender$batchSendMessage$1> r11) {
        this.$sameScene = r1;
        this.$strategies = r2;
        this.this$0 = r3;
        this.$cvsId = r4;
        this.$scene = r5;
        this.$cTraceId = r6;
        this.$sendClickTimestamp = r7;
        this.$callback = r8;
        this.$sendFuncChannel = r9;
        this.$needInterrupt = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new ChatSender$batchSendMessage$1(this.$sameScene, this.$strategies, this.this$0, this.$cvsId, this.$scene, this.$cTraceId, this.$sendClickTimestamp, this.$callback, this.$sendFuncChannel, this.$needInterrupt, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r62) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        boolean r3 = this.Z$0;
        wc9.e r4 = (wc9.e) this.L$3;
        String r5 = (String) this.L$2;
        IIMCallback<List<Message>> r6 = (IIMCallback) this.L$1;
        List<ic8.w> r7 = (List) this.L$0;
        ResultKt.throwOnFailure(r62);
        boolean r9 = r3;
        String r8 = r5;
        IIMCallback<List<Message>> r10 = r6;
        List<ic8.w> r11 = r7;
        Object r12 = r62;
    L79:
        ((com.larus.bmhome.chat.model.strategy.g0) r12).h(r4, r11, r10, r8, r9);
    L83:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r62);
        Object r13 = r62;
    L71:
        r4 = (wc9.e) r13;
        if (r4 == null) goto L83;
        ChatSender r14 = this.this$0;
        List<ic8.w> r15 = this.$strategies;
        IIMCallback<List<Message>> r16 = this.$callback;
        String r17 = this.$sendFuncChannel;
        boolean r18 = this.$needInterrupt;
        if (r4.h() == true) goto L80;
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = r17;
        this.L$3 = r4;
        this.Z$0 = r18;
        this.label = 2;
        int r19 = ChatSender.j;
        r12 = r14.C(r4, this);
        if (r12 != r1) goto L78;
        return r1;
    L78:
        r8 = r17;
        r9 = r18;
        r10 = r16;
        r11 = r15;
        goto L79
    L80:
        if (r16 == null) goto L83;
        r16.onFailure(new IMError(-1, "cvs disabled", null, null, 12, null));
        goto L83
    L11:
        ResultKt.throwOnFailure(r62);
        if (this.$sameScene == false) goto L20;
        List<ic8.w> r20 = this.$strategies;
        String r21 = this.$scene;
        Iterator<T> r22 = r20.iterator();
    L15:
        if (r22.hasNext() == false) goto L20;
        ic8.w r23 = (ic8.w) r22.next();
        ChatControlTrace r24 = ChatControlTrace.b;
        String r25 = r23.b();
        if (r25 != null) goto L19;
        r25 = "";
    L19:
        r24.Ma(r25, r21);
    L20:
        List<ic8.w> r26 = this.$strategies;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r27 = r26.iterator();
    L22:
        if (r27.hasNext() == false) goto L24;
        ic8.w r28 = (ic8.w) r27.next();
        int r29 = r28.contentType();
        String r51 = r28.g();
        r110.add(new Message(null, null, null, 0, 0, null, r29, false, null, r28.content(), null, null, null, r28.a(), null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, r51, null, 0, null, null, null, 2147474879, 31, null));
        goto L22
    L24:
        List<ic8.w> r30 = this.$strategies;
        String r111 = this.$cvsId;
        String r112 = this.$cTraceId;
        Long r113 = this.$sendClickTimestamp;
        String r114 = this.$scene;
        Iterator<T> r31 = r30.iterator();
    L25:
        boolean r32 = false;
        if (r31.hasNext() == false) goto L65;
        ic8.w r33 = (ic8.w) r31.next();
        String r34 = r33.b();
        if (r34 != null) goto L30;
        String r35 = "";
    L31:
        Map<String, String> r36 = r33.a();
        String r115 = ChatControlTrace.b.Ia(r35);
        if (r115.length() != 0) goto L34;
        r32 = true;
    L34:
        if (r32 == false) goto L36;
        r115 = r114;
    L36:
        String r37 = r35;
        String r38 = r111;
        String r39 = r35;
        String r40 = r115;
        String r116 = r114;
        Long r210 = r113;
        String r117 = r112;
        String r211 = r111;
        ArrayList r212 = r110;
        com.larus.bmhome.chat.trace.appreciable.f.l(com.larus.bmhome.chat.trace.appreciable.f.a, r37, r38, r40, r33.contentType(), r110, null, r112, r210, 32);
        LruCache r41 = ChatControlTrace.p;
        String r42 = (String) r41.get(r39);
        if (r36 == null) goto L44;
        String r43 = r36.get("content_source");
        if (r43 == null) goto L42;
        r42 = r43;
    L42:
        String r44 = r42;
        if (r44 == null) goto L44;
    L45:
        r41.put(r39, r44);
        LruCache r45 = ChatControlTrace.G;
        if (r36 == null) goto L51;
        String r46 = r36.get("enter_method_trace");
        if (r46 != null) goto L50;
        r46 = "";
    L50:
        String r47 = r46;
    L52:
        r45.put(r39, r47);
        LruCache r48 = ChatControlTrace.K;
        if (r36 == null) goto L58;
        String r49 = r36.get("previous_page_trace");
        if (r49 != null) goto L57;
        r49 = "";
    L57:
        String r50 = r49;
    L59:
        r48.put(r39, r50);
        Integer r52 = ChatControlTrace.p(r36);
        if (r36 == null) goto L62;
        String r118 = r36.get("action_bar_instruction_type");
    L63:
        ChatControlTrace.f0(r39, r118, r52);
        r114 = r116;
        r112 = r117;
        r113 = r210;
        r111 = r211;
        r110 = r212;
        goto L25
    L62:
        r118 = null;
        goto L63
    L58:
        r50 = "";
        goto L59
    L51:
        r47 = "";
    L44:
        r44 = "";
        goto L45
    L30:
        r35 = r34;
        goto L31
    L65:
        if (com.larus.platform.exp.s.e == false) goto L67;
        ChatSender r53 = this.this$0;
        BuildersKt.launch$default(r53.b, null, null, new AnonymousClass3(r53, null), 3, null);
    L68:
        ChatSender r54 = this.this$0;
        String r55 = this.$cvsId;
        this.label = 1;
        r13 = ChatSender.y(r54, r55, this);
        if (r13 != r1) goto L71;
        return r1;
    L67:
        this.this$0.a.d.d.i6("batchSendMessage", false);
        goto L68
    }
}
