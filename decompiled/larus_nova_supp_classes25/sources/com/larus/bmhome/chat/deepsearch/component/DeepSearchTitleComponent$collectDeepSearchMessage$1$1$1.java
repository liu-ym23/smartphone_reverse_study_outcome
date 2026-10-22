package com.larus.bmhome.chat.deepsearch.component;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mainbot.impl.databinding.LarusPageDeepSearchBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.component.DeepSearchTitleComponent$collectDeepSearchMessage$1$1$1", f = "DeepSearchTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DeepSearchTitleComponent$collectDeepSearchMessage$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeepSearchTitleComponent this$0;

    public DeepSearchTitleComponent$collectDeepSearchMessage$1$1$1(DeepSearchTitleComponent r1, Continuation<? super DeepSearchTitleComponent$collectDeepSearchMessage$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DeepSearchTitleComponent$collectDeepSearchMessage$1$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r4);
        DeepSearchTitleComponent r5 = this.this$0;
        int r0 = DeepSearchTitleComponent.r;
        LarusPageDeepSearchBinding r6 = r5.h3();
        Context r1 = null;
        if (r6 == null) goto L17;
        AppCompatImageView r7 = r6.c;
        if (r7 == null) goto L18;
        LarusPageDeepSearchBinding r2 = this.this$0.h3();
        if (r2 == null) goto L13;
        AppCompatImageView r3 = r2.c;
        if (r3 == null) goto L13;
        r1 = r3.getContext();
    L13:
        r7.setImageResource(v19.c.b(2130971977, r1, 2131242682));
        return Unit.INSTANCE;
    L18:
        return null;
    L17:
        return null;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
