package com.larus.bmhome.chat.component.list;

import android.os.SystemClock;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace;
import com.larus.bmhome.social.page.datasource.event.d;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "initialMessageListLoaded", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$setupList$1$4", f = "ChatListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$setupList$1$4 extends SuspendLambda implements Function3<com.larus.bmhome.social.page.datasource.event.c<b>, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$setupList$1$4(ChatListComponent r1, Continuation<? super ChatListComponent$setupList$1$4> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Object invoke(com.larus.bmhome.social.page.datasource.event.c<b> r3, boolean r4, Continuation<? super Unit> r5) {
        ChatListComponent$setupList$1$4 r0 = new ChatListComponent$setupList$1$4(this.this$0, r5);
        r0.L$0 = r3;
        r0.Z$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((com.larus.bmhome.social.page.datasource.event.c) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r14);
        com.larus.bmhome.social.page.datasource.event.c r15 = (com.larus.bmhome.social.page.datasource.event.c) this.L$0;
        boolean r0 = this.Z$0;
        ChatListComponent r1 = this.this$0;
        MessageAdapter r2 = r1.O;
        if (r2 == null) goto L8;
        r2.z = r0;
    L8:
        if (r1.W4() == true) goto L10;
    L15:
        ChatListComponent r3 = this.this$0;
        r3.getClass();
        Iterator r4 = CollectionsKt.take(r15.a, 4).iterator();
    L17:
        if (r4.hasNext() == false) goto L22;
        b r5 = (b) r4.next();
        ChatMessageCostTrace r6 = ChatMessageCostTrace.a;
        String r7 = r5.getMessage().getLocalMessageId();
        if (r7 != null) goto L21;
        r7 = "";
    L21:
        long r8 = SystemClock.elapsedRealtime();
        r6.getClass();
        ChatMessageCostTrace.h(r7, "handleMessageEventFlow", r8);
        goto L17
    L22:
        String r9 = r15.d;
        Job r10 = r3.p0;
        boolean r11 = true;
        if (r10 != null) goto L25;
    L27:
        boolean r12 = false;
    L28:
        if (r12 == true) goto L30;
    L43:
        Job r13 = r3.p0;
        if (r13 == null) goto L46;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L46:
        r3.H0 = r9;
        r3.L0 = false;
        r3.p0 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r3), null, null, new ChatListComponent$handleMessageEventFlow$2(r3, r15, null), 3, null);
        com.larus.bmhome.chat.component.showcase.y r16 = r3.x5();
        if (r16 != null) goto L49;
    L51:
        r11 = false;
    L52:
        if (r11 == false) goto L55;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r3), null, null, new ChatListComponent$handleMessageEventFlow$3(r3, null), 3, null);
    L55:
        return Unit.INSTANCE;
    L49:
        if (r16.iQ() != true) goto L51;
    L30:
        if (r3.L0 == true) goto L43;
        if (r3.H0.length() <= 0) goto L34;
        boolean r17 = true;
    L35:
        if (r17 == false) goto L43;
        if (Intrinsics.areEqual(r3.H0, r9) == true) goto L43;
        long r18 = d.b(r3.H0);
        if (r18 < 0) goto L41;
        long r19 = System.currentTimeMillis() - r18;
    L42:
        FLogger.a.w(r3.o, "refreshTrace end=superseded rt=" + r3.H0 + " by rt=" + r9 + " cost=" + r19);
        goto L43
    L41:
        r19 = -1;
        goto L42
    L34:
        r17 = false;
        goto L35
    L25:
        if (r10.isActive() != true) goto L27;
        r12 = true;
        goto L28
    L10:
        if (r15.a.isEmpty() == false) goto L15;
        if (r15.b != 0) goto L15;
        return Unit.INSTANCE;
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
