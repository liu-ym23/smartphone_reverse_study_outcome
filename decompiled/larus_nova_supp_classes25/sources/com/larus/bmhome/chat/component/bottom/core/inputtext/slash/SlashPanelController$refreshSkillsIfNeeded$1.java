package com.larus.bmhome.chat.component.bottom.core.inputtext.slash;

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
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.slash.SlashPanelController$refreshSkillsIfNeeded$1", f = "SlashPanelController.kt", i = {}, l = {496}, m = "invokeSuspend", n = {}, s = {})
final class SlashPanelController$refreshSkillsIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ be8.a $skillAbility;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ SlashPanelController this$0;

    public SlashPanelController$refreshSkillsIfNeeded$1(be8.a r1, long r2, SlashPanelController r4, String r5, Continuation<? super SlashPanelController$refreshSkillsIfNeeded$1> r6) {
        this.$skillAbility = r1;
        this.$generation = r2;
        this.this$0 = r4;
        this.$userId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SlashPanelController$refreshSkillsIfNeeded$1(this.$skillAbility, this.$generation, this.this$0, this.$userId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L11:
        JobKt.ensureActive(getContext());
        if (this.$generation != this.this$0.C) goto L44;
        if (Intrinsics.areEqual(AccountService.a.getUserId(), this.$userId) == false) goto L44;
        SlashPanelController r3 = this.this$0;
        if (Result.isSuccess-impl(r10) == false) goto L25;
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r6 = ((List) r10).iterator();
    L20:
        if (r6.hasNext() == false) goto L24;
        Object r7 = r6.next();
        if (r4.add(((be8.b) r7).a) == false) goto L20;
        r5.add(r7);
        goto L20
    L24:
        r3.y = r1.b(r3.y, r5);
        FLogger.a.i("SlashPanelController", "[refreshSkillsIfNeeded] success, refreshedSkills=" + r5.size() + ", mergedSkills=" + r3.y.size() + ", active=" + r3.w);
    L25:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L28;
        FLogger.a.w("SlashPanelController", "[refreshSkillsIfNeeded] failed, msg=" + r11.getMessage());
    L28:
        SlashPanelController r12 = this.this$0;
        r12.z = false;
        k1 r8 = r12.x;
        if (r8 != null) goto L31;
    L33:
        r8 = null;
    L34:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("[refreshSkillsIfNeeded] complete, active=");
        r14.append(this.this$0.w);
        r14.append(", hasActiveQuery=");
        if (r8 != null) goto L38;
        r2 = false;
    L38:
        r14.append(r2);
        r14.append(", skills=");
        r14.append(this.this$0.y.size());
        r13.i("SlashPanelController", r14.toString());
        if (r8 == null) goto L42;
        this.this$0.h(r8.c);
    L42:
        return Unit.INSTANCE;
    L31:
        if (r12.w == false) goto L33;
    L44:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        be8.a r15 = this.$skillAbility;
        this.label = 1;
        r10 = r15.Xr(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
