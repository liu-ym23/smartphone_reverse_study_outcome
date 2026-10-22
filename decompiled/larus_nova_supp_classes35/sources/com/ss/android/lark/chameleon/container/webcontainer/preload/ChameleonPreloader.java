package com.ss.android.lark.chameleon.container.webcontainer.preload;

import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.chameleon.api.PreloadPolicy;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\r\u001a\u00020\u000e2$\u0010\u000f\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00130\u0010J\u0006\u0010\u0014\u001a\u00020\nJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/ChameleonPreloader;", BuildConfig.FLAVOR, "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;Lcom/ss/android/lark/chameleon/api/ChameleonConfig;)V", "preloadPolicy", "Lcom/ss/android/lark/chameleon/api/PreloadPolicy;", "preloadStatus", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/PreloadStatus;", "preloadStatusChangeListener", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/ChameleonPreloader$PreloadStatusChangeListener;", "executeWithStatus", BuildConfig.FLAVOR, "map", BuildConfig.FLAVOR, "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlin/Function0;", "getPreloadStatus", "getPreloadStrategy", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/IPreloaderStrategy;", "getPreloadType", ChameleonOpenTracker.Stage.PRELOAD, "setPreloadStatus", "setPreloadStatusChangeListener", "listener", "Companion", "PreloadStatusChangeListener", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonPreloader {
    public static final Companion Companion = null;
    private static final String TAG = "CML_TAG_ChameleonPreloader";
    private final ChameleonConfig chameleonConfig;
    private final PreloadPolicy preloadPolicy;
    private volatile PreloadStatus preloadStatus;
    private volatile PreloadStatusChangeListener preloadStatusChangeListener;
    private final ChameleonWebView webView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/ChameleonPreloader$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/ChameleonPreloader$PreloadStatusChangeListener;", BuildConfig.FLAVOR, "onPreloadStatusChanged", BuildConfig.FLAVOR, "preloadStatus", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/PreloadStatus;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface PreloadStatusChangeListener {
        void onPreloadStatusChanged(PreloadStatus r1);
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[PreloadPolicy.values().length];
            r0[PreloadPolicy.PRELOAD_BIZ_HTML.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PreloadPolicy.PRELOAD_EMPTY_WEBVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.preload.ChameleonPreloader$preload$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.preload.ChameleonPreloader$preload$1", f = "ChameleonPreloader.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChameleonPreloader this$0;

        public AnonymousClass1(ChameleonPreloader r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7
        L27:
            boolean r7 = ((Boolean) r6).booleanValue();     // Catch: Throwable -> L7
        L30:
            Log.i(ChameleonPreloader.TAG, "preload end. success: " + r7);
            ChameleonPreloader r2 = this.this$0;
            if (r7 == false) goto L33;
            PreloadStatus r8 = PreloadStatus.PRELOAD_SUCCESS;
        L34:
            ChameleonPreloader.access$setPreloadStatus(r2, r8);
            return Unit.INSTANCE;
        L33:
            r8 = PreloadStatus.PRELOAD_FAILED;
            goto L34
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r6);
            Log.i(ChameleonPreloader.TAG, "preload()... preloadStatus = " + ChameleonPreloader.access$getPreloadStatus$p(this.this$0) + ", policy = " + ChameleonPreloader.access$getPreloadPolicy$p(this.this$0));
            if (ChameleonPreloader.access$getPreloadStatus$p(this.this$0) != PreloadStatus.INIT) goto L14;
            IPreloaderStrategy r9 = ChameleonPreloader.access$getPreloadStrategy(this.this$0);
            if (r9 != null) goto L20;
            ChameleonPreloader.access$setPreloadStatus(this.this$0, PreloadStatus.NOT_PRELOAD);
            return Unit.INSTANCE;
        L20:
            if (ChameleonPreloader.access$getPreloadPolicy$p(this.this$0) == PreloadPolicy.PRELOAD_BIZ_HTML) goto L23;
            ChameleonPreloader.access$setPreloadStatus(this.this$0, PreloadStatus.NOT_PRELOAD);
            return Unit.INSTANCE;
        L23:
            Log.i(ChameleonPreloader.TAG, "preload start.");
            ChameleonPreloader.access$setPreloadStatus(this.this$0, PreloadStatus.PRELOADING);
            this.label = 1;     // Catch: Throwable -> L7
            r6 = r9.preload(this);     // Catch: Throwable -> L7
            if (r6 != r0) goto L27;
            return r0;
        L14:
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            Log.e(ChameleonPreloader.TAG, "preload error!", th);
            r7 = false;
            goto L30
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final synchronized PreloadStatus getPreloadStatus() {
        monitor-enter(this);
        PreloadStatus r0 = this.preloadStatus;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private final IPreloaderStrategy getPreloadStrategy() {
        PreloadPolicy r0 = this.preloadPolicy;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return null;
    L11:
        return new PreloadEmptyHtmlStrategy(this.webView);
    L9:
        return new PreloadBizHtmlStrategy(this.webView, this.chameleonConfig);
    }

    public final void preload() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final PreloadPolicy getPreloadType() {
        return this.preloadPolicy;
    }

    public static final /* synthetic */ PreloadPolicy access$getPreloadPolicy$p(ChameleonPreloader r0) {
        return r0.preloadPolicy;
    }

    public static final /* synthetic */ PreloadStatus access$getPreloadStatus$p(ChameleonPreloader r0) {
        return r0.preloadStatus;
    }

    public static final /* synthetic */ IPreloaderStrategy access$getPreloadStrategy(ChameleonPreloader r0) {
        return r0.getPreloadStrategy();
    }

    private final synchronized void setPreloadStatus(PreloadStatus r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r2 == this.preloadStatus) goto L8;
        this.preloadStatus = r2;     // Catch: Throwable -> L10
        PreloadStatusChangeListener r0 = this.preloadStatusChangeListener;     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        r0.onPreloadStatusChanged(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }

    public final synchronized void executeWithStatus(Map<Function1<PreloadStatus, Boolean>, ? extends Function0<Unit>> r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "map");     // Catch: Throwable -> L13
        Iterator<Map.Entry<Function1<PreloadStatus, Boolean>, ? extends Function0<Unit>>> r5 = r4.entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        if (r5.hasNext() == false) goto L11;
        Map.Entry<Function1<PreloadStatus, Boolean>, ? extends Function0<Unit>> r0 = r5.next();     // Catch: Throwable -> L13
        if (((Boolean) r0.getKey().invoke(this.preloadStatus)).booleanValue() == false) goto L5;
        r0.getValue().invoke();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void setPreloadStatusChangeListener(PreloadStatusChangeListener r1) {
        this.preloadStatusChangeListener = r1;
    }

    public ChameleonPreloader(ChameleonWebView r2, ChameleonConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "chameleonConfig");
        this.webView = r2;
        this.chameleonConfig = r3;
        this.preloadStatus = PreloadStatus.INIT;
        PreloadConfig r4 = r3.getPreloadConfig();
        if (r4 == null) goto L6;
        PreloadPolicy r5 = r4.getPolicy();
        if (r5 == null) goto L6;
    L7:
        this.preloadPolicy = r5;
        return;
    L6:
        r5 = PreloadPolicy.NO_PRELOAD;
        goto L7
    }

    public static final /* synthetic */ void access$setPreloadStatus(ChameleonPreloader r0, PreloadStatus r1) {
        r0.setPreloadStatus(r1);
    }
}
