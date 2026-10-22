package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy$uploadSingleQuestionImagesInParallel$1", f = "ChatRetryStrategy.kt", i = {}, l = {408}, m = "invokeSuspend", n = {}, s = {})
final class ChatRetryStrategy$uploadSingleQuestionImagesInParallel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $localResPath;
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $originPath;
    int label;
    final /* synthetic */ ChatRetryStrategy this$0;

    public ChatRetryStrategy$uploadSingleQuestionImagesInParallel$1(ChatRetryStrategy r1, Message r2, String r3, String r4, ChatPageContext r5, wc9.e r6, Continuation<? super ChatRetryStrategy$uploadSingleQuestionImagesInParallel$1> r7) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$originPath = r3;
        this.$localResPath = r4;
        this.$chatPageContext = r5;
        this.$conversation = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatRetryStrategy$uploadSingleQuestionImagesInParallel$1(this.this$0, this.$msg, this.$originPath, this.$localResPath, this.$chatPageContext, this.$conversation, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r43) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r43);
        Object r3 = r43;
    L11:
        final MediaAttachment r4 = (MediaAttachment) r3;
        final Object r17 = new Object();
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        final Ref.ObjectRef r19 = new Ref.ObjectRef();
        final Ref.BooleanRef r20 = new Ref.BooleanRef();
        final Ref.LongRef r21 = new Ref.LongRef();
        final Ref.LongRef r22 = new Ref.LongRef();
        final Ref.LongRef r23 = new Ref.LongRef();
        final Ref.BooleanRef r24 = new Ref.BooleanRef();
        FLogger.a.i("ChatRetryStrategy", "retry single question: start parallel upload, messageId:" + this.$msg.getLocalMessageId());
        final ChatRetryStrategy r5 = this.this$0;
        ChatSender r15 = r5.a.e;
        String r14 = this.$originPath;
        UploadDataType r39 = UploadDataType.IMAGE;
        final Message r13 = this.$msg;
        final String r12 = this.$localResPath;
        final ChatPageContext r11 = this.$chatPageContext;
        final wc9.e r10 = this.$conversation;
        Function1 r29 = new m(r17, r24, r20, r18, r21, r19, r22, r13, r5, r4, r12, r11, r10);
        Function1 r16 = new n(r17, r24, r20, r19, r21, r22, r18, r23, r5, r13);
        Function1 r6 = new o(r17, r13, r24, r20, r19, r5, r4, r12, r11, r10);
        Boolean r33 = Boxing.boxBoolean(ChatRetryStrategy.j(r14));
        String r35 = this.$msg.getLocalMessageId() + "_origin";
        FlowResourceScene r40 = FlowResourceScene.ImageVLM;
        u1$a.h(r15, r14, null, r39, r29, r16, r6, r14, r33, null, r35, r40, null, 9408);
        final ChatRetryStrategy r7 = this.this$0;
        ChatSender r110 = r7.a.e;
        final String r111 = this.$localResPath;
        final Message r112 = this.$msg;
        final ChatPageContext r113 = this.$chatPageContext;
        final wc9.e r114 = this.$conversation;
        Function1 r32 = new p(r17, r24, r20, r18, r21, r19, r22, r112, r7, r4, r111, r113, r114);
        Function1 r34 = new q(r17, r24, r20, r19, r21, r22, r18, r23, r7, r112);
        Function1 r36 = new r(r17, r112, r7, r24, r19);
        String r8 = this.$originPath;
        u1$a.h(r110, r111, null, r39, r32, r34, r36, r8, Boxing.boxBoolean(ChatRetryStrategy.j(r8)), null, this.$msg.getLocalMessageId(), r40, null, 9408);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r43);
        ChatRetryStrategy r9 = this.this$0;
        Message r25 = this.$msg;
        this.label = 1;
        r3 = ChatRetryStrategy.c(r9, r25, this);
        if (r3 != r1) goto L11;
        return r1;
    }

    public static final void a(Message r22, ChatRetryStrategy r23, MediaAttachment r24, String r25, ChatPageContext r26, wc9.e r27, mr9.l r28, mr9.l r29) {
        if (r28 == null) goto L5;
        n0 r3 = n0.a;
        Map r4 = r22.getExt();
        r3.getClass();
        Map r5 = n0.k(r4, r28);
    L6:
        Integer r6 = null;
        if (r5 == null) goto L9;
        Map r14 = ChatRetryStrategy.b(r23, r5, r29, r24);
    L10:
        Map r7 = r22.getBusinessExt();
        if (r7 != null) goto L13;
        r7 = new LinkedHashMap();
    L13:
        Map r8 = com.larus.utils.h.c(r7, new Pair[0]);
        r8.put("send_loading", ic8.j.f(r22));
        r8.put("loading", "0");
        r8.put("progress", "0");
        String r9 = r29.a;
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        String r10 = r9;
        mr9.d r11 = r29.d;
        if (r11 == null) goto L19;
        Integer r12 = Integer.valueOf(r11.a);
    L20:
        mr9.d r13 = r29.d;
        if (r13 == null) goto L23;
        r6 = Integer.valueOf(r13.b);
    L23:
        ai8.e r15 = new ai8.e(r25, r10, r12, r6, null, null, r22.getLocalMessageId(), com.larus.bmhome.chat.bean.d.b1(r22), r14, r8, true, r26, null, null, 24688);
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("retry single question: main upload succeeded, originUploaded:");
        if (r28 == null) goto L26;
        boolean r18 = true;
    L27:
        r17.append(r18);
        r17.append(", messageId:");
        r17.append(r22.getLocalMessageId());
        r16.i("ChatRetryStrategy", r17.toString());
        ChatRetryStrategy.a(r23, r27, r15, r29.a);
        return;
    L26:
        r18 = false;
        goto L27
    L19:
        r12 = null;
        goto L20
    L9:
        r14 = null;
        goto L10
    L5:
        r5 = r22.getExt();
        goto L6
    }

    public static final void c(Object r0, Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef<mr9.l> r3, Ref.LongRef r4, Ref.LongRef r5, Ref.ObjectRef<mr9.l> r6, Ref.LongRef r7, ChatRetryStrategy r8, Message r9, boolean r10, mr9.k r11) {
        monitor-enter(r0);
    L37:
        th = move-exception;
        throw th;
    L4:
        if (r1.element == true) goto L35;
        if (r10 == true) goto L7;
    L8:
        if (r10 == false) goto L10;
    L12:
        if (r10 == false) goto L18;
        Long r12 = r11.a;     // Catch: Throwable -> L37
        if (r12 == null) goto L16;
        long r13 = r12.longValue();     // Catch: Throwable -> L37
    L17:
        r4.element = r13;     // Catch: Throwable -> L37
    L24:
        if (r2.element == true) goto L26;
    L28:
        long r14 = (r4.element + r5.element) / ((long) 2);     // Catch: Throwable -> L37
    L29:
        long r15 = Math.max(r7.element, r14);     // Catch: Throwable -> L37
        r7.element = r15;     // Catch: Throwable -> L37
        ChatSender r16 = r8.a.e;     // Catch: Throwable -> L37
        String r17 = r9.getLocalMessageId();     // Catch: Throwable -> L37
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        r16.O(r17, r15);     // Catch: Throwable -> L37
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r0);
        return;
    L26:
        if (r6.element != null) goto L28;
        r14 = r5.element;     // Catch: Throwable -> L37
        goto L29
    L16:
        r13 = r4.element;     // Catch: Throwable -> L37
        goto L17
    L18:
        Long r19 = r11.a;     // Catch: Throwable -> L37
        if (r19 == null) goto L21;
        long r110 = r19.longValue();     // Catch: Throwable -> L37
    L22:
        r5.element = r110;     // Catch: Throwable -> L37
        goto L24
    L21:
        r110 = r5.element;     // Catch: Throwable -> L37
        goto L22
    L10:
        if (r3.element == null) goto L12;
    L7:
        if (r2.element == false) goto L8;
    L35:
        monitor-exit(r0);
    }

    public static final void e(Object r10, Ref.BooleanRef r11, Ref.BooleanRef r12, Ref.ObjectRef<mr9.l> r13, Ref.LongRef r14, Ref.ObjectRef<mr9.l> r15, Ref.LongRef r16, Message r17, ChatRetryStrategy r18, MediaAttachment r19, String r20, ChatPageContext r21, wc9.e r22, boolean r23, mr9.l r24) {
        monitor-enter(r10);
        Pair r6 = null;
        if (r11.element == false) goto L8;
    L18:
        monitor-exit(r10);
        if (r6 == null) goto L26;
        a(r17, r18, r19, r20, r21, r22, (mr9.l) r6.component1(), (mr9.l) r6.component2());
        return;
    L26:
        return;
    L8:
        if (r23 == true) goto L10;
        r15.element = r24;     // Catch: Throwable -> L22
        r16.element = 100;     // Catch: Throwable -> L22
        if (r12.element == false) goto L18;
        r11.element = true;     // Catch: Throwable -> L22
        r6 = TuplesKt.to(r13.element, r24);     // Catch: Throwable -> L22
        goto L18
    L10:
        if (r12.element == true) goto L18;
        r13.element = r24;     // Catch: Throwable -> L22
        r12.element = true;     // Catch: Throwable -> L22
        r14.element = 100;     // Catch: Throwable -> L22
        mr9.l r1 = (mr9.l) r15.element;     // Catch: Throwable -> L22
        if (r1 == null) goto L18;
        r11.element = true;     // Catch: Throwable -> L22
        r6 = TuplesKt.to(r24, r1);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
