package com.lynx.clay.util;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {

    public static final class a {
        private a() {
        }

        public static boolean a(View r0) {
            return r0.isAttachedToWindow();
        }
    }

    public interface b {
        boolean a(View r1);
    }

    public static boolean a(View r0) {
        return a.a(r0);
    }

    public static boolean b(View r4, b r5) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r5.a(r4) == false) goto L9;
        return true;
    L9:
        if ((r4 instanceof ViewGroup) == false) goto L17;
        ViewGroup r6 = (ViewGroup) r4;
        int r1 = 0;
    L12:
        if (r1 >= r6.getChildCount()) goto L17;
        if (b(r6.getChildAt(r1), r5) == true) goto L15;
        r1 = r1 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }
}
