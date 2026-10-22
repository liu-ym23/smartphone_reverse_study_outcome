package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.android.live.revenue.platform.container.impl.z;
import io.reactivex.Observable;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface g {
    public static final a D0 = null;

    public static final class a {
        public static final Set<NotifyServiceCenterStateRequest.State> a = null;
        public static final Set<NotifyServiceCenterStateRequest.State> b = null;
        public static final /* synthetic */ a c = null;

        public a() {
        }

        static {
            c = new a();
            NotifyServiceCenterStateRequest.State r0 = NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED;
            a = SetsKt.setOf(r0);
            b = SetsKt.setOf(new NotifyServiceCenterStateRequest.State[]{NotifyServiceCenterStateRequest.State.STARTED, r0});
        }

        public static Set a(CenterServiceType r5) {
            Intrinsics.checkNotNullParameter(r5, "centerServiceType");
            int r6 = f.a[r5.ordinal()];
            if (r6 == 1) goto L16;
            if (r6 == 2) goto L19;
            if (r6 == 3) goto L18;
            if (r6 != 4) goto L12;
            return SetsKt.setOf(new NotifyServiceCenterStateRequest.State[]{NotifyServiceCenterStateRequest.State.STOPPED, NotifyServiceCenterStateRequest.State.PRE_STARTED, NotifyServiceCenterStateRequest.State.STARTED, NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED});
        L12:
            throw new NoWhenBranchMatchedException();
        L18:
            return SetsKt.setOf(new NotifyServiceCenterStateRequest.State[]{NotifyServiceCenterStateRequest.State.PRE_STARTED, NotifyServiceCenterStateRequest.State.STARTED, NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED});
        L19:
            return a;
        L16:
            return b;
        }
    }

    public static final class b {
        public static /* synthetic */ Observable a(g r6, Set r7, String r8, String r9, z r10) {
            return r6.K(r7, r8, r9, r10, false);
        }
    }

    static {
        D0 = a.c;
    }

    void E();

    void I(List r1, RevenueJsDriver r2);

    Observable K(Set r1, String r2, String r3, z r4, boolean r5);

    void L0(RevenueJsDriver r1);

    NotifyServiceCenterStateRequest.State b0();

    void w0(List r1, RevenueJsDriver r2);
}
