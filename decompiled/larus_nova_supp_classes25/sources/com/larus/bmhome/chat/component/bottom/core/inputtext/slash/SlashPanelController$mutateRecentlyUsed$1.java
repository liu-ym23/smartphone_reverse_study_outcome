package com.larus.bmhome.chat.component.bottom.core.inputtext.slash;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.slash.SlashPanelController$mutateRecentlyUsed$1", f = "SlashPanelController.kt", i = {}, l = {635, 642}, m = "invokeSuspend", n = {}, s = {})
public final class SlashPanelController$mutateRecentlyUsed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $add;
    final /* synthetic */ be8.b $skill;
    int label;
    final /* synthetic */ SlashPanelController this$0;

    public SlashPanelController$mutateRecentlyUsed$1(boolean r1, be8.b r2, SlashPanelController r3, Continuation<? super SlashPanelController$mutateRecentlyUsed$1> r4) {
        this.$add = r1;
        this.$skill = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SlashPanelController$mutateRecentlyUsed$1(this.$add, this.$skill, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r26);
        Object r1 = ((Result) r26).unbox-impl();
    L19:
        if (Result.isSuccess-impl(r1) == false) goto L21;
        Unit r2 = (Unit) r1;
        Object r3 = Result.constructor-impl(null);
    L22:
        boolean r4 = this.$add;
        SlashPanelController r5 = this.this$0;
        be8.b r6 = this.$skill;
        if (Result.isSuccess-impl(r3) == false) goto L61;
        Long r8 = (Long) r3;
        if (r4 == false) goto L30;
        if (r8 == null) goto L28;
        long r9 = r8.longValue();
    L29:
        Long r10 = Boxing.boxLong(r9);
    L31:
        List<be8.b> r11 = r5.y;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L33:
        if (r13.hasNext() == false) goto L43;
        be8.b r14 = (be8.b) r13.next();
        if (Intrinsics.areEqual(r14.a, r6.a) == false) goto L42;
        if (r14.getType() != r6.getType()) goto L42;
        if (Intrinsics.areEqual(r14.h, r6.h) == false) goto L42;
        String r15 = r14.a;
        String r16 = r14.b;
        String r17 = r14.c;
        String r18 = r14.d;
        String r19 = r14.e;
        boolean r110 = r14.f;
        int r20 = r14.g;
        String r21 = r14.h;
        String r22 = r14.i;
        Integer r23 = r14.m;
        Intrinsics.checkNotNullParameter(r15, "skillId");
        Intrinsics.checkNotNullParameter(r16, "name");
        Intrinsics.checkNotNullParameter(r18, "description");
        Intrinsics.checkNotNullParameter(r19, "iconUrl");
        r14 = new be8.b(r15, r16, r17, r18, r19, r110, r20, r21, r22, r10, false, null, r23);
    L42:
        r12.add(r14);
        r6 = r6;
        r13 = r13;
        goto L33
    L43:
        r5.y = r12;
        if (r5.w == true) goto L46;
    L56:
        s r24 = s.a;
        Context r25 = r5.r;
        if (r4 == false) goto L59;
        int r27 = 2131906722;
    L60:
        String r28 = r25.getString(r27);
        r24.getClass();
        s.p(r25, r28);
        goto L61
    L59:
        r27 = 2131906725;
        goto L60
    L46:
        if (r5.x == null) goto L56;
        if (((Boolean) r5.m.invoke()).booleanValue() == false) goto L56;
        k1 r29 = r5.x;
        if (r29 == null) goto L52;
        String r30 = r29.c;
    L53:
        if (r30 != null) goto L55;
        r30 = "";
    L55:
        r5.h(r30);
        goto L56
    L52:
        r30 = null;
        goto L53
    L28:
        r9 = System.currentTimeMillis();
        goto L29
    L30:
        r10 = null;
    L61:
        boolean r31 = this.$add;
        SlashPanelController r32 = this.this$0;
        Throwable r33 = Result.exceptionOrNull-impl(r3);
        if (r33 == null) goto L65;
        FLogger.a.e("SlashPanelController", "[mutateRecentlyUsed] add=" + r31 + " failed", r33);
        s r34 = s.a;
        Context r35 = r32.r;
        s.j(r34, r35, r35.getString(2131907052), null, false, 28);
    L65:
        return Unit.INSTANCE;
    L21:
        r3 = Result.constructor-impl(r1);
        goto L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r26);
        r3 = ((Result) r26).unbox-impl();
        goto L22
    L10:
        ResultKt.throwOnFailure(r26);
        if (this.$add == false) goto L15;
        SkillServiceDelegate r36 = SkillServiceDelegate.a;
        be8.b r37 = this.$skill;
        String r38 = r37.a;
        int r39 = r37.getType();
        be8.b r40 = this.$skill;
        String r41 = r40.h;
        String r42 = r40.c;
        this.label = 1;
        r3 = r36.e(r38, r39, r41, r42, this);
        if (r3 != r7) goto L22;
        return r7;
    L15:
        SkillServiceDelegate r43 = SkillServiceDelegate.a;
        be8.b r44 = this.$skill;
        String r45 = r44.a;
        int r46 = r44.getType();
        be8.b r47 = this.$skill;
        String r48 = r47.h;
        String r49 = r47.c;
        this.label = 2;
        r1 = r43.q(r45, r46, r48, r49, this);
        if (r1 != r7) goto L19;
        return r7;
    }
}
