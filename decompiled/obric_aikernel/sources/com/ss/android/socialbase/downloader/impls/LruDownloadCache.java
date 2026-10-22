package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jb.u;

/* JADX INFO: loaded from: classes2.dex */
public class LruDownloadCache extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> f7922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HashMap<Integer, Integer> f7923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<DownloadInfo> f7924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private u f7925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final LinkedHashMap<Integer, DownloadInfo> f7926m;

    public LruDownloadCache(u r10) {
        super(r10);
        this.f7922i = new SparseArray();
        this.f7923j = new HashMap();
        this.f7924k = new ArrayList();
        final int r11 = 0;
        final float r12 = 0.75f;
        final boolean r13 = true;
        this.f7926m = new AnonymousClass1(this, r11, r12, r13);
        this.f7925l = r10;
    }

    private void A(int r10, Map<Long, com.ss.android.socialbase.downloader.segment.i> r11) {
        if (r10 != 0) goto L4;
        return;
    L4:
        SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> r12 = this.f7922i;
        monitor-enter(r12);
        this.f7922i.put(r10, r11);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void B(Integer r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.b("LruDownloadCache", "addToUnreadMap", "Key: " + r10);
    L5:
        HashMap<Integer, Integer> r11 = this.f7923j;
        monitor-enter(r11);
        this.f7923j.put(r10, 0);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void C() {
        LinkedHashMap<Integer, DownloadInfo> r10 = this.f7926m;
        monitor-enter(r10);
        this.f7926m.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void D() {
        SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> r10 = this.f7922i;
        monitor-enter(r10);
        this.f7922i.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void F() {
        HashMap<Integer, Integer> r10 = this.f7923j;
        monitor-enter(r10);
        this.f7923j.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private DownloadInfo G(Integer r10) {
        LinkedHashMap<Integer, DownloadInfo> r11 = this.f7926m;
        monitor-enter(r11);
        DownloadInfo r12 = this.f7926m.get(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    private Map<Long, com.ss.android.socialbase.downloader.segment.i> H(Integer r10) {
        SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> r11 = this.f7922i;
        monitor-enter(r11);
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r12 = this.f7922i.get(r10.intValue());     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean I(Integer r10) {
        if (r10.intValue() != 0) goto L6;
        return false;
    L6:
        HashMap<Integer, Integer> r11 = this.f7923j;
        monitor-enter(r11);
        boolean r12 = this.f7923j.containsKey(r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    private void J(Integer r10) {
        LinkedHashMap<Integer, DownloadInfo> r11 = this.f7926m;
        monitor-enter(r11);
        this.f7926m.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void K(Integer r10) {
        SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> r11 = this.f7922i;
        monitor-enter(r11);
        this.f7922i.remove(r10.intValue());     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void L(Integer r10) {
        if (r10.intValue() != 0) goto L5;
        return;
    L5:
        HashMap<Integer, Integer> r11 = this.f7923j;
        monitor-enter(r11);
        this.f7923j.remove(r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void x(LruDownloadCache r10, Integer r11) {
        r10.B(r11);
    }

    private void z(Integer r10, DownloadInfo r11) {
        if (r10.intValue() != 0) goto L5;
        return;
    L5:
        LinkedHashMap<Integer, DownloadInfo> r12 = this.f7926m;
        monitor-enter(r12);
        this.f7926m.put(r10, r11);     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public boolean A0() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo B0(int r10) {
        DownloadInfo r11 = a(r10);
        if (r11 == null) goto L5;
        r11.setStatus(-7);
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo E(int r10) {
        DownloadInfo r11 = a(r10);
        if (r11 == null) goto L5;
        r11.setStatus(5);
        r11.setFirstDownload(false);
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo I0(int r10) {
        DownloadInfo r11 = a(r10);
        if (r11 == null) goto L5;
        r11.setStatus(1);
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public boolean U0(int r10, Map<Long, com.ss.android.socialbase.downloader.segment.i> r11) {
        A(r10, r11);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo V(int r10, long r11) {
        DownloadInfo r12 = a(r10);
        if (r12 == null) goto L5;
        r12.setCurBytes(r11, false);
        r12.setStatus(-1);
        r12.setFirstDownload(false);
    L5:
        return r12;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo a(int r10) {
        w();
        DownloadInfo r11 = null;
        r11 = G(Integer.valueOf(r10));     // Catch: Exception -> L12
        if (r11 == null) goto L6;
    L14:
        return r11;
    L6:
        if (I(Integer.valueOf(r10)) == false) goto L14;
        r11 = this.f7925l.a(r10);     // Catch: Exception -> L12
        if (r11 == null) goto L10;
        z(Integer.valueOf(r10), r11);     // Catch: Exception -> L12
    L10:
        L(Integer.valueOf(r10));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public boolean b(DownloadInfo r10) {
        w();
        boolean r11 = true;
        if (r10 != null) goto L6;
        return true;
    L6:
        if (a(r10.getId()) != null) goto L9;
        r11 = false;
    L9:
        z(Integer.valueOf(r10.getId()), r10);
        L(Integer.valueOf(r10.getId()));
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public void c() {
        w();
        C();
        F();
        D();
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo d0(int r10, long r11) {
        DownloadInfo r12 = a(r10);
        if (r12 == null) goto L5;
        r12.setCurBytes(r11, false);
        r12.setStatus(-3);
        r12.setFirstDownload(false);
        r12.setFirstSuccess(false);
    L5:
        return r12;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public List<DownloadInfo> e(String r10) {
        w();
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        return this.f7925l.e(r10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public List<DownloadInfo> f(String r10) {
        w();
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        return this.f7925l.f(r10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public void f2(int r10) {
        K(Integer.valueOf(r10));
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public List<DownloadInfo> g(String r10) {
        w();
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        return this.f7925l.g(r10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public boolean h(int r10) {
        w();
        J(Integer.valueOf(r10));
        L(Integer.valueOf(r10));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public boolean j(int r10) {
        h(r10);
        f2(r10);
        L(Integer.valueOf(r10));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public List<DownloadInfo> k() {
        w();
        return this.f7925l.k();
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public List<com.ss.android.socialbase.downloader.segment.i> k1(int r10) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r11 = l2(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r11.values());
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public List<DownloadInfo> l(String r10) {
        w();
        return this.f7925l.l(r10);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public Map<Long, com.ss.android.socialbase.downloader.segment.i> l2(int r10) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r11 = H(Integer.valueOf(r10));
        if (r11 != null) goto L9;
        r11 = this.f7925l.l2(r10);
        if (r11 != null) goto L8;
        return null;
    L8:
        A(r10, r11);
    L9:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public List<DownloadInfo> m(String r10, String r11) {
        w();
        return r(this.f7925l.k(), r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f
    public void n(DownloadInfo r10) {
        z(Integer.valueOf(r10.getId()), r10);
        L(Integer.valueOf(r10.getId()));
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo n0(int r10, long r11) {
        DownloadInfo r12 = a(r10);
        if (r12 == null) goto L13;
        r12.setCurBytes(r11, false);
        if (r12.getStatus() == (-3)) goto L13;
        if (r12.getStatus() == (-2)) goto L13;
        if (ab.d.c(r12.getStatus()) == true) goto L13;
        if (r12.getStatus() == (-4)) goto L13;
        r12.setStatus(4);
    L13:
        return r12;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f
    public List<DownloadInfo> q() {
        return this.f7924k;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f
    public List<String> s() {
        jb.k r10 = com.ss.android.socialbase.downloader.downloader.a.w();
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.b();
    }

    @Override // com.ss.android.socialbase.downloader.impls.f
    public HashMap<Integer, Integer> t() {
        return this.f7923j;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo t0(int r10, long r11, String r12, String r13) {
        DownloadInfo r14 = a(r10);
        if (r14 == null) goto L10;
        r14.setTotalBytes(r11);
        r14.seteTag(r12);
        if (TextUtils.isEmpty(r14.getName()) == true) goto L7;
    L9:
        r14.setStatus(3);
        goto L10
    L7:
        if (TextUtils.isEmpty(r13) == true) goto L9;
        r14.setName(r13);
    L10:
        return r14;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public void v(DownloadInfo r10) {
        b(r10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo w0(int r10) {
        DownloadInfo r11 = a(r10);
        if (r11 == null) goto L5;
        r11.setStatus(2);
    L5:
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, jb.i
    public DownloadInfo y(int r10, long r11) {
        DownloadInfo r12 = a(r10);
        if (r12 == null) goto L5;
        r12.setCurBytes(r11, false);
        r12.setStatus(-2);
    L5:
        return r12;
    }
}
