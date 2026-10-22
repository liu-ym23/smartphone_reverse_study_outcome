package com.larus.community.impl.detail.image;

import com.larus.bmhome.actionbar.model.j1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.image.CreationDetailImageComponent$detectCreationImage$1$1$1", f = "CreationDetailImageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailImageComponent$detectCreationImage$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j1 $it;
    int label;
    final /* synthetic */ CreationDetailImageComponent this$0;

    public CreationDetailImageComponent$detectCreationImage$1$1$1(CreationDetailImageComponent r1, j1 r2, Continuation<? super CreationDetailImageComponent$detectCreationImage$1$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationDetailImageComponent$detectCreationImage$1$1$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        t1a.b r4 = s1a.a.g(s1a.a.c(this.this$0));
        int r0 = j29.b.b;
        j1 r1 = this.$it;
        Intrinsics.checkNotNullParameter(r1, "avatarDetectInfo");
        r4.n(new j29.b(r1), j29.b.class);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
