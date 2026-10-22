package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum KeyPosition$Type extends Enum<KeyPosition$Type> {
    public static final KeyPosition$Type CARTESIAN = null;
    public static final KeyPosition$Type PATH = null;
    public static final KeyPosition$Type SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyPosition$Type[] f12538a = null;

    static {
        KeyPosition$Type r5 = new KeyPosition$Type("CARTESIAN", 0);
        CARTESIAN = r5;
        KeyPosition$Type r10 = new KeyPosition$Type("SCREEN", 1);
        SCREEN = r10;
        KeyPosition$Type r11 = new KeyPosition$Type("PATH", 2);
        PATH = r11;
        f12538a = new KeyPosition$Type[]{r5, r10, r11};
    }

    public static KeyPosition$Type valueOf(String r5) {
        return (KeyPosition$Type) Enum.valueOf(KeyPosition$Type.class, r5);
    }

    public static KeyPosition$Type[] values() {
        return (KeyPosition$Type[]) f12538a.clone();
    }
}
