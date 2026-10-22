package com.ss.android.socialbase.downloader.service;

import jb.p;
import lb.a;
import qb.b;
import qb.c;
import qb.d;
import qb.e;
import qb.f;
import qb.g;
import qb.h;
import qb.i;
import qb.j;
import qb.k;
import qb.l;
import qb.m;
import qb.n;
import qb.o;
import qb.q;
import qb.r;
import qb.s;
import qb.t;
import qb.u;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadServiceLoader implements p {
    private static final String TAG = "DownloadServiceLoader";
    private static boolean isLoaded = false;

    static {
    }

    public DownloadServiceLoader() {
    }

    @Override // jb.p
    public void defaultLoadCallback(boolean r10, String r11) {
        if (a.a() == false) goto L6;
        a.b(TAG, "defaultLoadCallback", "Load status:" + r10 + " errorMsg:" + r11);
        return;
    }

    @Override // jb.p
    public void load() {
        monitor-enter(k.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (isLoaded == false) goto L8;
        monitor-exit(k.class);     // Catch: Throwable -> L17
        return;
    L8:
        isLoaded = true;     // Catch: Throwable -> L17
        if (a.a() == false) goto L11;
        a.b(TAG, "load", "Load download service start");     // Catch: Throwable -> L17
    L11:
        k.d(o.class, new d());     // Catch: Throwable -> L17
        k.d(n.class, new c());     // Catch: Throwable -> L17
        k.d(l.class, new qb.a());     // Catch: Throwable -> L17
        k.d(t.class, new i());     // Catch: Throwable -> L17
        k.d(q.class, new f());     // Catch: Throwable -> L17
        k.d(s.class, new h());     // Catch: Throwable -> L17
        k.d(r.class, new g());     // Catch: Throwable -> L17
        k.d(u.class, new j());     // Catch: Throwable -> L17
        k.d(qb.p.class, new e());     // Catch: Throwable -> L17
        k.d(m.class, new b());     // Catch: Throwable -> L17
        k.f();     // Catch: Throwable -> L17
        monitor-exit(k.class);     // Catch: Throwable -> L17
        if (a.a() == false) goto L21;
        a.b(TAG, "load", "Load download service end");
        return;
    }
}
