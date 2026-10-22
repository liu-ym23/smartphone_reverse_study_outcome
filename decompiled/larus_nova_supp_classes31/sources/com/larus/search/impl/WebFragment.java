package com.larus.search.impl;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.apm.ApmAgent;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ivy.ivykit.plugin.impl.web.PluginWebView;
import com.ixigua.lib.track.TrackParams;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.CommonLoadDialogFragment;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.home.impl.sdk.x1;
import com.larus.ivykit.IvyKitInitializer;
import com.larus.ivykit.web.TTWebViewService;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.b2;
import com.larus.platform.api.e1;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.search.api.event.HybridEventParams;
import com.larus.search.api.model.SchemaSuffixMap;
import com.larus.search.impl.databinding.LarusSearchWebBrowserBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010/J\u0012\u0010E\u001a\u00020C2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0012\u0010H\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010I\u001a\u00020CH\u0002J\u001c\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020\u000b2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MH\u0002J\u0010\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020\u001bH\u0002J\u0012\u0010S\u001a\u0004\u0018\u00010\u000b2\u0006\u0010T\u001a\u00020\u000bH\u0002J\u0012\u0010U\u001a\u00020C2\b\u0010V\u001a\u0004\u0018\u000108H\u0002J&\u0010W\u001a\u0004\u0018\u00010\u00192\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010\\\u001a\u00020C2\u0006\u0010]\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\n\u0010^\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010_\u001a\u00020C2\b\u0010]\u001a\u0004\u0018\u00010\u00192\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010a\u001a\u00020C2\u0006\u0010b\u001a\u00020\u001bH\u0002J\b\u0010c\u001a\u00020CH\u0002J\b\u0010d\u001a\u00020CH\u0002J\b\u0010e\u001a\u00020\u001bH\u0002J\b\u0010f\u001a\u00020CH\u0002J\b\u0010g\u001a\u00020CH\u0002J\b\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u00020CH\u0002J\u0012\u0010k\u001a\u00020C2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010l\u001a\u00020CH\u0002J\u0010\u0010m\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0012\u0010n\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010o\u001a\u00020CH\u0002J\b\u0010p\u001a\u00020CH\u0002J\b\u0010q\u001a\u00020CH\u0002J\b\u0010r\u001a\u00020CH\u0016J\b\u0010s\u001a\u00020CH\u0016J\b\u0010t\u001a\u00020CH\u0016J&\u0010u\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0002J\u0012\u0010w\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010x\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0002J\f\u0010y\u001a\u00020z*\u00020zH\u0002J2\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0002J&\u0010|\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0002J\u000e\u0010}\u001a\u00020\u001b*\u0004\u0018\u00010\u000bH\u0002J\b\u0010~\u001a\u00020CH\u0016J\u0006\u0010\u007f\u001a\u00020CJ\u001b\u0010\u0080\u0001\u001a\u00020C2\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u0082\u0001\u001a\u00020MH\u0016J\u000b\u0010\u0083\u0001\u001a\u0004\u0018\u00010AH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b01X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020504\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b=\u0010>R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/larus/search/impl/WebFragment;", "Lcom/larus/platform/model/webview/AbsWebFragment;", "<init>", "()V", "localFileTaker", "Lcom/larus/search/impl/LocalFileTaker;", "getLocalFileTaker", "()Lcom/larus/search/impl/LocalFileTaker;", "localFileTaker$delegate", "Lkotlin/Lazy;", "schema", "", "binding", "Lcom/larus/search/impl/databinding/LarusSearchWebBrowserBinding;", "url", "schemeTitle", "morePopup", "Lcom/skydoves/balloon/Balloon;", "trace", "Lcom/larus/platform/api/IPageLoadTrace;", "ivyWebViewClient", "Lcom/ivy/ivykit/api/plugin/web/IvyWebClient;", "ivyWebView", "Lcom/ivy/ivykit/api/plugin/render/WebViewPluginView;", "webViewClientCustomView", "Landroid/view/View;", "isCurrentFullScreen", "", "originalPaddingTop", "", "originalPaddingBottom", "originalRequestedOrientation", "Ljava/lang/Integer;", "hybridEventParams", "Lcom/larus/search/api/event/HybridEventParams;", "onCreateTimeStamp", "", "isNotFullPage", "isShowProgressBar", "isShowCenterProgressBar", "disableGoForwardAndBack", "isNeedSchemaPremix", "schemaSuffix", "Lcom/larus/search/api/model/SchemaSuffixMap;", "enterLoadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialogFragment;", "webViewProxyCallback", "Lcom/larus/bmhome/web/IWebViewProxyCallback;", "haveAgreeRequestPermission", "", "fileChooserCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserResultDelivered", "pendingPermissionRequest", "Lcom/ivy/ivykit/api/plugin/callback/IIvyPermissionRequest;", "needTrace", "needLarkAuthCookieSync", "hasTraced", "enableAddingFragmentQueryCompact", "getEnableAddingFragmentQueryCompact", "()Z", "enableAddingFragmentQueryCompact$delegate", "preloadContextWrapper", "Landroid/content/MutableContextWrapper;", "setInterceptWebViewScrollCallback", "", "interceptWebViewScrollCallback", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "tryOpenOfficePreviewUrl", "ensureSDKInit", "doWhenReceivedError", "scene", "eventExtraInfo", "Lorg/json/JSONObject;", "isUriIntentValid", "intent", "Landroid/content/Intent;", "handleFullScreen", "isFullScreen", "transformManifestToPermissionName", "manifest", "createRequestPermissionDialog", "request", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initTitle", "innerSetViewColor", "rawColor", "handleTransStatusBar", "transParent", "initBottomBar", "tryShowLoading", "enableBottomShareStyle", "forwardWebPage", "doRefresh", "getWebViewContext", "Landroid/content/Context;", "createHybridKit", "interceptLoadIvykit", "setWebViewBgColor", "notUseForest", "isDomStorageEnabled", "backWebPage", "refreshCloseAllButton", "refreshBottomBar", "onResume", "onDestroyView", "onDestroy", "addCommonQuery", "requestHeaders", "needsAddCommonQueryCompact", "addCommonQueryCompact", "addThemeQuery", "Landroid/net/Uri$Builder;", "addCommonHeaders", "checkWhiteList", "urlCheck", "onPause", "onBackPressed", "sendEvent", "name", "params", "getPreloadContextWrapper", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class WebFragment extends AbsWebFragment {
    public static final HashMap<String, String> K = null;
    public zt8.c A;
    public final Map<String, Boolean> B;
    public ValueCallback<Uri[]> C;
    public boolean D;
    public ix7.a E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final Lazy I;
    public MutableContextWrapper J;
    public final Lazy d;
    public final String e;
    public LarusSearchWebBrowserBinding f;
    public String g;
    public String h;
    public Balloon i;
    public final e1 j;
    public lx7.a k;
    public kx7.c l;
    public View m;
    public boolean n;
    public int o;
    public int p;
    public Integer q;
    public HybridEventParams r;
    public long s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public SchemaSuffixMap y;
    public CommonLoadDialogFragment z;

    public static final class a {
    }

    public static final class b implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ WebFragment a;
        public final /* synthetic */ List<String> b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ix7.a d;

        public final void confirm() {
            i2 r0 = i2.b;
            final WebFragment r1 = this.a;
            List<String> r2 = this.b;
            final String r3 = this.c;
            final ix7.a r4 = this.d;
            i2.q(r1, r2, new y0(r1, r3, r4));
        }

        public b(WebFragment r1, List<String> r2, String r3, ix7.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ WebFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ix7.a c;

        public final void cancel() {
            this.a.B.put(this.b, Boolean.FALSE);
            ix7.a r0 = this.c;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public c(WebFragment r1, String r2, ix7.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ LinearLayout b;
        public final /* synthetic */ boolean c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r11) {
            this.a.removeOnAttachStateChangeListener(this);
            WindowInsetsCompat r12 = ViewCompat.getRootWindowInsets(this.b);
            if (r12 == null) goto L7;
            Insets r13 = r12.getInsets(WindowInsetsCompat.Type.navigationBars());
            if (r13 == null) goto L7;
            int r14 = r13.bottom;
        L8:
            WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(this.b);
            if (r1 == null) goto L13;
            Insets r2 = r1.getInsets(WindowInsetsCompat.Type.statusBars());
            if (r2 == null) goto L13;
            int r3 = r2.top;
        L15:
            if (this.c == false) goto L17;
            LinearLayout r4 = this.b;
            int r5 = r4.getPaddingStart();
            int r7 = r4.getPaddingEnd();
            FLogger.a.i("updatePaddingRelative", "view:" + r4.getClass().getSimpleName() + ",source:onWebViewCreated,start:" + r5 + ",top:0,end:" + r7 + ",bottom:" + r14);
            r4.setPaddingRelative(r5, 0, r7, r14);
            return;
        L17:
            LinearLayout r0 = this.b;
            int r6 = r0.getPaddingStart();
            int r8 = r0.getPaddingEnd();
            FLogger.a.i("updatePaddingRelative", "view:" + r0.getClass().getSimpleName() + ",source:onWebViewCreated,start:" + r6 + ",top:" + r3 + ",end:" + r8 + ",bottom:" + r14);
            r0.setPaddingRelative(r6, r3, r8, r14);
            return;
        L13:
            r3 = 0;
        L7:
            r14 = 0;
            goto L8
        }

        public d(View r1, LinearLayout r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements ix7.e {
        public String a;
        public final /* synthetic */ WebFragment b;

        public final void h(String r1, int r2, String r3) {
        }

        public final void f() {
            WebFragment r0 = this.b;
            HashMap<String, String> r1 = WebFragment.K;
            r0.da0(false);
            WebFragment r2 = this.b;
            View r3 = r2.m;
            if (r3 != null) goto L5;
            return;
        L5:
            LarusSearchWebBrowserBinding r4 = r2.f;
            if (r4 == null) goto L10;
            FrameLayout r5 = r4.a;
            if (r5 == null) goto L10;
            r5.removeView(r3);
        L10:
            this.b.m = null;
        }

        public e(WebFragment r1) {
            this.b = r1;
        }

        public final void b(SslError r4) {
            FLogger.a.w("WebFragment", "onReceivedSslError " + r4 + " url:" + this.b.g);
            WebFragment r0 = this.b;
            JSONObject r1 = new JSONObject();
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            r1.put("error", r5);
            Unit r6 = Unit.INSTANCE;
            WebFragment.U90(r0, "onReceivedSslError", r1);
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final lx7.b c(lx7.b r19) {
            Intrinsics.checkNotNullParameter(r19, "before");
            WebFragment r2 = this.b;
            String r9 = r19.a;
            Map r3 = r19.b;
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            Map<String, String> r11 = TypeIntrinsics.asMutableMap(r3);
            boolean r12 = true;
            if (((Boolean) r2.I.getValue()).booleanValue() == false) goto L16;
            if (r9 != null) goto L6;
        L9:
            boolean r4 = true;
        L10:
            if (r4 == true) goto L16;
            int r8 = StringsKt.indexOf$default(r9, "#", 0, false, 6, null);
            int r5 = StringsKt.indexOf$default(r9, "?", 0, false, 6, null);
            if (r8 <= 0) goto L16;
            if (r5 <= r8) goto L16;
            boolean r6 = true;
        L17:
            String r7 = "";
            if (r6 == false) goto L40;
            if (r9 != null) goto L21;
            String r10 = "";
        L47:
            WebFragment r13 = this.b;
            String r14 = r19.a;
            Map r1 = r19.b;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            Map<String, String> r15 = TypeIntrinsics.asMutableMap(r1);
            if (r13.X90(r14, r15) == false) goto L72;
            FLogger.a.i("WebFragment", "addCommonHeaders: called, in whitelist");
            Function0 r16 = SearchServiceImpl.a.a;
            if (r16 == null) goto L55;
            String r17 = (String) r16.invoke();
            if (r17 == null) goto L55;
            r7 = r17;
        L55:
            r15.put("x-tt-token", r7);
            if (HttpExtKt.e().a == false) goto L64;
            r15.put("x-use-boe", "1");
            if (HttpExtKt.e().b.length() > 0) goto L61;
            r12 = false;
        L61:
            if (r12 == false) goto L72;
            r15.put("x-tt-env", HttpExtKt.e().b);
            goto L72
        L64:
            if (HttpExtKt.e().c == false) goto L72;
            r15.put("x-use-ppe", "1");
            if (HttpExtKt.e().d.length() > 0) goto L69;
            r12 = false;
        L69:
            if (r12 == false) goto L72;
            r15.put("x-tt-env", HttpExtKt.e().d);
        L72:
            if (AppHost.a.isDebug() == false) goto L79;
            Iterator<Map.Entry<String, String>> r18 = r15.entrySet().iterator();
            String r20 = "addCommonHeaders: called, headers: ";
        L75:
            if (r18.hasNext() == false) goto L77;
            Map.Entry<String, String> r21 = r18.next();
            r20 = r20 + r21.getKey() + " = " + r21.getValue() + '\n';
            goto L75
        L77:
            FLogger.a.d("WebFragment", r20);
        L79:
            return new lx7.b(r10, r15);
        L21:
            boolean r22 = v19.h.a;
            Context r23 = r2.getContext();
            if (r23 != null) goto L25;
            r23 = AppHost.a.getApplication();
        L25:
            if (v19.h.b(r23) == false) goto L27;
            String r24 = "dark";
        L28:
            String r110 = "?";
            if (StringsKt.contains$default(r9, "?", false, 2, null) == false) goto L32;
            r110 = "&";
        L32:
            if (r2.X90(r9, r11) == true) goto L34;
            r10 = r9 + r110 + "theme=" + r24;
            FLogger.a.i("WebFragment", "addCommonQueryCompact: called, not in white list, result uri = " + r10);
            goto L47
        L34:
            if (HttpExtKt.e().a == false) goto L36;
            String r25 = b2.a.o();
        L37:
            r10 = r9 + r110 + "is_inapp=1&api_host=" + r25 + "&theme=" + r24;
            FLogger.a.i("WebFragment", "addCommonQueryCompact: called, result = " + r10);
            goto L47
        L36:
            r25 = b2.a.h();
            goto L37
        L27:
            r24 = "light";
            goto L28
        L40:
            if (r2.X90(r9, r11) == false) goto L46;
            Uri.Builder r26 = UriProtector.parse(r9).buildUpon().appendQueryParameter("is_inapp", "1");
            if (HttpExtKt.e().a == false) goto L44;
            String r27 = b2.a.o();
        L45:
            Uri r28 = r2.V90(r26.appendQueryParameter("api_host", r27)).build();
            FLogger.a.i("WebFragment", "addCommonQuery: called, result uri = " + r28);
            r10 = r28.toString();
            Intrinsics.checkNotNull(r10);
            goto L47
        L44:
            r27 = b2.a.h();
            goto L45
        L46:
            Uri r29 = r2.V90(UriProtector.parse(r9).buildUpon()).build();
            FLogger.a.i("WebFragment", "addCommonQuery: called, not in white list, result uri = " + r29);
            r10 = r29.toString();
            Intrinsics.checkNotNull(r10);
            goto L47
        L6:
            if (r9.length() == 0) goto L9;
            r4 = false;
        L16:
            r6 = false;
            goto L17
        }

        public final boolean d(com.ivy.ivykit.plugin.impl.web.b r15) {
            if (r15 == null) goto L4;
            String[] r0 = r15.getResources();
        L5:
            FLogger r10 = FLogger.a;
            if (r0 == null) goto L9;
            String r1 = ArraysKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null);
            if (r1 == null) goto L9;
        L10:
            r10.i("WebFragment", "onRequestPermission resources=".concat(r1));
            int r2 = 0;
            if (r0 != null) goto L13;
        L19:
            boolean r3 = true;
        L20:
            if (r3 == false) goto L25;
            r10.w("WebFragment", "onRequestPermission: empty resources, deny");
            if (r15 == null) goto L24;
            r15.a();
        L24:
            return true;
        L25:
            ArrayList r4 = new ArrayList();
            int r5 = r0.length;
        L26:
            if (r2 >= r5) goto L32;
            String r6 = WebFragment.K.get(r0[r2]);
            if (r6 == null) goto L30;
            r4.add(r6);
        L30:
            r2 = r2 + 1;
            goto L26
        L32:
            if (CollectionsKt.distinct(r4).isEmpty() == false) goto L36;
            FLogger.a.w("WebFragment", "onRequestPermission: unsupported resources: " + ArraysKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null));
            r15.a();
            return true;
        L36:
            if (this.b.isAdded() == true) goto L40;
            FLogger.a.w("WebFragment", "onRequestPermission: fragment not attached, deny");
            r15.a();
            return true;
        L40:
            if (this.b.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L42;
        L46:
            FLogger.a.w("WebFragment", "onRequestPermission: not resumed or state saved, postpone");
            this.b.E = r15;
            return true;
        L42:
            if (this.b.getChildFragmentManager().isStateSaved() == true) goto L46;
            WebFragment r7 = this.b;
            HashMap<String, String> r8 = WebFragment.K;
            r7.Z90(r15);
            return true;
        L13:
            if (r0.length != 0) goto L15;
            boolean r9 = true;
        L16:
            if (r9 == true) goto L19;
            r3 = false;
            goto L20
        L15:
            r9 = false;
        L9:
            r1 = "null";
            goto L10
        L4:
            r0 = null;
            goto L5
        }

        public final void e(View r4) {
            WebFragment r0 = this.b;
            if (r4 != null) goto L5;
            return;
        L5:
            r0.m = r4;
            r0.da0(true);
            LarusSearchWebBrowserBinding r1 = this.b.f;
            if (r1 == null) goto L11;
            FrameLayout r2 = r1.a;
            if (r2 == null) goto L12;
            r2.addView(r4, new ViewGroup.LayoutParams(-1, -1));
            return;
        L12:
            return;
        }

        public final void onPageStarted(String r4) {
            FLogger.a.i("WebFragment", "onPageStarted url:" + r4);
            this.a = r4;
            WebFragment r5 = this.b;
            HashMap<String, String> r0 = WebFragment.K;
            r5.ja0();
            this.b.ia0();
        }

        /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.search.impl.z] */
        /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.search.impl.y] */
        /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.search.impl.a1, java.lang.Object] */
        public final boolean g(WebView r17, ValueCallback r18) {
            WebFragment r1 = this.b;
            if (r1.D == true) goto L7;
            ValueCallback<Uri[]> r2 = r1.C;
            if (r2 == null) goto L7;
            r2.onReceiveValue(null);
        L7:
            WebFragment r3 = this.b;
            r3.C = r18;
            r3.D = false;
            if (r17 == null) goto L10;
            String r4 = r17.getUrl();
        L11:
            String r5 = "";
            if (r4 != null) goto L14;
            r4 = "";
        L14:
            Uri r6 = UriProtector.parse(r4);
            final a0 r7 = (a0) this.b.d.getValue();
            String r8 = r6.getHost();
            if (r8 != null) goto L17;
            r8 = "";
        L17:
            final WebFragment r9 = this.b;
            final ?? r10 = new a1(r9);
            r7.getClass();
            Intrinsics.checkNotNullParameter(r8, "originUri");
            Intrinsics.checkNotNullParameter(r9, "fragment");
            Intrinsics.checkNotNullParameter(r10, "onFail");
            if (Build.VERSION.SDK_INT >= 33) goto L54;
            FragmentManager r13 = r9.requireFragmentManager();
            Context r14 = r9.requireContext();
            ?? r15 = new y(r10);
            ?? r11 = new z(r7);
            if (r14 == null) goto L22;
            String r12 = r14.getString(2131900400);
        L23:
            if (r12 != null) goto L25;
            r12 = "";
        L25:
            if (r14 == null) goto L27;
            String r16 = r14.getString(2131900402, new Object[]{r8, r12});
        L28:
            String r19 = r8.concat("_android.permission.READ_EXTERNAL_STORAGE");
            if (i2.b.d("android.permission.READ_EXTERNAL_STORAGE") == true) goto L31;
        L33:
            boolean r20 = false;
        L34:
            if (r20 == false) goto L37;
            r11.invoke();
        L36:
            return true;
        L37:
            CommonDialog.a r110 = new CommonDialog.a();
            if (r16 == null) goto L41;
            r5 = r16;
        L41:
            Intrinsics.checkNotNullParameter(r5, "message");
            r110.i = r5;
            c0 r21 = new c0(r9, r7, r19, r11, r15);
            if (r14 == null) goto L44;
            String r22 = r14.getString(2131900963);
        L45:
            CommonDialog.a.f(r110, r21, r22, false, 12);
            d0 r23 = new d0(r7, r19, r15);
            if (r14 == null) goto L48;
            String r24 = r14.getString(2131910879);
        L49:
            CommonDialog.a.e(r110, r23, r24, 4);
            CommonDialog r25 = r110.a();
            LandscapeRestrictionOperation r26 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r25, null, r26);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r25, r26) == true) goto L36;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56
        L53:
            r25.show(r13, null);
            goto L36
        L48:
            r24 = null;
            goto L49
        L44:
            r22 = null;
            goto L45
        L31:
            if (Intrinsics.areEqual(((LinkedHashMap) r7.b).get(r19), Boolean.TRUE) == false) goto L33;
            r20 = true;
            goto L34
        L27:
            r16 = null;
            goto L28
        L22:
            r12 = null;
            goto L23
        L54:
            r7.a(true, true, false, true);
            return true;
        L10:
            r4 = null;
            goto L11
        }

        public final void i(WebView r4, int r5) {
            FLogger.a.i("WebFragment", "onProgressChanged newProgress:" + r5);
            WebFragment r6 = this.b;
            HashMap<String, String> r0 = WebFragment.K;
            r6.ja0();
            if (r5 != 100) goto L24;
            LarusSearchWebBrowserBinding r7 = this.b.f;
            if (r7 == null) goto L9;
            ProgressBar r8 = r7.n;
            if (r8 == null) goto L9;
            r8.setVisibility(4);
        L9:
            LarusSearchWebBrowserBinding r9 = this.b.f;
            if (r9 == null) goto L14;
            ProgressBar r10 = r9.n;
            if (r10 == null) goto L14;
            r10.setProgress(0);
        L14:
            LarusSearchWebBrowserBinding r11 = this.b.f;
            if (r11 == null) goto L19;
            ProgressBar r12 = r11.i;
            if (r12 == null) goto L19;
            r12.setVisibility(4);
        L19:
            LarusSearchWebBrowserBinding r13 = this.b.f;
            if (r13 == null) goto L71;
            ProgressBar r14 = r13.i;
            if (r14 == null) goto L72;
            r14.setProgress(0);
            return;
        L72:
            return;
        L71:
            return;
        L24:
            WebFragment r15 = this.b;
            if (r15.u == false) goto L31;
            LarusSearchWebBrowserBinding r16 = r15.f;
            if (r16 == null) goto L36;
            ProgressBar r17 = r16.n;
            if (r17 == null) goto L36;
            r17.setVisibility(0);
        L36:
            WebFragment r18 = this.b;
            if (r18.v == false) goto L43;
            LarusSearchWebBrowserBinding r19 = r18.f;
            if (r19 == null) goto L49;
            ProgressBar r20 = r19.i;
            if (r20 == null) goto L49;
            r20.setVisibility(0);
        L49:
            if (Build.VERSION.SDK_INT < 24) goto L60;
            LarusSearchWebBrowserBinding r21 = this.b.f;
            if (r21 == null) goto L55;
            ProgressBar r22 = r21.n;
            if (r22 == null) goto L55;
            r22.setProgress(r5, true);
        L55:
            LarusSearchWebBrowserBinding r23 = this.b.f;
            if (r23 == null) goto L74;
            ProgressBar r24 = r23.i;
            if (r24 == null) goto L75;
            r24.setProgress(r5, true);
            return;
        L75:
            return;
        L74:
            return;
        L60:
            LarusSearchWebBrowserBinding r25 = this.b.f;
            if (r25 == null) goto L65;
            ProgressBar r26 = r25.n;
            if (r26 == null) goto L65;
            r26.setProgress(r5);
        L65:
            LarusSearchWebBrowserBinding r27 = this.b.f;
            if (r27 == null) goto L77;
            ProgressBar r28 = r27.i;
            if (r28 == null) goto L78;
            r28.setProgress(r5);
            return;
        L78:
            return;
        L77:
            return;
        L43:
            LarusSearchWebBrowserBinding r29 = r18.f;
            if (r29 == null) goto L49;
            ProgressBar r30 = r29.i;
            if (r30 == null) goto L49;
            r30.setVisibility(8);
            goto L49
        L31:
            LarusSearchWebBrowserBinding r31 = r15.f;
            if (r31 == null) goto L36;
            ProgressBar r32 = r31.n;
            if (r32 == null) goto L36;
            r32.setVisibility(8);
            goto L36
        }

        public final boolean j(WebView r5, com.ivy.ivykit.plugin.impl.web.c r6) {
            if (r6 != null) goto L5;
        L7:
            boolean r7 = false;
        L8:
            if (r7 == false) goto L10;
            String r8 = "crashed";
        L11:
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("Render process ");
            r2.append(r8);
            r2.append(". WebView URL: ");
            if (r5 == null) goto L14;
            String r9 = r5.getUrl();
        L15:
            r2.append(r9);
            r1.e("WebFragment", r2.toString());
            return true;
        L14:
            r9 = null;
            goto L15
        L10:
            r8 = "killed by system";
            goto L11
        L5:
            if (r6.a() != true) goto L7;
            r7 = true;
            goto L8
        }

        public final void k(WebResourceRequest r8, WebResourceError r9) {
            JSONObject r0 = new JSONObject();
            if (Build.VERSION.SDK_INT < 23) goto L20;
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("onReceivedErrorV2 code:");
            CharSequence r5 = null;
            if (r9 == null) goto L7;
            Integer r6 = Integer.valueOf(r9.getErrorCode());
        L8:
            r2.append(r6);
            r2.append(" desc:");
            if (r9 == null) goto L11;
            CharSequence r7 = r9.getDescription();
        L12:
            r2.append(r7);
            r2.append(" url:");
            r2.append(this.b.g);
            r1.w("WebFragment", r2.toString());
            if (r9 == null) goto L15;
            Integer r3 = Integer.valueOf(r9.getErrorCode());
        L16:
            r0.put("error_code", r3);
            if (r9 == null) goto L19;
            r5 = r9.getDescription();
        L19:
            r0.put("error_desc", r5);
        L21:
            WebFragment r10 = this.b;
            HashMap<String, String> r4 = WebFragment.K;
            r10.ia0();
            if (r8 == null) goto L26;
            boolean r11 = true;
            if (r8.isForMainFrame() != true) goto L26;
        L27:
            if (r11 == false) goto L30;
            WebFragment.U90(this.b, "onReceivedErrorV2", r0);
            return;
        L30:
            return;
        L26:
            r11 = false;
            goto L27
        L15:
            r3 = null;
            goto L16
        L11:
            r7 = null;
            goto L12
        L7:
            r6 = null;
            goto L8
        L20:
            FLogger.a.w("WebFragment", "onReceivedErrorV2 " + r9 + " url:" + this.b.g);
            goto L21
        }

        public final void onPageFinished(WebView r3, String r4) {
            FLogger.a.i("WebFragment", "onPageFinished url:" + r4);
            WebFragment r5 = this.b;
            HashMap<String, String> r0 = WebFragment.K;
            r5.ja0();
            LarusSearchWebBrowserBinding r6 = this.b.f;
            if (r6 == null) goto L7;
            ProgressBar r7 = r6.n;
            if (r7 == null) goto L7;
            r7.setVisibility(4);
        L7:
            e1 r8 = this.b.j;
            if (r8 == null) goto L10;
            r8.b("load");
        L10:
            e1 r9 = this.b.j;
            if (r9 == null) goto L13;
            r9.a(1);
        L13:
            HybridEventParams r10 = this.b.r;
            if (r10 == null) goto L16;
            boolean r11 = Intrinsics.areEqual(r10.e, Boolean.TRUE);
        L17:
            if (r11 == false) goto L22;
            int r12 = vs9.a.a;
            vs9.a.b(r4, true, this.b.r);
            HybridEventParams r13 = this.b.r;
            if (r13 == null) goto L23;
            r13.e = Boolean.FALSE;
            return;
        L23:
            return;
        L22:
            return;
        L16:
            r11 = false;
            goto L17
        }

        public final void onReceivedTitle(WebView r5, String r6) {
            String r0 = this.b.h;
            FLogger.a.i("WebFragment", "onReceivedTitle title:" + r6 + ", schemeTitle: " + r0);
            LarusSearchWebBrowserBinding r7 = this.b.f;
            if (r7 == null) goto L17;
            TextView r8 = r7.q;
            if (r8 == null) goto L18;
            if (r0 != null) goto L15;
            if (r5 == null) goto L10;
            String r9 = r5.getTitle();
        L11:
            r0 = r9;
            if (r0 != null) goto L15;
            r0 = "";
            goto L15
        L10:
            r9 = null;
        L15:
            r8.setText(r0);
            return;
        L18:
            return;
        }

        public final boolean shouldOverrideUrlLoading(WebView r11, String r12) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(r11, true);
            WebFragment r13 = this.b;
            HashMap<String, String> r2 = WebFragment.K;
            if (r12 == null) goto L7;
            r13.getClass();
            if (StringsKt.startsWith(r12, "https://", true) == false) goto L7;
            String r4 = r12;
        L8:
            Bundle r5 = r13.getArguments();
            if (r5 != null) goto L11;
        L13:
            boolean r6 = false;
        L14:
            z2 r7 = z2.a;
            if (r7.getLarkBitableConfig().b() == false) goto L27;
            if (r6 == true) goto L27;
            if (r4 == null) goto L27;
            IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r8 == null) goto L23;
            r8.D();
            if (x1.a.j(r4) != true) goto L23;
            boolean r9 = true;
        L24:
            if (r9 == false) goto L27;
            com.bytedance.router.i r14 = SmartRouter.buildRoute(r13.getContext(), "//flow/webview");
            Bundle r10 = new Bundle();
            r10.putString("link_url", r4);
            r14.c.putExtras(r10);
            r14.d();
            boolean r15 = true;
        L28:
            if (r15 == false) goto L30;
            return true;
        L30:
            Intrinsics.checkNotNull(r12);
            if (StringsKt.startsWith$default(r12, "http", false, 2, null) == false) goto L51;
            return false;
        L51:
            Uri r16 = UriProtector.parse(r12);     // Catch: Exception -> L47
            FLogger.a.i("WebFragment", "shouldOverrideUrlLoading http url:" + r12 + ", host = " + this.b.getHost());     // Catch: Exception -> L47
            int r17 = com.larus.utils.k0.a;     // Catch: Exception -> L47
            if (Intrinsics.areEqual("//flow/open_browser", com.larus.utils.k0.a(r16.toString())) == false) goto L37;
            SmartRouter.buildRoute(this.b.getContext(), r16.toString()).d();     // Catch: Exception -> L47
        L49:
            return true;
        L37:
            if (StringsKt.startsWith$default(r12, "intent", false, 2, null) == false) goto L45;
            Intent r18 = Intent.parseUri(r12, 1);     // Catch: Exception -> L47
            r18.setFlags(r18.getFlags() & (-196));     // Catch: Exception -> L47
            WebFragment r3 = this.b;     // Catch: Exception -> L47
            Intrinsics.checkNotNull(r18);     // Catch: Exception -> L47
            r3.getClass();     // Catch: Exception -> L47
            if (Intrinsics.areEqual(r18.getAction(), "android.intent.action.VIEW") == true) goto L41;
            boolean r19 = false;
        L42:
            if (r19 == false) goto L44;
            this.b.requireActivity().startActivity(r18);     // Catch: Exception -> L47
            goto L49
        L44:
            return false;
        L41:
            r19 = CollectionsKt.contains(r7.f3(), r18.getPackage());     // Catch: Exception -> L47
            goto L42
        L45:
            Intent r20 = new Intent("android.intent.action.VIEW", r16);     // Catch: Exception -> L47
            r20.setFlags(805306368);     // Catch: Exception -> L47
            this.b.requireActivity().startActivity(r20);     // Catch: Exception -> L47
        L47:
            e = move-exception;
            FLogger.a.w("WebFragment", "shouldOverrideUrlLoading http url:" + r12, e);
        L23:
            r9 = false;
        L27:
            r15 = false;
            goto L28
        L11:
            if (r5.getBoolean("bundle_skip_office_sdk_route", false) != true) goto L13;
            r6 = true;
        L7:
            r4 = null;
            goto L8
        }

        public final void a(int r4, String r5, String r6) {
            FLogger.a.w("WebFragment", "onReceivedErrorV1 code:" + r4 + " desc:" + r5 + " url:" + r6);
            if (Intrinsics.areEqual(r6, this.a) == false) goto L6;
            WebFragment r7 = this.b;
            JSONObject r0 = new JSONObject();
            r0.put("error_code", r4);
            r0.put("error_desc", r5);
            Unit r8 = Unit.INSTANCE;
            WebFragment.U90(r7, "onReceivedErrorV1", r0);
            return;
        }
    }

    public static final class f extends ix7.d.a {
        public final /* synthetic */ WebFragment a;

        public f(WebFragment r1) {
            this.a = r1;
        }

        public final void d(View r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r10, "view");
            if ((r10 instanceof WebView) == true) goto L6;
            r10 = null;
        L6:
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.webkit.WebView");
            WebView r11 = (WebView) r10;
            final WebFragment r0 = this.a;
            zt8.c r2 = r0.A;
            if (r2 == null) goto L9;
            r2.c(r11);
        L9:
            boolean r3 = StringsKt.equals(UriProtector.parse(r0.g).getScheme(), "file", true);
            boolean r4 = StringsKt.equals(UriProtector.parse(r0.g).getScheme(), "content", true);
            r11.getSettings().setAllowFileAccess(true);
            WebSettings r5 = r11.getSettings();
            boolean r6 = false;
            if (r3 == true) goto L13;
            if (r4 == true) goto L13;
            boolean r7 = true;
        L14:
            r5.setJavaScriptEnabled(r7);
            WebSettings r8 = r11.getSettings();
            String r9 = r0.g;
            if (r9 == null) goto L32;
            Uri r12 = UriProtector.parse(r9);
            if (r12 == null) goto L32;
            String r13 = r12.getHost();
            if (r13 == null) goto L32;
            Function0 r14 = SearchServiceImpl.a.b;
            if (r14 == null) goto L32;
            List r15 = (List) r14.invoke();
            if (r15 == null) goto L32;
            Iterator r16 = r15.iterator();
        L28:
            if (r16.hasNext() == false) goto L32;
            if (StringsKt.contains$default(r13, (String) r16.next(), false, 2, null) == false) goto L28;
            r6 = true;
        L32:
            r8.setDomStorageEnabled(r6);
            if ((r0.getResources().getConfiguration().uiMode & 48) != 32) goto L35;
            String r17 = "dark";
        L36:
            WebSettings r18 = r11.getSettings();
            r18.setUserAgentString(r18.getUserAgentString() + ";AppTheme/" + r17);
            AppHost.Companion r19 = AppHost.a;
            if (r19.isOversea() == true) goto L39;
            WebSettings r20 = r11.getSettings();
            r20.setUserAgentString(r20.getUserAgentString() + ";doubao");
        L41:
            if (r19.isOversea() == true) goto L43;
            String r21 = "doubao";
        L44:
            WebSettings r22 = r11.getSettings();
            r22.setUserAgentString(r22.getUserAgentString() + ";AppName/" + r21);
            r11.getSettings().setMixedContentMode(2);
            r11.getSettings().setTextZoom(100);
            r11.getSettings().setDisplayZoomControls(z2.a.J0());
            int r23 = Build.VERSION.SDK_INT;
            if (r23 != 24) goto L47;
        L48:
            r11.setLayerType(1, null);
        L49:
            r11.setDownloadListener(new b1(r0));
            return;
        L47:
            if (r23 != 25) goto L49;
        L43:
            r21 = "Dola";
            goto L44
        L39:
            WebSettings r24 = r11.getSettings();
            r24.setUserAgentString(r24.getUserAgentString() + ";cici");
            goto L41
        L35:
            r17 = "light";
        L13:
            r7 = false;
            goto L14
        }
    }

    public static final class g implements ix7.h {
        public final /* synthetic */ WebFragment a;

        public g(WebFragment r1) {
            this.a = r1;
        }

        public final void a(int r2, int r3, boolean r4, boolean r5) {
            zt8.c r0 = this.a.A;
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4, r5);
            return;
        }

        public final void onScrollChanged(int r2, int r3, int r4, int r5) {
            zt8.c r0 = this.a.A;
            if (r0 == null) goto L6;
            r0.onScrollChanged(r2, r3, r4, r5);
            return;
        }

        public final void b(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, boolean r20) {
            zt8.c r2 = this.a.A;
            if (r2 == null) goto L6;
            r2.b(r12, r13, r14, r15, r16, r17, r18, r19);
            return;
        }
    }

    static {
        K = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO"), TuplesKt.to("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA")});
    }

    public final void W90() {
        int r0 = vs9.a.a;
        String r1 = this.g;
        HybridEventParams r2 = this.r;
        by7.a r3 = new by7.a("webview_backward_click");
        JSONObject r4 = new JSONObject();
        r4.put("url", r1);
        r4.put("is_ttwebview", vs9.a.a());
        if (r2 == null) goto L5;
        r4.put("enter_method", r2.a);
        r4.put("local_page", r2.b);
        r4.put("chat_type", r2.c);
        r4.put("webview_type", "self_webview");
    L5:
        TrackParams r5 = new TrackParams().merge(r4);
        r3.a.merge(r5);
        r3.b();
        kx7.c r6 = this.l;
        if (r6 == null) goto L8;
        boolean r7 = r6.a();
    L9:
        if (r7 == false) goto L15;
        kx7.c r8 = this.l;
        if (r8 == null) goto L13;
        r8.c();
    L13:
        ia0();
        return;
    L15:
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L19;
        r9.finish();
        return;
    L19:
        return;
    L8:
        r7 = false;
        goto L9
    }

    public final void Y90() {
        LarusSearchWebBrowserBinding r0 = this.f;     // Catch: Exception -> L28
        if (r0 == null) goto L33;
        PluginWebView r1 = this.l;     // Catch: Exception -> L28
        if (r1 == null) goto L7;
        r1.k();     // Catch: Exception -> L28
    L7:
        IIvyWebService.Companion r2 = IIvyWebService.a;     // Catch: Exception -> L28
        String r3 = this.e;     // Catch: Exception -> L28
        lx7.a r4 = this.k;     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L28
        kx7.c r5 = r2.b(r3, r4, ca0());     // Catch: Exception -> L28
        this.l = r5;     // Catch: Exception -> L28
        if (r5 == null) goto L12;
        View r6 = r5.f();     // Catch: Exception -> L28
        if (r6 == null) goto L12;
        r0.r.removeAllViews();     // Catch: Exception -> L28
        r0.r.addView(r6, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L28
        ka0();     // Catch: Exception -> L28
    L12:
        ga0(this.g);     // Catch: Exception -> L28
        if (Build.VERSION.SDK_INT < 23) goto L34;
        Bundle r7 = getArguments();     // Catch: Exception -> L28
        boolean r8 = false;
        if (r7 != null) goto L17;
    L19:
        if (r8 == false) goto L35;
        kx7.c r9 = this.l;     // Catch: Exception -> L28
        if (r9 == null) goto L36;
        WebView r10 = r9.j();     // Catch: Exception -> L28
        if (r10 == null) goto L37;
        WebSettings r11 = r10.getSettings();     // Catch: Exception -> L28
        if (r11 == null) goto L38;
        r11.setOffscreenPreRaster(true);     // Catch: Exception -> L28
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L17:
        if (r7.getBoolean("bundle_offscreen_pre_raster", false) != true) goto L19;
        r8 = true;
        goto L19
    L34:
        return;
    L33:
        return;
    L28:
        e = move-exception;
        FLogger.a.e("WebFragment", "createHybridKit: " + e);
    }

    public final void aa0() {
        FLogger.a.i("WebFragment", "click reload");     // Catch: Exception -> L26
        kx7.c r1 = this.l;     // Catch: Exception -> L26
        String r2 = null;
        if (r1 == null) goto L6;
        String r3 = r1.i();     // Catch: Exception -> L26
    L8:
        if (Intrinsics.areEqual(r3, this.g) == false) goto L10;
        Y90();     // Catch: Exception -> L26
    L24:
        ia0();     // Catch: Exception -> L26
        return;
    L10:
        kx7.c r4 = this.l;     // Catch: Exception -> L26
        if (r4 == null) goto L13;
        r2 = r4.i();     // Catch: Exception -> L26
    L13:
        if (r2 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        ga0(this.g);     // Catch: Exception -> L26
        goto L24
    L21:
        kx7.c r6 = this.l;     // Catch: Exception -> L26
        if (r6 == null) goto L24;
        r6.g();     // Catch: Exception -> L26
        goto L24
    L15:
        if (r2.length() == 0) goto L18;
        r5 = false;
        goto L19
    L6:
        r3 = null;
    L26:
        e = move-exception;
        FLogger.a.i("WebFragment", "click reload error: " + e);
    }

    public final Context ca0() {
        boolean r2 = false;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
        r2 = true;
        goto L12
    L7:
        if (r0.getBoolean("bundle_offscreen_pre_raster", false) != true) goto L9;
        r1 = true;
    L12:
        if (r2 == false) goto L19;
        MutableContextWrapper r3 = this.J;
        if (r3 != null) goto L20;
        MutableContextWrapper r4 = new MutableContextWrapper(AppHost.a.getApplication());
        this.J = r4;
        return r4;
    L20:
        return r3;
    L19:
        return requireContext();
    }

    public final void ja0() {
        LarusSearchWebBrowserBinding r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        Bundle r1 = getArguments();
        if (r1 == null) goto L8;
        String r2 = r1.getString("show_closeall");
    L9:
        int r3 = 0;
        if (Intrinsics.areEqual(r2, "1") == true) goto L12;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L24;
        int r5 = 0;
    L26:
        if (r0.f.getVisibility() != r5) goto L28;
        return;
    L28:
        r0.f.setVisibility(r5);
        ViewGroup.LayoutParams r6 = r0.c.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        int r8 = r7.getMarginStart() + r7.width;
        if (r4 == false) goto L31;
        r3 = r0.f.getLayoutParams().width;
    L31:
        int r9 = r8 + r3;
        TextView r10 = r0.q;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L36;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        r12.setMarginStart(r9);
        r12.setMarginEnd(r9);
        r10.setLayoutParams(r12);
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L24:
        r5 = 8;
        goto L26
    L12:
        if (ba0() == true) goto L21;
        kx7.c r13 = this.l;
        r4 = true;
        if (r13 != null) goto L16;
    L18:
        boolean r14 = false;
    L19:
        if (r14 == false) goto L21;
    L16:
        if (r13.a() != true) goto L18;
        r14 = true;
        goto L19
    L8:
        r2 = null;
        goto L9
    }

    public WebFragment() {
        this.d = LazyKt.lazy(new s0());
        this.e = "aweme://webview/?url=";
        this.g = "";
        this.j = com.larus.platform.service.g.a.h("WebFragment");
        this.u = true;
        this.B = new LinkedHashMap();
        this.I = LazyKt.lazy(new t0());
    }

    public final boolean ba0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("enable_bottom_share_style");
    L7:
        return Intrinsics.areEqual(r1, "1");
    L5:
        r1 = null;
        goto L7
    }

    public final void ia0() {
        if (ba0() == true) goto L6;
        return;
    L6:
        if (this.w == false) goto L8;
        return;
    L8:
        kx7.c r0 = this.l;
        Boolean r1 = null;
        if (r0 == null) goto L11;
        Boolean r2 = Boolean.valueOf(r0.a());
    L12:
        kx7.c r3 = this.l;
        if (r3 == null) goto L17;
        WebView r4 = r3.j();
        if (r4 == null) goto L17;
        r1 = Boolean.valueOf(r4.canGoForward());
    L17:
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r5) == false) goto L29;
        LarusSearchWebBrowserBinding r6 = this.f;
        if (r6 == null) goto L24;
        ImageView r7 = r6.d;
        if (r7 == null) goto L24;
        r7.setClickable(true);
    L24:
        LarusSearchWebBrowserBinding r8 = this.f;
        if (r8 == null) goto L40;
        ImageView r9 = r8.d;
        if (r9 == null) goto L40;
        r9.setImageResource(2131242344);
    L40:
        if (Intrinsics.areEqual(r1, r5) == false) goto L51;
        LarusSearchWebBrowserBinding r10 = this.f;
        if (r10 == null) goto L46;
        ImageView r11 = r10.e;
        if (r11 == null) goto L46;
        r11.setClickable(true);
    L46:
        LarusSearchWebBrowserBinding r12 = this.f;
        if (r12 == null) goto L62;
        ImageView r13 = r12.e;
        if (r13 == null) goto L62;
        r13.setImageResource(2131242346);
    L62:
        if (Intrinsics.areEqual(r1, r5) == false) goto L64;
    L71:
        LarusSearchWebBrowserBinding r14 = this.f;
        if (r14 == null) goto L80;
        LinearLayout r15 = r14.b;
        if (r15 == null) goto L81;
        r15.setVisibility(0);
        return;
    L81:
        return;
    L80:
        return;
    L64:
        if (Intrinsics.areEqual(r2, r5) == true) goto L71;
        LarusSearchWebBrowserBinding r16 = this.f;
        if (r16 == null) goto L77;
        LinearLayout r17 = r16.b;
        if (r17 == null) goto L78;
        r17.setVisibility(8);
        return;
    L78:
        return;
    L77:
        return;
    L51:
        LarusSearchWebBrowserBinding r18 = this.f;
        if (r18 == null) goto L56;
        ImageView r19 = r18.e;
        if (r19 == null) goto L56;
        r19.setClickable(false);
    L56:
        LarusSearchWebBrowserBinding r20 = this.f;
        if (r20 == null) goto L62;
        ImageView r21 = r20.e;
        if (r21 == null) goto L62;
        r21.setImageResource(2131242347);
        goto L62
    L29:
        LarusSearchWebBrowserBinding r22 = this.f;
        if (r22 == null) goto L34;
        ImageView r23 = r22.d;
        if (r23 == null) goto L34;
        r23.setClickable(false);
    L34:
        LarusSearchWebBrowserBinding r24 = this.f;
        if (r24 == null) goto L40;
        ImageView r25 = r24.d;
        if (r25 == null) goto L40;
        r25.setImageResource(2131242345);
        goto L40
    L11:
        r2 = null;
        goto L12
    }

    public final void ka0() {
        Bundle r1 = getArguments();     // Catch: Exception -> L18
        Integer r2 = null;
        if (r1 != null) goto L6;
    L11:
        if (r2 == null) goto L23;
        kx7.c r0 = this.l;     // Catch: Exception -> L18
        if (r0 == null) goto L24;
        BulletContainerView r3 = r0.f();     // Catch: Exception -> L18
        if (r3 == null) goto L25;
        r3.setBackgroundColor(r2.intValue());     // Catch: Exception -> L18
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L6:
        if (r1.containsKey("web_view_bg_color") == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        r2 = Integer.valueOf(r1.getInt("web_view_bg_color"));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        FLogger.a.e("WebFragment", "fail to setWebViewBgColor " + ExceptionsKt.stackTraceToString(e));
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.C = null;
        da0(false);
        com.larus.platform.service.g.a.g("WebFragment");
        FLogger.a.i("WebFragment", "onDestroy");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.G == false) goto L7;
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L7;
        r0.D();
        x1.a.o(this.g);
    L7:
        PluginWebView r1 = this.l;
        if (r1 == null) goto L10;
        r1.k();
    L10:
        LarusSearchWebBrowserBinding r2 = this.f;
        if (r2 == null) goto L15;
        ImageView r3 = r2.g;
        if (r3 == null) goto L15;
        int r4 = ys9.b.a;
        Intrinsics.checkNotNullParameter(r3, "host");
        com.larus.utils.l.d(r3, "ext_balloon_pop");
    L15:
        HybridEventParams r5 = null;
        this.f = null;
        FLogger.a.i("WebFragment", "onDestroyView");
        int r6 = vs9.a.a;
        String r7 = this.g;
        HybridEventParams r8 = this.r;
        if (r8 == null) goto L18;
        r8.d = Long.valueOf(System.currentTimeMillis() - this.s);
        Unit r9 = Unit.INSTANCE;
        r5 = r8;
    L18:
        by7.a r10 = new by7.a("leave_webviewcontainer");
        JSONObject r11 = new JSONObject();
        r11.put("url", r7);
        r11.put("is_ttwebview", vs9.a.a());
        if (r5 == null) goto L27;
        Map<String, String> r12 = r5.f;
        if (r12 == null) goto L26;
        Iterator<String> r13 = r12.keySet().iterator();
    L24:
        if (r13.hasNext() == false) goto L26;
        String r14 = r13.next();
        r11.put(r14, r12.get(r14));
    L26:
        r11.put("enter_method", r5.a);
        r11.put("local_page", r5.b);
        r11.put("chat_type", r5.c);
        r11.put("webview_type", "self_webview");
        r11.put("duration", r5.d);
    L27:
        TrackParams r15 = new TrackParams().merge(r11);
        r10.a.merge(r15);
        r10.b();
    }

    public final void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Bundle r0 = getArguments();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L12;
        FLogger.a.i("WebFragment", "onPause: called, offscreenPreRaster is true");
        return;
    L7:
        if (r0.getBoolean("bundle_offscreen_pre_raster", false) != true) goto L9;
        r1 = true;
    L12:
        PluginWebView r2 = this.l;
        if (r2 == null) goto L17;
        com.bytedance.ies.bullet.service.base.o r3 = r2.b.getKitView();
        if (r3 == null) goto L17;
        r3.onHide();
    L17:
        FLogger.a.i("WebFragment", "onPause: called");
    }

    public final void onResume() {
        super.onResume();
        e1 r0 = this.j;
        if (r0 == null) goto L5;
        r0.b("create");
    L5:
        e1 r1 = this.j;
        if (r1 == null) goto L8;
        r1.c("load");
    L8:
        PluginWebView r2 = this.l;
        if (r2 == null) goto L13;
        com.bytedance.ies.bullet.service.base.o r3 = r2.b.getKitView();
        if (r3 == null) goto L13;
        r3.onShow();
    L13:
        FLogger.a.i("WebFragment", "onResume: called");
        ix7.a r4 = this.E;
        if (r4 != null) goto L16;
        return;
    L16:
        if (isAdded() == true) goto L18;
    L22:
        r4.a();
    L23:
        this.E = null;
        return;
    L18:
        if (getChildFragmentManager().isStateSaved() == true) goto L22;
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L22;
        Z90(r4);
        goto L23
    }

    @Override // com.larus.platform.model.webview.AbsWebFragment
    public final MutableContextWrapper S90() {
        return this.J;
    }

    public final Uri.Builder V90(Uri.Builder r3) {
        if (z2.a.webviewAddThemeQuery() == true) goto L5;
        return r3;
    L5:
        boolean r0 = v19.h.a;
        Context r1 = getContext();
        if (r1 != null) goto L9;
        r1 = AppHost.a.getApplication();
    L9:
        if (v19.h.b(r1) == false) goto L11;
        String r2 = "dark";
    L13:
        return r3.appendQueryParameter("theme", r2);
    L11:
        r2 = "light";
        goto L13
    }

    public final void Z90(ix7.a r20) {
        if (r20 == null) goto L14;
        String[] r3 = r20.getResources();
        if (r3 == null) goto L14;
        ArrayList r4 = new ArrayList();
        int r5 = r3.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L12;
        String r7 = K.get(r3[r6]);
        if (r7 == null) goto L11;
        r4.add(r7);
    L11:
        r6 = r6 + 1;
        goto L7
    L12:
        List r8 = CollectionsKt.toList(r4);
        if (r8 == null) goto L14;
    L15:
        List r9 = r8;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L16:
        String r12 = null;
        if (r11.hasNext() == false) goto L30;
        String r13 = (String) r11.next();
        if (Intrinsics.areEqual(r13, "android.permission.RECORD_AUDIO") == false) goto L24;
        Context r14 = getContext();
        if (r14 == null) goto L28;
        r12 = r14.getString(2131900401);
    L28:
        if (r12 == null) goto L16;
        r10.add(r12);
        goto L16
    L24:
        if (Intrinsics.areEqual(r13, "android.permission.CAMERA") == false) goto L28;
        Context r15 = getContext();
        if (r15 == null) goto L28;
        r12 = r15.getString(2131900399);
        goto L28
    L30:
        StringBuilder r16 = new StringBuilder();
        if (r20 == null) goto L35;
        Uri r17 = r20.getOrigin();
        if (r17 == null) goto L35;
        String r18 = com.larus.utils.y0.k(r17);
    L36:
        String r19 = "";
        if (r18 != null) goto L39;
        r18 = "";
    L39:
        r16.append(r18);
        if (r20 == null) goto L44;
        String[] r110 = r20.getResources();
        if (r110 == null) goto L44;
        String r21 = ArraysKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null);
    L45:
        r16.append(r21);
        String r22 = r16.toString();
        Iterator r23 = r9.iterator();
        boolean r111 = true;
    L47:
        if (r23.hasNext() == false) goto L51;
        if (i2.b.d((String) r23.next()) == true) goto L47;
        r111 = false;
        goto L47
    L51:
        if (r111 == true) goto L53;
    L55:
        boolean r24 = false;
    L56:
        if (r24 == false) goto L60;
        if (r20 == null) goto L106;
        r20.b(r20.getResources());
        return;
    L106:
        return;
    L60:
        Context r25 = getContext();
        if (r25 == null) goto L70;
        Object[] r112 = new Object[2];
        if (r20 == null) goto L65;
        Uri r113 = r20.getOrigin();
    L66:
        r112[0] = r113;
        String r26 = (String) CollectionsKt.getOrNull(r10, 0);
        if (r26 != null) goto L69;
        r26 = "";
    L69:
        r112[1] = r26;
        String r27 = r25.getString(2131900402, r112);
    L71:
        CommonDialog.a r28 = new CommonDialog.a();
        if (r27 == null) goto L75;
        r19 = r27;
    L75:
        Intrinsics.checkNotNullParameter(r19, "message");
        r28.i = r19;
        CommonDialog.a.f(r28, new b(this, r8, r22, r20), getString(2131900963), false, 12);
        CommonDialog.a.e(r28, new c(this, r22, r20), getString(2131910879), 4);
        CommonDialog r2 = r28.a();
        if (isAdded() == true) goto L78;
    L88:
        FLogger.a.w("WebFragment", "createRequestPermissionDialog: cannot show, postpone");
        this.E = r20;
        return;
    L78:
        if (getChildFragmentManager().isStateSaved() == true) goto L88;
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L88;
        FragmentManager r1 = getChildFragmentManager();
        LandscapeRestrictionOperation r29 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r29);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r2, r29) == true) goto L107;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L90
    L86:
        r2.show(r1, null);
        return;
    L107:
        return;
    L65:
        r113 = null;
        goto L66
    L70:
        r27 = null;
        goto L71
    L53:
        if (Intrinsics.areEqual(((LinkedHashMap) this.B).get(r22), Boolean.TRUE) == false) goto L55;
        r24 = true;
    L44:
        r21 = null;
    L35:
        r18 = null;
    L14:
        r8 = CollectionsKt.emptyList();
        goto L15
    }

    public final void da0(boolean r8) {
        if (this.t == false) goto L6;
        return;
    L6:
        if (r8 != this.n) goto L8;
        return;
    L8:
        this.n = r8;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L18;
        if (r8 == false) goto L12;
        this.q = Integer.valueOf(r0.getRequestedOrientation());
        r0.setRequestedOrientation(-1);
        goto L18
    L12:
        Integer r1 = this.q;
        if (r1 == null) goto L15;
        int r2 = r1.intValue();
    L16:
        r0.setRequestedOrientation(r2);
        this.q = null;
        goto L18
    L15:
        r2 = 3;
    L18:
        if (r8 == false) goto L41;
        if (Build.VERSION.SDK_INT < 30) goto L35;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L28;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L28;
        WindowInsetsController r5 = r4.getInsetsController();
        if (r5 == null) goto L28;
        r5.hide(WindowInsets.Type.statusBars());
    L28:
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L61;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L61;
        WindowInsetsController r9 = r7.getInsetsController();
        if (r9 == null) goto L61;
        r9.hide(WindowInsets.Type.navigationBars());
    L61:
        LarusSearchWebBrowserBinding r10 = this.f;
        if (r10 == null) goto L81;
        FrameLayout r11 = r10.a;
        if (r11 == null) goto L84;
        if (r8 == false) goto L68;
        this.p = r11.getPaddingBottom();
        this.o = r11.getPaddingTop();
    L68:
        int r12 = 0;
        if (r8 == false) goto L71;
        int r13 = 0;
    L72:
        if (r8 == true) goto L75;
        r12 = this.o;
    L75:
        LarusSearchWebBrowserBinding r14 = this.f;
        if (r14 == null) goto L82;
        FrameLayout r15 = r14.a;
        if (r15 == null) goto L83;
        int r16 = r15.getPaddingStart();
        int r17 = r15.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r15.getClass().getSimpleName() + ",source:handleFullScreen,start:" + r16 + ",top:" + r12 + ",end:" + r17 + ",bottom:" + r13);
        r15.setPaddingRelative(r16, r12, r17, r13);
        return;
    L83:
        return;
    L82:
        return;
    L71:
        r13 = this.p;
        goto L72
    L84:
        return;
    L81:
        return;
    L35:
        FragmentActivity r18 = getActivity();
        if (r18 == null) goto L61;
        Window r19 = r18.getWindow();
        if (r19 == null) goto L61;
        r19.addFlags(1024);
        goto L61
    L41:
        if (Build.VERSION.SDK_INT < 30) goto L56;
        FragmentActivity r20 = getActivity();
        if (r20 == null) goto L49;
        Window r21 = r20.getWindow();
        if (r21 == null) goto L49;
        WindowInsetsController r22 = r21.getInsetsController();
        if (r22 == null) goto L49;
        r22.show(WindowInsets.Type.statusBars());
    L49:
        FragmentActivity r23 = getActivity();
        if (r23 == null) goto L61;
        Window r24 = r23.getWindow();
        if (r24 == null) goto L61;
        WindowInsetsController r25 = r24.getInsetsController();
        if (r25 == null) goto L61;
        r25.show(WindowInsets.Type.navigationBars());
        goto L61
    L56:
        FragmentActivity r26 = getActivity();
        if (r26 == null) goto L61;
        Window r27 = r26.getWindow();
        if (r27 == null) goto L61;
        r27.clearFlags(1024);
        goto L61
    }

    public final void ea0(boolean r11) {
        if (this.t == false) goto L5;
        return;
    L5:
        LarusSearchWebBrowserBinding r0 = this.f;
        if (r0 == null) goto L30;
        LinearLayout r1 = r0.o;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isAttachedToWindow() == false) goto L27;
        WindowInsetsCompat r2 = ViewCompat.getRootWindowInsets(r1);
        if (r2 == null) goto L16;
        Insets r3 = r2.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r3 == null) goto L16;
        int r4 = r3.bottom;
    L17:
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(r1);
        if (r5 == null) goto L22;
        Insets r6 = r5.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r6 == null) goto L22;
        int r7 = r6.top;
    L24:
        if (r11 == false) goto L26;
        int r12 = r1.getPaddingStart();
        int r8 = r1.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:onWebViewCreated,start:" + r12 + ",top:0,end:" + r8 + ",bottom:" + r4);
        r1.setPaddingRelative(r12, 0, r8, r4);
    L28:
        ViewCompat.setOnApplyWindowInsetsListener(r1, new m0());
        ViewCompat.requestApplyInsets(r1);
        return;
    L26:
        int r13 = r1.getPaddingStart();
        int r9 = r1.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:onWebViewCreated,start:" + r13 + ",top:" + r7 + ",end:" + r9 + ",bottom:" + r4);
        r1.setPaddingRelative(r13, r7, r9, r4);
    L22:
        r7 = 0;
    L16:
        r4 = 0;
        goto L17
    L27:
        r1.addOnAttachStateChangeListener(new d(r1, r1, r11));
        goto L28
    }

    public final void ga0(String r13) {
        if (this.x == false) goto L23;
        if (r13 == null) goto L28;
        boolean r0 = !ha0(r13);
        String r14 = URLEncoder.encode(r13);
        String r1 = "";
        if (r0 == true) goto L8;
        String r2 = "";
    L9:
        SchemaSuffixMap r3 = this.y;
        if (r3 == null) goto L12;
        Map<String, String> r4 = r3.getMap();
    L13:
        if (r4 == null) goto L20;
        Set<Map.Entry<String, String>> r5 = r4.entrySet();
        if (r5 == null) goto L20;
        String r6 = CollectionsKt.joinToString$default(r5, "", null, null, 0, null, new l0(), 30, null);
        if (r6 == null) goto L20;
        r1 = r6;
    L20:
        String r15 = "aweme://webview/?url=" + r14 + "&use_xbridge3=true&need_sec_link=1&sec_link_scene=im" + r2 + r1;
        kx7.c r7 = this.l;
        if (r7 == null) goto L29;
        r7.d(r15);
        return;
    L29:
        return;
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = "&loader_name=forest";
        goto L9
    L28:
        return;
    L23:
        if (r13 == null) goto L31;
        kx7.c r8 = this.l;
        if (r8 == null) goto L32;
        r8.e(r13, !ha0(r13));
        return;
    L32:
        return;
    }

    public final boolean ha0(String r15) {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        ArrayList r2 = new ArrayList();
        r2.addAll(z2.a.F0());
        int r3 = gv8.a.a;
        r2.addAll(CollectionsKt.listOf(new String[]{"www.douyin.com/video", "dcdapp.com", "doubao.com", "y.qq.com", "music.163.com", "piao.cn", "taopiaopiao.com", "taobao.com", "uri.amap.com", "jd.com"}));
        if (r2.isEmpty() == false) goto L13;
        return false;
    L13:
        Iterator r4 = r2.iterator();
    L15:
        if (r4.hasNext() == false) goto L19;
        if (StringsKt.contains$default(r15, (String) r4.next(), false, 2, null) == false) goto L15;
        return true;
    L19:
        return false;
    L5:
        if (r0.getBoolean("bundle_disable_forest", false) != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean la0(String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (StringsKt.startsWith$default(r6, "http", false, 2, null) == true) goto L14;
        return false;
    L14:
        ts9.a r7 = SearchServiceImpl.a;
        List r8 = SearchServiceImpl.a.e;
        Uri r3 = UriProtector.parse(this.g);
        if (Intrinsics.areEqual(r3.getScheme(), "https") == true) goto L17;
    L19:
        return false;
    L17:
        if (CollectionsKt.contains(r8, r3.getHost()) == false) goto L19;
        return true;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.search.impl.q0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.search.impl.r0, java.lang.Object] */
    public final void onCreate(Bundle r13) {
        super.onCreate(r13);
        e1 r14 = this.j;
        if (r14 == null) goto L5;
        r14.startTrace();
    L5:
        e1 r15 = this.j;
        if (r15 == null) goto L8;
        r15.c("create");
    L8:
        com.larus.platform.service.g.a.e("WebFragment");
        IvyKitInitializer r16 = IvyKitInitializer.a;
        if (IvyKitInitializer.c() == true) goto L11;
        r16.b(AppHost.a.getApplication(), new z0());
    L11:
        final a0 r17 = (a0) this.d.getValue();
        final ?? r1 = new q0(this);
        final ?? r2 = new r0(this);
        r17.getClass();
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(r1, "onSuccess");
        Intrinsics.checkNotNullParameter(r2, "onFail");
        getLifecycle().addObserver(new LocalFileTaker$registerResultForMultiFile$1(r17, this, r1, r2));
        int r18 = ts9.b.a;
        String r19 = ts9.b.a(getArguments());
        if (r19 != null) goto L14;
        r19 = "";
    L14:
        this.g = r19;
        Bundle r110 = getArguments();
        boolean r3 = true;
        boolean r4 = false;
        if (r110 != null) goto L17;
    L19:
        boolean r111 = false;
    L20:
        if (r111 == false) goto L24;
        IFlowSdkDepend r112 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r112 == null) goto L24;
        r112.D();
        x1.a.b(this.g);
    L24:
        Bundle r113 = getArguments();
        if (r113 != null) goto L27;
    L29:
        boolean r114 = false;
    L30:
        this.G = r114;
        if (r114 == false) goto L35;
        IFlowSdkDepend r115 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r115 == null) goto L35;
        r115.D();
        x1.a.n(this.g);
    L35:
        Bundle r116 = getArguments();
        HybridEventParams r5 = null;
        if (r116 == null) goto L38;
        String r117 = r116.getString("use_anniex");
    L40:
        if (Intrinsics.areEqual(r117, "1") == true) goto L47;
        Bundle r118 = getArguments();
        if (r118 == null) goto L44;
        String r119 = r118.getString("mix_container_type");
    L46:
        if (Intrinsics.areEqual(r119, "anniex") == true) goto L47;
    L71:
        Bundle r120 = getArguments();
        if (r120 == null) goto L76;
        String r121 = r120.getString("is_not_full_page");
        if (r121 == null) goto L76;
        boolean r122 = Intrinsics.areEqual(r121, "1");
    L77:
        this.t = r122;
        Bundle r123 = getArguments();
        if (r123 == null) goto L82;
        String r124 = r123.getString("is_show_progress_bar");
        if (r124 == null) goto L82;
        boolean r125 = Intrinsics.areEqual(r124, "1");
    L83:
        this.u = r125;
        Bundle r126 = getArguments();
        if (r126 == null) goto L88;
        String r127 = r126.getString("is_show_center_progress_bar");
        if (r127 == null) goto L88;
        boolean r128 = Intrinsics.areEqual(r127, "1");
    L89:
        this.v = r128;
        Bundle r129 = getArguments();
        if (r129 == null) goto L94;
        String r130 = r129.getString("need_schema_premix");
        if (r130 == null) goto L94;
        boolean r131 = Intrinsics.areEqual(r130, "1");
    L95:
        this.x = r131;
        Bundle r132 = getArguments();
        if (r132 == null) goto L98;
        Serializable r133 = r132.getSerializable("schema_suffix_map");
    L100:
        if ((r133 instanceof SchemaSuffixMap) == false) goto L102;
        SchemaSuffixMap r134 = (SchemaSuffixMap) r133;
    L103:
        this.y = r134;
        Bundle r135 = getArguments();
        if (r135 == null) goto L108;
        String r136 = r135.getString("hide_go_forward_and_back");
        if (r136 == null) goto L108;
        r4 = Intrinsics.areEqual(r136, "1");
    L108:
        this.w = r4;
        Bundle r137 = getArguments();
        if (r137 == null) goto L111;
        r3 = r137.getBoolean("bundle_need_trace", true);
    L111:
        this.F = r3;
        int r138 = ts9.b.a;
        Bundle r139 = getArguments();
        if (r139 == null) goto L114;
        String r140 = r139.getString("title");
    L115:
        this.h = r140;
        Bundle r141 = getArguments();
        if (r141 == null) goto L118;
        r5 = (HybridEventParams) r141.getParcelable("hybrid_event_param");
    L118:
        this.r = r5;
        int r142 = vs9.a.a;
        String r143 = this.g;
        by7.a r6 = new by7.a("webview_show");
        JSONObject r7 = new JSONObject();
        r7.put("url", r143);
        r7.put("is_ttwebview", vs9.a.a());
        if (r5 == null) goto L127;
        Map<String, String> r144 = r5.f;
        if (r144 == null) goto L126;
        Iterator<String> r8 = r144.keySet().iterator();
    L124:
        if (r8.hasNext() == false) goto L126;
        String r9 = r8.next();
        r7.put(r9, r144.get(r9));
    L126:
        r7.put("enter_method", r5.a);
        r7.put("local_page", r5.b);
        r7.put("chat_type", r5.c);
        r7.put("webview_type", "self_webview");
    L127:
        r6.a.merge(new TrackParams().merge(r7));
        r6.b();
        this.s = System.currentTimeMillis();
        FLogger.a.i("WebFragment", "onCreate url:" + this.g);
        this.k = IIvyWebService.a.a(IIvyWebService.a, com.larus.ivykit.c.a(), this.e, new e(this), new f(this), null, new g(this), null, Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888), 336);
        return;
    L114:
        r140 = null;
        goto L115
    L102:
        r134 = null;
        goto L103
    L98:
        r133 = null;
    L94:
        r131 = false;
    L88:
        r128 = false;
    L82:
        r125 = true;
    L76:
        r122 = false;
        goto L77
    L44:
        r119 = null;
    L47:
        Uri.Builder r145 = UriProtector.parse(this.g).buildUpon();
        Bundle r10 = getArguments();
        if (r10 == null) goto L70;
        Set<String> r11 = r10.keySet();
        if (r11 == null) goto L70;
        ArrayList r12 = new ArrayList();
        Iterator<T> r20 = r11.iterator();
    L53:
        if (r20.hasNext() == false) goto L62;
        Object r21 = r20.next();
        String r22 = (String) r21;
        if (Intrinsics.areEqual(r22, "url") == false) goto L57;
    L59:
        boolean r23 = false;
    L60:
        if (r23 == false) goto L53;
        r12.add(r21);
        goto L53
    L57:
        if (Intrinsics.areEqual(r22, "link_url") == true) goto L59;
        r23 = true;
        goto L60
    L62:
        Iterator r24 = r12.iterator();
    L64:
        if (r24.hasNext() == false) goto L70;
        String r25 = (String) r24.next();
        Bundle r26 = getArguments();
        if (r26 == null) goto L68;
        Object r27 = r26.get(r25);
    L69:
        r145.appendQueryParameter(r25, String.valueOf(r27));
        goto L64
    L68:
        r27 = null;
    L70:
        this.g = r145.build().toString();
        goto L71
    L38:
        r117 = null;
        goto L40
    L27:
        if (r113.getBoolean("bundle_need_lark_auth_cookie_sync", false) != true) goto L29;
        r114 = true;
        goto L30
    L17:
        if (r110.getBoolean("bundle_clear_lark_auth_cookies_once", false) != true) goto L19;
        r111 = true;
        goto L20
    }

    public static void fa0(View r4, String r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L23;
        return;
    L23:
    L20:
        e = move-exception;
        FLogger.a.e("WebFragment", "Fail to set view color " + r5 + ": " + e.getMessage());
        return;
    L15:
        if (StringsKt.startsWith$default(r5, "#", false, 2, null) == false) goto L17;
        String r0 = r5;
    L18:
        r4.setBackgroundColor(Color.parseColor(r0));     // Catch: Exception -> L20
        return;
    L17:
        r0 = "#" + r5;     // Catch: Exception -> L20
        goto L18
    L7:
        if (r5.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.larus.platform.model.webview.AbsWebFragment
    public final void T90(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "params");
        kx7.c r0 = this.l;
        if (r0 == null) goto L6;
        r0.h(r2, r3);
        return;
    }

    public final boolean X90(String r2, Map<String, String> r3) {
        String r4 = r3.get("Referer");
        if (la0(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (la0(r4) == true) goto L8;
        return false;
    }

    public final void onViewCreated(View r94, Bundle r95) {
        Intrinsics.checkNotNullParameter(r94, "view");
        super.onViewCreated(r94, r95);
        LarusSearchWebBrowserBinding r4 = this.f;
        if (r4 == null) goto L99;
        Uri r5 = UriProtector.parse(this.g);
        String r6 = null;
        Bundle r7 = getArguments();     // Catch: Exception -> L12
        if (r7 == null) goto L10;
        String r8 = r7.getString("status_bar_bg_color");     // Catch: Exception -> L12
        if (r8 == null) goto L10;
    L13:
        fa0(r4.o, r8);
        String r9 = "0";
        if (AppHost.a.isOversea() == false) goto L22;
        if (this.t == true) goto L22;
        String r10 = UriProtector.getQueryParameter(r5, "trans_status_bar");     // Catch: Exception -> L102
        if (r10 == null) goto L19;
    L20:
        ea0(Intrinsics.areEqual(r10, "1"));
    L27:
        ConstraintLayout r11 = r4.p;
        Bundle r12 = getArguments();
        if (r12 == null) goto L30;
        String r13 = r12.getString("nav_bar_color");
    L31:
        fa0(r11, r13);
        String r14 = UriProtector.getQueryParameter(r5, "hide_title_bar");     // Catch: Exception -> L101
        if (r14 != null) goto L114;
        Bundle r15 = getArguments();     // Catch: Exception -> L101
        if (r15 == null) goto L38;
        r14 = r15.getString("hide_nav_bar", "0");     // Catch: Exception -> L101
    L39:
        if (r14 != null) goto L114;
    L38:
        r14 = null;
    L114:
        String r0 = UriProtector.getQueryParameter(r5, "hide_nav_bar");     // Catch: Exception -> L45
        if (r0 == null) goto L46;
        r9 = r0;
    L46:
        ConstraintLayout r1 = r4.p;
        if (Intrinsics.areEqual(r14, "1") == false) goto L49;
    L58:
        int r3 = 8;
    L59:
        r1.setVisibility(r3);
        ProgressBar r2 = r4.n;
        r2.setVisibility(0);
        r2.setMax(100);
        r2.setProgress(10);
        ProgressBar r16 = r4.i;
        r16.setVisibility(0);
        r16.setMax(100);
        r16.setProgress(10);
        final LarusSearchWebBrowserBinding r17 = this.f;
        if (r17 == null) goto L67;
        if (ba0() == false) goto L64;
        r17.c.setImageResource(2131242348);
        r17.c.setContentDescription(getString(2131898809));
        r17.c.setOnClickListener(new u0(this));
        r17.h.setVisibility(0);
    L65:
        r17.f.setOnClickListener(new w0(this));
        ja0();
        com.larus.utils.e1.d(r17.h, new x0(this));
        r17.g.setOnClickListener(new j0(this, r17));
        List r18 = CollectionsKt.listOf(new com.larus.bmhome.view.screenmenu.l0[]{new com.larus.bmhome.view.screenmenu.l0(2131911187, 2131911187, null, null, null, null, null, null, null, false, false, null, 2131242350, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127), new com.larus.bmhome.view.screenmenu.l0(2131911188, 2131911188, null, null, null, null, null, null, null, false, false, null, 2131242354, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127)});
        CommonMenu r19 = new CommonMenu(ca0());
        r19.g(r18, new k0(this));
        int r20 = ys9.b.a;
        this.i = ys9.b.a(r17.g, r19.i());
        goto L67
    L64:
        r17.c.setImageResource(2131242343);
        r17.c.setContentDescription(getString(2131898805));
        r17.c.setOnClickListener(new v0(this));
        r17.h.setVisibility(8);
    L67:
        if (this.w == true) goto L72;
        LarusSearchWebBrowserBinding r21 = this.f;
        if (r21 == null) goto L72;
        com.larus.utils.e1.d(r21.d, new i0(this));
        com.larus.utils.e1.d(r21.e, new p0(this));
        ia0();
    L72:
        Y90();
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L75
        Object r23 = Result.constructor-impl(UriProtector.getQueryParameter(r5, "container_bg_color"));     // Catch: Throwable -> L75
    L78:
        if (Result.isFailure-impl(r23) == false) goto L80;
        r23 = null;
    L80:
        String r24 = (String) r23;
        if (r24 != null) goto L86;
        Bundle r25 = getArguments();
        if (r25 == null) goto L85;
        r24 = r25.getString("container_bg_color");
        goto L86
    L85:
        r24 = null;
    L86:
        kx7.c r26 = this.l;
        if (r26 == null) goto L89;
        BulletContainerView r27 = r26.f();
    L90:
        fa0(r27, r24);
        FragmentActivity r28 = getActivity();
        if (r28 == null) goto L99;
        Bundle r29 = getArguments();
        if (r29 == null) goto L97;
        r6 = r29.getString("is_show_loading");
    L97:
        if (Intrinsics.areEqual(r6, "1") == false) goto L99;
        int r30 = CommonLoadDialogFragment.e;
        Bundle r31 = new Bundle();
        r31.putFloat("key_dim", 0.0f);
        CommonLoadDialogFragment r32 = new CommonLoadDialogFragment();
        r32.setArguments(r31);
        this.z = r32;
        r32.S90(r28);
        goto L99
    L89:
        r27 = null;
    L75:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L78
    L49:
        if (Intrinsics.areEqual(r9, "1") == true) goto L58;
        Bundle r34 = getArguments();
        if (r34 == null) goto L53;
        String r35 = r34.getString("hide_title_bar");
    L55:
        if (Intrinsics.areEqual(r35, "1") == true) goto L58;
        r3 = 0;
        goto L59
    L53:
        r35 = null;
    L40:
        r14 = "0";
        goto L114
    L30:
        r13 = null;
    L19:
        r10 = "0";
    L22:
        if (this.t == true) goto L27;
        String r36 = UriProtector.getQueryParameter(r5, "should_full_screen");     // Catch: Exception -> L103
        if (r36 == null) goto L25;
    L26:
        ea0(Intrinsics.areEqual(r36, "1"));
    L25:
        r36 = "0";
    L10:
        r8 = UriProtector.getQueryParameter(r5, "status_bar_bg_color");     // Catch: Exception -> L12
    L12:
        r8 = null;
    L99:
        FLogger.a.i("WebFragment", "onViewCreated load kitViewDelegate=" + this.l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static final void U90(final WebFragment r9, String r10, JSONObject r11) {
        r9.getClass();
        FLogger.a.i("WebFragment", "isForMainFrame = true, doWhenReceivedError");
        CommonLoadDialogFragment r0 = r9.z;
        if (r0 != null) goto L62;
    L10:
        LarusSearchWebBrowserBinding r1 = r9.f;
        if (r1 == null) goto L15;
        ProgressBar r2 = r1.n;
        if (r2 == null) goto L15;
        r2.setVisibility(4);
    L15:
        LarusSearchWebBrowserBinding r3 = r9.f;
        if (r3 == null) goto L20;
        ProgressBar r4 = r3.i;
        if (r4 == null) goto L20;
        r4.setVisibility(4);
    L20:
        Bundle r5 = r9.getArguments();
        if (r5 == null) goto L23;
        String r6 = r5.getString("enable_error_view");
    L24:
        ?? r7 = 0;
        if (Intrinsics.areEqual(r6, "1") == false) goto L41;
        LarusSearchWebBrowserBinding r8 = r9.f;
        if (r8 == null) goto L31;
        ConstraintLayout r12 = r8.l;
        if (r12 == null) goto L31;
        r12.setVisibility(0);
    L31:
        LarusSearchWebBrowserBinding r13 = r9.f;
        if (r13 == null) goto L36;
        TextView r14 = r13.k;
        if (r14 == null) goto L36;
        com.larus.utils.e1.d(r14, new n0(r9));
    L36:
        LarusSearchWebBrowserBinding r15 = r9.f;
        if (r15 == null) goto L41;
        TextView r16 = r15.m;
        if (r16 == null) goto L41;
        com.larus.utils.e1.d(r16, new o0(r9));
    L41:
        HybridEventParams r17 = r9.r;
        if (r17 == null) goto L44;
        boolean r18 = Intrinsics.areEqual(r17.e, Boolean.TRUE);
    L45:
        if (r18 == false) goto L50;
        int r19 = vs9.a.a;
        vs9.a.b(r9.g, false, r9.r);
        HybridEventParams r20 = r9.r;
        if (r20 == null) goto L50;
        r20.e = Boolean.FALSE;
    L50:
        if (r9.F == true) goto L52;
        return;
    L52:
        if (r9.H == true) goto L65;
        r9.H = true;
        IApplog.Companion r21 = IApplog.a;
        ?? r22 = new JSONObject();
        r22.put("url", r9.g);
        r22.put("scene", r10);
        r22.put("extra_info", r11);
        TTWebViewService r23 = (TTWebViewService) ServiceManager.get().getService(TTWebViewService.class);
        if (r23 == null) goto L56;
        ?? r24 = r23.a();
    L57:
        r22.put("is_ttwebview", r24);
        Unit r25 = Unit.INSTANCE;
        r21.reportEvent("web_received_error", r22);
        ?? r26 = new JSONObject();
        r26.put("url", r9.g);
        r26.put("scene", r10);
        r26.put("extra_info", r11);
        TTWebViewService r27 = (TTWebViewService) ServiceManager.get().getService(TTWebViewService.class);
        if (r27 == null) goto L60;
        r7 = r27.a();
    L60:
        r26.put("is_ttwebview", r7);
        ApmAgent.monitorEvent("web_received_error", r26, null, null);
        return;
    L56:
        r24 = 0;
        goto L57
    L65:
        return;
    L44:
        r18 = false;
        goto L45
    L23:
        r6 = null;
        goto L24
    L62:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r28 = DialogFragmentLancet.sLastShowStack;
        if (r28 == null) goto L10;
        com.bytedance.crash.d.d(r28, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final View onCreateView(LayoutInflater r24, ViewGroup r25, Bundle r26) {
        Intrinsics.checkNotNullParameter(r24, "inflater");
        if (r25 == null) goto L7;
        boolean r5 = true;
        if (ViewExtKt.h(r25) != true) goto L7;
    L8:
        if (r5 == false) goto L10;
        ViewExtKt.g(r25);
    L10:
        View r1 = r24.inflate(2131563118, r25, false);
        int r2 = 2131364399;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131364399);
        if (r6 == null) goto L52;
        r2 = 2131364650;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r1, 2131364650);
        if (r7 == null) goto L52;
        r2 = 2131364663;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r1, 2131364663);
        if (r8 == null) goto L52;
        r2 = 2131364664;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r1, 2131364664);
        if (r9 == null) goto L52;
        r2 = 2131364680;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r1, 2131364680);
        if (r10 == null) goto L52;
        r2 = 2131364767;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r1, 2131364767);
        if (r11 == null) goto L52;
        r2 = 2131364832;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r1, 2131364832);
        if (r12 == null) goto L52;
        r2 = 2131365422;
        ProgressBar r13 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131365422);
        if (r13 == null) goto L52;
        r2 = 2131369197;
        View r14 = ViewBindings.findChildViewById(r1, 2131369197);
        if (r14 == null) goto L52;
        r2 = 2131371751;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r1, 2131371751);
        if (r15 == null) goto L52;
        r2 = 2131371753;
        ConstraintLayout r16 = ViewBindings.findChildViewById(r1, 2131371753);
        if (r16 == null) goto L52;
        r2 = 2131371755;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131371755)) == null) goto L52;
        r2 = 2131371763;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r1, 2131371763);
        if (r17 == null) goto L52;
        r2 = 2131383297;
        ProgressBar r18 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131383297);
        if (r18 == null) goto L52;
        r2 = 2131384822;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131384822);
        if (r19 == null) goto L52;
        r2 = 2131388807;
        ConstraintLayout r20 = ViewBindings.findChildViewById(r1, 2131388807);
        if (r20 == null) goto L52;
        r2 = 2131391606;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r1, 2131391606);
        if (r21 == null) goto L52;
        r2 = 2131393131;
        LinearLayout r22 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131393131);
        if (r22 == null) goto L52;
        this.f = new LarusSearchWebBrowserBinding((FrameLayout) r1, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        FLogger.a.i("WebFragment", "onCreateView");
        LarusSearchWebBrowserBinding r3 = this.f;
        if (r3 != null) goto L53;
        return null;
    L53:
        return r3.a;
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    L7:
        r5 = false;
        goto L8
    }
}
