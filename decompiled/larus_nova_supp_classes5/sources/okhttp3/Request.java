package okhttp3;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class Request {

    @Nullable
    final RequestBody body;

    @Nullable
    private volatile CacheControl cacheControl;
    final Headers headers;
    final String method;
    final HttpUrl originUrl;
    final Map<Class<?>, Object> tags;
    final HttpUrl url;

    public static class Builder {

        @Nullable
        RequestBody body;
        Headers.Builder headers;
        String method;

        @Nullable
        HttpUrl originUrl;
        Map<Class<?>, Object> tags;

        @Nullable
        HttpUrl url;

        public Request build() {
            if (this.url == null) goto L7;
            return new Request(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public Builder delete() {
            return delete(cvc.c.d);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder() {
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder(Request r3) {
            this.tags = Collections.emptyMap();
            this.url = r3.url;
            this.method = r3.method;
            this.body = r3.body;
            if (r3.tags.isEmpty() == false) goto L5;
            Map<Class<?>, Object> r0 = Collections.emptyMap();
        L6:
            this.tags = r0;
            this.headers = r3.headers.newBuilder();
            this.originUrl = r3.originUrl;
            return;
        L5:
            r0 = new LinkedHashMap(r3.tags);
            goto L6
        }

        public Builder cacheControl(CacheControl r3) {
            String r4 = r3.toString();
            if (r4.isEmpty() == false) goto L7;
            return removeHeader(DownloadHelper.CACHE_CONTROL);
        L7:
            return header(DownloadHelper.CACHE_CONTROL, r4);
        }

        public Builder delete(@Nullable RequestBody r2) {
            return method("DELETE", r2);
        }

        public Builder headers(Headers r1) {
            this.headers = r1.newBuilder();
            return this;
        }

        public Builder originUrl(String r7) {
            if (r7 == null) goto L12;
            if (r7.regionMatches(true, 0, "ws:", 0, 3) == false) goto L7;
            r7 = "http:" + r7.substring(3);
        L10:
            return originUrl(HttpUrl.get(r7));
        L7:
            if (r7.regionMatches(true, 0, "wss:", 0, 4) == false) goto L10;
            r7 = "https:" + r7.substring(4);
            goto L10
        L12:
            throw new NullPointerException("url == null");
        }

        public Builder patch(RequestBody r2) {
            return method("PATCH", r2);
        }

        public Builder post(RequestBody r2) {
            return method("POST", r2);
        }

        public Builder put(RequestBody r2) {
            return method("PUT", r2);
        }

        public Builder removeHeader(String r2) {
            this.headers.removeAll(r2);
            return this;
        }

        public Builder tag(@Nullable Object r2) {
            return tag(Object.class, r2);
        }

        public Builder url(String r7) {
            if (r7 == null) goto L12;
            if (r7.regionMatches(true, 0, "ws:", 0, 3) == false) goto L7;
            r7 = "http:" + r7.substring(3);
        L10:
            return url(HttpUrl.get(r7));
        L7:
            if (r7.regionMatches(true, 0, "wss:", 0, 4) == false) goto L10;
            r7 = "https:" + r7.substring(4);
            goto L10
        L12:
            throw new NullPointerException("url == null");
        }

        public Builder originUrl(HttpUrl r2) {
            if (r2 == null) goto L6;
            this.originUrl = r2;
            return this;
        L6:
            throw new NullPointerException("originUrl == null");
        }

        public Builder url(URL r2) {
            if (r2 == null) goto L6;
            return url(HttpUrl.get(r2.toString()));
        L6:
            throw new NullPointerException("url == null");
        }

        public Builder url(HttpUrl r2) {
            if (r2 == null) goto L6;
            this.url = r2;
            return this;
        L6:
            throw new NullPointerException("url == null");
        }

        public Builder addHeader(String r2, String r3) {
            this.headers.add(r2, r3);
            return this;
        }

        public Builder header(String r2, String r3) {
            this.headers.set(r2, r3);
            return this;
        }

        public Builder method(String r3, @Nullable RequestBody r4) {
            if (r3 == null) goto L23;
            if (r3.length() == 0) goto L21;
            if (r4 != null) goto L8;
        L12:
            if (r4 == null) goto L14;
        L18:
            this.method = r3;
            this.body = r4;
            return this;
        L14:
            if (evc.f.c(r3) == false) goto L18;
            throw new IllegalArgumentException("method " + r3 + " must have a request body.");
        L8:
            if (evc.f.b(r3) == true) goto L12;
            throw new IllegalArgumentException("method " + r3 + " must not have a request body.");
        L21:
            throw new IllegalArgumentException("method.length() == 0");
        L23:
            throw new NullPointerException("method == null");
        }

        public <T> Builder tag(Class<? super T> r2, @Nullable T r3) {
            if (r2 == null) goto L11;
            if (r3 != null) goto L6;
            this.tags.remove(r2);
        L9:
            return this;
        L6:
            if (this.tags.isEmpty() == false) goto L8;
            this.tags = new LinkedHashMap();
        L8:
            this.tags.put(r2, r2.cast(r3));
            goto L9
        L11:
            throw new NullPointerException("type == null");
        }
    }

    public CacheControl cacheControl() {
        CacheControl r0 = this.cacheControl;
        if (r0 != null) goto L7;
        CacheControl r1 = CacheControl.parse(this.headers);
        this.cacheControl = r1;
        return r1;
    L7:
        return r0;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    @Nullable
    public RequestBody body() {
        return this.body;
    }

    public Headers headers() {
        return this.headers;
    }

    public String method() {
        return this.method;
    }

    public HttpUrl originUrl() {
        return this.originUrl;
    }

    public HttpUrl url() {
        return this.url;
    }

    public Request(Builder r2) {
        this.url = r2.url;
        this.originUrl = r2.originUrl;
        this.method = r2.method;
        this.headers = r2.headers.build();
        this.body = r2.body;
        Map<Class<?>, Object> r3 = r2.tags;
        byte[] r0 = cvc.c.a;
        if (r3.isEmpty() == false) goto L5;
        Map<Class<?>, Object> r4 = Collections.emptyMap();
    L6:
        this.tags = r4;
        return;
    L5:
        r4 = Collections.unmodifiableMap(new LinkedHashMap(r3));
        goto L6
    }

    @Nullable
    public String header(String r2) {
        return this.headers.get(r2);
    }

    public List<String> headers(String r2) {
        return this.headers.values(r2);
    }

    @Nullable
    public <T> T tag(Class<? extends T> r2) {
        return r2.cast(this.tags.get(r2));
    }
}
