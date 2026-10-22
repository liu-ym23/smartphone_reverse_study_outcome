package androidx.room;

import android.database.Cursor;
import android.os.Build;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "configuration", "Landroidx/room/DatabaseConfiguration;", "delegate", "Landroidx/room/RoomOpenHelper$Delegate;", "legacyHash", "", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;)V", "identityHash", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;Ljava/lang/String;)V", "checkIdentity", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "createMasterTableIfNotExists", "onConfigure", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "updateIdentity", "Companion", "Delegate", "ValidationResult", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public static final Companion Companion = null;
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/room/RoomOpenHelper$Companion;", "", "()V", "hasEmptySchema", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "hasEmptySchema$room_runtime_release", "hasRoomMasterTable", "hasRoomMasterTable$room_runtime_release", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean hasEmptySchema$room_runtime_release(SupportSQLiteDatabase r5) {
            SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "db");
            Cursor r6 = r4.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            boolean r1 = true;
            if (Build.VERSION.SDK_INT <= 15) goto L33;
            Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            if (r0.moveToFirst() == false) goto L10;
            if (r0.getInt(0) != 0) goto L10;
        L11:
            CloseableKt.closeFinally(r7, null);
            return r1;
        L10:
            r1 = false;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r7, th);
            throw th;
        L33:
        L26:
            th = move-exception;
            r6.close();
            throw th;
        L19:
            if (r6.moveToFirst() == false) goto L23;
            if (r6.getInt(0) != 0) goto L23;
        L24:
            r6.close();
            return r1;
        L23:
            r1 = false;
            goto L24
        }

        public final boolean hasRoomMasterTable$room_runtime_release(SupportSQLiteDatabase r5) {
            SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "db");
            Cursor r6 = r4.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            boolean r1 = true;
            if (Build.VERSION.SDK_INT <= 15) goto L33;
            Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            if (r0.moveToFirst() == false) goto L10;
            if (r0.getInt(0) == 0) goto L10;
        L11:
            CloseableKt.closeFinally(r7, null);
            return r1;
        L10:
            r1 = false;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r7, th);
            throw th;
        L33:
        L26:
            th = move-exception;
            r6.close();
            throw th;
        L19:
            if (r6.moveToFirst() == false) goto L23;
            if (r6.getInt(0) == 0) goto L23;
        L24:
            r6.close();
            return r1;
        L23:
            r1 = false;
            goto L24
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/RoomOpenHelper$Delegate;", "", "version", "", "(I)V", "createAllTables", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "dropAllTables", "onCreate", "onOpen", "onPostMigrate", "onPreMigrate", "onValidateSchema", "Landroidx/room/RoomOpenHelper$ValidationResult;", "db", "validateMigration", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Delegate {
        public final int version;

        public Delegate(int r1) {
            this.version = r1;
        }

        public abstract void createAllTables(SupportSQLiteDatabase r1);

        public abstract void dropAllTables(SupportSQLiteDatabase r1);

        public abstract void onCreate(SupportSQLiteDatabase r1);

        public abstract void onOpen(SupportSQLiteDatabase r1);

        public void onPostMigrate(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "database");
        }

        public void onPreMigrate(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "database");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase r3) {
            SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "db");
            validateMigration(r4);
            return new ValidationResult(true, null);
        }

        @Deprecated(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        public void validateMigration(SupportSQLiteDatabase r2) {
            Intrinsics.checkNotNullParameter((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomOpenHelper$ValidationResult;", "", "isValid", "", "expectedFoundMsg", "", "(ZLjava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean r1, String r2) {
            this.isValid = r1;
            this.expectedFoundMsg = r2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RoomOpenHelper(DatabaseConfiguration r2, Delegate r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        Intrinsics.checkNotNullParameter(r4, "legacyHash");
        this(r2, r3, "", r4);
    }

    public RoomOpenHelper(DatabaseConfiguration r2, Delegate r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        Intrinsics.checkNotNullParameter(r4, "identityHash");
        Intrinsics.checkNotNullParameter(r5, "legacyHash");
        super(r3.version);
        this.configuration = r2;
        this.delegate = r3;
        this.identityHash = r4;
        this.legacyHash = r5;
    }

    private final void checkIdentity(SupportSQLiteDatabase r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (Companion.hasRoomMasterTable$room_runtime_release(r7) == false) goto L32;
        Cursor r8 = r7.query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        if (Build.VERSION.SDK_INT <= 15) goto L41;
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r0.moveToFirst() == false) goto L10;
        String r1 = r0.getString(0);     // Catch: Throwable -> L12
    L11:
        CloseableKt.closeFinally(r9, null);
    L23:
        if (Intrinsics.areEqual(this.identityHash, r1) == false) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual(this.legacyHash, r1) == false) goto L28;
        return;
    L28:
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.identityHash + ", found: " + r1);
    L10:
        r1 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L41:
    L29:
        th = move-exception;
        r8.close();
        throw th;
    L18:
        if (r8.moveToFirst() == false) goto L20;
        r1 = r8.getString(0);     // Catch: Throwable -> L29
    L21:
        r8.close();
        goto L23
    L20:
        r1 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        goto L21
    L32:
        ValidationResult r2 = this.delegate.onValidateSchema(r7);
        if (r2.isValid == false) goto L37;
        this.delegate.onPostMigrate(r7);
        updateIdentity(r7);
        return;
    L37:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r2.expectedFoundMsg);
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        createMasterTableIfNotExists(r4);
        r4.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "db");
        super.onConfigure(r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "db");
        boolean r0 = Companion.hasEmptySchema$room_runtime_release(r4);
        this.delegate.createAllTables(r4);
        if (r0 == true) goto L9;
        ValidationResult r1 = this.delegate.onValidateSchema(r4);
        if (r1.isValid == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r1.expectedFoundMsg);
    L9:
        updateIdentity(r4);
        this.delegate.onCreate(r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase r3, int r4, int r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "db");
        onUpgrade(r6, r4, r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "db");
        super.onOpen(r4);
        checkIdentity(r4);
        this.delegate.onOpen(r4);
        this.configuration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase r5, int r6, int r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "db");
        DatabaseConfiguration r0 = this.configuration;
        boolean r2 = false;
        if (r0 == null) goto L15;
        List<Migration> r1 = r0.migrationContainer.findMigrationPath(r6, r7);
        if (r1 == null) goto L15;
        this.delegate.onPreMigrate(r8);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ((Migration) ZeusTransformUtils.preCheckCast(r3.next(), Migration.class, "com.obric.memorydata.plugin")).migrate(r8);
        goto L8
    L10:
        ValidationResult r4 = this.delegate.onValidateSchema(r8);
        if (r4.isValid == false) goto L14;
        this.delegate.onPostMigrate(r8);
        updateIdentity(r8);
        r2 = true;
        goto L15
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r4.expectedFoundMsg);
    L15:
        if (r2 == true) goto L23;
        DatabaseConfiguration r9 = this.configuration;
        if (r9 == null) goto L22;
        if (r9.isMigrationRequired(r6, r7) == true) goto L22;
        this.delegate.dropAllTables(r8);
        this.delegate.createAllTables(r8);
        return;
    L22:
        throw new IllegalStateException("A migration from " + r6 + " to " + r7 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}
