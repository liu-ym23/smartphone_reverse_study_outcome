package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x0 {
    public static final boolean a(ef8.b r1) {
        if (ic8.n.C(r1.c()) == false) goto L15;
        com.larus.bmhome.chat.api.q0 r2 = r1.c;
        Context r0 = null;
        if (r2 == null) goto L9;
        Function0<Fragment> r3 = r2.getHostFragment();
        if (r3 == null) goto L9;
        Fragment r4 = (Fragment) r3.invoke();
    L10:
        if (r4 == null) goto L12;
        r0 = r4.requireContext();
    L12:
        if (r0 == null) goto L14;
        t19.s.a.getClass();
        t19.s.s(r0, 2131900761);
    L14:
        return true;
    L9:
        r4 = null;
        goto L10
    L15:
        return false;
    }
}
