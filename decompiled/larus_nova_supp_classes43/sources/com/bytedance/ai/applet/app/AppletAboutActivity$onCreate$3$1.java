package com.bytedance.ai.applet.app;

import android.graphics.Bitmap;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletAboutActivity$onCreate$3$1", f = "AppletAboutActivity.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
public final class AppletAboutActivity$onCreate$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $iconUrl;
    final /* synthetic */ SimpleDraweeView $this_apply;
    int label;

    public AppletAboutActivity$onCreate$3$1(String r1, SimpleDraweeView r10, Continuation<? super AppletAboutActivity$onCreate$3$1> r11) {
        this.$iconUrl = r1;
        this.$this_apply = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletAboutActivity$onCreate$3$1(this.$iconUrl, this.$this_apply, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L13:
        Bitmap r11 = (Bitmap) r10;
    L15:
        if (r11 == null) goto L17;
        this.$this_apply.setImageBitmap(r11);
    L19:
        return Unit.INSTANCE;
    L17:
        this.$this_apply.setActualImageResource(2131235790);
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r12 = AppletRuntimeManager.d;
        if (r12 == null) goto L14;
        String r13 = this.$iconUrl;
        this.label = 1;
        r10 = r12.J(r13, this);
        if (r10 != r0) goto L13;
        return r0;
    L14:
        r11 = null;
        goto L15
    }
}
