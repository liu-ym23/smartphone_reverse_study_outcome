package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LruDownloadCache extends DownloadCache {
    public final SparseArray d;
    public final HashMap e;
    public final ArrayList f;
    public final ISqlDownloadCache g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f15702h;

    public LruDownloadCache(ISqlDownloadCache r5) {
        this.d = new SparseArray();
        this.e = new HashMap();
        this.f = new ArrayList();
        this.f15702h = new AnonymousClass1(this);
        this.g = r5;
    }

    public final boolean a(Integer r5) {
        if (r5.intValue() != 0) goto L6;
        return false;
    L6:
        HashMap r10 = this.e;
        monitor-enter(r10);
        boolean r11 = this.e.containsKey(r5);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L11:
        th = move-exception;
        throw th;
    }

    public final void b(Integer r5) {
        if (r5.intValue() != 0) goto L5;
        return;
    L5:
        HashMap r10 = this.e;
        monitor-enter(r10);
        this.e.remove(r5);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List c(String r5) {
        h();
        return this.g.c(r5);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List d(String r5) {
        h();
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return null;
    L7:
        return this.g.d(r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo e(int r5) {
        DownloadInfo r10 = a(r5);
        if (r10 == null) goto L5;
        r10.a(5);
        r10.f15822k0 = false;
    L5:
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public final void f() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L7
        char[] r10 = DownloadUtils.f16142a;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public final HashMap g() {
        return this.e;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo h(int r5) {
        DownloadInfo r10 = a(r5);
        if (r10 == null) goto L5;
        r10.a(2);
    L5:
        return r10;
    }

    public final void i() {
        SparseArray r5 = this.d;
        monitor-enter(r5);
        this.d.clear();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void j() {
        HashMap r5 = this.e;
        monitor-enter(r5);
        this.e.clear();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo k(int r5) {
        DownloadInfo r10 = a(r5);
        if (r10 == null) goto L5;
        r10.a(1);
    L5:
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List o(int r5) {
        Map r10 = r(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r10.values());
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void q(int r5) {
        SparseArray r10 = this.d;
        monitor-enter(r10);
        this.d.remove(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final Map r(int r5) {
        SparseArray r10 = this.d;
        monitor-enter(r10);
        Map r11 = (Map) this.d.get(r5);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        if (r11 != null) goto L13;
        Map r12 = this.g.r(r5);
        if (r12 != null) goto L11;
        return null;
    L11:
        b(r5, r12);
        return r12;
    L13:
        return r11;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo c(int r5, long r10) {
        DownloadInfo r11 = a(r5);
        if (r11 == null) goto L5;
        r11.c(r10);
        r11.a(-1);
        r11.f15822k0 = false;
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List d() {
        h();
        return this.g.d();
    }

    public final void a(Integer r5, DownloadInfo r10) {
        if (r5.intValue() != 0) goto L5;
        return;
    L5:
        LinkedHashMap r11 = this.f15702h;
        monitor-enter(r11);
        this.f15702h.put(r5, r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo j(int r5) {
        DownloadInfo r10 = a(r5);
        if (r10 == null) goto L5;
        r10.a(-7);
    L5:
        return r10;
    }

    public final void b(int r5, Map r10) {
        if (r5 != 0) goto L4;
        return;
    L4:
        SparseArray r11 = this.d;
        monitor-enter(r11);
        this.d.put(r5, r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean d(int r5) {
        b(r5);
        q(r5);
        b(Integer.valueOf(r5));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public final void c(DownloadInfo r5) {
        a(Integer.valueOf(r5.l()), r5);
        b(Integer.valueOf(r5.l()));
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo d(int r5, long r10) {
        DownloadInfo r11 = a(r5);
        if (r11 == null) goto L5;
        r11.c(r10);
        r11.a(-3);
        r11.f15822k0 = false;
        r11.l0 = false;
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5) {
        h();
        Integer r10 = Integer.valueOf(r5);     // Catch: Exception -> L13
        LinkedHashMap r11 = this.f15702h;     // Catch: Exception -> L13
        monitor-enter(r11);     // Catch: Exception -> L13
        DownloadInfo r12 = (DownloadInfo) this.f15702h.get(r10);     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        if (r12 == null) goto L27;
    L19:
        return r12;
    L27:
    L17:
        e = e;
    L24:
        e.printStackTrace();
        return r12;
    L9:
        if (a(Integer.valueOf(r5)) == false) goto L19;
        DownloadInfo r13 = this.g.a(r5);     // Catch: Exception -> L17
        if (r13 == null) goto L15;
        a(Integer.valueOf(r5), r13);     // Catch: Exception -> L13
    L15:
        b(Integer.valueOf(r5));     // Catch: Exception -> L13
        return r13;
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L13
    L13:
        e = e;
        r12 = null;
        goto L24
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List b(String r5) {
        h();
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return null;
    L7:
        return this.g.b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean b(int r5) {
        h();
        Integer r10 = Integer.valueOf(r5);
        LinkedHashMap r11 = this.f15702h;
        monitor-enter(r11);
        this.f15702h.remove(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        b(Integer.valueOf(r5));
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List a(String r5) {
        h();
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return null;
    L7:
        return this.g.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo b(int r5, long r10) {
        DownloadInfo r11 = a(r5);
        if (r11 == null) goto L16;
        r11.c(r10);
        if (r11.o() == (-3)) goto L16;
        if (r11.o() == (-2)) goto L16;
        int r12 = r11.o();
        if (r12 == (-1)) goto L16;
        if (r12 == (-7)) goto L16;
        if (r11.o() == (-4)) goto L16;
        r11.a(4);
    L16:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List a(String r5, String r10) {
        h();
        return DownloadCache.a(this.g.d(), r5, r10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(DownloadInfo r5) {
        h();
        boolean r10 = true;
        if (r5 != null) goto L6;
        return true;
    L6:
        if (a(r5.l()) != null) goto L9;
        r10 = false;
    L9:
        a(Integer.valueOf(r5.l()), r5);
        b(Integer.valueOf(r5.l()));
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void b(DownloadInfo r5) {
        a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public final List b() {
        return this.f;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void a() {
        h();
        LinkedHashMap r5 = this.f15702h;
        monitor-enter(r5);
        this.f15702h.clear();     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        j();
        i();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5, long r10, String r11, String r12) {
        DownloadInfo r13 = a(r5);
        if (r13 == null) goto L10;
        r13.f15817h0 = r10;
        r13.F = r11;
        if (TextUtils.isEmpty(r13.f15808b) == true) goto L7;
    L9:
        r13.a(3);
        goto L10
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r13.f15808b = r12;
    L10:
        return r13;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5, long r10) {
        DownloadInfo r11 = a(r5);
        if (r11 == null) goto L5;
        r11.c(r10);
        r11.a(-2);
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(int r5, Map r10) {
        b(r5, r10);
        return true;
    }
}
