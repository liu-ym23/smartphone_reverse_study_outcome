package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final enum PreserveAspectRatio$Alignment extends Enum<PreserveAspectRatio$Alignment> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreserveAspectRatio$Alignment f9729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PreserveAspectRatio$Alignment f9730b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PreserveAspectRatio$Alignment f9731c = null;
    public static final PreserveAspectRatio$Alignment d = null;
    public static final PreserveAspectRatio$Alignment e = null;
    public static final PreserveAspectRatio$Alignment f = null;
    public static final PreserveAspectRatio$Alignment g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PreserveAspectRatio$Alignment f9732h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final PreserveAspectRatio$Alignment f9733i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final PreserveAspectRatio$Alignment f9734j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ PreserveAspectRatio$Alignment[] f9735k = null;

    static {
        PreserveAspectRatio$Alignment r5 = new PreserveAspectRatio$Alignment("none", 0);
        f9729a = r5;
        PreserveAspectRatio$Alignment r10 = new PreserveAspectRatio$Alignment("xMinYMin", 1);
        f9730b = r10;
        PreserveAspectRatio$Alignment r11 = new PreserveAspectRatio$Alignment("xMidYMin", 2);
        f9731c = r11;
        PreserveAspectRatio$Alignment r12 = new PreserveAspectRatio$Alignment("xMaxYMin", 3);
        d = r12;
        PreserveAspectRatio$Alignment r13 = new PreserveAspectRatio$Alignment("xMinYMid", 4);
        e = r13;
        PreserveAspectRatio$Alignment r14 = new PreserveAspectRatio$Alignment("xMidYMid", 5);
        f = r14;
        PreserveAspectRatio$Alignment r15 = new PreserveAspectRatio$Alignment("xMaxYMid", 6);
        g = r15;
        PreserveAspectRatio$Alignment r16 = new PreserveAspectRatio$Alignment("xMinYMax", 7);
        f9732h = r16;
        PreserveAspectRatio$Alignment r17 = new PreserveAspectRatio$Alignment("xMidYMax", 8);
        f9733i = r17;
        PreserveAspectRatio$Alignment r18 = new PreserveAspectRatio$Alignment("xMaxYMax", 9);
        f9734j = r18;
        f9735k = new PreserveAspectRatio$Alignment[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public PreserveAspectRatio$Alignment(String r5, int r10) {
        super(r5, r10);
    }

    public static PreserveAspectRatio$Alignment valueOf(String r5) {
        return (PreserveAspectRatio$Alignment) Enum.valueOf(PreserveAspectRatio$Alignment.class, r5);
    }

    public static PreserveAspectRatio$Alignment[] values() {
        return (PreserveAspectRatio$Alignment[]) f9735k.clone();
    }
}
