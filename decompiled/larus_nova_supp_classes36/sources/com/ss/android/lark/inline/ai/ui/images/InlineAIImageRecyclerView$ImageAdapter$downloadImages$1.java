package com.ss.android.lark.inline.ai.ui.images;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.ui.ImageData;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.images.InlineAIImageRecyclerView$ImageAdapter$downloadImages$1", f = "InlineAIImageRecyclerView.kt", i = {0}, l = {219}, m = "invokeSuspend", n = {"downloadRes"}, s = {"L$0"})
final class InlineAIImageRecyclerView$ImageAdapter$downloadImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ImageData> $images;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InlineAIImageRecyclerView.ImageAdapter this$0;

    public InlineAIImageRecyclerView$ImageAdapter$downloadImages$1(List<ImageData> r1, InlineAIImageRecyclerView.ImageAdapter r2, Continuation<? super InlineAIImageRecyclerView$ImageAdapter$downloadImages$1> r3) {
        this.$images = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        InlineAIImageRecyclerView$ImageAdapter$downloadImages$1 r0 = new InlineAIImageRecyclerView$ImageAdapter$downloadImages$1(this.$images, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$1;
        ConcurrentHashMap r3 = (ConcurrentHashMap) this.L$0;
        ResultKt.throwOnFailure(r13);
    L15:
        if (r2.hasNext() == false) goto L19;
        Deferred r4 = (Deferred) r2.next();
        this.L$0 = r3;
        this.L$1 = r2;
        this.label = 1;
        if (r4.await(this) != r0) goto L15;
        return r0;
    L19:
        Log.i("ImageRecyclerView", "all download complete");
        InlineAIImageRecyclerView.ImageAdapter.a r14 = this.this$0.h;
        if (r14 == null) goto L23;
        r14.e(r3);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        ArrayList r5 = new ArrayList();
        ConcurrentHashMap r9 = new ConcurrentHashMap();
        List<ImageData> r6 = this.$images;
        InlineAIImageRecyclerView.ImageAdapter r10 = this.this$0;
        Iterator<T> r11 = r6.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        ImageData r7 = (ImageData) r11.next();
        r10.f.put(r7.getId(), Boxing.boxInt(1));
        r5.add(BuildersKt.async$default(r15, Dispatchers.getIO(), null, new InlineAIImageRecyclerView$ImageAdapter$downloadImages$1$1$1(r7, r10, r9, null), 2, null));
        goto L10
    L12:
        r2 = r5.iterator();
        r3 = r9;
        goto L15
    }
}
