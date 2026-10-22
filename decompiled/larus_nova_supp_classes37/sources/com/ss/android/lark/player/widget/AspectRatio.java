package com.ss.android.lark.player.widget;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum AspectRatio extends Enum<AspectRatio> implements Serializable {
    public static final AspectRatio AspectRatio_16_9 = null;
    public static final AspectRatio AspectRatio_4_3 = null;
    public static final AspectRatio AspectRatio_FILL_PARENT = null;
    public static final AspectRatio AspectRatio_FIT_PARENT = null;
    public static final AspectRatio AspectRatio_MATCH_PARENT = null;
    public static final AspectRatio AspectRatio_ORIGIN = null;
    public static final /* synthetic */ AspectRatio[] a = null;

    static {
        AspectRatio r0 = new AspectRatio("AspectRatio_16_9", 0);
        AspectRatio_16_9 = r0;
        AspectRatio r1 = new AspectRatio("AspectRatio_4_3", 1);
        AspectRatio_4_3 = r1;
        AspectRatio r3 = new AspectRatio("AspectRatio_MATCH_PARENT", 2);
        AspectRatio_MATCH_PARENT = r3;
        AspectRatio r5 = new AspectRatio("AspectRatio_FILL_PARENT", 3);
        AspectRatio_FILL_PARENT = r5;
        AspectRatio r7 = new AspectRatio("AspectRatio_FIT_PARENT", 4);
        AspectRatio_FIT_PARENT = r7;
        AspectRatio r9 = new AspectRatio("AspectRatio_ORIGIN", 5);
        AspectRatio_ORIGIN = r9;
        a = new AspectRatio[]{r0, r1, r3, r5, r7, r9};
    }

    public static AspectRatio[] values() {
        return (AspectRatio[]) a.clone();
    }

    public static AspectRatio valueOf(String r1) {
        return (AspectRatio) a.a(AspectRatio.class, r1);
    }

    public AspectRatio(String r1, int r2) {
        super(r1, r2);
    }
}
