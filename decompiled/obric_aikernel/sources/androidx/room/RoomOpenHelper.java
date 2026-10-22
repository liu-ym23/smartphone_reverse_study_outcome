package androidx.room;

import android.database.Cursor;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public static final Companion Companion = null;
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean hasEmptySchema$room_runtime_release(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
            Cursor r11 = r10.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            boolean r12 = true;
            if (Build.VERSION.SDK_INT > 15) goto L29;
        L26:
            th = move-exception;
            r11.close();
            throw th;
        L19:
            if (r11.moveToFirst() == false) goto L23;
            if (r11.getInt(0) != 0) goto L23;
        L24:
            r11.close();
            return r12;
        L23:
            r12 = false;
            goto L24
        L29:
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r11, th);
            throw th;
        L6:
            if (r11.moveToFirst() == false) goto L10;
            if (r11.getInt(0) != 0) goto L10;
        L11:
            CloseableKt.closeFinally(r11, null);
            return r12;
        L10:
            r12 = false;
            goto L11
        }

        public final boolean hasRoomMasterTable$room_runtime_release(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
            Cursor r11 = r10.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            boolean r12 = true;
            if (Build.VERSION.SDK_INT > 15) goto L29;
        L26:
            th = move-exception;
            r11.close();
            throw th;
        L19:
            if (r11.moveToFirst() == false) goto L23;
            if (r11.getInt(0) == 0) goto L23;
        L24:
            r11.close();
            return r12;
        L23:
            r12 = false;
            goto L24
        L29:
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r11, th);
            throw th;
        L6:
            if (r11.moveToFirst() == false) goto L10;
            if (r11.getInt(0) == 0) goto L10;
        L11:
            CloseableKt.closeFinally(r11, null);
            return r12;
        L10:
            r12 = false;
            goto L11
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {

        @JvmField
        public final int version;

        public Delegate(int r10) {
            this.version = r10;
        }

        public abstract void createAllTables(SupportSQLiteDatabase r10);

        public abstract void dropAllTables(SupportSQLiteDatabase r10);

        public abstract void onCreate(SupportSQLiteDatabase r10);

        public abstract void onOpen(SupportSQLiteDatabase r10);

        public void onPostMigrate(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "database");
        }

        public void onPreMigrate(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "database");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
            validateMigration(r10);
            return new ValidationResult(true, null);
        }

        @Deprecated(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        protected void validateMigration(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {

        @JvmField
        public final String expectedFoundMsg;

        @JvmField
        public final boolean isValid;

        public ValidationResult(boolean r10, String r11) {
            this.isValid = r10;
            this.expectedFoundMsg = r11;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RoomOpenHelper(DatabaseConfiguration r10, Delegate r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "configuration");
        Intrinsics.checkNotNullParameter(r11, "delegate");
        Intrinsics.checkNotNullParameter(r12, "legacyHash");
        this(r10, r11, "", r12);
    }

    public RoomOpenHelper(DatabaseConfiguration r10, Delegate r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "configuration");
        Intrinsics.checkNotNullParameter(r11, "delegate");
        Intrinsics.checkNotNullParameter(r12, "identityHash");
        Intrinsics.checkNotNullParameter(r13, "legacyHash");
        super(r11.version);
        this.configuration = r10;
        this.delegate = r11;
        this.identityHash = r12;
        this.legacyHash = r13;
    }

    private final void checkIdentity(SupportSQLiteDatabase r10) {
        if (Companion.hasRoomMasterTable$room_runtime_release(r10) == false) goto L31;
        Cursor r11 = r10.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
        String r12 = null;
        if (Build.VERSION.SDK_INT > 15) goto L39;
    L28:
        th = move-exception;
        r11.close();
        throw th;
    L18:
        if (r11.moveToFirst() == false) goto L20;
        r12 = r11.getString(0);     // Catch: Throwable -> L28
    L20:
        r11.close();
        String r13 = r12;
    L22:
        if (Intrinsics.areEqual(this.identityHash, r13) == false) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual(this.legacyHash, r13) == false) goto L27;
        return;
    L27:
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.identityHash + ", found: " + r13);
    L39:
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L7:
        if (r11.moveToFirst() == false) goto L10;
        r13 = r11.getString(0);     // Catch: Throwable -> L12
    L11:
        CloseableKt.closeFinally(r11, null);
        goto L22
    L10:
        r13 = null;
        goto L11
    L31:
        ValidationResult r14 = this.delegate.onValidateSchema(r10);
        if (r14.isValid == false) goto L36;
        this.delegate.onPostMigrate(r10);
        updateIdentity(r10);
        return;
    L36:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r14.expectedFoundMsg);
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase r10) {
        r10.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(SupportSQLiteDatabase r10) {
        createMasterTableIfNotExists(r10);
        r10.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        super.onConfigure(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        boolean r11 = Companion.hasEmptySchema$room_runtime_release(r10);
        this.delegate.createAllTables(r10);
        if (r11 == true) goto L9;
        ValidationResult r12 = this.delegate.onValidateSchema(r10);
        if (r12.isValid == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r12.expectedFoundMsg);
    L9:
        updateIdentity(r10);
        this.delegate.onCreate(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "db");
        onUpgrade(r10, r11, r12);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        super.onOpen(r10);
        checkIdentity(r10);
        this.delegate.onOpen(r10);
        this.configuration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "db");
        DatabaseConfiguration r13 = this.configuration;
        boolean r14 = false;
        if (r13 == null) goto L15;
        List<Migration> r15 = r13.migrationContainer.findMigrationPath(r11, r12);
        if (r15 == null) goto L15;
        this.delegate.onPreMigrate(r10);
        Iterator<T> r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        ((Migration) r16.next()).migrate(r10);
        goto L8
    L10:
        ValidationResult r17 = this.delegate.onValidateSchema(r10);
        if (r17.isValid == false) goto L14;
        this.delegate.onPostMigrate(r10);
        updateIdentity(r10);
        r14 = true;
        goto L15
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r17.expectedFoundMsg);
    L15:
        if (r14 == true) goto L23;
        DatabaseConfiguration r18 = this.configuration;
        if (r18 == null) goto L22;
        if (r18.isMigrationRequired(r11, r12) == true) goto L22;
        this.delegate.dropAllTables(r10);
        this.delegate.createAllTables(r10);
        return;
    L22:
        throw new IllegalStateException("A migration from " + r11 + " to " + r12 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}
