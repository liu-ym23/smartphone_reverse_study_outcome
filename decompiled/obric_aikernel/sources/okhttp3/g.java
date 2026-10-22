package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f11711b;

    public g(String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, "scheme");
        Intrinsics.checkNotNullParameter(r11, "authParams");
        this.f11710a = r10;
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Map.Entry<String, String> r14 = r13.next();
        String r15 = r14.getKey();
        String r16 = r14.getValue();
        if (r15 == null) goto L8;
        Locale r17 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r17, "US");
        String r18 = r15.toLowerCase(r17);
        Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String).toLowerCase(locale)");
    L9:
        r12.put(r18, r16);
        goto L4
    L8:
        r18 = null;
        goto L9
    L10:
        Map<String, String> r19 = Collections.unmodifiableMap(r12);
        Intrinsics.checkNotNullExpressionValue(r19, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f11711b = r19;
    }

    @JvmName(name = "charset")
    public final Charset a() {
        String r10 = this.f11711b.get("charset");
        if (r10 != null) goto L9;
    L6:
        Charset r11 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue(r11, "ISO_8859_1");
        return r11;
    L9:
        Charset r12 = Charset.forName(r10);     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r12, "forName(charset)");     // Catch: Exception -> L8
        return r12;
    }

    @JvmName(name = "realm")
    public final String b() {
        return this.f11711b.get("realm");
    }

    @JvmName(name = "scheme")
    public final String c() {
        return this.f11710a;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof g) == false) goto L9;
        g r11 = (g) r10;
        if (Intrinsics.areEqual(r11.f11710a, this.f11710a) == false) goto L9;
        if (Intrinsics.areEqual(r11.f11711b, this.f11711b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return ((899 + this.f11710a.hashCode()) * 31) + this.f11711b.hashCode();
    }

    public String toString() {
        return this.f11710a + " authParams=" + this.f11711b;
    }
}
