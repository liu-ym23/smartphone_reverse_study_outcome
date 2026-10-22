package com.larus.uaigc.createpage.component.helper;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.upload.l;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class AlbumHelperKt {
    public static final Image a(MediaMetadataRetriever r29) {
        String r1 = b("video_cover_" + new SimpleDateFormat("yyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())) + '_' + Random.Default.nextLong(10000, 99999) + ".jpeg");
        File r0 = new PolarisFileWrapper(r1).getParentFile();
        if (r0 != null) goto L5;
    L7:
        int r2 = 0;
        String r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L32
        Bitmap r5 = r29.getFrameAtTime(0);     // Catch: Throwable -> L32
        if (r5 == null) goto L12;
        int r6 = r5.getWidth();     // Catch: Throwable -> L32
    L13:
        if (r5 != null) goto L60;
    L17:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r1);     // Catch: Throwable -> L15
        PolarisFileOutputStreamWrapper r8 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L15
        if (r5 != null) goto L69;
    L20:
        r8.flush();     // Catch: Throwable -> L25
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L23
        Object r10 = Result.constructor-impl(Uri.fromFile(r7));     // Catch: Throwable -> L23
    L36:
        int r11 = r2;
        int r12 = r6;
        Throwable r13 = Result.exceptionOrNull-impl(r10);
        if (r13 == null) goto L43;
        FLogger.a.e("AlbumHelper", "[buildCoverImage] failed, cause=".concat(r13.getClass().getSimpleName()));
        if (r8 == null) goto L42;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r8.close();     // Catch: Throwable -> L59
    L42:
        m5.b(r1);
        r1 = "";
    L43:
        String r18 = r1;
        if (Result.isSuccess-impl(r10) == false) goto L52;
        Uri r14 = (Uri) r10;
        FLogger.a.i("AlbumHelper", "[buildCoverImage] success");
        if (r8 == null) goto L52;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r8.close();     // Catch: Throwable -> L50
    L52:
        if (Result.isFailure-impl(r10) == false) goto L54;
        r10 = null;
    L54:
        Uri r15 = (Uri) r10;
        if (r15 == null) goto L58;
        r3 = r15.toString();
    L58:
        return new Image(r3, null, null, new ImageObj(null, r12, r11, null, null, 25, null), null, r18, null, null, null, null, null, null, null, null, 16342, null);
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L69:
        r5.compress(Bitmap.CompressFormat.JPEG, 100, r8);     // Catch: Throwable -> L25
    L23:
        th = th;
    L35:
        Result.Companion r16 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        th = th;
    L34:
        r8 = null;
        goto L35
    L60:
        r2 = r5.getHeight();     // Catch: Throwable -> L15
        goto L17
    L12:
        r6 = 0;
    L32:
        th = th;
        r6 = 0;
        goto L34
    L5:
        if (r0.exists() == true) goto L7;
        r0.mkdirs();
        goto L7
    }

    public static final String b(String r2) {
        return AppHost.a.getApplication().getExternalFilesDir(null) + "/creations/video/" + r2;
    }

    public static final String e(String r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        String r1 = b("video_" + new SimpleDateFormat("yyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())) + '_' + Random.Default.nextLong(10000, 99999) + '.' + StringsKt.substringAfterLast$default(r8, '.', null, 2, null));     // Catch: Throwable -> L10
        File r4 = new PolarisFileWrapper(r1).getParentFile();     // Catch: Throwable -> L10
        if (r4 != null) goto L6;
    L8:
        FLogger.a.i("AlbumHelper", "[copyVideoToIntervalDir] copy start");     // Catch: Throwable -> L10
        vqc.d.b(r8, r1);     // Catch: Throwable -> L10
        Object r9 = Result.constructor-impl(r1);     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.exceptionOrNull-impl(r9);
        if (r5 == null) goto L16;
        FLogger.a.w("AlbumHelper", "[copyVideoToIntervalDir] failed, cause=".concat(r5.getClass().getSimpleName()));
    L16:
        if (Result.isFailure-impl(r9) == true) goto L20;
        r2 = r9;
    L20:
        return (String) r2;
    L6:
        if (r4.exists() == true) goto L8;
        r4.mkdirs();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static String d(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static ResourceItemBean c(ResourceItemBean r25, String r26, mt8.b r27, int r28) {
        mt8.b r1 = null;
        if ((r28 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r28 & 2) != 0) goto L10;
        r1 = r27;
    L10:
        Intrinsics.checkNotNullParameter(r25, "<this>");
        if (r0 != null) goto L13;
        r0 = r25.getKey();
    L13:
        String r5 = r0;
        String r6 = r25.getTitle();
        String r7 = r25.getFileSuffixes();
        String r8 = r25.getMimeType();
        Image r9 = r25.getImage();
        if (r1 != null) goto L17;
        r1 = r25.getVideo();
    L17:
        return new ResourceItemBean(r5, r6, r7, r8, r9, r1, r25.getUpLinkProgress(), r25.getStatus(), r25.isExpire(), r25.getResourceType(), r25.getItemWidth(), r25.getItemHeight(), r25.getPaddingTop(), r25.getPaddingBottom(), r25.getShowEditImageBtn(), r25.getShowEditVideoBtn(), r25.getShowSubscriptView(), r25.getImmersiveStyle(), r25.getSubscriptIndex(), r25.getExt());
    L5:
        r0 = r26;
        goto L7
    }

    public static final Job f(CoroutineScope r2, CoroutineContext r3, CoroutineStart r4, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "start");
        Intrinsics.checkNotNullParameter(r5, "block");
        return BuildersKt.launch(r2, r3, r4, new AlbumHelperKt$launchSafely$1(r5, null));
    }

    public static /* synthetic */ Job g(CoroutineScope r1, CoroutineDispatcher r2, Function2 r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        CoroutineStart r5 = CoroutineStart.DEFAULT;
    L10:
        return f(r1, r2, r5, r3);
    L8:
        r5 = null;
        goto L10
    }

    public static final mr9.e h(Uri r18, String r19, long r20, String r22) {
        Intrinsics.checkNotNullParameter(r18, "uri");
        Intrinsics.checkNotNullParameter(r19, "fileName");
        Intrinsics.checkNotNullParameter(r22, "identifier");
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L47
        MediaMetadataRetriever r5 = new MediaMetadataRetriever();     // Catch: Throwable -> L47
        r5.setDataSource(AppHost.a.getApplication(), r18);     // Catch: Throwable -> L47
        String r0 = d(r5, 9);     // Catch: Throwable -> L47
        if (r0 == null) goto L6;
        Long r7 = Long.valueOf(CastLongProtector.parseLong(r0));     // Catch: Throwable -> L47
    L7:
        Image r16 = a(r5);     // Catch: Throwable -> L47
        String r1 = d(r5, 24);     // Catch: Throwable -> L47
        if (r1 == null) goto L10;
        Object r2 = Integer.valueOf(CastIntegerProtector.parseInt(r1));     // Catch: Throwable -> L47
    L11:
        String r8 = d(r5, 18);     // Catch: Throwable -> L47
        if (r8 == null) goto L14;
        Integer r9 = Integer.valueOf(CastIntegerProtector.parseInt(r8));     // Catch: Throwable -> L47
    L15:
        String r10 = d(r5, 19);     // Catch: Throwable -> L47
        if (r10 == null) goto L18;
        Integer r11 = Integer.valueOf(CastIntegerProtector.parseInt(r10));     // Catch: Throwable -> L47
    L20:
        if (Intrinsics.areEqual(r2, 90) == false) goto L22;
    L25:
        boolean r12 = true;
    L27:
        if (Build.VERSION.SDK_INT < 30) goto L29;
        String r15 = d(r5, 37);     // Catch: Throwable -> L47
    L30:
        FLogger.a.i("AlbumHelper", "[retrieveMetaInfo] rotationAngle:" + r2 + ", tradeWH:" + r12);     // Catch: Throwable -> L47
        if (r12 == false) goto L33;
        Integer r13 = r11;
    L34:
        if (r12 == false) goto L36;
        Integer r14 = r9;
    L37:
        String r6 = d(r5, 20);     // Catch: Throwable -> L47
        if (r6 == null) goto L40;
        Integer r17 = Integer.valueOf(CastIntegerProtector.parseInt(r6));     // Catch: Throwable -> L47
    L41:
        String r110 = d(r5, 12);     // Catch: Throwable -> L47
        ImFileUtil.a.getClass();     // Catch: Throwable -> L47
        float r21 = ImFileUtil.r(r5);     // Catch: Throwable -> L47
        String r23 = d(r5, 40);     // Catch: Throwable -> L47
        if (r23 == null) goto L44;
        String r111 = l.a(r23);     // Catch: Throwable -> L47
    L45:
        Object r24 = Result.constructor-impl(new mr9.e(r19, r22, r7, Float.valueOf(r21), Long.valueOf(r20), r110, r111, r14, r13, r17, r15, r16, 3072));     // Catch: Throwable -> L47
    L49:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L53;
        FLogger.a.e("AlbumHelper", "[retrieveMetaInfo] failed, cause=".concat(r25.getClass().getSimpleName()));
    L53:
        if (Result.isFailure-impl(r24) == true) goto L57;
        r3 = r24;
    L57:
        return (mr9.e) r3;
    L44:
        r111 = null;
        goto L45
    L40:
        r17 = null;
        goto L41
    L36:
        r14 = r11;
        goto L37
    L33:
        r13 = r9;
        goto L34
    L29:
        r15 = null;
        goto L30
    L22:
        if (Intrinsics.areEqual(r2, 270) == true) goto L25;
        r12 = false;
        goto L27
    L18:
        r11 = null;
        goto L20
    L14:
        r9 = null;
        goto L15
    L10:
        r2 = Float.valueOf(0.0f);     // Catch: Throwable -> L47
        goto L11
    L6:
        r7 = null;
    L47:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    }
}
