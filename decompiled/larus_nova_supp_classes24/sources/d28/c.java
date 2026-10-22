package d28;

import android.content.Context;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements ClearableCookieJar {
    public boolean b;
    public final Context c;
    public final CookieCache d;
    public final CookiePersistor e;

    public final void c() {
        if (this.b == false) goto L5;
        return;
    L5:
        List r0 = this.e.a();
        if (r0 != null) goto L8;
    L12:
        Log.i("PersistentCookieJar", "ensureLoaded failed");
        return;
    L8:
        if (r0.size() <= 0) goto L12;
        this.b = true;
        this.d.addAll(r0);
        Log.i("PersistentCookieJar ensureLoaded process:" + z.b(this.c));
    }

    public final synchronized List<g> a(HttpUrl r12) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L46
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L46
        c();     // Catch: Throwable -> L46
        Iterator r2 = this.d.iterator();     // Catch: Throwable -> L46
    L5:
        if (r2.hasNext() == false) goto L43;
        g r3 = (g) r2.next();     // Catch: Throwable -> L46
        boolean r8 = true;
        if (r3.c >= System.currentTimeMillis()) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L11;
        if (r3.i == false) goto L19;
        boolean r5 = r12.host().equals(r3.d);     // Catch: Throwable -> L46
    L20:
        if (r5 == true) goto L22;
    L21:
        r8 = false;
    L41:
        if (r8 == false) goto L5;
        r1.add(r3);     // Catch: Throwable -> L46
        goto L5
    L22:
        String r6 = r3.e;     // Catch: Throwable -> L46
        String r7 = r12.encodedPath();     // Catch: Throwable -> L46
        if (r7.equals(r6) == false) goto L26;
    L32:
        boolean r9 = true;
    L34:
        if (r9 == false) goto L21;
        if (r3.f == false) goto L41;
        if (r12.isHttps() == true) goto L41;
    L26:
        if (r7.startsWith(r6) == true) goto L28;
    L33:
        r9 = false;
        goto L34
    L28:
        if (r6.endsWith("/") == true) goto L32;
        if (r7.charAt(r6.length()) != '/') goto L33;
    L19:
        r5 = g.b(r12.host(), r3.d);     // Catch: Throwable -> L46
        goto L20
    L11:
        r0.add(r3);     // Catch: Throwable -> L46
        r2.remove();     // Catch: Throwable -> L46
        Log.i("PersistentCookieJar expiredcookie loadForRequest", r12.toString());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Log.e("logCookie", th);     // Catch: Throwable -> L46
        goto L5
    L9:
        r4 = false;
        goto L10
    L43:
        this.e.removeAll(r0);     // Catch: Throwable -> L46
        r12.host();     // Catch: Throwable -> L46
        monitor-exit(this);
        return r1;
    L46:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(HttpUrl r4, List<g> r5) {
        monitor-enter(this);
        this.d.addAll(r5);     // Catch: Throwable -> L12
        CookiePersistor r6 = this.e;     // Catch: Throwable -> L12
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<g> r7 = r5.iterator();     // Catch: Throwable -> L12
    L5:
        if (r7.hasNext() == false) goto L9;
        g r1 = r7.next();     // Catch: Throwable -> L12
        if (r1.h == false) goto L5;
        r0.add(r1);     // Catch: Throwable -> L12
        goto L5
    L9:
        r6.b(r0);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public c(Context r2, SetCookieCache r3, d r4) {
        this.b = false;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
