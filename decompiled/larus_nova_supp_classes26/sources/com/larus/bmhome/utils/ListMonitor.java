package com.larus.bmhome.utils;

import android.os.SystemClock;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.ApmAgent;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.stream.b;
import com.larus.platform.api.ISdkPerfDegradeService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import et3.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ListMonitor {
    public final String a;
    public final String b;
    public final Lazy c;
    public final c d;
    public final Lazy e;
    public final p0 f;
    public final b g;
    public int h;
    public volatile boolean i;
    public final Lazy j;
    public final a k;
    public final ListMonitor$onScrollListener$1 l;

    public static final class a implements nf9.c {
        public final /* synthetic */ ListMonitor a;

        public a(ListMonitor r1) {
            this.a = r1;
        }

        public final void A(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            ListMonitor r3 = this.a;
            r3.h = 0;
            r3.d.f();
        }

        public final void B(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a.h = 2;
        }

        public final void C(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            ListMonitor r3 = this.a;
            r3.h = 1;
            r3.d.d();
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.bmhome.utils.ListMonitor$onScrollListener$1] */
    public ListMonitor(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.a = r3;
        this.b = r4;
        this.c = LazyKt.lazy(new j2());
        c r5 = new c(r3, false, null);
        r5.b(new k2(this));
        this.d = r5;
        this.e = LazyKt.lazy(new l2(this));
        this.f = new p0(r3);
        int r6 = com.larus.im.d.a;
        this.g = b.a;
        this.j = LazyKt.lazy(new m2());
        this.k = new a(this);
        this.l = new ListMonitor$onScrollListener$1(this);
    }

    public final void a(RecyclerView r7, ISdkPerfDegradeService.ScrollState r8) {
        if (r8 == null) goto L25;
        ISdkPerfDegradeService r0 = (ISdkPerfDegradeService) this.e.getValue();
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L27;
        ISdkPerfDegradeService r3 = (ISdkPerfDegradeService) this.e.getValue();
        if (r3 == null) goto L26;
        String r4 = this.a;
        String r5 = this.b;
        if (r5 != null) goto L16;
    L17:
        r1 = true;
    L18:
        if (r1 == false) goto L21;
        r5 = null;
    L21:
        if (r5 != null) goto L23;
        r5 = String.valueOf(r7.hashCode());
    L23:
        r3.a(r4, r5, r8);
        return;
    L16:
        if (StringsKt.isBlank(r5) == false) goto L18;
    L26:
        return;
    L27:
        return;
    L6:
        if (r0.b(this.a) != true) goto L8;
        r2 = true;
        goto L9
    }

    public final void b(String r10, Map<String, Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "type");
        p0 r1 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "type");
        long r2 = SystemClock.uptimeMillis() - r1.c;
        boolean r4 = Intrinsics.areEqual(ThreadMethodProxy.currentThread(), (Thread) r1.g.getValue());
        ArrayMap<String, Integer> r5 = r1.e;
        Integer r6 = (Integer) r5.get(r10);
        if (r6 == null) goto L5;
        int r7 = r6.intValue();
    L6:
        r5.put(r10, Integer.valueOf(r7 + 1));
        String r8 = r1.j;
        JSONObject r9 = new JSONObject();
        r9.put("scene", r1.a);
        r9.put("type", r10);
        r9.put("duration", r2);
        r9.put("isMainThread", r4);
        if (r11 == null) goto L12;
        Iterator<Map.Entry<String, Object>> r12 = r11.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, Object> r0 = r12.next();
        r9.put(r0.getKey(), r0.getValue());
    L12:
        ApmAgent.monitorEvent(r8, r9, null, null);
        if (com.larus.platform.exp.h.a == false) goto L15;
        long r13 = ((Number) r1.f.getValue()).longValue();
    L17:
        if (r2 < r13) goto L21;
        FLogger.a.i("HolderTracker", "onBindVHEnd scene=" + r1.a + " type=" + r10 + " duration=" + r2 + " isMainThread=" + r4);
        return;
    L21:
        return;
    L15:
        r13 = com.larus.platform.service.z2.a.openTraceExecuteThreshold();
        goto L17
    L5:
        r7 = 0;
        goto L6
    }
}
