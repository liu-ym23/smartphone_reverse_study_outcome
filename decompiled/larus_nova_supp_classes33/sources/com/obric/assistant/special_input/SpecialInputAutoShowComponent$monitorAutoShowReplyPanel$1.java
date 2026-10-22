package com.obric.assistant.special_input;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.task.ObricTaskStatusManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1", f = "SpecialInputAutoShowComponent.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
final class SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpecialInputAutoShowComponent this$0;

    /* JADX INFO: renamed from: com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "dmStateInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "message", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$1", f = "SpecialInputAutoShowComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<DMStateInfo, Message, Continuation<? super DMTaskState>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ SpecialInputAutoShowComponent this$0;

        public AnonymousClass1(SpecialInputAutoShowComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(3, r2);
        }

        public final Object invoke(DMStateInfo r3, Message r4, Continuation<? super DMTaskState> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
            r0.L$0 = r3;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((DMStateInfo) r1, (Message) r2, (Continuation) r3);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L100;
            ResultKt.throwOnFailure(r11);
            DMStateInfo r12 = (DMStateInfo) this.L$0;
            Message r0 = (Message) this.L$1;
            IKeyguardState r1 = this.this$0.t;
            boolean r2 = false;
            if (r1 != null) goto L7;
        L9:
            boolean r3 = false;
        L11:
            if (r3 == false) goto L51;
            if (r12 == null) goto L23;
            List r4 = r12.getActiveTasks();
            if (r4 == null) goto L23;
            Iterator r5 = r4.iterator();
        L17:
            if (r5.hasNext() == false) goto L21;
            Object r7 = r5.next();
            if (com.obric.assistant.utils.l.f((DMTaskState) r7) == false) goto L17;
        L22:
            DMTaskState r8 = (DMTaskState) r7;
        L24:
            if (r8 != null) goto L28;
            FLogger.a.i("SpecialInputAutoShowComponent", "no running task");
            return null;
        L28:
            if (com.obric.assistant.utils.l.e(r8) == true) goto L31;
            FLogger.a.i("SpecialInputAutoShowComponent", "running task is not clarify");
            return null;
        L31:
            String r6 = com.obric.assistant.utils.l.a(r8);
            if (r6.length() != 0) goto L34;
            boolean r9 = true;
        L35:
            if (r9 == false) goto L39;
            FLogger.a.i("SpecialInputAutoShowComponent", "clarify msg id is empty");
            return null;
        L39:
            if (Intrinsics.areEqual(this.this$0.s.get(r6), Boxing.boxBoolean(true)) == false) goto L42;
            FLogger.a.i("SpecialInputAutoShowComponent", "clarify msg id " + r6 + " is logged");
            return null;
        L42:
            laa.c r10 = (laa.c) this.this$0.o.getValue();
            if (r10 != null) goto L45;
        L47:
            boolean r13 = false;
        L48:
            if (r13 == false) goto L52;
            FLogger.a.i("SpecialInputAutoShowComponent", "clarify msg id " + r6 + " is not in list");
            return r8;
        L52:
            if (r0 != null) goto L55;
            FLogger.a.i("SpecialInputAutoShowComponent", "message is null");
            return null;
        L55:
            String r14 = r0.getMessageId();
            if (r14 != null) goto L58;
        L59:
            r2 = true;
        L60:
            if (r2 == false) goto L64;
            FLogger.a.i("SpecialInputAutoShowComponent", "message id is empty");
            return null;
        L64:
            if (r0.getMessageStatusLocal() == 21) goto L68;
            FLogger.a.i("SpecialInputAutoShowComponent", "message id " + r0.getMessageId() + " has not received");
            return null;
        L68:
            if (com.obric.assistant.utils.k.c(r0) == true) goto L71;
            FLogger.a.i("SpecialInputAutoShowComponent", "message is not omni message");
            return null;
        L71:
            LruCache<String, Boolean> r15 = this.this$0.s;
            String r16 = r0.getMessageId();
            if (r16 != null) goto L75;
            r16 = "";
        L75:
            if (Intrinsics.areEqual(r15.get(r16), Boxing.boxBoolean(true)) == false) goto L78;
            FLogger.a.i("SpecialInputAutoShowComponent", "message id " + r0.getMessageId() + " is logged");
            return null;
        L78:
            FLogger.a.i("SpecialInputAutoShowComponent", "lastest msg id = " + r0.getMessageId());
            if (r8 != null) goto L94;
            if (r12 == null) goto L92;
            List r17 = r12.getActiveTasks();
            if (r17 == null) goto L92;
            Iterator r18 = r17.iterator();
        L85:
            if (r18.hasNext() == false) goto L89;
            Object r19 = r18.next();
            if (com.obric.assistant.utils.l.f((DMTaskState) r19) == false) goto L85;
        L90:
            r8 = (DMTaskState) r19;
            if (r8 != null) goto L94;
        L89:
            r19 = null;
        L92:
            return null;
        L94:
            if (com.obric.assistant.utils.l.e(r8) == true) goto L96;
        L98:
            return null;
        L96:
            if (Intrinsics.areEqual(com.obric.assistant.utils.l.a(r8), r0.getMessageId()) == false) goto L98;
            return r8;
        L58:
            if (r14.length() != 0) goto L60;
        L45:
            if (r10.BL(r6) == true) goto L47;
            r13 = true;
            goto L48
        L34:
            r9 = false;
            goto L35
        L21:
            r7 = null;
        L23:
            r8 = null;
            goto L24
        L51:
            r8 = null;
            goto L52
        L7:
            if (r1.isDeviceLocked() != true) goto L9;
            r3 = true;
            goto L11
        L100:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        public final /* synthetic */ SpecialInputAutoShowComponent a;

        public AnonymousClass2(SpecialInputAutoShowComponent r1) {
            this.a = r1;
        }

        public final Object a(DMTaskState r21, Continuation<? super Unit> r22) {
            if ((r22 instanceof SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1) == false) goto L7;
            SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1 r3 = (SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1) r22;
            int r4 = r3.label;
            if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
            r3.label = r4 - Integer.MIN_VALUE;
        L8:
            Object r2 = r3.result;
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r3.label;
            boolean r7 = true;
            boolean r8 = false;
            if (r6 == 0) goto L14;
            if (r6 != 1) goto L13;
            String r1 = (String) r3.L$1;
            DMTaskState r9 = (DMTaskState) r3.L$0;
            ResultKt.throwOnFailure(r2);
            DMTaskState r12 = r9;
        L23:
            if (((Boolean) r2).booleanValue() == true) goto L26;
            FLogger.a.i("SpecialInputAutoShowComponent", "cannot auto show input panel now");
            this.a.s.put(r1, Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L26:
            FLogger r10 = FLogger.a;
            r10.i("SpecialInputAutoShowComponent", "auto show clarify task = " + com.obric.assistant.utils.l.g(r12));
            this.a.s.put(r1, Boxing.boxBoolean(true));
            ISpecialInputTask r11 = c.a();
            if (r11 == null) goto L29;
            ISpecialInputTask$a.a(r11, com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", "intent_reply")), null, r12, 8), false, true, true, null, 16);
        L29:
            String r13 = sea.e.b();
            if (r13 != null) goto L32;
        L35:
            boolean r14 = true;
        L36:
            if (r14 == false) goto L38;
        L41:
            if (r13 != null) goto L43;
        L46:
            boolean r15 = true;
        L47:
            if (r15 == false) goto L49;
        L51:
            long r16 = sea.e.e.get();
            if (r16 != 0) goto L55;
        L59:
            if (r8 == false) goto L62;
            r10.i("SpecialInputAutoShowComponent", "skip scrollToBottom due to recent complex task reply anchor");
            return Unit.INSTANCE;
        L62:
            laa.c r17 = (laa.c) this.a.o.getValue();
            if (r17 == null) goto L66;
            r17.kc();
        L66:
            return Unit.INSTANCE;
        L55:
            if ((SystemClock.elapsedRealtime() - r16) <= 2000) goto L58;
            r7 = false;
        L58:
            r8 = r7;
            goto L59
        L49:
            if (Intrinsics.areEqual(r13, r1) == false) goto L51;
        L43:
            if (r13.length() == 0) goto L46;
            r15 = false;
            goto L47
        L38:
            if (Intrinsics.areEqual(r13, r1) == true) goto L41;
            r10.i("SpecialInputAutoShowComponent", "skip scrollToBottom due to pending complex task reply target, pendingReplyMessageId=" + r13 + ", clarifyMsgId=" + r1);
            return Unit.INSTANCE;
        L32:
            if (r13.length() == 0) goto L35;
            r14 = false;
            goto L36
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r2);
            if (r21 == null) goto L17;
            String r18 = com.obric.assistant.utils.l.a(r21);
            SpecialInputAutoShowComponent r19 = this.a;
            r3.L$0 = r21;
            r3.L$1 = r18;
            r3.label = 1;
            Object r20 = fga.a.C0055a.a(r19, false, false, r3, 7);
            if (r20 != r5) goto L21;
            return r5;
        L21:
            r12 = r21;
            r1 = r18;
            r2 = r20;
            goto L23
        L17:
            return Unit.INSTANCE;
        L7:
            r3 = new SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1$2$emit$1(this, r22);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((DMTaskState) r1, r2);
        }
    }

    public SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1(SpecialInputAutoShowComponent r1, Continuation<? super SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SpecialInputAutoShowComponent$monitorAutoShowReplyPanel$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ObricTaskStatusManager.a.getClass();
        StateFlowImpl r8 = ObricTaskStatusManager.f;
        SpecialInputAutoShowComponent r2 = this.this$0;
        int r3 = SpecialInputAutoShowComponent.v;
        laa.c r4 = (laa.c) r2.o.getValue();
        Intrinsics.checkNotNull(r4);
        kotlinx.coroutines.flow.v0 r5 = new kotlinx.coroutines.flow.v0(r8, r4.q90(), new AnonymousClass1(this.this$0, null));
        AnonymousClass2 r9 = new AnonymousClass2(this.this$0);
        this.label = 1;
        if (r5.collect(r9, this) != r0) goto L12;
        return r0;
    }
}
