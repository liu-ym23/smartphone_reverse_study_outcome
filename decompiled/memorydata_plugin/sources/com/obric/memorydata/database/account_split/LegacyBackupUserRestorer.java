package com.obric.memorydata.database.account_split;

import android.database.Cursor;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004:;<=B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0005H\u0003JB\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0018\"\u000e\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u001dH\u0003J:\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002J@\u0010%\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0018\"\u000e\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00180\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00190'2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u001dH\u0002J<\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0'2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010/H\u0002J\u001e\u00100\u001a\b\u0012\u0004\u0012\u0002010'2\u0006\u0010)\u001a\u00020*2\u0006\u00102\u001a\u00020\u0005H\u0002J\u001e\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u0002012\f\u00105\u001a\b\u0012\u0004\u0012\u0002010'H\u0002J\u001a\u00106\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "TABLE_RESTORE_TIMEOUT_MS", "", "KEY_RESTORED_PREFIX", "scope", "Lkotlinx/coroutines/CoroutineScope;", "job", "Lkotlinx/coroutines/Job;", "restoreUserIfNeeded", "", "userId", "onFinished", "Lkotlin/Function1;", "", "restoreUserIfNeededBlocking", "restoreTable", "Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$RestoreTableResult;", "S", "B", "Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;", "latestDbVersion", "spec", "Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec;", "trackRestore", "indexedRows", "directRows", "fkDroppedRows", "durationMs", "status", "failureReason", "copyBackupRowsToPersonal", "backups", "", "replaceBackupRow", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "targetTableName", "copyColumns", "Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$BackupCopyColumn;", "values", "", "loadTableColumns", "Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$TableColumn;", "tableName", "isGeneratedIntegerPrimaryKey", "column", "allColumns", "readCursorValue", "cursor", "Landroid/database/Cursor;", "index", "TableColumn", "BackupCopyColumn", "LegacyBackupRestoreTimeoutException", "RestoreTableResult", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LegacyBackupUserRestorer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LegacyBackupUserRestorer f8803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f8804b = null;
    private static volatile bx c;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$LegacyBackupRestoreTimeoutException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "tableName", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "<init>", "(Ljava/lang/String;I)V", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class LegacyBackupRestoreTimeoutException extends IllegalStateException {
        public LegacyBackupRestoreTimeoutException(String r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "tableName");
            super("Legacy backup restore timed out, table=" + r3 + ", offset=" + r4);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$BackupCopyColumn;", "", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$TableColumn;", "backupSourceName", "", "<init>", "(Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$TableColumn;Ljava/lang/String;)V", "getTarget", "()Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$TableColumn;", "getBackupSourceName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f8805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8806b;

        public a(c r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
            Intrinsics.checkNotNullParameter(r3, "backupSourceName");
            this.f8805a = r2;
            this.f8806b = r3;
        }

        public final c a() {
            return this.f8805a;
        }

        public final String b() {
            return this.f8806b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8805a, r6.f8805a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8806b, r6.f8806b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8805a.hashCode() * 31) + this.f8806b.hashCode();
        }

        public String toString() {
            return "BackupCopyColumn(target=" + this.f8805a + ", backupSourceName=" + this.f8806b + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$RestoreTableResult;", "", "indexedRows", "", "directRows", "fkDroppedRows", "<init>", "(III)V", "getIndexedRows", "()I", "getDirectRows", "getFkDroppedRows", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f8808b;
        private final int c;

        public b(int r1, int r2, int r3) {
            this.f8807a = r1;
            this.f8808b = r2;
            this.c = r3;
        }

        public final int a() {
            return this.f8807a;
        }

        public final int b() {
            return this.f8808b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f8807a == r6.f8807a) goto L12;
            return false;
        L12:
            if (this.f8808b == r6.f8808b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f8807a) * 31) + Integer.hashCode(this.f8808b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "RestoreTableResult(indexedRows=" + this.f8807a + ", directRows=" + this.f8808b + ", fkDroppedRows=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/account_split/LegacyBackupUserRestorer$TableColumn;", "", ActivityLifecycle.NAME, "", "notNull", "", "defaultValue", "primaryKeyOrder", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getNotNull", "()Z", "getDefaultValue", "getPrimaryKeyOrder", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8810b;
        private final String c;
        private final int d;

        public c(String r2, boolean r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            this.f8809a = r2;
            this.f8810b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final String a() {
            return this.f8809a;
        }

        public final boolean b() {
            return this.f8810b;
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
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8809a, r6.f8809a) == true) goto L12;
            return false;
        L12:
            if (this.f8810b == r6.f8810b) goto L15;
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
            int r0 = ((this.f8809a.hashCode() * 31) + Boolean.hashCode(this.f8810b)) * 31;
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
            return "TableColumn(name=" + this.f8809a + ", notNull=" + this.f8810b + ", defaultValue=" + this.c + ", primaryKeyOrder=" + this.d + ')';
        }
    }

    static {
        f8803a = new LegacyBackupUserRestorer();
        f8804b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private LegacyBackupUserRestorer() {
    }

    private final <S, B extends com.obric.memorydata.database.backup.a.a<S>> int a(List<? extends B> r22, l<S, B> r23) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (r1.isEmpty() == false) goto L5;
        return 0;
    L5:
        SupportSQLiteDatabase r3 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getWritableDatabase();
        SupportSQLiteDatabase r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getWritableDatabase();
        List<c> r6 = a(r5, r23.j());
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(a(r3, r23.g().getTableName()), Iterable.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Object r10 = r2.next();
        r8.put(((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")).a(), r10);
        goto L7
    L9:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L11:
        if (r9.hasNext() == false) goto L20;
        c r12 = (c) ZeusTransformUtils.preCheckCast(r9.next(), c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r12.a(), "personalDbSplitMigrated") == false) goto L15;
    L14:
        a r13 = null;
    L18:
        if (r13 == null) goto L11;
        r11.add(r13);
        goto L11
    L15:
        String r14 = "backup_" + r12.a();
        if (r8.containsKey(r14) == false) goto L14;
        r13 = new a(r12, r14);
        goto L18
    L20:
        List<a> r15 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L22:
        if (r18.hasNext() == false) goto L24;
        r17.add(((a) ZeusTransformUtils.preCheckCast(r18.next(), a.class, "com.obric.memorydata.plugin")).a().a());
        goto L22
    L24:
        Set r19 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r110.iterator();
    L26:
        if (r112.hasNext() == false) goto L41;
        Object r113 = r112.next();
        c r114 = (c) ZeusTransformUtils.preCheckCast(r113, c.class, "com.obric.memorydata.plugin");
        if (r19.contains(r114.a()) == false) goto L30;
    L38:
        boolean r115 = false;
    L39:
        if (r115 == false) goto L26;
        r111.add(r113);
        goto L26
    L30:
        if (Intrinsics.areEqual(r114.a(), "personalDbSplitMigrated") == true) goto L38;
        if (r114.c() != null) goto L38;
        if (r114.b() == false) goto L38;
        if (f8803a.a(r114, r6) == true) goto L38;
        r115 = true;
        goto L39
    L41:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin");
        if (r20.isEmpty() == true) goto L49;
        StringBuilder r21 = new StringBuilder().append("Legacy backup restore copy invalid, target=").append(r23.j()).append(", backup=").append(r23.g().getTableName()).append(", missing required columns=");
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L45:
        if (r26.hasNext() == false) goto L48;
        r25.add(((c) ZeusTransformUtils.preCheckCast(r26.next(), c.class, "com.obric.memorydata.plugin")).a());
        goto L45
    L48:
        throw new IllegalArgumentException(r21.append((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin")).toString().toString());
    L49:
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r27, Collection.class) == true) goto L52;
    L54:
        Iterator r28 = r27.iterator();
    L56:
        if (r28.hasNext() == false) goto L53;
        if (((c) ZeusTransformUtils.preCheckCast(r28.next(), c.class, "com.obric.memorydata.plugin")).d() <= 0) goto L60;
        boolean r29 = true;
    L61:
        if (r29 == false) goto L56;
        boolean r116 = true;
    L63:
        if (r116 == false) goto L95;
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r31 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r32 = r30.iterator();
    L66:
        if (r32.hasNext() == false) goto L68;
        r31.add(Long.valueOf(((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r32.next(), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")).c()));
        goto L66
    L68:
        List r33 = (List) ZeusTransformUtils.preCheckCast(r31, List.class, "com.obric.memorydata.plugin");
        String r34 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$LegacyBackupUserRestorer$MuNrdBsnnL3CJLA8HOH0V6Po908.INSTANCE, 30, null);
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r117 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r36 = r35.iterator();
    L70:
        if (r36.hasNext() == false) goto L72;
        r117.add(((a) ZeusTransformUtils.preCheckCast(r36.next(), a.class, "com.obric.memorydata.plugin")).b());
        goto L70
    L72:
        List r37 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r117, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"), OaidModel.KEY_ID);
        String r38 = StringsKt.trimIndent("\n            SELECT " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$LegacyBackupUserRestorer$lXRzsExixrypqSITJMiKAz2PP2U.INSTANCE, 30, null) + "\n            FROM " + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r23.g().getTableName()) + "\n            WHERE id IN (" + r34 + ")\n            ORDER BY id\n            ");
        Iterable r39 = (Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin");
        Collection r118 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r39, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r40 = r39.iterator();
    L74:
        if (r40.hasNext() == false) goto L76;
        r118.add(ZeusTransformUtils.preCheckCast(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r40.next(), Number.class, "com.obric.memorydata.plugin")).longValue()), Object.class, "com.obric.memorydata.plugin"));
        goto L74
    L76:
        Closeable r41 = (Closeable) ZeusTransformUtils.preCheckCast(r3.query(r38, ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r118, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0])), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r42 = (Cursor) ZeusTransformUtils.preCheckCast(r41, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
    L79:
        if (r42.moveToNext() == false) goto L85;
        Iterable r43 = (Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L88
        LinkedHashMap r119 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r43, 10)), 16));     // Catch: Throwable -> L88
        Iterator r44 = r43.iterator();     // Catch: Throwable -> L88
    L82:
        if (r44.hasNext() == false) goto L84;
        Object r120 = r44.next();     // Catch: Throwable -> L88
        ((Map) ZeusTransformUtils.preCheckCast(r119, Map.class, "com.obric.memorydata.plugin")).put(r120, f8803a.a(r42, r42.getColumnIndexOrThrow((String) ZeusTransformUtils.preCheckCast(r120, String.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L88
        goto L82
    L84:
        f8803a.a(r5, r23.j(), r15, (Map) ZeusTransformUtils.preCheckCast(r119, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L88
        r4 = r4 + 1;     // Catch: Throwable -> L88
        goto L79
    L85:
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L88
        CloseableKt.closeFinally(r41, null);
        return r4;
    L88:
        th = move-exception;
        throw th;     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        CloseableKt.closeFinally(r41, th);
        throw th;
    L95:
        throw new IllegalArgumentException(("No primary key found for legacy backup restore target " + r23.j()).toString());
    L60:
        r29 = false;
    L53:
        r116 = false;
        goto L63
    L52:
        if (((Collection) ZeusTransformUtils.preCheckCast(r27, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L54;
        goto L53
    }

    private final <S, B extends com.obric.memorydata.database.backup.a.a<S>> b a(String r26, int r27, l<S, B> r28) {
        String r2 = r28.e().getTableName();
        com.obric.memorydata.database.backup.dao.e<B> r3 = r28.g();
        long r4 = SystemClock.elapsedRealtime() + 300000;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L4:
        if (SystemClock.elapsedRealtime() >= r4) goto L26;
        List<B> r10 = r3.queryByBackupUserId(r26, 200, r6);
        if (r10.isEmpty() == true) goto L7;
        List<B> r14 = r28.a(r10, r27);
        List<? extends B> r15 = r28.a(r14);
        int r16 = r14.size() - r15.size();
        r7 = r7 + r16;
        com.obric.memorydata.database.backup.dao.e<B> r17 = r3;
        if (r16 <= 0) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_LegacyBackupUserRestorer", "restore filtered dangling fk rows, userId=" + com.obric.memorydata.utils.q.f13259a.b(r26) + ", table=" + r2 + ", dropped=" + r16, false, 4, null);
    L14:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        if (r28.d() == false) goto L22;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r5.iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        r11.add(r28.a((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")));
        goto L19
    L21:
        final List r13 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.c.e.f8857a.a(new $$Lambda$LegacyBackupUserRestorer$VN4pAEx5HksawtUlkkGrsN8ao3k(r13));
        r8 = r8 + r13.size();
        goto L24
    L22:
        r9 = r9 + a(r15, r28);
    L24:
        r6 = r6 + r10.size();
        r3 = r17;
        r4 = r4;
        goto L4
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_LegacyBackupUserRestorer", "restore table finished, userId=" + com.obric.memorydata.utils.q.f13259a.b(r26) + ", table=" + r2 + ", indexedRows=" + r8 + ", directRows=" + r9 + ", fkDroppedRows=" + r7, false, 4, null);
        return new b(r8, r9, r7);
    L26:
        throw new LegacyBackupRestoreTimeoutException(r2, r6);
    }

    private static final CharSequence a(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
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

    private final List<c> a(SupportSQLiteDatabase r10, String r11) {
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r10, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("PRAGMA table_info(" + com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r11) + ')'), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r12 = (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        int r13 = r12.getColumnIndexOrThrow(ActivityLifecycle.NAME);     // Catch: Throwable -> L18
        int r0 = r12.getColumnIndexOrThrow("notnull");     // Catch: Throwable -> L18
        int r1 = r12.getColumnIndexOrThrow("dflt_value");     // Catch: Throwable -> L18
        int r2 = r12.getColumnIndexOrThrow("pk");     // Catch: Throwable -> L18
        List r3 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L18
    L4:
        String r5 = null;
        if (r12.moveToNext() == false) goto L15;
        String r6 = r12.getString(r13);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");     // Catch: Throwable -> L18
        if (r12.getInt(r0) == 0) goto L9;
        boolean r7 = true;
    L11:
        if (r12.isNull(r1) == true) goto L14;
        r5 = r12.getString(r1);     // Catch: Throwable -> L18
    L14:
        r3.add(new c(r6, r7, r5, r12.getInt(r2)));     // Catch: Throwable -> L18
        goto L4
    L9:
        r7 = false;
        goto L11
    L15:
        List<c> r14 = CollectionsKt.build(r3);     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r9, null);
        return r14;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    }

    private static final List a(List r2) {
        List<? extends AppEntity> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        return EntityManager.INSTANCE.bulkIndex(r3);
    }

    private final void a(int r8, int r9, int r10, long r11, String r13, String r14) {
        DatabaseIsolationTracker.f11642a.a(r13, r8 + r9, r10, r11, r14);
    }

    private final void a(SupportSQLiteDatabase r2, final String r3, List<a> r4, Map<String, ? extends Object> r5) {
        final SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().runInTransaction(new $$Lambda$LegacyBackupUserRestorer$C5MvCCFvjnOeMAresUoIyGicIw(r6, r1, r3, r7));
    }

    private static final void a(List r6, SupportSQLiteDatabase r7, String r8, Map r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r11 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin")).a().a());
        goto L4
    L6:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r4.add(r12.get(((a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.memorydata.plugin")).b()));
        goto L8
    L10:
        Object[] r15 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]);
        r11.execSQL(m.a(r8, r3), r15);
    }

    private final boolean a(c r5, List<c> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r5.d() <= 0) goto L23;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L7;
    L9:
        Iterator r8 = r7.iterator();
        int r9 = 0;
    L11:
        if (r8.hasNext() == false) goto L20;
        if (((c) ZeusTransformUtils.preCheckCast(r8.next(), c.class, "com.obric.memorydata.plugin")).d() <= 0) goto L15;
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

    public static final /* synthetic */ boolean a(LegacyBackupUserRestorer r0, String r1) {
        return r0.a(r1);
    }

    private final boolean a(String r32) {
        if (com.obric.memorydata.database.account_split.a.f8813a.a(r32) == false) goto L43;
        int r10 = 0;
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r6 = "legacy_backup_restored_" + r32;
        long r8 = System.currentTimeMillis();
        if (r0.getBoolean(r6, false) == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_LegacyBackupUserRestorer", "restore skipped, already done, userId=" + com.obric.memorydata.utils.q.f13259a.b(r32), false, 4, null);
        return false;
    L8:
        String r12 = "db_iso_LegacyBackupUserRestorer";
        if (com.obric.memorydata.database.account_split.spliter.d.f8821a.b("db_iso_LegacyBackupUserRestorer") == true) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_LegacyBackupUserRestorer", "restore skipped, personal db profile mismatch, userId=" + com.obric.memorydata.utils.q.f13259a.b(r32), false, 4, null);
        a(0, 0, 0, System.currentTimeMillis() - r8, "skipped_profile_mismatch", "personal_db_profile_mismatch");
        return false;
    L12:
        int r11 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getWritableDatabase().getVersion();
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(w.f8834a.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L34
        int r14 = 0;
        int r15 = 0;
    L50:
        String r22 = r12;
        if (r13.hasNext() == false) goto L19;
        b r16 = f8803a.a(r32, r11, (l) ZeusTransformUtils.preCheckCast(r13.next(), l.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
        r10 = r10 + r16.a();     // Catch: Throwable -> L29
        r15 = r15 + r16.b();     // Catch: Throwable -> L29
        r14 = r14 + r16.c();     // Catch: Throwable -> L29
        r13 = r13;
        r12 = r22;
    L29:
        th = th;
    L33:
        int r7 = r14;
        int r9 = r15;
    L36:
        long r17 = System.currentTimeMillis() - r8;
        RunLog.INSTANCE.error(r22, "restore failed, userId=" + com.obric.memorydata.utils.q.f13259a.b(r32) + ", indexedRows=" + r10 + ", directRows=" + r9 + ", fkDroppedRows=" + r7 + ", cost=" + r17, th);
        if (ZeusTransformUtils.instanceOf(th, LegacyBackupRestoreTimeoutException.class) == false) goto L39;
        String r1 = LocationMonitorConst.TIMEOUT;
    L40:
        a(r10, r9, r7, r17, r1, th.getClass().getSimpleName());
        throw th;
    L39:
        r1 = "failed";
        goto L40
    L19:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(w.f8834a.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L29
    L21:
        if (r18.hasNext() == false) goto L23;
        ((l) ZeusTransformUtils.preCheckCast(r18.next(), l.class, "com.obric.memorydata.plugin")).g().deleteByBackupUserId(r32);     // Catch: Throwable -> L29
        goto L21
    L23:
        r0.save(r6, true);     // Catch: Throwable -> L29
        long r19 = System.currentTimeMillis() - r8;     // Catch: Throwable -> L29
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_LegacyBackupUserRestorer", "restore finished, userId=" + com.obric.memorydata.utils.q.f13259a.b(r32) + ", indexedRows=" + r10 + ", directRows=" + r15 + ", fkDroppedRows=" + r14 + ", cost=" + r19, false, 4, null);     // Catch: Throwable -> L29
        r7 = r14;
        r9 = r15;
        a(r10, r9, r7, r19, "success", null);     // Catch: Throwable -> L27
        return true;
    L27:
        th = th;
    L31:
        th = th;
        r22 = r12;
    L34:
        th = th;
        r22 = "db_iso_LegacyBackupUserRestorer";
        r7 = 0;
        r9 = 0;
        goto L36
    L43:
        throw new IllegalArgumentException(("Invalid legacy backup restore userId=" + com.obric.memorydata.utils.q.f13259a.b(r32)).toString());
    }

    private static final CharSequence b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.account_split.spliter.d.f8821a.a(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$C5MvCCFvjnOeMAresUoIy-GicIw, reason: not valid java name */
    public static /* synthetic */ void m531lambda$C5MvCCFvjnOeMAresUoIyGicIw(List r0, SupportSQLiteDatabase r1, String r2, Map r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ CharSequence lambda$MuNrdBsnnL3CJLA8HOH0V6Po908(long r0) {
        return a(r0);
    }

    public static /* synthetic */ List lambda$VN4pAEx5HksawtUlkkGrsN8ao3k(List r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$lXRzsExixrypqSITJMiKAz2PP2U(String r0) {
        return b(r0);
    }

    public final synchronized void a(String r9, Function1<? super Boolean, Unit> r10) {
        monitor-enter(this);
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r9, "userId");     // Catch: Throwable -> L25
        if (com.obric.memorydata.database.account_split.a.f8813a.a(r9) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_LegacyBackupUserRestorer", "restore skipped, invalid userId=" + com.obric.memorydata.utils.q.f13259a.b(r9), false, 4, null);     // Catch: Throwable -> L25
        if (r11 == null) goto L8;
        r11.invoke(false);     // Catch: Throwable -> L25
    L8:
        monitor-exit(this);
        return;
    L10:
        bx r0 = c;     // Catch: Throwable -> L25
        boolean r2 = true;
        if (r0 != null) goto L13;
    L15:
        r2 = false;
    L16:
        if (r2 == false) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_LegacyBackupUserRestorer", "restore ignored, active job=" + c + ", userId=" + com.obric.memorydata.utils.q.f13259a.b(r9), false, 4, null);     // Catch: Throwable -> L25
        if (r11 == null) goto L20;
        r11.invoke(false);     // Catch: Throwable -> L25
    L20:
        monitor-exit(this);
        return;
    L22:
        c = kotlinx.coroutines.i.a(f8804b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new LegacyBackupUserRestorer$restoreUserIfNeeded$1(r9, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L13:
        if (r0.a() != true) goto L15;
    L25:
        th = move-exception;
        throw th;
    }
}
