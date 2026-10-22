package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility$ActionType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y0 extends a {
    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131900868) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 2131907411) goto L8;
        return false;
    }

    public y0() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r6, View r7, ef8.b r8) {
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "menuContext");
        com.larus.bmhome.chat.api.q0.a r9 = r8.b;
        if (r9 != null) goto L6;
        return true;
    L6:
        if (r8.c != null) goto L9;
        return true;
    L9:
        if (x0.a(r8) == false) goto L11;
        return true;
    L11:
        IChatMessageShareAbility r10 = r9.J9();
        if (r10 == null) goto L14;
        r10.yt(IChatMessageShareAbility$ActionType.SHARE, r8.a, r8.c.getCurrentList(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EXT_KEY_CLICK_FROM", "long_press_answer")}));
    L14:
        return true;
    }
}
