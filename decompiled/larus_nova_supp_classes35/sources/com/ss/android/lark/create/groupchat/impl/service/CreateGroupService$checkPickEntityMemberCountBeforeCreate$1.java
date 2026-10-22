package com.ss.android.lark.create.groupchat.impl.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.m;
import com.ss.android.lark.pb.chats.PullChangeGroupMemberAuthorizationResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/ss/android/lark/pb/chats/PullChangeGroupMemberAuthorizationResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.CreateGroupService$checkPickEntityMemberCountBeforeCreate$1", f = "CreateGroupService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreateGroupService$checkPickEntityMemberCountBeforeCreate$1 extends SuspendLambda implements Function2<PullChangeGroupMemberAuthorizationResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<m> $callback;
    /* synthetic */ Object L$0;
    int label;

    public CreateGroupService$checkPickEntityMemberCountBeforeCreate$1(IGetDataCallback<m> r1, Continuation<? super CreateGroupService$checkPickEntityMemberCountBeforeCreate$1> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreateGroupService$checkPickEntityMemberCountBeforeCreate$1 r0 = new CreateGroupService$checkPickEntityMemberCountBeforeCreate$1(this.$callback, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(PullChangeGroupMemberAuthorizationResponse r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((PullChangeGroupMemberAuthorizationResponse) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r6);
        PullChangeGroupMemberAuthorizationResponse r7 = (PullChangeGroupMemberAuthorizationResponse) this.L$0;
        IGetDataCallback<m> r0 = this.$callback;
        int r1 = m.e;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        boolean r2 = r7.mpass.booleanValue();
        String r3 = r7.mmsg_description;
        if (r3 != null) goto L7;
        r3 = BuildConfig.FLAVOR;
    L7:
        r0.onSuccess(new m(r2, r3, r7.mneed_apply_for_incr.booleanValue(), r7.mis_cross_tenant.booleanValue()));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
