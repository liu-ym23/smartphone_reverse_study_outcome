package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jb.u;

/* JADX INFO: loaded from: classes2.dex */
public class f implements jb.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, DownloadInfo> f7992c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Integer, Map<Long, com.ss.android.socialbase.downloader.segment.i>> f7993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7994h;

    public f(u r10) {
        this.f7992c = new ConcurrentHashMap();
        this.f7993g = new ConcurrentHashMap();
        boolean r11 = false;
        this.f7994h = false;
        if (rb.a.d().optInt("active_load_download_cache") <= 0) goto L5;
        r11 = true;
    L5:
        this.f7994h = r11;
    }

    private boolean o(DownloadInfo r10, String r11, String r12) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L14;
        if (TextUtils.isEmpty(r10.getMimeType()) == true) goto L14;
        if (r11.equals(r10.getMimeType()) == false) goto L14;
        return true;
    L14:
        if (TextUtils.isEmpty(r12) == false) goto L16;
        return false;
    L16:
        if (TextUtils.isEmpty(r10.getUrl()) == true) goto L30;
        String r13 = null;
        r13 = Uri.parse(r10.getUrl()).getLastPathSegment();     // Catch: Throwable -> L20
    L23:
        if (TextUtils.isEmpty(r13) == false) goto L26;
        return false;
    L26:
        return r13.endsWith(r12);
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L30:
        return false;
    }

    @Override // jb.i
    public boolean A0() {
        return false;
    }

    @Override // jb.i
    public DownloadInfo B0(int r10) {
        DownloadInfo r11 = a(r10);
        if (r11 == null) goto L5;
        r11.setStatus(-7);
    L5:
        return r11;
    }

    @Override // jb.i
    public DownloadInfo E(int r10) {
        DownloadInfo r11 = a(r10);
        if (r11 == null) goto L5;
        r11.setStatus(5);
        r11.setFirstDownload(false);
    L5:
        return r11;
    }

    @Override // jb.i
    public DownloadInfo I0(int r10) {
        DownloadInfo r11 = a(r10);
        if (r11 == null) goto L5;
        r11.setStatus(1);
    L5:
        return r11;
    }

    @Override // jb.i
    public boolean U0(int r10, Map<Long, com.ss.android.socialbase.downloader.segment.i> r11) {
        if (r11 == null) goto L6;
        this.f7993g.put(Integer.valueOf(r10), r11);
        return false;
    L6:
        return false;
    }

    @Override // jb.i
    public DownloadInfo V(int r10, long r11) {
        DownloadInfo r12 = a(r10);
        if (r12 == null) goto L5;
        r12.setCurBytes(r11, false);
        r12.setStatus(-1);
        r12.setFirstDownload(false);
    L5:
        return r12;
    }

    @Override // jb.i
    @Nullable
    public DownloadInfo a(int r10) {
        w();
        return this.f7992c.get(Integer.valueOf(r10));
    }

    @Override // jb.i
    public boolean b(DownloadInfo r10) {
        w();
        boolean r11 = true;
        if (r10 != null) goto L6;
        return true;
    L6:
        if (this.f7992c.get(Integer.valueOf(r10.getId())) != null) goto L9;
        r11 = false;
    L9:
        this.f7992c.put(Integer.valueOf(r10.getId()), r10);
        return r11;
    }

    @Override // jb.i
    public void c() {
        w();
        this.f7992c.clear();
    }

    @Override // jb.i
    public boolean d() {
        return false;
    }

    @Override // jb.i
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

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> e(String r10) {
        w();
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        if (this.f7992c.isEmpty() == true) goto L29;
        ArrayList r11 = new ArrayList();
        Iterator<DownloadInfo> r12 = this.f7992c.values().iterator();
    L9:
        if (r12.hasNext() == false) goto L17;
        DownloadInfo r13 = r12.next();
        if (TextUtils.isEmpty(r13.getMimeType()) == true) goto L9;
        if (r13.getMimeType().equals(r10) == false) goto L9;
        if (r13.getStatus() != (-3)) goto L9;
        r11.add(r13);
        goto L9
    L17:
        return r11;
    L29:
        return null;
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> f(String r10) {
        w();
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        if (this.f7992c.isEmpty() == true) goto L29;
        ArrayList r11 = new ArrayList();
        Iterator<DownloadInfo> r12 = this.f7992c.values().iterator();
    L9:
        if (r12.hasNext() == false) goto L17;
        DownloadInfo r13 = r12.next();
        if (r13 == null) goto L9;
        if (TextUtils.isEmpty(r13.getName()) == true) goto L9;
        if (r13.getName().endsWith(r10) == false) goto L9;
        r11.add(r13);
        goto L9
    L17:
        return r11;
    L29:
        return null;
    }

    @Override // jb.i
    public void f2(int r10) {
        this.f7993g.remove(Integer.valueOf(r10));
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> g(String r10) {
        w();
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        if (this.f7992c.isEmpty() == true) goto L33;
        ArrayList r11 = new ArrayList();
        Iterator<DownloadInfo> r12 = this.f7992c.values().iterator();
    L9:
        if (r12.hasNext() == false) goto L19;
        DownloadInfo r13 = r12.next();
        if (r13 == null) goto L9;
        if (TextUtils.isEmpty(r13.getMimeType()) == true) goto L9;
        if (r13.getMimeType().equals(r10) == false) goto L9;
        if (ab.d.g(r13.getStatus()) == false) goto L9;
        r11.add(r13);
        goto L9
    L19:
        return r11;
    L33:
        return null;
    }

    @Override // jb.i
    public boolean h(int r10) {
        w();
        this.f7992c.remove(Integer.valueOf(r10));
        return true;
    }

    @Override // jb.i
    public void i(int r10) {
    }

    @Override // jb.i
    public boolean j(int r10) {
        h(r10);
        f2(r10);
        return true;
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> k() {
        w();
        if (this.f7992c.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r10 = new ArrayList();
        Iterator<DownloadInfo> r11 = this.f7992c.values().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r10.add(r11.next());
        goto L8
    L10:
        return r10;
    }

    @Override // jb.i
    @Nullable
    public List<com.ss.android.socialbase.downloader.segment.i> k1(int r10) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r11 = this.f7993g.get(Integer.valueOf(r10));
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r11.values());
    }

    @Override // jb.i
    public List<DownloadInfo> l(String r10) {
        w();
        ArrayList r11 = new ArrayList();
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r11;
    L5:
        Iterator<DownloadInfo> r12 = this.f7992c.values().iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        DownloadInfo r13 = r12.next();
        if (r10.equals(r13.getUrl()) == false) goto L7;
        r11.add(r13);
        goto L7
    L11:
        return r11;
    }

    @Override // jb.i
    @Nullable
    public Map<Long, com.ss.android.socialbase.downloader.segment.i> l2(int r10) {
        return this.f7993g.get(Integer.valueOf(r10));
    }

    @Override // jb.i
    @Nullable
    public List<DownloadInfo> m(String r10, String r11) {
        w();
        return r(this.f7992c.values(), r10, r11);
    }

    public void n(DownloadInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f7992c.put(Integer.valueOf(r10.getId()), r10);
    }

    @Override // jb.i
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

    public void p(SparseArray<DownloadInfo> r10) {
        Iterator<Map.Entry<Integer, DownloadInfo>> r11 = this.f7992c.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<Integer, DownloadInfo> r12 = r11.next();
        if (r12.getKey().intValue() == 0) goto L4;
        if (r12.getValue() == null) goto L4;
        r10.put(r12.getKey().intValue(), r12.getValue());
        goto L4
    }

    public List<DownloadInfo> q() {
        jb.k r10 = com.ss.android.socialbase.downloader.downloader.a.w();
        if (r10 == null) goto L10;
        List<String> r11 = r10.b();
        if (r11 != null) goto L7;
    L9:
        ArrayList r12 = null;
    L11:
        SparseArray r13 = new SparseArray();
        Iterator<Map.Entry<Integer, DownloadInfo>> r14 = this.f7992c.entrySet().iterator();
    L13:
        if (r14.hasNext() == false) goto L20;
        Map.Entry<Integer, DownloadInfo> r15 = r14.next();
        if (r15.getKey().intValue() == 0) goto L13;
        if (r15.getValue() == null) goto L13;
        r13.put(r15.getKey().intValue(), r15.getValue());
        goto L13
    L20:
        if (r13.size() != 0) goto L22;
        return null;
    L22:
        int r16 = 0;
    L24:
        if (r16 >= r13.size()) goto L53;
        int r17 = r13.keyAt(r16);
        if (r17 == 0) goto L52;
        DownloadInfo r18 = (DownloadInfo) r13.get(r17);
        if (r18 == null) goto L52;
        int r19 = r18.getRealStatus();
        int r20 = r18.getStatusAtDbInit();
        if (r20 >= 1) goto L34;
    L36:
        if (r11 == null) goto L52;
        if (r12 == null) goto L52;
        if (r18.getMimeType() == null) goto L52;
        if (r11.contains(r18.getMimeType()) == false) goto L52;
        if (rb.a.g(r18.getId()).n("enable_notification_ui") < 2) goto L47;
    L51:
        r18.setDownloadFromReserveWifi(false);
        r12.add(r18);
        goto L52
    L47:
        if (r19 != (-2)) goto L51;
        if (r18.isPauseReserveOnWifi() == true) goto L51;
    L34:
        if (r20 > 11) goto L36;
        mb.a.m(com.ss.android.socialbase.downloader.downloader.a.y(), null, r18, null, -5);
    L52:
        r16 = r16 + 1;
        goto L24
    L53:
        return r12;
    L7:
        if (r11.isEmpty() == true) goto L9;
        r12 = new ArrayList();
        goto L11
    L10:
        r11 = null;
        r12 = null;
        goto L11
    }

    protected List<DownloadInfo> r(Collection<DownloadInfo> r10, String r11, String r12) {
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();
        Iterator<DownloadInfo> r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        DownloadInfo r15 = r14.next();
        if (o(r15, r11, r12) == false) goto L8;
        r13.add(r15);
        goto L8
    L12:
        return r13;
    }

    public List<String> s() {
        return null;
    }

    public HashMap<Integer, Integer> t() {
        return null;
    }

    @Override // jb.i
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

    public boolean u() {
        return this.f7994h;
    }

    @Override // jb.i
    public void v(DownloadInfo r10) {
        b(r10);
    }

    protected void w() {
        jb.l r10 = com.ss.android.socialbase.downloader.downloader.a.x();
        if (r10 == null) goto L6;
        r10.a();
    L6:
        if (this.f7994h == true) goto L8;
        return;
    L8:
        if (com.ss.android.socialbase.downloader.utils.g.O() == true) goto L12;
        com.ss.android.socialbase.downloader.downloader.a.o().A0();
        return;
    }

    @Override // jb.i
    @Nullable
    public DownloadInfo w0(int r10) {
        DownloadInfo r11 = a(r10);
        if (r11 == null) goto L5;
        r11.setStatus(2);
    L5:
        return r11;
    }

    @Override // jb.i
    public DownloadInfo y(int r10, long r11) {
        DownloadInfo r12 = a(r10);
        if (r12 == null) goto L5;
        r12.setCurBytes(r11, false);
        r12.setStatus(-2);
    L5:
        return r12;
    }
}
