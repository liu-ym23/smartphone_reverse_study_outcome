package com.ss.android.deviceregister.b.a.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.ss.android.deviceregister.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes6.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccountManager f15170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Account f15171b;
    private final ConcurrentHashMap<String, String> c;
    private volatile Set<String> d;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.c = new ConcurrentHashMap();
        this.d = null;
        this.f15170a = AccountManager.get(r4);
    }

    static /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.c;
    }

    static /* synthetic */ AccountManager b(a r0) {
        return r0.f15170a;
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public String a(String r5) {
        Account r0 = this.f15171b;
        if (r0 != null) goto L15;
        return null;
    L15:
        String r4 = this.f15170a.getUserData(r0, r5);     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L8;
        Logger.d("AccountCacheHelper", "get cached string : key = " + r5 + ",value = " + r4);     // Catch: Throwable -> L9
    L8:
        return r4;
    L9:
        th = move-exception;
        if (Logger.debug() == false) goto L13;
        Logger.e("get string error,please fix it : ");
    L13:
        th.printStackTrace();
        return null;
    }

    public void a(final Account r6) {
        if (r6 == null) goto L23;
        monitor-enter(this);
        this.f15171b = r6;     // Catch: Throwable -> L20
        if (this.c.size() > 0) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.d == null) goto L18;
        Iterator<String> r0 = this.d.iterator();     // Catch: Throwable -> L20
    L12:
        if (r0.hasNext() == false) goto L18;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        this.f15170a.setUserData(this.f15171b, r1, null);     // Catch: Exception -> L16 Throwable -> L20
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        com.bytedance.common.utility.a.c.a(new AnonymousClass1(this, r6));
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public void a(String r4, String r5) {
        l.b(l.f15219a, "AccountCacheHelper#cacheString key=" + r4 + " value=" + r5 + " mAccount=" + this.f15171b);
        if (this.f15171b != null) goto L6;
        this.c.put(r4, r5);
        return;
    L6:
        if (r4 == null) goto L22;
        if (r5 == null) goto L23;
    L14:
        th = move-exception;
        if (Logger.debug() == false) goto L18;
        Logger.e("save string error,please fix it : ");
    L18:
        th.printStackTrace();
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("AccountCacheHelper", "cache string : key = " + r4 + ",value = " + r5);     // Catch: Throwable -> L14
    L12:
        this.f15170a.setUserData(this.f15171b, r4, r5);     // Catch: Throwable -> L14
        return;
    L23:
        return;
    }

    @Override // com.ss.android.deviceregister.b.a.a.b
    public void b(String r4) {
        ConcurrentHashMap<String, String> r0 = this.c;
        if (r0 != null) goto L5;
    L29:
        monitor-enter(this);     // Catch: Exception -> L28
    L23:
        th = move-exception;
        throw th;     // Catch: Exception -> L28
    L9:
        if (this.f15171b == null) goto L11;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L23
        Account r1 = this.f15171b;     // Catch: Exception -> L28
        if (r1 == null) goto L26;
        AccountManager r2 = this.f15170a;     // Catch: Exception -> L28
        if (r2 == null) goto L26;
        r2.setUserData(r1, r4, null);     // Catch: Exception -> L28
        goto L26
        goto L26
    L11:
        if (this.d != null) goto L14;
        this.d = new CopyOnWriteArraySet();     // Catch: Throwable -> L23
    L14:
        if (this.d.contains(r4) == true) goto L16;
        this.d.add(r4);     // Catch: Throwable -> L23
    L26:
        l.b(l.f15219a, "AccountCacheHelper#clear key=" + r4 + " mAccount=" + this.f15171b + " getCachedString(key)=" + a(r4));
        super.b(r4);
        return;
    L5:
        if (r0.containsKey(r4) == false) goto L29;
        this.c.remove(r4);
        goto L29
    }
}
