package com.larus.chat.gallery.impl.preview.provider;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.provider.LocalPreviewBottomController$save$4", f = "LocalPreviewBottomController.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
final class LocalPreviewBottomController$save$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ xy8.d $data;
    int label;
    final /* synthetic */ c this$0;

    public LocalPreviewBottomController$save$4(c r1, Context r2, xy8.d r3, Continuation<? super LocalPreviewBottomController$save$4> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LocalPreviewBottomController$save$4(this.this$0, this.$context, this.$data, r5);
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
        boolean r8 = ((Boolean) r7).booleanValue();
        com.larus.chat.gallery.providers.input.h0 r2 = this.this$0.a.o;
        if (r2 == null) goto L14;
        r2.g = false;
        r2.a();
    L14:
        if (r8 == false) goto L16;
        t19.s r9 = t19.s.a;
        Context r3 = this.$context;
        r9.getClass();
        t19.s.o(r3, 2131908983, false);
    L18:
        return Unit.INSTANCE;
    L16:
        t19.s r10 = t19.s.a;
        Context r4 = this.$context;
        r10.getClass();
        t19.s.s(r4, 2131908982);
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        LocalPreviewBottomController$save$4$saved$1 r5 = new LocalPreviewBottomController$save$4$saved$1(this.$context, this.$data, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r11, r5, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
