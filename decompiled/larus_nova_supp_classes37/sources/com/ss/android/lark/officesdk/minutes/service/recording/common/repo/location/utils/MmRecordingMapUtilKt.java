package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingMapUtilKt {
    public static final PolarisFileWrapper c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2.getFilesDir(), "mm_map");
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    public static final boolean a(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 == false) goto L5;
        String r3 = "mm_map_snapshot_dark.png";
    L6:
        PolarisFileWrapper r0 = new PolarisFileWrapper(c(r1), r3);
        if (r0.exists() == true) goto L11;
        return false;
    L11:
        return r0.delete();
    L5:
        r3 = "mm_map_snapshot_light.png";
        goto L6
    }

    public static final void b(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "logTag");
        Intrinsics.checkNotNullParameter(r5, "from");
        lvb.a.e(r4, "[deleteMapFiles] from=" + r5 + ", dark=" + a(r3, true) + ", light=" + a(r3, false));
    }

    public static final Object d(Context r3, boolean r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordingMapUtilKt$isSnapShotFileExist$2(r4, r3, null), r5);
    }
}
