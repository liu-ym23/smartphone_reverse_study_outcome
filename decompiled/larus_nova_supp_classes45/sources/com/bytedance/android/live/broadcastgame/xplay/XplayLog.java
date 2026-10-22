package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayLog {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayLog$Severity;", "", "Debug", "Info", "Error", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Severity extends Enum<Severity> {
        public static final Severity Debug = null;
        public static final Severity Error = null;
        public static final Severity Info = null;
        public static final /* synthetic */ Severity[] a = null;

        static {
            Severity r1 = new Severity("Debug", 0);
            Debug = r1;
            Severity r2 = new Severity("Info", 1);
            Info = r2;
            Severity r3 = new Severity("Error", 2);
            Error = r3;
            a = new Severity[]{r1, r2, r3};
        }

        public static Severity valueOf(String r1) {
            return (Severity) r27.a.a(Severity.class, r1);
        }

        public static Severity[] values() {
            return (Severity[]) a.clone();
        }

        public Severity(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }

    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        d(Severity.Debug, r1, r2);
    }

    public static void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        d(Severity.Error, r1, r2);
    }

    public static void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        d(Severity.Info, r1, r2);
    }

    public static void d(Severity r3, String r4, String r5) {
        String r6 = "[" + ThreadMethodProxy.currentThread().getName() + ':' + ThreadMethodProxy.currentThread().getId() + "] " + r5;
        int r7 = f0.a[r3.ordinal()];
        if (r7 != 1) goto L5;
        ALogger.d(r4, r6);
        return;
    L5:
        if (r7 != 2) goto L7;
        ALogger.i(r4, r6);
        return;
    L7:
        if (r7 != 3) goto L10;
        ALogger.e(r4, r6);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
