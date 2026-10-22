package ho1;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.n;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.p;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.t;
import com.bytedance.android.livesdk.chatroom.widget.landscape.u;
import com.bytedance.android.livesdk.widget.h0;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import gd0.f;
import gd0.k;
import iy.d;
import jo1.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final d a(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return r2.getAbility(d.class);
    L6:
        return null;
    }

    public static final f b(e0 r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.m;
        if (r2 == null) goto L6;
        return r2.getAbility(f.class);
    L6:
        return null;
    }

    public static final com.bytedance.android.livesdk.chatroom.ui.framework.a c(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return (com.bytedance.android.livesdk.chatroom.ui.framework.a) r2.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.a.class);
    L6:
        return null;
    }

    public static final com.bytedance.android.livesdk.chatroom.ui.framework.c d(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return (com.bytedance.android.livesdk.chatroom.ui.framework.c) r2.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
    L6:
        return null;
    }

    public static final n e(h70.b r1) {
        IAbilityCenter r2 = r1.a();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (n) r2.getAbility(n.class);
    }

    public static final q f(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return (q) r2.getAbility(q.class);
    L6:
        return null;
    }

    public static final h g(e0 r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.m;
        if (r2 == null) goto L6;
        return (h) r2.getAbility(h.class);
    L6:
        return null;
    }

    public static final u h(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return (u) r2.getAbility(u.class);
    L6:
        return null;
    }

    public static final com.bytedance.android.livesdk.chatroom.ui.framework.d i(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return (com.bytedance.android.livesdk.chatroom.ui.framework.d) r2.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.d.class);
    L6:
        return null;
    }

    public static final p j(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return (p) r2.getAbility(p.class);
    L6:
        return null;
    }

    public static final k k(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return r2.getAbility(k.class);
    L6:
        return null;
    }

    public static final h0 l(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return r2.getAbility(h0.class);
    L6:
        return null;
    }

    public static final yh0.c m(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return r2.getAbility(yh0.c.class);
    L6:
        return null;
    }

    public static final t n(e0 r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.m;
        if (r2 == null) goto L6;
        return (t) r2.getAbility(t.class);
    L6:
        return null;
    }

    public static final boolean o(h70.b r1) {
        if ((r1 instanceof d90.d) == true) goto L5;
        r1 = null;
    L5:
        d90.d r2 = (d90.d) r1;
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.d;
    }

    public static final <T extends IAbility> void q(h70.b r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        if (r1 == null) goto L8;
        IAbilityCenter r3 = r1.a();
        if (r3 == null) goto L9;
        r3.unregisterAbility(r2);
        return;
    L9:
        return;
    }

    public static final <T extends IAbility> void p(h70.b r1, Class<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "ability");
        if (r1 == null) goto L8;
        IAbilityCenter r4 = r1.a();
        if (r4 == null) goto L9;
        r4.registerAbility(r2, r3);
        return;
    L9:
        return;
    }
}
