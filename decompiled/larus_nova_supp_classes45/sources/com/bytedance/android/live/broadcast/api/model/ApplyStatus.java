package com.bytedance.android.live.broadcast.api.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final enum ApplyStatus extends Enum<ApplyStatus> {
    public static final ApplyStatus AlreadyHasPermission = null;
    public static final ApplyStatus CanApply = null;
    public static final ApplyStatus CanNotApply = null;
    public static final ApplyStatus Submitted = null;
    public static final ApplyStatus Unknow = null;
    public static final /* synthetic */ ApplyStatus[] a = null;
    public int code;

    static {
        ApplyStatus r0 = new ApplyStatus("Unknow", 0, 0);
        Unknow = r0;
        ApplyStatus r1 = new ApplyStatus("CanNotApply", 1, 1);
        CanNotApply = r1;
        ApplyStatus r3 = new ApplyStatus("CanApply", 2, 2);
        CanApply = r3;
        ApplyStatus r5 = new ApplyStatus("Submitted", 3, 3);
        Submitted = r5;
        ApplyStatus r7 = new ApplyStatus("AlreadyHasPermission", 4, 99);
        AlreadyHasPermission = r7;
        a = new ApplyStatus[]{r0, r1, r3, r5, r7};
    }

    public static ApplyStatus[] values() {
        return (ApplyStatus[]) a.clone();
    }

    public static ApplyStatus valueOf(String r1) {
        return (ApplyStatus) r27.a.a(ApplyStatus.class, r1);
    }

    public ApplyStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
