package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class IdGeneratorKt {
    public static final int INITIAL_ID = 0;
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";

    public static final /* synthetic */ int access$nextId(WorkDatabase r10, String r11) {
        return nextId(r10, r11);
    }

    public static final /* synthetic */ void access$updatePreference(WorkDatabase r10, String r11, int r12) {
        updatePreference(r10, r11, r12);
    }

    public static final void migrateLegacyIdGenerator(Context r10, SupportSQLiteDatabase r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "sqLiteDatabase");
        SharedPreferences r12 = r10.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        if (r12.contains(NEXT_JOB_SCHEDULER_ID_KEY) == false) goto L5;
    L6:
        int r13 = r12.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
        int r14 = r12.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
        r11.beginTransaction();
        r11.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, Integer.valueOf(r13)});     // Catch: Throwable -> L10
        r11.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{NEXT_ALARM_MANAGER_ID_KEY, Integer.valueOf(r14)});     // Catch: Throwable -> L10
        r12.edit().clear().apply();     // Catch: Throwable -> L10
        r11.setTransactionSuccessful();     // Catch: Throwable -> L10
        r11.endTransaction();
        return;
    L10:
        th = move-exception;
        r11.endTransaction();
        throw th;
    L5:
        if (r12.contains(NEXT_JOB_SCHEDULER_ID_KEY) == true) goto L6;
    }

    private static final int nextId(WorkDatabase r10, String r11) {
        Long r12 = r10.preferenceDao().getLongValue(r11);
        int r13 = 0;
        if (r12 == null) goto L5;
        int r14 = (int) r12.longValue();
    L7:
        if (r14 == Integer.MAX_VALUE) goto L10;
        r13 = r14 + 1;
    L10:
        updatePreference(r10, r11, r13);
        return r14;
    L5:
        r14 = 0;
        goto L7
    }

    private static final void updatePreference(WorkDatabase r10, String r11, int r12) {
        r10.preferenceDao().insertPreference(new Preference(r11, Long.valueOf(r12)));
    }
}
