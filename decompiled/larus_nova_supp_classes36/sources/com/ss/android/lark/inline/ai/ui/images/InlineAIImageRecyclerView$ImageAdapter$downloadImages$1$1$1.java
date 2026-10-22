package com.ss.android.lark.inline.ai.ui.images;

import com.bumptech.glide.RequestManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.ui.ImageData;
import com.ss.android.lark.inline.ai.utils.d;
import com.ss.android.lark.log.Log;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.images.InlineAIImageRecyclerView$ImageAdapter$downloadImages$1$1$1", f = "InlineAIImageRecyclerView.kt", i = {0}, l = {208}, m = "invokeSuspend", n = {"urlHash"}, s = {"I$0"})
public final class InlineAIImageRecyclerView$ImageAdapter$downloadImages$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConcurrentHashMap<String, Boolean> $downloadRes;
    final /* synthetic */ ImageData $it;
    int I$0;
    int label;
    final /* synthetic */ InlineAIImageRecyclerView.ImageAdapter this$0;

    public InlineAIImageRecyclerView$ImageAdapter$downloadImages$1$1$1(ImageData r1, InlineAIImageRecyclerView.ImageAdapter r2, ConcurrentHashMap<String, Boolean> r3, Continuation<? super InlineAIImageRecyclerView$ImageAdapter$downloadImages$1$1$1> r4) {
        this.$it = r1;
        this.this$0 = r2;
        this.$downloadRes = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new InlineAIImageRecyclerView$ImageAdapter$downloadImages$1$1$1(this.$it, this.this$0, this.$downloadRes, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        int r1 = this.I$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L8
    L17:
        Log.i("ImageRecyclerView", "download success, url = " + r1);     // Catch: Throwable -> L8
        this.this$0.f.put(this.$it.getId(), Boxing.boxInt(2));     // Catch: Throwable -> L8
        this.$downloadRes.put(this.$it.getId(), Boxing.boxBoolean(true));     // Catch: Throwable -> L8
    L23:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        th = th;
        int r8 = r1;
    L21:
        this.this$0.f.put(this.$it.getId(), Boxing.boxInt(3));
        this.$downloadRes.put(this.$it.getId(), Boxing.boxBoolean(false));
        Log.e("ImageRecyclerView", "download failed, url = " + r8, th);
        goto L23
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r7);
        r8 = this.$it.getUrl().hashCode();
        Log.i("ImageRecyclerView", "start downloading, url = " + r8);     // Catch: Throwable -> L20
        int r4 = d.a;     // Catch: Throwable -> L20
        RequestManager r5 = this.this$0.e;     // Catch: Throwable -> L20
        String r6 = this.$it.getUrl();     // Catch: Throwable -> L20
        this.I$0 = r8;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        if (d.a(r5, r6, this) != r2) goto L16;
        return r2;
    L16:
        r1 = r8;
    L20:
        th = th;
        goto L21
    }
}
