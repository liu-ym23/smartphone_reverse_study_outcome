package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;

    public static final class a {
    }

    static {
    }

    public e(MinutesUCCImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentContext");
        this.a = r2;
    }

    public static long a(Object r2) {
        if ((r2 instanceof Number) == false) goto L6;
        return ((Number) r2).longValue();
    L6:
        if ((r2 instanceof String) == false) goto L10;
        Long r3 = StringsKt.toLongOrNull((String) r2);
        if (r3 == null) goto L10;
        return r3.longValue();
    L10:
        return 0;
    }

    public static o b(o r22) {
        List<eub.d> r1 = r22.a.c;
        if (r1.isEmpty() == false) goto L6;
        lvb.a.b("MmMinutesFileUploadLocalStorage", "drop invalid upload task: taskId=" + r22.a.a + ", fileCount=0");
        return null;
    L6:
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
        int r7 = 0;
    L8:
        if (r3.hasNext() == false) goto L78;
        Object r8 = r3.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        if ((r8 instanceof eub.d) == false) goto L16;
        eub.d r10 = (eub.d) r8;
    L50:
        if (r10 == null) goto L62;
        boolean r11 = true;
        if (r10.a.length() != 0) goto L55;
        boolean r12 = true;
    L56:
        if (r12 == true) goto L58;
    L63:
        Integer r13 = Integer.valueOf(r10.f);
        if (r13.intValue() > 0) goto L67;
        r11 = false;
    L67:
        if (r11 == true) goto L70;
        r13 = null;
    L70:
        if (r13 == null) goto L72;
        int r14 = r13.intValue();
    L73:
        eub.d r15 = eub.d.a(r10, null, r14, 31);
    L74:
        if (r15 == null) goto L75;
        r2.add(r15);
        r7 = r9;
        goto L8
    L75:
        lvb.a.b("MmMinutesFileUploadLocalStorage", "drop invalid upload task: taskId=" + r22.a.a + ", invalidFileIndex=" + r7);
        return null;
    L72:
        r14 = r9;
        goto L73
    L58:
        if (r10.b.length() != 0) goto L60;
        boolean r16 = true;
    L61:
        if (r16 == false) goto L63;
    L60:
        r16 = false;
        goto L61
    L55:
        r12 = false;
    L62:
        r15 = null;
        goto L74
    L16:
        if ((r8 instanceof Map) == false) goto L49;
        Map r17 = (Map) r8;
        Object r18 = r17.get("localPath");
        if ((r18 instanceof String) == false) goto L20;
        String r19 = (String) r18;
    L22:
        if (r19 != null) goto L24;
        String r110 = "";
    L25:
        Object r111 = r17.get("uriStr");
        if ((r111 instanceof String) == false) goto L28;
        String r112 = (String) r111;
    L29:
        if (r112 != null) goto L31;
        String r113 = "";
    L32:
        Object r114 = r17.get("fileName");
        if ((r114 instanceof String) == false) goto L35;
        String r115 = (String) r114;
    L36:
        if (r115 != null) goto L38;
        String r116 = "";
    L39:
        long r117 = a(r17.get("fileSizeBytes"));
        long r118 = a(r17.get("fileDurationMs"));
        Object r20 = r17.get("fileIndexInMinutes");
        if ((r20 instanceof Number) == false) goto L43;
        int r21 = ((Number) r20).intValue();
    L48:
        r10 = new eub.d(r110, r113, r116, r117, r118, r21);
        goto L50
    L43:
        if ((r20 instanceof String) == false) goto L47;
        Integer r23 = StringsKt.toIntOrNull((String) r20);
        if (r23 == null) goto L47;
        r21 = r23.intValue();
    L47:
        r21 = r9;
        goto L48
    L38:
        r116 = r115;
        goto L39
    L35:
        r115 = null;
        goto L36
    L31:
        r113 = r112;
        goto L32
    L28:
        r112 = null;
        goto L29
    L24:
        r110 = r19;
        goto L25
    L20:
        r19 = null;
        goto L22
    L49:
        r10 = null;
        goto L50
    L78:
        eub.f r24 = eub.f.a(r22.a, null, r2, null, 507);
        eub.g r25 = r22.b;
        String r26 = r22.c;
        List<String> r119 = r22.d;
        Map<String, Boolean> r120 = r22.e;
        Map<String, Long> r121 = r22.f;
        Map<String, Long> r122 = r22.g;
        Map<String, String> r123 = r22.h;
        long r4 = r22.i;
        long r5 = r22.j;
        int r6 = r22.k;
        int r0 = r22.l;
        Intrinsics.checkNotNullParameter(r24, "param");
        Intrinsics.checkNotNullParameter(r25, "status");
        Intrinsics.checkNotNullParameter(r26, "uploadToken");
        Intrinsics.checkNotNullParameter(r119, "uploadTaskIds");
        Intrinsics.checkNotNullParameter(r120, "uploadTaskDoneMap");
        Intrinsics.checkNotNullParameter(r121, "uploadTaskTransferredBytes");
        Intrinsics.checkNotNullParameter(r122, "uploadTaskTotalBytes");
        Intrinsics.checkNotNullParameter(r123, "uploadFileTokenMap");
        return new o(r24, r25, r26, r119, r120, r121, r122, r123, r4, r5, r6, r0);
    }
}
