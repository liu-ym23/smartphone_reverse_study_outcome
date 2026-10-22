package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q extends com.larus.bmhome.chat.layout.holder.menu.item.a {
    public final Function0<Unit> b;

    public q(Function0<Unit> r1) {
        this.b = r1;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.COPY_CODE.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r2, View r3, ef8.b r4) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "menuContext");
        Function0<Unit> r5 = this.b;
        if (r5 == null) goto L7;
        r5.invoke();
        return true;
    L7:
        return true;
    }
}
