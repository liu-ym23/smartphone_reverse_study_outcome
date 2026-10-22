package com.obric.assistant.guide.ui;

import android.content.Intent;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricActivityRecordAudioRuleWebviewBinding;
import com.obric.capabilitykit.common.Ext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y extends WebViewClient {
    public final /* synthetic */ ObricRecordAudioRuleWebViewActivity a;
    public final /* synthetic */ ObricActivityRecordAudioRuleWebviewBinding b;

    public y(ObricRecordAudioRuleWebViewActivity r1, ObricActivityRecordAudioRuleWebviewBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r1, String r2) {
        this.b.c.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r5, RenderProcessGoneDetail r6) {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        boolean r0 = false;
        if (r6 != null) goto L7;
    L9:
        if (r0 == false) goto L11;
        String r7 = "crashed";
    L13:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("Render process ");
        r2.append(r7);
        r2.append(". WebView URL: ");
        if (r5 == null) goto L16;
        String r8 = r5.getUrl();
    L17:
        r2.append(r8);
        r1.e("ObricRecordAudioRuleWebViewActivity", r2.toString());
        return true;
    L16:
        r8 = null;
        goto L17
    L11:
        r7 = "killed by system";
        goto L13
    L7:
        if (r6.didCrash() != true) goto L9;
        r0 = true;
        goto L9
    L12:
        r7 = "unknown reason";
        goto L13
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r5, WebResourceRequest r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, Ext.KEY_REQUEST);
        String r7 = r6.getUrl().toString();
        if (StringsKt.startsWith$default(r7, "mailto:", false, 2, null) == false) goto L8;
        Intent r8 = new Intent("android.intent.action.SENDTO", UriProtector.parse(r7));
        if (r8.resolveActivity(this.a.getPackageManager()) == null) goto L7;
        this.a.startActivity(r8);
    L7:
        return true;
    L8:
        r5.loadUrl(r7);
        return true;
    }
}
