package nta;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.bytedance.common.utility.Logger;
import ita.j;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b extends c {
    public final AccountManager b;
    public Account c;
    public final ConcurrentHashMap<String, String> d;
    public volatile Set<String> e;

    public b(Context r2) {
        this.d = new ConcurrentHashMap();
        this.e = null;
        this.b = AccountManager.get(r2);
    }

    @Override // nta.c
    public final void a(String r4) {
        Objects.toString(this.c);
        if (this.c != null) goto L6;
        this.d.put("device_id", r4);
        return;
    L6:
        if (r4 == null) goto L21;
    L13:
        th = move-exception;
        if (Logger.debug() == false) goto L17;
        j.c("save string error,please fix it : ", th);
    L17:
        th.printStackTrace();
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        j.b("AccountCacheHelper cache string : key = device_id,value = ".concat(r4), null);     // Catch: Throwable -> L13
    L11:
        this.b.setUserData(this.c, "device_id", r4);     // Catch: Throwable -> L13
        return;
    }

    @Override // nta.c
    public final void b(String r4) {
        ConcurrentHashMap<String, String> r0 = this.d;
        if (r0 != null) goto L5;
    L32:
        monitor-enter(this);     // Catch: Exception -> L29
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L29
    L9:
        if (this.c == null) goto L11;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L16
        Account r1 = this.c;     // Catch: Exception -> L29
        if (r1 == null) goto L27;
        AccountManager r2 = this.b;     // Catch: Exception -> L29
        if (r2 == null) goto L27;
        r2.setUserData(r1, r4, null);     // Catch: Exception -> L29
        goto L27
        goto L27
    L11:
        if (this.e != null) goto L14;
        this.e = new CopyOnWriteArraySet();     // Catch: Throwable -> L16
    L14:
        if (((CopyOnWriteArraySet) this.e).contains(r4) == true) goto L18;
        ((CopyOnWriteArraySet) this.e).add(r4);     // Catch: Throwable -> L16
    L27:
        Objects.toString(this.c);
        c(r4);
        super.b(r4);
        return;
    L5:
        if (r0.containsKey(r4) == false) goto L32;
        this.d.remove(r4);
        goto L32
    }

    @Override // nta.c
    public final String c(String r5) {
        Account r1 = this.c;
        if (r1 != null) goto L15;
        return null;
    L15:
        String r2 = this.b.getUserData(r1, r5);     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L8;
        j.b("AccountCacheHelper get cached string : key = " + r5 + ",value = " + r2, null);     // Catch: Throwable -> L9
    L8:
        return r2;
    L9:
        th = move-exception;
        if (Logger.debug() == false) goto L13;
        j.c("get string error,please fix it : ", null);
    L13:
        th.printStackTrace();
        return null;
    }
}
