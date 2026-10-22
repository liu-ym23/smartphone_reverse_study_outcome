package w48;

import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.t0;
import com.larus.applog.impl.ApplogImpl;
import kotlin.jvm.internal.Intrinsics;
import nba.c;
import v48.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k implements t0 {
    public final /* synthetic */ ApplogImpl a;
    public final /* synthetic */ b b;

    public final void onTimeout() {
        this.a.getClass();
        ApplogImpl.A(0, "-1001", "timeout");
        b r0 = this.b;
        if (r0 == null) goto L6;
        r0.onTimeout();
        return;
    }

    public final void a(n0 r5) {
        Intrinsics.checkNotNullParameter(r5, "installInfo");
        String r0 = r5.a;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r6 = r5.b;
        if (r6 == null) goto L10;
        r1 = r6;
    L10:
        if (r0.length() <= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == true) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L20;
        this.a.getClass();
        ApplogImpl.A(1, null, null);
    L21:
        b r9 = this.b;
        if (r9 == null) goto L25;
        r9.a(r0, r1);
        return;
    L25:
        return;
    L20:
        this.a.getClass();
        ApplogImpl.A(0, "-1002", "invalid_did");
        goto L21
    L15:
        if (Intrinsics.areEqual(r0, "0") == true) goto L17;
        r8 = true;
        goto L18
    L12:
        r7 = false;
        goto L13
    }

    public k(ApplogImpl r1, c.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
