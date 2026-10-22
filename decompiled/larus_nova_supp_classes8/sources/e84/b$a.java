package e84;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class b$a extends i84.r<Boolean> {
    public final /* synthetic */ b c;

    public b$a(b r1) {
        this.c = r1;
    }

    public final Object a(Object[] r4) {
        boolean r0 = false;
        Context r5 = (Context) r4[0];
        String r1 = this.c.a;
        if (r5.getPackageManager().getPackageInfo(r1, 128) == null) goto L7;
        r0 = true;
    L7:
        return Boolean.valueOf(r0);
    }
}
