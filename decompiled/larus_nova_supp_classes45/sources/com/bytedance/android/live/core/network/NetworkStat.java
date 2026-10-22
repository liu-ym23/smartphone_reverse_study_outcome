package com.bytedance.android.live.core.network;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class NetworkStat {
    public static final NetworkStat LOADED = null;
    public static final NetworkStat LOADING = null;
    public Status mStatus;
    public Throwable throwable;

    public static final enum Status extends Enum<Status> {
        public static final Status FAILED = null;
        public static final Status RUNNING = null;
        public static final Status SUCCESS = null;
        public static final /* synthetic */ Status[] a = null;
        public final int mStatus;

        static {
            Status r0 = new Status("RUNNING", 0, 0);
            RUNNING = r0;
            Status r1 = new Status("SUCCESS", 1, 1);
            SUCCESS = r1;
            Status r3 = new Status("FAILED", 2, -1);
            FAILED = r3;
            a = new Status[]{r0, r1, r3};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.mStatus = r3;
        }
    }

    static {
        LOADING = new NetworkStat(Status.RUNNING, null);
        LOADED = new NetworkStat(Status.SUCCESS, null);
    }

    public boolean isFailed() {
        if (this.mStatus != Status.FAILED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLoading() {
        if (this.mStatus != Status.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSuccess() {
        if (this.mStatus != Status.SUCCESS) goto L5;
        return true;
    L5:
        return false;
    }

    public static NetworkStat error(Throwable r2) {
        return new NetworkStat(Status.FAILED, r2);
    }

    private NetworkStat(Status r1, Throwable r2) {
        this.mStatus = r1;
        this.throwable = r2;
    }
}
