package com.ss.android.lark.conditional.access.nopermission.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0003J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/UnknownNoPermissionFragment;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionFragment;", "<init>", "()V", "rawAction", BuildConfig.FLAVOR, "onViewCreated", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "initWebView", "parseData", "onPageUpdate", "adaptUI", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnknownNoPermissionFragment extends Hilt_UnknownNoPermissionFragment {
    public String j;

    public static final class a {
    }

    public static final class b extends WebViewClient {
        public final /* synthetic */ UnknownNoPermissionFragment a;

        public b(UnknownNoPermissionFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r2, WebResourceRequest r3, WebResourceError r4) {
            super.onReceivedError(r2, r3, r4);
            if (r3 == null) goto L7;
            boolean r0 = true;
            if (r3.isForMainFrame() != true) goto L7;
        L8:
            if (r0 == true) goto L10;
            return;
        L10:
            if (Build.VERSION.SDK_INT < 23) goto L19;
            int r5 = ScsLogger.a;
            StringBuilder r6 = new StringBuilder("url: ");
            r6.append(r3.getUrl());
            r6.append(", code: ");
            CharSequence r7 = null;
            if (r4 == null) goto L14;
            Integer r1 = Integer.valueOf(r4.getErrorCode());
        L15:
            r6.append(r1);
            r6.append(", message: ");
            if (r4 == null) goto L18;
            r7 = r4.getDescription();
        L18:
            r6.append(r7);
            ScsLogger.c("SecurityPolicy_UnknownNoPermissionFragment", r6.toString());
            goto L19
        L14:
            r1 = null;
        L19:
            FileAuthMonitor.UpdateTrigger[] r8 = FileAuthMonitor.a;
            InternalSecurityAction r9 = this.a.g;
            if (r9 == null) goto L23;
            String r10 = r9.parseToPrint();
            if (r10 == null) goto L23;
        L24:
            FileAuthMonitor.o("RESPONSE_HEADER", r10, "unknownNoPermissionError");
            return;
        L23:
            r10 = BuildConfig.FLAVOR;
        L7:
            r0 = false;
            goto L8
        }
    }

    static {
    }

    public UnknownNoPermissionFragment() {
        super(NoPermissionType.UNKNOWN);
        this.j = BuildConfig.FLAVOR;
    }

    public final void Y90() {
        NoPermissionActivity r0 = requireActivity();
        if ((r0 instanceof NoPermissionActivity) == false) goto L13;
        NoPermissionActivity r1 = r0;
        NoPermissionActivity.d r2 = r1.d;
        NoPermissionActivity.d r3 = null;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L7:
        r2.b().setFitsSystemWindows(false);
        NoPermissionActivity.d r4 = r1.d;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L11:
        t4c.b.a(r3.e());
        return;
    L10:
        r3 = r4;
        goto L11
    }

    public final void initWebView() {
        t4c.b.b(S90().k);
        S90().k.setWebViewClient(new b(this));
        WebSettings r0 = S90().k.getSettings();
        r0.setJavaScriptEnabled(true);
        r0.setAllowContentAccess(true);
        r0.setDisplayZoomControls(false);
        r0.setSupportZoom(false);
        r0.setBuiltInZoomControls(false);
        r0.setUseWideViewPort(true);
        r0.setLoadWithOverviewMode(true);
        S90().k.setVerticalScrollBarEnabled(false);
        S90().k.setHorizontalScrollBarEnabled(false);
        String r1 = v4c.a.a("security_web");
        String r2 = StringsKt.replace$default(((apb.a) e0c.k.a(requireActivity().getApplication(), apb.a.class)).g(), '_', '-', false, 4, null);
        HttpMethod r5 = HttpMethod.POST;
        new HttpParams();
        HttpHeaders r7 = new HttpHeaders();
        LinkedHashMap r3 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r1, "host");
        Intrinsics.checkNotNullParameter("/conditionalaccess/fallback", "path");
        HttpParams r6 = new HttpParams();
        r6.put("language", r2, new boolean[0]);
        r6.put("decision", this.j, new boolean[0]);
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r4 = new com.ss.android.lark.security.compliance.infra.network.a("/conditionalaccess/fallback", r5, r6, r7, new JSONObject(r3), true);
        r4.c(r1);
        String r8 = r4.getUrl();
        int r9 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UnknownNoPermissionFragment", "initWebView, encoded url is " + r8);
        FileAuthMonitor.UpdateTrigger[] r10 = FileAuthMonitor.a;
        FileAuthMonitor.l("webview", this.g);
        S90().k.loadUrl(r8);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment, com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        super.onPageUpdate();
        Y90();
        InternalSecurityAction r0 = this.g;
        if (r0 == null) goto L6;
        String r1 = r0.getRawActions();
        if (r1 == null) goto L6;
    L7:
        this.j = r1;
        initWebView();
        return;
    L6:
        r1 = BuildConfig.FLAVOR;
        goto L7
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ScsLogger.d("SecurityPolicy_UnknownNoPermissionFragment", "onViewCreated");
        InternalSecurityAction r4 = this.g;
        if (r4 == null) goto L6;
        String r5 = r4.getRawActions();
        if (r5 == null) goto L6;
    L7:
        this.j = r5;
        Y90();
        t4c.b.a(S90().f);
        t4c.b.a(S90().e.a);
        initWebView();
        return;
    L6:
        r5 = BuildConfig.FLAVOR;
        goto L7
    }
}
