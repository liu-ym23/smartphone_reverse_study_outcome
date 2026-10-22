package com.obric.memorydata.personalcontext.vectordb;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.memorydata.middleware.database.i;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003 !\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0007J \u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J0\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator;", "", "<init>", "()V", "TAG", "", "VECTOR_DB_DIR_NAME", "KEY_DONE", "KEY_ITEM_DONE_PREFIX", "migrateCurrentProfileIfNeededBlocking", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$MigrationResult;", "migrateOnePersonalVectorDbIfNeeded", "baseDbName", "targetModelName", "targetVlmName", "migrateOnePersonalVectorDb", "spec", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrationSpec;", "profileId", "vectorDbDir", "Ljava/io/File;", "renameEntry", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult;", AILabCheckPermissionTask.KEY_SOURCE, TypedValues.AttributesType.S_TARGET, "buildPersonalDbName", "buildPersonalVlmDbName", "getCurrentProfile", "Lcom/obric/memorydata/middleware/database/PersonalDbSplitProfile;", "deleteRecursively", "", "file", "MigrationResult", "MigrationStatus", "RenameEntryResult", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalVectorDbFileMigrator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PersonalVectorDbFileMigrator f12393a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$MigrationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "ALREADY_DONE", "SKIPPED_INVALID_UID", RawObservationEntity.STATE_FAILED, "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum MigrationStatus extends Enum<MigrationStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ MigrationStatus[] $VALUES = null;
        public static final MigrationStatus ALREADY_DONE = null;
        public static final MigrationStatus FAILED = null;
        public static final MigrationStatus SKIPPED_INVALID_UID = null;
        public static final MigrationStatus SUCCESS = null;

        private static final /* synthetic */ MigrationStatus[] $values() {
            return new MigrationStatus[]{SUCCESS, ALREADY_DONE, SKIPPED_INVALID_UID, FAILED};
        }

        static {
            SUCCESS = new MigrationStatus("SUCCESS", 0);
            ALREADY_DONE = new MigrationStatus("ALREADY_DONE", 1);
            SKIPPED_INVALID_UID = new MigrationStatus("SKIPPED_INVALID_UID", 2);
            FAILED = new MigrationStatus(RawObservationEntity.STATE_FAILED, 3);
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$MigrationResult;", "", "status", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$MigrationStatus;", "migratedCount", "", "skippedCount", "failedCount", "errorMessage", "", "<init>", "(Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$MigrationStatus;IIILjava/lang/String;)V", "getStatus", "()Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$MigrationStatus;", "getMigratedCount", "()I", "getSkippedCount", "getFailedCount", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MigrationStatus f12394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12395b;
        private final int c;
        private final int d;
        private final String e;

        public a(MigrationStatus r2, int r3, int r4, int r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "status");
            this.f12394a = r2;
            this.f12395b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public /* synthetic */ a(MigrationStatus r8, int r9, int r10, int r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L5;
            int r3 = 0;
        L7:
            if ((r13 & 4) == 0) goto L9;
            int r4 = 0;
        L11:
            if ((r13 & 8) == 0) goto L13;
            int r5 = 0;
        L15:
            if ((r13 & 16) == 0) goto L17;
            r12 = null;
        L17:
            this(r8, r3, r4, r5, r12);
            return;
        L13:
            r5 = r11;
            goto L15
        L9:
            r4 = r10;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public final MigrationStatus a() {
            return this.f12394a;
        }

        public final int b() {
            return this.f12395b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f12394a == r6.f12394a) goto L12;
            return false;
        L12:
            if (this.f12395b == r6.f12395b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.f12394a.hashCode() * 31) + Integer.hashCode(this.f12395b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31;
            String r2 = this.e;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "MigrationResult(status=" + this.f12394a + ", migratedCount=" + this.f12395b + ", skippedCount=" + this.c + ", failedCount=" + this.d + ", errorMessage=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult;", "", "<init>", "()V", "Renamed", "Skipped", "Failed", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult$Failed;", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult$Renamed;", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult$Skipped;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static abstract class b {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult$Failed;", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult;", "sourceName", "", "targetName", InfoRequestQPSOptTraceLogger.REASON, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSourceName", "()Ljava/lang/String;", "getTargetName", "getReason", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f12396a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f12397b;
            private final String c;

            public a(String r2, String r3, String r4) {
                Intrinsics.checkNotNullParameter(r2, "sourceName");
                Intrinsics.checkNotNullParameter(r3, "targetName");
                Intrinsics.checkNotNullParameter(r4, InfoRequestQPSOptTraceLogger.REASON);
                super(null);
                this.f12396a = r2;
                this.f12397b = r3;
                this.c = r4;
            }

            public final String a() {
                return this.f12396a;
            }

            public final String b() {
                return this.f12397b;
            }

            public final String c() {
                return this.c;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f12396a, r6.f12396a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f12397b, r6.f12397b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f12396a.hashCode() * 31) + this.f12397b.hashCode()) * 31) + this.c.hashCode();
            }

            public String toString() {
                return "Failed(sourceName=" + this.f12396a + ", targetName=" + this.f12397b + ", reason=" + this.c + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.vectordb.PersonalVectorDbFileMigrator$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult$Renamed;", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult;", "sourceName", "", "targetName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSourceName", "()Ljava/lang/String;", "getTargetName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0663b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f12398a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f12399b;

            public C0663b(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "sourceName");
                Intrinsics.checkNotNullParameter(r3, "targetName");
                super(null);
                this.f12398a = r2;
                this.f12399b = r3;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0663b.class) == true) goto L8;
                return false;
            L8:
                C0663b r6 = (C0663b) ZeusTransformUtils.preCheckCast(r5, C0663b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f12398a, r6.f12398a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f12399b, r6.f12399b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f12398a.hashCode() * 31) + this.f12399b.hashCode();
            }

            public String toString() {
                return "Renamed(sourceName=" + this.f12398a + ", targetName=" + this.f12399b + ')';
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult$Skipped;", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrator$RenameEntryResult;", "sourceName", "", "targetName", InfoRequestQPSOptTraceLogger.REASON, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSourceName", "()Ljava/lang/String;", "getTargetName", "getReason", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f12400a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f12401b;
            private final String c;

            public c(String r2, String r3, String r4) {
                Intrinsics.checkNotNullParameter(r2, "sourceName");
                Intrinsics.checkNotNullParameter(r3, "targetName");
                Intrinsics.checkNotNullParameter(r4, InfoRequestQPSOptTraceLogger.REASON);
                super(null);
                this.f12400a = r2;
                this.f12401b = r3;
                this.c = r4;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
                return false;
            L8:
                c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f12400a, r6.f12400a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f12401b, r6.f12401b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f12400a.hashCode() * 31) + this.f12401b.hashCode()) * 31) + this.c.hashCode();
            }

            public String toString() {
                return "Skipped(sourceName=" + this.f12400a + ", targetName=" + this.f12401b + ", reason=" + this.c + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12393a = new PersonalVectorDbFileMigrator();
    }

    private PersonalVectorDbFileMigrator() {
    }

    private final a a(c r21, String r22, String r23, String r24, File r25) {
        int r8 = 0;
        IStore r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r6 = "personal_vector_db_file_migration_item_done_" + r21.a();
        if (r5.getBoolean(r6, false) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "skip vector db file item migration, already done, table=" + r21.a() + ", profile=" + q.f13259a.b(r24) + ", targetModel=" + q.f13259a.b(r22) + ", targetVlm=" + q.f13259a.b(r23), false, 4, null);
        return new a(MigrationStatus.ALREADY_DONE, 0, 2, 0, null, 26, null);
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "vector db file item migration start, table=" + r21.a() + ", profile=" + q.f13259a.b(r24) + ", sourceModel=" + r21.b() + ", sourceVlm=" + r21.c() + ", targetModel=" + q.f13259a.b(r22) + ", targetVlm=" + q.f13259a.b(r23), false, 4, null);
        List r0 = CollectionsKt.listOf(new b[]{a(new File(r25, r21.b()), new File(r25, r22)), a(new File(r25, r21.c()), new File(r25, r23))});
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r9 = r3.next();
        if (ZeusTransformUtils.instanceOf(r9, b.a.class) == false) goto L8;
        r4.add(r9);
        goto L8
    L12:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L46;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r1.hasNext() == false) goto L18;
        b.a r10 = (b.a) ZeusTransformUtils.preCheckCast(r1.next(), b.a.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "rename vector db file failed, table=" + r21.a() + ", source=" + r10.a() + ", target=" + q.f13259a.b(r10.b()) + ", reason=" + r10.c(), null, 4, null);
        goto L16
    L18:
        MigrationStatus r11 = MigrationStatus.FAILED;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L21;
    L23:
        Iterator r13 = r12.iterator();
        int r14 = 0;
    L25:
        if (r13.hasNext() == false) goto L31;
        if (ZeusTransformUtils.instanceOf((b) ZeusTransformUtils.preCheckCast(r13.next(), b.class, "com.obric.memorydata.plugin"), b.C0663b.class) == false) goto L25;
        r14 = r14 + 1;
        if (r14 >= 0) goto L25;
        CollectionsKt.throwCountOverflow();
    L31:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L34;
    L36:
        Iterator r16 = r15.iterator();
    L38:
        if (r16.hasNext() == false) goto L45;
        if (ZeusTransformUtils.instanceOf((b) ZeusTransformUtils.preCheckCast(r16.next(), b.class, "com.obric.memorydata.plugin"), b.c.class) == false) goto L38;
        r8 = r8 + 1;
        if (r8 >= 0) goto L38;
        CollectionsKt.throwCountOverflow();
    L45:
        return new a(r11, r14, r8, r7.size(), CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$PersonalVectorDbFileMigrator$frVM954lG5uuhUXeDzTnN6OI96o.INSTANCE, 31, null));
    L34:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L36;
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L23;
        r14 = 0;
        goto L31
    L46:
        r5.save(r6, true);
        IRunLog r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder().append("vector db file migrated, table=").append(r21.a()).append(", profile=").append(q.f13259a.b(r24)).append(", migrated=");
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L49;
    L51:
        Iterator r20 = r19.iterator();
        int r26 = 0;
    L53:
        if (r20.hasNext() == false) goto L59;
        if (ZeusTransformUtils.instanceOf((b) ZeusTransformUtils.preCheckCast(r20.next(), b.class, "com.obric.memorydata.plugin"), b.C0663b.class) == false) goto L53;
        r26 = r26 + 1;
        if (r26 >= 0) goto L53;
        CollectionsKt.throwCountOverflow();
    L59:
        StringBuilder r27 = r18.append(r26).append(", skipped=");
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r28, Collection.class) == true) goto L62;
    L64:
        Iterator r29 = r28.iterator();
        int r30 = 0;
    L66:
        if (r29.hasNext() == false) goto L72;
        if (ZeusTransformUtils.instanceOf((b) ZeusTransformUtils.preCheckCast(r29.next(), b.class, "com.obric.memorydata.plugin"), b.c.class) == false) goto L66;
        r30 = r30 + 1;
        if (r30 >= 0) goto L66;
        CollectionsKt.throwCountOverflow();
    L72:
        IRunLog.a.a(r17, "db_iso_PersonalVectorDbFileMigrator", r27.append(r30).toString(), false, 4, null);
        MigrationStatus r110 = MigrationStatus.SUCCESS;
        Iterable r31 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r31, Collection.class) == true) goto L75;
    L77:
        Iterator r32 = r31.iterator();
        int r33 = 0;
    L79:
        if (r32.hasNext() == false) goto L85;
        if (ZeusTransformUtils.instanceOf((b) ZeusTransformUtils.preCheckCast(r32.next(), b.class, "com.obric.memorydata.plugin"), b.C0663b.class) == false) goto L79;
        r33 = r33 + 1;
        if (r33 >= 0) goto L79;
        CollectionsKt.throwCountOverflow();
        goto L79
    L85:
        int r111 = r33;
    L86:
        Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r34, Collection.class) == true) goto L89;
    L91:
        Iterator r35 = r34.iterator();
    L93:
        if (r35.hasNext() == false) goto L100;
        if (ZeusTransformUtils.instanceOf((b) ZeusTransformUtils.preCheckCast(r35.next(), b.class, "com.obric.memorydata.plugin"), b.c.class) == false) goto L93;
        r8 = r8 + 1;
        if (r8 >= 0) goto L93;
        CollectionsKt.throwCountOverflow();
    L100:
        return new a(r110, r111, r8, 0, null, 24, null);
    L89:
        if (((Collection) ZeusTransformUtils.preCheckCast(r34, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L91;
    L75:
        if (((Collection) ZeusTransformUtils.preCheckCast(r31, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L77;
        r111 = 0;
        goto L86
    L62:
        if (((Collection) ZeusTransformUtils.preCheckCast(r28, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L64;
        r30 = 0;
        goto L72
    L49:
        if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L51;
        r26 = 0;
        goto L59
    }

    private final b a(File r4, File r5) {
        if (r4.exists() == false) goto L14;
        if (r5.exists() == false) goto L14;
        if (a(r5) == true) goto L10;
        String r6 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "getName(...)");
        String r7 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "getName(...)");
        Object r3 = new b.a(r6, r7, "delete target failed");
    L24:
        return (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
    L10:
        if (r4.renameTo(r5) == false) goto L12;
        String r8 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r8, "getName(...)");
        String r9 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r9, "getName(...)");
        r3 = new b.C0663b(r8, r9);
        goto L24
    L12:
        String r10 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r10, "getName(...)");
        String r11 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r11, "getName(...)");
        r3 = new b.a(r10, r11, "rename after target delete failed");
    L14:
        if (r4.exists() == false) goto L20;
        if (r4.renameTo(r5) == false) goto L18;
        String r12 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "getName(...)");
        String r13 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r13, "getName(...)");
        r3 = new b.C0663b(r12, r13);
        goto L24
    L18:
        String r14 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "getName(...)");
        String r15 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "getName(...)");
        r3 = new b.a(r14, r15, "rename failed");
        goto L24
    L20:
        if (r5.exists() == false) goto L22;
        String r16 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r16, "getName(...)");
        String r17 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r17, "getName(...)");
        r3 = new b.c(r16, r17, "target exists");
        goto L24
    L22:
        String r18 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r18, "getName(...)");
        String r19 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r19, "getName(...)");
        r3 = new b.c(r18, r19, "source and target missing");
        goto L24
    }

    private static final CharSequence a(b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.c(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String a(String r1, String r2) {
        return r1 + '_' + r2;
    }

    private final boolean a(File r1) {
        if (r1.exists() == true) goto L7;
        return true;
    L7:
        return FilesKt.deleteRecursively(r1);
    }

    private final i b() {
        return com.obric.memorydata.middleware.database.b.f11646a.a();
    }

    private final String b(String r1, String r2) {
        return r1 + "_vlm_" + r2;
    }

    public static /* synthetic */ CharSequence lambda$frVM954lG5uuhUXeDzTnN6OI96o(b.a r0) {
        return a(r0);
    }

    public final a a() {
        int r3 = 0;
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r0.getBoolean("personal_vector_db_file_migration_done", false) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "skip vector db file migration, already done", false, 4, null);
        return new a(MigrationStatus.ALREADY_DONE, 0, 0, 0, null, 30, null);
    L6:
        i r4 = b();
        String r11 = r4.a();
        if (r4.c() == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "skip vector db file migration, invalid uid, rawUserId=" + q.f13259a.b(r4.b()) + ", isLogin=" + AppContext.INSTANCE.isLogin(), null, 4, null);
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, DatabaseIsolationTracker.VectorFileMigrationPhase.OVERALL, "skipped_invalid_uid", 0, 0, 0, 0, "invalid_uid", null, 188, null);
        return new a(MigrationStatus.SKIPPED_INVALID_UID, 0, 0, 0, "invalid_uid", 14, null);
    L10:
        File r5 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "vectorDataBase");
        long r12 = System.currentTimeMillis();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "vector db file migration start, profile=" + q.f13259a.b(r11) + ", dir=" + r5.getAbsolutePath() + ", specCount=" + com.obric.memorydata.personalcontext.vectordb.b.f12404a.a().size(), false, 4, null);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.vectordb.b.f12404a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r10 = 0;
        int r15 = 0;
    L12:
        if (r14.hasNext() == false) goto L17;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r14.next(), c.class, "com.obric.memorydata.plugin");
        PersonalVectorDbFileMigrator r7 = f12393a;
        Iterator r26 = r14;
        a r8 = r7.a(r6, r7.a(r6.a(), r11), r7.b(r6.a(), r11), r11, r5);
        r15 = r15 + r8.b();
        r10 = r10 + r8.c();
        if (r8.a() != MigrationStatus.FAILED) goto L16;
        r3 = r3 + 1;
    L16:
        r14 = r26;
        goto L12
    L17:
        int r16 = r10;
        if (r3 != 0) goto L20;
        r0.save("personal_vector_db_file_migration_done", true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "vector db file migration finished, profile=" + q.f13259a.b(r11) + ", migrated=" + r15 + ", skipped=" + r16 + ", cost=" + (System.currentTimeMillis() - r12), false, 4, null);
        a r1 = new a(MigrationStatus.SUCCESS, r15, r16, r3, null, 16, null);
    L21:
        DatabaseIsolationTracker r17 = DatabaseIsolationTracker.f11642a;
        DatabaseIsolationTracker.VectorFileMigrationPhase r18 = DatabaseIsolationTracker.VectorFileMigrationPhase.OVERALL;
        if (r1.a() != MigrationStatus.SUCCESS) goto L24;
        String r2 = "success";
    L25:
        DatabaseIsolationTracker.a(r17, r18, r2, r1.b(), r1.c(), r1.d(), System.currentTimeMillis() - r12, r1.e(), null, 128, null);
        return r1;
    L24:
        r2 = "failed";
        goto L25
    L20:
        int r9 = r15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "vector db file migration failed, profile=" + q.f13259a.b(r11) + ", migrated=" + r9 + ", skipped=" + r16 + ", failed=" + r3, null, 4, null);
        r1 = new a(MigrationStatus.FAILED, r9, r16, r3, null, 16, null);
        goto L21
    }

    public final a a(String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "baseDbName");
        Intrinsics.checkNotNullParameter(r22, "targetModelName");
        Intrinsics.checkNotNullParameter(r23, "targetVlmName");
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("personal_vector_db_file_migration_item_done_" + r21, false) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "skip vector db file item migration, already done, table=" + r21 + ", targetModel=" + q.f13259a.b(r22) + ", targetVlm=" + q.f13259a.b(r23), false, 4, null);
        return new a(MigrationStatus.ALREADY_DONE, 0, 2, 0, null, 26, null);
    L6:
        i r0 = b();
        if (r0.c() == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_PersonalVectorDbFileMigrator", "skip vector db file item migration, invalid uid, table=" + r21 + ", rawUserId=" + q.f13259a.b(r0.b()) + ", isLogin=" + AppContext.INSTANCE.isLogin() + ", targetModel=" + q.f13259a.b(r22) + ", targetVlm=" + q.f13259a.b(r23), null, 4, null);
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, DatabaseIsolationTracker.VectorFileMigrationPhase.DYNAMIC_ITEM, "skipped_invalid_uid", 0, 0, 0, 0, "invalid_uid", r21, 60, null);
        return new a(MigrationStatus.SKIPPED_INVALID_UID, 0, 0, 0, "invalid_uid", 14, null);
    L10:
        long r6 = System.currentTimeMillis();
        a r10 = a(new c(r21), r22, r23, r0.a(), new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "vectorDataBase"));
        DatabaseIsolationTracker r1 = DatabaseIsolationTracker.f11642a;
        DatabaseIsolationTracker.VectorFileMigrationPhase r2 = DatabaseIsolationTracker.VectorFileMigrationPhase.DYNAMIC_ITEM;
        if (r10.a() != MigrationStatus.SUCCESS) goto L13;
        String r3 = "success";
    L14:
        r1.a(r2, r3, r10.b(), r10.c(), r10.d(), System.currentTimeMillis() - r6, r10.e(), r21);
        return r10;
    L13:
        r3 = "failed";
        goto L14
    }
}
