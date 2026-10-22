package okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.g;
import okio.h;
import okio.i;
import okio.y;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nResourceFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n766#2:211\n857#2,2:212\n1549#2:214\n1620#2,3:215\n766#2:218\n857#2,2:219\n1549#2:221\n1620#2,3:222\n1603#2,9:225\n1855#2:234\n1856#2:236\n1612#2:237\n1603#2,9:238\n1855#2:247\n1856#2:249\n1612#2:250\n1#3:235\n1#3:248\n*S KotlinDebug\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n*L\n74#1:211\n74#1:212,2\n75#1:214\n75#1:215,3\n90#1:218\n90#1:219,2\n91#1:221\n91#1:222,3\n173#1:225,9\n173#1:234\n173#1:236\n173#1:237\n174#1:238,9\n174#1:247\n174#1:249\n174#1:250\n173#1:235\n174#1:248\n*E\n"})
public final class ResourceFileSystem extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f12232f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final y f12233g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClassLoader f12234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f12235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f12236e;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ boolean a(a r10, y r11) {
            return r10.c(r11);
        }

        private final boolean c(y r10) {
            return !StringsKt.endsWith(r10.f(), ".class", true);
        }

        public final y b() {
            return ResourceFileSystem.h();
        }

        public final y d(y r10, y r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "base");
            String r12 = r11.toString();
            return b().j(StringsKt.replace$default(StringsKt.removePrefix(r10.toString(), r12), '\\', '/', false, 4, null));
        }
    }

    static {
        f12232f = new a(null);
        f12233g = y.a.e(y.f12274g, "/", false, 1, null);
    }

    public ResourceFileSystem(ClassLoader r10, boolean r11, i r12) {
        Intrinsics.checkNotNullParameter(r10, "classLoader");
        Intrinsics.checkNotNullParameter(r12, "systemFileSystem");
        this.f12234c = r10;
        this.f12235d = r12;
        this.f12236e = LazyKt.lazy(new ResourceFileSystem$roots$2(this));
        if (r11 == false) goto L6;
        k().size();
        return;
    }

    public /* synthetic */ ResourceFileSystem(ClassLoader r10, boolean r11, i r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = i.f12227b;
    L5:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ ClassLoader f(ResourceFileSystem r10) {
        return r10.f12234c;
    }

    public static final /* synthetic */ a g() {
        return f12232f;
    }

    public static final /* synthetic */ y h() {
        return f12233g;
    }

    public static final /* synthetic */ List i(ResourceFileSystem r10, ClassLoader r11) {
        return r10.l(r11);
    }

    private final y j(y r10) {
        return f12233g.l(r10, true);
    }

    private final List<Pair<i, y>> k() {
        return (List) this.f12236e.getValue();
    }

    private final List<Pair<i, y>> l(ClassLoader r10) {
        Enumeration<URL> r11 = r10.getResources("");
        Intrinsics.checkNotNullExpressionValue(r11, "getResources(...)");
        ArrayList r12 = Collections.list(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "list(this)");
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        URL r15 = (URL) r14.next();
        Intrinsics.checkNotNull(r15);
        Pair<i, y> r16 = m(r15);
        if (r16 == null) goto L4;
        r13.add(r16);
        goto L4
    L8:
        Enumeration<URL> r17 = r10.getResources("META-INF/MANIFEST.MF");
        Intrinsics.checkNotNullExpressionValue(r17, "getResources(...)");
        ArrayList r18 = Collections.list(r17);
        Intrinsics.checkNotNullExpressionValue(r18, "list(this)");
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L10:
        if (r20.hasNext() == false) goto L15;
        URL r21 = (URL) r20.next();
        Intrinsics.checkNotNull(r21);
        Pair<i, y> r22 = n(r21);
        if (r22 == null) goto L10;
        r19.add(r22);
        goto L10
    L15:
        return CollectionsKt.plus(r13, r19);
    }

    private final Pair<i, y> m(URL r10) {
        if (Intrinsics.areEqual(r10.getProtocol(), "file") == true) goto L6;
        return null;
    L6:
        return TuplesKt.to(this.f12235d, y.a.d(y.f12274g, new File(r10.toURI()), false, 1, null));
    }

    private final Pair<i, y> n(URL r10) {
        String r11 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        if (StringsKt.startsWith$default(r11, "jar:file:", false, 2, null) == true) goto L5;
        return null;
    L5:
        int r12 = StringsKt.lastIndexOf$default(r11, "!", 0, false, 6, null);
        if (r12 != (-1)) goto L8;
        return null;
    L8:
        y.a r13 = y.f12274g;
        String r14 = r11.substring(4, r12);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return TuplesKt.to(ZipFilesKt.d(y.a.d(r13, new File(URI.create(r14)), false, 1, null), this.f12235d, ResourceFileSystem$toJarRoot$zip$1.INSTANCE), f12233g);
    }

    private final String o(y r10) {
        return j(r10).i(f12233g).toString();
    }

    @Override // okio.i
    public List<y> a(y r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        String r11 = o(r10);
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator<Pair<i, y>> r13 = k().iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L18;
        Pair<i, y> r15 = r13.next();
        i r16 = r15.component1();
        y r17 = r15.component2();
        List<y> r18 = r16.a(r17.j(r11));     // Catch: IOException -> L23
        ArrayList r19 = new ArrayList();     // Catch: IOException -> L23
        Iterator<T> r20 = r18.iterator();     // Catch: IOException -> L23
    L8:
        if (r20.hasNext() == false) goto L12;
        Object r21 = r20.next();     // Catch: IOException -> L23
        if (a.a(f12232f, (y) r21) == false) goto L8;
        r19.add(r21);     // Catch: IOException -> L23
        goto L8
    L12:
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));     // Catch: IOException -> L23
        Iterator r23 = r19.iterator();     // Catch: IOException -> L23
    L14:
        if (r23.hasNext() == false) goto L16;
        r22.add(f12232f.d((y) r23.next(), r17));     // Catch: IOException -> L23
        goto L14
    L16:
        CollectionsKt.addAll(r12, r22);     // Catch: IOException -> L23
        r14 = true;
        goto L4
    L18:
        if (r14 == false) goto L22;
        return CollectionsKt.toList(r12);
    L22:
        throw new FileNotFoundException("file not found: " + r10);
    }

    @Override // okio.i
    public List<y> b(y r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        String r11 = o(r10);
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator<Pair<i, y>> r13 = k().iterator();
        boolean r14 = false;
    L3:
        ArrayList r15 = null;
        if (r13.hasNext() == false) goto L20;
        Pair<i, y> r16 = r13.next();
        i r17 = r16.component1();
        y r18 = r16.component2();
        List<y> r19 = r17.b(r18.j(r11));
        if (r19 == null) goto L18;
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r19.iterator();
    L9:
        if (r21.hasNext() == false) goto L13;
        Object r22 = r21.next();
        a r23 = f12232f;
        if (a.a(r23, (y) r22) == false) goto L9;
        r20.add(r22);
        goto L9
    L13:
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r25 = r20.iterator();
    L15:
        if (r25.hasNext() == false) goto L17;
        y r26 = (y) r25.next();
        r24.add(f12232f.d(r26, r18));
        goto L15
    L17:
        r15 = r24;
    L18:
        if (r15 == null) goto L3;
        CollectionsKt.addAll(r12, r15);
        r14 = true;
        goto L3
    L20:
        if (r14 == true) goto L22;
        return null;
    L22:
        return CollectionsKt.toList(r12);
    }

    @Override // okio.i
    public h d(y r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        if (a.a(f12232f, r10) == true) goto L5;
        return null;
    L5:
        String r11 = o(r10);
        Iterator<Pair<i, y>> r12 = k().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        Pair<i, y> r13 = r12.next();
        h r14 = r13.component1().d(r13.component2().j(r11));
        if (r14 == null) goto L7;
        return r14;
    L12:
        return null;
    }

    @Override // okio.i
    public g e(y r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        if (a.a(f12232f, r10) == false) goto L13;
        String r11 = o(r10);
        Iterator<Pair<i, y>> r12 = k().iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        Pair<i, y> r13 = r12.next();
        return r13.component1().e(r13.component2().j(r11));
    L11:
        throw new FileNotFoundException("file not found: " + r10);
    L13:
        throw new FileNotFoundException("file not found: " + r10);
    }
}
