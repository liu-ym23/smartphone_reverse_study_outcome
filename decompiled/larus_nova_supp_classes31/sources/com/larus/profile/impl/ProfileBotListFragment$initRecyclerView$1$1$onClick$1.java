package com.larus.profile.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.profile.impl.ProfileBotListFragment$initRecyclerView$1$1$onClick$1", f = "ProfileBotListFragment.kt", i = {1, 1}, l = {386, 391}, m = "invokeSuspend", n = {"validExistConv", "isDeleted"}, s = {"L$0", "I$0"})
public final class ProfileBotListFragment$initRecyclerView$1$1$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fs9.n $profileBot;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ ProfileBotListFragment this$0;

    public ProfileBotListFragment$initRecyclerView$1$1$onClick$1(ProfileBotListFragment r1, fs9.n r2, Continuation<? super ProfileBotListFragment$initRecyclerView$1$1$onClick$1> r3) {
        this.this$0 = r1;
        this.$profileBot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProfileBotListFragment$initRecyclerView$1$1$onClick$1(this.this$0, this.$profileBot, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v22 */
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        wc9.e r3 = null;
        boolean r5 = false;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        int r4 = this.I$0;
        wc9.e r6 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r7 = r17;
    L39:
        String r8 = (String) r7;
        r3 = r6;
        ?? r9 = r4;
    L40:
        final String r10 = r8;
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("onClick bot conversationId: ");
        r12.append(this.$profileBot.i());
        r12.append(", has conversation: ");
        if (r3 == null) goto L43;
        boolean r13 = true;
    L44:
        r12.append(r13);
        r12.append(", conversationId: ");
        r12.append(r10);
        r12.append(", isDeleted: ");
        if (r9 == 0) goto L47;
        r5 = true;
    L47:
        r12.append(r5);
        r11.i("ProfileBotListFragment", r12.toString());
        final ProfileBotListFragment r14 = this.this$0;
        final fs9.n r15 = this.$profileBot;
        int r16 = ProfileBotListFragment.y;
        final String r18 = "";
        Fragment r19 = r14.getParentFragment();
        if (r19 == null) goto L66;
        if (r19.getActivity() == null) goto L66;
        int r20 = com.larus.profile.impl.info.a.c;
        if (com.larus.profile.impl.info.a.C0014a.a(r14.getArguments(), r14.getActivity()).a == false) goto L61;
        ICreationWorkflowService.Companion r110 = ICreationWorkflowService.a;
        Context r111 = r14.getContext();
        if (r111 == null) goto L66;
        final wc9.e r112 = r3;
        if (r110.S(r111, new o(r14, r15, r112, r10, r18)) == true) goto L66;
        r11.e("ProfileBotListFragment", "open profile bot failed in AI creation applet: native host is null");
    L61:
        Context r21 = r14.getContext();
        if (r21 == null) goto L66;
        r14.ca0(r21, false, r15, r3, r10, "");
    L66:
        return Unit.INSTANCE;
    L43:
        r13 = false;
        goto L44
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
        Object r22 = r17;
    L13:
        wc9.e r23 = (wc9.e) r22;
        if (r23 == null) goto L24;
        Integer r24 = r23.t;
        if (r24 != null) goto L19;
    L20:
        boolean r25 = true;
    L22:
        if (r25 == false) goto L24;
        r3 = r23;
        goto L24
    L19:
        if (r24.intValue() != 2) goto L20;
        r25 = false;
    L24:
        if (r23 == null) goto L31;
        Integer r26 = r23.t;
        if (r26 == null) goto L31;
        if (r26.intValue() != 2) goto L31;
        boolean r27 = true;
    L32:
        if (r3 == null) goto L35;
        r8 = r3.a;
        r9 = r27;
        if (r8 != null) goto L40;
    L35:
        ProfileBotListFragment r28 = this.this$0;
        fs9.n r29 = this.$profileBot;
        this.L$0 = r3;
        this.I$0 = r27 ? 1 : 0;
        this.label = 2;
        r7 = ProfileBotListFragment.Z90(r28, r29, r27, this);
        if (r7 != r1) goto L38;
        return r1;
    L38:
        r4 = r27 ? 1 : 0;
        r6 = r3;
    L31:
        r27 = false;
        goto L32
    L10:
        ResultKt.throwOnFailure(r17);
        RepoDispatcherDelegate r30 = RepoDispatcherDelegate.b;
        ProfileBotListFragment$initRecyclerView$1$1$onClick$1$existConv$1 r31 = new ProfileBotListFragment$initRecyclerView$1$1$onClick$1$existConv$1(this.$profileBot, null);
        this.label = 1;
        r22 = r30.d(r31, this);
        if (r22 != r1) goto L13;
        return r1;
    }
}
