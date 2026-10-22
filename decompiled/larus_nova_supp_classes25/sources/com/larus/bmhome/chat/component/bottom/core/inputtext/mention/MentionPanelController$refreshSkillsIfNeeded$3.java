package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.r1;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$refreshSkillsIfNeeded$3", f = "MentionPanelController.kt", i = {}, l = {1037}, m = "invokeSuspend", n = {}, s = {})
final class MentionPanelController$refreshSkillsIfNeeded$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ be8.a $skillAbility;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ MentionPanelController this$0;

    public MentionPanelController$refreshSkillsIfNeeded$3(be8.a r1, long r2, MentionPanelController r4, String r5, Continuation<? super MentionPanelController$refreshSkillsIfNeeded$3> r6) {
        this.$skillAbility = r1;
        this.$generation = r2;
        this.this$0 = r4;
        this.$userId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MentionPanelController$refreshSkillsIfNeeded$3(this.$skillAbility, this.$generation, this.this$0, this.$userId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L11:
        JobKt.ensureActive(getContext());
        if (this.$generation != this.this$0.C) goto L34;
        if (Intrinsics.areEqual(AccountService.a.getUserId(), this.$userId) == false) goto L34;
        MentionPanelController r2 = this.this$0;
        if (Result.isSuccess-impl(r9) == false) goto L25;
        List<be8.b> r3 = r2.D;
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r6 = ((List) r9).iterator();
    L20:
        if (r6.hasNext() == false) goto L24;
        Object r7 = r6.next();
        if (r4.add(((be8.b) r7).a) == false) goto L20;
        r5.add(r7);
        goto L20
    L24:
        r2.D = r1.b(r3, r5);
    L25:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L28;
        FLogger.a.w("MentionPanelController", "[refreshSkillsIfNeeded] refresh skills failed, msg=" + r10.getMessage());
    L28:
        MentionPanelController r11 = this.this$0;
        r11.r = null;
        k1 r12 = r11.n;
        if (r12 == null) goto L32;
        r11.p(r12);
    L32:
        return Unit.INSTANCE;
    L34:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        be8.a r13 = this.$skillAbility;
        this.label = 1;
        r9 = r13.Xr(this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
