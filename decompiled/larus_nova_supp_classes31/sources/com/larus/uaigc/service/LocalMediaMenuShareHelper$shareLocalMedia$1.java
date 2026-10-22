package com.larus.uaigc.service;

import android.net.Uri;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.service.LocalMediaMenuShareHelper$shareLocalMedia$1", f = "LocalMediaMenuShareHelper.kt", i = {}, l = {160, 161}, m = "invokeSuspend", n = {}, s = {})
final class LocalMediaMenuShareHelper$shareLocalMedia$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Uri, Boolean> $launchShare;
    final /* synthetic */ Function0<Unit> $onFailure;
    final /* synthetic */ Function1<Continuation<? super Uri>, Object> $prepareUri;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalMediaMenuShareHelper$shareLocalMedia$1(Function1<? super Continuation<? super Uri>, ? extends Object> r1, Function0<Unit> r2, Function1<? super Uri, Boolean> r3, Continuation<? super LocalMediaMenuShareHelper$shareLocalMedia$1> r4) {
        this.$prepareUri = r1;
        this.$onFailure = r2;
        this.$launchShare = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LocalMediaMenuShareHelper$shareLocalMedia$1(this.$prepareUri, this.$onFailure, this.$launchShare, r5);
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
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L17:
        if (((Boolean) r7).booleanValue() == true) goto L20;
        this.$onFailure.invoke();
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        LocalMediaMenuShareHelper$shareLocalMedia$1$success$1 r3 = new LocalMediaMenuShareHelper$shareLocalMedia$1$success$1((Uri) r7, this.$launchShare, null);
        this.label = 2;
        r7 = BuildersKt.withContext(r2, r3, this);
        if (r7 != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        Function1<Continuation<? super Uri>, Object> r8 = this.$prepareUri;
        this.label = 1;
        r7 = r8.invoke(this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
