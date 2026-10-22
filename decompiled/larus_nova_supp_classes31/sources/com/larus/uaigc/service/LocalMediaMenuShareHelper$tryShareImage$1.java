package com.larus.uaigc.service;

import android.content.Context;
import android.net.Uri;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.service.LocalMediaMenuShareHelper$tryShareImage$1", f = "LocalMediaMenuShareHelper.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
final class LocalMediaMenuShareHelper$tryShareImage$1 extends SuspendLambda implements Function1<Continuation<? super Uri>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $sourceUrl;
    int label;

    public LocalMediaMenuShareHelper$tryShareImage$1(Context r1, String r2, Continuation<? super LocalMediaMenuShareHelper$tryShareImage$1> r3) {
        this.$context = r1;
        this.$sourceUrl = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new LocalMediaMenuShareHelper$tryShareImage$1(this.$context, this.$sourceUrl, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Uri> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        u r8 = u.a;
        Context r2 = this.$context;
        String r3 = this.$sourceUrl;
        this.label = 1;
        r8.getClass();
        r7 = BuildersKt.withContext(Dispatchers.getIO(), new LocalMediaMenuShareHelper$resolveShareUri$2(r3, r2, true, null), this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
