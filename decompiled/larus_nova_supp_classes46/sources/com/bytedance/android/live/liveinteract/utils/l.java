package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface l {

    public static final class a {
        public static /* synthetic */ void b(l r6, LinkMonitorData r7, long r8, Throwable r10) {
            r6.a(r7, r8, r10, null);
        }

        public static /* synthetic */ void c(l r6, LinkMonitorData r7, long r8, String r10) {
            r6.c(r7, r8, r10, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(l r13, LinkMonitorData r14, String r15, String r16, int r17, Integer r18, String r19, String r20, Integer r21, Map r22, int r23) {
            if ((r23 & 2) == 0) goto L5;
            String r5 = null;
        L7:
            if ((r23 & 4) == 0) goto L9;
            String r6 = null;
        L11:
            if ((r23 & 8) == 0) goto L13;
            int r7 = 0;
        L15:
            if ((r23 & 16) == 0) goto L17;
            Integer r8 = null;
        L19:
            if ((r23 & 32) == 0) goto L21;
            String r9 = null;
        L23:
            if ((r23 & 64) == 0) goto L25;
            String r10 = null;
        L27:
            if ((r23 & 128) == 0) goto L29;
            Integer r11 = null;
        L31:
            if ((r23 & 256) == 0) goto L33;
            Map r12 = null;
        L34:
            r13.b(r14, r5, r6, r7, r8, r9, r10, r11, r12);
            return;
        L33:
            r12 = r22;
            goto L34
        L29:
            r11 = r21;
            goto L31
        L25:
            r10 = r20;
            goto L27
        L21:
            r9 = r19;
            goto L23
        L17:
            r8 = r18;
            goto L19
        L13:
            r7 = r17;
            goto L15
        L9:
            r6 = r16;
            goto L11
        L5:
            r5 = r15;
            goto L7
        }
    }

    void a(LinkMonitorData r1, long r2, Throwable r4, Map<String, ? extends Object> r5);

    void b(LinkMonitorData r1, String r2, String r3, int r4, Integer r5, String r6, String r7, Integer r8, Map<String, ? extends Object> r9);

    void c(LinkMonitorData r1, long r2, String r4, Map<String, ? extends Object> r5);
}
