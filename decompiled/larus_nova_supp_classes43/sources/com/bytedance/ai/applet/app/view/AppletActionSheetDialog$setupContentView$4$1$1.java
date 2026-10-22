package com.bytedance.ai.applet.app.view;

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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.view.AppletActionSheetDialog$setupContentView$4$1$1", f = "AppletActionSheetDialog.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
public final class AppletActionSheetDialog$setupContentView$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletActionSheetDialog.b $h;
    final /* synthetic */ SimpleDraweeView $iconView;
    final /* synthetic */ String $url;
    int label;

    public AppletActionSheetDialog$setupContentView$4$1$1(String r1, SimpleDraweeView r10, AppletActionSheetDialog.b r11, Continuation<? super AppletActionSheetDialog$setupContentView$4$1$1> r12) {
        this.$url = r1;
        this.$iconView = r10;
        this.$h = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletActionSheetDialog$setupContentView$4$1$1(this.$url, this.$iconView, this.$h, r11);
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
        if (Intrinsics.areEqual(this.$iconView.getTag(), this.$url) == false) goto L24;
        if (r11 == null) goto L19;
        this.$iconView.setImageBitmap(r11);
        goto L24
    L19:
        Integer r12 = this.$h.a;
        if (r12 == null) goto L22;
        this.$iconView.setActualImageResource(r12.intValue());
        goto L24
    L22:
        this.$iconView.setVisibility(8);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r13 = AppletRuntimeManager.d;
        if (r13 == null) goto L14;
        String r14 = this.$url;
        this.label = 1;
        r10 = r13.J(r14, this);
        if (r10 != r0) goto L13;
        return r0;
    L14:
        r11 = null;
        goto L16
    }
}
