package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum KeyCycles$Wave extends Enum<KeyCycles$Wave> {
    public static final KeyCycles$Wave COS = null;
    public static final KeyCycles$Wave REVERSE_SAW = null;
    public static final KeyCycles$Wave SAW = null;
    public static final KeyCycles$Wave SIN = null;
    public static final KeyCycles$Wave SQUARE = null;
    public static final KeyCycles$Wave TRIANGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyCycles$Wave[] f12537a = null;

    static {
        KeyCycles$Wave r5 = new KeyCycles$Wave("SIN", 0);
        SIN = r5;
        KeyCycles$Wave r10 = new KeyCycles$Wave("SQUARE", 1);
        SQUARE = r10;
        KeyCycles$Wave r11 = new KeyCycles$Wave("TRIANGLE", 2);
        TRIANGLE = r11;
        KeyCycles$Wave r12 = new KeyCycles$Wave("SAW", 3);
        SAW = r12;
        KeyCycles$Wave r13 = new KeyCycles$Wave("REVERSE_SAW", 4);
        REVERSE_SAW = r13;
        KeyCycles$Wave r14 = new KeyCycles$Wave("COS", 5);
        COS = r14;
        f12537a = new KeyCycles$Wave[]{r5, r10, r11, r12, r13, r14};
    }

    public static KeyCycles$Wave valueOf(String r5) {
        return (KeyCycles$Wave) Enum.valueOf(KeyCycles$Wave.class, r5);
    }

    public static KeyCycles$Wave[] values() {
        return (KeyCycles$Wave[]) f12537a.clone();
    }
}
