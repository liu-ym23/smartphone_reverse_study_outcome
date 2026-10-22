package com.ss.android.lark.inline.ai.ui.richtext;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends ws5.c implements ys5.b {
    public final b e;
    public final com.ss.android.lark.inline.ai.ui.richtext.a f;
    public long g;
    public final ConcurrentHashMap<String, String> h;

    public static final class a {
    }

    static {
    }

    public void onPageFinished(WebView r5, String r6) {
        super.onPageFinished(r5, r6);
        long r0 = System.currentTimeMillis() - this.g;
        StringBuilder r2 = new StringBuilder("onPageFinished = ");
        if (r5 == null) goto L5;
        Integer r7 = Integer.valueOf(r5.hashCode());
    L6:
        r2.append(r7);
        r2.append(" , url = ");
        r2.append(r6);
        r2.append(" , cost time = ");
        r2.append(r0);
        Log.i("RichtextPreviewWebViewClient", r2.toString());
        com.ss.android.lark.inline.ai.ui.richtext.a r8 = this.f;
        if (r8 == null) goto L9;
        r8.onPageFinished();
    L9:
        int r9 = zlb.a.d;
        zlb.a.C0355a.e(0, "", (int) r0);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final boolean onRenderProcessGone(WebView r3, RenderProcessGoneDetail r4) {
        StringBuilder r0 = new StringBuilder("onRenderProcessGone = ");
        Integer r1 = null;
        if (r3 == null) goto L5;
        Integer r5 = Integer.valueOf(r3.hashCode());
    L6:
        r0.append(r5);
        r0.append(" , detail?.didCrash = ");
        if (r4 == null) goto L9;
        Boolean r6 = Boolean.valueOf(r4.didCrash());
    L10:
        r0.append(r6);
        r0.append(" , detail?.rendererPriorityAtExit = ");
        if (r4 == null) goto L13;
        r1 = Integer.valueOf(r4.rendererPriorityAtExit());
    L13:
        r0.append(r1);
        Log.w("RichtextPreviewWebViewClient", r0.toString());
        b r7 = this.e;
        if (r7 == null) goto L18;
        r7.a(r4);
        return true;
    L18:
        return true;
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007f -> B:65:0x0080). Please report as a decompilation issue!!! */
    public final WebResourceResponse shouldInterceptRequest(WebView r11, WebResourceRequest r12) {
        if (r12 == null) goto L5;
        Uri r3 = r12.getUrl();
    L6:
        Log.i("RichtextPreviewWebViewClient", "shouldInterceptRequest url = " + r3);
        if (r3 == null) goto L62;
        String r4 = r3.getLastPathSegment();
        if (r4 == null) goto L62;
        String r7 = this.h.get(r4);
        Log.i("RichtextPreviewWebViewClient", "getFileStreamByName url.path = " + r4 + " , cachePath = " + r7);
        if (r7 == null) goto L35;
        VFSFiles.b.getClass();
        VFSFile r8 = VFSFiles.b(true).i(r7);
    L23:
        e = move-exception;
        Log.e("RichtextPreviewWebViewClient", "readResponseStream... err happens", e);
    L25:
        InputStream r9 = null;
    L65:
        if (r9 == null) goto L31;
        int r1 = r9.available();     // Catch: Exception -> L33
        if (r1 <= 0) goto L30;
        Log.i("RichtextPreviewWebViewClient", "getFileStreamByName()... mFileStreamCacheMap fileName = " + r4 + " inputStream size: " + r1);     // Catch: Exception -> L33
    L36:
        if (r9 == null) goto L62;
        String r13 = UriProtector.parse(r3.toString()).getPath();
        if (r13 != null) goto L40;
    L58:
        String r14 = "text/html";
    L60:
        return new WebResourceResponse(r14, Charset.defaultCharset().name(), r9);
    L40:
        if (StringsKt.endsWith$default(r13, ".css", false, 2, null) == false) goto L43;
        r14 = "text/css";
        goto L60
    L43:
        if (StringsKt.endsWith$default(r13, ".js", false, 2, null) == false) goto L46;
        r14 = "application/x-javascript";
        goto L60
    L46:
        if (StringsKt.endsWith$default(r13, ".jpg", false, 2, null) == false) goto L48;
    L57:
        r14 = "image/*";
        goto L60
    L48:
        if (StringsKt.endsWith$default(r13, ".gif", false, 2, null) == true) goto L57;
        if (StringsKt.endsWith$default(r13, ".png", false, 2, null) == true) goto L57;
        if (StringsKt.endsWith$default(r13, ".jpeg", false, 2, null) == true) goto L57;
        if (StringsKt.endsWith$default(r13, ".webp", false, 2, null) == true) goto L57;
        if (StringsKt.endsWith$default(r13, ".bmp", false, 2, null) == false) goto L58;
    L30:
        Log.i("RichtextPreviewWebViewClient", "getFileStreamByName()..11.. fileName = ".concat(r4));     // Catch: Exception -> L33
        goto L35
    L31:
        Log.i("RichtextPreviewWebViewClient", "getFileStreamByName()..22.. fileName = ".concat(r4));     // Catch: Exception -> L33
    L33:
        e = move-exception;
        Log.i("RichtextPreviewWebViewClient", "getFileStreamByName()..33.. fileName = " + r4 + "   ===== e = " + e);
        goto L35
    L14:
        if (r8.exists() == false) goto L16;
        r9 = r8.newInputStream();     // Catch: Exception -> L23
        goto L65
    L16:
        if (r11 == null) goto L25;
        Context r10 = r11.getContext();     // Catch: Exception -> L23
        if (r10 == null) goto L25;
        AssetManager r15 = r10.getAssets();     // Catch: Exception -> L23
        if (r15 == null) goto L25;
        r9 = r15.open(r7);     // Catch: Exception -> L23
    L35:
        r9 = null;
    L62:
        return super.shouldInterceptRequest(r11, r12);
    L5:
        r3 = null;
        goto L6
    }

    public final boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2) {
        return super.shouldOverrideUrlLoading(r1, r2);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView r1, String r2) {
        return super.shouldInterceptRequest(r1, r2);
    }

    public boolean shouldOverrideUrlLoading(WebView r1, String r2) {
        return super.shouldOverrideUrlLoading(r1, r2);
    }

    public void onPageStarted(WebView r3, String r4, Bitmap r5) {
        super.onPageStarted(r3, r4, r5);
        this.g = System.currentTimeMillis();
        StringBuilder r0 = new StringBuilder("onPageStarted = ");
        if (r3 == null) goto L5;
        Integer r6 = Integer.valueOf(r3.hashCode());
    L6:
        r0.append(r6);
        r0.append(" , url = ");
        r0.append(r4);
        r0.append(" , favicon = ");
        r0.append(r5);
        Log.i("RichtextPreviewWebViewClient", r0.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onReceivedError(WebView r3, WebResourceRequest r4, WebResourceError r5) {
        super.onReceivedError(r3, r4, r5);
        StringBuilder r0 = new StringBuilder("onReceivedError = ");
        Uri r1 = null;
        if (r3 == null) goto L5;
        Integer r6 = Integer.valueOf(r3.hashCode());
    L6:
        r0.append(r6);
        r0.append(" , request?.url = ");
        if (r4 == null) goto L9;
        r1 = r4.getUrl();
    L9:
        r0.append(r1);
        r0.append(" , error?.errorCode = ");
        r0.append(Integer.valueOf(r5.getErrorCode()));
        Log.w("RichtextPreviewWebViewClient", r0.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onReceivedHttpError(WebView r3, WebResourceRequest r4, WebResourceResponse r5) {
        super.onReceivedHttpError(r3, r4, r5);
        StringBuilder r0 = new StringBuilder("onReceivedHttpError = ");
        Uri r1 = null;
        if (r3 == null) goto L5;
        Integer r6 = Integer.valueOf(r3.hashCode());
    L6:
        r0.append(r6);
        r0.append(" , request.url = ");
        if (r4 == null) goto L9;
        r1 = r4.getUrl();
    L9:
        r0.append(r1);
        r0.append(" , errorResponse?.statusCode = ");
        r0.append(Integer.valueOf(r5.getStatusCode()));
        Log.w("RichtextPreviewWebViewClient", r0.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onReceivedSslError(WebView r3, SslErrorHandler r4, SslError r5) {
        super.onReceivedSslError(r3, r4, r5);
        StringBuilder r0 = new StringBuilder("onReceivedSslError = ");
        Integer r1 = null;
        if (r3 == null) goto L5;
        Integer r6 = Integer.valueOf(r3.hashCode());
    L6:
        r0.append(r6);
        r0.append(" , handler = ");
        r0.append(r4);
        r0.append(" , error.primaryError = ");
        if (r5 == null) goto L9;
        r1 = Integer.valueOf(r5.getPrimaryError());
    L9:
        r0.append(r1);
        Log.w("RichtextPreviewWebViewClient", r0.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }

    public i(k r2, b r3, wlb.e r4, RichtextPreviewWebview.c r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.e = r3;
        this.f = r5;
        ConcurrentHashMap<String, String> r6 = new ConcurrentHashMap();
        this.h = r6;
        if (r4 == null) goto L6;
        r4.j(r6);
        return;
    }

    public final void onReceivedError(WebView r3, int r4, String r5, String r6) {
        super.onReceivedError(r3, r4, r5, r6);
        StringBuilder r0 = new StringBuilder("onReceivedError = ");
        if (r3 == null) goto L5;
        Integer r7 = Integer.valueOf(r3.hashCode());
    L6:
        r0.append(r7);
        r0.append(" , errorCode = ");
        r0.append(r4);
        r0.append(" , description = ");
        r0.append(r5);
        r0.append(" , failingUrl = ");
        r0.append(r6);
        Log.w("RichtextPreviewWebViewClient", r0.toString());
        return;
    L5:
        r7 = null;
        goto L6
    }
}
