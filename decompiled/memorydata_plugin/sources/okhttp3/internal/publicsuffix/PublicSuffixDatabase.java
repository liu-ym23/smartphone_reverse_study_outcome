package okhttp3.internal.publicsuffix;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
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
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ String access$binarySearch(Companion r0, byte[] r1, byte[][] r2, int r3) {
            return r0.binarySearch(r1, r2, r3);
        }

        private final String binarySearch(byte[] r19, byte[][] r20, int r21) {
            int r2 = r19.length;
            String r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
            int r6 = 0;
        L3:
            if (r6 >= r2) goto L63;
            int r7 = (r6 + r2) / 2;
        L6:
            if (r7 <= (-1)) goto L10;
            if (r19[r7] == ((byte) 10)) goto L10;
            r7 = r7 - 1;
        L10:
            int r8 = r7 + 1;
            int r11 = 1;
        L11:
            int r12 = r8 + r11;
            if (r19[r12] == ((byte) 10)) goto L14;
            r11 = r11 + 1;
            goto L11
        L14:
            int r9 = r12 - r8;
            int r13 = r21;
            boolean r14 = false;
            int r15 = 0;
            int r16 = 0;
        L16:
            if (r14 == false) goto L18;
            int r17 = 46;
            boolean r10 = false;
        L19:
            int r18 = r17 - Util.and(r19[r8 + r16], 255);
            if (r18 != 0) goto L29;
            r16 = r16 + 1;
            r15 = r15 + 1;
            if (r16 == r9) goto L29;
            if (r20[r13].length == r15) goto L28;
            r14 = r10;
            goto L16
        L28:
            if (r13 == (((Object[]) ZeusTransformUtils.preCheckCast(r20, Object[].class, "com.obric.memorydata.plugin")).length - 1)) goto L29;
            r13 = r13 + 1;
            r14 = true;
            r15 = -1;
        L29:
            if (r18 < 0) goto L30;
            if (r18 > 0) goto L32;
            int r4 = r9 - r16;
            int r22 = r20[r13].length - r15;
            int r110 = r13 + 1;
            int r111 = ((Object[]) ZeusTransformUtils.preCheckCast(r20, Object[].class, "com.obric.memorydata.plugin")).length;
        L34:
            if (r110 >= r111) goto L36;
            r22 = r22 + r20[r110].length;
            r110 = r110 + 1;
            goto L34
        L36:
            if (r22 < r4) goto L30;
            if (r22 > r4) goto L32;
            Charset r1 = StandardCharsets.UTF_8;
            Intrinsics.checkExpressionValueIsNotNull(r1, "UTF_8");
            return new String(r19, r8, r9, r1);
        L32:
            r6 = r12 + 1;
        L30:
            r2 = r8 - 1;
            goto L3
        L18:
            boolean r112 = r14;
            r17 = Util.and(r20[r13][r15], 255);
            r10 = r112;
            goto L19
        L63:
            return r3;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.access$getInstance$cp();
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$findMatchingRule$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0 {
        AnonymousClass1(PublicSuffixDatabase r1) {
            super(r1);
        }

        @Override // kotlin.reflect.KProperty0
        public Object get() {
            return PublicSuffixDatabase.access$getPublicSuffixListBytes$p((PublicSuffixDatabase) ZeusTransformUtils.preCheckCast(this.receiver, PublicSuffixDatabase.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "publicSuffixListBytes";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(PublicSuffixDatabase.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getPublicSuffixListBytes()[B";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(Object r3) {
            PublicSuffixDatabase.access$setPublicSuffixListBytes$p((PublicSuffixDatabase) ZeusTransformUtils.preCheckCast(this.receiver, PublicSuffixDatabase.class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
        WILDCARD_LABEL = new byte[]{(byte) 42};
        PREVAILING_RULE = CollectionsKt.listOf("*");
        instance = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    public static final /* synthetic */ PublicSuffixDatabase access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase r1) {
        byte[] r2 = r1.publicSuffixListBytes;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$setPublicSuffixListBytes$p(PublicSuffixDatabase r0, byte[] r1) {
        r0.publicSuffixListBytes = r1;
    }

    private final List<String> findMatchingRule(List<String> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if (this.listRead.get() == false) goto L5;
    L79:
        this.readCompleteLatch.await();     // Catch: InterruptedException -> L9
    L11:
        if (((PublicSuffixDatabase) ZeusTransformUtils.preCheckCast(this, PublicSuffixDatabase.class, "com.obric.memorydata.plugin")).publicSuffixListBytes == null) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L78;
        int r2 = r15.size();
        byte[][] r5 = new byte[r2][];
        int r6 = 0;
    L16:
        if (r6 >= r2) goto L22;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r15.get(r6), String.class, "com.obric.memorydata.plugin");
        Charset r8 = StandardCharsets.UTF_8;
        Intrinsics.checkExpressionValueIsNotNull(r8, "UTF_8");
        if (r7 == null) goto L21;
        byte[] r9 = r7.getBytes(r8);
        Intrinsics.checkExpressionValueIsNotNull(r9, "(this as java.lang.String).getBytes(charset)");
        r5[r6] = r9;
        r6 = r6 + 1;
        goto L16
    L21:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L22:
        byte[][] r16 = (byte[][]) ZeusTransformUtils.preCheckCast(r5, byte[][].class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        int r10 = r16.length;
        int r11 = 0;
    L24:
        if (r11 >= r10) goto L32;
        Companion r12 = Companion;
        byte[] r13 = this.publicSuffixListBytes;
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
    L28:
        String r17 = Companion.access$binarySearch(r12, r13, r16, r11);
        if (r17 != null) goto L30;
        r11 = r11 + 1;
        goto L24
    L30:
        r3 = r17;
    L32:
        String r18 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        if (((Object[]) ZeusTransformUtils.preCheckCast(r16, Object[].class, "com.obric.memorydata.plugin")).length <= 1) goto L43;
        byte[][] r0 = (byte[][]) ZeusTransformUtils.preCheckCast(((Object[]) ZeusTransformUtils.preCheckCast(r16, Object[].class, "com.obric.memorydata.plugin")).clone(), byte[][].class, "com.obric.memorydata.plugin");
        int r19 = ((Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.memorydata.plugin")).length - 1;
        int r20 = 0;
    L35:
        if (r20 >= r19) goto L43;
        r0[r20] = WILDCARD_LABEL;
        Companion r110 = Companion;
        byte[] r111 = this.publicSuffixListBytes;
        if (r111 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
    L39:
        String r112 = Companion.access$binarySearch(r110, r111, r0, r20);
        if (r112 != null) goto L41;
        r20 = r20 + 1;
        goto L35
    L41:
        r18 = r112;
    L43:
        String r4 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L55;
        int r21 = ((Object[]) ZeusTransformUtils.preCheckCast(r16, Object[].class, "com.obric.memorydata.plugin")).length - 1;
        int r22 = 0;
    L46:
        if (r22 >= r21) goto L55;
        Companion r23 = Companion;
        byte[] r24 = this.publicSuffixExceptionListBytes;
        if (r24 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
    L50:
        String r25 = Companion.access$binarySearch(r23, r24, r16, r22);
        if (r25 != null) goto L52;
        r22 = r22 + 1;
        goto L46
    L52:
        r4 = r25;
    L55:
        if (r4 != null) goto L57;
        if (r3 != null) goto L62;
        if (r18 != null) goto L62;
        return PREVAILING_RULE;
    L62:
        if (r3 == null) goto L66;
        List<String> r113 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'.'}, false, 0, 6, null);
        if (r113 == null) goto L66;
    L67:
        if (r18 == null) goto L71;
        List<String> r114 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'.'}, false, 0, 6, null);
        if (r114 == null) goto L71;
    L73:
        if (r113.size() <= r114.size()) goto L76;
        return r113;
    L76:
        return r114;
    L71:
        r114 = CollectionsKt.emptyList();
    L66:
        r113 = CollectionsKt.emptyList();
        goto L67
    L57:
        return StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(EXCEPTION_MARKER + r4, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'.'}, false, 0, 6, null);
    L78:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L13:
        r1 = false;
    L9:
        Thread.currentThread().interrupt();
        goto L11
    L5:
        if (this.listRead.compareAndSet(false, true) == false) goto L79;
        readTheListUninterruptibly();
        goto L11
    }

    private final void readTheList() {
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(null, byte[].class, "com.obric.memorydata.plugin");
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(null, byte[].class, "com.obric.memorydata.plugin");
        InputStream r2 = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (r2 == null) goto L25;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(Okio.buffer((Source) ZeusTransformUtils.preCheckCast(new GzipSource(Okio.source(r2)), Source.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
        BufferedSource r5 = (BufferedSource) ZeusTransformUtils.preCheckCast(r3, BufferedSource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        byte[] r6 = r5.readByteArray(r5.readInt());     // Catch: Throwable -> L20
        byte[] r7 = r5.readByteArray(r5.readInt());     // Catch: Throwable -> L20
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r3, r4);
        monitor-enter(this);
        if (r6 == null) goto L26;
    L10:
        this.publicSuffixListBytes = r6;     // Catch: Throwable -> L17
        if (r7 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L17
    L13:
        this.publicSuffixExceptionListBytes = r7;     // Catch: Throwable -> L17
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        this.readCompleteLatch.countDown();
        return;
    L17:
        th = move-exception;
        throw th;
    L26:
        Intrinsics.throwNpe();     // Catch: Throwable -> L17
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    private final void readTheListUninterruptibly() {
        boolean r0 = false;
    L19:
        readTheList();     // Catch: Throwable -> L7 IOException -> L9 InterruptedIOException -> L14
        if (r0 == false) goto L6;
        Thread.currentThread().interrupt();     // Catch: IOException -> L9 InterruptedIOException -> L14
    L23:
        return;
    L6:
        return;
    L7:
        th = move-exception;
        if (r0 == false) goto L18;
        Thread.currentThread().interrupt();
    L18:
        throw th;
    L14:
        Thread.interrupted();     // Catch: Throwable -> L7
        r0 = true;
    L9:
        e = move-exception;
        Platform.Companion.get().log(5, "Failed to read public suffix list", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        if (r0 == false) goto L24;
        Thread.currentThread().interrupt();
        return;
    }

    public final String getEffectiveTldPlusOne(String r18) {
        Intrinsics.checkParameterIsNotNull(r18, "domain");
        String r1 = IDN.toUnicode(r18);
        Intrinsics.checkExpressionValueIsNotNull(r1, "unicodeDomain");
        List<String> r4 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'.'}, false, 0, 6, null);
        List<String> r5 = findMatchingRule(r4);
        if (r4.size() == r5.size()) goto L5;
    L8:
        char r6 = ((String) ZeusTransformUtils.preCheckCast(r5.get(0), String.class, "com.obric.memorydata.plugin")).charAt(0);
        int r7 = r4.size();
        int r8 = r5.size();
        if (r6 == '!') goto L13;
        r8 = r8 + 1;
    L13:
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'.'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin")), r7 - r8), (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L5:
        if (((String) ZeusTransformUtils.preCheckCast(r5.get(0), String.class, "com.obric.memorydata.plugin")).charAt(0) == '!') goto L8;
        return null;
    }

    public final void setListBytes(byte[] r2, byte[] r3) {
        Intrinsics.checkParameterIsNotNull(r2, "publicSuffixListBytes");
        Intrinsics.checkParameterIsNotNull(r3, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = r2;
        this.publicSuffixExceptionListBytes = r3;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
