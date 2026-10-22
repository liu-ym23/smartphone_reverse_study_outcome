package androidx.work.impl;

import androidx.work.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabasePathHelperKt {
    private static final String[] DATABASE_EXTRA_FILES = null;
    private static final String TAG = null;
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        String r10 = Logger.tagWithPrefix("WrkDbPathHelper");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"WrkDbPathHelper\")");
        TAG = r10;
        DATABASE_EXTRA_FILES = new String[]{"-journal", "-shm", "-wal"};
    }

    public static final /* synthetic */ String[] access$getDATABASE_EXTRA_FILES$p() {
        return DATABASE_EXTRA_FILES;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }
}
