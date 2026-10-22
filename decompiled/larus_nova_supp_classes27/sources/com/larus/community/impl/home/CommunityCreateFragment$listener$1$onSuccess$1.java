package com.larus.community.impl.home;

import com.larus.community.impl.databinding.LarusCommunityMainFragmentLayoutBinding;
import com.larus.community.impl.view.CommunityCreateButton;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.home.CommunityCreateFragment$listener$1$onSuccess$1", f = "CommunityCreateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CommunityCreateFragment$listener$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommunityCreateFragment this$0;

    public CommunityCreateFragment$listener$1$onSuccess$1(CommunityCreateFragment r1, Continuation<? super CommunityCreateFragment$listener$1$onSuccess$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommunityCreateFragment$listener$1$onSuccess$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        LarusCommunityMainFragmentLayoutBinding r3 = this.this$0.k;
        if (r3 == null) goto L9;
        CommunityCreateButton r4 = r3.b;
        if (r4 == null) goto L9;
        e1.o(r4);
    L9:
        this.this$0.B = false;
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
