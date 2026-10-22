package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.larus.platform.api.s3;
import com.larus.platform.service.i3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 extends a {
    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131907404) goto L5;
        return true;
    L5:
        return false;
    }

    public a0() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r4, View r5, ef8.b r6) {
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "menuContext");
        if (i3.a.a() == false) goto L6;
        s3.a.b();
        return true;
    L6:
        com.larus.bmhome.chat.api.q0 r7 = r6.c;
        if (r7 != null) goto L10;
        a.d("ModifyMenuHandler", "adapter");
        return true;
    L10:
        r7.K7().invoke(r7, r6.a, 1, Boolean.TRUE);
        return true;
    }
}
