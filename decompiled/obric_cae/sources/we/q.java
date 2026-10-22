package we;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f13238a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f13239a;

        public a() {
            this.f13239a = new ArrayList(20);
        }

        public final void a(String r8, String r10) {
            q.b(r8);
            q.c(r10, r8);
            b(r8, r10);
        }

        public final void b(String r8, String r10) {
            ArrayList r11 = this.f13239a;
            r11.add(r8);
            r11.add(r10.trim());
        }

        public final void c(String r8) {
            int r10 = 0;
        L3:
            ArrayList r11 = this.f13239a;
            if (r10 >= r11.size()) goto L9;
            if (r8.equalsIgnoreCase((String) r11.get(r10)) == false) goto L8;
            r11.remove(r10);
            r11.remove(r10);
            r10 = r10 - 2;
        L8:
            r10 = r10 + 2;
            goto L3
        }

        public final void d(String r8, String r10) {
            q.b(r8);
            q.c(r10, r8);
            c(r8);
            b(r8, r10);
        }
    }

    public q(a r8) {
        ArrayList r10 = r8.f13239a;
        this.f13238a = (String[]) r10.toArray(new String[r10.size()]);
    }

    public static void b(String r8) {
        if (r8 == null) goto L18;
        if (r8.isEmpty() == true) goto L16;
        int r10 = r8.length();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L14;
        char r12 = r8.charAt(r11);
        if (r12 <= ' ') goto L13;
        if (r12 >= 127) goto L13;
        r11 = r11 + 1;
    L13:
        throw new IllegalArgumentException(xe.c.n("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r12), Integer.valueOf(r11), r8}));
    L14:
        return;
    L16:
        throw new IllegalArgumentException("name is empty");
    L18:
        throw new NullPointerException("name == null");
    }

    public static void c(String r8, String r10) {
        if (r8 == null) goto L16;
        int r11 = r8.length();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L14;
        char r13 = r8.charAt(r12);
        if (r13 > 31) goto L10;
        if (r13 == '\t') goto L10;
    L13:
        throw new IllegalArgumentException(xe.c.n("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(r13), Integer.valueOf(r12), r10, r8}));
    L10:
        if (r13 >= 127) goto L13;
        r12 = r12 + 1;
        goto L4
    L14:
        return;
    L16:
        throw new NullPointerException(defpackage.b.d("value for name ", r10, " == null"));
    }

    public static q h(String... r8) {
        if ((r8.length % 2) != 0) goto L18;
        String[] r10 = (String[]) r8.clone();
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r12 >= r10.length) goto L13;
        String r13 = r10[r12];
        if (r13 == null) goto L11;
        r10[r12] = r13.trim();
        r12 = r12 + 1;
        goto L6
    L11:
        throw new IllegalArgumentException("Headers cannot be null");
    L13:
        if (r11 >= r10.length) goto L16;
        String r14 = r10[r11];
        String r15 = r10[r11 + 1];
        b(r14);
        c(r15, r14);
        r11 = r11 + 2;
        goto L13
    L16:
        return new q(r10);
    L18:
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    public final long a() {
        String[] r8 = this.f13238a;
        long r10 = r8.length * 2;
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10 = r10 + ((long) r8[r12].length());
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @Nullable
    public final String d(String r8) {
        String[] r10 = this.f13238a;
        int r11 = r10.length;
    L3:
        r11 = r11 - 2;
        if (r11 < 0) goto L8;
        if (r8.equalsIgnoreCase(r10[r11]) == false) goto L3;
        return r10[r11 + 1];
    L8:
        return null;
    }

    public final String e(int r8) {
        String[] r10 = this.f13238a;
        return r10[r8 * 2];
    }

    public final boolean equals(@Nullable Object r8) {
        if ((r8 instanceof q) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(((q) r8).f13238a, this.f13238a) == false) goto L7;
        return true;
    }

    public final Set<String> f() {
        TreeSet r8 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int r10 = this.f13238a.length / 2;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        r8.add(e(r11));
        r11 = r11 + 1;
        goto L3
    L6:
        return Collections.unmodifiableSet(r8);
    }

    public final a g() {
        a r8 = new a();
        Collections.addAll(r8.f13239a, this.f13238a);
        return r8;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f13238a);
    }

    public final TreeMap i() {
        TreeMap r8 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int r10 = this.f13238a.length / 2;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        String r12 = e(r11).toLowerCase(Locale.US);
        List r13 = (List) r8.get(r12);
        if (r13 != null) goto L7;
        r13 = new ArrayList(2);
        r8.put(r12, r13);
    L7:
        r13.add(j(r11));
        r11 = r11 + 1;
        goto L3
    L8:
        return r8;
    }

    public final String j(int r8) {
        String[] r10 = this.f13238a;
        return r10[(r8 * 2) + 1];
    }

    public final List<String> k(String r8) {
        int r10 = this.f13238a.length / 2;
        ArrayList r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L10;
        if (r8.equalsIgnoreCase(e(r12)) == false) goto L9;
        if (r11 != null) goto L8;
        r11 = new ArrayList(2);
    L8:
        r11.add(j(r12));
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        if (r11 == null) goto L13;
        return Collections.unmodifiableList(r11);
    L13:
        return Collections.emptyList();
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        int r10 = this.f13238a.length / 2;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        r8.append(e(r11));
        r8.append(": ");
        r8.append(j(r11));
        r8.append("\n");
        r11 = r11 + 1;
        goto L3
    L6:
        return r8.toString();
    }

    public q(String[] r8) {
        this.f13238a = r8;
    }
}
