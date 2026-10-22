package b4;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final String a;
    public final HashMap<String, String> b;
    public final String c;

    public static final class a {
        public static String a(String r1, String r10) {
            if (r10 != null) goto L5;
            r1 = URLEncoder.encode(r1, "ISO_8859_1");     // Catch: UnsupportedEncodingException -> L10
        L8:
            Intrinsics.checkNotNull(r1);     // Catch: UnsupportedEncodingException -> L10
            return r1;
        L5:
            if (Intrinsics.areEqual(r10, "null_encoding") == true) goto L8;
            r1 = URLEncoder.encode(r1, r10);     // Catch: UnsupportedEncodingException -> L10
        L10:
            e = move-exception;
            throw new IllegalArgumentException(e);
        }
    }

    static {
    }

    public final String a() {
        if (this.b.isEmpty() == true) goto L5;
        HashMap<String, String> r0 = this.b;
        String r1 = this.c;
        StringBuilder r10 = new StringBuilder();
        Set<String> r11 = r0.keySet();
        boolean r12 = false;
        String r13 = "";
        if (r11.isEmpty() == true) goto L26;
        Iterator<String> r14 = r11.iterator();
    L11:
        if (r14.hasNext() == false) goto L24;
        String r15 = r14.next();
        String r16 = a.a(r15, r1);
        String r17 = r0.get(r15);
        if (r17 == null) goto L16;
        String r18 = a.a(r17, r1);
        if (r18 == null) goto L16;
    L18:
        if (r10.length() <= 0) goto L20;
        boolean r19 = true;
    L21:
        if (r19 == false) goto L23;
        r10.append("&");
    L23:
        r10.append(r16);
        r10.append("=");
        r10.append(r18);
        goto L11
    L20:
        r19 = false;
    L16:
        r18 = "";
        goto L18
    L24:
        r13 = r10.toString();
    L26:
        if (this.a.length() != 0) goto L28;
        r12 = true;
    L28:
        if (r12 == false) goto L31;
        return r13;
    L31:
        if (StringsKt.indexOf$default(this.a, '?', 0, false, 6, null) < 0) goto L34;
        return this.a + '&' + r13;
    L34:
        return this.a + '?' + r13;
    L5:
        return this.a;
    }

    public final String toString() {
        return a();
    }

    public g(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
        this.b = new HashMap();
        this.c = "UTF-8";
    }
}
