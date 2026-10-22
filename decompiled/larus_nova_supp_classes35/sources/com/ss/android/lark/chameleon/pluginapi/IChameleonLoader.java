package com.ss.android.lark.chameleon.pluginapi;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002!\"J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u001c\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u001a\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", BuildConfig.FLAVOR, "load", BuildConfig.FLAVOR, "url", BuildConfig.FLAVOR, "reload", "addLoadCallback", "cb", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$LoadingCallback;", "removeLoadCallback", "addTitleBarCallback", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$IChameleonTitleBarCallback;", "removeTitleBarCallback", "onLoadSuccess", "onLoadFailed", "code", BuildConfig.FLAVOR, "e", BuildConfig.FLAVOR, "release", "getVisible", BuildConfig.FLAVOR, "getStatus", "Lcom/ss/android/lark/chameleon/pluginapi/WebviewStatus;", "getRouterState", "Lcom/ss/android/lark/chameleon/pluginapi/RouterState;", "Ljava/io/Serializable;", "setRouteState", "state", "reportOpenStatus", ChameleonOpenTracker.ParamKey.RESULT, "Lcom/ss/android/lark/chameleon/pluginapi/OpenStatus;", "LoadingCallback", "IChameleonTitleBarCallback", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChameleonLoader {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onLoadFailed$default(IChameleonLoader r0, int r1, Throwable r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            r0.onLoadFailed(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadFailed");
        }

        public static /* synthetic */ void reportOpenStatus$default(IChameleonLoader r0, OpenStatus r1, int r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = -1;
        L6:
            r0.reportOpenStatus(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportOpenStatus");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$IChameleonTitleBarCallback;", BuildConfig.FLAVOR, "onLeftBackAndCloseChange", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IChameleonTitleBarCallback {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onLeftBackAndCloseChange(IChameleonTitleBarCallback r0) {
            }
        }

        void onLeftBackAndCloseChange();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J\b\u0010\u000b\u001a\u00020\u0007H\u0017J\b\u0010\f\u001a\u00020\u0007H\u0017J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0017J\u001a\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J\b\u0010\u0018\u001a\u00020\u0007H\u0017R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$LoadingCallback;", BuildConfig.FLAVOR, "keepOnRelease", BuildConfig.FLAVOR, "getKeepOnRelease", "()Z", "onLoadStart", BuildConfig.FLAVOR, "onPageStarted", "url", BuildConfig.FLAVOR, "onLoadSuccess", "onLoadSuccessByJS", "onLoadFailByJS", IPortraitService.TYPE, "code", BuildConfig.FLAVOR, "onReceivedTitle", "view", "Landroid/webkit/WebView;", "title", "onLoadFail", "e", BuildConfig.FLAVOR, "onRenderProcessGone", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface LoadingCallback {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            public static boolean getKeepOnRelease(LoadingCallback r0) {
                return false;
            }

            public static void onLoadFail(LoadingCallback r0, int r1, Throwable r2) {
            }

            public static void onLoadFailByJS(LoadingCallback r0, String r1, int r2) {
                Intrinsics.checkNotNullParameter(r1, IPortraitService.TYPE);
            }

            public static void onLoadStart(LoadingCallback r0) {
            }

            public static void onLoadSuccess(LoadingCallback r0) {
            }

            public static void onLoadSuccessByJS(LoadingCallback r0) {
            }

            public static void onPageStarted(LoadingCallback r0, String r1) {
            }

            public static void onReceivedTitle(LoadingCallback r0, WebView r1, String r2) {
            }

            @Deprecated(message = "已废弃，使用IRenderGoneListener")
            public static void onRenderProcessGone(LoadingCallback r0) {
            }
        }

        boolean getKeepOnRelease();

        void onLoadFail(int r1, Throwable r2);

        void onLoadFailByJS(String r1, int r2);

        void onLoadStart();

        void onLoadSuccess();

        void onLoadSuccessByJS();

        void onPageStarted(String r1);

        void onReceivedTitle(WebView r1, String r2);

        @Deprecated(message = "已废弃，使用IRenderGoneListener")
        void onRenderProcessGone();
    }

    void addLoadCallback(LoadingCallback r1);

    void addTitleBarCallback(IChameleonTitleBarCallback r1);

    RouterState<Serializable> getRouterState();

    WebviewStatus getStatus();

    boolean getVisible();

    void load(String r1);

    void onLoadFailed(int r1, Throwable r2);

    void onLoadSuccess();

    void release();

    void reload();

    void removeLoadCallback(LoadingCallback r1);

    void removeTitleBarCallback(IChameleonTitleBarCallback r1);

    void reportOpenStatus(OpenStatus r1, int r2);

    void setRouteState(RouterState<Serializable> r1);
}
