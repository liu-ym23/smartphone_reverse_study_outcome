package nta;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import ita.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e extends c {
    public final SharedPreferences b;
    public final SharedPreferences c;

    public e(Context r3) {
        if (r3 == null) goto L7;
        this.b = r3.getSharedPreferences(kta.b.a(), 0);
        this.c = r3.getSharedPreferences(kta.b.a, 0);
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    @Override // nta.c
    public final void a(String r3) {
        if (Logger.debug() == false) goto L6;
        j.g("SharePreferenceCacheHandler cacheString key = device_id value = " + r3, null);
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        SharedPreferences.Editor r1 = e("device_id").edit();
        r1.putString("device_id", r3);
        r1.apply();
        return;
    }

    @Override // nta.c
    public final void b(String r2) {
        SharedPreferences r0 = e(r2);
        if (r0 != null) goto L5;
    L7:
        c(r2);
        super.b(r2);
        return;
    L5:
        if (r0.contains(r2) == false) goto L7;
        e(r2).edit().remove(r2).commit();
        goto L7
    }

    @Override // nta.c
    public final String c(String r5) {
        String r0 = e(r5).getString(r5, null);
        if (Logger.debug() == false) goto L5;
        j.g("SharePreferenceCacheHandler getCachedString key = " + r5 + " value = " + r0, null);
    L5:
        return r0;
    }

    public final SharedPreferences e(String r2) {
        if ("device_id".equals(r2) == false) goto L6;
        return this.c;
    L6:
        return this.b;
    }
}
