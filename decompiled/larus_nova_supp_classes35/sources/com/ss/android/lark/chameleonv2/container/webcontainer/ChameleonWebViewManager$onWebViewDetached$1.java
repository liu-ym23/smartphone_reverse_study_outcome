package com.ss.android.lark.chameleonv2.container.webcontainer;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadStatus;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager$onWebViewDetached$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChameleonWebViewManager$onWebViewDetached$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonConfig $chameleonConfig;
    final /* synthetic */ Object $tag;
    final /* synthetic */ ChameleonWebView $webView;
    int label;
    final /* synthetic */ ChameleonWebViewManager this$0;

    public ChameleonWebViewManager$onWebViewDetached$1(ChameleonWebViewManager r1, Object r2, ChameleonConfig r3, ChameleonWebView r4, Continuation<? super ChameleonWebViewManager$onWebViewDetached$1> r5) {
        this.this$0 = r1;
        this.$tag = r2;
        this.$chameleonConfig = r3;
        this.$webView = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChameleonWebViewManager$onWebViewDetached$1(this.this$0, this.$tag, this.$chameleonConfig, this.$webView, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r4);
        com.ss.android.lark.officesdk.utils.di.j.e(this.this$0.a, "onWebViewDetached()... tag = " + this.$tag + ", bizName = " + this.$chameleonConfig.getBizName() + ", webView " + this.$webView.hashCode());
        q0b.a r5 = this.this$0.b.get(ChameleonWebViewManager.e(this.$chameleonConfig));
        if (r5 == null) goto L13;
        r5.detachWebView(this.$tag);
        if (this.$webView.getPreloader().c() != PreloadStatus.PRELOAD_FAILED) goto L9;
        r5.e(this.$webView);
    L9:
        ChameleonWebViewManager r6 = this.this$0;
        ChameleonConfig r0 = this.$chameleonConfig;
        r6.getClass();
        String r7 = ChameleonWebViewManager.e(r0);
        Runnable r1 = this.this$0.e.get(r7);
        Runnable r2 = r1;
        if (r1 != null) goto L12;
        ChameleonWebViewManager.a r3 = this.this$0.f;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.a = r7;
        this.this$0.e.put(r7, r3);
        r2 = r3;
    L12:
        Lazy r8 = ThreadUtil.a;
        ThreadUtil.a.e(r2);
        ThreadUtil.a.d(r2, OpenConfig.DEFAULT_LOADING_TIMEOUT);
    L25:
        return Unit.INSTANCE;
    L13:
        PreloadConfig r9 = this.$chameleonConfig.getPreloadConfig();
        if (r9 == null) goto L17;
        PreloadPolicy r10 = r9.getPolicy();
        if (r10 == null) goto L17;
    L19:
        if (r10 != PreloadPolicy.NO_PRELOAD) goto L25;
        vv4.n r11 = this.$webView.getWebServiceManager();
        if (r11 == null) goto L23;
        r11.c();
    L23:
        this.$webView.clearHistory();
        this.$webView.destroy();
    L17:
        r10 = PreloadPolicy.NO_PRELOAD;
        goto L19
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
