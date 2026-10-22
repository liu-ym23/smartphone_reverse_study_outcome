package com.obric.assistant.omnidetailpage.localmedia;

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
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.localmedia.LocalMediaBottomProvider$saveCurrent$1", f = "LocalMediaBottomProvider.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
final class LocalMediaBottomProvider$saveCurrent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ ifa.c $item;
    int label;
    final /* synthetic */ b this$0;

    public LocalMediaBottomProvider$saveCurrent$1(b r1, Context r2, ifa.c r3, Continuation<? super LocalMediaBottomProvider$saveCurrent$1> r4) {
        this.this$0 = r1;
        this.$ctx = r2;
        this.$item = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LocalMediaBottomProvider$saveCurrent$1(this.this$0, this.$ctx, this.$item, r5);
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
        b r2 = this.this$0;
        r2.g = false;
        r2.y();
        if (r8 == null) goto L14;
        Context r3 = this.$ctx.getApplicationContext();
        if (Intrinsics.areEqual(r8, Boxing.boxBoolean(true)) == false) goto L18;
        String r9 = "已保存到相册";
    L19:
        Toast.makeText(r3, r9, 0).show();
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
        LocalMediaBottomProvider$saveCurrent$1$saved$1 r4 = new LocalMediaBottomProvider$saveCurrent$1$saved$1(this.$ctx, this.$item, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r10, r4, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
