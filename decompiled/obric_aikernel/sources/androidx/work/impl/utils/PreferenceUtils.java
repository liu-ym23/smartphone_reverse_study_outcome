package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PreferenceUtils {
    public static final String CREATE_PREFERENCE = "CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))";
    public static final String INSERT_PREFERENCE = "INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)";
    public static final String KEY_LAST_CANCEL_ALL_TIME_MS = "last_cancel_all_time_ms";
    private static final String KEY_LAST_FORCE_STOP_MS = "last_force_stop_ms";
    public static final String KEY_RESCHEDULE_NEEDED = "reschedule_needed";
    public static final String PREFERENCES_FILE_NAME = "androidx.work.util.preferences";
    private final WorkDatabase mWorkDatabase;

    public PreferenceUtils(@NonNull WorkDatabase r10) {
        this.mWorkDatabase = r10;
    }

    public static void migrateLegacyPreferences(@NonNull Context r10, @NonNull SupportSQLiteDatabase r11) {
        SharedPreferences r12 = r10.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
        if (r12.contains(KEY_RESCHEDULE_NEEDED) == false) goto L5;
    L6:
        long r13 = 0;
        long r14 = r12.getLong(KEY_LAST_CANCEL_ALL_TIME_MS, 0);
        if (r12.getBoolean(KEY_RESCHEDULE_NEEDED, false) == false) goto L9;
        r13 = 1;
    L9:
        r11.beginTransaction();
        r11.execSQL(INSERT_PREFERENCE, new Object[]{KEY_LAST_CANCEL_ALL_TIME_MS, Long.valueOf(r14)});     // Catch: Throwable -> L13
        r11.execSQL(INSERT_PREFERENCE, new Object[]{KEY_RESCHEDULE_NEEDED, Long.valueOf(r13)});     // Catch: Throwable -> L13
        r12.edit().clear().apply();     // Catch: Throwable -> L13
        r11.setTransactionSuccessful();     // Catch: Throwable -> L13
        r11.endTransaction();
        return;
    L13:
        th = move-exception;
        r11.endTransaction();
        throw th;
    L5:
        if (r12.contains(KEY_LAST_CANCEL_ALL_TIME_MS) == true) goto L6;
    }

    public long getLastCancelAllTimeMillis() {
        Long r10 = this.mWorkDatabase.preferenceDao().getLongValue(KEY_LAST_CANCEL_ALL_TIME_MS);
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.longValue();
    }

    @NonNull
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return Transformations.map(this.mWorkDatabase.preferenceDao().getObservableLongValue(KEY_LAST_CANCEL_ALL_TIME_MS), new AnonymousClass1(this));
    }

    public long getLastForceStopEventMillis() {
        Long r10 = this.mWorkDatabase.preferenceDao().getLongValue(KEY_LAST_FORCE_STOP_MS);
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.longValue();
    }

    public boolean getNeedsReschedule() {
        Long r10 = this.mWorkDatabase.preferenceDao().getLongValue(KEY_RESCHEDULE_NEEDED);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.longValue() != 1) goto L7;
        return true;
    }

    public void setLastCancelAllTimeMillis(long r10) {
        Preference r11 = new Preference(KEY_LAST_CANCEL_ALL_TIME_MS, Long.valueOf(r10));
        this.mWorkDatabase.preferenceDao().insertPreference(r11);
    }

    public void setLastForceStopEventMillis(long r10) {
        Preference r11 = new Preference(KEY_LAST_FORCE_STOP_MS, Long.valueOf(r10));
        this.mWorkDatabase.preferenceDao().insertPreference(r11);
    }

    public void setNeedsReschedule(boolean r10) {
        Preference r11 = new Preference(KEY_RESCHEDULE_NEEDED, r10);
        this.mWorkDatabase.preferenceDao().insertPreference(r11);
    }
}
