package nsc;

import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.core.spans.r;
import lsc.t;
import lsc.u;
import lsc.x;
import msc.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class k implements x {
    public k() {
    }

    @Override // lsc.x
    public Object a(lsc.h r8, t r9) {
        int r5 = b(r8, r9, null);
        boolean r6 = ((Boolean) CoreProps.e.b(r9)).booleanValue();
        if (CoreProps.ListItemType.BULLET != CoreProps.a.b(r9)) goto L11;
        s r10 = r8.a;
        t r11 = (u) r9;
        int r1 = ((Integer) r11.b(CoreProps.c, -1)).intValue();
        if (r1 == 0) goto L8;
        if (r1 == (-1)) goto L8;
    L12:
        return new io.noties.markwon.core.spans.d(r10, r1, r5, r6);
    L8:
        r1 = ((Integer) CoreProps.b.b(r11)).intValue();
        goto L12
    L11:
        return new r(r8.a, null, CoreProps.d.b(r9) + ". ", r5, r6);
    }

    public static int b(lsc.h r4, t r5, ListMarginInfo r6) {
        u r7 = (u) r5;     // Catch: Exception -> L14
        int r0 = ((Integer) r7.b(CoreProps.b, -1)).intValue();     // Catch: Exception -> L14
        int r8 = ((Integer) r7.b(CoreProps.c, -1)).intValue();     // Catch: Exception -> L14
        if (r0 == (-1)) goto L12;
        if (r8 == (-1)) goto L12;
        if (r6 == null) goto L8;
        int r9 = r6.getListMargin();     // Catch: Exception -> L14
    L9:
        if (r0 != 0) goto L12;
        if (r8 == 0) goto L12;
        return r8 * r9;
    L8:
        r9 = r4.a.c;     // Catch: Exception -> L14
    L12:
        return 0;
    }
}
