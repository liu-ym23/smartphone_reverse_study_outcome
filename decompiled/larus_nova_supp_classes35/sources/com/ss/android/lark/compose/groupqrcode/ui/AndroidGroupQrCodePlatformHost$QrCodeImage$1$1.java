package com.ss.android.lark.compose.groupqrcode.ui;

import android.graphics.Bitmap;
import androidx.compose.runtime.MutableState;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import owb.b;
import owb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.ui.AndroidGroupQrCodePlatformHost$QrCodeImage$1$1", f = "AndroidGroupQrCodePlatformHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidGroupQrCodePlatformHost$QrCodeImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Bitmap> $bitmap$delegate;
    final /* synthetic */ MutableState<Throwable> $error$delegate;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ AndroidGroupQrCodePlatformHost this$0;

    public AndroidGroupQrCodePlatformHost$QrCodeImage$1$1(AndroidGroupQrCodePlatformHost r1, String r2, MutableState<Bitmap> r3, MutableState<Throwable> r4, Continuation<? super AndroidGroupQrCodePlatformHost$QrCodeImage$1$1> r5) {
        this.this$0 = r1;
        this.$url = r2;
        this.$bitmap$delegate = r3;
        this.$error$delegate = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AndroidGroupQrCodePlatformHost$QrCodeImage$1$1(this.this$0, this.$url, this.$bitmap$delegate, this.$error$delegate, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        AndroidGroupQrCodePlatformHost r6 = this.this$0;
        String r0 = this.$url;
        r6.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        int r2 = UIHelper.dp2px(270.0f);     // Catch: Throwable -> L10
        UIHelper.dp2px(8.0f);     // Catch: Throwable -> L10
        UIHelper.dp2px(96.0f);     // Catch: Throwable -> L10
        Bitmap r7 = ((b) r6.b.getValue()).q1(r0, new c(r2, r2));     // Catch: Throwable -> L10
        if (r7 == null) goto L9;
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L10
    L12:
        MutableState<Bitmap> r3 = this.$bitmap$delegate;
        if (Result.isSuccess-impl(r8) == false) goto L15;
        r3.setValue((Bitmap) r8);
    L15:
        MutableState<Throwable> r4 = this.$error$delegate;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L19;
        int r10 = f8b.a.a;
        f8b.a.a("AndroidGroupQrCodePlatformHost generate QR code failed: " + r9.getMessage());
        r4.setValue(r9);
    L19:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("QR code generation failed: SDK returned null Bitmap");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
