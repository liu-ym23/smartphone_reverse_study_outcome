package p38;

import com.larus.login.impl.w;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import n38.m;
import xa7.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends va7.f {
    public final /* synthetic */ m a;

    public b(w r1) {
        this.a = r1;
    }

    public final void onSuccess(ua7.b r5) {
        i r6 = (i) r5;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("checkSafeEnvBeforeInputOldMobile safe:");
        if (r6 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r6.q);
    L6:
        r1.append(r3);
        r1.append(" ticket:");
        if (r6 == null) goto L9;
        String r4 = r6.p;
    L10:
        r1.append(r4);
        r0.i("ChangePhoneManager", r1.toString());
        if (r6 == null) goto L15;
        boolean r2 = true;
        if (r6.q != true) goto L15;
    L16:
        if (r2 == true) goto L18;
    L20:
        m r7 = this.a;
        if (r6 == null) goto L23;
        int r8 = ((ua7.b) r6).g;
    L24:
        if (r6 == null) goto L26;
        String r9 = ((ua7.b) r6).i;
    L27:
        r7.a(r8, r9, null, null);
        return;
    L26:
        r9 = null;
        goto L27
    L23:
        r8 = -1;
        goto L24
    L18:
        if (o0.d(r6.p) == false) goto L20;
        this.a.onSuccess(r6.p);
        return;
    L15:
        r2 = false;
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onError(ua7.b r4, int r5) {
        i r6 = (i) r4;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("checkSafeEnvBeforeInputOldMobile error:");
        r1.append(r5);
        r1.append(':');
        if (r6 == null) goto L5;
        String r2 = ((ua7.b) r6).i;
    L6:
        r1.append(r2);
        r0.w("ChangePhoneManager", r1.toString());
        m r3 = this.a;
        if (r6 == null) goto L9;
        int r7 = ((ua7.b) r6).g;
    L10:
        if (r6 == null) goto L12;
        String r8 = ((ua7.b) r6).i;
    L13:
        r3.a(r7, r8, null, null);
        return;
    L12:
        r8 = null;
        goto L13
    L9:
        r7 = -1;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
