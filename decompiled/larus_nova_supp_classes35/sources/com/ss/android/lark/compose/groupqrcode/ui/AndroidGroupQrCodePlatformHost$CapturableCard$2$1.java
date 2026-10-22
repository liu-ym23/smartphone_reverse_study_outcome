package com.ss.android.lark.compose.groupqrcode.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.platform.ComposeView;
import com.larksuite.framework.utils.UIUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.ui.AndroidGroupQrCodePlatformHost$CapturableCard$2$1", f = "AndroidGroupQrCodePlatformHost.kt", i = {0}, l = {128}, m = "invokeSuspend", n = {"view"}, s = {"L$0"})
public final class AndroidGroupQrCodePlatformHost$CapturableCard$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<ComposeView> $cardView$delegate;
    final /* synthetic */ boolean $ready;
    Object L$0;
    int label;
    final /* synthetic */ AndroidGroupQrCodePlatformHost this$0;

    public AndroidGroupQrCodePlatformHost$CapturableCard$2$1(boolean r1, AndroidGroupQrCodePlatformHost r2, MutableState<ComposeView> r3, Continuation<? super AndroidGroupQrCodePlatformHost$CapturableCard$2$1> r4) {
        this.$ready = r1;
        this.this$0 = r2;
        this.$cardView$delegate = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AndroidGroupQrCodePlatformHost$CapturableCard$2$1(this.$ready, this.this$0, this.$cardView$delegate, r5);
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
        final ComposeView r2 = (ComposeView) this.L$0;
        ResultKt.throwOnFailure(r4);
    L20:
        final AndroidGroupQrCodePlatformHost r5 = this.this$0;
        r5.getClass();
        if (r2.getWidth() > 0) goto L23;
    L29:
        f8b.a.a("AndroidGroupQrCodePlatformHost card view size is 0");
    L31:
        return Unit.INSTANCE;
    L23:
        if (r2.getHeight() <= 0) goto L29;
        UIUtils.getScreenViewShot(r2, r5.a.getWindow(), new AndroidGroupQrCodePlatformHost$captureCardBitmap$1(r5, r2));     // Catch: Exception -> L27
    L27:
        e = move-exception;
        int r3 = f8b.a.a;
        f8b.a.a("AndroidGroupQrCodePlatformHost capture card failed: " + e);
        goto L31
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ComposeView r6 = (ComposeView) this.$cardView$delegate.getValue();
        if (r6 != null) goto L13;
        return Unit.INSTANCE;
    L13:
        if (this.$ready == false) goto L15;
        this.L$0 = r6;
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L19;
        return r0;
    L19:
        r2 = r6;
        goto L20
    L15:
        return Unit.INSTANCE;
    }
}
