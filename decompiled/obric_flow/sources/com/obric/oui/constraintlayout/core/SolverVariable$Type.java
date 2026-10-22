package com.obric.oui.constraintlayout.core;

/* JADX INFO: loaded from: classes3.dex */
public final enum SolverVariable$Type extends Enum<SolverVariable$Type> {
    public static final SolverVariable$Type CONSTANT = null;
    public static final SolverVariable$Type ERROR = null;
    public static final SolverVariable$Type SLACK = null;
    public static final SolverVariable$Type UNKNOWN = null;
    public static final SolverVariable$Type UNRESTRICTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SolverVariable$Type[] f12524a = null;

    static {
        SolverVariable$Type r5 = new SolverVariable$Type("UNRESTRICTED", 0);
        UNRESTRICTED = r5;
        SolverVariable$Type r10 = new SolverVariable$Type("CONSTANT", 1);
        CONSTANT = r10;
        SolverVariable$Type r11 = new SolverVariable$Type("SLACK", 2);
        SLACK = r11;
        SolverVariable$Type r12 = new SolverVariable$Type("ERROR", 3);
        ERROR = r12;
        SolverVariable$Type r13 = new SolverVariable$Type("UNKNOWN", 4);
        UNKNOWN = r13;
        f12524a = new SolverVariable$Type[]{r5, r10, r11, r12, r13};
    }

    public static SolverVariable$Type valueOf(String r5) {
        return (SolverVariable$Type) Enum.valueOf(SolverVariable$Type.class, r5);
    }

    public static SolverVariable$Type[] values() {
        return (SolverVariable$Type[]) f12524a.clone();
    }
}
