package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum KeyCycle$Wave extends Enum<KeyCycle$Wave> {
    public static final KeyCycle$Wave COS = null;
    public static final KeyCycle$Wave REVERSE_SAW = null;
    public static final KeyCycle$Wave SAW = null;
    public static final KeyCycle$Wave SIN = null;
    public static final KeyCycle$Wave SQUARE = null;
    public static final KeyCycle$Wave TRIANGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyCycle$Wave[] f12536a = null;

    static {
        KeyCycle$Wave r5 = new KeyCycle$Wave("SIN", 0);
        SIN = r5;
        KeyCycle$Wave r10 = new KeyCycle$Wave("SQUARE", 1);
        SQUARE = r10;
        KeyCycle$Wave r11 = new KeyCycle$Wave("TRIANGLE", 2);
        TRIANGLE = r11;
        KeyCycle$Wave r12 = new KeyCycle$Wave("SAW", 3);
        SAW = r12;
        KeyCycle$Wave r13 = new KeyCycle$Wave("REVERSE_SAW", 4);
        REVERSE_SAW = r13;
        KeyCycle$Wave r14 = new KeyCycle$Wave("COS", 5);
        COS = r14;
        f12536a = new KeyCycle$Wave[]{r5, r10, r11, r12, r13, r14};
    }

    public static KeyCycle$Wave valueOf(String r5) {
        return (KeyCycle$Wave) Enum.valueOf(KeyCycle$Wave.class, r5);
    }

    public static KeyCycle$Wave[] values() {
        return (KeyCycle$Wave[]) f12536a.clone();
    }
}
