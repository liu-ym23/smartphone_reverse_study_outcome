package com.bytedance.android.live.emoji.online;

import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiRes;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends AbsDownloadListener {
    public final /* synthetic */ OnlineSmallEmojiResManager a;
    public final /* synthetic */ OnlineSmallEmojiRes b;

    public final void onSuccessed(DownloadInfo r17) {
        super.onSuccessed(r17);
        ALogger.d("OnlineEmojiResManager", " download succeed");
        OnlineSmallEmojiResManager r3 = this.a;
        OnlineSmallEmojiRes r4 = this.b;
        if (r17 == null) goto L6;
        String r0 = r17.getTargetFilePath();
        if (r0 == null) goto L6;
    L7:
        r3.getClass();
        c r5 = c.c;
        String r6 = r4.getMd5();
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(r0, "zipFilePath");
        Intrinsics.checkNotNullParameter(r6, "md5");
        PolarisFileWrapper r8 = new PolarisFileWrapper(r0);
        boolean r11 = false;
        if (r8.exists() == true) goto L11;
        ALogger.d("OnlineEmojiFileHelper", " isZipFileValid: zFile not exist: " + r0 + ", " + r6);
    L16:
        boolean r7 = false;
    L19:
        if (r7 == true) goto L22;
        r5 = null;
    L22:
        if (r5 == null) goto L81;
        String r9 = r4.getMd5();
        Intrinsics.checkNotNull(r9);
        String r12 = c.b(r9);
        Intrinsics.checkNotNullParameter(r0, "zipFilePath");
        Intrinsics.checkNotNullParameter(r12, "outputDirPath");
        ALogger.d("OnlineEmojiFileHelper", "unZipFile: zipFilePath=" + r0 + ", outputDirPath=" + r12);
        PolarisFileWrapper r13 = new PolarisFileWrapper(r12);
        if (r13.exists() == false) goto L26;
        c.c(r12);
    L26:
        r13.mkdirs();
        PolarisFileWrapper r14 = new PolarisFileWrapper(r0);
        if (r14.exists() == true) goto L29;
    L77:
        r14.delete();
        ALogger.e("OnlineEmojiFileHelper", " unZipFile zipFile invalid: " + r0 + ", " + r12);
    L78:
        if (r11 == false) goto L80;
        ALogger.d("OnlineEmojiResManager", "  unZip success");
        r3.a(r4);
        com.bytedance.android.live.emoji.utils.a r1 = com.bytedance.android.live.emoji.utils.a.a();
        r1.b.edit().putString("key_small_emoji_md5", r4.getMd5()).commit();
        Task.call(new h(r3, true), Task.UI_THREAD_EXECUTOR);
    L82:
        PolarisFileWrapper r2 = new PolarisFileWrapper(c.a + "tmp/");
        if (r2.isDirectory() == false) goto L85;
        String r15 = c.a;
        c.c(r2.getAbsolutePath());
        return;
    L85:
        r2.delete();
        return;
    L80:
        ALogger.d("OnlineEmojiResManager", "  unZip failed");
        String r16 = c.a;
        c.c(r12);
        goto L82
    L29:
        if (StringsKt.endsWith$default(r14.getName(), ".zip", false, 2, null) == false) goto L77;
        PolarisZipFileWrapper r18 = new PolarisZipFileWrapper(r14);     // Catch: Exception -> L75
        Iterator r19 = CollectionsKt.iterator(r18.entries());     // Catch: Throwable -> L68
        boolean r21 = false;
    L34:
        if (r19.hasNext() == false) goto L65;
        ZipEntry r110 = (ZipEntry) r19.next();     // Catch: Throwable -> L68
        if (StringsKt.startsWith$default(r110.getName(), "emoji_", false, 2, null) == true) goto L38;
    L63:
        r110.getName();     // Catch: Throwable -> L68
        goto L34
    L38:
        if (StringsKt.contains$default(r110.getName(), "../", false, 2, null) == true) goto L63;
        ALogger.d("OnlineEmojiFileHelper", "unZipFile entry=" + r110.getName());     // Catch: Throwable -> L68
        PolarisFileWrapper r22 = new PolarisFileWrapper(r13, r110.getName());     // Catch: Throwable -> L68
        if (r110.isDirectory() == false) goto L43;
        r22.mkdirs();     // Catch: Throwable -> L68
    L48:
        r21 = true;
        goto L34
    L43:
        InputStream r111 = r18.getInputStream(r110);     // Catch: Throwable -> L68
        PolarisFileOutputStreamWrapper r112 = new PolarisFileOutputStreamWrapper(r22);     // Catch: Throwable -> L56
        ByteStreamsKt.copyTo$default(r111, r112, 0, 2, null);     // Catch: Throwable -> L49
        CloseableKt.closeFinally(r112, null);     // Catch: Throwable -> L56
        CloseableKt.closeFinally(r111, null);     // Catch: Throwable -> L68
        goto L48
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        CloseableKt.closeFinally(r112, th);     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);     // Catch: Throwable -> L68
        throw th;     // Catch: Throwable -> L68
    L65:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L68
        CloseableKt.closeFinally(r18, null);     // Catch: Exception -> L75
        r11 = r21;
    L68:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Exception -> L75
        throw th;     // Catch: Exception -> L75
    L75:
        e = move-exception;
        ALogger.e("OnlineEmojiFileHelper", "unZipFile cause exception: " + e.getMessage());
        goto L78
    L81:
        ALogger.d("OnlineEmojiResManager", "  resource zip not valid");
        goto L82
    L11:
        if (r8.isFile() == true) goto L13;
        ALogger.d("OnlineEmojiFileHelper", " isZipFileValid: zFile not a file: " + r0 + ", " + r6);
        goto L16
    L13:
        String r24 = DigestUtils.md5Hex(r8);
        if ((!Intrinsics.areEqual(r6, r24)) == false) goto L17;
        ALogger.d("OnlineEmojiFileHelper", " isZipFileValid: md5 not match: " + r0 + ", " + r6 + ", " + r24);
        goto L16
    L17:
        r7 = true;
    L6:
        r0 = "";
        goto L7
    }

    public e(OnlineSmallEmojiResManager r1, OnlineSmallEmojiRes r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailed(DownloadInfo r3, BaseException r4) {
        super.onFailed(r3, r4);
        StringBuilder r5 = new StringBuilder(" download failed: ");
        String r0 = null;
        if (r4 == null) goto L5;
        Integer r1 = Integer.valueOf(r4.getErrorCode());
    L6:
        r5.append(r1);
        r5.append(", ");
        if (r4 == null) goto L9;
        r0 = r4.getMessage();
    L9:
        r5.append(r0);
        ALogger.d("OnlineEmojiResManager", r5.toString());
        return;
    L5:
        r1 = null;
        goto L6
    }
}
