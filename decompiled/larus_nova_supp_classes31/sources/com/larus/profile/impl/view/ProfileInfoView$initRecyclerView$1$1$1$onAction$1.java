package com.larus.profile.impl.view;

import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.profile.impl.view.ProfileInfoView$initRecyclerView$1$1$1$onAction$1", f = "ProfileInfoView.kt", i = {1, 1}, l = {187, 192}, m = "invokeSuspend", n = {"validExistConv", "isDeleted"}, s = {"L$2", "I$0"})
public final class ProfileInfoView$initRecyclerView$1$1$1$onAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fs9.n $profileBot;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ProfileInfoView this$0;

    public ProfileInfoView$initRecyclerView$1$1$1$onAction$1(ProfileInfoView r1, fs9.n r2, Continuation<? super ProfileInfoView$initRecyclerView$1$1$1$onAction$1> r3) {
        this.this$0 = r1;
        this.$profileBot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProfileInfoView$initRecyclerView$1$1$1$onAction$1(this.this$0, this.$profileBot, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.larus.profile.impl.view.ProfileInfoView] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.profile.impl.view.ProfileInfoView] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final Object invokeSuspend(Object r20) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        wc9.e r4 = null;
        boolean r6 = false;
        if (r3 == 0) goto L14;
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L10;
        int r5 = this.I$0;
        wc9.e r7 = (wc9.e) this.L$2;
        fs9.n r8 = (fs9.n) this.L$1;
        ProfileInfoView r9 = (ProfileInfoView) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L62
        ProfileInfoView r10 = r9;
        Object r11 = r20;
    L48:
        String r12 = (String) r11;     // Catch: Throwable -> L62
        int r13 = r5;
        fs9.n r18 = r8;
        r4 = r7;
        fs9.n r14 = r18;
        ?? r15 = r10;
    L49:
        FLogger r16 = FLogger.a;     // Catch: Throwable -> L62
        StringBuilder r17 = new StringBuilder("onClick bot conversationId: ");     // Catch: Throwable -> L62
        r17.append(r14.i());     // Catch: Throwable -> L62
        r17.append(", has conversation: ");     // Catch: Throwable -> L62
        if (r4 == null) goto L52;
        boolean r0 = true;
    L53:
        r17.append(r0);     // Catch: Throwable -> L62
        r17.append(", conversationId: ");     // Catch: Throwable -> L62
        r17.append(r12);     // Catch: Throwable -> L62
        r17.append(", isDeleted: ");     // Catch: Throwable -> L62
        if (r13 == 0) goto L56;
        r6 = true;
    L56:
        r17.append(r6);     // Catch: Throwable -> L62
        r16.i("ProfileInfoView", r17.toString());     // Catch: Throwable -> L62
        int r1 = ProfileInfoView.n;     // Catch: Throwable -> L62
        final String r19 = "";
        r15.getClass();     // Catch: Throwable -> L62
        final ?? r110 = r15;
        final fs9.n r111 = r14;
        final wc9.e r112 = r4;
        final String r113 = r12;
        if (ICreationWorkflowService.a.S(r15.getContext(), new q(r110, r111, r112, r113, r19)) == true) goto L60;
        ?? r114 = r15;
        r114.Y5(r15.getContext(), false, r14, r4, r12, "");     // Catch: Throwable -> L62
    L60:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L65:
        return Unit.INSTANCE;
    L52:
        r0 = false;
        goto L53
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r14 = (fs9.n) this.L$1;
        ProfileInfoView r21 = (ProfileInfoView) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L62
        Object r22 = r20;
        ProfileInfoView r23 = r21;
    L19:
        wc9.e r24 = (wc9.e) r22;     // Catch: Throwable -> L62
        if (r24 == null) goto L30;
        Integer r115 = r24.t;     // Catch: Throwable -> L62
        if (r115 != null) goto L25;
    L26:
        boolean r116 = true;
    L28:
        if (r116 == false) goto L30;
        r4 = r24;
        goto L30
    L25:
        if (r115.intValue() != 2) goto L26;
        r116 = false;
    L30:
        if (r24 == null) goto L37;
        Integer r25 = r24.t;     // Catch: Throwable -> L62
        if (r25 == null) goto L37;
        if (r25.intValue() != 2) goto L37;
        r13 = 1;
    L38:
        if (r4 == null) goto L41;
        r12 = r4.a;     // Catch: Throwable -> L62
        r15 = r23;
        if (r12 != null) goto L49;
    L41:
        if (r13 == 0) goto L43;
        boolean r117 = true;
    L44:
        this.L$0 = r23;     // Catch: Throwable -> L62
        this.L$1 = r14;     // Catch: Throwable -> L62
        this.L$2 = r4;     // Catch: Throwable -> L62
        this.I$0 = r13;     // Catch: Throwable -> L62
        this.label = 2;     // Catch: Throwable -> L62
        r11 = ProfileInfoView.R5(r23, r14, r117, this);     // Catch: Throwable -> L62
        if (r11 != r2) goto L47;
        return r2;
    L47:
        r5 = r13;
        wc9.e r118 = r4;
        r8 = r14;
        r7 = r118;
        r10 = r23;
        goto L48
    L43:
        r117 = false;
    L37:
        r13 = 0;
        goto L38
    L14:
        ResultKt.throwOnFailure(r20);
        ProfileInfoView r26 = this.this$0;
        fs9.n r27 = this.$profileBot;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L62
        RepoDispatcherDelegate r29 = RepoDispatcherDelegate.b;     // Catch: Throwable -> L62
        ProfileInfoView$initRecyclerView$1$1$1$onAction$1$1$existConv$1 r119 = new ProfileInfoView$initRecyclerView$1$1$1$onAction$1$1$existConv$1(r27, null);     // Catch: Throwable -> L62
        this.L$0 = r26;     // Catch: Throwable -> L62
        this.L$1 = r27;     // Catch: Throwable -> L62
        this.label = 1;     // Catch: Throwable -> L62
        r22 = r29.d(r119, this);     // Catch: Throwable -> L62
        if (r22 != r2) goto L18;
        return r2;
    L18:
        r23 = r26;
        r14 = r27;
    L62:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    }
}
