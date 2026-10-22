package al0;

import am2.x;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.base.y;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import el0.j;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final b a;
    public int b;
    public boolean c;
    public long d;
    public final i e;

    /* JADX INFO: renamed from: al0.a$a, reason: collision with other inner class name */
    public static final class C0003a {
    }

    public static final class b extends y {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r8) {
            if (r8 == null) goto L15;
            a r9 = this.a;
            if (r9.c == true) goto L16;
            int r0 = r9.e.b();
            int r1 = r9.b;
            if (r1 != 0) goto L10;
            if (r0 <= 0) goto L10;
            ALogger.i("LinkInfoReportHelper", "reportSeeGuestShow: livesdk_audience_guest_connection_show");
            r9.d = SystemClock.elapsedRealtime();
            int r2 = j.b;
            LinkedHashMap r3 = new LinkedHashMap();
            j.m(r3);
            j.j(r3, 1);
            j.n(r3, 1);
            u.l().sendLog("livesdk_audience_guest_connection_show", r3, new Object[]{Room.class, x.class});
        L13:
            r9.b = r0;
            return;
        L10:
            if (r1 <= 0) goto L13;
            if (r0 != 0) goto L13;
            r9.a();
            goto L13
        L16:
            return;
        }
    }

    static {
    }

    public final void a() {
        ALogger.i("LinkInfoReportHelper", "reportSeeGuestConnectionDuration: showStartTime=" + this.d);
        if (this.d <= 0) goto L6;
        long r2 = SystemClock.elapsedRealtime() - this.d;
        ALogger.i("LinkInfoReportHelper", "reportSeeGuestConnectionDuration: livesdk_audience_guest_connection_duration, duration=" + r2 + " ms");
        int r0 = j.b;
        LinkedHashMap r1 = new LinkedHashMap();
        j.m(r1);
        j.j(r1, 1);
        r1.put("duration", String.valueOf(r2));
        j.n(r1, 1);
        u.l().sendLog("livesdk_audience_guest_connection_duration", r1, new Object[]{Room.class, x.class});
        this.d = 0;
        return;
    }

    public a(i r2) {
        Intrinsics.checkNotNullParameter(r2, "userCenter");
        this.e = r2;
        b r0 = new b(this);
        this.a = r0;
        r2.c(r0);
    }
}
