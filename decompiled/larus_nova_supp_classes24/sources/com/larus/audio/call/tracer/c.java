package com.larus.audio.call.tracer;

import com.larus.audio.call.RealtimeCallParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c {

    public static final class a {
        public static void b(String r1, String r2, String r3, String r4, String r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r1, "endType");
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "ownerInputLanguage");
            Intrinsics.checkNotNullParameter(r4, "ownerOutputLanguage");
            Intrinsics.checkNotNullParameter(r5, "guestInputLanguage");
            Intrinsics.checkNotNullParameter(r6, "guestOutputLanguage");
            Intrinsics.checkNotNullParameter(r7, "translateMode");
        }

        public static void c(String r1, String r2, String r3, String r4, String r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r1, "startType");
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "ownerInputLanguage");
            Intrinsics.checkNotNullParameter(r4, "ownerOutputLanguage");
            Intrinsics.checkNotNullParameter(r5, "guestInputLanguage");
            Intrinsics.checkNotNullParameter(r6, "guestOutputLanguage");
            Intrinsics.checkNotNullParameter(r7, "translateMode");
        }

        public static /* synthetic */ void a(IRealtimeCallTracer r12, String r13, Integer r14, String r15, Long r16, Long r17, Long r19, Integer r110, int r20) {
            if ((r20 & 2) == 0) goto L5;
            Integer r5 = null;
        L7:
            if ((r20 & 4) == 0) goto L9;
            String r6 = null;
        L11:
            if ((r20 & 8) == 0) goto L13;
            Long r7 = null;
        L15:
            if ((r20 & 16) == 0) goto L17;
            Long r8 = null;
        L19:
            if ((r20 & 64) == 0) goto L21;
            Long r10 = null;
        L23:
            if ((r20 & 128) == 0) goto L25;
            Integer r11 = null;
        L26:
            r12.V(r13, r5, r6, r7, r8, null, r10, r11);
            return;
        L25:
            r11 = r110;
            goto L26
        L21:
            r10 = r19;
            goto L23
        L17:
            r8 = r17;
            goto L19
        L13:
            r7 = r16;
            goto L15
        L9:
            r6 = r15;
            goto L11
        L5:
            r5 = r14;
            goto L7
        }
    }

    void N(RealtimeCallParam r1, String r2, String r3);

    void V(String r1, Integer r2, String r3, Long r4, Long r5, Long r6, Long r7, Integer r8);

    void X(String r1, RealtimeCallParam r2);

    void Y(long r1, long r3, long r5);

    void a(String r1, int r2);

    void b(String r1, String r2, String r3, String r4, String r5, String r6, String r7);

    void onSessionStarted();

    void q0(String r1, boolean r2, String r3);

    void u(String r1, String r2, long r3, String r5, String r6, String r7, String r8, String r9, long r10);
}
