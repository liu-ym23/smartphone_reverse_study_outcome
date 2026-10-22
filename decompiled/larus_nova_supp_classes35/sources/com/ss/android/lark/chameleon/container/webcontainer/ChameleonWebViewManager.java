package com.ss.android.lark.chameleon.container.webcontainer;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.chameleon.api.PreloadPolicy;
import com.ss.android.lark.chameleon.api.WebViewPoolConfig;
import com.ss.android.lark.chameleon.api.WebviewConfig;
import com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadStatus;
import com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool;
import com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.WebViewPool;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\r\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\nj\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/ChameleonWebViewManager;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "TAG", BuildConfig.FLAVOR, "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "webViewDestroyJob", "Ljava/util/HashMap;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/HashMap;", "webViewPools", "Lkotlin/Pair;", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/webviewpool/IWebViewPool;", "Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;", "doCreateWebView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "getWebView", "tag", BuildConfig.FLAVOR, "onWebViewDetached", "webView", ChameleonOpenTracker.Stage.PRELOAD, "shrinkWebPoolSize", BuildConfig.FLAVOR, "webViewPool", "poolConfig", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonWebViewManager implements CoroutineScope {
    public static final ChameleonWebViewManager INSTANCE = null;
    private static final String TAG = "CML_TAG_WebViewManager";
    private static final CoroutineContext coroutineContext = null;
    private static final HashMap<String, Job> webViewDestroyJob = null;
    private static final HashMap<String, Pair<IWebViewPool, WebViewPoolConfig>> webViewPools = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.ChameleonWebViewManager$onWebViewDetached$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.ChameleonWebViewManager$onWebViewDetached$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChameleonConfig $chameleonConfig;
        final /* synthetic */ Object $tag;
        final /* synthetic */ ChameleonWebView $webView;
        int label;

        public C03271(Object r1, ChameleonConfig r2, ChameleonWebView r3, Continuation<? super C03271> r4) {
            this.$tag = r1;
            this.$chameleonConfig = r2;
            this.$webView = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03271(this.$tag, this.$chameleonConfig, this.$webView, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L37;
            ResultKt.throwOnFailure(r10);
            Log.i(ChameleonWebViewManager.TAG, "onWebViewDetached()... tag = " + this.$tag + ", bizName = " + this.$chameleonConfig.getBizName());
            HashMap r11 = ChameleonWebViewManager.access$getWebViewPools$p();
            String r0 = this.$chameleonConfig.getBizName();
            String r1 = BuildConfig.FLAVOR;
            if (r0 != null) goto L7;
            r0 = BuildConfig.FLAVOR;
        L7:
            Pair r12 = (Pair) r11.get(r0);
            WebViewPoolConfig r2 = null;
            if (r12 == null) goto L10;
            IWebViewPool r13 = (IWebViewPool) r12.getFirst();
        L11:
            HashMap r3 = ChameleonWebViewManager.access$getWebViewPools$p();
            String r4 = this.$chameleonConfig.getBizName();
            if (r4 == null) goto L15;
            r1 = r4;
        L15:
            Pair r5 = (Pair) r3.get(r1);
            if (r5 == null) goto L18;
            r2 = (WebViewPoolConfig) r5.getSecond();
        L18:
            if (r13 == null) goto L26;
            r13.detachWebView(this.$tag);
            if (this.$webView.getPreloader().getPreloadStatus() != PreloadStatus.PRELOAD_FAILED) goto L22;
            r13.destroyWebView(this.$webView);
        L22:
            ChameleonWebViewManager r6 = ChameleonWebViewManager.INSTANCE;
            if (r2 != null) goto L25;
            r2 = new WebViewPoolConfig(0, 0, 0, 0, 15, null);
        L25:
            ChameleonWebViewManager.access$shrinkWebPoolSize(r6, r13, r2);
        L35:
            return Unit.INSTANCE;
        L26:
            PreloadConfig r14 = this.$chameleonConfig.getPreloadConfig();
            if (r14 == null) goto L30;
            PreloadPolicy r15 = r14.getPolicy();
            if (r15 == null) goto L30;
        L32:
            if (r15 != PreloadPolicy.NO_PRELOAD) goto L35;
            this.$webView.destroy();
        L30:
            r15 = PreloadPolicy.NO_PRELOAD;
            goto L32
        L10:
            r13 = null;
            goto L11
        L37:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.ChameleonWebViewManager$preload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.ChameleonWebViewManager$preload$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChameleonConfig $chameleonConfig;
        int label;

        public C03281(ChameleonConfig r1, Continuation<? super C03281> r2) {
            this.$chameleonConfig = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03281(this.$chameleonConfig, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r4);
            StringBuilder r5 = new StringBuilder("preload()... bizName = ");
            r5.append(this.$chameleonConfig.getBizName());
            r5.append(", already preload: ");
            HashMap r0 = ChameleonWebViewManager.access$getWebViewPools$p();
            String r1 = this.$chameleonConfig.getBizName();
            String r2 = BuildConfig.FLAVOR;
            if (r1 != null) goto L7;
            r1 = BuildConfig.FLAVOR;
        L7:
            r5.append(r0.containsKey(r1));
            Log.i(ChameleonWebViewManager.TAG, r5.toString());
            HashMap r6 = ChameleonWebViewManager.access$getWebViewPools$p();
            String r3 = this.$chameleonConfig.getBizName();
            if (r3 == null) goto L12;
            r2 = r3;
        L12:
            if (((Pair) r6.get(r2)) != null) goto L14;
            ChameleonWebViewManager.access$doCreateWebView(ChameleonWebViewManager.INSTANCE, this.$chameleonConfig);
            return Unit.INSTANCE;
        L14:
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private ChameleonWebViewManager() {
    }

    static {
        INSTANCE = new ChameleonWebViewManager();
        webViewPools = new HashMap();
        webViewDestroyJob = new HashMap();
        coroutineContext = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate());
    }

    public static final /* synthetic */ HashMap access$getWebViewPools$p() {
        return webViewPools;
    }

    public CoroutineContext getCoroutineContext() {
        return coroutineContext;
    }

    private final ChameleonWebView doCreateWebView(ChameleonConfig r10) {
        final WebViewPool r0 = new WebViewPool();
        WebviewConfig r1 = r10.getWebviewConfig();
        if (r1 == null) goto L6;
        WebViewPoolConfig r2 = r1.getWebViewPoolConfig();
        if (r2 == null) goto L6;
    L7:
        HashMap<String, Pair<IWebViewPool, WebViewPoolConfig>> r3 = webViewPools;
        String r4 = r10.getBizName();
        if (r4 != null) goto L10;
        r4 = BuildConfig.FLAVOR;
    L10:
        r3.put(r4, new Pair(r0, r2));
        r0.setWebViewLifeCycleListener(new AnonymousClass1(r0));
        ChameleonWebView r11 = r0.createWebView(r10);
        r11.preload();
        return r11;
    L6:
        r2 = new WebViewPoolConfig(0, 0, 0, 0, 15, null);
        goto L7
    }

    public final Job preload(ChameleonConfig r8) {
        Intrinsics.checkNotNullParameter(r8, "chameleonConfig");
        return BuildersKt.launch$default(this, null, null, new C03281(r8, null), 3, null);
    }

    public static final /* synthetic */ ChameleonWebView access$doCreateWebView(ChameleonWebViewManager r0, ChameleonConfig r1) {
        return r0.doCreateWebView(r1);
    }

    private final void shrinkWebPoolSize(IWebViewPool r5, WebViewPoolConfig r6) {
        Log.i(TAG, "shrinkWebPoolSize()... occupiedSize = " + r5.occupiedSize() + ", poolSize = " + r5.poolSize() + ", poolConfig = " + r6);
    L4:
        if ((r5.occupiedSize() + 1) >= r5.poolSize()) goto L9;
        if (r5.poolSize() <= r6.getCoreSize()) goto L9;
        Log.i(TAG, "shrinkWebPoolSize == ");
        r5.destroyWebView(r5.provideWebView(null, true));
    L9:
        if (r5.occupiedSize() == 0) goto L11;
        return;
    L11:
        if (r5.poolSize() != r6.getCoreSize()) goto L19;
        ChameleonWebView r7 = r5.getOverMaxUsedWebView(r6.getMaxUseCount());
        if (r7 == null) goto L20;
        Log.i(TAG, "release over-max-used WebView and create new WebView");
        r5.destroyWebView(r7);
        return;
    L20:
        return;
    }

    public final ChameleonWebView getWebView(ChameleonConfig r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r9, "tag");
        Log.i(TAG, "getWebView()... bizName = " + r8.getBizName() + ",  tag = " + r9);
        HashMap<String, Pair<IWebViewPool, WebViewPoolConfig>> r0 = webViewPools;
        String r2 = r8.getBizName();
        String r3 = BuildConfig.FLAVOR;
        if (r2 != null) goto L5;
        r2 = BuildConfig.FLAVOR;
    L5:
        Pair<IWebViewPool, WebViewPoolConfig> r4 = r0.get(r2);
        PreloadPolicy r5 = null;
        ViewGroup r6 = null;
        if (r4 == null) goto L8;
        IWebViewPool r7 = (IWebViewPool) r4.getFirst();
    L9:
        String r10 = r8.getBizName();
        if (r10 == null) goto L13;
        r3 = r10;
    L13:
        Pair<IWebViewPool, WebViewPoolConfig> r1 = r0.get(r3);
        if (r1 == null) goto L16;
        WebViewPoolConfig r11 = (WebViewPoolConfig) r1.getSecond();
    L18:
        if (r7 == null) goto L45;
        Log.i(TAG, "provideWebView occupiedSize = " + r7.occupiedSize() + ", poolSize = " + r7.poolSize() + ", poolConfig = " + r11);
        ChameleonWebView r12 = r7.getCurWebView(r9, true);
        if (r12 == null) goto L28;
        r12.setChameleonConfig(r8);
        OpenConfig r13 = r8.getOpenConfig();
        if (r13 == null) goto L25;
        r13.setHitWebViewCache(true);
    L25:
        Log.i(TAG, "provideWebView()1... tag = " + r9 + "webview = " + r12.hashCode());
        return r12;
    L28:
        if (r7.occupiedSize() != r7.poolSize()) goto L34;
        OpenConfig r14 = r8.getOpenConfig();
        if (r14 == null) goto L33;
        r14.setHitWebViewCache(false);
    L33:
        r7.createWebView(r8).preload();
    L34:
        ChameleonWebView r15 = r7.provideWebView(r9, true);
        if (r15 == null) goto L37;
        ViewParent r16 = r15.getParent();
    L39:
        if ((r16 instanceof ViewGroup) == false) goto L41;
        r6 = (ViewGroup) r16;
    L41:
        if (r6 == null) goto L43;
        r6.removeView(r15);
    L43:
        Log.i(TAG, "provideWebView()2... tag = " + r9 + " webview = " + r15.hashCode());
        return r15;
    L37:
        r16 = null;
        goto L39
    L45:
        StringBuilder r17 = new StringBuilder("cachedWebViewPool is null, ... bizName = ");
        r17.append(r8.getBizName());
        r17.append(",  preloadPolicy = ");
        PreloadConfig r18 = r8.getPreloadConfig();
        if (r18 == null) goto L48;
        r5 = r18.getPolicy();
    L48:
        r17.append(r5);
        Log.i(TAG, r17.toString());
        OpenConfig r19 = r8.getOpenConfig();
        if (r19 == null) goto L52;
        r19.setHitWebViewCache(false);
    L52:
        PreloadConfig r20 = r8.getPreloadConfig();
        if (r20 == null) goto L56;
        PreloadPolicy r21 = r20.getPolicy();
        if (r21 == null) goto L56;
    L58:
        if (r21 != PreloadPolicy.NO_PRELOAD) goto L61;
        return new ChameleonWebView(Env.getApplication(), r8);
    L61:
        return doCreateWebView(r8);
    L56:
        r21 = PreloadPolicy.NO_PRELOAD;
        goto L58
    L16:
        r11 = null;
        goto L18
    L8:
        r7 = null;
        goto L9
    }

    public static final /* synthetic */ void access$shrinkWebPoolSize(ChameleonWebViewManager r0, IWebViewPool r1, WebViewPoolConfig r2) {
        r0.shrinkWebPoolSize(r1, r2);
    }

    public final Job onWebViewDetached(ChameleonConfig r8, ChameleonWebView r9, Object r10) {
        Intrinsics.checkNotNullParameter(r8, "chameleonConfig");
        Intrinsics.checkNotNullParameter(r9, "webView");
        Intrinsics.checkNotNullParameter(r10, "tag");
        return BuildersKt.launch$default(this, null, null, new C03271(r10, r8, r9, null), 3, null);
    }
}
