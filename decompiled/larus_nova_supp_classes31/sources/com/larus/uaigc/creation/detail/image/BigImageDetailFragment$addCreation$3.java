package com.larus.uaigc.creation.detail.image;

import android.content.Context;
import com.larus.utils.p0;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$addCreation$3", f = "BigImageDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BigImageDetailFragment$addCreation$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ zp9.a $result;
    int label;
    final /* synthetic */ BigImageDetailFragment this$0;

    public BigImageDetailFragment$addCreation$3(BigImageDetailFragment r1, zp9.a r2, Continuation<? super BigImageDetailFragment$addCreation$3> r3) {
        this.this$0 = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BigImageDetailFragment$addCreation$3(this.this$0, this.$result, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r3);
        BigImageDetailFragment r4 = this.this$0;
        int r0 = BigImageDetailFragment.I;
        r4.ma0(1);
        int r5 = p0.a;
        zp9.a r6 = this.$result;
        if (r6 == null) goto L7;
        String r7 = r6.d;
    L8:
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        String r8 = p0.a(r7);
        if (r8 == null) goto L16;
        BigImageDetailFragment r1 = this.this$0;
        t19.s r2 = t19.s.a;
        Context r9 = r1.getContext();
        r2.getClass();
        t19.s.t(r9, r8);
        return Unit.INSTANCE;
    L16:
        return null;
    L7:
        r7 = null;
        goto L8
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
