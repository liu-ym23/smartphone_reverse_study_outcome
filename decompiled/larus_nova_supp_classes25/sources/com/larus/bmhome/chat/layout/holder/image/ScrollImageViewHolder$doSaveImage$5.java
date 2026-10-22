package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.uaigc.service.IUgcAIGCService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.ScrollImageViewHolder$doSaveImage$5", f = "ImageScrollAdapter.kt", i = {}, l = {630}, m = "invokeSuspend", n = {}, s = {})
final class ScrollImageViewHolder$doSaveImage$5 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ String $subScene;
    int label;

    public ScrollImageViewHolder$doSaveImage$5(String r1, String r2, Continuation<? super ScrollImageViewHolder$doSaveImage$5> r3) {
        this.$imageUrl = r1;
        this.$subScene = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new ScrollImageViewHolder$doSaveImage$5(this.$imageUrl, this.$subScene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IUgcAIGCService.Companion r6 = IUgcAIGCService.a;
        String r2 = this.$imageUrl;
        String r3 = this.$subScene;
        this.label = 1;
        r5 = IUgcAIGCService.a.b(r6, r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
