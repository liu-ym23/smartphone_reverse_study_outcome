package mlc;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements c {
    public final SharedPreferences a;

    @Override // mlc.c
    public final void clear() {
        SharedPreferences.Editor r0 = this.a.edit();
        if (r0 == null) goto L11;
        Iterator<String> r1 = this.a.getAll().keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r0.remove(r1.next());
        goto L6
    L8:
        r0.apply();
        return;
    }

    public a(Context r2, String r3) {
        this.a = r2.getApplicationContext().getSharedPreferences(r3, 0);
    }

    @Override // mlc.c
    public final String getString(String r2, String r3) {
        String r4 = this.a.getString(r2, r3);
        if (r4 != null) goto L5;
        return r3;
    L5:
        return r4;
    }

    @Override // mlc.c
    public final void putString(String r2, String r3) {
        SharedPreferences.Editor r0 = this.a.edit();
        if (r0 == null) goto L8;
        SharedPreferences.Editor r4 = r0.putString(r2, r3);
        if (r4 == null) goto L9;
        r4.apply();
        return;
    L9:
        return;
    }
}
