package uo8;

import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public static a a;
    public static final b b = null;

    public static final class a {
        public final int a;
        public final JSONObject b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            JSONObject r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            long r4 = this.c;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "PictureInnerStreamTraceInfo(position=" + this.a + ", photoViewerReportParams=" + this.b + ", startReadDuration=" + this.c + ')';
        }

        public a() {
            this(0, null, 0);
        }

        public a(int r1, JSONObject r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements f09.a.b {
        public a a;

        public b() {
        }

        public final void onAppBackground() {
            a r0 = l.a;
            if (r0 == null) goto L6;
            this.a = r0;
            l.a(l.a);
            l.a = null;
            return;
        }

        public final void onAppForeground() {
            a r0 = this.a;
            if (r0 == null) goto L6;
            a r1 = l.a;
            l.b(r0.a, r0.b);
            this.a = null;
            return;
        }

        public final void onAllActivityDestroyed() {
            l.c();
        }
    }

    static {
        b = new b();
    }

    public static void c() {
        a(a);
        a = null;
        AppHost.a.a().c(b);
    }

    public static void a(a r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.b == null) goto L8;
        r4.b.put("duration", System.currentTimeMillis() - r4.c);
        FLogger.a.i("PictureInnerStreamTrace", "mobPictureDuration: " + r4.b);
        by7.a r0 = new by7.a("picture_inner_stream_duration");
        r0.a.merge(new TrackParams().merge(r4.b));
        r0.b();
        return;
    }

    public static void b(int r3, JSONObject r4) {
        a r0 = a;
        if (r0 != null) goto L5;
    L10:
        a = new a(r3, r4, System.currentTimeMillis());
        AppHost.a.a().j(b);
        return;
    L5:
        if (r0.a != r3) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        a(r0);
        goto L10
    L7:
        r1 = false;
        goto L8
    }
}
