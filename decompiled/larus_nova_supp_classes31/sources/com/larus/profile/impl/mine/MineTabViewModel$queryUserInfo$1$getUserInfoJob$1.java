package com.larus.profile.impl.mine;

import com.larus.profile.impl.ProfileRepo;
import com.larus.profile.impl.ProfileRequestSource;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.mine.MineTabViewModel$queryUserInfo$1$getUserInfoJob$1", f = "MineTabViewModel.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
public final class MineTabViewModel$queryUserInfo$1$getUserInfoJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends fs9.u>>, Object> {
    final /* synthetic */ fs9.u $cache;
    final /* synthetic */ ProfileRequestSource $source;
    int label;
    final /* synthetic */ MineTabViewModel this$0;

    public MineTabViewModel$queryUserInfo$1$getUserInfoJob$1(MineTabViewModel r1, ProfileRequestSource r2, fs9.u r3, Continuation<? super MineTabViewModel$queryUserInfo$1$getUserInfoJob$1> r4) {
        this.this$0 = r1;
        this.$source = r2;
        this.$cache = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MineTabViewModel$queryUserInfo$1$getUserInfoJob$1(this.this$0, this.$source, this.$cache, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<fs9.u>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ProfileRepo r7 = MineTabViewModel.access$getRepo$p(this.this$0);
        String r2 = this.this$0.getUserId();
        ProfileRequestSource r3 = this.$source;
        if (this.$cache == null) goto L11;
        boolean r4 = true;
    L12:
        this.label = 1;
        r7.getClass();
        r6 = ProfileRepo.e(r2, r3, r4, this);
        if (r6 != r0) goto L15;
        return r0;
    L11:
        r4 = false;
        goto L12
    }
}
