package com.larus.voicecall.impl.plugins;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.r;
import com.obric.assistant.AutoEndConversationTime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c3<C extends r> extends com.larus.audio.call.arch.a<C> {
    public a f;
    public final String g;

    public static final class a extends com.larus.audio.call.p {
        public final /* synthetic */ c3<C> g;

        public final void b() {
            t19.s.a.g(AppHost.a.getApplication(), 2131898478, false);
            com.larus.voicecall.impl.q r0 = ((r) this.g.getContext()).h();
            if (r0 == null) goto L6;
            r0.d("reach_single_time_limit");
            return;
        }

        public final void c(long r5) {
            if (r5 > 0) goto L5;
        L9:
            FLogger.a.i(this.g.g, "video timing onTick current = " + r5);
            return;
        L5:
            if (r5 >= AutoEndConversationTime.AFTER_60_SECONDS) goto L9;
            com.larus.voicecall.impl.q r0 = ((r) this.g.getContext()).h();
            if (r0 == null) goto L9;
            r0.c(r5 / ((long) 1000));
            goto L9
        }

        public a(c3<C> r3, long r4) {
            this.g = r3;
            super(r4, 1000);
        }
    }

    public final void b3() {
        a r0 = this.f;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.f = null;
    }

    public final void e3() {
        super.e3();
        if (this.f != null) goto L9;
        int r0 = com.larus.platform.service.z2.a.J2();
        FLogger.a.i(this.g, "video time out settings is " + r0);
        if (r0 != 0) goto L7;
        return;
    L7:
        a r2 = new a(this, ((long) (r0 * 60)) * 1000);
        this.f = r2;
        r2.d();
        return;
    }

    public final String T2() {
        return this.g;
    }

    public c3(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.g = "VideoTimingPlugin";
    }
}
