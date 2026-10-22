package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.g;
import okio.h;
import okio.i;
import okio.i0;
import okio.t;
import okio.y;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nZipFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,459:1\n1045#2:460\n*S KotlinDebug\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n*L\n156#1:460\n*E\n"})
public final class ZipFilesKt {

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 ZipFiles.kt\nokio/internal/ZipFilesKt\n*L\n1#1,328:1\n156#2:329\n*E\n"})
    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r10, T r11) {
            return ComparisonsKt.compareValues(((f) r10).a(), ((f) r11).a());
        }
    }

    private static final Map<y, f> a(List<f> r22) {
        y r10 = y.a.e(y.f12274g, "/", false, 1, null);
        Map<y, f> r11 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r10, new f(r10, true, null, 0, 0, 0, 0, null, 0, TypedValues.PositionType.TYPE_CURVE_FIT, null))});
        Iterator r12 = CollectionsKt.sortedWith(r22, new a()).iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        f r13 = (f) r12.next();
        if (r11.put(r13.a(), r13) != null) goto L4;
    L7:
        y r14 = r13.a().h();
        if (r14 == null) goto L4;
        f r15 = r11.get(r14);
        if (r15 != null) goto L12;
        f r16 = new f(r14, true, null, 0, 0, 0, 0, null, 0, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        r11.put(r14, r16);
        r16.b().add(r13.a());
        r13 = r16;
        goto L7
    L12:
        r15.b().add(r13.a());
        goto L4
    L14:
        return r11;
    }

    private static final Long b(int r10, int r11) {
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        GregorianCalendar r12 = new GregorianCalendar();
        r12.set(14, 0);
        r12.set(((r10 >> 9) & 127) + 1980, ((r10 >> 5) & 15) - 1, r10 & 31, (r11 >> 11) & 31, (r11 >> 5) & 63, (r11 & 31) << 1);
        return Long.valueOf(r12.getTime().getTime());
    }

    private static final String c(int r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append("0x");
        String r12 = Integer.toString(r10, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        r11.append(r12);
        return r11.toString();
    }

    public static final i0 d(y r18, i r19, Function1<? super f, Boolean> r20) {
        Intrinsics.checkNotNullParameter(r18, "zipPath");
        Intrinsics.checkNotNullParameter(r19, "fileSystem");
        Intrinsics.checkNotNullParameter(r20, "predicate");
        g r10 = r19.e(r18);
        long r11 = r10.s() - ((long) 22);     // Catch: Throwable -> L78
        long r12 = 0;
        if (r11 < 0) goto L77;
        long r13 = Math.max(r11 - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0);     // Catch: Throwable -> L78
    L6:
        okio.f r14 = t.b(r10.u(r11));     // Catch: Throwable -> L78
    L73:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L8:
        if (r14.H() == 101010256) goto L9;
        r14.close();     // Catch: Throwable -> L78
        r11 = r11 - 1;     // Catch: Throwable -> L78
        if (r11 >= r13) goto L6;
        throw new IOException("not a zip: end of central directory signature not found");     // Catch: Throwable -> L78
    L9:
        e r15 = f(r14);     // Catch: Throwable -> L73
        String r16 = r14.e(r15.b());     // Catch: Throwable -> L73
        r14.close();     // Catch: Throwable -> L78
        long r17 = r11 - ((long) 20);     // Catch: Throwable -> L78
        if (r17 <= 0) goto L45;
        okio.f r21 = t.b(r10.u(r17));     // Catch: Throwable -> L78
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r21, th);     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L14:
        if (r21.H() != 117853008) goto L35;
        int r22 = r21.H();     // Catch: Throwable -> L38
        long r110 = r21.T();     // Catch: Throwable -> L38
        if (r21.H() != 1) goto L34;
        if (r22 != 0) goto L34;
        okio.f r23 = t.b(r10.u(r110));     // Catch: Throwable -> L38
        int r111 = r23.H();     // Catch: Throwable -> L26
        if (r111 != 101075792) goto L25;
        r15 = j(r23, r15);     // Catch: Throwable -> L26
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r23, null);     // Catch: Throwable -> L38
        goto L35
    L25:
        throw new IOException("bad zip: expected " + c(101075792) + " but was " + c(r111));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r23, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L34:
        throw new IOException("unsupported zip: spanned");     // Catch: Throwable -> L38
    L35:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r21, null);     // Catch: Throwable -> L78
    L45:
        ArrayList r25 = new ArrayList();     // Catch: Throwable -> L78
        okio.f r26 = t.b(r10.u(r15.a()));     // Catch: Throwable -> L78
        long r113 = r15.c();     // Catch: Throwable -> L61
    L48:
        if (r12 >= r113) goto L57;
        f r114 = e(r26);     // Catch: Throwable -> L61
        if (r114.d() >= r15.a()) goto L56;
        if (r20.invoke(r114).booleanValue() == false) goto L54;
        r25.add(r114);     // Catch: Throwable -> L61
    L54:
        r12 = r12 + 1;     // Catch: Throwable -> L61
        goto L48
    L56:
        throw new IOException("bad zip: local file header offset >= central directory offset");     // Catch: Throwable -> L61
    L57:
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L61
        CloseableKt.closeFinally(r26, null);     // Catch: Throwable -> L78
        i0 r28 = new i0(r18, r19, a(r25), r16);     // Catch: Throwable -> L78
        CloseableKt.closeFinally(r10, null);
        return r28;
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        CloseableKt.closeFinally(r26, th);     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L77:
        throw new IOException("not a zip: size=" + r10.s());     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    public static final f e(final okio.f r26) {
        Intrinsics.checkNotNullParameter(r26, "<this>");
        int r10 = r26.H();
        if (r10 != 33639248) goto L32;
        r26.skip(4);
        int r11 = r26.R() & UShort.MAX_VALUE;
        if ((r11 & 1) != 0) goto L30;
        int r12 = r26.R() & UShort.MAX_VALUE;
        Long r13 = b(r26.R() & UShort.MAX_VALUE, r26.R() & UShort.MAX_VALUE);
        long r14 = ((long) r26.H()) & 4294967295L;
        final Ref.LongRef r15 = new Ref.LongRef();
        r15.element = ((long) r26.H()) & 4294967295L;
        final Ref.LongRef r16 = new Ref.LongRef();
        r16.element = ((long) r26.H()) & 4294967295L;
        int r17 = r26.R() & UShort.MAX_VALUE;
        int r18 = r26.R() & UShort.MAX_VALUE;
        int r19 = r26.R() & UShort.MAX_VALUE;
        r26.skip(8);
        final Ref.LongRef r20 = new Ref.LongRef();
        r20.element = ((long) r26.H()) & 4294967295L;
        String r21 = r26.e(r17);
        if (StringsKt.contains$default(r21, 0, false, 2, null) == true) goto L28;
        if (r16.element != 4294967295L) goto L11;
        long r22 = ((long) 8) + 0;
    L13:
        if (r15.element != 4294967295L) goto L16;
        r22 = r22 + ((long) 8);
    L16:
        if (r20.element != 4294967295L) goto L18;
        r22 = r22 + ((long) 8);
    L18:
        final long r23 = r22;
        final Ref.BooleanRef r24 = new Ref.BooleanRef();
        g(r26, r18, new ZipFilesKt$readEntry$1(r24, r23, r16, r26, r15, r20));
        if (r23 <= 0) goto L26;
        if (r24.element == true) goto L26;
        throw new IOException("bad zip: zip64 extra required but absent");
    L26:
        return new f(y.a.e(y.f12274g, "/", false, 1, null).j(r21), StringsKt.endsWith$default(r21, "/", false, 2, null), r26.e(r19), r14, r15.element, r16.element, r12, r13, r20.element);
    L11:
        r22 = 0;
        goto L13
    L28:
        throw new IOException("bad zip: filename contains 0x00");
    L30:
        throw new IOException("unsupported zip: general purpose bit flag=" + c(r11));
    L32:
        throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(r10));
    }

    private static final e f(okio.f r10) {
        int r11 = r10.R() & UShort.MAX_VALUE;
        int r12 = r10.R() & UShort.MAX_VALUE;
        long r13 = r10.R() & UShort.MAX_VALUE;
        if (r13 != (r10.R() & UShort.MAX_VALUE)) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        r10.skip(4);
        return new e(r13, 4294967295L & ((long) r10.H()), r10.R() & UShort.MAX_VALUE);
    L9:
        throw new IOException("unsupported zip: spanned");
    }

    private static final void g(okio.f r10, int r11, Function2<? super Integer, ? super Long, Unit> r12) {
        long r13 = r11;
    L4:
        if (r13 == 0) goto L20;
        if (r13 < 4) goto L19;
        int r14 = r10.R() & UShort.MAX_VALUE;
        long r15 = ((long) r10.R()) & 65535;
        long r16 = r13 - ((long) 4);
        if (r16 < r15) goto L17;
        r10.U(r15);
        long r17 = r10.b().M();
        r12.invoke(Integer.valueOf(r14), Long.valueOf(r15));
        long r18 = (r10.b().M() + r15) - r17;
        if (r18 < 0) goto L15;
        if (r18 <= 0) goto L13;
        r10.b().skip(r18);
    L13:
        r13 = r16 - r15;
        goto L4
    L15:
        throw new IOException("unsupported zip: too many bytes processed for " + r14);
    L17:
        throw new IOException("bad zip: truncated value in extra field");
    L19:
        throw new IOException("bad zip: truncated header in extra field");
    }

    public static final h h(okio.f r10, h r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "basicMetadata");
        h r12 = i(r10, r11);
        Intrinsics.checkNotNull(r12);
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final h i(final okio.f r17, h r18) {
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        if (r18 == null) goto L5;
        T r11 = r18.a();
    L6:
        r10.element = r11;
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        int r14 = r17.H();
        if (r14 != 67324752) goto L19;
        r17.skip(2);
        int r15 = r17.R() & UShort.MAX_VALUE;
        if ((r15 & 1) != 0) goto L17;
        r17.skip(18);
        long r16 = ((long) r17.R()) & 65535;
        int r19 = r17.R() & UShort.MAX_VALUE;
        r17.skip(r16);
        if (r18 != null) goto L14;
        r17.skip(r19);
        return null;
    L14:
        g(r17, r19, new ZipFilesKt$readOrSkipLocalHeader$1(r17, r10, r12, r13));
        return new h(r18.e(), r18.d(), null, r18.b(), (Long) r13.element, (Long) r10.element, (Long) r12.element, null, 128, null);
    L17:
        throw new IOException("unsupported zip: general purpose bit flag=" + c(r15));
    L19:
        throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(r14));
    L5:
        r11 = 0;
        goto L6
    }

    private static final e j(okio.f r10, e r11) {
        r10.skip(12);
        int r12 = r10.H();
        int r13 = r10.H();
        long r14 = r10.T();
        if (r14 != r10.T()) goto L9;
        if (r12 != 0) goto L9;
        if (r13 != 0) goto L9;
        r10.skip(8);
        return new e(r14, r10.T(), r11.b());
    L9:
        throw new IOException("unsupported zip: spanned");
    }
}
