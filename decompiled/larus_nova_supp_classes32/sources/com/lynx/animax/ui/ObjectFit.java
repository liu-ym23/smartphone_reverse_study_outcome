package com.lynx.animax.ui;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ObjectFit extends Enum<ObjectFit> {
    public static final ObjectFit CENTER = null;
    public static final ObjectFit CONTAIN = null;
    public static final ObjectFit COVER = null;
    public static final ObjectFit FILL = null;
    public static final ObjectFit SCALE_DOWN = null;
    public static final /* synthetic */ ObjectFit[] a = null;

    static {
        ObjectFit r0 = new ObjectFit("CENTER", 0);
        CENTER = r0;
        ObjectFit r1 = new ObjectFit("COVER", 1);
        COVER = r1;
        ObjectFit r3 = new ObjectFit("CONTAIN", 2);
        CONTAIN = r3;
        ObjectFit r5 = new ObjectFit("FILL", 3);
        FILL = r5;
        ObjectFit r7 = new ObjectFit("SCALE_DOWN", 4);
        SCALE_DOWN = r7;
        a = new ObjectFit[]{r0, r1, r3, r5, r7};
    }

    public static ObjectFit[] values() {
        return (ObjectFit[]) a.clone();
    }

    public static ObjectFit valueOf(String r1) {
        return (ObjectFit) a.a(ObjectFit.class, r1);
    }

    public ObjectFit(String r1, int r2) {
        super(r1, r2);
    }
}
