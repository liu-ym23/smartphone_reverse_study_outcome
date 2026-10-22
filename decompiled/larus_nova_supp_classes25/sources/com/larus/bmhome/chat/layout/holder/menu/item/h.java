package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.larus.bmhome.chat.component.collection.o$a;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends com.larus.bmhome.chat.layout.holder.menu.item.a {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131900900) goto L5;
        return true;
    L5:
        return false;
    }

    public h() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r3, final View r4, final ef8.b r5) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "menuContext");
        com.larus.bmhome.chat.api.q0.a r6 = r5.b;
        if (r6 == null) goto L9;
        com.larus.bmhome.chat.component.collection.o r7 = r6.i2();
        if (r7 == null) goto L10;
        o$a.b(r7, "long_press_answer", null, CollectionsKt.listOf(r5.a), new g(r4, r5));
        return true;
    L10:
        return true;
    L9:
        return true;
    }
}
