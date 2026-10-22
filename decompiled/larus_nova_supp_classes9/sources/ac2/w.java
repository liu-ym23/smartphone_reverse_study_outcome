package ac2;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ugc.live.sdk.msg.network.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w {
    public String a;
    public HttpMethod b;
    public String c;
    public final LinkedHashMap<String, String> d;
    public final LinkedHashMap<String, String> e;
    public final LinkedHashMap<String, String> f;
    public com.ss.ugc.live.sdk.msg.network.b g;
    public com.ss.ugc.live.sdk.msg.network.n h;

    public w() {
        this.a = BuildConfig.FLAVOR;
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
    }

    public final String d(String r3) {
        String r0 = this.a;
        if (r0 == null) goto L10;
        if (r0.startsWith("http://") == true) goto L11;
        if (this.a.startsWith("https://") == false) goto L10;
    L11:
        return this.a;
    L10:
        return UriProtector.parse(r3).buildUpon().encodedPath(this.a).build().toString();
    }

    public final void b(String r2, String r3) {
        this.d.put(r2, r3);
    }

    public final void a(String r4, String r5, boolean r6) {
        if (r4 == null) goto L19;
        if (r6 == true) goto L20;
    L8:
        if (r6 == false) goto L10;
        r5 = URLEncoder.encode(r5, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L10:
        if (r5 != null) goto L12;
        return;
    L12:
        if (r5.isEmpty() == true) goto L22;
        this.f.put(r4, r5);     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r4 + "\" value to UTF-8: " + r5, e);
    L22:
        return;
    L20:
        r4 = URLEncoder.encode(r4, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
        goto L8
    L19:
        throw new IllegalArgumentException("field param name must not be null.");
    }

    public final void c(String r4, String r5, boolean r6) {
        if (r4 == null) goto L19;
        if (r6 == true) goto L20;
    L8:
        if (r6 == false) goto L10;
        r5 = URLEncoder.encode(r5, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L10:
        if (r5 != null) goto L12;
        return;
    L12:
        if (r5.isEmpty() == true) goto L22;
        this.e.put(r4, r5);     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r4 + "\" value to UTF-8: " + r5, e);
    L22:
        return;
    L20:
        r4 = URLEncoder.encode(r4, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
        goto L8
    L19:
        throw new IllegalArgumentException("Query param name must not be null.");
    }
}
