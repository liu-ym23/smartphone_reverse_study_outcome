package com.larus.bmhome.chat.adapter;

import android.os.SystemClock;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.adapter.MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1", f = "MessageAdapter.kt", i = {}, l = {MessageCellStateTransformerType.AWEME_POST_LIST}, m = "invokeSuspend", n = {}, s = {})
public final class MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends xc8.b>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageAdapter this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.adapter.MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ FlowCollector<List<? extends xc8.b>> a;
        public final /* synthetic */ MessageAdapter b;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.adapter.MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.adapter.MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1$1", f = "MessageAdapter.kt", i = {}, l = {230}, m = "emit", n = {}, s = {})
        public static final class C00391 extends ContinuationImpl {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ AnonymousClass1 this$0;

            public C00391(AnonymousClass1 r1, Continuation r2) {
                this.this$0 = r1;
                super(r2);
            }

            public final Object invokeSuspend(Object r2) {
                this.result = r2;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector r1, MessageAdapter r2) {
            this.b = r2;
            this.a = r1;
        }

        public final Object emit(T r17, Continuation<? super Unit> r18) {
            if ((r18 instanceof C00391) == false) goto L7;
            C00391 r2 = (C00391) r18;
            int r3 = r2.label;
            if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
            r2.label = r3 - Integer.MIN_VALUE;
        L8:
            Object r1 = r2.result;
            Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r5 = r2.label;
            if (r5 == 0) goto L14;
            if (r5 != 1) goto L13;
            ResultKt.throwOnFailure(r1);
        L97:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r1);
            FlowCollector<List<? extends xc8.b>> r6 = this.a;
            List r7 = (List) r17;
            long r8 = System.currentTimeMillis();
            MessageAdapter r9 = this.b;
            r9.getClass();
            com.larus.bmhome.chat.component.regen.a r10 = r9.getProvider().s5();
            boolean r11 = false;
            if (r10 == null) goto L17;
            r10.qb(false);
        L17:
            MessageAdapter r12 = this.b;
            Iterator r13 = ((ArrayList) r12.getCurrentList()).iterator();
        L19:
            if (r13.hasNext() == false) goto L32;
            Object r14 = r13.next();
            Message r15 = (Message) r14;
            if (com.larus.bmhome.social.userchat.model.b0.f(r15) == false) goto L29;
            Integer r16 = com.larus.bmhome.social.userchat.model.b0.c(r15);
            if (r16 != null) goto L26;
        L28:
            boolean r19 = false;
        L30:
            if (r19 == false) goto L19;
        L33:
            Message r110 = (Message) r14;
            if (r12.D == true) goto L40;
            FLogger r20 = FLogger.a;
            StringBuilder r111 = new StringBuilder("curSecId lastRealMsg ");
            if (r110 == null) goto L38;
            String r112 = r110.getMessageId();
        L39:
            r111.append(r112);
            r20.i("MessageAdapter", r111.toString());
            goto L40
        L38:
            r112 = null;
        L40:
            if (r110 == null) goto L42;
            String r21 = r110.getSectionId();
        L43:
            Intrinsics.checkNotNullParameter(r12, "<this>");
            Iterator<T> r113 = r12.getCurrentList().iterator();
        L45:
            if (r113.hasNext() == false) goto L49;
            T r114 = r113.next();
            if (com.larus.bmhome.chat.bean.d.H0((Message) r114) == false) goto L45;
        L50:
            Message r115 = (Message) r114;
            String r116 = r12.C;
            if (r21 != null) goto L53;
        L54:
            r11 = true;
        L56:
            if (r11 == false) goto L61;
            if (r115 == null) goto L59;
            String r22 = r115.getLocalMessageId();
        L60:
            r12.C = r22;
        L73:
            Message r23 = (Message) CollectionsKt.firstOrNull(r12.getCurrentList());
            if (r23 != null) goto L76;
        L78:
            FLogger.a.i("ModifyMessage", "update canModifyId " + r116 + "  " + r12.C);
            if (Intrinsics.areEqual(r116, r12.C) == false) goto L81;
        L86:
            Iterator<T> r24 = CollectionsKt.take(this.b.z2(), 4).iterator();
        L88:
            if (r24.hasNext() == false) goto L93;
            xc8.b r25 = (xc8.b) r24.next();
            ChatMessageCostTrace r26 = ChatMessageCostTrace.a;
            String r27 = r25.getMessage().getLocalMessageId();
            if (r27 != null) goto L92;
            r27 = "";
        L92:
            long r28 = SystemClock.elapsedRealtime();
            r26.getClass();
            ChatMessageCostTrace.h(r27, "msg_adapter_emit", r28);
            goto L88
        L93:
            long r29 = System.currentTimeMillis();
            FLogger.a.i("MessageAdapter", "onPagesUpdatedFlow.transform executeMills=" + (r29 - r8) + " listSize=" + this.b.z2().size());
            List<xc8.b> r30 = this.b.z2();
            r2.label = 1;
            if (r6.emit(r30, r2) != r4) goto L97;
            return r4;
        L81:
            if (r116 == null) goto L83;
            r12.S3(r116, 1);
        L83:
            String r31 = r12.C;
            if (r31 == null) goto L86;
            r12.S3(r31, 1);
            goto L86
        L76:
            if (com.larus.bmhome.chat.bean.d.V(r23) == false) goto L78;
            FLogger.a.i("ModifyMessage", "update canModifyId null because isAwemeVideoLocalPrompt");
            r12.C = null;
            goto L78
        L59:
            r22 = null;
            goto L60
        L61:
            if (r115 == null) goto L63;
            String r32 = r115.getSectionId();
        L65:
            if (Intrinsics.areEqual(r21, r32) == false) goto L67;
            String r33 = r115.getLocalMessageId();
        L72:
            r12.C = r33;
            goto L73
        L67:
            FLogger r34 = FLogger.a;
            StringBuilder r117 = new StringBuilder("update canModifyId null because sectionId not match conversation secId: ");
            r117.append(r21);
            r117.append("  msg secId:");
            if (r115 == null) goto L70;
            String r35 = r115.getSectionId();
        L71:
            r117.append(r35);
            r117.append(' ');
            r34.i("ModifyMessage", r117.toString());
            r33 = null;
            goto L72
        L70:
            r35 = null;
            goto L71
        L63:
            r32 = null;
            goto L65
        L53:
            if (r21.length() != 0) goto L56;
        L49:
            r114 = null;
            goto L50
        L42:
            r21 = null;
            goto L43
        L26:
            if (r16.intValue() != 3) goto L28;
        L29:
            r19 = true;
            goto L30
        L32:
            r14 = null;
        L7:
            r2 = new C00391(this, r18);
            goto L8
        }
    }

    public MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1(Flow r1, Continuation r2, MessageAdapter r3) {
        this.$this_transform = r1;
        this.this$0 = r3;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1 r0 = new MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1(this.$this_transform, r5, this.this$0);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super List<? extends xc8.b>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowCollector r7 = (FlowCollector) this.L$0;
        Flow r2 = this.$this_transform;
        AnonymousClass1 r3 = new AnonymousClass1(r7, this.this$0);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
