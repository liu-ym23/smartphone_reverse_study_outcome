package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxSSRHelper {
    public SSRHydrateStatus a;

    public static final enum SSRHydrateStatus extends Enum<SSRHydrateStatus> {
        public static final SSRHydrateStatus EXECUTING = null;
        public static final SSRHydrateStatus FAILED = null;
        public static final SSRHydrateStatus PENDING = null;
        public static final SSRHydrateStatus STARTED = null;
        public static final SSRHydrateStatus SUCCESSFUL = null;
        public static final SSRHydrateStatus UNDEFINED = null;
        public static final /* synthetic */ SSRHydrateStatus[] a = null;

        static {
            SSRHydrateStatus r0 = new SSRHydrateStatus("UNDEFINED", 0);
            UNDEFINED = r0;
            SSRHydrateStatus r1 = new SSRHydrateStatus("PENDING", 1);
            PENDING = r1;
            SSRHydrateStatus r3 = new SSRHydrateStatus("STARTED", 2);
            STARTED = r3;
            SSRHydrateStatus r5 = new SSRHydrateStatus("EXECUTING", 3);
            EXECUTING = r5;
            SSRHydrateStatus r7 = new SSRHydrateStatus("FAILED", 4);
            FAILED = r7;
            SSRHydrateStatus r9 = new SSRHydrateStatus("SUCCESSFUL", 5);
            SUCCESSFUL = r9;
            a = new SSRHydrateStatus[]{r0, r1, r3, r5, r7, r9};
        }

        public static SSRHydrateStatus[] values() {
            return (SSRHydrateStatus[]) a.clone();
        }

        public static SSRHydrateStatus valueOf(String r1) {
            return (SSRHydrateStatus) r27.a.a(SSRHydrateStatus.class, r1);
        }

        public SSRHydrateStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public LynxSSRHelper() {
        this.a = SSRHydrateStatus.UNDEFINED;
    }
}
