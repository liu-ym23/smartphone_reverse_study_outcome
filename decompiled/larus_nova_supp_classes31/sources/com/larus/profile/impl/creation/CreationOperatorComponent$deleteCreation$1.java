package com.larus.profile.impl.creation;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.ICommunityService;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.z3;
import com.larus.profile.api.ICreationService;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationOperatorComponent$deleteCreation$1", f = "CreationOperatorComponent.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
public final class CreationOperatorComponent$deleteCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationOperatorComponent this$0;

    public CreationOperatorComponent$deleteCreation$1(CreationOperatorComponent r1, Continuation<? super CreationOperatorComponent$deleteCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationOperatorComponent$deleteCreation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = false;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r23);
        Object r4 = r23;
    L23:
        Pair r5 = (Pair) r4;
        if (r5 != null) goto L26;
    L28:
        boolean r6 = false;
    L29:
        String r8 = "creation_private";
        if (r6 == false) goto L77;
        t19.s r7 = t19.s.a;
        AppHost.Companion r11 = AppHost.a;
        Application r12 = r11.getApplication();
        String r13 = r11.getApplication().getString(2131900648);
        r7.getClass();
        t19.s.p(r12, r13);
        Integer r14 = this.this$0.g;
        if (r14 != null) goto L35;
    L37:
        String r15 = "creation_list";
    L38:
        UserCreation r9 = this.this$0.d;
        if (r9 == null) goto L41;
        String r17 = r9.a;
    L42:
        String r18 = zp9.d.d(r9);
        UserCreation r10 = this.this$0.d;
        if (r10 == null) goto L50;
        Integer r16 = r10.d;
        if (r16 == null) goto L50;
        if (r16.intValue() != 2) goto L50;
        boolean r19 = true;
    L51:
        if (r19 == false) goto L53;
        String r110 = "0";
    L54:
        gs9.d r20 = this.this$0.h;
        if (r20 == null) goto L59;
        gs9.b r21 = r20.f;
        if (r21 == null) goto L59;
        String r22 = r21.g;
    L60:
        tx9.e2.a.b(new tx9.u(r15, "creation_detail", "1", r17, r18, r110, r22, 1), null, 3);
        ICommunityService.Companion r24 = ICommunityService.a;
        UserCreation r25 = this.this$0.d;
        if (r25 == null) goto L64;
        String r26 = r25.a;
        if (r26 == null) goto L64;
    L65:
        r24.X0(r26);
        UserCreation r27 = this.this$0.d;
        if (r27 != null) goto L68;
    L70:
        if (r3 == false) goto L74;
        Lazy r28 = com.larus.platform.service.q3.a;
        z3 r29 = com.larus.platform.service.q3.a();
        if (r29 == null) goto L74;
        r29.k(null);
    L74:
        j2 r30 = this.this$0.f;
        if (r30 == null) goto L107;
        r30.fB();
    L107:
        return Unit.INSTANCE;
    L68:
        if (r27.b != 1) goto L70;
        r3 = true;
    L64:
        r26 = "";
    L59:
        r22 = null;
        goto L60
    L53:
        r110 = "1";
    L50:
        r19 = false;
        goto L51
    L41:
        r17 = null;
        goto L42
    L35:
        if (r14.intValue() != 2) goto L37;
        r15 = "creation_private";
        goto L38
    L77:
        Integer r111 = this.this$0.g;
        if (r111 != null) goto L81;
    L83:
        r8 = "creation_list";
    L84:
        UserCreation r112 = this.this$0.d;
        if (r112 == null) goto L87;
        String r113 = r112.a;
    L88:
        String r114 = zp9.d.d(r112);
        UserCreation r115 = this.this$0.d;
        if (r115 == null) goto L96;
        Integer r116 = r115.d;
        if (r116 == null) goto L96;
        if (r116.intValue() != 2) goto L96;
        r3 = true;
    L96:
        if (r3 == false) goto L98;
        String r31 = "0";
    L99:
        gs9.d r32 = this.this$0.h;
        if (r32 == null) goto L104;
        gs9.b r33 = r32.f;
        if (r33 == null) goto L104;
        String r34 = r33.g;
    L105:
        tx9.e2.a.b(new tx9.u(r8, "creation_detail", "0", r113, r114, r31, r34, 1), null, 3);
    L104:
        r34 = null;
        goto L105
    L98:
        r31 = "1";
        goto L99
    L87:
        r113 = null;
        goto L88
    L81:
        if (r111.intValue() != 2) goto L83;
    L26:
        if (((Boolean) r5.getFirst()).booleanValue() != true) goto L28;
        r6 = true;
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        UserCreation r35 = this.this$0.d;
        if (r35 == null) goto L109;
        String r36 = r35.a;
        if (r36 == null) goto L109;
        ICreationService.Companion r37 = ICreationService.a;
        Integer r38 = r35.d;
        if (r38 != null) goto L17;
    L19:
        boolean r39 = false;
    L20:
        this.label = 1;
        r4 = r37.b(r36, r39, this);
        if (r4 != r1) goto L23;
        return r1;
    L17:
        if (r38.intValue() != 1) goto L19;
        r39 = true;
    L109:
        return Unit.INSTANCE;
    }
}
