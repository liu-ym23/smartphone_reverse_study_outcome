package okio;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.internal.ZipFilesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nZipFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,175:1\n52#2,5:176\n52#2,21:181\n60#2,10:202\n57#2,2:212\n71#2,2:214\n52#2,21:216\n*S KotlinDebug\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n*L\n102#1:176,5\n103#1:181,21\n102#1:202,10\n102#1:212,2\n102#1:214,2\n132#1:216,21\n*E\n"})
public final class i0 extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final y f12228f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y f12229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f12230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<y, okio.internal.f> f12231e;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        f12228f = y.a.e(y.f12274g, "/", false, 1, null);
    }

    public i0(y r10, i r11, Map<y, okio.internal.f> r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "zipPath");
        Intrinsics.checkNotNullParameter(r11, "fileSystem");
        Intrinsics.checkNotNullParameter(r12, "entries");
        this.f12229c = r10;
        this.f12230d = r11;
        this.f12231e = r12;
    }

    private final y f(y r10) {
        return f12228f.l(r10, true);
    }

    private final List<y> g(y r10, boolean r11) {
        okio.internal.f r12 = this.f12231e.get(f(r10));
        if (r12 != null) goto L10;
        if (r11 == true) goto L8;
        return null;
    L8:
        throw new IOException("not a directory: " + r10);
    L10:
        return CollectionsKt.toList(r12.b());
    }

    @Override // okio.i
    public List<y> a(y r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        List<y> r11 = g(r10, true);
        Intrinsics.checkNotNull(r11);
        return r11;
    }

    @Override // okio.i
    public List<y> b(y r10) {
        Intrinsics.checkNotNullParameter(r10, "dir");
        return g(r10, false);
    }

    @Override // okio.i
    public h d(y r14) {
        Intrinsics.checkNotNullParameter(r14, "path");
        okio.internal.f r15 = this.f12231e.get(f(r14));
        Throwable th = null;
        if (r15 != null) goto L5;
        return null;
    L5:
        boolean r10 = !r15.f();
        boolean r11 = r15.f();
        if (r15.f() == false) goto L8;
        Long r12 = null;
    L9:
        h r13 = new h(r10, r11, null, r12, null, r15.c(), null, null, 128, null);
        if (r15.d() != (-1)) goto L12;
        return r13;
    L12:
        g r16 = this.f12230d.e(this.f12229c);
        f r17 = t.b(r16.u(r15.d()));     // Catch: Throwable -> L36
        h r18 = ZipFilesKt.h(r17, r13);     // Catch: Throwable -> L21
        if (r17 != null) goto L54;
    L20:
        Throwable th2 = null;
    L28:
        if (th2 != null) goto L35;
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L36
        if (r16 != null) goto L51;
    L43:
        if (th != null) goto L46;
        Intrinsics.checkNotNull(r18);
        return r18;
    L46:
        throw th;
    L51:
        r16.close();     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L43
    L35:
        throw th2;     // Catch: Throwable -> L36
    L54:
        r17.close();     // Catch: Throwable -> L18
    L18:
        th2 = th;
        goto L28
    L21:
        th = move-exception;
        if (r17 != null) goto L49;
    L27:
        th2 = th;
        r18 = null;
        goto L28
    L49:
        r17.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        if (r16 != null) goto L47;
    L42:
        r18 = null;
        th = th;
        goto L43
    L47:
        r16.close();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L42
    L8:
        r12 = Long.valueOf(r15.e());
        goto L9
    }

    @Override // okio.i
    public g e(y r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }
}
