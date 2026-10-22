package com.larus.share.impl.sdk.special;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.api.z3;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.q3;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.platform.service.z2;
import com.larus.share.impl.util.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ShareImageSpecialHandler {
    public static final List<String> b = null;
    public final ConcurrentHashMap<Integer, i<String>> a;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "ShareVideoSaveResult(path=" + this.a + ", mdlCacheHit=" + this.b + ')';
        }

        public b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "path");
            this.a = r2;
            this.b = r3;
        }
    }

    public static String k(int r1) {
        if (r1 != 1) goto L5;
        return "image";
    L5:
        if (r1 != 2) goto L7;
        return "image2image";
    L7:
        if (r1 != 4) goto L9;
        return "music";
    L9:
        if (r1 != 5) goto L11;
        return "avatar_image";
    L11:
        if (r1 != 6) goto L13;
        return "video";
    L13:
        if (r1 == 7) goto L15;
        return "";
    L15:
        return "ai_beautify_image";
    }

    static {
        b = CollectionsKt.listOf(new String[]{"save_image", "save_video", "more"});
    }

    public ShareImageSpecialHandler() {
        this.a = new ConcurrentHashMap();
    }

    public static void a(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final String c(ShareImageSpecialHandler r4, String r5) {
        r4.getClass();
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%d_%d.%s", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(Math.abs(r5.hashCode())), "mp4"}, 3));
    }

    public static final WatermarkPerfLogger.a b(ShareImageSpecialHandler r2, String r3, com.larus.bmhome.share.panel.b r4) {
        r2.getClass();
        FLogger.a.i("ShareImageSpecialHandler", "video share perf, videUrl = ".concat(r3));
        if (r4.w != null) goto L5;
        return null;
    L5:
        DownloadWatermarkService.a.getClass();
        boolean r5 = DownloadWatermarkService.d();
        int r6 = WatermarkPerfLogger.a;
        if (r5 == false) goto L8;
        WatermarkPerfLogger.Version r7 = WatermarkPerfLogger.Version.ENTERPRISE;
    L9:
        WatermarkPerfLogger.a r8 = WatermarkPerfLogger.a("creation_video_share", r7, DownloadWatermarkScene.CI_GEN_VIDEO_SHARE);
        if (r5 == true) goto L12;
    L17:
        WatermarkPerfLogger.Path r9 = WatermarkPerfLogger.Path.NONE;
    L18:
        r8.c(r9);
        return r8;
    L12:
        if (r3.length() <= 0) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == false) goto L17;
        r9 = WatermarkPerfLogger.Path.A;
        goto L18
    L14:
        r10 = false;
        goto L15
    L8:
        r7 = WatermarkPerfLogger.Version.PERSONAL;
        goto L9
    }

    public static final void d(ShareImageSpecialHandler r0, int r1, String r2) {
        i<String> r3 = r0.a.remove(Integer.valueOf(r1));
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.isActive() == false) goto L11;
        r3.resumeWith(Result.constructor-impl(r2));
        return;
    }

    public static final void g(ShareImageSpecialHandler r6, Context r7, String r8) {
        r6.getClass();
        PolarisFileWrapper r1 = new PolarisFileWrapper(r8);
        String r9 = i1.b() + File.separator + System.currentTimeMillis() + ".mp4";
        PolarisFileWrapper r2 = new PolarisFileWrapper(r9);
        FileInputStream r3 = null;
        FileInputStream r4 = new PolarisFileInputStreamWrapper(r1);     // Catch: Throwable -> L23 Exception -> L25
        BufferedOutputStream r5 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r2));     // Catch: Throwable -> L17 Exception -> L20
    L57:
        byte[] r10 = new byte[1024];     // Catch: Throwable -> L13 Exception -> L15
    L7:
        int r11 = r4.read(r10);     // Catch: Throwable -> L13 Exception -> L15
        if (r11 <= 0) goto L10;
        r5.write(r10, 0, r11);     // Catch: Throwable -> L13 Exception -> L15
        goto L7
    L10:
        r.u(r7, r9, false);     // Catch: Throwable -> L13 Exception -> L15
        r4.close();     // Catch: IOException -> L30
    L33:
        r5.close();     // Catch: IOException -> L30
        return;
    L15:
        e = e;
    L22:
        r3 = r4;
    L48:
        FLogger.a.e("ShareImageSpecialHandler", "saveVideoToAlbumBeforeQ failed", e);     // Catch: Throwable -> L37
        if (r3 == null) goto L32;
        r3.close();     // Catch: IOException -> L30
    L32:
        if (r5 != null) goto L33;
        return;
    L37:
        th = th;
        r4 = r3;
    L19:
        r3 = r4;
    L39:
        if (r3 != null) goto L52;
    L43:
        if (r5 == null) goto L47;
        r5.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        FLogger.a.e("ShareImageSpecialHandler", "finally close stream failed", e);
    L47:
        throw th;
    L52:
        r3.close();     // Catch: IOException -> L41
    L13:
        th = th;
    L20:
        e = e;
        r5 = null;
    L17:
        th = th;
        r5 = null;
        goto L19
    L30:
        e = move-exception;
        FLogger.a.e("ShareImageSpecialHandler", "finally close stream failed", e);
        return;
    L25:
        e = e;
        r5 = null;
    L23:
        th = th;
        r5 = null;
        goto L39
    }

    public static String h(String r10, String r11, String r12) {
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r2 = null;
        if (r0 == false) goto L9;
    L35:
        FLogger.a.i("ShareImageSpecialHandler", "[copyMdlCacheFile] local file miss, key=" + r10 + ", localPath=" + r11);
        return null;
    L9:
        if (new PolarisFileWrapper(r11).exists() == false) goto L35;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        PolarisFileWrapper r3 = new PolarisFileWrapper(r12);     // Catch: Throwable -> L21
        File r13 = r3.getParentFile();     // Catch: Throwable -> L21
        if (r13 != null) goto L14;
    L19:
        FilesKt.copyTo$default(new PolarisFileWrapper(r11), r3, true, 0, 4, null);     // Catch: Throwable -> L21
        Object r14 = Result.constructor-impl(r3.getAbsolutePath());     // Catch: Throwable -> L21
    L24:
        if (Result.isSuccess-impl(r14) == false) goto L26;
        FLogger.a.i("ShareImageSpecialHandler", "[copyMdlCacheFile] hit, key=" + r10 + ", path=" + ((String) r14));
    L26:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L30;
        FLogger.a.e("ShareImageSpecialHandler", "[copyMdlCacheFile] copy failed, key=" + r10 + ", " + r15);
    L30:
        if (Result.isFailure-impl(r14) == true) goto L34;
        r2 = r14;
    L34:
        return (String) r2;
    L14:
        if ((true ^ r13.exists()) == true) goto L17;
        r13 = null;
    L17:
        if (r13 == null) goto L19;
        r13.mkdirs();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L5:
        r0 = false;
        goto L6
    }

    public static final Object e(ShareImageSpecialHandler r11, String r12, String r13, String r14, Continuation r15) {
        r11.getClass();
        if ((r15 instanceof ShareImageSpecialHandler$saveVideoByMdlCache$1) == false) goto L7;
        ShareImageSpecialHandler$saveVideoByMdlCache$1 r0 = (ShareImageSpecialHandler$saveVideoByMdlCache$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = false;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r14 = (String) r0.L$1;
        r12 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L83:
        String r18 = (String) r16;
        if (r18 != null) goto L86;
    L87:
        r3 = true;
    L88:
        if (r3 == false) goto L90;
        FLogger.a.i("ShareImageSpecialHandler", "[saveVideoByMdlCache] mdl download failed, key=" + r12);
    L94:
        return null;
    L90:
        String r19 = h(r12, r18, r14);
        if (r19 == null) goto L94;
        return new b(r19, true);
    L86:
        if (r18.length() != 0) goto L88;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        if (r12 != null) goto L17;
    L20:
        boolean r110 = true;
    L21:
        if (r110 == true) goto L94;
        if (r12 != null) goto L25;
    L28:
        boolean r111 = true;
    L29:
        if (r111 == false) goto L95;
    L74:
        String r112 = null;
    L75:
        if (r112 != null) goto L97;
        z2 r113 = z2.a;
        if (r113.enableVideoDownloadMdl() == true) goto L80;
        FLogger.a.i("ShareImageSpecialHandler", "[saveVideoByMdlCache] mdl download disabled, key=" + r12);
        goto L94
    L80:
        long r6 = r113.getCreationVideoMdlDownloadTimeoutMs();
        ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1 r114 = new ShareImageSpecialHandler$saveVideoByMdlCache$downloadedLocalFilePath$1(r13, r12, null);
        r0.L$0 = r12;
        r0.L$1 = r14;
        r0.label = 1;
        r16 = TimeoutKt.c(r6, r114, r0);
        if (r16 != r17) goto L83;
        return r17;
    L97:
        return new b(r112, true);
    L95:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L37
        Lazy r116 = q3.a;     // Catch: Throwable -> L37
        z3 r117 = q3.a();     // Catch: Throwable -> L37
        if (r117 == null) goto L34;
        yq9.a r118 = r117.g(r12);     // Catch: Throwable -> L37
    L35:
        Object r119 = Result.constructor-impl(r118);     // Catch: Throwable -> L37
    L39:
        Throwable r4 = Result.exceptionOrNull-impl(r119);
        if (r4 == null) goto L43;
        FLogger.a.e("ShareImageSpecialHandler", "[copyCompleteMdlCache] get cache failed, key=" + r12 + ", " + r4);
    L43:
        if (Result.isFailure-impl(r119) == false) goto L45;
        r119 = null;
    L45:
        yq9.a r120 = (yq9.a) r119;
        if (r120 == null) goto L48;
        String r5 = r120.c;
    L49:
        if (r120 == null) goto L65;
        long r7 = r120.a;
        if (r7 <= 0) goto L65;
        if (r120.b < r7) goto L65;
        if (r5 != null) goto L56;
    L59:
        boolean r8 = true;
    L60:
        if (r8 == true) goto L65;
        if (new PolarisFileWrapper(r5).exists() == false) goto L65;
        r112 = h(r12, r5, r14);
        goto L75
    L56:
        if (r5.length() == 0) goto L59;
        r8 = false;
    L65:
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("[copyCompleteMdlCache] miss, key=");
        r10.append(r12);
        r10.append(", mediaSize=");
        if (r120 == null) goto L68;
        Long r20 = Long.valueOf(r120.a);
    L69:
        r10.append(r20);
        r10.append(", cacheSize=");
        if (r120 == null) goto L72;
        Long r121 = Long.valueOf(r120.b);
    L73:
        r10.append(r121);
        r10.append(", localPath=");
        r10.append(r5);
        r9.i("ShareImageSpecialHandler", r10.toString());
        goto L74
    L72:
        r121 = null;
        goto L73
    L68:
        r20 = null;
        goto L69
    L48:
        r5 = null;
        goto L49
    L34:
        r118 = null;
    L37:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r119 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L25:
        if (r12.length() == 0) goto L28;
        r111 = false;
        goto L29
    L17:
        if (r12.length() == 0) goto L20;
        r110 = false;
    L7:
        r0 = new ShareImageSpecialHandler$saveVideoByMdlCache$1(r11, r15);
        goto L8
    }

    public static final Object f(ShareImageSpecialHandler r5, Context r6, String r7, String r8, Continuation r9) {
        r5.getClass();
        i<String> r0 = new j(IntrinsicsKt.intercepted(r9), 1);
        r0.C();
        Ref.IntRef r1 = new Ref.IntRef();
        DownloadTask r10 = Downloader.with(r6).url(r7).savePath(r8).name(System.currentTimeMillis() + ".mp4").subThreadListener(new d(r5, r1));
        int r11 = r10.getDownloadId();
        r1.element = r11;
        r5.a.put(Boxing.boxInt(r11), r0);
        r0.i(new c(r5, r1, r6));
        r10.asyncDownload(null);
        Object r12 = r0.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L5:
        return r12;
    }

    public final boolean i(Context r23, final String r24, final String r25, final com.larus.bmhome.share.panel.b r26, final boolean r27, final Function1<? super Integer, Unit> r28) {
        Intrinsics.checkNotNullParameter(r26, "shareContent");
        boolean r2 = false;
        if (r26.r == true) goto L6;
        FLogger.a.i("ShareImageSpecialHandler", "isShareOriginImage false so not take effect");
        return false;
    L6:
        Unit r10 = null;
        if ((r23 instanceof LifecycleOwner) == false) goto L9;
        LifecycleOwner r1 = (LifecycleOwner) r23;
    L10:
        if (r1 == null) goto L14;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r1);
        if (r3 == null) goto L14;
    L15:
        LifecycleCoroutineScope r18 = r3;
        if (r23 == null) goto L18;
        WeakReference r7 = new WeakReference(r23);
    L19:
        int r4 = f.a;
        if (f.a(r26.a) == true) goto L22;
        Bitmap r0 = r26.b;
        if (r0 != null) goto L67;
    L73:
        return false;
    L67:
        if (r0.isRecycled() != true) goto L69;
        boolean r15 = true;
    L70:
        if (r15 == true) goto L73;
        final WeakReference r5 = r7;
        ImageSave.z(ImageSave.a, "", r26.b, r26.p, null, r26.q, false, r18, new com.larus.share.impl.sdk.special.b(r5, this, r24, r25, r26, r27, r28), 40);
        return true;
    L69:
        r15 = false;
        goto L70
    L22:
        if ((r23 instanceof Activity) == false) goto L24;
        l0 r6 = new l0(r23, 0.0f, false, 6);
    L25:
        if (r6 == null) goto L27;
        r6.setCancelable(true);
    L27:
        if (r27 == false) goto L34;
        if (r6 == null) goto L34;
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L81;
        DialogLancet.handleBlockedDialogShow(r6);
        goto L34
    L81:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L74
    L33:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
    L34:
        if (r6 == null) goto L36;
        WeakReference r21 = new WeakReference(r6);
    L37:
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("loadingDialog is not null ");
        if (r6 == null) goto L40;
        r2 = true;
    L40:
        r9.append(r2);
        r9.append(" show");
        r8.i("ShareImageSpecialHandler", r9.toString());
        String r11 = r26.a;
        if (r11 != null) goto L43;
        r11 = "";
    L43:
        String r12 = r11;
        Integer r13 = r26.w;
        ImageSave r14 = ImageSave.a;     // Catch: Exception -> L50
        Map r16 = r26.p;     // Catch: Exception -> L50
        ShareImageSpecialHandler$handleShareImage$1 r17 = new ShareImageSpecialHandler$handleShareImage$1(r12, r13, this, r26, null);     // Catch: Exception -> L50
        boolean r19 = r26.q;     // Catch: Exception -> L50
        final WeakReference r20 = r7;
        final WeakReference r22 = r21;
        Function1 r110 = new com.larus.share.impl.sdk.special.a(r20, this, r26, r24, r25, r27, r28, r22);     // Catch: Exception -> L50
        boolean r29 = true;
        ImageSave.z(r14, r12, null, r16, r17, r19, false, r18, r110, 34);     // Catch: Exception -> L48
    L63:
        return r29;
    L48:
        e = e;
    L52:
        Exception r30 = e;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L60
        if (r21 == null) goto L58;
        l0 r32 = (l0) r21.get();     // Catch: Throwable -> L60
        if (r32 == null) goto L58;
        a(r32);     // Catch: Throwable -> L60
        r10 = Unit.INSTANCE;     // Catch: Throwable -> L60
    L58:
        Result.constructor-impl(r10);     // Catch: Throwable -> L60
    L62:
        FLogger.a.i("ShareImageSpecialHandler", "loadingDialog dismiss due to exception: " + r30.getMessage());
    L60:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L50:
        e = e;
        r29 = true;
        goto L52
    L36:
        r21 = null;
        goto L37
    L24:
        r6 = null;
        goto L25
    L18:
        r7 = null;
    L14:
        r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        goto L15
    L9:
        r1 = null;
        goto L10
    }

    public final boolean j(Context r16, String r17, String r18, com.larus.bmhome.share.panel.b r19, boolean r20, Function1<? super Integer, Unit> r21) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r19, "shareContent");
        int r0 = f.a;
        boolean r2 = false;
        if (f.a(r19.e) == true) goto L5;
        return false;
    L5:
        LifecycleOwner r4 = null;
        if ((r16 instanceof Activity) == false) goto L8;
        l0 r1 = new l0(r16, 0.0f, false, 6);
    L10:
        if (r1 == null) goto L12;
        r1.setCancelable(true);
    L12:
        if (r20 == false) goto L19;
        if (r1 == null) goto L19;
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L36;
        DialogLancet.handleBlockedDialogShow(r1);
        goto L19
    L36:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
    L18:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    L19:
        if (r1 == null) goto L21;
        WeakReference r8 = new WeakReference(r1);
    L22:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[handleShareVideo] loadingDialog is not null ");
        if (r1 == null) goto L25;
        r2 = true;
    L25:
        r6.append(r2);
        r6.append(" show");
        r5.i("ShareImageSpecialHandler", r6.toString());
        if ((r16 instanceof LifecycleOwner) == false) goto L28;
        r4 = (LifecycleOwner) r16;
    L28:
        if (r4 == null) goto L32;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r4);
        if (r3 == null) goto L32;
    L33:
        BuildersKt.launch$default(r3, Dispatchers.getIO(), null, new ShareImageSpecialHandler$handleShareVideo$1(r19, this, r16, r17, r18, r20, r21, r8, null), 2, null);
        return true;
    L32:
        r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        goto L33
    L21:
        r8 = null;
        goto L22
    L8:
        r1 = null;
        goto L10
    }
}
