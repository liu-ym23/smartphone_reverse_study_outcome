package com.obric.memorydata.middleware.database;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Ensure;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003Z[\\B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005H\u0002JV\u0010&\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005JV\u0010)\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005JV\u0010,\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005JB\u0010.\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005J:\u0010/\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005J8\u00100\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005J\u001e\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005J*\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0005072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000507J,\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u0005072\u0006\u0010<\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020\u001bJ0\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020AH\u0002J\u0010\u0010G\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020AH\u0002J\b\u0010H\u001a\u00020\u001bH\u0002J\u0010\u0010I\u001a\u00020\u00162\u0006\u0010F\u001a\u00020AH\u0002J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020A0KH\u0002J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010F\u001a\u00020AH\u0002J\u0016\u0010M\u001a\u00020\u001b2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020A0OH\u0002J\u001b\u0010P\u001a\u00020Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0002¢\u0006\u0002\u0010UJ\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020T0S2\b\u0010W\u001a\u0004\u0018\u00010QH\u0002¢\u0006\u0002\u0010XJ\u0010\u0010Y\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000RP\u0010\u0013\u001aB\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00160\u0016 \u0015* \u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseIsolationTracker;", "", "<init>", "()V", "TAG", "", "MIGRATION_EVENT", "ANONYMOUS_ACCESS_EVENT", "PERSONAL_TABLE_GLOBAL_ACCESS_EVENT", "PERSONAL_TABLE_GLOBAL_ACCESS_EXCEPTION_TAG", "PENDING_REPORTS_KEY", "MAX_PENDING_REPORT_COUNT", "", "EVENT_NAME", "EVENT_PARAMS", "EXCEPTION_MESSAGE", "EXCEPTION_TAG", "EXCEPTION_STACK_TRACE", "MAX_EXCEPTION_STACK_DEPTH", "reportedAnonymousAccesses", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "pendingReportsLock", "reportingSdkReady", "reportMigration", "", "migrationType", TypedValues.CycleType.S_WAVE_PHASE, "status", "migratedCount", "skippedCount", "failedCount", "durationMs", "", "failureReason", "resource", "reportSqlMigration", "Lcom/obric/memorydata/middleware/database/DatabaseIsolationTracker$SqlMigrationPhase;", "tableName", "reportOseMigration", "Lcom/obric/memorydata/middleware/database/DatabaseIsolationTracker$OseMigrationPhase;", "schemaName", "reportVectorFileMigration", "Lcom/obric/memorydata/middleware/database/DatabaseIsolationTracker$VectorFileMigrationPhase;", "reportMetaFullContentUidMigration", "reportIndexPendingBackfill", "reportLegacyBackupRestore", "reportAnonymousDatabaseAccess", "databaseType", "rawUserId", "reportPersonalTableGlobalAccess", "databaseName", "tableNames", "", "runningPackages", "reportAnonymousPersonalOnDemandAccess", "logicName", "physicalName", "threadName", "onReportingSdkReady", "reportEvent", "eventName", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "exceptionTag", "submitReport", "record", "enqueuePendingReport", "flushPendingReports", "dispatchReport", "readPendingReportsLocked", "", "isValidPendingReport", "persistPendingReportsLocked", "reports", "", "encodeStackTrace", "Lorg/json/JSONArray;", "stackTrace", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Lorg/json/JSONArray;", "decodeStackTrace", "encodedStackTrace", "(Lorg/json/JSONArray;)[Ljava/lang/StackTraceElement;", "anonymousReason", "SqlMigrationPhase", "OseMigrationPhase", "VectorFileMigrationPhase", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatabaseIsolationTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DatabaseIsolationTracker f11642a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap.KeySetView<String, Boolean> f11643b = null;
    private static final Object c = null;
    private static volatile boolean d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseIsolationTracker$OseMigrationPhase;", "", "eventValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventValue", "()Ljava/lang/String;", "OVERALL", "SCHEMA", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum OseMigrationPhase extends Enum<OseMigrationPhase> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ OseMigrationPhase[] $VALUES = null;
        public static final OseMigrationPhase OVERALL = null;
        public static final OseMigrationPhase SCHEMA = null;
        private final String eventValue;

        private static final /* synthetic */ OseMigrationPhase[] $values() {
            return new OseMigrationPhase[]{OVERALL, SCHEMA};
        }

        static {
            OVERALL = new OseMigrationPhase("OVERALL", 0, "overall");
            SCHEMA = new OseMigrationPhase("SCHEMA", 1, "schema");
            OseMigrationPhase[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private OseMigrationPhase(String r1, int r2, String r3) {
            super(r1, r2);
            this.eventValue = r3;
        }

        public static EnumEntries<OseMigrationPhase> getEntries() {
            return $ENTRIES;
        }

        public static OseMigrationPhase valueOf(String r2) {
            return (OseMigrationPhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(OseMigrationPhase.class, r2), OseMigrationPhase.class, "com.obric.memorydata.plugin");
        }

        public static OseMigrationPhase[] values() {
            return (OseMigrationPhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OseMigrationPhase[].class, "com.obric.memorydata.plugin");
        }

        public final String getEventValue() {
            return this.eventValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseIsolationTracker$SqlMigrationPhase;", "", "eventValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventValue", "()Ljava/lang/String;", "OVERALL", "COPY", HttpMethodContrants.DELETE, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum SqlMigrationPhase extends Enum<SqlMigrationPhase> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SqlMigrationPhase[] $VALUES = null;
        public static final SqlMigrationPhase COPY = null;
        public static final SqlMigrationPhase DELETE = null;
        public static final SqlMigrationPhase OVERALL = null;
        private final String eventValue;

        private static final /* synthetic */ SqlMigrationPhase[] $values() {
            return new SqlMigrationPhase[]{OVERALL, COPY, DELETE};
        }

        static {
            OVERALL = new SqlMigrationPhase("OVERALL", 0, "overall");
            COPY = new SqlMigrationPhase("COPY", 1, "copy");
            DELETE = new SqlMigrationPhase(HttpMethodContrants.DELETE, 2, "delete");
            SqlMigrationPhase[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private SqlMigrationPhase(String r1, int r2, String r3) {
            super(r1, r2);
            this.eventValue = r3;
        }

        public static EnumEntries<SqlMigrationPhase> getEntries() {
            return $ENTRIES;
        }

        public static SqlMigrationPhase valueOf(String r2) {
            return (SqlMigrationPhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(SqlMigrationPhase.class, r2), SqlMigrationPhase.class, "com.obric.memorydata.plugin");
        }

        public static SqlMigrationPhase[] values() {
            return (SqlMigrationPhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SqlMigrationPhase[].class, "com.obric.memorydata.plugin");
        }

        public final String getEventValue() {
            return this.eventValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseIsolationTracker$VectorFileMigrationPhase;", "", "eventValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventValue", "()Ljava/lang/String;", "OVERALL", "DYNAMIC_ITEM", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum VectorFileMigrationPhase extends Enum<VectorFileMigrationPhase> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ VectorFileMigrationPhase[] $VALUES = null;
        public static final VectorFileMigrationPhase DYNAMIC_ITEM = null;
        public static final VectorFileMigrationPhase OVERALL = null;
        private final String eventValue;

        private static final /* synthetic */ VectorFileMigrationPhase[] $values() {
            return new VectorFileMigrationPhase[]{OVERALL, DYNAMIC_ITEM};
        }

        static {
            OVERALL = new VectorFileMigrationPhase("OVERALL", 0, "overall");
            DYNAMIC_ITEM = new VectorFileMigrationPhase("DYNAMIC_ITEM", 1, "dynamic_item");
            VectorFileMigrationPhase[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private VectorFileMigrationPhase(String r1, int r2, String r3) {
            super(r1, r2);
            this.eventValue = r3;
        }

        public static EnumEntries<VectorFileMigrationPhase> getEntries() {
            return $ENTRIES;
        }

        public static VectorFileMigrationPhase valueOf(String r2) {
            return (VectorFileMigrationPhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(VectorFileMigrationPhase.class, r2), VectorFileMigrationPhase.class, "com.obric.memorydata.plugin");
        }

        public static VectorFileMigrationPhase[] values() {
            return (VectorFileMigrationPhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VectorFileMigrationPhase[].class, "com.obric.memorydata.plugin");
        }

        public final String getEventValue() {
            return this.eventValue;
        }
    }

    static {
        f11642a = new DatabaseIsolationTracker();
        f11643b = ConcurrentHashMap.newKeySet();
        c = new Object();
    }

    private DatabaseIsolationTracker() {
    }

    private final String a(String r2) {
        if (AppContext.INSTANCE.isLogin() == true) goto L6;
        return "not_login";
    L6:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        return "blank_uid";
    L9:
        if (Intrinsics.areEqual(r2, "0") == false) goto L12;
        return "zero_uid";
    L12:
        if (StringsKt.toLongOrNull(r2) != null) goto L14;
        return "invalid_uid";
    L14:
        return "unknown";
    }

    private final JSONArray a(StackTraceElement[] r5) {
        JSONArray r4 = new JSONArray();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.take(r5, 32), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        StackTraceElement r0 = (StackTraceElement) ZeusTransformUtils.preCheckCast(r6.next(), StackTraceElement.class, "com.obric.memorydata.plugin");
        JSONArray r2 = new JSONArray().put(r0.getClassName()).put(r0.getMethodName());
        Object r3 = r0.getFileName();
        if (r3 != null) goto L8;
        r3 = JSONObject.NULL;
    L8:
        r4.put(r2.put(r3).put(r0.getLineNumber()));
        goto L4
    L9:
        return r4;
    }

    public static /* synthetic */ void a(DatabaseIsolationTracker r13, OseMigrationPhase r14, String r15, int r16, int r17, int r18, long r19, String r21, String r22, int r23, Object r24) {
        if ((r23 & 4) == 0) goto L5;
        int r6 = 0;
    L7:
        if ((r23 & 8) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r23 & 16) == 0) goto L13;
        int r8 = 0;
    L15:
        if ((r23 & 32) == 0) goto L17;
        long r9 = 0;
    L19:
        if ((r23 & 64) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r23 & 128) == 0) goto L25;
        String r12 = null;
    L26:
        r13.a(r14, r15, r6, r7, r8, r9, r11, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r11 = r21;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public static /* synthetic */ void a(DatabaseIsolationTracker r13, SqlMigrationPhase r14, String r15, String r16, int r17, int r18, int r19, long r20, String r22, int r23, Object r24) {
        if ((r23 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r23 & 8) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r23 & 16) == 0) goto L13;
        int r8 = 0;
    L15:
        if ((r23 & 32) == 0) goto L17;
        int r9 = 0;
    L19:
        if ((r23 & 64) == 0) goto L21;
        long r10 = 0;
    L23:
        if ((r23 & 128) == 0) goto L25;
        String r12 = null;
    L26:
        r13.a(r14, r15, r6, r7, r8, r9, r10, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public static /* synthetic */ void a(DatabaseIsolationTracker r13, VectorFileMigrationPhase r14, String r15, int r16, int r17, int r18, long r19, String r21, String r22, int r23, Object r24) {
        if ((r23 & 4) == 0) goto L5;
        int r6 = 0;
    L7:
        if ((r23 & 8) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r23 & 16) == 0) goto L13;
        int r8 = 0;
    L15:
        if ((r23 & 32) == 0) goto L17;
        long r9 = 0;
    L19:
        if ((r23 & 64) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r23 & 128) == 0) goto L25;
        String r12 = null;
    L26:
        r13.a(r14, r15, r6, r7, r8, r9, r11, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r11 = r21;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public static /* synthetic */ void a(DatabaseIsolationTracker r6, String r7, int r8, int r9, int r10, long r11, String r13, int r14, Object r15) {
        int r1 = 0;
        if ((r14 & 2) == 0) goto L5;
        int r0 = 0;
    L7:
        if ((r14 & 4) == 0) goto L9;
        int r2 = 0;
    L11:
        if ((r14 & 8) != 0) goto L15;
        r1 = r10;
    L15:
        if ((r14 & 16) == 0) goto L17;
        long r3 = 0;
    L19:
        if ((r14 & 32) == 0) goto L21;
        String r5 = null;
    L22:
        r6.a(r7, r0, r2, r1, r3, r5);
        return;
    L21:
        r5 = r13;
        goto L22
    L17:
        r3 = r11;
        goto L19
    L9:
        r2 = r9;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }

    public static /* synthetic */ void a(DatabaseIsolationTracker r7, String r8, int r9, long r10, String r12, String r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = 0;
    L5:
        int r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        r10 = 0;
    L8:
        long r3 = r10;
        if ((r14 & 8) == 0) goto L11;
        String r5 = null;
    L13:
        if ((r14 & 16) == 0) goto L15;
        String r6 = null;
    L16:
        r7.a(r8, r2, r3, r5, r6);
        return;
    L15:
        r6 = r13;
        goto L16
    L11:
        r5 = r12;
        goto L13
    }

    static /* synthetic */ void a(DatabaseIsolationTracker r14, String r15, String r16, String r17, int r18, int r19, int r20, long r21, String r23, String r24, int r25, Object r26) {
        if ((r25 & 8) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r25 & 16) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r25 & 32) == 0) goto L13;
        int r9 = 0;
    L15:
        if ((r25 & 64) == 0) goto L17;
        long r10 = 0;
    L19:
        if ((r25 & 128) == 0) goto L21;
        String r12 = null;
    L23:
        if ((r25 & 256) == 0) goto L25;
        String r13 = null;
    L26:
        r14.a(r15, r16, r17, r7, r8, r9, r10, r12, r13);
        return;
    L25:
        r13 = r24;
        goto L26
    L21:
        r12 = r23;
        goto L23
    L17:
        r10 = r21;
        goto L19
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }

    static /* synthetic */ void a(DatabaseIsolationTracker r1, String r2, JSONObject r3, Throwable r4, String r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.a(r2, r3, r4, r5);
    }

    private final void a(String r15, String r16, String r17, int r18, int r19, int r20, long r21, String r23, String r24) {
        int r4 = r18 + r20;
        int r5 = r4 + r19;
        if (Intrinsics.areEqual(r17, "success") == false) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r4 == 0) goto L11;
        double r10 = ((double) r18) / ((double) r4);
    L18:
        JSONObject r0 = new JSONObject().put("schema_version", 1).put("migration_type", r15).put(TypedValues.CycleType.S_WAVE_PHASE, r16).put("status", r17).put(LocationMonitorConst.IS_SUCCESS, r7);
        String r6 = "";
        if (r24 != null) goto L21;
        String r8 = "";
    L22:
        JSONObject r1 = r0.put("resource", r8).put("migrated_count", r18).put("skipped_count", r19).put("failed_count", r20).put("attempted_count", r4).put("total_count", r5).put("success_rate", r10).put("duration_ms", r21);
        if (r23 == null) goto L26;
        r6 = r23;
    L26:
        JSONObject r2 = r1.put("failure_reason", r6);
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        a(this, "database_isolation_migration", r2, null, null, 12, null);
        return;
    L21:
        r8 = r24;
        goto L22
    L11:
        if (Intrinsics.areEqual(r17, "success") == false) goto L13;
    L16:
        r10 = 1.0d;
        goto L18
    L13:
        if (Intrinsics.areEqual(r17, "partial_success") == true) goto L16;
        r10 = 0.0d;
        goto L18
    L5:
        if (Intrinsics.areEqual(r17, "partial_success") == true) goto L8;
        r7 = false;
        goto L9
    }

    private final void a(String r3, JSONObject r4, Throwable r5, String r6) {
        JSONObject r7 = new JSONObject().put("event_name", r3).put("event_params", new JSONObject(r4.toString()));
        if (r5 == null) goto L5;
        String r8 = r5.getMessage();
    L7:
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        JSONObject r9 = r7.put("exception_message", r8);
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        JSONObject r10 = r9.put("exception_tag", r6);
        if (r5 == null) goto L15;
        DatabaseIsolationTracker r11 = f11642a;
        StackTraceElement[] r12 = r5.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(r12, "getStackTrace(...)");
        r10.put("exception_stack_trace", r11.a(r12));
    L15:
        Intrinsics.checkNotNull(r10);
        a(r10);
        return;
    L5:
        r8 = null;
        goto L7
    }

    private final void a(List<? extends JSONObject> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        JSONArray r6 = new JSONArray();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.put((JSONObject) ZeusTransformUtils.preCheckCast(r7.next(), JSONObject.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        IStore r8 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r9 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        r8.syncSave("database_isolation_pending_reports", r9);
    }

    private final void a(JSONObject r2) {
        if (d == true) goto L5;
    L7:
        b(r2);
        return;
    L5:
        if (c(r2) == false) goto L7;
    }

    private final StackTraceElement[] a(JSONArray r10) {
        if (r10 == null) goto L5;
        List r0 = CollectionsKt.createListBuilder();
        int r1 = Math.min(r10.length(), 32);
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L24;
        JSONArray r4 = r10.optJSONArray(r2);
        if (r4 == null) goto L22;
        String r5 = r4.optString(0);
        String r6 = r4.optString(1);
        Intrinsics.checkNotNull(r5);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L22;
        Intrinsics.checkNotNull(r6);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L22;
        String r7 = r4.optString(2);
        if (r4.isNull(2) == false) goto L21;
        r7 = null;
    L21:
        r0.add(new StackTraceElement(r5, r6, r7, r4.optInt(3, -1)));
    L22:
        r2 = r2 + 1;
        goto L8
    L24:
        return (StackTraceElement[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r0), Collection.class, "com.obric.memorydata.plugin")).toArray(new StackTraceElement[0]), StackTraceElement[].class, "com.obric.memorydata.plugin");
    L5:
        return new StackTraceElement[0];
    }

    private final void b() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        DatabaseIsolationTracker r7 = (DatabaseIsolationTracker) ZeusTransformUtils.preCheckCast(this, DatabaseIsolationTracker.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Object r1 = c;     // Catch: Throwable -> L21
        monitor-enter(r1);     // Catch: Throwable -> L21
        List<JSONObject> r2 = r7.c();     // Catch: Throwable -> L18
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L18
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();     // Catch: Throwable -> L18
        if (r7.c((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin")) == true) goto L8;
        r4.add(r6);     // Catch: Throwable -> L18
        goto L8
    L12:
        List<? extends JSONObject> r8 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r8.size() == r2.size()) goto L15;
        r7.a(r8);     // Catch: Throwable -> L18
    L15:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L21
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L35;
        RunLog.INSTANCE.warn("db_iso_DatabaseIsolationTracker", "flush pending database isolation reports failed", r11);
        return;
    L35:
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    private final void b(JSONObject r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        DatabaseIsolationTracker r3 = (DatabaseIsolationTracker) ZeusTransformUtils.preCheckCast(this, DatabaseIsolationTracker.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r1 = c;     // Catch: Throwable -> L14
        monitor-enter(r1);     // Catch: Throwable -> L14
        List<JSONObject> r2 = r3.c();     // Catch: Throwable -> L11
        r2.add(new JSONObject(r4.toString()));     // Catch: Throwable -> L11
    L6:
        if (r2.size() <= 200) goto L8;
        r2.remove(0);     // Catch: Throwable -> L11
        goto L6
    L8:
        r3.a(r2);     // Catch: Throwable -> L11
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L14
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L24;
        RunLog.INSTANCE.warn("db_iso_DatabaseIsolationTracker", "persist pending database isolation report failed", r7);
        return;
    L24:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private final List<JSONObject> c() {
        int r3 = 0;
        Object r5 = null;
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r4 = r0.getString("database_isolation_pending_reports", "");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L34;
        ArrayList r10 = new ArrayList();
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    L34:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        DatabaseIsolationTracker r7 = (DatabaseIsolationTracker) ZeusTransformUtils.preCheckCast(this, DatabaseIsolationTracker.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r8 = Result.m1421constructorimpl(new JSONArray(r4));     // Catch: Throwable -> L9
    L11:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L15;
        RunLog.INSTANCE.warn("db_iso_DatabaseIsolationTracker", "pending database isolation reports json is invalid", r9);
        r0.syncSave("database_isolation_pending_reports", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    L15:
        if (Result.m1427isFailureimpl(r8) == true) goto L18;
        r5 = r8;
    L18:
        JSONArray r1 = (JSONArray) ZeusTransformUtils.preCheckCast(r5, JSONArray.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L21;
        r10 = new ArrayList();
        goto L6
    L21:
        List<JSONObject> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r11 = r1.length();
        boolean r12 = false;
    L22:
        if (r3 >= r11) goto L31;
        JSONObject r13 = r1.optJSONObject(r3);
        if (r13 != null) goto L26;
    L29:
        r12 = true;
    L30:
        r3 = r3 + 1;
        goto L22
    L26:
        if (d(r13) == false) goto L29;
        r2.add(r13);
        goto L30
    L31:
        if (r12 == false) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_DatabaseIsolationTracker", "drop invalid pending database isolation report records", null, 4, null);
        a(r2);
    L33:
        return r2;
    L9:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final boolean c(JSONObject r6) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        DatabaseIsolationTracker r5 = (DatabaseIsolationTracker) ZeusTransformUtils.preCheckCast(this, DatabaseIsolationTracker.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        String r2 = r6.getString("event_name");     // Catch: Throwable -> L20
        JSONObject r3 = r6.getJSONObject("event_params");     // Catch: Throwable -> L20
        Tracker r4 = Tracker.INSTANCE;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L20
        r4.reportEvent(r2, new JSONObject(r3.toString()));     // Catch: Throwable -> L20
        String r7 = r6.optString("exception_message");     // Catch: Throwable -> L20
        String r8 = r6.optString("exception_tag");     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L20
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L18;
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L20
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L18;
        IllegalStateException r9 = new IllegalStateException(r7);     // Catch: Throwable -> L20
        StackTraceElement[] r10 = r5.a(r6.optJSONArray("exception_stack_trace"));     // Catch: Throwable -> L20
        if (r10.length != 0) goto L10;
        boolean r11 = true;
    L12:
        if ((!r11) == true) goto L15;
        r10 = null;
    L15:
        if (r10 == null) goto L17;
        r9.setStackTrace(r10);     // Catch: Throwable -> L20
    L17:
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin"), r8);     // Catch: Throwable -> L20
        goto L18
    L10:
        r11 = false;
    L18:
        Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 == null) goto L26;
        RunLog.INSTANCE.warn("db_iso_DatabaseIsolationTracker", "dispatch database isolation report failed", r13);
    L26:
        return Result.m1428isSuccessimpl(r12);
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    private final boolean d(JSONObject r3) {
        String r2 = r3.optString("event_name");
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L7:
        return false;
    L5:
        if (r3.optJSONObject("event_params") == null) goto L7;
        return true;
    }

    public final void a() {
        d = true;
        b();
    }

    public final void a(OseMigrationPhase r13, String r14, int r15, int r16, int r17, long r18, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r13, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r14, "status");
        a("ose", r13.getEventValue(), r14, r15, r16, r17, r18, r20, r21);
    }

    public final void a(SqlMigrationPhase r13, String r14, String r15, int r16, int r17, int r18, long r19, String r21) {
        Intrinsics.checkNotNullParameter(r13, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r14, "status");
        a("sql", r13.getEventValue(), r14, r16, r17, r18, r19, r21, r15);
    }

    public final void a(VectorFileMigrationPhase r13, String r14, int r15, int r16, int r17, long r18, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r13, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r14, "status");
        a("vector_file", r13.getEventValue(), r14, r15, r16, r17, r18, r20, r21);
    }

    public final void a(String r15, int r16, int r17, int r18, long r19, String r21) {
        Intrinsics.checkNotNullParameter(r15, "status");
        a(this, "meta_full_content_uid", "overall", r15, r16, r17, r18, r19, r21, null, 256, null);
    }

    public final void a(String r15, int r16, int r17, long r18, String r20) {
        Intrinsics.checkNotNullParameter(r15, "status");
        a(this, "legacy_backup_restore", "overall", r15, r16, r17, 0, r18, r20, null, 288, null);
    }

    public final void a(String r15, int r16, long r17, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r15, "status");
        a(this, "index_pending_backfill", "overall", r15, r16, 0, 0, r17, r19, r20, 48, null);
    }

    public final void a(String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "databaseType");
        Intrinsics.checkNotNullParameter(r19, "resource");
        Intrinsics.checkNotNullParameter(r20, "rawUserId");
        if (f11643b.add(r18 + ':' + r19) == true) goto L5;
        return;
    L5:
        String r3 = a(r20);
        RunLog.INSTANCE.error("db_iso_DatabaseIsolationTracker", "anonymous profile database access, databaseType=" + r18 + ", resource=" + r19 + ", reason=" + r3, (Throwable) ZeusTransformUtils.preCheckCast(new IllegalAccessException("anonymous profile database access"), Throwable.class, "com.obric.memorydata.plugin"));
        IllegalStateException r5 = new IllegalStateException("anonymous profile database access: databaseType=" + r18 + ", resource=" + r19 + ", reason=" + r3);
        StackTraceElement[] r6 = r5.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(r6, "getStackTrace(...)");
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.memorydata.plugin");
        ArrayList r8 = new ArrayList();
        int r9 = r7.length;
        int r10 = 0;
        boolean r12 = false;
    L6:
        if (r10 >= r9) goto L14;
        Object r14 = r7[r10];
        if (r12 == false) goto L11;
        r8.add(r14);
    L13:
        r10 = r10 + 1;
        goto L6
    L11:
        if (Intrinsics.areEqual(((StackTraceElement) ZeusTransformUtils.preCheckCast(r14, StackTraceElement.class, "com.obric.memorydata.plugin")).getClassName(), DatabaseIsolationTracker.class.getName()) == true) goto L13;
        r8.add(r14);
        r12 = true;
        goto L13
    L14:
        r5.setStackTrace((StackTraceElement[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 32), Collection.class, "com.obric.memorydata.plugin")).toArray(new StackTraceElement[0]), StackTraceElement[].class, "com.obric.memorydata.plugin"));
        JSONObject r1 = new JSONObject().put("schema_version", 1).put("database_type", r18).put("resource", r19).put(InfoRequestQPSOptTraceLogger.REASON, r3).put("is_login", AppContext.INSTANCE.isLogin());
        Intrinsics.checkNotNullExpressionValue(r1, "put(...)");
        a("database_isolation_anonymous_access", r1, (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"), "db_iso_anonymous_profile_access");
    }

    public final void a(String r12, String r13, Set<String> r14, String r15) {
        Set r16 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "logicName");
        Intrinsics.checkNotNullParameter(r13, "physicalName");
        Intrinsics.checkNotNullParameter(r16, "runningPackages");
        Intrinsics.checkNotNullParameter(r15, "threadName");
        if (f11643b.add("on_demand:" + r12) == true) goto L5;
        return;
    L5:
        String r17 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        String r18 = "db_iso_DatabaseIsolationTracker anonymous profile personal db on-demand access: logicName=" + r12 + ", physicalName=" + r13 + ", runningPackages=" + r17 + ", thread=" + r15;
        IllegalStateException r0 = new IllegalStateException(r18);
        RunLog.INSTANCE.error("db_iso_DatabaseIsolationTracker", r18, (Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin"));
        JSONObject r19 = new JSONObject().put("schema_version", 1).put("database_type", "on_demand_personal").put("resource", r12).put(InfoRequestQPSOptTraceLogger.REASON, "on_demand_not_login").put("running_packages", r17).put("thread", r15).put("is_login", AppContext.INSTANCE.isLogin());
        Intrinsics.checkNotNullExpressionValue(r19, "put(...)");
        a("database_isolation_anonymous_access", r19, (Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin"), "db_iso_anonymous_on_demand_personal_access");
    }

    public final void a(String r11, Set<String> r12, Set<String> r13) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "databaseName");
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        Intrinsics.checkNotNullParameter(r14, "runningPackages");
        String r15 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        String r16 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        String r17 = "db_iso_DatabaseIsolationTracker personal table accessed through global database: databaseName=" + r11 + ", tables=" + r15 + ", runningPackages=" + r16;
        IllegalStateException r18 = new IllegalStateException(r17);
        RunLog.INSTANCE.error("db_iso_DatabaseIsolationTracker", r17, (Throwable) ZeusTransformUtils.preCheckCast(r18, Throwable.class, "com.obric.memorydata.plugin"));
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(r18, Throwable.class, "com.obric.memorydata.plugin"), "db_iso_personal_table_global_access", MapsKt.mapOf(new Pair[]{TuplesKt.to("tables", r15), TuplesKt.to("running_packages", r16)}));
    }
}
