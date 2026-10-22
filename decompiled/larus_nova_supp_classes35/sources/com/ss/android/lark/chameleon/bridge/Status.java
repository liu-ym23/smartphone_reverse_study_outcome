package com.ss.android.lark.chameleon.bridge;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/Status;", BuildConfig.FLAVOR, "status", BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "SUCCESS", "FAILURE", "CANCEL", "TIMEOUT", "PROGRESS", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status CANCEL = null;
    public static final Status FAILURE = null;
    public static final Status PROGRESS = null;
    public static final Status SUCCESS = null;
    public static final Status TIMEOUT = null;
    private final String status;

    private static final /* synthetic */ Status[] $values() {
        return new Status[]{SUCCESS, FAILURE, CANCEL, TIMEOUT, PROGRESS};
    }

    public static Status valueOf(String r1) {
        return (Status) r27.a.a(Status.class, r1);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    static {
        SUCCESS = new Status("SUCCESS", 0, ChameleonOpenTracker.OpenResult.SUCCESS);
        FAILURE = new Status("FAILURE", 1, "failure");
        CANCEL = new Status("CANCEL", 2, ChameleonOpenTracker.OpenResult.CANCEL);
        TIMEOUT = new Status("TIMEOUT", 3, ChameleonOpenTracker.OpenResult.TIMEOUT);
        PROGRESS = new Status("PROGRESS", 4, "progress");
        $VALUES = $values();
    }

    public final String getStatus() {
        return this.status;
    }

    private Status(String r1, int r2, String r3) {
        super(r1, r2);
        this.status = r3;
    }
}
