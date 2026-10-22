package d28;

import android.content.Context;
import android.text.TextUtils;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import com.franmontiel.persistentcookiejar.persistence.SerializableCookie;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import okhttp3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements CookiePersistor {
    public final KVRepo a;
    public final KVRepo b;
    public final Context c;

    public final List<g> a() {
        Log.i("SharedPrefsCookiePersistor", "loadAll!!!!-cookies in process " + z.b(this.c));
        ArrayList r0 = new ArrayList();
        d(this.a, r0);
        if (r0.isEmpty() == false) goto L5;
        Log.i("SharedPrefsCookiePersistor", "loadAll called, cookies is empty");
        d(this.b, r0);
    L5:
        Log.i("SharedPrefsCookiePersistor", "loadAll!!!!-cookies");
        return r0;
    }

    public static String c(g r2) {
        StringBuilder r0 = new StringBuilder();
        if (r2.f == false) goto L5;
        String r1 = "https";
    L6:
        r0.append(r1);
        r0.append("://");
        r0.append(r2.d);
        r0.append(r2.e);
        r0.append("|");
        r0.append(r2.a);
        return r0.toString();
    L5:
        r1 = "http";
        goto L6
    }

    public final void b(Collection<g> r7) {
        Log.i("SharedPrefsCookiePersistor", "saveAll!!!!-cookies in process " + z.b(this.c));
        if (CollectionUtils.isEmpty(r7) == false) goto L6;
        Log.i("SharedPrefsCookiePersistor", "saveAll!!!!-cookies empty return");
        return;
    L6:
        Log.i("SharedPrefsCookiePersistor", "saveAll!!!!-cookies");
        Iterator r8 = ((ArrayList) r7).iterator();
    L8:
        if (r8.hasNext() == false) goto L14;
        g r0 = (g) r8.next();
        String r2 = c(r0);
        String r3 = new SerializableCookie().encode(r0);
        this.a.putString(r2, r3);
        if (r3 == null) goto L12;
        int r4 = r3.length();
    L13:
        Log.i("SharedPrefsCookiePersistor", "Cookie PUT - key: " + r2 + ", value size: " + r4 + " characters");
        StringBuilder r5 = new StringBuilder("saveAll called, key: ");
        r5.append(r2);
        r5.append(", cookie: ");
        r5.append(r0);
        Log.d("SharedPrefsCookiePersistor", r5.toString());
        goto L8
    L12:
        r4 = 0;
        goto L13
    }

    public final void removeAll(Collection<g> r5) {
        Log.i("SharedPrefsCookiePersistor", "remove specified cookies in process " + z.b(this.c));
        if (CollectionUtils.isEmpty(r5) == false) goto L6;
        Log.i("SharedPrefsCookiePersistor", "no cookies in process");
        return;
    L6:
        Iterator r6 = ((ArrayList) r5).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        g r0 = (g) r6.next();
        this.a.remove(c(r0));
        Log.d("SharedPrefsCookiePersistor", "removeAll called, key: " + c(r0) + ", cookie: " + r0);
        goto L8
    }

    public static void d(KVRepo r10, List<g> r11) {
        String[] r0 = r10.b();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        String r4 = r0[r3];
        String r5 = r10.getString(r4, "");
        if (TextUtils.isEmpty(r5) == false) goto L7;
        Log.e("SharedPrefsCookiePersistor", "load cookie failed in CookiePersistenceSP, key:" + r4);
    L14:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r5 == null) goto L9;
        int r6 = r5.length();
    L10:
        Log.i("SharedPrefsCookiePersistor", "Cookie GET - key: " + r4 + ", value size: " + r6 + " characters");
        g r7 = new SerializableCookie().decode(r5);     // Catch: Exception -> L15
        if (r7 == null) goto L14;
        Log.d("SharedPrefsCookiePersistor", "loadAllDataFromSP called, key: " + c(r7) + ", cookie: " + r7);
        ((ArrayList) r11).add(r7);
    L16:
        throw new IllegalStateException("Failed to code cookie from sp, key: " + r4 + ", value: " + r5 + ", size: " + r5.length());
    L9:
        r6 = 0;
        goto L10
    }

    public d(Context r1, com.ss.android.lark.storage.kv.repo.a r2, com.ss.android.lark.storage.kv.repo.a r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
