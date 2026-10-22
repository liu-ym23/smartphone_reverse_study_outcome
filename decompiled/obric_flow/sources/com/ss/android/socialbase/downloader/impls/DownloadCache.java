package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCache implements IDownloadCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f15692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f15693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15694c;

    public DownloadCache() {
        this.f15692a = new ConcurrentHashMap();
        this.f15693b = new ConcurrentHashMap();
        boolean r5 = false;
        this.f15694c = false;
        LruCache r10 = DownloadSetting.e;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("active_load_download_cache") <= 0) goto L5;
        r5 = true;
    L5:
        this.f15694c = r5;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo a(int r5) {
        h();
        return (DownloadInfo) this.f15692a.get(Integer.valueOf(r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List b(String r5) {
        h();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.f15692a.isEmpty() == true) goto L29;
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f15692a.values().iterator();
    L9:
        if (r11.hasNext() == false) goto L17;
        DownloadInfo r12 = (DownloadInfo) r11.next();
        if (TextUtils.isEmpty(r12.f15839u) == true) goto L9;
        if (r12.f15839u.equals(r5) == false) goto L9;
        if (r12.o() != (-3)) goto L9;
        r10.add(r12);
        goto L9
    L17:
        return r10;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void c(int r5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List d(String r5) {
        h();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.f15692a.isEmpty() == true) goto L29;
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f15692a.values().iterator();
    L9:
        if (r11.hasNext() == false) goto L17;
        DownloadInfo r12 = (DownloadInfo) r11.next();
        if (r12 == null) goto L9;
        if (TextUtils.isEmpty(r12.f15808b) == true) goto L9;
        if (r12.f15808b.endsWith(r5) == false) goto L9;
        r10.add(r12);
        goto L9
    L17:
        return r10;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean e() {
        return false;
    }

    public void f() {
    }

    public HashMap g() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo h(int r5) {
        DownloadInfo r10 = a(r5);
        if (r10 == null) goto L5;
        r10.a(2);
    L5:
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo j(int r5) {
        DownloadInfo r10 = a(r5);
        if (r10 == null) goto L5;
        r10.a(-7);
    L5:
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo k(int r5) {
        DownloadInfo r10 = a(r5);
        if (r10 == null) goto L5;
        r10.a(1);
    L5:
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List o(int r5) {
        Map r10 = (Map) this.f15693b.get(Integer.valueOf(r5));
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r10.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void q(int r5) {
        this.f15693b.remove(Integer.valueOf(r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map r(int r5) {
        return (Map) this.f15693b.get(Integer.valueOf(r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean c() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo e(int r5) {
        DownloadInfo r10 = a(r5);
        if (r10 == null) goto L5;
        r10.a(5);
        r10.f15822k0 = false;
    L5:
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List a(String r5) {
        h();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.f15692a.isEmpty() == true) goto L45;
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f15692a.values().iterator();
    L9:
        if (r11.hasNext() == false) goto L27;
        DownloadInfo r12 = (DownloadInfo) r11.next();
        if (r12 == null) goto L9;
        if (TextUtils.isEmpty(r12.f15839u) == true) goto L9;
        if (r12.f15839u.equals(r5) == false) goto L9;
        int r13 = r12.o();
        if (r13 == (-1)) goto L26;
        if (r13 == (-2)) goto L26;
        if (r13 == (-7)) goto L26;
        if (r13 == (-4)) goto L26;
        if (r13 != (-5)) goto L9;
    L26:
        r10.add(r12);
        goto L9
    L27:
        return r10;
    L45:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List c(String r5) {
        h();
        ArrayList r10 = new ArrayList();
        if (TextUtils.isEmpty(r5) == true) goto L11;
        Iterator r11 = this.f15692a.values().iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        DownloadInfo r12 = (DownloadInfo) r11.next();
        if (r5.equals(r12.d) == false) goto L7;
        r10.add(r12);
    L11:
        return r10;
    }

    public final void h() {
        Context r5 = DownloadComponentManager.f15515a;
        if (this.f15694c == true) goto L5;
        return;
    L5:
        if (DownloadUtils.a() == true) goto L9;
        ((DefaultDownloadCache) DownloadComponentManager.h()).e();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo c(int r5, long r10) {
        DownloadInfo r11 = a(r5);
        if (r11 == null) goto L5;
        r11.c(r10);
        r11.a(-1);
        r11.f15822k0 = false;
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List d() {
        h();
        if (this.f15692a.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r5 = new ArrayList();
        Iterator r10 = this.f15692a.values().iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r5.add((DownloadInfo) r10.next());
        goto L8
    L10:
        return r5;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean b(int r5) {
        h();
        this.f15692a.remove(Integer.valueOf(r5));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List a(String r5, String r10) {
        h();
        return a(this.f15692a.values(), r5, r10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo b(int r5, long r10) {
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

    public void c(DownloadInfo r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.f15692a.put(Integer.valueOf(r5.l()), r5);
    }

    public static ArrayList a(Collection r5, String r10, String r11) {
        if (r5.isEmpty() == false) goto L5;
        return null;
    L5:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r5.iterator();
    L7:
        if (r13.hasNext() == false) goto L33;
        DownloadInfo r14 = (DownloadInfo) r13.next();
        if (r14 != null) goto L12;
    L30:
        boolean r15 = false;
    L31:
        if (r15 == false) goto L7;
        r12.add(r14);
        goto L7
    L12:
        if (TextUtils.isEmpty(r10) == true) goto L19;
        if (TextUtils.isEmpty(r14.f15839u) == true) goto L19;
        if (r10.equals(r14.f15839u) == false) goto L19;
        r15 = true;
    L19:
        if (TextUtils.isEmpty(r11) == true) goto L30;
        if (TextUtils.isEmpty(r14.d) == true) goto L30;
        String r16 = Uri.parse(r14.d).getLastPathSegment();     // Catch: Throwable -> L24
    L27:
        if (TextUtils.isEmpty(r16) == true) goto L30;
        r15 = r16.endsWith(r11);
    L24:
        th = move-exception;
        th.printStackTrace();
        r16 = null;
        goto L27
    L33:
        return r12;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean d(int r5) {
        b(r5);
        q(r5);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo d(int r5, long r10) {
        DownloadInfo r11 = a(r5);
        if (r11 == null) goto L5;
        r11.c(r10);
        r11.a(-3);
        r11.f15822k0 = false;
        r11.l0 = false;
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void b(DownloadInfo r5) {
        a(r5);
    }

    public List b() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L33
        char[] r10 = DownloadUtils.f16142a;     // Catch: Throwable -> L33
        monitor-exit(DownloadComponentManager.class);
        SparseArray r11 = new SparseArray();
        Iterator r12 = this.f15692a.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L15;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (((Integer) r13.getKey()).intValue() == 0) goto L8;
        if (r13.getValue() == null) goto L8;
        r11.put(((Integer) r13.getKey()).intValue(), r13.getValue());
        goto L8
    L15:
        if (r11.size() != 0) goto L17;
        return null;
    L17:
        int r14 = 0;
    L19:
        if (r14 >= r11.size()) goto L32;
        int r15 = r11.keyAt(r14);
        if (r15 == 0) goto L31;
        DownloadInfo r16 = (DownloadInfo) r11.get(r15);
        if (r16 == null) goto L31;
        r16.n();
        int r17 = r16.V0;
        if (r17 < 1) goto L31;
        if (r17 > 11) goto L31;
        Context r18 = DownloadComponentManager.f15515a;
    L31:
        r14 = r14 + 1;
        goto L19
    L32:
        return null;
    L33:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean a(DownloadInfo r5) {
        h();
        boolean r10 = true;
        if (r5 != null) goto L6;
        return true;
    L6:
        if (this.f15692a.get(Integer.valueOf(r5.l())) != null) goto L9;
        r10 = false;
    L9:
        this.f15692a.put(Integer.valueOf(r5.l()), r5);
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void a() {
        h();
        this.f15692a.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo a(int r5, long r10, String r11, String r12) {
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

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo a(int r5, long r10) {
        DownloadInfo r11 = a(r5);
        if (r11 == null) goto L5;
        r11.c(r10);
        r11.a(-2);
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean a(int r5, Map r10) {
        if (r10 == null) goto L6;
        this.f15693b.put(Integer.valueOf(r5), r10);
        return false;
    L6:
        return false;
    }
}
