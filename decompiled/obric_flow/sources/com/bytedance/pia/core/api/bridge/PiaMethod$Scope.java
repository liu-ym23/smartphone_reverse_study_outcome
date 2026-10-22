package com.bytedance.pia.core.api.bridge;

/* JADX INFO: loaded from: classes2.dex */
public final enum PiaMethod$Scope extends Enum<PiaMethod$Scope> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PiaMethod$Scope f6952a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PiaMethod$Scope f6953b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PiaMethod$Scope f6954c = null;
    public static final /* synthetic */ PiaMethod$Scope[] d = null;

    static {
        PiaMethod$Scope r5 = new PiaMethod$Scope("Worker", 0);
        f6952a = r5;
        PiaMethod$Scope r10 = new PiaMethod$Scope("Render", 1);
        f6953b = r10;
        PiaMethod$Scope r11 = new PiaMethod$Scope("All", 2);
        f6954c = r11;
        d = new PiaMethod$Scope[]{r5, r10, r11};
    }

    public PiaMethod$Scope(String r5, int r10) {
        super(r5, r10);
    }

    public static PiaMethod$Scope valueOf(String r5) {
        return (PiaMethod$Scope) Enum.valueOf(PiaMethod$Scope.class, r5);
    }

    public static PiaMethod$Scope[] values() {
        return (PiaMethod$Scope[]) d.clone();
    }
}
