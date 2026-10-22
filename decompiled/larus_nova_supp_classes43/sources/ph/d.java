package ph;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.opt.ab.j;
import com.bytedance.android.ec.core.opt.ab.v;
import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final Handler a = null;

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static void a(boolean r0) {
        int r1 = ECSdk.a;
        cj.b r10 = (cj.b) ECSdk.a(cj.b.class);
        if (r10 == null) goto L6;
        r10.i();
        return;
    }

    public static void b(boolean r1) {
        if (v.a().b() == false) goto L6;
        a(r1);
        return;
    }

    public static void c(boolean r0) {
        if (j.a().l() == false) goto L8;
        int r1 = ECSdk.a;
        cj.b r10 = (cj.b) ECSdk.a(cj.b.class);
        if (r10 == null) goto L9;
        r10.h();
        return;
    L9:
        return;
    }
}
