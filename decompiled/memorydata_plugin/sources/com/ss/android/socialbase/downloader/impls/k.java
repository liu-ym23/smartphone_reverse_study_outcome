package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class k extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> f15504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<Integer, Integer> f15505b;
    private final List<DownloadInfo> c;
    private s d;
    private final LinkedHashMap<Integer, DownloadInfo> e;

    public k(s r5) {
        s r6 = (s) ZeusTransformUtils.wrapperContextForParams(r5, s.class, "com.obric.memorydata.plugin");
        super(r6);
        this.f15504a = new SparseArray();
        this.f15505b = new HashMap();
        this.c = new ArrayList();
        final int r1 = 0;
        final float r2 = 0.75f;
        final boolean r3 = true;
        this.e = new LruDownloadCache$1(this, r1, r2, r3);
        this.d = r6;
    }

    static /* synthetic */ void a(k r0, Integer r1) {
        r0.a(r1);
    }

    private void a(Integer r5) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("LruDownloadCache", "addToUnreadMap", "Key: " + r5);
    L5:
        HashMap<Integer, Integer> r0 = this.f15505b;
        monitor-enter(r0);
        this.f15505b.put(r5, 0);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void a(Integer r2, DownloadInfo r3) {
        if (r2.intValue() != 0) goto L5;
        return;
    L5:
        LinkedHashMap<Integer, DownloadInfo> r0 = this.e;
        monitor-enter(r0);
        this.e.put(r2, r3);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void b(int r3, Map<Long, com.ss.android.socialbase.downloader.segment.i> r4) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r3 != 0) goto L5;
        return;
    L5:
        SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> r0 = this.f15504a;
        monitor-enter(r0);
        this.f15504a.put(r3, r5);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void b(Integer r2) {
        if (r2.intValue() != 0) goto L5;
        return;
    L5:
        HashMap<Integer, Integer> r0 = this.f15505b;
        monitor-enter(r0);
        this.f15505b.remove(r2);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean c(Integer r2) {
        if (r2.intValue() != 0) goto L6;
        return false;
    L6:
        HashMap<Integer, Integer> r0 = this.f15505b;
        monitor-enter(r0);
        boolean r1 = this.f15505b.containsKey(r2);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private void d(Integer r2) {
        SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> r0 = this.f15504a;
        monitor-enter(r0);
        this.f15504a.remove(r2.intValue());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Map<Long, com.ss.android.socialbase.downloader.segment.i> e(Integer r3) {
        SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> r0 = this.f15504a;
        monitor-enter(r0);
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r2 = (Map) ZeusTransformUtils.preCheckCast(this.f15504a.get(r3.intValue()), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private void f(Integer r2) {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.e;
        monitor-enter(r0);
        this.e.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private DownloadInfo g(Integer r3) {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.e;
        monitor-enter(r0);
        DownloadInfo r2 = (DownloadInfo) ZeusTransformUtils.preCheckCast(this.e.get(r3), DownloadInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private void k() {
        HashMap<Integer, Integer> r0 = this.f15505b;
        monitor-enter(r0);
        this.f15505b.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void l() {
        SparseArray<Map<Long, com.ss.android.socialbase.downloader.segment.i>> r0 = this.f15504a;
        monitor-enter(r0);
        this.f15504a.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void m() {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.e;
        monitor-enter(r0);
        this.e.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
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

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
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

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a() {
        j();
        return this.d.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String r1) {
        j();
        return this.d.a(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> a(String r2, String r3) {
        j();
        return a(this.d.a(), r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public void a(double r7) {
        j();
        if (r7 > 0.0d) goto L5;
        return;
    L5:
        if (r7 > 1.0d) goto L36;
        LinkedHashMap<Integer, DownloadInfo> r0 = this.e;
        monitor-enter(r0);
        int r8 = (int) (((double) this.e.size()) * r7);     // Catch: Throwable -> L26
        int r9 = 0;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L12;
        com.ss.android.socialbase.downloader.e.a.a("LruDownloadCache", "clearMemoryCacheData", "Before LruDownloadInfoMap Size:" + this.e.size() + " ClearSize:" + r8);     // Catch: Throwable -> L26
    L12:
        Iterator<Map.Entry<Integer, DownloadInfo>> r1 = this.e.entrySet().iterator();     // Catch: Throwable -> L26
    L14:
        if (r1.hasNext() == false) goto L22;
        if (r9 >= r8) goto L22;
        if (com.ss.android.socialbase.downloader.downloader.b.F().a(((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue()) == true) goto L20;
        r1.remove();     // Catch: Throwable -> L26
    L20:
        r9 = r9 + 1;     // Catch: Throwable -> L26
    L22:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L24;
        com.ss.android.socialbase.downloader.e.a.a("LruDownloadCache", "clearMemoryCacheData", "End LruDownloadInfoMap Size:" + this.e.size());     // Catch: Throwable -> L26
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public boolean a(int r3, Map<Long, com.ss.android.socialbase.downloader.segment.i> r4) {
        b(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public boolean a(DownloadInfo r3) {
        j();
        boolean r0 = true;
        if (r3 != null) goto L6;
        return true;
    L6:
        if (b(r3.getId()) != null) goto L9;
        r0 = false;
    L9:
        a(Integer.valueOf(r3.getId()), r3);
        b(Integer.valueOf(r3.getId()));
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(int r3) {
        j();
        DownloadInfo r0 = null;
        r0 = g(Integer.valueOf(r3));     // Catch: Exception -> L12
        if (r0 == null) goto L6;
    L14:
        return r0;
    L6:
        if (c(Integer.valueOf(r3)) == false) goto L14;
        r0 = this.d.b(r3);     // Catch: Exception -> L12
        if (r0 == null) goto L10;
        a(Integer.valueOf(r3), r0);     // Catch: Exception -> L12
    L10:
        b(Integer.valueOf(r3));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo b(int r1, long r2) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-1);
        r0.setFirstDownload(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> b(String r2) {
        j();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.d.b(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public void b() {
        j();
        m();
        k();
        l();
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public void b(DownloadInfo r1) {
        a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
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

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> c(String r2) {
        j();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.d.c(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f
    public void c(DownloadInfo r2) {
        a(Integer.valueOf(r2.getId()), r2);
        b(Integer.valueOf(r2.getId()));
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public boolean c() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public boolean c(int r2) {
        j();
        f(Integer.valueOf(r2));
        b(Integer.valueOf(r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo d(int r1, long r2) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-2);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public List<DownloadInfo> d(String r2) {
        j();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.d.d(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public boolean d(int r1) {
        c(r1);
        l(r1);
        b(Integer.valueOf(r1));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo e(int r1) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setStatus(2);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f
    public HashMap<Integer, Integer> e() {
        return this.f15505b;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo f(int r1) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setStatus(5);
        r0.setFirstDownload(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f
    public List<DownloadInfo> f() {
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo g(int r1) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setStatus(1);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public DownloadInfo h(int r1) {
        DownloadInfo r0 = b(r1);
        if (r0 == null) goto L5;
        r0.setStatus(-7);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f
    public List<String> h() {
        com.ss.android.socialbase.downloader.downloader.j r0 = com.ss.android.socialbase.downloader.downloader.b.B();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public Map<Long, com.ss.android.socialbase.downloader.segment.i> k(int r2) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r0 = e(Integer.valueOf(r2));
        if (r0 != null) goto L9;
        r0 = this.d.k(r2);
        if (r0 != null) goto L8;
        return null;
    L8:
        b(r2, r0);
    L9:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public void l(int r1) {
        d(Integer.valueOf(r1));
    }

    @Override // com.ss.android.socialbase.downloader.impls.f, com.ss.android.socialbase.downloader.downloader.h
    public List<com.ss.android.socialbase.downloader.segment.i> m(int r1) {
        Map<Long, com.ss.android.socialbase.downloader.segment.i> r0 = k(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r0.values());
    }
}
