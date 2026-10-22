package z18;

import android.text.TextUtils;
import com.larksuite.framework.http.request.HttpHeaders;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.HttpParams;
import com.larksuite.framework.http.request.RequestBody;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import x18.d;
import x18.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a<T> {
    public final HttpParams a;
    public HttpHeaders b;
    public String c;
    public HttpMethod d;
    public RequestBody e;
    public final String f;
    public volatile com.larksuite.framework.http.call.b g;
    public final d h;

    public final HttpHeaders a() {
        if (this.b.headersMap.containsKey("X-BaseRequest-ID") == true) goto L6;
        HttpHeaders r0 = this.b;
        long r2 = System.currentTimeMillis();
        r0.put("X-BaseRequest-ID", String.valueOf(r2) + Math.abs(new Random(r2).nextInt()));
    L6:
        return this.b;
    }

    public final String b() {
        String r0 = this.c + "";
        LinkedHashMap<String, String> r1 = this.a.urlParamsMap;
        int r2 = c28.b.a;
        if (TextUtils.isEmpty(r0) == true) goto L31;
        if (r1 != null) goto L6;
        return r0;
    L6:
        if (r1.size() <= 0) goto L33;
        StringBuilder r3 = new StringBuilder(r0);
        if (r0.endsWith("?") == true) goto L11;
        r3.append("?");
    L11:
        Iterator<String> r4 = r1.keySet().iterator();
        boolean r5 = true;
    L13:
        if (r4.hasNext() == false) goto L23;
        String r6 = r4.next();
        if (TextUtils.isEmpty(r6) == true) goto L13;
        if (TextUtils.isEmpty(r1.get(r6)) == true) goto L13;
        if (r5 == false) goto L20;
        r5 = false;
    L21:
        r3.append(r6);
        r3.append("=");
        r3.append(r1.get(r6));
        goto L13
    L20:
        r3.append("&");
        goto L21
    L23:
        return r3.toString();
    L33:
        return r0;
    L31:
        return r0;
    }

    public a() {
        this.a = new HttpParams();
        this.b = new HttpHeaders();
        this.d = HttpMethod.GET;
        this.f = "BaseRequest";
        this.g = null;
        this.h = e.a.a.a;
    }

    public final void c(b<T> r4) {
        d r0 = this.h;
        r0.getClass();
        this.g = new com.larksuite.framework.http.call.b(r0, this);
        com.larksuite.framework.http.call.b r1 = this.g;
        r1.c.enqueue(new com.larksuite.framework.http.call.a(r1, r4));
    }

    public a(HttpMethod r2, String r3) {
        this.a = new HttpParams();
        this.b = new HttpHeaders();
        this.d = HttpMethod.GET;
        this.f = "BaseRequest";
        this.g = null;
        this.h = e.a.a.a;
        this.d = r2;
        this.c = r3;
    }
}
