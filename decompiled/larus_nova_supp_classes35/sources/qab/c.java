package qab;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static int a(Context r0, int r1) {
        return r0.getResources().getColor(r1);
    }

    public static String b(Context r3, int r4, int r5) {
        return r3.getResources().getQuantityString(r4, r5, new Object[]{Integer.valueOf(r5)});
    }
}
