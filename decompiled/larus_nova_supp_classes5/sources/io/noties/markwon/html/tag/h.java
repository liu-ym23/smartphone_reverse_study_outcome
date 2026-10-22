package io.noties.markwon.html.tag;

import io.noties.markwon.core.CoreProps;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import lsc.t;
import lsc.x;
import lsc.y;
import org.commonmark.node.ListItem;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h extends a0 {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"ol", "ul"});
    }

    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tsc.a0
    public final void a(lsc.m r11, v r12, tsc.l r13) {
        if (r13.isBlock() == true) goto L5;
        return;
    L5:
        tsc.l.a r14 = r13.a();
        boolean r0 = "ol".equals(r14.name());
        boolean r2 = "ul".equals(r14.name());
        if (r0 == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        lsc.h r3 = r11.B();
        t r4 = r11.r();
        x r5 = ((lsc.l) r3.e).a(ListItem.class);
        int r6 = 0;
        tsc.m.a r7 = r14;
    L10:
        r7 = r7.parent();
        if (r7 == 0) goto L17;
        if ("ul".equals(r7.a) == true) goto L16;
        if ("ol".equals(r7.a) == false) goto L10;
    L16:
        r6 = r6 + 1;
        goto L10
    L17:
        Iterator<tsc.l.a> r15 = r14.children().iterator();
        int r1 = 1;
    L19:
        if (r15.hasNext() == false) goto L29;
        tsc.l.a r8 = r15.next();
        a0.d(r11, r12, r8);
        if (r5 == null) goto L19;
        if ("li".equals(r8.name()) == false) goto L19;
        CoreProps.e.c(r11.r(), Boolean.TRUE);
        if (r0 == false) goto L27;
        CoreProps.a.c(r4, CoreProps.ListItemType.ORDERED);
        int r9 = r1 + 1;
        CoreProps.d.c(r4, Integer.valueOf(r1));
        CoreProps.b.c(r4, Integer.valueOf(r6));
        r1 = r9;
    L28:
        y.f(r11.builder(), r5.a(r3, r4), r8.start(), r8.end());
        goto L19
    L27:
        CoreProps.a.c(r4, CoreProps.ListItemType.BULLET);
        CoreProps.b.c(r4, Integer.valueOf(r6));
        goto L28
    }
}
