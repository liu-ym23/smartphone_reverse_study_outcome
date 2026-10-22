package com.larus.dora.impl.ota.connector;

import com.bytedance.dora.transfer.DoraTransferDirection;
import com.ttnetuploader.uploader.api.IUploadCallback;
import com.ttnetuploader.uploader.api.ResultInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ok4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTAWifiConnector$b implements IUploadCallback {
    public final /* synthetic */ DoraOTAWifiConnector a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ Ref.LongRef d;
    public final /* synthetic */ Ref.IntRef e;
    public final /* synthetic */ h f;
    public final /* synthetic */ b g;
    public final /* synthetic */ String h;
    public final /* synthetic */ Ref.BooleanRef i;
    public final /* synthetic */ Ref.IntRef j;
    public final /* synthetic */ Long k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;
    public final /* synthetic */ String n;

    public final void onFailed(ResultInfo r27) {
        Intrinsics.checkNotNullParameter(r27, "uploadInfo");
        Object r3 = this.a.c;
        Ref.IntRef r4 = this.j;
        monitor-enter(r3);
        int r5 = r4.element;     // Catch: Throwable -> L64
        monitor-exit(r3);
        g49.d.b("DoraOTAWifiConnector", "dataTransfer: onFailed: code=" + r27.code + ", retryCount=" + r5);
        final DoraOTAWifiConnector r6 = this.a;
        Object r7 = r6.c;
        final int r9 = this.b;
        final Ref.BooleanRef r10 = this.c;
        final Ref.BooleanRef r15 = this.i;
        final Ref.LongRef r14 = this.d;
        final Long r8 = this.k;
        final Ref.IntRef r13 = this.j;
        final String r12 = this.l;
        String r11 = this.m;
        final String r16 = this.n;
        final Ref.IntRef r17 = this.e;
        final h r18 = this.f;
        final b r2 = this.g;
        final String r20 = this.h;
        monitor-enter(r7);
        boolean r110 = false;
        if (r6.f == r9) goto L72;
    L52:
        ResultInfo r21 = r27;
    L53:
        monitor-exit(r7);
        if (r110 == false) goto L57;
        return;
    L57:
        if (DoraOTAWifiConnector.e(this.a, this.b, this.c, this.i, this.j) == true) goto L59;
        return;
    L59:
        k.a("upload_failed");
        ok4.e r0 = this.g;
        String r22 = this.h;
        DoraOTAWifiConnector r23 = this.a;
        long r24 = this.d.element;
        r23.getClass();
        int r25 = (int) RangesKt.coerceIn(r24, 0, 2147483647L);
        DoraTransferDirection r26 = DoraTransferDirection.UPLINK;
        r0.d(r22, r25);
        this.g.b(this.h, ok4.a.b, new ok4.f.a(String.valueOf(r21.code)));
        this.f.a(r21.uploadId, r21.code, r27.getUploadLog());
        return;
    L72:
    L50:
        th = th;
    L62:
        monitor-exit(r7);
        throw th;
    L13:
        if (r10.element == true) goto L52;
        if (r15.element == false) goto L18;
        r21 = r27;
    L49:
        r110 = true;
        goto L53
    L18:
        r6.a = null;     // Catch: Throwable -> L50
        r14.element = Math.max(r14.element, r27.uploadedLen);     // Catch: Throwable -> L50
        int r1 = r27.code;     // Catch: Throwable -> L50
        if (r1 != 1038) goto L21;
        boolean r28 = true;
    L22:
        if (r28 == false) goto L24;
        r6.a = r8;     // Catch: Throwable -> L50
    L24:
        int r30 = DoraOTAWifiConnector.i;     // Catch: Throwable -> L50
        String r31 = r27.getUploadLog();     // Catch: Throwable -> L50
        if (r31 != null) goto L27;
        r31 = "";
    L27:
        int r32 = r13.element;     // Catch: Throwable -> L50
        Intrinsics.checkNotNullParameter(r31, "uploadLog");     // Catch: Throwable -> L50
        if (r1 != 1038) goto L30;
        boolean r33 = true;
    L32:
        if (r1 != 1009) goto L36;
        String r210 = r11;
        if (StringsKt.contains(r31, "task duplicate", true) == false) goto L37;
        boolean r34 = true;
    L38:
        if (r34 == false) goto L40;
        int r35 = 4;
    L42:
        if (r1 == 1009) goto L44;
        if (r33 == true) goto L44;
    L45:
        Long r36 = null;
    L47:
        if (r36 == null) goto L52;
        int r37 = r13.element + 1;     // Catch: Throwable -> L50
        r13.element = r37;     // Catch: Throwable -> L50
        r6.g = r37;     // Catch: Throwable -> L50
        final boolean r38 = r28;
        final String r211 = r210;
        Runnable r40 = new f(r6, r38, r8, r9, r10, r15, r12, r211, r16, r14, r17, r18, r2, r20, r13);     // Catch: Throwable -> L50
        r6.e = r40;     // Catch: Throwable -> L50
        r15.element = true;     // Catch: Throwable -> L50
        r6.d.postDelayed(r40, r36.longValue());     // Catch: Throwable -> L50
        StringBuilder r41 = new StringBuilder("dataTransfer: retry for code=");     // Catch: Throwable -> L50
        r21 = r27;
        r41.append(r21.code);     // Catch: Throwable -> L50
        r41.append(", retryCount=");     // Catch: Throwable -> L50
        r41.append(r13.element);     // Catch: Throwable -> L50
        r41.append(", delayMs=");     // Catch: Throwable -> L50
        r41.append(r36);     // Catch: Throwable -> L50
        g49.d.d("DoraOTAWifiConnector", r41.toString());     // Catch: Throwable -> L50
    L44:
        if (r32 >= r35) goto L45;
        r36 = Long.valueOf((1 << r32) * 2000);     // Catch: Throwable -> L50
        goto L47
    L40:
        r35 = 3;
    L37:
        r34 = false;
        goto L38
    L36:
        r210 = r11;
        goto L37
    L30:
        r33 = false;
        goto L32
    L21:
        r28 = false;
    L61:
        th = th;
    L64:
        th = move-exception;
        throw th;
    }

    public final void onSuccess(ResultInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "uploadInfo");
        g49.d.b("DoraOTAWifiConnector", "dataTransfer: onSuccess uploadInfo=" + r6 + ", code=" + r6.code);
        if (DoraOTAWifiConnector.e(this.a, this.b, this.c, this.i, this.j) == true) goto L5;
        return;
    L5:
        k.a("upload_success");
        ok4.e r0 = this.g;
        String r1 = this.h;
        int r3 = (int) r6.totalLen;
        DoraTransferDirection r2 = DoraTransferDirection.UPLINK;
        r0.d(r1, r3);
        this.g.b(this.h, ok4.a.b, ok4.f.b);
        this.f.onSuccess(r6.uploadId);
    }

    public final void onProgress(long r5, long r7, long r9, long r11) {
        g49.d.d("DoraOTAWifiConnector", "dataTransfer: onProgress uploadId=" + r5 + ", uploadedLen=" + r7 + ", totalLen=" + r9 + ", speed=" + r11);
        DoraOTAWifiConnector r12 = this.a;
        Object r13 = r12.c;
        int r0 = this.b;
        Ref.BooleanRef r1 = this.c;
        Ref.LongRef r2 = this.d;
        Ref.IntRef r3 = this.e;
        monitor-enter(r13);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r12.f == r0) goto L7;
    L16:
        Integer r8 = null;
    L17:
        monitor-exit(r13);
        if (r8 == null) goto L25;
        this.f.b(r5, r8.intValue());
        return;
    L25:
        return;
    L7:
        if (r1.element == true) goto L16;
        r2.element = Math.max(r2.element, r7);     // Catch: Throwable -> L14
        int r14 = 0;
        if (r9 <= 0) goto L12;
        r14 = RangesKt.coerceIn((int) ((r7 * ((long) 100)) / r9), 0, 100);     // Catch: Throwable -> L14
    L12:
        int r10 = Math.max(r3.element, r14);     // Catch: Throwable -> L14
        r3.element = r10;     // Catch: Throwable -> L14
        r8 = Integer.valueOf(r10);     // Catch: Throwable -> L14
        goto L17
    }

    public DoraOTAWifiConnector$b(DoraOTAWifiConnector r1, int r2, Ref.BooleanRef r3, Ref.LongRef r4, Ref.IntRef r5, h r6, b r7, String r8, Ref.BooleanRef r9, Ref.IntRef r10, Long r11, String r12, String r13, String r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }
}
