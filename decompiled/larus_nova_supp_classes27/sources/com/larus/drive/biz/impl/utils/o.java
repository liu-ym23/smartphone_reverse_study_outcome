package com.larus.drive.biz.impl.utils;

import com.larus.drive.biz.api.model.DriveUploadStatus;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Map r7) {
        Intrinsics.checkNotNullParameter(r7, "uploadItems");
        if (r7.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator r8 = r7.entrySet().iterator();
        int r0 = 3;
    L7:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) r8.next();
        if (CollectionsKt.listOf(new DriveUploadStatus[]{DriveUploadStatus.UPLOADING, DriveUploadStatus.UNSTARTED}).contains(((com.larus.drive.biz.api.model.a) r2.getValue()).f) == true) goto L10;
        if (((com.larus.drive.biz.api.model.a) r2.getValue()).f != DriveUploadStatus.FAILED) goto L7;
        r0 = 2;
        goto L7
    L10:
        return 1;
    L14:
        return r0;
    }
}
