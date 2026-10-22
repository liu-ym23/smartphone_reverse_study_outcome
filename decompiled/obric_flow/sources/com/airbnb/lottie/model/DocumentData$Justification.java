package com.airbnb.lottie.model;

/* JADX INFO: loaded from: classes.dex */
public final enum DocumentData$Justification extends Enum<DocumentData$Justification> {
    public static final DocumentData$Justification CENTER = null;
    public static final DocumentData$Justification LEFT_ALIGN = null;
    public static final DocumentData$Justification RIGHT_ALIGN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocumentData$Justification[] f1283a = null;

    static {
        DocumentData$Justification r5 = new DocumentData$Justification("LEFT_ALIGN", 0);
        LEFT_ALIGN = r5;
        DocumentData$Justification r10 = new DocumentData$Justification("RIGHT_ALIGN", 1);
        RIGHT_ALIGN = r10;
        DocumentData$Justification r11 = new DocumentData$Justification("CENTER", 2);
        CENTER = r11;
        f1283a = new DocumentData$Justification[]{r5, r10, r11};
    }

    public static DocumentData$Justification valueOf(String r5) {
        return (DocumentData$Justification) Enum.valueOf(DocumentData$Justification.class, r5);
    }

    public static DocumentData$Justification[] values() {
        return (DocumentData$Justification[]) f1283a.clone();
    }
}
