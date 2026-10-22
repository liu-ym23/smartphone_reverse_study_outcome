package com.ss.android.lark.image.impl.image_compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import f06.b;
import f06.d;
import g06.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class LubanCompresser {
    private ByteArrayOutputStream mByteArrayOutputStream;
    private final LubanBuilder mLuban;

    private String getCacheFilePath() {
        StringBuilder r0 = new StringBuilder("Luban_" + System.currentTimeMillis() + UUID.randomUUID().toString());
        Bitmap.CompressFormat r1 = this.mLuban.compressFormat;
        if (r1 != Bitmap.CompressFormat.WEBP) goto L6;
        r0.append(".webp");
    L10:
        return this.mLuban.cacheDir.getAbsolutePath() + File.separator + r0;
    L6:
        if (r1 != Bitmap.CompressFormat.PNG) goto L8;
        r0.append(".png");
        goto L10
    L8:
        r0.append(".jpg");
        goto L10
    }

    public LubanCompresser(LubanBuilder r1) {
        this.mLuban = r1;
    }

    public static /* synthetic */ LubanBuilder access$000(LubanCompresser r0) {
        return r0.mLuban;
    }

    private File customCompress(File r15) throws IOException {
        String r2 = getCacheFilePath();
        String r1 = r15.getAbsolutePath();
        int r5 = getImageSpinAngle(r1);
        int r0 = this.mLuban.maxSize;
        if (r0 > 0) goto L5;
    L7:
        long r6 = r15.length() / 1024;
    L8:
        int[] r3 = getImageSize(r1);
        int r4 = r3[0];
        int r9 = r3[1];
        int r10 = this.mLuban.maxSize;
        if (r10 > 0) goto L11;
    L13:
        int r11 = this.mLuban.maxWidth;
        if (r11 <= 0) goto L16;
        r4 = Math.min(r4, r11);
    L16:
        int r12 = this.mLuban.maxHeight;
        if (r12 <= 0) goto L19;
        r9 = Math.min(r9, r12);
    L19:
        float r7 = Math.min(r4 / r3[0], r9 / r3[1]);
        int r8 = (int) (r3[0] * r7);
        int r13 = (int) (r3[1] * r7);
        if (this.mLuban.maxSize <= (r15.length() / 1024.0f)) goto L25;
        if (r7 != 1.0f) goto L25;
        return r15;
    L25:
        return compress(r1, r2, r8, r13, r5, r6);
    L11:
        if (r10 >= (r15.length() / 1024.0f)) goto L13;
        float r14 = (float) Math.sqrt((r15.length() / 1024.0f) / this.mLuban.maxSize);
        r4 = (int) (r4 / r14);
        r9 = (int) (r9 / r14);
        goto L13
    L5:
        if (r0 >= (r15.length() / 1024)) goto L7;
        r6 = this.mLuban.maxSize;
        goto L8
    }

    private File firstCompress(File r23) throws IOException {
        String r2 = getCacheFilePath();
        String r1 = r23.getAbsolutePath();
        long r3 = r23.length() / 5;
        int r5 = getImageSpinAngle(r1);
        int[] r0 = getImageSize(r1);
        int r7 = r0[0];
        int r4 = r0[1];
        int r15 = 1280;
        if (r7 > r4) goto L22;
        double r13 = ((double) r7) / ((double) r4);
        if (r13 > 1.0d) goto L14;
        if (r13 <= 0.5625d) goto L14;
        if (r7 > 1280) goto L12;
        r15 = r7;
    L12:
        r3 = 60;
        int r18 = (r4 * r15) / r7;
        int r6 = r15;
    L21:
        long r20 = r3;
        int r8 = r6;
        long r9 = r20;
        int r10 = r18;
    L39:
        return compress(r1, r2, r8, r10, r5, r9);
    L14:
        if (r13 <= 0.5625d) goto L16;
        r3 = 0;
        r6 = 0;
        r18 = 0;
        goto L21
    L16:
        if (r4 <= 720) goto L18;
        r18 = 720;
    L19:
        r6 = (r18 * r7) / r4;
        goto L21
    L18:
        r18 = r4;
        goto L19
    L22:
        double r14 = ((double) r4) / ((double) r7);
        if (r14 > 1.0d) goto L31;
        if (r14 <= 0.5625d) goto L31;
        if (r4 > 1280) goto L29;
        r15 = r4;
    L29:
        r8 = (r15 * r7) / r4;
        r9 = 60;
        r10 = r15;
    L31:
        if (r14 <= 0.5625d) goto L33;
        r9 = 0;
        r8 = 0;
        r10 = 0;
        goto L39
    L33:
        if (r7 <= 720) goto L35;
        int r16 = 720;
    L36:
        r9 = r3;
        r8 = r16;
        r10 = (r4 * r16) / r7;
        goto L39
    L35:
        r16 = r7;
        goto L36
    }

    public static int[] getImageSize(String r4) {
        BitmapFactory.Options r1 = new BitmapFactory.Options();
        r1.inJustDecodeBounds = true;
        r1.inSampleSize = 1;
        BitmapFactory.decodeFile(r4, r1);
        return new int[]{r1.outWidth, r1.outHeight};
    }

    private int getImageSpinAngle(String r4) {
        int r5 = com_ss_android_lark_image_impl_image_compress_LubanCompresser_android_media_ExifInterface_getAttributeInt(new ExifInterface(r4), "Orientation", 1);
        if (r5 != 3) goto L7;
        return 180;
    L7:
        if (r5 != 6) goto L9;
        return 90;
    L9:
        if (r5 != 8) goto L20;
        return 270;
    L20:
        return 0;
    L21:
        return 0;
    }

    private File thirdCompress(File r25) throws IOException {
        String r2 = getCacheFilePath();
        String r1 = r25.getAbsolutePath();
        int r5 = getImageSpinAngle(r1);
        boolean r3 = false;
        int r0 = getImageSize(r1)[0];
        int r6 = 1;
        int r4 = getImageSize(r1)[1];
        if (r0 <= r4) goto L6;
        r3 = true;
    L6:
        if ((r0 % 2) != 1) goto L9;
        r0 = r0 + 1;
    L9:
        if ((r4 % 2) != 1) goto L11;
        r4 = r4 + 1;
    L11:
        if (r0 <= r4) goto L13;
        int r7 = r4;
    L14:
        if (r0 <= r4) goto L16;
        int r9 = r0;
    L17:
        double r12 = r9;
        double r10 = ((double) r7) / r12;
        double r20 = 100.0d;
        if (r10 > 1.0d) goto L51;
        if (r10 <= 0.5625d) goto L51;
        double r11 = 60.0d;
        if (r9 >= 1664) goto L31;
        if ((r25.length() / 1024) >= 150) goto L26;
        return r25;
    L26:
        double r8 = (((double) (r7 * r9)) / Math.pow(1664.0d, 2.0d)) * 150.0d;
        if (r8 < 60.0d) goto L73;
    L29:
        r11 = r8;
    L73:
        if (r3 == false) goto L75;
        int r13 = r4;
    L76:
        if (r3 == false) goto L79;
        r4 = r0;
    L79:
        return compress(r1, r2, r13, r4, r5, (long) r11);
    L75:
        r13 = r0;
        goto L76
    L31:
        if (r9 < 1664) goto L37;
        if (r9 >= 4990) goto L37;
        r0 = r7 / 2;
        r4 = r9 / 2;
        r8 = (((double) (r0 * r4)) / Math.pow(2495.0d, 2.0d)) * 300.0d;
        if (r8 >= 60.0d) goto L29;
    L37:
        if (r9 >= 4990) goto L39;
    L43:
        int r14 = r9 / 1280;
        if (r14 == 0) goto L47;
        r6 = r14;
    L47:
        r0 = r7 / r6;
        r4 = r9 / r6;
        double r15 = (((double) (r0 * r4)) / Math.pow(2560.0d, 2.0d)) * 300.0d;
        if (r15 < 100.0d) goto L67;
    L66:
        r20 = r15;
    L67:
        r11 = r20;
        goto L73
    L39:
        if (r9 >= 10240) goto L43;
        r0 = r7 / 4;
        r4 = r9 / 4;
        r15 = (((double) (r0 * r4)) / Math.pow(2560.0d, 2.0d)) * 300.0d;
        if (r15 >= 100.0d) goto L66;
    L51:
        if (r10 <= 0.5625d) goto L53;
    L68:
        double r16 = 1280.0d / r10;
        int r17 = (int) Math.ceil(r12 / r16);
        int r18 = r7 / r17;
        int r19 = r9 / r17;
        double r21 = (((double) (r18 * r19)) / (r16 * 1280.0d)) * 500.0d;
        if (r21 < 100.0d) goto L72;
        r20 = r21;
    L72:
        r11 = r20;
        r4 = r19;
        r0 = r18;
        goto L73
    L53:
        if (r10 <= 0.5d) goto L68;
        if (r9 < 1280) goto L57;
    L59:
        int r22 = r9 / 1280;
        if (r22 == 0) goto L63;
        r6 = r22;
    L63:
        r0 = r7 / r6;
        r4 = r9 / r6;
        r15 = (((double) (r0 * r4)) / 3686400.0d) * 400.0d;
        if (r15 >= 100.0d) goto L66;
    L57:
        if ((r25.length() / 1024) >= 200) goto L59;
        return r25;
    L16:
        r9 = r4;
        goto L17
    L13:
        r7 = r0;
        goto L14
    }

    public Observable<File> singleAction(final File r2) {
        return Observable.fromCallable(new AnonymousClass1(this, r2)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }

    private File compressImage(int r2, File r3) throws IOException {
        if (r2 == 1) goto L14;
        if (r2 == 3) goto L12;
        if (r2 == 4) goto L10;
        return r3;
    L10:
        return customCompress(r3);
    L12:
        return thirdCompress(r3);
    L14:
        return firstCompress(r3);
    }

    private static Bitmap rotatingImage(int r7, Bitmap r8) {
        Matrix r5 = new Matrix();
        r5.postRotate(r7);
        return Bitmap.createBitmap(r8, 0, 0, r8.getWidth(), r8.getHeight(), r5, true);
    }

    public static /* synthetic */ File access$100(LubanCompresser r0, int r1, File r2) throws IOException {
        return r0.compressImage(r1, r2);
    }

    private static int com_ss_android_lark_image_impl_image_compress_LubanCompresser_android_media_ExifInterface_getAttributeInt(ExifInterface r18, String r19, int r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, Integer.valueOf(r20)};
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(100022);
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
        d r4 = r7.preInvoke(100022, "android/media/ExifInterface", "getAttributeInt", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.getAttributeInt(r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private Bitmap compress(String r6, int r7, int r8) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        int r1 = 1;
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r6, r0);
        int r2 = r0.outHeight;
        int r3 = r0.outWidth;
    L4:
        if ((r2 / r1) > r8) goto L10;
        if ((r3 / r1) > r7) goto L10;
        r0.inSampleSize = r1;
        r0.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(r6, r0);
    L10:
        r1 = r1 * 2;
        goto L4
    }

    private File saveImage(String r5, Bitmap r6, long r7) throws IOException {
        Preconditions.checkNotNull(r6, "Luban Compressbitmap cannot be null");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r5.substring(0, r5.lastIndexOf("/")));
        if (r0.exists() == false) goto L5;
    L8:
        ByteArrayOutputStream r1 = this.mByteArrayOutputStream;
        if (r1 != null) goto L11;
        this.mByteArrayOutputStream = new ByteArrayOutputStream(r6.getWidth() * r6.getHeight());
    L12:
        int r2 = 100;
        r6.compress(this.mLuban.compressFormat, 100, this.mByteArrayOutputStream);
    L14:
        if ((this.mByteArrayOutputStream.size() / 1024) <= r7) goto L18;
        if (r2 <= 6) goto L18;
        this.mByteArrayOutputStream.reset();
        r2 = r2 - 6;
        r6.compress(this.mLuban.compressFormat, r2, this.mByteArrayOutputStream);
    L18:
        r6.recycle();
        PolarisFileOutputStreamWrapper r8 = new PolarisFileOutputStreamWrapper(r5);
        this.mByteArrayOutputStream.writeTo(r8);
        r8.close();
        return new PolarisFileWrapper(r5);
    L11:
        r1.reset();
        goto L12
    L5:
        if (r0.mkdirs() == true) goto L8;
        return null;
    }

    private File compress(String r1, String r2, int r3, int r4, int r5, long r6) throws IOException {
        Bitmap r7 = compress(r1, r3, r4);
        if (r7 == null) goto L6;
        r7 = rotatingImage(r5, r7);
    L6:
        return saveImage(r2, r7, r6);
    }
}
