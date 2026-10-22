package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.v;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.r;
import com.larus.utils.z0;
import ic8.m0;
import ic8.n0;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends e {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.preprocess.a$a, reason: collision with other inner class name */
    public static final class C0051a {
    }

    static {
    }

    public a() {
    }

    public static Bitmap k(Bitmap r5) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return r5;
    L5:
        ColorSpace r0 = r5.getColorSpace();
        ColorSpace r1 = ColorSpace.get(ColorSpace.Named.SRGB);
        if (r0 != null) goto L8;
    L12:
        return r5;
    L8:
        if (Intrinsics.areEqual(r0, r1) == true) goto L12;
        Bitmap r2 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), z0.b(r5.getConfig()), r5.hasAlpha(), r1);
        Canvas r3 = new Canvas(r2);
        Paint r4 = new Paint();
        r4.setAntiAlias(true);
        r3.drawBitmap(r5, 0.0f, 0.0f, r4);
        return r2;
    }

    public final int m(FileDescriptor r5) {
        ExifInterface r1 = new ExifInterface(r5);     // Catch: Throwable -> L5
        this.c = r1;     // Catch: Throwable -> L5
        return r1.getAttributeInt("Orientation", 1);
    L5:
        th = move-exception;
        FLogger.a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[getImgOrientation] readImgDegree err: " + th);
        return 1;
    }

    public static ParcelFileDescriptor j(ContentResolver r20, Uri r21) {
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

    public final boolean o(Bitmap r7, Bitmap.CompressFormat r8, int r9, String r10) {
        boolean r2 = true;
        boolean r3 = false;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        e.b(r10);     // Catch: Throwable -> L18
        PolarisFileOutputStreamWrapper r5 = new PolarisFileOutputStreamWrapper(r10);     // Catch: Throwable -> L18
        boolean r6 = g(r8);     // Catch: Throwable -> L16
        int r11 = i.b(r8, r9, r6);     // Catch: Throwable -> L16
        if (r6 == false) goto L7;
        int r12 = v.a;     // Catch: Throwable -> L16
        boolean r13 = v.a(r7, r11, r5, f().g());     // Catch: Throwable -> L16
    L8:
        if (r13 == true) goto L10;
        FLogger.a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[writeCompressedBitmap] compress failed, outPath:".concat(r10));     // Catch: Throwable -> L16
        boolean r14 = true;
    L39:
        Object r15 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L14
    L21:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L24;
        FLogger.a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[writeCompressedBitmap] failed, outPath:" + r10 + ", err:" + r16);
    L25:
        if (r5 == null) goto L30;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.close();     // Catch: Throwable -> L29
    L30:
        if (r2 == false) goto L32;
        m5.b(r10);
    L32:
        Boolean r17 = Boolean.FALSE;
        if (Result.isFailure-impl(r15) == false) goto L36;
        r15 = r17;
    L36:
        return ((Boolean) r15).booleanValue();
    L24:
        r2 = r14;
    L14:
        Throwable th = th;
        r3 = r14;
    L20:
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        r14 = r3;
        goto L21
    L10:
        r5.flush();     // Catch: Throwable -> L16
        r14 = false;
        r3 = true;
        goto L39
    L7:
        r13 = r7.compress(r8, r11, r5);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th = th;
    L18:
        th = move-exception;
        th = th;
        r5 = null;
        goto L20
    }

    public final n0 l(Uri r29, boolean r30, ns8.a r31, String r32, ns8.b r33) {
        Intrinsics.checkNotNullParameter(r29, "uri");
        FLogger r0 = FLogger.a;
        r0.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] for uri: " + r29);
        m0 r6 = new m0(r29.toString(), null, 0, null, null, null, null, 16382);
        ImFileUtil.a.getClass();
        if (ImFileUtil.w(r29) == true) goto L6;
        r0.e("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] not image type abort for uri: " + r29);
        return new n0(r6, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH);
    L6:
        String r13 = null;
        this.c = null;
        ParcelFileDescriptor r14 = j((ContentResolver) this.b.getValue(), r29);     // Catch: Throwable -> L9
    L11:
        if (r14 == null) goto L13;
        FileDescriptor r15 = r14.getFileDescriptor();
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("fileDescriptor:");
        boolean r16 = false;
        if (r15 == null) goto L17;
        boolean r3 = true;
    L18:
        r2.append(r3);
        r1.i("SendResourcePreprocessManager_AlbumImgProcessor", r2.toString());
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L21
        BitmapFactory.Options r5 = new BitmapFactory.Options();     // Catch: Throwable -> L21
        r5.inJustDecodeBounds = true;     // Catch: Throwable -> L21
        BitmapFactory.decodeFileDescriptor(r15, null, r5);     // Catch: Throwable -> L21
        Object r7 = Result.constructor-impl(r5.outMimeType);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r7) == false) goto L26;
        r7 = null;
    L26:
        String r8 = (String) r7;
        if (r8 != null) goto L29;
        ImFileUtil.a.getClass();
        r8 = ImFileUtil.i(r29);
    L29:
        String r9 = r8;
        r6.d = r9;
        Regex r10 = j.a;
        ImFileUtil.a.getClass();
        r6.m = j.a(ImFileUtil.f(r29).b, r9);
        FLogger r11 = FLogger.a;
        r11.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] imageType: " + r9);
        if (r33 != null) goto L32;
    L34:
        boolean r12 = false;
    L35:
        if (r12 == false) goto L37;
    L40:
        boolean r17 = true;
    L41:
        if (r9 != null) goto L43;
    L45:
        boolean r18 = false;
    L47:
        if (r18 == false) goto L120;
        if (r17 == true) goto L120;
        if (r31 == null) goto L57;
        Bitmap.CompressFormat r19 = r31.d;
        if (r19 == null) goto L57;
        if (Intrinsics.areEqual(i.a(r19), "webp") == true) goto L56;
        r19 = null;
    L56:
        if (r19 == null) goto L57;
    L58:
        Intrinsics.checkNotNull(r15);
        PolarisFileInputStreamWrapper r20 = new PolarisFileInputStreamWrapper(r15);     // Catch: Throwable -> L80
        Movie r21 = Movie.decodeStream(r20);     // Catch: Throwable -> L78
        Bitmap r22 = Bitmap.createBitmap(r21.width(), r21.height(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L78
        Canvas r23 = new Canvas(r22);     // Catch: Throwable -> L78
        r21.draw(r23, 0.0f, 0.0f);     // Catch: Throwable -> L78
        r23.save();     // Catch: Throwable -> L78
        String r24 = e.a(this, i.a(r19), r33, null, 10);     // Catch: Throwable -> L78
        PolarisFileOutputStreamWrapper r25 = new PolarisFileOutputStreamWrapper(r24);     // Catch: Throwable -> L76
        boolean r26 = g(r19);     // Catch: Throwable -> L65
        int r27 = i.b(r19, 100, r26);     // Catch: Throwable -> L65
        if (r26 == false) goto L67;
        int r28 = v.a;     // Catch: Throwable -> L65
        boolean r34 = v.a(r22, r27, r25, f().g());     // Catch: Throwable -> L65
    L68:
        if (r34 == false) goto L75;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        r20.close();     // Catch: Throwable -> L331
    L71:
        Intrinsics.checkNotNullParameter(r25, "<this>");
        r25.close();     // Catch: Throwable -> L332
    L94:
        Intrinsics.checkNotNullParameter(r14, "<this>");
        r14.close();     // Catch: Throwable -> L97
    L99:
        if (o0.d(r24) == false) goto L101;
        ProcessFileResultCode r35 = ProcessFileResultCode.PREPARE_GIF_PROCESS_SUCCESS;
    L102:
        r6.e = r24;
        if (r30 == true) goto L105;
    L107:
        r6.f = r13;
        return new n0(r6, r35);
    L105:
        if (o0.d(r24) == false) goto L107;
        ImFileUtil r36 = ImFileUtil.a;
        PolarisFileWrapper r37 = new PolarisFileWrapper(r24);
        r36.getClass();
        r13 = ImFileUtil.g(r37);
        goto L107
    L101:
        r35 = ProcessFileResultCode.PREPARE_GIF_PROCESS_FAILED;
        goto L102
    L75:
        throw new IllegalStateException("encode gif first frame failed".toString());     // Catch: Throwable -> L65
    L67:
        r34 = r22.compress(r19, r27, r25);     // Catch: Throwable -> L65
    L65:
        th = th;
    L358:
        FLogger.a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[execForGif] execForGif failed, err:" + th);     // Catch: Throwable -> L109
        if (r20 == null) goto L90;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        r20.close();     // Catch: Throwable -> L89
    L90:
        if (r25 == null) goto L93;
        Intrinsics.checkNotNullParameter(r25, "<this>");
        r25.close();     // Catch: Throwable -> L333
    L93:
        m5.b(r24);
        r24 = null;
    L109:
        th = move-exception;
        if (r20 == null) goto L115;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        r20.close();     // Catch: Throwable -> L114
    L115:
        if (r25 == null) goto L118;
        Intrinsics.checkNotNullParameter(r25, "<this>");
        r25.close();     // Catch: Throwable -> L334
    L118:
        m5.b(r24);
        throw th;
    L76:
        th = th;
    L83:
        r25 = null;
    L78:
        th = th;
    L82:
        r24 = null;
    L80:
        th = th;
        r20 = null;
    L57:
        r19 = Bitmap.CompressFormat.JPEG;
    L120:
        r11.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] imageMineType: " + r9);
        if (r9 == null) goto L125;
        boolean r38 = true;
        if (x.a(r9) != true) goto L126;
        boolean r39 = true;
    L127:
        if (r39 == false) goto L270;
        if (r33 != null) goto L130;
    L132:
        boolean r40 = false;
    L133:
        if (r40 == true) goto L270;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Locale r41 = Locale.ROOT;
        String r42 = r9.toLowerCase(r41);
        if (Intrinsics.areEqual(r42, "image/heif") == false) goto L137;
    L140:
        boolean r43 = true;
    L141:
        if (r43 == false) goto L143;
    L150:
        r9 = r9;
    L151:
        boolean r210 = false;
    L152:
        Intrinsics.checkNotNull(r15);
        if (r31 != null) goto L362;
    L157:
        int r44 = z2.a.imageUploadOptConfig().a;     // Catch: Throwable -> L238
    L158:
        int r211 = r44;
        if (r31 == null) goto L162;
        Integer r212 = r31.b;     // Catch: Throwable -> L238
    L163:
        ParcelFileDescriptor r213 = r14;
        FileDescriptor r214 = r15;
        String r110 = r9;
        String r111 = "<this>";
        m0 r215 = r6;
        Pair<Bitmap, Boolean> r45 = n(r29, r15, r211, r212, r33);     // Catch: Throwable -> L236
        if (r45 == null) goto L176;
        Bitmap r46 = (Bitmap) r45.getFirst();     // Catch: Throwable -> L236
        z2 r47 = z2.a;     // Catch: Throwable -> L236
        if (r47.enableImageUploadConvertToSrgb() == false) goto L170;
        r11.i("SendResourcePreprocessManager_AlbumImgProcessor", "[tryFixImgDegreeForCompress] tryFixImgDegreeForCompress convertToSrgb");     // Catch: Throwable -> L236
        Bitmap r48 = k(r46);     // Catch: Throwable -> L236
    L171:
        if (r210 == true) goto L173;
    L177:
        Intrinsics.checkNotNullParameter(r110, r111);     // Catch: Throwable -> L236
        String r49 = r110.toLowerCase(r41);     // Catch: Throwable -> L236
        if (Intrinsics.areEqual(r49, "image/png") == false) goto L180;
    L187:
        boolean r50 = true;
        boolean r51 = true;
    L188:
        if (r51 != r50) goto L190;
        boolean r52 = true;
    L191:
        if (r52 == true) goto L193;
    L195:
        boolean r53 = false;
    L196:
        if (r53 == false) goto L199;
        if (r31 == null) goto L201;
        Bitmap.CompressFormat r54 = r31.g;     // Catch: Throwable -> L236
    L202:
        if (r54 != null) goto L204;
        r54 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L236
    L204:
        int r55 = r47.imageUploadOptConfig().b;     // Catch: Throwable -> L236
        if (1 <= r55) goto L207;
    L209:
        boolean r56 = false;
    L210:
        if (r56 == true) goto L213;
        r55 = 100;
    L213:
        if (r53 == false) goto L219;
        if (r31 == null) goto L217;
        Integer r57 = r31.f;     // Catch: Throwable -> L236
        if (r57 == null) goto L217;
    L222:
        if (r57 == null) goto L224;
        r55 = r57.intValue();     // Catch: Throwable -> L236
    L224:
        String r58 = i.a(r54);     // Catch: Throwable -> L236
        String r59 = e.a(this, r58, r33, ImFileUtil.f(r29).b, 2);     // Catch: Throwable -> L236
        r11.i("SendResourcePreprocessManager_AlbumImgProcessor", "[tryCompress] outPath:".concat(r59));     // Catch: Throwable -> L236
        if (o(r48, r54, r55, r59) == false) goto L228;
    L234:
        Object r60 = Result.constructor-impl(r59);     // Catch: Throwable -> L236
    L241:
        Throwable r61 = Result.exceptionOrNull-impl(r60);
        if (r61 == null) goto L245;
        FLogger.a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[tryCompress] err: " + r61);
    L245:
        if (Result.isFailure-impl(r60) == false) goto L247;
        r60 = null;
    L247:
        String r62 = (String) r60;
        m0 r112 = r215;
    L248:
        r112.e = r62;
        if (r62 == null) goto L269;
        FLogger.a.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] Compressed");
        PolarisFileWrapper r63 = new PolarisFileWrapper(r62);
        r112.c = r63.length();
        if (r30 == false) goto L253;
        ImFileUtil.a.getClass();
        r112.f = ImFileUtil.g(r63);
    L253:
        if (r31 != null) goto L255;
    L257:
        if (r16 == false) goto L259;
        e.d(this.c, r62);
    L259:
        ParcelFileDescriptor r113 = r213;
        Intrinsics.checkNotNullParameter(r113, r111);
        r113.close();     // Catch: Throwable -> L262
    L263:
        ImFileUtil r64 = ImFileUtil.a;
        long r65 = r112.c;
        r64.getClass();
        if (ImFileUtil.v(r65, true) == false) goto L266;
        ProcessFileResultCode r66 = ProcessFileResultCode.PREPARE_OVER_SIZE;
    L268:
        return new n0(r112, r66);
    L266:
        r66 = ProcessFileResultCode.PREPARE_COMPRESSED_SUCCESS;
        goto L268
    L255:
        if (r31.e != true) goto L257;
        r16 = true;
        goto L257
    L269:
        r14 = r213;
    L271:
        Intrinsics.checkNotNull(r214);
        FileDescriptor r67 = r214;
        long r68 = e.c(r67, r29);
        r112.c = r68;
        ImFileUtil.a.getClass();
        if (ImFileUtil.v(r68, true) == false) goto L277;
        Intrinsics.checkNotNullParameter(r14, r111);
        r14.close();     // Catch: Throwable -> L335
    L276:
        return new n0(r112, ProcessFileResultCode.PREPARE_OVER_SIZE);
    L277:
        if (r33 != null) goto L279;
    L281:
        if (r16 == false) goto L318;
        FLogger.a.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] skip clone");
        if (r112.e == null) goto L354;
        Intrinsics.checkNotNullParameter(r14, r111);
        r14.close();     // Catch: Throwable -> L336
    L287:
        return new n0(r112, ProcessFileResultCode.PREPARE_CLONE_SUCCESS);
    L354:
        String r69 = r.j(AppHost.a.getApplication(), r29);     // Catch: Throwable -> L296
        if (r69 == null) goto L293;
        PolarisFileWrapper r70 = new PolarisFileWrapper(r69);     // Catch: Throwable -> L296
        if (r70.exists() == false) goto L293;
    L294:
        Object r71 = Result.constructor-impl(r70);     // Catch: Throwable -> L296
    L298:
        Throwable r72 = Result.exceptionOrNull-impl(r71);
        if (r72 == null) goto L302;
        FLogger.a.w("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] get original file path failed: " + r72);
    L302:
        if (Result.isFailure-impl(r71) == false) goto L304;
        r71 = null;
    L304:
        File r73 = (File) r71;
        if (r73 == null) goto L307;
        String r74 = r73.getAbsolutePath();
    L308:
        if (r74 == null) goto L318;
        r112.e = r73.getAbsolutePath();
        if (r33.f == true) goto L312;
        ImFileUtil.a.getClass();
        String r75 = ImFileUtil.g(r73);
    L313:
        r112.f = r75;
        Intrinsics.checkNotNullParameter(r14, r111);
        r14.close();     // Catch: Throwable -> L337
    L316:
        return new n0(r112, ProcessFileResultCode.PREPARE_CLONE_SUCCESS);
    L312:
        r75 = null;
        goto L313
    L307:
        r74 = null;
    L293:
        r70 = null;
    L296:
        th = move-exception;
        Result.Companion r76 = Result.Companion;
        r71 = Result.constructor-impl(ResultKt.createFailure(th));
    L318:
        if (AppHost.a.isPlugin() == true) goto L320;
        ImFileUtil.a.getClass();
        Pair<String, String> r77 = e.h(this, r110, r67, false, null, r30, r33, ImFileUtil.f(r29).b, r29, 12);
        r111 = r111;
    L321:
        r112.e = (String) r77.getFirst();
        r112.f = (String) r77.getSecond();
        FLogger.a.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] tryCloneOriginalRes result: " + ((String) r77.getFirst()));
        Intrinsics.checkNotNullParameter(r14, r111);
        r14.close();     // Catch: Throwable -> L324
    L326:
        if (o0.d((String) r77.getFirst()) == false) goto L328;
        ProcessFileResultCode r78 = ProcessFileResultCode.PREPARE_CLONE_SUCCESS;
    L330:
        return new n0(r112, r78);
    L328:
        r78 = ProcessFileResultCode.PREPARE_CLONE_FAILED;
        goto L330
    L320:
        r77 = i(r110, r29, false, null, r30, r33);
        goto L321
    L279:
        if (r33.e != true) goto L281;
        r16 = true;
        goto L281
    L228:
        if (r47.enableImagePreprocessCacheFallback() == false) goto L233;
        r59 = SendResourcePreprocessManager.g(true, r58);     // Catch: Throwable -> L236
        x.b(r59);     // Catch: Throwable -> L236
        r11.w("SendResourcePreprocessManager_AlbumImgProcessor", "[tryCompress] retry compress to cache outPath:".concat(r59));     // Catch: Throwable -> L236
        if (o(r48, r54, r55, r59) == true) goto L234;
    L233:
        r59 = null;
    L217:
        if (r31 == null) goto L221;
        r57 = r31.c;     // Catch: Throwable -> L236
    L221:
        r57 = null;
        goto L222
    L219:
        if (r31 == null) goto L221;
        r57 = r31.c;     // Catch: Throwable -> L236
        goto L222
    L207:
        if (r55 >= 101) goto L209;
        r56 = true;
    L201:
        r54 = null;
        goto L202
    L199:
        if (r31 == null) goto L201;
        r54 = r31.d;     // Catch: Throwable -> L236
        goto L202
    L193:
        if (r48.hasAlpha() == false) goto L195;
        r53 = true;
        goto L196
    L190:
        r52 = false;
        goto L191
    L180:
        if (Intrinsics.areEqual(r49, "image/webp") == true) goto L187;
        if (Intrinsics.areEqual(r49, "image/heif") == true) goto L187;
        if (Intrinsics.areEqual(r49, "image/heic") == true) goto L187;
        r50 = true;
        r51 = false;
        goto L188
    L173:
        if (Intrinsics.areEqual(r48, r46) == false) goto L177;
        if (((Boolean) r45.getSecond()).booleanValue() == true) goto L177;
    L170:
        r48 = r46;
    L176:
        r112 = r215;
        r62 = null;
    L236:
        th = th;
    L240:
        Result.Companion r79 = Result.Companion;
        r60 = Result.constructor-impl(ResultKt.createFailure(th));
    L238:
        th = th;
        r111 = "<this>";
        r215 = r6;
        r213 = r14;
        r214 = r15;
        r110 = r9;
        goto L240
    L162:
        r212 = null;
        goto L163
    L362:
        Integer r80 = r31.a;     // Catch: Throwable -> L238
        if (r80 == null) goto L157;
        r44 = r80.intValue();     // Catch: Throwable -> L238
        goto L158
    L143:
        if (r14.getStatSize() <= 0) goto L150;
        if (r31 == null) goto L146;
        int r81 = r31.h;
    L148:
        if (r81 <= r14.getStatSize()) goto L151;
        r210 = true;
        goto L152
    L146:
        r81 = 0;
        goto L148
    L137:
        if (Intrinsics.areEqual(r42, "image/heic") == true) goto L140;
        r43 = false;
        goto L141
    L130:
        if (r33.a != r38) goto L132;
        r40 = true;
    L270:
        r111 = "<this>";
        r112 = r6;
        r214 = r15;
        r110 = r9;
    L126:
        r39 = false;
        goto L127
    L125:
        r38 = true;
        goto L126
    L43:
        if (Intrinsics.areEqual(r9.toLowerCase(), "image/gif") == false) goto L45;
        r18 = true;
        goto L47
    L37:
        if (Intrinsics.areEqual(r32, "doc") == true) goto L40;
        r17 = false;
        goto L41
    L32:
        if (r33.d != true) goto L34;
        r12 = true;
    L21:
        th = move-exception;
        Result.Companion r82 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L17:
        r3 = false;
        goto L18
    L13:
        return new n0(r6, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    L9:
        th = move-exception;
        FLogger.a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] openFileDescriptor failed: " + th);
        r14 = null;
        goto L11
    }

    public final Pair<Bitmap, Boolean> n(Uri r18, FileDescriptor r19, int r20, Integer r21, ns8.b r22) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = false;
        AppHost.Companion r6 = AppHost.a;
        AppHost.Companion r8 = null;
        if (r6.isPlugin() == true) goto L107;
        Bitmap r1 = BitmapFactory.decodeFileDescriptor(r19, null, r0);
    L25:
        Bitmap r9 = r1;
        FLogger r2 = FLogger.a;
        StringBuilder r7 = new StringBuilder("origin");
        if (r9 == null) goto L28;
        Integer r10 = Integer.valueOf(r9.getHeight());
    L29:
        r7.append(r10);
        r7.append(',');
        if (r9 == null) goto L32;
        Integer r11 = Integer.valueOf(r9.getWidth());
    L33:
        r7.append(r11);
        r7.append(",isRecycled ");
        if (r9 == null) goto L36;
        Boolean r12 = Boolean.valueOf(r9.isRecycled());
    L37:
        r7.append(r12);
        r7.append(')');
        r2.i("SendResourcePreprocessManager_AlbumImgProcessor", r7.toString());
        if (r9 != null) goto L40;
        return null;
    L40:
        Matrix r14 = new Matrix();
        Boolean r13 = f().a();
        AppHost.Companion r15 = Boolean.TRUE;
        float r16 = 270.0f;
        if (Intrinsics.areEqual(r13, r15) == false) goto L54;
        int r3 = m(r19);
        r2.i("SendResourcePreprocessManager_AlbumImgProcessor", "[getRotationFixedMatrix] orientation: " + r3);
        switch(r3) {
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            default: goto L44;
        };
    L44:
        boolean r4 = false;
    L53:
        r8 = Boolean.valueOf(r4);
    L72:
        if (r8 == null) goto L74;
        boolean r5 = r8.booleanValue();
    L76:
        if (Math.min(r9.getWidth(), r9.getHeight()) <= r20) goto L83;
        if (r20 <= 0) goto L83;
        if (r9.getWidth() >= r9.getHeight()) goto L81;
        float r17 = r20;
        int r23 = r9.getWidth();
    L82:
        float r24 = r17 / r23;
    L84:
        if (r21 != null) goto L86;
    L94:
        float r25 = f.a(r24, r22);
        if (Intrinsics.areEqual(f().a(), r15) == false) goto L104;
        if (r5 == true) goto L104;
        if (r25 != 1.0f) goto L100;
        boolean r26 = true;
    L101:
        if (r26 == false) goto L104;
        return TuplesKt.to(r9, Boolean.FALSE);
    L100:
        r26 = false;
    L104:
        r14.postScale(r25, r25);
        r2.i("SendResourcePreprocessManager_AlbumImgProcessor", "[tryFixImgDegreeForCompress] resize scaleFactor: " + r25 + ",height: " + r9.getHeight() + ", width: " + r9.getWidth() + ", optShortSize: " + r20 + "optLongSize: " + r21);
        return TuplesKt.to(Bitmap.createBitmap(r9, 0, 0, r9.getWidth(), r9.getHeight(), r14, true), r15);
    L86:
        if (r21.intValue() <= 0) goto L94;
        if ((Math.max(r9.getWidth(), r9.getHeight()) * r24) <= r21.intValue()) goto L94;
        if (r9.getWidth() >= r9.getHeight()) goto L92;
        float r27 = r21.intValue();
        int r28 = r9.getHeight();
    L93:
        r24 = r27 / r28;
        goto L94
    L92:
        r27 = r21.intValue();
        r28 = r9.getWidth();
        goto L93
    L81:
        r17 = r20;
        r23 = r9.getHeight();
    L83:
        r24 = 1.0f;
        goto L84
    L74:
        r5 = false;
        goto L76
    L45:
        r14.postRotate(270.0f);
    L52:
        r4 = true;
        goto L53
    L46:
        r14.postScale(-1.0f, 1.0f);
        r14.postRotate(90.0f);
        goto L52
    L47:
        r14.postRotate(90.0f);
        goto L52
    L48:
        r14.postScale(-1.0f, 1.0f);
        r14.postRotate(270.0f);
        goto L52
    L49:
        r14.postScale(1.0f, -1.0f);
        goto L52
    L50:
        r14.postRotate(180.0f);
        goto L52
    L51:
        r14.postScale(-1.0f, 1.0f);
        goto L52
    L54:
        int r29 = m(r19);
        if (r29 != 3) goto L57;
        r16 = 180.0f;
    L63:
        Float r30 = Float.valueOf(r16);
        if (r30.floatValue() <= 0.0f) goto L66;
        boolean r31 = true;
    L67:
        if (r31 == true) goto L70;
        r30 = null;
    L70:
        if (r30 == null) goto L72;
        float r32 = r30.floatValue();
        r2.i("SendResourcePreprocessManager_AlbumImgProcessor", "[tryFixImgDegreeForCompress] tryFixImgDegree not to rotate degree:" + r32);
        r14.postRotate(r32);
        r8 = r15;
        goto L72
    L66:
        r31 = false;
        goto L67
    L57:
        if (r29 != 6) goto L59;
        r16 = 90.0f;
        goto L63
    L59:
        if (r29 == 8) goto L63;
        r16 = 0.0f;
        goto L63
    L36:
        r12 = null;
        goto L37
    L32:
        r11 = null;
        goto L33
    L28:
        r10 = null;
        goto L29
    L107:
        r6 = ContentResolverWrapper.openInputStream(r6.getApplication().getContentResolver(), r18);     // Catch: Throwable -> L13 Exception -> L15
        r1 = BitmapFactory.decodeStream(r6);     // Catch: Throwable -> L9 Exception -> L11
        if (r6 == null) goto L106;
    L20:
        r6.close();
    L106:
    L11:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L9
        r1 = null;
        if (r6 == null) goto L106;
    L9:
        th = th;
        r8 = r6;
    L21:
        if (r8 == null) goto L23;
        r8.close();
    L23:
        throw th;
    L15:
        e = e;
        r6 = null;
    L13:
        th = th;
        goto L21
    }
}
