package com.larus.drive.biz.impl.file;

import com.larus.drive.biz.api.model.DriveUploadStatus;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.p1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements y79.b {
    public s() {
    }

    @Override // y79.b
    public final void onFailed(String r9, int r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        Lazy r0 = t.a;
        Map r1 = (Map) t.f().getValue();
        if (r1 != null) goto L7;
        return;
    L7:
        Iterator r2 = r1.values().iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((com.larus.drive.biz.api.model.a) r3).b, r9) == false) goto L9;
    L14:
        com.larus.drive.biz.api.model.a r4 = (com.larus.drive.biz.api.model.a) r3;
        if (r4 == null) goto L28;
        com.larus.drive.biz.api.model.a r11 = r4.a();
        DriveUploadStatus r5 = DriveUploadStatus.FAILED;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r11.f = r5;
        Lazy r6 = t.a;
        if (r10 != 90003043) goto L19;
        int r7 = 2131907743;
    L23:
        r11.g = Integer.valueOf(r7);
        t.a(r11);
        FLogger.a.i("DriveUploadManager", "onFailed itemId = " + r11.a + ", errorCode = " + r10);
        String r8 = r11.a;
        String r12 = r11.c;
        Boolean r13 = Boolean.FALSE;
        String r14 = com.larus.drive.biz.impl.utils.e.a;
        p1.d(r8, r12, r13, com.larus.drive.biz.impl.utils.e.c(r11.d), com.larus.drive.biz.impl.utils.e.a(r11), r11.j);
        return;
    L19:
        if (r10 == 90003061) goto L21;
        r7 = 2131905424;
        goto L23
    L21:
        r7 = 2131907745;
        goto L23
    L28:
        return;
    L13:
        r3 = null;
        goto L14
    }

    @Override // y79.b
    public final void a(String r7, DriveUploadStatus r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "status");
        if (r7 != null) goto L5;
        return;
    L5:
        Lazy r0 = t.a;
        Map r1 = (Map) t.f().getValue();
        if (r1 == null) goto L29;
        Collection r2 = r1.values();
        if (r2 == null) goto L39;
        List r3 = CollectionsKt.toList(r2);
        if (r3 == null) goto L40;
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((com.larus.drive.biz.api.model.a) r5).b, r7) == false) goto L13;
    L18:
        com.larus.drive.biz.api.model.a r6 = (com.larus.drive.biz.api.model.a) r5;
        if (r6 == null) goto L41;
        com.larus.drive.biz.api.model.a r10 = r6.a();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r10.f = r8;
        r10.i = Long.valueOf(r9);
        r10.h = Long.valueOf(r11);
        Lazy r12 = t.a;
        t.a(r10);
        if (r8 != DriveUploadStatus.FINISH) goto L42;
        FLogger.a.i("DriveUploadManager", "onProgressUpdated finish itemId = " + r10.a);
        String r13 = r10.a;
        String r14 = r10.c;
        Boolean r15 = Boolean.TRUE;
        String r16 = com.larus.drive.biz.impl.utils.e.a;
        p1.d(r13, r14, r15, com.larus.drive.biz.impl.utils.e.c(r10.d), com.larus.drive.biz.impl.utils.e.a(r10), r10.j);
        Iterator r17 = t.d().iterator();
    L24:
        if (r17.hasNext() == false) goto L43;
        WeakReference r18 = (WeakReference) r17.next();
        Function1 r110 = (Function1) r18.get();
        if (r110 == null) goto L27;
        r110.invoke(r10);
        goto L24
    L27:
        Lazy r111 = t.a;
        t.d().remove(r18);
        goto L24
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L17:
        r5 = null;
        goto L18
    L40:
        return;
    L39:
        return;
    }
}
