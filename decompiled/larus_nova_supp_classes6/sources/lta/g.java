package lta;

import android.text.TextUtils;
import ita.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class g implements h.b.a {
    public final /* synthetic */ h a;

    @Override // lta.h.b.a
    public final void onNetworkReady() {
        j.b("Retry update device id", null);
        if (TextUtils.isEmpty(((jta.a) this.a.e).c()) == false) goto L6;
        this.a.f();
        return;
    }

    public g(h r1) {
        this.a = r1;
    }
}
