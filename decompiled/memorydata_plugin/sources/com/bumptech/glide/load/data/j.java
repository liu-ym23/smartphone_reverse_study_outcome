package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j implements d<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.a.h f690b;
    private final int c;
    private final b d;
    private HttpURLConnection e;
    private InputStream f;
    private volatile boolean g;

    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL r2) {
            return (HttpURLConnection) ZeusTransformUtils.preCheckCast(r2.openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");
        }
    }

    interface b {
        HttpURLConnection a(URL r1);
    }

    static {
        f689a = new a();
    }

    public j(com.bumptech.glide.load.a.h r2, int r3) {
        this(r2, r3, f689a);
    }

    j(com.bumptech.glide.load.a.h r3, int r4, b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        this.f690b = r3;
        this.c = r4;
        this.d = r6;
    }

    private static int a(HttpURLConnection r2) {
        return r2.getResponseCode();
    L4:
        e = move-exception;
        if (Log.isLoggable("HttpUrlFetcher", 3) == false) goto L12;
        Log.d("HttpUrlFetcher", "Failed to get a response code", e);
        return -1;
    L12:
        return -1;
    }

    private InputStream a(URL r3, int r4, URL r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r4 >= 5) goto L44;
        if (r5 != null) goto L52;
    L10:
        HttpURLConnection r8 = a(r3, r7);
        this.e = r8;
        r8.connect();     // Catch: IOException -> L40
        this.f = this.e.getInputStream();     // Catch: IOException -> L40
        if (this.g == false) goto L16;
        return null;
    L16:
        int r9 = a(this.e);
        if (a(r9) == false) goto L21;
        return b(this.e);
    L21:
        if (b(r9) == false) goto L32;
        String r0 = this.e.getHeaderField("Location");
        if (TextUtils.isEmpty(r0) == true) goto L31;
        URL r1 = new URL(r3, r0);     // Catch: MalformedURLException -> L27
        b();
        return a(r1, r4 + 1, r3, r7);
    L27:
        e = move-exception;
        throw new HttpException("Bad redirect url: " + r0, r9, e);
    L31:
        throw new HttpException("Received empty or null redirect url", r9);
    L32:
        if (r9 == (-1)) goto L34;
    L37:
        e = move-exception;
        throw new HttpException("Failed to get a response message", r9, e);
    L36:
        throw new HttpException(this.e.getResponseMessage(), r9);     // Catch: IOException -> L37
    L34:
        throw new HttpException(r9);
    L40:
        e = move-exception;
        throw new HttpException("Failed to connect or obtain data", a(this.e), e);
    L52:
        if (r3.toURI().equals(r5.toURI()) == false) goto L10;
        throw new HttpException("In re-direct loop", -1);     // Catch: URISyntaxException -> L45
    L44:
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    private HttpURLConnection a(URL r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        HttpURLConnection r9 = this.d.a(r6);     // Catch: IOException -> L10
        Iterator r10 = r8.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r9.addRequestProperty((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L6
    L8:
        r9.setConnectTimeout(this.c);
        r9.setReadTimeout(this.c);
        r9.setUseCaches(false);
        r9.setDoInput(true);
        r9.setInstanceFollowRedirects(false);
        return r9;
    L10:
        e = move-exception;
        throw new HttpException("URL.openConnection threw", 0, e);
    }

    private static boolean a(int r1) {
        if ((r1 / 100) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private InputStream b(HttpURLConnection r5) {
    L14:
        e = move-exception;
        throw new HttpException("Failed to obtain InputStream", a(r5), e);
    L4:
        if (TextUtils.isEmpty(r5.getContentEncoding()) == false) goto L8;
        InputStream r0 = com.bumptech.glide.util.b.a(r5.getInputStream(), r5.getContentLength());     // Catch: IOException -> L14
    L6:
        this.f = r0;     // Catch: IOException -> L14
        return this.f;
    L8:
        if (Log.isLoggable("HttpUrlFetcher", 3) == false) goto L10;
        Log.d("HttpUrlFetcher", "Got non empty content encoding: " + r5.getContentEncoding());     // Catch: IOException -> L14
    L10:
        r0 = r5.getInputStream();     // Catch: IOException -> L14
        goto L6
    }

    private static boolean b(int r1) {
        if ((r1 / 100) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void a(Priority r9, d.a<? super InputStream> r10) {
        d.a r11 = (d.a) ZeusTransformUtils.wrapperContextForParams(r10, d.a.class, "com.obric.memorydata.plugin");
        long r1 = com.bumptech.glide.util.f.a();
        r11.a(a(this.f690b.a(), 0, null, this.f690b.b()));     // Catch: Throwable -> L7 IOException -> L9
    L5:
        if (Log.isLoggable("HttpUrlFetcher", 2) == false) goto L26;
        StringBuilder r8 = new StringBuilder();
    L18:
        Log.v("HttpUrlFetcher", r8.append("Finished http url fetcher fetch in ").append(com.bumptech.glide.util.f.a(r1)).toString());
        return;
    L26:
        return;
    L7:
        th = move-exception;
        if (Log.isLoggable("HttpUrlFetcher", 2) == false) goto L23;
        Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.bumptech.glide.util.f.a(r1));
    L23:
        throw th;
    L9:
        e = move-exception;
        if (Log.isLoggable("HttpUrlFetcher", 3) == false) goto L14;
        Log.d("HttpUrlFetcher", "Failed to load data for url", e);     // Catch: Throwable -> L7
    L14:
        r11.a(e);     // Catch: Throwable -> L7
        if (Log.isLoggable("HttpUrlFetcher", 2) == false) goto L27;
        r8 = new StringBuilder();
        goto L18
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream r0 = this.f;
        if (r0 != null) goto L11;
    L5:
        HttpURLConnection r1 = this.e;
        if (r1 == null) goto L8;
        r1.disconnect();
    L8:
        this.e = null;
        return;
    L11:
        r0.close();     // Catch: IOException -> L10
        goto L5
    }

    @Override // com.bumptech.glide.load.data.d
    public void c() {
        this.g = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public DataSource d() {
        return DataSource.REMOTE;
    }
}
