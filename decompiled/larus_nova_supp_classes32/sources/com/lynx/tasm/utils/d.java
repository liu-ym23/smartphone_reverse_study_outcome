package com.lynx.tasm.utils;

import android.text.StaticLayout;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static final Field a = null;
    public static final Field b = null;

    static {
        Field r0 = StaticLayout.class.getDeclaredField("mLines");     // Catch: Exception -> L4
        a = r0;     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        Field r1 = StaticLayout.class.getDeclaredField("mColumns");     // Catch: Exception -> L4
        b = r1;     // Catch: Exception -> L4
        r1.setAccessible(true);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
