package com.larus.commercecredit.impl.page;

import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.page.CommerceInviteFriendsFragment$getGroupInvitationInfo$1", f = "CommerceInviteFriendsFragment.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
final class CommerceInviteFriendsFragment$getGroupInvitationInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<qz8.l, Unit> $inviteAction;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ CommerceInviteFriendsFragment this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceInviteFriendsFragment$getGroupInvitationInfo$1(String r1, CommerceInviteFriendsFragment r2, Function1<? super qz8.l, Unit> r3, Continuation<? super CommerceInviteFriendsFragment$getGroupInvitationInfo$1> r4) {
        this.$scene = r1;
        this.this$0 = r2;
        this.$inviteAction = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommerceInviteFriendsFragment$getGroupInvitationInfo$1(this.$scene, this.this$0, this.$inviteAction, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CommerceCreditConfigManager r8 = CommerceCreditConfigManager.a;
        String r9 = this.$scene;
        CommerceInviteFriendsFragment r2 = this.this$0;
        int r3 = CommerceInviteFriendsFragment.i;
        String r4 = (String) r2.g.getValue();
        i0 r5 = new i0(this.this$0, this.$inviteAction);
        this.label = 1;
        if (CommerceCreditConfigManager.d(r9, r4, r5, this) != r0) goto L12;
        return r0;
    }
}
