package hf;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.n;
import com.bytedance.geckox.utils.BsPatch;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.meta.h;
import com.bytedance.iesgurd.update.ErrorCode;
import com.bytedance.iesgurd.update.UpdateException;
import com.lynx.tasm.ui.image.f0;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mn.i;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f17309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17310c;
    public int d;
    public pa.a e;
    public final PrepareMeta f;
    public final n g;

    public c(PrepareMeta r5, n r10) {
        this.f = r5;
        this.g = r10;
        if (r5.getUpdateWithPatch() == false) goto L5;
        String r11 = "DOWNLOAD_PATCH";
    L6:
        this.f17308a = r11;
        return;
    L5:
        r11 = "DOWNLOAD_FULL";
        goto L6
    }

    public static void c(String r5, PrepareMeta r10, na.b r11) {
        df.c.f16652i.a();     // Catch: Throwable -> L8
        ta.b r12 = df.c.f.getNetWork();     // Catch: Throwable -> L8
        MapsKt.emptyMap();     // Catch: Throwable -> L8
        r10.getPackage().getLength();     // Catch: Throwable -> L8
        r12.c(r5, r11);     // Catch: Throwable -> L8
        if (r11.f20222b == null) goto L15;
        r10.originCDNDuration = 0;
        r10.originCDNReceivedBytes = 0;
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (r11.f20222b == null) goto L12;
        r10.originCDNDuration = 0;
        r10.originCDNReceivedBytes = 0;
    L12:
        throw th;
    }

    public final void a() {
        String r5 = "";
        long r10 = System.currentTimeMillis();
        PrepareMeta r11 = this.f;
        List<String> r12 = r11.getPackage().getUrlList();
        String r13 = r12.get(this.d);
        h r14 = this.f17309b;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L5:
        com.bytedance.iesgurd.meta.g r15 = r14.a(r11.getUpdateWithPatch());
        r15.d = r13;
        b(r13);     // Catch: Throwable -> L95
        h r16 = this.f17309b;
        if (r16 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L10:
        r16.e = System.currentTimeMillis() - r10;
        h r17 = this.f17309b;
        if (r17 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L13:
        r17.d = System.currentTimeMillis() - this.f17310c;
        ((Executor) com.bytedance.geckox.utils.c.e.getValue()).execute(new b(this, 1));
        ug.d r18 = new ug.d(r11);
        long r19 = System.currentTimeMillis();
        GeckoLogger.a("[" + r11 + "]start active");
        boolean r20 = r11.getUpdateWithPatch();
        boolean r21 = r11.getUseZstd();
        File r22 = (File) r18.e;
        File r110 = (File) r18.f;
        File r111 = (File) r18.d;
        h r112 = (h) r18.f22358c;
        if (r21 == false) goto L49;
        GeckoLogger.a("[" + r11 + "]start decompress zstd");
        long r113 = System.currentTimeMillis();
        ((la.a) r18.f22357b).g(0);
        File r23 = new File(r11.getUpdatingDir(), "res.zst.tmp");
        com.bytedance.geckox.utils.d.j(r23);
        la.a r24 = f0.e(r23.length(), r23);
        com.bytedance.geckox.utils.d.i((la.a) r18.f22357b, r24);     // Catch: Throwable -> L41 Exception -> L43
        ((la.a) r18.f22357b).e();
        r24.g(0);
        MD5Utils.INSTANCE.check$geckox_noasanRelease(new na.a(r24), r11.getPackage().getDecompressMd5());     // Catch: Throwable -> L38
        r18.f22357b = r24;
        r11.setUpdateBuffer(r24);
        r112.f6659h = System.currentTimeMillis() - r113;
        if (r20 == false) goto L37;
        GeckoLogger.a("[" + r11 + "]start merge dir");
        long r114 = System.currentTimeMillis();
        File r25 = ((la.a) r18.f22357b).b();
        ((la.a) r18.f22357b).d();
        ((la.a) r18.f22357b).release();
        LinkedHashMap r26 = ra.b.f21714a;
        if (ra.b.b(r111.getAbsolutePath()) == false) goto L36;
        new a().d(r110, r22, r25);     // Catch: Throwable -> L25 BytePatchException -> L27
        ra.b.c(r111.getAbsolutePath());
        r25.delete();
        r112.f6660i = System.currentTimeMillis() - r114;
    L127:
        new i(r11).j();     // Catch: Throwable -> L92
        r112.f = System.currentTimeMillis() - r19;
        return;
    L92:
        th = move-exception;
        throw new UpdateException(ErrorCode.f6709n, th.getMessage());
    L27:
        e = move-exception;
        GeckoLogger.b("[" + ((PrepareMeta) r18.g) + "]merge dir failed: " + e.getMessage());     // Catch: Throwable -> L25
        int r27 = e.f6622a;     // Catch: Throwable -> L25
        String r28 = e.getMessage();     // Catch: Throwable -> L25
        if (r28 == null) goto L32;
        r5 = r28;
    L32:
        throw new UpdateException(r27, r5);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        LinkedHashMap r29 = ra.b.f21714a;
        ra.b.c(r111.getAbsolutePath());
        r25.delete();
        throw th;
    L36:
        throw new UpdateException(ErrorCode.f6705j, "read lock failed");
    L37:
        r18.k();
    L38:
        th = move-exception;
        r24.e();
        throw new UpdateException(ErrorCode.f6707l, th.getMessage());
    L43:
        e = move-exception;
        r24.e();     // Catch: Throwable -> L41
        throw new UpdateException(ErrorCode.f6706k, e.getMessage());     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        ((la.a) r18.f22357b).e();
        throw th;
    L49:
        if (r11.isSingleFile() == false) goto L88;
        if (r20 == false) goto L80;
        GeckoLogger.a("[" + r11 + "]start merge patch");
        long r30 = System.currentTimeMillis();
        File r31 = ((la.a) r18.f22357b).b();
        ((la.a) r18.f22357b).d();
        ((la.a) r18.f22357b).release();
        File[] r32 = r110.listFiles();
        if (r32 == null) goto L78;
        if (r32.length == 0) goto L78;
        File r33 = r32[0];
        File r34 = r18.a();
        String r35 = r111.getAbsolutePath();
        if (ra.b.b(r35) == false) goto L76;
        BsPatch.f4780a.a(r33, r31, r34.getParentFile(), r34.getName());     // Catch: Throwable -> L68 Exception -> L70
        ra.b.c(r35);
        com.bytedance.geckox.utils.d.j(r31);
        la.a r36 = f0.e(r34.length(), r34);
        r36.g(0);
        MD5Utils r37 = MD5Utils.INSTANCE;     // Catch: Throwable -> L62
        na.a r38 = new na.a(r36);     // Catch: Throwable -> L62
        PrepareMetaPackage r39 = r11.getFullPackage();     // Catch: Throwable -> L62
        if (r39 != null) goto L64;
        Intrinsics.throwNpe();     // Catch: Throwable -> L62
    L64:
        r37.check$geckox_noasanRelease(r38, r39.getMd5());     // Catch: Throwable -> L62
        r18.f22357b = r36;
        r11.setUpdateBuffer(r36);
        r112.f6661j = System.currentTimeMillis() - r30;
    L62:
        th = move-exception;
        throw new UpdateException(ErrorCode.g, th.getMessage());
    L70:
        e = move-exception;
        throw new UpdateException(ErrorCode.f, e.getMessage());     // Catch: Throwable -> L68
    L76:
        throw new UpdateException(ErrorCode.f6703h, "read lock failed");
    L68:
        th = move-exception;
        ra.b.c(r35);
        com.bytedance.geckox.utils.d.j(r31);
        throw th;
    L78:
        throw new UpdateException(ErrorCode.f6704i, "get old file is null");
    L80:
        if (r22.mkdirs() == false) goto L87;
        if (r11.getDownloadFile().renameTo(r18.a()) == true) goto L127;
        throw new UpdateException(ErrorCode.f6708m, "single file channel rename failed");
    L87:
        throw new UpdateException(ErrorCode.f6708m, "single file channel make dir failed");
    L88:
        r18.k();
    L95:
        th = move-exception;
        if (this.g.f4765l == true) goto L101;
        if (r11.getUsePcdn() == true) goto L101;
    L105:
        if ((th instanceof UpdateException) == false) goto L107;
        int r40 = th.f6712a;
    L108:
        String r41 = th.getMessage();
        if (r41 == null) goto L111;
        r5 = r41;
    L111:
        UpdateException r42 = new UpdateException(r40, r5);
        ((Executor) com.bytedance.geckox.utils.c.e.getValue()).execute(new b(this, 0));
        throw r42;
    L107:
        r40 = 102;
    L101:
        if (this.d >= (r12.size() - 1)) goto L105;
        this.d++;
        r15.e++;
        a();
    }

    public final void b(String r13) {
        StringBuilder r5 = new StringBuilder("[");
        PrepareMeta r10 = this.f;
        r5.append(r10);
        r5.append("]download url: ");
        r5.append(r13);
        GeckoLogger.a(r5.toString());
        PrepareMetaPackage r11 = r10.getPackage();
        long r12 = r11.getLength();
        if (r10.getUsePcdn() == true) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r14 == false) goto L15;
        String r15 = com.bytedance.geckox.pcdn.d.f4776k.b();
        if (r15 == null) goto L15;
        if (r15.length() == 0) goto L15;
        r10.odlFallbackReason = r15;
        boolean r16 = false;
    L16:
        na.b r17 = null;
        if (r16 == true) goto L28;
        la.a r18 = f0.e(r12, r10.getDownloadFile());     // Catch: Throwable -> L26
        na.b r19 = new na.b(r18, this.g, this.f, r12);     // Catch: Throwable -> L24
        c(r13, r10, r19);     // Catch: Throwable -> L22
    L32:
        ta.a r110 = r19.f20222b;
        if (r110 == null) goto L35;
        r110.a();
    L35:
        r18.mo119finish();
        r18.g(0);     // Catch: Throwable -> L39
        MD5Utils.INSTANCE.check$geckox_noasanRelease(new na.a(r18), r11.getMd5());     // Catch: Throwable -> L39
        r10.setUpdateBuffer(r18);
        return;
    L39:
        th = move-exception;
        r18.e();
        if (r16 == false) goto L44;
        r10.odlFallbackReason = th.getMessage();
    L44:
        throw new UpdateException(ErrorCode.d, th.getMessage());
    L28:
        r18 = f0.e(r12, r10.getDownloadFile());     // Catch: Throwable -> L26
        r19 = new na.b(r18, this.g, this.f, r12);     // Catch: Throwable -> L24
        r10.odlUseUrl = r13;     // Catch: Throwable -> L22
        new com.bytedance.geckox.pcdn.d(r13, this.f17308a, r10, r19).a();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        r10.odlFallbackReason = th.toString();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = th;
        r17 = r19;
    L48:
        if (r18 == null) goto L53;
        r18.e();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (r17 == null) goto L58;
        ta.a r111 = r17.f20222b;
        if (r111 == null) goto L58;
        r111.a();
    L58:
        throw th;
    L53:
        throw new UpdateException(ErrorCode.f6702c, th.getMessage());     // Catch: Throwable -> L50
    L24:
        th = th;
    L26:
        th = th;
        r18 = null;
    L15:
        r16 = r14;
        goto L16
    L5:
        if (r10.odlUseUrl.length() != 0) goto L7;
        r14 = true;
        goto L8
    }

    public final void d() {
        StringBuilder r5 = new StringBuilder("[");
        PrepareMeta r10 = this.f;
        r5.append(r10);
        r5.append("]start download");
        GeckoLogger.a(r5.toString());
        this.f17310c = System.currentTimeMillis();
        h r11 = r10.getStatisticModel();
        if (r11 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        this.f17309b = r11;
        this.e = this.g.f4760c;
        r10.setDownloadFile(new File(r10.getUpdatingDir(), this.f17308a));
        a();
    }
}
