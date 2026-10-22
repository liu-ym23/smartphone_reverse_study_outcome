package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0.g f1432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HttpURLConnection f1434c;
    public InputStream d;
    public volatile boolean e;

    static {
    }

    public l(d0.g r5, int r10) {
        this.f1432a = r5;
        this.f1433b = r10;
    }

    public final InputStream a(URL r5, int r10, URL r11, Map r12) {
        if (r10 >= 5) goto L43;
        if (r11 != null) goto L45;
    L10:
        this.f1434c = (HttpURLConnection) r5.openConnection();
        Iterator r13 = r12.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r13.next();
        this.f1434c.addRequestProperty((String) r14.getKey(), (String) r14.getValue());
        goto L12
    L14:
        this.f1434c.setConnectTimeout(this.f1433b);
        this.f1434c.setReadTimeout(this.f1433b);
        this.f1434c.setUseCaches(false);
        this.f1434c.setDoInput(true);
        this.f1434c.setInstanceFollowRedirects(false);
        this.f1434c.connect();
        this.d = this.f1434c.getInputStream();
        if (this.e == false) goto L18;
        return null;
    L18:
        int r15 = this.f1434c.getResponseCode();
        int r16 = r15 / 100;
        if (r16 != 2) goto L29;
        HttpURLConnection r17 = this.f1434c;
        if (TextUtils.isEmpty(r17.getContentEncoding()) == false) goto L24;
        this.d = new q0.c(r17.getInputStream(), r17.getContentLength());
    L28:
        return this.d;
    L24:
        if (Log.isLoggable("HttpUrlFetcher", 3) == false) goto L26;
        Log.d("HttpUrlFetcher", "Got non empty content encoding: " + r17.getContentEncoding());
    L26:
        this.d = r17.getInputStream();
        goto L28
    L29:
        if (r16 != 3) goto L37;
        String r18 = this.f1434c.getHeaderField("Location");
        if (TextUtils.isEmpty(r18) == true) goto L35;
        URL r19 = new URL(r5, r18);
        b();
        return a(r19, r10 + 1, r5, r12);
    L35:
        throw new HttpException("Received empty or null redirect url");
    L37:
        if (r15 != (-1)) goto L41;
        throw new HttpException(r15);
    L41:
        throw new HttpException(this.f1434c.getResponseMessage(), r15);
    L45:
        if (r5.toURI().equals(r11.toURI()) == false) goto L10;
        throw new HttpException("In re-direct loop");     // Catch: URISyntaxException -> L44
    L43:
        throw new HttpException("Too many (> 5) redirects!");
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        InputStream r5 = this.d;
        if (r5 != null) goto L11;
    L5:
        HttpURLConnection r10 = this.f1434c;
        if (r10 == null) goto L8;
        r10.disconnect();
    L8:
        this.f1434c = null;
        return;
    L11:
        r5.close();     // Catch: IOException -> L10
        goto L5
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.e = true;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource d() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(Priority r10, d r11) {
        d0.g r12 = this.f1432a;
        int r5 = q0.f.f21454b;
        long r13 = SystemClock.elapsedRealtimeNanos();
    L13:
        e = move-exception;
        if (Log.isLoggable("HttpUrlFetcher", 3) == false) goto L18;
        Log.d("HttpUrlFetcher", "Failed to load data for url", e);     // Catch: Throwable -> L11
    L18:
        r11.a(e);     // Catch: Throwable -> L11
        if (Log.isLoggable("HttpUrlFetcher", 2) == false) goto L31;
        StringBuilder r14 = new StringBuilder("Finished http url fetcher fetch in ");
    L10:
        r14.append(q0.f.a(r13));
        Log.v("HttpUrlFetcher", r14.toString());
        return;
    L31:
        return;
    L11:
        th = move-exception;
        if (Log.isLoggable("HttpUrlFetcher", 2) == false) goto L26;
        Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + q0.f.a(r13));
    L26:
        throw th;
    L4:
        if (r12.f != null) goto L6;
        r12.f = new URL(r12.d());     // Catch: Throwable -> L11 IOException -> L13
    L6:
        r11.f(a(r12.f, 0, null, r12.f16545b.b()));     // Catch: Throwable -> L11 IOException -> L13
    L8:
        if (Log.isLoggable("HttpUrlFetcher", 2) == false) goto L22;
        r14 = new StringBuilder("Finished http url fetcher fetch in ");
        goto L10
    }
}
