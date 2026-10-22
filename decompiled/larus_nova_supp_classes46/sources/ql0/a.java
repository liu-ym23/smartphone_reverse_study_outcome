package ql0;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.monitor.lynx.LynxMonitor;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import com.lynx.tasm.LynxView;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jz2.k;
import kotlin.jvm.internal.Intrinsics;
import py2.i;
import py2.j;
import rl0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements u {
    public final SoftReference<LynxView> a;
    public final boolean b;

    public final /* synthetic */ void b(c0 r1, int r2) {
    }

    public a(LynxView r2) {
        new ConcurrentHashMap();
        this.b = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
        this.a = new SoftReference(r2);
    }

    public static j d(String r6, int r7, o0 r8) {
        long r0 = SystemClock.elapsedRealtime();
        j r2 = new j();
        r2.b = r6;
        r2.c = r7;
        List r9 = r8.c;
        if (r9 == null) goto L12;
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        TimeLineEvent r3 = (TimeLineEvent) r10.next();
        if (r3 == null) goto L6;
        if ("label_create_java_call".equals(r3.getLabel()) == false) goto L6;
        long r4 = r3.getElapsedTimestamp();
    L13:
        r2.e = r4;
        if (r4 == 0) goto L16;
        r2.f = r0;
        r2.d = r0 - r4;
    L16:
        return r2;
    L12:
        r4 = 0;
        goto L13
    }

    public final void a(String r3, String r4, o0 r5) {
        LynxView r6 = this.a.get();
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        if (this.b == false) goto L10;
        k r7 = e(r4, 0, r5);
        int r8 = b.a;
        rl0.a.b.getClass();
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "jsbInfo");
        LynxViewMonitor.b.getClass();
        LynxViewMonitor.o(r6, r7);
        return;
    L10:
        j r9 = d(r4, 0, r5);
        int r10 = b.a;
        rl0.a.b.l(r6, r9);
    }

    public final k e(String r7, int r8, o0 r9) {
        long r0 = SystemClock.elapsedRealtime();
        k r2 = new k();
        r2.b = r7;
        r2.c = r8;
        List r10 = r9.c;
        if (r10 == null) goto L12;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        TimeLineEvent r3 = (TimeLineEvent) r11.next();
        if (r3 == null) goto L6;
        if ("label_create_java_call".equals(r3.getLabel()) == false) goto L6;
        long r4 = r3.getElapsedTimestamp();
    L13:
        r2.e = r4;
        if (r4 == 0) goto L16;
        r2.f = r0;
        r2.d = r0 - r4;
    L16:
        return r2;
    L12:
        r4 = 0;
        goto L13
    }

    public final void c(String r7, String r8, int r9, String r10, o0 r11) {
        LynxView r12 = this.a.get();
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L45;
        int r2 = 3;
        if (this.b == false) goto L21;
        if (r9 == 1) goto L13;
        if (r9 == 2) goto L12;
        int r0 = 3;
    L14:
        k r13 = e(r8, r0, r11);
        jz2.j r1 = new jz2.j();
        r1.d = r8;
        if (r9 == 1) goto L19;
        if (r9 != 2) goto L20;
        r2 = 2;
    L20:
        r1.b = r2;
        r1.c = r10;
        int r14 = b.a;
        rl0.a.b.getClass();
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, "jsbInfo");
        LynxViewMonitor r15 = LynxViewMonitor.b;
        r15.getClass();
        LynxViewMonitor.o(r12, r13);
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r1, "jsbError");
        r15.getClass();
        LynxViewMonitor.m(r12, r1);
        return;
    L19:
        r2 = 1;
        goto L20
    L12:
        r0 = 2;
        goto L14
    L13:
        r0 = 1;
        goto L14
    L21:
        if (r9 == 1) goto L25;
        if (r9 == 2) goto L24;
        int r3 = 3;
    L26:
        j r16 = d(r8, r3, r11);
        i r4 = new i();
        r4.d = r8;
        if (r9 == 1) goto L31;
        if (r9 != 2) goto L32;
        r2 = 2;
    L32:
        r4.b = r2;
        r4.c = r10;
        int r17 = b.a;
        rl0.a.b.l(r12, r16);
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r4, "jsbError");
        LynxMonitor r18 = LynxMonitor.j;
        uy2.b r19 = r18.a.a(r12);
        if (r19 != null) goto L35;
        return;
    L35:
        if (r19.e == false) goto L46;
        LynxMonitor.e().getClass();
        vy2.b r20 = r18.b.c(r12);
        if (r20 == null) goto L44;
        Map r110 = az2.a.a;
        LynxMonitor.f(r20, az2.a.d(r12), r4, r19, null);
        return;
    L44:
        return;
    L46:
        return;
    L31:
        r2 = 1;
        goto L32
    L24:
        r3 = 2;
        goto L26
    L25:
        r3 = 1;
        goto L26
    }
}
