package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum KeyAttribute$Fit extends Enum<KeyAttribute$Fit> {
    public static final KeyAttribute$Fit LINEAR = null;
    public static final KeyAttribute$Fit SPLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyAttribute$Fit[] f12532a = null;

    static {
        KeyAttribute$Fit r5 = new KeyAttribute$Fit("SPLINE", 0);
        SPLINE = r5;
        KeyAttribute$Fit r10 = new KeyAttribute$Fit("LINEAR", 1);
        LINEAR = r10;
        f12532a = new KeyAttribute$Fit[]{r5, r10};
    }

    public static KeyAttribute$Fit valueOf(String r5) {
        return (KeyAttribute$Fit) Enum.valueOf(KeyAttribute$Fit.class, r5);
    }

    public static KeyAttribute$Fit[] values() {
        return (KeyAttribute$Fit[]) f12532a.clone();
    }
}
