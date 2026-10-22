package com.ss.android.lark.chameleon.container.webcontainer.plugin.core;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.MainLooper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J$\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/UIThreadCallbackAdapter;", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;", "()V", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addLoadCallback", BuildConfig.FLAVOR, "cb", "onLoadFail", "code", BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "e", BuildConfig.FLAVOR, "onLoadStart", "onLoadSuccess", "onPageStarted", "url", "onReceivedTitle", "view", "Landroid/webkit/WebView;", "title", "onRenderProcessGone", "release", "removeLoadCallback", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UIThreadCallbackAdapter implements IChameleonLoader.LoadingCallback {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_UIThreadCallbackAdapter";
    private final CopyOnWriteArrayList<IChameleonLoader.LoadingCallback> callbacks;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/UIThreadCallbackAdapter$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(UIThreadCallbackAdapter r0, WebView r1, String r2) {
        onReceivedTitle$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ void b(int r0, Throwable r1, UIThreadCallbackAdapter r2, String r3) {
        onLoadFail$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void c(UIThreadCallbackAdapter r0) {
        onLoadSuccess$lambda$2(r0);
    }

    public static /* synthetic */ void d(UIThreadCallbackAdapter r0) {
        onLoadStart$lambda$0(r0);
    }

    public static /* synthetic */ void e(UIThreadCallbackAdapter r0) {
        onRenderProcessGone$lambda$5(r0);
    }

    public static /* synthetic */ void f(UIThreadCallbackAdapter r0, String r1) {
        onPageStarted$lambda$1(r0, r1);
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onLoadStart() {
        Log.i(TAG, "onLoadStart");
        MainLooper.post(new f(this));
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onLoadSuccess() {
        Log.i(TAG, "onLoadSuccess");
        MainLooper.post(new c(this));
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onRenderProcessGone() {
        Log.i(TAG, "onRenderProcessGone");
        MainLooper.post(new b(this));
    }

    public final void release() {
        this.callbacks.clear();
    }

    public UIThreadCallbackAdapter() {
        this.callbacks = new CopyOnWriteArrayList();
    }

    private static final void onLoadStart$lambda$0(UIThreadCallbackAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Log.i(TAG, "onLoadStart execute");
        Iterator<IChameleonLoader.LoadingCallback> r3 = r2.callbacks.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().onLoadStart();
        goto L4
    }

    private static final void onLoadSuccess$lambda$2(UIThreadCallbackAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Log.i(TAG, "onLoadSuccess execute");
        Iterator<IChameleonLoader.LoadingCallback> r3 = r2.callbacks.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().onLoadSuccess();
        goto L4
    }

    private static final void onRenderProcessGone$lambda$5(UIThreadCallbackAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Log.i(TAG, "onRenderProcessGone execute");
        Iterator<IChameleonLoader.LoadingCallback> r3 = r2.callbacks.iterator();     // Catch: Throwable -> L8
    L5:
        if (r3.hasNext() == false) goto L15;
        r3.next().onRenderProcessGone();     // Catch: Throwable -> L8
        goto L5
    L15:
        return;
    L8:
        th = move-exception;
        Log.e(TAG, th.toString());
    }

    public final void addLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.callbacks.add(r2);
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onPageStarted(final String r3) {
        Log.i(TAG, "onPageStart");
        MainLooper.post(new a(this, r3));
    }

    public final void removeLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.callbacks.remove(r2);
    }

    private static final void onPageStarted$lambda$1(UIThreadCallbackAdapter r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Log.i(TAG, "onPageStart execute");
        Iterator<IChameleonLoader.LoadingCallback> r4 = r2.callbacks.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().onPageStarted(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onReceivedTitle(final WebView r3, final String r4) {
        Log.i(TAG, "onReceivedTitle");
        MainLooper.post(new d(this, r3, r4));
    }

    private static final void onReceivedTitle$lambda$4(UIThreadCallbackAdapter r2, WebView r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Log.i(TAG, "onReceivedTitle execute");
        Iterator<IChameleonLoader.LoadingCallback> r5 = r2.callbacks.iterator();     // Catch: Throwable -> L8
    L5:
        if (r5.hasNext() == false) goto L15;
        r5.next().onReceivedTitle(r3, r4);     // Catch: Throwable -> L8
        goto L5
    L15:
        return;
    L8:
        th = move-exception;
        Log.e(TAG, th.toString());
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onLoadFail(final int r3, final String r4, final Throwable r5) {
        Log.i(TAG, "onLoadFail code=" + r3 + ", e=" + r5);
        MainLooper.post(new e(r3, r5, this, r4));
    }

    private static final void onLoadFail$lambda$3(int r2, Throwable r3, UIThreadCallbackAdapter r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Log.i(TAG, "onLoadFail execute code=" + r2 + ", e=" + r3);
        Iterator<IChameleonLoader.LoadingCallback> r6 = r4.callbacks.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r6.next().onLoadFail(r2, r5, r3);
        goto L4
    }
}
