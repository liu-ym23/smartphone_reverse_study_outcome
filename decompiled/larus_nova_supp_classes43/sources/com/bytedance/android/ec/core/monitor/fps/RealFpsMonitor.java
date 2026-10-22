package com.bytedance.android.ec.core.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.g;
import com.larus.apm.impl.protector.RunnableProtector;
import et3.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RealFpsMonitor implements jh.a {
    public final c a;
    public boolean b;
    public final q c;

    public static final class a implements c.d {
        public final /* synthetic */ RealFpsMonitor a;

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.monitor.fps.RealFpsMonitor$a$a, reason: collision with other inner class name */
        public static final class RunnableC0141a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ double b;

            public RunnableC0141a(a r1, double r10) {
                this.a = r1;
                this.b = r10;
            }

            public final void a() {
                System.out.println("Django: " + this.a.a.c.a + " fps: " + this.b);
                g r0 = g.a;
                String r1 = this.a.a.c.a;
                JSONObject r10 = new JSONObject();
                r10.put("FPS", this.b);
                r10.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
                r10.put("EVENT_FUNCTION_FEATURE", "TEMAI_MONITOR");
                JSONObject r11 = this.a.a.c.b;
                if (r11 == null) goto L5;
                String r12 = String.valueOf(r11);
            L6:
                z1.c(r10, r12);
                Unit r13 = Unit.INSTANCE;
                r0.logV3(r1, r10);
                return;
            L5:
                r12 = "";
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(RealFpsMonitor r1) {
            this.a = r1;
        }

        public final void fpsCallBack(double r10) {
            oh.a.d(this.a.c.a, new RunnableC0141a(this, r10));
        }
    }

    public final void a() {
        this.a.d();
    }

    @Override // jh.a
    public final void stop() {
        this.a.f();
    }

    public RealFpsMonitor(q r10) {
        Intrinsics.checkNotNullParameter(r10, "monitorSceneWrapper");
        this.c = r10;
        c r0 = new c(r10.a);
        r0.c(new a(this));
        Unit r11 = Unit.INSTANCE;
        this.a = r0;
    }

    public final void b(RecyclerView r10) {
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        r10.addOnScrollListener(new RealFpsMonitor$startRecyclerView$1(this));
    }
}
