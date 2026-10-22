package yz8;

import com.larus.login.impl.b4;
import n38.z;
import wb7.k;
import yb7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h extends j {
    public final /* synthetic */ z a;

    public h(b4 r1) {
        this.a = r1;
    }

    public final void b(ua7.e<k> r1) {
        this.a.onSendSuccess();
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((ua7.e) r1);
    }

    public final void a(ua7.e<k> r5, int r6) {
        z r0 = this.a;
        String r1 = null;
        if (r5 == null) goto L5;
        String r2 = ((ua7.b) r5).i;
    L6:
        if (r5 == null) goto L8;
        Integer r3 = Integer.valueOf(((ua7.b) r5).h);
    L9:
        if (r5 == null) goto L11;
        r1 = ((ua7.b) r5).j;
    L11:
        r0.a(r6, r2, r3, r1);
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((ua7.e) r1, r2);
    }
}
