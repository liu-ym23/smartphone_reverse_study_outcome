package com.larus.drive.sdk.impl;

import com.bytedance.flow.search.kmp.api.spi.SearchDriveItem;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import u79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w implements b {
    public final /* synthetic */ kotlinx.coroutines.i<zv5.i> a;
    public final /* synthetic */ KmpSearchDriveServiceImpl b;

    @Override // u79.b
    public final void onError(String r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        if (this.a.isActive() == false) goto L6;
        kotlinx.coroutines.i<zv5.i> r9 = this.a;
        Result.Companion r0 = Result.Companion;
        r9.resumeWith(Result.constructor-impl(new zv5.i(null, null, false, true, 7)));
        return;
    }

    public w(kotlinx.coroutines.j r1, KmpSearchDriveServiceImpl r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // u79.b
    public final void a(String r22, List<DriveFileItem> r23) {
        w r0 = this;
        Intrinsics.checkNotNullParameter(r23, "driveFileList");
        KmpSearchDriveServiceImpl r2 = r0.b;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r1 = r23.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        DriveFileItem r3 = (DriveFileItem) r1.next();
        r2.getClass();
        r4.add(new SearchDriveItem(r3.a, r3.b, r3.c, r3.d, r3.e, r3.f, r3.g, r3.i, r3.j.getValue(), r3.k, r3.l, r3.h));
        r0 = this;
        r1 = r1;
        r2 = r2;
        goto L4
    L7:
        if (r0.a.isActive() == false) goto L18;
        kotlinx.coroutines.i<zv5.i> r5 = r0.a;
        if (r22 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        r5.resumeWith(Result.constructor-impl(new zv5.i(r4, r22, !r6, false, 8)));
        return;
    L11:
        if (StringsKt.isBlank(r22) == true) goto L14;
        r6 = false;
        goto L15
    }
}
