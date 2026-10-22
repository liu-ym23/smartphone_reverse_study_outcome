package com.larus.bmhome.chat.trace;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z implements com.larus.bmhome.chat.api.s {
    public static final z a = null;
    public static final CopyOnWriteArraySet<a> b = null;

    public static final class a {
        public final String a;
        public final long b;
        public String c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            String r3 = this.c;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r2 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public final String toString() {
            return "SendTraceParam(traceId=" + this.a + ", startTime=" + this.b + ", messageId=" + this.c + ')';
        }

        public a(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "traceId");
            this.a = r2;
            this.b = r3;
            this.c = null;
        }
    }

    public z() {
    }

    static {
        a = new z();
        b = new CopyOnWriteArraySet();
    }

    public final void d(String r6) {
        Intrinsics.checkNotNullParameter(r6, "traceId");
        a r0 = new a(r6, SystemClock.elapsedRealtime());
        CopyOnWriteArraySet<a> r1 = b;
        if (r1.contains(r0) == false) goto L5;
        return;
    L5:
        r1.add(r0);
        FLogger.a.d("ChatSendTrace", "send start: " + r0.b + ", traceId: " + r6);
    }
}
