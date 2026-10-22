package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    public FrameworkSQLiteOpenHelperFactory() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "configuration");
        return new FrameworkSQLiteOpenHelper(r10.context, r10.name, r10.callback, r10.useNoBackupDirectory, r10.allowDataLossOnRecovery);
    }
}
