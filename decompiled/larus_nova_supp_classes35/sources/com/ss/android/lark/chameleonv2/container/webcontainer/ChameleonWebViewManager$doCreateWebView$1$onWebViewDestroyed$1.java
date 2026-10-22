package com.ss.android.lark.chameleonv2.container.webcontainer;

import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonWebView $webView;
    int label;

    public ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1(ChameleonWebView r1, Continuation<? super ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1> r2) {
        this.$webView = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1(this.$webView, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r2);
        ChameleonWebView r3 = this.$webView;
        if (r3 == null) goto L9;
        vv4.n r4 = r3.getWebServiceManager();
        if (r4 == null) goto L9;
        r4.c();
    L9:
        zv4.c r5 = this.$webView;
        if (r5 == null) goto L12;
        r5.clearHistory();
    L12:
        ChameleonWebView r6 = this.$webView;
        if (r6 == null) goto L16;
        r6.destroy();
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
