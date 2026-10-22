package com.larus.chat.gallery.impl.preview.datasource;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/chat/gallery/impl/preview/datasource/LoadMoreResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.datasource.PreviewCreationRecordDataSource$awaitLoadMore$2", f = "PreviewCreationRecordDataSource.kt", i = {}, l = {569}, m = "invokeSuspend", n = {}, s = {})
public final class PreviewCreationRecordDataSource$awaitLoadMore$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
    final /* synthetic */ int $currentDataSize;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ PreviewCreationRecordDataSource this$0;

    public PreviewCreationRecordDataSource$awaitLoadMore$2(PreviewCreationRecordDataSource r1, int r2, Continuation<? super PreviewCreationRecordDataSource$awaitLoadMore$2> r3) {
        this.this$0 = r1;
        this.$currentDataSize = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PreviewCreationRecordDataSource$awaitLoadMore$2(this.this$0, this.$currentDataSize, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        PreviewCreationRecordDataSource r2 = (PreviewCreationRecordDataSource) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        PreviewCreationRecordDataSource r7 = this.this$0;
        int r3 = this.$currentDataSize;
        this.L$0 = r7;
        this.I$0 = r3;
        this.label = 1;
        kotlinx.coroutines.j r4 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r4.C();
        final f r5 = new f(r4, r7.a, r3);
        r5.a.i(new c(r5));
        new Handler(Looper.getMainLooper()).post(new d(r5));
        r6 = r4.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r6 != r0) goto L13;
        return r0;
    }
}
