package net.zetetic.database.sqlcipher;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SupportOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private static final int UNCHANGED = -1;
    private final boolean enableWriteAheadLogging;
    private final SQLiteDatabaseHook hook;
    private final int minimumSupportedVersion;
    private final byte[] password;

    public SupportOpenHelperFactory(byte[] r3) {
        this(r3, null, false);
    }

    public SupportOpenHelperFactory(byte[] r3, SQLiteDatabaseHook r4, boolean r5) {
        this(r3, (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r4, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin"), r5, -1);
    }

    public SupportOpenHelperFactory(byte[] r3, SQLiteDatabaseHook r4, boolean r5, int r6) {
        SQLiteDatabaseHook r7 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r4, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        this.password = r3;
        this.hook = r7;
        this.enableWriteAheadLogging = r5;
        this.minimumSupportedVersion = r6;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r10) {
        if (this.minimumSupportedVersion != (-1)) goto L7;
        return new SupportHelper(r10, this.password, this.hook, this.enableWriteAheadLogging);
    L7:
        return new SupportHelper(r10, this.password, this.hook, this.enableWriteAheadLogging, this.minimumSupportedVersion);
    }
}
