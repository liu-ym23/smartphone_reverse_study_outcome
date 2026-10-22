package y60;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean();
    }

    public static final void a(Context r7) {
        Map<String, ?> r0 = r7.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2", 0).getAll();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isEmpty()) == false) goto L54;
        SharedPreferences.Editor r2 = r7.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2_for_mini_process", 0).edit();
        Iterator<T> r1 = r0.entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L30;
        Map.Entry r3 = (Map.Entry) r1.next();
        String r4 = (String) r3.getKey();
        Object r5 = r3.getValue();
        if ((r5 instanceof Boolean) == true) goto L11;
        if ((r5 instanceof String) == true) goto L14;
        if ((r5 instanceof Integer) == true) goto L17;
        if ((r5 instanceof Long) == true) goto L20;
        if ((r5 instanceof Float) == true) goto L23;
        boolean r6 = r5 instanceof Set;
        if (r6 == false) goto L8;
        if (r6 == true) goto L28;
        r5 = null;
    L28:
        r2.putStringSet(r4, (Set) r5);
        goto L8
    L23:
        r2.putFloat(r4, ((Number) r5).floatValue());
        goto L8
    L20:
        r2.putLong(r4, ((Number) r5).longValue());
        goto L8
    L17:
        r2.putInt(r4, ((Number) r5).intValue());
        goto L8
    L14:
        r2.putString(r4, (String) r5);
        goto L8
    L11:
        r2.putBoolean(r4, ((Boolean) r5).booleanValue());
        goto L8
    L30:
        r2.commit();
        r7.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2_flags", 0).edit().putBoolean("need_update_for_mini_process", false).apply();
        return;
    }
}
