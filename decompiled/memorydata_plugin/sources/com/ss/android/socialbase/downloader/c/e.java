package com.ss.android.socialbase.downloader.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.i;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes6.dex */
public class e extends c.a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15291a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile HashMap<String, Integer> f15292b;
    private static volatile SQLiteDatabase d;
    private static final int h = 0;
    private static final boolean l = false;
    b c;
    private g e;
    private g f;
    private volatile boolean g;
    private int i;
    private long j;
    private boolean k;

    private interface a<T> {
        T b();
    }

    static {
        f15291a = k();
        f15292b = null;
        h = l();
        l = m();
    }

    public e() {
        this(false);
    }

    public e(boolean r3) {
        this.k = false;
        this.c = null;
        if (r3 == true) goto L5;
        return;
    L5:
        this.g = false;
        a(false);
    }

    static /* synthetic */ int a(e r0, int r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ long a(e r0, long r1) {
        r0.j = r1;
        return r1;
    }

    private <T> T a(Callable<T> r5, a<T> r6) {
        Callable<T> r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.memorydata.plugin");
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        int r8 = h;
        if (r8 > 0) goto L5;
    L24:
        return r4.call();
    L14:
        th = th;
        th.printStackTrace();
        StringBuilder r9 = new StringBuilder();
        String r2 = "Call Error: ";
    L16:
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "runImpl", r9.append(r2).append(th).toString());
        if (r7 != null) goto L19;
        return null;
    L19:
        return (T) r7.b();
    L5:
        if (com.ss.android.socialbase.downloader.utils.g.a() == false) goto L24;
        return com.ss.android.socialbase.downloader.downloader.b.s().submit(r4).get(r8, TimeUnit.MILLISECONDS);
    L10:
        th = th;
        th.printStackTrace();
        r9 = new StringBuilder();
        r2 = "Get Error: ";
        goto L16
    }

    static /* synthetic */ List a(e r0, String r1) {
        return r0.g(r1);
    }

    private void a(int r8, ContentValues r9) {
        int r1 = 10;
    L17:
    L14:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r8, "updateInner", "Error2:" + th);
        return;
    L4:
        if (d.isDbLockedByCurrentThread() == false) goto L12;
        r1 = r1 - 1;
        if (r1 < 0) goto L12;
        Thread.sleep(5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r8, "updateInner", "Error:" + th);     // Catch: Throwable -> L14
    L12:
        d.update("downloader", r9, "_id = ? ", new String[]{String.valueOf(r8)});     // Catch: Throwable -> L14
    }

    private void a(int r4, SQLiteStatement r5) {
        if (r5 != null) goto L15;
        return;
    L15:
        monitor-enter(r5);     // Catch: Throwable -> L12
        r5.bindLong(1, r4);     // Catch: Throwable -> L9
        r5.execute();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
    L18:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r4, "deleteInner", "Error:" + th);
    }

    static /* synthetic */ void a(e r0) {
        r0.o();
    }

    static /* synthetic */ void a(e r0, int r1, ContentValues r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(e r0, int r1, SQLiteStatement r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(e r0, DownloadInfo r1) {
        r0.c(r1);
    }

    static /* synthetic */ void a(e r0, DownloadInfo r1, SQLiteStatement r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(e r10, com.ss.android.socialbase.downloader.model.c r11, SparseArray r12, HashMap r13, List r14, List r15, d r16, com.ss.android.socialbase.downloader.cleaner.a r17) {
        r10.a(r11, r12, r13, (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r16, d.class, "com.obric.memorydata.plugin"), r17);
    }

    static /* synthetic */ void a(e r2, List r3) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(e r2, List r3, SparseArray r4) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    private void a(DownloadInfo r4, SQLiteStatement r5) {
        if (r4 == null) goto L18;
        if (r5 == null) goto L20;
        monitor-enter(r5);     // Catch: Throwable -> L12
        r4.bindValue(r5);     // Catch: Throwable -> L9
        r5.executeInsert();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r4.getId(), "insertDownloadInfoInner", "Error:" + th);
        return;
    L20:
        return;
    }

    private void a(com.ss.android.socialbase.downloader.model.c r36, SparseArray<DownloadInfo> r37, HashMap<Integer, Integer> r38, List<DownloadInfo> r39, List<String> r40, d r41, com.ss.android.socialbase.downloader.cleaner.a r42) {
        r36 = r36;
        List<DownloadInfo> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r40, List.class, "com.obric.memorydata.plugin");
        d r14 = (d) ZeusTransformUtils.wrapperContextForParams(r41, d.class, "com.obric.memorydata.plugin");
        SparseArray<DownloadInfo> r15 = new SparseArray();
        ArrayList r8 = new ArrayList();
        if (com.ss.android.socialbase.downloader.g.a.c().b("sql_download_cache_time_opt") <= 0) goto L5;
        boolean r16 = true;
    L7:
        if (com.ss.android.socialbase.downloader.g.a.c().b("remove_download_success_and_not_exists") <= 0) goto L9;
        boolean r17 = true;
    L11:
        if (com.ss.android.socialbase.downloader.g.a.c().b("remove_external_public_dir_task_for_q") <= 0) goto L13;
        boolean r18 = true;
    L15:
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("remove_useless_monitor_report", 0) <= 0) goto L17;
        boolean r19 = true;
    L19:
        if (com.ss.android.socialbase.downloader.g.a.c().b("clean_installed_apk") <= 0) goto L21;
        boolean r20 = true;
    L22:
        long r21 = com.ss.android.socialbase.downloader.g.a.c().c("incomplete_file_expired_time");
        if (com.ss.android.socialbase.downloader.g.a.c().b("async_db_clean") <= 0) goto L25;
        boolean r23 = true;
    L26:
        Set<String> r4 = com.ss.android.socialbase.downloader.utils.c.d();
        Set<String> r5 = com.ss.android.socialbase.downloader.utils.c.e();
        Set<String> r3 = com.ss.android.socialbase.downloader.utils.c.f();
        Cursor r1 = null;
        r1 = d.rawQuery("SELECT * FROM downloader", null);     // Catch: Throwable -> L225
        if (r13 == null) goto L33;
        if (r38 == null) goto L33;
        n();     // Catch: Throwable -> L40
        int r2 = r1.getCount();     // Catch: Throwable -> L40
        int r6 = f15291a;     // Catch: Throwable -> L40
        if (r2 <= r6) goto L33;
        int r7 = r1.getCount() - r6;     // Catch: Throwable -> L40
    L34:
        if (r16 == true) goto L36;
    L42:
        n r9 = null;
        boolean r25 = true;
    L256:
        r36.f15566b = r1.getCount();     // Catch: Throwable -> L222
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L52;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "newBatchInit", "DownloadInfo Count:" + r36.f15566b);     // Catch: Throwable -> L47
    L52:
        int r27 = r7;
        int r28 = 0;
    L53:
        if (r1.moveToNext() == false) goto L215;
        DownloadInfo r10 = com.ss.android.socialbase.downloader.utils.c.a(r1);     // Catch: Throwable -> L211
        long r11 = r10.getCurBytes();     // Catch: Throwable -> L211
        if (r11 <= 0) goto L62;
        r36.d += r11;     // Catch: Throwable -> L47
    L47:
        th = th;
        r8 = r8;
        List<DownloadInfo> r29 = r13;
        r14 = r14;
    L50:
        int r31 = 0;
    L250:
        th.printStackTrace();     // Catch: Throwable -> L235
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "newBatchInit", "Error:" + th);     // Catch: Throwable -> L235
        Cursor[] r12 = new Cursor[1];
        r12[r31] = r1;
        com.ss.android.socialbase.downloader.utils.g.a(r12);
        r();
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L231;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "newBatchInit", "Run End");
    L231:
        a(true, r8, r15, r37, r38, r29, r14);
        this.g = true;
        r36.f15565a = System.currentTimeMillis() - r36.f15565a;
        r36.c = r37.size();
        com.ss.android.socialbase.downloader.f.a.a(r36);
        m r22 = com.ss.android.socialbase.downloader.downloader.b.K();
        if (r22 != null) goto L220;
    L221:
        r42.c();
        return;
    L220:
        r22.a(r36);
    L235:
        th = move-exception;
        Cursor[] r24 = new Cursor[1];
        r24[r31] = r1;
        com.ss.android.socialbase.downloader.utils.g.a(r24);
        r();
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L239;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "newBatchInit", "Run End");
    L239:
        a(true, r8, r15, r37, r38, r29, r14);
        this.g = true;
        r36.f15565a = System.currentTimeMillis() - r36.f15565a;
        r36.c = r37.size();
        com.ss.android.socialbase.downloader.f.a.a(r36);
        m r26 = com.ss.android.socialbase.downloader.downloader.b.K();
        if (r26 == null) goto L242;
        r26.a(r36);
    L242:
        r42.c();
        throw th;
    L62:
        Set<String> r30 = r3;
        r4 = r4;
        List r210 = r0;
        r3 = r30;
        r14 = r14;
        r5 = r5;
        List<DownloadInfo> r32 = r13;
    L209:
        th = th;
        r29 = r32;
    L213:
        r31 = 0;
    L214:
        r36 = r36;
    L224:
        r1 = r1;
        goto L250
    L64:
        if (a(r10, r18, r21, r23) == true) goto L65;
        if (r23 == false) goto L83;
        if (r10.getCacheLifeTimeMax() != 0) goto L83;
        r42.a(r10);     // Catch: Throwable -> L80
    L83:
        if (com.ss.android.socialbase.downloader.utils.c.a(r4, r5, r3, r10.getMimeType(), r10.getMonitorScene()) == true) goto L84;
        if (r19 == true) goto L90;
        r10.setStatusAtDbInit(r10.getRealStatus());     // Catch: Throwable -> L80
    L90:
        if (r10.isCanResumeFromBreakPointStatus() == false) goto L96;
        r10.setDBInitStatus(r10.getStatus());     // Catch: Throwable -> L80
        r10.setStatus(-5);     // Catch: Throwable -> L80
        if (r16 == false) goto L96;
        if (r19 == true) goto L96;
        r15.put(r10.getId(), r10);     // Catch: Throwable -> L80
    L96:
        if (TextUtils.isEmpty(r10.getSavePath()) == false) goto L98;
    L127:
        boolean r33 = true;
    L128:
        if (r33 == true) goto L129;
        if (r16 == false) goto L137;
        if (r25 == true) goto L140;
        int r34 = r10.getId();     // Catch: Throwable -> L80
        int r35 = r9.a(r10);     // Catch: Throwable -> L80
        if (r35 == r34) goto L140;
        r10.setId(r35);     // Catch: Throwable -> L80
    L135:
        r15.put(r34, r10);     // Catch: Throwable -> L80
    L140:
        if (r23 == false) goto L142;
    L144:
        if (r32 == null) goto L198;
        if (r38 == null) goto L198;
        if (r19 == true) goto L148;
        c(r10);     // Catch: Throwable -> L80
    L148:
        if (r210 != null) goto L150;
    L165:
        List r43 = r210;
    L166:
        r29 = r32;
    L167:
        if (r27 <= 0) goto L197;
        int r211 = r27 - 1;
        if (r27 <= 0) goto L196;
    L194:
        th = th;
        r29 = r29;
        goto L213
    L171:
        if (f(r10.getUrl()) == true) goto L196;
        monitor-enter(r38);     // Catch: Throwable -> L194
        r38.put(Integer.valueOf(r10.getId()), 0);     // Catch: Throwable -> L186
        monitor-exit(r38);     // Catch: Throwable -> L186
        int r44 = r28 + 1;
        if (r44 >= this.i) goto L180;
        r28 = r44;
        r13 = r29;
        r27 = r211;
        r0 = r43;
        goto L53
    L180:
        List<DownloadInfo> r212 = r29;
        List r310 = r43;
        n r311 = r9;
        ArrayList r312 = r8;
        a(false, r8, r15, r37, r38, r212, r14);     // Catch: Throwable -> L207
        r27 = r211;
        r13 = r212;
        r28 = 0;
        r9 = r311;
        r8 = r312;
        r0 = r310;
    L184:
        th = th;
        r29 = r29;
        r8 = r8;
        r31 = 0;
    L186:
        th = th;
        r31 = 0;
    L272:
        monitor-exit(r38);     // Catch: Throwable -> L192
        throw th;     // Catch: Throwable -> L207
    L207:
        th = th;
    L192:
        th = th;
    L188:
        th = th;
        r31 = 0;
    L196:
        r29 = r29;
        List r313 = r43;
        r9 = r9;
        r8 = r8;
        r31 = 0;
        r27 = r211;
    L200:
        r37.put(r10.getId(), r10);     // Catch: Throwable -> L207
    L274:
        int r45 = r28 + 1;     // Catch: Throwable -> L207
        if (r45 < this.i) goto L205;
        a(false, r8, r15, r37, r38, r29, r14);     // Catch: Throwable -> L207
        r28 = r31;
    L206:
        r13 = r29;
        r0 = r313;
        r9 = r9;
        r8 = r8;
        goto L53
    L205:
        r28 = r45;
        goto L206
    L197:
        r29 = r29;
        r313 = r43;
    L199:
        r31 = 0;
        goto L200
    L150:
        if (r210.isEmpty() == true) goto L165;
        String r46 = r10.getMimeType();     // Catch: Throwable -> L80
        r43 = r210;
        if (r43.contains(r46) == false) goto L166;
        int r47 = r10.getRealStatus();     // Catch: Throwable -> L80
        if (com.ss.android.socialbase.downloader.g.a.a(r10).b("enable_notification_ui") < 2) goto L156;
    L160:
        r29 = r32;
        r29.add(r10);     // Catch: Throwable -> L163
    L163:
        th = th;
        r36 = r36;
        r29 = r29;
        r8 = r8;
        goto L50
    L156:
        if (r47 != (-2)) goto L160;
        if (r10.isPauseReserveOnWifi() == true) goto L160;
    L198:
        r313 = r210;
        r29 = r32;
        goto L199
    L142:
        if (r10.getCacheLifeTimeMax() != 0) goto L144;
        r42.a(r10);     // Catch: Throwable -> L80
        goto L144
    L137:
        r34 = r10.getId();     // Catch: Throwable -> L209
        int r48 = ((n) ZeusTransformUtils.preCheckCast(k.a(n.class), n.class, "com.obric.memorydata.plugin")).a(r10);     // Catch: Throwable -> L209
        if (r48 == r34) goto L140;
        r10.setId(r48);     // Catch: Throwable -> L80
        goto L135
    L129:
        r8.add(r10);     // Catch: Throwable -> L80
        r9 = r9;
        r8 = r8;
        r313 = r210;
        r29 = r32;
        r31 = 0;
        goto L274
    L98:
        if (TextUtils.isEmpty(r10.getName()) == true) goto L127;
        if (r10.getStatus() != 1) goto L106;
        if (r10.getCurBytes() > 0) goto L106;
        boolean r49 = true;
    L114:
        if (r10.getStatus() != 11) goto L116;
        r10.setStatus(-5);     // Catch: Throwable -> L80
    L116:
        if (r20 == false) goto L119;
        r33 = a(r10, r17, r49, r42, r23);     // Catch: Throwable -> L80
        goto L128
    L119:
        if (com.ss.android.socialbase.downloader.utils.g.a(r10.getStatus(), r10.getSavePath(), r10.getName()) == true) goto L121;
    L126:
        r33 = r49;
        goto L128
    L121:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L123;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", r10, "run", "Download success and file not exist");     // Catch: Throwable -> L80
    L123:
        if (r17 == true) goto L127;
        r10.erase();     // Catch: Throwable -> L80
    L106:
        if (r10.getStatus() != (-3)) goto L108;
    L112:
        r49 = false;
        goto L114
    L108:
        if (r10.getStatus() == 11) goto L112;
        if (r10.isFileDataValid() == true) goto L112;
        r10.reset();     // Catch: Throwable -> L80
        goto L112
    L84:
        if (r27 > 0) goto L85;
    L74:
        r13 = r32;
        r0 = r210;
        goto L53
    L85:
        r27 = r27 - 1;
        goto L74
    L65:
        if (r27 <= 0) goto L67;
        r27 = r27 - 1;
    L67:
        if (r23 == true) goto L254;
        d(r10.getId());     // Catch: Throwable -> L80
    L80:
        th = th;
        r36 = r36;
        r8 = r8;
        r29 = r32;
        goto L50
    L254:
        r42.a(r10, false);     // Catch: Throwable -> L71
    L71:
        th = th;
        r36 = r36;
        r8 = r8;
        r29 = r32;
        r31 = 0;
    L211:
        th = th;
        r29 = r13;
        r14 = r14;
        goto L213
    L215:
        ArrayList r314 = r8;
        List<DownloadInfo> r213 = r13;
        d r410 = r14;
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r1});
        r();
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L218;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "newBatchInit", "Run End");
    L218:
        a(true, r314, r15, r37, r38, r213, r410);
        this.g = true;
        r36 = r36;
        r36.f15565a = System.currentTimeMillis() - r36.f15565a;
        r36.c = r37.size();
        com.ss.android.socialbase.downloader.f.a.a(r36);
        r22 = com.ss.android.socialbase.downloader.downloader.b.K();
        if (r22 == null) goto L221;
    L222:
        th = th;
        r8 = r8;
        r29 = r13;
        r14 = r14;
        r31 = 0;
        goto L224
    L36:
        if (r1.getCount() <= 0) goto L42;
        n r50 = (n) ZeusTransformUtils.preCheckCast(k.a(n.class), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        r9 = r50;
        r25 = r50.a();     // Catch: Throwable -> L47
    L40:
        th = th;
        r31 = 0;
        r8 = r8;
        r29 = r13;
        r14 = r14;
    L33:
        r7 = 0;
    L225:
        th = th;
        r31 = 0;
        r8 = r8;
        r29 = r13;
        r14 = r14;
        goto L250
    L25:
        r23 = false;
        goto L26
    L21:
        r20 = false;
        goto L22
    L17:
        r19 = false;
        goto L19
    L13:
        r18 = false;
        goto L15
    L9:
        r17 = false;
        goto L11
    L5:
        r16 = false;
        goto L7
    }

    private void a(List<DownloadInfo> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L17;
        return;
    L17:
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L14
    L7:
        if (r4.hasNext() == false) goto L26;
        DownloadInfo r5 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r5 == null) goto L7;
        if (r5.isSavePathRedirected() == false) goto L7;
        com.ss.android.socialbase.downloader.utils.g.d(r5);     // Catch: Throwable -> L14
        goto L7
    L26:
        return;
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "clearAntiHijackDirIfNeeded", "Error:" + th);
    }

    private void a(List<DownloadInfo> r11, SparseArray<DownloadInfo> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        int r0 = r12.size();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (d == null) goto L40;
        SQLiteDatabase r1 = d;
        monitor-enter(r1);
        q();     // Catch: Throwable -> L22
        if (r13.isEmpty() == true) goto L16;
        String[] r2 = new String[r13.size()];     // Catch: Throwable -> L22
        int r5 = 0;
    L13:
        if (r5 >= r13.size()) goto L15;
        r2[r5] = String.valueOf(((DownloadInfo) ZeusTransformUtils.preCheckCast(r13.get(r5), DownloadInfo.class, "com.obric.memorydata.plugin")).getId());     // Catch: Throwable -> L22
        r5 = r5 + 1;     // Catch: Throwable -> L22
        goto L13
    L15:
        d.delete("downloader", "CAST(_id AS TEXT) IN (" + new String(new char[r13.size() - 1]).replace("\u0000", "?,") + "?)", r2);     // Catch: Throwable -> L22
    L16:
        int r14 = 0;
    L17:
        if (r14 >= r0) goto L19;
        int r3 = r12.keyAt(r14);     // Catch: Throwable -> L22
        DownloadInfo r6 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r12.get(r3), DownloadInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        d.delete("downloader", "_id = ?", new String[]{String.valueOf(r3)});     // Catch: Throwable -> L22
        d.insert("downloader", null, com.ss.android.socialbase.downloader.utils.c.c(r6));     // Catch: Throwable -> L22
        r14 = r14 + 1;     // Catch: Throwable -> L22
        goto L17
    L19:
        d.setTransactionSuccessful();     // Catch: Throwable -> L22
    L20:
        t();     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "loadCacheFromDB", "Error:" + th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        t();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    }

    private void a(boolean r7, List<DownloadInfo> r8, SparseArray<DownloadInfo> r9, SparseArray<DownloadInfo> r10, HashMap<Integer, Integer> r11, List<DownloadInfo> r12, d r13) {
        List<DownloadInfo> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<DownloadInfo> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        d r16 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "callbackDownloadInfo", "Run");
    L5:
        a(r14);
        a(r14, r9);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "callbackDownloadInfo", "Run Callback:" + r16);
    L8:
        if (r16 == null) goto L10;
        r16.a(r7);
    L10:
        a(r10, r11, r15, r7);
        r9.clear();
        r14.clear();
        r10.clear();
        if (r7 == false) goto L21;
        return;
    L21:
    L18:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "newInit", "Sleep:" + th);
        return;
    L14:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "newInit", "Sleep:" + this.j);     // Catch: Throwable -> L18
    L16:
        Thread.sleep(this.j);     // Catch: Throwable -> L18
    }

    static /* synthetic */ boolean a(e r0, DownloadInfo r1, boolean r2, long r3, boolean r5) {
        return r0.a(r1, r2, r3, r5);
    }

    static /* synthetic */ boolean a(e r0, DownloadInfo r1, boolean r2, boolean r3, com.ss.android.socialbase.downloader.cleaner.a r4, boolean r5) {
        return r0.a(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ boolean a(e r0, boolean r1) {
        r0.g = r1;
        return r1;
    }

    private boolean a(DownloadInfo r10, boolean r11, long r12, boolean r14) {
        if (this.k == true) goto L5;
    L14:
        if (r11 == false) goto L23;
        if (com.ss.android.socialbase.downloader.d.b.a() == false) goto L23;
        if (com.ss.android.socialbase.downloader.d.b.a(r10.getSavePath()) == true) goto L23;
        if (com.ss.android.socialbase.downloader.d.b.f(r10.getSavePath()) == false) goto L23;
        return true;
    L23:
        if (r12 > 0) goto L25;
    L32:
        return false;
    L25:
        if (r10.getStatus() == (-3)) goto L32;
        if ((r10.getLastDownloadTime() + (r12 * 1000)) >= System.currentTimeMillis()) goto L32;
        if (r14 == false) goto L30;
        return true;
    L30:
        com.ss.android.socialbase.downloader.utils.g.b(r10, false);
        return true;
    L5:
        if (r10.getCacheLifeTimeMax() <= 0) goto L14;
        if (r10.getDownloadStartTimeStamp() <= 0) goto L14;
        if ((r10.getDownloadStartTimeStamp() + (r10.getCacheLifeTimeMax() * 1000)) >= System.currentTimeMillis()) goto L14;
        if (r14 == false) goto L12;
        return true;
    L12:
        com.ss.android.socialbase.downloader.utils.g.b(r10, true);
        return true;
    }

    private boolean a(DownloadInfo r5, boolean r6, boolean r7, com.ss.android.socialbase.downloader.cleaner.a r8, boolean r9) {
        if (r5.getStatus() == (-3)) goto L5;
        return r7;
    L5:
        boolean r4 = com.ss.android.socialbase.downloader.utils.g.d(r5.getSavePath(), r5.getName());
        if (r5.getInstalledTimeStamp() > 0) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r4 == false) goto L18;
        if (r0 == false) goto L17;
        if (r9 == false) goto L16;
        r8.a(r5, true);
        return r7;
    L16:
        com.ss.android.socialbase.downloader.utils.g.c(r5);
    L17:
        return r7;
    L18:
        if (r6 == false) goto L20;
        return true;
    L20:
        if (r0 == true) goto L22;
        r5.erase();
    L22:
        return r7;
    L8:
        if (com.ss.android.socialbase.downloader.utils.a.a(r5.getSavePath()) == false) goto L10;
        r0 = true;
        goto L11
    }

    static /* synthetic */ int b(e r0) {
        return r0.i;
    }

    static /* synthetic */ DownloadInfo b(e r0, int r1) {
        return r0.n(r1);
    }

    static /* synthetic */ List b(e r0, String r1) {
        return r0.h(r1);
    }

    static /* synthetic */ void b(e r0, DownloadInfo r1) {
        r0.e(r1);
    }

    private void b(DownloadInfo r4, SQLiteStatement r5) {
        if (r4 == null) goto L19;
        if (r5 == null) goto L21;
        monitor-enter(r5);     // Catch: Throwable -> L12
        r4.bindValue(r5);     // Catch: Throwable -> L9
        r5.bindLong(r4.getBindValueCount() + 1, r4.getId());     // Catch: Throwable -> L9
        r5.execute();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
    L20:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r4.getId(), "updateDownloadInfoInner", "Error:" + th);
        return;
    L21:
        return;
    }

    static /* synthetic */ boolean b(e r0, boolean r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ long c(e r2) {
        return r2.j;
    }

    static /* synthetic */ List c(e r0, String r1) {
        return r0.i(r1);
    }

    private void c(DownloadInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r2 = r3.getStatusAtDbInit();
        if (r2 >= 1) goto L7;
        return;
    L7:
        if (r2 > 11) goto L11;
        com.ss.android.socialbase.downloader.f.a.a(com.ss.android.socialbase.downloader.downloader.b.f(), null, r3, null, -5);
        return;
    }

    static /* synthetic */ List d(e r0, String r1) {
        return r0.j(r1);
    }

    static /* synthetic */ void d(e r0) {
        r0.r();
    }

    private void d(final DownloadInfo r2) {
        com.ss.android.socialbase.downloader.downloader.b.c(new AnonymousClass5(this, r2));
    }

    static /* synthetic */ List e(e r0) {
        return r0.s();
    }

    private synchronized void e(DownloadInfo r6) {
        monitor-enter(this);
        if (r6 != null) goto L23;
        monitor-exit(this);
        return;
    L23:
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r6.getId(), "updateDownloadInfoForCurrentThread", "Error:" + th);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    L7:
        if (a(r6.getId()) == true) goto L9;
        d(r6);     // Catch: Throwable -> L15
    L22:
        goto L17
    L9:
        g r0 = this.e;     // Catch: Throwable -> L15
        if (r0 != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        b(r6, r0.c());     // Catch: Throwable -> L15
        goto L22
    }

    static /* synthetic */ boolean e(String r0) {
        return f(r0);
    }

    static /* synthetic */ g f(e r0) {
        return r0.e;
    }

    private static boolean f(String r5) {
        if (f15292b != null) goto L5;
    L17:
        return false;
    L5:
        if (f15292b.isEmpty() == true) goto L17;
        if (r5 == null) goto L17;
        Iterator<Map.Entry<String, Integer>> r0 = f15292b.entrySet().iterator();
    L10:
        if (r0.hasNext() == false) goto L17;
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        if (r5.indexOf(r2) == (-1)) goto L10;
        return true;
    }

    private List<DownloadInfo> g(String r8) {
        o();
        ArrayList r7 = new ArrayList();
        if (d == null) goto L17;
        Cursor r0 = null;
        r0 = d.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"downloader", "url"}), new String[]{r8});     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r7.add(com.ss.android.socialbase.downloader.utils.c.a(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "getDownloadInfoListImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
        throw th;
    L17:
        return r7;
    }

    static /* synthetic */ void g(e r0) {
        r0.u();
    }

    static /* synthetic */ SQLiteDatabase h() {
        return d;
    }

    private List<DownloadInfo> h(String r9) {
        o();
        ArrayList r8 = new ArrayList();
        if (d == null) goto L17;
        Cursor r0 = null;
        r0 = d.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", new Object[]{"downloader", "mimeType", "status"}), new String[]{r9, String.valueOf(-3)});     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r8.add(com.ss.android.socialbase.downloader.utils.c.a(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "getSuccessedDownloadInfosWithMimeTypeImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
        throw th;
    L17:
        return r8;
    }

    private List<DownloadInfo> i(String r10) {
        o();
        ArrayList r9 = new ArrayList();
        if (d == null) goto L17;
        Cursor r0 = null;
        r0 = d.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s IN (?,?,?,?,?)", new Object[]{"downloader", "mimeType", "status"}), new String[]{r10, String.valueOf(-1), String.valueOf(-2), String.valueOf(-7), String.valueOf(-4), String.valueOf(-5)});     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r9.add(com.ss.android.socialbase.downloader.utils.c.a(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "getUnCompletedDownloadInfosWithMimeTypeImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
        throw th;
    L17:
        return r9;
    }

    static /* synthetic */ void i() {
        n();
    }

    private List<DownloadInfo> j(String r9) {
        o();
        ArrayList r8 = new ArrayList();
        if (d == null) goto L17;
        Cursor r0 = null;
        r0 = d.rawQuery(String.format("SELECT * FROM %s WHERE %s LIKE ?", new Object[]{"downloader", ActivityLifecycle.NAME}), new String[]{"%" + r9});     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r8.add(com.ss.android.socialbase.downloader.utils.c.a(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "getDownloadInfosByFileExtensionImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
        throw th;
    L17:
        return r8;
    }

    static /* synthetic */ boolean j() {
        return l;
    }

    private static int k() {
        int r0 = com.ss.android.socialbase.downloader.g.a.b().optInt("lru_download_info_capacity_max", 300);
        if (r0 >= 100) goto L5;
        return 300;
    L5:
        return r0;
    }

    private static int l() {
        int r0 = com.ss.android.socialbase.downloader.g.a.c().b("main_thread_db_op_max_time_ms");
        if (r0 >= 0) goto L6;
        return r0;
    L6:
        if (com.ss.android.socialbase.downloader.downloader.b.aa() == false) goto L9;
        return 4000;
    L9:
        return r0;
    }

    private static boolean m() {
        if (com.ss.android.socialbase.downloader.g.a.c().b("enable_remove_download_sp_info") <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private DownloadInfo n(int r9) {
        o();
        if (d != null) goto L24;
    L21:
        return null;
    L24:
        Cursor r2 = d.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"downloader", "_id"}), new String[]{Integer.toString(r9)});     // Catch: Throwable -> L14
    L12:
        th = th;
    L26:
        th.printStackTrace();     // Catch: Throwable -> L18
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r9, "getDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L18
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r2});
    L18:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r2});
        throw th;
    L7:
        if (r2.moveToNext() == false) goto L11;
        DownloadInfo r10 = com.ss.android.socialbase.downloader.utils.c.a(r2);     // Catch: Throwable -> L12
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r2});
        return r10;
    L11:
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r2});
    L14:
        th = th;
        r2 = null;
        goto L26
    }

    private static void n() {
        if (f15292b == null) goto L5;
        return;
    L5:
        f15292b = com.ss.android.socialbase.downloader.utils.c.a(com.ss.android.socialbase.downloader.g.a.b().optJSONObject("lru_preload_hot_cache_keys"));
    }

    private void o() {
        if (d == null) goto L5;
        return;
    L5:
        monitor-enter(e.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (d == null) goto L23;
    L17:
        monitor-exit(e.class);     // Catch: Throwable -> L19
        return;
    L23:
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "ensureDataBaseInit", "Error:" + th);     // Catch: Throwable -> L19
        goto L17
    L9:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L13;
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "ensureDataBaseInit", "Context is null");     // Catch: Throwable -> L15
        monitor-exit(e.class);     // Catch: Throwable -> L19
        return;
    L13:
        d = com.ss.android.socialbase.downloader.c.a.a().getWritableDatabase();     // Catch: Throwable -> L15
        this.e = new g(d, "downloader", com.ss.android.socialbase.downloader.constants.a.f15350a, com.ss.android.socialbase.downloader.constants.a.f15351b);     // Catch: Throwable -> L15
        this.f = new g(d, "segments", com.ss.android.socialbase.downloader.constants.a.c, com.ss.android.socialbase.downloader.constants.a.d);     // Catch: Throwable -> L15
        goto L17
    }

    private List<String> p() {
        j r0 = com.ss.android.socialbase.downloader.downloader.b.B();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    private void q() {
        d.beginTransaction();
    }

    private void r() {
        if (d != null) goto L10;
        return;
    L10:
        d.execSQL("DROP TABLE IF EXISTS downloadChunk");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "deleteChunkTable", "Error:" + th);
    }

    private List<DownloadInfo> s() {
        o();
        ArrayList r8 = new ArrayList();
        if (d == null) goto L17;
        Cursor r0 = null;
        r0 = d.rawQuery(String.format("SELECT * FROM %s", new Object[]{"downloader"}), null);     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r8.add(com.ss.android.socialbase.downloader.utils.c.a(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "getAllDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
    L14:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r0});
        throw th;
    L17:
        return r8;
    }

    private void t() {
    L8:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "safeEndTransaction", "Error:" + th);
        return;
    L3:
        if (d != null) goto L5;
        return;
    L5:
        if (d.inTransaction() == false) goto L14;
        d.endTransaction();     // Catch: Throwable -> L8
        return;
    }

    private synchronized void u() {
        monitor-enter(this);
        q();     // Catch: Throwable -> L6
        d.delete("downloader", null, null);     // Catch: Throwable -> L6
        d.setTransactionSuccessful();     // Catch: Throwable -> L6
    L4:
        t();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", "clearDataInSubThread", "Error:" + th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        t();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private void update(final int r2, final ContentValues r3) {
        com.ss.android.socialbase.downloader.downloader.b.c(new AnonymousClass10(this, r2, r3));
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo a(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 4);
        r0.put("curBytes", Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo a(int r4, long r5, String r7, String r8) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 3);
        r0.put("totalBytes", Long.valueOf(r5));
        r0.put("eTag", r7);
        if (TextUtils.isEmpty(r8) == true) goto L5;
        r0.put(ActivityLifecycle.NAME, r8);
    L5:
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<DownloadInfo> a() {
        return (List) ZeusTransformUtils.preCheckCast(a(new AnonymousClass3(this), new AnonymousClass4(this)), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<DownloadInfo> a(final String r2) {
        return (List) ZeusTransformUtils.preCheckCast(a(new AnonymousClass12(this, r2), new AnonymousClass13(this)), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<DownloadInfo> a(String r1, String r2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void a(double r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.s
    public void a(final SparseArray<DownloadInfo> r10, final HashMap<Integer, Integer> r11, List<DownloadInfo> r12, List<String> r13, d r14) {
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        final List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        final d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r14, d.class, "com.obric.memorydata.plugin");
        Runnable r15 = new AnonymousClass1(this, r10, r5, r11, r7, r8);     // Catch: Throwable -> L7
        ExecutorService r9 = com.ss.android.socialbase.downloader.downloader.b.s();     // Catch: Throwable -> L7
        if (r9 == null) goto L12;
        r9.execute(r15);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", CommonConsts.APM_INNER_EVENT_COST_INIT, "Error2:" + th);
    }

    public void a(SparseArray<DownloadInfo> r5, HashMap<Integer, Integer> r6, List<DownloadInfo> r7, boolean r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "onInitFinish", "Run onInitFinish:" + this.c);
    L14:
        HashMap r10 = com.ss.android.socialbase.downloader.utils.c.a(r5);     // Catch: Throwable -> L9
        Map<Integer, DownloadInfo> r11 = com.ss.android.socialbase.downloader.utils.c.a(r9);     // Catch: Throwable -> L9
        b r4 = this.c;     // Catch: Throwable -> L9
        if (r4 == null) goto L16;
        r4.a(r10, r6, r11, r8);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L17;
        com.ss.android.socialbase.downloader.e.a.a("SqlDownloadCache", "onInitFinish", "Error:" + th);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a(b r3) {
        this.c = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void a(boolean r13) {
        if (r13 == false) goto L4;
        a(new SparseArray(), new HashMap(), new ArrayList(), p(), null);
        return;
    L4:
        a(new SparseArray(), null, null, null, null);
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean a(int r4) {
        if (b(r4) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r4, "cacheExist", "Error:" + th);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public boolean a(int r7, Map<Long, i> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        o();
        if (d != null) goto L5;
        return false;
    L5:
        JSONArray r0 = new JSONArray();
        Iterator r10 = r9.entrySet().iterator();     // Catch: Throwable -> L13
    L8:
        if (r10.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r2.getValue() == null) goto L8;
        r0.put(((i) ZeusTransformUtils.preCheckCast(r2.getValue(), i.class, "com.obric.memorydata.plugin")).k());     // Catch: Throwable -> L13
    L15:
        SQLiteStatement r6 = this.f.d();
        if (r6 != null) goto L19;
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r7, "updateSegments", "UpdateSegments statement is null");
        return false;
    L19:
        monitor-enter(r6);
        r6.clearBindings();     // Catch: Throwable -> L23
        r6.bindLong(1, r7);     // Catch: Throwable -> L23
        r6.bindString(2, r0.toString());     // Catch: Throwable -> L23
        r6.execute();     // Catch: Throwable -> L23
        monitor-exit(r6);     // Catch: Throwable -> L23
        return false;
    L23:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r7, "updateSegments", "Error:" + th);
        goto L15
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean a(final DownloadInfo r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        com.ss.android.socialbase.downloader.downloader.b.c(new AnonymousClass6(this, r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo b(final int r2) {
        return (DownloadInfo) ZeusTransformUtils.preCheckCast(a(new AnonymousClass11(this, r2), null), DownloadInfo.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo b(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -1);
        r0.put("curBytes", Long.valueOf(r5));
        if (r5 <= 0) goto L5;
        r0.put("isFirstDownload", 0);
    L5:
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<DownloadInfo> b(final String r2) {
        return (List) ZeusTransformUtils.preCheckCast(a(new AnonymousClass14(this, r2), new AnonymousClass15(this)), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void b() {
        com.ss.android.socialbase.downloader.downloader.b.c(new AnonymousClass9(this));
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void b(DownloadInfo r1) {
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo c(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -3);
        r0.put("curBytes", Long.valueOf(r5));
        r0.put("isFirstDownload", 0);
        r0.put("isFirstSuccess", 0);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<DownloadInfo> c(final String r2) {
        return (List) ZeusTransformUtils.preCheckCast(a(new AnonymousClass16(this, r2), new AnonymousClass17(this)), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean c() {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean c(final int r2) {
        com.ss.android.socialbase.downloader.downloader.b.c(new AnonymousClass7(this, r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo d(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -2);
        r0.put("curBytes", Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public List<DownloadInfo> d(final String r2) {
        return (List) ZeusTransformUtils.preCheckCast(a(new AnonymousClass18(this, r2), new AnonymousClass2(this)), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public boolean d(final int r2) {
        com.ss.android.socialbase.downloader.downloader.b.c(new AnonymousClass8(this, r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo e(int r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo e(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -4);
        r0.put("curBytes", Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo f(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 5);
        r0.put("isFirstDownload", 0);
        update(r4, r0);
        return null;
    }

    public void f() {
        this.i = Integer.MAX_VALUE;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo g(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 1);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void g() {
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public DownloadInfo h(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -7);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void i(int r1) {
    }

    public ArrayList<i> j(int r1) {
        Map<Long, i> r0 = k(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r0.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public Map<Long, i> k(int r11) {
        o();
        if (d != null) goto L32;
    L29:
        return null;
    L32:
        Cursor r2 = d.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"segments", "_id"}), new String[]{Integer.toString(r11)});     // Catch: Throwable -> L22
    L20:
        th = th;
    L34:
        th.printStackTrace();     // Catch: Throwable -> L26
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r11, "getSegmentMap", "Error:" + th);     // Catch: Throwable -> L26
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r2});
    L26:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r2});
        throw th;
    L7:
        if (r2.moveToNext() == false) goto L19;
        int r3 = r2.getColumnIndex("info");     // Catch: Throwable -> L20
        if (r3 < 0) goto L11;
        String r4 = r2.getString(r3);     // Catch: Throwable -> L20
    L12:
        HashMap r5 = new HashMap();     // Catch: Throwable -> L20
        JSONArray r6 = new JSONArray(r4);     // Catch: Throwable -> L20
        int r7 = 0;
    L13:
        if (r7 >= r6.length()) goto L17;
        i r8 = new i(r6.getJSONObject(r7));     // Catch: Throwable -> L20
        r5.put(Long.valueOf(r8.c()), r8);     // Catch: Throwable -> L20
        r7 = r7 + 1;
        goto L13
    L17:
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r2});
        return r5;
    L11:
        r4 = null;
        goto L12
    L19:
        com.ss.android.socialbase.downloader.utils.g.a(new Cursor[]{r2});
    L22:
        th = th;
        r2 = null;
        goto L34
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public void l(int r3) {
        o();
        if (d != null) goto L10;
        return;
    L10:
        a(r3, this.f.b());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        com.ss.android.socialbase.downloader.e.a.b("SqlDownloadCache", r3, "removeSegments", "Error:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.h
    public /* synthetic */ List m(int r1) {
        return j(r1);
    }
}
