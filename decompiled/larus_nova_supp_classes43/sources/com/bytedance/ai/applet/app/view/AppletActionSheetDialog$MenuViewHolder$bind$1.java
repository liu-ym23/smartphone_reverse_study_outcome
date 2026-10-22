package com.bytedance.ai.applet.app.view;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.view.AppletActionSheetDialog$MenuViewHolder$bind$1", f = "AppletActionSheetDialog.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
final class AppletActionSheetDialog$MenuViewHolder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ AppletActionSheetDialog.e this$0;

    public AppletActionSheetDialog$MenuViewHolder$bind$1(String r1, AppletActionSheetDialog.e r10, Continuation<? super AppletActionSheetDialog$MenuViewHolder$bind$1> r11) {
        this.$url = r1;
        this.this$0 = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletActionSheetDialog$MenuViewHolder$bind$1(this.$url, this.this$0, r11);
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
    L16:
        if (Intrinsics.areEqual(this.this$0.b.getTag(), this.$url) == false) goto L20;
        if (r11 == null) goto L20;
        this.this$0.b.setImageBitmap(r11);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r12 = AppletRuntimeManager.d;
        if (r12 == null) goto L14;
        String r13 = this.$url;
        this.label = 1;
        r10 = r12.J(r13, this);
        if (r10 != r0) goto L13;
        return r0;
    L14:
        r11 = null;
        goto L16
    }
}
