package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.g;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.api.settings.config.f;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public boolean a;
    public final boolean b;
    public final h c;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.b d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.a$a, reason: collision with other inner class name */
    public static final class C0204a {
    }

    public static final class b {
        public b(g r1, a r2) {
        }
    }

    static {
    }

    public final void a() {
        if (this.b == true) goto L5;
        return;
    L5:
        if (this.a == false) goto L19;
        h r0 = this.c;
        if (r0 == null) goto L20;
        j<d> r1 = r0.getLiveStream();
        if (r1 == null) goto L21;
        d r2 = (d) r1.getValue();
        if (r2 == null) goto L22;
        r2.g0(false);
        ALogger.i("CARNIVAL_MESSAGE", " close contour algorithm, res:-1");
        this.a = false;
        com.bytedance.android.livesdk.interactivity.common.utils.c.c(false);
        if (v.a() == true) goto L15;
        return;
    L15:
        if (CarnivalAutoTestUtil.a == false) goto L24;
        CarnivalAutoTestUtil.a();
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void b() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasCleared() == false) goto L7;
        return;
    L7:
        if (n22.a.b() == false) goto L44;
        h r1 = this.c;
        if (r1 == null) goto L14;
        j<d> r2 = r1.getLiveStream();
        if (r2 == null) goto L14;
        d r3 = (d) r2.getValue();
    L15:
        if (r3 == null) goto L18;
        r3.l0();
    L18:
        if (r3 == null) goto L20;
        r3.g0(true);
        Integer r4 = -1;
    L21:
        ALogger.i("CARNIVAL_MESSAGE", " open contour algorithm，res = " + r4);
        f r5 = DanmakuMonitor.a;
        if (r4 != null) goto L25;
    L27:
        String r6 = "fail";
    L28:
        DanmakuMonitor.b(r6, null);
        if (r4 != null) goto L32;
        return;
    L32:
        if (r4.intValue() == 0) goto L35;
        return;
    L35:
        if (v.a() == true) goto L37;
    L39:
        this.a = true;
        com.bytedance.android.livesdk.interactivity.common.utils.c.c(true);
        g r7 = new g();
        r3.j0();
        r3.h0(new b(r7, this));
        return;
    L37:
        if (CarnivalAutoTestUtil.a == false) goto L39;
        CarnivalAutoTestUtil.a();
        goto L39
    L25:
        if (r4.intValue() != 0) goto L27;
        r6 = "success";
        goto L28
    L20:
        r4 = null;
    L14:
        r3 = null;
        goto L15
    }

    public a(boolean r1, h r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.b r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
