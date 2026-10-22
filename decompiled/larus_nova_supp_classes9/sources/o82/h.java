package o82;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vr1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("LiveInteractive", r1);
    }

    @JvmStatic
    public static final void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("LiveInteractive", r1);
    }

    @JvmStatic
    public static final void a(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "toastMessage");
        if (v.a() == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.e r3 = nq1.d.a;
        if (((Boolean) nq1.d.s.getValue()).booleanValue() == false) goto L11;
        j r4 = r.i();
        if (r4 == null) goto L12;
        r4.n(r2);
        return;
    L12:
        return;
    L11:
        return;
    }
}
