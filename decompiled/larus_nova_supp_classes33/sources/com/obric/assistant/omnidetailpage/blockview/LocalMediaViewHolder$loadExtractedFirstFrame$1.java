package com.obric.assistant.omnidetailpage.blockview;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.blockview.LocalMediaViewHolder$loadExtractedFirstFrame$1", f = "TaskLocalMediaPreviewView.kt", i = {}, l = {593}, m = "invokeSuspend", n = {}, s = {})
final class LocalMediaViewHolder$loadExtractedFirstFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ifa.c.b $item;
    int label;
    final /* synthetic */ j this$0;

    public LocalMediaViewHolder$loadExtractedFirstFrame$1(j r1, ifa.c.b r2, Continuation<? super LocalMediaViewHolder$loadExtractedFirstFrame$1> r3) {
        this.this$0 = r1;
        this.$item = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalMediaViewHolder$loadExtractedFirstFrame$1(this.this$0, this.$item, r4);
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
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        Bitmap r8 = (Bitmap) r7;
        if (r8 == null) goto L26;
        ifa.c.b r2 = this.this$0.k;
        if (r2 == null) goto L16;
        String r4 = r2.a;
    L18:
        if (Intrinsics.areEqual(r4, this.$item.a) == false) goto L26;
        ifa.c.b r5 = this.this$0.k;
        if (r5 == null) goto L23;
        r3 = r5.c;
    L23:
        if (Intrinsics.areEqual(r3, this.$item.c) == false) goto L26;
        this.this$0.g.setImageBitmap(r8);
        this.this$0.g.setVisibility(0);
        goto L26
    L16:
        r4 = null;
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1 r6 = new LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1(this.this$0, this.$item, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r9, r6, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
