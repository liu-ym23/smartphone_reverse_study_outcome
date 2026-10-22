package okhttp3.internal.publicsuffix;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import f4.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import nu.r;
import nu.x;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class PublicSuffixDatabase {
    public static final Companion Companion = null;
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = null;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = null;
    private static final PublicSuffixDatabase instance = null;
    private final AtomicBoolean listRead;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$binarySearch(Companion r5, byte[] r10, byte[][] r11, int r12) {
            return r5.binarySearch(r10, r11, r12);
        }

        private final String binarySearch(byte[] r19, byte[][] r20, int r21) {
            int r5 = r19.length;
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L44;
            int r11 = (r10 + r5) / 2;
        L6:
            if (r11 <= (-1)) goto L10;
            if (r19[r11] == ((byte) 10)) goto L10;
            r11 = r11 - 1;
        L10:
            int r12 = r11 + 1;
            int r13 = 1;
        L11:
            int r14 = r12 + r13;
            if (r19[r14] == ((byte) 10)) goto L14;
            r13 = r13 + 1;
            goto L11
        L14:
            int r15 = r14 - r12;
            int r16 = r21;
            boolean r17 = false;
            int r18 = 0;
            int r110 = 0;
        L16:
            if (r17 == false) goto L18;
            int r111 = 46;
            boolean r22 = false;
        L19:
            int r112 = r111 - Util.and(r19[r12 + r110], 255);
            if (r112 != 0) goto L29;
            r110 = r110 + 1;
            r18 = r18 + 1;
            if (r110 == r15) goto L29;
            if (r20[r16].length == r18) goto L28;
            r17 = r22;
            goto L16
        L28:
            if (r16 == (r20.length - 1)) goto L29;
            r16 = r16 + 1;
            r17 = true;
            r18 = -1;
        L29:
            if (r112 < 0) goto L30;
            if (r112 > 0) goto L32;
            int r23 = r15 - r110;
            int r24 = r20[r16].length - r18;
            int r113 = r16 + 1;
            int r25 = r20.length;
        L34:
            if (r113 >= r25) goto L36;
            r24 = r24 + r20[r113].length;
            r113 = r113 + 1;
            goto L34
        L36:
            if (r24 < r23) goto L30;
            if (r24 > r23) goto L32;
            return new String(r19, r12, r15, StandardCharsets.UTF_8);
        L32:
            r10 = r14 + 1;
        L30:
            r5 = r11;
            goto L3
        L18:
            boolean r114 = r17;
            r111 = Util.and(r20[r16][r18], 255);
            r22 = r114;
            goto L19
        L44:
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.access$getInstance$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$findMatchingRule$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(PublicSuffixDatabase r10) {
            super(r10, PublicSuffixDatabase.class, "publicSuffixListBytes", "getPublicSuffixListBytes()[B", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return PublicSuffixDatabase.access$getPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r5) {
            PublicSuffixDatabase.access$setPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver, (byte[]) r5);
        }
    }

    static {
        Companion = new Companion(null);
        WILDCARD_LABEL = new byte[]{(byte) 42};
        PREVAILING_RULE = CollectionsKt.listOf(XPath.WILDCARD);
        instance = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    public static final /* synthetic */ PublicSuffixDatabase access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase r5) {
        byte[] r10 = r5.publicSuffixListBytes;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
    L5:
        return r10;
    }

    public static final /* synthetic */ void access$setPublicSuffixListBytes$p(PublicSuffixDatabase r5, byte[] r10) {
        r5.publicSuffixListBytes = r10;
    }

    private final List<String> findMatchingRule(List<String> r12) {
        if (this.listRead.get() == false) goto L5;
    L76:
        this.readCompleteLatch.await();     // Catch: InterruptedException -> L9
    L11:
        if (this.publicSuffixListBytes == null) goto L75;
        int r5 = r12.size();
        byte[][] r10 = new byte[r5][];
        int r11 = 0;
    L13:
        if (r11 >= r5) goto L19;
        String r13 = r12.get(r11);
        Charset r14 = StandardCharsets.UTF_8;
        if (r13 == null) goto L18;
        r10[r11] = r13.getBytes(r14);
        r11 = r11 + 1;
        goto L13
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        int r15 = 0;
    L20:
        String r16 = null;
        if (r15 >= r5) goto L29;
        Companion r17 = Companion;
        byte[] r18 = this.publicSuffixListBytes;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
    L25:
        String r19 = Companion.access$binarySearch(r17, r18, r10, r15);
        if (r19 != null) goto L30;
        r15 = r15 + 1;
    L30:
        if (r5 <= 1) goto L40;
        byte[][] r110 = (byte[][]) r10.clone();
        int r20 = r110.length - 1;
        int r21 = 0;
    L32:
        if (r21 >= r20) goto L40;
        r110[r21] = WILDCARD_LABEL;
        Companion r22 = Companion;
        byte[] r111 = this.publicSuffixListBytes;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
    L36:
        String r23 = Companion.access$binarySearch(r22, r111, r110, r21);
        if (r23 != null) goto L41;
        r21 = r21 + 1;
    L41:
        if (r23 == null) goto L52;
        int r24 = r5 - 1;
        int r112 = 0;
    L43:
        if (r112 >= r24) goto L52;
        Companion r25 = Companion;
        byte[] r26 = this.publicSuffixExceptionListBytes;
        if (r26 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
    L47:
        String r27 = Companion.access$binarySearch(r25, r26, r10, r112);
        if (r27 != null) goto L49;
        r112 = r112 + 1;
        goto L43
    L49:
        r16 = r27;
    L52:
        if (r16 != null) goto L54;
        if (r19 != null) goto L59;
        if (r23 != null) goto L59;
        return PREVAILING_RULE;
    L59:
        if (r19 == null) goto L63;
        List<String> r28 = StringsKt.J(r19, new char[]{'.'}, 0, 6);
        if (r28 == null) goto L63;
    L64:
        if (r23 == null) goto L68;
        List<String> r113 = StringsKt.J(r23, new char[]{'.'}, 0, 6);
        if (r113 == null) goto L68;
    L70:
        if (r28.size() <= r113.size()) goto L73;
        return r28;
    L73:
        return r113;
    L68:
        r113 = CollectionsKt.emptyList();
    L63:
        r28 = CollectionsKt.emptyList();
        goto L64
    L54:
        return StringsKt.J(XPath.NOT.concat(r16), new char[]{'.'}, 0, 6);
    L40:
        r23 = null;
        goto L41
    L29:
        r19 = null;
        goto L30
    L75:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
    L9:
        Thread.currentThread().interrupt();
        goto L11
    L5:
        if (this.listRead.compareAndSet(false, true) == false) goto L76;
        readTheListUninterruptibly();
        goto L11
    }

    private final void readTheList() throws IOException {
        InputStream r5 = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (r5 == null) goto L20;
        x r10 = b.e(new r(b.p(r5)));
        long r11 = r10.readInt();     // Catch: Throwable -> L15
        r10.s(r11);     // Catch: Throwable -> L15
        byte[] r12 = r10.f20349a.K(r11);     // Catch: Throwable -> L15
        long r13 = r10.readInt();     // Catch: Throwable -> L15
        r10.s(r13);     // Catch: Throwable -> L15
        byte[] r14 = r10.f20349a.K(r13);     // Catch: Throwable -> L15
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r10, null);
        monitor-enter(this);
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L12
        this.publicSuffixListBytes = r12;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L12
        this.publicSuffixExceptionListBytes = r14;     // Catch: Throwable -> L12
        monitor-exit(this);
        this.readCompleteLatch.countDown();
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private final void readTheListUninterruptibly() {
        boolean r5 = false;
    L19:
        readTheList();     // Catch: Throwable -> L7 IOException -> L9 InterruptedIOException -> L14
    L4:
        if (r5 == false) goto L23;
        Thread.currentThread().interrupt();
        return;
    L23:
        return;
    L7:
        th = move-exception;
        if (r5 == false) goto L18;
        Thread.currentThread().interrupt();
    L18:
        throw th;
    L14:
        Thread.interrupted();     // Catch: Throwable -> L7
        r5 = true;
    L9:
        e = move-exception;
        Platform.Companion.get().log("Failed to read public suffix list", 5, e);     // Catch: Throwable -> L7
        if (r5 == false) goto L24;
        Thread.currentThread().interrupt();
        return;
    }

    private final List<String> splitDomain(String r5) {
        List<String> r10 = StringsKt.J(r5, new char[]{'.'}, 0, 6);
        if (Intrinsics.areEqual((String) CollectionsKt.last(r10), "") == true) goto L5;
        return r10;
    L5:
        return CollectionsKt.dropLast(r10, 1);
    }

    public final String getEffectiveTldPlusOne(String r10) {
        Intrinsics.checkNotNullParameter(r10, "domain");
        List<String> r5 = splitDomain(IDN.toUnicode(r10));
        List<String> r11 = findMatchingRule(r5);
        if (r5.size() != r11.size()) goto L9;
        if (r11.get(0).charAt(0) == '!') goto L9;
        return null;
    L9:
        if (r11.get(0).charAt(0) != '!') goto L12;
        int r12 = r5.size();
        int r13 = r11.size();
    L11:
        int r14 = r12 - r13;
        return SequencesKt.c(SequencesKt.drop(CollectionsKt.asSequence(splitDomain(r10)), r14), ".");
    L12:
        r12 = r5.size();
        r13 = r11.size() + 1;
        goto L11
    }

    public final void setListBytes(byte[] r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r5, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(r10, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = r5;
        this.publicSuffixExceptionListBytes = r10;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
