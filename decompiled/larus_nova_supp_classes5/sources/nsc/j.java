package nsc;

import com.larus.business.markdown.api.model.ListStyle;
import com.larus.business.markdown.api.model.OrderedSymbol;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.core.spans.q;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import lsc.t;
import lsc.u;
import org.commonmark.node.BlockQuote;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j extends k {
    public static final String[] c = null;
    public static final String[] d = null;
    public static final String[] e = null;
    public static final String[] f = null;
    public final ListMarginInfo a;
    public final ListStyle b;

    public static final class a {
    }

    public j() {
        this(null, null);
    }

    static {
        c = new String[]{"", "M", "MM", "MMM"};
        d = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        e = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        f = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    }

    private static int c(t r3) {
        t r4 = (u) r3;
        int r0 = ((Number) r4.b(CoreProps.c, -1)).intValue();
        if (r0 == 0) goto L7;
        if (r0 == (-1)) goto L7;
        return r0;
    L7:
        return ((Number) CoreProps.b.b(r4)).intValue();
    }

    public j(ListMarginInfo r1, ListStyle r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // nsc.k, lsc.x
    public final Object a(lsc.h r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        Intrinsics.checkNotNullParameter(r3, "props");
        return d(r2, r3, null, null);
    }

    public final Object d(lsc.h r12, t r13, lw8.a r14, uvc.b r15) {
        Intrinsics.checkNotNullParameter(r12, "configuration");
        Intrinsics.checkNotNullParameter(r13, "props");
        ListStyle r0 = this.b;
        int r2 = 0;
        if (r0 != null) goto L5;
        r0 = new ListStyle(null, false, 3, null);
    L5:
        int r8 = k.b(r12, r13, this.a);
        boolean r9 = ((Boolean) CoreProps.e.b(r13)).booleanValue();
        boolean r10 = true;
        if (CoreProps.ListItemType.BULLET != CoreProps.a.b(r13)) goto L25;
        io.noties.markwon.core.spans.c r1 = new io.noties.markwon.core.spans.c(r12.a, this.a, c(r13), r8, r9);
        r1.j = r0.getSymbolStrategy();
        if (r15 != null) goto L11;
    L9:
        r10 = false;
    L19:
        if (r10 == false) goto L61;
        if (r14 == null) goto L24;
        Integer r16 = r14.h;
        if (r16 == null) goto L24;
        r2 = r16.intValue();
    L24:
        r1.i = r2;
    L61:
        return r1;
    L11:
        if ((r15 instanceof BlockQuote) == true) goto L19;
        uvc.b r17 = r15.a;
    L14:
        if (r17 == null) goto L9;
        if ((r17 instanceof BlockQuote) == true) goto L19;
        r17 = r17.a;
        goto L14
    L25:
        lw8.j r3 = r0.getSymbolStrategy();
        c(r13);
        OrderedSymbol r4 = r3.a();
        int r18 = ((Number) CoreProps.d.b(r13)).intValue();
        int r5 = b.a[r4.ordinal()];
        if (r5 != 1) goto L28;
        Object r19 = Integer.valueOf(r18);
    L43:
        r1 = new q(r12.a, this.a, r19 + ". ", r8, r9);
        if (r15 != null) goto L47;
    L45:
        r10 = false;
    L55:
        if (r10 == false) goto L61;
        if (r14 == null) goto L60;
        Integer r110 = r14.g;
        if (r110 == null) goto L60;
        r2 = r110.intValue();
    L60:
        ((q) r1).j = r2;
        goto L61
    L47:
        if ((r15 instanceof BlockQuote) == true) goto L55;
        uvc.b r111 = r15.a;
    L50:
        if (r111 == null) goto L45;
        if ((r111 instanceof BlockQuote) == true) goto L55;
        r111 = r111.a;
        goto L50
    L28:
        if (r5 == 2) goto L38;
        if (r5 == 3) goto L31;
        r19 = Integer.valueOf(r18);
        goto L43
    L31:
        if (r18 != 0) goto L33;
        r19 = "";
        goto L43
    L33:
        String r112 = c[r18 / 1000] + d[(r18 % 1000) / 100] + e[(r18 % 100) / 10] + f[r18 % 10];
        Locale r6 = Locale.getDefault();
        if (r112 == null) goto L37;
        r19 = r112.toLowerCase(r6);
        goto L43
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L38:
        StringBuilder r7 = new StringBuilder();
        int r113 = Math.max(1, r18);
    L39:
        if (r113 <= 0) goto L41;
        int r114 = r113 - 1;
        r7.insert(0, String.valueOf((char) (((r114 % 26) + 1) + 96)));
        r113 = r114 / 26;
        goto L39
    L41:
        r19 = r7.toString();
        goto L43
    }
}
