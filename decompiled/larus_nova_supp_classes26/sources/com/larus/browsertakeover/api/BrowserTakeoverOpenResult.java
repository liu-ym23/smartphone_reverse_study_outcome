package com.larus.browsertakeover.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/browsertakeover/api/BrowserTakeoverOpenResult;", "", "<init>", "(Ljava/lang/String;I)V", "OPENED", "REUSED", "ACTIVITY_UNAVAILABLE", "EXPERIMENT_DISABLED", "TARGET_DISABLED", "INVALID_REQUEST", "SESSION_BUSY", "PAGE_OPEN_FAILED", "SERVICE_UNAVAILABLE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BrowserTakeoverOpenResult extends Enum<BrowserTakeoverOpenResult> {
    public static final BrowserTakeoverOpenResult ACTIVITY_UNAVAILABLE = null;
    public static final BrowserTakeoverOpenResult EXPERIMENT_DISABLED = null;
    public static final BrowserTakeoverOpenResult INVALID_REQUEST = null;
    public static final BrowserTakeoverOpenResult OPENED = null;
    public static final BrowserTakeoverOpenResult PAGE_OPEN_FAILED = null;
    public static final BrowserTakeoverOpenResult REUSED = null;
    public static final BrowserTakeoverOpenResult SERVICE_UNAVAILABLE = null;
    public static final BrowserTakeoverOpenResult SESSION_BUSY = null;
    public static final BrowserTakeoverOpenResult TARGET_DISABLED = null;
    public static final /* synthetic */ BrowserTakeoverOpenResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BrowserTakeoverOpenResult> getEntries() {
        return b;
    }

    static {
        BrowserTakeoverOpenResult r0 = new BrowserTakeoverOpenResult("OPENED", 0);
        OPENED = r0;
        BrowserTakeoverOpenResult r1 = new BrowserTakeoverOpenResult("REUSED", 1);
        REUSED = r1;
        BrowserTakeoverOpenResult r3 = new BrowserTakeoverOpenResult("ACTIVITY_UNAVAILABLE", 2);
        ACTIVITY_UNAVAILABLE = r3;
        BrowserTakeoverOpenResult r5 = new BrowserTakeoverOpenResult("EXPERIMENT_DISABLED", 3);
        EXPERIMENT_DISABLED = r5;
        BrowserTakeoverOpenResult r7 = new BrowserTakeoverOpenResult("TARGET_DISABLED", 4);
        TARGET_DISABLED = r7;
        BrowserTakeoverOpenResult r9 = new BrowserTakeoverOpenResult("INVALID_REQUEST", 5);
        INVALID_REQUEST = r9;
        BrowserTakeoverOpenResult r11 = new BrowserTakeoverOpenResult("SESSION_BUSY", 6);
        SESSION_BUSY = r11;
        BrowserTakeoverOpenResult r13 = new BrowserTakeoverOpenResult("PAGE_OPEN_FAILED", 7);
        PAGE_OPEN_FAILED = r13;
        BrowserTakeoverOpenResult r15 = new BrowserTakeoverOpenResult("SERVICE_UNAVAILABLE", 8);
        SERVICE_UNAVAILABLE = r15;
        BrowserTakeoverOpenResult[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static BrowserTakeoverOpenResult[] values() {
        return (BrowserTakeoverOpenResult[]) a.clone();
    }

    public static BrowserTakeoverOpenResult valueOf(String r1) {
        return (BrowserTakeoverOpenResult) a.a(BrowserTakeoverOpenResult.class, r1);
    }

    public BrowserTakeoverOpenResult(String r1, int r2) {
        super(r1, r2);
    }
}
