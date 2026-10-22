package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v implements Action {
    public final /* synthetic */ u a;

    public v(u r1) {
        this.a = r1;
    }

    public final void run() {
        u r0 = this.a;
        e0 r1 = r0.a;
        com.bytedance.android.live.broadcastgame.api.xplay.p r2 = r0.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "xplayNewEnv");
        int r3 = XplayLog.a;
        XplayLog.c("XplayInstance", "xplayInitialize, xplayScope=" + r1.b);
        Object r4 = null;
        if (r1.b != null) goto L29;
        Pair r5 = com.bytedance.live.datacontext.d.a(XplayInstance$start$1.INSTANCE);
        XplayInternalContext r6 = (XplayInternalContext) r5.component1();
        RxUtilKt.c((Disposable) r5.component2(), r1.a);
        XplayScene r7 = r2.f;
        com.bytedance.android.live.broadcastgame.api.xplay.s r8 = r2.j;
        if (r8 == null) goto L9;
        XplayGuestType r9 = r8.i;
        if (r9 == null) goto L9;
    L10:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r1.c = r9;
        com.bytedance.android.live.broadcastgame.api.xplay.l r11 = r2.h;
        r1.d = r11.b;
        r1.e = r11.c;
        r6.getCurrentScene().setValue(r2.f);
        com.bytedance.android.scope.m.e.getClass();
        t1 r12 = new t1(com.bytedance.android.scope.m.d);
        Intrinsics.checkNotNullParameter(r12, "scope");
        Intrinsics.checkNotNullParameter(r2, "value");
        r12.e = r2;
        Intrinsics.checkNotNullParameter(r6, "value");
        r12.g = r6;
        Intrinsics.checkNotNullParameter(r1, "value");
        r12.f = r1;
        Object r13 = e33.k.a;
        if (r12.e != r13) goto L13;
        String r14 = "newEnv";
    L19:
        if (r14 != null) goto L37;
        r1.b = r12;
        com.bytedance.android.scope.l.a(r12);
        LinkedHashSet<com.bytedance.android.live.broadcastgame.api.xplay.f> r15 = XplayGlobalServiceImpl.a;
        Intrinsics.checkNotNullParameter(r1, "instance");
        XplayGlobalServiceImpl.a.add(r1);
        Set<g10.b> r16 = s.a;
        Intrinsics.checkNotNullParameter(r1, "instance");
        XplayLog.a("XplayExtensionManager", "dispatch instance create: " + r1);
        Iterator<T> r17 = s.a.iterator();
    L22:
        if (r17.hasNext() == false) goto L29;
        g10.b r18 = (g10.b) r17.next();
        if ((r18 instanceof g10.d) == true) goto L26;
        r18 = null;
    L26:
        g10.d r19 = (g10.d) r18;
        if (r19 == null) goto L22;
        r19.a(r1);
        goto L22
    L37:
        throw new UninitializedPropertyAccessException(r14);
    L13:
        if (r1 != r13) goto L16;
        r14 = "instance";
        goto L19
    L16:
        if (r12.g != r13) goto L18;
        r14 = "xplayInternalContext";
        goto L19
    L18:
        r14 = null;
    L9:
        r9 = XplayGuestType.DEFAULT;
    L29:
        t1 r21 = this.a.a.b;
        if (r21 == null) goto L32;
        r4 = com.bytedance.android.scope.m.e.d(r21, k20.a.class);
    L32:
        k20.a r22 = (k20.a) r4;
        if (r22 == null) goto L43;
        r22.launch();
        return;
    }
}
