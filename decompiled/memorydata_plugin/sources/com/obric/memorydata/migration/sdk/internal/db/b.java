package com.obric.memorydata.migration.sdk.internal.db;

import android.content.Context;
import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.u;
import com.obric.memorydata.middleware.api.DatabaseKeyMigration;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.ab;
import com.obric.memorydata.migration.sdk.ai;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.x;
import com.obric.memorydata.migration.sdk.z;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u0000 f2\u00020\u0001:\u0002fgB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ8\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J@\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J.\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002JV\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010\u001d\u001a\u00020\u001e28\u0010$\u001a4\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110*¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H#0%H\u0082\b¢\u0006\u0002\u0010,J&\u0010-\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020*2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0.H\u0082\b¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u00102\u001a\u0004\u0018\u00010!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00103\u001a\u00020!H\u0002J\u0012\u00104\u001a\u0004\u0018\u00010!2\u0006\u00105\u001a\u00020\u0012H\u0002JP\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!082$\u00109\u001a \u0012\u0004\u0012\u00020!\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0:0808H\u0002J\u0010\u0010;\u001a\u00020\u00192\u0006\u0010(\u001a\u00020!H\u0002J4\u0010<\u001a\u00020\u00102\u0006\u0010+\u001a\u00020*2\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!08H\u0002J\u0018\u0010?\u001a\u00020\u00102\u0006\u0010+\u001a\u00020*2\u0006\u0010=\u001a\u00020!H\u0002J$\u0010@\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020B0A082\u0006\u0010+\u001a\u00020&H\u0002J \u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020!2\u000e\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0AH\u0002J \u0010F\u001a\u00020\u00102\u0006\u0010D\u001a\u00020!2\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0AH\u0002J\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00020I0:2\u0006\u0010+\u001a\u00020*2\u0006\u0010D\u001a\u00020!H\u0002J4\u0010J\u001a\u00020\u00102\u0006\u0010+\u001a\u00020*2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020!0L2\u0014\u0010M\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010!08H\u0002J(\u0010N\u001a\b\u0012\u0004\u0012\u00020!0:2\u0006\u0010+\u001a\u00020*2\u0006\u0010D\u001a\u00020!2\b\u0010O\u001a\u0004\u0018\u00010!H\u0002J*\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020*2\u0006\u0010D\u001a\u00020!2\b\u0010O\u001a\u0004\u0018\u00010!H\u0002J*\u0010S\u001a\u00020T2\u0006\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020*2\u0006\u0010D\u001a\u00020!2\b\u0010O\u001a\u0004\u0018\u00010!H\u0002J\u001e\u0010U\u001a\u00020!2\u0006\u0010=\u001a\u00020!2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020!0:H\u0002J\u001e\u0010W\u001a\b\u0012\u0004\u0012\u00020!0:2\u0006\u0010+\u001a\u00020*2\u0006\u0010D\u001a\u00020!H\u0002J(\u0010X\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020T2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020TH\u0002J(\u0010_\u001a\u00020`2\u0006\u0010+\u001a\u00020*2\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!2\u0006\u0010a\u001a\u00020!H\u0002J\u0018\u0010b\u001a\u00020\u00192\u0006\u0010+\u001a\u00020*2\u0006\u0010=\u001a\u00020!H\u0002J\u0018\u0010c\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/db/DbImporter;", "", "context", "Landroid/content/Context;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "fileUriMapper", "Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapper;", "postRestoreHook", "Lcom/obric/memorydata/migration/sdk/PostRestoreHook;", "gson", "Lcom/google/gson/Gson;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/migration/sdk/BackupConfig;Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapper;Lcom/obric/memorydata/migration/sdk/PostRestoreHook;Lcom/google/gson/Gson;)V", "restore", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "restoreDir", "Ljava/io/File;", "publicResourceRestoreDir", "backupConfigOverride", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Ljava/io/File;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/BackupConfig;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearNonRestoredTables", "", "(Ljava/io/File;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/BackupConfig;ZLcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importDbPassphrasesIfNeeded", "restoreOneDbFromSnapshot", "dbConfig", "Lcom/obric/memorydata/migration/sdk/DbConfig;", "restoredSnapshotTempDbs", "", "", "withTargetDb", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Landroidx/room/RoomDatabase;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "roomDb", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "(Lcom/obric/memorydata/migration/sdk/DbConfig;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "inTx", "Lkotlin/Function0;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "restoreExtraFiles", "restorePublicMediaAndRewriteDb", "restorePrivateAbsolutePath", "relPath", "createFileProviderUri", "file", "validateOldUrisRemoved", "oldToNew", "", "publicMediaColumns", "", "looksLikeResourceColumn", "rewriteColumnByMapping", "table", "column", "clearTable", "resolveRawDaoByTableName", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "restoreRawDbTableByIndex", "tableName", "snapshotDao", "enqueuePendingForRawTable", "targetDao", "queryTableColumnInfo", "Lcom/obric/memorydata/migration/sdk/internal/db/DbImporter$TableColumnInfo;", "applyExportSqlFiltersOnSnapshotDb", "keepTables", "", "exportSqlByTable", "querySelectColumns", "exportSql", "isTableSchemaCompatibleForRestore", "sourceDb", "targetDb", "restoreTableFullReplace", "", "insertSql", "cols", "queryTableColumns", "bindFromCursor", "stmt", "Landroidx/sqlite/db/SupportSQLiteStatement;", "index", "cursor", "Landroid/database/Cursor;", "colIndex", "queryCountContains", "", "needle", "tableExists", "copyFile", "src", "dest", "Companion", "TableColumnInfo", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11917a = null;
    private static final Set<String> g = null;
    private static final Set<String> h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f11918b;
    private final com.obric.memorydata.migration.sdk.b c;
    private final com.obric.memorydata.migration.sdk.internal.file.b d;
    private final ab e;
    private final Gson f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/db/DbImporter$Companion;", "", "<init>", "()V", "RAW_DB_LOGICAL_RESTORE_TABLES", "", "", "MEMORY_DOMAIN_EXTRA_TABLES_NOT_CLEANED_BY_ENTITY_DELETE", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.db.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/db/DbImporter$TableColumnInfo;", "", ActivityLifecycle.NAME, "", "notNull", "", "defaultValue", "isPrimaryKey", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getNotNull", "()Z", "getDefaultValue", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0646b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f11920b;
        private final String c;
        private final boolean d;

        public C0646b(String r2, boolean r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            this.f11919a = r2;
            this.f11920b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final String a() {
            return this.f11919a;
        }

        public final boolean b() {
            return this.f11920b;
        }

        public final String c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0646b.class) == true) goto L8;
            return false;
        L8:
            C0646b r6 = (C0646b) ZeusTransformUtils.preCheckCast(r5, C0646b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11919a, r6.f11919a) == true) goto L12;
            return false;
        L12:
            if (this.f11920b == r6.f11920b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f11919a.hashCode() * 31) + Boolean.hashCode(this.f11920b)) * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Boolean.hashCode(this.d);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TableColumnInfo(name=" + this.f11919a + ", notNull=" + this.f11920b + ", defaultValue=" + this.c + ", isPrimaryKey=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/migration/sdk/internal/db/DbImporter$importDbPassphrasesIfNeeded$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<Map<String, ? extends String>> {
        c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00020\u00020\u0001¨\u0006\u0005"}, d2 = {"com/obric/memorydata/migration/sdk/internal/db/DbImporter$restorePublicMediaAndRewriteDb$publicMediaColumns$columnsType$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends TypeToken<Map<String, ? extends Map<String, ? extends List<? extends String>>>> {
        d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/migration/sdk/internal/db/DbImporter$restorePublicMediaAndRewriteDb$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends TypeToken<Map<String, ? extends String>> {
        e() {
        }
    }

    static {
        f11917a = new a(null);
        g = SetsKt.setOf(new String[]{"RawMemoryEntity", "ShortMemory", "EpisodicTopicMemory", "AutoMemoryPro"});
        h = SetsKt.setOf(new String[]{"AutoMemorySemanticRelevantData", "AutoMemoryEpisodicRelevantData", "ComplexRecommendQuery", "PendingContext", "PendingEpisodic", "PendingSemantic", "AppEntityToMemoryTable", "MemoryEntityToCalendar", "LocalMemorySyncToDoubaoPending", "UnionSemanticTypeSummary", "MemoryProcessUserInsight", "UnionUserInsight", "UnionUserPersona", "AssistantChatEntity", "AutoMemoryProEvaluationStats", "AutoMemoryProRawSource", "DataBuildMemoryStatus", "SmartMemoryOrderHit"});
    }

    public b(Context r3, com.obric.memorydata.migration.sdk.b r4, com.obric.memorydata.migration.sdk.internal.file.b r5, ab r6, Gson r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.internal.file.b r9 = (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin");
        ab r10 = (ab) ZeusTransformUtils.wrapperContextForParams(r6, ab.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r4, "backupConfig");
        Intrinsics.checkNotNullParameter(r9, "fileUriMapper");
        Intrinsics.checkNotNullParameter(r7, "gson");
        this.f11918b = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.c = r4;
        this.d = r9;
        this.e = r10;
        this.f = r7;
    }

    public /* synthetic */ b(Context r8, com.obric.memorydata.migration.sdk.b r9, com.obric.memorydata.migration.sdk.internal.file.b r10, ab r11, Gson r12, int r13, DefaultConstructorMarker r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.internal.file.b r4 = (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin");
        ab r15 = (ab) ZeusTransformUtils.wrapperContextForParams(r11, ab.class, "com.obric.memorydata.plugin");
        if ((r13 & 8) == 0) goto L5;
        r15 = null;
    L5:
        ab r5 = r15;
        if ((r13 & 16) == 0) goto L8;
        r12 = new Gson();
    L8:
        this(r2, r9, r4, r5, r12);
    }

    private final long a(SupportSQLiteDatabase r5, String r6, String r7, String r8) {
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (d(r9, r6) == true) goto L30;
        return 0;
    L30:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9.query("SELECT COUNT(1) FROM `" + r6 + "` WHERE instr(`" + r7 + "`, ?) > 0", new String[]{r8}), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Cursor r11 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r11.moveToFirst() == false) goto L11;
        long r12 = r11.getLong(0);     // Catch: Throwable -> L14
    L12:
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L19
        Object r13 = Result.m1421constructorimpl(Long.valueOf(r12));     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r13) == false) goto L25;
        r13 = 0L;
    L25:
        return ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue();
    L11:
        r12 = 0;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public static final /* synthetic */ Context a(b r0) {
        return r0.f11918b;
    }

    private final z<Unit> a(com.obric.memorydata.migration.sdk.b r21, Map<String, String> r22, Map<String, ? extends Map<String, ? extends List<String>>> r23) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L7;
        z.b r0 = new z.b(Unit.INSTANCE);
    L6:
        return (z) ZeusTransformUtils.preCheckCast(r0, z.class, "com.obric.memorydata.plugin");
    L7:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r21.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L96;
        com.obric.memorydata.migration.sdk.g r1 = (com.obric.memorydata.migration.sdk.g) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.memorydata.migration.sdk.g.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r1.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        Object r10 = r9.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((ai) ZeusTransformUtils.preCheckCast(r10, ai.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
        r8.add(r10);
        goto L12
    L16:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == true) goto L94;
        Pair<RoomDatabase, SupportSQLiteDatabase> r12 = com.obric.memorydata.migration.sdk.internal.db.a.c(r1);
        RoomDatabase r13 = (RoomDatabase) ZeusTransformUtils.preCheckCast(r12.component1(), RoomDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r14 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r12.component2(), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L83
    L21:
        if (r15.hasNext() == false) goto L73;
        ai r16 = (ai) ZeusTransformUtils.preCheckCast(r15.next(), ai.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        String r17 = r16.a();     // Catch: Throwable -> L83
        if (d(r14, r17) == false) goto L71;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(c(r14, r17), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r18, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        Iterator r110 = r18.iterator();     // Catch: Throwable -> L83
    L27:
        if (r110.hasNext() == false) goto L29;
        Object r111 = r110.next();     // Catch: Throwable -> L83
        Iterator r24 = r6;
        String r20 = ((String) ZeusTransformUtils.preCheckCast(r111, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);     // Catch: Throwable -> L83
        Intrinsics.checkNotNullExpressionValue(r20, "toLowerCase(...)");     // Catch: Throwable -> L83
        r19.put(r20, r111);     // Catch: Throwable -> L83
        r6 = r24;
        r15 = r15;
        goto L27
    L29:
        Iterator r25 = r6;
        Iterator r26 = r15;
        Set<String> r27 = r16.c().keySet();     // Catch: Throwable -> L83
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r27, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L32;
        List r28 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L83
    L48:
        Iterator r29 = r28.iterator();     // Catch: Throwable -> L83
    L50:
        if (r29.hasNext() == false) goto L70;
        String r30 = ((String) ZeusTransformUtils.preCheckCast(r29.next(), String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);     // Catch: Throwable -> L83
        Intrinsics.checkNotNullExpressionValue(r30, "toLowerCase(...)");     // Catch: Throwable -> L83
        String r31 = (String) ZeusTransformUtils.preCheckCast(r19.get(r30), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        if (r31 == null) goto L50;
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L83
    L56:
        if (r112.hasNext() == false) goto L50;
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        Map r114 = r4;
        Map r115 = r5;
        long r32 = a(r14, r17, r31, r113);     // Catch: Throwable -> L83
        if (r32 > 0) goto L59;
        r4 = r114;
        r5 = r115;
        goto L56
    L59:
        z<Unit> r33 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "public media uri 未重写完成: table=" + r17 + " col=" + r31 + " oldUri=" + r113 + " remains=" + r32, null, 4, null)), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L66
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        if (r13 == null) goto L63;
        r13.close();     // Catch: Throwable -> L66
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L66
    L64:
        Result.m1421constructorimpl(r116);     // Catch: Throwable -> L66
    L68:
        return r33;
    L63:
        r116 = null;
    L66:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L68
    L70:
        Map r117 = r4;
        Map r118 = r5;
    L72:
        r6 = r25;
        r15 = r26;
        r4 = r117;
        r5 = r118;
        goto L21
    L32:
        Map r35 = (Map) ZeusTransformUtils.preCheckCast(r5.get(r1.a()), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        if (r35 == null) goto L35;
        List r36 = (List) ZeusTransformUtils.preCheckCast(r35.get(r17), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
    L36:
        if (r36 != null) goto L38;
        r36 = CollectionsKt.emptyList();     // Catch: Throwable -> L83
    L38:
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(r36, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        if (r37.isEmpty() == false) goto L47;
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r19.values(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        Iterator r40 = r38.iterator();     // Catch: Throwable -> L83
    L42:
        if (r40.hasNext() == false) goto L46;
        Object r119 = r40.next();     // Catch: Throwable -> L83
        if (a((String) ZeusTransformUtils.preCheckCast(r119, String.class, "com.obric.memorydata.plugin")) == false) goto L42;
        r39.add(r119);     // Catch: Throwable -> L83
        goto L42
    L46:
        r37 = (List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
    L47:
        r28 = (List) ZeusTransformUtils.preCheckCast(r37, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        goto L48
    L35:
        r36 = null;
        goto L36
    L71:
        r117 = r4;
        r118 = r5;
        r25 = r6;
        r26 = r15;
        goto L72
    L73:
        Map r120 = r4;
        Map r121 = r5;
        Iterator r210 = r6;
        Unit r41 = Unit.INSTANCE;     // Catch: Throwable -> L83
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L81
        b r43 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L81
        if (r13 == null) goto L78;
        r13.close();     // Catch: Throwable -> L81
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L81
    L79:
        Result.m1421constructorimpl(r122);     // Catch: Throwable -> L81
    L95:
        r6 = r210;
        r4 = r120;
        r5 = r121;
        goto L9
    L78:
        r122 = null;
    L81:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L83:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L91
        if (r13 == null) goto L88;
        r13.close();     // Catch: Throwable -> L91
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L91
    L89:
        Result.m1421constructorimpl(r123);     // Catch: Throwable -> L91
        throw th;
    L88:
        r123 = null;
    L91:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    L94:
        r120 = r4;
        r121 = r5;
        r210 = r6;
        goto L95
    L96:
        r0 = new z.b(Unit.INSTANCE);
        goto L6
    }

    public static final /* synthetic */ z a(b r0, File r1, com.obric.memorydata.migration.sdk.b r2, File r3) {
        return r0.a(r1, r2, r3);
    }

    private final z<Unit> a(File r17, com.obric.memorydata.migration.sdk.b r18, File r19) {
        File r0 = new File(r17, "path_mapping.json");
        if (r0.exists() == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L9;
        Type r7 = new e().getType();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L13
        Object r1 = Result.m1421constructorimpl((Map) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f.fromJson(FilesKt.readText$default(r0, null, 1, null), r7), Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L15:
        Map r8 = MapsKt.emptyMap();
        if (Result.m1427isFailureimpl(r1) == false) goto L18;
        r1 = r8;
    L18:
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == true) goto L21;
        if (r19 == null) goto L24;
        r19.mkdirs();
    L24:
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r11 = r2.entrySet().iterator();
    L26:
        if (r11.hasNext() == false) goto L43;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default(r14, "private_files/", false, 2, null) == true) goto L29;
        if (r19 == null) goto L26;
        File r15 = new File(r17, r14);
        if (r15.isFile() == false) goto L26;
        File r16 = new File(r19, r15.getName());
        if (r16.exists() == true) goto L39;
        a(r15, r16);
    L39:
        String r110 = c(r16);
        if (r110 == null) goto L26;
    L31:
        ((Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin")).put(r13, r110);
        goto L26
    L29:
        r110 = a(r17, r14);
        if (r110 == null) goto L26;
    L43:
        if (r10.isEmpty() == true) goto L45;
        t.f11981a.a("restore: public media rewrite begin, mappingCount=" + r2.size() + ", rewriteUriCount=" + r10.size());
        File r3 = new File(r17, "public_media_columns.json");
        if (r3.exists() == true) goto L50;
        r3 = null;
    L50:
        if (r3 == null) goto L60;
        Type r4 = new d().getType();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L54
        Object r6 = Result.m1421constructorimpl((Map) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f.fromJson(FilesKt.readText$default(r3, null, 1, null), r4), Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
    L56:
        Map r20 = MapsKt.emptyMap();
        if (Result.m1427isFailureimpl(r6) == false) goto L59;
        r6 = r20;
    L59:
        Map<String, ? extends Map<String, ? extends List<String>>> r21 = (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin");
    L61:
        Map<String, ? extends Map<String, ? extends List<String>>> r22 = r21;
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r18.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L63:
        if (r23.hasNext() == false) goto L133;
        com.obric.memorydata.migration.sdk.g r24 = (com.obric.memorydata.migration.sdk.g) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.memorydata.migration.sdk.g.class, "com.obric.memorydata.plugin");
        Pair<RoomDatabase, SupportSQLiteDatabase> r25 = com.obric.memorydata.migration.sdk.internal.db.a.c(r24);
        RoomDatabase r111 = (RoomDatabase) ZeusTransformUtils.preCheckCast(r25.component1(), RoomDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r26 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r25.component2(), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r26.beginTransaction();     // Catch: Throwable -> L122
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r24.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L119
    L68:
        if (r112.hasNext() == false) goto L108;
        ai r113 = (ai) ZeusTransformUtils.preCheckCast(r112.next(), ai.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        String r114 = r113.a();     // Catch: Throwable -> L119
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L72;
    L106:
        Iterator r115 = r23;
    L107:
        r23 = r115;
        goto L68
    L72:
        if (d(r26, r114) == false) goto L106;
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(c(r26, r114), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        Map r116 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r27, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        Iterator r28 = r27.iterator();     // Catch: Throwable -> L119
    L77:
        if (r28.hasNext() == false) goto L79;
        Object r117 = r28.next();     // Catch: Throwable -> L119
        Iterator r118 = r23;
        String r29 = ((String) ZeusTransformUtils.preCheckCast(r117, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);     // Catch: Throwable -> L119
        Intrinsics.checkNotNullExpressionValue(r29, "toLowerCase(...)");     // Catch: Throwable -> L119
        r116.put(r29, r117);     // Catch: Throwable -> L119
        r23 = r118;
        r28 = r28;
        goto L77
    L79:
        r115 = r23;
        Set<String> r30 = r113.c().keySet();     // Catch: Throwable -> L119
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r30, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L82;
        List r31 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L119
    L99:
        Iterator r32 = r31.iterator();     // Catch: Throwable -> L119
    L101:
        if (r32.hasNext() == false) goto L107;
        String r33 = ((String) ZeusTransformUtils.preCheckCast(r32.next(), String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);     // Catch: Throwable -> L119
        Intrinsics.checkNotNullExpressionValue(r33, "toLowerCase(...)");     // Catch: Throwable -> L119
        String r34 = (String) ZeusTransformUtils.preCheckCast(r116.get(r33), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        if (r34 == null) goto L101;
        a(r26, r114, r34, (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L119
        goto L101
    L82:
        Map r35 = (Map) ZeusTransformUtils.preCheckCast(r22.get(r24.a()), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        if (r35 == null) goto L85;
        List r36 = (List) ZeusTransformUtils.preCheckCast(r35.get(r114), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
    L86:
        if (r36 != null) goto L88;
        r36 = CollectionsKt.emptyList();     // Catch: Throwable -> L119
    L88:
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(r36, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        if (r37.isEmpty() == false) goto L98;
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r116.values(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        Iterator r40 = r38.iterator();     // Catch: Throwable -> L119
    L92:
        if (r40.hasNext() == false) goto L97;
        Object r119 = r40.next();     // Catch: Throwable -> L119
        if (a((String) ZeusTransformUtils.preCheckCast(r119, String.class, "com.obric.memorydata.plugin")) == false) goto L92;
        r39.add(r119);     // Catch: Throwable -> L119
        goto L92
    L97:
        r37 = (List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
    L98:
        r31 = (List) ZeusTransformUtils.preCheckCast(r37, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
        goto L99
    L85:
        r36 = null;
        goto L86
    L108:
        Iterator r120 = r23;
        Unit r41 = Unit.INSTANCE;     // Catch: Throwable -> L119
        r26.setTransactionSuccessful();     // Catch: Throwable -> L119
        r26.endTransaction();     // Catch: Throwable -> L122
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L122
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L116
        b r44 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L116
        if (r111 == null) goto L113;
        r111.close();     // Catch: Throwable -> L116
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L116
    L114:
        Result.m1421constructorimpl(r45);     // Catch: Throwable -> L116
    L118:
        r23 = r120;
        goto L63
    L113:
        r45 = null;
    L116:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L119:
        th = move-exception;
        r26.endTransaction();     // Catch: Throwable -> L122
        throw th;     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L130
        if (r111 == null) goto L127;
        r111.close();     // Catch: Throwable -> L130
        Unit r48 = Unit.INSTANCE;     // Catch: Throwable -> L130
    L128:
        Result.m1421constructorimpl(r48);     // Catch: Throwable -> L130
        throw th;
    L127:
        r48 = null;
    L130:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    L133:
        z<Unit> r50 = a(r18, (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin"), r22);
        if (ZeusTransformUtils.instanceOf(r50, z.a.class) == false) goto L137;
        t.a(t.f11981a, "restore: public media rewrite validate failed, " + ((z.a) ZeusTransformUtils.preCheckCast(r50, z.a.class, "com.obric.memorydata.plugin")).a().b(), null, 2, null);
        return r50;
    L137:
        t.f11981a.a("restore: public media rewrite end, rewriteUriCount=" + r10.size());
        return (z) ZeusTransformUtils.preCheckCast(new z.b(Unit.INSTANCE), z.class, "com.obric.memorydata.plugin");
    L54:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L56
    L60:
        r21 = MapsKt.emptyMap();
        goto L61
    L45:
        return (z) ZeusTransformUtils.preCheckCast(new z.b(Unit.INSTANCE), z.class, "com.obric.memorydata.plugin");
    L21:
        return (z) ZeusTransformUtils.preCheckCast(new z.b(Unit.INSTANCE), z.class, "com.obric.memorydata.plugin");
    L13:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L9:
        return (z) ZeusTransformUtils.preCheckCast(new z.b(Unit.INSTANCE), z.class, "com.obric.memorydata.plugin");
    }

    private final String a(File r1, String r2) {
        return f.a(this.f11918b, r1, r2);
    }

    private final String a(String r12, List<String> r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        String r14 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$QUDxQ2FgBqD4X6OFT0kW32jNgxg.INSTANCE, 30, null);
        int r15 = r11.size();
        ArrayList r1 = new ArrayList(r15);
        int r2 = 0;
    L3:
        if (r2 >= r15) goto L6;
        r1.add("?");
        r2 = r2 + 1;
        goto L3
    L6:
        return "INSERT OR IGNORE INTO `" + r12 + "` (" + r14 + ") VALUES (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')';
    }

    private final List<String> a(SupportSQLiteDatabase r7, String r8, String r9) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        String r0 = "SELECT * FROM `" + r8 + "` LIMIT 0";
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
    L14:
        String r11 = r0;
    L35:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Object r12 = Result.m1421constructorimpl(e(r10, r11));     // Catch: Throwable -> L17
    L19:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r12);
        if (r5 != null) goto L34;
    L28:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 == null) goto L33;
        t.f11981a.a("restore: query columns failed, table=" + r8 + " sql=" + r11, r13);
        r12 = CollectionsKt.emptyList();
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    L34:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r11, r0) == true) goto L25;
        t.f11981a.a("restore: query columns by exportSQL failed, fallback to default, table=" + r8 + " sql=" + r11 + ", err=" + r5.getMessage());     // Catch: Throwable -> L26
        r12 = Result.m1421constructorimpl(e(r10, r0));     // Catch: Throwable -> L26
        goto L28
    L25:
        throw r5;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    L12:
        if (StringsKt.startsWith(StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "select", true) == false) goto L14;
        r11 = "SELECT * FROM (" + StringsKt.trimEnd(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString(), new char[]{';'}) + ") LIMIT 0";
        goto L35
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L9
    }

    private final Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> a(RoomDatabase r9) {
        LinkedHashMap r1 = new LinkedHashMap();
        Method[] r2 = r9.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(r2, "getMethods(...)");
        Iterator r3 = SequencesKt.filter(SequencesKt.filter(ArraysKt.asSequence((Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.memorydata.plugin")), $$Lambda$b$lJQAcpCKTEHV6Ah8zJf5aqWy3KE.INSTANCE), $$Lambda$b$Tq15AWxTJsKiJuNVri8t6CJbIBg.INSTANCE).iterator();
    L4:
        if (r3.hasNext() == false) goto L35;
        Method r4 = (Method) ZeusTransformUtils.preCheckCast(r3.next(), Method.class, "com.obric.memorydata.plugin");
        Object r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L12
        b r7 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Object r8 = r4.invoke(r9, new Object[0]);     // Catch: Throwable -> L12
        if (ZeusTransformUtils.instanceOf(r8, IAppEntityRawDbDao.class) == false) goto L9;
        IAppEntityRawDbDao r10 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r8, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L10:
        Object r11 = Result.m1421constructorimpl(r10);     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r11) == false) goto L17;
        r11 = null;
    L17:
        IAppEntityRawDbDao r12 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r11, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L4;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L22
        b r14 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Object r15 = Result.m1421constructorimpl(r12.getTableName());     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r15) == true) goto L28;
        r5 = r15;
    L28:
        String r16 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L32;
        r16 = "";
    L32:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin")).put(r16, r12);
    L22:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L9:
        r10 = null;
    L12:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L35:
        return (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");
    }

    private static final Pair a(Map r6, String r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "table");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.get(r7), String.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r10 == null) goto L16;
        String r11 = StringsKt.trimEnd(r10, new char[]{';'});
        if (r11 != null) goto L9;
        return null;
    L9:
        if (StringsKt.startsWith(StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "select", true) == true) goto L12;
        r11 = null;
    L12:
        if (r11 != null) goto L14;
        return null;
    L14:
        return TuplesKt.to(r7, r11);
    L16:
        return null;
    L15:
        return null;
    }

    private final void a(SupportSQLiteDatabase r5, String r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (d(r7, r6) == true) goto L16;
        return;
    L16:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        b r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        r7.execSQL("DELETE FROM `" + r6 + '`');     // Catch: Throwable -> L7
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L14:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r7.execSQL("DELETE FROM sqlite_sequence WHERE name='" + r6 + '\'');     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final void a(SupportSQLiteDatabase r4, String r5, String r6, Map<String, String> r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (d(r8, r5) == true) goto L5;
        return;
    L5:
        SupportSQLiteStatement r10 = r8.compileStatement("UPDATE `" + r5 + "` SET `" + r6 + "` = REPLACE(`" + r6 + "`, ?, ?) WHERE instr(`" + r6 + "`, ?) > 0");
        Iterator r11 = r9.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.memorydata.plugin");
        r10.clearBindings();
        r10.bindString(1, r13);
        r10.bindString(2, r14);
        r10.bindString(3, r13);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L11
        b r16 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Integer.valueOf(r10.executeUpdateDelete()));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void a(SupportSQLiteDatabase r22, Set<String> r23, Map<String, String> r24) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r22, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set r0 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.memorydata.plugin");
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        List r7 = SequencesKt.toList(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$b$ImI1Rid3N5tvSIt38cHlQ77JehU(r6)));
        if (r7.isEmpty() == false) goto L8;
        return;
    L8:
        boolean r8 = com.obric.memorydata.migration.sdk.internal.db.a.a(r5);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        r5.execSQL("PRAGMA foreign_keys=OFF");     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (com.obric.memorydata.migration.sdk.internal.db.a.a(r5) == false) goto L106;
        t.f11981a.a("sqlite pragma foreign_keys=OFF not applied (maybe inside a transaction)");
    L106:
        r5.beginTransaction();     // Catch: Throwable -> L93
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L90
    L19:
        if (r9.hasNext() == false) goto L82;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        String r10 = (String) ZeusTransformUtils.preCheckCast(r2.component1(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.component2(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        if (d(r5, r10) == false) goto L19;
        String r11 = "__migration_restore_" + System.nanoTime();     // Catch: Throwable -> L90
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L25
        b r13 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        r5.execSQL("CREATE TEMP TABLE `" + r11 + "` AS " + r3);     // Catch: Throwable -> L25
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        String r14 = null;
        if (Result.m1427isFailureimpl(r4) == true) goto L29;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(c(r5, r10), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L90
    L41:
        if (r17.hasNext() == false) goto L121;
        Object r18 = r17.next();     // Catch: Throwable -> L90
        String r19 = ((String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);     // Catch: Throwable -> L90
        Intrinsics.checkNotNullExpressionValue(r19, "toLowerCase(...)");     // Catch: Throwable -> L90
        r16.put(r19, r18);     // Catch: Throwable -> L90
        goto L41
    L121:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L55
        b r21 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Closeable r110 = (Closeable) ZeusTransformUtils.preCheckCast(r5.query("SELECT * FROM `" + r11 + "` LIMIT 0"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        String[] r25 = ((Cursor) ZeusTransformUtils.preCheckCast(r110, Cursor.class, "com.obric.memorydata.plugin")).getColumnNames();     // Catch: Throwable -> L48
        Intrinsics.checkNotNullExpressionValue(r25, "getColumnNames(...)");     // Catch: Throwable -> L48
        List r26 = ArraysKt.toList((Object[]) ZeusTransformUtils.preCheckCast(r25, Object[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48
        CloseableKt.closeFinally(r110, null);     // Catch: Throwable -> L55
        Object r27 = Result.m1421constructorimpl(r26);     // Catch: Throwable -> L55
    L57:
        List r111 = CollectionsKt.emptyList();     // Catch: Throwable -> L90
        if (Result.m1427isFailureimpl(r27) == false) goto L60;
        r27 = r111;
    L60:
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Iterator r29 = r28.iterator();     // Catch: Throwable -> L90
    L62:
        if (r29.hasNext() == false) goto L66;
        Object r113 = r29.next();     // Catch: Throwable -> L90
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L90
        String r115 = r114.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L90
        Intrinsics.checkNotNullExpressionValue(r115, "toLowerCase(...)");     // Catch: Throwable -> L90
        if (r16.containsKey(r115) == false) goto L62;
        r112.add(r113);     // Catch: Throwable -> L90
        goto L62
    L66:
        List r30 = (List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        if (r30.isEmpty() == false) goto L73;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L71
        b r32 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L71
        r5.execSQL("DROP TABLE `" + r11 + '`');     // Catch: Throwable -> L71
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L90
        Object r34 = ResultKt.createFailure(th);     // Catch: Throwable -> L90
    L37:
        Result.m1421constructorimpl(r34);     // Catch: Throwable -> L90
        goto L19
    L73:
        String r35 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$zcARdrzXirxG8KcMrQjAfrr11uc.INSTANCE, 30, null);     // Catch: Throwable -> L90
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L76
        b r117 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L76
        r5.execSQL("DELETE FROM `" + r10 + '`');     // Catch: Throwable -> L76
        r5.execSQL("INSERT INTO `" + r10 + "` (" + r35 + ") SELECT " + r35 + " FROM `" + r11 + '`');     // Catch: Throwable -> L76
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L76
    L117:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L80
        b r37 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L80
        r5.execSQL("DROP TABLE `" + r11 + '`');     // Catch: Throwable -> L80
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L90
        r34 = ResultKt.createFailure(th);     // Catch: Throwable -> L90
    L76:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L90
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
        goto L117
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);     // Catch: Throwable -> L55
        throw th;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L90
        r27 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
        goto L57
    L29:
        t r119 = t.f11981a;     // Catch: Throwable -> L90
        StringBuilder r40 = new StringBuilder().append("restore: skip exportSQL filter, table=").append(r10).append(", err=");     // Catch: Throwable -> L90
        Throwable r41 = Result.m1424exceptionOrNullimpl(r4);     // Catch: Throwable -> L90
        if (r41 == null) goto L32;
        r14 = r41.getMessage();     // Catch: Throwable -> L90
    L32:
        r119.a(r40.append(r14).toString());     // Catch: Throwable -> L90
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L35
        b r43 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        r5.execSQL("DROP TABLE IF EXISTS `" + r11 + '`');     // Catch: Throwable -> L35
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L90
        r34 = ResultKt.createFailure(th);     // Catch: Throwable -> L90
        goto L37
    L25:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L90
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
        goto L27
    L82:
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L90
        r5.setTransactionSuccessful();     // Catch: Throwable -> L90
        r5.endTransaction();     // Catch: Throwable -> L93
        Unit r46 = Unit.INSTANCE;     // Catch: Throwable -> L93
        if (r8 == false) goto L143;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L87
        r5.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L87
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L87
        return;
    L87:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L143:
        return;
    L90:
        th = move-exception;
        r5.endTransaction();     // Catch: Throwable -> L93
        throw th;     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        if (r8 == false) goto L145;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L98
        r5.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L98
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L98
        throw th;
    L98:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    L145:
        throw th;
    L11:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static final /* synthetic */ void a(b r0, File r1) {
        r0.a(r1);
    }

    private final void a(File r7) {
        File r2 = new File(r7, "db_passphrases.json");
        if (r2.exists() == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        Type r8 = new c().getType();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        Object r9 = Result.m1421constructorimpl((Map) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f.fromJson(FilesKt.readText$default(r2, null, 1, null), r8), Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L13:
        Map r3 = MapsKt.emptyMap();
        if (Result.m1427isFailureimpl(r9) == false) goto L16;
        r9 = r3;
    L16:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin");
        if (r10.isEmpty() == false) goto L19;
        return;
    L19:
        Iterator r11 = r10.entrySet().iterator();
    L21:
        if (r11.hasNext() == false) goto L31;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L21;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L21;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L29
        b r14 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        DatabaseKeyMigration.INSTANCE.writeDatabasePhrase(r6, r12);     // Catch: Throwable -> L29
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    L31:
        return;
    L11:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void a(File r5, File r6) {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        File r4 = r6.getParentFile();
        if (r4 == null) goto L8;
        r4.mkdirs();
    L8:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r8 = (FileInputStream) ZeusTransformUtils.preCheckCast(r7, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        OutputStream r1 = (OutputStream) ZeusTransformUtils.preCheckCast(r9, OutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin"), r1, 0, 2, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r7, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    private final boolean a(SupportSQLiteDatabase r12, SupportSQLiteDatabase r13, String r14, String r15) {
        SupportSQLiteDatabase r16 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r12, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r17 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r13, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<String> r18 = a(r16, r14, r15);
        if (r18.isEmpty() == false) goto L6;
        t.f11981a.a("restore: skip table, empty source columns, table=" + r14);
        return false;
    L6:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(c(r17, r14), Iterable.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r19, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r110 = r19.iterator();
    L8:
        if (r110.hasNext() == false) goto L10;
        Object r4 = r110.next();
        String r6 = ((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "toLowerCase(...)");
        r3.put(r6, r4);
        goto L8
    L10:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r113 = r111.iterator();
    L12:
        if (r113.hasNext() == false) goto L16;
        Object r5 = r113.next();
        String r7 = ((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
        if (r3.containsKey(r7) == false) goto L12;
        r112.add(r5);
        goto L12
    L16:
        List r114 = (List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.memorydata.plugin");
        if (r114.isEmpty() == false) goto L20;
        t.f11981a.a("restore: skip table, no compatible columns, table=" + r14);
        return false;
    L20:
        Iterable r115 = (Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin");
        Collection r116 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r117 = r115.iterator();
    L22:
        if (r117.hasNext() == false) goto L24;
        String r8 = ((String) ZeusTransformUtils.preCheckCast(r117.next(), String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        r116.add(r8);
        goto L22
    L24:
        Set r118 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r116, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(b(r17, r14), Iterable.class, "com.obric.memorydata.plugin");
        Collection r119 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r120 = r11.iterator();
    L25:
        boolean r9 = true;
        if (r120.hasNext() == false) goto L37;
        Object r121 = r120.next();
        C0646b r10 = (C0646b) ZeusTransformUtils.preCheckCast(r121, C0646b.class, "com.obric.memorydata.plugin");
        if (r10.b() == true) goto L30;
    L34:
        r9 = false;
    L35:
        if (r9 == false) goto L25;
        r119.add(r121);
        goto L25
    L30:
        if (r10.c() != null) goto L34;
        if (r10.d() == true) goto L34;
    L37:
        Iterable r122 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r119, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r123 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r124 = r122.iterator();
    L39:
        if (r124.hasNext() == false) goto L41;
        r123.add(((C0646b) ZeusTransformUtils.preCheckCast(r124.next(), C0646b.class, "com.obric.memorydata.plugin")).a());
        goto L39
    L41:
        Iterable r125 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r123, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r126 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r127 = r125.iterator();
    L43:
        if (r127.hasNext() == false) goto L47;
        Object r128 = r127.next();
        String r2 = ((String) ZeusTransformUtils.preCheckCast(r128, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r2, "toLowerCase(...)");
        if ((!r118.contains(r2)) == false) goto L43;
        r126.add(r128);
        goto L43
    L47:
        List r129 = (List) ZeusTransformUtils.preCheckCast(r126, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r129, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L51;
        t.f11981a.a("restore: skip table, required columns missing, table=" + r14 + " missing=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r129, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
        return false;
    L51:
        return true;
    }

    private final boolean a(SupportSQLiteStatement r3, int r4, Cursor r5, int r6) {
        SupportSQLiteStatement r2 = (SupportSQLiteStatement) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        int r8 = r7.getType(r6);
        if (r8 == 0) goto L17;
        if (r8 != 1) goto L6;
        r2.bindLong(r4, r7.getLong(r6));
    L16:
        Unit r9 = Unit.INSTANCE;
        return true;
    L6:
        if (r8 != 2) goto L8;
        r2.bindDouble(r4, r7.getDouble(r6));
        goto L16
    L8:
        if (r8 == 4) goto L13;
        String r10 = r7.getString(r6);
        if (r10 != null) goto L12;
        r10 = "";
    L12:
        r2.bindString(r4, r10);
        goto L16
    L13:
        byte[] r11 = r7.getBlob(r6);
        Intrinsics.checkNotNullExpressionValue(r11, "getBlob(...)");
        r2.bindBlob(r4, r11);
        goto L16
    L17:
        r2.bindNull(r4);
        Unit r12 = Unit.INSTANCE;
        return false;
    }

    private static final boolean a(b r2, SupportSQLiteDatabase r3, SupportSQLiteDatabase r4, String r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "it");
        if (r2.d(r6, r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.d(r7, r5) == false) goto L7;
        return true;
    }

    private static final boolean a(b r2, SupportSQLiteDatabase r3, String r4) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        return r2.d(r5, r4);
    }

    public static final /* synthetic */ boolean a(b r2, File r3, com.obric.memorydata.migration.sdk.g r4, boolean r5, Set r6) {
        return r2.a(r3, r4, r5, (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean a(File r42, com.obric.memorydata.migration.sdk.g r43, boolean r44, Set<String> r45) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r45, Set.class, "com.obric.memorydata.plugin");
        String r7 = r43.a();
        String r8 = r43.d();
        if (r8 != null) goto L5;
        r8 = r7;
    L5:
        String r9 = com.obric.memorydata.migration.sdk.internal.db.a.a(r8);
        File r10 = new File(r42, "dbs/" + r9);
        t.f11981a.a("restore: ======== db " + r7 + " (" + r43.b() + ") ========");
        if (r10.exists() == true) goto L9;
        t.a(t.f11981a, "restore: snapshot not found, skip db=" + r7 + " snapshotFrom=" + r8 + " path=" + r10.getAbsolutePath(), null, 2, null);
        return false;
    L9:
        t.f11981a.a("restore: db begin, role=" + r43.b() + ", logical=" + r7 + ", snapshotFrom=" + r8 + ", temp=" + r9 + ", requestedTableCount=" + r43.c().size() + ", snapshotDir=" + r10.getAbsolutePath());
        if (r5.add(r9) == false) goto L12;
        com.obric.memorydata.migration.sdk.internal.db.a.a(this.f11918b, r10, r9);
    L14:
        if (r43.d() == null) goto L16;
        RoomDatabase r11 = (RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.buildDatabaseEngine(r9), RoomDatabase.class, "com.obric.memorydata.plugin");
    L380:
        SupportSQLiteDatabase r12 = r11.getOpenHelper().getWritableDatabase();     // Catch: Throwable -> L333
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r43.c(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L333
    L19:
        if (r15.hasNext() == false) goto L24;
        r14.add(((ai) ZeusTransformUtils.preCheckCast(r15.next(), ai.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Throwable r1 = th;
        RoomDatabase r28 = r11;
    L397:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L338
        r28.close();     // Catch: Throwable -> L338
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L338
        throw r1;
    L338:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw r1;
    L24:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        Iterator r18 = r16.iterator();     // Catch: Throwable -> L333
    L27:
        if (r18.hasNext() == false) goto L32;
        Object r19 = r18.next();     // Catch: Throwable -> L22
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L27;
        r17.add(r19);     // Catch: Throwable -> L22
        goto L27
    L32:
        List r110 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        if (r110.isEmpty() == false) goto L36;
        final Set<String> r111 = SetsKt.emptySet();     // Catch: Throwable -> L22
    L37:
        Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(r43.c(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        Iterator r114 = r112.iterator();     // Catch: Throwable -> L333
    L39:
        if (r114.hasNext() == false) goto L44;
        Object r115 = r114.next();     // Catch: Throwable -> L22
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((ai) ZeusTransformUtils.preCheckCast(r115, ai.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L39;
        r113.add(r115);     // Catch: Throwable -> L22
        goto L39
    L44:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        Map r116 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        Iterator r20 = r6.iterator();     // Catch: Throwable -> L333
    L46:
        if (r20.hasNext() == false) goto L49;
        ai r117 = (ai) ZeusTransformUtils.preCheckCast(r20.next(), ai.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Pair r118 = TuplesKt.to(r117.a(), r117.b());     // Catch: Throwable -> L22
        r116.put(r118.getFirst(), r118.getSecond());     // Catch: Throwable -> L22
        goto L46
    L49:
        a(r12, r111, r116);     // Catch: Throwable -> L333
        t.f11981a.a("restore tables: db=" + r7 + "\nrequestedCount=" + r110.size() + " requested=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + " \nkeepCount=" + r111.size() + " keepTables=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L333
        Pair<RoomDatabase, SupportSQLiteDatabase> r21 = com.obric.memorydata.migration.sdk.internal.db.a.c(r43);     // Catch: Throwable -> L333
        RoomDatabase r119 = (RoomDatabase) ZeusTransformUtils.preCheckCast(r21.component1(), RoomDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        final SupportSQLiteDatabase r22 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r21.component2(), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L333
        if (r119 == null) goto L382;
        RoomDatabase r120 = r119;
    L345:
        RoomDatabase r121 = r119;
        Iterator r122 = SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$b$KMGMbvSYcZnEKdTn1jzqSj3AE0U.INSTANCE).iterator();     // Catch: Throwable -> L316
    L60:
        if (r122.hasNext() == false) goto L72;
        Iterator r46 = r122;
        String r123 = (String) ZeusTransformUtils.preCheckCast(r122.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if (d(r12, r123) == true) goto L64;
    L66:
        boolean r124 = false;
    L67:
        if (r124 == true) goto L68;
        r122 = r46;
        goto L60
    L68:
        boolean r125 = true;
    L73:
        Class r25 = b.class;
        boolean r4 = u.f9600a.a((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L316
        String r23 = "PRAGMA foreign_keys=ON";
        if (r44 == false) goto L117;
        if (r125 == false) goto L117;
        boolean r126 = r125;
        Map r27 = r116;
        List r127 = SequencesKt.toList(SequencesKt.filter(SequencesKt.filterNot(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(h, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$b$yTPmCF7APzOr5z0QXZkepgxEP3M(r111)), new $$Lambda$b$rvPuA3jo8OVFDQZo_gfInZw30fI(this, r22)));     // Catch: Throwable -> L70
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r127, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L116;
        Set<String> r24 = r111;
        SupportSQLiteDatabase r29 = r12;
        t.f11981a.a("restore: clear memory extra tables (not covered by entity.delete), db=" + r7 + " clear=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r127, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L70
        boolean r26 = com.obric.memorydata.migration.sdk.internal.db.a.a(r22);     // Catch: Throwable -> L70
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L83
        r22.execSQL("PRAGMA foreign_keys=OFF");     // Catch: Throwable -> L83
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L83
    L87:
        if (com.obric.memorydata.migration.sdk.internal.db.a.a(r22) == false) goto L356;
        t.f11981a.a("sqlite pragma foreign_keys=OFF not applied (maybe inside a transaction)");     // Catch: Throwable -> L70
    L356:
        r22.beginTransaction();     // Catch: Throwable -> L107
        Iterator r129 = ((Iterable) ZeusTransformUtils.preCheckCast(r127, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L103
    L92:
        if (r129.hasNext() == false) goto L94;
        a(r22, (String) ZeusTransformUtils.preCheckCast(r129.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L103
        goto L92
    L94:
        Unit r130 = Unit.INSTANCE;     // Catch: Throwable -> L103
        r22.setTransactionSuccessful();     // Catch: Throwable -> L103
        r22.endTransaction();     // Catch: Throwable -> L107
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L107
        Set<String> r210 = r24;
        if (r26 == true) goto L412;
    L118:
        final Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r30 = a(r120);     // Catch: Throwable -> L316
        final Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r132 = a(r11);     // Catch: Throwable -> L316
        final SupportSQLiteDatabase r133 = r29;
        Set<String> r134 = SequencesKt.toSet(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$b$J44qTa8eOVGHO6376X3oOlh5Siw.INSTANCE), new $$Lambda$b$UiXdaRdOIBFs6viyZXEVbxWhnZ8(r30, r132)), new $$Lambda$b$mreXcgxPHh_37YmDSuCChBasc(this, r133, r22)));     // Catch: Throwable -> L316
        LinkedHashSet r135 = new LinkedHashSet();     // Catch: Throwable -> L316
        r28 = r11;
        Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r47 = r132;
        Iterator r31 = ((Iterable) ZeusTransformUtils.preCheckCast(r210, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L314
        Object r211 = r210;
    L122:
        if (r31.hasNext() == false) goto L138;
        Iterator r212 = r31;
        String r32 = (String) ZeusTransformUtils.preCheckCast(r31.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L314
        if (r134.contains(r32) == false) goto L126;
        String r33 = r23;
        Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r213 = r30;
    L136:
        Map r34 = r27;
    L137:
        r27 = r34;
        r31 = r212;
        r30 = r213;
        r23 = r33;
        r211 = r212;
        goto L122
    L126:
        if (d(r133, r32) == true) goto L128;
        r213 = r30;
        r33 = r23;
        t.f11981a.a("restore: skip table missing in snapshot, table=" + r32);     // Catch: Throwable -> L314
        goto L136
    L128:
        r33 = r23;
        r213 = r30;
        if (d(r22, r32) == true) goto L131;
        t.f11981a.a("restore: skip table missing in target, table=" + r32);     // Catch: Throwable -> L314
        goto L136
    L131:
        r34 = r27;
        if (a(r133, r22, r32, (String) ZeusTransformUtils.preCheckCast(r34.get(r32), String.class, "com.obric.memorydata.plugin")) == false) goto L137;
        r135.add(r32);     // Catch: Throwable -> L314
        goto L137
    L138:
        String r35 = r23;
        Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r214 = r30;
        Map r36 = r27;
        if (r135.isEmpty() == true) goto L141;
    L144:
        SupportSQLiteDatabase r215 = r133;
        t.f11981a.a("restore: db=" + r7 + " isMemoryRestore=" + r126 + ", rawTablesCount=" + r134.size() + " rawTables=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r134, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ", copyTablesCount=" + r135.size() + " copyTables=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r135, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L314
        Map r37 = r36;
        IStore r38 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);     // Catch: Throwable -> L314
        boolean r136 = r38.getBoolean("is_on_avoid_data_import_switch_on", false);     // Catch: Throwable -> L314
        if (r136 == false) goto L158;
        boolean r48 = r136;
        t.f11981a.a("restore: temporarily disable avoid-data-import switch for index/delete, db=" + r7);     // Catch: Throwable -> L314
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L153
        r25 = r25;
        b r137 = (b) ZeusTransformUtils.preCheckCast(this, r25, "com.obric.memorydata.plugin");     // Catch: Throwable -> L151
        r38.save("is_on_avoid_data_import_switch_on", false);     // Catch: Throwable -> L151
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L151
    L159:
        String r138 = "restore: restore avoid-data-import switch to ON, db=";
        Object r216 = r211;
        if (r4 == false) goto L349;
        SupportSQLiteDatabase r217 = r22;
        u.a(u.f9600a, r217, 0, 2, null);     // Catch: Throwable -> L163
        r216 = r217;
    L163:
        th = move-exception;
        Throwable r40 = th;
        IStore r41 = r38;
        String r49 = "is_on_avoid_data_import_switch_on";
        String r50 = "restore: restore avoid-data-import switch to ON, db=";
    L306:
        if (r48 == false) goto L443;
        t.f11981a.a(r50 + r7);     // Catch: Throwable -> L314
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L310
        r41.save(r49, true);     // Catch: Throwable -> L310
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L310
    L444:
        throw r40;     // Catch: Throwable -> L314
    L310:
        th = move-exception;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L314
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L314
        throw r40;     // Catch: Throwable -> L314
    L443:
        throw r40;     // Catch: Throwable -> L314
    L349:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r134, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L182;
        r41 = r38;
        String r218 = "is_on_avoid_data_import_switch_on";
        t.f11981a.a("restore: cleanup existing rawTables on target, db=" + r7 + " tables=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r134, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L177
        com.obric.memorydata.migration.sdk.internal.db.e.f11923a.a(r120, r134);     // Catch: Throwable -> L177
        Iterator r53 = ((Iterable) ZeusTransformUtils.preCheckCast(r134, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L177
    L174:
        if (r53.hasNext() == false) goto L410;
        a(r22, (String) ZeusTransformUtils.preCheckCast(r53.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L177
    L410:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r135, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L249;
        t.f11981a.a("restore: copyTables full-replace begin, db=" + r7 + " count=" + r135.size());     // Catch: Throwable -> L177
        boolean r54 = com.obric.memorydata.migration.sdk.internal.db.a.a(r22);     // Catch: Throwable -> L177
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L189
        r22.execSQL("PRAGMA foreign_keys=OFF");     // Catch: Throwable -> L189
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L189
    L193:
        if (com.obric.memorydata.migration.sdk.internal.db.a.a(r22) == false) goto L386;
        t.f11981a.a("sqlite pragma foreign_keys=OFF not applied (maybe inside a transaction)");     // Catch: Throwable -> L177
    L386:
        r22.beginTransaction();     // Catch: Throwable -> L238
        Iterator r56 = ((Iterable) ZeusTransformUtils.preCheckCast(r135, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L231
        r138 = r138;
    L197:
        if (r56.hasNext() == false) goto L208;
        String r57 = (String) ZeusTransformUtils.preCheckCast(r56.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L205
        t.f11981a.a("restore: copy full-replace start, table=" + r57);     // Catch: Throwable -> L205
        Map r58 = r37;
        SupportSQLiteDatabase r139 = r215;
        int r140 = b(r139, r22, r57, (String) ZeusTransformUtils.preCheckCast(r58.get(r57), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L205
        Iterator r141 = r56;
        String r219 = r138;
        t.f11981a.a("restore: copy full-replace end, table=" + r57 + " count=" + r140);     // Catch: Throwable -> L203
        r37 = r58;
        r215 = r139;
        r56 = r141;
        r138 = r219;
    L203:
        th = th;
    L207:
        Throwable r59 = th;
        r216 = r219;
    L384:
        r22.endTransaction();     // Catch: Throwable -> L236
        throw r59;     // Catch: Throwable -> L236
    L236:
        th = th;
    L241:
        Throwable r60 = th;
        if (r54 == false) goto L441;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L245
        r22.execSQL(r35);     // Catch: Throwable -> L245
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L245
    L442:
        throw r60;     // Catch: Throwable -> L266
    L245:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L266
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L266
        throw r60;     // Catch: Throwable -> L266
    L441:
        throw r60;     // Catch: Throwable -> L266
    L205:
        th = th;
        r219 = r138;
        goto L207
    L208:
        r216 = r138;
        SupportSQLiteDatabase r142 = r215;
        Map r63 = r37;
        Unit r64 = Unit.INSTANCE;     // Catch: Throwable -> L229
        r22.setTransactionSuccessful();     // Catch: Throwable -> L229
        r22.endTransaction();     // Catch: Throwable -> L227
        Unit r65 = Unit.INSTANCE;     // Catch: Throwable -> L227
        if (r54 == true) goto L341;
    L217:
        Iterator r66 = SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r135, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$b$oyebvfwx2V9_u_3jYAly9BwAvnE.INSTANCE).iterator();     // Catch: Throwable -> L266
    L219:
        if (r66.hasNext() == false) goto L225;
        String r67 = (String) ZeusTransformUtils.preCheckCast(r66.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L266
        Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r68 = r214;
        IAppEntityRawDbDao r143 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r68.get(r67), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L266
        if (r143 != null) goto L223;
        t.f11981a.a("restore: raw table downgraded to copy but target dao missing, skip pending enqueue, table=" + r67);     // Catch: Throwable -> L266
    L224:
        r214 = r68;
        goto L219
    L223:
        t.f11981a.a("restore: raw table downgraded to copy, compensate pending, table=" + r67);     // Catch: Throwable -> L266
        b(r67, r143);     // Catch: Throwable -> L266
        goto L224
    L225:
        Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r69 = r214;
        t.f11981a.a("restore: copyTables full-replace end, db=" + r7);     // Catch: Throwable -> L266
        Object r220 = r216;
    L401:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r134, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L268;
        t.f11981a.a("restore: rawTables logical restore begin, db=" + r7 + " count=" + r134.size());     // Catch: Throwable -> L266
        Iterator r70 = ((Iterable) ZeusTransformUtils.preCheckCast(r134, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L266
    L255:
        if (r70.hasNext() == false) goto L265;
        String r71 = (String) ZeusTransformUtils.preCheckCast(r70.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L266
        Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r144 = r47;
        IAppEntityRawDbDao r145 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r144.get(r71), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L266
        if (r145 != null) goto L260;
        t.f11981a.a("restore: raw dao missing in snapshot, skip table=" + r71);     // Catch: Throwable -> L266
    L264:
        r47 = r144;
        goto L255
    L260:
        if (a(r71, r145) == true) goto L264;
        t.f11981a.a("restore: raw index failed, fallback to table copy, table=" + r71);     // Catch: Throwable -> L266
        t.f11981a.a("restore: raw fallback copy done, table=" + r71 + " count=" + b(r142, r22, r71, (String) ZeusTransformUtils.preCheckCast(r63.get(r71), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L266
        IAppEntityRawDbDao r146 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r69.get(r71), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L266
        if (r146 == null) goto L264;
        b(r71, r146);     // Catch: Throwable -> L266
        Unit r72 = Unit.INSTANCE;     // Catch: Throwable -> L266
        Unit r73 = Unit.INSTANCE;     // Catch: Throwable -> L266
        goto L264
    L265:
        t.f11981a.a("restore: rawTables logical restore end, db=" + r7);     // Catch: Throwable -> L266
    L268:
        if (r4 == false) goto L270;
        u.f9600a.a(r22);     // Catch: Throwable -> L266
    L270:
        if (r48 == true) goto L271;
    L143:
        Class r74 = r25;
    L282:
        Unit r75 = Unit.INSTANCE;     // Catch: Throwable -> L314
        Result.Companion r76 = Result.Companion;     // Catch: Throwable -> L289
        b r77 = (b) ZeusTransformUtils.preCheckCast(this, r74, "com.obric.memorydata.plugin");     // Catch: Throwable -> L289
        if (r121 == null) goto L286;
        r121.close();     // Catch: Throwable -> L289
        Unit r147 = Unit.INSTANCE;     // Catch: Throwable -> L289
    L287:
        Result.m1421constructorimpl(r147);     // Catch: Throwable -> L289
    L359:
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L294
        b r79 = (b) ZeusTransformUtils.preCheckCast(this, r74, "com.obric.memorydata.plugin");     // Catch: Throwable -> L294
        r28.close();     // Catch: Throwable -> L294
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L294
    L296:
        t.f11981a.a("restore: db done, logical=" + r7);
        return true;
    L294:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L296
    L286:
        r147 = null;
    L289:
        th = move-exception;
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L331
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L331
        goto L359
    L271:
        t.f11981a.a(r220 + r7);     // Catch: Throwable -> L314
        Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L278
        r74 = r25;
        b r83 = (b) ZeusTransformUtils.preCheckCast(this, r74, "com.obric.memorydata.plugin");     // Catch: Throwable -> L276
        r41.save(r218, true);     // Catch: Throwable -> L276
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L276
    L276:
        th = th;
    L280:
        Throwable r84 = th;
        Result.Companion r85 = Result.Companion;     // Catch: Throwable -> L314
        Result.m1421constructorimpl(ResultKt.createFailure(r84));     // Catch: Throwable -> L314
    L278:
        th = th;
        r74 = r25;
    L298:
        th = th;
        Object r86 = r220;
    L302:
        r49 = r218;
        Object r87 = r86;
    L305:
        r40 = th;
        r50 = r87;
        goto L306
    L341:
        Result.Companion r88 = Result.Companion;     // Catch: Throwable -> L214
        r22.execSQL(r35);     // Catch: Throwable -> L214
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L214
    L214:
        th = move-exception;
        Result.Companion r89 = Result.Companion;     // Catch: Throwable -> L266
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L266
    L227:
        th = th;
    L240:
        r35 = r35;
    L229:
        th = th;
    L233:
        r59 = th;
        r216 = r216;
    L231:
        th = th;
        r216 = r138;
    L238:
        th = th;
        r216 = "restore: restore avoid-data-import switch to ON, db=";
    L189:
        th = move-exception;
        Result.Companion r90 = Result.Companion;     // Catch: Throwable -> L177
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L177
        goto L193
    L249:
        r220 = "restore: restore avoid-data-import switch to ON, db=";
        r142 = r215;
        r69 = r214;
        r63 = r37;
    L266:
        th = move-exception;
        r40 = th;
        r41 = r41;
        Object r91 = r216;
    L179:
        r49 = r218;
        r50 = r91;
    L300:
        th = th;
        r86 = "restore: restore avoid-data-import switch to ON, db=";
    L177:
        th = move-exception;
        r40 = th;
        r91 = "restore: restore avoid-data-import switch to ON, db=";
        r41 = r41;
    L180:
        th = move-exception;
        r40 = th;
        r49 = "is_on_avoid_data_import_switch_on";
        r50 = "restore: restore avoid-data-import switch to ON, db=";
        r41 = r41;
        goto L306
    L182:
        r41 = r38;
        r218 = "is_on_avoid_data_import_switch_on";
    L303:
        th = th;
        r41 = r38;
        r49 = "is_on_avoid_data_import_switch_on";
        r87 = "restore: restore avoid-data-import switch to ON, db=";
    L151:
        th = th;
    L155:
        Throwable r148 = th;
        Result.Companion r149 = Result.Companion;     // Catch: Throwable -> L314
        Result.m1421constructorimpl(ResultKt.createFailure(r148));     // Catch: Throwable -> L314
    L153:
        th = th;
        r25 = r25;
        goto L155
    L158:
        r48 = r136;
        r25 = r25;
        goto L159
    L141:
        if (r134.isEmpty() == false) goto L144;
        t.f11981a.a("restore: no tables to restore, db=" + r7);     // Catch: Throwable -> L314
    L314:
        th = th;
    L318:
        Throwable r92 = th;
    L361:
        Result.Companion r93 = Result.Companion;     // Catch: Throwable -> L327
        if (r121 == null) goto L324;
        r121.close();     // Catch: Throwable -> L327
        Unit r150 = Unit.INSTANCE;     // Catch: Throwable -> L327
    L325:
        Result.m1421constructorimpl(r150);     // Catch: Throwable -> L327
    L445:
        throw r92;     // Catch: Throwable -> L331
    L324:
        r150 = null;
    L327:
        th = move-exception;
        Result.Companion r94 = Result.Companion;     // Catch: Throwable -> L331
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L331
        throw r92;     // Catch: Throwable -> L331
    L412:
        Result.Companion r95 = Result.Companion;     // Catch: Throwable -> L99
        r22.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L99
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L99
        r210 = r24;
    L99:
        th = move-exception;
        Result.Companion r151 = Result.Companion;     // Catch: Throwable -> L70
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L70
        r210 = r24;
        goto L118
    L103:
        th = move-exception;
        r22.endTransaction();     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        if (r26 == false) goto L439;
        Result.Companion r96 = Result.Companion;     // Catch: Throwable -> L112
        r22.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L112
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L112
    L440:
        throw th;     // Catch: Throwable -> L70
    L112:
        th = move-exception;
        Result.Companion r97 = Result.Companion;     // Catch: Throwable -> L70
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L439:
        throw th;     // Catch: Throwable -> L70
    L83:
        th = move-exception;
        Result.Companion r152 = Result.Companion;     // Catch: Throwable -> L70
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L70
        goto L87
    L116:
        r29 = r12;
        r210 = r111;
    L117:
        r29 = r12;
        r210 = r111;
        r27 = r116;
        r126 = r125;
        goto L118
    L64:
        if (d(r22, r123) == false) goto L66;
        r124 = true;
    L70:
        th = move-exception;
        r92 = th;
        r28 = r11;
        goto L361
    L72:
        r125 = false;
    L316:
        th = th;
        r28 = r11;
    L319:
        th = th;
        r28 = r11;
        r121 = r119;
        goto L318
    L382:
        r120 = com.obric.memorydata.migration.sdk.internal.db.a.b(r43);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        r92 = th;
        r28 = r11;
        r121 = r119;
    L331:
        th = th;
    L335:
        r1 = th;
        goto L397
    L36:
        r111 = com.obric.memorydata.migration.sdk.internal.db.a.a(r12, r110);     // Catch: Throwable -> L333
    L333:
        th = th;
        r28 = r11;
        goto L335
    L16:
        r11 = com.obric.memorydata.migration.sdk.internal.db.a.a(r43, r9);
        goto L380
    L12:
        t.f11981a.a("restore: reuse restored snapshot temp db, db=" + r7 + " snapshotFrom=" + r8 + " temp=" + r9);
        goto L14
    }

    private final boolean a(String r7) {
        String r6 = r7.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r6, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("screenshot", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L5;
    L22:
        return true;
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("image", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("media", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("uri", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("url", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("path", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("file", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("cover", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("thumb", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("avatar", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        return false;
    }

    private final boolean a(String r14, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r15) {
        IAppEntityRawDbDao r16 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r15, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        t.f11981a.a("restore: raw index start, table=" + r14);
        long r3 = 0;
        int r5 = 0;
    L32:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L6
        b r8 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Object r4 = Result.m1421constructorimpl(r16.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM `" + r16.getTableName() + "` WHERE id > ? ORDER BY id ASC LIMIT ?", new Object[]{Long.valueOf(r3), 200}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L6
    L8:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r4);
        if (r6 != null) goto L30;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == true) goto L28;
        long r10 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r9), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r11.hasNext() == false) goto L27;
        com.obric.memorydata.database.entity.d r12 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L18
        b r17 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Object r18 = Result.m1421constructorimpl(Boolean.valueOf(r12.index(false)));     // Catch: Throwable -> L18
    L20:
        Throwable r19 = Result.m1424exceptionOrNullimpl(r18);
        if (r19 == null) goto L25;
        t.f11981a.a("restore: raw index failed, table=" + r14 + " entityId=" + r12.getEntityId() + " type=" + r12.getType() + " id=" + r12.getId(), r19);
        r18 = false;
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r18, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L14;
        r5 = r5 + 1;
    L18:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    L27:
        r3 = r10;
        goto L32
    L28:
        t.f11981a.a("restore: raw index end, table=" + r14 + " count=" + r5);
        return true;
    L30:
        t.f11981a.a("restore: raw query failed, table=" + r14, r6);
        return false;
    L6:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final boolean a(Method r2) {
        Class<?>[] r3 = r2.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r3, "getParameterTypes(...)");
        if (((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin")).length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean a(Map r2, Map r3, String r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r5.containsKey(r4) == true) goto L5;
    L7:
        return false;
    L5:
        if (r6.containsKey(r4) == false) goto L7;
        return true;
    }

    private static final boolean a(Set r2, String r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return r4.contains(r3);
    }

    private final int b(SupportSQLiteDatabase r19, SupportSQLiteDatabase r20, String r21, String r22) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r19, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r20, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (d(r6, r21) == false) goto L103;
        if (d(r7, r21) == false) goto L103;
        if (a(r6, r7, r21, r22) == true) goto L10;
        return 0;
    L10:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(c(r7, r21), Iterable.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        Object r12 = r1.next();
        String r14 = ((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r14, "toLowerCase(...)");
        r10.put(r14, r12);
        goto L12
    L14:
        String r13 = "SELECT * FROM `" + r21 + '`';
        if (r22 != null) goto L17;
        String r15 = r13;
    L108:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Object r4 = Result.m1421constructorimpl(r6.query(r15));     // Catch: Throwable -> L20
    L22:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r4);
        if (r16 != null) goto L112;
    L33:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 != null) goto L101;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast((Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r9 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        String[] r11 = r9.getColumnNames();     // Catch: Throwable -> L95
        Intrinsics.checkNotNullExpressionValue(r11, "getColumnNames(...)");     // Catch: Throwable -> L95
        List r17 = ArraysKt.toList((Object[]) ZeusTransformUtils.preCheckCast(r11, Object[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L95
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        Iterator r111 = r18.iterator();     // Catch: Throwable -> L95
    L38:
        if (r111.hasNext() == false) goto L43;
        Object r112 = r111.next();     // Catch: Throwable -> L95
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L95
        String r23 = r113.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L95
        Intrinsics.checkNotNullExpressionValue(r23, "toLowerCase(...)");     // Catch: Throwable -> L95
        if (r10.containsKey(r23) == false) goto L38;
        r110.add(r112);     // Catch: Throwable -> L95
        goto L38
    L43:
        List<String> r24 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        if (r24.isEmpty() == false) goto L48;
        CloseableKt.closeFinally(r8, null);
        return 0;
    L48:
        a(r7, r21);     // Catch: Throwable -> L95
        SupportSQLiteStatement r25 = r7.compileStatement(a(r21, r24));     // Catch: Throwable -> L95
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        LinkedHashMap r114 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r26, 10)), 16));     // Catch: Throwable -> L95
        Iterator r27 = r26.iterator();     // Catch: Throwable -> L95
    L50:
        if (r27.hasNext() == false) goto L52;
        Object r115 = r27.next();     // Catch: Throwable -> L95
        ((Map) ZeusTransformUtils.preCheckCast(r114, Map.class, "com.obric.memorydata.plugin")).put(r115, Integer.valueOf(r9.getColumnIndex((String) ZeusTransformUtils.preCheckCast(r115, String.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L95
        goto L50
    L52:
        Map r116 = (Map) ZeusTransformUtils.preCheckCast(r114, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        int r117 = 0;
        int r118 = 0;
        int r119 = 0;
    L54:
        if (r9.moveToNext() == false) goto L87;
        r25.clearBindings();     // Catch: Throwable -> L95
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L95
        boolean r120 = true;
        int r121 = 0;
    L57:
        if (r28.hasNext() == false) goto L70;
        Object r29 = r28.next();     // Catch: Throwable -> L95
        Iterator r210 = r28;
        int r30 = r121 + 1;     // Catch: Throwable -> L95
        if (r121 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L95
    L61:
        Integer r31 = (Integer) ZeusTransformUtils.preCheckCast(r116.get((String) ZeusTransformUtils.preCheckCast(r29, String.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        if (r31 == null) goto L64;
        int r32 = r31.intValue();     // Catch: Throwable -> L95
    L65:
        if (r32 < 0) goto L69;
        if (a(r25, r30, r9, r32) == false) goto L69;
        r120 = false;
    L69:
        r121 = r30;
        r28 = r210;
        goto L57
    L64:
        r32 = -1;
        goto L65
    L70:
        if (r120 == false) goto L104;
        r118 = r118 + 1;
        goto L54
    L104:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L75
        b r34 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        Object r35 = Result.m1421constructorimpl(Long.valueOf(r25.executeInsert()));     // Catch: Throwable -> L75
    L77:
        Throwable r36 = Result.m1424exceptionOrNullimpl(r35);     // Catch: Throwable -> L95
        if (r36 == null) goto L81;
        t.f11981a.a("restore: insert row failed, table=" + r21, r36);     // Catch: Throwable -> L95
        r35 = -2L;     // Catch: Throwable -> L95
    L81:
        long r122 = ((Number) ZeusTransformUtils.preCheckCast(r35, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L95
        if (r122 != (-1)) goto L85;
        r117 = r117 + 1;     // Catch: Throwable -> L95
        goto L54
    L85:
        if (r122 < 0) goto L54;
        r119 = r119 + 1;     // Catch: Throwable -> L95
        goto L54
    L75:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L95
        r35 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L95
        goto L77
    L87:
        if (r117 > 0) goto L91;
        if (r118 > 0) goto L91;
    L93:
        CloseableKt.closeFinally(r8, null);
        return r119;
    L91:
        t.f11981a.a("restore: insert done, table=" + r21 + " inserted=" + r119 + " ignored=" + r117 + " skippedAllNull=" + r118);     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        throw th;     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L101:
        t.f11981a.a("restore: query source failed, table=" + r21 + " sql=" + r15, r5);
        return 0;
    L112:
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L31
        if (r22 != null) goto L28;
        throw r16;     // Catch: Throwable -> L31
    L28:
        if (Intrinsics.areEqual(r15, r13) == true) goto L127;
        t.f11981a.a("restore: query source by exportSQL failed, fallback to default, table=" + r21 + " sql=" + r15, r16);     // Catch: Throwable -> L31
        r4 = Result.m1421constructorimpl(r6.query(r13));     // Catch: Throwable -> L31
        goto L33
    L127:
        throw r16;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L20:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L17:
        r15 = r22;
    L103:
        return 0;
    }

    public static final /* synthetic */ com.obric.memorydata.migration.sdk.b b(b r0) {
        return r0.c;
    }

    private final List<C0646b> b(SupportSQLiteDatabase r11, String r12) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r13 = CollectionsKt.createListBuilder();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L31
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r10.query("PRAGMA table_info(`" + r12 + "`)"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Cursor r15 = (Cursor) ZeusTransformUtils.preCheckCast(r14, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        int r0 = r15.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L26
        int r2 = r15.getColumnIndex("notnull");     // Catch: Throwable -> L26
        int r3 = r15.getColumnIndex("dflt_value");     // Catch: Throwable -> L26
        int r4 = r15.getColumnIndex("pk");     // Catch: Throwable -> L26
    L5:
        String r5 = null;
        if (r15.moveToNext() == false) goto L23;
        String r6 = r15.getString(r0);     // Catch: Throwable -> L26
        if (r6 == null) goto L5;
        boolean r7 = true;
        if (r15.getInt(r2) == 0) goto L13;
        boolean r8 = true;
    L14:
        if (r3 < 0) goto L19;
        if (r15.isNull(r3) == true) goto L19;
        r5 = r15.getString(r3);     // Catch: Throwable -> L26
    L19:
        if (r15.getInt(r4) != 0) goto L22;
        r7 = false;
    L22:
        r13.add(new C0646b(r6, r8, r5, r7));     // Catch: Throwable -> L26
        goto L5
    L13:
        r8 = false;
        goto L14
    L23:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L31
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L34:
        return CollectionsKt.build(r13);
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    public static final /* synthetic */ void b(b r0, File r1) {
        r0.b(r1);
    }

    private final void b(File r10) {
        File r0 = new File(r10, WsConstants.KEY_EXTRA);
        if (r0.exists() == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        File r9 = this.f11918b.getDataDir();
        Iterator r11 = ((Sequence) ZeusTransformUtils.preCheckCast(FilesKt.walkTopDown(r0), Sequence.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r11.hasNext() == false) goto L31;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r11.next(), File.class, "com.obric.memorydata.plugin");
        if (r2.isFile() == false) goto L10;
        File r4 = new File(r9, FilesKt.relativeTo(r2, r0).getPath());
        File r5 = r4.getParentFile();
        if (r5 == null) goto L16;
        r5.mkdirs();
    L16:
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r2), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r6 = (FileInputStream) ZeusTransformUtils.preCheckCast(r3, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r4), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r6, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r7, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L26
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r3, null);
        goto L10
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    private final void b(String r14, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r15) {
        IAppEntityRawDbDao r16 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r15, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        t.f11981a.a("restore: raw pending enqueue start, table=" + r14);
        long r3 = 0;
        int r5 = 0;
    L27:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        b r7 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(r16.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM `" + r16.getTableName() + "` WHERE id > ? ORDER BY id ASC LIMIT ?", new Object[]{Long.valueOf(r3), 200}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L5
    L7:
        List r8 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r4) == false) goto L10;
        r4 = r8;
    L10:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == true) goto L23;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r10.hasNext() == false) goto L22;
        com.obric.memorydata.database.entity.d r12 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (x.f11987a.a(r12) == false) goto L14;
        r5 = r5 + 1;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L20
        b r13 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        PersonalContextAPI.INSTANCE.onRawEntityInsert(r12.getType(), r12.getEntityId(), r12.getId(), r12);     // Catch: Throwable -> L20
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    L22:
        r3 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r9), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId();
        goto L27
    L23:
        t.f11981a.a("restore: raw pending enqueue end, table=" + r14 + " count=" + r5);
        return;
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return g.contains(r1);
    }

    private static final boolean b(Method r1) {
        return IAppEntityRawDbDao.class.isAssignableFrom(r1.getReturnType());
    }

    public static final /* synthetic */ com.obric.memorydata.migration.sdk.internal.file.b c(b r0) {
        return r0.d;
    }

    private final String c(File r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(ZeusTransformUtils.getUriForFile(((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f11918b, "com.larus.nova.zeus.memorydata.fileprovider", r3, "com.obric.memorydata.plugin").toString());     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r2) == false) goto L11;
        r2 = null;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final List<String> c(SupportSQLiteDatabase r4, String r5) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r6 = CollectionsKt.createListBuilder();
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r3.query("PRAGMA table_info(`" + r5 + "`)"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r8 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        int r0 = r8.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L10
    L5:
        if (r8.moveToNext() == false) goto L7;
        String r1 = r8.getString(r0);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");     // Catch: Throwable -> L10
        r6.add(r1);     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r7, null);
        return CollectionsKt.build(r6);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    private static final boolean c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return g.contains(r1);
    }

    public static final /* synthetic */ ab d(b r0) {
        return r0.e;
    }

    private final boolean d(SupportSQLiteDatabase r4, String r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6.query("SELECT 1 FROM sqlite_master WHERE type='table' AND name=? LIMIT 1", new String[]{r5}), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        boolean r8 = ((Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin")).moveToFirst();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L13
        Object r9 = Result.m1421constructorimpl(Boolean.valueOf(r8));     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r9) == false) goto L19;
        r9 = false;
    L19:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private static final boolean d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return g.contains(r1);
    }

    private static final CharSequence e(String r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast('`' + r2 + '`', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final List<String> e(SupportSQLiteDatabase r2, String r3) {
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query(r3), Closeable.class, "com.obric.memorydata.plugin");
        String[] r5 = ((Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin")).getColumnNames();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r5, "getColumnNames(...)");     // Catch: Throwable -> L6
        List<String> r6 = ArraysKt.toList((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r4, null);
        return r6;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    private static final CharSequence f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast('`' + r2 + '`', CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Pair lambda$ImI1Rid3N5tvSIt38cHlQ77JehU(Map r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$J44qTa8eOVGHO6376X3oOlh5Siw(String r0) {
        return c(r0);
    }

    public static /* synthetic */ boolean lambda$KMGMbvSYcZnEKdTn1jzqSj3AE0U(String r0) {
        return b(r0);
    }

    public static /* synthetic */ CharSequence lambda$QUDxQ2FgBqD4X6OFT0kW32jNgxg(String r0) {
        return f(r0);
    }

    public static /* synthetic */ boolean lambda$Tq15AWxTJsKiJuNVri8t6CJbIBg(Method r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$UiXdaRdOIBFs6viyZXEVbxWhnZ8(Map r0, Map r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$lJQAcpCKTEHV6Ah8zJf5aqWy3KE(Method r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$mreXcgxPHh-_37-YmDSuCChBasc, reason: not valid java name */
    public static /* synthetic */ boolean m1040lambda$mreXcgxPHh_37YmDSuCChBasc(b r0, SupportSQLiteDatabase r1, SupportSQLiteDatabase r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean lambda$oyebvfwx2V9_u_3jYAly9BwAvnE(String r0) {
        return d(r0);
    }

    public static /* synthetic */ boolean lambda$rvPuA3jo8OVFDQZo_gfInZw30fI(b r0, SupportSQLiteDatabase r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$yTPmCF7APzOr5z0QXZkepgxEP3M(Set r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$zcARdrzXirxG8KcMrQjAfrr11uc(String r0) {
        return e(r0);
    }

    public final Object a(File r10, File r11, com.obric.memorydata.migration.sdk.b r12, m r13, Continuation<? super z<Unit>> r14) {
        return a(r10, r11, r12, false, (m) ZeusTransformUtils.wrapperContextForParams(r13, m.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object a(File r13, File r14, com.obric.memorydata.migration.sdk.b r15, boolean r16, m r17, Continuation<? super z<Unit>> r18) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r17, m.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DbImporter$restore$3(r15, this, r13, r16, r14, r8, null), Function2.class, "com.obric.memorydata.plugin"), r0);
    }
}
