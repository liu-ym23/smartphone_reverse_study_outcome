package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kq9.t;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class e {
    public final Lazy a;
    public final Lazy b;
    public ExifInterface c;

    public static final class a {
    }

    static {
    }

    public final t f() {
        return (t) this.a.getValue();
    }

    public e() {
        this.a = LazyKt.lazy(new c());
        this.b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new d());
    }

    public static void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "path");
        FLogger r0 = FLogger.a;
        r0.i("BaseProcessor", "[checkDestExist] path:" + r5);
        if (m5.c(r5) == false) goto L5;
        return;
    L5:
        r0.i("BaseProcessor", "[checkDestExist] dest not exist");
        String r6 = StringsKt.substringBeforeLast$default(r5, '/', null, 2, null);
        r0.i("BaseProcessor", "[checkDestExist] dir:" + r6);
        if (m5.c(r6) == false) goto L20;
        return;
    L20:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(Boolean.valueOf(new PolarisFileWrapper(r6).mkdirs()));     // Catch: Throwable -> L10
    L12:
        Throwable r2 = Result.exceptionOrNull-impl(r7);
        if (r2 == null) goto L15;
        FLogger.a.e("BaseProcessor", "[checkDestExist] dir not exist, mkdirs exception: " + r2);
    L15:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L18;
        r7 = r3;
    L18:
        boolean r8 = ((Boolean) r7).booleanValue();
        FLogger.a.i("BaseProcessor", "[checkDestExist] dir not exist, mkdirs success:" + r8);
        return;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static String e(String r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        List r8 = StringsKt.split$default(r7, new String[]{"/"}, false, 0, 6, null);
        String r9 = (String) CollectionsKt.getOrNull(r8, Math.max(1, CollectionsKt.getLastIndex(r8)));
        FLogger.a.i("BaseProcessor", "getFormatSuffix: " + r9);
        return r9;
    }

    public final boolean g(Bitmap.CompressFormat r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Intrinsics.areEqual(i.a(r2), "webp") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(f().f(), Boolean.TRUE) == false) goto L7;
        return true;
    }

    public static long c(FileDescriptor r7, Uri r8) {
        Intrinsics.checkNotNullParameter(r7, "fileDescriptor");
        Intrinsics.checkNotNullParameter(r8, "uri");
        long r4 = -1;
        PolarisFileWrapper r6 = null;
        if (z2.a.androidPreprocessOptFileSize() == false) goto L72;
        ImFileUtil.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "uri");
        if (Intrinsics.areEqual(r8.getScheme(), "content") == false) goto L30;
        Cursor r9 = ImFileUtil.b((ContentResolver) ImFileUtil.b.getValue(), r8, null);     // Catch: Exception -> L27
        if (r9 == null) goto L24;
        Cursor r10 = r9;     // Catch: Exception -> L27
        Cursor r0 = r10;     // Catch: Throwable -> L14
        if (r0.moveToFirst() == false) goto L16;
        int r1 = r0.getColumnIndex("_size");     // Catch: Throwable -> L14
        if (r1 == (-1)) goto L16;
        long r2 = r0.getLong(r1);     // Catch: Throwable -> L14
    L17:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r10, null);     // Catch: Exception -> L27
    L79:
        return ImFileUtil.h(r8, r2, "getFileSize");
    L16:
        r2 = -1;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Exception -> L27
        throw th;     // Catch: Exception -> L27
    L24:
        r2 = -1;
    L27:
        e = move-exception;
        FLogger.a.e("ImFileUtil", "getFileSize failed, uri: " + r8 + ", error: " + e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        return -1;
    L30:
        if (Intrinsics.areEqual(r8.getScheme(), "file") == false) goto L32;
        String r11 = r8.getPath();
    L33:
        if (r11 == null) goto L77;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r11);
        if (r12.exists() == false) goto L37;
        r6 = r12;
    L37:
        if (r6 != null) goto L39;
        return -1;
    L39:
        return r6.length();
    L77:
        return -1;
    L32:
        r11 = r8.toString();
        goto L33
    L72:
        PolarisFileWrapper r13 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L47
        r4 = r13.available();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r13.close();     // Catch: Throwable -> L58
    L65:
    L45:
        th = th;
        r6 = r13;
    L68:
        FLogger.a.w("BaseProcessor", "checkSendFileSize failed, err:" + th);     // Catch: Throwable -> L53
        if (r6 == null) goto L52;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r6.close();     // Catch: Throwable -> L58
    L53:
        th = move-exception;
        if (r6 == null) goto L57;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r6.close();     // Catch: Throwable -> L59
    L57:
        throw th;
    L47:
        th = th;
    L52:
        return r4;
    }

    public static void d(ExifInterface r25, String r26) {
        Intrinsics.checkNotNullParameter(r26, "imageOutputPath");
        if (r25 != null) goto L5;
        return;
    L5:
        List r2 = CollectionsKt.mutableListOf(new String[]{"FNumber", "ShutterSpeedValue", "ISOSpeedRatings", "DateTime", "DateTimeOriginal", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance", "ColorSpace", "BrightnessValue", "Contrast", "ISOSpeed", "ImageWidth", "ImageLength"});
        ISettingRepoService r3 = (ISettingRepoService) ServiceManager.get().getService(ISettingRepoService.class);
        int r4 = 0;
        if (r3 == null) goto L10;
        boolean r5 = true;
        if (r3.H() != true) goto L10;
    L12:
        if (r5 == false) goto L25;
        FLogger.a.d("BaseProcessor", "copyExif with location");
        r2.addAll(CollectionsKt.listOf(new String[]{"GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp"}));
    L25:
        ExifInterface r6 = new ExifInterface(r26);     // Catch: IOException -> L22
        Iterator r1 = r2.iterator();     // Catch: IOException -> L22
    L16:
        if (r1.hasNext() == false) goto L20;
        String r7 = (String) r1.next();     // Catch: IOException -> L22
        String r8 = r25.getAttribute(r7);     // Catch: IOException -> L22
        if (TextUtils.isEmpty(r8) == true) goto L16;
        r6.setAttribute(r7, r8);     // Catch: IOException -> L22
        r4 = r4 + 1;     // Catch: IOException -> L22
        goto L16
    L20:
        r6.resetOrientation();     // Catch: IOException -> L22
        r6.saveAttributes();     // Catch: IOException -> L22
        FLogger.a.d("BaseProcessor", "copyExif success, setAttribute count: " + r4);     // Catch: IOException -> L22
        return;
    L22:
        e = move-exception;
        FLogger.a.d("BaseProcessor", "copyExif failed, " + e.getMessage());
        return;
    L10:
        r5 = false;
        goto L12
    }

    public static String a(e r7, String r8, ns8.b r9, String r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r8 = "jpeg";
    L5:
        String r1 = r8;
        if ((r11 & 4) == 0) goto L8;
        ns8.b r3 = null;
    L10:
        if ((r11 & 8) == 0) goto L12;
        String r4 = null;
    L13:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "suffix");
        String r12 = SendResourcePreprocessManager.h(true, r1, false, r3, r4, null, 32);
        x.b(r12);
        return r12;
    L12:
        r4 = r10;
        goto L13
    L8:
        r3 = r9;
        goto L10
    }

    public final Pair<String, String> i(String r10, Uri r11, boolean r12, String r13, boolean r14, ns8.b r15) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        StringBuilder r0 = new StringBuilder();
        if (r14 == false) goto L11;
        if (r15 != null) goto L6;
    L8:
        boolean r16 = false;
    L9:
        if (r16 == true) goto L11;
        boolean r17 = true;
    L12:
        PolarisFileOutputStreamWrapper r18 = null;
        if (r17 == true) goto L95;
    L17:
        MessageDigest r3 = null;
    L19:
        if (r12 == true) goto L25;
        if (r10 != null) goto L117;
    L24:
        r13 = "emptyType";
        goto L25
    L117:
        r13 = e(r10);     // Catch: Throwable -> L68
        if (r13 != null) goto L25;
    L68:
        th = move-exception;
        Object th = th;
        PolarisFileOutputStreamWrapper r19 = null;
        PolarisFileOutputStreamWrapper r110 = null;
    L70:
        PolarisFileOutputStreamWrapper r111 = r110;
    L101:
        FLogger.a.w("BaseProcessor", "tryCloneOriginalRes err: " + th);     // Catch: Throwable -> L82
        if (r110 != null) goto L111;
    L76:
        if (r111 == null) goto L79;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        r111.close();     // Catch: Throwable -> L92
    L79:
        m5.b(r19);
        r0.setLength(0);
    L81:
        return TuplesKt.to(r18, r0.toString());
    L111:
        r110.close();     // Catch: Exception -> L75
    L82:
        th = move-exception;
        if (r110 != null) goto L113;
    L87:
        if (r111 == null) goto L90;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        r111.close();     // Catch: Throwable -> L93
    L90:
        m5.b(r19);
        r0.setLength(0);
        throw th;
    L113:
        r110.close();     // Catch: Exception -> L86
    L25:
        if (r13 != null) goto L27;
    L30:
        boolean r112 = true;
    L31:
        if (r112 == true) goto L59;
        Intrinsics.checkNotNullParameter(r13, "suffix");     // Catch: Throwable -> L68
        r19 = SendResourcePreprocessManager.a.b(true, r13, r12);     // Catch: Throwable -> L68
        x.b(r19);     // Catch: Throwable -> L68
        r110 = ContentResolverWrapper.openInputStream((ContentResolver) this.b.getValue(), r11);     // Catch: Throwable -> L57
        if (r110 != null) goto L115;
    L56:
        PolarisFileOutputStreamWrapper r113 = r19;
        PolarisFileOutputStreamWrapper r114 = r18;
        r18 = r110;
    L60:
        if (r18 != null) goto L103;
    L64:
        if (r114 == null) goto L67;
        Intrinsics.checkNotNullParameter(r114, "<this>");
        r114.close();     // Catch: Throwable -> L94
    L67:
        r18 = r113;
        goto L81
    L103:
        r18.close();     // Catch: Exception -> L63
        goto L64
    L115:
        r111 = new PolarisFileOutputStreamWrapper(r19);     // Catch: Throwable -> L54
        byte[] r115 = new byte[10240];     // Catch: Throwable -> L52
        int r5 = r110.read(r115);     // Catch: Throwable -> L52
    L39:
        if ((-1) == r5) goto L44;
        r111.write(r115, 0, r5);     // Catch: Throwable -> L52
        if (r3 == null) goto L43;
        r3.update(r115, 0, r5);     // Catch: Throwable -> L52
    L43:
        r5 = r110.read(r115);     // Catch: Throwable -> L52
        goto L39
    L44:
        r111.flush();     // Catch: Throwable -> L52
        if (r17 == false) goto L51;
        if (r3 == null) goto L51;
        byte[] r116 = r3.digest();     // Catch: Throwable -> L52
        int r117 = r116.length;     // Catch: Throwable -> L52
        int r4 = 0;
    L48:
        if (r4 >= r117) goto L51;
        byte r6 = r116[r4];     // Catch: Throwable -> L52
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L52
        r0.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r6)}, 1)));     // Catch: Throwable -> L52
        r4 = r4 + 1;
    L51:
        r18 = r111;
    L52:
        th = th;
    L54:
        th = move-exception;
        th = th;
        r111 = null;
    L57:
        th = move-exception;
        th = th;
        r110 = null;
        goto L70
    L59:
        r114 = null;
        r113 = null;
        goto L60
    L27:
        if (r13.length() == 0) goto L30;
        r112 = false;
        goto L31
    L95:
        r3 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L16
    L6:
        if (r15.f != true) goto L8;
        r16 = true;
    L11:
        r17 = false;
        goto L12
    }

    public static Pair h(e r18, String r19, FileDescriptor r20, boolean r21, String r22, boolean r23, ns8.b r24, String r25, Uri r26, int r27) {
        if ((r27 & 4) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r27 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r27 & 16) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r27 & 32) == 0) goto L17;
        ns8.b r7 = null;
    L19:
        if ((r27 & 64) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r27 & 128) == 0) goto L25;
        Uri r1 = null;
    L26:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r20, "fileDescriptor");
        StringBuilder r9 = new StringBuilder();
        if (r6 == false) goto L35;
        if (r7 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == true) goto L35;
        boolean r12 = true;
    L36:
        if (r12 == true) goto L162;
    L40:
        MessageDigest r13 = null;
    L42:
        if (r2 == false) goto L44;
        String r14 = r4;
    L51:
        if (r14 == null) goto L57;
        if (r14.length() == 0) goto L57;
        boolean r15 = false;
    L58:
        if (r15 == false) goto L138;
        r6 = r6;
        FileOutputStream r5 = null;
        String r10 = null;
        FileInputStream r16 = null;
    L94:
        if (r16 == null) goto L99;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        r16.close();     // Catch: Throwable -> L98
    L99:
        if (r5 == null) goto L104;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.close();     // Catch: Throwable -> L103
    L104:
        Object r17 = null;
    L118:
        if (r17 == null) goto L124;
        if (r1 == null) goto L124;
        if (Intrinsics.areEqual(r18.f().a(), Boolean.TRUE) == false) goto L124;
        return r18.i(r19, r1, r2, r4, r6, r7);
    L124:
        return TuplesKt.to(r10, r9.toString());
    L138:
        Intrinsics.checkNotNullParameter(r14, "suffix");     // Catch: Throwable -> L91
        r10 = SendResourcePreprocessManager.h(true, r14, r2, r7, r8, null, 32);     // Catch: Throwable -> L91
        x.b(r10);     // Catch: Throwable -> L91
        r16 = new PolarisFileInputStreamWrapper(r20);     // Catch: Throwable -> L89
    L87:
        th = th;
        r6 = r6;
    L107:
        r5 = null;
    L142:
        FLogger.a.w("BaseProcessor", "tryCloneOriginalRes err: " + th);     // Catch: Throwable -> L125
        if (r16 == null) goto L114;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        r16.close();     // Catch: Throwable -> L113
    L114:
        if (r5 == null) goto L117;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.close();     // Catch: Throwable -> L136
    L117:
        m5.b(r10);
        r9.setLength(0);
        r17 = th;
        r10 = null;
    L125:
        th = move-exception;
        if (r16 == null) goto L131;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        r16.close();     // Catch: Throwable -> L130
    L131:
        if (r5 == null) goto L134;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.close();     // Catch: Throwable -> L137
    L134:
        m5.b(r10);
        r9.setLength(0);
        throw th;
    L62:
        if (Intrinsics.areEqual(r18.f().a(), Boolean.TRUE) == false) goto L66;
        r6 = r6;
        r16.getChannel().position(0);     // Catch: Throwable -> L85
    L67:
        r5 = new PolarisFileOutputStreamWrapper(r10);     // Catch: Throwable -> L85
        byte[] r0 = new byte[10240];     // Catch: Throwable -> L83
        int r28 = r16.read(r0);     // Catch: Throwable -> L83
    L71:
        if ((-1) == r28) goto L76;
        r5.write(r0, 0, r28);     // Catch: Throwable -> L83
        if (r13 == null) goto L75;
        r13.update(r0, 0, r28);     // Catch: Throwable -> L83
    L75:
        r28 = r16.read(r0);     // Catch: Throwable -> L83
        goto L71
    L76:
        r5.flush();     // Catch: Throwable -> L83
        if (r12 == false) goto L94;
        if (r13 == null) goto L94;
        byte[] r3 = r13.digest();     // Catch: Throwable -> L83
        int r29 = r3.length;     // Catch: Throwable -> L83
        int r110 = 0;
    L80:
        if (r110 >= r29) goto L94;
        byte r111 = r3[r110];     // Catch: Throwable -> L83
        StringCompanionObject r112 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L83
        byte[] r210 = r3;
        r9.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r111)}, 1)));     // Catch: Throwable -> L83
        r110 = r110 + 1;
        r3 = r210;
    L83:
        th = th;
    L85:
        th = th;
        goto L107
    L66:
        r6 = r6;
    L89:
        th = th;
    L106:
        r16 = null;
    L91:
        th = th;
        r10 = null;
    L48:
        th = th;
        r6 = r6;
        r5 = null;
        r10 = null;
        r16 = null;
    L57:
        r15 = true;
        goto L58
    L44:
        if (r19 != null) goto L146;
    L50:
        r14 = "emptyType";
        goto L51
    L146:
        r14 = e(r19);     // Catch: Throwable -> L48
        if (r14 != null) goto L51;
    L162:
        r13 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L39
    L30:
        if (r7.f != true) goto L32;
        r11 = true;
    L35:
        r12 = false;
        goto L36
    L25:
        r1 = r26;
        goto L26
    L21:
        r8 = r25;
        goto L23
    L17:
        r7 = r24;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r4 = r22;
        goto L11
    L5:
        r2 = r21;
        goto L7
    }
}
