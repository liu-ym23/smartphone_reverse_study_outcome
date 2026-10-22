package io.noties.markwon.core;

import java.util.HashMap;
import lsc.m;
import lsc.m$c;
import lsc.q;
import lsc.t;
import org.commonmark.node.Block;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements m$c<ListItem> {
    public a() {
    }

    @Override // lsc.m$c
    public final void a(m r8, b r9) {
        ListItem r10 = (ListItem) r9;
        int r0 = r8.length();
        r8.c(r10);
        Block r1 = (Block) r10.a;
        int r3 = 0;
        if (((HashMap) r10.g).get("start_self") != null) goto L5;
        boolean r2 = true;
    L6:
        CoreProps.e.c(r8.r(), Boolean.valueOf(r2));
        if ((r1 instanceof OrderedList) == false) goto L9;
        OrderedList r4 = (OrderedList) r1;
        int r5 = r4.i;
        CoreProps.a.c(r8.r(), CoreProps.ListItemType.ORDERED);
        CoreProps.d.c(r8.r(), Integer.valueOf(r5));
        r4.i++;
    L16:
        r8.G(r10, r0);
        if (r8.s(r10) == false) goto L23;
        r8.a();
        return;
    L23:
        return;
    L9:
        CoreProps.a.c(r8.r(), CoreProps.ListItemType.BULLET);
        q r6 = CoreProps.b;
        t r7 = r8.r();
        b r11 = r10.c();
    L10:
        if (r11 == null) goto L15;
        if ((r11 instanceof ListItem) == false) goto L14;
        r3 = r3 + 1;
    L14:
        r11 = r11.c();
        goto L10
    L15:
        r6.c(r7, Integer.valueOf(r3));
        goto L16
    L5:
        r2 = false;
        goto L6
    }
}
