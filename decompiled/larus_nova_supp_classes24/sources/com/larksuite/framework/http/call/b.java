package com.larksuite.framework.http.call;

import android.text.TextUtils;
import com.larksuite.framework.http.request.HttpHeaders;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.RequestBody;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import x18.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b<T> {
    public final z18.a<T> a;
    public final d b;
    public final b28.b c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HttpMethod.values().length];
            a = r0;
            r0[HttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[HttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public b(d r6, z18.a<T> r7) {
        this.a = r7;
        this.b = r6;
        String r8 = r7.b();
        FormBody r1 = null;
        if (TextUtils.isEmpty(r8) == true) goto L39;
        Request.Builder r9 = new Request.Builder().url(r8);
        HttpHeaders r0 = r7.a();
        if (r0.isEmpty() == true) goto L11;
        Iterator<String> r2 = r0.getNames().iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        r9.addHeader(r3, r0.get(r3));
    L11:
        int r4 = a.a[r7.d.ordinal()];
        if (r4 != 1) goto L14;
        r9.get();
    L38:
        r1 = r9.build();
        goto L39
    L14:
        if (r4 != 2) goto L38;
        RequestBody r10 = r7.e;
        if (r10 != null) goto L20;
    L36:
        r9.post(r1);
        goto L38
    L20:
        if ((r10 instanceof com.larksuite.framework.http.request.FormBody) == false) goto L42;
        com.larksuite.framework.http.request.FormBody r11 = (com.larksuite.framework.http.request.FormBody) r10;
        Charset r5 = r11.getCharset();
        FormBody.Builder r12 = new FormBody.Builder();
        Map<String, String> r13 = r11.getName2Value();
        Iterator<String> r14 = r13.keySet().iterator();
    L23:
        if (r14.hasNext() == false) goto L28;
        String r15 = r14.next();
        String r16 = r13.get(r15);
        if (r5 == null) goto L26;
        r12.addEncoded(r15, r16);
        goto L23
    L26:
        r12.add(r15, r16);
        goto L23
    L28:
        r1 = r12.build();
        goto L36
    L42:
        MediaType r17 = MediaType.parse(r10.getMediaType());     // Catch: Exception -> L34
        if (r10.getContent() == null) goto L32;
        r1 = okhttp3.RequestBody.create(r17, r10.getContent());     // Catch: Exception -> L34
    L41:
        goto L36
    L32:
        r1 = okhttp3.RequestBody.create(r17, r10.getBytesContent());     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L39:
        this.c = b28.b.c(this.b, r1, false);
    }
}
