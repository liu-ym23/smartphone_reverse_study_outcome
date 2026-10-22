package com.larus.e_commerce.impl.applet.panel;

import android.graphics.Bitmap;
import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.e_commerce.impl.applet.panel.ECAppletPanel$MenuViewHolder$bind$1", f = "ECAppletPanel.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
final class ECAppletPanel$MenuViewHolder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $iconUrl;
    int label;
    final /* synthetic */ ECAppletPanel.d this$0;

    public ECAppletPanel$MenuViewHolder$bind$1(String r1, ECAppletPanel.d r2, Continuation<? super ECAppletPanel$MenuViewHolder$bind$1> r3) {
        this.$iconUrl = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ECAppletPanel$MenuViewHolder$bind$1(this.$iconUrl, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L13:
        Bitmap r5 = (Bitmap) r4;
    L16:
        if (Intrinsics.areEqual(this.this$0.c.getTag(), this.$iconUrl) == false) goto L20;
        if (r5 == null) goto L20;
        this.this$0.c.setImageBitmap(r5);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r6 = AppletRuntimeManager.d;
        if (r6 == null) goto L14;
        String r2 = this.$iconUrl;
        this.label = 1;
        r4 = r6.J(r2, this);
        if (r4 != r0) goto L13;
        return r0;
    L14:
        r5 = null;
        goto L16
    }
}
