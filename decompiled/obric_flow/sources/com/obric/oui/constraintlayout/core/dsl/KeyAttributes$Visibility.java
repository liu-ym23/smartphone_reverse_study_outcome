package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum KeyAttributes$Visibility extends Enum<KeyAttributes$Visibility> {
    public static final KeyAttributes$Visibility GONE = null;
    public static final KeyAttributes$Visibility INVISIBLE = null;
    public static final KeyAttributes$Visibility VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyAttributes$Visibility[] f12535a = null;

    static {
        KeyAttributes$Visibility r5 = new KeyAttributes$Visibility("VISIBLE", 0);
        VISIBLE = r5;
        KeyAttributes$Visibility r10 = new KeyAttributes$Visibility("INVISIBLE", 1);
        INVISIBLE = r10;
        KeyAttributes$Visibility r11 = new KeyAttributes$Visibility("GONE", 2);
        GONE = r11;
        f12535a = new KeyAttributes$Visibility[]{r5, r10, r11};
    }

    public static KeyAttributes$Visibility valueOf(String r5) {
        return (KeyAttributes$Visibility) Enum.valueOf(KeyAttributes$Visibility.class, r5);
    }

    public static KeyAttributes$Visibility[] values() {
        return (KeyAttributes$Visibility[]) f12535a.clone();
    }
}
