package com.ttnet.org.chromium.net.urlconnection;

import android.text.TextUtils;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class CronetHttpURLConnection$CronetUrlRequestCallback extends UrlRequest.Callback {
    final /* synthetic */ CronetHttpURLConnection this$0;

    public CronetHttpURLConnection$CronetUrlRequestCallback(CronetHttpURLConnection r1) {
        this.this$0 = r1;
    }

    private void setResponseDataCompleted(IOException r2) {
        CronetHttpURLConnection.access$1202(this.this$0, r2);
        if (CronetHttpURLConnection.access$1400(this.this$0) == null) goto L6;
        CronetHttpURLConnection.access$1400(this.this$0).setResponseDataCompleted(r2);
    L6:
        if (CronetHttpURLConnection.access$1500(this.this$0) == null) goto L8;
        CronetHttpURLConnection.access$1500(this.this$0).setRequestCompleted(r2);
    L8:
        CronetHttpURLConnection.access$102(this.this$0, true);
        CronetHttpURLConnection.access$1600(this.this$0).set(true);
        CronetHttpURLConnection.access$400(this.this$0).quit();
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest r2, UrlResponseInfo r3) {
        CronetHttpURLConnection.access$002(this.this$0, r3);
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetHttpURLConnection", "onCanceled loop quit url = " + this.this$0.getURL().toString());
    L6:
        if (CronetHttpURLConnection.access$1200(this.this$0) == null) goto L8;
    L10:
        setResponseDataCompleted(CronetHttpURLConnection.access$1200(this.this$0));
        return;
    L8:
        if (CronetHttpURLConnection.access$500(this.this$0) == true) goto L10;
        CronetHttpURLConnection.access$1202(this.this$0, new TTRequestCanceledException("request canceled, ErrorCode=11, InternalErrorCode=-999"));
        goto L10
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest r1, UrlResponseInfo r2) {
        CronetHttpURLConnection.access$002(this.this$0, r2);
        setResponseDataCompleted(null);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest r2, UrlResponseInfo r3, CronetException r4) {
        if (r4 == null) goto L6;
        CronetHttpURLConnection r5 = this.this$0;
        CronetHttpURLConnection.access$1202(r5, CronetHttpURLConnection.access$1300(r5, r4));
        CronetHttpURLConnection.access$002(this.this$0, r3);
        setResponseDataCompleted(r4);
        return;
    L6:
        throw new IllegalStateException("Exception cannot be null in onFailed.");
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest r1, UrlResponseInfo r2, ByteBuffer r3) {
        CronetHttpURLConnection.access$002(this.this$0, r2);
        CronetHttpURLConnection.access$400(this.this$0).quit();
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest r4, UrlResponseInfo r5, String r6) {
        CronetHttpURLConnection.access$002(this.this$0, r5);
        CronetHttpURLConnection.access$102(this.this$0, true);
        if (CronetHttpURLConnection.access$000(this.this$0) == null) goto L8;
        long r0 = System.nanoTime();
        CronetHttpURLConnection r7 = this.this$0;
        CronetHttpURLConnection.access$300(r7, r6, CronetHttpURLConnection.access$200(r7));
        long r8 = (System.nanoTime() - r0) / 1000;
        if (r4 == null) goto L8;
        r4.setSaveCookieCostUs(r8);
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("CronetHttpURLConnection", "onResponseStarted loop quit url = " + this.this$0.getURL().toString());
    L10:
        CronetHttpURLConnection.access$400(this.this$0).quit();
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest r4, UrlResponseInfo r5, String r6, String r7) {
        boolean r0 = true;
        CronetHttpURLConnection.access$502(this.this$0, true);
        if (r5 == null) goto L5;
        CronetHttpURLConnection.access$300(this.this$0, r7, r5.getAllHeaders());
    L5:
        URL r8 = CronetHttpURLConnection.access$600(this.this$0);
        if (TextUtils.isEmpty(r7) == true) goto L43;
        r8 = new URL(r7);     // Catch: Throwable -> L40
    L43:
        URL r9 = new URL(r6);     // Catch: MalformedURLException -> L35
        if (CronetHttpURLConnection.access$700(this.this$0) == false) goto L13;
        CronetHttpURLConnection.access$802(this.this$0, r9);     // Catch: MalformedURLException -> L35
    L13:
        if (CronetHttpURLConnection.access$900(this.this$0) == false) goto L36;
        if (CronetHttpURLConnection.access$1000(this.this$0) != null) goto L17;
        return;
    L17:
        if ("http".equals(r9.getProtocol()) == true) goto L19;
    L21:
        r0 = false;
    L23:
        if (r9.getHost().equals(r8.getHost()) == false) goto L25;
        if (r0 == true) goto L25;
    L33:
        CronetHttpURLConnection.access$1000(this.this$0).followRedirect();     // Catch: MalformedURLException -> L35
        return;
    L25:
        CronetHttpURLConnection.access$1000(this.this$0).RemoveRequestCookieHeader();     // Catch: MalformedURLException -> L35
        URL r10 = new URL(r6);     // Catch: MalformedURLException -> L35
        CronetHttpURLConnection r11 = this.this$0;     // Catch: MalformedURLException -> L35
        Map r12 = CronetHttpURLConnection.access$1100(r11, r11.uri(r10));     // Catch: MalformedURLException -> L35
        if (r12 == null) goto L33;
        if (r12.isEmpty() == true) goto L33;
        Iterator r13 = r12.entrySet().iterator();     // Catch: MalformedURLException -> L35
    L31:
        if (r13.hasNext() == false) goto L33;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: MalformedURLException -> L35
        CronetHttpURLConnection.access$1000(this.this$0).AddRequestCookieHeader((String) r14.getKey(), (String) r14.getValue());     // Catch: MalformedURLException -> L35
        goto L31
    L19:
        if ("https".equals(r8.getProtocol()) == false) goto L21;
    L36:
        CronetHttpURLConnection.access$002(this.this$0, r5);
        if (CronetHttpURLConnection.access$1000(this.this$0) == null) goto L47;
        CronetHttpURLConnection.access$1000(this.this$0).cancel();
        return;
    }
}
