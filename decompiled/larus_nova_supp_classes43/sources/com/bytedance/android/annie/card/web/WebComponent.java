package com.bytedance.android.annie.card.web;

import a9.j;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.card.AnnieCard$getBaseLifecycle$1;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.card.web.resource.WebResourceProvider;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.param.k;
import com.bytedance.android.annie.resource.m;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.resource.o;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.service.prefetch.p;
import com.bytedance.android.annie.service.preload.PreLoadUtils;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.resource.h;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.common.util.HoneyCombV11Compat;
import com.bytedance.common.util.JellyBeanMR1V17Compat;
import com.bytedance.common.util.LollipopV21Compat;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f0;
import com.bytedance.ies.web.jsbridge2.l0;
import com.bytedance.ies.web.jsbridge2.u;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.services.IPiaLifeCycleService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o7.i;
import o7.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class WebComponent extends BaseHybridComponent implements HybridFragment.a {
    public static final Lazy<Boolean> y = null;
    public final Context a;
    public CardParamVoNew b;
    public final com.bytedance.android.annie.card.base.b c;
    public final j9.a d;
    public final com.bytedance.android.annie.param.a e;
    public final q7.b f;
    public final JSBridgeManager g;
    public final a h;
    public final AnnieWebChromeClient i;
    public boolean j;
    public boolean k;
    public final CopyOnWriteArrayList<com.bytedance.android.annie.card.web.e> l;
    public IHybridComponent.b m;
    public boolean n;
    public String o;
    public volatile Map<String, Object> p;
    public final Object q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public Map<String, ? extends Object> v;
    public InjectDataHolder w;
    public final com.bytedance.android.annie.pia.d x;

    public final class AnnieWebChromeClient extends WebChromeClient {
        public final UploadFileFragment a;
        public final /* synthetic */ WebComponent b;

        @Override // android.webkit.WebChromeClient
        public final Bitmap getDefaultVideoPoster() {
            CardParamVoNew r0 = this.b.b;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            if (r1 == false) goto L11;
            return Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
        L11:
            return super.getDefaultVideoPoster();
        L5:
            if (r0.F0() != true) goto L7;
            r1 = true;
            goto L7
        }

        @Override // android.webkit.WebChromeClient
        public final void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
            Iterator<T> r0 = this.b.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.annie.card.web.e) r0.next()).o();
            goto L4
        }

        @Override // android.webkit.WebChromeClient
        public final void onHideCustomView() {
            super.onHideCustomView();
            Iterator<T> r0 = this.b.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.annie.card.web.e) r0.next()).r();
            goto L4
        }

        public AnnieWebChromeClient(WebComponent r10) {
            this.b = r10;
            AppCompatActivity r0 = r10.a;
            if ((r0 instanceof AppCompatActivity) == false) goto L5;
            AppCompatActivity r1 = r0;
        L6:
            if (r1 == null) goto L13;
            UploadFileFragment r11 = new UploadFileFragment();
            Context r12 = r10.a;
            Intrinsics.checkNotNullParameter(r12, "context");
            r11.d = r12;
            FragmentTransaction r13 = r1.getSupportFragmentManager().beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r11, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "web_view_upload_file", 0) == true) goto L11;
            r13 = r13.add(r11, "web_view_upload_file");
        L11:
            r13.commitAllowingStateLoss();
            this.a = r11;
            return;
        L13:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // android.webkit.WebChromeClient
        public final void onGeolocationPermissionsShowPrompt(String r21, GeolocationPermissions.Callback r22) {
            ArrayList r10 = new ArrayList();
            Object[] r11 = {r21, r22};
            f06.b r13 = new f06.b();
            g06.a r12 = (g06.a) ApiHookConfig.b.get(100003);
            if (r12 == null) goto L5;
            f06.a[] r14 = r12.i;
        L6:
            f06.a[] r15 = r14;
            int r16 = r15.length;
            int r17 = 0;
        L8:
            if (r17 >= r16) goto L15;
            f06.a r18 = r15[r17];
            int r19 = r17;
            int r110 = r16;
            f06.a[] r111 = r15;
            f06.d r20 = r18.preInvoke(100003, "com/bytedance/android/annie/card/web/WebComponent$AnnieWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r11, "void", r13);     // Catch: Exception -> L24
            if (r20.a == true) goto L17;
            r10.add(r18);     // Catch: Exception -> L24
        L17:
            if (r20.a == false) goto L19;
            return;
        L19:
            super.onGeolocationPermissionsShowPrompt(r21, r22);
            Iterator<com.bytedance.android.annie.card.web.e> r23 = this.b.l.iterator();
        L21:
            if (r23.hasNext() == false) goto L23;
            r23.next().p(r21, r22);
            goto L21
        L23:
            return;
        L14:
            r17 = r19 + 1;
            r16 = r110;
            r15 = r111;
            goto L8
        L15:
            r20 = new f06.d(false, null);
            goto L17
        L5:
            r14 = ApiHookConfig.d;
            goto L6
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r10, int r11) {
            super.onProgressChanged(r10, r11);
            Iterator<T> r0 = this.b.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.annie.card.web.e) r0.next()).t(r10, r11);
            goto L4
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView r10, String r11) {
            super.onReceivedTitle(r10, r11);
            Iterator<com.bytedance.android.annie.card.web.e> r12 = this.b.l.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r12.next().x(r11);
            goto L4
        }

        @Override // android.webkit.WebChromeClient
        public final void onShowCustomView(View r10, WebChromeClient.CustomViewCallback r11) {
            super.onShowCustomView(r10, r11);
            Iterator<T> r0 = this.b.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.annie.card.web.e) r0.next()).z(r10, r11);
            goto L4
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView r18, final ValueCallback<Uri[]> r19, WebChromeClient.FileChooserParams r20) {
            boolean r0 = true;
            if (r20 == null) goto L76;
            UploadFileFragment r10 = this.a;
            if (r10 == null) goto L77;
            Function1 r11 = new WebComponent$AnnieWebChromeClient$onShowFileChooser$1$1(r19);
            String[] r12 = r20.getAcceptTypes();
            boolean r13 = r20.isCaptureEnabled();
            if (r20.getMode() != 1) goto L9;
            boolean r14 = true;
        L10:
            Intrinsics.checkNotNullParameter(r11, "chooseFileCallback");
            r10.f = r11;
            if (r12 == null) goto L65;
            Context r15 = null;
            if (r13 == false) goto L47;
            int r16 = r12.length;
            int r17 = 0;
        L15:
            if (r17 >= r16) goto L65;
            String r110 = r12[r17];
            if (StringsKt.startsWith$default(r110, "image", false, 2, null) == true) goto L18;
            if (StringsKt.startsWith$default(r110, "video", false, 2, null) == true) goto L42;
            if (StringsKt.startsWith$default(r110, "audio", false, 2, null) == true) goto L45;
            r17 = r17 + 1;
            goto L15
        L45:
            r10.U90("android.permission.RECORD_AUDIO", 2131897342, new Intent("android.provider.MediaStore.RECORD_SOUND"), 2131897338, r10.S90(false, false, true, r14));
            return true;
        L42:
            r10.U90("android.permission.CAMERA", 2131897344, new Intent("android.media.action.VIDEO_CAPTURE"), 2131897340, r10.S90(false, true, false, r14));
            return true;
        L18:
            Intent r21 = new Intent("android.media.action.IMAGE_CAPTURE");
            Context r22 = r10.d;
            if (r22 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            r22 = null;
        L21:
            PolarisFileWrapper r23 = r22.getExternalFilesDir(Environment.DIRECTORY_DCIM);
            if (r23 != null) goto L27;
            Context r111 = r10.d;
            if (r111 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            r111 = null;
        L26:
            r23 = new PolarisFileWrapper(r111.getFilesDir(), Environment.DIRECTORY_DCIM);
        L27:
            StringBuilder r112 = new StringBuilder();
            r112.append(r23.getAbsolutePath());
            String r24 = File.separator;
            r112.append(r24);
            r112.append("browser-photos");
            PolarisFileWrapper r113 = new PolarisFileWrapper(r112.toString());
            r113.mkdirs();
            String r25 = r113.getAbsolutePath() + r24 + System.currentTimeMillis() + ".jpg";
            r10.g = r25;
            Context r114 = r10.d;
            if (r114 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        L31:
            PolarisFileWrapper r26 = new PolarisFileWrapper(r25);
            if (r15 != null) goto L34;
        L38:
            Uri r27 = Uri.fromFile(r26);
        L39:
            r21.putExtra("output", r27);
            r10.U90("android.permission.CAMERA", 2131897343, r21, 2131897339, r10.S90(true, false, false, r14));
            return true;
        L34:
            if (Build.VERSION.SDK_INT < 24) goto L38;
            if (r15.getApplicationInfo().targetSdkVersion < 24) goto L38;
            r27 = FileProvider.getUriForFile(r15, r15.getPackageName() + ".fileprovider", r26);
            goto L39
        L30:
            r15 = r114;
            goto L31
        L47:
            int r28 = r12.length;
            int r115 = 0;
            boolean r116 = false;
            boolean r117 = false;
            boolean r118 = false;
        L48:
            if (r115 >= r28) goto L59;
            String r1 = r12[r115];
            if (StringsKt.startsWith$default(r1, "image", false, 2, null) == false) goto L53;
            r116 = true;
        L58:
            r115 = r115 + 1;
            goto L48
        L53:
            if (StringsKt.startsWith$default(r1, "video", false, 2, null) == false) goto L56;
            r117 = true;
            goto L58
        L56:
            if (StringsKt.startsWith$default(r1, "audio", false, 2, null) == false) goto L58;
            r118 = true;
            goto L58
        L59:
            if (r116 == true) goto L64;
            if (r117 == true) goto L64;
            if (r118 == true) goto L64;
            r0 = true;
        L64:
            r10.V90(r10.S90(r116, r117, r118, r14));
            return true;
        L65:
            r10.V90(r10.S90(r0, r0, r0, r14));
            return r0;
        L9:
            r14 = false;
            goto L10
        L77:
            return true;
        L76:
            return true;
        }
    }

    public final class a extends n56.b {
        public final /* synthetic */ WebComponent b;

        public final WebResourceResponse shouldInterceptRequest(WebView r1, String r10) {
            return null;
        }

        public a(WebComponent r1) {
            this.b = r1;
        }

        public void onLoadResource(WebView r1, String r10) {
            super.onLoadResource(r1, r10);
            Iterator<T> r11 = this.b.l.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((com.bytedance.android.annie.card.web.e) r11.next()).getClass();
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onPageCommitVisible(WebView r10, String r11) {
            super/*android.webkit.WebViewClient*/.onPageCommitVisible(r10, r11);
            q7.b r12 = this.b.f;
            if ((r12 instanceof q7.d) == true) goto L6;
            r12 = null;
        L6:
            if (r12 == null) goto L9;
            r12.setPageCommitVisibleUrl(r11);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onPageFinished(WebView r10, String r11) {
            if (this.b.j == false) goto L8;
            if (r10 == null) goto L6;
            r10.clearHistory();
        L6:
            this.b.j = false;
        L8:
            if (Build.VERSION.SDK_INT > 28) goto L10;
            WebComponent.a(this.b);
        L10:
            super/*android.webkit.WebViewClient*/.onPageFinished(r10, r11);
            if (g.b().a.a == false) goto L18;
            Bundle r0 = this.b.e.getBundle();
            if (r0 == null) goto L15;
            Long r1 = Long.valueOf(r0.getLong("open_time"));
        L16:
            if (r1 == null) goto L18;
            this.b.e.d.e("livesdk_live_container_timing", "===onPageFinished====full_time: " + (System.currentTimeMillis() - r1.longValue()));
            goto L18
        L15:
            r1 = null;
        L18:
            Iterator<com.bytedance.android.annie.card.web.e> r12 = this.b.l.iterator();
        L20:
            if (r12.hasNext() == false) goto L22;
            r12.next().g(r10, r11);
            goto L20
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final WebResourceResponse shouldInterceptRequest(WebView r32, WebResourceRequest r33) {
            Iterator<com.bytedance.android.annie.card.web.e> r10 = this.b.l.iterator();
        L4:
            if (r10.hasNext() == false) goto L7;
            r10.next().getClass();
            goto L4
        L7:
            if (r33 == null) goto L11;
            Uri r11 = r33.getUrl();
            if (r11 == null) goto L11;
            String r12 = r11.toString();
        L12:
            com.bytedance.android.annie.pia.d r13 = this.b.x;
            if (r13 == null) goto L23;
            if (r33 != null) goto L16;
        L21:
            WebResourceResponse r14 = null;
        L22:
            WebResourceResponse r15 = r14;
        L24:
            if (r12 == null) goto L192;
            WebComponent r16 = this.b;
            boolean r17 = r33.isForMainFrame();
            if (r17 == false) goto L31;
            Iterator<com.bytedance.android.annie.card.web.e> r18 = r16.l.iterator();
        L29:
            if (r18.hasNext() == false) goto L31;
            r18.next().i(null, r12, null);
        L31:
            boolean r19 = false;
            if (r15 == null) goto L34;
            com.bytedance.android.annie.card.web.resource.b r20 = new com.bytedance.android.annie.card.web.resource.b("pia", "pia", false, r15, 8);
        L162:
            if (r17 == true) goto L164;
        L177:
            Iterator<com.bytedance.android.annie.card.web.e> r0 = r16.l.iterator();
        L179:
            if (r0.hasNext() == false) goto L182;
            r0.next().C();
            goto L179
        L182:
            if (r20.d == 0) goto L190;
            WebResourceResponse r1 = r20.e;
            if (r1 == null) goto L188;
            Map<String, String> r21 = r1.getResponseHeaders();
            if (r21 == null) goto L188;
            String r22 = r21.put("x-ttwebview-response-update-time", String.valueOf(r20.d));
        L188:
            r16.e.d.e("TT_WEBVIEW", "add custom header for ttwebview x-ttwebview-response-update-time = " + r20.d);
        L190:
            return r20.e;
        L164:
            if (Intrinsics.areEqual(r20.b, "cdn") == false) goto L166;
        L168:
            r16.n = r19;
            Iterator<com.bytedance.android.annie.card.web.e> r23 = r16.l.iterator();
        L170:
            if (r23.hasNext() == false) goto L172;
            r23.next().onTemplateLoaded(r32, r16.n);
            goto L170
        L172:
            com.bytedance.android.annie.card.web.resource.a r24 = new com.bytedance.android.annie.card.web.resource.a(r16.n, r20.a, r20.d, r20.c);
            Iterator<com.bytedance.android.annie.card.web.e> r25 = r16.l.iterator();
        L174:
            if (r25.hasNext() == false) goto L176;
            r25.next().h(r32, r24);
            goto L174
        L176:
            r16.e.d.e("WebComponent", "load main resource, info: " + r24 + " , response: " + r20.e);
            r16.h();
            goto L177
        L166:
            if (Intrinsics.areEqual(r20.a, "unknown") == true) goto L168;
            r19 = true;
            goto L168
        L34:
            WebResourceProvider r26 = r16.f();
            boolean r27 = r33.isForMainFrame();
            r26.getClass();
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
            if (StringsKt.isBlank(r12) == false) goto L37;
        L80:
            Pair r28 = TuplesKt.to(Boolean.FALSE, AnnieResType.UNKNOWN);
        L81:
            boolean r29 = ((Boolean) r28.component1()).booleanValue();
            AnnieResType r30 = (AnnieResType) r28.component2();
            if (((Boolean) WebResourceProvider.g.getValue()).booleanValue() == false) goto L84;
        L85:
            if (r29 == false) goto L156;
            LinkedHashMap r31 = new LinkedHashMap();
            com.bytedance.android.annie.card.base.c r34 = r26.d;
            if (r34 == null) goto L89;
            r34.b(r12, r30, IHybridComponent.HybridType.H5, r31);
        L89:
            IHybridComponent.HybridType r35 = IHybridComponent.HybridType.H5;
            if (r26.a.e == false) goto L98;
            String r110 = r33.getMethod();
            if (r110 == null) goto L94;
            String r111 = r110.toLowerCase();
        L96:
            if (Intrinsics.areEqual(r111, "get") == true) goto L98;
            com.bytedance.android.annie.card.web.resource.b r36 = new com.bytedance.android.annie.card.web.resource.b("unknown", "unknown", true, null, 24);
        L161:
            r20 = r36;
            goto L162
        L94:
            r111 = null;
        L98:
            String r112 = r26.e;
            if (r112 == null) goto L108;
            if (r27 == true) goto L102;
        L106:
            String r37 = r12;
        L107:
            if (r37 == null) goto L108;
        L110:
            if (r26.a.b == false) goto L115;
            RequestConfig r113 = new RequestConfig(r30);
            r113.c = n.c(r35);
            r113.d = true;
            com.bytedance.android.annie.service.resource.g r114 = r26.a;
            if (r114.c == false) goto L114;
            r113.h = r114.d;
        L114:
            r113.a().putAll(r31);
            r113.k = r33;
            h r38 = n.h(r37, r113);
        L119:
            if (r38 != null) goto L121;
        L155:
            r36 = new com.bytedance.android.annie.card.web.resource.b("unknown", "unknown", true, null, 24);
            goto L161
        L121:
            if (r26.b == false) goto L123;
            r36 = new com.bytedance.android.annie.card.web.resource.b("unknown", "unknown", true, new WebResourceResponse("", "", null), 8);
            goto L161
        L123:
            r26.c.put(r12, r38);
            o r39 = r38.b();
            if (r39 == null) goto L155;
            r26.c.remove(r12);
            if (r39.e == false) goto L128;
            r36 = new com.bytedance.android.annie.card.web.resource.b("unknown", "unknown", true, new WebResourceResponse("", "", null), 8);
            goto L161
        L128:
            com.bytedance.android.annie.card.base.c r40 = r26.d;
            if (r40 == null) goto L131;
            r40.a(r12, r30, r35, r39.i.c);
        L131:
            String r41 = r39.c;
            String r42 = r39.d;
            long r43 = r39.f;
            Integer r115 = r39.g;
            if (r115 == null) goto L134;
            int r116 = r115.intValue();
        L136:
            if (r116 != 304) goto L138;
        L145:
            WebResourceResponse r44 = r39.e();
            if (r44 == null) goto L148;
        L153:
            WebResourceResponse r210 = r44;
        L154:
            r20 = new com.bytedance.android.annie.card.web.resource.b(r41, r42, true, r43, r210);
            goto L162
        L148:
            if (WebResourceProvider.f == true) goto L150;
        L152:
            r210 = null;
            goto L154
        L150:
            if (r26.a.b == true) goto L152;
            r44 = new WebResourceResponse("", "", null);
            goto L153
        L138:
            if (300 <= r116) goto L140;
        L142:
            boolean r117 = false;
        L143:
            if (r117 == false) goto L145;
        L140:
            if (r116 >= 400) goto L142;
            r117 = true;
            goto L143
        L134:
            r116 = -1;
            goto L136
        L115:
            RequestConfig r118 = new RequestConfig(r30);
            r118.c = n.c(r35);
            com.bytedance.android.annie.service.resource.g r119 = r26.a;
            if (r119.c == false) goto L118;
            r118.h = r119.d;
        L118:
            r118.a().putAll(r31);
            r118.k = r33;
            r118.l = r26.a.e;
            r38 = n.h(r37, r118);
            goto L119
        L102:
            if (StringsKt.startsWith$default(r12, r112, false, 2, null) == false) goto L106;
            PreLoadUtils.a.getClass();
            if (CollectionsKt.contains(((com.bytedance.android.annie.service.preload.b) PreLoadUtils.b.getValue()).b, r112) == false) goto L106;
            r37 = r26.e;
        L108:
            r37 = r12;
        L156:
            WebResourceResponse r120 = com.bytedance.android.annie.service.resource.a.a.j(r12);
            if (r120 == null) goto L159;
            String r45 = "gecko";
        L160:
            r36 = new com.bytedance.android.annie.card.web.resource.b(r45, r45, false, r120, 8);
            goto L161
        L159:
            r45 = "cdn";
            goto L160
        L84:
            if (r26.a.a == false) goto L156;
        L37:
            if (StringsKt.startsWith$default(r12, "http", false, 2, null) == false) goto L80;
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
            String r46 = UriProtector.parse(r12).getPath();
            if (r46 == null) goto L48;
            if (r27 == false) goto L43;
        L46:
            AnnieResType r47 = AnnieResType.WEB_MAIN_RESOURCE;
        L47:
            if (r47 == null) goto L48;
        L49:
            com.bytedance.android.annie.service.resource.e r121 = (com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null);
            if (r121.D1(r12) == true) goto L56;
            if (r121.l(r12) == true) goto L56;
            if (r121.F0(r12) == true) goto L56;
        L78:
            boolean r48 = false;
        L79:
            r28 = new Pair(Boolean.valueOf(r48), r47);
        L56:
            if (r47 == AnnieResType.WEB_MAIN_RESOURCE) goto L77;
            String r122 = UriProtector.parse(r12).getPath();
            if (r122 == null) goto L70;
            Iterator r123 = ((Collection) WebResourceProvider.j.getValue()).iterator();
        L62:
            if (r123.hasNext() == false) goto L67;
            Object r124 = r123.next();
            if (StringsKt.endsWith$default(r122, (String) r124, false, 2, null) == false) goto L62;
        L68:
            if (r124 == null) goto L70;
            boolean r49 = true;
        L71:
            if (r49 == true) goto L77;
            if (r122 != null) goto L75;
            r122 = "";
        L75:
            com.bytedance.android.annie.service.resource.d r50 = r121.b1(r12, r122);
            if (new PolarisFileWrapper(ResLoadUtils.getChannelPath(new PolarisFileWrapper(m.c()), r50.a, r50.b) + '/' + r50.c).exists() == false) goto L78;
        L67:
            r124 = null;
        L70:
            r49 = false;
        L77:
            r48 = true;
            goto L79
        L43:
            if (StringsKt.endsWith$default(r46, ".html", false, 2, null) == true) goto L46;
            r47 = AnnieResType.WEB_CHILD_RESOURCE;
        L48:
            r47 = AnnieResType.UNKNOWN;
            goto L49
        L192:
            return super/*android.webkit.WebViewClient*/.shouldInterceptRequest(r32, r33);
        L16:
            if (r13.b.e(r33.getUrl()) == false) goto L21;
            i47.e r51 = r13.b.c(new com.bytedance.android.annie.pia.c(r33));
            if (r51 == null) goto L21;
            r14 = new WebResourceResponse(r51.getMimeType(), r51.getEncoding(), r51.getData());
            goto L22
        L23:
            r15 = null;
        L11:
            r12 = null;
            goto L12
        }

        public boolean shouldOverrideUrlLoading(WebView r10, String r11) {
            q7.b r0 = this.b.f;
            if ((r0 instanceof o7.d) == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L8;
            r0.c(r11);
        L8:
            boolean r1 = true;
            if (super.shouldOverrideUrlLoading(r10, r11) == false) goto L12;
            return true;
        L12:
            if (r11 != null) goto L14;
        L17:
            boolean r12 = true;
        L18:
            if (r12 == false) goto L40;
            return false;
        L40:
            Uri r13 = UriProtector.parse(r11);     // Catch: Exception -> L39
            String r14 = r13.getScheme();     // Catch: Exception -> L39
            if (r14 != null) goto L24;
        L26:
            boolean r15 = false;
        L27:
            if (r15 == true) goto L29;
            String r16 = r13.getScheme();     // Catch: Exception -> L39
            if (r16 != null) goto L33;
        L35:
            r1 = false;
        L36:
            if (r1 == false) goto L38;
            this.b.f().e = r11;     // Catch: Exception -> L39
            goto L38
        L33:
            if (StringsKt.startsWith$default(r16, "http", false, 2, null) != true) goto L35;
        L29:
            return w9.a.a.j0(this.b.a, r13, null, null);
        L24:
            if (StringsKt.startsWith$default(r14, "http", false, 2, null) == true) goto L26;
            r15 = true;
        L38:
            return false;
        L14:
            if (StringsKt.isBlank(r11) == true) goto L17;
            r12 = false;
            goto L18
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void doUpdateVisitedHistory(WebView r1, String r10, boolean r11) {
            super/*android.webkit.WebViewClient*/.doUpdateVisitedHistory(r1, r10, r11);
            Iterator<T> r12 = this.b.l.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ((com.bytedance.android.annie.card.web.e) r12.next()).getClass();
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onPageStarted(WebView r10, String r11, Bitmap r12) {
            super/*android.webkit.WebViewClient*/.onPageStarted(r10, r11, r12);
            q7.b r0 = this.b.f;
            if ((r0 instanceof q7.d) == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L8;
            r0.setPageStartUrl(r11);
        L8:
            WebComponent.a(this.b);
            int r1 = p7.a.a;
            if ((r10 instanceof o7.b) == false) goto L12;
            if (r11 == null) goto L12;
            ((o7.b) r10).setSafeUrl(r11);
        L12:
            WebComponent r13 = this.b;
            Iterator<com.bytedance.android.annie.card.web.e> r14 = r13.l.iterator();
        L14:
            if (r14.hasNext() == false) goto L16;
            r14.next().k(r10, r11, r12, r13.n);
            goto L14
        L16:
            this.b.n = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
            if (Build.VERSION.SDK_INT < 23) goto L16;
            x8.b r0 = this.b.e.d;
            StringBuilder r1 = new StringBuilder("onReceivedError: request:");
            CharSequence r13 = null;
            if (r11 == null) goto L7;
            Uri r14 = r11.getUrl();
        L8:
            r1.append(r14);
            r1.append(", error:");
            if (r12 == null) goto L11;
            Integer r15 = Integer.valueOf(r12.getErrorCode());
        L12:
            r1.append(r15);
            r1.append(':');
            if (r12 == null) goto L15;
            r13 = r12.getDescription();
        L15:
            r1.append(r13);
            x8.b.b(r0, "WebComponent", "on_received_error", r1.toString());
            goto L16
        L11:
            r15 = null;
            goto L12
        L7:
            r14 = null;
        L16:
            super/*android.webkit.WebViewClient*/.onReceivedError(r10, r11, r12);
            Iterator<com.bytedance.android.annie.card.web.e> r16 = this.b.l.iterator();
        L18:
            if (r16.hasNext() == false) goto L20;
            r16.next().u(r10, r11, r12);
            goto L18
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onReceivedHttpError(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
            if (Build.VERSION.SDK_INT < 23) goto L16;
            x8.b r0 = this.b.e.d;
            StringBuilder r1 = new StringBuilder("onReceivedHttpError: request:");
            InputStream r13 = null;
            if (r11 == null) goto L7;
            Uri r14 = r11.getUrl();
        L8:
            r1.append(r14);
            r1.append(", error:");
            if (r12 == null) goto L11;
            Integer r15 = Integer.valueOf(r12.getStatusCode());
        L12:
            r1.append(r15);
            r1.append(':');
            if (r12 == null) goto L15;
            r13 = r12.getData();
        L15:
            r1.append(r13);
            x8.b.b(r0, "WebComponent", "on_received_error", r1.toString());
            goto L16
        L11:
            r15 = null;
            goto L12
        L7:
            r14 = null;
        L16:
            super/*android.webkit.WebViewClient*/.onReceivedHttpError(r10, r11, r12);
            Iterator<com.bytedance.android.annie.card.web.e> r16 = this.b.l.iterator();
        L18:
            if (r16.hasNext() == false) goto L20;
            r16.next().v(r10, r11, r12);
            goto L18
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onReceivedSslError(WebView r10, SslErrorHandler r11, SslError r12) {
            x8.b.b(this.b.e.d, "WebComponent", "on_received_error", "onReceivedSslError: " + r12);
            super/*android.webkit.WebViewClient*/.onReceivedSslError(r10, r11, r12);
            Iterator<com.bytedance.android.annie.card.web.e> r13 = this.b.l.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r13.next().w();
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onReceivedError(WebView r10, int r11, String r12, String r13) {
            x8.b.b(this.b.e.d, "WebComponent", "on_received_error", "onReceivedError: failingUrl:" + r13 + ", error:" + r11 + ':' + r12);
            super/*android.webkit.WebViewClient*/.onReceivedError(r10, r11, r12, r13);
            Iterator<com.bytedance.android.annie.card.web.e> r14 = this.b.l.iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            r14.next().j(r10, r13, r12);
            goto L4
        }
    }

    public static final class b {
        public b() {
        }

        public static k a(Context r10, String r11, String r12, JsonObject r13, String r14, com.bytedance.android.annie.param.a r15, boolean r16) {
            Intrinsics.checkNotNullParameter(r13, "queryItems");
            Intrinsics.checkNotNullParameter(r14, "containerId");
            Intrinsics.checkNotNullParameter(r15, "annieContext");
            Bundle r0 = r15.getBundle();
            if (r0 == null) goto L5;
            Long r1 = Long.valueOf(r0.getLong("open_time"));
        L7:
            return b(r10, r11, r12, r13, r14, r1, r16, r15.getBizKey());
        L5:
            r1 = null;
            goto L7
        }

        public static k b(Context r1, String r10, String r11, JsonObject r12, String r13, Long r14, boolean r15, String r16) {
            Intrinsics.checkNotNullParameter(r12, "queryItems");
            Intrinsics.checkNotNullParameter(r13, "containerId");
            Intrinsics.checkNotNullParameter(r16, "bizKey");
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            k r17 = com.bytedance.android.annie.a.a(r1, r10, !o7.e.a(), r11, r16);
            if (r11 != null) goto L8;
            r11 = "";
        L8:
            r17.G1(r11);
            r17.N1(r15 ? 1 : 0);
            r17.h1(r13);
            if (r14 == null) goto L11;
            r17.C1(r14.toString());
            r17.i1(r14.toString());
        L11:
            return r17;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ WebComponent a;

        public c(WebComponent r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebComponent r0 = this.a;     // Catch: Throwable -> L6
            r0.w = r0.c();     // Catch: Throwable -> L6
            WebComponent r1 = this.a;     // Catch: Throwable -> L6
            InjectDataHolder r10 = r1.w;     // Catch: Throwable -> L6
            if (r10 == null) goto L9;
            q7.b r11 = r1.f;     // Catch: Throwable -> L6
            Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L6
            r11.addJavascriptInterface(r10, BaseHybridComponent.INJECT_NATIVE_DATA);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ WebComponent a;
        public final /* synthetic */ String b;

        public d(WebComponent r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void a() {
            Iterator<com.bytedance.android.annie.card.web.e> r0 = this.a.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onEngineLoadStart();
            goto L4
        L6:
            int r1 = o7.k.a;
            CardParamVoNew r10 = this.a.b;
            String r11 = null;
            if (r10 == null) goto L9;
            String r12 = r10.b;
        L10:
            if (r10 == null) goto L12;
            String r13 = r10.C0();
        L13:
            Map<String, String> r14 = o7.k.a(r12, r13);
            String r15 = this.b;
            WebComponent r16 = this.a;
            q7.b r17 = r16.f;
            CardParamVoNew r18 = r16.b;
            if (r18 == null) goto L16;
            String r19 = r18.J0();
        L17:
            CardParamVoNew r20 = this.a.b;
            if (r20 == null) goto L20;
            r11 = r20.j();
        L20:
            String r21 = l.d(r15, r17, r14, r19, r11);
            if (r21 == null) goto L30;
            WebComponent r22 = this.a;
            r22.e.d.f("WebComponent", "component_load_start", "===mWebView loadUrl: " + r21 + "===");
            if ((!StringsKt.isBlank(r21)) == true) goto L25;
            return;
        L25:
            if ((!r14.isEmpty()) == false) goto L27;
            r22.f.loadUrl(r21, r14);
            return;
        L27:
            r22.f.loadUrl(r21);
            return;
        L30:
            return;
        L16:
            r19 = null;
            goto L17
        L12:
            r13 = null;
            goto L13
        L9:
            r12 = null;
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ WebComponent a;

        public e(WebComponent r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<T> r0 = this.a.l.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            ((com.bytedance.android.annie.card.web.e) r0.next()).onEngineLoadEnd();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final boolean isAnnieXComponent() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment.a
    public final void onActivityResult(int r1, int r10, Intent r11) {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void updateScreenMetrics(int r1, int r10) {
    }

    static {
        new b();
        y = LazyKt.lazy(WebComponent$Companion$allowWebUseNetworkPaused$2.INSTANCE);
    }

    public final InjectDataHolder c() {
        x8.b r0 = this.e.d;
        StringBuilder r1 = new StringBuilder("===createInjectDataHolder: ");
        String r10 = getUrl();
        if (r10 != null) goto L5;
        r10 = "empty";
    L5:
        r1.append(r10);
        r1.append("===");
        r0.e("WebComponent", r1.toString());
        Iterator<com.bytedance.android.annie.card.web.e> r11 = this.l.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().onBeforeCreateRenderData(this.f);
        goto L7
    L9:
        Iterator<com.bytedance.android.annie.card.web.e> r12 = this.l.iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        r12.next().onBeforeInitialPropsInitialize();
        goto L11
    L13:
        String r13 = getUrl();
        CardParamVoNew r14 = this.b;
        if (r14 == null) goto L16;
        String r15 = r14.o();
    L17:
        Map<String, Object> r16 = observeWith(r13, r15);
        String r17 = com.bytedance.android.annie.api.data.subscribe.d.c(r16);
        Iterator<com.bytedance.android.annie.card.web.e> r18 = this.l.iterator();
    L19:
        if (r18.hasNext() == false) goto L21;
        r18.next().onInitialPropsInitialized();
        goto L19
    L21:
        Pair r19 = new Pair(r17, r16);
        String r20 = (String) r19.component1();
        Map r21 = (Map) r19.component2();
        Map<String, ? extends Object> r22 = this.v;
        if (r22 != null) goto L24;
        String r23 = "{}";
    L25:
        this.o = "javascript:window.initialProps=" + r20 + ";window.injectInitData=" + r23 + ';';
        Iterator<com.bytedance.android.annie.card.web.e> r24 = this.l.iterator();
    L27:
        if (r24.hasNext() == false) goto L30;
        r24.next().onCreateRenderData(this.f, r21.keySet());
        goto L27
    L30:
        return new InjectDataHolder(r20, r23);
    L24:
        Gson r25 = com.bytedance.android.annie.api.data.subscribe.d.a;
        Intrinsics.checkNotNull(r22);
        r23 = com.bytedance.android.annie.api.data.subscribe.d.c(r22);
        goto L25
    L16:
        r15 = null;
        goto L17
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean canGoBack() {
        return this.f.canGoBack();
    }

    public final WebResourceProvider f() {
        return (WebResourceProvider) this.u.getValue();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String getBizKey() {
        return this.e.getBizKey();
    }

    public final String getUrl() {
        CardParamVoNew r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void goBack() {
        this.f.goBack();
    }

    public final void h() {
        Iterator<com.bytedance.android.annie.card.web.e> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onBeforeGlobalPropsInitialize();
        goto L4
    L6:
        this.o += g(null, true, null);
        Iterator<com.bytedance.android.annie.card.web.e> r1 = this.l.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().onGlobalPropsInitialized();
        goto L8
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean isPopup() {
        CardParamVoNew r0 = this.b;
        if (r0 == null) goto L5;
        PageType r1 = r0.I0();
    L7:
        if (r1 != PageType.POPUP) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void onPause() {
        x8.b r0 = this.e.d;
        StringBuilder r1 = new StringBuilder("===onPause: ");
        String r10 = getUrl();
        if (r10 != null) goto L5;
        r10 = "empty";
    L5:
        r1.append(r10);
        r1.append("===");
        r0.e("WebComponent", r1.toString());
        if (((Boolean) y.getValue()).booleanValue() == true) goto L8;
        this.f.getSettings().setBlockNetworkLoads(true);
    L8:
        HoneyCombV11Compat.pauseWebView(this.f);
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void onResume() {
        x8.b r0 = this.e.d;
        StringBuilder r1 = new StringBuilder("===onResume: ");
        String r10 = getUrl();
        if (r10 != null) goto L5;
        r10 = "empty";
    L5:
        r1.append(r10);
        r1.append("===");
        r0.e("WebComponent", r1.toString());
        if (((Boolean) y.getValue()).booleanValue() == true) goto L8;
        this.f.getSettings().setBlockNetworkLoads(false);
    L8:
        HoneyCombV11Compat.resumeWebView(this.f);
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        x8.b r0 = this.e.d;
        StringBuilder r1 = new StringBuilder("===release: ");
        String r10 = getUrl();
        if (r10 != null) goto L5;
        r10 = "empty";
    L5:
        r1.append(r10);
        r1.append("===");
        r0.e("WebComponent", r1.toString());
        super.release();
        this.g.i();
        this.g.release();
        q7.b r11 = this.f;
        int r12 = l.a;
        Intrinsics.checkNotNullParameter("live/business-end", "cmd");
        if (r11 == null) goto L8;
        r11.evaluateJavascript("ttwebview:/*live/business-end*/;", null);
    L8:
        Iterator<com.bytedance.android.annie.card.web.e> r13 = this.l.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        r13.next().y();
        goto L10
    L12:
        this.f.destroy();
        WebResourceProvider r14 = f();
        r14.b = true;
        com.bytedance.android.annie.service.resource.g r15 = r14.a;
        if (r15.c == false) goto L15;
        String r16 = r15.d;
        y9.m r17 = n.a;
        Intrinsics.checkNotNullParameter(r16, "containerId");
        ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).h(r16);
    L15:
        com.bytedance.android.annie.card.base.d.a.a(r14);
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
        super.hide();
        x8.b r0 = this.e.d;
        StringBuilder r1 = new StringBuilder("===hide: ");
        String r10 = getUrl();
        if (r10 != null) goto L5;
        r10 = "empty";
    L5:
        r1.append(r10);
        r1.append("===");
        r0.e("WebComponent", r1.toString());
        sendJsEvent("viewDisappeared", new JSONObject());
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void show() {
        super.show();
        x8.b r0 = this.e.d;
        StringBuilder r1 = new StringBuilder("===show: ");
        String r10 = getUrl();
        if (r10 != null) goto L5;
        r10 = "empty";
    L5:
        r1.append(r10);
        r1.append("===");
        r0.e("WebComponent", r1.toString());
        sendJsEvent("viewAppeared", new JSONObject());
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final JSBridgeManager getJSBridgeManger() {
        return this.g;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final View getView() {
        return this.f;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final IHybridComponent.HybridType hybridType() {
        return IHybridComponent.HybridType.H5;
    }

    public static final void a(WebComponent r10) {
        if (StringsKt.isBlank(r10.o) == true) goto L10;
        x8.b r0 = r10.e.d;
        StringBuilder r1 = new StringBuilder("===injectGlobalProps: ");
        String r11 = r10.getUrl();
        if (r11 != null) goto L8;
        r11 = "empty";
    L8:
        r1.append(r11);
        r1.append("===");
        r0.e("WebComponent", r1.toString());
        String r12 = r10.o;
        r10.f.evaluateJavascript(r12, null);
        return;
    }

    public static JsonObject e(String r10) {
        JsonObject r0 = new JsonObject();
        if (r10 != null) goto L11;
    L9:
        return r0;
    L11:
        Uri r11 = UriProtector.parse(r10);     // Catch: Throwable -> L10
        Iterator r1 = UriProtector.getQueryParameterNames(r11).iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L9;
        String r12 = (String) r1.next();     // Catch: Throwable -> L10
        r0.addProperty(r12, UriProtector.getQueryParameter(r11, r12));     // Catch: Throwable -> L10
        goto L6
    }

    public final Map<String, Object> b(CardParamVoNew r10) {
        if (r10 == null) goto L4;
        k r11 = b.a(this.a, r10.o(), r10.b, e(r10.o()), containerId(), this.e, this.n);
    L12:
        CardParamVoNew r0 = this.b;
        if (r0 == null) goto L20;
        String r1 = r0.y0();
        if (r1 == null) goto L20;
        if (StringsKt.isBlank(r1) == false) goto L19;
        r1 = containerId();
    L19:
        if (r1 == null) goto L20;
    L21:
        r11.y1(r1);
        Bundle r12 = this.e.getBundle();
        if (r12 == null) goto L24;
        int r13 = r12.getInt("isPrerender");
    L25:
        r11.W1(r13);
        LinkedHashMap r14 = new LinkedHashMap();
        r14.putAll(com.bytedance.android.annie.param.b.b(r11));
        int r15 = com.bytedance.android.annie.a.a;
        String r16 = getBizKey();
        Intrinsics.checkNotNullParameter(r14, "mutableMap");
        Intrinsics.checkNotNullParameter(r16, "bizKey");
        ((com.bytedance.android.annie.param.m) Annie.getService(com.bytedance.android.annie.param.m.class, r16)).W0(r14);
        return r14;
    L24:
        r13 = 0;
    L20:
        r1 = containerId();
        goto L21
    L4:
        Context r17 = this.a;
        CardParamVoNew r18 = this.b;
        String r19 = null;
        if (r18 == null) goto L7;
        String r20 = r18.o();
    L8:
        String r21 = getUrl();
        CardParamVoNew r22 = this.b;
        if (r22 == null) goto L11;
        r19 = r22.o();
    L11:
        r11 = b.a(r17, r20, r21, e(r19), containerId(), this.e, this.n);
        goto L12
    L7:
        r20 = null;
        goto L8
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void registerLifecycleCallback(com.bytedance.android.annie.card.base.b r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        if ((r10 instanceof com.bytedance.android.annie.card.web.e) == false) goto L5;
        this.l.add(r10);
        return;
    L5:
        this.l.add(new com.bytedance.android.annie.card.web.e(r10));
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
        this.m = r10;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, a7.b
    public final void setRadius(float r10) {
        q7.b r0 = this.f;
        if ((r0 instanceof o7.a) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        r0.setRadius(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        x8.b r0 = this.e.d;
        StringBuilder r1 = new StringBuilder("===updateGlobalProps: ");
        String r11 = getUrl();
        if (r11 != null) goto L5;
        r11 = "empty";
    L5:
        r1.append(r11);
        r1.append("===");
        r0.e("WebComponent", r1.toString());
        String r12 = g(r10, false, null);
        this.f.evaluateJavascript(r12, null);
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void updateHybridParamsNew(CardParamVoNew r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        super.updateHybridParamsNew(r10);
        this.b = r10;
    }

    public final Map<String, Object> d(boolean r10, CardParamVoNew r11) {
        if (r10 == false) goto L6;
        LinkedHashMap r12 = new LinkedHashMap();
        r12.putAll(b(r11));
        this.p = r12;
        return this.p;
    L6:
        if (this.p != null) goto L19;
        Object r13 = this.q;
        monitor-enter(r13);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.p != null) goto L12;
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L15
        r0.putAll(b(r11));     // Catch: Throwable -> L15
        this.p = r0;     // Catch: Throwable -> L15
    L12:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r13);
    L19:
        return this.p;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r12, Map<String, ? extends Object> r13) {
        x8.b r0 = this.e.d;
        StringBuilder r1 = new StringBuilder("===load: ");
        String r10 = getUrl();
        String r11 = "empty";
        if (r10 != null) goto L5;
        r10 = "empty";
    L5:
        r1.append(r10);
        r1.append("===");
        r0.f("WebComponent", "component_load_start", r1.toString());
        Iterator<com.bytedance.android.annie.card.web.e> r14 = this.l.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        r14.next().onCardLoadStart();
        goto L7
    L9:
        this.v = r13;
        if (r12 != null) goto L12;
    L15:
        boolean r15 = true;
    L16:
        String r16 = null;
        if (r15 == true) goto L30;
        String r17 = getUrl();
        if (r17 != null) goto L21;
    L25:
        f().e = r12;
    L26:
        x8.b r18 = this.e.d;
        StringBuilder r19 = new StringBuilder("===load: ");
        String r20 = getUrl();
        if (r20 != null) goto L29;
        r20 = "empty";
    L29:
        r19.append(r20);
        r19.append("===");
        r18.f("WebComponent", "component_load_start", r19.toString());
        com.bytedance.android.annie.scheme.helper.a.d(this.b, com.bytedance.android.ec.core.event.a.KEY_URL, r12);
    L32:
        if (AnnieConfigSettingKeys.LIVE_HYBRID_CREATE_ANNIE_CARD_OPT.a().booleanValue() == false) goto L41;
        CardParamVoNew r110 = this.b;
        if (r110 != null) goto L36;
    L38:
        boolean r111 = false;
    L39:
        if (r111 == true) goto L41;
        boolean r112 = true;
    L42:
        String r21 = getUrl();
        if (r21 != null) goto L45;
    L83:
        if (r112 == false) goto L85;
        ThreadUtils.a().post(new e(this));
    L89:
        x8.b r113 = this.e.d;
        StringBuilder r114 = new StringBuilder("===load end: ");
        String r22 = getUrl();
        if (r22 == null) goto L93;
        r11 = r22;
    L93:
        r114.append(r11);
        r114.append("===");
        r113.f("WebComponent", "component_load_end", r114.toString());
        return;
    L85:
        Iterator<com.bytedance.android.annie.card.web.e> r115 = this.l.iterator();
    L87:
        if (r115.hasNext() == false) goto L89;
        r115.next().onEngineLoadEnd();
        goto L87
    L45:
        if (this.k == false) goto L47;
        this.k = false;
    L48:
        if (r112 == false) goto L50;
        ThreadUtils.a().post(new c(this));
        ThreadUtils.a().post(new d(this, r21));
        goto L83
    L50:
        InjectDataHolder r23 = c();
        this.w = r23;
        q7.b r24 = this.f;
        Intrinsics.checkNotNull(r23);
        r24.addJavascriptInterface(r23, BaseHybridComponent.INJECT_NATIVE_DATA);
        Iterator<com.bytedance.android.annie.card.web.e> r25 = this.l.iterator();
    L52:
        if (r25.hasNext() == false) goto L54;
        r25.next().onEngineLoadStart();
        goto L52
    L54:
        int r26 = o7.k.a;
        CardParamVoNew r27 = this.b;
        if (r27 == null) goto L57;
        String r28 = r27.b;
    L58:
        if (r27 == null) goto L60;
        String r29 = r27.C0();
    L61:
        Map<String, String> r30 = o7.k.a(r28, r29);
        q7.b r31 = this.f;
        CardParamVoNew r32 = this.b;
        if (r32 == null) goto L64;
        String r33 = r32.b;
    L65:
        if (r32 == null) goto L67;
        String r34 = r32.C0();
    L68:
        Map r35 = o7.k.a(r33, r34);
        CardParamVoNew r36 = this.b;
        if (r36 == null) goto L71;
        String r37 = r36.J0();
    L72:
        CardParamVoNew r116 = this.b;
        if (r116 == null) goto L75;
        r16 = r116.j();
    L75:
        String r38 = l.d(r21, r31, r35, r37, r16);
        if (r38 == null) goto L83;
        this.e.d.f("WebComponent", "component_load_start", "===mWebView loadUrl: " + r38 + "===");
        if ((!StringsKt.isBlank(r38)) == false) goto L83;
        if ((true ^ r30.isEmpty()) == false) goto L82;
        this.f.loadUrl(r38, r30);
        goto L83
    L82:
        this.f.loadUrl(r38);
        goto L83
    L71:
        r37 = null;
        goto L72
    L67:
        r34 = null;
        goto L68
    L64:
        r33 = null;
        goto L65
    L60:
        r29 = null;
        goto L61
    L57:
        r28 = null;
        goto L58
    L47:
        this.f.clearCache(false);
        goto L48
    L36:
        if (r110.f0() != true) goto L38;
        r111 = true;
    L41:
        r112 = false;
        goto L42
    L21:
        if (StringsKt.startsWith$default(r12, r17, false, 2, null) == false) goto L25;
        if (((com.bytedance.android.annie.service.resource.e) getService(com.bytedance.android.annie.service.resource.e.class)).D1(r12) == false) goto L25;
        f().e = r17;
        goto L26
    L30:
        f().e = getUrl();
        goto L32
    L12:
        if (StringsKt.isBlank(r12) == true) goto L15;
        r15 = false;
        goto L16
    }

    public final String g(Map<String, ? extends Object> r10, boolean r11, CardParamVoNew r12) {
        Map<String, Object> r13 = d(r11, r12);
        if (r13 == null) goto L8;
        HashMap r14 = new HashMap();
        if (r10 == null) goto L7;
        r14.putAll(r10);
    L7:
        r14.put("offline", Boolean.valueOf(this.n));
        r13.putAll(r14);
    L8:
        Map<String, Object> r15 = d(false, null);
        String r16 = "{}";
        if (r15 != null) goto L22;
    L17:
        InjectDataHolder r17 = this.w;
        if (r17 == null) goto L21;
        Intrinsics.checkNotNullParameter(r16, "globalProps");
        r17.a = r16;
    L21:
        return "window.__globalProps=" + r16 + ';';
    L22:
        String r18 = com.bytedance.android.annie.api.data.subscribe.d.c(r15);     // Catch: Exception -> L12
    L14:
        if (r18 == null) goto L17;
        r16 = r18;
    L12:
        e = move-exception;
        b8.a r19 = b8.a.a;
        b8.a.a(new b8.b("GlobalProps", LogLevel.ERROR, e, null, 8), true);
        r18 = "{}";
        goto L14
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, a7.b
    public final void setRadius(float r10, float r11, float r12, float r13) {
        q7.b r0 = this.f;
        if ((r0 instanceof o7.a) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        r0.setRadius(r10, r11, r12, r13);
        return;
    }

    public WebComponent(Context r20, CardParamVoNew r21, AnnieCard$getBaseLifecycle$1 r22, com.bytedance.android.annie.card.e.a r23, com.bytedance.android.annie.param.a r24) {
        Intrinsics.checkNotNullParameter(r20, "mContext");
        Intrinsics.checkNotNullParameter(r22, "mInitializeLifecycle");
        Intrinsics.checkNotNullParameter(r23, "monitorProvider");
        Intrinsics.checkNotNullParameter(r24, "mAnnieContext");
        super(r24);
        this.a = r20;
        this.b = r21;
        this.c = r22;
        this.d = r23;
        this.e = r24;
        this.g = new JSBridgeManager(r24);
        this.h = new a(this);
        this.i = new AnnieWebChromeClient(this);
        boolean r1 = true;
        this.j = true;
        this.k = true;
        this.l = new CopyOnWriteArrayList();
        this.o = "";
        this.q = new Object();
        new AtomicBoolean(false);
        this.r = LazyKt.lazy(new WebComponent$useForest$2(this));
        this.s = LazyKt.lazy(WebComponent$disableForestCdn$2.INSTANCE);
        this.t = LazyKt.lazy(new WebComponent$loaderConfig$2(this));
        this.u = LazyKt.lazy(new WebComponent$resourceProvider$2(this));
        x8.b r10 = r24.d;
        StringBuilder r11 = new StringBuilder("===init start: ");
        String r12 = getUrl();
        String r13 = "empty";
        if (r12 != null) goto L5;
        r12 = "empty";
    L5:
        r11.append(r12);
        r11.append("===");
        r10.f("WebComponent", "init_component", r11.toString());
        registerLifecycleCallback(r22);
        Iterator<T> r14 = r23.a().iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        registerLifecycleCallback((com.bytedance.android.annie.card.base.b) r14.next());
        goto L7
    L9:
        c47.c r15 = com.bytedance.android.annie.pia.b.a;
        CardParamVoNew r16 = this.b;
        if (r16 == null) goto L12;
        String r17 = r16.o();
    L13:
        String r18 = getUrl();
        com.bytedance.android.annie.param.a r19 = this.e;
        Intrinsics.checkNotNullParameter(r19, "annieContext");
        if (r18 != null) goto L17;
    L24:
        com.bytedance.android.annie.pia.d r25 = null;
    L26:
        if (r25 == null) goto L28;
        registerLifecycleCallback(r25);
    L29:
        this.x = r25;
        Context r26 = this.a;
        CardParamVoNew r27 = this.b;
        Intrinsics.checkNotNull(r27);
        q7.b r28 = new q7.b(r26, r27, this.l);
        r28.setEnableSafeAuth(AnnieConfigSettingKeys.ENABLE_SAFE_WEB_JSB_AUTH.a());
        r28.setOnScrollChangeListener(new com.bytedance.android.annie.card.web.d(this));
        r28.setBackgroundColor(this.a.getResources().getColor(2131100223));
        CardParamVoNew r29 = this.b;
        Context r30 = this.a;
        String r31 = getBizKey();
        int r110 = o7.k.a;
        Intrinsics.checkNotNullParameter(r28, "webView");
        Intrinsics.checkNotNullParameter(r30, "context");
        Intrinsics.checkNotNullParameter(r31, "bizKey");
        r28.setScrollBarStyle(0);
        r28.setVerticalScrollBarEnabled(false);
        r28.setHorizontalScrollBarEnabled(false);
        r28.getSettings().setMixedContentMode(2);
        if (r29 != null) goto L32;
    L34:
        boolean r111 = false;
    L35:
        if (r111 == false) goto L37;
        r28.getSettings().setCacheMode(2);
    L47:
        r28.setDownloadListener(new i(r30, r28));
        r28.getSettings().setMixedContentMode(2);
        r28.getSettings().setJavaScriptEnabled(true);     // Catch: Exception -> L50
        r28.getSettings().setSupportZoom(true);     // Catch: Exception -> L50
        r28.getSettings().setTextZoom(100);     // Catch: Exception -> L50
        r28.getSettings().setBuiltInZoomControls(true);     // Catch: Exception -> L50
        HoneyCombV11Compat.setDisplayZoomControl(r28.getSettings(), false);     // Catch: Exception -> L50
    L51:
        r28.getSettings().setLoadWithOverviewMode(true);
        r28.getSettings().setUseWideViewPort(true);
        r28.getSettings().setDomStorageEnabled(true);
        WebSettings r32 = r28.getSettings();
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r33 = g.c;
        com.bytedance.android.annie.ng.a r112 = r33.get(r31);
        if (r112 == null) goto L56;
        o8.h r113 = r112.a;
        if (r113 == null) goto L56;
        boolean r114 = r113.a;
    L57:
        r32.setAllowFileAccess(r114);
        JellyBeanMR1V17Compat.setMediaPlaybackRequiresUserGesture(r28.getSettings(), false);
        LollipopV21Compat.setAcceptThirdPartyCookies(r28, true);
        LollipopV21Compat.setMixedContentMode(r28.getSettings(), 2);
        com.bytedance.android.annie.ng.a r34 = r33.get(r31);
        if (r34 == null) goto L62;
        o8.h r35 = r34.a;
        if (r35 == null) goto L62;
        boolean r36 = r35.b;
    L63:
        if (r36 == true) goto L65;
        r28.setOnLongClickListener(null);
        r28.setLongClickable(false);
    L66:
        CookieManager.getInstance().setAcceptCookie(true);
        String r37 = l.e(r28.getContext(), r28);
        StringBuilder r38 = new StringBuilder(r37);
        if (TextUtils.isEmpty(r37) == true) goto L69;
        r37 = l.b(r38);
    L69:
        if (r37 == null) goto L71;
        r28.getSettings().setUserAgentString(r37);
    L71:
        x8.b r39 = this.e.d;
        StringBuilder r40 = new StringBuilder("===createWebView: ");
        String r41 = getUrl();
        if (r41 != null) goto L74;
        r41 = "empty";
    L74:
        r40.append(r41);
        r40.append("===");
        r39.f("WebComponent", "create_component_view", r40.toString());
        this.f = r28;
        r28.setWebViewClient(this.h);
        r28.setWebChromeClient(this.i);
        Iterator<com.bytedance.android.annie.card.web.e> r42 = this.l.iterator();
    L76:
        if (r42.hasNext() == false) goto L78;
        r42.next().onBeforeJsbRegister();
        goto L76
    L78:
        String r43 = getUrl();
        JSBridgeManager r44 = this.g;
        q7.b r45 = this.f;
        Context r115 = this.a;
        n56.b r46 = this.h;
        AnnieWebChromeClient r116 = this.i;
        List<u> r117 = this.d.b(r45);
        CardParamVoNew r47 = this.b;
        if (r47 != null) goto L81;
    L83:
        r1 = false;
    L84:
        CardParamVoNew r48 = this.b;
        if (r48 == null) goto L88;
        String r49 = r48.z();
        if (r49 == null) goto L88;
    L89:
        r44.getClass();
        Intrinsics.checkNotNullParameter(this, "hybridComponent");
        Intrinsics.checkNotNullParameter(r45, "webView");
        Intrinsics.checkNotNullParameter(r115, "context");
        Intrinsics.checkNotNullParameter(r117, "jsbListeners");
        Intrinsics.checkNotNullParameter(r49, "xBridgeRegisterStrategy");
        r44.l = r1;
        r44.f = this;
        r44.h = r115;
        r44.m = r43;
        d0.a r50 = d0.g;
        com.bytedance.ies.web.jsbridge2.o r51 = new com.bytedance.ies.web.jsbridge2.o(r45);
        r51.u = null;
        Unit r52 = Unit.INSTANCE;
        d0 r53 = r44.f(r115, r51, null, r117, r43);
        r44.c = r53;
        f0 r54 = new f0(r45, r53);
        n56.a r55 = r54.b;
        r55.b = "bytedance";
        if (r46 == null) goto L92;
        r55.i(r46);
    L92:
        if (r116 == null) goto L96;
        WebView r56 = r54.b.a;
        if (r56 == null) goto L96;
        r56.setWebChromeClient(r116);
    L96:
        r44.d = r54;
        d0 r57 = r44.c;
        if (r57 == null) goto L99;
        Set<d0> r58 = com.bytedance.android.annie.bridge.h.a;
        Intrinsics.checkNotNullParameter(r57, "owner");
    L99:
        r44.j(r49, getBizKey());
        j r59 = j.a;
        j.H1(r44);
        Iterator<com.bytedance.android.annie.card.web.e> r60 = this.l.iterator();
    L101:
        if (r60.hasNext() == false) goto L103;
        r60.next().onJsbRegistered();
        goto L101
    L103:
        com.bytedance.android.annie.pia.d r61 = this.x;
        if (r61 == null) goto L106;
        d0 r62 = this.g.d();
        Intrinsics.checkNotNullParameter(r62, "bridge");
        l0 r63 = r61.c;
        r63.c = r62;
        r61.b.g(r63);
    L106:
        ((p) getService(p.class)).r0(this);
        WeakReference<HybridFragment> r64 = AnnieFragmentManager.b(this.e.getUuid());
        if (r64 == null) goto L111;
        HybridFragment r65 = r64.get();
        if (r65 == null) goto L111;
        r65.registerLifecycleListener(this);
    L111:
        x8.b r66 = this.e.d;
        StringBuilder r67 = new StringBuilder("===init end: ");
        String r68 = getUrl();
        if (r68 == null) goto L115;
        r13 = r68;
    L115:
        r67.append(r13);
        r67.append("===");
        r66.f("WebComponent", "init_component_end", r67.toString());
        return;
    L88:
        r49 = "all";
        goto L89
    L81:
        if (r47.c0() != true) goto L83;
    L65:
        r28.setLongClickable(true);
        r28.setOnLongClickListener(o7.g.a);
    L62:
        r36 = true;
    L56:
        r114 = false;
        goto L57
    L37:
        WebSettings r118 = r28.getSettings();
        if (r29 != null) goto L40;
    L42:
        boolean r69 = false;
    L43:
        if (r69 == false) goto L45;
        int r70 = 1;
    L46:
        r118.setCacheMode(r70);
        goto L47
    L45:
        r70 = -1;
        goto L46
    L40:
        if (r29.i0() != true) goto L42;
        r69 = true;
        goto L43
    L32:
        if (r29.G0() != true) goto L34;
        r111 = true;
        goto L35
    L28:
        r25 = null;
        goto L29
    L17:
        if (com.bytedance.android.annie.pia.b.a(r18, r19) == false) goto L24;
        IPiaLifeCycleService r71 = k47.c.a();
        if (r71 == null) goto L24;
        s47.k r72 = r71.b("annie", r19.getContainerId(), new com.bytedance.android.annie.pia.b.a(r17, r18));
        if (r72 == null) goto L24;
        r25 = new com.bytedance.android.annie.pia.d(r72);
        goto L26
    L12:
        r17 = null;
        goto L13
    }
}
