package lw1;

import android.view.Choreographer;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.feed.z0;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final boolean g = false;
    public long a;
    public long b;
    public long c;
    public boolean d;
    public int e;
    public final ChoreographerFrameCallbackC0400a f;

    /* JADX INFO: renamed from: lw1.a$a, reason: collision with other inner class name */
    public class ChoreographerFrameCallbackC0400a implements Choreographer.FrameCallback {
        public final /* synthetic */ a a;

        public ChoreographerFrameCallbackC0400a(a r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r7) {
            a r0 = this.a;
            if (r0.d == true) goto L6;
            return;
        L6:
            if (r0.b > 0) goto L8;
            r0.b = r7;
        L9:
            r0.a = r7;
            Choreographer.getInstance().postFrameCallback(this);     // Catch: Throwable -> L14
            if (a.g == false) goto L18;
            this.a.a(true);     // Catch: Throwable -> L14
            return;
        L18:
            return;
        L14:
            this.a.d = false;
            return;
        L8:
            r0.c++;
            goto L9
        }
    }

    public static class b {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    static {
        g = Logger.debug();
    }

    public a() {
        this.e = 0;
        this.f = new ChoreographerFrameCallbackC0400a(this);
    }

    public final void a(boolean r9) {
        if (r9 == false) goto L5;
        int r1 = 1;
    L6:
        long r2 = this.c;
        if (r2 < r1) goto L17;
        long r4 = this.a;
        long r6 = this.b;
        if (r4 <= r6) goto L18;
        float r3 = (r2 * 1.0E9f) / (r4 - r6);
        if (r9 == true) goto L14;
        String r5 = z0.d;
        JSONObject r7 = new JSONObject();
        BaseMonitor.add(r7, "feed_fps", r3);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_feed_list_fps_all", 0, r7);
        this.e++;
    L14:
        if (g == false) goto L19;
        Logger.d("FPSMonitor", "report: realTime = " + r9 + ", frameCount = " + this.c + ", fps = " + r3);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r1 = 30;
        goto L6
    }

    public final void b(int r6) {
        if (r6 == 0) goto L29;
        boolean r7 = this.d;
        if (r7 == false) goto L11;
    L16:
        if (r7 == true) goto L35;
        Choreographer.getInstance().removeFrameCallback(this.f);     // Catch: Throwable -> L25
        if (this.d == false) goto L31;
        a(false);     // Catch: Throwable -> L25
    L31:
        this.b = 0;     // Catch: Throwable -> L23
        this.a = 0;     // Catch: Throwable -> L23
        this.c = 0;     // Catch: Throwable -> L23
        this.d = true;     // Catch: Throwable -> L23
        Choreographer.getInstance().postFrameCallback(this.f);     // Catch: Throwable -> L23
        return;
    L23:
        this.d = false;
        return;
    L35:
        return;
    L11:
        if (this.e <= 10) goto L16;
        if (g == false) goto L33;
        Logger.d("FPSMonitor", "stop because over max count, cur count = " + this.e);
        return;
    L33:
        return;
    L29:
        Choreographer.getInstance().removeFrameCallback(this.f);     // Catch: Throwable -> L26
        if (this.d == false) goto L7;
        a(false);     // Catch: Throwable -> L26
    L7:
        this.d = false;
        this.b = 0;
        this.a = 0;
        this.c = 0;
    }
}
