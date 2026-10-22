package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends com.larus.bmhome.chat.layout.holder.menu.item.a {
    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131899580) goto L5;
        return true;
    L5:
        return false;
    }

    public a() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r3, View r4, ef8.b r5) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "menuContext");
        int r6 = r.a;
        com.larus.bmhome.chat.api.q0 r7 = r5.c;
        if (r7 == null) goto L7;
        Function0<Fragment> r8 = r7.getHostFragment();
        if (r8 == null) goto L7;
        Fragment r9 = (Fragment) r8.invoke();
    L9:
        return r.a(r9, r5.a, r5.b, "long_press_meeting_record_create_button", "mobile");
    L7:
        r9 = null;
        goto L9
    }
}
