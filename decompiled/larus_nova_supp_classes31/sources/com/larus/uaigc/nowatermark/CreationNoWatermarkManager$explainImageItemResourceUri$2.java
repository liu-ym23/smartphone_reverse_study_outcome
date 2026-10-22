package com.larus.uaigc.nowatermark;

import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager$explainImageItemResourceUri$2", f = "CreationNoWatermarkManager.kt", i = {}, l = {1778}, m = "invokeSuspend", n = {}, s = {})
public final class CreationNoWatermarkManager$explainImageItemResourceUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $explainInFlightKey;
    final /* synthetic */ String $negativeKey;
    final /* synthetic */ List<String> $urls;
    int label;

    public CreationNoWatermarkManager$explainImageItemResourceUri$2(String r1, List<String> r2, String r3, Continuation<? super CreationNoWatermarkManager$explainImageItemResourceUri$2> r4) {
        this.$explainInFlightKey = r1;
        this.$urls = r2;
        this.$negativeKey = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationNoWatermarkManager$explainImageItemResourceUri$2(this.$explainInFlightKey, this.$urls, this.$negativeKey, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
    L10:
        if (CreationNoWatermarkManager.k.contains(this.$explainInFlightKey) == false) goto L30;
        List<String> r7 = this.$urls;
        if ((r7 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        String r2 = (String) r8.next();
        if (CreationNoWatermarkManager.l.containsKey(r2) == false) goto L18;
        boolean r9 = false;
    L23:
        if (r9 == false) goto L30;
        CreationNoWatermarkManager r10 = CreationNoWatermarkManager.a;
        ConcurrentHashMap.KeySetView r3 = CreationNoWatermarkManager.g;
        String r4 = this.$negativeKey;
        r10.getClass();
        if (r3.contains(r4) == true) goto L30;
        this.label = 1;
        if (DelayKt.delay(50, this) != r0) goto L10;
        return r0;
    L22:
        r9 = true;
        goto L23
    L14:
        if (r7.isEmpty() == false) goto L16;
    L30:
        return Unit.INSTANCE;
    }
}
