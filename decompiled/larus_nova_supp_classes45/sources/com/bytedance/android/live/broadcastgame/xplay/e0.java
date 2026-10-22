package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 implements com.bytedance.android.live.broadcastgame.api.xplay.f {
    public final CompositeDisposable a;
    public t1 b;
    public XplayGuestType c;
    public String d;
    public String e;

    public static final class a {
    }

    static {
        e33.l[] r0 = d13.a.a;
        com.bytedance.android.scope.m r1 = com.bytedance.android.scope.m.e;
        d13.a r2 = d13.a.b;
        r1.getClass();
        com.bytedance.android.scope.m.e(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final void stop() {
        int r0 = XplayLog.a;
        XplayLog.c("XplayInstance", "xplayDestroy, xplayScope=" + this.b);
        Set<g10.b> r1 = s.a;
        Intrinsics.checkNotNullParameter(this, "instance");
        XplayLog.a("XplayExtensionManager", "dispatch instance destroy: " + this);
        Iterator<T> r2 = s.a.iterator();
    L3:
        g10.b r3 = null;
        if (r2.hasNext() == false) goto L12;
        g10.b r4 = (g10.b) r2.next();
        if ((r4 instanceof g10.d) == false) goto L9;
        r3 = r4;
    L9:
        g10.d r5 = (g10.d) r3;
        if (r5 == null) goto L3;
        r5.d(this);
        goto L3
    L12:
        t1 r6 = this.b;
        if (r6 == null) goto L15;
        com.bytedance.android.scope.l.c(r6);
    L15:
        LinkedHashSet<com.bytedance.android.live.broadcastgame.api.xplay.f> r7 = XplayGlobalServiceImpl.a;
        Intrinsics.checkNotNullParameter(this, "instance");
        XplayGlobalServiceImpl.a.remove(this);
        this.b = null;
        this.a.clear();
    }

    public e0() {
        this.a = new CompositeDisposable();
        this.c = XplayGuestType.DEFAULT;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final XplayGuestType a() {
        return this.c;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final String getAppId() {
        return this.d;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final String getGameName() {
        return this.e;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.f
    public final <T> T getService(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        t1 r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) com.bytedance.android.scope.m.e.d(r0, r3);
    }
}
