package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$load$2", f = "MentionPanelController.kt", i = {}, l = {260, 263}, m = "invokeSuspend", n = {}, s = {})
final class MentionPanelController$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f0 $cached;
    final /* synthetic */ long $generation;
    final /* synthetic */ String $query;
    int label;
    final /* synthetic */ MentionPanelController this$0;

    public MentionPanelController$load$2(String r1, MentionPanelController r2, long r3, f0 r5, Continuation<? super MentionPanelController$load$2> r6) {
        this.$query = r1;
        this.this$0 = r2;
        this.$generation = r3;
        this.$cached = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MentionPanelController$load$2(this.$query, this.this$0, this.$generation, this.$cached, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L26:
        f0 r14 = (f0) r13;
        JobKt.ensureActive(getContext());
        MentionPanelController r2 = this.this$0;
        String r3 = this.$query;
        long r5 = this.$generation;
        int r6 = MentionPanelController.R;
        k1 r7 = r2.h(r3, r5);
        if (r7 == null) goto L29;
        MentionPanelController r8 = this.this$0;
        if (r14 != null) goto L34;
        f0 r9 = r8.u;
    L37:
        r8.u = r9;
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("[load] recommend refreshed fresh=");
        if (r14 != null) goto L41;
        r4 = false;
    L41:
        r11.append(r4);
        r11.append(", freshContacts=");
        if (r14 == null) goto L56;
        List<c> r15 = r14.b;
        if (r15 == null) goto L56;
        ArrayList r12 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L47:
        if (r16.hasNext() == false) goto L57;
        c r17 = (c) r16.next();
        if (r17 == null) goto L53;
        qp8.c r18 = r17.a;
        if (r18 == null) goto L53;
        String r19 = r18.a;
    L54:
        if (r19 == null) goto L47;
        r12.add(r19);
    L53:
        r19 = null;
    L57:
        r11.append(r12);
        r11.append(", shownContacts=");
        List<c> r110 = this.this$0.u.b;
        ArrayList r20 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L59:
        if (r111.hasNext() == false) goto L68;
        c r21 = (c) r111.next();
        if (r21 == null) goto L65;
        qp8.c r22 = r21.a;
        if (r22 == null) goto L65;
        String r23 = r22.a;
    L66:
        if (r23 == null) goto L59;
        r20.add(r23);
    L65:
        r23 = null;
        goto L66
    L68:
        r11.append(r20);
        r10.i("MentionPanelController", r11.toString());
        MentionPanelController r112 = this.this$0;
        r112.v = false;
        r112.p(r7);
        return Unit.INSTANCE;
    L56:
        r12 = null;
        goto L57
    L34:
        if (this.$cached != null) goto L36;
        r9 = r8.j(r14);
        goto L37
    L36:
        r9 = f0.b(r8.j(r14), null, this.this$0.u.b, null, null, null, 29);
        goto L37
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L22:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r13);
        if (this.$query.length() <= 0) goto L13;
        boolean r113 = true;
    L14:
        if (r113 == false) goto L23;
        MentionPanelController r24 = this.this$0;
        String r25 = this.$query;
        long r26 = this.$generation;
        this.label = 1;
        int r114 = MentionPanelController.R;
        r24.getClass();
        Object r115 = SupervisorKt.supervisorScope(new MentionPanelController$loadSearch$2(r24, r25, r26, null), this);
        if (r115 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        r115 = Unit.INSTANCE;
    L19:
        if (r115 != r0) goto L22;
        return r0;
    L23:
        MentionRecommendStore r116 = MentionRecommendStore.a;
        MentionPanelController r27 = this.this$0;
        qp8.e r28 = r27.d;
        boolean r29 = r27.K;
        this.label = 2;
        r13 = r116.d(r28, r29, this);
        if (r13 != r0) goto L26;
        return r0;
    L13:
        r113 = false;
        goto L14
    }
}
