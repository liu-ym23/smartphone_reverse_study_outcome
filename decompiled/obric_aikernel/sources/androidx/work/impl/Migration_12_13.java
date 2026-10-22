package androidx.work.impl;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Migration_12_13 extends Migration {
    public static final Migration_12_13 INSTANCE = null;

    static {
        INSTANCE = new Migration_12_13();
    }

    private Migration_12_13() {
        super(12, 13);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        r10.execSQL("UPDATE workspec SET required_network_type = 0 WHERE required_network_type IS NULL ");
        r10.execSQL("UPDATE workspec SET content_uri_triggers = x'' WHERE content_uri_triggers is NULL");
    }
}
