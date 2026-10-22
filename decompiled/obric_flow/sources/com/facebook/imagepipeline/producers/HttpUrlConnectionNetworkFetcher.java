package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<HttpUrlConnectionNetworkFetchState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f8309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RealtimeSinceBootClock f8310c;

    public static class HttpUrlConnectionNetworkFetchState extends FetchState {
        public long d;
        public long e;
        public long f;

        public HttpUrlConnectionNetworkFetchState(Consumer r5, ProducerContext r10) {
            super(r5, r10);
        }
    }

    public HttpUrlConnectionNetworkFetcher() {
        RealtimeSinceBootClock r5 = RealtimeSinceBootClock.get();
        this.f8309b = Executors.newFixedThreadPool(3);
        this.f8310c = r5;
        this.f8308a = 30000;
    }

    public final HttpURLConnection a(Uri r5, int r10) {
        Uri r11 = UriUtil.f7699a;
        Uri r12 = null;
        if (r5 != null) goto L37;
        URL r13 = null;
    L6:
        HttpURLConnection r14 = (HttpURLConnection) r13.openConnection();
        r14.setConnectTimeout(this.f8308a);
        int r15 = r14.getResponseCode();
        if (r15 < 200) goto L12;
        if (r15 >= 300) goto L12;
        return r14;
    L12:
        if (r15 != 307) goto L14;
    L18:
        String r16 = r14.getHeaderField("Location");
        r14.disconnect();
        if (r16 == null) goto L22;
        r12 = Uri.parse(r16);
    L22:
        String r17 = r5.getScheme();
        if (r10 <= 0) goto L29;
        if (r12 == null) goto L29;
        if (r12.getScheme().equals(r17) == true) goto L29;
        return a(r12, r10 - 1);
    L29:
        if (r10 != 0) goto L31;
        String r18 = r5.toString();
        Locale.getDefault();
        String r19 = "URL " + r18 + " follows too many redirects";
    L33:
        throw new IOException(r19);
    L31:
        r19 = String.format(Locale.getDefault(), "URL %s returned %d without a valid redirect", new Object[]{r5.toString(), Integer.valueOf(r15)});
        goto L33
    L14:
        if (r15 == 308) goto L18;
        switch(r15) {
            case 300: goto L18;
            case 301: goto L18;
            case 302: goto L18;
            case 303: goto L18;
            default: goto L16;
        };
    L16:
        r14.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[]{r5.toString(), Integer.valueOf(r15)}));
    L37:
        r13 = new URL(r5.toString());     // Catch: MalformedURLException -> L34
    L34:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
