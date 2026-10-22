package com.larus.disk.impl;

import com.larus.disk.api.ManualCacheCleanError;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ManualCacheCleanError.values().length];
            r0[ManualCacheCleanError.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ManualCacheCleanError.BUSINESS_HANDLER_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ManualCacheCleanError.MULTIPLE_COMPONENTS_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2) {
        if (r2 == false) goto L5;
        return r0;
    L5:
        return r1;
    }

    public static final String c(ManualCacheCleanError r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r3, "failedBizTags");
        int r0 = a.a[r2.ordinal()];
        if (r0 != 1) goto L5;
        return "none";
    L5:
        if (r0 != 2) goto L7;
        String r4 = (String) SequencesKt.firstOrNull(SequencesKt.sorted(SequencesKt.filter(CollectionsKt.asSequence(r3), new v())));
        if (r4 != null) goto L17;
        return "unknown";
    L17:
        return r4;
    L7:
        if (r0 != 3) goto L15;
        return "multiple_components";
    L15:
        return r2.getStage();
    }

    public static final ManualCacheCleanError b(AppDiskManager$CleanExecutionStatus r4, AppDiskManager$CleanExecutionStatus r5, boolean r6, boolean r7, boolean r8, boolean r9, long r10) {
        Intrinsics.checkNotNullParameter(r4, "executionStatus");
        if (r5 != AppDiskManager$CleanExecutionStatus.ACCOUNT_CHANGED) goto L7;
        return ManualCacheCleanError.ACCOUNT_CHANGED;
    L7:
        if (r5 == AppDiskManager$CleanExecutionStatus.APP_FOREGROUND) goto L9;
        int r1 = 0;
        List r11 = CollectionsKt.listOf(new Boolean[]{Boolean.valueOf(r6), Boolean.valueOf(r7), Boolean.valueOf(r8)});
        if ((r11 instanceof Collection) == true) goto L13;
    L15:
        Iterator r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L23;
        if ((!((Boolean) r12.next()).booleanValue()) == false) goto L17;
        r1 = r1 + 1;
        if (r1 >= 0) goto L17;
        CollectionsKt.throwCountOverflow();
    L23:
        if (r1 > 1) goto L25;
        if (r6 == false) goto L28;
        if (r7 == false) goto L31;
        if (r8 == false) goto L34;
        if (r9 == false) goto L41;
        if (r10 <= 0) goto L41;
        return ManualCacheCleanError.REMAINING_CACHE;
    L41:
        if (r4 == AppDiskManager$CleanExecutionStatus.FAILED) goto L47;
        if (r4 == AppDiskManager$CleanExecutionStatus.PARTIAL) goto L47;
        return ManualCacheCleanError.NONE;
    L47:
        return ManualCacheCleanError.EXECUTION_FAILED;
    L34:
        return ManualCacheCleanError.BUSINESS_HANDLER_FAILED;
    L31:
        return ManualCacheCleanError.CONFIGURED_PATH_DELETE_FAILED;
    L28:
        return ManualCacheCleanError.ROOT_CACHE_DELETE_FAILED;
    L25:
        return ManualCacheCleanError.MULTIPLE_COMPONENTS_FAILED;
    L13:
        if (r11.isEmpty() == false) goto L15;
    L9:
        return ManualCacheCleanError.APP_FOREGROUND;
    }
}
