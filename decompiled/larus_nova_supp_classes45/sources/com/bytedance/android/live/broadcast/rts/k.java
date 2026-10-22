package com.bytedance.android.live.broadcast.rts;

import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            int r0 = com.bytedance.salamander.bdfoundation.a.a;
            String r3 = "[ERROR]: " + r2;
            Intrinsics.checkNotNullParameter("rts_anchor_status_rts", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            ALog.e("rts_anchor_status_rts", r3);
        }

        public static void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            int r0 = com.bytedance.salamander.bdfoundation.a.a;
            String r3 = "[I]: " + r2;
            Intrinsics.checkNotNullParameter("rts_anchor_status_rts", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            ALog.i("rts_anchor_status_rts", r3);
        }

        public static void c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            int r0 = com.bytedance.salamander.bdfoundation.a.a;
            String r3 = "[WARN]: " + r2;
            Intrinsics.checkNotNullParameter("rts_anchor_status_rts", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            ALog.w("rts_anchor_status_rts", r3);
        }
    }

    static {
    }
}
