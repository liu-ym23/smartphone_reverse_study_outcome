package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkDatabasePathHelper {
    public static final WorkDatabasePathHelper INSTANCE = null;

    static {
        INSTANCE = new WorkDatabasePathHelper();
    }

    private WorkDatabasePathHelper() {
    }

    @RequiresApi(23)
    private final File getNoBackupPath(Context r10) {
        return new File(Api21Impl.INSTANCE.getNoBackupFilesDir(r10), WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
    }

    @JvmStatic
    public static final void migrateDatabase(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        WorkDatabasePathHelper r11 = INSTANCE;
        File r12 = r11.getDefaultDatabasePath(r10);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        if (r12.exists() == false) goto L25;
        Logger.get().debug(WorkDatabasePathHelperKt.access$getTAG$p(), "Migrating WorkDatabase to the no-backup directory");
        Iterator<Map.Entry<File, File>> r13 = r11.migrationPaths(r10).entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L26;
        Map.Entry<File, File> r14 = r13.next();
        File r15 = r14.getKey();
        File r16 = r14.getValue();
        if (r15.exists() == false) goto L8;
        if (r16.exists() == false) goto L15;
        Logger.get().warning(WorkDatabasePathHelperKt.access$getTAG$p(), "Over-writing contents of " + r16);
    L15:
        if (r15.renameTo(r16) == false) goto L17;
        StringBuilder r17 = new StringBuilder();
        r17.append("Migrated ");
        r17.append(r15);
        r17.append("to ");
        r17.append(r16);
    L18:
        Logger.get().debug(WorkDatabasePathHelperKt.access$getTAG$p(), r17.toString());
        goto L8
    L17:
        r17 = new StringBuilder();
        r17.append("Renaming ");
        r17.append(r15);
        r17.append(" to ");
        r17.append(r16);
        r17.append(" failed");
        goto L18
    L26:
        return;
    }

    public final File getDatabasePath(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return getDefaultDatabasePath(r10);
    L6:
        return getNoBackupPath(r10);
    }

    public final File getDefaultDatabasePath(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        File r11 = r10.getDatabasePath(WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
        Intrinsics.checkNotNullExpressionValue(r11, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return r11;
    }

    public final Map<File, File> migrationPaths(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT < 23) goto L9;
        File r11 = getDefaultDatabasePath(r10);
        File r12 = getDatabasePath(r10);
        String[] r13 = WorkDatabasePathHelperKt.access$getDATABASE_EXTRA_FILES$p();
        LinkedHashMap r14 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r13.length), 16));
        int r15 = 0;
        int r16 = r13.length;
    L5:
        if (r15 >= r16) goto L11;
        String r17 = r13[r15];
        Pair r18 = TuplesKt.to(new File(r11.getPath() + r17), new File(r12.getPath() + r17));
        r14.put(r18.getFirst(), r18.getSecond());
        r15 = r15 + 1;
        goto L5
    L11:
        return MapsKt.plus(r14, TuplesKt.to(r11, r12));
    L9:
        return MapsKt.emptyMap();
    }
}
