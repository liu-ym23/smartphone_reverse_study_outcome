package f3;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.ai.lynx.k;
import com.bytedance.ai.settings.internal.AISDKSettingsRequestServiceImpl;
import com.bytedance.ies.bullet.core.j;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.map.api.lifecycle.MapLifecycleObserver;
import kotlin.jvm.internal.Intrinsics;
import obric.flow.app.FlowApplication;
import r2.b;
import s6.c;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16876a;

    public /* synthetic */ a(int r5) {
        this.f16876a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f16876a) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L34;
            case 4: goto L8;
            default: goto L4;
        };
    L4:
        j r10 = ki.a.d;
        c r5 = (c) r10.f5321c;
        if (r5 != null) goto L48;
        r10.f5321c = new c(r5);
        return;
    L48:
        return;
    L8:
        Application r11 = b.d;
        if (r11 == null) goto L50;
        Resources r12 = r11.getResources();
        DisplayMetrics r13 = r12.getDisplayMetrics();
        Configuration r14 = r12.getConfiguration();
        r2.a r15 = new r2.a(r14.fontScale, r13.widthPixels, r13.heightPixels, r14.densityDpi, r14.orientation);
        if (Intrinsics.areEqual(r15, b.e) == true) goto L51;
        b.e = r15;
        l2.c r16 = l2.c.f19515a;
        monitor-enter(r16);
        l2.c.f19516b = -1;     // Catch: Throwable -> L30
        l2.c.f19517c = -1;     // Catch: Throwable -> L30
        monitor-exit(r16);     // Catch: Throwable -> L30
        k r17 = k.f2188a;
        monitor-enter(r17);
        k.d.evictAll();     // Catch: Throwable -> L27
        k.f2190c.clear();     // Catch: Throwable -> L27
        k.f2189b.clear();     // Catch: Throwable -> L27
        monitor-exit(r17);
        String r18 = "display state changed, caches invalidated, reason=" + b.f + " snapshot=" + r15;
        Intrinsics.checkNotNullParameter("DisplayStateMonitor", "tag");
        d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L49;
        r19.i("DisplayStateMonitor", r18);
        return;
    L49:
        return;
    L27:
        th = move-exception;
        throw th;
    L30:
        th = move-exception;
        throw th;
    L51:
        return;
    L50:
        return;
    L38:
        int r20 = FlowApplication.e;
        InitScheduler.initTasks();
        return;
    L40:
        MapLifecycleObserver.a();
        return;
    L42:
        AISDKSettingsRequestServiceImpl.d();
        return;
    L34:
        if (rh.a.f21738a != null) goto L36;
        Intrinsics.checkNotNullParameter("Initialize worker polyfill failed!", "message");
        com.bytedance.pia.core.utils.j.x("Initialize worker polyfill failed!", null);
        return;
    L36:
        Intrinsics.checkNotNullParameter("Initialize worker polyfill success.", "message");
        com.bytedance.pia.core.utils.j.y("Initialize worker polyfill success.", null);
    }
}
