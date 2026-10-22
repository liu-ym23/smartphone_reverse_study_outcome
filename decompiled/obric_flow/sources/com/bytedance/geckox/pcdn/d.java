package com.bytedance.geckox.pcdn;

import android.net.Uri;
import com.bytedance.android.live.pcdn.api.IPCDNDownloadTask;
import com.bytedance.android.live.pcdn.api.IPCDNDownloader;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.meta.PrepareMeta;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final AtomicInteger g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile IPCDNDownloader f4773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile File f4774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f4775j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f4776k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IPCDNDownloader f4778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4779c;
    public final String d;
    public final PrepareMeta e;
    public final na.b f;

    static {
        f4776k = new b();
        g = new AtomicInteger(0);
        f4775j = LazyKt.lazy(GeckoXOdlDownloader$Companion$odlListenerImpl$2.f4772a);
    }

    public d(String r5, String r10, PrepareMeta r11, na.b r12) {
        this.f4779c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.f4777a = g.incrementAndGet();
        this.f4778b = f4773h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v45, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r7v10, types: [T, java.lang.String] */
    public final void a() {
        IPCDNDownloadTask r5 = "odl_cache/";
        if (this.f4778b == null) goto L88;
        String r10 = this.e.getPackage().getMd5();
        String r11 = this.e.getAccessKey() + '-' + this.e.getChannel() + '-' + this.e.getVersion() + '-' + this.d;
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = null;
        na.b r13 = this.f;
        String r14 = this.f4779c;
        String r15 = Uri.parse(r14).getHost();
        if (r15 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r13.f20222b = new ta.a(r14, r15, this.e.getPackage().getLength());
        long r16 = System.currentTimeMillis();
        IPCDNDownloadTask r17 = this.f4778b.createTask(this.f4779c, r10, r11);
        if (r17 == null) goto L86;
        r17.setStringValue("notify_sizeinfo", "true");
        StringBuilder r18 = new StringBuilder("[pcdn][");
        r18.append(this.f4777a);
        r18.append("]Start to perform odl task ");
        r18.append(r17.hashCode());
        r18.append(" for ");
        f8.b.e(r18, this.f4779c, ", uniqueId=", r10, ", fileName=");
        r18.append(r11);
        GeckoLogger.a(r18.toString());
        CountDownLatch r19 = new CountDownLatch(1);
        Ref.IntRef r110 = new Ref.IntRef();
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        Pair r112 = new Pair(0, "");
        r110.element = ((Number) r112.component1()).intValue();
        r111.element = (String) r112.component2();
        Ref.BooleanRef r20 = new Ref.BooleanRef();
        r20.element = false;
        Ref.BooleanRef r113 = new Ref.BooleanRef();
        r113.element = false;
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = null;
        int r21 = r17.start(new c());
        if (r21 == 0) goto L102;
        r5 = r17;
    L74:
        th = th;
    L18:
        long r22 = -1;
    L76:
        PrepareMeta r23 = this.e;
        r23.odlDuration = r22;
        OdlDownloadSize r24 = (OdlDownloadSize) r114.element;
        if (r24 == null) goto L82;
        r23.odlP2PReceivedBytes = r24.getP2pSize();
        PrepareMeta r25 = this.e;
        OdlDownloadSize r26 = (OdlDownloadSize) r114.element;
        if (r26 != null) goto L81;
        Intrinsics.throwNpe();
    L81:
        r25.odlCDNReceivedBytes = r26.getCdnSize();
    L83:
        r5.deleteFile();
        r5.stop();
        this.f4778b.deleteTask(r5);
        throw th;
    L82:
        GeckoLogger.a("[pcdn][" + this.f4777a + "]Odl not pass download_sizeinfo through");
        goto L83
    L73:
        throw new IllegalStateException("Odl start task failed, ret=" + r21);     // Catch: Throwable -> L74
    L102:
        if (r113.element == false) goto L89;
        IPCDNDownloadTask r115 = r17;
    L22:
        r22 = System.currentTimeMillis() - r16;
        GeckoLogger.a("[pcdn][" + this.f4777a + "]Odl task complete, result=" + r20.element + ", costTime=" + r22);     // Catch: Throwable -> L33
        if (r20.element == false) goto L68;
        File r27 = (File) r12.element;     // Catch: Throwable -> L33
        if (r27 != null) goto L29;
    L36:
        FileInputStream r28 = new FileInputStream((File) r12.element);     // Catch: Throwable -> L33
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L42
        long r30 = ByteStreamsKt.copyTo(r28, this.f, 8192);     // Catch: Throwable -> L44
    L40:
        CloseableKt.closeFinally(r28, null);     // Catch: Throwable -> L42
        Object r31 = Result.m124constructorimpl(Long.valueOf(r30));     // Catch: Throwable -> L42
    L52:
        Throwable r32 = Result.m127exceptionOrNullimpl(r31);     // Catch: Throwable -> L33
        if (r32 != null) goto L64;
        PrepareMeta r33 = this.e;
        r33.odlDuration = r22;
        OdlDownloadSize r34 = (OdlDownloadSize) r114.element;
        if (r34 != null) goto L57;
        GeckoLogger.a("[pcdn][" + this.f4777a + "]Odl not pass download_sizeinfo through");
    L61:
        r115.deleteFile();
        r115.stop();
        this.f4778b.deleteTask(r115);
        return;
    L57:
        r33.odlP2PReceivedBytes = r34.getP2pSize();
        PrepareMeta r35 = this.e;
        OdlDownloadSize r36 = (OdlDownloadSize) r114.element;
        if (r36 != null) goto L60;
        Intrinsics.throwNpe();
    L60:
        r35.odlCDNReceivedBytes = r36.getCdnSize();
        goto L61
    L64:
        throw r32;     // Catch: Throwable -> L65
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        CloseableKt.closeFinally(r28, th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L33
        r31 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L52
    L29:
        if (r27.exists() == true) goto L36;
        GeckoLogger.a("[pcdn][" + this.f4777a + "]Odl not pass file_path through, assign default");     // Catch: Throwable -> L33
        File r38 = f4774i;     // Catch: Throwable -> L33
        if (r38 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");     // Catch: Throwable -> L33
    L35:
        r12.element = new File(r38, "odl_cache/" + r11);     // Catch: Throwable -> L33
        goto L36
    L68:
        throw new IOException("Odl running task failed, errCode=" + r110.element + ", errMsg=" + ((String) r111.element));     // Catch: Throwable -> L65
    L65:
        th = th;
    L33:
        th = th;
        r5 = r115;
    L16:
        th = th;
    L17:
        r5 = r115;
        goto L18
    L89:
        GeckoLogger.a("[pcdn][" + this.f4777a + "]Waiting odl task complete...");     // Catch: Throwable -> L19
        r115 = r17;
        r19.await(1, TimeUnit.MINUTES);     // Catch: Throwable -> L16
    L19:
        th = th;
        r115 = r17;
    L69:
        th = th;
        r5 = r17;
        goto L18
    L86:
        throw new IllegalStateException("Create odl task failed, receive null");
    L88:
        throw new IllegalStateException("Odl downloader still be null, do you invoke initIfNeed?");
    }
}
