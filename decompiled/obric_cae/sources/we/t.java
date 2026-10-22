package we;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f13258d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f13259e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f13262c;

    static {
        f13258d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f13259e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public t(String r8, String r10, @Nullable String r11) {
        this.f13260a = r8;
        this.f13261b = r10;
        this.f13262c = r11;
    }

    public static t a(String r10) {
        Matcher r8 = f13258d.matcher(r10);
        if (r8.lookingAt() == false) goto L37;
        String r11 = r8.group(1);
        Locale r12 = Locale.US;
        String r13 = r11.toLowerCase(r12);
        r8.group(2).toLowerCase(r12);
        Matcher r14 = f13259e.matcher(r10);
        int r15 = r8.end();
        String r16 = null;
    L6:
        if (r15 >= r10.length()) goto L35;
        r14.region(r15, r10.length());
        if (r14.lookingAt() == false) goto L33;
        String r17 = r14.group(1);
        if (r17 == null) goto L31;
        if (r17.equalsIgnoreCase("charset") == false) goto L31;
        String r18 = r14.group(2);
        if (r18 != null) goto L17;
        r18 = r14.group(3);
    L24:
        if (r16 != null) goto L26;
    L30:
        r16 = r18;
        goto L31
    L26:
        if (r18.equalsIgnoreCase(r16) == true) goto L30;
        StringBuilder r19 = defpackage.b.i("Multiple charsets defined: \"", r16, "\" and: \"", r18, "\" for: \"");
        r19.append(r10);
        r19.append('\"');
        throw new IllegalArgumentException(r19.toString());
    L17:
        if (r18.startsWith("'") == false) goto L24;
        if (r18.endsWith("'") == false) goto L24;
        if (r18.length() <= 2) goto L24;
        r18 = r18.substring(1, r18.length() - 1);
    L31:
        r15 = r14.end();
        goto L6
    L33:
        throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + r10.substring(r15) + "\" for: \"" + r10 + '\"');
    L35:
        return new t(r10, r13, r16);
    L37:
        throw new IllegalArgumentException("No subtype found for: \"" + r10 + '\"');
    }

    @Nullable
    public static t b(String r8) {
        return a(r8);
    L4:
        return null;
    }

    public final boolean equals(@Nullable Object r8) {
        if ((r8 instanceof t) == true) goto L5;
    L7:
        return false;
    L5:
        if (((t) r8).f13260a.equals(this.f13260a) == false) goto L7;
        return true;
    }

    public final int hashCode() {
        return this.f13260a.hashCode();
    }

    public final String toString() {
        return this.f13260a;
    }
}
