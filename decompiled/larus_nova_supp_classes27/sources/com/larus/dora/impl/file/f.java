package com.larus.dora.impl.file;

import com.larus.dora.api.model.FlowDoraConnectReason;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static volatile com.larus.dora.impl.file.a a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraFileStreamingSinkReason.values().length];
            r0[DoraFileStreamingSinkReason.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[DoraFileStreamingSinkReason.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[DoraFileStreamingSinkReason.INCOMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[DoraFileStreamingSinkReason.PAUSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[DoraFileStreamingSinkReason.FIRST_FRAME_TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[DoraFileStreamingSinkReason.DONE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[DoraFileStreamingSinkReason.NO_ENOUGH_SPACE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[DoraFileStreamingSinkReason.MD5_CHECK_FAILED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
        a = com.larus.dora.impl.file.a.a;
    }

    public static void b(String r3, Map r4) {
        a.a(r3, r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        g49.d.c("DoraMetrics", "report failed for event=" + r3 + ", params=" + r4, th);
    }

    public static void a(DoraFileFetchTask r5, DoraFileStreamingSinkReason r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "task");
        Intrinsics.checkNotNullParameter(r6, "sinkReason");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("transport_type", r5.getTransportType());
        r0.put("fetch_from", r5.getFetchFrom());
        r0.put("file_type", r5.getFileType());
        r0.put("file_name", r5.getFileName());
        Long r8 = r5.getFileTotalSize();
        if (r8 == null) goto L5;
        long r1 = r8.longValue();
    L6:
        r0.put("file_size", Long.valueOf(r1 / ((long) 1024)));
        r0.put("duration", Long.valueOf(r7));
        if (r6 != DoraFileStreamingSinkReason.DONE) goto L9;
        int r9 = 1;
    L10:
        r0.put("result", Integer.valueOf(r9));
        switch(a.a[r6.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L13;
        };
    L14:
        String r10 = "md5CheckFailed";
    L21:
        r0.put("reason", r10);
        b("d_file_fetch", r0);
        return;
    L15:
        r10 = "notEnoughSpace";
        goto L21
    L16:
        r10 = FlowDoraConnectReason.SUCCESS;
        goto L21
    L17:
        r10 = "fetchInterrupted";
        goto L21
    L18:
        r10 = "fetchOverRetries";
        goto L21
    L19:
        r10 = "file_write_failed";
        goto L21
    L20:
        r10 = "start";
        goto L21
    L13:
        throw new NoWhenBranchMatchedException();
    L9:
        r9 = 2;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }
}
