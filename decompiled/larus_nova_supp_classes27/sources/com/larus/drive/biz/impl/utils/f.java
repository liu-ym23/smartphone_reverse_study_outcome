package com.larus.drive.biz.impl.utils;

import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static final CopyOnWriteArrayList<WeakReference<AbsDriveListViewModel>> a = null;

    static {
        a = new CopyOnWriteArrayList();
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "fileToken");
        FLogger.a.i("DriveLocalFileUpdateHelper", "deleteFileInList, fileToken[" + r3 + ']');
        Iterator<WeakReference<AbsDriveListViewModel>> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        WeakReference<AbsDriveListViewModel> r1 = r0.next();
        AbsDriveListViewModel r2 = r1.get();
        if (r2 == null) goto L7;
        DriveFileItem r4 = r2.getFileFromLocalList(r3);
        if (r4 == null) goto L4;
        r2.deleteFile(r4);
        goto L4
    L7:
        a.remove(r1);
        goto L4
    }

    public static void b(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "fileToken");
        Intrinsics.checkNotNullParameter(r6, "name");
        FLogger.a.i("DriveLocalFileUpdateHelper", "updateFileInList, fileToken[" + r5 + ']');
        Iterator<WeakReference<AbsDriveListViewModel>> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        WeakReference<AbsDriveListViewModel> r1 = r0.next();
        AbsDriveListViewModel r2 = r1.get();
        if (r2 == null) goto L7;
        DriveFileItem r3 = r2.getFileFromLocalList(r5);
        if (r3 == null) goto L4;
        r2.updateFile(DriveFileItem.a(r3, r6, null, null, 4094));
        goto L4
    L7:
        a.remove(r1);
        goto L4
    }
}
