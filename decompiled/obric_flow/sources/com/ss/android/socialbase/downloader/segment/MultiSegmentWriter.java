package com.ss.android.socialbase.downloader.segment;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.core.module.multi.DownloadMultiSegmentModule;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.Closeable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class MultiSegmentWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f16016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f16017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadInfo f16018c;
    public final IDownloadCache d;
    public final DownloadSetting e;
    public final DownloadMultiSegmentModule f;
    public final IBufferPool g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BaseException f16019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f16020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f16021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f16022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AppStatusManager f16023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f16024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f16025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f16026o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f16027p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f16028q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f16029r;
    public long s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile long f16030t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile long f16031u;

    public MultiSegmentWriter(DownloadInfo r10, DownloadMultiSegmentModule r11, IBufferPool r12) {
        this.f16016a = new LinkedList();
        this.f16017b = new ArrayList();
        boolean r5 = false;
        this.f16020i = false;
        this.f16021j = false;
        this.f16022k = false;
        this.f16028q = true;
        this.f16030t = 0;
        this.f16031u = 0;
        this.f16018c = r10;
        this.d = DownloadComponentManager.h();
        this.f = r11;
        this.g = r12;
        this.f16023l = AppStatusManager.b();
        DownloadSetting r13 = DownloadSetting.a(r10.l(), null);
        this.e = r13;
        if (r13.a("sync_strategy", 0) != 1) goto L5;
        boolean r14 = true;
    L6:
        this.f16024m = r14;
        if (r14 == false) goto L9;
        long r15 = r13.a("sync_interval_ms_fg", 5000);
        long r16 = r13.a("sync_interval_ms_bg", 1000);
        this.f16025n = Math.max(r15, 500);
        this.f16026o = Math.max(r16, 500);
        this.f16027p = r13.a("sync_min_length", 10485760);
    L11:
        if (r13.a("monitor_rw", 0) != 1) goto L13;
        r5 = true;
    L13:
        this.f16029r = r5;
        return;
    L9:
        this.f16025n = 0;
        this.f16026o = 0;
        this.f16027p = 0;
        goto L11
    L5:
        r14 = false;
        goto L6
    }

    public final void a(SegmentOutput r5) {
        monitor-enter(this);
        this.f16016a.add(r5);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v42 */
    /* JADX WARN: Type inference failed for: r15v54 */
    /* JADX WARN: Type inference failed for: r15v55 */
    /* JADX WARN: Type inference failed for: r15v56 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r3v21, types: [com.ss.android.socialbase.downloader.setting.DownloadSetting] */
    /* JADX WARN: Type inference failed for: r3v33, types: [com.ss.android.socialbase.downloader.setting.DownloadSetting] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.ss.android.socialbase.downloader.setting.DownloadSetting] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(IInput r35) {
        if (this.f16021j == false) goto L5;
        return;
    L5:
        if (this.f16022k == true) goto L395;
        ?? r5 = 0;
        this.f16019h = null;
        DownloadInfo r10 = this.f16018c;
        DownloadMultiSegmentModule r11 = this.f;
        IBufferPool r12 = this.g;
        long r13 = r10.i();
        long r14 = System.nanoTime();
        boolean r15 = this.f16029r;
        long r16 = 0;
        int r17 = 0;
        ?? r18 = 0;
        r17 = 0;
        int r19 = 0;
        r17 = 0;
        r17 = 0;
        r19 = 0;
        r17 = 0;
        if (this.f16024m == false) goto L14;
        long r110 = r10.f15817h0;
        if (r110 <= 0) goto L14;
        DownloadMultiSegmentModule r20 = r11;
        int r21 = (r110 > this.f16027p ? 1 : (r110 == this.f16027p ? 0 : -1));
        r5 = r21;
        if (r21 > 0) goto L336;
        this.f16028q = false;
        r5 = r21;
    L336:
    L192:
        th = th;
    L193:
        Throwable r24 = th;
        if (r17 <= 0) goto L285;
        r20.a(r17);     // Catch: Throwable -> L318
    L285:
        if (this.f16022k == false) goto L334;
    L293:
        Throwable th2 = null;
    L294:
        monitor-enter(this);
        a(this.f16016a);     // Catch: Throwable -> L312
        this.f16016a.clear();     // Catch: Throwable -> L312
        monitor-exit(this);     // Catch: Throwable -> L312
        long r111 = r10.i() - r13;
        long r112 = System.nanoTime() - r14;
        ?? r22 = this.e;
        DownloadMonitorHelper.a(r22.a("monitor_download_io", r5), r22, r10, r10.d, null, null, null, this.f16021j, this.f16022k, this.f16019h, r111, r112, r15, r18, r26, this.s);
        if (th2 != null) goto L300;
        throw r24;
    L300:
        if (this.f16021j == false) goto L302;
        throw r24;
    L302:
        if (this.f16022k == false) goto L304;
        throw r24;
    L304:
        if (this.f16019h != null) goto L385;
        DownloadHelper.a(th2, "loopAndWrite_finally");     // Catch: BaseException -> L308
        throw null;     // Catch: BaseException -> L308
    L308:
        e = move-exception;
        this.f16019h = e;
        throw e;
    L385:
        throw r24;
    L312:
        th = move-exception;
        throw th;
    L334:
        this.f16028q = true;     // Catch: Throwable -> L289
        a();     // Catch: Throwable -> L289
    L289:
        th2 = th;
        if (Logger.b() == false) goto L294;
        Logger.a("MultiSegmentWriter", r10.l(), null, "loopAndWrite", "Finally sync, e = " + th2, false);
    L180:
        e = e;
        r15 = r15;
        ?? r23 = 0;
        long r113 = 0;
    L276:
        long r25 = r16;
        long r26 = r113;
        r5 = r23;
    L322:
        this.f16019h = e;     // Catch: Throwable -> L279
        throw e;     // Catch: Throwable -> L279
    L279:
        th = th;
        long r114 = r25;
    L178:
        e = e;
        r15 = r15;
        ?? r27 = 0;
        r113 = 0;
    L232:
        long r115 = r16;
        r26 = r113;
        ?? r28 = r27;
    L234:
        if (this.f16021j == false) goto L236;
    L243:
        if (r19 <= 0) goto L247;
        r20.a(r19);     // Catch: Throwable -> L319
    L247:
        if (this.f16022k == false) goto L324;
    L255:
        Throwable th3 = null;
    L256:
        monitor-enter(this);
        a(this.f16016a);     // Catch: Throwable -> L273
        this.f16016a.clear();     // Catch: Throwable -> L273
        monitor-exit(this);     // Catch: Throwable -> L273
        long r116 = r10.i() - r13;
        long r117 = System.nanoTime() - r14;
        ?? r29 = this.e;
        DownloadMonitorHelper.a(r29.a("monitor_download_io", r28), r29, r10, r10.d, null, null, null, this.f16021j, this.f16022k, this.f16019h, r116, r117, r15, r115, r26, this.s);
        if (th3 != null) goto L262;
        return;
    L262:
        if (this.f16021j == false) goto L264;
        return;
    L264:
        if (this.f16022k == false) goto L266;
        return;
    L266:
        if (this.f16019h != null) goto L398;
        DownloadHelper.a(th3, "loopAndWrite_finally");     // Catch: BaseException -> L270
        throw null;     // Catch: BaseException -> L270
    L270:
        e = move-exception;
        this.f16019h = e;
        throw e;
    L398:
        return;
    L273:
        th = move-exception;
        throw th;
    L324:
        this.f16028q = true;     // Catch: Throwable -> L251
        a();     // Catch: Throwable -> L251
    L251:
        th3 = th;
        if (Logger.b() == false) goto L256;
        Logger.a("MultiSegmentWriter", r10.l(), null, "loopAndWrite", "Finally sync, e = " + th3, false);
        goto L256
    L236:
        if (this.f16022k == true) goto L243;
        if (Logger.b() == false) goto L241;
        e.printStackTrace();     // Catch: Throwable -> L192
        Logger.a("MultiSegmentWriter", r10.l(), null, "loopAndWrite", "BaseException: " + e, false);     // Catch: Throwable -> L192
    L241:
        this.f16019h = e;     // Catch: Throwable -> L192
        throw e;     // Catch: Throwable -> L192
    L176:
        th = th;
        r15 = r15;
        ?? r30 = 0;
        r113 = 0;
    L182:
        r114 = r16;
        r26 = r113;
        r5 = r30;
    L184:
        if (this.f16021j == false) goto L186;
    L199:
        if (r17 <= 0) goto L203;
        r20.a(r17 == true ? 1 : 0);     // Catch: Throwable -> L317
    L203:
        if (this.f16022k == false) goto L347;
    L211:
        Throwable th4 = null;
    L212:
        monitor-enter(this);
        a(this.f16016a);     // Catch: Throwable -> L229
        this.f16016a.clear();     // Catch: Throwable -> L229
        monitor-exit(this);     // Catch: Throwable -> L229
        long r118 = r10.i() - r13;
        long r119 = System.nanoTime() - r14;
        ?? r31 = this.e;
        DownloadMonitorHelper.a(r31.a("monitor_download_io", r5), r31, r10, r10.d, null, null, null, this.f16021j, this.f16022k, this.f16019h, r118, r119, r15, r114, r26, this.s);
        if (th4 != null) goto L218;
        return;
    L218:
        if (this.f16021j == false) goto L220;
        return;
    L220:
        if (this.f16022k == false) goto L222;
        return;
    L222:
        if (this.f16019h != null) goto L397;
        DownloadHelper.a(th4, "loopAndWrite_finally");     // Catch: BaseException -> L226
        throw null;     // Catch: BaseException -> L226
    L226:
        e = move-exception;
        this.f16019h = e;
        throw e;
    L397:
        return;
    L229:
        th = move-exception;
        throw th;
    L347:
        this.f16028q = true;     // Catch: Throwable -> L207
        a();     // Catch: Throwable -> L207
    L207:
        th4 = th;
        if (Logger.b() == false) goto L212;
        Logger.a("MultiSegmentWriter", r10.l(), null, "loopAndWrite", "Finally sync, e = " + th4, false);
        goto L212
    L186:
        if (this.f16022k == true) goto L199;
        if (Logger.b() == false) goto L349;
        th.printStackTrace();     // Catch: Throwable -> L192
        Logger.a("MultiSegmentWriter", r10.l(), null, "loopAndWrite", "Throwable: " + th, false);     // Catch: Throwable -> L192
    L349:
        DownloadHelper.a(th, "loopAndWrite");     // Catch: Throwable -> L192 BaseException -> L196
        throw null;     // Catch: Throwable -> L192 BaseException -> L196
    L196:
        e = move-exception;
        this.f16019h = e;     // Catch: Throwable -> L192
        throw e;     // Catch: Throwable -> L192
    L17:
        if (r10.f15836s0 == 0) goto L359;
    L26:
        this.f16031u = SystemClock.uptimeMillis();     // Catch: Throwable -> L176 BaseException -> L178 StreamClosedException -> L180
        r25 = 0;
        r113 = 0;
        long r120 = 0;
        int r32 = 0;
    L28:
        if (r15 == false) goto L373;
        r16 = System.nanoTime();     // Catch: Throwable -> L31 BaseException -> L34 StreamClosedException -> L37
    L37:
        e = e;
        r16 = r25;
    L39:
        r17 = r32;
        r23 = r18;
    L34:
        e = e;
        r16 = r25;
    L36:
        r19 = r32;
        r27 = r18;
    L31:
        th = th;
        r16 = r25;
    L33:
        r17 = r32;
        r30 = r18;
    L373:
        Buffer r33 = ((BufferQueue) r35).c();     // Catch: Throwable -> L170 BaseException -> L172 StreamClosedException -> L174
        if (r15 == true) goto L43;
        r25 = r25;
    L368:
        int r121 = r33.f16008c;     // Catch: Throwable -> L164 BaseException -> L166 StreamClosedException -> L168
        if (r121 != (-1)) goto L55;
        a(r33.f16007b);     // Catch: Throwable -> L49 BaseException -> L51 StreamClosedException -> L53
        ((BufferQueue) r12).a(r33);     // Catch: Throwable -> L49 BaseException -> L51 StreamClosedException -> L53
    L53:
        e = e;
        r16 = r25;
    L51:
        e = e;
        r16 = r25;
    L49:
        th = th;
        r16 = r25;
        goto L33
    L55:
        if (r15 == false) goto L57;
        r16 = System.nanoTime();     // Catch: Throwable -> L49 BaseException -> L51 StreamClosedException -> L53
    L57:
        ((SegmentOutput) r33.f16007b).a(r33);     // Catch: Throwable -> L164 BaseException -> L166 StreamClosedException -> L168
        if (r15 == true) goto L60;
        r26 = r113;
    L370:
        ((BufferQueue) r12).a(r33);     // Catch: Throwable -> L110 BaseException -> L113 StreamClosedException -> L116
        if (this.f16020i == false) goto L70;
        if (this.f16021j == true) goto L77;
    L75:
        e = e;
        r16 = r25;
        r113 = r26;
    L73:
        e = e;
        r16 = r25;
        r113 = r26;
    L71:
        th = th;
        r16 = r25;
        r113 = r26;
        goto L33
    L67:
        if (this.f16022k == true) goto L77;
        this.f16020i = r18;     // Catch: Throwable -> L71 BaseException -> L73 StreamClosedException -> L75
    L77:
        if (r32 <= 0) goto L81;
        r20.a(r32);     // Catch: Throwable -> L316
    L81:
        if (this.f16022k == false) goto L328;
    L89:
        Throwable th5 = null;
    L90:
        monitor-enter(this);
        a(this.f16016a);     // Catch: Throwable -> L107
        this.f16016a.clear();     // Catch: Throwable -> L107
        monitor-exit(this);     // Catch: Throwable -> L107
        long r122 = r10.i() - r13;
        long r34 = System.nanoTime() - r14;
        boolean r36 = r18 == true ? 1 : 0;
        DownloadSetting r37 = this.e;
        long r38 = this.s;
        DownloadMonitorHelper.a(r37.a("monitor_download_io", r36 ? 1 : 0), r37, r10, r10.d, null, null, null, this.f16021j, this.f16022k, this.f16019h, r122, r34, r15, r25, r26, r38);
        if (th5 != null) goto L96;
        return;
    L96:
        if (this.f16021j == false) goto L98;
        return;
    L98:
        if (this.f16022k == false) goto L100;
        return;
    L100:
        if (this.f16019h != null) goto L396;
        DownloadHelper.a(th5, "loopAndWrite_finally");     // Catch: BaseException -> L104
        throw null;     // Catch: BaseException -> L104
    L104:
        e = move-exception;
        this.f16019h = e;
        throw e;
    L396:
        return;
    L107:
        th = move-exception;
        throw th;
    L328:
        this.f16028q = true;     // Catch: Throwable -> L85
        a();     // Catch: Throwable -> L85
    L85:
        th5 = th;
        if (Logger.b() == false) goto L90;
        Logger.a("MultiSegmentWriter", r10.l(), null, "loopAndWrite", "Finally sync, e = " + th5, false);
        goto L90
    L70:
        r15 = r15;
        boolean r39 = r18 == true ? 1 : 0;
        r32 = r32 + r121;
        if (r32 >= 65536) goto L361;
    L163:
        r18 = r39 ? 1 : 0;
    L153:
        r15 = r15;
        r113 = r26;
        goto L28
    L361:
        long r123 = SystemClock.uptimeMillis();     // Catch: Throwable -> L157 BaseException -> L159 StreamClosedException -> L161
        if ((r123 - r120) <= 200) goto L163;
        boolean r40 = r20.a(r32);     // Catch: Throwable -> L157 BaseException -> L159 StreamClosedException -> L161
    L372:
    L141:
        e = e;
        r17 = r39 ? 1 : 0;
        r5 = r39;
    L139:
        e = e;
        r19 = r39 ? 1 : 0;
        r115 = r25;
        r28 = r39;
    L137:
        th = th;
        r17 = r39 ? 1 : 0;
        r114 = r25;
        r5 = r39;
        goto L184
    L125:
        if (this.f16028q == false) goto L128;
        a(r123, r40);     // Catch: Throwable -> L137 BaseException -> L139 StreamClosedException -> L141
    L128:
        if (DeviceBandwidthSampler.f != 1) goto L131;
    L152:
        r32 = r39 ? 1 : 0;
        r18 = r32;
        r120 = r123;
        goto L153
    L131:
        if (r10.g == false) goto L144;
        DeviceBandwidthSampler.c();     // Catch: Throwable -> L137 BaseException -> L139 StreamClosedException -> L141
        if (DeviceBandwidthSampler.f != 2) goto L144;
        throw new DownloadOnlyWifiException();     // Catch: Throwable -> L137 BaseException -> L139 StreamClosedException -> L141
    L144:
        if (r10.W0 == false) goto L152;
        if (r10.x() == false) goto L152;
        DeviceBandwidthSampler.c();     // Catch: Throwable -> L137 BaseException -> L139 StreamClosedException -> L141
        if (DeviceBandwidthSampler.f != 2) goto L152;
        throw new DownloadPauseReserveWifiException();     // Catch: Throwable -> L137 BaseException -> L139 StreamClosedException -> L141
    L161:
        e = e;
    L118:
        r17 = r32;
        r16 = r25;
        r113 = r26;
        r23 = r39;
    L159:
        e = e;
    L115:
        r19 = r32;
        r16 = r25;
        r113 = r26;
        r27 = r39;
    L157:
        th = th;
    L112:
        r17 = r32;
        r16 = r25;
        r113 = r26;
        r30 = r39;
    L116:
        e = e;
        r15 = r15;
        r39 = r18 == true ? 1 : 0;
    L113:
        e = e;
        r15 = r15;
        r39 = r18 == true ? 1 : 0;
    L110:
        th = th;
        r15 = r15;
        r39 = r18 == true ? 1 : 0;
        goto L112
    L60:
        r26 = (System.nanoTime() - r16) + r113;
        goto L370
    L168:
        e = e;
        r15 = r15;
        r23 = r18 == true ? 1 : 0;
        r17 = r32;
        r16 = r25;
    L166:
        e = e;
        r15 = r15;
        r27 = r18 == true ? 1 : 0;
        r19 = r32;
        r16 = r25;
    L164:
        th = th;
        r15 = r15;
        r30 = r18 == true ? 1 : 0;
        r17 = r32;
        r16 = r25;
        goto L182
    L43:
        r25 = (System.nanoTime() - r16) + r25;
        goto L368
    L174:
        e = e;
        r15 = r15;
        r23 = r18 == true ? 1 : 0;
        r17 = r32;
        r16 = r25;
    L172:
        e = e;
        r15 = r15;
        r27 = r18 == true ? 1 : 0;
        r19 = r32;
        r16 = r25;
    L170:
        th = th;
        r15 = r15;
        r30 = r18 == true ? 1 : 0;
        r17 = r32;
        r16 = r25;
        goto L182
    L359:
        r10.f15836s0 = System.nanoTime();     // Catch: Throwable -> L20 BaseException -> L22 StreamClosedException -> L24
    L24:
        e = e;
        r113 = 0;
        r15 = r15;
        r23 = 0;
    L22:
        e = e;
        r113 = 0;
        r15 = r15;
        r27 = 0;
    L20:
        th = th;
        r113 = 0;
        r15 = r15;
        r30 = 0;
    L14:
        r20 = r11;
        goto L336
    }

    public final void a(long r10, boolean r11) {
        long r5 = r10 - this.f16031u;
        if (this.f16024m == true) goto L5;
        long r12 = this.f16018c.i() - this.f16030t;
        if (r11 == false) goto L15;
    L20:
        a();
        this.f16031u = r10;
        return;
    L15:
        if (r12 > 65536) goto L17;
        return;
    L17:
        if (r5 > 500) goto L20;
        return;
    L5:
        if (this.f16023l.c() != 1) goto L7;
        long r13 = this.f16025n;
    L9:
        if (r5 <= r13) goto L22;
        a();
        this.f16031u = r10;
        return;
    L22:
        return;
    L7:
        r13 = this.f16026o;
        goto L9
    }

    public final void a(IOutput r5) {
        monitor-enter(this);
        this.f16017b.add((SegmentOutput) r5);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a() {
        boolean r5 = this.f16029r;
        if (r5 == false) goto L5;
        long r10 = System.nanoTime();
    L6:
        DownloadInfo r11 = this.f16018c;
        IDownloadCache r12 = this.d;
        LinkedList r13 = this.f16016a;
        ArrayList r14 = this.f16017b;
        Map r15 = r12.r(r11.l());
        if (r15 != null) goto L9;
        r15 = new HashMap(4);
    L9:
        monitor-enter(this);
        Iterator r16 = r13.iterator();     // Catch: Throwable -> L15
    L12:
        if (r16.hasNext() == false) goto L40;
        ((SegmentOutput) r16.next()).f16063b.b();     // Catch: Throwable -> L15
        goto L12
    L40:
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        boolean r17 = false;
    L29:
        a(r13, r15);     // Catch: Throwable -> L15
        if (r14.size() <= 0) goto L32;
        a(r14);     // Catch: Throwable -> L15
        r13.removeAll(r14);     // Catch: Throwable -> L15
        r14.clear();     // Catch: Throwable -> L15
    L32:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r17 == false) goto L35;
        r11.a(true);
        r12.a(r11.l(), r15);
        r12.a(r11);
        this.f16030t = r11.i();
    L35:
        if (r5 == false) goto L47;
        this.s += System.nanoTime() - r10;
        return;
    L47:
        return;
    L19:
        if (this.f16028q == false) goto L27;
        Iterator r18 = r13.iterator();     // Catch: Throwable -> L25
    L22:
        if (r18.hasNext() == false) goto L27;
        ((SegmentOutput) r18.next()).f16063b.c();     // Catch: Throwable -> L25
    L27:
        r17 = true;
    L15:
        th = move-exception;
        throw th;
    L5:
        r10 = 0;
        goto L6
    }

    public static void a(AbstractList r5) {
        Iterator r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        DownloadUtils.a(new Closeable[]{((SegmentOutput) r10.next()).f16063b});
        goto L4
    }

    public static void a(LinkedList r10, Map r11) {
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L17;
        Segment r5 = ((SegmentOutput) r12.next()).f16062a;
        Segment r13 = (Segment) r11.get(Long.valueOf(r5.f16034a));
        if (r13 == null) goto L7;
        long r14 = r5.a();
        long r15 = r13.f16034a;
        if (r14 >= r15) goto L11;
        r14 = r15;
    L11:
        long r16 = r13.d;
        if (r16 <= 0) goto L16;
        long r17 = r16 + 1;
        if (r14 <= r17) goto L16;
        r14 = r17;
    L16:
        r13.f16035b.set(r14);
        r13.a(r5.d);
        goto L4
    L7:
        Segment r18 = new Segment(r5);
        r11.put(Long.valueOf(r5.f16034a), r18);
        goto L4
    }
}
