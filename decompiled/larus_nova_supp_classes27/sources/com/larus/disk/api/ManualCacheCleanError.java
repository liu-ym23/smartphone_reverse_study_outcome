package com.larus.disk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/disk/api/ManualCacheCleanError;", "", "code", "", "reason", "stage", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getReason", "getStage", "NONE", "SERVICE_UNAVAILABLE", "FEATURE_DISABLED", "TASK_RUNNING", "ACCOUNT_CHANGED", "APP_FOREGROUND", "ROOT_CACHE_DELETE_FAILED", "CONFIGURED_PATH_DELETE_FAILED", "BUSINESS_HANDLER_FAILED", "MULTIPLE_COMPONENTS_FAILED", "REMAINING_CACHE", "SIZE_QUERY_FAILED", "EXECUTION_FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManualCacheCleanError extends Enum<ManualCacheCleanError> {
    public static final ManualCacheCleanError ACCOUNT_CHANGED = null;
    public static final ManualCacheCleanError APP_FOREGROUND = null;
    public static final ManualCacheCleanError BUSINESS_HANDLER_FAILED = null;
    public static final ManualCacheCleanError CONFIGURED_PATH_DELETE_FAILED = null;
    public static final ManualCacheCleanError EXECUTION_FAILED = null;
    public static final ManualCacheCleanError FEATURE_DISABLED = null;
    public static final ManualCacheCleanError MULTIPLE_COMPONENTS_FAILED = null;
    public static final ManualCacheCleanError NONE = null;
    public static final ManualCacheCleanError REMAINING_CACHE = null;
    public static final ManualCacheCleanError ROOT_CACHE_DELETE_FAILED = null;
    public static final ManualCacheCleanError SERVICE_UNAVAILABLE = null;
    public static final ManualCacheCleanError SIZE_QUERY_FAILED = null;
    public static final ManualCacheCleanError TASK_RUNNING = null;
    public static final /* synthetic */ ManualCacheCleanError[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String code;
    private final String reason;
    private final String stage;

    public static EnumEntries<ManualCacheCleanError> getEntries() {
        return b;
    }

    static {
        ManualCacheCleanError r6 = new ManualCacheCleanError("NONE", 0, "none", "none", "none");
        NONE = r6;
        ManualCacheCleanError r0 = new ManualCacheCleanError("SERVICE_UNAVAILABLE", 1, "service_unavailable", "disk clean service is unavailable", "precheck");
        SERVICE_UNAVAILABLE = r0;
        ManualCacheCleanError r1 = new ManualCacheCleanError("FEATURE_DISABLED", 2, "feature_disabled", "manual disk clean is disabled", "precheck");
        FEATURE_DISABLED = r1;
        ManualCacheCleanError r2 = new ManualCacheCleanError("TASK_RUNNING", 3, "task_running", "another disk clean task is running", "precheck");
        TASK_RUNNING = r2;
        ManualCacheCleanError r3 = new ManualCacheCleanError("ACCOUNT_CHANGED", 4, "account_changed", "account changed before disk clean finished", "precheck");
        ACCOUNT_CHANGED = r3;
        ManualCacheCleanError r4 = new ManualCacheCleanError("APP_FOREGROUND", 5, "app_foreground", "automatic disk clean stopped in foreground", "precheck");
        APP_FOREGROUND = r4;
        ManualCacheCleanError r5 = new ManualCacheCleanError("ROOT_CACHE_DELETE_FAILED", 6, "root_cache_delete_failed", "one or more root cache entries could not be deleted", "root_cache");
        ROOT_CACHE_DELETE_FAILED = r5;
        ManualCacheCleanError r13 = new ManualCacheCleanError("CONFIGURED_PATH_DELETE_FAILED", 7, "configured_path_delete_failed", "one or more configured cache paths could not be deleted", "configured_path");
        CONFIGURED_PATH_DELETE_FAILED = r13;
        ManualCacheCleanError r7 = new ManualCacheCleanError("BUSINESS_HANDLER_FAILED", 8, "business_handler_failed", "one or more business cache handlers did not finish cleanly", "business_handler");
        BUSINESS_HANDLER_FAILED = r7;
        ManualCacheCleanError r8 = new ManualCacheCleanError("MULTIPLE_COMPONENTS_FAILED", 9, "multiple_components_failed", "multiple cache cleaning components failed", "execution");
        MULTIPLE_COMPONENTS_FAILED = r8;
        ManualCacheCleanError r9 = new ManualCacheCleanError("REMAINING_CACHE", 10, "remaining_cleanable_cache", "cleanable cache remained after execution", "verification");
        REMAINING_CACHE = r9;
        ManualCacheCleanError r10 = new ManualCacheCleanError("SIZE_QUERY_FAILED", 11, "size_query_failed", "cleanable cache size query failed", "verification");
        SIZE_QUERY_FAILED = r10;
        ManualCacheCleanError r11 = new ManualCacheCleanError("EXECUTION_FAILED", 12, "execution_failed", "disk clean execution failed", "execution");
        EXECUTION_FAILED = r11;
        ManualCacheCleanError[] r12 = {r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static ManualCacheCleanError[] values() {
        return (ManualCacheCleanError[]) a.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getStage() {
        return this.stage;
    }

    public static ManualCacheCleanError valueOf(String r1) {
        return (ManualCacheCleanError) a.a(ManualCacheCleanError.class, r1);
    }

    public ManualCacheCleanError(String r1, int r2, String r3, String r4, String r5) {
        super(r1, r2);
        this.code = r3;
        this.reason = r4;
        this.stage = r5;
    }
}
