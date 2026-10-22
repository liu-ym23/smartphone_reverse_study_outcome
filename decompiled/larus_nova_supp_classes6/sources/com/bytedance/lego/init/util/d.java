package com.bytedance.lego.init.util;

import com.bytedance.lego.init.config.ProcessMatchMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ProcessMatchMode.values().length];
        a = r0;
        r0[ProcessMatchMode.ENDWITH.ordinal()] = 1;
        r0[ProcessMatchMode.CONTAIN.ordinal()] = 2;
    }
}
