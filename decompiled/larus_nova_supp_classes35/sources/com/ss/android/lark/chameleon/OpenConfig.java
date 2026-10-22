package com.ss.android.lark.chameleon;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 W2\u00020\u0001:\u0001WB\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010D\u001a\u00020\u0000J\b\u0010E\u001a\u00020FH\u0016J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0013\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011HÆ\u0003J\u0083\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011HÆ\u0001J\u0013\u0010R\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020VHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001a\"\u0004\b'\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001a\"\u0004\b*\u0010\u001cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102Rz\u00103\u001ab\u0012\u0013\u0012\u001105¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0013\u0012\u001109¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110;¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010=¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006X"}, d2 = {"Lcom/ss/android/lark/chameleon/OpenConfig;", "Ljava/io/Serializable;", "titlebarConfig", "Lcom/ss/android/lark/chameleon/TitlebarConfig;", "showLoading", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "useErrorPage", "hideLoadingByJS", "statisticsByJS", "loadingTimeout", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "isModelView", "hideScrollBar", "isNestedEnable", "pluginProvider", "Lcom/ss/android/lark/chameleon/PluginProvider;", "onCreateLifecycleListener", "Lkotlin/Function0;", "Lcom/ss/android/lark/chameleon/ChameleonContainerLifecycleListener;", "<init>", "(Lcom/ss/android/lark/chameleon/TitlebarConfig;ZZZZJZZZLcom/ss/android/lark/chameleon/PluginProvider;Lkotlin/jvm/functions/Function0;)V", "getTitlebarConfig", "()Lcom/ss/android/lark/chameleon/TitlebarConfig;", "setTitlebarConfig", "(Lcom/ss/android/lark/chameleon/TitlebarConfig;)V", "getShowLoading", "()Z", "setShowLoading", "(Z)V", "getUseErrorPage", "setUseErrorPage", "getHideLoadingByJS", "setHideLoadingByJS", "getStatisticsByJS", "setStatisticsByJS", "getLoadingTimeout", "()J", "setLoadingTimeout", "(J)V", "setModelView", "getHideScrollBar", "setHideScrollBar", "setNestedEnable", "getPluginProvider", "()Lcom/ss/android/lark/chameleon/PluginProvider;", "setPluginProvider", "(Lcom/ss/android/lark/chameleon/PluginProvider;)V", "getOnCreateLifecycleListener", "()Lkotlin/jvm/functions/Function0;", "setOnCreateLifecycleListener", "(Lkotlin/jvm/functions/Function0;)V", "onCreateUIContainer", "Lkotlin/Function4;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Lkotlin/ParameterName;", IPortraitService.NAME, "pluginHost", "Landroid/view/View;", "contentView", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "titleBar", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getOnCreateUIContainer", "()Lkotlin/jvm/functions/Function4;", "setOnCreateUIContainer", "(Lkotlin/jvm/functions/Function4;)V", "copy", "toString", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "equals", "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Companion", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_LOADING_TIMEOUT = 25000;
    private boolean hideLoadingByJS;
    private boolean hideScrollBar;
    private boolean isModelView;
    private boolean isNestedEnable;
    private long loadingTimeout;
    private transient Function0<? extends ChameleonContainerLifecycleListener> onCreateLifecycleListener;
    private transient Function4<? super ChameleonPluginHost, ? super View, ? super FragmentManager, ? super TitleBar, ? extends t> onCreateUIContainer;
    private PluginProvider pluginProvider;
    private boolean showLoading;
    private boolean statisticsByJS;
    private TitlebarConfig titlebarConfig;
    private boolean useErrorPage;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/OpenConfig$Companion;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "DEFAULT_LOADING_TIMEOUT", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public OpenConfig() {
        this(null, false, false, false, false, 0, false, false, false, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenConfig copy$default(OpenConfig r13, TitlebarConfig r14, boolean r15, boolean r16, boolean r17, boolean r18, long r19, boolean r21, boolean r22, boolean r23, PluginProvider r24, Function0 r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        TitlebarConfig r2 = r13.titlebarConfig;
    L7:
        if ((r26 & 2) == 0) goto L9;
        boolean r3 = r13.showLoading;
    L11:
        if ((r26 & 4) == 0) goto L13;
        boolean r4 = r13.useErrorPage;
    L15:
        if ((r26 & 8) == 0) goto L17;
        boolean r5 = r13.hideLoadingByJS;
    L19:
        if ((r26 & 16) == 0) goto L21;
        boolean r6 = r13.statisticsByJS;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r7 = r13.loadingTimeout;
    L27:
        if ((r26 & 64) == 0) goto L29;
        boolean r9 = r13.isModelView;
    L31:
        if ((r26 & 128) == 0) goto L33;
        boolean r10 = r13.hideScrollBar;
    L35:
        if ((r26 & 256) == 0) goto L37;
        boolean r11 = r13.isNestedEnable;
    L39:
        if ((r26 & 512) == 0) goto L41;
        PluginProvider r12 = r13.pluginProvider;
    L43:
        if ((r26 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        Function0 r1 = r13.onCreateLifecycleListener;
    L47:
        return r13.copy(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12, r1);
    L45:
        r1 = r25;
        goto L47
    L41:
        r12 = r24;
        goto L43
    L37:
        r11 = r23;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final TitlebarConfig component1() {
        return this.titlebarConfig;
    }

    public final PluginProvider component10() {
        return this.pluginProvider;
    }

    public final Function0<ChameleonContainerLifecycleListener> component11() {
        return this.onCreateLifecycleListener;
    }

    public final boolean component2() {
        return this.showLoading;
    }

    public final boolean component3() {
        return this.useErrorPage;
    }

    public final boolean component4() {
        return this.hideLoadingByJS;
    }

    public final boolean component5() {
        return this.statisticsByJS;
    }

    public final long component6() {
        return this.loadingTimeout;
    }

    public final boolean component7() {
        return this.isModelView;
    }

    public final boolean component8() {
        return this.hideScrollBar;
    }

    public final boolean component9() {
        return this.isNestedEnable;
    }

    public final OpenConfig copy(TitlebarConfig r15, boolean r16, boolean r17, boolean r18, boolean r19, long r20, boolean r22, boolean r23, boolean r24, PluginProvider r25, Function0<? extends ChameleonContainerLifecycleListener> r26) {
        Intrinsics.checkNotNullParameter(r15, "titlebarConfig");
        return new OpenConfig(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OpenConfig) == true) goto L8;
        return false;
    L8:
        OpenConfig r9 = (OpenConfig) r8;
        if (Intrinsics.areEqual(this.titlebarConfig, r9.titlebarConfig) == true) goto L12;
        return false;
    L12:
        if (this.showLoading == r9.showLoading) goto L15;
        return false;
    L15:
        if (this.useErrorPage == r9.useErrorPage) goto L18;
        return false;
    L18:
        if (this.hideLoadingByJS == r9.hideLoadingByJS) goto L21;
        return false;
    L21:
        if (this.statisticsByJS == r9.statisticsByJS) goto L24;
        return false;
    L24:
        if (this.loadingTimeout == r9.loadingTimeout) goto L27;
        return false;
    L27:
        if (this.isModelView == r9.isModelView) goto L30;
        return false;
    L30:
        if (this.hideScrollBar == r9.hideScrollBar) goto L33;
        return false;
    L33:
        if (this.isNestedEnable == r9.isNestedEnable) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.pluginProvider, r9.pluginProvider) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.onCreateLifecycleListener, r9.onCreateLifecycleListener) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = this.titlebarConfig.hashCode() * 31;
        int r2 = 1231;
        if (this.showLoading == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.useErrorPage == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.hideLoadingByJS == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.statisticsByJS == false) goto L17;
        int r8 = 1231;
    L18:
        long r9 = this.loadingTimeout;
        int r10 = (((r7 + r8) * 31) + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        if (this.isModelView == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.hideScrollBar == false) goto L25;
        int r13 = 1231;
    L26:
        int r14 = (r12 + r13) * 31;
        if (this.isNestedEnable == true) goto L30;
        r2 = 1237;
    L30:
        int r15 = (r14 + r2) * 31;
        PluginProvider r16 = this.pluginProvider;
        int r17 = 0;
        if (r16 != null) goto L33;
        int r18 = 0;
    L34:
        int r19 = (r15 + r18) * 31;
        Function0<? extends ChameleonContainerLifecycleListener> r20 = this.onCreateLifecycleListener;
        if (r20 == null) goto L39;
        r17 = r20.hashCode();
    L39:
        return r19 + r17;
    L33:
        r18 = r16.hashCode();
        goto L34
    L25:
        r13 = 1237;
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final OpenConfig copy() {
        TitlebarConfig r1 = this.titlebarConfig.copy();
        boolean r2 = this.showLoading;
        boolean r3 = this.useErrorPage;
        boolean r4 = this.hideLoadingByJS;
        boolean r5 = this.statisticsByJS;
        long r6 = this.loadingTimeout;
        boolean r8 = this.isModelView;
        boolean r9 = this.hideScrollBar;
        boolean r10 = this.isNestedEnable;
        PluginProvider r0 = this.pluginProvider;
        if (r0 == null) goto L5;
        PluginProvider r7 = r0.copy();
    L6:
        OpenConfig r13 = new OpenConfig(r1, r2, r3, r4, r5, r6, r8, r9, r10, r7, this.onCreateLifecycleListener);
        r13.onCreateUIContainer = this.onCreateUIContainer;
        return r13;
    L5:
        r7 = null;
        goto L6
    }

    public String toString() {
        return "OpenConfig(titlebarConfig=" + this.titlebarConfig + ", showLoading=" + this.showLoading + ", useErrorPage=" + this.useErrorPage + ", hideLoadingByJS=" + this.hideLoadingByJS + ", statisticsByJS=" + this.statisticsByJS + ", loadingTimeout=" + this.loadingTimeout + ", isModelView=" + this.isModelView + ", hideScrollBar=" + this.hideScrollBar + ", isNestedEnable=" + this.isNestedEnable + ", pluginProvider=" + this.pluginProvider + ", lifecycleListener=" + this.onCreateLifecycleListener + ')';
    }

    public final boolean getHideLoadingByJS() {
        return this.hideLoadingByJS;
    }

    public final boolean getHideScrollBar() {
        return this.hideScrollBar;
    }

    public final long getLoadingTimeout() {
        return this.loadingTimeout;
    }

    public final Function0<ChameleonContainerLifecycleListener> getOnCreateLifecycleListener() {
        return this.onCreateLifecycleListener;
    }

    public final Function4<ChameleonPluginHost, View, FragmentManager, TitleBar, t> getOnCreateUIContainer() {
        return this.onCreateUIContainer;
    }

    public final PluginProvider getPluginProvider() {
        return this.pluginProvider;
    }

    public final boolean getShowLoading() {
        return this.showLoading;
    }

    public final boolean getStatisticsByJS() {
        return this.statisticsByJS;
    }

    public final TitlebarConfig getTitlebarConfig() {
        return this.titlebarConfig;
    }

    public final boolean getUseErrorPage() {
        return this.useErrorPage;
    }

    public final boolean isModelView() {
        return this.isModelView;
    }

    public final boolean isNestedEnable() {
        return this.isNestedEnable;
    }

    public final void setHideLoadingByJS(boolean r1) {
        this.hideLoadingByJS = r1;
    }

    public final void setHideScrollBar(boolean r1) {
        this.hideScrollBar = r1;
    }

    public final void setLoadingTimeout(long r1) {
        this.loadingTimeout = r1;
    }

    public final void setModelView(boolean r1) {
        this.isModelView = r1;
    }

    public final void setNestedEnable(boolean r1) {
        this.isNestedEnable = r1;
    }

    public final void setOnCreateLifecycleListener(Function0<? extends ChameleonContainerLifecycleListener> r1) {
        this.onCreateLifecycleListener = r1;
    }

    public final void setOnCreateUIContainer(Function4<? super ChameleonPluginHost, ? super View, ? super FragmentManager, ? super TitleBar, ? extends t> r1) {
        this.onCreateUIContainer = r1;
    }

    public final void setPluginProvider(PluginProvider r1) {
        this.pluginProvider = r1;
    }

    public final void setShowLoading(boolean r1) {
        this.showLoading = r1;
    }

    public final void setStatisticsByJS(boolean r1) {
        this.statisticsByJS = r1;
    }

    public final void setTitlebarConfig(TitlebarConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.titlebarConfig = r2;
    }

    public final void setUseErrorPage(boolean r1) {
        this.useErrorPage = r1;
    }

    public OpenConfig(TitlebarConfig r2, boolean r3, boolean r4, boolean r5, boolean r6, long r7, boolean r9, boolean r10, boolean r11, PluginProvider r12, Function0<? extends ChameleonContainerLifecycleListener> r13) {
        Intrinsics.checkNotNullParameter(r2, "titlebarConfig");
        this.titlebarConfig = r2;
        this.showLoading = r3;
        this.useErrorPage = r4;
        this.hideLoadingByJS = r5;
        this.statisticsByJS = r6;
        this.loadingTimeout = r7;
        this.isModelView = r9;
        this.hideScrollBar = r10;
        this.isNestedEnable = r11;
        this.pluginProvider = r12;
        this.onCreateLifecycleListener = r13;
    }

    public /* synthetic */ OpenConfig(TitlebarConfig r14, boolean r15, boolean r16, boolean r17, boolean r18, long r19, boolean r21, boolean r22, boolean r23, PluginProvider r24, Function0 r25, int r26, DefaultConstructorMarker r27) {
        Function0 r2 = null;
        if ((r26 & 1) == 0) goto L5;
        TitlebarConfig r1 = new TitlebarConfig(true, null, 2, null);
    L6:
        boolean r4 = false;
        if ((r26 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r26 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r26 & 8) == 0) goto L17;
        boolean r6 = false;
    L19:
        if ((r26 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r8 = DEFAULT_LOADING_TIMEOUT;
    L27:
        if ((r26 & 64) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r26 & 128) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r26 & 256) != 0) goto L39;
        r4 = r23;
    L39:
        if ((r26 & 512) == 0) goto L41;
        PluginProvider r12 = null;
    L43:
        if ((r26 & ChameleonContainerUtils.MAX_URL_LENGTH) != 0) goto L46;
        r2 = r25;
    L46:
        this(r1, r3, r5, r6, r7, r8, r10, r11, r4, r12, r2);
        return;
    L41:
        r12 = r24;
        goto L43
    L33:
        r11 = r22;
        goto L35
    L29:
        r10 = r21;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L6
    }
}
