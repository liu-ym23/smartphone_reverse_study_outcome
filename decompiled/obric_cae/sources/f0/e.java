package f0;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f7236b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f7237a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Locale[] f7238a = null;

        static {
            f7238a = new Locale[]{new Locale("en", "XA"), new Locale("ar", "XB")};
        }

        public static Locale a(String r8) {
            return Locale.forLanguageTag(r8);
        }

        public static boolean b(Locale r8, Locale r10) {
            if (r8.equals(r10) == false) goto L6;
            return true;
        L6:
            if (r8.getLanguage().equals(r10.getLanguage()) == true) goto L8;
            return false;
        L8:
            Locale[] r11 = f7238a;
            int r12 = r11.length;
            int r13 = 0;
        L9:
            if (r13 >= r12) goto L14;
            if (r11[r13].equals(r8) == true) goto L12;
            r13 = r13 + 1;
            goto L9
        L12:
            boolean r14 = true;
        L15:
            if (r14 == true) goto L36;
            int r15 = r11.length;
            int r16 = 0;
        L17:
            if (r16 >= r15) goto L22;
            if (r11[r16].equals(r10) == true) goto L20;
            r16 = r16 + 1;
            goto L17
        L20:
            boolean r17 = true;
        L23:
            if (r17 == true) goto L36;
            String r18 = h0.b.c(h0.b.a(h0.b.b(r8)));
            if (r18.isEmpty() == false) goto L35;
            String r19 = r8.getCountry();
            if (r19.isEmpty() == false) goto L30;
            return true;
        L30:
            if (r19.equals(r10.getCountry()) == false) goto L33;
            return true;
        L33:
            return false;
        L35:
            return r18.equals(h0.b.c(h0.b.a(h0.b.b(r10))));
        L22:
            r17 = false;
        L36:
            return false;
        L14:
            r14 = false;
            goto L15
        }
    }

    public static class b {
        public static LocaleList a(Locale... r8) {
            return new LocaleList(r8);
        }

        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    static {
        f7236b = new e(new g(b.a(new Locale[0])));
    }

    public e(g r8) {
        this.f7237a = r8;
    }

    public static e a(String r8) {
        if (r8 == null) goto L12;
        if (r8.isEmpty() == true) goto L12;
        String[] r10 = r8.split(",", -1);
        int r11 = r10.length;
        Locale[] r12 = new Locale[r11];
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L10;
        r12[r13] = a.a(r10[r13]);
        r13 = r13 + 1;
        goto L7
    L10:
        return new e(new g(b.a(r12)));
    L12:
        return f7236b;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof e) == false) goto L7;
        f r10 = ((e) r8).f7237a;
        if (this.f7237a.equals(r10) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        return this.f7237a.hashCode();
    }

    public final String toString() {
        return this.f7237a.toString();
    }
}
