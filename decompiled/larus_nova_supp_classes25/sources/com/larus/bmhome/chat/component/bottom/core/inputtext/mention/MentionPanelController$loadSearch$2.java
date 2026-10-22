package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$loadSearch$2", f = "MentionPanelController.kt", i = {0, 1}, l = {305, 316}, m = "invokeSuspend", n = {"referencesRequest", "contacts"}, s = {"L$0", "L$0"})
final class MentionPanelController$loadSearch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ String $query;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MentionPanelController this$0;

    public MentionPanelController$loadSearch$2(MentionPanelController r1, String r2, long r3, Continuation<? super MentionPanelController$loadSearch$2> r5) {
        this.this$0 = r1;
        this.$query = r2;
        this.$generation = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MentionPanelController$loadSearch$2 r6 = new MentionPanelController$loadSearch$2(this.this$0, this.$query, this.$generation, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        f0 r3 = (f0) this.L$0;
        ResultKt.throwOnFailure(r16);
        Object r4 = r16;
    L51:
        f0 r5 = (f0) r4;
        if (r5 != null) goto L54;
        f0 r6 = r3;
    L55:
        r5 = new f0(null, null, null, null, 31);
        r3 = r6;
    L54:
        f0 r7 = r5;
        JobKt.ensureActive(getContext());
        MentionPanelController r8 = this.this$0;
        String r9 = this.$query;
        long r10 = this.$generation;
        int r11 = MentionPanelController.R;
        k1 r12 = r8.h(r9, r10);
        if (r12 == null) goto L59;
        MentionPanelController r13 = this.this$0;
        if (r13.w != MentionPanelController.SearchState.CONTACT_READY_WAITING_REFERENCES) goto L63;
        r3 = r13.u;
    L65:
        MentionPanelController r14 = this.this$0;
        List<c> r15 = r3.b;
        Map<MentionSearchDomain, d1> r17 = r7.e;
        Map<MentionSearchDomain, d1> r18 = r3.e;
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator<Map.Entry<MentionSearchDomain, d1>> r20 = r18.entrySet().iterator();
    L67:
        if (r20.hasNext() == false) goto L74;
        Map.Entry<MentionSearchDomain, d1> r110 = r20.next();
        if (r110.getKey() != MentionSearchDomain.CONTACT) goto L71;
        boolean r111 = true;
    L72:
        if (r111 == false) goto L67;
        r19.put(r110.getKey(), r110.getValue());
        goto L67
    L71:
        r111 = false;
        goto L72
    L74:
        r14.u = r14.j(f0.b(r7, null, r15, null, null, MapsKt.plus(r17, r19), 13));
        MentionPanelController r21 = this.this$0;
        r21.w = MentionPanelController.SearchState.READY;
        r21.p(r12);
        return Unit.INSTANCE;
    L63:
        if (r3 != null) goto L65;
        r3 = new f0(null, null, null, null, 31);
        goto L65
    L59:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred r22 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r16);
        Object r23 = r16;
    L34:
        r6 = (f0) r23;
    L36:
        if (r6 == null) goto L46;
        JobKt.ensureActive(getContext());
        if (r22 == null) goto L46;
        if (r22.isCompleted() == true) goto L46;
        MentionPanelController r24 = this.this$0;
        String r25 = this.$query;
        long r26 = this.$generation;
        int r112 = MentionPanelController.R;
        k1 r27 = r24.h(r25, r26);
        if (r27 == null) goto L44;
        MentionPanelController r28 = this.this$0;
        r28.u = r28.j(r6);
        MentionPanelController r29 = this.this$0;
        r29.w = MentionPanelController.SearchState.CONTACT_READY_WAITING_REFERENCES;
        r29.p(r27);
        goto L46
    L44:
        return Unit.INSTANCE;
    L46:
        if (r22 == null) goto L55;
        this.L$0 = r6;
        this.label = 2;
        r4 = r22.await(this);
        if (r4 != r1) goto L50;
        return r1;
    L50:
        r3 = r6;
        goto L51
    L10:
        ResultKt.throwOnFailure(r16);
        CoroutineScope r30 = (CoroutineScope) this.L$0;
        MentionPanelController r31 = this.this$0;
        if (r31.K == false) goto L13;
        Deferred r113 = BuildersKt.async$default(r30, null, null, new MentionPanelController$loadSearch$2$contactsRequest$1(r31, this.$query, null), 3, null);
    L14:
        MentionPanelController r32 = this.this$0;
        List r33 = CollectionsKt.createListBuilder();
        if (r32.L == false) goto L18;
        r33.add(MentionSearchDomain.GROUP);
    L18:
        if (r32.M == false) goto L21;
        r33.add(MentionSearchDomain.DRIVE);
    L21:
        if (r32.N == false) goto L23;
        r33.add(MentionSearchDomain.CONVERSATION);
    L23:
        List r34 = CollectionsKt.build(r33);
        if ((!r34.isEmpty()) == true) goto L27;
        r34 = null;
    L27:
        if (r34 == null) goto L29;
        r22 = BuildersKt.async$default(r30, null, null, new MentionPanelController$loadSearch$2$referencesRequest$2$1(this.this$0, this.$query, r34, null), 3, null);
    L30:
        if (r113 == null) goto L35;
        this.L$0 = r22;
        this.label = 1;
        r23 = r113.await(this);
        if (r23 != r1) goto L34;
        return r1;
    L35:
        r6 = null;
        goto L36
    L29:
        r22 = null;
        goto L30
    L13:
        r113 = null;
        goto L14
    }
}
