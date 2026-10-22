package com.larus.bot.impl.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.BitmapHelperKt$prefetchBitmap$4", f = "BitmapHelper.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class BitmapHelperKt$prefetchBitmap$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ List<String> $urls;
    private /* synthetic */ Object L$0;
    int label;

    public BitmapHelperKt$prefetchBitmap$4(List<String> r1, Continuation<? super BitmapHelperKt$prefetchBitmap$4> r2) {
        this.$urls = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BitmapHelperKt$prefetchBitmap$4 r0 = new BitmapHelperKt$prefetchBitmap$4(this.$urls, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L20:
        return (List) r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        List<String> r2 = this.$urls;
        if (r2 == null) goto L22;
        List r3 = CollectionsKt.filterNotNull(r2);
        if (r3 == null) goto L23;
        List r4 = r3;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        r10.add(BuildersKt.async$default(r13, null, null, new BitmapHelperKt$prefetchBitmap$4$1$1((String) r5.next(), null), 3, null));
        goto L14
    L16:
        this.label = 1;
        r12 = AwaitKt.a(r10, this);
        if (r12 != r0) goto L20;
        return r0;
    L23:
        return null;
    L22:
        return null;
    }
}
