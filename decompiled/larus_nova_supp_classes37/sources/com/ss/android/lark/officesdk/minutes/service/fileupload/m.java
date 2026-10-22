package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.vfs.VFSFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final eub.f a;
        public final String b;

        public a() {
            this(null, null, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            eub.f r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "NormalizeResult(param=" + this.a + ", errorMessage=" + this.b + ')';
        }

        public a(eub.f r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            this.a = r3;
            this.b = r4;
        }
    }

    static {
    }

    public static void a(eub.f r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        MmRecordingSource r1 = r10.b;
        if (r1 != MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L5;
    L34:
        lvb.a.e("MmMinutesFileUploadSourceFileHelper", "cleanupUploadSourceFiles: skip hardware taskId=" + r10.a);
        return;
    L5:
        if (r1 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L34;
        if (r1 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L34;
        List<eub.d> r2 = r10.c;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r3.add(((eub.d) r4.next()).a);
        goto L11
    L13:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r3.iterator();
    L15:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        if (((String) r7).length() <= 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L15;
        r5.add(r7);
        goto L15
    L19:
        r8 = false;
        goto L20
    L22:
        List r9 = CollectionsKt.distinct(r5);
        long r11 = System.currentTimeMillis();
        Iterator r12 = r9.iterator();
    L24:
        if (r12.hasNext() == false) goto L32;
        String r13 = (String) r12.next();
        VFSFile r14 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r13);     // Catch: Throwable -> L30
        if (r14.exists() == false) goto L24;
        lvb.a.e("MmMinutesFileUploadSourceFileHelper", "cleanupUploadSourceFiles: taskId=" + r10.a + ", path=" + r13 + ", deleted=" + r14.delete());     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        lvb.a.b("MmMinutesFileUploadSourceFileHelper", "cleanupUploadSourceFiles failed: taskId=" + r10.a + ", path=" + r13 + ", err=" + th.getClass().getSimpleName() + ", msg=" + th.getMessage());
        goto L24
    L32:
        lvb.a.e("MmMinutesFileUploadSourceFileHelper", "cleanupUploadSourceFiles: taskId=" + r10.a + ", fileCount=" + r9.size() + ", cost=" + (System.currentTimeMillis() - r11) + "ms");
    }
}
