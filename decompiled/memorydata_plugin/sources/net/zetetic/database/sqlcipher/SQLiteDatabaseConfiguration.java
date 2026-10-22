package net.zetetic.database.sqlcipher;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteDatabaseConfiguration {
    private static final Pattern EMAIL_IN_DB_PATTERN = null;
    public static final String MEMORY_DB_PATH = ":memory:";
    public final ArrayList<SQLiteCustomFunction> customFunctions;
    public SQLiteDatabaseHook databaseHook;
    public boolean foreignKeyConstraintsEnabled;
    public final String label;
    public Locale locale;
    public int maxSqlCacheSize;
    public int openFlags;
    public byte[] password;
    public final String path;

    static {
        EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    }

    public SQLiteDatabaseConfiguration(String r2, int r3) {
        this(r2, r3, null, null);
    }

    public SQLiteDatabaseConfiguration(String r3, int r4, byte[] r5, SQLiteDatabaseHook r6) {
        SQLiteDatabaseHook r7 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r6, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        this.customFunctions = new ArrayList();
        if (r3 == null) goto L7;
        this.path = r3;
        this.label = stripPathForLogs(r3);
        this.openFlags = r4;
        this.password = r5;
        this.databaseHook = r7;
        this.maxSqlCacheSize = 25;
        this.locale = Locale.getDefault();
        return;
    L7:
        throw new IllegalArgumentException("path must not be null.");
    }

    public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration r2) {
        this.customFunctions = new ArrayList();
        if (r2 == null) goto L7;
        this.path = r2.path;
        this.label = r2.label;
        updateParametersFrom(r2);
        return;
    L7:
        throw new IllegalArgumentException("other must not be null.");
    }

    private static String stripPathForLogs(String r2) {
        int r0 = r2.indexOf(63);
        if (r0 < 0) goto L6;
        r2 = (String) ZeusTransformUtils.preCheckCast(r2.subSequence(0, r0), String.class, "com.obric.memorydata.plugin");
    L6:
        if (r2.indexOf(64) != (-1)) goto L9;
        return r2;
    L9:
        return EMAIL_IN_DB_PATTERN.matcher(r2).replaceAll("XX@YY");
    }

    public boolean isInMemoryDb() {
        return this.path.equalsIgnoreCase(MEMORY_DB_PATH);
    }

    public void updateParametersFrom(SQLiteDatabaseConfiguration r3) {
        if (r3 == null) goto L10;
        if (this.path.equals(r3.path) == false) goto L8;
        this.openFlags = r3.openFlags;
        this.maxSqlCacheSize = r3.maxSqlCacheSize;
        this.locale = r3.locale;
        this.foreignKeyConstraintsEnabled = r3.foreignKeyConstraintsEnabled;
        this.password = r3.password;
        this.databaseHook = r3.databaseHook;
        this.customFunctions.clear();
        this.customFunctions.addAll(r3.customFunctions);
        return;
    L8:
        throw new IllegalArgumentException("other configuration must refer to the same database.");
    L10:
        throw new IllegalArgumentException("other must not be null.");
    }
}
