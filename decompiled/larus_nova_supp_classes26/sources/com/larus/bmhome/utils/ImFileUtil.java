package com.larus.bmhome.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.media.MediaUtils;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f06.b;
import f06.c;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ImFileUtil {
    public static final ImFileUtil a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;

    public ImFileUtil() {
    }

    static {
        a = new ImFileUtil();
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new t0());
        c = LazyKt.lazy(new i1());
        d = LazyKt.lazy(new j1());
        e = LazyKt.lazy(new k1());
        f = LazyKt.lazy(new u0());
        g = LazyKt.lazy(new v0());
        h = LazyKt.lazy(new w0());
        i = LazyKt.lazy(new x0());
        j = LazyKt.lazy(new y0());
        k = LazyKt.lazy(new z0());
        l = LazyKt.lazy(new c1());
        m = LazyKt.lazy(new d1());
        n = LazyKt.lazy(new e1());
        o = LazyKt.lazy(new f1());
        p = LazyKt.lazy(new g1());
        q = LazyKt.lazy(new h1());
    }

    public static long j() {
        return ((Number) l.getValue()).longValue();
    }

    public static int k() {
        return ((Number) n.getValue()).intValue();
    }

    public static int l() {
        return ((Number) m.getValue()).intValue();
    }

    public static int m() {
        String r0 = PollingConfigService.a.f("vlm_cnt_dg");
        int r1 = 0;
        if (r0 == null) goto L7;
        Integer r2 = StringsKt.toIntOrNull(r0);
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        if (r3 <= 0) goto L10;
        FLogger.a.i("ImFileUtil", "supportMaxImageAndVideoCount downgradeCount = " + r3);
        return r3;
    L10:
        com.larus.platform.model.chat.t0 r4 = q().n();
        if (r4 == null) goto L17;
        com.larus.platform.model.chat.u0 r5 = r4.a();
        if (r5 == null) goto L17;
        Integer r6 = r5.c();
        if (r6 == null) goto L17;
        r1 = r6.intValue();
    L17:
        if (r1 > 0) goto L20;
        return 10;
    L20:
        return r1;
    L7:
        r3 = 0;
        goto L8
    }

    public static int n() {
        String r0 = PollingConfigService.a.f("vlm_cnt_dg");
        int r1 = 0;
        if (r0 == null) goto L7;
        Integer r2 = StringsKt.toIntOrNull(r0);
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        if (r3 <= 0) goto L10;
        FLogger.a.i("ImFileUtil", "supportMaxImageCount downgradeCount = " + r3);
        return r3;
    L10:
        com.larus.platform.model.chat.s0 r4 = q().m();
        if (r4 == null) goto L15;
        Integer r5 = r4.c();
        if (r5 == null) goto L15;
        r1 = r5.intValue();
    L15:
        if (r1 > 0) goto L18;
        return 10;
    L18:
        return r1;
    L7:
        r3 = 0;
        goto L8
    }

    public static int o() {
        return ((Number) q.getValue()).intValue();
    }

    public static com.larus.platform.model.chat.r0 p() {
        if (AccountService.a.a() == false) goto L9;
        com.larus.platform.model.chat.r0 r0 = q().j();
        if (r0 != null) goto L10;
        return null;
    L10:
        return com.larus.platform.model.chat.r0.a(r0, new ArrayList());
    L9:
        return q().j();
    }

    public static com.larus.platform.model.chat.t q() {
        return (com.larus.platform.model.chat.t) c.getValue();
    }

    public static boolean A(long r3) {
        if (r3 > 0) goto L5;
    L8:
        return true;
    L5:
        if (r3 > ((Number) e.getValue()).longValue()) goto L8;
        return false;
    }

    public static String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r4 = "h264";
        if (StringsKt.contains$default(r5, "avc", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r5, "h264", false, 2, null) == true) goto L18;
        r4 = "h265";
        if (StringsKt.contains$default(r5, "hevc", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r5, "h265", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r5, "dolby-vision", false, 2, null) == true) goto L18;
        if (StringsKt.contains$default(r5, '/', false, 2, null) == true) goto L20;
        return r5;
    L20:
        return StringsKt.substringAfterLast$default(r5, '/', null, 2, null);
    L18:
        return r4;
    }

    public static String e(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((StringsKt.endsWith$default(r5, ".jpg", false, 2, null) | StringsKt.endsWith$default(r5, ".jpeg", false, 2, null)) == false) goto L9;
        return "image/jpeg";
    L9:
        if (StringsKt.endsWith$default(r5, ".png", false, 2, null) == false) goto L13;
        return "image/png";
    L13:
        return null;
    }

    public static ic8.m0 f(Uri r11) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        String r6 = i(r11);
        String r1 = null;
        long r2 = -1;
        if (Intrinsics.areEqual(r11.getScheme(), "content") == false) goto L45;
        Cursor r0 = b((ContentResolver) b.getValue(), r11, null);     // Catch: Exception -> L42
        if (r0 != null) goto L61;
    L40:
        r2 = h(r11, r2, "getFileInfoFromUri");     // Catch: Exception -> L42
    L55:
        long r4 = r2;
        return new ic8.m0(r11.toString(), r1, r4, r6, null, null, null, 16368);
    L61:
        Cursor r3 = r0;     // Catch: Exception -> L42
        Cursor r5 = r3;     // Catch: Throwable -> L32
        if (r5.moveToFirst() == false) goto L27;
        a.getClass();     // Catch: Throwable -> L32
        int r7 = r5.getColumnIndex("_display_name");     // Catch: Throwable -> L32
        if (r7 == (-1)) goto L12;
        String r8 = r5.getString(r7);     // Catch: Throwable -> L32
    L13:
        if (r8 != null) goto L64;
        int r9 = r5.getColumnIndex("_data");     // Catch: Throwable -> L32
        if (r9 == (-1)) goto L17;
        String r10 = r5.getString(r9);     // Catch: Throwable -> L32
    L18:
        if (r10 == null) goto L21;
        r8 = StringsKt.substringAfterLast$default(r10, '/', null, 2, null);     // Catch: Throwable -> L32
        goto L64
    L21:
        r8 = null;
        goto L64
    L17:
        r10 = null;
    L64:
        int r12 = r5.getColumnIndex("_size");     // Catch: Throwable -> L25
        if (r12 == (-1)) goto L28;
        r2 = r5.getLong(r12);     // Catch: Throwable -> L25
    L28:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r3, null);     // Catch: Exception -> L38
        r1 = r8;
    L25:
        Throwable th = th;
    L62:
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Exception -> L38
        throw th;     // Catch: Exception -> L38
    L12:
        r8 = null;
        goto L13
    L27:
        r8 = null;
    L32:
        th = move-exception;
        r8 = null;
        th = th;
    L38:
        e = e;
        r1 = r8;
    L43:
        FLogger.a.e("ImFileUtil", "getFileInfoFromUri failed, uri: " + r11 + ", error: " + e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    L42:
        e = e;
        goto L43
    L45:
        if (Intrinsics.areEqual(r11.getScheme(), ShareType.FILE) == false) goto L47;
        String r14 = r11.getPath();
    L48:
        if (r14 == null) goto L55;
        File r15 = new PolarisFileWrapper(r14);
        if (r15.exists() == true) goto L53;
        r15 = null;
    L53:
        if (r15 == null) goto L55;
        r1 = r15.getName();
        r2 = r15.length();
        goto L55
    L47:
        r14 = r11.toString();
        goto L48
    }

    public static String g(File r9) {
        Intrinsics.checkNotNullParameter(r9, ShareType.FILE);
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L15
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(r9);     // Catch: Throwable -> L15
        byte[] r10 = new byte[8192];     // Catch: Throwable -> L15
    L17:
        int r2 = r1.read(r10);     // Catch: Throwable -> L12
        if (r2 <= 0) goto L7;
        r0.update(r10, 0, r2);     // Catch: Throwable -> L12
        goto L17
    L7:
        byte[] r11 = r0.digest();     // Catch: Throwable -> L12
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L12
        int r4 = r11.length;     // Catch: Throwable -> L12
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L10;
        byte r6 = r11[r5];     // Catch: Throwable -> L12
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L12
        r3.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r6)}, 1)));     // Catch: Throwable -> L12
        r5 = r5 + 1;     // Catch: Throwable -> L12
        goto L8
    L10:
        String r12 = r3.toString();     // Catch: Throwable -> L12
        r1.close();     // Catch: Throwable -> L15
        return r12;
    L12:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        return null;
    }

    public static String i(Uri r13) {
        Intrinsics.checkNotNullParameter(r13, "uri");
        if (Intrinsics.areEqual(r13.getScheme(), "content") == false) goto L6;
        return ((ContentResolver) b.getValue()).getType(r13);
    L6:
        if (Intrinsics.areEqual(r13.getScheme(), ShareType.FILE) == false) goto L8;
        String r14 = r13.getPath();
    L9:
        MimeTypeMap r6 = MimeTypeMap.getSingleton();
        if (r14 == null) goto L28;
        int r0 = StringsKt.lastIndexOf$default(r14, '#', 0, false, 6, null);
        boolean r1 = false;
        if (r0 <= 0) goto L15;
        r14 = r14.substring(0, r0);
    L15:
        int r2 = StringsKt.lastIndexOf$default(r14, '?', 0, false, 6, null);
        if (r2 <= 0) goto L18;
        r14 = r14.substring(0, r2);
    L18:
        int r3 = StringsKt.lastIndexOf$default(r14, '/', 0, false, 6, null);
        if (r3 < 0) goto L22;
        r14 = r14.substring(r3 + 1);
    L22:
        if (r14.length() <= 0) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L28;
        int r4 = StringsKt.lastIndexOf$default(r14, '.', 0, false, 6, null);
        if (r4 < 0) goto L28;
        String r15 = r14.substring(r4 + 1);
    L30:
        return r6.getMimeTypeFromExtension(r15);
    L28:
        r15 = "";
        goto L30
    L8:
        r14 = r13.toString();
        goto L9
    }

    public static float r(MediaMetadataRetriever r11) {
        Intrinsics.checkNotNullParameter(r11, "mediaMetadataRetriever");
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L26
        int r3 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L26
        if (r3 < 23) goto L6;
        String r4 = c(r11, 25);     // Catch: Throwable -> L26
    L7:
        if (r4 == null) goto L9;
        float r12 = CastFloatProtector.parseFloat(r4);     // Catch: Throwable -> L26
    L24:
        Object r13 = Result.constructor-impl(Float.valueOf(r12));     // Catch: Throwable -> L26
    L28:
        Throwable r5 = Result.exceptionOrNull-impl(r13);
        if (r5 == null) goto L32;
        FLogger.a.e("ImFileUtil", "[getVideoFps] " + r5);
    L32:
        if (Result.isFailure-impl(r13) == true) goto L35;
        r1 = r13;
    L35:
        Float r6 = (Float) r1;
        if (r6 != null) goto L38;
        return 0.0f;
    L38:
        return r6.floatValue();
    L9:
        String r7 = c(r11, 9);     // Catch: Throwable -> L26
        if (r3 < 28) goto L13;
        String r14 = c(r11, 32);     // Catch: Throwable -> L26
    L20:
        if (r7 == null) goto L23;
        if (r14 == null) goto L23;
        r12 = CastIntegerProtector.parseInt(r14) / (CastLongProtector.parseLong(r7) / 1000.0f);     // Catch: Throwable -> L26
    L23:
        r12 = 0.0f;
        goto L24
    L13:
        if (r7 == null) goto L15;
        long r8 = CastLongProtector.parseLong(r7);     // Catch: Throwable -> L26
    L16:
        long r9 = r8 / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);     // Catch: Throwable -> L26
        if (r9 <= 0) goto L19;
        r14 = String.valueOf(((long) 25) * r9);     // Catch: Throwable -> L26
        goto L20
    L19:
        r14 = null;
        goto L20
    L15:
        r8 = 0;
        goto L16
    L6:
        r4 = null;
    L26:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    public static boolean s(Uri r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r5 = i(r4);
        if (r5 != null) goto L8;
        return false;
    L8:
        if (StringsKt.startsWith$default(r5, "audio/", false, 2, null) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean w(Uri r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return MediaUtils.isPhoto(i(r0));
    }

    public static boolean x(long r4) {
        File r0 = AppHost.a.getApplication().getExternalFilesDir(null);
        if (r0 == null) goto L5;
        long r1 = r0.getFreeSpace();
    L7:
        if (r4 <= (r1 - 52428800)) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    public static boolean y(Uri r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return MediaUtils.isVideo(i(r0));
    }

    public static String c(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        b r11 = new b();
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

    public static Long d(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        MediaMetadataRetriever r1 = new MediaMetadataRetriever();     // Catch: Throwable -> L15
        r1.setDataSource(r2, r3);     // Catch: Throwable -> L12
        String r4 = c(r1, 9);     // Catch: Throwable -> L12
        r1.release();     // Catch: Throwable -> L15
        if (r4 == null) goto L10;
        Long r5 = StringsKt.toLongOrNull(r4);     // Catch: Throwable -> L15
        if (r5 == null) goto L10;
        long r6 = r5.longValue();     // Catch: Throwable -> L15
    L11:
        Object r7 = Result.constructor-impl(Long.valueOf(r6));     // Catch: Throwable -> L15
    L17:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L21;
        FLogger.a.i("ImFileUtil", r8.toString());
    L21:
        if (Result.isFailure-impl(r7) == false) goto L24;
        r7 = null;
    L24:
        return (Long) r7;
    L10:
        r6 = 0;
        goto L11
    L12:
        th = move-exception;
        r1.release();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public static boolean u(String r4, String r5) {
        if (r5 != null) goto L5;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == true) goto L26;
        com.larus.platform.model.chat.r0 r7 = p();
        if (r7 == null) goto L24;
        List r8 = r7.b();
        if (r8 == null) goto L24;
        if (r4 == null) goto L20;
        String r9 = StringsKt.substringAfterLast(r4, ".", "");
        if (r9 == null) goto L20;
        String r10 = r9.toLowerCase(Locale.getDefault());
    L22:
        if (r8.contains(r10) != true) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L26;
        return false;
    L20:
        r10 = null;
    L24:
        r11 = false;
    L26:
        return true;
    L5:
        if (r5.length() != 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 != true) goto L10;
        r6 = true;
        goto L11
    L7:
        r12 = false;
        goto L8
    }

    public static boolean v(long r4, boolean r6) {
        if (r6 == false) goto L4;
        long r0 = ((Number) l.getValue()).longValue();
    L6:
        if (r4 > 0) goto L8;
    L11:
        return true;
    L8:
        if (r4 > r0) goto L11;
        return false;
    L4:
        r0 = ((Number) k.getValue()).longValue();
        goto L6
    }

    public static boolean z(mr9.e r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "videoMeta");
        Integer r0 = r10.j();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        Integer r2 = r10.h();
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L11:
        if (r1 > 0) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r3 > 0) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r4 == true) goto L27;
        if (r5 == true) goto L27;
        boolean r6 = false;
    L29:
        if (r6 == false) goto L32;
        FLogger.a.e("ImFileUtil", "[isOverMetaLimit] isVideoOverResolution:true, h:" + r10.h() + ", w:" + r10.j());
        return true;
    L32:
        Integer r7 = r10.b();
        long r8 = 0;
        if (r7 == null) goto L35;
        long r9 = r7.intValue();
    L37:
        if (r9 > 0) goto L39;
    L42:
        boolean r12 = true;
    L43:
        if (r12 == false) goto L46;
        FLogger.a.e("ImFileUtil", "[isOverMetaLimit] isVideoOverBitrate:true, bitrate:" + r10.b());
        return true;
    L46:
        Long r13 = r10.d();
        if (r13 == null) goto L49;
        r8 = r13.longValue();
    L49:
        int r14 = (int) (r8 / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY));
        if (r11 == true) goto L60;
        if (r14 >= 0) goto L53;
    L56:
        boolean r15 = true;
    L57:
        if (r15 == false) goto L60;
        FLogger.a.e("ImFileUtil", "[isOverMetaLimit] isVideoOverDuration:true, durationS:" + r14);
        return true;
    L53:
        if (r14 > ((Number) i.getValue()).longValue()) goto L56;
        r15 = false;
    L60:
        Float r16 = r10.g();
        if (r16 == null) goto L63;
        float r17 = r16.floatValue();
    L65:
        if (r17 <= ((Number) j.getValue()).floatValue()) goto L67;
        boolean r18 = true;
    L68:
        if (r18 == false) goto L71;
        FLogger.a.e("ImFileUtil", "[isOverMetaLimit] isVideoOverFps:true, fps:" + r10.g());
        return true;
    L71:
        String r19 = r10.f();
        String r20 = null;
        if (r19 == null) goto L74;
        r20 = StringsKt.substringAfterLast$default(r19, '/', null, 2, null);
    L74:
        String r110 = "";
        if (r20 != null) goto L78;
        r20 = "";
    L78:
        if (r20.length() <= 0) goto L80;
        boolean r21 = true;
    L81:
        if (r21 == false) goto L94;
        com.larus.platform.model.chat.t0 r22 = q().n();
        if (r22 == null) goto L91;
        com.larus.platform.model.chat.u0 r23 = r22.a();
        if (r23 == null) goto L91;
        List r24 = r23.b();
        if (r24 == null) goto L91;
        if (r24.contains(r20.toLowerCase(Locale.getDefault())) == true) goto L91;
        boolean r25 = true;
    L92:
        if (r25 == false) goto L94;
        boolean r26 = true;
    L95:
        if (r26 == false) goto L98;
        FLogger.a.e("ImFileUtil", "[isOverMetaLimit] isDisallowedVideoType:true, format:" + r10.f());
        return true;
    L98:
        String r27 = r10.c();
        if (r27 == null) goto L103;
        r110 = r27;
    L103:
        if (r110.length() <= 0) goto L105;
        boolean r28 = true;
    L106:
        if (r28 == false) goto L119;
        com.larus.platform.model.chat.t0 r29 = q().n();
        if (r29 == null) goto L116;
        com.larus.platform.model.chat.u0 r30 = r29.a();
        if (r30 == null) goto L116;
        List r31 = r30.a();
        if (r31 == null) goto L116;
        if (r31.contains(r110.toLowerCase(Locale.getDefault())) == true) goto L116;
        boolean r111 = true;
    L117:
        if (r111 == false) goto L119;
        boolean r112 = true;
    L120:
        if (r112 == false) goto L123;
        FLogger.a.e("ImFileUtil", "[isOverMetaLimit] isDisallowedVideoCodec:true, codec:" + r10.c());
        return true;
    L123:
        return false;
    L116:
        r111 = false;
    L119:
        r112 = false;
        goto L120
    L105:
        r28 = false;
    L91:
        r25 = false;
    L94:
        r26 = false;
        goto L95
    L80:
        r21 = false;
        goto L81
    L67:
        r18 = false;
        goto L68
    L63:
        r17 = 0.0f;
        goto L65
    L39:
        if (r9 > ((Number) h.getValue()).longValue()) goto L42;
        r12 = false;
        goto L43
    L35:
        r9 = 0;
    L27:
        r6 = true;
        goto L29
    L19:
        if (r3 > ((Number) g.getValue()).intValue()) goto L22;
        r5 = false;
        goto L23
    L13:
        if (r1 > ((Number) f.getValue()).intValue()) goto L16;
        r4 = false;
        goto L17
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    public static Cursor b(ContentResolver r12, Uri r13, String[] r14) {
        c r8 = new c();
        Object[] r9 = {r13, r14, null, null, null};
        b r10 = new b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public static long h(Uri r9, long r10, String r12) {
        if (com.larus.platform.service.z2.a.androidPreprocessOptFileSize() == true) goto L5;
        return r10;
    L5:
        FLogger r0 = FLogger.a;
        r0.i("ImFileUtil", r12 + " fileSize from OpenableColumns.SIZE, uri: " + r9 + ", fileSize: " + r10);
        boolean r1 = false;
        Object r4 = null;
        long r5 = 0;
        if (r10 > 0) goto L45;
        r0.i("ImFileUtil", r12 + " fileSize <= 0, try query from MediaStore, uri: " + r9);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L35
        Cursor r13 = b((ContentResolver) b.getValue(), r9, new String[]{"_size"});     // Catch: Throwable -> L35
        if (r13 == null) goto L32;
        Cursor r14 = r13;     // Catch: Throwable -> L35
        Cursor r2 = r14;     // Catch: Throwable -> L27
        if (r2.moveToFirst() == false) goto L24;
        int r15 = r2.getColumnIndex("_size");     // Catch: Throwable -> L27
        if (r15 < 0) goto L24;
        if (r2.isNull(r15) == true) goto L24;
        Long r16 = Long.valueOf(r2.getLong(r15));     // Catch: Throwable -> L27
    L19:
        if (r16.longValue() <= 0) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L24;
    L25:
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L35
    L33:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r17) == false) goto L40;
        r17 = null;
    L40:
        Long r18 = (Long) r17;
        if (r18 == null) goto L43;
        r10 = r18.longValue();
        goto L45
    L43:
        r10 = 0;
        goto L45
    L21:
        r3 = false;
    L24:
        r16 = null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L32:
        r16 = null;
    L35:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L45:
        if (r10 > 0) goto L87;
        FLogger.a.w("ImFileUtil", r12 + " fileSize from MediaStore.MediaColumns.SIZE <= 0, uri: " + r9);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L66
        AssetFileDescriptor r20 = ContentResolverWrapper.openAssetFileDescriptor((ContentResolver) b.getValue(), r9, "r");     // Catch: Throwable -> L66
        if (r20 != null) goto L81;
        Long r111 = null;
    L64:
        Object r21 = Result.constructor-impl(r111);     // Catch: Throwable -> L66
    L69:
        if (Result.isFailure-impl(r21) == true) goto L72;
        r4 = r21;
    L72:
        Long r6 = (Long) r4;
        if (r6 == null) goto L76;
        r5 = r6.longValue();
    L76:
        return r5;
    L81:
        r111 = Long.valueOf(r20.getLength());     // Catch: Throwable -> L58
    L51:
        if (r111.longValue() <= 0) goto L53;
        r1 = true;
    L53:
        if (r1 == true) goto L56;
        r111 = null;
    L56:
        CloseableKt.closeFinally(r20, null);     // Catch: Throwable -> L66
    L58:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L69
    L87:
        return r10;
    }

    public static Object t(Context r3, Uri r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImFileUtil$isAudioFileOverDuration$2(r3, r4, null), r5);
    }

    public static boolean B(final Context r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r6, "fileName");
        final FlowFileProtectionService r0 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L27;
        FLogger.a.d("ImFileUtil", "external file open blocked by enterprise file security");
        com.larus.platform.service.o r8 = com.larus.platform.service.o.a;
        JSONObject r9 = new JSONObject();
        r9.put("action", "open_external");
        r9.put("entry", "im_file_util");
        r9.put("content_type", ShareType.FILE);
        Unit r10 = Unit.INSTANCE;
        r8.reportEvent("flow_enterprise_file_egress_block", r9);
        com.larus.utils.y.c(new a1(r0, r4));
        return false;
    L27:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        Uri r11 = FileProvider.getUriForFile(r4, AppHost.a.getApplication().getPackageName() + ".sendimagesprovider", new PolarisFileWrapper(r5));     // Catch: Throwable -> L21
        if (r7 != null) goto L16;
        HashMap<String, String> r12 = FileMimeTypeUtils.a;     // Catch: Throwable -> L21
        r7 = FileMimeTypeUtils.c(StringsKt.substringAfterLast$default(r6, '.', null, 2, null));     // Catch: Throwable -> L21
        if (r7 != null) goto L16;
        r7 = "*/*";
    L16:
        Intent r13 = new Intent("android.intent.action.VIEW");     // Catch: Throwable -> L21
        r13.addFlags(1);     // Catch: Throwable -> L21
        r13.setDataAndType(r11, r7);     // Catch: Throwable -> L21
        if (r13.resolveActivity(r4.getPackageManager()) == null) goto L19;
        r4.startActivity(r13);     // Catch: Throwable -> L21
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L24:
        if (Result.exceptionOrNull-impl(r14) == null) goto L26;
        return false;
    L26:
        return true;
    L19:
        com.larus.utils.y.c(new b1(r4));     // Catch: Throwable -> L21
        return false;
    L21:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L5:
        if (r0.I0() != true) goto L7;
        r3 = true;
        goto L8
    }
}
