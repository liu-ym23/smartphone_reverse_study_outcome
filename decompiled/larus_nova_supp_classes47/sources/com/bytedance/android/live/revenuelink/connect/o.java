package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.livesdk.link.model.a7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface o {

    public static final class a {
        public static /* synthetic */ void a(o r12, long r13, String r14, String r15, long r16, a7 r18, Throwable r19, int r20) {
            if ((r20 & 16) == 0) goto L5;
            a7 r9 = null;
        L7:
            if ((r20 & 32) == 0) goto L9;
            Throwable r10 = null;
        L10:
            r12.a(r13, r14, r15, r16, r9, r10);
            return;
        L9:
            r10 = r19;
            goto L10
        L5:
            r9 = r18;
            goto L7
        }
    }

    void a(long r1, String r3, String r4, long r5, a7 r7, Throwable r8);
}
