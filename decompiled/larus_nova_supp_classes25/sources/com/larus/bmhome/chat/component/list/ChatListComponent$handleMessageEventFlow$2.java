package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.playback.MessagePlaybackHelper;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$handleMessageEventFlow$2", f = "ChatListComponent.kt", i = {0}, l = {4441}, m = "invokeSuspend", n = {"toppingList"}, s = {"L$0"})
final class ChatListComponent$handleMessageEventFlow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.social.page.datasource.event.c<b> $it;
    Object L$0;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.ChatListComponent$handleMessageEventFlow$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.larus.bmhome.social.page.datasource.event.c<b>, Unit> {
        public AnonymousClass1(Object r8) {
            super(1, r8, ChatListComponent.class, "createRecoverAction", "createRecoverAction(Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;)V", 0);
        }

        public final void invoke(com.larus.bmhome.social.page.datasource.event.c<b> r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            ChatListComponent.h3((ChatListComponent) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.larus.bmhome.social.page.datasource.event.c) r1);
            return Unit.INSTANCE;
        }
    }

    public ChatListComponent$handleMessageEventFlow$2(ChatListComponent r1, com.larus.bmhome.social.page.datasource.event.c<b> r2, Continuation<? super ChatListComponent$handleMessageEventFlow$2> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponent$handleMessageEventFlow$2(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Message r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.larus.bmhome.social.page.datasource.event.c r3 = (com.larus.bmhome.social.page.datasource.event.c) this.L$0;
        ResultKt.throwOnFailure(r11);
    L67:
        com.larus.bmhome.social.page.datasource.event.c r12 = r3;
    L68:
        this.this$0.L0 = true;
    L69:
        FLogger r4 = FLogger.a;
        String r5 = this.this$0.o;
        StringBuilder r6 = new StringBuilder("handleMessageEventFlow submitEvent ");
        r6.append(r12);
        r6.append(" isPlaybackMode=");
        com.larus.bmhome.chat.component.showcase.y r7 = this.this$0.x5();
        if (r7 == null) goto L72;
        Boolean r8 = Boxing.boxBoolean(r7.iQ());
    L73:
        r6.append(r8);
        r4.i(r5, r6.toString());
        ChatListComponent r9 = this.this$0;
        b r10 = (b) CollectionsKt.firstOrNull(r12.a);
        if (r10 == null) goto L76;
        r2 = r10.getMessage();
    L76:
        r9.R7(r2);
        if ((!r12.a.isEmpty()) == false) goto L82;
        com.larus.bmhome.chat.component.bottom.p1 r13 = (com.larus.bmhome.chat.component.bottom.p1) this.this$0.y2.getValue();
        if (r13 == null) goto L82;
        r13.Bc();
    L82:
        return Unit.INSTANCE;
    L72:
        r8 = null;
        goto L73
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        FLogger.a.i(this.this$0.o, "handleMessageEventFlow launch " + this.$it);
        ChatListComponent r14 = this.this$0;
        com.larus.bmhome.social.page.datasource.event.c r15 = r14.d4(this.$it);
        LarusPageChatBinding r16 = this.this$0.h4();
        if (r16 == null) goto L13;
        ChatMessageList r17 = r16.n;
        if (r17 == null) goto L13;
        r17.setToppingPageScopeId(this.this$0.R5());
    L13:
        ConcurrentHashMap r18 = com.larus.bmhome.utils.v3.a;
        com.larus.bmhome.utils.v3.g(r15, new AnonymousClass1(r14), this.this$0.R5());
        r12 = com.larus.bmhome.utils.v3.c(r15, this.this$0.R5());
        this.this$0.P7(r12);
        zd8.b r19 = (zd8.b) this.this$0.x2.getValue();
        if (r19 == null) goto L24;
        b r20 = (b) CollectionsKt.firstOrNull(r12.a);
        if (r20 == null) goto L18;
        Message r21 = r20.getMessage();
    L19:
        List r22 = r12.a;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r24 = r22.iterator();
    L21:
        if (r24.hasNext() == false) goto L23;
        r23.add(((b) r24.next()).getMessage());
        goto L21
    L23:
        r19.Xt(r21, r23);
        goto L24
    L18:
        r21 = null;
    L24:
        com.larus.bmhome.chat.component.receive.m0 r25 = (com.larus.bmhome.chat.component.receive.m0) this.this$0.P2.getValue();
        if (r25 == null) goto L27;
        r25.yy();
    L27:
        com.larus.bmhome.chat.component.showcase.y r26 = this.this$0.x5();
        boolean r27 = false;
        if (r26 != null) goto L30;
    L32:
        boolean r28 = false;
    L33:
        if (r28 == true) goto L35;
    L44:
        com.larus.bmhome.chat.component.showcase.y r29 = this.this$0.x5();
        if (r29 != null) goto L47;
    L49:
        if (r27 == false) goto L51;
        MessagePlaybackHelper r30 = this.this$0.o3;
        r30.getClass();
        Intrinsics.checkNotNullParameter(r12, "event");
        r30.a = r12;
        goto L69
    L51:
        wc9.e r31 = this.this$0.R4();
        if (r31 == null) goto L61;
        dh8.b r32 = dh8.b.a;
        StringBuilder r33 = new StringBuilder();
        r33.append(r31.a);
        r33.append(':');
        String r34 = r31.B;
        if (r34 != null) goto L56;
        r34 = "";
    L56:
        r33.append(r34);
        String r35 = r33.toString();
        List r36 = r12.a;
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator r38 = r36.iterator();
    L58:
        if (r38.hasNext() == false) goto L60;
        r37.add(((b) r38.next()).getMessage());
        goto L58
    L60:
        r32.getClass();
        Boxing.boxBoolean(dh8.b.k(r35, r37));
    L61:
        MessageAdapter r39 = this.this$0.O;
        if (r39 == null) goto L68;
        this.L$0 = r12;
        this.label = 1;
        if (MessageAdapter.L2(r39, r12, this) != r0) goto L66;
        return r0;
    L66:
        r3 = r12;
        goto L67
    L47:
        if (r29.iQ() != true) goto L49;
        r27 = true;
        goto L49
    L35:
        if ((!r12.a.isEmpty()) == false) goto L44;
        if (((b) CollectionsKt.first(r12.a)).getMessage().getServerIndex() < 20) goto L41;
        com.larus.bmhome.chat.component.showcase.y r40 = this.this$0.x5();
        if (r40 == null) goto L44;
        r40.KQ();
        goto L44
    L41:
        com.larus.bmhome.chat.component.showcase.y r41 = this.this$0.x5();
        if (r41 == null) goto L44;
        r41.rZ();
        goto L44
    L30:
        if (r26.XR() != true) goto L32;
        r28 = true;
        goto L33
    }
}
