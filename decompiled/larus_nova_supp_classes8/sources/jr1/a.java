package jr1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import d90.d;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final j<Unit> a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isFirstFrameShown");
        u r3 = r.u(r2.h, null, 2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return r3.k();
    }

    public static final boolean b(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isMultiTabRoom");
        s.i().a();
        return MultiTabManagerImpl.e.h(r1.h);
    }

    public static final boolean c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isVSVerticalStream");
        u r3 = r.u(r2.h, null, 2);
        if (r3 == null) goto L9;
        m<Boolean> r4 = r3.A();
        if (r4 == null) goto L9;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final m<Boolean> d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$streamTransitionAnimating");
        u r3 = r.u(r2.h, null, 2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return r3.X0();
    }

    public static final boolean e(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$vsMediaSupport");
        return r.d().d(r1.h);
    }
}
