package fh8;

import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.core.spans.LinkSpan;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Integer) ((Pair) r1).getFirst(), (Integer) ((Pair) r2).getFirst());
        }
    }

    public static final List<k> a(final lw8.l r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Lazy r0 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new m(r10));
        List r1 = c(r10.e(), CustomLinkSpan.class);
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L29;
        CustomLinkSpan r4 = (CustomLinkSpan) r3.next();
        int r5 = r10.e().getSpanStart(r4);
        int r6 = r10.e().getSpanEnd(r4);
        int r7 = 0;
        k r8 = null;
        if (r5 >= 0) goto L8;
    L15:
        Iterator r9 = ((List) r0.getValue()).iterator();
    L17:
        if (r9.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((lw8.k) r9.next()).a, ((LinkSpan) r4).b) == true) goto L23;
        r7 = r7 + 1;
    L23:
        if (r7 < 0) goto L25;
        lw8.k r11 = (lw8.k) ListProtector.remove((List) r0.getValue(), r7);
    L26:
        r8 = new k(r4, r11);
    L27:
        if (r8 == null) goto L4;
        r2.add(r8);
        goto L4
    L25:
        r11 = new lw8.k(((LinkSpan) r4).b, "", null, null);
        goto L26
    L22:
        r7 = -1;
        goto L23
    L8:
        if (r6 > r10.e().length()) goto L15;
        if (r5 >= r6) goto L15;
        CharSequence r12 = r10.e().subSequence(r5, r6);
        if (r12.length() <= 0) goto L13;
        r7 = 1;
    L13:
        if (r7 == 0) goto L27;
        r8 = new k(r4, new lw8.k(((LinkSpan) r4).b, r12.toString(), Integer.valueOf(r5), Integer.valueOf(r6)));
        goto L27
    L29:
        return r2;
    }

    public static final void b(StringBuilder r1, uvc.b r2) {
    L2:
        if (r2 == null) goto L17;
        if ((r2 instanceof Text) == false) goto L7;
        r1.append(((Text) r2).h);
    L16:
        r2 = r2.e;
        goto L2
    L7:
        if ((r2 instanceof Code) == false) goto L10;
        r1.append(((Code) r2).h);
        goto L16
    L10:
        if ((r2 instanceof SoftLineBreak) == false) goto L12;
    L15:
        r1.append('\n');
        goto L16
    L12:
        if ((r2 instanceof HardLineBreak) == true) goto L15;
        b(r1, r2.b);
        Unit r0 = Unit.INSTANCE;
        goto L16
    }

    public static final <T> List<T> c(Spanned r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "kind");
        Object[] r0 = r10.getSpans(0, r10.length(), r11);
        ArrayList r2 = new ArrayList(r0.length);
        int r3 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        Object r5 = r0[r4];
        r2.add(TuplesKt.to(Integer.valueOf(r10.getSpanStart(r5)), r5));
        r4 = r4 + 1;
        goto L3
    L5:
        List r1 = CollectionsKt.toMutableList(r2);
        Iterator<T> r6 = ArraysKt.sortedWith(r10.getSpans(0, r10.length(), TableRowSpan2.class), new q(r10)).iterator();
    L7:
        if (r6.hasNext() == false) goto L28;
        TableRowSpan2 r7 = (TableRowSpan2) r6.next();
        int r8 = r10.getSpanStart(r7);
        r7.getClass();
        ArrayList r9 = new ArrayList();
        List r12 = r7.o.b;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L20;
        CharSequence r15 = ((io.noties.markwon.ext.tables.g.a) r14.next()).e;
        Object[] r16 = null;
        if ((r15 instanceof Spanned) == true) goto L14;
        CharSequence r17 = null;
    L15:
        Spanned r18 = (Spanned) r17;
        if (r18 == null) goto L18;
        r16 = r18.getSpans(0, r15.length(), r11);
    L18:
        if (r16 == null) goto L10;
        r13.add(r16);
        goto L10
    L14:
        r17 = r15;
        goto L15
    L20:
        Iterator r19 = r13.iterator();
    L22:
        if (r19.hasNext() == false) goto L24;
        CollectionsKt.addAll(r9, (Object[]) r19.next());
        goto L22
    L24:
        Iterator r20 = r9.iterator();
    L26:
        if (r20.hasNext() == false) goto L7;
        r1.add(TuplesKt.to(Integer.valueOf(r8), r20.next()));
        goto L26
    L28:
        List r110 = CollectionsKt.sortedWith(r1, new a());
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L30:
        if (r112.hasNext() == false) goto L33;
        r111.add(((Pair) r112.next()).getSecond());
        goto L30
    L33:
        return CollectionsKt.distinct(r111);
    }
}
