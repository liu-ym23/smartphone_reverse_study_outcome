package okio;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/Path\n+ 2 Path.kt\nokio/internal/-Path\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n45#2,3:133\n53#2,28:136\n59#2,22:168\n112#2:190\n117#2:191\n122#2,6:192\n139#2,5:198\n149#2:203\n154#2,25:204\n194#2:229\n199#2,11:230\n204#2,6:241\n199#2,11:247\n204#2,6:258\n228#2,36:264\n268#2:300\n282#2:301\n287#2:302\n292#2:303\n297#2:304\n1549#3:164\n1620#3,3:165\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/Path\n*L\n44#1:133,3\n47#1:136,28\n50#1:168,22\n53#1:190\n56#1:191\n60#1:192,6\n64#1:198,5\n68#1:203\n72#1:204,25\n75#1:229\n78#1:230,11\n81#1:241,6\n87#1:247,11\n90#1:258,6\n95#1:264,36\n97#1:300\n104#1:301\n106#1:302\n108#1:303\n110#1:304\n47#1:164\n47#1:165,3\n*E\n"})
public final class y implements Comparable<y> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12274g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final String f12275h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ByteString f12276c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ y d(a r10, File r11, boolean r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r12 = false;
        L6:
            return r10.a(r11, r12);
        }

        public static /* synthetic */ y e(a r10, String r11, boolean r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r12 = false;
        L6:
            return r10.b(r11, r12);
        }

        public static /* synthetic */ y f(a r10, Path r11, boolean r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r12 = false;
        L6:
            return r10.c(r11, r12);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name = "get")
        public final y a(File r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            String r12 = r10.toString();
            Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
            return b(r12, r11);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name = "get")
        public final y b(String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return okio.internal.c.k(r10, r11);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName(name = "get")
        public final y c(Path r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return b(r10.toString(), r11);
        }
    }

    static {
        f12274g = new a(null);
        String r10 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r10, "separator");
        f12275h = r10;
    }

    public y(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        this.f12276c = r10;
    }

    public int a(y r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return b().compareTo2(r10.b());
    }

    public final ByteString b() {
        return this.f12276c;
    }

    public final y c() {
        int r10 = okio.internal.c.h(this);
        if (r10 != (-1)) goto L6;
        return null;
    L6:
        return new y(b().substring(0, r10));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(y r10) {
        return a(r10);
    }

    public final List<ByteString> d() {
        ArrayList r10 = new ArrayList();
        int r11 = okio.internal.c.h(this);
        if (r11 != (-1)) goto L6;
        r11 = 0;
    L10:
        int r12 = b().size();
        int r13 = r11;
    L11:
        if (r11 >= r12) goto L19;
        if (b().getByte(r11) != 47) goto L15;
    L16:
        r10.add(b().substring(r13, r11));
        r13 = r11 + 1;
    L17:
        r11 = r11 + 1;
        goto L11
    L15:
        if (b().getByte(r11) != 92) goto L17;
    L19:
        if (r13 >= b().size()) goto L21;
        r10.add(b().substring(r13, b().size()));
    L21:
        return r10;
    L6:
        if (r11 >= b().size()) goto L10;
        if (b().getByte(r11) != 92) goto L10;
        r11 = r11 + 1;
        goto L10
    }

    public final boolean e() {
        if (okio.internal.c.h(this) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof y) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((y) r10).b(), b()) == false) goto L7;
        return true;
    }

    @JvmName(name = ActivityLifecycle.NAME)
    public final String f() {
        return g().utf8();
    }

    @JvmName(name = "nameBytes")
    public final ByteString g() {
        int r10 = okio.internal.c.d(this);
        if (r10 == (-1)) goto L6;
        return ByteString.substring$default(b(), r10 + 1, 0, 2, null);
    L6:
        if (o() == null) goto L11;
        if (b().size() != 2) goto L11;
        return ByteString.EMPTY;
    L11:
        return b();
    }

    @JvmName(name = "parent")
    public final y h() {
        if (Intrinsics.areEqual(b(), okio.internal.c.b()) == false) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(b(), okio.internal.c.e()) == false) goto L7;
        return null;
    L7:
        if (Intrinsics.areEqual(b(), okio.internal.c.a()) == false) goto L9;
        return null;
    L9:
        if (okio.internal.c.g(this) == true) goto L43;
        int r10 = okio.internal.c.d(this);
        if (r10 == 2) goto L14;
    L20:
        if (r10 != 1) goto L25;
        if (b().startsWith(okio.internal.c.a()) == false) goto L25;
        return null;
    L25:
        if (r10 == (-1)) goto L27;
    L32:
        if (r10 == (-1)) goto L42;
        if (r10 != 0) goto L37;
        y r11 = new y(ByteString.substring$default(b(), 0, 1, 1, null));
    L41:
        return r11;
    L37:
        return new y(ByteString.substring$default(b(), 0, r10, 1, null));
    L42:
        return new y(okio.internal.c.b());
    L27:
        if (o() == null) goto L32;
        if (b().size() == 2) goto L46;
        r11 = new y(ByteString.substring$default(b(), 0, 2, 1, null));
        goto L41
    L46:
        return null;
    L14:
        if (o() == null) goto L20;
        if (b().size() == 3) goto L44;
        r11 = new y(ByteString.substring$default(b(), 0, 3, 1, null));
        goto L41
    L44:
        return null;
    L43:
        return null;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final y i(y r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (Intrinsics.areEqual(c(), r10.c()) == false) goto L35;
        List<ByteString> r11 = d();
        List<ByteString> r12 = r10.d();
        int r13 = Math.min(r11.size(), r12.size());
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L9;
        if (Intrinsics.areEqual(r11.get(r14), r12.get(r14)) == false) goto L9;
        r14 = r14 + 1;
    L9:
        boolean r15 = true;
        if (r14 != r13) goto L15;
        if (b().size() != r10.b().size()) goto L15;
        return a.e(f12274g, ".", false, 1, null);
    L15:
        if (r12.subList(r14, r12.size()).indexOf(okio.internal.c.c()) == (-1)) goto L18;
        r15 = false;
    L18:
        if (r15 == false) goto L33;
        d r16 = new d();
        ByteString r17 = okio.internal.c.f(r10);
        if (r17 != null) goto L24;
        r17 = okio.internal.c.f(this);
        if (r17 != null) goto L24;
        r17 = okio.internal.c.i(f12275h);
    L24:
        int r18 = r12.size();
        int r19 = r14;
    L25:
        if (r19 >= r18) goto L27;
        r16.V(okio.internal.c.c());
        r16.V(r17);
        r19 = r19 + 1;
        goto L25
    L27:
        int r20 = r11.size();
    L28:
        if (r14 >= r20) goto L31;
        r16.V(r11.get(r14));
        r16.V(r17);
        r14 = r14 + 1;
        goto L28
    L31:
        return okio.internal.c.q(r16, false);
    L33:
        throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + r10).toString());
    L35:
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + r10).toString());
    }

    @JvmName(name = "resolve")
    public final y j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "child");
        return okio.internal.c.j(this, okio.internal.c.q(new d().l0(r10), false), false);
    }

    @JvmName(name = "resolve")
    public final y k(y r10) {
        Intrinsics.checkNotNullParameter(r10, "child");
        return okio.internal.c.j(this, r10, false);
    }

    public final y l(y r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "child");
        return okio.internal.c.j(this, r10, r11);
    }

    public final File m() {
        return new File(toString());
    }

    public final Path n() {
        Path r10 = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(r10, "get(...)");
        return r10;
    }

    @JvmName(name = "volumeLetter")
    public final Character o() {
        boolean r10 = false;
        if (ByteString.indexOf$default(b(), okio.internal.c.e(), 0, 2, null) == (-1)) goto L6;
        return null;
    L6:
        if (b().size() >= 2) goto L9;
        return null;
    L9:
        if (b().getByte(1) != 58) goto L29;
        char r11 = (char) b().getByte(0);
        if ('a' <= r11) goto L14;
    L16:
        boolean r12 = false;
    L17:
        if (r12 == true) goto L26;
        if ('A' <= r11) goto L21;
    L23:
        if (r10 == true) goto L26;
        return null;
    L21:
        if (r11 >= '[') goto L23;
        r10 = true;
    L26:
        return Character.valueOf(r11);
    L14:
        if (r11 >= '{') goto L16;
        r12 = true;
        goto L17
    L29:
        return null;
    }

    public String toString() {
        return b().utf8();
    }
}
