package com.larus.uaigc.chat.block.create.horizontal;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.uaigc.chat.block.widget.image.LocalImageItemViewHolder;
import com.tencent.open.log.TraceLevel;
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
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.LocalCreationHorizontalGroup$reloadFailedImages$1", f = "LocalCreationHorizontalGroup.kt", i = {0}, l = {323}, m = "invokeSuspend", n = {"index"}, s = {"I$0"})
public final class LocalCreationHorizontalGroup$reloadFailedImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ LocalCreationHorizontalGroup this$0;

    public LocalCreationHorizontalGroup$reloadFailedImages$1(LocalCreationHorizontalGroup r1, Continuation<? super LocalCreationHorizontalGroup$reloadFailedImages$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LocalCreationHorizontalGroup$reloadFailedImages$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003d -> B:25:0x0073). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0070 -> B:25:0x0073). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r4 = this.I$0;
        ResultKt.throwOnFailure(r10);
        LocalCreationHorizontalGroup$reloadFailedImages$1 r11 = this;
    L25:
        r4 = r4 + 1;
    L9:
        if (r4 >= r2) goto L27;
        LocalCreationHorizontalGroup r5 = r11.this$0;
        int r6 = LocalCreationHorizontalGroup.w;
        View r7 = r5.p().getChildAt(r4);
        if (r7 == null) goto L25;
        LocalCreationHorizontalGroup r8 = r11.this$0;
        RecyclerView.ViewHolder r9 = r8.r.b.getChildViewHolder(r7);
        if ((r9 instanceof LocalImageItemViewHolder) == false) goto L15;
        LocalImageItemViewHolder r12 = (LocalImageItemViewHolder) r9;
    L16:
        if (r12 == null) goto L28;
        if (r12.r != true) goto L28;
        if (1 == 0) goto L25;
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        LocalCreationHorizontalGroup$reloadFailedImages$1$1$1 r14 = new LocalCreationHorizontalGroup$reloadFailedImages$1$1$1(r4, r8, null);
        r11.I$0 = r4;
        r11.I$1 = r2;
        r11.label = 1;
        if (BuildersKt.withContext(r13, r14, r11) != r0) goto L25;
        return r0;
    L28:
        if (0 == 0) goto L25;
        goto L25
    L15:
        r12 = null;
        goto L16
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        LocalCreationHorizontalGroup r15 = this.this$0;
        int r3 = LocalCreationHorizontalGroup.w;
        r2 = r15.p().getChildCount();
        r4 = 0;
        r11 = this;
        goto L9
    }
}
