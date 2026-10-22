package hc;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.a0;
import okhttp3.q;
import okhttp3.r;
import okhttp3.s;
import okhttp3.y;
import okhttp3.z;
import okio.ByteString;
import okio.f0;
import okio.g0;
import okio.w;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "Util")
@SourceDebugExtension({"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokhttp3/internal/Util\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,636:1\n37#2,2:637\n1627#3,6:639\n1#4:645\n1549#5:646\n1620#5,3:647\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokhttp3/internal/Util\n*L\n127#1:637,2\n167#1:639,6\n300#1:646\n300#1:647,3\n*E\n"})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final byte[] f9277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final r f9278b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final a0 f9279c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final w f9280d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public static final TimeZone f9281e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Regex f9282f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public static final boolean f9283g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final String f9284h = null;

    static {
        byte[] r10 = new byte[0];
        f9277a = r10;
        f9278b = r.f12022g.h(new String[0]);
        f9279c = a0.a.c(a0.f11678c, r10, null, 1, null);
        y.a.h(y.f12130a, r10, null, 0, 0, 7, null);
        w.a r11 = w.f12269h;
        ByteString.a r12 = ByteString.Companion;
        f9280d = r11.d(new ByteString[]{r12.b("efbbbf"), r12.b("feff"), r12.b("fffe"), r12.b("0000ffff"), r12.b("ffff0000")});
        TimeZone r13 = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(r13);
        f9281e = r13;
        f9282f = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f9283g = false;
        String r14 = okhttp3.w.class.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "OkHttpClient::class.java.name");
        f9284h = StringsKt.removeSuffix(StringsKt.removePrefix(r14, "okhttp3."), "Client");
    }

    public static /* synthetic */ int A(String r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        return z(r10, r11, r12);
    }

    public static final int B(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r13 = r12 - 1;
        if (r11 > r13) goto L33;
    L4:
        char r14 = r10.charAt(r13);
        boolean r15 = false;
        if (r14 != '\t') goto L8;
    L6:
        boolean r16 = true;
    L11:
        if (r16 == false) goto L14;
    L12:
        boolean r17 = true;
    L17:
        if (r17 == false) goto L20;
    L18:
        boolean r18 = true;
    L23:
        if (r18 == false) goto L26;
    L24:
        r15 = true;
    L28:
        if (r15 == false) goto L30;
        if (r13 == r11) goto L33;
        r13 = r13 - 1;
        goto L4
    L30:
        return r13 + 1;
    L26:
        if (r14 != ' ') goto L28;
    L20:
        if (r14 == '\r') goto L18;
        r18 = false;
        goto L23
    L14:
        if (r14 == '\f') goto L12;
        r17 = false;
        goto L17
    L8:
        if (r14 == '\n') goto L6;
        r16 = false;
    L33:
        return r11;
    }

    public static /* synthetic */ int C(String r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        return B(r10, r11, r12);
    }

    public static final int D(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length();
    L3:
        if (r11 >= r12) goto L11;
        char r13 = r10.charAt(r11);
        if (r13 == ' ') goto L9;
        if (r13 == '\t') goto L9;
        return r11;
    L9:
        r11 = r11 + 1;
        goto L3
    L11:
        return r10.length();
    }

    public static final String[] E(String[] r10, String[] r11, Comparator<? super String> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "comparator");
        ArrayList r13 = new ArrayList();
        int r14 = r10.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L12;
        String r16 = r10[r15];
        int r17 = r11.length;
        int r18 = 0;
    L5:
        if (r18 >= r17) goto L10;
        if (r12.compare(r16, r11[r18]) == 0) goto L8;
        r18 = r18 + 1;
        goto L5
    L8:
        r13.add(r16);
    L10:
        r15 = r15 + 1;
        goto L3
    L12:
        return (String[]) r13.toArray(new String[0]);
    }

    public static final boolean F(Socket r10, okio.f r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "source");
        int r12 = r10.getSoTimeout();     // Catch: IOException -> L10 SocketTimeoutException -> L12
        r10.setSoTimeout(1);     // Catch: Throwable -> L7
        boolean r13 = !r11.n();
        r10.setSoTimeout(r12);     // Catch: IOException -> L10 SocketTimeoutException -> L12
        return r13;
    L7:
        th = move-exception;
        r10.setSoTimeout(r12);     // Catch: IOException -> L10 SocketTimeoutException -> L12
        throw th;     // Catch: IOException -> L10 SocketTimeoutException -> L12
    L10:
        return false;
    L17:
        return true;
    }

    public static final boolean G(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        if (StringsKt.equals(r10, "Authorization", true) == false) goto L5;
        return true;
    L5:
        if (StringsKt.equals(r10, "Cookie", true) == false) goto L7;
        return true;
    L7:
        if (StringsKt.equals(r10, "Proxy-Authorization", true) == false) goto L9;
        return true;
    L9:
        if (StringsKt.equals(r10, Api.KEY_SET_COOKIE, true) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static final int H(char r10) {
        boolean r11 = true;
        if ('0' <= r10) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == true) goto L28;
        char r13 = 'a';
        if ('a' <= r10) goto L13;
    L15:
        boolean r14 = false;
    L16:
        if (r14 == true) goto L29;
        r13 = 'A';
        if ('A' <= r10) goto L21;
    L23:
        r11 = false;
    L24:
        if (r11 == true) goto L29;
        return -1;
    L21:
        if (r10 >= 'G') goto L23;
    L29:
        return (r10 - r13) + 10;
    L13:
        if (r10 >= 'g') goto L15;
        r14 = true;
        goto L16
    L28:
        return r10 - '0';
    L5:
        if (r10 >= ':') goto L7;
        r12 = true;
        goto L8
    }

    public static final Charset I(okio.f r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE);
        int r12 = r10.b0(f9280d);
        if (r12 == (-1)) goto L22;
        if (r12 != 0) goto L6;
        Charset r13 = StandardCharsets.UTF_8;
        String r14 = "UTF_8";
    L20:
        Intrinsics.checkNotNullExpressionValue(r13, r14);
        return r13;
    L6:
        if (r12 != 1) goto L8;
        r13 = StandardCharsets.UTF_16BE;
        r14 = "UTF_16BE";
        goto L20
    L8:
        if (r12 != 2) goto L10;
        r13 = StandardCharsets.UTF_16LE;
        r14 = "UTF_16LE";
        goto L20
    L10:
        if (r12 == 3) goto L24;
        if (r12 != 4) goto L15;
        return Charsets.INSTANCE.UTF32_LE();
    L15:
        throw new AssertionError();
    L24:
        return Charsets.INSTANCE.UTF32_BE();
    L22:
        return r11;
    }

    public static final <T> T J(Object r10, Class<T> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "instance");
        Intrinsics.checkNotNullParameter(r11, "fieldType");
        Intrinsics.checkNotNullParameter(r12, "fieldName");
        Class<?> r13 = r10.getClass();
    L3:
        T r14 = null;
        if (Intrinsics.areEqual(r13, Object.class) == true) goto L12;
        Field r15 = r13.getDeclaredField(r12);     // Catch: NoSuchFieldException -> L10
        r15.setAccessible(true);     // Catch: NoSuchFieldException -> L10
        Object r16 = r15.get(r10);     // Catch: NoSuchFieldException -> L10
        if (r11.isInstance(r16) == false) goto L9;
        r14 = r11.cast(r16);     // Catch: NoSuchFieldException -> L10
    L9:
        return r14;
    L10:
        r13 = r13.getSuperclass();
        Intrinsics.checkNotNullExpressionValue(r13, "c.superclass");
        goto L3
    L12:
        if (Intrinsics.areEqual(r12, "delegate") == true) goto L17;
        Object r17 = J(r10, Object.class, "delegate");
        if (r17 == null) goto L17;
        return (T) J(r17, r11, r12);
    L17:
        return null;
    }

    public static final int K(okio.f r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = (d(r10.readByte(), 255) << 16) | (d(r10.readByte(), 255) << 8);
        return d(r10.readByte(), 255) | r11;
    }

    public static final int L(okio.d r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = 0;
    L4:
        if (r10.n() == true) goto L8;
        if (r10.r(0) != r11) goto L8;
        r12 = r12 + 1;
        r10.readByte();
    L8:
        return r12;
    }

    public static final boolean M(f0 r11, int r12, TimeUnit r13) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r13, "timeUnit");
        long r10 = System.nanoTime();
        if (r11.timeout().e() == false) goto L5;
        long r14 = r11.timeout().c() - r10;
    L6:
        r11.timeout().d(Math.min(r14, r13.toNanos(r12)) + r10);
        okio.d r15 = new okio.d();     // Catch: Throwable -> L16 InterruptedIOException -> L22
    L9:
        if (r11.S(r15, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L12;
        r15.f();     // Catch: Throwable -> L16 InterruptedIOException -> L22
    L12:
        boolean r16 = true;
        if (r14 != Long.MAX_VALUE) goto L15;
    L14:
        r11.timeout().a();
    L25:
        return r16;
    L15:
        r11.timeout().d(r10 + r14);
    L22:
        r16 = false;
        if (r14 != Long.MAX_VALUE) goto L15;
    L16:
        th = move-exception;
        g0 r17 = r11.timeout();
        if (r14 != Long.MAX_VALUE) goto L20;
        r17.a();
    L21:
        throw th;
    L20:
        r17.d(r10 + r14);
        goto L21
    L5:
        r14 = Long.MAX_VALUE;
        goto L6
    }

    public static final ThreadFactory N(final String r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return new c(r10, r11);
    }

    private static final Thread O(String r10, boolean r11, Runnable r12) {
        Intrinsics.checkNotNullParameter(r10, "$name");
        Thread r13 = new Thread(r12, r10);
        r13.setDaemon(r11);
        return r13;
    }

    public static final List<mc.a> P(r r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        IntRange r11 = RangesKt.until(0, r10.size());
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<Integer> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        int r14 = ((IntIterator) r13).nextInt();
        r12.add(new mc.a(r10.c(r14), r10.i(r14)));
        goto L4
    L6:
        return r12;
    }

    public static final r Q(List<mc.a> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r.a r11 = new r.a();
        Iterator<mc.a> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        mc.a r13 = r12.next();
        ByteString r14 = r13.a();
        ByteString r15 = r13.b();
        r11.c(r14.utf8(), r15.utf8());
        goto L4
    L7:
        return r11.e();
    }

    public static final String R(s r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (StringsKt.contains$default(r10.h(), ":", false, 2, null) == false) goto L5;
        String r12 = '[' + r10.h() + ']';
    L6:
        if (r11 == true) goto L10;
        if (r10.n() != s.f12025k.c(r10.s())) goto L10;
        return r12;
    L10:
        return r12 + ':' + r10.n();
    L5:
        r12 = r10.h();
        goto L6
    }

    public static /* synthetic */ String S(s r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        return R(r10, r11);
    }

    public static final <T> List<T> T(List<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<T> r11 = Collections.unmodifiableList(CollectionsKt.toMutableList(r10));
        Intrinsics.checkNotNullExpressionValue(r11, "unmodifiableList(toMutableList())");
        return r11;
    }

    public static final <K, V> Map<K, V> U(Map<K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        Map<K, V> r11 = Collections.unmodifiableMap(new LinkedHashMap(r10));
        Intrinsics.checkNotNullExpressionValue(r11, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return r11;
    L7:
        return MapsKt.emptyMap();
    }

    public static final long V(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Long.parseLong(r10);
    L8:
        return r11;
    }

    public static final int W(String r10, int r11) {
        if (r10 != null) goto L14;
    L12:
        return r11;
    L14:
        long r12 = Long.parseLong(r10);     // Catch: NumberFormatException -> L13
        if (r12 <= 2147483647L) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r12 >= 0) goto L11;
        return 0;
    L11:
        return (int) r12;
    }

    public static final String X(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r13 = z(r10, r11, r12);
        String r14 = r10.substring(r13, B(r10, r13, r12));
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return r14;
    }

    public static /* synthetic */ String Y(String r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        return X(r10, r11, r12);
    }

    public static final Throwable Z(Exception r10, List<? extends Exception> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "suppressed");
        Iterator<? extends Exception> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ExceptionsKt.addSuppressed(r10, r12.next());
        goto L4
    L6:
        return r10;
    }

    public static /* synthetic */ q a(q r10, okhttp3.e r11) {
        return h(r10, r11);
    }

    public static final void a0(okio.e r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.writeByte((r11 >>> 16) & 255);
        r10.writeByte((r11 >>> 8) & 255);
        r10.writeByte(r11 & 255);
    }

    public static /* synthetic */ Thread b(String r10, boolean r11, Runnable r12) {
        return O(r10, r11, r12);
    }

    public static final <E> void c(List<E> r10, E r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.contains(r11) == true) goto L6;
        r10.add(r11);
        return;
    }

    public static final int d(byte r10, int r11) {
        return r10 & r11;
    }

    public static final int e(short r10, int r11) {
        return r10 & r11;
    }

    public static final long f(int r10, long r11) {
        return ((long) r10) & r11;
    }

    public static final q.c g(final q r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new d(r10);
    }

    private static final q h(q r10, okhttp3.e r11) {
        Intrinsics.checkNotNullParameter(r10, "$this_asFactory");
        Intrinsics.checkNotNullParameter(r11, "it");
        return r10;
    }

    public static final boolean i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return f9282f.matches(r10);
    }

    public static final boolean j(s r10, s r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        if (Intrinsics.areEqual(r10.h(), r11.h()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r10.n() != r11.n()) goto L9;
        if (Intrinsics.areEqual(r10.s(), r11.s()) == false) goto L9;
        return true;
    }

    public static final int k(String r10, long r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        boolean r13 = true;
        if (r11 < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L31;
        if (r12 == null) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L29;
        long r16 = r12.toMillis(r11);
        if (r16 > 2147483647L) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == false) goto L27;
        if (r16 != 0) goto L21;
        if (r11 <= 0) goto L21;
        r13 = false;
    L21:
        if (r13 == false) goto L25;
        return (int) r16;
    L25:
        throw new IllegalArgumentException((r10 + " too small.").toString());
    L27:
        throw new IllegalArgumentException((r10 + " too large.").toString());
    L14:
        r17 = false;
        goto L15
    L29:
        throw new IllegalStateException("unit == null".toString());
    L9:
        r15 = false;
        goto L10
    L31:
        throw new IllegalStateException((r10 + " < 0").toString());
    L5:
        r14 = false;
        goto L6
    }

    public static final void l(long r10, long r11, long r12) {
        if ((r11 | r12) < 0) goto L10;
        if (r11 > r10) goto L10;
        if ((r10 - r11) < r12) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final void m(Closeable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.close();     // Catch: Exception -> L7 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static final void n(Socket r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.close();     // Catch: Exception -> L12 RuntimeException -> L5 AssertionError -> L10
        return;
    L10:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (Intrinsics.areEqual(e.getMessage(), "bio == null") == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static final String[] o(String[] r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        Object[] r12 = Arrays.copyOf(r10, r10.length + 1);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        String[] r13 = (String[]) r12;
        r13[ArraysKt.getLastIndex(r13)] = r11;
        return r13;
    }

    public static final int p(String r10, char r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
    L3:
        if (r12 >= r13) goto L8;
        if (r10.charAt(r12) == r11) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return r13;
    }

    public static final int q(String r10, String r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "delimiters");
    L3:
        if (r12 >= r13) goto L8;
        if (StringsKt.contains$default(r11, r10.charAt(r12), false, 2, null) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return r13;
    }

    public static /* synthetic */ int r(String r10, char r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length();
    L9:
        return p(r10, r11, r12, r13);
    }

    public static final boolean s(f0 r10, int r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "timeUnit");
        return M(r10, r11, r12);
    L5:
        return false;
    }

    public static final String t(String r10, Object... r11) {
        Intrinsics.checkNotNullParameter(r10, "format");
        Intrinsics.checkNotNullParameter(r11, "args");
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        Locale r13 = Locale.US;
        Object[] r14 = Arrays.copyOf(r11, r11.length);
        String r15 = String.format(r13, r10, Arrays.copyOf(r14, r14.length));
        Intrinsics.checkNotNullExpressionValue(r15, "format(locale, format, *args)");
        return r15;
    }

    public static final boolean u(String[] r10, String[] r11, Comparator<? super String> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "comparator");
        if (r10.length != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L23;
        if (r11 == null) goto L23;
        if (r11.length != 0) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == true) goto L23;
        int r15 = r10.length;
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L23;
        String r17 = r10[r16];
        Iterator r18 = ArrayIteratorKt.iterator(r11);
    L18:
        if (r18.hasNext() == false) goto L22;
        if (r12.compare(r17, (String) r18.next()) != 0) goto L18;
        return true;
    L22:
        r16 = r16 + 1;
        goto L15
    L11:
        r14 = false;
    L23:
        return false;
    L5:
        r13 = false;
        goto L6
    }

    public static final long v(z r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.v().b("Content-Length");
        if (r11 != null) goto L5;
        return -1;
    L5:
        return V(r11, -1);
    }

    @SafeVarargs
    public static final <T> List<T> w(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        Object[] r11 = (Object[]) r10.clone();
        List<T> r12 = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(r11, r11.length)));
        Intrinsics.checkNotNullExpressionValue(r12, "unmodifiableList(listOf(*elements.clone()))");
        return r12;
    }

    public static final int x(String[] r10, String r11, Comparator<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r12, "comparator");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        if (r12.compare(r10[r14], r11) != 0) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == true) goto L15;
        r14 = r14 + 1;
        goto L3
    L15:
        return r14;
    L7:
        r15 = false;
        goto L8
    L11:
        return -1;
    }

    public static final int y(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        char r13 = r10.charAt(r12);
        if (Intrinsics.compare(r13, 31) <= 0) goto L10;
        if (Intrinsics.compare(r13, 127) >= 0) goto L10;
        r12 = r12 + 1;
    L10:
        return r12;
    L11:
        return -1;
    }

    public static final int z(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
    L3:
        if (r11 >= r12) goto L31;
        char r13 = r10.charAt(r11);
        boolean r14 = false;
        if (r13 != '\t') goto L8;
    L6:
        boolean r15 = true;
    L11:
        if (r15 == false) goto L14;
    L12:
        boolean r16 = true;
    L17:
        if (r16 == false) goto L20;
    L18:
        boolean r17 = true;
    L23:
        if (r17 == false) goto L26;
    L24:
        r14 = true;
    L28:
        if (r14 == false) goto L29;
        r11 = r11 + 1;
        goto L3
    L29:
        return r11;
    L26:
        if (r13 != ' ') goto L28;
    L20:
        if (r13 == '\r') goto L18;
        r17 = false;
        goto L23
    L14:
        if (r13 == '\f') goto L12;
        r16 = false;
        goto L17
    L8:
        if (r13 == '\n') goto L6;
        r15 = false;
        goto L11
    L31:
        return r12;
    }
}
