package com.obric.memorydata.database.ose_split;

import android.content.ContentValues;
import android.os.SystemClock;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.memorydata.middleware.database.h;
import com.obric.memorydata.middleware.database.i;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006-./012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0007JH\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002J@\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 2\u0006\u0010!\u001a\u00020\u0007H\u0002J(\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J(\u0010&\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010'\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J&\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020%0\u001cH\u0002J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "OFFSET_ZERO", "MAX_DOCUMENT_RETRY_COUNT", "", "SCHEMA_MIGRATION_TIMEOUT_MS", "KEY_DONE", "KEY_SCHEMA_DONE_PREFIX", "migrateCurrentProfileIfNeededBlocking", "Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$MigrationResult;", "migrateSchemaIfNeeded", "Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$SchemaMigrationResult;", "schemaName", "sourceEngine", "Lcom/obric/search/api/OSearchEngine;", "targetEngine", "isSchemaDone", "Lkotlin/Function1;", "", "markSchemaDone", "", "queryNextPageExcludingSkipped", "", "Lkotlin/Pair;", "Landroid/content/ContentValues;", "skippedSourceIds", "", "deadline", "migrateDocumentWithRetry", "Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$DocumentMigrationStatus;", "document", "Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$OseMigrationDocument;", "migrateDocumentOnce", "removeSourceDocumentAfterSkip", "removeDocuments", "engine", "documents", "checkDeadline", "stage", "MigrationResult", "SchemaMigrationResult", "MigrationStatus", "OseMigrationDocument", "DocumentMigrationStatus", "OseMigrationTimeoutException", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalOseDbMigrator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PersonalOseDbMigrator f9612a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$DocumentMigrationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "MIGRATED", "SKIPPED_SOURCE_REMOVED", "SKIPPED_SOURCE_RETAINED", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum DocumentMigrationStatus extends Enum<DocumentMigrationStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DocumentMigrationStatus[] $VALUES = null;
        public static final DocumentMigrationStatus MIGRATED = null;
        public static final DocumentMigrationStatus SKIPPED_SOURCE_REMOVED = null;
        public static final DocumentMigrationStatus SKIPPED_SOURCE_RETAINED = null;

        private static final /* synthetic */ DocumentMigrationStatus[] $values() {
            return new DocumentMigrationStatus[]{MIGRATED, SKIPPED_SOURCE_REMOVED, SKIPPED_SOURCE_RETAINED};
        }

        static {
            MIGRATED = new DocumentMigrationStatus("MIGRATED", 0);
            SKIPPED_SOURCE_REMOVED = new DocumentMigrationStatus("SKIPPED_SOURCE_REMOVED", 1);
            SKIPPED_SOURCE_RETAINED = new DocumentMigrationStatus("SKIPPED_SOURCE_RETAINED", 2);
            DocumentMigrationStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private DocumentMigrationStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<DocumentMigrationStatus> getEntries() {
            return $ENTRIES;
        }

        public static DocumentMigrationStatus valueOf(String r2) {
            return (DocumentMigrationStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(DocumentMigrationStatus.class, r2), DocumentMigrationStatus.class, "com.obric.memorydata.plugin");
        }

        public static DocumentMigrationStatus[] values() {
            return (DocumentMigrationStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DocumentMigrationStatus[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$MigrationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "ALREADY_DONE", "SKIPPED_INVALID_UID", RawObservationEntity.STATE_FAILED, "TIMEOUT", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum MigrationStatus extends Enum<MigrationStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ MigrationStatus[] $VALUES = null;
        public static final MigrationStatus ALREADY_DONE = null;
        public static final MigrationStatus FAILED = null;
        public static final MigrationStatus SKIPPED_INVALID_UID = null;
        public static final MigrationStatus SUCCESS = null;
        public static final MigrationStatus TIMEOUT = null;

        private static final /* synthetic */ MigrationStatus[] $values() {
            return new MigrationStatus[]{SUCCESS, ALREADY_DONE, SKIPPED_INVALID_UID, FAILED, TIMEOUT};
        }

        static {
            SUCCESS = new MigrationStatus("SUCCESS", 0);
            ALREADY_DONE = new MigrationStatus("ALREADY_DONE", 1);
            SKIPPED_INVALID_UID = new MigrationStatus("SKIPPED_INVALID_UID", 2);
            FAILED = new MigrationStatus(RawObservationEntity.STATE_FAILED, 3);
            TIMEOUT = new MigrationStatus("TIMEOUT", 4);
            MigrationStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private MigrationStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<MigrationStatus> getEntries() {
            return $ENTRIES;
        }

        public static MigrationStatus valueOf(String r2) {
            return (MigrationStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(MigrationStatus.class, r2), MigrationStatus.class, "com.obric.memorydata.plugin");
        }

        public static MigrationStatus[] values() {
            return (MigrationStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MigrationStatus[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$OseMigrationTimeoutException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "stage", "", "<init>", "(Ljava/lang/String;)V", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class OseMigrationTimeoutException extends IllegalStateException {
        public OseMigrationTimeoutException(String r3) {
            Intrinsics.checkNotNullParameter(r3, "stage");
            super("personal ose migration timeout, stage=" + r3);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$MigrationResult;", "", "status", "Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$MigrationStatus;", "migratedCount", "", "skippedCount", "failedCount", "durationMs", "", "failureReason", "", "<init>", "(Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$MigrationStatus;IIIJLjava/lang/String;)V", "getStatus", "()Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$MigrationStatus;", "getMigratedCount", "()I", "getSkippedCount", "getFailedCount", "getDurationMs", "()J", "getFailureReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MigrationStatus f9613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9614b;
        private final int c;
        private final int d;
        private final long e;
        private final String f;

        public a(MigrationStatus r2, int r3, int r4, int r5, long r6, String r8) {
            Intrinsics.checkNotNullParameter(r2, "status");
            this.f9613a = r2;
            this.f9614b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r8;
        }

        public /* synthetic */ a(MigrationStatus r7, int r8, int r9, int r10, long r11, String r13, int r14, DefaultConstructorMarker r15) {
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
            this(r7, r0, r2, r1, r3, r5);
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

        public final MigrationStatus a() {
            return this.f9613a;
        }

        public final int b() {
            return this.f9614b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (this.f9613a == r10.f9613a) goto L12;
            return false;
        L12:
            if (this.f9614b == r10.f9614b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((this.f9613a.hashCode() * 31) + Integer.hashCode(this.f9614b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31;
            String r3 = this.f;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r0 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public String toString() {
            return "MigrationResult(status=" + this.f9613a + ", migratedCount=" + this.f9614b + ", skippedCount=" + this.c + ", failedCount=" + this.d + ", durationMs=" + this.e + ", failureReason=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$OseMigrationDocument;", "Lcom/obric/search/api/document/intf/IFullTextSearchDocument;", OaidModel.KEY_ID, "", "schemaName", "", "contentValues", "Landroid/content/ContentValues;", "<init>", "(JLjava/lang/String;Landroid/content/ContentValues;)V", "getId", "()J", "getSchemaName", "()Ljava/lang/String;", "toContentValues", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b implements com.obric.search.api.b.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9616b;
        private final ContentValues c;

        public b(long r2, String r4, ContentValues r5) {
            Intrinsics.checkNotNullParameter(r4, "schemaName");
            Intrinsics.checkNotNullParameter(r5, "contentValues");
            this.f9615a = r2;
            this.f9616b = r4;
            this.c = r5;
        }

        @Override // com.obric.search.api.b.a.a
        public long getId() {
            return this.f9615a;
        }

        @Override // com.obric.search.api.b.a.a
        public String getSchemaName() {
            return this.f9616b;
        }

        @Override // com.obric.search.api.b.a.b
        public ContentValues toContentValues() {
            return this.c;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/ose_split/PersonalOseDbMigrator$SchemaMigrationResult;", "", "migratedCount", "", "skippedCount", "failedCount", "<init>", "(III)V", "getMigratedCount", "()I", "getSkippedCount", "getFailedCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9618b;
        private final int c;

        public c(int r1, int r2, int r3) {
            this.f9617a = r1;
            this.f9618b = r2;
            this.c = r3;
        }

        public final int a() {
            return this.f9617a;
        }

        public final int b() {
            return this.f9618b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f9617a == r6.f9617a) goto L12;
            return false;
        L12:
            if (this.f9618b == r6.f9618b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f9617a) * 31) + Integer.hashCode(this.f9618b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "SchemaMigrationResult(migratedCount=" + this.f9617a + ", skippedCount=" + this.f9618b + ", failedCount=" + this.c + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9619a = null;

        static {
            int[] r0 = new int[DocumentMigrationStatus.values().length];
            r0[DocumentMigrationStatus.MIGRATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DocumentMigrationStatus.SKIPPED_SOURCE_REMOVED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DocumentMigrationStatus.SKIPPED_SOURCE_RETAINED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f9619a = r0;
        }
    }

    static {
        f9612a = new PersonalOseDbMigrator();
    }

    private PersonalOseDbMigrator() {
    }

    private final DocumentMigrationStatus a(String r20, b r21, com.obric.search.api.a r22, com.obric.search.api.a r23) {
        Throwable r3 = null;
        int r4 = 0;
    L4:
        if (r4 >= 3) goto L28;
        PersonalOseDbMigrator r0 = f9612a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L12
        Object r1 = Result.m1421constructorimpl(Boolean.valueOf(r0.b(r20, r21, r22, r23)));     // Catch: Throwable -> L10
    L15:
        Object r11 = false;
        if (Result.m1427isFailureimpl(r1) == true) goto L20;
        r11 = r1;
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L22;
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 != null) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose document migration retry failed, schema=" + r20 + ", documentId=" + r21.getId() + ", attempt=" + (r4 + 1), null, 4, null);
    L27:
        r4 = r4 + 1;
        goto L4
    L26:
        RunLog.INSTANCE.warn("db_iso_PersonalOseDbMigrator", "personal ose document migration retry failed, schema=" + r20 + ", documentId=" + r21.getId() + ", attempt=" + (r4 + 1), r2);
        r3 = r2;
        goto L27
    L22:
        return DocumentMigrationStatus.MIGRATED;
    L10:
        th = th;
    L14:
        Result.Companion r12 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L12:
        th = th;
        goto L14
    L28:
        String r13 = "personal ose document migration skipped after retry, schema=" + r20 + ", documentId=" + r21.getId();
        RunLog r5 = RunLog.INSTANCE;
        if (r3 != null) goto L31;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(r5, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", r13, null, 4, null);
    L33:
        if (a(r20, r21, r22) == false) goto L36;
        return DocumentMigrationStatus.SKIPPED_SOURCE_REMOVED;
    L36:
        return DocumentMigrationStatus.SKIPPED_SOURCE_RETAINED;
    L31:
        r5.error("db_iso_PersonalOseDbMigrator", r13, r3);
        goto L33
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    private final c a(String r21, com.obric.search.api.a r22, com.obric.search.api.a r23, Function1<? super String, Boolean> r24, Function1<? super String, Unit> r25) {
        Function1 r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
        String r9 = "personal_ose_db_migration_schema_done_" + r21;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(r9), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose schema migration skipped, schema=" + r21 + ", doneKey=" + r9, false, 4, null);
        return new c(0, 0, 0);
    L6:
        long r15 = System.currentTimeMillis();
        long r10 = SystemClock.elapsedRealtime() + 600000;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose schema migration start, schema=" + r21 + ", pageSize=200", false, 4, null);
        Set<Long> r1 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        int r5 = 0;
        int r12 = 0;
        ?? r16 = r15;
    L61:
        a(r10, "query schema=" + r21);     // Catch: OseMigrationTimeoutException -> L51
        int r14 = r5;
        List<Pair<Long, ContentValues>> r2 = a(r22, r21, r1, r10);     // Catch: OseMigrationTimeoutException -> L49
        if (r2.isEmpty() == true) goto L11;
        long r18 = r16 == true ? 1 : 0;
        int r17 = r12;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");     // Catch: OseMigrationTimeoutException -> L47
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: OseMigrationTimeoutException -> L47
        Iterator r6 = r3.iterator();     // Catch: OseMigrationTimeoutException -> L47
    L27:
        if (r6.hasNext() == false) goto L29;
        Pair r7 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: OseMigrationTimeoutException -> L47
        r4.add(new b(((Number) ZeusTransformUtils.preCheckCast(r7.component1(), Number.class, "com.obric.memorydata.plugin")).longValue(), r21, new ContentValues((ContentValues) ZeusTransformUtils.preCheckCast(r7.component2(), ContentValues.class, "com.obric.memorydata.plugin"))));     // Catch: OseMigrationTimeoutException -> L47
        goto L27
    L29:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: OseMigrationTimeoutException -> L47
        r5 = r14;
        r12 = r17;
    L63:
    L45:
        e = e;
        int r13 = r5;
        ?? r19 = r12;
    L55:
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, DatabaseIsolationTracker.OseMigrationPhase.SCHEMA, LocationMonitorConst.TIMEOUT, r13, r19, 0, System.currentTimeMillis() - r18, LocationMonitorConst.TIMEOUT, r21, 16, null);
        throw e;
    L32:
        if (r11.hasNext() == false) goto L44;
        b r20 = (b) ZeusTransformUtils.preCheckCast(r11.next(), b.class, "com.obric.memorydata.plugin");     // Catch: OseMigrationTimeoutException -> L45
        PersonalOseDbMigrator r26 = f9612a;     // Catch: OseMigrationTimeoutException -> L45
        r26.a(r10, "migrate schema=" + r21);     // Catch: OseMigrationTimeoutException -> L45
        int r27 = d.f9619a[r26.a(r21, r20, r22, r23).ordinal()];     // Catch: OseMigrationTimeoutException -> L45
        if (r27 != 1) goto L36;
        r5 = r5 + 1;
        goto L63
    L36:
        if (r27 != 2) goto L38;
        r12 = r12 + 1;
        goto L63
    L38:
        if (r27 != 3) goto L41;
        r12 = r12 + 1;     // Catch: OseMigrationTimeoutException -> L45
        r1.add(Long.valueOf(r20.getId()));     // Catch: OseMigrationTimeoutException -> L45
        goto L63
    L41:
        throw new NoWhenBranchMatchedException();     // Catch: OseMigrationTimeoutException -> L45
    L44:
        r16 = r18;
    L47:
        e = e;
    L54:
        r13 = r14;
        r19 = r16;
        goto L55
    L11:
        long r110 = System.currentTimeMillis() - (r16 == true ? 1 : 0);     // Catch: OseMigrationTimeoutException -> L49
        r8.invoke(r9);     // Catch: OseMigrationTimeoutException -> L49
        if (r12 != 0) goto L17;
        String r28 = "success";
    L18:
        String r29 = r28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose schema migration finished, schema=" + r21 + ", migrated=" + r14 + ", skipped=" + r12 + ", status=" + r29 + ", cost=" + r110, false, 4, null);     // Catch: OseMigrationTimeoutException -> L49
        DatabaseIsolationTracker r30 = DatabaseIsolationTracker.f11642a;     // Catch: OseMigrationTimeoutException -> L49
        DatabaseIsolationTracker.OseMigrationPhase r31 = DatabaseIsolationTracker.OseMigrationPhase.SCHEMA;     // Catch: OseMigrationTimeoutException -> L49
        if (r12 != 0) goto L21;
        String r32 = null;
    L22:
        String r33 = r32;
        int r34 = r12;
        r18 = r16 == true ? 1 : 0;
        r16 = r12;
        DatabaseIsolationTracker.a(r30, r31, r29, r14, r34, 0, r110, r33, r21, 16, null);     // Catch: OseMigrationTimeoutException -> L47
        return new c(r14, r16 == true ? 1 : 0, 0);
    L21:
        r32 = "document_retry_exhausted";
        goto L22
    L17:
        r28 = "partial_success";
    L49:
        e = e;
    L53:
        r18 = r16 == true ? 1 : 0;
        r16 = r12;
    L51:
        e = e;
        r14 = r5;
        goto L53
    }

    private final List<Pair<Long, ContentValues>> a(com.obric.search.api.a r11, String r12, Set<Long> r13, long r14) {
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin");
        long r2 = 0;
    L3:
        a(r14, "scan schema=" + r12);
        List<Pair<Long, ContentValues>> r0 = r11.a(r12, 200, r2);
        if (r0.isEmpty() == true) goto L6;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        Object r5 = r3.next();
        if (r15.contains(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin")).component1(), Number.class, "com.obric.memorydata.plugin")).longValue())) == true) goto L9;
        r4.add(r5);
        goto L9
    L13:
        List<Pair<Long, ContentValues>> r6 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L15;
        r2 = r2 + 200;
        goto L3
    L15:
        return r6;
    L6:
        return CollectionsKt.emptyList();
    }

    private final void a(long r3, String r5) {
        if (SystemClock.elapsedRealtime() >= r3) goto L6;
        return;
    L6:
        throw new OseMigrationTimeoutException(r5);
    }

    private static final boolean a(IStore r2, String r3) {
        IStore r4 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        return r4.getBoolean(r3, false);
    }

    private final boolean a(com.obric.search.api.a r8, String r9, List<b> r10) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L7;
        return true;
    L7:
        return r8.a((com.obric.search.api.e.b.a) ZeusTransformUtils.preCheckCast(new com.obric.search.api.e.a.a(r9, r3, false, 4, null), com.obric.search.api.e.b.a.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(String r13, b r14, com.obric.search.api.a r15) {
        int r0 = 0;
    L4:
        if (r0 >= 3) goto L23;
        PersonalOseDbMigrator r3 = f9612a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(Boolean.valueOf(r3.a(r15, r13, CollectionsKt.listOf(r14))));     // Catch: Throwable -> L8
    L10:
        Object r6 = false;
        if (Result.m1427isFailureimpl(r5) == true) goto L15;
        r6 = r5;
    L15:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L16;
        Throwable r7 = Result.m1424exceptionOrNullimpl(r5);
        if (r7 != null) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "remove skipped personal ose source document failed, schema=" + r13 + ", documentId=" + r14.getId() + ", attempt=" + (r0 + 1), null, 4, null);
    L22:
        r0 = r0 + 1;
        goto L4
    L21:
        RunLog.INSTANCE.warn("db_iso_PersonalOseDbMigrator", "remove skipped personal ose source document failed, schema=" + r13 + ", documentId=" + r14.getId() + ", attempt=" + (r0 + 1), r7);
        goto L22
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose document skipped and removed from source, schema=" + r13 + ", documentId=" + r14.getId(), null, 4, null);
        return true;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L23:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose document skipped but source retained, schema=" + r13 + ", documentId=" + r14.getId(), null, 4, null);
        return false;
    }

    private static final Unit b(IStore r2, String r3) {
        IStore r4 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        r4.save(r3, true);
        return Unit.INSTANCE;
    }

    private final boolean b(String r1, b r2, com.obric.search.api.a r3, com.obric.search.api.a r4) {
        List<? extends com.obric.search.api.b.a.a> r5 = CollectionsKt.listOf(r2);
        a(r4, r1, r5);
        if (r4.a(r5) == true) goto L7;
        return false;
    L7:
        return a(r3, r1, r5);
    }

    public static /* synthetic */ Unit lambda$ES6Y1hSK7KzRWPLufOnwpxmQOJA(IStore r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$YxKxsMHYm9OZNPRR3c0hIlLesW0(IStore r0, String r1) {
        return a(r0, r1);
    }

    public final a a() {
        int r3 = 0;
        final IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r0.getBoolean("personal_ose_db_migration_done", false) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose migration skipped, already done", false, 4, null);
        return new a(MigrationStatus.ALREADY_DONE, 0, 0, 0, 0, null, 62, null);
    L6:
        i r4 = h.f11660a.a();
        String r5 = r4.a();
        if (r4.c() == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "skip personal ose migration, invalid uid, rawUserId=" + q.f13259a.b(r4.b()) + ", isLogin=" + AppContext.INSTANCE.isLogin(), null, 4, null);
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, DatabaseIsolationTracker.OseMigrationPhase.OVERALL, "skipped_invalid_uid", 0, 0, 0, 0, "invalid_uid", null, 188, null);
        return new a(MigrationStatus.SKIPPED_INVALID_UID, 0, 0, 0, 0, "invalid_uid", 30, null);
    L10:
        long r6 = System.currentTimeMillis();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose migration start, profile=" + q.f13259a.b(r5) + ", schemas=" + com.obric.memorydata.database.ose_split.a.f9620a.a(), false, 4, null);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        PersonalOseDbMigrator r8 = (PersonalOseDbMigrator) ZeusTransformUtils.preCheckCast(this, PersonalOseDbMigrator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.ose_split.a.f9620a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L20
        int r15 = 0;
        int r16 = 0;
    L44:
    L18:
        th = th;
    L22:
        Result.Companion r1 = Result.Companion;
        Object r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L23:
        int r9 = r15;
        int r10 = r16;
        Throwable r11 = Result.m1424exceptionOrNullimpl(r2);
        if (r11 != null) goto L30;
        Unit r12 = (Unit) ZeusTransformUtils.preCheckCast(r2, Unit.class, "com.obric.memorydata.plugin");
        long r13 = System.currentTimeMillis() - r6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalOseDbMigrator", "personal ose migration finished, profile=" + q.f13259a.b(r5) + ", migrated=" + r3 + ", skipped=" + r9 + ", failed=" + r10 + ", cost=" + r13, false, 4, null);
        DatabaseIsolationTracker r17 = DatabaseIsolationTracker.f11642a;
        DatabaseIsolationTracker.OseMigrationPhase r18 = DatabaseIsolationTracker.OseMigrationPhase.OVERALL;
        if (r9 != 0) goto L28;
        String r19 = "success";
    L29:
        DatabaseIsolationTracker.a(r17, r18, r19, r3, r9, r10, r13, null, null, 192, null);
        return new a(MigrationStatus.SUCCESS, r3, r9, r10, r13, null, 32, null);
    L28:
        r19 = "partial_success";
        goto L29
    L30:
        long r20 = System.currentTimeMillis() - r6;
        boolean r21 = ZeusTransformUtils.instanceOf(r11, OseMigrationTimeoutException.class);
        if (r21 == false) goto L33;
        String r110 = LocationMonitorConst.TIMEOUT;
    L34:
        RunLog.INSTANCE.error("db_iso_PersonalOseDbMigrator", "personal ose migration failed, profile=" + q.f13259a.b(r5) + ", migrated=" + r3 + ", skipped=" + r9 + ", failed=" + r10 + ", cost=" + r20 + ", reason=" + r110, r11);
        DatabaseIsolationTracker r22 = DatabaseIsolationTracker.f11642a;
        DatabaseIsolationTracker.OseMigrationPhase r23 = DatabaseIsolationTracker.OseMigrationPhase.OVERALL;
        if (r21 == false) goto L37;
        String r111 = LocationMonitorConst.TIMEOUT;
    L38:
        String r24 = r110;
        DatabaseIsolationTracker.a(r22, r23, r111, r3, r9, r10, r20, r24, null, 128, null);
        if (r21 == false) goto L41;
        MigrationStatus r25 = MigrationStatus.TIMEOUT;
    L43:
        return new a(r25, r3, r9, r10, r20, r24);
    L41:
        r25 = MigrationStatus.FAILED;
        goto L43
    L37:
        r111 = "failed";
        goto L38
    L33:
        r110 = r11.getClass().getSimpleName();
        goto L34
    L14:
        if (r14.hasNext() == false) goto L16;
        c r26 = r8.a((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.util.c.f9626a.a(), com.obric.memorydata.database.util.c.f9626a.b(), new $$Lambda$PersonalOseDbMigrator$YxKxsMHYm9OZNPRR3c0hIlLesW0(r0), new $$Lambda$PersonalOseDbMigrator$ES6Y1hSK7KzRWPLufOnwpxmQOJA(r0));     // Catch: Throwable -> L18
        r3 = r3 + r26.a();     // Catch: Throwable -> L18
        r15 = r15 + r26.b();     // Catch: Throwable -> L18
        r16 = r16 + r26.c();     // Catch: Throwable -> L18
        goto L44
    L16:
        r0.save("personal_ose_db_migration_done", true);     // Catch: Throwable -> L18
        r2 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        th = th;
        r15 = 0;
        r16 = 0;
        goto L22
    }
}
