package com.larus.chat.gallery.api.datasource;

import com.larus.im.bean.message.Message;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.api.datasource.BaseChatDataSource$loadPrevious$2$galleryDataLists$1$1", f = "BaseChatDataSource.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
public final class BaseChatDataSource$loadPrevious$2$galleryDataLists$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Object>>, Object> {
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ BaseChatDataSource<Object> this$0;

    public BaseChatDataSource$loadPrevious$2$galleryDataLists$1$1(BaseChatDataSource<Object> r1, Message r2, Continuation<? super BaseChatDataSource$loadPrevious$2$galleryDataLists$1$1> r3) {
        this.this$0 = r1;
        this.$message = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BaseChatDataSource$loadPrevious$2$galleryDataLists$1$1(this.this$0, this.$message, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        List r5 = (List) r4;
        if (r5 == null) goto L14;
        return r5;
    L14:
        return CollectionsKt.emptyList();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        BaseChatDataSource<Object> r6 = this.this$0;
        Message r2 = this.$message;
        this.label = 1;
        r4 = r6.o(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
