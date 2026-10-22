package wk0;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.bytedance.live.kmp.core.KmpEnv;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import qh0.d;
import qh0.f;
import qh0.g;
import vm2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends vb6.b implements bc6.a {

    /* JADX INFO: renamed from: wk0.a$a, reason: collision with other inner class name */
    public static final class C0289a {
    }

    public static final class b implements d<rh0.a> {
        public final /* synthetic */ bc6.b a;
        public final /* synthetic */ long b;
        public final /* synthetic */ OperateType c;

        @Override // qh0.d
        public final void b(BaseCheckException r5) {
            Intrinsics.checkNotNullParameter(r5, "exception");
            bc6.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.c1(dc6.a.a(this.b), this.c, r5);
            return;
        }

        @Override // qh0.d
        public final void onResult(rh0.a r4) {
            bc6.b r5 = this.a;
            if (r5 == null) goto L6;
            r5.W(dc6.a.a(this.b), this.c);
            return;
        }

        public b(bc6.b r1, long r2, OperateType r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    static {
    }

    public a() {
    }

    public final void E(Context r18, OperateType r19, int r20, bc6.b r21) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "operateType");
        KmpEnv r2 = KmpEnv.a;
        if (v.a() == true) goto L5;
    L8:
        long r3 = SystemClock.elapsedRealtime();
        ArrayList r4 = new ArrayList();
        r4.add(g.a(r19, r20));
        r4.add(new f.g(r18, r19, r20));
        r4.add(new f.c(r18, r19, r20));
        r4.add(new f.a(r18));
        r4.add(new f.d(r18, r19, r20, true));
        r4.add(new f.C0257f(r18, r19, r20, true));
        r4.add(new f.e(r18, r19));
        f.a(r4).a(new b(r21, r3, r19));
        return;
    L5:
        if (i.h().L5() == false) goto L8;
        LinkMonitor.a("LinkPermissionM", "mock check link failed", null, null, null, false, 124);
        r21.c1(0, r19, new BaseCheckException(r20, r19, BaseCheckException.CheckType.AndroidPermission, "mock no android permission", null, 16, null));
    }
}
