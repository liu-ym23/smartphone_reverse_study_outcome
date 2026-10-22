package com.larus.search.impl;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ivy.ivykit.plugin.impl.web.PluginWebView;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b2;
import com.larus.platform.api.e1;
import com.larus.search.impl.databinding.LarusBaseWebDialogFragmentBinding;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\u0012\u0010&\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\b\u0010*\u001a\u00020\u001fH\u0016J\b\u0010+\u001a\u00020\u001fH\u0014J&\u0010,\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050.H\u0002J2\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050.2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050.H\u0002J&\u00100\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u00062"}, d2 = {"Lcom/larus/search/impl/HalfWebFragment;", "Lcom/larus/search/impl/BaseWebDialogFragment;", "<init>", "()V", "schema", "", "url", "trace", "Lcom/larus/platform/api/IPageLoadTrace;", "ivyWebViewClient", "Lcom/ivy/ivykit/api/plugin/web/IvyWebClient;", "ivyWebView", "Lcom/ivy/ivykit/api/plugin/render/WebViewPluginView;", "isErrorOccurred", "", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "startY", "", "getStartY", "()F", "setStartY", "(F)V", "endY", "getEndY", "setEndY", "scrollDistance", "getScrollDistance", "setScrollDistance", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "doRefresh", "createHybridKit", "isDomStorageEnabled", "backWebPage", "onResume", "onDestroyView", "onDestroy", "onRefresh", "addCommonQuery", "requestHeaders", "", "addCommonHeaders", "checkWhiteList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class HalfWebFragment extends BaseWebDialogFragment {
    public static final /* synthetic */ int u = 0;
    public final String l;
    public String m;
    public final e1 n;
    public lx7.a o;
    public kx7.c p;
    public boolean q;
    public BottomSheetBehavior<View> r;
    public float s;
    public float t;

    public static final class a {
    }

    public static final class b implements ix7.e {
        public final /* synthetic */ HalfWebFragment a;

        public final boolean d(com.ivy.ivykit.plugin.impl.web.b r1) {
            return false;
        }

        public final boolean g(WebView r1, ValueCallback r2) {
            return false;
        }

        public final void h(String r1, int r2, String r3) {
        }

        public final void f() {
            FLogger.a.w("HalfFragment", "onHideCustomView");
        }

        public b(HalfWebFragment r1) {
            this.a = r1;
        }

        public final void b(SslError r4) {
            FLogger.a.w("HalfFragment", "onReceivedSslError " + r4 + " url:" + this.a.m);
        }

        public final lx7.b c(lx7.b r9) {
            Intrinsics.checkNotNullParameter(r9, "before");
            HalfWebFragment r0 = this.a;
            String r1 = r9.a;
            Map r2 = r9.b;
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            Map<String, String> r3 = TypeIntrinsics.asMutableMap(r2);
            int r4 = HalfWebFragment.u;
            String r5 = "";
            if (r0.S90(r1, r3) == false) goto L9;
            Uri.Builder r6 = UriProtector.parse(r1).buildUpon().appendQueryParameter("is_inapp", "1");
            if (HttpExtKt.e().a == false) goto L7;
            String r7 = b2.a.o();
        L8:
            Uri r8 = r6.appendQueryParameter("api_host", r7).build();
            FLogger.a.i("HalfFragment", "addCommonQuery: called, result uri = " + r8);
            r1 = r8.toString();
            Intrinsics.checkNotNull(r1);
        L11:
            HalfWebFragment r10 = this.a;
            String r11 = r9.a;
            Map r12 = r9.b;
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            Map<String, String> r13 = TypeIntrinsics.asMutableMap(r12);
            if (r10.S90(r11, r13) == false) goto L34;
            FLogger.a.i("HalfFragment", "addCommonHeaders: called, in whitelist");
            Function0 r14 = SearchServiceImpl.a.a;
            if (r14 == null) goto L19;
            String r15 = (String) r14.invoke();
            if (r15 == null) goto L19;
            r5 = r15;
        L19:
            r13.put("x-tt-token", r5);
            boolean r16 = false;
            if (HttpExtKt.e().a == false) goto L27;
            r13.put("x-use-boe", "1");
            if (HttpExtKt.e().b.length() <= 0) goto L24;
            r16 = true;
        L24:
            if (r16 == false) goto L34;
            r13.put("x-tt-env", HttpExtKt.e().b);
            goto L34
        L27:
            if (HttpExtKt.e().c == false) goto L34;
            r13.put("x-use-ppe", "1");
            if (HttpExtKt.e().d.length() <= 0) goto L31;
            r16 = true;
        L31:
            if (r16 == false) goto L34;
            r13.put("x-tt-env", HttpExtKt.e().d);
        L34:
            if (AppHost.a.isDebug() == false) goto L41;
            Iterator<Map.Entry<String, String>> r17 = r13.entrySet().iterator();
            String r18 = "addCommonHeaders: called, headers: ";
        L37:
            if (r17.hasNext() == false) goto L39;
            Map.Entry<String, String> r19 = r17.next();
            r18 = r18 + r19.getKey() + " = " + r19.getValue() + '\n';
            goto L37
        L39:
            FLogger.a.d("HalfFragment", r18);
        L41:
            return new lx7.b(r1, r13);
        L7:
            r7 = b2.a.h();
            goto L8
        L9:
            if (r1 != null) goto L11;
            r1 = "";
            goto L11
        }

        public final void e(View r4) {
            FLogger.a.w("HalfFragment", "onShowCustomView view=" + r4);
        }

        public final void onPageStarted(String r4) {
            FLogger.a.i("HalfFragment", "onPageStarted url:" + r4);
            this.a.onLoading();
        }

        public final void i(WebView r3, int r4) {
            FLogger.a.i("HalfFragment", "onProgressChanged newProgress:" + r4);
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
            r1.e("HalfFragment", r2.toString());
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

        public final void k(WebResourceRequest r3, WebResourceError r4) {
            FLogger.a.w("HalfFragment", "onReceivedError " + r4 + " url:" + this.a.m + ' ');
        }

        public final void onPageFinished(final WebView r4, String r5) {
            FLogger.a.i("HalfFragment", "onPageFinished url:" + r5);
            e1 r6 = this.a.n;
            if (r6 == null) goto L5;
            r6.b("load");
        L5:
            e1 r7 = this.a.n;
            boolean r0 = true;
            if (r7 == null) goto L8;
            r7.a(1);
        L8:
            if (r4 == null) goto L11;
            final HalfWebFragment r8 = this.a;
            r4.setOnTouchListener(new v(r8, r4));
        L11:
            if (r4 == null) goto L17;
            String r9 = r4.getTitle();
            if (r9 == null) goto L17;
            if (com.larus.utils.o0.d(r9) != true) goto L17;
        L18:
            if (r0 == false) goto L25;
            HalfWebFragment r10 = this.a;
            if (r10.q == true) goto L25;
            LarusBaseWebDialogFragmentBinding r11 = r10.d;
            if (r11 == null) goto L24;
            com.larus.utils.e1.o(r11.d);
            com.larus.utils.e1.o(r11.c);
            com.larus.utils.e1.x(r11.f);
        L24:
            this.a.q = false;
            return;
        L25:
            final HalfWebFragment r12 = this.a;
            LarusBaseWebDialogFragmentBinding r13 = r12.d;
            if (r13 == null) goto L30;
            com.larus.utils.e1.o(r13.d);
            com.larus.utils.e1.x(r13.c);
            com.larus.utils.e1.o(r13.f);
            r13.c.setOnClickListener(new i(r12));
            return;
        L30:
            return;
        L17:
            r0 = false;
            goto L18
        }

        public final void onReceivedTitle(WebView r3, String r4) {
            FLogger.a.i("HalfFragment", "onReceivedTitle title:" + r4);
        }

        public final boolean shouldOverrideUrlLoading(WebView r6, String r7) {
            Intrinsics.checkNotNull(r7);
            if (StringsKt.startsWith$default(r7, "http", false, 2, null) == false) goto L11;
            return false;
        L11:
            FLogger.a.i("HalfFragment", "shouldOverrideUrlLoading http url:" + r7);     // Catch: Exception -> L6
            Intent r1 = new Intent("android.intent.action.VIEW", UriProtector.parse(r7));     // Catch: Exception -> L6
            r1.setFlags(805306368);     // Catch: Exception -> L6
            this.a.requireActivity().startActivity(r1);     // Catch: Exception -> L6
            return true;
        L6:
            e = move-exception;
            FLogger.a.w("HalfFragment", "shouldOverrideUrlLoading http url:" + r7, e);
            return true;
        }

        public final void a(int r4, String r5, String r6) {
            this.a.q = true;
            FLogger.a.w("HalfFragment", "onReceivedError code:" + r4 + " desc:" + r5 + " url:" + r6);
        }
    }

    public static final class c extends ix7.d.a {
        public final /* synthetic */ HalfWebFragment a;

        public c(HalfWebFragment r1) {
            this.a = r1;
        }

        public final void d(View r9) {
            Intrinsics.checkNotNullParameter(r9, "view");
            if ((r9 instanceof WebView) == true) goto L6;
            r9 = null;
        L6:
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.webkit.WebView");
            WebView r10 = (WebView) r9;
            HalfWebFragment r0 = this.a;
            boolean r2 = StringsKt.equals(UriProtector.parse(r0.m).getScheme(), "file", true);
            boolean r3 = StringsKt.equals(UriProtector.parse(r0.m).getScheme(), "content", true);
            r10.getSettings().setAllowFileAccess(true);
            WebSettings r5 = r10.getSettings();
            boolean r6 = false;
            if (r2 == true) goto L10;
            if (r3 == true) goto L10;
            boolean r4 = true;
        L11:
            r5.setJavaScriptEnabled(r4);
            WebSettings r7 = r10.getSettings();
            String r1 = r0.m;
            if (r1 == null) goto L23;
            Function0 r8 = SearchServiceImpl.a.b;
            if (r8 == null) goto L23;
            List r11 = (List) r8.invoke();
            if (r11 == null) goto L23;
            Iterator r12 = r11.iterator();
        L19:
            if (r12.hasNext() == false) goto L23;
            if (StringsKt.contains$default(r1, (String) r12.next(), false, 2, null) == false) goto L19;
            r6 = true;
        L23:
            r7.setDomStorageEnabled(r6);
            r10.getSettings().setMixedContentMode(2);
            int r13 = Build.VERSION.SDK_INT;
            if (r13 != 24) goto L26;
        L27:
            r10.setLayerType(1, null);
            return;
        L26:
            if (r13 == 25) goto L27;
            return;
        L10:
            r4 = false;
            goto L11
        }
    }

    static {
    }

    public final void T90() {
        PluginWebView r0 = this.p;     // Catch: Exception -> L27
        if (r0 == null) goto L5;
        r0.k();     // Catch: Exception -> L27
    L5:
        IIvyWebService.Companion r1 = IIvyWebService.a;     // Catch: Exception -> L27
        String r2 = this.l;     // Catch: Exception -> L27
        lx7.a r3 = this.o;     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L27
        kx7.c r4 = r1.b(r2, r3, requireContext());     // Catch: Exception -> L27
        this.p = r4;     // Catch: Exception -> L27
        if (r4 == null) goto L21;
        View r5 = r4.f();     // Catch: Exception -> L27
        if (r5 == null) goto L21;
        LarusBaseWebDialogFragmentBinding r6 = this.d;     // Catch: Exception -> L27
        FrameLayout r7 = null;
        if (r6 == null) goto L12;
        FrameLayout r8 = r6.f;     // Catch: Exception -> L27
    L13:
        if (r8 == null) goto L15;
        r8.removeAllViews();     // Catch: Exception -> L27
    L15:
        LarusBaseWebDialogFragmentBinding r9 = this.d;     // Catch: Exception -> L27
        if (r9 == null) goto L18;
        r7 = r9.f;     // Catch: Exception -> L27
    L18:
        if (r7 == null) goto L20;
        r7.addView(r5, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L27
    L20:
        r5.setOnKeyListener(new u(this));     // Catch: Exception -> L27
        goto L21
    L12:
        r8 = null;
    L21:
        String r10 = this.m;     // Catch: Exception -> L27
        if (r10 == null) goto L32;
        kx7.c r11 = this.p;     // Catch: Exception -> L27
        if (r11 == null) goto L33;
        r11.d(r10);     // Catch: Exception -> L27
        return;
    L33:
        return;
    L32:
        return;
    L27:
        e = move-exception;
        FLogger.a.e("HalfFragment", "createHybridKit: " + e);
    }

    @Override // com.larus.search.impl.BaseWebDialogFragment
    public final void onRefresh() {
        onLoading();     // Catch: Exception -> L27
        boolean r1 = false;
        this.q = false;     // Catch: Exception -> L27
        FLogger.a.i("HalfFragment", "click reload");     // Catch: Exception -> L27
        kx7.c r2 = this.p;     // Catch: Exception -> L27
        String r3 = null;
        if (r2 == null) goto L6;
        String r4 = r2.i();     // Catch: Exception -> L27
    L8:
        if (Intrinsics.areEqual(r4, this.m) == false) goto L10;
        T90();     // Catch: Exception -> L27
        return;
    L10:
        kx7.c r5 = this.p;     // Catch: Exception -> L27
        if (r5 == null) goto L13;
        r3 = r5.i();     // Catch: Exception -> L27
    L13:
        if (r3 != null) goto L15;
    L16:
        r1 = true;
    L17:
        if (r1 == false) goto L23;
        String r6 = this.m;     // Catch: Exception -> L27
        if (r6 == null) goto L32;
        kx7.c r7 = this.p;     // Catch: Exception -> L27
        if (r7 == null) goto L33;
        r7.d(r6);     // Catch: Exception -> L27
        return;
    L33:
        return;
    L32:
        return;
    L23:
        kx7.c r8 = this.p;     // Catch: Exception -> L27
        if (r8 == null) goto L35;
        r8.g();     // Catch: Exception -> L27
        return;
    L35:
        return;
    L15:
        if (r3.length() != 0) goto L17;
    L6:
        r4 = null;
    L27:
        e = move-exception;
        FLogger.a.i("HalfFragment", "click reload error: " + e);
    }

    public HalfWebFragment() {
        this.l = "aweme://half_webview/?url=";
        this.n = com.larus.platform.service.g.a.h("HalfWebFragment");
    }

    @Override // com.larus.search.impl.BaseWebDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        com.larus.platform.service.g.a.g("HalfFragment");
        FLogger.a.i("HalfFragment", "onDestroy");
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        PluginWebView r0 = this.p;
        if (r0 == null) goto L5;
        r0.k();
    L5:
        FLogger.a.i("HalfFragment", "onDestroyView");
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        e1 r0 = this.n;
        if (r0 == null) goto L5;
        r0.b("create");
    L5:
        e1 r1 = this.n;
        if (r1 == null) goto L9;
        r1.c("load");
        return;
    }

    @Override // com.larus.search.impl.BaseWebDialogFragment
    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        e1 r12 = this.n;
        if (r12 == null) goto L5;
        r12.startTrace();
    L5:
        e1 r13 = this.n;
        if (r13 == null) goto L8;
        r13.c("create");
    L8:
        com.larus.platform.service.g.a.e("HalfFragment");
        Bundle r14 = getArguments();
        View r1 = null;
        if (r14 == null) goto L11;
        String r15 = r14.getString("link_url");
    L12:
        this.m = r15;
        FLogger.a.i("HalfFragment", "onCreate url:" + this.m);
        BottomSheetDialog r16 = getDialog();
        if ((r16 instanceof BottomSheetDialog) == false) goto L15;
        BottomSheetDialog r17 = r16;
    L16:
        if (r17 == null) goto L18;
        r1 = r17.findViewById(2131368870);
    L18:
        if (r1 == null) goto L20;
        r1.setBackgroundResource(R.color.transparent);
        this.r = BottomSheetBehavior.from(r1);
    L20:
        this.o = IIvyWebService.a.a(IIvyWebService.a, com.larus.ivykit.c.a(), this.l, new b(this), new c(this), null, null, null, null, 496);
        return;
    L15:
        r17 = null;
        goto L16
    L11:
        r15 = null;
        goto L12
    }

    public final boolean S90(String r5, Map<String, String> r6) {
        String r7 = r6.get("Referer");
        ts9.a r0 = SearchServiceImpl.a;
        List r1 = SearchServiceImpl.a.e;
        if (r5 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
    L12:
        if (r7 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == false) goto L20;
        return false;
    L20:
        if (CollectionsKt.contains(r1, UriProtector.parse(r7).getHost()) == false) goto L24;
    L21:
        return true;
    L24:
        return false;
    L14:
        if (r7.length() == 0) goto L17;
        r8 = false;
        goto L18
    L11:
        if (CollectionsKt.contains(r1, UriProtector.parse(r5).getHost()) == true) goto L21;
    L5:
        if (r5.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.larus.search.impl.BaseWebDialogFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        T90();
        FLogger.a.i("HalfFragment", "onViewCreated load kitViewDelegate=" + this.p);
    }
}
