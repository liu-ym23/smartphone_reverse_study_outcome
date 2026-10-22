package com.larus.profile.impl.view;

import com.larus.bmhome.utils.a4;
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
@DebugMetadata(c = "com.larus.profile.impl.view.ProfileInfoView$initRecyclerView$1$1$1$onAction$2", f = "ProfileInfoView.kt", i = {}, l = {203, 205}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileInfoView$initRecyclerView$1$1$1$onAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fs9.n $profileBot;
    int label;
    final /* synthetic */ ProfileInfoView this$0;

    public ProfileInfoView$initRecyclerView$1$1$1$onAction$2(fs9.n r1, ProfileInfoView r2, Continuation<? super ProfileInfoView$initRecyclerView$1$1$1$onAction$2> r3) {
        this.$profileBot = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProfileInfoView$initRecyclerView$1$1$1$onAction$2(this.$profileBot, this.this$0, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L23:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r7);
        a4.a.getClass();
        a4.a(a4.b);
        if (this.$profileBot.p() == true) goto L17;
        ProfileInfoView.b r8 = this.this$0.m;
        if (r8 == null) goto L23;
        fs9.n r2 = this.$profileBot;
        this.label = 1;
        if (r8.g(r2) != r0) goto L23;
        return r0;
    L17:
        ProfileInfoView.b r9 = this.this$0.m;
        if (r9 == null) goto L23;
        fs9.n r3 = this.$profileBot;
        this.label = 2;
        if (r9.a(r3) != r0) goto L23;
        return r0;
    }
}
