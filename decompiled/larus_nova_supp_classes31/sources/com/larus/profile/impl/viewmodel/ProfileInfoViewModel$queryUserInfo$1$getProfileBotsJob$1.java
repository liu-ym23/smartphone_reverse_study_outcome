package com.larus.profile.impl.viewmodel;

import com.larus.profile.impl.ProfileRepo;
import com.larus.profile.impl.ProfileRequestSource;
import com.tencent.open.log.TraceLevel;
import fs9.r;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/ProfileBotListResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileInfoViewModel$queryUserInfo$1$getProfileBotsJob$1", f = "ProfileInfoViewModel.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileInfoViewModel$queryUserInfo$1$getProfileBotsJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends r>>, Object> {
    final /* synthetic */ ProfileRequestSource $source;
    int label;
    final /* synthetic */ ProfileInfoViewModel this$0;

    public ProfileInfoViewModel$queryUserInfo$1$getProfileBotsJob$1(ProfileInfoViewModel r1, ProfileRequestSource r2, Continuation<? super ProfileInfoViewModel$queryUserInfo$1$getProfileBotsJob$1> r3) {
        this.this$0 = r1;
        this.$source = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProfileInfoViewModel$queryUserInfo$1$getProfileBotsJob$1(this.this$0, this.$source, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<r>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ProfileRepo r6 = ProfileInfoViewModel.access$getRepo$p(this.this$0);
        String r2 = this.this$0.getUserId();
        ProfileRequestSource r3 = this.$source;
        this.label = 1;
        r6.getClass();
        r5 = ProfileRepo.c(r2, "", r3, false, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
