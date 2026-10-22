package com.obric.sva.sdk.db;

import android.content.Context;
import androidx.room.DatabaseConfiguration;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/sva/sdk/db/SvaSdkDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "VoicePrintDao", "Lcom/obric/sva/sdk/db/VoicePrintDao;", "init", "", "configuration", "Landroidx/room/DatabaseConfiguration;", "Companion", "Migrations", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public abstract class SvaSdkDatabase extends RoomDatabase {
    public static final Companion Companion = null;
    public static final String DB_NAME = "sva_sdk";
    private static final String TAG = "SvaSdkDatabase";
    private static volatile SvaSdkDatabase sMe;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/sva/sdk/db/SvaSdkDatabase$Companion;", "", "<init>", "()V", "DB_NAME", "", "TAG", "sMe", "Lcom/obric/sva/sdk/db/SvaSdkDatabase;", "instance", "c", "Landroid/content/Context;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final SvaSdkDatabase instance(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "c");
            if (SvaSdkDatabase.access$getSMe$cp() != null) goto L5;
            LogUtils.i(SvaSdkDatabase.TAG, "SvaSdkDatabase instance ...", new Object[0]);
            SvaSdkDatabase.access$setSMe$cp((SvaSdkDatabase) Room.databaseBuilder(r5, SvaSdkDatabase.class, SvaSdkDatabase.DB_NAME).addMigrations(new Migration[]{Migrations.INSTANCE.getMIGRATION_1_2()}).fallbackToDestructiveMigration().build());
        L5:
            SvaSdkDatabase r6 = SvaSdkDatabase.access$getSMe$cp();
            Intrinsics.checkNotNull(r6);
            return r6;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/db/SvaSdkDatabase$Migrations;", "", "<init>", "()V", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Migrations {
        public static final Migrations INSTANCE = null;
        private static final Migration MIGRATION_1_2 = null;

        private Migrations() {
        }

        static {
            INSTANCE = new Migrations();
            MIGRATION_1_2 = new SvaSdkDatabase$Migrations$MIGRATION_1_2$1();
        }

        public final Migration getMIGRATION_1_2() {
            return MIGRATION_1_2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract VoicePrintDao VoicePrintDao();

    public SvaSdkDatabase() {
    }

    public static final /* synthetic */ SvaSdkDatabase access$getSMe$cp() {
        return sMe;
    }

    public static final /* synthetic */ void access$setSMe$cp(SvaSdkDatabase r0) {
        sMe = r0;
    }

    public void init(DatabaseConfiguration r3) {
        Intrinsics.checkNotNullParameter(r3, "configuration");
        super.init(r3);
        LogUtils.i(TAG, "init with configuration " + r3, new Object[0]);
    }
}
