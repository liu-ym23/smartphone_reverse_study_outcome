package wq1;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.live.datacontext.j;
import fq1.n;
import nq1.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static boolean a;
    public static long b;
    public static boolean c;
    public static boolean d;

    static {
        b = -1;
    }

    public static boolean a() {
        if (r.d().isSaas() == true) goto L18;
        yq1.a r0 = s.c();
        if (r0 != null) goto L7;
    L8:
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r1 = ReplayDataContext.a.a();
        if (r1 == null) goto L16;
        j<kq1.a> r2 = r1.getPaidManager();
        if (r2 == null) goto L16;
        kq1.a r3 = (kq1.a) r2.getValue();
        if (r3 == null) goto L16;
        if (kq1.a.C0397a.a(r3, false, null, 6) != true) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r0.n(null, PaidInteractEntry.CONTROL_ENTRY_FLOAT_WINDOW) == true) goto L8;
        return false;
    L18:
        return false;
    }

    public static boolean b(Context r1) {
        if (a() == true) goto L5;
    L9:
        return false;
    L5:
        if (((Boolean) d.g.getValue()).booleanValue() == false) goto L9;
        if (n.a().c(r1) == false) goto L9;
        return true;
    }
}
