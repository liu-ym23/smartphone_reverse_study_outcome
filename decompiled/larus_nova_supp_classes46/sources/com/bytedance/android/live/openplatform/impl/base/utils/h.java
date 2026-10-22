package com.bytedance.android.live.openplatform.impl.base.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingDialog$jumpToGallery$1;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public final Activity a;
    public final String b;
    public final String c;
    public final e d;
    public final int e;
    public final int f;
    public Uri g;

    public final Uri b() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.c + "_null");
        r0.append(".jpeg");
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.b + "/" + r0.toString());
        if (r1.exists() == false) goto L19;
    L12:
        Activity r2 = this.a;
        int r3 = c.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r1, "file");
        if (Build.VERSION.SDK_INT < 24) goto L18;
        if (r2.getApplicationInfo().targetSdkVersion < 24) goto L18;
        return FileProvider.getUriForFile(r2, r2.getPackageName() + ".fileprovider", r1);
    L18:
        return Uri.fromFile(r1);
    L19:
        PolarisFileWrapper r4 = new PolarisFileWrapper(this.b);     // Catch: IOException -> L9
        if (r4.exists() == true) goto L7;
        r4.mkdirs();     // Catch: IOException -> L9
    L7:
        r1.createNewFile();     // Catch: IOException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final String c() {
        return this.c + "_null";
    }

    public final Uri d() {
        String r0 = c();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.b + "/" + r0);
        if (r1.exists() == true) goto L15;
        PolarisFileWrapper r2 = new PolarisFileWrapper(this.b);     // Catch: IOException -> L12
        if (r2.exists() == true) goto L10;
        r2.mkdirs();     // Catch: IOException -> L12
    L10:
        r1.createNewFile();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L15:
        return Uri.fromFile(r1);
    }

    public final void e(Uri r7, boolean r8) {
        System.currentTimeMillis();
        if (r7 != null) goto L5;
        return;
    L5:
        Intent r1 = new Intent("com.android.camera.action.CROP");
        if (r8 == false) goto L34;
    L14:
        r1.setDataAndType(r7, "image/*");     // Catch: Exception -> L23
        r1.putExtra("crop", "true");     // Catch: Exception -> L23
        r1.putExtra("scale", true);     // Catch: Exception -> L23
        r1.putExtra("aspectX", this.e);     // Catch: Exception -> L23
        r1.putExtra("aspectY", this.f);     // Catch: Exception -> L23
        r1.putExtra("return-data", false);     // Catch: Exception -> L23
        r1.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());     // Catch: Exception -> L23
        r1.putExtra("noFaceDetection", true);     // Catch: Exception -> L23
        r1.putExtra("scaleUpIfNeeded", true);     // Catch: Exception -> L23
        IHostApp r9 = jc1.k.f(IHostApp.class);     // Catch: Exception -> L23
        if (r9 != null) goto L17;
    L19:
        Uri r10 = d();     // Catch: Exception -> L23
    L20:
        if (r10 == null) goto L30;
        r1.putExtra("output", r10);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L30:
        this.a.startActivityForResult(r1, 40002);     // Catch: Exception -> L27
        return;
    L27:
        f2.b(2131920894, 0);
        return;
    L17:
        if (r9.shouldUseScopedStorage() == false) goto L19;
        ContentValues r11 = new ContentValues();     // Catch: Exception -> L23
        r11.put("title", "avatar_crop.jpeg");     // Catch: Exception -> L23
        r11.put("datetaken", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L23
        r10 = a(this.a.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r11);     // Catch: Exception -> L23
        this.g = r10;     // Catch: Exception -> L23
        goto L20
    L34:
        String r12 = r7.getLastPathSegment();     // Catch: Exception -> L23
        if (StringUtils.isEmpty(r12) == false) goto L11;
    L32:
        r7 = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, CastLongProtector.parseLong(r12));     // Catch: NumberFormatException -> L29 Exception -> L23
        goto L14
    L11:
        if (r12.contains(":") == false) goto L32;
        r12 = r12.split(":")[1];     // Catch: Exception -> L23
        goto L32
    }

    public static Uri a(ContentResolver r18, Uri r19, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
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
        f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r19, r20);
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

    public h(Activity r1, int r2, int r3, ExplainCardSettingDialog$jumpToGallery$1 r4) {
        this.a = r1;
        this.d = r4;
        this.e = r2;
        this.f = r3;
        this.c = "miniapp_panel_cover.data";
        this.b = c.a(r1).getAbsolutePath();
        r1.getResources();
    }
}
