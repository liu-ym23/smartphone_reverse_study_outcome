package com.lynx.animax.ui;

/* JADX INFO: loaded from: classes2.dex */
public final enum ObjectFit extends Enum<ObjectFit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObjectFit f9704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObjectFit f9705b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ObjectFit f9706c = null;
    public static final ObjectFit d = null;
    public static final ObjectFit e = null;
    public static final /* synthetic */ ObjectFit[] f = null;

    static {
        ObjectFit r5 = new ObjectFit("CENTER", 0);
        f9704a = r5;
        ObjectFit r10 = new ObjectFit("COVER", 1);
        f9705b = r10;
        ObjectFit r11 = new ObjectFit("CONTAIN", 2);
        f9706c = r11;
        ObjectFit r12 = new ObjectFit("FILL", 3);
        d = r12;
        ObjectFit r13 = new ObjectFit("SCALE_DOWN", 4);
        e = r13;
        f = new ObjectFit[]{r5, r10, r11, r12, r13};
    }

    public ObjectFit(String r5, int r10) {
        super(r5, r10);
    }

    public static ObjectFit valueOf(String r5) {
        return (ObjectFit) Enum.valueOf(ObjectFit.class, r5);
    }

    public static ObjectFit[] values() {
        return (ObjectFit[]) f.clone();
    }
}
