package r10;

import amc.f;
import android.content.Context;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.c10;
import java.util.ArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import st2.b;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static d a(Context r12, long r13, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r12, "context");
        String r5 = k.n(IUserService.class).user().n();
        ArrayList r9 = new ArrayList();
        s10.a r0 = new s10.a(r12, r13, r5, r15, r9);
        int r14 = vs1.d.a;
        c10 r16 = c10.a;
        if (((vs1.d) r16.getValue()).d() == false) goto L6;
        return b.a(((vs1.d) r16.getValue()).c(), ((vs1.d) r16.getValue()).a(), r0.f(), r9, null, null);
    L6:
        return f.a(r0);
    }
}
