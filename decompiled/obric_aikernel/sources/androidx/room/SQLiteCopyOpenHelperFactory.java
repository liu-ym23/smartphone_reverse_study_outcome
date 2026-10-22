package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Callable<InputStream> mCopyFromInputStream;
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    public SQLiteCopyOpenHelperFactory(String r10, File r11, Callable<InputStream> r12, SupportSQLiteOpenHelper.Factory r13) {
        Intrinsics.checkNotNullParameter(r13, "mDelegate");
        this.mCopyFromAssetPath = r10;
        this.mCopyFromFile = r11;
        this.mCopyFromInputStream = r12;
        this.mDelegate = r13;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "configuration");
        return new SQLiteCopyOpenHelper(r10.context, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, r10.callback.version, this.mDelegate.create(r10));
    }
}
