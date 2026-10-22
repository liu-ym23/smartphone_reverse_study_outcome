package com.bytedance.android.annie.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static boolean e() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static String f(String r10) {
        int r0 = r10.length();
        char[] r1 = r10.toCharArray();
        int r11 = 0;
        char r12 = 0;
        int r13 = 0;
    L4:
        if (r11 >= r0) goto L10;
        char r14 = r1[r11];
        if (r14 != '/') goto L8;
        if (r12 != '/') goto L8;
    L9:
        r11 = r11 + 1;
        r12 = r14;
    L8:
        r1[r13] = r14;
        r13 = r13 + 1;
        goto L9
    L10:
        if (r12 == '/') goto L12;
    L14:
        if (r13 != r0) goto L16;
        return r10;
    L16:
        return new String(r1, 0, r13);
    L12:
        if (r0 <= 1) goto L14;
        r13 = r13 - 1;
        goto L14
    }

    public static boolean g(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L16;
        boolean r0 = "mounted".equals(Environment.getExternalStorageState());     // Catch: Exception -> L6
    L7:
        if (r0 == false) goto L17;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r10);
        if (r1.exists() == true) goto L11;
        return false;
    L11:
        if (r1.delete() == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        return false;
    L6:
        r0 = false;
        goto L7
    L16:
        return false;
    }

    public static void b(PolarisFileInputStreamWrapper r10, OutputStream r11) throws IOException {
        byte[] r1 = new byte[4096];     // Catch: Throwable -> L15
        if (r11 == null) goto L14;
    L5:
        int r0 = r10.read(r1);     // Catch: Throwable -> L15
        if (r0 <= 0) goto L7;
        r11.write(r1, 0, r0);     // Catch: Throwable -> L15
        goto L5
    L7:
        r11.flush();     // Catch: Throwable -> L15
        r10.close();     // Catch: IOException -> L20
    L24:
        r11.close();     // Catch: IOException -> L21
        return;
    L34:
        return;
    L14:
        throw new IOException("Failed to copy input:" + r10 + "output:" + r11);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r10.close();     // Catch: IOException -> L22
    L17:
        if (r11 == null) goto L35;
        r11.close();     // Catch: IOException -> L23
        throw th;
    L36:
        throw th;
    L35:
        throw th;
    }

    public static Uri c(Context r10, String r11) {
        String r12 = "image/jpeg";
        if (e() == true) goto L5;
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/" + Environment.DIRECTORY_DCIM + "/Camera");
        if (r0.exists() == true) goto L34;
        r0.mkdirs();
    L34:
        String r1 = Environment.DIRECTORY_DCIM + "/Camera/";
        if (r10 != null) goto L37;
    L48:
        return null;
    L37:
        if (TextUtils.isEmpty(r11) == true) goto L48;
        if (TextUtils.isEmpty(r1) == true) goto L48;
        if (r1.endsWith("/") == true) goto L43;
        r1 = r1.concat("/");
    L43:
        ContentValues r13 = new ContentValues();
        r13.put("_display_name", r11);
        r13.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r13.put("mime_type", "image/jpeg");
        if (e() == false) goto L46;
        Uri r14 = MediaStore.Images.Media.getContentUri("external_primary");
        r13.put("relative_path", r1);
    L50:
        return a(r10.getContentResolver(), r14, r13);
    L46:
        Uri r15 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r13.put("_data", f(Environment.getExternalStorageDirectory().getPath() + "/" + r1 + "/" + r11));
        r14 = r15;
        goto L50
    L5:
        if (r11.endsWith(".jpeg") == false) goto L7;
    L29:
        ContentValues r16 = new ContentValues();
        r16.put("title", r11);
        r16.put("_display_name", r11);
        r16.put("mime_type", r12);
        return a(r10.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r16);
    L7:
        if (r11.endsWith(".jpg") == true) goto L29;
        if (r11.endsWith(".png") == false) goto L13;
        r12 = "image/png";
        goto L29
    L13:
        if (r11.endsWith(".gif") == false) goto L16;
        r12 = "image/gif";
        goto L29
    L16:
        if (r11.endsWith(".webp") == false) goto L19;
        r12 = "image/webp";
        goto L29
    L19:
        if (r11.endsWith(".bmp") == false) goto L22;
        r12 = "image/bmp";
        goto L29
    L22:
        if (r11.endsWith(".jpg2") == false) goto L25;
        r12 = "image/jp2";
        goto L29
    L25:
        if (r11.endsWith(".tif") == false) goto L27;
    L28:
        r12 = "image/tiff";
        goto L29
    L27:
        if (r11.endsWith(".tiff") == false) goto L29;
        goto L28
    }

    public static Uri d(Context r10, String r11) {
        if (e() == false) goto L6;
        ContentValues r0 = new ContentValues();
        r0.put("title", r11);
        r0.put("_display_name", r11);
        r0.put("mime_type", "video/mp4");
        return a(r10.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r0);
    L6:
        PolarisFileWrapper r1 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + "/" + Environment.DIRECTORY_DCIM + "/Camera");
        if (r1.exists() == true) goto L9;
        r1.mkdirs();
    L9:
        String r12 = Environment.DIRECTORY_DCIM + "/Camera/";
        if (r10 != null) goto L12;
    L23:
        return null;
    L12:
        if (TextUtils.isEmpty(r11) == true) goto L23;
        if (TextUtils.isEmpty(r12) == true) goto L23;
        if (r12.endsWith("/") == true) goto L18;
        r12 = r12.concat("/");
    L18:
        ContentValues r13 = new ContentValues();
        r13.put("_display_name", r11);
        r13.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r13.put("mime_type", "video/mp4");
        if (e() == false) goto L21;
        Uri r14 = MediaStore.Video.Media.getContentUri("external_primary");
        r13.put("relative_path", r12);
    L25:
        return a(r10.getContentResolver(), r14, r13);
    L21:
        Uri r15 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        r13.put("_data", f(Environment.getExternalStorageDirectory().getPath() + "/" + r12 + "/" + r11));
        r14 = r15;
        goto L25
    }

    public static Uri a(ContentResolver r18, Uri r19, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r10 = (g06.a) ApiHookConfig.b.get(240017);
        if (r10 == null) goto L5;
        f06.a[] r12 = r10.i;
    L6:
        f06.a[] r15 = r12;
        int r13 = r15.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L15;
        f06.a r16 = r15[r14];
        int r17 = r14;
        int r110 = r13;
        f06.d r21 = r16.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r21.a == true) goto L17;
        r0.add(r16);     // Catch: Exception -> L22
    L17:
        if (r21.a == false) goto L21;
        return (Uri) r21.b;
    L21:
        return r18.insert(r19, r20);
    L14:
        r14 = r17 + 1;
        r13 = r110;
        goto L8
    L15:
        r21 = new f06.d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }
}
