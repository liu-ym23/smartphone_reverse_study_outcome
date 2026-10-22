package androidx.room;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "configuration", "Landroidx/room/DatabaseConfiguration;", "delegate", "Landroidx/room/RoomOpenHelper$Delegate;", "legacyHash", "", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;)V", "identityHash", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;Ljava/lang/String;)V", "checkIdentity", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "createMasterTableIfNotExists", "onConfigure", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "updateIdentity", "Companion", "Delegate", "ValidationResult", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public static final Companion Companion = null;
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/room/RoomOpenHelper$Companion;", "", "()V", "hasEmptySchema", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "hasEmptySchema$room_runtime_release", "hasRoomMasterTable", "hasRoomMasterTable$room_runtime_release", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final boolean hasEmptySchema$room_runtime_release(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
            Cursor r10 = r5.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            boolean r11 = false;
            if (r10.moveToFirst() == false) goto L10;
            if (r10.getInt(0) != 0) goto L10;
            r11 = true;
        L10:
            CloseableKt.closeFinally(r10, null);
            return r11;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            CloseableKt.closeFinally(r10, th);
            throw th;
        }

        public final boolean hasRoomMasterTable$room_runtime_release(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
            Cursor r10 = r5.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            boolean r11 = false;
            if (r10.moveToFirst() == false) goto L10;
            if (r10.getInt(0) == 0) goto L10;
            r11 = true;
        L10:
            CloseableKt.closeFinally(r10, null);
            return r11;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            CloseableKt.closeFinally(r10, th);
            throw th;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/RoomOpenHelper$Delegate;", "", "version", "", "(I)V", "createAllTables", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "dropAllTables", "onCreate", "onOpen", "onPostMigrate", "onPreMigrate", "onValidateSchema", "Landroidx/room/RoomOpenHelper$ValidationResult;", "db", "validateMigration", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {

        @JvmField
        public final int version;

        public Delegate(int r5) {
            this.version = r5;
        }

        public abstract void createAllTables(SupportSQLiteDatabase r5);

        public abstract void dropAllTables(SupportSQLiteDatabase r5);

        public abstract void onCreate(SupportSQLiteDatabase r5);

        public abstract void onOpen(SupportSQLiteDatabase r5);

        public void onPostMigrate(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "database");
        }

        public void onPreMigrate(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "database");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
            validateMigration(r5);
            return new ValidationResult(true, null);
        }

        @Deprecated(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        public void validateMigration(SupportSQLiteDatabase r5) {
            Intrinsics.checkNotNullParameter(r5, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/RoomOpenHelper$ValidationResult;", "", "isValid", "", "expectedFoundMsg", "", "(ZLjava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {

        @JvmField
        public final String expectedFoundMsg;

        @JvmField
        public final boolean isValid;

        public ValidationResult(boolean r5, String r10) {
            this.isValid = r5;
            this.expectedFoundMsg = r10;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RoomOpenHelper(DatabaseConfiguration r5, Delegate r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "configuration");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "identityHash");
        Intrinsics.checkNotNullParameter(r12, "legacyHash");
        super(r10.version);
        this.configuration = r5;
        this.delegate = r10;
        this.identityHash = r11;
        this.legacyHash = r12;
    }

    private final void checkIdentity(SupportSQLiteDatabase r5) {
        if (Companion.hasRoomMasterTable$room_runtime_release(r5) == false) goto L23;
        Cursor r10 = r5.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L6:
        if (r10.moveToFirst() == false) goto L11;
        String r11 = r10.getString(0);     // Catch: Throwable -> L9
    L12:
        CloseableKt.closeFinally(r10, null);
        if (Intrinsics.areEqual(this.identityHash, r11) == false) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(this.legacyHash, r11) == false) goto L18;
        return;
    L18:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.t(new StringBuilder("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "), this.identityHash, ", found: ", r11));
    L11:
        r11 = null;
        goto L12
    L23:
        ValidationResult r12 = this.delegate.onValidateSchema(r5);
        if (r12.isValid == false) goto L28;
        this.delegate.onPostMigrate(r5);
        updateIdentity(r5);
        return;
    L28:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r12.expectedFoundMsg);
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase r5) {
        r5.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(SupportSQLiteDatabase r5) {
        createMasterTableIfNotExists(r5);
        r5.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "db");
        super.onConfigure(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "db");
        boolean r10 = Companion.hasEmptySchema$room_runtime_release(r5);
        this.delegate.createAllTables(r5);
        if (r10 == true) goto L9;
        ValidationResult r11 = this.delegate.onValidateSchema(r5);
        if (r11.isValid == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r11.expectedFoundMsg);
    L9:
        updateIdentity(r5);
        this.delegate.onCreate(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "db");
        onUpgrade(r5, r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "db");
        super.onOpen(r5);
        checkIdentity(r5);
        this.delegate.onOpen(r5);
        this.configuration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "db");
        DatabaseConfiguration r12 = this.configuration;
        if (r12 == null) goto L15;
        List<Migration> r13 = r12.migrationContainer.findMigrationPath(r10, r11);
        if (r13 == null) goto L15;
        this.delegate.onPreMigrate(r5);
        Iterator<T> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        ((Migration) r14.next()).migrate(r5);
        goto L8
    L10:
        ValidationResult r15 = this.delegate.onValidateSchema(r5);
        if (r15.isValid == false) goto L14;
        this.delegate.onPostMigrate(r5);
        updateIdentity(r5);
        return;
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r15.expectedFoundMsg);
    L15:
        DatabaseConfiguration r16 = this.configuration;
        if (r16 == null) goto L22;
        if (r16.isMigrationRequired(r10, r11) == true) goto L22;
        this.delegate.dropAllTables(r5);
        this.delegate.createAllTables(r5);
        return;
    L22:
        throw new IllegalStateException("A migration from " + r10 + " to " + r11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public RoomOpenHelper(DatabaseConfiguration r5, Delegate r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "configuration");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "legacyHash");
        this(r5, r10, "", r11);
    }
}
