package com.larus.uaigc.service;

import android.net.Uri;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.service.LocalMediaMenuShareHelper$shareLocalMedia$1$success$1", f = "LocalMediaMenuShareHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalMediaMenuShareHelper$shareLocalMedia$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<Uri, Boolean> $launchShare;
    final /* synthetic */ Uri $shareUri;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalMediaMenuShareHelper$shareLocalMedia$1$success$1(Uri r1, Function1<? super Uri, Boolean> r2, Continuation<? super LocalMediaMenuShareHelper$shareLocalMedia$1$success$1> r3) {
        this.$shareUri = r1;
        this.$launchShare = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalMediaMenuShareHelper$shareLocalMedia$1$success$1(this.$shareUri, this.$launchShare, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        Uri r3 = this.$shareUri;
        if (r3 == null) goto L7;
        boolean r4 = ((Boolean) this.$launchShare.invoke(r3)).booleanValue();
    L9:
        return Boxing.boxBoolean(r4);
    L7:
        r4 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
