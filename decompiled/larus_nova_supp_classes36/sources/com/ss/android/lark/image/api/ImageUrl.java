package com.ss.android.lark.image.api;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ImageUrl implements Key {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private volatile byte[] cacheKeyBytes;
    private Map<String, String> headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getCacheKey().getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl) == false) goto L9;
        String r0 = this.stringUrl;
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = this.url.toString();
    L7:
        this.safeStringUrl = Uri.encode(r0, ALLOWED_URI_CHARS);
    L9:
        return this.safeStringUrl;
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl != null) goto L6;
        this.safeUrl = new URL(getSafeStringUrl());
    L6:
        return this.safeUrl;
    }

    public String getCacheKey() {
        String r0 = this.stringUrl;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.url.toString();
    }

    public String toString() {
        return getCacheKey() + '\n' + this.headers.toString();
    }

    public int hashCode() {
        return (getCacheKey().hashCode() * 31) + this.headers.hashCode();
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    public URL toURL() throws MalformedURLException {
        return getSafeUrl();
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public ImageUrl(String r2) {
        this(r2, new HashMap());
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof ImageUrl) == false) goto L10;
        ImageUrl r5 = (ImageUrl) r4;
        if (getCacheKey().equals(r5.getCacheKey()) == true) goto L7;
        return false;
    L7:
        if (this.headers.equals(r5.headers) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(getCacheKeyBytes());
    }

    public ImageUrl(URL r2) {
        this(r2, new HashMap());
    }

    public ImageUrl(String r3, Map<String, String> r4) {
        this.headers = new HashMap();
        if (TextUtils.isEmpty(r3) == true) goto L10;
        if (r4 == null) goto L8;
        this.stringUrl = r3;
        this.url = null;
        this.headers = r4;
        return;
    L8:
        throw new IllegalArgumentException("Headers must not be null");
    L10:
        throw new IllegalArgumentException("String url must not be empty or null: " + r3);
    }

    public ImageUrl(URL r2, Map<String, String> r3) {
        this.headers = new HashMap();
        if (r2 == null) goto L10;
        if (r3 == null) goto L8;
        this.url = r2;
        this.stringUrl = null;
        this.headers = r3;
        return;
    L8:
        throw new IllegalArgumentException("Headers must not be null");
    L10:
        throw new IllegalArgumentException("URL must not be null!");
    }
}
