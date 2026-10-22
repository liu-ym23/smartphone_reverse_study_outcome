package okhttp3;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f12022g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f12023c;

    @SourceDebugExtension({"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,458:1\n1#2:459\n37#3,2:460\n*S KotlinDebug\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n*L\n359#1:460,2\n*E\n"})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f12024a;

        public a() {
            this.f12024a = new ArrayList(20);
        }

        public final a a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            b r12 = r.f12022g;
            b.a(r12, r10);
            b.b(r12, r11, r10);
            c(r10, r11);
            return this;
        }

        public final a b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "line");
            int r11 = StringsKt.indexOf$default(r10, ':', 1, false, 4, null);
            if (r11 == (-1)) goto L6;
            String r12 = r10.substring(0, r11);
            Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String…ing(startIndex, endIndex)");
            String r13 = r10.substring(r11 + 1);
            Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");
            c(r12, r13);
        L9:
            return this;
        L6:
            if (r10.charAt(0) != ':') goto L8;
            r10 = r10.substring(1);
            Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String).substring(startIndex)");
        L8:
            c("", r10);
            goto L9
        }

        public final a c(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            this.f12024a.add(r10);
            this.f12024a.add(StringsKt.trim(r11).toString());
            return this;
        }

        public final a d(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            b.a(r.f12022g, r10);
            c(r10, r11);
            return this;
        }

        public final r e() {
            return new r((String[]) this.f12024a.toArray(new String[0]), null);
        }

        public final List<String> f() {
            return this.f12024a;
        }

        public final a g(String r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            int r11 = 0;
        L4:
            if (r11 >= this.f12024a.size()) goto L9;
            if (StringsKt.equals(r10, this.f12024a.get(r11), true) == false) goto L8;
            this.f12024a.remove(r11);
            this.f12024a.remove(r11);
            r11 = r11 - 2;
        L8:
            r11 = r11 + 2;
            goto L4
        L9:
            return this;
        }

        public final a h(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            b r12 = r.f12022g;
            b.a(r12, r10);
            b.b(r12, r11, r10);
            g(r10);
            c(r10, r11);
            return this;
        }
    }

    @SourceDebugExtension({"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,458:1\n1#2:459\n*E\n"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ void a(b r10, String r11) {
            r10.d(r11);
        }

        public static final /* synthetic */ void b(b r10, String r11, String r12) {
            r10.e(r11, r12);
        }

        public static final /* synthetic */ String c(b r10, String[] r11, String r12) {
            return r10.f(r11, r12);
        }

        private final void d(String r10) {
            if (r10.length() <= 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L21;
            int r12 = r10.length();
            int r13 = 0;
        L8:
            if (r13 >= r12) goto L19;
            char r14 = r10.charAt(r13);
            if ('!' <= r14) goto L12;
        L14:
            boolean r15 = false;
        L15:
            if (r15 == false) goto L18;
            r13 = r13 + 1;
            goto L8
        L18:
            throw new IllegalArgumentException(hc.e.t("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r14), Integer.valueOf(r13), r10}).toString());
        L12:
            if (r14 >= 127) goto L14;
            r15 = true;
            goto L15
        L19:
            return;
        L21:
            throw new IllegalArgumentException("name is empty".toString());
        L5:
            r11 = false;
            goto L6
        }

        private final void e(String r10, String r11) {
            int r12 = r10.length();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L24;
            char r14 = r10.charAt(r13);
            if (r14 != '\t') goto L7;
        L15:
            boolean r15 = true;
        L16:
            if (r15 == false) goto L17;
            r13 = r13 + 1;
            goto L3
        L17:
            StringBuilder r16 = new StringBuilder();
            r16.append(hc.e.t("Unexpected char %#04x at %d in %s value", new Object[]{Integer.valueOf(r14), Integer.valueOf(r13), r11}));
            if (hc.e.G(r11) == false) goto L20;
            String r17 = "";
        L21:
            r16.append(r17);
            throw new IllegalArgumentException(r16.toString().toString());
        L20:
            r17 = ": " + r10;
            goto L21
        L7:
            if (' ' <= r14) goto L9;
        L11:
            boolean r18 = false;
        L12:
            if (r18 == true) goto L15;
            r15 = false;
            goto L16
        L9:
            if (r14 >= 127) goto L11;
            r18 = true;
            goto L12
        }

        private final String f(String[] r10, String r11) {
            int r12 = r10.length - 2;
            int r13 = ProgressionUtilKt.getProgressionLastElement(r12, 0, -2);
            if (r13 <= r12) goto L5;
            return null;
        L5:
            if (StringsKt.equals(r11, r10[r12], true) == true) goto L7;
            if (r12 == r13) goto L14;
            r12 = r12 - 2;
            goto L5
        L14:
            return null;
        L7:
            return r10[r12 + 1];
        }

        @JvmStatic
        @JvmName(name = "of")
        public final r g(Map<String, String> r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            String[] r11 = new String[r10.size() * 2];
            Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
            int r13 = 0;
        L4:
            if (r12.hasNext() == false) goto L7;
            Map.Entry<String, String> r14 = r12.next();
            String r15 = r14.getKey();
            String r16 = r14.getValue();
            String r17 = StringsKt.trim(r15).toString();
            String r18 = StringsKt.trim(r16).toString();
            d(r17);
            e(r18, r17);
            r11[r13] = r17;
            r11[r13 + 1] = r18;
            r13 = r13 + 2;
            goto L4
        L7:
            return new r(r11, null);
        }

        @JvmStatic
        @JvmName(name = "of")
        public final r h(String... r10) {
            Intrinsics.checkNotNullParameter(r10, "namesAndValues");
            int r11 = 0;
            if ((r10.length % 2) != 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L25;
            String[] r13 = (String[]) r10.clone();
            int r14 = r13.length;
            int r15 = 0;
        L8:
            if (r15 >= r14) goto L17;
            if (r13[r15] == null) goto L12;
            boolean r16 = true;
        L13:
            if (r16 == false) goto L16;
            r13[r15] = StringsKt.trim(r13[r15]).toString();
            r15 = r15 + 1;
            goto L8
        L16:
            throw new IllegalArgumentException("Headers cannot be null".toString());
        L12:
            r16 = false;
            goto L13
        L17:
            int r17 = ProgressionUtilKt.getProgressionLastElement(0, r13.length - 1, 2);
            if (r17 < 0) goto L23;
        L19:
            String r18 = r13[r11];
            String r19 = r13[r11 + 1];
            d(r18);
            e(r19, r18);
            if (r11 == r17) goto L23;
            r11 = r11 + 2;
        L23:
            return new r(r13, null);
        L25:
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        L5:
            r12 = false;
            goto L6
        }
    }

    static {
        f12022g = new b(null);
    }

    private r(String[] r10) {
        this.f12023c = r10;
    }

    public /* synthetic */ r(String[] r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    @JvmStatic
    @JvmName(name = "of")
    public static final r f(Map<String, String> r10) {
        return f12022g.g(r10);
    }

    @JvmStatic
    @JvmName(name = "of")
    public static final r g(String... r10) {
        return f12022g.h(r10);
    }

    public final long a() {
        String[] r10 = this.f12023c;
        long r11 = r10.length * 2;
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11 = r11 + ((long) this.f12023c[r13].length());
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public final String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return b.c(f12022g, this.f12023c, r10);
    }

    public final String c(int r10) {
        return this.f12023c[r10 * 2];
    }

    public final Set<String> d() {
        TreeSet r10 = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int r11 = size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(c(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        Set<String> r13 = Collections.unmodifiableSet(r10);
        Intrinsics.checkNotNullExpressionValue(r13, "unmodifiableSet(result)");
        return r13;
    }

    public final a e() {
        a r10 = new a();
        CollectionsKt.addAll(r10.f(), this.f12023c);
        return r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof r) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(this.f12023c, ((r) r10).f12023c) == false) goto L7;
        return true;
    }

    public final Map<String, List<String>> h() {
        TreeMap r10 = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int r11 = size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        String r13 = c(r12);
        Locale r14 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r14, "US");
        String r15 = r13.toLowerCase(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase(locale)");
        List r16 = (List) r10.get(r15);
        if (r16 != null) goto L7;
        r16 = new ArrayList(2);
        r10.put(r15, r16);
    L7:
        r16.add(i(r12));
        r12 = r12 + 1;
        goto L3
    L8:
        return r10;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f12023c);
    }

    public final String i(int r10) {
        return this.f12023c[(r10 * 2) + 1];
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int r10 = size();
        Pair[] r11 = new Pair[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L6;
        r11[r12] = TuplesKt.to(c(r12), i(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        return ArrayIteratorKt.iterator(r11);
    }

    public final List<String> j(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        int r11 = size();
        ArrayList r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        if (StringsKt.equals(r10, c(r13), true) == false) goto L9;
        if (r12 != null) goto L8;
        r12 = new ArrayList(2);
    L8:
        r12.add(i(r13));
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r12 == null) goto L13;
        List<String> r14 = Collections.unmodifiableList(r12);
        Intrinsics.checkNotNullExpressionValue(r14, "{\n      Collections.unmodifiableList(result)\n    }");
        return r14;
    L13:
        return CollectionsKt.emptyList();
    }

    @JvmName(name = "size")
    public final int size() {
        return this.f12023c.length / 2;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        int r11 = size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        String r13 = c(r12);
        String r14 = i(r12);
        r10.append(r13);
        r10.append(": ");
        if (hc.e.G(r13) == false) goto L7;
        r14 = "██";
    L7:
        r10.append(r14);
        r10.append("\n");
        r12 = r12 + 1;
        goto L3
    L8:
        String r15 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
        return r15;
    }
}
