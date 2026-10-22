package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final Fragment a;
    public final a b;
    public Uri c;

    public interface a {
        void a(String r1);

        void d();
    }

    public static final class b {
    }

    static {
    }

    public final File d() {
        Context r1 = this.a.getContext();
        Object r2 = null;
        if (r1 != null) goto L21;
        return null;
    L21:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        PolarisFileWrapper r4 = new PolarisFileWrapper(r1.getCacheDir(), "camera_view/photo");     // Catch: Throwable -> L10
        if (r4.exists() == true) goto L8;
        r4.mkdirs();     // Catch: Throwable -> L10
    L8:
        Object r0 = Result.constructor-impl(new PolarisFileWrapper(r4, "photo_" + System.currentTimeMillis() + ".jpeg"));     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.exceptionOrNull-impl(r0);
        if (r5 == null) goto L16;
        int r6 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#createCameraPhotoFile", "failed: " + r5.getMessage(), null);
        this.b.d();
    L16:
        if (Result.isFailure-impl(r0) == true) goto L20;
        r2 = r0;
    L20:
        return (File) r2;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.a g() {
        String r0 = OfficeSDKManager.getCurrentUid();
        if (r0 != null) goto L17;
        r0 = "";
    L17:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl((com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.a) OfficeSDKManager.getHostUserService(r0, com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.a.class));     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L13;
        int r4 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#getHostCameraDependency", "no host camera dependency: " + r3.getMessage(), null, 8);
    L13:
        if (Result.isFailure-impl(r2) == false) goto L16;
        r2 = null;
    L16:
        return (com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.a) r2;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static Uri c(FragmentActivity r7) {
        String r2 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(new Date());
        ContentValues r3 = new ContentValues();
        r3.put("_display_name", "office_sdk_ai_note_" + r2 + ".jpg");
        r3.put("mime_type", "image/jpeg");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        r3.put("relative_path", Environment.DIRECTORY_PICTURES + "/OfficeSDKAINote");
    L5:
        Object r4 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        Uri r8 = b(r7.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r3);     // Catch: Throwable -> L8
        int r5 = bwb.b.a;     // Catch: Throwable -> L8
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#createCameraOutputUri", "uri=" + r8 + ", displayName=office_sdk_ai_note_" + r2 + ".jpg", null, 8);     // Catch: Throwable -> L8
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L8
    L10:
        Throwable r1 = Result.exceptionOrNull-impl(r9);
        if (r1 == null) goto L14;
        int r10 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#createCameraOutputUri", "failed: " + r1.getMessage(), null);
    L14:
        if (Result.isFailure-impl(r9) == true) goto L18;
        r4 = r9;
    L18:
        return (Uri) r4;
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static String e(Object r2) {
        if (r2 == null) goto L5;
        String r3 = r2.getClass().getSimpleName() + '@' + System.identityHashCode(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return "null";
    }

    public static long f(String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(Long.valueOf(new PolarisFileWrapper(r2).length()));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = -1L;
    L10:
        return ((Number) r3).longValue();
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean h(FragmentActivity r11) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        long r0 = System.currentTimeMillis();
        int r2 = bwb.b.a;
        MmUiLogScene r3 = MmUiLogScene.AI_NOTE;
        bwb.b.g(r3, "MmAINoteMediaBridge#openCamera", "start fragment=" + e(this.a) + " activity=" + e(r11), null, 8);
        com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.a r4 = g();
        if (r4 == null) goto L5;
        r4.B1(this.a);
    L5:
        boolean r8 = false;
        if (ContextCompat.checkSelfPermission(r11, "android.permission.CAMERA") != 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L33;
        this.a.requestPermissions(new String[]{"android.permission.CAMERA"}, 10002);
        bwb.b.g(r3, "MmAINoteMediaBridge#openCamera", "request camera permission costMs=" + (System.currentTimeMillis() - r0), null, 8);
        return true;
    L33:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L20
        Intent r6 = new Intent("android.media.action.IMAGE_CAPTURE");     // Catch: Throwable -> L20
        if (r6.resolveActivity(r11.getPackageManager()) == null) goto L19;
        Uri r9 = c(r11);     // Catch: Throwable -> L20
        this.c = r9;     // Catch: Throwable -> L20
        if (r9 == null) goto L17;
        r6.putExtra("output", r9);     // Catch: Throwable -> L20
        r6.setClipData(ClipData.newUri(r11.getContentResolver(), "office_sdk_ai_note_camera", r9));     // Catch: Throwable -> L20
        r6.addFlags(3);     // Catch: Throwable -> L20
    L17:
        this.a.startActivityForResult(r6, 10001);     // Catch: Throwable -> L20
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L23:
        if (Result.isSuccess-impl(r12) == false) goto L28;
        Unit r10 = (Unit) r12;
        int r13 = bwb.b.a;
        MmUiLogScene r14 = MmUiLogScene.AI_NOTE;
        StringBuilder r15 = new StringBuilder("start system camera, hasOutputUri=");
        if (this.c == null) goto L27;
        r8 = true;
    L27:
        r15.append(r8);
        r15.append(", outputUri=");
        r15.append(this.c);
        r15.append(" costMs=");
        r15.append(System.currentTimeMillis() - r0);
        bwb.b.g(r14, "MmAINoteMediaBridge#openCamera", r15.toString(), null, 8);
    L28:
        Throwable r1 = Result.exceptionOrNull-impl(r12);
        if (r1 == null) goto L32;
        this.c = null;
        int r16 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#openCamera", "start system camera failed: " + r1.getMessage(), null);
        this.b.d();
    L32:
        return Result.isSuccess-impl(r12);
    L19:
        throw new IllegalStateException("no activity can handle ACTION_IMAGE_CAPTURE".toString());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L8:
        r7 = false;
        goto L9
    }

    public final String i(Bitmap r9) {
        File r2 = d();
        Object r3 = null;
        if (r2 != null) goto L27;
        return null;
    L27:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        PolarisFileOutputStreamWrapper r5 = new PolarisFileOutputStreamWrapper(r2);     // Catch: Throwable -> L14
        r9.compress(Bitmap.CompressFormat.JPEG, 95, r5);     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L14
        int r6 = bwb.b.a;     // Catch: Throwable -> L14
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#saveCameraBitmapToFile", "success, path=" + r2.getAbsolutePath() + ", size=" + r2.length() + ", bitmap=" + r9.getWidth() + 'x' + r9.getHeight() + ", recycled=" + r9.isRecycled(), null, 8);     // Catch: Throwable -> L14
        Object r10 = Result.constructor-impl(r2.getAbsolutePath());     // Catch: Throwable -> L14
    L16:
        Throwable r1 = Result.exceptionOrNull-impl(r10);
        if (r1 == null) goto L20;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#saveCameraBitmapToFile", "failed: " + r1.getMessage(), null);
    L20:
        if (Result.isFailure-impl(r10) == true) goto L24;
        r3 = r10;
    L24:
        return (String) r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public e(Fragment r2, MmAINoteFragment.b r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }

    public static int a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, null, null};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240019);
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
        f06.d r5 = r7.preInvoke(240019, "android/content/ContentResolver", "delete", r20, r2, "int", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return ((Integer) r5.b).intValue();
    L21:
        return r20.delete(r21, null, null);
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

    public static Uri b(ContentResolver r18, Uri r19, ContentValues r20) {
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
}
