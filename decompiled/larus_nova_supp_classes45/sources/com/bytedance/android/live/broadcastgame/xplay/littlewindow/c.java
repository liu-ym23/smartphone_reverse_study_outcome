package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.g0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends FrameLayout {
    public d a;
    public com.bytedance.android.live.broadcastgame.api.xplay.h b;
    public final com.bytedance.android.live.broadcastgame.api.xplay.f c;
    public final XplayLittleWindowContext d;
    public final p e;
    public final g0 f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.a != null) goto L5;
        return;
    L5:
        XplayLog.c("LittleWindowLayer", "destroy cast little window");
        d r0 = this.a;
        if (r0 == null) goto L8;
        removeView(r0);
    L8:
        this.a = null;
        com.bytedance.android.live.broadcastgame.api.xplay.h r1 = this.b;
        if (r1 == null) goto L12;
        r1.onDestroyView();
        return;
    }

    public final void b(boolean r2) {
        if (r2 == false) goto L10;
        XplayLog.c("LittleWindowLayer", "open capture");
        d r3 = this.a;
        if (r3 == null) goto L7;
        r3.setVisibility(0);
    L7:
        this.d.isHidden().setValue(Boolean.FALSE);
        d r4 = this.a;
        if (r4 == null) goto L17;
        r4.h();
        return;
    L17:
        return;
    L10:
        XplayLog.c("LittleWindowLayer", "close capture");
        d r5 = this.a;
        if (r5 == null) goto L13;
        r5.setVisibility(8);
    L13:
        this.d.isHidden().setValue(Boolean.TRUE);
        d r6 = this.a;
        if (r6 == null) goto L19;
        r6.h();
        return;
    }

    public c(Context r2, com.bytedance.android.live.broadcastgame.api.xplay.f r3, XplayLittleWindowContext r4, p r5, g0 r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "inst");
        Intrinsics.checkNotNullParameter(r4, "littleWindowContext");
        Intrinsics.checkNotNullParameter(r5, "newEnv");
        Intrinsics.checkNotNullParameter(r6, "xplayLogService");
        super(r2);
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
