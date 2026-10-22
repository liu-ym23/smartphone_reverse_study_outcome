package com.larus.bmhome.chat.standarduikit.videogroup.binder;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zn8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/bmhome/chat/standarduikit/videogroup/view/VideoData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.videogroup.binder.RelatedVideoBinder$parseGetVideoDataList$2", f = "RelatedVideoBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RelatedVideoBinder$parseGetVideoDataList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends q>>, Object> {
    final /* synthetic */ Message $message;
    final /* synthetic */ usc.e $span;
    int label;
    final /* synthetic */ RelatedVideoBinder this$0;

    public RelatedVideoBinder$parseGetVideoDataList$2(usc.e r1, RelatedVideoBinder r2, Message r3, Continuation<? super RelatedVideoBinder$parseGetVideoDataList$2> r4) {
        this.$span = r1;
        this.this$0 = r2;
        this.$message = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RelatedVideoBinder$parseGetVideoDataList$2(this.$span, this.this$0, this.$message, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<q>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        fh8.b.a r5 = fh8.b.a;
        final usc.e r6 = this.$span;
        final RelatedVideoBinder r0 = this.this$0;
        final Message r1 = this.$message;
        return fh8.b.a(r6, new b(r0, r6, r1));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
