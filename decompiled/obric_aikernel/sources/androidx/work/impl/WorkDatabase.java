package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Data;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.concurrent.Executor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@TypeConverters({Data.class, WorkTypeConverters.class})
@Database(autoMigrations = {@AutoMigration(from = 13, to = 14), @AutoMigration(from = 14, spec = AutoMigration_14_15.class, to = 15)}, entities = {Dependency.class, WorkSpec.class, WorkTag.class, SystemIdInfo.class, WorkName.class, WorkProgress.class, Preference.class}, version = 16)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class WorkDatabase extends RoomDatabase {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ SupportSQLiteOpenHelper a(Context r10, SupportSQLiteOpenHelper.Configuration r11) {
            return create$lambda$0(r10, r11);
        }

        private static final SupportSQLiteOpenHelper create$lambda$0(Context r10, SupportSQLiteOpenHelper.Configuration r11) {
            Intrinsics.checkNotNullParameter(r10, "$context");
            Intrinsics.checkNotNullParameter(r11, "configuration");
            SupportSQLiteOpenHelper.Configuration.Builder r12 = SupportSQLiteOpenHelper.Configuration.Companion.builder(r10);
            r12.name(r11.name).callback(r11.callback).noBackupDirectory(true).allowDataLossOnRecovery(true);
            return new FrameworkSQLiteOpenHelperFactory().create(r12.build());
        }

        @JvmStatic
        public final WorkDatabase create(final Context r10, Executor r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "queryExecutor");
            if (r12 == false) goto L5;
            RoomDatabase.Builder r13 = Room.inMemoryDatabaseBuilder(r10, WorkDatabase.class).allowMainThreadQueries();
        L7:
            return (WorkDatabase) r13.setQueryExecutor(r11).addCallback(CleanupCallback.INSTANCE).addMigrations(new Migration[]{Migration_1_2.INSTANCE}).addMigrations(new Migration[]{new RescheduleMigration(r10, 2, 3)}).addMigrations(new Migration[]{Migration_3_4.INSTANCE}).addMigrations(new Migration[]{Migration_4_5.INSTANCE}).addMigrations(new Migration[]{new RescheduleMigration(r10, 5, 6)}).addMigrations(new Migration[]{Migration_6_7.INSTANCE}).addMigrations(new Migration[]{Migration_7_8.INSTANCE}).addMigrations(new Migration[]{Migration_8_9.INSTANCE}).addMigrations(new Migration[]{new WorkMigration9To10(r10)}).addMigrations(new Migration[]{new RescheduleMigration(r10, 10, 11)}).addMigrations(new Migration[]{Migration_11_12.INSTANCE}).addMigrations(new Migration[]{Migration_12_13.INSTANCE}).addMigrations(new Migration[]{Migration_15_16.INSTANCE}).fallbackToDestructiveMigration().build();
        L5:
            r13 = Room.databaseBuilder(r10, WorkDatabase.class, WorkDatabasePathHelperKt.WORK_DATABASE_NAME).openHelperFactory(new c(r10));
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WorkDatabase() {
    }

    @JvmStatic
    public static final WorkDatabase create(Context r10, Executor r11, boolean r12) {
        return Companion.create(r10, r11, r12);
    }

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract RawWorkInfoDao rawWorkInfoDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();
}
