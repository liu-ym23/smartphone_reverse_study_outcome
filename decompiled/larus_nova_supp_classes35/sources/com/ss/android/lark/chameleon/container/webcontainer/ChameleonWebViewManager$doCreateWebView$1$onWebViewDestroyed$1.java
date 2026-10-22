package com.ss.android.lark.chameleon.container.webcontainer;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.pluginsystem.WebServiceManager;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r3);
        ChameleonWebView r4 = this.$webView;
        ViewGroup r0 = null;
        if (r4 == null) goto L7;
        ViewParent r5 = r4.getParent();
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L11;
        r0 = (ViewGroup) r5;
    L11:
        if (r0 == null) goto L13;
        r0.removeView(this.$webView);
    L13:
        ChameleonWebView r6 = this.$webView;
        if (r6 == null) goto L18;
        WebServiceManager r7 = r6.getWebServiceManager();
        if (r7 == null) goto L18;
        r7.onDestroy();
    L18:
        ChameleonWebView r8 = this.$webView;
        if (r8 == null) goto L21;
        r8.clearHistory();
    L21:
        ChameleonWebView r9 = this.$webView;
        if (r9 == null) goto L25;
        r9.destroy();
    L25:
        return Unit.INSTANCE;
    L7:
        r5 = null;
        goto L9
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
