package com.larus.bmhome.upload.audio;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1$2$1", f = "AudioResourceUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioResourceUploader$upLoadImage$task$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<b> $content;
    final /* synthetic */ Throwable $it;
    final /* synthetic */ Function1<Throwable, Unit> $onFail;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioResourceUploader$upLoadImage$task$1$2$1(Function1<? super Throwable, Unit> r1, Throwable r2, List<b> r3, Continuation<? super AudioResourceUploader$upLoadImage$task$1$2$1> r4) {
        this.$onFail = r1;
        this.$it = r2;
        this.$content = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AudioResourceUploader$upLoadImage$task$1$2$1(this.$onFail, this.$it, this.$content, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        this.$onFail.invoke(this.$it);
        List<b> r6 = this.$content;
        Throwable r0 = this.$it;
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        b r1 = (b) r7.next();
        Map<String, l> r2 = g.b;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        l r4 = (l) r3.get(r1.a());
        if (r4 == null) goto L6;
        r4.H0(r1, r0);
        goto L6
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
