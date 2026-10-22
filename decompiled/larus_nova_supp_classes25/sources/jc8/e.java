package jc8;

import android.content.res.Resources;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.MetaInfoBlock;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final int b(int r2) {
        Resources r0 = Resources.getSystem();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static final d d(a r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        boolean r0 = r6.m();
        boolean r1 = r6.n();
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        d r2 = new d(b(16), b(12), b(16), b(14));
    L13:
        return a(r6, r2);
    L7:
        if (r0 == false) goto L9;
        r2 = new d(b(16), b(12), b(16), b(6));
        goto L13
    L9:
        if (r1 == false) goto L11;
        r2 = new d(b(16), b(6), b(16), b(14));
        goto L13
    L11:
        r2 = new d(b(16), b(6), b(16), b(6));
        goto L13
    }

    public static final d a(a r6, d r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "margin");
        f r0 = r6.d;
        int r1 = 0;
        if (r0 == null) goto L38;
        a r2 = r0.c;
        if (r2 == null) goto L38;
        BlockContent r3 = r2.a.getContent();
        MetaInfoBlock r4 = null;
        if (r3 == null) goto L10;
        MetaInfoBlock r5 = r3.getMetaInfoBlock();
    L11:
        boolean r8 = true;
        if (r5 == null) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == true) goto L39;
        String r10 = r6.a.getParentId();
        if (r10 == null) goto L38;
        if (r10.length() <= 0) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == true) goto L26;
        r10 = null;
    L26:
        if (r10 == null) goto L38;
        a r12 = c(r2, r10);
        if (r12 == null) goto L38;
        BlockContent r13 = r12.a.getContent();
        if (r13 == null) goto L33;
        r4 = r13.getMetaInfoBlock();
    L33:
        if (r4 == null) goto L35;
        boolean r14 = true;
    L36:
        if (r14 != true) goto L38;
    L35:
        r14 = false;
        goto L36
    L22:
        r11 = false;
    L39:
        if (r8 == true) goto L42;
        return r7;
    L42:
        if (r6.m() == true) goto L44;
    L46:
        int r15 = b(6);
    L47:
        int r16 = r7.a;
        if (r16 <= 0) goto L50;
        r16 = 0;
    L50:
        int r17 = r7.c;
        if (r17 > 0) goto L55;
        r1 = r17;
    L55:
        return d.a(r7, r16, r1, r15, 2);
    L44:
        if (r6.n() == false) goto L46;
        r15 = r7.d;
        goto L47
    L14:
        r9 = false;
        goto L15
    L10:
        r5 = null;
    L38:
        r8 = false;
        goto L39
    }

    public static final a c(a r2, String r3) {
        Iterator<T> r4 = r2.i().iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        a r0 = (a) r4.next();
        if (Intrinsics.areEqual(r0.h(), r3) == true) goto L7;
        a r1 = c(r0, r3);
        if (r1 == null) goto L4;
        return r1;
    L7:
        return r0;
    L11:
        return null;
    }
}
