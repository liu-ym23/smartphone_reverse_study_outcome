package com.ss.android.lark.chameleon.container.webcontainer.preload;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/PreloadEmptyHtmlStrategy;", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/IPreloaderStrategy;", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;)V", ChameleonOpenTracker.Stage.PRELOAD, BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PreloadEmptyHtmlStrategy implements IPreloaderStrategy {
    private static final String ASSET_FILE_PATH = "file:///android_asset/wa_empty_template.html";
    public static final Companion Companion = null;
    private static final String TAG = "CML_TAG_PreloadEmptyHtmlStrategy";
    private final ChameleonWebView webView;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/PreloadEmptyHtmlStrategy$Companion;", BuildConfig.FLAVOR, "()V", "ASSET_FILE_PATH", BuildConfig.FLAVOR, "TAG", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadEmptyHtmlStrategy$preload$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadEmptyHtmlStrategy", f = "PreloadEmptyHtmlStrategy.kt", i = {}, l = {19}, m = ChameleonOpenTracker.Stage.PRELOAD, n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PreloadEmptyHtmlStrategy this$0;

        public AnonymousClass1(PreloadEmptyHtmlStrategy r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= PluginList.LEVEL_NOT_SET;
            return this.this$0.preload(this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadEmptyHtmlStrategy$preload$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadEmptyHtmlStrategy$preload$2", f = "PreloadEmptyHtmlStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PreloadEmptyHtmlStrategy this$0;

        public AnonymousClass2(PreloadEmptyHtmlStrategy r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            PreloadEmptyHtmlStrategy.access$getWebView$p(this.this$0).resumeTimers();
            PreloadEmptyHtmlStrategy.access$getWebView$p(this.this$0).loadUrl(PreloadEmptyHtmlStrategy.ASSET_FILE_PATH);
            PreloadEmptyHtmlStrategy.access$getWebView$p(this.this$0).setReady(true);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PreloadEmptyHtmlStrategy(ChameleonWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.webView = r2;
    }

    public static final /* synthetic */ ChameleonWebView access$getWebView$p(PreloadEmptyHtmlStrategy r0) {
        return r0.webView;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.IPreloaderStrategy
    public Object preload(Continuation<? super Boolean> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L18:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass2 r4 = new AnonymousClass2(this, null);
        r0.label = 1;
        if (BuildersKt.withContext(r8, r4, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
