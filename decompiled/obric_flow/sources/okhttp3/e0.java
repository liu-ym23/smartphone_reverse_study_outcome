package okhttp3;

import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.net.URI;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f20638k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20641c;
    public final String d;
    public final String e;
    public final int f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f20642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f20643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f20644j;

    static {
        f20638k = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public e0(String r5, String r10, String r11, String r12, int r13, ArrayList r14, ArrayList r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r5, "scheme");
        Intrinsics.checkNotNullParameter(r10, "username");
        Intrinsics.checkNotNullParameter(r11, "password");
        Intrinsics.checkNotNullParameter(r12, "host");
        Intrinsics.checkNotNullParameter(r14, "pathSegments");
        Intrinsics.checkNotNullParameter(r17, "url");
        this.f20640b = r5;
        this.f20641c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f20642h = r15;
        this.f20643i = r16;
        this.f20644j = r17;
        this.f20639a = Intrinsics.areEqual(r5, IIvyAIPackageResourceService.SCHEMA);
    }

    public static final e0 h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toHttpUrlOrNull");
        Intrinsics.checkNotNullParameter(r5, "$this$toHttpUrl");     // Catch: IllegalArgumentException -> L5
        d0 r10 = new d0();     // Catch: IllegalArgumentException -> L5
        r10.d(null, r5);     // Catch: IllegalArgumentException -> L5
        return r10.a();
    L8:
        return null;
    }

    public final String a() {
        if (this.d.length() != 0) goto L6;
        return "";
    L6:
        int r5 = this.f20640b.length() + 3;
        String r10 = this.f20644j;
        int r11 = StringsKt.q(r10, ':', r5, 4) + 1;
        int r12 = StringsKt.q(r10, '@', 0, 6);
        if (r10 == null) goto L11;
        return r10.substring(r11, r12);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final String b() {
        int r5 = this.f20640b.length() + 3;
        String r10 = this.f20644j;
        int r11 = StringsKt.q(r10, '/', r5, 4);
        return r10.substring(r11, Util.delimiterOffset(r10, "?#", r11, r10.length()));
    }

    public final ArrayList c() {
        int r5 = this.f20640b.length() + 3;
        String r10 = this.f20644j;
        int r11 = StringsKt.q(r10, '/', r5, 4);
        int r12 = Util.delimiterOffset(r10, "?#", r11, r10.length());
        ArrayList r13 = new ArrayList();
    L3:
        if (r11 >= r12) goto L5;
        int r14 = r11 + 1;
        int r15 = Util.delimiterOffset(r10, '/', r14, r12);
        r13.add(r10.substring(r14, r15));
        r11 = r15;
        goto L3
    L5:
        return r13;
    }

    public final String d() {
        if (this.f20642h != null) goto L6;
        return null;
    L6:
        String r5 = this.f20644j;
        int r10 = StringsKt.q(r5, '?', 0, 6) + 1;
        return r5.substring(r10, Util.delimiterOffset(r5, '#', r10, r5.length()));
    }

    public final String e() {
        if (this.f20641c.length() != 0) goto L6;
        return "";
    L6:
        int r5 = this.f20640b.length() + 3;
        String r10 = this.f20644j;
        int r11 = Util.delimiterOffset(r10, ":@", r5, r10.length());
        if (r10 == null) goto L11;
        return r10.substring(r5, r11);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof e0) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((e0) r5).f20644j, this.f20644j) == false) goto L7;
        return true;
    }

    public final d0 f() {
        d0 r5 = new d0();
        String r10 = this.f20640b;
        r5.f20626a = r10;
        String r11 = e();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r5.f20627b = r11;
        String r12 = a();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r5.f20628c = r12;
        r5.d = this.e;
        int r13 = uj.a.i(r10);
        int r14 = this.f;
        if (r14 != r13) goto L6;
        r14 = -1;
    L6:
        r5.e = r14;
        ArrayList r15 = r5.f;
        r15.clear();
        r15.addAll(c());
        r5.c(d());
        if (this.f20643i != null) goto L9;
        String r16 = null;
    L12:
        r5.f20629h = r16;
        return r5;
    L9:
        String r17 = this.f20644j;
        int r18 = StringsKt.q(r17, '#', 0, 6) + 1;
        if (r17 == null) goto L15;
        r16 = r17.substring(r18);
        goto L12
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final d0 g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "link");
        d0 r10 = new d0();     // Catch: IllegalArgumentException -> L5
        r10.d(this, r5);     // Catch: IllegalArgumentException -> L5
        return r10;
    L5:
        return null;
    }

    public final int hashCode() {
        return this.f20644j.hashCode();
    }

    public final String i() {
        d0 r10 = g("/...");
        Intrinsics.checkNotNull(r10);
        r10.getClass();
        Intrinsics.checkNotNullParameter("", "username");
        r10.f20627b = uj.a.h("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
        Intrinsics.checkNotNullParameter("", "password");
        r10.f20628c = uj.a.h("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
        return r10.a().f20644j;
    }

    public final e0 j(String r5) {
        Intrinsics.checkNotNullParameter(r5, "link");
        d0 r10 = g(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.a();
    }

    public final URI k() {
        d0 r5 = f();
        String r10 = r5.d;
        String r11 = null;
        if (r10 == null) goto L5;
        String r12 = new Regex("[\"<>^`{|}]").replace(r10, "");
    L6:
        r5.d = r12;
        ArrayList r13 = r5.f;
        int r14 = r13.size();
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L9;
        r13.set(r16, uj.a.h((String) r13.get(r16), 0, 0, "[]", true, true, false, false, 227));
        r16 = r16 + 1;
        goto L7
    L9:
        ArrayList r17 = r5.g;
        if (r17 == null) goto L18;
        int r18 = r17.size();
    L12:
        if (r15 >= r18) goto L18;
        String r19 = (String) r17.get(r15);
        if (r19 == null) goto L16;
        String r20 = uj.a.h(r19, 0, 0, "\\^`{|}", true, true, true, false, 195);
    L17:
        r17.set(r15, r20);
        r15 = r15 + 1;
        goto L12
    L16:
        r20 = null;
    L18:
        String r21 = r5.f20629h;
        if (r21 == null) goto L21;
        r11 = uj.a.h(r21, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 163);
    L21:
        r5.f20629h = r11;
        String r22 = r5.toString();
        return new URI(r22);
    L24:
        e = move-exception;
        return URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(r22, ""));
    L28:
        throw new RuntimeException(e);
    L5:
        r12 = null;
        goto L6
    }

    public final String toString() {
        return this.f20644j;
    }
}
