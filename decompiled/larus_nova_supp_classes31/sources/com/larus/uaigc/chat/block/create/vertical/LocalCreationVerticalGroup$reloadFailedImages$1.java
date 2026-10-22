package com.larus.uaigc.chat.block.create.vertical;

import com.larus.uaigc.chat.block.widget.image.LocalImageItemViewHolder;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.vertical.LocalCreationVerticalGroup$reloadFailedImages$1", f = "LocalCreationVerticalGroup.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
public final class LocalCreationVerticalGroup$reloadFailedImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ LocalCreationVerticalGroup this$0;

    public LocalCreationVerticalGroup$reloadFailedImages$1(LocalCreationVerticalGroup r1, Continuation<? super LocalCreationVerticalGroup$reloadFailedImages$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LocalCreationVerticalGroup$reloadFailedImages$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r9);
    L11:
        if (r2.hasNext() == false) goto L26;
        cz9.g r3 = (cz9.g) r2.next();
        if ((r3 instanceof LocalImageItemViewHolder) == false) goto L15;
        LocalImageItemViewHolder r4 = (LocalImageItemViewHolder) r3;
    L16:
        boolean r6 = false;
        if (r4 != null) goto L19;
    L21:
        if (r6 == false) goto L11;
        MainCoroutineDispatcher r7 = Dispatchers.getMain();
        LocalCreationVerticalGroup$reloadFailedImages$1$1$1 r8 = new LocalCreationVerticalGroup$reloadFailedImages$1$1$1(r3, r4, null);
        this.L$0 = r2;
        this.label = 1;
        if (BuildersKt.withContext(r7, r8, this) != r0) goto L11;
        return r0;
    L19:
        if (r4.r != true) goto L21;
        r6 = true;
        goto L21
    L15:
        r4 = null;
        goto L16
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r2 = new HashMap(this.this$0.t).values().iterator();
        goto L11
    }
}
