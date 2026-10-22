package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.applet.granting.GrantingAction;
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
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.McpGrantingManager$onConfirmationResult$2", f = "McpGrantingManager.kt", i = {}, l = {371, 375}, m = "invokeSuspend", n = {}, s = {})
public final class McpGrantingManager$onConfirmationResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GrantingAction $action;
    final /* synthetic */ u2.c $appletMetaData;
    final /* synthetic */ f $grantingContext;
    final /* synthetic */ String $msgID;
    final /* synthetic */ i $strategy;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowResult.values().length];
            r0[FlowResult.CONTINUE_NEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FlowResult.STOP_FLOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FlowResult.REQUIRES_CONFIRMATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public McpGrantingManager$onConfirmationResult$2(GrantingAction r1, i r10, f r11, String r12, u2.c r13, Continuation<? super McpGrantingManager$onConfirmationResult$2> r14) {
        this.$action = r1;
        this.$strategy = r10;
        this.$grantingContext = r11;
        this.$msgID = r12;
        this.$appletMetaData = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new McpGrantingManager$onConfirmationResult$2(this.$action, this.$strategy, this.$grantingContext, this.$msgID, this.$appletMetaData, r11);
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
    L23:
        c r11 = (c) r10;
    L24:
        u2.a r12 = r11.d;
        if (r12 == null) goto L27;
        f r13 = this.$grantingContext;
        r13.d.a(this.$msgID, r12);
    L27:
        u2.f r14 = r11.e;
        if (r14 == null) goto L32;
        u2.c r15 = this.$appletMetaData;
        f r16 = this.$grantingContext;
        final String r17 = this.$msgID;
        String r18 = r15.f.c;
        u2.e r19 = v.c(r16.a, r14);
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r16.a = r19;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r20 = AppletRuntimeManager.d;
        if (r20 == null) goto L32;
        r20.t(r17, r18, com.bytedance.ai.applet.base.gson.e.c(r19), new s(r17));
    L32:
        int r21 = a.a[r11.a.ordinal()];
        if (r21 != 1) goto L35;
        McpGrantingManager.b(McpGrantingManager.a, this.$grantingContext, this.$action, r11.e);
        McpGrantingManager.l(this.$grantingContext, false);
    L53:
        return Unit.INSTANCE;
    L35:
        if (r21 != 2) goto L37;
        com.bytedance.ai.utils.g r22 = com.bytedance.ai.utils.g.a;
        r22.i("McpGrantingManagerV2", "Strong dependency rejected in confirmation, stop granting flow");
        McpGrantingManager.b(McpGrantingManager.a, this.$grantingContext, this.$action, r11.e);
        if (this.$action == GrantingAction.REJECTED) goto L44;
    L50:
        McpGrantingManager.g(this.$grantingContext, false);
        goto L53
    L44:
        if (this.$grantingContext.a.i() == true) goto L50;
        r22.i("McpGrantingManagerV2", "Confirmation rejected without resend query, stop granting flow");
        if (r11.e != null) goto L49;
        this.$grantingContext.j.set(false);
        this.$grantingContext.k.set(0);
    L49:
        return Unit.INSTANCE;
    L37:
        if (r21 != 3) goto L40;
        com.bytedance.ai.utils.g.a.w("McpGrantingManagerV2", "Unexpected flow result: REQUIRES_CONFIRMATION in onConfirmationReject");
        goto L53
    L40:
        throw new NoWhenBranchMatchedException();
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L15:
        r11 = (c) r10;
        goto L24
    L10:
        ResultKt.throwOnFailure(r10);
        if (this.$action != GrantingAction.REJECTED) goto L16;
        i r23 = this.$strategy;
        f r24 = this.$grantingContext;
        this.label = 1;
        r10 = r23.h(r24);
        if (r10 != r0) goto L15;
        return r0;
    L16:
        com.bytedance.applet.impl.j r25 = this.$grantingContext.e;
        if (r25 == null) goto L19;
        boolean r26 = r25.a(this.$msgID);
    L20:
        i r27 = this.$strategy;
        f r28 = this.$grantingContext;
        this.label = 2;
        r10 = r27.e(r28, !r26);
        if (r10 != r0) goto L23;
        return r0;
    L19:
        r26 = false;
        goto L20
    }
}
