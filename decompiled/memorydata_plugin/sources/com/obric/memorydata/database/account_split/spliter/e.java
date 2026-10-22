package com.obric.memorydata.database.account_split.spliter;

import android.database.Cursor;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.account_split.x;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.memorydata.middleware.database.i;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 <2\u00020\u0001:\u0005<=>?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J6\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J=\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\"J(\u0010#\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0017H\u0002J:\u0010$\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u00142\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J4\u0010%\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u001a\u0010&\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u0014H\u0002J.\u0010'\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002J.\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002J \u0010+\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0002J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00142\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u001e\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u0014H\u0002J\u001a\u00103\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0002J.\u00107\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J&\u00108\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001a2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J \u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002¨\u0006A"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator;", "", "<init>", "()V", "copyTableIfNeeded", "", "spec", "Lcom/obric/memorydata/database/account_split/PersonalDbSplitTableSpec;", "profile", "Lcom/obric/memorydata/middleware/database/PersonalDbSplitProfile;", "globalSqlDb", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "deleteCopiedSourceTableIfNeeded", "", "copyPageToPersonalWithRetry", "Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$CopyPageResult;", "personalSqlDb", "copyPlan", "Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$CopyPlan;", "rowIds", "", "", "replaceSingleRowWithRetry", "", "row", "", "", "rowId", "queryRowIdsByMigrationMark", "db", "tableName", "migrationMarkColumn", "migrated", "afterRowId", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;)Ljava/util/List;", "hasRowsByMigrationMark", "querySourceRowsByRowIds", "replaceRowsOrThrow", "rows", "replaceRowOrThrow", "bindReplaceRow", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "buildCopyPlan", "sourceDb", "targetDb", "loadTableColumns", "Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$TableColumn;", "isGeneratedIntegerPrimaryKey", "column", "allColumns", "readCursorValue", "cursor", "Landroid/database/Cursor;", "index", "markRowsCopied", "deleteRowsByRowIds", "checkDeadline", "deadline", TypedValues.CycleType.S_WAVE_PHASE, "Companion", "CopyPageResult", "TableColumn", "CopyColumn", "CopyPlan", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f8822a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "REPLACE_RETRY_COUNT", "TABLE_MIGRATION_TIMEOUT_MS", "", "SOURCE_ROW_ID_ALIAS", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$CopyColumn;", "", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$TableColumn;", "sourceName", "", "<init>", "(Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$TableColumn;Ljava/lang/String;)V", "getTarget", "()Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$TableColumn;", "getSourceName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C0452e f8823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8824b;

        public b(C0452e r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
            Intrinsics.checkNotNullParameter(r3, "sourceName");
            this.f8823a = r2;
            this.f8824b = r3;
        }

        public final C0452e a() {
            return this.f8823a;
        }

        public final String b() {
            return this.f8824b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8823a, r6.f8823a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8824b, r6.f8824b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8823a.hashCode() * 31) + this.f8824b.hashCode();
        }

        public String toString() {
            return "CopyColumn(target=" + this.f8823a + ", sourceName=" + this.f8824b + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$CopyPageResult;", "", "copiedRowIds", "", "", "skippedRowIds", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getCopiedRowIds", "()Ljava/util/List;", "getSkippedRowIds", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Long> f8825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Long> f8826b;

        public c(List<Long> r3, List<Long> r4) {
            List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "copiedRowIds");
            Intrinsics.checkNotNullParameter(r6, "skippedRowIds");
            this.f8825a = r5;
            this.f8826b = r6;
        }

        public final List<Long> a() {
            return this.f8825a;
        }

        public final List<Long> b() {
            return this.f8826b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8825a, r6.f8825a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8826b, r6.f8826b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8825a.hashCode() * 31) + this.f8826b.hashCode();
        }

        public String toString() {
            return "CopyPageResult(copiedRowIds=" + this.f8825a + ", skippedRowIds=" + this.f8826b + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$CopyPlan;", "", "sourceTableName", "", "primaryKeyColumns", "", "copyColumns", "Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$CopyColumn;", "replaceSql", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getSourceTableName", "()Ljava/lang/String;", "getPrimaryKeyColumns", "()Ljava/util/List;", "getCopyColumns", "getReplaceSql", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f8828b;
        private final List<b> c;
        private final String d;

        public d(String r3, List<String> r4, List<b> r5, String r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<b> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "sourceTableName");
            Intrinsics.checkNotNullParameter(r7, "primaryKeyColumns");
            Intrinsics.checkNotNullParameter(r8, "copyColumns");
            Intrinsics.checkNotNullParameter(r6, "replaceSql");
            this.f8827a = r3;
            this.f8828b = r7;
            this.c = r8;
            this.d = r6;
        }

        public final String a() {
            return this.f8827a;
        }

        public final List<String> b() {
            return this.f8828b;
        }

        public final List<b> c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8827a, r6.f8827a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8828b, r6.f8828b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f8827a.hashCode() * 31) + this.f8828b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "CopyPlan(sourceTableName=" + this.f8827a + ", primaryKeyColumns=" + this.f8828b + ", copyColumns=" + this.c + ", replaceSql=" + this.d + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.database.account_split.spliter.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitTableMigrator$TableColumn;", "", ActivityLifecycle.NAME, "", "notNull", "", "defaultValue", "primaryKeyOrder", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getNotNull", "()Z", "getDefaultValue", "getPrimaryKeyOrder", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0452e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8830b;
        private final String c;
        private final int d;

        public C0452e(String r2, boolean r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            this.f8829a = r2;
            this.f8830b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final String a() {
            return this.f8829a;
        }

        public final boolean b() {
            return this.f8830b;
        }

        public final String c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0452e.class) == true) goto L8;
            return false;
        L8:
            C0452e r6 = (C0452e) ZeusTransformUtils.preCheckCast(r5, C0452e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8829a, r6.f8829a) == true) goto L12;
            return false;
        L12:
            if (this.f8830b == r6.f8830b) goto L15;
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
            int r0 = ((this.f8829a.hashCode() * 31) + Boolean.hashCode(this.f8830b)) * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Integer.hashCode(this.d);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TableColumn(name=" + this.f8829a + ", notNull=" + this.f8830b + ", defaultValue=" + this.c + ", primaryKeyOrder=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((C0452e) ZeusTransformUtils.preCheckCast(r2, C0452e.class, "com.obric.memorydata.plugin")).d()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((C0452e) ZeusTransformUtils.preCheckCast(r3, C0452e.class, "com.obric.memorydata.plugin")).d()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f8822a = new a(null);
    }

    public e() {
    }

    private final c a(SupportSQLiteDatabase r18, SupportSQLiteDatabase r19, d r20, List<Long> r21) {
        SupportSQLiteDatabase r0 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r18, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r19, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<Long> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        List<Map<String, Object>> r2 = a(r0, r20, r1);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Object r6 = MapsKt.getValue((Map) ZeusTransformUtils.preCheckCast(r5.next(), Map.class, "com.obric.memorydata.plugin"), "__personalDbSplitSourceRowId");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Long");
        r4.add(Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin")).longValue()));
        goto L4
    L6:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        List r8 = CollectionsKt.minus((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        if (r2.isEmpty() == true) goto L9;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L12
        ((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin")).b(r10, r20, r2);     // Catch: Throwable -> L12
        Object r11 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L15:
        if (Result.m1428isSuccessimpl(r11) == false) goto L18;
        Unit r12 = (Unit) ZeusTransformUtils.preCheckCast(r11, Unit.class, "com.obric.memorydata.plugin");
        return new c(r7, r8);
    L18:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r11);
        if (r13 == null) goto L21;
        RunLog.INSTANCE.warn("db_iso_PersonalDbSplitTableMigrator", "migration copy page replace failed, table=" + r20.a() + ", rows=" + r2.size(), r13);
    L21:
        List r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r15 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r16.hasNext() == false) goto L30;
        Map<String, ? extends Object> r17 = (Map) ZeusTransformUtils.preCheckCast(r16.next(), Map.class, "com.obric.memorydata.plugin");
        Object r22 = MapsKt.getValue(r17, "__personalDbSplitSourceRowId");
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.Long");
        long r110 = ((Long) ZeusTransformUtils.preCheckCast(r22, Long.class, "com.obric.memorydata.plugin")).longValue();
        if (a(r10, r20, r17, r110) == false) goto L27;
        Long r23 = Long.valueOf(r110);
        Object r24 = ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin");
    L28:
        ((Collection) r24).add(r23);
        goto L23
    L27:
        r23 = Long.valueOf(r110);
        r24 = ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin");
        goto L28
    L30:
        return new c(r14, r15);
    L12:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L9:
        return new c(CollectionsKt.emptyList(), r8);
    }

    private final d a(x r13, SupportSQLiteDatabase r14, SupportSQLiteDatabase r15) {
        SupportSQLiteDatabase r16 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r14, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r17 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r15, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(a(r16, r13.i()), Iterable.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r18, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r18.iterator();
    L4:
        if (r19.hasNext() == false) goto L6;
        Object r3 = r19.next();
        r2.put(((C0452e) ZeusTransformUtils.preCheckCast(r3, C0452e.class, "com.obric.memorydata.plugin")).a(), r3);
        goto L4
    L6:
        List<C0452e> r110 = a(r17, r13.j());
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r111.iterator();
    L7:
        boolean r5 = false;
        if (r112.hasNext() == false) goto L14;
        Object r6 = r112.next();
        if (((C0452e) ZeusTransformUtils.preCheckCast(r6, C0452e.class, "com.obric.memorydata.plugin")).d() <= 0) goto L12;
        r5 = true;
    L12:
        if (r5 == false) goto L7;
        r4.add(r6);
        goto L7
    L14:
        Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new f(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r114 = r113.iterator();
    L16:
        if (r114.hasNext() == false) goto L18;
        r7.add(((C0452e) ZeusTransformUtils.preCheckCast(r114.next(), C0452e.class, "com.obric.memorydata.plugin")).a());
        goto L16
    L18:
        List r115 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r115, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L70;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L34;
        C0452e r11 = (C0452e) ZeusTransformUtils.preCheckCast(r10.next(), C0452e.class, "com.obric.memorydata.plugin");
        b r12 = null;
        if (r13.k().contains(r11.a()) == true) goto L32;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r13.l().get(r11.a()), String.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L30;
        r20 = r11.a();
    L30:
        if (r2.containsKey(r20) == false) goto L32;
        r12 = new b(r11, r20);
    L32:
        if (r12 == null) goto L22;
        r9.add(r12);
        goto L22
    L34:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L36:
        if (r24.hasNext() == false) goto L38;
        r23.add(((b) ZeusTransformUtils.preCheckCast(r24.next(), b.class, "com.obric.memorydata.plugin")).a().a());
        goto L36
    L38:
        Set r25 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r28 = r26.iterator();
    L40:
        if (r28.hasNext() == false) goto L55;
        Object r29 = r28.next();
        C0452e r30 = (C0452e) ZeusTransformUtils.preCheckCast(r29, C0452e.class, "com.obric.memorydata.plugin");
        if (r25.contains(r30.a()) == false) goto L44;
    L52:
        boolean r31 = false;
    L53:
        if (r31 == false) goto L40;
        r27.add(r29);
        goto L40
    L44:
        if (r13.k().contains(r30.a()) == true) goto L52;
        if (r30.c() != null) goto L52;
        if (r30.b() == false) goto L52;
        if (a(r30, r110) == true) goto L52;
        r31 = true;
        goto L53
    L55:
        List r116 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin");
        if (r116.isEmpty() == true) goto L63;
        StringBuilder r117 = new StringBuilder().append("Personal DB split copy invalid, target=").append(r13.j()).append(", missing required columns=");
        Iterable r118 = (Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin");
        Collection r119 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r120 = r118.iterator();
    L59:
        if (r120.hasNext() == false) goto L62;
        r119.add(((C0452e) ZeusTransformUtils.preCheckCast(r120.next(), C0452e.class, "com.obric.memorydata.plugin")).a());
        goto L59
    L62:
        throw new IllegalArgumentException(r117.append((List) ZeusTransformUtils.preCheckCast(r119, List.class, "com.obric.memorydata.plugin")).toString().toString());
    L63:
        Iterable r121 = (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin");
        Collection r122 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r123 = r121.iterator();
    L65:
        if (r123.hasNext() == false) goto L67;
        r122.add(((b) ZeusTransformUtils.preCheckCast(r123.next(), b.class, "com.obric.memorydata.plugin")).a().a());
        goto L65
    L67:
        List r124 = (List) ZeusTransformUtils.preCheckCast(r122, List.class, "com.obric.memorydata.plugin");
        return new d(r13.i(), r115, r21, "INSERT OR REPLACE INTO " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r13.j()) + " (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r124, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$IdXYmf5swtYLZXhDberLXnEnA.INSTANCE, 30, null) + ") VALUES (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r124, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$64tL3o9pXH2Gahvea9BYK08G30I.INSTANCE, 30, null) + ')');
    L70:
        throw new IllegalArgumentException(("No primary key found for split migration target table " + r13.j()).toString());
    }

    private static final CharSequence a(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final Object a(Cursor r4, int r5) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        int r6 = r3.getType(r5);
        if (r6 != 0) goto L5;
        return null;
    L5:
        if (r6 != 1) goto L7;
        Object r7 = Long.valueOf(r3.getLong(r5));
    L18:
        return (Serializable) ZeusTransformUtils.preCheckCast(r7, Serializable.class, "com.obric.memorydata.plugin");
    L7:
        if (r6 != 2) goto L9;
        r7 = Double.valueOf(r3.getDouble(r5));
        goto L18
    L9:
        if (r6 != 3) goto L11;
        r7 = r3.getString(r5);
        goto L18
    L11:
        if (r6 != 4) goto L20;
        r7 = r3.getBlob(r5);
        goto L18
    L20:
        return null;
    }

    private final List<Map<String, Object>> a(SupportSQLiteDatabase r25, d r26, List<Long> r27) {
        SupportSQLiteDatabase r0 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r25, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<Long> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == true) goto L5;
        String r3 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$fGoZqlmTrQoQSbxk9RR6iqCQsYc.INSTANCE, 30, null);
        String r4 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r26.b(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$n4zhFpqu5w8VZuLsUngXpPiU48.INSTANCE, 30, null);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r26.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r6.add(((b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.memorydata.plugin")).b());
        goto L8
    L10:
        List r8 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r0.query(StringsKt.trimIndent("\n            SELECT " + (CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$p9Dhxx3fGQq362WxozTgmsX3OzQ.INSTANCE, 30, null) + ", rowid AS " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a("__personalDbSplitSourceRowId")) + "\n            FROM " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r26.a()) + "\n            WHERE rowid IN (" + r3 + ")\n            ORDER BY " + r4 + "\n            "), com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r2)), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r10 = (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        List r11 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L22
    L13:
        if (r10.moveToNext() == false) goto L19;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));     // Catch: Throwable -> L22
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L22
    L16:
        if (r14.hasNext() == false) goto L18;
        Object r15 = r14.next();     // Catch: Throwable -> L22
        ((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin")).put(r15, a(r10, r10.getColumnIndexOrThrow((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L22
        goto L16
    L18:
        Map r16 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
        r16.put("__personalDbSplitSourceRowId", Long.valueOf(r10.getLong(r10.getColumnIndexOrThrow("__personalDbSplitSourceRowId"))));     // Catch: Throwable -> L22
        r11.add(r16);     // Catch: Throwable -> L22
        goto L13
    L19:
        List<Map<String, Object>> r1 = CollectionsKt.build(r11);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r9, null);
        return r1;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<C0452e> a(SupportSQLiteDatabase r12, String r13) {
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r12, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("PRAGMA table_info(" + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r13) + ')'), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        int r1 = r14.getColumnIndexOrThrow(ActivityLifecycle.NAME);     // Catch: Throwable -> L21
        int r2 = r14.getColumnIndexOrThrow("notnull");     // Catch: Throwable -> L21
        int r3 = r14.getColumnIndexOrThrow("dflt_value");     // Catch: Throwable -> L21
        int r4 = r14.getColumnIndexOrThrow("pk");     // Catch: Throwable -> L21
        List r5 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L21
    L4:
        boolean r7 = true;
        String r8 = null;
        if (r14.moveToNext() == false) goto L15;
        String r9 = r14.getString(r1);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");     // Catch: Throwable -> L21
        if (r14.getInt(r2) != 0) goto L11;
        r7 = false;
    L11:
        if (r14.isNull(r3) == true) goto L14;
        r8 = r14.getString(r3);     // Catch: Throwable -> L21
    L14:
        r5.add(new C0452e(r9, r7, r8, r14.getInt(r4)));     // Catch: Throwable -> L21
        goto L4
    L15:
        List<C0452e> r15 = CollectionsKt.build(r5);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r11, null);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        return r15;
    L20:
        throw new IllegalArgumentException(("Table " + r13 + " not found for split migration").toString());
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    private final List<Long> a(SupportSQLiteDatabase r7, String r8, String r9, boolean r10, Long r11) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L5;
        String r12 = "";
    L7:
        if (r11 != null) goto L9;
        Object[] r13 = {Integer.valueOf(r10 ? 1 : 0), 200};
    L10:
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r6.query(StringsKt.trimIndent("\n            SELECT rowid\n            FROM " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r8) + "\n            WHERE " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r9) + " = ?\n            " + r12 + "\n            ORDER BY rowid\n            LIMIT ?\n            "), r13), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r15 = (Cursor) ZeusTransformUtils.preCheckCast(r14, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        List r16 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L18
    L13:
        if (r15.moveToNext() == false) goto L15;
        r16.add(Long.valueOf(r15.getLong(0)));     // Catch: Throwable -> L18
        goto L13
    L15:
        List<Long> r17 = CollectionsKt.build(r16);     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r14, null);
        return r17;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L9:
        r13 = new Object[]{Integer.valueOf(r10 ? 1 : 0), r11, 200};
        goto L10
    L5:
        r12 = "AND rowid > ?";
        goto L7
    }

    private final void a(long r3, String r5, String r6) {
        if (SystemClock.elapsedRealtime() >= r3) goto L6;
        return;
    L6:
        throw new PersonalDbSplitMigrationTimeoutException(r5, r6);
    }

    private static final void a(SupportSQLiteDatabase r4, d r5, List r6, e r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r8.compileStatement(r5.d()), Closeable.class, "com.obric.memorydata.plugin");
        SupportSQLiteStatement r0 = (SupportSQLiteStatement) ZeusTransformUtils.preCheckCast(r10, SupportSQLiteStatement.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r11.hasNext() == false) goto L7;
        r7.a(r0, r5, (Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        r0.executeInsert();     // Catch: Throwable -> L10
        r0.clearBindings();     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r10, null);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private final void a(SupportSQLiteDatabase r3, d r4, Map<String, ? extends Object> r5) {
        b((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), r4, CollectionsKt.listOf((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")));
    }

    private final void a(SupportSQLiteDatabase r11, String r12, String r13, List<Long> r14) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<Long> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if (r15.isEmpty() == false) goto L5;
        return;
    L5:
        r10.execSQL(StringsKt.trimIndent("\n            UPDATE " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r12) + "\n            SET " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r13) + " = 1\n            WHERE rowid IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$QS5PWAw81K267u4sqzs83AKE020.INSTANCE, 30, null) + ")\n            "), com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r15));
    }

    private final void a(SupportSQLiteDatabase r11, String r12, List<Long> r13) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<Long> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L5;
        return;
    L5:
        r10.execSQL("DELETE FROM " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r12) + " WHERE rowid IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$1fc2kRTmAv5JAcxWoJYZiqjwc1c.INSTANCE, 30, null) + ')', com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r14));
    }

    private final void a(SupportSQLiteStatement r6, d r7, Map<String, ? extends Object> r8) {
        SupportSQLiteStatement r5 = (SupportSQLiteStatement) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r10.hasNext() == false) goto L26;
        Object r2 = r10.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin");
        Object r11 = r9.get(r4.b());
        if (r11 != null) goto L12;
        r5.bindNull(r3);
    L23:
        r1 = r3;
        goto L4
    L12:
        if (ZeusTransformUtils.instanceOf(r11, Long.class) == false) goto L15;
        r5.bindLong(r3, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L23
    L15:
        if (ZeusTransformUtils.instanceOf(r11, Double.class) == false) goto L18;
        r5.bindDouble(r3, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L23
    L18:
        if (ZeusTransformUtils.instanceOf(r11, String.class) == false) goto L21;
        r5.bindString(r3, (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"));
        goto L23
    L21:
        if ((r11 instanceof byte[]) == false) goto L25;
        r5.bindBlob(r3, (byte[]) ZeusTransformUtils.preCheckCast(r11, byte[].class, "com.obric.memorydata.plugin"));
        goto L23
    L25:
        throw new IllegalStateException(("Unsupported SQLite value type " + r11.getClass().getName() + ", table=" + r7.a() + ", column=" + r4.b()).toString());
    }

    private static final void a(e r2, SupportSQLiteDatabase r3, String r4, x r5, List r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<Long> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        r2.a(r7, r4, r5.h_(), r8);
    }

    private static final void a(e r2, SupportSQLiteDatabase r3, String r4, List r5) {
        r2.a((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(SupportSQLiteDatabase r15, d r16, Map<String, ? extends Object> r17, long r18) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r15, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
        int r7 = 0;
    L4:
        if (r7 >= 3) goto L29;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        ((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin")).a(r4, r16, r5);     // Catch: Throwable -> L11
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L20:
        if (Result.m1428isSuccessimpl(r1) == true) goto L21;
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 == null) goto L28;
        RunLog.INSTANCE.warn("db_iso_PersonalDbSplitTableMigrator", "migration copy row replace failed, table=" + r16.a() + ", rowId=" + r18 + ", attempt=" + (r7 + 1), r2);
    L28:
        r7 = r7 + 1;
        goto L4
    L21:
        Unit r3 = (Unit) ZeusTransformUtils.preCheckCast(r1, Unit.class, "com.obric.memorydata.plugin");
        if (r7 <= 0) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration copy row replace recovered, table=" + r16.a() + ", rowId=" + r18 + ", attempts=" + (r7 + 1), false, 4, null);
    L24:
        return true;
    L11:
        th = th;
    L18:
        Result.Companion r10 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L13:
        th = th;
    L15:
        th = th;
        goto L18
    L29:
        return false;
    }

    private final boolean a(SupportSQLiteDatabase r3, String r4, String r5, boolean r6) {
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query(StringsKt.trimIndent("\n            SELECT 1\n            FROM " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r4) + "\n            WHERE " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r5) + " = ?\n            LIMIT 1\n            "), new Object[]{Integer.valueOf(r6 ? 1 : 0)}), Closeable.class, "com.obric.memorydata.plugin");
        boolean r7 = ((Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin")).moveToFirst();     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r2, null);
        return r7;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private final boolean a(C0452e r5, List<C0452e> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r5.d() <= 0) goto L23;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L7;
    L9:
        Iterator r8 = r7.iterator();
        int r9 = 0;
    L11:
        if (r8.hasNext() == false) goto L20;
        if (((C0452e) ZeusTransformUtils.preCheckCast(r8.next(), C0452e.class, "com.obric.memorydata.plugin")).d() <= 0) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L11;
        r9 = r9 + 1;
        if (r9 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
        goto L11
    L15:
        r2 = false;
    L20:
        if (r9 != 1) goto L23;
        return true;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
        r9 = 0;
    L23:
        return false;
    }

    private static final CharSequence b(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final void b(SupportSQLiteDatabase r3, final d r4, List<? extends Map<String, ? extends Object>> r5) {
        final SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().runInTransaction(new $$Lambda$e$C94W9ZBFkpmnPS4sS9NijT4ervk(r6, r4, r7, this));
    }

    private static final CharSequence c(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$-kdBgDvVRL-dui70Tv83jaTgKqI, reason: not valid java name */
    public static /* synthetic */ void m534lambda$kdBgDvVRLdui70Tv83jaTgKqI(e r0, SupportSQLiteDatabase r1, String r2, List r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ CharSequence lambda$1fc2kRTmAv5JAcxWoJYZiqjwc1c(long r0) {
        return c(r0);
    }

    public static /* synthetic */ CharSequence lambda$64tL3o9pXH2Gahvea9BYK08G30I(String r0) {
        return d(r0);
    }

    public static /* synthetic */ void lambda$C94W9ZBFkpmnPS4sS9NijT4ervk(SupportSQLiteDatabase r0, d r1, List r2, e r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$IdXYmf5swtYL-ZXhDber-LXnEnA, reason: not valid java name */
    public static /* synthetic */ CharSequence m535lambda$IdXYmf5swtYLZXhDberLXnEnA(String r0) {
        return c(r0);
    }

    public static /* synthetic */ void lambda$PFow_gpsQ6RSW1gpxt14qE8QsyI(e r0, SupportSQLiteDatabase r1, String r2, x r3, List r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ CharSequence lambda$QS5PWAw81K267u4sqzs83AKE020(long r0) {
        return b(r0);
    }

    public static /* synthetic */ CharSequence lambda$fGoZqlmTrQoQSbxk9RR6iqCQsYc(long r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$n4zhFpq-u5w8VZuLsUngXpPiU48, reason: not valid java name */
    public static /* synthetic */ CharSequence m536lambda$n4zhFpqu5w8VZuLsUngXpPiU48(String r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$p9Dhxx3fGQq362WxozTgmsX3OzQ(String r0) {
        return b(r0);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    public final int a(final x r44, i r45, SupportSQLiteDatabase r46) {
        e r0 = this;
        String r8 = ", cost=";
        SupportSQLiteDatabase r12 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r46, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r44, "spec");
        Intrinsics.checkNotNullParameter(r45, "profile");
        Intrinsics.checkNotNullParameter(r12, "globalSqlDb");
        final String r15 = r44.i();
        IStore r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r4 = "personal_sql_split_copy_table_done_" + r15;
        String r3 = ", anonymous=";
        String r2 = ", table=";
        if (r5.getBoolean(r4, false) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration copy table skipped, profileId=" + q.f13259a.b(r45.a()) + ", anonymous=" + r45.c() + ", table=" + r15 + ", doneKey=" + r4, false, 4, null);
        return 0;
    L6:
        long r24 = System.currentTimeMillis();
        IStore r20 = r5;
        long r6 = SystemClock.elapsedRealtime() + 600000;
        SupportSQLiteDatabase r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getWritableDatabase();     // Catch: Throwable -> L92
        d r14 = r0.a(r44, r12, r1);     // Catch: Throwable -> L90
        SupportSQLiteDatabase r17 = r1;
        String r18 = r4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration copy table start, profileId=" + q.f13259a.b(r45.a()) + ", anonymous=" + r45.c() + ", table=" + r15 + ", markColumn=" + r44.h_() + ", primaryKeys=" + r14.b() + ", columns=" + r14.c().size(), false, 4, null);     // Catch: Throwable -> L90
        int r7 = 0;
        Long r9 = null;
        int r19 = 0;
    L131:
        r0.a(r6, "copy", r15);     // Catch: Throwable -> L87
        SupportSQLiteDatabase r33 = r17;
        int r32 = r19;
        String r34 = r2;
        String r35 = r3;
        r7 = r7;
        d r110 = r14;
        String r16 = r18;
        r6 = r6;
        IStore r10 = r20;
        r8 = r8;
        List<Long> r11 = a(r12, r15, r44.h_(), false, r9);     // Catch: Throwable -> L84
        if (r11.isEmpty() == true) goto L15;
        r15 = r15;
        r8 = r8;
        c r111 = r0.a(r12, r33, r110, r11);     // Catch: Throwable -> L82
        final List r13 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r111.a(), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r111.b(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L82
        r2 = r34;
        r3 = r35;
        final SupportSQLiteDatabase r21 = r12;
        SupportSQLiteDatabase r26 = r12;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().runInTransaction(new $$Lambda$e$PFow_gpsQ6RSW1gpxt14qE8QsyI(this, r21, r15, r44, r13));     // Catch: Throwable -> L80
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r111.b(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L71;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration copy rows skipped after retry, profileId=" + q.f13259a.b(r45.a()) + r2 + r15 + ", skippedRows=" + r111.b().size(), null, 4, null);     // Catch: Throwable -> L80
    L71:
        r7 = r7 + r111.a().size();
        int r22 = r32 + r111.b().size();
        r15 = r15;
        r2 = r2;
        r3 = r3;
        r20 = r10;
        r18 = r16;
        r14 = r110;
        r12 = r26;
        r17 = r33;
        r8 = r8;
        r9 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r11), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L76
        r19 = r22;
        r0 = this;
    L76:
        th = th;
    L95:
        long r23 = System.currentTimeMillis() - r24;
        RunLog.INSTANCE.error("db_iso_PersonalDbSplitTableMigrator", "migration copy table failed, profileId=" + q.f13259a.b(r45.a()) + r3 + r45.c() + r2 + r15 + ", migrated=" + r7 + ", skipped=" + r22 + r8 + r23, th);
        DatabaseIsolationTracker r112 = DatabaseIsolationTracker.f11642a;
        DatabaseIsolationTracker.SqlMigrationPhase r113 = DatabaseIsolationTracker.SqlMigrationPhase.COPY;
        if (ZeusTransformUtils.instanceOf(th, PersonalDbSplitMigrationTimeoutException.class) == false) goto L98;
        String r114 = LocationMonitorConst.TIMEOUT;
    L100:
        if (ZeusTransformUtils.instanceOf(th, PersonalDbSplitMigrationTimeoutException.class) == false) goto L102;
        String r25 = LocationMonitorConst.TIMEOUT;
    L103:
        r112.a(r113, r114, r15, r7, r22, 0, r23, r25);
        throw th;
    L102:
        r25 = th.getClass().getSimpleName();
        goto L103
    L98:
        r114 = "failed";
    L78:
        th = th;
    L89:
        r22 = r32;
    L80:
        th = th;
    L86:
        r7 = r7;
    L82:
        th = th;
        r2 = r34;
        r3 = r35;
        goto L86
    L15:
        if (r9 != null) goto L135;
    L125:
        r10.save(r16, true);     // Catch: Throwable -> L62
        long r27 = System.currentTimeMillis() - r24;     // Catch: Throwable -> L62
        r32 = r32;
        r8 = r8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration copy table finished, profileId=" + q.f13259a.b(r45.a()) + r35 + r45.c() + r34 + r15 + ", migrated=" + r7 + ", skipped=" + r32 + r8 + r27, false, 4, null);     // Catch: Throwable -> L50
        DatabaseIsolationTracker r28 = DatabaseIsolationTracker.f11642a;     // Catch: Throwable -> L50
        DatabaseIsolationTracker.SqlMigrationPhase r29 = DatabaseIsolationTracker.SqlMigrationPhase.COPY;     // Catch: Throwable -> L50
        if (r32 != 0) goto L39;
        String r30 = "success";
    L40:
        String r115 = r30;
        if (r32 != 0) goto L44;
        String r210 = null;
    L45:
        r15 = r15;
        r28.a(r29, r115, r15, r7, r32, 0, r27, r210);     // Catch: Throwable -> L48
        return r7;
    L48:
        th = th;
    L59:
        r3 = r35;
        r2 = r34;
        goto L86
    L44:
        r210 = "insert_failed_after_retry";
        goto L45
    L39:
        r30 = "partial_success";
    L50:
        th = th;
    L54:
        r32 = r32;
        r15 = r15;
    L52:
        th = th;
        r8 = r8;
    L55:
        th = th;
        r32 = r32;
    L58:
        r15 = r15;
        r8 = r8;
    L57:
        th = th;
    L60:
        th = th;
        r15 = r15;
        r8 = r8;
        r3 = r35;
        r7 = r7;
        r22 = r32;
        r2 = r34;
    L62:
        th = th;
    L22:
        r22 = r32;
        r2 = r34;
        r3 = r35;
        goto L95
    L135:
    L20:
        th = th;
        goto L22
    L17:
        if (r0.a(r12, r15, r44.h_(), false) == false) goto L125;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration copy keyset found remaining rows, restart scan, table=" + r15 + ", lastRowId=" + r9, null, 4, null);     // Catch: Throwable -> L20
        r7 = r7;
        r9 = null;
        r19 = r32;
        r2 = r34;
        r3 = r35;
        r20 = r10;
        r18 = r16;
        r14 = r110;
        r8 = r8;
        r17 = r33;
    L84:
        th = th;
        r15 = r15;
        r8 = r8;
        r2 = r34;
        r3 = r35;
    L87:
        th = th;
        r3 = r3;
        r8 = r8;
        r15 = r15;
        r32 = r19;
        r2 = r2;
    L90:
        th = th;
        int r116 = 0;
    L94:
        r22 = r116;
        r7 = r22;
    L92:
        th = th;
        r116 = 0;
        goto L94
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.obric.memorydata.middleware.database.DatabaseIsolationTracker] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v25, types: [com.obric.memorydata.middleware.database.DatabaseIsolationTracker] */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(x r34, i r35, SupportSQLiteDatabase r36) {
        String r7 = ", cost=";
        final SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r36, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r34, "spec");
        Intrinsics.checkNotNullParameter(r35, "profile");
        Intrinsics.checkNotNullParameter(r10, "globalSqlDb");
        String r15 = r34.i();
        IStore r14 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r6 = "personal_sql_split_delete_table_done_" + r15;
        String r5 = ", table=";
        String r4 = ", anonymous=";
        if (r14.getBoolean(r6, false) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration delete table skipped, profileId=" + q.f13259a.b(r35.a()) + ", anonymous=" + r35.c() + ", table=" + r15 + ", doneKey=" + r6, false, 4, null);
        return;
    L6:
        long r23 = System.currentTimeMillis();
        long r1 = SystemClock.elapsedRealtime() + 600000;
        String r25 = r6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration delete table start, profileId=" + q.f13259a.b(r35.a()) + ", anonymous=" + r35.c() + ", table=" + r15 + ", markColumn=" + r34.h_() + ", keyset=rowid", false, 4, null);     // Catch: Throwable -> L44
        Long r8 = null;
        int r13 = 0;
    L58:
        a(r1, "delete", r15);     // Catch: Throwable -> L40
        r1 = r1;
        String r3 = r15;
        r4 = r4;
        r5 = r5;
        int r9 = 1;
        Long r37 = r8;
        String r26 = r7;
        r25 = r25;
        final List<Long> r2 = a(r10, r3, r34.h_(), true, r8);     // Catch: Throwable -> L38
        ?? r11 = r2.isEmpty();     // Catch: Throwable -> L38
        if (r11 != 0) goto L14;
        int r12 = r13;
        final String r16 = r15;
        String r17 = r26;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().runInTransaction(new $$Lambda$e$kdBgDvVRLdui70Tv83jaTgKqI(this, r10, r16, r2));     // Catch: Throwable -> L36
        r13 = r12 + r2.size();
        r8 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r2), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        r15 = r16;
        r7 = r17;
    L34:
        th = th;
    L21:
        int r18 = r13;
        ?? r19 = r16;
        String r20 = r17;
    L46:
        long r21 = System.currentTimeMillis() - r23;
        RunLog.INSTANCE.error("db_iso_PersonalDbSplitTableMigrator", "migration delete table failed, profileId=" + q.f13259a.b(r35.a()) + r4 + r35.c() + r5 + r19 + ", rows=" + r18 + r20 + r21, th);
        ?? r110 = DatabaseIsolationTracker.f11642a;
        DatabaseIsolationTracker.SqlMigrationPhase r111 = DatabaseIsolationTracker.SqlMigrationPhase.DELETE;
        if (ZeusTransformUtils.instanceOf(th, PersonalDbSplitMigrationTimeoutException.class) == false) goto L49;
        String r112 = LocationMonitorConst.TIMEOUT;
    L51:
        if (ZeusTransformUtils.instanceOf(th, PersonalDbSplitMigrationTimeoutException.class) == false) goto L53;
        String r22 = LocationMonitorConst.TIMEOUT;
    L54:
        r110.a(r111, r112, r19, r18, 0, 0, r21, r22);
        throw th;
    L53:
        r22 = th.getClass().getSimpleName();
        goto L54
    L49:
        r112 = "failed";
    L36:
        th = th;
    L43:
        r18 = r9;
        r19 = r11;
        r20 = r3;
        goto L46
    L14:
        if (r37 == null) goto L22;
    L19:
        th = th;
        r16 = r15;
        r17 = r26;
        goto L21
    L16:
        if (a(r10, r15, r34.h_(), true) == false) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration delete keyset found remaining rows, restart scan, table=" + r15 + ", lastRowId=" + r37, null, 4, null);     // Catch: Throwable -> L19
        r7 = r26;
        r8 = null;
    L22:
        r14.save(r25, true);     // Catch: Throwable -> L38
        long r0 = System.currentTimeMillis() - r23;     // Catch: Throwable -> L38
        r3 = r26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalDbSplitTableMigrator", "migration delete table finished, profileId=" + q.f13259a.b(r35.a()) + r4 + r35.c() + r5 + r15 + ", rows=" + r13 + r3 + r0, false, 4, null);     // Catch: Throwable -> L28
        r9 = r13;
        r11 = r15;
        DatabaseIsolationTracker.f11642a.a(DatabaseIsolationTracker.SqlMigrationPhase.DELETE, "success", r11, r9, 0, 0, r0, null);     // Catch: Throwable -> L36
        return;
    L28:
        th = th;
        r3 = r3;
    L42:
        r9 = r13;
        r11 = r15;
    L38:
        th = th;
        r9 = r13;
        r11 = r15;
        r3 = r26;
    L40:
        th = th;
        r4 = r4;
        r5 = r5;
        r3 = r7;
    L44:
        th = th;
        r4 = ", anonymous=";
        r5 = ", table=";
        r20 = ", cost=";
        r19 = r15;
        r18 = 0;
        goto L46
    }
}
