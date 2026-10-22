package com.ss.android.lark.compose.groupqrcode.ui;

import androidx.compose.runtime.MutableState;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.ui.AndroidGroupQrCodePlatformHost$QrCodeImage$3$1", f = "AndroidGroupQrCodePlatformHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidGroupQrCodePlatformHost$QrCodeImage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Throwable> $error$delegate;
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidGroupQrCodePlatformHost$QrCodeImage$3$1(Function1<? super Throwable, Unit> r1, MutableState<Throwable> r2, Continuation<? super AndroidGroupQrCodePlatformHost$QrCodeImage$3$1> r3) {
        this.$onError = r1;
        this.$error$delegate = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AndroidGroupQrCodePlatformHost$QrCodeImage$3$1(this.$onError, this.$error$delegate, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        Throwable r3 = (Throwable) this.$error$delegate.getValue();
        if (r3 == null) goto L8;
        this.$onError.invoke(r3);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
