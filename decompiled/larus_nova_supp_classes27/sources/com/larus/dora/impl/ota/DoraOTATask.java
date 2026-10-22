package com.larus.dora.impl.ota;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.device.ota.DoraOTAReporter;
import com.larus.dora.impl.ota.connector.DoraOTAWifiConnector;
import com.larus.dora.impl.ota.connector.g;
import com.larus.dora.impl.ota.g.DoraGOTAPlugin;
import com.larus.dora.impl.ota.g.e0;
import com.larus.dora.impl.ota.plugin.DoraOTAPeripheralStage;
import com.larus.dora.impl.ota.utils.KeyLogUtils;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.dora.impl.util.g0;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import g49.d;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTATask implements p, o {
    public static final /* synthetic */ int z = 0;
    public final String a;
    public final k b;
    public final d c;
    public final j d;
    public final i69.a e;
    public final g f;
    public final CoroutineScope g;
    public String h;
    public String i;
    public String j;
    public int k;
    public final Handler l;
    public Job m;
    public Integer n;
    public Job o;
    public final Object p;
    public Function0<Unit> q;
    public boolean r;
    public boolean s;
    public volatile boolean t;
    public volatile int u;
    public final Object v;
    public long w;
    public Long x;
    public int y;

    public static final class a {
    }

    static {
    }

    public final d49.a o() {
        d49.a r0 = (d49.a) ((Map) this.b.b.getValue()).get(this.a);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return d49.a.l.c;
    }

    @Override // com.larus.dora.impl.ota.p
    public final int a() {
        return this.y;
    }

    @Override // com.larus.dora.impl.ota.p
    public final String getSn() {
        return this.a;
    }

    public static final boolean l(DoraOTATask r1) {
        if ((r1.o() instanceof d49.a.e) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1.o() instanceof d49.a.h) == true) goto L8;
        return false;
    }

    @Override // com.larus.dora.impl.ota.p
    public final void f(e49.a r2) {
        Intrinsics.checkNotNullParameter(r2, "responseWrapper");
        u(r2, null);
    }

    @Override // com.larus.dora.impl.ota.p
    public final void g(DoraDevice r9) {
        Intrinsics.checkNotNullParameter(r9, "device");
        d.d("DoraOTATask0711", "onDeviceDisconnected: " + r9 + ", currentState=" + o());
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = -1;
        BuildersKt.launch$default(this.g, null, null, new DoraOTATask$onDeviceDisconnected$1(r9, null), 3, null);
        v(false);
        Object r10 = this.v;
        monitor-enter(r10);
        this.w++;     // Catch: Throwable -> L8
        this.x = null;     // Catch: Throwable -> L8
        this.f.c("onDeviceDisconnected");     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r10);
        this.y = -1;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.dora.impl.ota.p
    public final void h(DoraDevice r3) {
        Intrinsics.checkNotNullParameter(r3, "device");
        d.d("DoraOTATask0711", "onDeviceConnected: " + r3 + ", currentState=" + o());
        this.l.removeMessages(1000);
    }

    public final void m(String r3) {
        if (r3 == null) goto L6;
        DoraOTAWifiConnector r0 = this.f;
        if ((r0 instanceof DoraOTAWifiConnector) == false) goto L6;
        r0.getClass();
        DoraOTAWifiConnector.g(r3);
        return;
    L6:
        this.f.disconnect();
    }

    public final void t(d49.a r3) {
        this.b.a(this.a, r3);
    }

    public final void v(boolean r8) {
        d.d("DoraOTATask0711", "stopDownload: downloadId=" + this.n);
        Object r0 = this.p;
        monitor-enter(r0);
        if (r8 == true) goto L26;
    L8:
        Pair r9 = TuplesKt.to(this.n, this.q);     // Catch: Throwable -> L23
        monitor-exit(r0);
        Integer r1 = (Integer) r9.component1();
        Function0 r10 = (Function0) r9.component2();
        if (r1 == null) goto L19;
        int r2 = r1.intValue();
        AppHost.Companion r3 = AppHost.a;
        boolean r4 = Downloader.getInstance(r3.getApplication()).isDownloading(r2);
        d.d("DoraOTATask0711", "stopDownload: downloadId=" + this.n + ", isDownloading=" + r4);
        if (r4 == false) goto L15;
        Downloader.getInstance(r3.getApplication()).pause(r2);
        Unit r5 = Unit.INSTANCE;
    L18:
        if (r5 == null) goto L19;
    L21:
        this.n = null;
        return;
    L15:
        if (r10 == null) goto L17;
        r10.invoke();
        r5 = Unit.INSTANCE;
        goto L18
    L17:
        r5 = null;
    L19:
        if (r10 == null) goto L21;
        r10.invoke();
        Unit r11 = Unit.INSTANCE;
    L23:
        th = move-exception;
        throw th;
    L26:
        if (this.q == null) goto L8;
        this.r = true;     // Catch: Throwable -> L23
        goto L8
    }

    public static final void i(DoraOTATask r2, String r3) {
        Object r0 = r2.v;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r2.x != null) goto L7;
        r2.m(r3);     // Catch: Throwable -> L10
    L7:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public static final boolean k(DoraOTATask r3, long r4) {
        Object r0 = r3.v;
        monitor-enter(r0);
        Long r5 = r3.x;     // Catch: Throwable -> L14
        if (r5 == null) goto L11;
        if (r5.longValue() != r4) goto L11;
        boolean r6 = true;
    L12:
        monitor-exit(r0);
        return r6;
    L11:
        r6 = false;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.dora.impl.ota.p
    public final void e(e49.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "responseWrapper");
        n(r2, r3, null);
    }

    public final void p(int r6, int r7) {
        e49.a r0 = o().a();
        if (r0 != null) goto L6;
        d.b("DoraOTATask0711", "handleManualOTAStageChanged: ignore because response is null");
        return;
    L6:
        DoraOTAPeripheralStage r8 = this.e.c(r6, r7);
        d.d("DoraOTATask0711", "handleManualOTAStageChanged: peripheralStage=" + r8);
        if ((r8 instanceof DoraOTAPeripheralStage.a) == false) goto L9;
        return;
    L9:
        if ((r8 instanceof DoraOTAPeripheralStage.b) == false) goto L12;
        t(new d49.a.o(r0, ((DoraOTAPeripheralStage.b) r8).a));
        return;
    L12:
        if ((r8 instanceof DoraOTAPeripheralStage.f) == false) goto L35;
        if ((o() instanceof d49.a.p) == true) goto L54;
        t(new d49.a.p(r0));
        this.t = false;
        OTAUpdatePackage r9 = e49.b.a(r0);
        int r10 = j69.a.a;
        String r11 = null;
        if (r9 == null) goto L18;
        String r1 = r9.getUrl();
    L19:
        String r2 = "";
        if (r1 != null) goto L22;
        r1 = "";
    L22:
        j69.a.g(r1, this.u);
        d.d("DoraOTATask0711", "handleManualOTAStageChanged: deleteOTAFile");
        int r3 = k69.b.a;
        String r4 = this.d.a;
        if (r9 == null) goto L25;
        r11 = r9.getName();
    L25:
        if (r11 == null) goto L28;
        r2 = r11;
    L28:
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r2, "otaFileName");
        d.d("DoraOTAUtils", "deleteOTAFile：path=" + r4 + ", name=" + r2);     // Catch: Throwable -> L31
        DownloadUtils.deleteFile(r4, r2);     // Catch: Throwable -> L31
        d.d("DoraOTAUtils", "deleteOTAFile: " + r2 + " success");     // Catch: Throwable -> L31
    L33:
        d.d("DoraOTATask0711", "handleManualOTAStageChanged: PeripheralRestartFinished ##");
        this.l.sendEmptyMessageDelayed(1000, 600000);
        return;
    L31:
        th = move-exception;
        d.c("DoraOTAUtils", "deleteOTAFile: ERROR", th);
        goto L33
    L18:
        r1 = null;
        goto L19
    L54:
        return;
    L35:
        if ((r8 instanceof DoraOTAPeripheralStage.c) == false) goto L44;
        int r5 = j69.a.a;
        s(r0, "upgrade_firmware_failure_" + r6, ((DoraOTAPeripheralStage.c) r8).b);
        if (this.e.d(r6) == false) goto L56;
        d.d("DoraOTATask0711", "handleManualOTAStageChanged: requireFullPackage, isDebug=" + this.s);
        if (this.s == true) goto L57;
        DoraDevice r12 = kj4.a.g().c();
        if (r12 == null) goto L58;
        c(r12, DoraOTACheckFrom.REQUIRE_FULL_PACKAGE, false);
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L44:
        if (Intrinsics.areEqual(r8, DoraOTAPeripheralStage.d.a) == false) goto L46;
        return;
    L46:
        if ((r8 instanceof DoraOTAPeripheralStage.e) == false) goto L49;
        return;
    L49:
        throw new NoWhenBranchMatchedException();
    }

    public final void q(int r11, int r12) {
        d49.a r0 = o();
        if ((r0 instanceof d49.a.k) == true) goto L5;
    L8:
        e49.a r1 = o().a();
        if (r1 != null) goto L11;
    L33:
        d.b("DoraOTATask0711", "handleSilentOTAStageChanged: ignore because response is null");
        Job r13 = this.m;
        boolean r14 = false;
        if (r13 != null) goto L36;
    L38:
        if (r14 == false) goto L41;
        d.d("DoraOTATask0711", "handleSilentOTAStageChanged: ignore because job is active");
        return;
    L41:
        this.m = BuildersKt.launch$default(this.g, null, null, new DoraOTATask$handleSilentOTAStageChanged$2(this, null), 3, null);
        return;
    L36:
        if (r13.isActive() != true) goto L38;
        r14 = true;
        goto L38
    L11:
        if (r1.c == false) goto L33;
        DoraOTAPeripheralStage r15 = this.e.b(r11, r12);
        d.d("DoraOTATask0711", "handleSilentOTAStageChanged: peripheralStage=" + r15);
        if ((r15 instanceof DoraOTAPeripheralStage.a) == false) goto L17;
        t(new d49.a.k(r1, r12));
        return;
    L17:
        if ((r15 instanceof DoraOTAPeripheralStage.b) == false) goto L20;
        t(new d49.a.o(r1, ((DoraOTAPeripheralStage.b) r15).a));
        return;
    L20:
        if ((r15 instanceof DoraOTAPeripheralStage.f) == false) goto L23;
        t(new d49.a.p(r1));
        return;
    L23:
        if ((r15 instanceof DoraOTAPeripheralStage.c) == false) goto L26;
        s(r1, "", ((DoraOTAPeripheralStage.c) r15).b);
        return;
    L26:
        if (Intrinsics.areEqual(r15, DoraOTAPeripheralStage.d.a) == false) goto L28;
        return;
    L28:
        if ((r15 instanceof DoraOTAPeripheralStage.e) == false) goto L31;
        return;
    L31:
        throw new NoWhenBranchMatchedException();
    L5:
        if (((d49.a.k) r0).c.c == true) goto L8;
        d.d("DoraOTATask0711", "handleSilentOTAStageChanged: postInterruptSilentOTA");
        BuildersKt.launch$default(this.g, null, null, new DoraOTATask$handleSilentOTAStageChanged$1(null), 3, null);
    }

    public final void u(e49.a r23, e0 r24) {
        Intrinsics.checkNotNullParameter(r23, "responseWrapper");
        Object r1 = this.v;
        monitor-enter(r1);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.x == null) goto L7;
        boolean r2 = true;
    L8:
        long r4 = this.w + 1;     // Catch: Throwable -> L27
        this.w = r4;     // Catch: Throwable -> L27
        this.x = Long.valueOf(r4);     // Catch: Throwable -> L27
        if (r2 == false) goto L11;
        this.f.c("replaced");     // Catch: Throwable -> L27
    L11:
        this.t = false;     // Catch: Throwable -> L27
        this.u = 0;     // Catch: Throwable -> L27
        int r3 = j69.a.a;     // Catch: Throwable -> L27
        ReentrantLock r5 = j69.b.b;     // Catch: Throwable -> L27
        r5.lock();     // Catch: Throwable -> L27
        j69.b.a.clear();     // Catch: Throwable -> L24
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r5.unlock();     // Catch: Throwable -> L27
        j69.b.b("ota_update_begin");     // Catch: Throwable -> L27
        j69.a.b("ota_update_begin", MapsKt.emptyMap());     // Catch: Throwable -> L27
        t(new d49.a.e(r23));     // Catch: Throwable -> L27
        j69.a.b("ota_update_check", MapsKt.mapOf(TuplesKt.to("step", "start")));     // Catch: Throwable -> L27
        long r7 = this.w;     // Catch: Throwable -> L27
        monitor-exit(r1);
        int r8 = KeyLogUtils.a;
        KeyLogUtils.LogType r10 = KeyLogUtils.LogType.KEY;
        KeyLogUtils.DataLink r11 = KeyLogUtils.DataLink.OTA;
        KeyLogUtils.DataFlowDirection r12 = KeyLogUtils.DataFlowDirection.INTERNAL;
        KeyLogUtils.a r14 = new KeyLogUtils.a();
        z39.a r9 = r23.a;
        String r13 = null;
        if (r9 == null) goto L18;
        String r15 = r9.d();
    L19:
        r14.a("trace", r15);
        z39.a r16 = r23.a;
        if (r16 == null) goto L22;
        r13 = r16.c();
    L22:
        r14.a("task_id", r13);
        KeyLogUtils.a(r10, r11, r12, "ota_upload_start", r14, "-");
        BuildersKt.launch$default(this.g, null, null, new DoraOTATask$startDataTransfer$1(r23, this, r7, null, r24, null), 3, null);
        return;
    L18:
        r15 = null;
        goto L19
    L24:
        th = move-exception;
        r5.unlock();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L7:
        r2 = false;
        goto L8
    }

    public static final Object j(DoraOTATask r1, c r2, Continuation r3) {
        d r0 = r1.c;
        String r4 = r1.a;
        Object r5 = r0.a.emit(MapsKt.mapOf(TuplesKt.to(r4, r2)), r3);
        if (r5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        r5 = Unit.INSTANCE;
    L7:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r5;
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.larus.dora.impl.ota.p
    public final void c(DoraDevice r12, DoraOTACheckFrom r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "device");
        Intrinsics.checkNotNullParameter(r13, "from");
        d.a("DoraOTATask0711", "checkUpdate: from=" + r13 + " start, isDebug=" + r14);
        BuildersKt.launch$default(this.g, null, null, new DoraOTATask$checkUpdate$1(this, r13, r12, r14, null), 3, null);
    }

    @Override // com.larus.dora.impl.ota.o
    public final void d(int r5, int r6, int r7) {
        Object r1 = this.v;
        monitor-enter(r1);
        d.d("DoraOTATask0711", "handleOTAStageChanged: stage=" + r5 + ", progress=" + r6 + ", type=" + r7);     // Catch: Throwable -> L11
        this.y = r5;     // Catch: Throwable -> L11
        if (r7 != 0) goto L7;
        p(r5, r6);     // Catch: Throwable -> L11
    L8:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r1);
        return;
    L7:
        q(r5, r6);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void n(e49.a r16, boolean r17, final h r18) {
        Intrinsics.checkNotNullParameter(r16, "responseWrapper");
        d.d("DoraOTATask0711", "download: start, response=" + r16 + ", onlyWifi=" + r17);
        final AtomicBoolean r2 = new AtomicBoolean(false);
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = new m(this, r18, r2, r6);
        Object r3 = this.p;
        monitor-enter(r3);
        this.r = false;     // Catch: Throwable -> L12
        Object r1 = r6.element;     // Catch: Throwable -> L12
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("finish");     // Catch: Throwable -> L12
        Function0<Unit> r4 = null;
    L8:
        this.q = r4;     // Catch: Throwable -> L12
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r3);
        BuildersKt.launch$default(this.g, null, null, new DoraOTATask$download$3(r2, r16, this, r17, r6, null), 3, null);
        return;
    L7:
        r4 = (Function0) r1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final void s(e49.a r10, String r11, c r12) {
        StringBuilder r0 = new StringBuilder("onOTAFailed: response=");
        r0.append(r10);
        r0.append(", failReason=");
        r0.append(r11);
        r0.append(", failIntent=");
        String r1 = null;
        if (r12 == null) goto L5;
        String r2 = r12.a();
    L6:
        r0.append(r2);
        d.d("DoraOTATask0711", r0.toString());
        this.t = false;
        t(new d49.a.m(r10, r11));
        if (r12 == null) goto L10;
        BuildersKt.launch$default(this.g, null, null, new DoraOTATask$onOTAFailed$1(this, r12, null), 3, null);
    L10:
        if (r11.length() <= 0) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L21;
        int r14 = j69.a.a;
        OTAUpdatePackage r15 = e49.b.a(r10);
        if (r15 == null) goto L17;
        r1 = r15.getUrl();
    L17:
        if (r1 != null) goto L19;
        r1 = "";
    L19:
        int r16 = this.u;
        Intrinsics.checkNotNullParameter(r1, "downloadUrl");
        Intrinsics.checkNotNullParameter(r11, "failReason");
        j69.a.b("ota_update_end", MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", Long.valueOf(j69.b.a("ota_update_begin"))), TuplesKt.to("update_status", "failure"), TuplesKt.to("package_host", j69.a.a(r1)), TuplesKt.to("fail_reason", r11), TuplesKt.to("error_message", "ota_".concat(r11)), TuplesKt.to("retrycount", Integer.valueOf(r16))}));
        DoraOTAReporter.c(r11);
        return;
    L21:
        return;
    L12:
        r13 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void r(e49.a r8, String r9, c r10, Integer r11) {
        int r0 = KeyLogUtils.a;
        KeyLogUtils.a(KeyLogUtils.LogType.ERROR, KeyLogUtils.DataLink.OTA, KeyLogUtils.DataFlowDirection.INTERNAL, "ota_download_end", null, "traceFailCode:" + r11 + ", failReason:" + r9);
        t(new d49.a.i(r8, r9));
        String r12 = null;
        if (r10 == null) goto L5;
        BuildersKt.launch$default(this.g, null, null, new DoraOTATask$onDownloadFailed$1(this, r10, null), 3, null);
    L5:
        if (r11 == null) goto L13;
        int r13 = j69.a.a;
        OTAUpdatePackage r14 = e49.b.a(r8);
        if (r14 == null) goto L9;
        r12 = r14.getUrl();
    L9:
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        int r15 = r11.intValue();
        Intrinsics.checkNotNullParameter(r12, "downloadUrl");
        String r16 = "download_package_failure_" + r15;
        j69.a.b("ota_update_download", MapsKt.mapOf(new Pair[]{TuplesKt.to("step", "end"), TuplesKt.to("package_host", j69.a.a(r12)), TuplesKt.to("duration", Long.valueOf(j69.b.a("ota_update_download"))), TuplesKt.to("fail_reason", r16), TuplesKt.to("error_message", "ota_" + r16)}));
        DoraOTAReporter.b(r16);
        return;
    }

    @Override // com.larus.dora.impl.ota.p
    public final void b(DoraDevice r18, String r110, String r20, String r21, int r22) {
        String r4 = r20;
        Intrinsics.checkNotNullParameter(r18, "device");
        Intrinsics.checkNotNullParameter(r110, "androidBuildTime");
        Intrinsics.checkNotNullParameter(r4, "androidOSVersion");
        Intrinsics.checkNotNullParameter(r21, "androidRomVersion");
        if (this.i.length() <= 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L8;
    L20:
        boolean r7 = false;
    L22:
        if (r7 == true) goto L29;
        this.h = r110;
        this.i = r4;
        this.j = r21;
        this.k = r22;
        int r10 = KeyLogUtils.a;
        KeyLogUtils.LogType r11 = KeyLogUtils.LogType.KEY;
        KeyLogUtils.DataLink r12 = KeyLogUtils.DataLink.OTA;
        KeyLogUtils.DataFlowDirection r13 = KeyLogUtils.DataFlowDirection.UPLINK;
        KeyLogUtils.a r15 = new KeyLogUtils.a();
        r15.a("android_os_version", r4);
        r15.a("android_rom_version", r21);
        Intrinsics.checkNotNullParameter("android_pkg_type", "key");
        r15.a.put("android_pkg_type", r22);     // Catch: JSONException -> L26
    L28:
        r15.a("android_build_time", r110);
        KeyLogUtils.a(r11, r12, r13, "ota_android_info", r15, "-");
    L30:
        d49.a r0 = o();
        d.d("DoraOTATask0711", "onOTAAndroidInfo: currentState=" + r0);
        String r5 = null;
        if ((r0 instanceof d49.a.g) == false) goto L34;
        e49.a r1 = ((d49.a.g) r0).c;
    L41:
        if (r1 == null) goto L83;
        boolean r8 = r1.b;
        d.d("DoraOTATask0711", "onOTAAndroidInfo: isNuttxFirmware=" + r8);
        if (r8 == false) goto L45;
        r4 = r18.softVersion;
    L45:
        OTAUpdatePackage r14 = e49.b.a(r1);
        if (r14 == null) goto L48;
        String r16 = r14.getVersion();
    L49:
        String r17 = "";
        if (r16 != null) goto L52;
        r16 = "";
    L52:
        d.d("DoraOTATask0711", "onOTAAndroidInfo: compareVersion: current=" + r4 + ", target=" + r16);
        int r111 = g0.a;
        Intrinsics.checkNotNull(r4);
        if (g0.a(r4, r16) < 0) goto L82;
        d.d("DoraOTATask0711", "onOTAAndroidInfo: OTA success ##");
        String r112 = r18.androidRomVersion;
        String r113 = r18.softVersion;
        d49.b r9 = new d49.b(r112, r113);
        if (r113 != null) goto L58;
        r113 = "";
    L58:
        if (g0.a(r113, r16) < 0) goto L60;
        boolean r114 = true;
    L61:
        Intrinsics.checkNotNullParameter(r9, "currentDevice");
        Intrinsics.checkNotNullParameter(r16, "targetVersion");
        if (r8 == true) goto L71;
        if (r114 == true) goto L71;
        if (r16.length() <= 0) goto L67;
        boolean r23 = true;
    L68:
        if (r23 == false) goto L71;
        r9 = new d49.b(r112, r16);
        goto L71
    L67:
        r23 = false;
    L71:
        if (this.t == false) goto L80;
        this.t = false;
        d.d("DoraOTATask0711", "reportSkipUploadSuccessIfNeeded: report OTA success for skip-upload flow");
        int r24 = j69.a.a;
        OTAUpdatePackage r2 = e49.b.a(r1);
        if (r2 == null) goto L76;
        r5 = r2.getUrl();
    L76:
        if (r5 == null) goto L79;
        r17 = r5;
    L79:
        j69.a.g(r17, 0);
    L80:
        d.d("DoraOTATask0711", "onOTASuccess: " + r9);
        t(new d49.a.n(r9));
        DoraSystemInfoManager r3 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.f(CollectionsKt.listOf(new Pair[]{TuplesKt.to("fw_version", o59.a.e(r18)), TuplesKt.to("has_new_firmware_available", "0")}));
        return;
    L60:
        r114 = false;
        goto L61
    L82:
        d.d("DoraOTATask0711", "onOTAAndroidInfo: OTA failed ##");
        s(r1, "", com.larus.dora.impl.ota.a.e.a);
    L86:
        DoraSystemInfoManager r25 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("fw_version", o59.a.e(r18))));
        c(r18, DoraOTACheckFrom.ANDROID_INFO_RECEIVED, false);
        return;
    L48:
        r16 = null;
        goto L49
    L83:
        if (r7 == false) goto L86;
        d.d("DoraOTATask0711", "onOTAAndroidInfo: version has been set and no pending ota state, return");
        return;
    L34:
        if ((r0 instanceof d49.a.o) == false) goto L37;
        r1 = ((d49.a.o) r0).c;
        goto L41
    L37:
        if ((r0 instanceof d49.a.p) == false) goto L39;
        r1 = ((d49.a.p) r0).c;
        goto L41
    L39:
        r1 = null;
    L26:
        e = move-exception;
        KeyLogUtils.a.b("android_pkg_type", e);
        goto L28
    L29:
        d.d("DoraOTATask0711", "onOTAAndroidInfo: version has been set, continue ota state check");
        goto L30
    L8:
        if (this.j.length() <= 0) goto L10;
        boolean r26 = true;
    L11:
        if (r26 == false) goto L20;
        if (this.k == (-1)) goto L20;
        if (this.h.length() <= 0) goto L17;
        boolean r27 = true;
    L18:
        if (r27 == false) goto L20;
        r7 = true;
        goto L22
    L17:
        r27 = false;
        goto L18
    L10:
        r26 = false;
        goto L11
    L5:
        r6 = false;
        goto L6
    }

    public DoraOTATask(String r2, k r3, d r4, j r5, DoraGOTAPlugin r6, DoraOTAWifiConnector r7) {
        Intrinsics.checkNotNullParameter(r2, "sn");
        Intrinsics.checkNotNullParameter(r3, "otaStateFlow");
        Intrinsics.checkNotNullParameter(r4, "otaIntentSharedFlow");
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r6, "plugin");
        Intrinsics.checkNotNullParameter(r7, "connector");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = -1;
        this.l = new Handler(Looper.getMainLooper(), new l());
        AppHost.Companion r8 = AppHost.a;
        if (r8.isDebug() == false) goto L5;
    L8:
        boolean r9 = true;
    L9:
        d.d("DoraOTATask0711", "init......" + hashCode() + ", isDebug=" + r9);
        if (r9 == false) goto L12;
        Logger.setLogLevel(2);
        Logger.registerLogHandler(new k69.a());
    L12:
        this.p = new Object();
        this.v = new Object();
        this.y = -1;
        return;
    L5:
        if (r8.isTestChannel() == true) goto L8;
        r9 = false;
        goto L9
    }
}
