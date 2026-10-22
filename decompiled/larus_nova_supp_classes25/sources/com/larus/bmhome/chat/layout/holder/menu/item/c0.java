package com.larus.bmhome.chat.layout.holder.menu.item;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 {
    public static com.larus.bmhome.view.screenmenu.l0 a(List r55) {
        Intrinsics.checkNotNullParameter(r55, "foldItems");
        MenuActionType r0 = MenuActionType.MORE;
        int r1 = r0.getType();
        int r13 = v19.c.b(2130971822, null, 2131241955);
        int r8 = v19.c.b(2130971996, null, 2131242789);
        int r15 = r0.getType();
        int r2 = v19.c.b(2130971822, null, 2131241955);
        ListProtector.add(r55, 0, new com.larus.bmhome.view.screenmenu.l0(r15, 2131909371, null, null, null, null, null, Integer.valueOf(v19.c.b(2130971809, null, 2131241915)), null, false, false, null, Integer.valueOf(r2), null, false, false, null, null, "more", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528516, 127));
        com.larus.bmhome.view.screenmenu.l0 r3 = l.a();
        if (r3 == null) goto L6;
        r55.add(r3);
    L6:
        return new com.larus.bmhome.view.screenmenu.l0(r1, 2131909371, null, null, null, null, null, Integer.valueOf(r8), null, false, false, r55, Integer.valueOf(r13), null, false, false, null, null, "more", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -530564, 127);
    }
}
