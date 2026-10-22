package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum KeyPositions$Type extends Enum<KeyPositions$Type> {
    public static final KeyPositions$Type CARTESIAN = null;
    public static final KeyPositions$Type PATH = null;
    public static final KeyPositions$Type SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyPositions$Type[] f12539a = null;

    static {
        KeyPositions$Type r5 = new KeyPositions$Type("CARTESIAN", 0);
        CARTESIAN = r5;
        KeyPositions$Type r10 = new KeyPositions$Type("SCREEN", 1);
        SCREEN = r10;
        KeyPositions$Type r11 = new KeyPositions$Type("PATH", 2);
        PATH = r11;
        f12539a = new KeyPositions$Type[]{r5, r10, r11};
    }

    public static KeyPositions$Type valueOf(String r5) {
        return (KeyPositions$Type) Enum.valueOf(KeyPositions$Type.class, r5);
    }

    public static KeyPositions$Type[] values() {
        return (KeyPositions$Type[]) f12539a.clone();
    }
}
