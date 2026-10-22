package yz8;

import n38.z;
import wb7.k;
import yb7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g extends j {
    public final /* synthetic */ z a;

    public g(z r1) {
        this.a = r1;
    }

    public final void b(ua7.e<k> r1) {
        this.a.onSendSuccess();
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((ua7.e) r1);
    }

    public final void a(ua7.e<k> r3, int r4) {
        z r0 = this.a;
        if (r3 == null) goto L5;
        String r5 = ((ua7.b) r3).i;
    L6:
        r0.a(r4, r5, null, null);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((ua7.e) r1, r2);
    }
}
