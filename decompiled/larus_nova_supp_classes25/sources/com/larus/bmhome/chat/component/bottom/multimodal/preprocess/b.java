package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.core.content.FileProvider;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import ic8.m0;
import java.io.File;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import v19.m5;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public b() {
        StringBuilder r0 = new StringBuilder();
        String r2 = null;
        File r1 = AppHost.a.getApplication().getExternalFilesDir(null);
        if (r1 == null) goto L5;
        r2 = r1.getCanonicalPath();
    L5:
        r0.append(r2);
        r0.append("/images/sendimages/");
        this.d = r0.toString();
    }

    public static Image j(MediaMetadataRetriever r29) {
        SendResourcePreprocessManager r0 = SendResourcePreprocessManager.a;
        String r1 = SendResourcePreprocessManager.i("video_cover_" + SendResourcePreprocessManager.j() + '_' + Random.Default.nextLong(10000, 99999) + ".jpeg");
        x.b(r1);
        String r2 = null;
        int r3 = 0;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L27
        Bitmap r5 = r29.getFrameAtTime(0);     // Catch: Throwable -> L27
        if (r5 == null) goto L7;
        int r6 = r5.getWidth();     // Catch: Throwable -> L27
    L8:
        if (r5 != null) goto L66;
    L12:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r1);     // Catch: Throwable -> L10
        PolarisFileOutputStreamWrapper r8 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L10
        if (r5 != null) goto L58;
    L15:
        r8.flush();     // Catch: Throwable -> L20
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L18
        Object r10 = Result.constructor-impl(Uri.fromFile(r7));     // Catch: Throwable -> L18
    L31:
        int r11 = r6;
        PolarisFileOutputStreamWrapper r28 = r8;
        int r12 = r3;
        Throwable r13 = Result.exceptionOrNull-impl(r10);
        if (r13 == null) goto L38;
        FLogger.a.e("AlbumVideoProcessor", "[buildCoverImage] " + r13);
        if (r28 == null) goto L37;
        Intrinsics.checkNotNullParameter(r28, "<this>");
        r28.close();     // Catch: Throwable -> L54
    L37:
        m5.b(r1);
        r1 = "";
    L38:
        String r17 = r1;
        if (Result.isSuccess-impl(r10) == false) goto L47;
        Uri r14 = (Uri) r10;
        FLogger.a.i("AlbumVideoProcessor", "[buildCoverImage] success");
        if (r28 == null) goto L47;
        Intrinsics.checkNotNullParameter(r28, "<this>");
        r28.close();     // Catch: Throwable -> L45
    L47:
        if (Result.isFailure-impl(r10) == false) goto L49;
        r10 = null;
    L49:
        Uri r15 = (Uri) r10;
        if (r15 == null) goto L53;
        r2 = r15.toString();
    L53:
        return new Image(r2, null, null, new ImageObj(null, r11, r12, null, null, 25, null), null, r17, null, null, null, null, null, null, null, null, 16342, null);
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L58:
        r5.compress(Bitmap.CompressFormat.JPEG, 100, r8);     // Catch: Throwable -> L20
    L18:
        th = th;
    L30:
        Result.Companion r16 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        th = th;
    L29:
        r8 = null;
        goto L30
    L66:
        r3 = r5.getHeight();     // Catch: Throwable -> L10
        goto L12
    L7:
        r6 = 0;
    L27:
        th = th;
        r6 = 0;
        goto L29
    }

    public final mr9.e o(UplinkFileEntity r14) {
        Intrinsics.checkNotNullParameter(r14, "entity");
        Object r1 = null;
        if (n1.e(r14) == true) goto L34;
        return null;
    L34:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        UplinkEntityContent r2 = r14.getUplinkEntityContent();     // Catch: Throwable -> L21
        if (r2 == null) goto L23;
        UplinkFileInfo r3 = r2.getUplinkFileInfo();     // Catch: Throwable -> L21
        if (r3 == null) goto L23;
        VideoExtension r4 = r3.getVideo();     // Catch: Throwable -> L21
        if (r4 == null) goto L23;
        String r5 = r4.getPath();     // Catch: Throwable -> L21
        if (r5 == null) goto L23;
        String r6 = p0.a(r5);     // Catch: Throwable -> L21
        if (r6 == null) goto L23;
        String r7 = this.d + StringsKt.substringAfterLast$default(r6, '/', null, 2, null);     // Catch: Throwable -> L21
        AppHost.Companion r8 = AppHost.a;     // Catch: Throwable -> L21
        Uri r9 = FileProvider.getUriForFile(r8.getApplication().getApplicationContext(), r8.getApplication().getPackageName() + ".sendimagesprovider", new PolarisFileWrapper(r7));     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L21
        m0 r12 = new m0(r9.toString(), l1.a(r14), l1.b(r14), null, null, null, null, 16376);     // Catch: Throwable -> L21
        String r15 = r14.getFileIdentifier();     // Catch: Throwable -> L21
        if (r15 != null) goto L19;
        r15 = "";
    L19:
        Object r16 = Result.constructor-impl(n(r9, r12, r15, true));     // Catch: Throwable -> L21
    L25:
        Throwable r10 = Result.exceptionOrNull-impl(r16);
        if (r10 == null) goto L29;
        FLogger.a.e("AlbumVideoProcessor", "[retrieveMetaInfoFromFile] from entity failed, " + r10);
    L29:
        if (Result.isFailure-impl(r16) == true) goto L33;
        r1 = r16;
    L33:
        return (mr9.e) r1;
    L23:
        return null;
    L21:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }

    public static ParcelFileDescriptor l(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static String m(MediaMetadataRetriever r18, int r19) {
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

    public final boolean k(Uri r9, m0 r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        Intrinsics.checkNotNullParameter(r10, "fileInfo");
        Intrinsics.checkNotNullParameter(r11, "identifier");
        ImFileUtil.a.getClass();
        boolean r2 = false;
        if (ImFileUtil.y(r9) == true) goto L37;
        return false;
    L37:
        ParcelFileDescriptor r1 = l((ContentResolver) this.b.getValue(), r9);     // Catch: Throwable -> L7
    L9:
        if (r1 != null) goto L35;
        return false;
    L35:
        long r3 = r10.c;     // Catch: Throwable -> L25
        if (r3 > 0) goto L15;
        r3 = e.c(r1.getFileDescriptor(), r9);     // Catch: Throwable -> L25
    L15:
        r10.c = r3;     // Catch: Throwable -> L25
        ImFileUtil.a.getClass();     // Catch: Throwable -> L25
        if (ImFileUtil.A(r3) == true) goto L22;
        mr9.e r12 = n(r9, r10, r11, false);     // Catch: Throwable -> L25
        if (r12 == null) goto L22;
        if (ImFileUtil.z(r12, true) == true) goto L22;
        r2 = true;
    L22:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.close();     // Catch: Throwable -> L29
    L24:
        return r2;
    L25:
        th = move-exception;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.close();     // Catch: Throwable -> L30
    L28:
        throw th;
    L7:
        th = move-exception;
        FLogger.a.e("AlbumVideoProcessor", "[canProcessAsVideo] openFileDescriptor failed: " + th);
        r1 = null;
        goto L9
    }

    public static mr9.e n(Uri r21, m0 r22, String r23, boolean r24) {
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L54
        MediaMetadataRetriever r5 = new MediaMetadataRetriever();     // Catch: Throwable -> L54
        r5.setDataSource(AppHost.a.getApplication(), r21);     // Catch: Throwable -> L51
        String r6 = m(r5, 9);     // Catch: Throwable -> L51
        if (r6 == null) goto L7;
        Long r9 = Long.valueOf(Long.parseLong(r6));     // Catch: Throwable -> L51
    L8:
        if (r24 == false) goto L10;
        Image r18 = j(r5);     // Catch: Throwable -> L51
    L11:
        String r7 = m(r5, 24);     // Catch: Throwable -> L51
        if (r7 == null) goto L14;
        Object r8 = Integer.valueOf(Integer.parseInt(r7));     // Catch: Throwable -> L51
    L15:
        String r10 = m(r5, 18);     // Catch: Throwable -> L51
        if (r10 == null) goto L18;
        Integer r11 = Integer.valueOf(Integer.parseInt(r10));     // Catch: Throwable -> L51
    L19:
        String r12 = m(r5, 19);     // Catch: Throwable -> L51
        if (r12 == null) goto L22;
        Integer r13 = Integer.valueOf(Integer.parseInt(r12));     // Catch: Throwable -> L51
    L24:
        if (Intrinsics.areEqual(r8, 90) == false) goto L26;
    L29:
        boolean r14 = true;
    L31:
        if (Build.VERSION.SDK_INT < 30) goto L33;
        String r17 = m(r5, 37);     // Catch: Throwable -> L51
    L34:
        FLogger.a.i("AlbumVideoProcessor", "[retrieveMetaInfo] rotationAngle:" + r8 + ", tradeWH:" + r14);     // Catch: Throwable -> L51
        String r2 = r22.b;     // Catch: Throwable -> L51
        if (r14 == false) goto L37;
        Integer r15 = r13;
    L38:
        if (r14 == false) goto L40;
        Integer r16 = r11;
    L41:
        String r19 = m(r5, 20);     // Catch: Throwable -> L51
        if (r19 == null) goto L44;
        Integer r110 = Integer.valueOf(Integer.parseInt(r19));     // Catch: Throwable -> L51
    L45:
        String r111 = m(r5, 12);     // Catch: Throwable -> L51
        long r20 = r22.c;     // Catch: Throwable -> L51
        ImFileUtil.a.getClass();     // Catch: Throwable -> L51
        float r0 = ImFileUtil.r(r5);     // Catch: Throwable -> L51
        String r25 = m(r5, 40);     // Catch: Throwable -> L51
        if (r25 == null) goto L48;
        String r112 = com.larus.bmhome.upload.l.a(r25);     // Catch: Throwable -> L51
    L49:
        mr9.e r26 = new mr9.e(r2, r23, r9, Float.valueOf(r0), Long.valueOf(r20), r111, r112, r16, r15, r110, r17, r18, 3072);     // Catch: Throwable -> L51
        r5.release();     // Catch: Throwable -> L54
        Object r1 = Result.constructor-impl(r26);     // Catch: Throwable -> L54
    L56:
        Throwable r27 = Result.exceptionOrNull-impl(r1);
        if (r27 == null) goto L60;
        FLogger.a.e("AlbumVideoProcessor", "[retrieveMetaInfo] " + r27);
    L60:
        if (Result.isFailure-impl(r1) == true) goto L64;
        r3 = r1;
    L64:
        return (mr9.e) r3;
    L48:
        r112 = null;
        goto L49
    L44:
        r110 = null;
        goto L45
    L40:
        r16 = r13;
        goto L41
    L37:
        r15 = r11;
        goto L38
    L33:
        r17 = null;
        goto L34
    L26:
        if (Intrinsics.areEqual(r8, 270) == true) goto L29;
        r14 = false;
        goto L31
    L22:
        r13 = null;
        goto L24
    L18:
        r11 = null;
        goto L19
    L14:
        r8 = Float.valueOf(0.0f);     // Catch: Throwable -> L51
        goto L15
    L10:
        r18 = null;
        goto L11
    L7:
        r9 = null;
    L51:
        th = move-exception;
        r5.release();     // Catch: Throwable -> L54
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    }
}
