package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.api.pluginapi.ILoadingPlugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import com.ss.android.lark.chameleon.widget.emptyview.EmptyView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/LoadingPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "callbackList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/LoadingPlugin$LoadFinishCallback;", "cmlLoadingLayout", "Landroid/widget/FrameLayout;", "emptyView", "Lcom/ss/android/lark/chameleon/widget/emptyview/EmptyView;", "hasLoadDone", BuildConfig.FLAVOR, "iLoadingPlugin", "Lcom/ss/android/lark/chameleon/api/pluginapi/ILoadingPlugin;", "timeoutJob", "Lkotlinx/coroutines/Job;", "addHideLoadingCallbackOnce", BuildConfig.FLAVOR, "callback", "getLoadingTimeout", BuildConfig.FLAVOR, "initEmptyView", "isStatisticsByJS", "needShowLoading", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/UIContainer;", "onDetachFromUIContainer", "Companion", "LoadFinishCallback", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LoadingPlugin extends AbsChameleonPlugin {
    public static final Companion Companion = null;
    public static final String TAG = "LARKAPI_TAG_LoadingPlugin";
    private final CopyOnWriteArrayList<LoadFinishCallback> callbackList;
    private FrameLayout cmlLoadingLayout;
    private EmptyView emptyView;
    private boolean hasLoadDone;
    private ILoadingPlugin iLoadingPlugin;
    private volatile Job timeoutJob;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/LoadingPlugin$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/LoadingPlugin$LoadFinishCallback;", BuildConfig.FLAVOR, "onLoadFinish", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface LoadFinishCallback {
        void onLoadFinish();
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(LoadingPlugin r0) {
        initEmptyView$lambda$0(r0);
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
        r1.setOnRetryListener(new a(this));
    L10:
        EmptyView r2 = this.emptyView;
        if (r2 == null) goto L14;
        r2.show();
        return;
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

    public static final /* synthetic */ UIContainer access$getUIContainer(LoadingPlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ void access$initEmptyView(LoadingPlugin r0) {
        r0.initEmptyView();
    }

    public static final /* synthetic */ boolean access$isStatisticsByJS(LoadingPlugin r0) {
        return r0.isStatisticsByJS();
    }

    public static final /* synthetic */ boolean access$needShowLoading(LoadingPlugin r0) {
        return r0.needShowLoading();
    }

    private final void addHideLoadingCallbackOnce(final LoadFinishCallback r3) {
        this.callbackList.add(new AnonymousClass1(this, r3));
    }

    private static final void initEmptyView$lambda$0(LoadingPlugin r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.getHost().getLoader().reload();
    }

    public void onAttachToHost(final ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        if (r3 == null) goto L8;
        IChameleonLoader r0 = r3.getLoader();
        if (r0 == null) goto L9;
        r0.addLoadCallback(new C03291(this, r3));
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$addHideLoadingCallbackOnce(LoadingPlugin r0, LoadFinishCallback r1) {
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

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, UIContainer r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, UIContainer r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r1, UIContainer r2) {
        super.onAttachToUIContainer(r1, r2);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, UIContainer r2) {
        super.onDetachFromUIContainer(r1, r2);
    }
}
