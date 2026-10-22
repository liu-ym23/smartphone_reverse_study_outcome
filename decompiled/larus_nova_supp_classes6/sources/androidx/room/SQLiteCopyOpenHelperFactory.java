package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Callable<InputStream> mCopyFromInputStream;
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r9) {
        return new SQLiteCopyOpenHelper(r9.context, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, r9.callback.version, this.mDelegate.create(r9));
    }

    public SQLiteCopyOpenHelperFactory(String r1, File r2, Callable<InputStream> r3, SupportSQLiteOpenHelper.Factory r4) {
        this.mCopyFromAssetPath = r1;
        this.mCopyFromFile = r2;
        this.mCopyFromInputStream = r3;
        this.mDelegate = r4;
    }
}
