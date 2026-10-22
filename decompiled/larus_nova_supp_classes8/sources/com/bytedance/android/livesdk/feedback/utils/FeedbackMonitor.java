package com.bytedance.android.livesdk.feedback.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedbackMonitor {
    public static final /* synthetic */ int a = 0;

    public static final class Monitor {
        public String a;
        public final Lazy b;

        public final void d() {
            String r0 = this.a;
            if (r0 != null) goto L5;
        L14:
            String r1 = ((StringBuilder) this.b.getValue()).toString();
        L15:
            ALogger.i("LightFeedbackMonitor", r1);
            return;
        L5:
            if (r0.length() <= 0) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == true) goto L11;
            r0 = null;
        L11:
            if (r0 == null) goto L14;
            r1 = "the page is " + r0 + ".\n" + ((StringBuilder) this.b.getValue());
            if (r1 != null) goto L15;
        L7:
            r2 = false;
            goto L8
        }

        public Monitor() {
            this.a = "";
            this.b = LazyKt.lazy(FeedbackMonitor$Monitor$strBuilder$2.INSTANCE);
        }

        public final void b(Pair... r5) {
            Intrinsics.checkNotNullParameter(r5, "pairs");
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            Pair r2 = r5[r1];
            if (r2 == null) goto L9;
            Object r3 = r2.getSecond();
            if (r3 == null) goto L9;
            a((String) r2.getFirst(), r3);
        L9:
            r1 = r1 + 1;
            goto L3
        }

        public final void c(String r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            ((StringBuilder) this.b.getValue()).append(r3 + '\n');
        }

        public final void a(String r4, Object r5) {
            Intrinsics.checkNotNullParameter(r4, "key");
            Intrinsics.checkNotNullParameter(r5, "value");
            ((StringBuilder) this.b.getValue()).append("the " + r4 + " is " + r5 + ".\n");
        }
    }

    static {
    }
}
