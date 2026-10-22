package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.blockview.LocalMediaViewHolder$saveMedia$1", f = "TaskLocalMediaPreviewView.kt", i = {}, l = {669}, m = "invokeSuspend", n = {}, s = {})
final class LocalMediaViewHolder$saveMedia$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ifa.c $item;
    int label;
    final /* synthetic */ j this$0;

    public LocalMediaViewHolder$saveMedia$1(j r1, ifa.c r2, Continuation<? super LocalMediaViewHolder$saveMedia$1> r3) {
        this.this$0 = r1;
        this.$item = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalMediaViewHolder$saveMedia$1(this.this$0, this.$item, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        Boolean r8 = (Boolean) r7;
        if (r8 == null) goto L14;
        Context r2 = this.this$0.a.getApplicationContext();
        if (Intrinsics.areEqual(r8, Boxing.boxBoolean(true)) == false) goto L18;
        String r9 = "已保存到相册";
    L19:
        Toast.makeText(r2, r9, 0).show();
        return Unit.INSTANCE;
    L18:
        r9 = "保存失败";
        goto L19
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r10 = Dispatchers.getIO();
        LocalMediaViewHolder$saveMedia$1$saved$1 r3 = new LocalMediaViewHolder$saveMedia$1$saved$1(this.this$0, this.$item, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r10, r3, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
