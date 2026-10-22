package pc;

import hc.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.platform.h;
import okio.f;
import okio.n;
import okio.t;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0276a f12377e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f12378f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f12379g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f12380h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f12381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CountDownLatch f12382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f12383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f12384d;

    /* JADX INFO: renamed from: pc.a$a, reason: collision with other inner class name */
    public static final class C0276a {
        private C0276a() {
        }

        public /* synthetic */ C0276a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ String a(C0276a r10, byte[] r11, byte[][] r12, int r13) {
            return r10.b(r11, r12, r13);
        }

        private final String b(byte[] r19, byte[][] r20, int r21) {
            int r10 = r19.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L42;
            int r12 = (r11 + r10) / 2;
        L6:
            if (r12 <= (-1)) goto L10;
            if (r19[r12] == 10) goto L10;
            r12 = r12 - 1;
        L10:
            int r13 = r12 + 1;
            int r14 = 1;
        L11:
            int r15 = r13 + r14;
            if (r19[r15] == 10) goto L14;
            r14 = r14 + 1;
            goto L11
        L14:
            int r16 = r15 - r13;
            int r17 = r21;
            boolean r18 = false;
            int r110 = 0;
            int r111 = 0;
        L16:
            if (r18 == false) goto L18;
            int r22 = 46;
            boolean r112 = false;
        L19:
            int r23 = r22 - e.d(r19[r13 + r111], 255);
            if (r23 != 0) goto L30;
            r111 = r111 + 1;
            r110 = r110 + 1;
            if (r111 == r16) goto L30;
            if (r20[r17].length == r110) goto L26;
            r18 = r112;
            goto L16
        L26:
            if (r17 == (r20.length - 1)) goto L30;
            r17 = r17 + 1;
            r110 = -1;
            r18 = true;
        L30:
            if (r23 < 0) goto L31;
            if (r23 > 0) goto L33;
            int r24 = r16 - r111;
            int r25 = r20[r17].length - r110;
            int r113 = r17 + 1;
            int r26 = r20.length;
        L35:
            if (r113 >= r26) goto L37;
            r25 = r25 + r20[r113].length;
            r113 = r113 + 1;
            goto L35
        L37:
            if (r25 < r24) goto L31;
            if (r25 > r24) goto L33;
            Charset r27 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(r27, "UTF_8");
            return new String(r19, r13, r16, r27);
        L33:
            r11 = r15 + 1;
        L31:
            r10 = r13 - 1;
            goto L3
        L18:
            r112 = r18;
            r22 = e.d(r20[r17][r110], 255);
            goto L19
        L42:
            return null;
        }

        public final a c() {
            return a.a();
        }
    }

    static {
        f12377e = new C0276a(null);
        f12378f = new byte[]{42};
        f12379g = CollectionsKt.listOf("*");
        f12380h = new a();
    }

    public a() {
        this.f12381a = new AtomicBoolean(false);
        this.f12382b = new CountDownLatch(1);
    }

    public static final /* synthetic */ a a() {
        return f12380h;
    }

    private final List<String> b(List<String> r18) {
        if (this.f12381a.get() == false) goto L5;
    L73:
        this.f12382b.await();     // Catch: InterruptedException -> L9
    L11:
        if (this.f12383c == null) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L72;
        int r11 = r18.size();
        byte[][] r12 = new byte[r11][];
        int r13 = 0;
    L16:
        if (r13 >= r11) goto L18;
        String r14 = r18.get(r13);
        Charset r15 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(r15, "UTF_8");
        byte[] r16 = r14.getBytes(r15);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).getBytes(charset)");
        r12[r13] = r16;
        r13 = r13 + 1;
        goto L16
    L18:
        int r17 = 0;
    L19:
        String r19 = null;
        if (r17 >= r11) goto L28;
        C0276a r20 = f12377e;
        byte[] r21 = this.f12383c;
        if (r21 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
        r21 = null;
    L24:
        String r22 = C0276a.a(r20, r21, r12, r17);
        if (r22 != null) goto L29;
        r17 = r17 + 1;
    L29:
        if (r11 <= 1) goto L39;
        byte[][] r23 = (byte[][]) r12.clone();
        int r24 = r23.length - 1;
        int r110 = 0;
    L31:
        if (r110 >= r24) goto L39;
        r23[r110] = f12378f;
        C0276a r111 = f12377e;
        byte[] r112 = this.f12383c;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
        r112 = null;
    L35:
        String r113 = C0276a.a(r111, r112, r23, r110);
        if (r113 != null) goto L37;
        r110 = r110 + 1;
        goto L31
    L37:
        String r25 = r113;
    L40:
        if (r25 == null) goto L51;
        int r26 = r11 - 1;
        int r27 = 0;
    L42:
        if (r27 >= r26) goto L51;
        C0276a r28 = f12377e;
        byte[] r114 = this.f12384d;
        if (r114 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
        r114 = null;
    L46:
        String r29 = C0276a.a(r28, r114, r12, r27);
        if (r29 != null) goto L48;
        r27 = r27 + 1;
        goto L42
    L48:
        r19 = r29;
    L51:
        if (r19 != null) goto L53;
        if (r22 != null) goto L58;
        if (r25 != null) goto L58;
        return f12379g;
    L58:
        if (r22 == null) goto L61;
        List<String> r30 = StringsKt.split$default(r22, new char[]{'.'}, false, 0, 6, null);
        if (r30 == null) goto L61;
    L62:
        if (r25 == null) goto L65;
        List<String> r31 = StringsKt.split$default(r25, new char[]{'.'}, false, 0, 6, null);
        if (r31 == null) goto L65;
    L67:
        if (r30.size() <= r31.size()) goto L70;
        return r30;
    L70:
        return r31;
    L65:
        r31 = CollectionsKt.emptyList();
    L61:
        r30 = CollectionsKt.emptyList();
        goto L62
    L53:
        return StringsKt.split$default('!' + r19, new char[]{'.'}, false, 0, 6, null);
    L39:
        r25 = null;
        goto L40
    L28:
        r22 = null;
        goto L29
    L72:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    L13:
        r10 = false;
    L9:
        Thread.currentThread().interrupt();
        goto L11
    L5:
        if (this.f12381a.compareAndSet(false, true) == false) goto L73;
        e();
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, byte[]] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, byte[]] */
    private final void d() {
        Ref.ObjectRef r10 = new Ref.ObjectRef();     // Catch: Throwable -> L23
        Ref.ObjectRef r11 = new Ref.ObjectRef();     // Catch: Throwable -> L23
        InputStream r12 = a.class.getResourceAsStream("publicsuffixes.gz");     // Catch: Throwable -> L23
        if (r12 != null) goto L6;
        this.f12382b.countDown();
        return;
    L6:
        f r13 = t.b(new n(t.g(r12)));     // Catch: Throwable -> L23
        r10.element = r13.L(r13.readInt());     // Catch: Throwable -> L18
        r11.element = r13.L(r13.readInt());     // Catch: Throwable -> L18
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L23
        monitor-enter(this);     // Catch: Throwable -> L23
        T r15 = r10.element;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L15
        this.f12383c = (byte[]) r15;     // Catch: Throwable -> L15
        T r16 = r11.element;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L15
        this.f12384d = (byte[]) r16;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L23
        this.f12382b.countDown();
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this.f12382b.countDown();
        throw th;
    }

    private final void e() {
        boolean r10 = false;
    L19:
        d();     // Catch: Throwable -> L7 IOException -> L9 InterruptedIOException -> L14
    L4:
        if (r10 == false) goto L23;
        Thread.currentThread().interrupt();
        return;
    L23:
        return;
    L7:
        th = move-exception;
        if (r10 == false) goto L18;
        Thread.currentThread().interrupt();
    L18:
        throw th;
    L14:
        Thread.interrupted();     // Catch: Throwable -> L7
        r10 = true;
    L9:
        e = move-exception;
        h.f11979a.g().j("Failed to read public suffix list", 5, e);     // Catch: Throwable -> L7
        if (r10 == false) goto L24;
        Thread.currentThread().interrupt();
        return;
    }

    private final List<String> f(String r10) {
        List<String> r11 = StringsKt.split$default(r10, new char[]{'.'}, false, 0, 6, null);
        if (Intrinsics.areEqual(CollectionsKt.last(r11), "") == true) goto L5;
        return r11;
    L5:
        return CollectionsKt.dropLast(r11, 1);
    }

    public final String c(String r11) {
        Intrinsics.checkNotNullParameter(r11, "domain");
        String r10 = IDN.toUnicode(r11);
        Intrinsics.checkNotNullExpressionValue(r10, "unicodeDomain");
        List<String> r12 = f(r10);
        List<String> r13 = b(r12);
        if (r12.size() == r13.size()) goto L5;
    L8:
        char r14 = r13.get(0).charAt(0);
        int r15 = r12.size();
        int r16 = r13.size();
        if (r14 == '!') goto L12;
        r16 = r16 + 1;
    L12:
        Sequence r17 = CollectionsKt.asSequence(f(r11));
        return SequencesKt.joinToString$default(SequencesKt.drop(r17, r15 - r16), ".", null, null, 0, null, null, 62, null);
    L5:
        if (r13.get(0).charAt(0) == '!') goto L8;
        return null;
    }
}
