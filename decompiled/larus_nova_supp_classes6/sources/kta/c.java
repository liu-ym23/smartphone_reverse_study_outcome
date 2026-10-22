package kta;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class c<SERVICE> implements o {
    public final String a;
    public final a b;

    public abstract Intent b(Context r1);

    public abstract w.b<SERVICE, String> c();

    public c(String r2) {
        this.b = new a(this);
        this.a = r2;
    }

    @Override // kta.o
    public final boolean a(Context r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        return ((Boolean) this.b.b(new Object[]{r4})).booleanValue();
    }

    @Override // kta.o
    public o.a getOaid(Context r4) {
        String r5 = (String) new w(r4, b(r4), c()).a();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        o.a r0 = new o.a();
        r0.a = r5;
        return r0;
    }
}
