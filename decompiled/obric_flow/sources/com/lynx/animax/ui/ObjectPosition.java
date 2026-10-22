package com.lynx.animax.ui;

/* JADX INFO: loaded from: classes2.dex */
public final enum ObjectPosition extends Enum<ObjectPosition> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObjectPosition f9707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObjectPosition f9708b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ObjectPosition f9709c = null;
    public static final ObjectPosition d = null;
    public static final ObjectPosition e = null;
    public static final /* synthetic */ ObjectPosition[] f = null;

    static {
        ObjectPosition r5 = new ObjectPosition("CENTER", 0);
        f9707a = r5;
        ObjectPosition r10 = new ObjectPosition("LEFT", 1);
        f9708b = r10;
        ObjectPosition r11 = new ObjectPosition("RIGHT", 2);
        f9709c = r11;
        ObjectPosition r12 = new ObjectPosition("TOP", 3);
        d = r12;
        ObjectPosition r13 = new ObjectPosition("BOTTOM", 4);
        e = r13;
        f = new ObjectPosition[]{r5, r10, r11, r12, r13};
    }

    public ObjectPosition(String r5, int r10) {
        super(r5, r10);
    }

    public static ObjectPosition valueOf(String r5) {
        return (ObjectPosition) Enum.valueOf(ObjectPosition.class, r5);
    }

    public static ObjectPosition[] values() {
        return (ObjectPosition[]) f.clone();
    }
}
