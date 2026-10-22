package com.larus.uaigc.chat.markdown.image;

import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.uaigc.impl.databinding.LarusItemMarkdownCreationImageScrollBinding;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.MDImageScrollAdapter$MDImageScrollViewHolder$refreshShareOrDownloadBtn$1$3$1", f = "MDImageScrollAdapter.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
final class MDImageScrollAdapter$MDImageScrollViewHolder$refreshShareOrDownloadBtn$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusItemMarkdownCreationImageScrollBinding $this_apply;
    final /* synthetic */ String $url;
    int label;

    public MDImageScrollAdapter$MDImageScrollViewHolder$refreshShareOrDownloadBtn$1$3$1(String r1, LarusItemMarkdownCreationImageScrollBinding r2, Continuation<? super MDImageScrollAdapter$MDImageScrollViewHolder$refreshShareOrDownloadBtn$1$3$1> r3) {
        this.$url = r1;
        this.$this_apply = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MDImageScrollAdapter$MDImageScrollViewHolder$refreshShareOrDownloadBtn$1$3$1(this.$url, this.$this_apply, r4);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ImageDownloadLoadingMgr r7 = ImageDownloadLoadingMgr.a;
        String r2 = this.$url;
        final LarusItemMarkdownCreationImageScrollBinding r3 = this.$this_apply;
        Function1 r4 = new q(r3);
        this.label = 1;
        if (r7.a(r2, r4, this) != r0) goto L12;
        return r0;
    }
}
