package com.larus.bmhome.chat.component.list;

import android.os.SystemClock;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$changeListener$1$handleReceiveStreamReport$1", f = "ChatListComponent.kt", i = {}, l = {1325, 1338}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponent$changeListener$1$handleReceiveStreamReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ Integer $multiQuestionCount;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$changeListener$1$handleReceiveStreamReport$1(Message r1, ChatListComponent r2, String r3, Integer r4, Continuation<? super ChatListComponent$changeListener$1$handleReceiveStreamReport$1> r5) {
        this.$msg = r1;
        this.this$0 = r2;
        this.$token = r3;
        this.$multiQuestionCount = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatListComponent$changeListener$1$handleReceiveStreamReport$1(this.$msg, this.this$0, this.$token, this.$multiQuestionCount, r8);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L49:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r14);
        int r15 = this.$msg.getMessageStatusLocal();
        wc9.e r5 = null;
        if (r15 != 21) goto L13;
        ChatControlTrace r2 = ChatControlTrace.b;
        ChatListComponent r16 = this.this$0;
        int r3 = ChatListComponent.W3;
        com.larus.bmhome.chat.component.cvs.y r17 = r16.u0();
        if (r17 == null) goto L39;
        r5 = r17.h();
    L39:
        wc9.e r4 = r5;
        String r18 = this.$token;
        Message r6 = this.$msg;
        String r7 = r6.getSenderId();
        if (r7 != null) goto L42;
        r7 = "";
    L42:
        Integer r8 = this.this$0.j4();
        Integer r10 = this.$multiQuestionCount;
        this.label = 1;
        Object r19 = r2.Y(r4, r18, r6, null, r7, r8, 0, r10, this);
        if (r19 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        r19 = Unit.INSTANCE;
    L46:
        if (r19 != r0) goto L49;
        return r0;
    L13:
        if (r15 == 22) goto L24;
        ChatControlTrace r110 = ChatControlTrace.b;
        String r9 = this.$token;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r9, "token");
        ConcurrentHashMap r11 = ChatControlTrace.d;
        Long r12 = (Long) r11.remove(r9);
        if (r12 == null) goto L20;
        long r13 = r12.longValue();
        long r20 = SystemClock.elapsedRealtime() - r13;
        r11.put(r9, Long.valueOf(SystemClock.elapsedRealtime()));
        Map r21 = ChatControlTrace.b0;
        Pair r22 = (Pair) ((LinkedHashMap) r21).get(r9);
        if (r22 != null) goto L19;
        r22 = new Pair(0, 0L);
    L19:
        r21.put(r9, TuplesKt.to(Integer.valueOf(((Number) r22.getFirst()).intValue() + 1), Long.valueOf(((Number) r22.getSecond()).longValue() + r20)));
    L20:
        String r23 = this.$token;
        Intrinsics.checkNotNullParameter(r23, "token");
        Map r111 = ChatControlTrace.a0;
        Pair r24 = (Pair) ((LinkedHashMap) r111).get(r23);
        if (r24 != null) goto L23;
        r24 = new Pair(0, 0L);
    L23:
        r111.put(r23, TuplesKt.to(Integer.valueOf(((Number) r24.getFirst()).intValue() + 1), Long.valueOf(((Number) r24.getSecond()).longValue() + 0)));
        goto L49
    L24:
        ChatControlTrace r112 = ChatControlTrace.b;
        ChatListComponent r25 = this.this$0;
        int r26 = ChatListComponent.W3;
        com.larus.bmhome.chat.component.cvs.y r27 = r25.u0();
        if (r27 == null) goto L27;
        r5 = r27.h();
    L27:
        wc9.e r28 = r5;
        String r29 = this.$token;
        Message r30 = this.$msg;
        String r31 = r30.getSenderId();
        if (r31 != null) goto L30;
        r31 = "";
    L30:
        Integer r32 = this.this$0.j4();
        Integer r113 = this.$multiQuestionCount;
        this.label = 2;
        Object r114 = r112.Y(r28, r29, r30, "stream_error", r31, r32, 0, r113, this);
        if (r114 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        r114 = Unit.INSTANCE;
    L34:
        if (r114 != r0) goto L49;
        return r0;
    }
}
