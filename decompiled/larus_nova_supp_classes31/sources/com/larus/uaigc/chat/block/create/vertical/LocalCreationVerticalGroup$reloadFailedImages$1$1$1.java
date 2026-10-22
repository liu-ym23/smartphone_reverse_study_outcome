package com.larus.uaigc.chat.block.create.vertical;

import com.larus.uaigc.chat.block.widget.image.LocalImageItemViewHolder;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.vertical.LocalCreationVerticalGroup$reloadFailedImages$1$1$1", f = "LocalCreationVerticalGroup.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalCreationVerticalGroup$reloadFailedImages$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalImageItemViewHolder $imageItemBinder;
    final /* synthetic */ cz9.g $it;
    int label;

    public LocalCreationVerticalGroup$reloadFailedImages$1$1$1(cz9.g r1, LocalImageItemViewHolder r2, Continuation<? super LocalCreationVerticalGroup$reloadFailedImages$1$1$1> r3) {
        this.$it = r1;
        this.$imageItemBinder = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalCreationVerticalGroup$reloadFailedImages$1$1$1(this.$it, this.$imageItemBinder, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        cz9.g r5 = this.$it;
        cz9.m r0 = ((LocalImageItemViewHolder) r5).q;
        if (r0 == null) goto L12;
        this.$imageItemBinder.p2(r0);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("reloadFailedImage, index: ");
        cz9.m r6 = ((LocalImageItemViewHolder) r5).q;
        if (r6 == null) goto L9;
        Integer r7 = Boxing.boxInt(r6.f);
    L10:
        r2.append(r7);
        r1.i("LocalCreationVerticalGroup", r2.toString());
        goto L12
    L9:
        r7 = null;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
