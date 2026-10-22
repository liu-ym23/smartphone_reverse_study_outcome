package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.sg1;
import com.bytedance.android.livesdk.config.w00;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q {
    public static final TokenCert a = null;

    static {
        a = TokenCert.with("bpea-apputil_request_permission");
    }

    public static int b(ExifInterface r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {"Orientation", 1};
        f06.b r13 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100022);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r17 = r7;
        int r18 = r8;
        f06.a[] r19 = r9;
        f06.d r4 = r6.preInvoke(100022, "android/media/ExifInterface", "getAttributeInt", r21, r1, "int", r13);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r21.getAttributeInt("Orientation", 1);
    L14:
        r7 = r17 + 1;
        r8 = r18;
        r9 = r19;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static int e(Bitmap r6) {
    L17:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (Build.VERSION.SDK_INT < 24) goto L16;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: IOException -> L17
        r6.compress(Bitmap.CompressFormat.JPEG, 100, r3);     // Catch: IOException -> L17
        int r7 = b(new ExifInterface(new ByteArrayInputStream(r3.toByteArray())));     // Catch: IOException -> L17
        if (r7 != 3) goto L9;
        return 180;
    L9:
        if (r7 != 6) goto L11;
        return 90;
    L11:
        if (r7 != 8) goto L25;
        return 270;
    L25:
        return 0;
    L16:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    public static Uri c(Context r5, String r6) {
        ?? r1 = 0;
        if (StringUtils.isEmpty(r6) == false) goto L29;
        return null;
    L29:
        Cursor r7 = a(r5.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data= ?", new String[]{r6});     // Catch: Throwable -> L13 Exception -> L15
    L11:
        Exception e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r7 == null) goto L20;
    L19:
        r7.close();
    L20:
        return null;
    L7:
        if (r7.moveToFirst() == false) goto L19;
        Uri r8 = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Long.parseLong(r7.getString(0)));     // Catch: Exception -> L11 Throwable -> L21
        r7.close();
        return r8;
    L15:
        e = move-exception;
        e = e;
        r7 = null;
    L13:
        Throwable th = th;
    L23:
        if (r1 == 0) goto L25;
        r1.close();
    L25:
        throw th;
    L21:
        th = move-exception;
        r1 = r5;
        th = th;
        goto L23
    }

    public static String d(Context r12, Uri r13) {
        Cursor r2 = null;
        if (r13 != null) goto L5;
        return null;
    L5:
        String r3 = r13.getScheme();
        if (StringUtils.isEmpty(r3) == true) goto L103;
        if ("file".equals(r3) == true) goto L103;
        if ("http".equals(r3) == false) goto L15;
        return r13.toString();
    L15:
        if ("content".equals(r3) == false) goto L101;
        String[] r4 = {"_data"};
        String r5 = "";
        r2 = a(r12.getContentResolver(), r13, r4, null, null);     // Catch: Exception -> L22 Throwable -> L23
        if (r2.moveToFirst() == false) goto L20;
        r5 = r2.getString(0);     // Catch: Exception -> L22 Throwable -> L23
    L20:
        r2.close();     // Catch: Exception -> L22 Throwable -> L23
    L119:
        r2.close();     // Catch: Exception -> L30
    L32:
        if (StringUtils.isEmpty(r5) == false) goto L53;
        ContentResolver r6 = r12.getContentResolver();     // Catch: Exception -> L43 Throwable -> L44
        String r11 = r13.getLastPathSegment();     // Catch: Exception -> L43 Throwable -> L44
        if (StringUtils.isEmpty(r11) == false) goto L36;
    L38:
        r2 = a(r6, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r4, "_id= ?", new String[]{r11});     // Catch: Exception -> L43 Throwable -> L44
        if (r2.moveToFirst() == false) goto L41;
        r5 = r2.getString(0);     // Catch: Exception -> L43 Throwable -> L44
    L41:
        r2.close();     // Catch: Exception -> L43 Throwable -> L44
    L109:
        r2.close();     // Catch: Exception -> L51
        goto L53
        goto L48
    L36:
        if (r11.contains(":") == false) goto L38;
        r11 = r11.split(":")[1];     // Catch: Exception -> L43 Throwable -> L44
    L44:
        th = move-exception;
        if (r2 != null) goto L121;
    L47:
        throw th;
    L121:
        r2.close();     // Catch: Exception -> L105
    L48:
        if (r2 != null) goto L109;
    L53:
        if (StringUtils.isEmpty(r5) == false) goto L74;
        ContentResolver r7 = r12.getContentResolver();     // Catch: Exception -> L64 Throwable -> L65
        String r14 = r13.getLastPathSegment();     // Catch: Exception -> L64 Throwable -> L65
        if (StringUtils.isEmpty(r14) == false) goto L57;
    L59:
        r2 = a(r7, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r4, "_id= ?", new String[]{r14});     // Catch: Exception -> L64 Throwable -> L65
        if (r2.moveToFirst() == false) goto L62;
        r5 = r2.getString(0);     // Catch: Exception -> L64 Throwable -> L65
    L62:
        r2.close();     // Catch: Exception -> L64 Throwable -> L65
    L117:
        r2.close();     // Catch: Exception -> L72
        goto L74
        goto L69
    L57:
        if (r14.contains(":") == false) goto L59;
        r14 = r14.split(":")[1];     // Catch: Exception -> L64 Throwable -> L65
    L65:
        th = move-exception;
        if (r2 != null) goto L107;
    L68:
        throw th;
    L107:
        r2.close();     // Catch: Exception -> L104
    L69:
        if (r2 != null) goto L117;
    L74:
        if (StringUtils.isEmpty(r5) == true) goto L76;
        return r5;
    L76:
        if (((Boolean) sg1.a.getValue()).booleanValue() == false) goto L130;
    L89:
        e = move-exception;
        ALogger.e("LiveSDK_AppUtil", "parse doc failed", e);
    L115:
        String r15 = r13.getPath();     // Catch: Exception -> L98
        if (StringUtils.isEmpty(r5) == false) goto L131;
        if (r15 != null) goto L95;
        return r5;
    L95:
        if (r15.startsWith("/root") == false) goto L133;
        r5 = r15.substring(5);     // Catch: Exception -> L98
        ALogger.i("LiveSDK_AppUtil", "ears root path = " + r5);     // Catch: Exception -> L98
        return r5;
    L133:
        return r5;
    L131:
        return r5;
    L98:
        e = move-exception;
        ALogger.e("LiveSDK_AppUtil", "filePath failed", e);
        return r5;
    L78:
        if (DocumentsContract.isDocumentUri(r12, r13) == false) goto L115;
        String r16 = DocumentsContract.getDocumentId(r13);     // Catch: Exception -> L89
        if (r16 == null) goto L115;
        if (r16.contains(":") == false) goto L115;
        String[] r17 = r16.split(":");     // Catch: Exception -> L89
        if (r17.length < 2) goto L115;
        if ("primary".equalsIgnoreCase(r17[0]) == false) goto L115;
        r5 = Environment.getExternalStorageDirectory() + "/" + r17[1];     // Catch: Exception -> L89
        goto L115
    L130:
        return r5;
    L23:
        th = move-exception;
        if (r2 != null) goto L113;
    L26:
        throw th;
    L113:
        r2.close();     // Catch: Exception -> L106
    L27:
        if (r2 == null) goto L32;
    L101:
        return null;
    L103:
        return r13.getPath();
    }

    public static File f(Context r0, boolean r1) {
        if (r1 == false) goto L4;
        File r2 = r0.getExternalCacheDir();
    L5:
        if (r2 == null) goto L7;
        return r2;
    L7:
        return r0.getCacheDir();
    L4:
        r2 = null;
        goto L5
    }

    public static o1 g(Context r4, Uri r5) {
        o1 r0 = new o1();
        r0.a = r5;
        String r1 = r5.getScheme();
        r1.getClass();
        PolarisFileWrapper r3 = null;
        if (r1.equals("file") == false) goto L5;
        int r6 = com.ss.ugc.effectplatform.util.r.a;
        if (com.ss.ugc.effectplatform.util.r.b(r5.getPath()) == true) goto L21;
        r3 = new PolarisFileWrapper(r5.getPath());
    L21:
        if (r3 != null) goto L23;
    L25:
        return r0;
    L23:
        if (r3.exists() == false) goto L25;
        r0.c = Long.valueOf(r3.length());
        r0.b = r3.getName();
        goto L25
    L5:
        if (r1.equals("content") == true) goto L26;
        return r0;
    L26:
        Uri r7 = UriProtector.parse(r5.toString());     // Catch: Exception -> L16
        ContentResolver r8 = r4.getContentResolver();     // Catch: Exception -> L16
        if (r8 != null) goto L10;
        return r0;
    L10:
        Cursor r9 = a(r8, r7, null, null, null);     // Catch: Exception -> L16
        if (r9 != null) goto L13;
    L15:
        return r0;
    L13:
        if (r9.moveToFirst() == false) goto L15;
        String r11 = r9.getString(r9.getColumnIndex("_display_name"));     // Catch: Exception -> L16
        long r2 = r9.getLong(r9.getColumnIndex("_size"));     // Catch: Exception -> L16
        r0.b = r11;     // Catch: Exception -> L16
        r0.c = Long.valueOf(r2);     // Catch: Exception -> L16
        r9.close();     // Catch: Exception -> L16
    L17:
        return new o1();
    }

    public static File h(Context r1, String r2) {
        File r3 = f(r1, true);
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3, r2);
        if (r0.exists() == true) goto L8;
        if (r0.mkdir() == true) goto L8;
        return r3;
    L8:
        return r0;
    }

    public static void o(Activity r2, Fragment r3) {
        Intent r0 = new Intent();
        r0.setType("image/*");
        r0.setAction("android.intent.action.OPEN_DOCUMENT");
        if (r3 == null) goto L5;
        r3.startActivityForResult(r0, 40003);     // Catch: Exception -> L7
    L9:
        return;
    L5:
        r2.startActivityForResult(r0, 40003);     // Catch: Exception -> L7
    L7:
        UIUtils.displayToastWithIcon(r2, 2131250233, 2131916012);
    }

    public static void n(Activity r2, Fragment r3, com.bytedance.android.livesdk.utils.k2.a r4) {
        if (r4 == null) goto L5;
        r4.onCallback();
    L5:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L8;
        UIUtils.displayToastWithIcon(r2, 2131250233, 2131916013);
        return;
    L8:
        Intent r5 = new Intent();
        r5.setType("image/*");
        r5.setAction("android.intent.action.GET_CONTENT");
        if (r3 == null) goto L11;
        r3.startActivityForResult(r5, 40003);     // Catch: Exception -> L13
    L15:
        return;
    L11:
        r2.startActivityForResult(r5, 40003);     // Catch: Exception -> L13
    L13:
        UIUtils.displayToastWithIcon(r2, 2131250233, 2131916012);
    }

    public static Cursor a(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, null};
        f06.b r11 = new f06.b();
        f06.d r12 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r11);
        if (r12.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r11, false);
        return (Cursor) r12.b;
    L6:
        Cursor r18 = r13.query(r14, r15, r16, r17, null);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r18, r11, true);
        return r18;
    }

    public static void j(FragmentActivity r2, Fragment r3, String r4, String r5, TokenCert r6) {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L6;
        UIUtils.displayToastWithIcon(r2, 2131250233, 2131916013);
        return;
    L6:
        SettingKey<Boolean> r0 = m60.i.a;
        m60.i.b r1 = new m60.i.b(r2);
        r1.d = new i();
        r1.e = new i();
        r1.b(new n(r4, r5, r2, r3), null, r6, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static void l(Activity r3, Fragment r4, int r5, TokenCert r6, com.bytedance.android.livesdk.utils.k2.a r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 34) goto L8;
        if (r3.getApplicationInfo().targetSdkVersion < 34) goto L8;
        String r1 = "android.permission.READ_MEDIA_VISUAL_USER_SELECTED";
    L13:
        SettingKey<Boolean> r2 = m60.i.a;
        m60.i.b r8 = new m60.i.b(r3);
        r8.d = new i();
        r8.e = new i();
        r8.b(new j(r7, r3, r4, r5), null, r6, new String[]{r1});
        return;
    L8:
        if (r0 >= 33) goto L10;
    L12:
        r1 = "android.permission.WRITE_EXTERNAL_STORAGE";
        goto L13
    L10:
        if (r3.getApplicationInfo().targetSdkVersion < 33) goto L12;
        r1 = "android.permission.READ_MEDIA_IMAGES";
        goto L13
    }

    public static void m(Activity r2, Fragment r3, int r4, TokenCert r5, String[] r6) {
        SettingKey<Boolean> r0 = m60.i.a;
        m60.i.b r1 = new m60.i.b(r2);
        r1.d = new i();
        r1.e = new i();
        r1.b(new k(r2, r3, r4), null, r5, r6);
    }

    public static void p(Activity r7, Fragment r8, int r9, TokenCert r11, com.bytedance.android.livesdk.utils.k2.a r12) {
        q(r7, r8, r9, false, false, r11, r12);
    }

    public static void i(Activity r3, Fragment r4, int r5, boolean r6, boolean r7, p1 r8) {
        if (r8 == null) goto L5;
        ((com.bytedance.android.livesdk.utils.k2.a) r8).onCallback();
    L5:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L8;
        UIUtils.displayToastWithIcon(r3, 2131250233, 2131916013);
        return;
    L8:
        Intent r9 = new Intent();
        r9.setType("*/*");
        if (r5 != 40008) goto L11;
        String[] r1 = {"image/*", "video/*"};
    L12:
        r9.putExtra("android.intent.extra.MIME_TYPES", r1);
        r9.putExtra("android.intent.extra.ALLOW_MULTIPLE", r6);
        r9.putExtra("android.intent.extra.LOCAL_ONLY", r7);
        r9.setAction("android.intent.action.GET_CONTENT");
        r9.addCategory("android.intent.category.OPENABLE");
        if (r4 == null) goto L15;
        r4.startActivityForResult(r9, r5);     // Catch: Exception -> L17
    L19:
        return;
    L15:
        r3.startActivityForResult(r9, r5);     // Catch: Exception -> L17
    L17:
        UIUtils.displayToastWithIcon(r3, 2131250233, 2131916012);
        return;
    L11:
        r1 = new String[]{"image/*"};
        goto L12
    }

    public static void k(Activity r9, Fragment r11, int r12, String r13, String r14, TokenCert r15, com.bytedance.android.livesdk.utils.k2.a r16) {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L6;
        UIUtils.displayToastWithIcon(r9, 2131250233, 2131916013);
        return;
    L6:
        SettingKey<Boolean> r0 = m60.i.a;
        m60.i.b r1 = new m60.i.b(r9);
        r1.d = new i();
        r1.e = new i();
        r1.b(new o(r16, r13, r14, r9, r11, r12), null, r15, new String[]{"android.permission.CAMERA"});
    }

    public static void q(Activity r13, Fragment r14, int r15, boolean r16, boolean r17, TokenCert r18, com.bytedance.android.livesdk.utils.k2.a r19) {
        int r0 = Build.VERSION.SDK_INT;
        String r2 = "android.permission.READ_MEDIA_IMAGES";
        if (r0 < 33) goto L9;
        if (r15 != 40008) goto L7;
        String[] r6 = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};
    L12:
        String[] r9 = r6;
        if (((Boolean) w00.a.getValue()).booleanValue() == true) goto L15;
    L29:
        SettingKey<Boolean> r1 = m60.i.a;
        m60.i.b r11 = new m60.i.b(r13);
        r11.d = new i();
        r11.e = new i();
        r11.b(new m(r13, r14, r15, r16, r17, r18, r19), null, r18, r9);
        return;
    L15:
        if (r15 != 40006) goto L17;
    L20:
        if (r0 >= 33) goto L24;
        r2 = "android.permission.READ_EXTERNAL_STORAGE";
    L24:
        if (ContextCompat.checkSelfPermission(r13, r2) == 0) goto L27;
        SettingKey<Boolean> r3 = m60.i.a;
        m60.i.b r12 = new m60.i.b(r13);
        r12.d = new i();
        r12.e = new i();
        r12.b(new l(r13, r14, r15, r16, r17, r18, r19), null, r18, r9);
        return;
    L27:
        i(r13, r14, r15, r16, r17, r19);
        return;
    L17:
        if (r15 == 400013) goto L20;
        if (r15 != 40003) goto L29;
    L7:
        r6 = new String[]{"android.permission.READ_MEDIA_IMAGES"};
        goto L12
    L9:
        if (r0 < 29) goto L11;
        r6 = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        goto L12
    L11:
        r6 = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        goto L12
    }
}
