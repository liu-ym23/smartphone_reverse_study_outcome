package com.larus.bmhome.chat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c4 {
    public static final boolean a(Fragment r5) {
        if (r5 == null) goto L16;
        t1a.b r3 = a.g(r5);
        if (r3 == null) goto L16;
        de8.c r4 = (de8.c) r3.a(de8.c.class);
        if (r4 == null) goto L16;
        Bundle r6 = r4.b;
        if (r6 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 != true) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == true) goto L27;
        if (r5 == null) goto L20;
        Bundle r9 = r5.getArguments();
    L21:
        if (r9 != null) goto L23;
    L25:
        boolean r10 = false;
    L26:
        if (r10 == true) goto L27;
        return false;
    L23:
        if (r9.getBoolean("human_merge_forward_float_chat") != true) goto L25;
        r10 = true;
        goto L26
    L20:
        r9 = null;
    L27:
        return true;
    L11:
        if (r6.getBoolean("human_merge_forward_float_chat") != true) goto L13;
        r7 = true;
    L16:
        r8 = false;
        goto L17
    }
}
