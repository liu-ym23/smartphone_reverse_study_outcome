package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public final enum KeyAttributes$Fit extends Enum<KeyAttributes$Fit> {
    public static final KeyAttributes$Fit LINEAR = null;
    public static final KeyAttributes$Fit SPLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyAttributes$Fit[] f12534a = null;

    static {
        KeyAttributes$Fit r5 = new KeyAttributes$Fit("SPLINE", 0);
        SPLINE = r5;
        KeyAttributes$Fit r10 = new KeyAttributes$Fit("LINEAR", 1);
        LINEAR = r10;
        f12534a = new KeyAttributes$Fit[]{r5, r10};
    }

    public static KeyAttributes$Fit valueOf(String r5) {
        return (KeyAttributes$Fit) Enum.valueOf(KeyAttributes$Fit.class, r5);
    }

    public static KeyAttributes$Fit[] values() {
        return (KeyAttributes$Fit[]) f12534a.clone();
    }
}
