package com.obric.memorydata.memory.ui.migration;

import android.content.Context;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.memorydata.database.account_split.w;
import com.obric.memorydata.database.account_split.x;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.migration.sdk.DbRole;
import com.obric.memorydata.migration.sdk.KvValueType;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.QrPayload;
import com.obric.memorydata.migration.sdk.ab;
import com.obric.memorydata.migration.sdk.ai;
import com.obric.memorydata.migration.sdk.j;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.n;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.r;
import com.obric.memorydata.migration.sdk.u;
import com.obric.memorydata.migration.sdk.v;
import com.obric.memorydata.migration.sdk.z;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin_api.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.ck;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0004XYZ[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013J \u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u00132\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020\rH\u0014J\b\u00101\u001a\u000202H\u0002J\u001e\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020-J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000207062\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130<H\u0002J\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020>H\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020A06H\u0002J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130<2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00130<H\u0002J \u0010D\u001a\u00020>2\u0006\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005H\u0002J\u0018\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020J2\u0006\u00104\u001a\u00020\u0007H\u0002J\u001e\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/J\u0010\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020>H\u0002J\u0010\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020QH\u0002J\f\u0010R\u001a\u00020Q*\u00020SH\u0002J\u001a\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00132\b\u0010W\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006\\"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "userCancelled", "", "bizCallback", "Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel$BizCallback;", "getBizCallback", "()Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel$BizCallback;", "bizCallback$delegate", "Lkotlin/Lazy;", "cancelByUser", "", "SIZE_RE", "Lkotlin/text/Regex;", "parseSizeNumberAndUnit", "Lkotlin/Pair;", "", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, EventBody.KEY_VALUE, "isExport", "()Z", "lastTransferPercent", "", "lastErrorStep", "Lcom/obric/memorydata/migration/sdk/MigrationStep;", "migrationClient", "Lcom/obric/memorydata/migration/sdk/MigrationClient;", "importTracker", "Lcom/obric/memorydata/memory/ui/migration/DataMigrationImportTracker;", "exportScopeForUi", "Ljava/lang/Integer;", "importScopeForUi", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/migration/MigrationState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "initInitialState", "scanResult", "exportSelection", "Lcom/obric/memorydata/memory/ui/migration/ExportSelection;", "context", "Landroid/content/Context;", "onCleared", "resolveMigrationAppVersionCode", "", "startExportAsOldDevice", "biz", "globalBackupTables", "", "Lcom/obric/memorydata/migration/sdk/TableBackupConfig;", "userBaseBackupTables", "userBaseBackupTablesLegacy", "discoverFkChildTables", "declaredNames", "", "buildMigrationBackupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "buildLegacySingleDbBackupConfig", "buildMigrationKvRepos", "Lcom/obric/memorydata/migration/sdk/KvRepoConfig;", "discoverForeignKeyChildren", "parentTables", "buildReceiverBackupConfig", "baseConfig", "screenEnabled", "autoEnabled", "onSdkEvent", "event", "Lcom/obric/memorydata/migration/sdk/MigrationEvent;", "startImportAsNewDevice", "qrText", "summarizeBackupConfig", "config", "reportImportFailure", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/memorydata/memory/ui/migration/DataMigrationImportTracker$FailReason;", "toImportFailReason", "Lcom/obric/memorydata/migration/sdk/MigrationErrorCode;", "buildPostRestoreHook", "Lcom/obric/memorydata/migration/sdk/PostRestoreHook;", "expectedUserId", "syncToken", "ContextSyncMigrationSession", "Companion", "BizCallback", "UiBizCallback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataTransferViewModel extends ViewModel {
    public static final b Companion = null;
    private static final long DUAL_DB_MIN_APP_VERSION_CODE = 14030010;
    private static final String TAG = "DataTransferViewModel";
    private final Regex SIZE_RE;
    private final ae<com.obric.memorydata.memory.ui.migration.b> _uiState;
    private final Lazy bizCallback$delegate;
    private volatile Integer exportScopeForUi;
    private volatile Integer importScopeForUi;
    private DataMigrationImportTracker importTracker;
    private boolean isExport;
    private volatile MigrationStep lastErrorStep;
    private int lastTransferPercent;
    private n migrationClient;
    private final ar<com.obric.memorydata.memory.ui.migration.b> uiState;
    private volatile boolean userCancelled;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel$BizCallback;", "", "onQrTextReady", "", "qrText", "", "onState", "step", "Lcom/obric/memorydata/migration/sdk/MigrationStep;", MemoryListActivity.JUMP_FROM_DETAIL, "onProgress", "transferred", LBSLightLocationTraceLogger.TOTAL, "percent", "", "onError", "code", "Lcom/obric/memorydata/migration/sdk/MigrationErrorCode;", "message", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void a(MigrationErrorCode r1, String r2);

        void a(MigrationStep r1, String r2);

        void a(String r1);

        void a(String r1, String r2, int r3);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel$Companion;", "", "<init>", "()V", "TAG", "", "DUAL_DB_MIN_APP_VERSION_CODE", "", "isScreenMemoryEnabled", "", "isAutoMemoryEnabled", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        private final boolean a() {
            return AILabPermissionRepository.a(AILabPermissionRepository.f10236a, null, 1, null);
        }

        public static final /* synthetic */ boolean a(b r0) {
            return r0.a();
        }

        private final boolean b() {
            return AILabPermissionRepository.a(AILabPermissionRepository.f10236a, null, null, null, null, null, null, 63, null);
        }

        public static final /* synthetic */ boolean b(b r0) {
            return r0.b();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel$ContextSyncMigrationSession;", "", "userId", "", "token", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getToken", "restoreStarted", "", "getRestoreStarted", "()Z", "setRestoreStarted", "(Z)V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11356b;
        private volatile boolean c;

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "token");
            this.f11355a = r2;
            this.f11356b = r3;
        }

        public final String a() {
            return this.f11355a;
        }

        public final void a(boolean r1) {
            this.c = r1;
        }

        public final String b() {
            return this.f11356b;
        }

        public final boolean c() {
            return this.c;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel$UiBizCallback;", "Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel$BizCallback;", "<init>", "(Lcom/obric/memorydata/memory/ui/migration/DataTransferViewModel;)V", "onQrTextReady", "", "qrText", "", "onState", "step", "Lcom/obric/memorydata/migration/sdk/MigrationStep;", MemoryListActivity.JUMP_FROM_DETAIL, "onProgress", "transferred", LBSLightLocationTraceLogger.TOTAL, "percent", "", "onError", "code", "Lcom/obric/memorydata/migration/sdk/MigrationErrorCode;", "message", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataTransferViewModel f11357a;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11358a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f11359b = null;

            static {
                int[] r0 = new int[MigrationStep.values().length];
                r0[MigrationStep.BACKING_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
            L35:
                r0[MigrationStep.RESTORING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
            L47:
                r0[MigrationStep.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
            L37:
                r0[MigrationStep.CONNECTING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
            L10:
                f11358a = r0;
                int[] r1 = new int[MigrationErrorCode.values().length];
                r1[MigrationErrorCode.CONNECT_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
            L41:
                r1[MigrationErrorCode.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
            L29:
                r1[MigrationErrorCode.OTHER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
            L39:
                r1[MigrationErrorCode.UID_MISMATCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
            L33:
                r1[MigrationErrorCode.VERSION_TOO_LOW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
            L43:
                r1[MigrationErrorCode.NO_SPACE_LEFT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
            L17:
                f11359b = r1;
            }
        }

        public d(DataTransferViewModel r1) {
            this.f11357a = r1;
        }

        @Override // com.obric.memorydata.memory.ui.migration.DataTransferViewModel.a
        public void a(MigrationErrorCode r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "code");
            Intrinsics.checkNotNullParameter(r11, "message");
            if (DataTransferViewModel.access$getUserCancelled$p(this.f11357a) == false) goto L5;
            return;
        L5:
            com.obric.memorydata.memory.ui.migration.b r0 = (com.obric.memorydata.memory.ui.migration.b) ZeusTransformUtils.preCheckCast(DataTransferViewModel.access$get_uiState$p(this.f11357a).c(), com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.c.class) == false) goto L8;
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.e.class) == true) goto L36;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "onError: code=" + r10 + ", isExport=" + this.f11357a.isExport() + ", lastErrorStep=" + DataTransferViewModel.access$getLastErrorStep$p(this.f11357a) + ", msg=" + r11, null, 4, null);
            DataTransferViewModel r12 = this.f11357a;
            DataTransferViewModel.access$reportImportFailure(r12, DataTransferViewModel.access$toImportFailReason(r12, r10));
            switch(a.f11359b[r10.ordinal()]) {
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L15;
                default: goto L13;
            };
        L25:
            ae r9 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            com.obric.memorydata.memory.ui.migration.b.c r13 = com.obric.memorydata.memory.ui.migration.b.c.f.f11372a;
        L31:
            r9.b(r13);
            return;
        L26:
            r9 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            r13 = com.obric.memorydata.memory.ui.migration.b.c.a.f11367a;
            goto L31
        L27:
            ae r14 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            com.obric.memorydata.memory.ui.migration.b.c r15 = new com.obric.memorydata.memory.ui.migration.b.c.C0612b(this.f11357a.isExport());
        L29:
            r14.b(r15);
            return;
        L28:
            r14 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            r15 = new com.obric.memorydata.memory.ui.migration.b.c.e(this.f11357a.isExport());
            goto L29
        L30:
            r9 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            r13 = com.obric.memorydata.memory.ui.migration.b.c.C0613c.f11369a;
            goto L31
        L13:
            throw new NoWhenBranchMatchedException();
        L15:
            if (this.f11357a.isExport() == true) goto L17;
        L19:
            boolean r16 = false;
        L20:
            ae r17 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            if (r16 == false) goto L23;
            Object r18 = ZeusTransformUtils.preCheckCast(new com.obric.memorydata.memory.ui.migration.b.c.C0612b(this.f11357a.isExport()), com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin");
        L24:
            r17.b((com.obric.memorydata.memory.ui.migration.b) r18);
            return;
        L23:
            r18 = ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.migration.b.c.d.f11370a, com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin");
            goto L24
        L17:
            if (DataTransferViewModel.access$getLastErrorStep$p(this.f11357a) != MigrationStep.TRANSFERRING) goto L19;
            r16 = true;
            goto L20
        }

        @Override // com.obric.memorydata.memory.ui.migration.DataTransferViewModel.a
        public void a(MigrationStep r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "step");
            if (DataTransferViewModel.access$getUserCancelled$p(this.f11357a) == false) goto L5;
            return;
        L5:
            com.obric.memorydata.memory.ui.migration.b r5 = (com.obric.memorydata.memory.ui.migration.b) ZeusTransformUtils.preCheckCast(DataTransferViewModel.access$get_uiState$p(this.f11357a).c(), com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.migration.b.c.class) == false) goto L8;
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.migration.b.e.class) == false) goto L11;
            return;
        L11:
            if (r3 != MigrationStep.FAILED) goto L14;
            DataTransferViewModel.access$reportImportFailure(this.f11357a, DataMigrationImportTracker.FailReason.TRANSFER_ERROR);
            DataTransferViewModel.access$get_uiState$p(this.f11357a).b(new com.obric.memorydata.memory.ui.migration.b.c.e(this.f11357a.isExport()));
            return;
        L14:
            int r6 = a.f11358a[r3.ordinal()];
            if (r6 != 1) goto L17;
            ae r2 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            com.obric.memorydata.memory.ui.migration.b r7 = com.obric.memorydata.memory.ui.migration.b.C0611b.f11366a;
        L40:
            r2.b(r7);
            return;
        L17:
            if (r6 == 2) goto L37;
            if (r6 == 3) goto L29;
            if (r6 != 4) goto L47;
            ae r8 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            com.obric.memorydata.memory.ui.migration.b.a r0 = com.obric.memorydata.memory.ui.migration.b.a.f11365a;
            if ((!this.f11357a.isExport()) == true) goto L27;
            r0 = null;
        L27:
            r8.b(r0);
            return;
        L47:
            return;
        L29:
            if (this.f11357a.isExport() == false) goto L32;
            ae r9 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            com.obric.memorydata.memory.ui.migration.b.e r10 = new com.obric.memorydata.memory.ui.migration.b.e.a(DataTransferViewModel.access$getExportScopeForUi$p(this.f11357a));
        L31:
            r9.b(r10);
            return;
        L32:
            DataMigrationImportTracker r11 = DataTransferViewModel.access$getImportTracker$p(this.f11357a);
            if (r11 == null) goto L35;
            r11.a();
        L35:
            r9 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            r10 = new com.obric.memorydata.memory.ui.migration.b.e.C0614b(DataTransferViewModel.access$getImportScopeForUi$p(this.f11357a));
            goto L31
        L37:
            if (this.f11357a.isExport() == true) goto L45;
            r2 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            r7 = com.obric.memorydata.memory.ui.migration.b.d.f11373a;
            goto L40
        }

        @Override // com.obric.memorydata.memory.ui.migration.DataTransferViewModel.a
        public void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "qrText");
            if (DataTransferViewModel.access$getUserCancelled$p(this.f11357a) == false) goto L5;
            return;
        L5:
            DataTransferViewModel.access$get_uiState$p(this.f11357a).b(new com.obric.memorydata.memory.ui.migration.b.g(r2));
        }

        @Override // com.obric.memorydata.memory.ui.migration.DataTransferViewModel.a
        public void a(String r4, String r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "transferred");
            Intrinsics.checkNotNullParameter(r5, LBSLightLocationTraceLogger.TOTAL);
            if (DataTransferViewModel.access$getUserCancelled$p(this.f11357a) == false) goto L5;
            return;
        L5:
            com.obric.memorydata.memory.ui.migration.b r0 = (com.obric.memorydata.memory.ui.migration.b) ZeusTransformUtils.preCheckCast(DataTransferViewModel.access$get_uiState$p(this.f11357a).c(), com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.c.class) == false) goto L8;
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.e.class) == false) goto L10;
            return;
        L10:
            if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.migration.b.d.class) == true) goto L20;
            ae r1 = DataTransferViewModel.access$get_uiState$p(this.f11357a);
            Pair<Double, String> r3 = this.f11357a.parseSizeNumberAndUnit(r4);
            if (r3 == null) goto L15;
            Double r7 = (Double) ZeusTransformUtils.preCheckCast(r3.getFirst(), Double.class, "com.obric.memorydata.plugin");
        L16:
            r1.b(new com.obric.memorydata.memory.ui.migration.b.f(r6, String.valueOf(r7), r5));
            return;
        L15:
            r7 = null;
            goto L16
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11360a = null;

        static {
            int[] r0 = new int[MigrationErrorCode.values().length];
            r0[MigrationErrorCode.VERSION_TOO_LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[MigrationErrorCode.CONNECT_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[MigrationErrorCode.DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[MigrationErrorCode.NO_SPACE_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MigrationErrorCode.OTHER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[MigrationErrorCode.UID_MISMATCH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f11360a = r0;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class f implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11362b;

        f(String r1, String r2) {
            this.f11361a = r1;
            this.f11362b = r2;
        }

        @Override // com.obric.memorydata.migration.sdk.ab
        public final Object a(Context r7, com.obric.memorydata.migration.sdk.b r8, m r9, Continuation<? super z<Unit>> r10) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            m r12 = (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.memorydata.plugin");
            Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r13, DataTransferViewModel$buildPostRestoreHook$1$onPostRestore$1.class) == false) goto L7;
            DataTransferViewModel$buildPostRestoreHook$1$onPostRestore$1 r14 = (DataTransferViewModel$buildPostRestoreHook$1$onPostRestore$1) ZeusTransformUtils.preCheckCast(r13, DataTransferViewModel$buildPostRestoreHook$1$onPostRestore$1.class, "com.obric.memorydata.plugin");
            if ((r14.label & Integer.MIN_VALUE) == 0) goto L7;
            r14.label -= Integer.MIN_VALUE;
        L8:
            Object r15 = r14.result;
            Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r17 = r14.label;
            if (r17 == 0) goto L16;
            if (r17 == 1) goto L15;
            if (r17 != 2) goto L14;
            ResultKt.throwOnFailure(r15);
        L30:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L34;
            return new z.a(new o(MigrationErrorCode.OTHER, "记忆同步进度准备失败，请重试迁移", null, 4, null));
        L34:
            return new z.b(Unit.INSTANCE);
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            f this = (f) ZeusTransformUtils.preCheckCast(r14.L$0, f.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
        L25:
            if (this.f11362b == null) goto L34;
            CoroutineContext r18 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.preCheckCast(new DataTransferViewModel$buildPostRestoreHook$1$prepared$1(this.f11361a, this.f11362b, null), Function2.class, "com.obric.memorydata.plugin");
            r14.L$0 = null;
            r14.label = 2;
            r15 = i.a(r18, r6, r14);
            if (r15 != r16) goto L30;
            return r16;
        L16:
            ResultKt.throwOnFailure(r15);
            if (AppContext.INSTANCE.isLogin() == false) goto L36;
            if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), this.f11361a) == false) goto L36;
            CoroutineContext r19 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r110 = (Function2) ZeusTransformUtils.preCheckCast(new DataTransferViewModel$buildPostRestoreHook$1$1(null), Function2.class, "com.obric.memorydata.plugin");
            r14.L$0 = this;
            r14.label = 1;
            if (i.a(r19, r110, r14) != r16) goto L25;
            return r16;
        L36:
            return new z.a(new o(MigrationErrorCode.UID_MISMATCH, "迁移恢复时账号已变化", null, 4, null));
        L7:
            r14 = new DataTransferViewModel$buildPostRestoreHook$1$onPostRestore$1(this, r13);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class g<T> implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((ai) ZeusTransformUtils.preCheckCast(r2, ai.class, "com.obric.memorydata.plugin")).a(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.memorydata.plugin")).a(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.DataTransferViewModel$startExportAsOldDevice$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferViewModel$startExportAsOldDevice$1", f = "DataTransferViewModel.kt", i = {0, 0}, l = {237, 266}, m = "invokeSuspend", n = {"uid", "appVersionCode"}, s = {"L$0", "J$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $biz;
        final /* synthetic */ Context $context;
        final /* synthetic */ com.obric.memorydata.memory.ui.migration.a $exportSelection;
        long J$0;
        Object L$0;
        int label;
        final /* synthetic */ DataTransferViewModel this$0;

        AnonymousClass1(DataTransferViewModel r3, com.obric.memorydata.memory.ui.migration.a r4, Context r5, a r6, Continuation<? super AnonymousClass1> r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$exportSelection = r4;
            this.$context = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
            this.$biz = r9;
            super(2, r10);
        }

        private static final void invokeSuspend$lambda$0(DataTransferViewModel r2, a r3, p r4) {
            DataTransferViewModel.access$onSdkEvent(r2, r4, (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"));
        }

        public static /* synthetic */ void lambda$i_2Dquo9BNoDYvqAoR0fGkuS1_s(DataTransferViewModel r0, a r1, p r2) {
            invokeSuspend$lambda$0(r0, r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$exportSelection, this.$context, this.$biz, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r25) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r25);
            Object r3 = r25;
        L20:
            z r4 = (z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, z.a.class) == false) goto L23;
            RunLog.INSTANCE.error(DataTransferViewModel.TAG, "startExportAsOldDevice: startSender FAILED, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r4, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", msg=" + ((z.a) ZeusTransformUtils.preCheckCast(r4, z.a.class, "com.obric.memorydata.plugin")).a().b(), ((z.a) ZeusTransformUtils.preCheckCast(r4, z.a.class, "com.obric.memorydata.plugin")).a().c());
            this.$biz.a(((z.a) ZeusTransformUtils.preCheckCast(r4, z.a.class, "com.obric.memorydata.plugin")).a().a(), ((z.a) ZeusTransformUtils.preCheckCast(r4, z.a.class, "com.obric.memorydata.plugin")).a().b());
        L25:
            return Unit.INSTANCE;
        L23:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startExportAsOldDevice: startSender SUCCESS", false, 4, null);
            goto L25
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            long r7 = this.J$0;
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r25);
            Object r6 = r25;
        L13:
            long r9 = r7;
            String r8 = r5;
            com.obric.memorydata.migration.sdk.b r13 = (com.obric.memorydata.migration.sdk.b) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.migration.sdk.b.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startExportAsOldDevice: backupConfig built -> " + DataTransferViewModel.access$summarizeBackupConfig(this.this$0, r13), false, 4, null);
            DataTransferViewModel.access$setExportScopeForUi$p(this.this$0, this.$exportSelection.d());
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startExportAsOldDevice: exportScopeForUi=" + DataTransferViewModel.access$getExportScopeForUi$p(this.this$0), false, 4, null);
            if (this.$exportSelection.a() == false) goto L16;
            List r10 = CollectionsKt.listOf(new com.obric.memorydata.migration.sdk.a(null, null, null, null, 15, null));
        L17:
            List r17 = r10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startExportAsOldDevice: addonCount=" + r17.size(), false, 4, null);
            n r11 = new n(this.$context, r13, null, (v) ZeusTransformUtils.preCheckCast(new u("migration_sender"), v.class, "com.obric.memorydata.plugin"), AppContext.INSTANCE.isDebug(), r17);
            DataTransferViewModel.access$setMigrationClient$p(this.this$0, r11);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startExportAsOldDevice: client created, calling startSender ...", false, 4, null);
            Integer r12 = DataTransferViewModel.access$getExportScopeForUi$p(this.this$0);
            final DataTransferViewModel r14 = this.this$0;
            final a r15 = this.$biz;
            m r16 = new $$Lambda$DataTransferViewModel$startExportAsOldDevice$1$i_2Dquo9BNoDYvqAoR0fGkuS1_s(r14, r15);
            Continuation<? super z<Unit>> r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 2;
            r3 = r11.a(r8, r9, r12, r16, r18);
            if (r3 != r1) goto L20;
            return r1;
        L16:
            r10 = CollectionsKt.emptyList();
            goto L17
        L10:
            ResultKt.throwOnFailure(r25);
            DataTransferViewModel.access$setLastTransferPercent$p(this.this$0, -1);
            r5 = AppContext.INSTANCE.getUserId();
            r7 = DataTransferViewModel.access$resolveMigrationAppVersionCode(this.this$0);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startExportAsOldDevice: begin, appVersionCode=" + r7 + ", includeMemoryData=" + this.$exportSelection.b() + ", includeTaskData=" + this.$exportSelection.a(), false, 4, null);
            CoroutineContext r19 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r110 = (Function2) ZeusTransformUtils.preCheckCast(new DataTransferViewModel$startExportAsOldDevice$1$backupConfig$1(this.$exportSelection, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r5;
            this.J$0 = r7;
            this.label = 1;
            r6 = i.a(r19, r110, r111);
            if (r6 != r1) goto L13;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.DataTransferViewModel$startImportAsNewDevice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferViewModel$startImportAsNewDevice$1", f = "DataTransferViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3}, l = {661, 674, 687, TypedValues.TransitionType.TYPE_STAGGERED, 731, 731}, m = "invokeSuspend", n = {"uid", "appVersionCode", "isLegacySingleDb", "uid", "baseBackupConfig", "publicDir", "appVersionCode", "uid", "baseBackupConfig", "publicDir", "receiverBackupConfig", "appVersionCode", "restoresSemantic", "syncSession"}, s = {"L$0", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "L$0"})
    static final class C12081 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $biz;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $qrText;
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ DataTransferViewModel this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.DataTransferViewModel$startImportAsNewDevice$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.migration.DataTransferViewModel$startImportAsNewDevice$1$2", f = "DataTransferViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
            final /* synthetic */ c $syncSession;
            int label;

            AnonymousClass2(c r3, Continuation<? super AnonymousClass2> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.$syncSession = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$syncSession, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return Boxing.boxBoolean(com.obric.memorydata.memory.contextsync.f.f10102a.b(this.$syncSession.a(), this.$syncSession.b()));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C12081(DataTransferViewModel r3, String r4, a r5, Context r6, Continuation<? super C12081> r7) {
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$qrText = r4;
            this.$biz = r8;
            this.$context = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
            super(2, r10);
        }

        private static final Integer invokeSuspend$lambda$0(DataTransferViewModel r0) {
            return DataTransferViewModel.access$getImportScopeForUi$p(r0);
        }

        private static final void invokeSuspend$lambda$5(c r2, DataTransferViewModel r3, a r4, p r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, p.e.class) == true) goto L5;
        L8:
            DataTransferViewModel.access$onSdkEvent(r3, r5, r6);
            return;
        L5:
            if (((p.e) ZeusTransformUtils.preCheckCast(r5, p.e.class, "com.obric.memorydata.plugin")).a() != MigrationStep.RESTORING) goto L8;
            if (r2 == null) goto L8;
            r2.a(true);
            goto L8
        }

        /* JADX INFO: renamed from: lambda$0jrt7NOtc-Ll2LI83fo5CcyXkjM, reason: not valid java name */
        public static /* synthetic */ Integer m963lambda$0jrt7NOtcLl2LI83fo5CcyXkjM(DataTransferViewModel r0) {
            return invokeSuspend$lambda$0(r0);
        }

        /* JADX INFO: renamed from: lambda$THNjsFMlkY1CvH0A8ZpyHm-piWk, reason: not valid java name */
        public static /* synthetic */ void m964lambda$THNjsFMlkY1CvH0A8ZpyHmpiWk(c r0, DataTransferViewModel r1, a r2, p r3) {
            invokeSuspend$lambda$5(r0, r1, r2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12081(this.this$0, this.$qrText, this.$biz, this.$context, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12081) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12081.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v71 */
        /* JADX WARN: Type inference failed for: r0v72 */
        /* JADX WARN: Type inference failed for: r11v18, types: [java.lang.StringBuilder] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r31) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Integer r6 = null;
            switch(this.label) {
                case 0: goto L16;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r31);
            throw r0;
        L7:
            ResultKt.throwOnFailure(r31);
        L93:
            return Unit.INSTANCE;
        L8:
            c r4 = (c) ZeusTransformUtils.preCheckCast(this.L$0, c.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r31);     // Catch: Throwable -> L11
            Object r1 = r31;
        L82:
            z r3 = (z) ZeusTransformUtils.preCheckCast(r1, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            if (ZeusTransformUtils.instanceOf(r3, z.a.class) == false) goto L85;
            RunLog.INSTANCE.error(DataTransferViewModel.TAG, "startImportAsNewDevice: startReceiverByQrText FAILED, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", msg=" + ((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.memorydata.plugin")).a().b(), ((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.memorydata.plugin")).a().c());     // Catch: Throwable -> L11
            this.$biz.a(((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.memorydata.plugin")).a().a(), ((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.memorydata.plugin")).a().b());     // Catch: Throwable -> L11
        L86:
            if (r4 == null) goto L93;
            if (r4.c() == true) goto L93;
            CoroutineContext r5 = ck.f17296b.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
            Function2 r7 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 5;
            if (i.a(r5, r7, r8) != r2) goto L93;
            return r2;
        L85:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startImportAsNewDevice: startReceiverByQrText SUCCESS", false, 4, null);     // Catch: Throwable -> L11
        L11:
            th = th;
        L96:
            if (r4 != null) goto L98;
            throw th;
        L98:
            if (r4.c() == true) goto L115;
            CoroutineContext r9 = ck.f17296b.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
            Function2 r10 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = th;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 6;
            if (i.a(r9, r10, r11) != r2) goto L116;
            return r2;
        L116:
            throw th;
        L115:
            throw th;
        L13:
            int r12 = this.I$0;
            long r13 = this.J$0;
            com.obric.memorydata.migration.sdk.b r14 = (com.obric.memorydata.migration.sdk.b) ZeusTransformUtils.preCheckCast(this.L$3, com.obric.memorydata.migration.sdk.b.class, "com.obric.memorydata.plugin");
            File r15 = (File) ZeusTransformUtils.preCheckCast(this.L$2, File.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.migration.sdk.b r16 = (com.obric.memorydata.migration.sdk.b) ZeusTransformUtils.preCheckCast(this.L$1, com.obric.memorydata.migration.sdk.b.class, "com.obric.memorydata.plugin");
            String r17 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r31);
            Object r18 = r31;
        L70:
            String r19 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin");
            File r110 = r15;
            com.obric.memorydata.migration.sdk.b r111 = r16;
            long r28 = r13;
            int r20 = r12;
            com.obric.memorydata.migration.sdk.b r21 = r14;
            long r22 = r28;
        L72:
            if (r20 == 0) goto L75;
            if (r19 != null) goto L75;
            this.$biz.a(MigrationErrorCode.OTHER, "无法保存记忆同步迁移进度，请重试");
        L23:
            return Unit.INSTANCE;
        L75:
            if (r19 == null) goto L77;
            final c r23 = new c(r17, r19);
        L103:
            n r24 = new n(this.$context, r111, DataTransferViewModel.access$buildPostRestoreHook(this.this$0, r17, r19), (v) ZeusTransformUtils.preCheckCast(new u("migration_receiver"), v.class, "com.obric.memorydata.plugin"), AppContext.INSTANCE.isDebug(), CollectionsKt.listOf(new com.obric.memorydata.migration.sdk.a(null, null, null, null, 15, null)));     // Catch: Throwable -> L94
            DataTransferViewModel.access$setMigrationClient$p(this.this$0, r24);     // Catch: Throwable -> L94
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startImportAsNewDevice: client created, calling startReceiver...", false, 4, null);     // Catch: Throwable -> L94
            String r112 = this.$qrText;     // Catch: Throwable -> L94
            n.a r25 = new n.a(r110, null, r21, 2, null);     // Catch: Throwable -> L94
            final DataTransferViewModel r26 = this.this$0;     // Catch: Throwable -> L94
            final a r113 = this.$biz;     // Catch: Throwable -> L94
            m r114 = new $$Lambda$DataTransferViewModel$startImportAsNewDevice$1$THNjsFMlkY1CvH0A8ZpyHmpiWk(r23, r26, r113);     // Catch: Throwable -> L94
            Continuation<? super z<Unit>> r27 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L94
            this.L$0 = r23;     // Catch: Throwable -> L94
            this.L$1 = null;     // Catch: Throwable -> L94
            this.L$2 = null;     // Catch: Throwable -> L94
            this.L$3 = null;     // Catch: Throwable -> L94
            this.label = 4;     // Catch: Throwable -> L94
            r1 = r24.a(r112, r17, r22, true, r25, r114, r27);     // Catch: Throwable -> L94
            if (r1 != r2) goto L81;
            return r2;
        L81:
            r4 = r23;
        L94:
            th = th;
            r4 = r23;
            goto L96
        L77:
            r23 = null;
            goto L103
        L14:
            r22 = this.J$0;
            File r29 = (File) ZeusTransformUtils.preCheckCast(this.L$2, File.class, "com.obric.memorydata.plugin");
            r16 = (com.obric.memorydata.migration.sdk.b) ZeusTransformUtils.preCheckCast(this.L$1, com.obric.memorydata.migration.sdk.b.class, "com.obric.memorydata.plugin");
            r17 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r31);
            Object r30 = r31;
        L39:
            r21 = (com.obric.memorydata.migration.sdk.b) ZeusTransformUtils.preCheckCast(r30, com.obric.memorydata.migration.sdk.b.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startImportAsNewDevice: receiverBackupConfig (after trim) -> " + DataTransferViewModel.access$summarizeBackupConfig(this.this$0, r21), false, 4, null);
            Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r21.a(), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r32, Collection.class) == true) goto L42;
        L44:
            Iterator r33 = r32.iterator();
        L46:
            if (r33.hasNext() == false) goto L43;
            com.obric.memorydata.migration.sdk.g r115 = (com.obric.memorydata.migration.sdk.g) ZeusTransformUtils.preCheckCast(r33.next(), com.obric.memorydata.migration.sdk.g.class, "com.obric.memorydata.plugin");
            if (r115.b() != DbRole.USER) goto L62;
            Iterable r116 = (Iterable) ZeusTransformUtils.preCheckCast(r115.c(), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r116, Collection.class) == true) goto L52;
        L54:
            Iterator r117 = r116.iterator();
        L56:
            if (r117.hasNext() == false) goto L53;
            if (Intrinsics.areEqual(((ai) ZeusTransformUtils.preCheckCast(r117.next(), ai.class, "com.obric.memorydata.plugin")).a(), "UnionSemanticMemory") == false) goto L56;
            boolean r118 = true;
        L60:
            if (r118 == false) goto L62;
            boolean r119 = true;
        L63:
            if (r119 == false) goto L46;
            r20 = 1;
        L65:
            if (r20 == 0) goto L71;
            CoroutineContext r120 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r121 = (Function2) ZeusTransformUtils.preCheckCast(new DataTransferViewModel$startImportAsNewDevice$1$syncToken$1(r17, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r122 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r17;
            this.L$1 = r16;
            this.L$2 = r29;
            this.L$3 = r21;
            this.J$0 = r22;
            this.I$0 = r20;
            this.label = 3;
            r18 = i.a(r120, r121, r122);
            if (r18 != r2) goto L69;
            return r2;
        L69:
            long r210 = r22;
            r15 = r29;
            r14 = r21;
            r12 = r20;
            r13 = r210;
            goto L70
        L71:
            r110 = r29;
            r19 = null;
            r111 = r16;
        L53:
            r118 = false;
            goto L60
        L52:
            if (((Collection) ZeusTransformUtils.preCheckCast(r116, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L54;
        L62:
            r119 = false;
        L43:
            r20 = 0;
            goto L65
        L42:
            if (((Collection) ZeusTransformUtils.preCheckCast(r32, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L44;
        L15:
            int r34 = this.I$0;
            r22 = this.J$0;
            String r123 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r31);
            Object r124 = r31;
            ?? r35 = r34;
        L31:
            com.obric.memorydata.migration.sdk.b r125 = (com.obric.memorydata.migration.sdk.b) ZeusTransformUtils.preCheckCast(r124, com.obric.memorydata.migration.sdk.b.class, "com.obric.memorydata.plugin");
            IRunLog r126 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r127 = new StringBuilder().append("startImportAsNewDevice: baseBackupConfig built (legacy=");
            if (r35 == 0) goto L34;
            boolean r36 = true;
        L35:
            IRunLog.a.a(r126, DataTransferViewModel.TAG, r127.append(r36).append(") -> ").append(DataTransferViewModel.access$summarizeBackupConfig(this.this$0, r125)).toString(), false, 4, null);
            r29 = new File(this.$context.getFilesDir(), "MemoryImage");
            r29.mkdirs();
            boolean r128 = b.a(DataTransferViewModel.Companion);
            boolean r129 = b.b(DataTransferViewModel.Companion);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startImportAsNewDevice: lab switches -> screenEnabled=" + r128 + ", autoEnabled=" + r129, false, 4, null);
            CoroutineContext r130 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r37 = (Function2) ZeusTransformUtils.preCheckCast(new DataTransferViewModel$startImportAsNewDevice$1$receiverBackupConfig$1(this.this$0, r125, r128, r129, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r131 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r123;
            this.L$1 = r125;
            this.L$2 = r29;
            this.J$0 = r22;
            this.label = 2;
            r30 = i.a(r130, r37, r131);
            if (r30 != r2) goto L38;
            return r2;
        L38:
            r17 = r123;
            r16 = r125;
            goto L39
        L34:
            r36 = false;
            goto L35
        L16:
            ResultKt.throwOnFailure(r31);
            DataTransferViewModel.access$setLastTransferPercent$p(this.this$0, -1);
            DataTransferViewModel r38 = this.this$0;
            final DataTransferViewModel r39 = this.this$0;
            DataTransferViewModel.access$setImportTracker$p(r38, new DataMigrationImportTracker(0, new $$Lambda$DataTransferViewModel$startImportAsNewDevice$1$0jrt7NOtcLl2LI83fo5CcyXkjM(r39), 1, null));
            r123 = AppContext.INSTANCE.getUserId();
            r22 = DataTransferViewModel.access$resolveMigrationAppVersionCode(this.this$0);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startImportAsNewDevice: begin, appVersionCode=" + r22, false, 4, null);
            z<QrPayload> r40 = r.f11979a.a(this.$qrText, r123, r22);
            if (ZeusTransformUtils.instanceOf(r40, z.a.class) == false) goto L24;
            DataTransferViewModel r41 = this.this$0;
            QrPayload r42 = r.f11979a.a(this.$qrText);
            if (r42 == null) goto L21;
            r6 = r42.getExportScope();
        L21:
            DataTransferViewModel.access$setImportScopeForUi$p(r41, r6);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startImportAsNewDevice: verifyPrecondition FAILED, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r40, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", msg=" + ((z.a) ZeusTransformUtils.preCheckCast(r40, z.a.class, "com.obric.memorydata.plugin")).a().b() + ", importScopeForUi=" + DataTransferViewModel.access$getImportScopeForUi$p(this.this$0), null, 4, null);
            this.$biz.a(((z.a) ZeusTransformUtils.preCheckCast(r40, z.a.class, "com.obric.memorydata.plugin")).a().a(), ((z.a) ZeusTransformUtils.preCheckCast(r40, z.a.class, "com.obric.memorydata.plugin")).a().b());
            goto L23
        L24:
            Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type com.obric.memorydata.migration.sdk.MigrationResult.Success<com.obric.memorydata.migration.sdk.QrPayload>");
            QrPayload r43 = (QrPayload) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r40, z.b.class, "com.obric.memorydata.plugin")).a(), QrPayload.class, "com.obric.memorydata.plugin");
            DataTransferViewModel.access$setImportScopeForUi$p(this.this$0, r43.getExportScope());
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startImportAsNewDevice: verifyPrecondition OK, importScopeForUi=" + DataTransferViewModel.access$getImportScopeForUi$p(this.this$0), false, 4, null);
            long r132 = r43.getSenderAppVersionCode();
            if (r132 >= DataTransferViewModel.DUAL_DB_MIN_APP_VERSION_CODE) goto L27;
            ?? r44 = 1;
        L28:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransferViewModel.TAG, "startImportAsNewDevice: version gate -> senderAppVersionCode=" + r132 + ",  isLegacySingleDb=" + r44, false, 4, null);
            CoroutineContext r133 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r134 = (Function2) ZeusTransformUtils.preCheckCast(new DataTransferViewModel$startImportAsNewDevice$1$baseBackupConfig$1(r44, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r135 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r123;
            this.J$0 = r22;
            this.I$0 = r44;
            this.label = 1;
            r124 = i.a(r133, r134, r135);
            r35 = r44;
            if (r124 != r2) goto L31;
            return r2;
        L27:
            r44 = 0;
            goto L28
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new b(null);
    }

    public DataTransferViewModel() {
        this.bizCallback$delegate = LazyKt.lazy(new $$Lambda$DataTransferViewModel$G0aSTGE0n0CRD_7UV6Umvsd30(this));
        this.SIZE_RE = new Regex("^\\s*(\\d+(?:\\.\\d+)?)\\s*(MB|GB)\\s*$", RegexOption.IGNORE_CASE);
        this.isExport = true;
        this.lastTransferPercent = -1;
        ae<com.obric.memorydata.memory.ui.migration.b> r0 = at.a(null);
        this._uiState = r0;
        this.uiState = k.a(r0);
    }

    public static final /* synthetic */ com.obric.memorydata.migration.sdk.b access$buildLegacySingleDbBackupConfig(DataTransferViewModel r0) {
        return r0.buildLegacySingleDbBackupConfig();
    }

    public static final /* synthetic */ com.obric.memorydata.migration.sdk.b access$buildMigrationBackupConfig(DataTransferViewModel r0) {
        return r0.buildMigrationBackupConfig();
    }

    public static final /* synthetic */ ab access$buildPostRestoreHook(DataTransferViewModel r0, String r1, String r2) {
        return r0.buildPostRestoreHook(r1, r2);
    }

    public static final /* synthetic */ com.obric.memorydata.migration.sdk.b access$buildReceiverBackupConfig(DataTransferViewModel r0, com.obric.memorydata.migration.sdk.b r1, boolean r2, boolean r3) {
        return r0.buildReceiverBackupConfig(r1, r2, r3);
    }

    public static final /* synthetic */ Integer access$getExportScopeForUi$p(DataTransferViewModel r0) {
        return r0.exportScopeForUi;
    }

    public static final /* synthetic */ Integer access$getImportScopeForUi$p(DataTransferViewModel r0) {
        return r0.importScopeForUi;
    }

    public static final /* synthetic */ DataMigrationImportTracker access$getImportTracker$p(DataTransferViewModel r0) {
        return r0.importTracker;
    }

    public static final /* synthetic */ MigrationStep access$getLastErrorStep$p(DataTransferViewModel r0) {
        return r0.lastErrorStep;
    }

    public static final /* synthetic */ boolean access$getUserCancelled$p(DataTransferViewModel r0) {
        return r0.userCancelled;
    }

    public static final /* synthetic */ ae access$get_uiState$p(DataTransferViewModel r0) {
        return r0._uiState;
    }

    public static final /* synthetic */ void access$onSdkEvent(DataTransferViewModel r2, p r3, a r4) {
        r2.onSdkEvent(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$reportImportFailure(DataTransferViewModel r0, DataMigrationImportTracker.FailReason r1) {
        r0.reportImportFailure(r1);
    }

    public static final /* synthetic */ long access$resolveMigrationAppVersionCode(DataTransferViewModel r2) {
        return r2.resolveMigrationAppVersionCode();
    }

    public static final /* synthetic */ void access$setExportScopeForUi$p(DataTransferViewModel r0, Integer r1) {
        r0.exportScopeForUi = r1;
    }

    public static final /* synthetic */ void access$setImportScopeForUi$p(DataTransferViewModel r0, Integer r1) {
        r0.importScopeForUi = r1;
    }

    public static final /* synthetic */ void access$setImportTracker$p(DataTransferViewModel r0, DataMigrationImportTracker r1) {
        r0.importTracker = r1;
    }

    public static final /* synthetic */ void access$setLastTransferPercent$p(DataTransferViewModel r0, int r1) {
        r0.lastTransferPercent = r1;
    }

    public static final /* synthetic */ void access$setMigrationClient$p(DataTransferViewModel r0, n r1) {
        r0.migrationClient = r1;
    }

    public static final /* synthetic */ String access$summarizeBackupConfig(DataTransferViewModel r0, com.obric.memorydata.migration.sdk.b r1) {
        return r0.summarizeBackupConfig(r1);
    }

    public static final /* synthetic */ DataMigrationImportTracker.FailReason access$toImportFailReason(DataTransferViewModel r0, MigrationErrorCode r1) {
        return r0.toImportFailReason(r1);
    }

    private static final d bizCallback_delegate$lambda$0(DataTransferViewModel r1) {
        return new d(r1);
    }

    private final com.obric.memorydata.migration.sdk.b buildLegacySingleDbBackupConfig() {
        List<ai> r0 = globalBackupTables();
        List<ai> r1 = userBaseBackupTablesLegacy();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r4.add(((ai) ZeusTransformUtils.preCheckCast(r3.next(), ai.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        List<ai> r11 = discoverFkChildTables((Set) ZeusTransformUtils.preCheckCast((LinkedHashSet) ZeusTransformUtils.preCheckCast(r4, LinkedHashSet.class, "com.obric.memorydata.plugin"), Set.class, "com.obric.memorydata.plugin"));
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(w.f8834a.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r6.add(((x) ZeusTransformUtils.preCheckCast(r7.next(), x.class, "com.obric.memorydata.plugin")).f().getTableName());
        goto L8
    L10:
        LinkedHashSet r8 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r6, LinkedHashSet.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r9.iterator();
    L12:
        if (r12.hasNext() == false) goto L16;
        Object r13 = r12.next();
        if (r8.contains(((ai) ZeusTransformUtils.preCheckCast(r13, ai.class, "com.obric.memorydata.plugin")).a()) == true) goto L12;
        r10.add(r13);
        goto L12
    L16:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L18:
        if (r17.hasNext() == false) goto L22;
        Object r18 = r17.next();
        if (r8.contains(((ai) ZeusTransformUtils.preCheckCast(r18, ai.class, "com.obric.memorydata.plugin")).a()) == false) goto L18;
        r16.add(r18);
        goto L18
    L22:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
        return new com.obric.memorydata.migration.sdk.b(CollectionsKt.listOf(new com.obric.memorydata.migration.sdk.g[]{new com.obric.memorydata.migration.sdk.g(MemoryDbEngine.ENCRYPT_DB_NAME, DbRole.GLOBAL, r14, null, 8, null), new com.obric.memorydata.migration.sdk.g(MemoryDbEngine.USER_LOGIC_DB_NAME, DbRole.USER, r19, MemoryDbEngine.ENCRYPT_DB_NAME)}), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    private final com.obric.memorydata.migration.sdk.b buildMigrationBackupConfig() {
        List<ai> r3 = globalBackupTables();
        List<ai> r7 = userBaseBackupTables();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((ai) ZeusTransformUtils.preCheckCast(r2.next(), ai.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        List<ai> r10 = discoverFkChildTables((Set) ZeusTransformUtils.preCheckCast((LinkedHashSet) ZeusTransformUtils.preCheckCast(r1, LinkedHashSet.class, "com.obric.memorydata.plugin"), Set.class, "com.obric.memorydata.plugin"));
        return new com.obric.memorydata.migration.sdk.b(CollectionsKt.listOf(new com.obric.memorydata.migration.sdk.g[]{new com.obric.memorydata.migration.sdk.g(MemoryDbEngine.ENCRYPT_DB_NAME, DbRole.GLOBAL, r3, null, 8, null), new com.obric.memorydata.migration.sdk.g(MemoryDbEngine.USER_LOGIC_DB_NAME, DbRole.USER, CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), null, 8, null)}), CollectionsKt.emptyList(), buildMigrationKvRepos());
    }

    private final List<j> buildMigrationKvRepos() {
        return CollectionsKt.listOf(new j(UserSettings.REPO_MEMORY_DATA, CollectionsKt.listOf(new com.obric.memorydata.migration.sdk.i[]{new com.obric.memorydata.migration.sdk.i("is_refresh_screen_memory_validate_day_ota", KvValueType.BOOLEAN), new com.obric.memorydata.migration.sdk.i("last_open_screen_memory_switch_time_stamp", KvValueType.LONG), new com.obric.memorydata.migration.sdk.i("screen_memory_validate_day", KvValueType.LONG), new com.obric.memorydata.migration.sdk.i("validate_screen_memory_open_status", KvValueType.BOOLEAN)})));
    }

    private final ab buildPostRestoreHook(String r1, String r2) {
        return (ab) ZeusTransformUtils.preCheckCast(new f(r1, r2), ab.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.migration.sdk.b buildReceiverBackupConfig(com.obric.memorydata.migration.sdk.b r20, boolean r21, boolean r22) {
        Set r0 = SetsKt.createSetBuilder();
        if (r21 == true) goto L5;
        r0.add(1001);
        r0.add(0);
    L5:
        if (r22 == true) goto L7;
        r0.add(1004);
    L7:
        Set r1 = SetsKt.build(r0);
        Set r2 = SetsKt.setOf(new String[]{"EpisodicTopicMemory", "BlockMemoryContent"});
        Set r3 = SetsKt.setOf(new String[]{"AutoMemoryPro", "MemoryRule"});
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r20.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L53;
        com.obric.memorydata.migration.sdk.g r7 = (com.obric.memorydata.migration.sdk.g) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.memorydata.migration.sdk.g.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L51;
        ai r12 = (ai) ZeusTransformUtils.preCheckCast(r9.next(), ai.class, "com.obric.memorydata.plugin");
        String r11 = r12.a();
        ai r13 = null;
        if (r21 == false) goto L16;
    L18:
        if (r22 == false) goto L20;
    L22:
        int r14 = r11.hashCode();
        if (r14 == (-1855420291)) goto L42;
        if (r14 == (-494460608)) goto L36;
        if (r14 == 108429046) goto L30;
    L48:
        r13 = r12;
    L49:
        if (r13 == null) goto L12;
        r10.add(r13);
        goto L12
    L30:
        if (r11.equals("UnionSemanticMemory") == false) goto L48;
        String r15 = null;
        String r16 = buildReceiverBackupConfig$productTypeFilteredSelect(r1, r11, "product_type");
        if (r16 != null) goto L47;
        r16 = r12.b();
    L47:
        r12 = ai.a(r12, r15, r16, null, false, 13, null);
        goto L48
    L36:
        if (r11.equals("ProactiveSemanticRelevantData") == false) goto L48;
        r15 = null;
        r16 = buildReceiverBackupConfig$proactiveSemanticRelevantFilteredSelect(r1, "product_type");
        if (r16 != null) goto L47;
        r16 = r12.b();
        goto L47
    L42:
        if (r11.equals("ShortMemory") == false) goto L48;
        r15 = null;
        r16 = buildReceiverBackupConfig$productTypeFilteredSelect(r1, r11, "productType");
        if (r16 != null) goto L47;
        r16 = r12.b();
        goto L47
    L20:
        if (r3.contains(r11) == false) goto L22;
    L16:
        if (r2.contains(r11) == false) goto L18;
    L51:
        r5.add(com.obric.memorydata.migration.sdk.g.a(r7, null, null, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), null, 11, null));
        goto L9
    L53:
        return com.obric.memorydata.migration.sdk.b.a(r20, (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    }

    private static final String buildReceiverBackupConfig$proactiveSemanticRelevantFilteredSelect(Set<Integer> r11, String r12) {
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if (r13.isEmpty() == false) goto L7;
        return null;
    L7:
        return "SELECT * FROM `ProactiveSemanticRelevantData` WHERE `semantic_id` IN (SELECT `entityId` FROM `UnionSemanticMemory` WHERE `" + r12 + "` NOT IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + "))";
    }

    private static final String buildReceiverBackupConfig$productTypeFilteredSelect(Set<Integer> r11, String r12, String r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L7;
        return null;
    L7:
        return "SELECT * FROM `" + r12 + "` WHERE `" + r13 + "` NOT IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')';
    }

    private final List<ai> discoverFkChildTables(Set<String> r10) {
        final Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        List r9 = SequencesKt.toList(SequencesKt.sorted(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(discoverForeignKeyChildren(SetsKt.setOf(new String[]{"ShortMemory", "UnionSemanticMemory"})), Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$DataTransferViewModel$5jS04FXIOdqKqTXOqNqGlFpvyAA(r11))));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "migration auto-add child tables by FK: count=" + r9.size() + ", tables=" + r9, false, 4, null);
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13.add(new ai((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), null, null, true, 6, null));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    }

    private static final boolean discoverFkChildTables$lambda$3(Set r2, String r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return !r4.contains(r3);
    }

    private final Set<String> discoverForeignKeyChildren(Set<String> r11) {
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L47
        DataTransferViewModel r10 = (DataTransferViewModel) ZeusTransformUtils.preCheckCast(this, DataTransferViewModel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        SupportSQLiteDatabase r13 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getReadableDatabase();     // Catch: Throwable -> L47
        Set r1 = SetsKt.createSetBuilder();     // Catch: Throwable -> L47
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r13.query("SELECT name FROM sqlite_master WHERE type='table'"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        int r4 = r3.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L42
    L6:
        if (r3.moveToNext() == false) goto L19;
        String r5 = r3.getString(r4);     // Catch: Throwable -> L42
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        if (Intrinsics.areEqual(r5, "android_metadata") == true) goto L6;
        if (Intrinsics.areEqual(r5, "room_master_table") == true) goto L6;
        if (StringsKt.startsWith$default(r5, "sqlite_", false, 2, null) == true) goto L6;
        r1.add(r5);     // Catch: Throwable -> L42
        goto L6
    L19:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L47
        Set r7 = SetsKt.build(r1);     // Catch: Throwable -> L47
        Set r8 = SetsKt.createSetBuilder();     // Catch: Throwable -> L47
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L47
    L22:
        if (r9.hasNext() == false) goto L40;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(r13.query("PRAGMA foreign_key_list(`" + r14 + "`)"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Cursor r16 = (Cursor) ZeusTransformUtils.preCheckCast(r15, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        int r17 = r16.getColumnIndex("table");     // Catch: Throwable -> L35
    L26:
        if (r16.moveToNext() == false) goto L32;
        String r18 = r16.getString(r17);     // Catch: Throwable -> L35
        if (r18 == null) goto L26;
        if (r12.contains(r18) == false) goto L26;
        r8.add(r14);     // Catch: Throwable -> L35
    L32:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L35
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L47
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L40:
        Set r110 = SetsKt.build(r8);     // Catch: Throwable -> L47
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "discoverForeignKeyChildren: parents=" + r12 + ", scannedTables=" + r7.size() + ", fkChildrenCount=" + r110.size() + ", fkChildren=" + CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")), false, 4, null);     // Catch: Throwable -> L47
        Object r111 = Result.m1421constructorimpl(r110);     // Catch: Throwable -> L47
    L49:
        Throwable r112 = Result.m1424exceptionOrNullimpl(r111);
        if (r112 == null) goto L54;
        RunLog.INSTANCE.error(TAG, "migration discoverForeignKeyChildren failed", r112);
        r111 = SetsKt.emptySet();
    L54:
        return (Set) ZeusTransformUtils.preCheckCast(r111, Set.class, "com.obric.memorydata.plugin");
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L49
    }

    private final a getBizCallback() {
        return (a) ZeusTransformUtils.preCheckCast(this.bizCallback$delegate.getValue(), a.class, "com.obric.memorydata.plugin");
    }

    private final List<ai> globalBackupTables() {
        return CollectionsKt.listOf(new ai("RawMemoryEntity", null, null, true, 6, null));
    }

    public static /* synthetic */ boolean lambda$5jS04FXIOdqKqTXOqNqGlFpvyAA(Set r0, String r1) {
        return discoverFkChildTables$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$G0aSTGE0n0CRD_7-UV6Umvs-d30, reason: not valid java name */
    public static /* synthetic */ d m962lambda$G0aSTGE0n0CRD_7UV6Umvsd30(DataTransferViewModel r0) {
        return bizCallback_delegate$lambda$0(r0);
    }

    public static /* synthetic */ CharSequence lambda$GmQVhO0lFwPV1v2cczWWb1OqefY(ai r0) {
        return summarizeBackupConfig$lambda$24$lambda$23(r0);
    }

    public static /* synthetic */ CharSequence lambda$vQLqcxgQ1TJU5Tf9VAuSABHc59I(com.obric.memorydata.migration.sdk.g r0) {
        return summarizeBackupConfig$lambda$24(r0);
    }

    private final void onSdkEvent(p r7, a r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, p.d.class) == false) goto L10;
        com.obric.memorydata.memory.ui.migration.b r6 = (com.obric.memorydata.memory.ui.migration.b) ZeusTransformUtils.preCheckCast(this._uiState.c(), com.obric.memorydata.memory.ui.migration.b.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
    L8:
        r9.a(((p.d) ZeusTransformUtils.preCheckCast(r7, p.d.class, "com.obric.memorydata.plugin")).a());
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.migration.b.g.class) == true) goto L8;
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, p.e.class) == false) goto L13;
        r9.a(((p.e) ZeusTransformUtils.preCheckCast(r7, p.e.class, "com.obric.memorydata.plugin")).a(), ((p.e) ZeusTransformUtils.preCheckCast(r7, p.e.class, "com.obric.memorydata.plugin")).b());
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, p.c.class) == false) goto L20;
        if (((p.c) ZeusTransformUtils.preCheckCast(r7, p.c.class, "com.obric.memorydata.plugin")).a() == MigrationStep.TRANSFERRING) goto L17;
        return;
    L17:
        if (((p.c) ZeusTransformUtils.preCheckCast(r7, p.c.class, "com.obric.memorydata.plugin")).d() == this.lastTransferPercent) goto L27;
        this.lastTransferPercent = ((p.c) ZeusTransformUtils.preCheckCast(r7, p.c.class, "com.obric.memorydata.plugin")).d();
        Pair<String, String> r10 = r.f11979a.a(((p.c) ZeusTransformUtils.preCheckCast(r7, p.c.class, "com.obric.memorydata.plugin")).b(), ((p.c) ZeusTransformUtils.preCheckCast(r7, p.c.class, "com.obric.memorydata.plugin")).c());
        r9.a((String) ZeusTransformUtils.preCheckCast(r10.component1(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r10.component2(), String.class, "com.obric.memorydata.plugin"), ((p.c) ZeusTransformUtils.preCheckCast(r7, p.c.class, "com.obric.memorydata.plugin")).d());
        return;
    L27:
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r7, p.b.class) == false) goto L29;
        this.lastErrorStep = ((p.b) ZeusTransformUtils.preCheckCast(r7, p.b.class, "com.obric.memorydata.plugin")).a();
        r9.a(((p.b) ZeusTransformUtils.preCheckCast(r7, p.b.class, "com.obric.memorydata.plugin")).b().a(), ((p.b) ZeusTransformUtils.preCheckCast(r7, p.b.class, "com.obric.memorydata.plugin")).b().b());
        return;
    }

    private final void reportImportFailure(DataMigrationImportTracker.FailReason r2) {
        if (this.isExport == true) goto L8;
        DataMigrationImportTracker r1 = this.importTracker;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    L9:
        return;
    }

    private final long resolveMigrationAppVersionCode() {
        int r2 = SharedState.INSTANCE.getInt("doubao_version_code", BuildConfig.PLUGIN_VERSION_CODE);
        if (r2 != BuildConfig.PLUGIN_VERSION_CODE) goto L6;
        r2 = r2 / 10;
    L6:
        return r2;
    }

    private final String summarizeBackupConfig(com.obric.memorydata.migration.sdk.b r12) {
        return "BackupConfig(dbCount=" + r12.a().size() + ", extraFiles=" + r12.b().size() + ", dbs=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r12.a(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$DataTransferViewModel$vQLqcxgQ1TJU5Tf9VAuSABHc59I.INSTANCE, 30, null) + ')';
    }

    private static final CharSequence summarizeBackupConfig$lambda$24(com.obric.memorydata.migration.sdk.g r12) {
        Intrinsics.checkNotNullParameter(r12, "db");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((ai) ZeusTransformUtils.preCheckCast(r2.next(), ai.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        List r3 = CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r12.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(((ai) ZeusTransformUtils.preCheckCast(r7, ai.class, "com.obric.memorydata.plugin")).b(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L12;
    L15:
        boolean r9 = true;
    L17:
        if ((!r9) == false) goto L8;
        r5.add(r7);
        goto L8
    L12:
        if (StringsKt.isBlank(r8) == true) goto L15;
        r9 = false;
        goto L17
    L20:
        return (CharSequence) ZeusTransformUtils.preCheckCast("[db=" + r12.a() + ", role=" + r12.b() + ", tableCount=" + r3.size() + ", tables=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ", exportSQL={" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new g(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ; ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$DataTransferViewModel$GmQVhO0lFwPV1v2cczWWb1OqefY.INSTANCE, 30, null) + "}]", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence summarizeBackupConfig$lambda$24$lambda$23(ai r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a() + '=' + r2.b(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final DataMigrationImportTracker.FailReason toImportFailReason(MigrationErrorCode r1) {
        switch(e.f11360a[r1.ordinal()]) {
            case 1: goto L9;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L10:
        return DataMigrationImportTracker.FailReason.OTHER;
    L11:
        return DataMigrationImportTracker.FailReason.TRANSFER_ERROR;
    L9:
        return DataMigrationImportTracker.FailReason.VERSION_TOO_LOW;
    }

    private final List<ai> userBaseBackupTables() {
        return CollectionsKt.listOf(new ai[]{new ai("UserKeyword", null, null, false, 14, null), new ai("UnionSemanticMemory", null, null, true, 6, null), new ai("UserKeywordRef", null, null, false, 14, null), new ai("SemanticRetraction", null, null, false, 14, null), new ai("UnionSemanticMemoryExt", null, null, false, 14, null), new ai("ProactiveEpisodicRelevantData", null, null, true, 6, null), new ai("GlassesEpisodicRelevantData", null, null, false, 14, null), new ai("ProactiveSemanticRelevantData", null, null, true, 6, null), new ai("RawMemoryEntityCorrelation", null, null, false, 14, null), new ai("MemoryKeyInfoEntity", null, null, false, 14, null), new ai("ShortMemory", null, null, true, 6, null), new ai("EpisodicTopicMemory", null, null, false, 14, null), new ai("AutoMemoryPro", null, null, false, 14, null), new ai("PendingMemoryCalendar", null, null, false, 14, null), new ai("BlockMemoryContent", null, null, false, 14, null), new ai("MemoryRule", null, null, false, 14, null), new ai("AutoMemoryProSlmPersonalInfo", null, null, true, 6, null), new ai("AutoMemoryProSlmEpisodicMemory", null, null, true, 6, null), new ai("MemoryBaseRequirement", null, null, true, 6, null), new ai("MemoryBaseScene", null, null, true, 6, null), new ai("UnionUserPersona", null, null, true, 6, null), new ai("SlmAutoMemoryProTempResult", null, null, true, 6, null), new ai("SlmAgentWatermark", null, null, true, 6, null), new ai("Lifelog", null, null, true, 6, null), new ai("AutoMemoryEpisodicRelevantData", null, null, true, 6, null), new ai("UserProfileEntityTextVectorCopilot", null, null, true, 6, null), new ai("RawUserProfileEntity", null, null, true, 6, null), new ai("RawUserProfileHistoryEntity", null, null, true, 6, null), new ai("ShortMemoryContentTime", null, null, true, 6, null), new ai("UnionSemanticMemoryHistoryEntity", null, null, true, 6, null), new ai("SemanticTextCopilot", null, null, true, 6, null), new ai("UnionUserInsight", null, null, true, 6, null), new ai("AutoMemorySemanticRelevantData", null, null, true, 6, null), new ai("MemorySourceEpisodicImageRelation", null, null, false, 14, null), new ai("MemorySourceSemanticImageRelation", null, null, false, 14, null), new ai("PersonProfile", null, null, false, 14, null), new ai("PersonAudioProfile", null, null, false, 14, null), new ai("PersonImageProfile", null, null, false, 14, null)});
    }

    private final List<ai> userBaseBackupTablesLegacy() {
        return CollectionsKt.listOf(new ai[]{new ai("UnionSemanticMemory", null, null, true, 6, null), new ai("UnionSemanticMemoryExt", null, null, false, 14, null), new ai("ProactiveEpisodicRelevantData", null, null, true, 6, null), new ai("ProactiveSemanticRelevantData", null, null, true, 6, null), new ai("RawMemoryEntityCorrelation", null, null, false, 14, null), new ai("MemoryKeyInfoEntity", null, null, false, 14, null), new ai("ShortMemory", null, null, true, 6, null), new ai("EpisodicTopicMemory", null, null, false, 14, null), new ai("AutoMemoryPro", null, null, false, 14, null), new ai("PendingMemoryCalendar", null, null, false, 14, null), new ai("BlockMemoryContent", null, null, false, 14, null), new ai("MemoryRule", null, null, false, 14, null), new ai("UserKeyword", null, null, false, 14, null)});
    }

    public final void cancelByUser() {
        this.userCancelled = true;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        n r2 = ((DataTransferViewModel) ZeusTransformUtils.preCheckCast(this, DataTransferViewModel.class, "com.obric.memorydata.plugin")).migrationClient;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.a();     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L9
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    public final ar<com.obric.memorydata.memory.ui.migration.b> getUiState() {
        return this.uiState;
    }

    public final void initInitialState(String r3, com.obric.memorydata.memory.ui.migration.a r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "exportSelection");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (this._uiState.c() == null) goto L5;
        return;
    L5:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        startExportAsOldDevice(getBizCallback(), r6, r4);
        return;
    L14:
        this.isExport = false;
        startImportAsNewDevice(r3, getBizCallback(), r6);
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public final boolean isExport() {
        return this.isExport;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        n r2 = ((DataTransferViewModel) ZeusTransformUtils.preCheckCast(this, DataTransferViewModel.class, "com.obric.memorydata.plugin")).migrationClient;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        r2.a();     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L9
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    public final Pair<Double, String> parseSizeNumberAndUnit(String r5) {
        Intrinsics.checkNotNullParameter(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        MatchResult r4 = this.SIZE_RE.matchEntire((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r4 != null) goto L5;
        return null;
    L5:
        Double r0 = StringsKt.toDoubleOrNull((String) ZeusTransformUtils.preCheckCast(r4.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L9;
        double r2 = r0.doubleValue();
        String r6 = ((String) ZeusTransformUtils.preCheckCast(r4.getGroupValues().get(2), String.class, "com.obric.memorydata.plugin")).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "toUpperCase(...)");
        return TuplesKt.to(Double.valueOf(r2), r6);
    L9:
        return null;
    }

    public final void startExportAsOldDevice(a r14, Context r15, com.obric.memorydata.memory.ui.migration.a r16) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r14, a.class, "com.obric.memorydata.plugin");
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "biz");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r16, "exportSelection");
        i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r16, r5, r6, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void startImportAsNewDevice(String r14, a r15, Context r16) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r15, a.class, "com.obric.memorydata.plugin");
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "qrText");
        Intrinsics.checkNotNullParameter(r5, "biz");
        Intrinsics.checkNotNullParameter(r6, "context");
        i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12081(this, r14, r5, r6, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
