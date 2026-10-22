package okhttp3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import evc.d;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class Headers {
    private final String[] namesAndValues;

    public static final class Builder {
        final List<String> namesAndValues;

        public Headers build() {
            return new Headers(this);
        }

        public Builder() {
            this.namesAndValues = new ArrayList(20);
        }

        public Builder add(String r3) {
            int r0 = r3.indexOf(":");
            if (r0 == (-1)) goto L7;
            return add(r3.substring(0, r0).trim(), r3.substring(r0 + 1));
        L7:
            throw new IllegalArgumentException("Unexpected header: ".concat(r3));
        }

        public Builder addAll(Headers r5) {
            int r0 = r5.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            addLenient(r5.name(r1), r5.value(r1));
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder addLenient(String r5) {
            int r2 = r5.indexOf(":", 1);
            if (r2 == (-1)) goto L7;
            return addLenient(r5.substring(0, r2), r5.substring(r2 + 1));
        L7:
            if (r5.startsWith(":") == false) goto L11;
            return addLenient("", r5.substring(1));
        L11:
            return addLenient("", r5);
        }

        public String get(String r3) {
            int r0 = this.namesAndValues.size() - 2;
        L3:
            if (r0 < 0) goto L9;
            if (r3.equalsIgnoreCase((String) ListProtector.get(this.namesAndValues, r0)) == true) goto L7;
            r0 = r0 - 2;
            goto L3
        L7:
            return (String) ListProtector.get(this.namesAndValues, r0 + 1);
        L9:
            return null;
        }

        public Builder removeAll(String r3) {
            int r0 = 0;
        L4:
            if (r0 >= this.namesAndValues.size()) goto L9;
            if (r3.equalsIgnoreCase((String) ListProtector.get(this.namesAndValues, r0)) == false) goto L8;
            ListProtector.remove(this.namesAndValues, r0);
            ListProtector.remove(this.namesAndValues, r0);
            r0 = r0 - 2;
        L8:
            r0 = r0 + 2;
            goto L4
        L9:
            return this;
        }

        public Builder add(String r3, Date r4) {
            if (r4 == null) goto L6;
            add(r3, ((DateFormat) d.a.get()).format(r4));
            return this;
        L6:
            throw new NullPointerException("value for name " + r3 + " == null");
        }

        public Builder addLenient(String r2, String r3) {
            this.namesAndValues.add(r2);
            this.namesAndValues.add(r3.trim());
            return this;
        }

        public Builder addUnsafeNonAscii(String r1, String r2) {
            Headers.checkName(r1);
            return addLenient(r1, r2);
        }

        public Builder set(String r3, Date r4) {
            if (r4 == null) goto L6;
            set(r3, ((DateFormat) d.a.get()).format(r4));
            return this;
        L6:
            throw new NullPointerException("value for name " + r3 + " == null");
        }

        public Builder add(String r1, String r2) {
            Headers.checkName(r1);
            Headers.checkValue(r2, r1);
            return addLenient(r1, r2);
        }

        public Builder set(String r1, String r2) {
            Headers.checkName(r1);
            Headers.checkValue(r2, r1);
            removeAll(r1);
            addLenient(r1, r2);
            return this;
        }
    }

    public long byteCount() {
        String[] r0 = this.namesAndValues;
        long r1 = r0.length * 2;
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1 = r1 + ((long) this.namesAndValues[r3].length());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public Set<String> names() {
        TreeSet r0 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(name(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return Collections.unmodifiableSet(r0);
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        Collections.addAll(r0.namesAndValues, this.namesAndValues);
        return r0;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = name(r2).toLowerCase(Locale.US);
        List r4 = (List) r0.get(r3);
        if (r4 != null) goto L7;
        r4 = new ArrayList(2);
        r0.put(r3, r4);
    L7:
        r4.add(value(r2));
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.append(name(r2));
        r0.append(": ");
        r0.append(value(r2));
        r0.append("\n");
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public Headers(Builder r2) {
        List<String> r3 = r2.namesAndValues;
        this.namesAndValues = (String[]) r3.toArray(new String[r3.size()]);
    }

    public static void checkName(String r5) {
        if (r5 == null) goto L18;
        if (r5.isEmpty() == true) goto L16;
        int r0 = r5.length();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L14;
        char r3 = r5.charAt(r2);
        if (r3 <= ' ') goto L13;
        if (r3 >= 127) goto L13;
        r2 = r2 + 1;
    L13:
        throw new IllegalArgumentException(cvc.c.l("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r3), Integer.valueOf(r2), r5}));
    L14:
        return;
    L16:
        throw new IllegalArgumentException("name is empty");
    L18:
        throw new NullPointerException("name == null");
    }

    public static Headers of(Map<String, String> r4) {
        if (r4 == null) goto L16;
        String[] r0 = new String[r4.size() * 2];
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
        int r1 = 0;
    L5:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, String> r2 = r5.next();
        if (r2.getKey() == null) goto L12;
        if (r2.getValue() == null) goto L12;
        String r3 = r2.getKey().trim();
        String r6 = r2.getValue().trim();
        checkName(r3);
        checkValue(r6, r3);
        r0[r1] = r3;
        r0[r1 + 1] = r6;
        r1 = r1 + 2;
    L12:
        throw new IllegalArgumentException("Headers cannot be null");
    L14:
        return new Headers(r0);
    L16:
        throw new NullPointerException("headers == null");
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof Headers) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(((Headers) r2).namesAndValues, this.namesAndValues) == false) goto L7;
        return true;
    }

    @Nullable
    public String get(String r2) {
        return get(this.namesAndValues, r2);
    }

    @Nullable
    public Date getDate(String r1) {
        String r2 = get(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return d.a(r2);
    }

    public String name(int r2) {
        return this.namesAndValues[r2 * 2];
    }

    public String value(int r2) {
        return this.namesAndValues[(r2 * 2) + 1];
    }

    public List<String> values(String r5) {
        int r0 = size();
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        if (r5.equalsIgnoreCase(name(r2)) == false) goto L9;
        if (r1 != null) goto L8;
        r1 = new ArrayList(2);
    L8:
        r1.add(value(r2));
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r1 == null) goto L13;
        return Collections.unmodifiableList(r1);
    L13:
        return Collections.emptyList();
    }

    private Headers(String[] r1) {
        this.namesAndValues = r1;
    }

    public static Headers of(String... r3) {
        if (r3 == null) goto L21;
        if ((r3.length % 2) != 0) goto L19;
        String[] r4 = (String[]) r3.clone();
        int r0 = 0;
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L14;
        String r2 = r4[r1];
        if (r2 == null) goto L12;
        r4[r1] = r2.trim();
        r1 = r1 + 1;
        goto L7
    L12:
        throw new IllegalArgumentException("Headers cannot be null");
    L14:
        if (r0 >= r4.length) goto L17;
        String r5 = r4[r0];
        String r6 = r4[r0 + 1];
        checkName(r5);
        checkValue(r6, r5);
        r0 = r0 + 2;
        goto L14
    L17:
        return new Headers(r4);
    L19:
        throw new IllegalArgumentException("Expected alternating header names and values");
    L21:
        throw new NullPointerException("namesAndValues == null");
    }

    public static void checkValue(String r5, String r6) {
        if (r5 == null) goto L16;
        int r0 = r5.length();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L14;
        char r3 = r5.charAt(r2);
        if (r3 > 31) goto L10;
        if (r3 == '\t') goto L10;
    L13:
        throw new IllegalArgumentException(cvc.c.l("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(r3), Integer.valueOf(r2), r6, r5}));
    L10:
        if (r3 >= 127) goto L13;
        r2 = r2 + 1;
        goto L4
    L14:
        return;
    L16:
        throw new NullPointerException("value for name " + r6 + " == null");
    }

    private static String get(String[] r2, String r3) {
        int r0 = r2.length - 2;
    L3:
        if (r0 < 0) goto L9;
        if (r3.equalsIgnoreCase(r2[r0]) == true) goto L7;
        r0 = r0 - 2;
        goto L3
    L7:
        return r2[r0 + 1];
    L9:
        return null;
    }
}
