package androidx.work.impl;

import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGeneratorKt;
import androidx.work.impl.utils.PreferenceUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WorkMigration9To10 extends Migration {
    private final Context context;

    public WorkMigration9To10(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(9, 10);
        this.context = r10;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        r10.execSQL(PreferenceUtils.CREATE_PREFERENCE);
        PreferenceUtils.migrateLegacyPreferences(this.context, r10);
        IdGeneratorKt.migrateLegacyIdGenerator(this.context, r10);
    }
}
