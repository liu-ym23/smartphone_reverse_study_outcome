package com.obric.memorydata.memory.ui.migration;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0017\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataMigrationImportTracker;", "", "startTimeMillis", "", "exportScopeProvider", "Lkotlin/Function0;", "", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "consumed", "", "finishSuccess", "", "finishFailure", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/memorydata/memory/ui/migration/DataMigrationImportTracker$FailReason;", "report", "status", "", "failReason", "mapDataType", "exportScope", "(Ljava/lang/Integer;)Ljava/lang/String;", "FailReason", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataMigrationImportTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11350b;
    private final Function0<Integer> c;
    private boolean d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataMigrationImportTracker$FailReason;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VERSION_TOO_LOW", "TRANSFER_ERROR", "OTHER", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum FailReason extends Enum<FailReason> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ FailReason[] $VALUES = null;
        public static final FailReason OTHER = null;
        public static final FailReason TRANSFER_ERROR = null;
        public static final FailReason VERSION_TOO_LOW = null;
        private final String value;

        private static final /* synthetic */ FailReason[] $values() {
            return new FailReason[]{VERSION_TOO_LOW, TRANSFER_ERROR, OTHER};
        }

        static {
            VERSION_TOO_LOW = new FailReason("VERSION_TOO_LOW", 0, "version_too_low");
            TRANSFER_ERROR = new FailReason("TRANSFER_ERROR", 1, "transfer_error");
            OTHER = new FailReason("OTHER", 2, "other");
            FailReason[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private FailReason(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<FailReason> getEntries() {
            return $ENTRIES;
        }

        public static FailReason valueOf(String r2) {
            return (FailReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(FailReason.class, r2), FailReason.class, "com.obric.memorydata.plugin");
        }

        public static FailReason[] values() {
            return (FailReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FailReason[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataMigrationImportTracker$Companion;", "", "<init>", "()V", "TAG", "", "EVENT_NAME", "KEY_DATA_TYPE", "KEY_DURATION", "KEY_STATUS", "KEY_FAIL_REASON", "STATUS_SUCCESS", "STATUS_FAIL", "DATA_TYPE_TASK_ONLY", "DATA_TYPE_MEMORY_ONLY", "DATA_TYPE_TASK_AND_MEMORY", "EXPORT_SCOPE_MEMORY_ONLY", "", "EXPORT_SCOPE_TASK_ONLY", "EXPORT_SCOPE_TASK_AND_MEMORY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11349a = new a(null);
    }

    public DataMigrationImportTracker(long r3, Function0<Integer> r5) {
        Function0<Integer> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "exportScopeProvider");
        this.f11350b = r3;
        this.c = r6;
    }

    public /* synthetic */ DataMigrationImportTracker(long r2, Function0 r4, int r5, DefaultConstructorMarker r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L5;
        r2 = System.currentTimeMillis();
    L5:
        this(r2, r7);
    }

    private final String a(Integer r3) {
        if (r3 == null) goto L9;
        if (r3.intValue() != 1) goto L9;
        return "memory_only";
    L9:
        if (r3 == null) goto L15;
        if (r3.intValue() != 2) goto L15;
        return "task_only";
    L15:
        if (r3 == null) goto L21;
        r3.intValue();
        return "task_and_memory";
    L21:
        return "task_and_memory";
    }

    private final void a(String r8, String r9) {
        if (this.d == false) goto L6;
        RunLog.INSTANCE.debug("DataMigrationImportTracker", "report import finish ignored: already consumed");
        return;
    L6:
        this.d = true;
        JSONObject r0 = new JSONObject();
        r0.put("data_type", a((Integer) ZeusTransformUtils.preCheckCast(this.c.invoke(), Integer.class, "com.obric.memorydata.plugin")));
        r0.put("duration", RangesKt.coerceAtLeast(System.currentTimeMillis() - this.f11350b, 0));
        r0.put("status", r8);
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        r0.put("fail_reason", r9);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataMigrationImportTracker", "report obric_omni_migration_import_finish: " + r0, false, 4, null);
        Tracker.INSTANCE.reportEvent("obric_omni_migration_import_finish", r0);
    }

    public final synchronized void a() {
        monitor-enter(this);
        a("success", null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(FailReason r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L6
        a("fail", r2.getValue());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
