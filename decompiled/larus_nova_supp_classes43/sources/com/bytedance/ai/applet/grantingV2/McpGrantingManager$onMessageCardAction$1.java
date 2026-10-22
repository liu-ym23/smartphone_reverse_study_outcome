package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.McpGrantingManager$onMessageCardAction$1", f = "McpGrantingManager.kt", i = {}, l = {264, 306}, m = "invokeSuspend", n = {}, s = {})
public final class McpGrantingManager$onMessageCardAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ u2.a $cardData;
    final /* synthetic */ String $cardID;
    final /* synthetic */ boolean $granted;
    final /* synthetic */ f $grantingContext;
    final /* synthetic */ boolean $isHistory;
    final /* synthetic */ String $msgID;
    final /* synthetic */ i $strategy;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowResult.values().length];
            r0[FlowResult.REQUIRES_CONFIRMATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FlowResult.CONTINUE_NEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FlowResult.STOP_FLOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public McpGrantingManager$onMessageCardAction$1(f r1, u2.a r10, boolean r11, String r12, i r13, boolean r14, String r15, Continuation<? super McpGrantingManager$onMessageCardAction$1> r16) {
        this.$grantingContext = r1;
        this.$cardData = r10;
        this.$granted = r11;
        this.$msgID = r12;
        this.$strategy = r13;
        this.$isHistory = r14;
        this.$cardID = r15;
        super(2, r16);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new McpGrantingManager$onMessageCardAction$1(this.$grantingContext, this.$cardData, this.$granted, this.$msgID, this.$strategy, this.$isHistory, this.$cardID, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L51:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L16:
        com.bytedance.ai.applet.grantingV2.a r11 = (com.bytedance.ai.applet.grantingV2.a) r10;
        String r12 = r11.b;
        String r13 = r11.c;
        u2.f r14 = r11.e;
        u2.a r15 = r11.d;
        this.$grantingContext.h = r15;
        if (r12 == null) goto L22;
        if (r13 == null) goto L22;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r16 = AppletRuntimeManager.d;
        if (r16 == null) goto L22;
        r16.q(r12, r13);
    L22:
        if (r15 == null) goto L24;
        f r17 = this.$grantingContext;
        r17.d.a(this.$msgID, r15);
    L24:
        if (r14 == null) goto L28;
        f r18 = this.$grantingContext;
        final String r19 = this.$msgID;
        String r20 = this.$cardID;
        u2.e r21 = v.c(r18.a, r14);
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r18.a = r21;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r22 = AppletRuntimeManager.d;
        if (r22 == null) goto L28;
        r22.t(r19, r20, com.bytedance.ai.applet.base.gson.e.c(r21), new t(r19));
    L28:
        int r110 = a.a[r11.a.ordinal()];
        if (r110 != 1) goto L31;
        i r111 = this.$strategy;
        f r23 = this.$grantingContext;
        this.label = 2;
        if (r111.f(r23, this) != r0) goto L51;
        return r0;
    L31:
        if (r110 != 2) goto L33;
        McpGrantingManager.a(McpGrantingManager.a, this.$grantingContext, this.$granted, r14);
        McpGrantingManager.l(this.$grantingContext, false);
        goto L51
    L33:
        if (r110 != 3) goto L45;
        com.bytedance.ai.utils.g r112 = com.bytedance.ai.utils.g.a;
        r112.i("McpGrantingManagerV2", "Strong dependency rejected, stop granting flow");
        McpGrantingManager.a(McpGrantingManager.a, this.$grantingContext, this.$granted, r14);
        if (this.$granted == false) goto L37;
    L43:
        McpGrantingManager.g(this.$grantingContext, false);
        goto L51
    L37:
        if (this.$grantingContext.a.i() == true) goto L43;
        r112.i("McpGrantingManagerV2", "Reject without resend query, stop granting flow");
        if (r14 != null) goto L42;
        this.$grantingContext.j.set(false);
        this.$grantingContext.k.set(0);
    L42:
        return Unit.INSTANCE;
    L45:
        throw new NoWhenBranchMatchedException();
    L10:
        ResultKt.throwOnFailure(r10);
        u2.a r113 = this.$grantingContext.h;
        if (r113 != null) goto L13;
        r113 = this.$cardData;
    L13:
        boolean r24 = this.$granted;
        u2.a r114 = u2.a.a(r113, r24, !r24, 511);
        f r25 = this.$grantingContext;
        r25.h = r114;
        r25.d.a(this.$msgID, r114);
        i r115 = this.$strategy;
        f r26 = this.$grantingContext;
        boolean r27 = this.$granted;
        boolean r28 = this.$isHistory;
        this.label = 1;
        r10 = r115.d(r26, r27, r28, this);
        if (r10 != r0) goto L16;
        return r0;
    }
}
