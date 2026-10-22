package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginId;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.ILoadingPlugin;
import com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyView;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0016\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u001c\u0010\u001d\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010 \u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020*H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/LoadingPlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "emptyView", "Lcom/ss/android/lark/chameleon/widgetv2/emptyview/EmptyView;", "cmlLoadingLayout", "Landroid/widget/FrameLayout;", "iLoadingPlugin", "Lcom/ss/android/lark/chameleon/pluginapi/ILoadingPlugin;", "hasLoadDone", BuildConfig.FLAVOR, "timeoutJob", "Lkotlinx/coroutines/Job;", "getPluginId", BuildConfig.FLAVOR, "getLoadingView", "Landroid/view/View;", "onLoadSuccess", BuildConfig.FLAVOR, "onLoadFail", "code", BuildConfig.FLAVOR, "e", BuildConfig.FLAVOR, "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "initEmptyView", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "addHideLoadingCallbackOnce", "callback", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/LoadingPlugin$LoadFinishCallback;", "callbackList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "useErrorPage", "needShowLoading", "isStatisticsByJS", "getLoadingTimeout", BuildConfig.FLAVOR, "Companion", "LoadFinishCallback", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LoadingPlugin extends AbsChameleonPlugin {
    public static final a Companion = null;
    public static final String TAG = "CML_TAG_LoadingPlugin";
    private final CopyOnWriteArrayList<b> callbackList;
    private FrameLayout cmlLoadingLayout;
    private EmptyView emptyView;
    private boolean hasLoadDone;
    private ILoadingPlugin iLoadingPlugin;
    private volatile Job timeoutJob;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void onLoadFinish();
    }

    public static final class c implements b {
        public final /* synthetic */ LoadingPlugin a;
        public final /* synthetic */ b b;

        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.LoadingPlugin.b
        public final void onLoadFinish() {
            LoadingPlugin.access$getCallbackList$p(this.a).remove(this);
            this.b.onLoadFinish();
        }

        public c(LoadingPlugin r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements EmptyView.OnRetryListener {
        public final /* synthetic */ LoadingPlugin a;

        public d(LoadingPlugin r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyView.OnRetryListener
        public final void onFailedRetry() {
            this.a.getHost().getLoader().reload();
        }
    }

    static {
        Companion = new a();
    }

    public void onLoadFail(int r1, Throwable r2) {
    }

    public void onLoadSuccess() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void initEmptyView() {
        if (this.emptyView != null) goto L10;
        EmptyView r0 = (EmptyView) ((ViewStub) getUIContainer().getContentView().findViewById(2131367049)).inflate();
        this.emptyView = r0;
        if (r0 == null) goto L7;
        r0.setLoadViewMarginTop(0);
    L7:
        EmptyView r1 = this.emptyView;
        if (r1 == null) goto L10;
        r1.setOnRetryListener(new d(this));
    L10:
        EmptyView r2 = this.emptyView;
        if (r2 == null) goto L14;
        r2.show();
        return;
    }

    public String getPluginId() {
        return ChameleonPluginId.LoadingPlugin.getValue();
    }

    public LoadingPlugin() {
        this.callbackList = new CopyOnWriteArrayList();
    }

    private final long getLoadingTimeout() {
        OpenConfig r0 = getChameleonConfig().getOpenConfig();
        if (r0 != null) goto L7;
        return OpenConfig.DEFAULT_LOADING_TIMEOUT;
    L7:
        return r0.getLoadingTimeout();
    }

    private final boolean isStatisticsByJS() {
        OpenConfig r0 = getChameleonConfig().getOpenConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getStatisticsByJS() != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean needShowLoading() {
        OpenConfig r0 = getChameleonConfig().getOpenConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getShowLoading() != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean useErrorPage() {
        OpenConfig r0 = getChameleonConfig().getOpenConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getUseErrorPage() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public View getLoadingView() {
        initEmptyView();
        if (needShowLoading() == false) goto L7;
        j.e(TAG, "showLoading is true ");
        EmptyView r0 = this.emptyView;
        if (r0 == null) goto L16;
        r0.showLoading();
    L16:
        return this.emptyView;
    L7:
        j.e(TAG, "showLoading is false");
        if (useErrorPage() == false) goto L12;
        EmptyView r1 = this.emptyView;
        if (r1 == null) goto L16;
        r1.hideLoadingAndShowErrorPage();
        goto L16
    L12:
        EmptyView r2 = this.emptyView;
        if (r2 == null) goto L16;
        r2.hideLoading();
        goto L16
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getCallbackList$p(LoadingPlugin r0) {
        return r0.callbackList;
    }

    public static final /* synthetic */ FrameLayout access$getCmlLoadingLayout$p(LoadingPlugin r0) {
        return r0.cmlLoadingLayout;
    }

    public static final /* synthetic */ EmptyView access$getEmptyView$p(LoadingPlugin r0) {
        return r0.emptyView;
    }

    public static final /* synthetic */ boolean access$getHasLoadDone$p(LoadingPlugin r0) {
        return r0.hasLoadDone;
    }

    public static final /* synthetic */ ILoadingPlugin access$getILoadingPlugin$p(LoadingPlugin r0) {
        return r0.iLoadingPlugin;
    }

    public static final /* synthetic */ long access$getLoadingTimeout(LoadingPlugin r2) {
        return r2.getLoadingTimeout();
    }

    public static final /* synthetic */ Job access$getTimeoutJob$p(LoadingPlugin r0) {
        return r0.timeoutJob;
    }

    public static final /* synthetic */ t access$getUIContainer(LoadingPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ boolean access$isStatisticsByJS(LoadingPlugin r0) {
        return r0.isStatisticsByJS();
    }

    private final void addHideLoadingCallbackOnce(b r3) {
        this.callbackList.add(new c(this, r3));
    }

    public void onAttachToHost(final ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        if (r3 == null) goto L8;
        IChameleonLoader r0 = r3.getLoader();
        if (r0 == null) goto L9;
        r0.addLoadCallback(new AnonymousClass1(this, r3));
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$addHideLoadingCallbackOnce(LoadingPlugin r0, b r1) {
        r0.addHideLoadingCallbackOnce(r1);
    }

    public static final /* synthetic */ void access$setCmlLoadingLayout$p(LoadingPlugin r0, FrameLayout r1) {
        r0.cmlLoadingLayout = r1;
    }

    public static final /* synthetic */ void access$setHasLoadDone$p(LoadingPlugin r0, boolean r1) {
        r0.hasLoadDone = r1;
    }

    public static final /* synthetic */ void access$setILoadingPlugin$p(LoadingPlugin r0, ILoadingPlugin r1) {
        r0.iLoadingPlugin = r1;
    }

    public static final /* synthetic */ void access$setTimeoutJob$p(LoadingPlugin r0, Job r1) {
        r0.timeoutJob = r1;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
    }
}
