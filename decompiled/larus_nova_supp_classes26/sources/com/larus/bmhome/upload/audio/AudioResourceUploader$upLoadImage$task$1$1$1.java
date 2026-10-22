package com.larus.bmhome.upload.audio;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1$1$1", f = "AudioResourceUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioResourceUploader$upLoadImage$task$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<i, Unit> $onSuccess;
    final /* synthetic */ i $result;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioResourceUploader$upLoadImage$task$1$1$1(Function1<? super i, Unit> r1, i r2, Continuation<? super AudioResourceUploader$upLoadImage$task$1$1$1> r3) {
        this.$onSuccess = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AudioResourceUploader$upLoadImage$task$1$1$1(this.$onSuccess, this.$result, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        this.$onSuccess.invoke(this.$result);
        List<h> r6 = this.$result.a();
        if (r6 == null) goto L18;
        List r7 = CollectionsKt.filterNotNull(r6);
        if (r7 == null) goto L18;
        i r0 = this.$result;
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L27;
        h r1 = (h) r8.next();
        Map<String, l> r2 = g.b;
        String r3 = r1.a();
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        l r4 = (l) ((LinkedHashMap) r2).get(r3);
        if (r4 == null) goto L10;
        r4.I0(r0, r1);
        goto L10
    L27:
        return Unit.INSTANCE;
    L18:
        return null;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
