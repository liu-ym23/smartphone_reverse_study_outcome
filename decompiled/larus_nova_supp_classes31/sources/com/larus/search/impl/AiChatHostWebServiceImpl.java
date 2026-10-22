package com.larus.search.impl;

import android.os.Bundle;
import com.larus.bmhome.web.IAiChatHostWebService;
import com.larus.network.HttpConst;
import com.larus.platform.model.webview.AbsWebFragment;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/search/impl/AiChatHostWebServiceImpl;", "Lcom/larus/bmhome/web/IAiChatHostWebService;", "<init>", "()V", "getWebFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "webViewScrollCallback", "Lcom/larus/bmhome/web/IWebViewProxyCallback;", "getWebFragmentArguments", "Landroid/os/Bundle;", "config", "Lcom/larus/bmhome/web/HostWebFragmentConfig;", "getUrlForCodePreview", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AiChatHostWebServiceImpl implements IAiChatHostWebService {
    public AiChatHostWebServiceImpl() {
    }

    public final String b() {
        StringBuilder r0 = new StringBuilder();
        HttpConst.a.getClass();
        r0.append(HttpConst.g);
        r0.append("/html-preview/inapp");
        return r0.toString();
    }

    public final AbsWebFragment a(zt8.c r2) {
        WebFragment r0 = new WebFragment();
        r0.A = r2;
        return r0;
    }

    public final Bundle c(zt8.b r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        Bundle r0 = new Bundle();
        r0.putString("link_url", r6.a);
        String r2 = "1";
        if (r6.b == false) goto L5;
        String r1 = "1";
    L6:
        r0.putString("hide_title_bar", r1);
        if (r6.c == false) goto L9;
        String r3 = "1";
    L10:
        r0.putString("is_not_full_page", r3);
        if (r6.d == false) goto L13;
        String r4 = "1";
    L14:
        r0.putString("is_show_progress_bar", r4);
        Integer r5 = r6.e;
        if (r5 == null) goto L18;
        r0.putInt("web_view_bg_color", r5.intValue());
    L18:
        if (r6.f == true) goto L21;
        r2 = "0";
    L21:
        r0.putString("hide_go_forward_and_back", r2);
        r0.putBoolean("bundle_offscreen_pre_raster", r6.g);
        return r0;
    L13:
        r4 = "0";
        goto L14
    L9:
        r3 = "0";
        goto L10
    L5:
        r1 = "0";
        goto L6
    }
}
