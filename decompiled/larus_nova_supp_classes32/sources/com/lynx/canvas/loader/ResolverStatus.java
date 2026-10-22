package com.lynx.canvas.loader;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ResolverStatus extends Enum<ResolverStatus> {
    private static final /* synthetic */ ResolverStatus[] $VALUES = null;
    public static final ResolverStatus PENDING = null;
    public static final ResolverStatus REJECTED = null;
    public static final ResolverStatus RESOLVED = null;
    private final String status;

    static {
        ResolverStatus r0 = new ResolverStatus("PENDING", 0, "Pending");
        PENDING = r0;
        ResolverStatus r1 = new ResolverStatus("RESOLVED", 1, "Resolved");
        RESOLVED = r1;
        ResolverStatus r2 = new ResolverStatus("REJECTED", 2, "Rejected");
        REJECTED = r2;
        $VALUES = new ResolverStatus[]{r0, r1, r2};
    }

    public static ResolverStatus[] values() {
        return (ResolverStatus[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.status;
    }

    public static ResolverStatus valueOf(String r1) {
        return (ResolverStatus) a.a(ResolverStatus.class, r1);
    }

    private ResolverStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.status = r3;
    }
}
