package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class f implements com.ss.android.socialbase.downloader.downloader.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, DownloadInfo> f15495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, Map<Long, com.ss.android.socialbase.downloader.segment.i>> f15496b;
    private boolean c;

    public f(s r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        this.f15495a = new ConcurrentHashMap();
        this.f15496b = new ConcurrentHashMap();
        boolean r5 = false;
        this.c = false;
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("active_load_download_cache") <= 0) goto L5;
        r5 = true;
    L5:
        this.c = r5;
    }

    private boolean a(DownloadInfo r2, String r3, String r4) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (TextUtils.isEmpty(r2.getMimeType()) == true) goto L14;
        if (r3.equals(r2.getMimeType()) == false) goto L14;
        return true;
    L14:
        if (TextUtils.isEmpty(r4) == false) goto L16;
        return false;
    L16:
        if (TextUtils.isEmpty(r2.getUrl()) == true) goto L30;
        String r5 = null;
        r5 = Uri.parse(r2.getUrl()).getLastPathSegment();     // Catch: Throwable -> L20
    L23:
        if (TextUtils.isEmpty(r5) == false) goto L26;
        return false;
    L26:
        return r5.endsWith(r4);
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L30:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo a(int r1, long r2) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L13;
        r0.setCurBytes(r2, false);
        if (r0.getStatus() == (-3)) goto L13;
        if (r0.getStatus() == (-2)) goto L13;
        if (DownloadStatus.isFailedStatus(r0.getStatus()) == true) goto L13;
        if (r0.getStatus() == (-4)) goto L13;
        r0.setStatus(4);
    L13:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo a(int r1, long r2, String r4, String r5) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L10;
        r0.setTotalBytes(r2);
        r0.seteTag(r4);
        if (TextUtils.isEmpty(r0.getName()) == true) goto L7;
    L9:
        r0.setStatus(3);
        goto L10
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        r0.setName(r5);
    L10:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a() {
        j();
        if (this.f15495a.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r4 = this.f15495a.values().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add((DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String r5) {
        j();
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return r0;
    L5:
        Iterator<DownloadInfo> r4 = this.f15495a.values().iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r5.equals(r1.getUrl()) == false) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String r2, String r3) {
        j();
        return a(this.f15495a.values(), r2, r3);
    }

    public List<DownloadInfo> a(Collection<DownloadInfo> r5, String r6, String r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        DownloadInfo r2 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r9.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (a(r2, r6, r7) == false) goto L8;
        r0.add(r2);
        goto L8
    L12:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(double r8) {
        j();
        if (r8 > 0.0d) goto L5;
        return;
    L5:
        if (r8 > 1.0d) goto L30;
        int r9 = (int) (((double) this.f15495a.size()) * r8);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L10;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCache", "clearMemoryCacheData", "Before DownloadInfoMap Size:" + this.f15495a.size() + " ClearSize:" + r9);
    L10:
        int r10 = 0;
        Iterator<Map.Entry<Integer, DownloadInfo>> r2 = this.f15495a.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        if (r10 >= r9) goto L19;
        if (com.ss.android.socialbase.downloader.downloader.b.F().a(((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue()) == true) goto L12;
        r2.remove();
        r10 = r10 + 1;
    L19:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L29;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCache", "clearMemoryCacheData", "End DownloadInfoMap Size:" + this.f15495a.size());
        return;
    L29:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(SparseArray<DownloadInfo> r5) {
        Iterator<Map.Entry<Integer, DownloadInfo>> r4 = this.f15495a.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L4;
        if (r0.getValue() == null) goto L4;
        r5.put(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r0.getValue());
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean a(int r3, Map<Long, com.ss.android.socialbase.downloader.segment.i> r4) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        this.f15496b.put(Integer.valueOf(r3), r5);
        return false;
    L7:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean a(DownloadInfo r4) {
        j();
        boolean r0 = true;
        if (r4 != null) goto L6;
        return true;
    L6:
        if (this.f15495a.get(Integer.valueOf(r4.getId())) != null) goto L9;
        r0 = false;
    L9:
        this.f15495a.put(Integer.valueOf(r4.getId()), r4);
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(int r2) {
        j();
        return (DownloadInfo) ZeusTransformUtils.preCheckCast(this.f15495a.get(Integer.valueOf(r2)), DownloadInfo.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(int r1, long r2) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-1);
        r0.setFirstDownload(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> b(String r5) {
        j();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.f15495a.isEmpty() == true) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r4 = this.f15495a.values().iterator();
    L9:
        if (r4.hasNext() == false) goto L17;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r1.getMimeType()) == true) goto L9;
        if (r1.getMimeType().equals(r5) == false) goto L9;
        if (r1.getStatus() != (-3)) goto L9;
        r0.add(r1);
        goto L9
    L17:
        return r0;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b() {
        j();
        this.f15495a.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void b(DownloadInfo r1) {
        a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo c(int r1, long r2) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-3);
        r0.setFirstDownload(false);
        r0.setFirstSuccess(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> c(String r5) {
        j();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.f15495a.isEmpty() == true) goto L33;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r4 = this.f15495a.values().iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        if (TextUtils.isEmpty(r1.getMimeType()) == true) goto L9;
        if (r1.getMimeType().equals(r5) == false) goto L9;
        if (DownloadStatus.isUnCompletedStatus(r1.getStatus()) == false) goto L9;
        r0.add(r1);
        goto L9
    L19:
        return r0;
    L33:
        return null;
    }

    public void c(DownloadInfo r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f15495a.put(Integer.valueOf(r2.getId()), r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean c() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean c(int r1) {
        j();
        this.f15495a.remove(Integer.valueOf(r1));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo d(int r1, long r2) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-2);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> d(String r5) {
        j();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.f15495a.isEmpty() == true) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r4 = this.f15495a.values().iterator();
    L9:
        if (r4.hasNext() == false) goto L17;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        if (TextUtils.isEmpty(r1.getName()) == true) goto L9;
        if (r1.getName().endsWith(r5) == false) goto L9;
        r0.add(r1);
        goto L9
    L17:
        return r0;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean d(int r1) {
        c(r1);
        l(r1);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo e(int r1) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setStatus(2);
    L5:
        return r0;
    }

    public HashMap<Integer, Integer> e() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo f(int r1) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setStatus(5);
        r0.setFirstDownload(false);
    L5:
        return r0;
    }

    public List<DownloadInfo> f() {
        com.ss.android.socialbase.downloader.downloader.j r0 = com.ss.android.socialbase.downloader.downloader.b.B();
        if (r0 == null) goto L10;
        List<String> r1 = r0.a();
        if (r1 != null) goto L7;
    L9:
        ArrayList r2 = null;
    L11:
        SparseArray r3 = new SparseArray();
        Iterator<Map.Entry<Integer, DownloadInfo>> r10 = this.f15495a.entrySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L13;
        if (r4.getValue() == null) goto L13;
        r3.put(((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r4.getValue());
        goto L13
    L20:
        if (r3.size() != 0) goto L22;
        return null;
    L22:
        int r5 = 0;
    L24:
        if (r5 >= r3.size()) goto L53;
        int r6 = r3.keyAt(r5);
        if (r6 == 0) goto L52;
        DownloadInfo r7 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r3.get(r6), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L52;
        int r8 = r7.getRealStatus();
        int r9 = r7.getStatusAtDbInit();
        if (r9 >= 1) goto L34;
    L36:
        if (r1 == null) goto L52;
        if (r2 == null) goto L52;
        if (r7.getMimeType() == null) goto L52;
        if (r1.contains(r7.getMimeType()) == false) goto L52;
        if (com.ss.android.socialbase.downloader.g.a.a(r7.getId()).b("enable_notification_ui") < 2) goto L47;
    L51:
        r7.setDownloadFromReserveWifi(false);
        r2.add(r7);
        goto L52
    L47:
        if (r8 != (-2)) goto L51;
        if (r7.isPauseReserveOnWifi() == true) goto L51;
    L34:
        if (r9 > 11) goto L36;
        com.ss.android.socialbase.downloader.f.a.a(com.ss.android.socialbase.downloader.downloader.b.f(), null, r7, null, -5);
    L52:
        r5 = r5 + 1;
        goto L24
    L53:
        return r2;
    L7:
        if (r1.isEmpty() == true) goto L9;
        r2 = new ArrayList();
        goto L11
    L10:
        r1 = null;
        r2 = null;
        goto L11
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo g(int r1) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setStatus(1);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void g() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo h(int r1) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setStatus(-7);
    L5:
        return r0;
    }

    public List<String> h() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void i(int r1) {
    }

    public boolean i() {
        return this.c;
    }

    public void j() {
        com.ss.android.socialbase.downloader.downloader.k r0 = com.ss.android.socialbase.downloader.downloader.b.J();
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (this.c == true) goto L8;
        return;
    L8:
        if (com.ss.android.socialbase.downloader.utils.g.a() == true) goto L12;
        com.ss.android.socialbase.downloader.downloader.b.C().d();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public Map<Long, com.ss.android.socialbase.downloader.segment.i> k(int r2) {
        return (Map) ZeusTransformUtils.preCheckCast(this.f15496b.get(Integer.valueOf(r2)), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void l(int r1) {
        this.f15496b.remove(Integer.valueOf(r1));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public List<com.ss.android.socialbase.downloader.segment.i> m(int r2) {
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.f15496b.get(Integer.valueOf(r2)), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r1.values());
    }
}
