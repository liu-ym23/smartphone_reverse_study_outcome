package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum KeyAttribute$Visibility extends Enum<KeyAttribute$Visibility> {
    public static final KeyAttribute$Visibility GONE = null;
    public static final KeyAttribute$Visibility INVISIBLE = null;
    public static final KeyAttribute$Visibility VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyAttribute$Visibility[] f12533a = null;

    static {
        KeyAttribute$Visibility r5 = new KeyAttribute$Visibility("VISIBLE", 0);
        VISIBLE = r5;
        KeyAttribute$Visibility r10 = new KeyAttribute$Visibility("INVISIBLE", 1);
        INVISIBLE = r10;
        KeyAttribute$Visibility r11 = new KeyAttribute$Visibility("GONE", 2);
        GONE = r11;
        f12533a = new KeyAttribute$Visibility[]{r5, r10, r11};
    }

    public static KeyAttribute$Visibility valueOf(String r5) {
        return (KeyAttribute$Visibility) Enum.valueOf(KeyAttribute$Visibility.class, r5);
    }

    public static KeyAttribute$Visibility[] values() {
        return (KeyAttribute$Visibility[]) f12533a.clone();
    }
}
