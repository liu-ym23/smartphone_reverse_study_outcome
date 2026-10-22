package com.larus.avlink.gallery.processor;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v98.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ImagePackProcessor implements i {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public a() {
        }

        public static File b(PolarisFileWrapper r7) {
            ArrayList r0 = new ArrayList();
            Object r1 = null;
            Iterator r8 = FilesKt.walk$default(r7, null, 1, null).iterator();
        L4:
            if (r8.hasNext() == false) goto L13;
            File r3 = (File) r8.next();
            if (r3.isFile() == false) goto L4;
            if (StringsKt.endsWith(r3.getName(), ".jpg", true) == true) goto L11;
            if (StringsKt.endsWith(r3.getName(), ".jpeg", true) == false) goto L4;
        L11:
            r0.add(r3);
            goto L4
        L13:
            if (r0.isEmpty() == false) goto L15;
            return null;
        L15:
            Iterator r9 = r0.iterator();
        L17:
            if (r9.hasNext() == false) goto L21;
            Object r2 = r9.next();
            if (StringsKt.contains$default(((File) r2).getName(), "base_1", false, 2, null) == false) goto L17;
        L22:
            File r4 = (File) r2;
            if (r4 == null) goto L25;
            return r4;
        L25:
            Iterator r10 = r0.iterator();
        L27:
            if (r10.hasNext() == false) goto L31;
            Object r5 = r10.next();
            if (StringsKt.contains$default(((File) r5).getName(), "base_0", false, 2, null) == false) goto L27;
            r1 = r5;
        L31:
            File r6 = (File) r1;
            if (r6 == null) goto L35;
            return r6;
        L35:
            return (File) CollectionsKt.firstOrNull(r0);
        L21:
            r2 = null;
            goto L22
        }

        public static final k a(String r22, String r23, String r24, String r25, long r26, String r28) {
            int r0 = ImagePackProcessor.a;
            FLogger r1 = FLogger.a;
            r1.w("ImagePackProcessor", "Attempting fallback: extracting raw image without ISP processing (reason: " + r28 + ')');
            PolarisFileWrapper r13 = "Pack file not found: ";
            PolarisFileWrapper r2 = new PolarisFileWrapper(r22);     // Catch: Throwable -> L61 Exception -> L63
            if (r2.exists() == true) goto L6;
            r1.e("ImagePackProcessor", "Pack file not found: " + r22);     // Catch: Throwable -> L61 Exception -> L63
        L92:
        L74:
            boolean r3 = false;
        L75:
            if (r3 == false) goto L81;
            int r4 = j0.a;
            a.d(r23, r24, r25);
            PolarisFileWrapper r5 = new PolarisFileWrapper(r22);
            if (r5.exists() == false) goto L118;
            r.a.a(r22, r5.getName(), r5.length());
        L118:
            return new k(true, r23, null, System.currentTimeMillis() - r26, MapsKt.mapOf(TuplesKt.to("fallback_reason", r28)), true, 4);
        L81:
            return new k(false, null, r28 + ", fallback also failed", System.currentTimeMillis() - r26, null, false, 50);
        L45:
            e = e;
        L57:
            PolarisFileWrapper r6 = r13;
        L97:
            FLogger r7 = FLogger.a;     // Catch: Throwable -> L82
            r7.e("ImagePackProcessor", "Failed to extract raw image from pack (fallback): " + e.getMessage(), e);     // Catch: Throwable -> L82
            if (r6 == null) goto L74;
        L71:
            Exception e = e;
            FLogger r8 = FLogger.a;
            StringBuilder r9 = new StringBuilder("Failed to cleanup temp unpack directory: ");
        L73:
            r9.append(e.getMessage());
            r8.w("ImagePackProcessor", r9.toString());
            goto L74
        L68:
            if (r6.exists() == false) goto L74;
            FilesKt.deleteRecursively(r6);     // Catch: Exception -> L71
            r7.d("ImagePackProcessor", "Cleaned up temp unpack directory: " + r6.getAbsolutePath());     // Catch: Exception -> L71
        L82:
            th = th;
        L83:
            Throwable r10 = th;
            r13 = r6;
        L84:
            if (r13 == null) goto L119;
        L89:
            e = move-exception;
            FLogger.a.w("ImagePackProcessor", "Failed to cleanup temp unpack directory: " + e.getMessage());
            throw r10;
        L86:
            if (r13.exists() == false) goto L120;
            FilesKt.deleteRecursively(r13);     // Catch: Exception -> L89
            FLogger.a.d("ImagePackProcessor", "Cleaned up temp unpack directory: " + r13.getAbsolutePath());     // Catch: Exception -> L89
            throw r10;
        L120:
            throw r10;
        L119:
            throw r10;
        L6:
            r1.i("ImagePackProcessor", "Attempting to extract raw image from pack (fallback mode): " + r22);     // Catch: Throwable -> L61 Exception -> L63
            File r14 = r2.getParentFile();     // Catch: Throwable -> L61 Exception -> L63
            StringBuilder r11 = new StringBuilder("fallback_unpack_");     // Catch: Throwable -> L61 Exception -> L63
            r11.append(System.currentTimeMillis());     // Catch: Exception -> L58 Throwable -> L61
            r13 = new PolarisFileWrapper(r14, r11.toString());     // Catch: Exception -> L58 Throwable -> L61
            r13.mkdirs();     // Catch: Throwable -> L43 Exception -> L45
            PolarisFileInputStreamWrapper r12 = new PolarisFileInputStreamWrapper(r2);     // Catch: Throwable -> L43 Exception -> L45
            ja8.f.a(r12, r13.getAbsolutePath());     // Catch: Throwable -> L47
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L47
            CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L43 Exception -> L45
            r1.i("ImagePackProcessor", "Successfully unpacked to: " + r13.getAbsolutePath());     // Catch: Throwable -> L43 Exception -> L45
            File r16 = b(r13);     // Catch: Throwable -> L43 Exception -> L45
            if (r16 != null) goto L22;
            r1.e("ImagePackProcessor", "No .jpg/.jpeg file found in unpacked directory");     // Catch: Throwable -> L43 Exception -> L45
        L19:
            e = move-exception;
            FLogger.a.w("ImagePackProcessor", "Failed to cleanup temp unpack directory: " + e.getMessage());
            goto L92
        L16:
            if (r13.exists() == false) goto L92;
            FilesKt.deleteRecursively(r13);     // Catch: Exception -> L19
            r1.d("ImagePackProcessor", "Cleaned up temp unpack directory: " + r13.getAbsolutePath());     // Catch: Exception -> L19
            goto L92
        L22:
            r1.i("ImagePackProcessor", "Found raw image: " + r16.getName() + " (" + r16.length() + " bytes)");     // Catch: Throwable -> L43 Exception -> L45
            FilesKt.copyTo$default(r16, new PolarisFileWrapper(r23), true, 0, 4, null);     // Catch: Throwable -> L43 Exception -> L54
            PolarisFileWrapper r17 = new PolarisFileWrapper(r23);     // Catch: Throwable -> L43 Exception -> L54
            if (r17.exists() == true) goto L27;
        L36:
            r1.e("ImagePackProcessor", "Failed to copy extracted image to output path");     // Catch: Throwable -> L43 Exception -> L54
        L41:
            e = e;
            r8 = FLogger.a;
            r9 = new StringBuilder("Failed to cleanup temp unpack directory: ");
            goto L73
        L38:
            if (r13.exists() == false) goto L92;
            FilesKt.deleteRecursively(r13);     // Catch: Exception -> L41
            r1.d("ImagePackProcessor", "Cleaned up temp unpack directory: " + r13.getAbsolutePath());     // Catch: Exception -> L41
            goto L92
        L27:
            if (r17.length() <= 0) goto L36;
            r1.i("ImagePackProcessor", "Successfully extracted raw image (fallback): " + r23 + " (" + r17.length() + " bytes)");     // Catch: Throwable -> L43 Exception -> L54
        L33:
            e = move-exception;
            FLogger.a.w("ImagePackProcessor", "Failed to cleanup temp unpack directory: " + e.getMessage());
        L35:
            r3 = true;
            goto L75
        L30:
            if (r13.exists() == false) goto L35;
            FilesKt.deleteRecursively(r13);     // Catch: Exception -> L33
            r1.d("ImagePackProcessor", "Cleaned up temp unpack directory: " + r13.getAbsolutePath());     // Catch: Exception -> L33
        L47:
            th = move-exception;
            throw th;     // Catch: Throwable -> L50
        L50:
            th = move-exception;
            CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L43 Exception -> L54
            throw th;     // Catch: Throwable -> L43 Exception -> L54
        L43:
            th = move-exception;
            r10 = th;
        L54:
            e = e;
        L58:
            e = e;
        L60:
            r6 = null;
        L63:
            e = e;
        L61:
            th = th;
            r6 = null;
            goto L83
        }
    }

    static {
        new a();
    }

    public ImagePackProcessor() {
    }

    public static List e(String r12) {
        byte[] r1 = FilesKt.readBytes(new PolarisFileWrapper(r12));     // Catch: Exception -> L38
        if (r1.length >= 4) goto L8;
        return CollectionsKt.emptyList();
    L8:
        if (r1[0] != (-1)) goto L37;
        if (r1[1] != (-40)) goto L37;
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L38
        int r6 = 2;
    L14:
        if ((r6 + 4) > r1.length) goto L34;
        byte r7 = r1[r6];     // Catch: Exception -> L38
        if (r7 != (-1)) goto L34;
        int r8 = ((r7 & 255) << 8) | (r1[r6 + 1] & 255);     // Catch: Exception -> L38
        int r9 = r6 + 2;     // Catch: Exception -> L38
        if (r8 == 65498) goto L34;
        int r10 = r9 + 2;     // Catch: Exception -> L38
        if (r10 > r1.length) goto L34;
        int r11 = (r1[r9 + 1] & 255) | ((r1[r9] & 255) << 8);     // Catch: Exception -> L38
        if (r11 < 2) goto L34;
        int r13 = r11 - 2;     // Catch: Exception -> L38
        int r14 = r10 + r13;     // Catch: Exception -> L38
        if (r14 > r1.length) goto L34;
        int r15 = r10 - 4;     // Catch: Exception -> L38
        if (r8 != 65506) goto L33;
        int r16 = Math.min(14, r13);     // Catch: Exception -> L38
        if (r16 < 11) goto L33;
        byte[] r17 = ArraysKt.copyOfRange(r1, r10, r16 + r10);     // Catch: Exception -> L38
        if (Intrinsics.areEqual(new String(ArraysKt.copyOfRange(r17, 0, Math.min(11, r17.length)), Charsets.US_ASCII), "ICC_PROFILE") == false) goto L33;
        byte[] r18 = ArraysKt.copyOfRange(r1, r15, r14);     // Catch: Exception -> L38
        r3.add(r18);     // Catch: Exception -> L38
        FLogger.a.d("ImagePackProcessor", "Found ICC_PROFILE segment at position " + r15 + ", size: " + r18.length);     // Catch: Exception -> L38
    L33:
        r6 = r14;
    L34:
        FLogger.a.i("ImagePackProcessor", "Extracted " + r3.size() + " ICC profile segments from " + r12);     // Catch: Exception -> L38
        return r3;
    L37:
        return CollectionsKt.emptyList();
    L38:
        e = move-exception;
        FLogger.a.e("ImagePackProcessor", "Error extracting ICC segments: " + e.getMessage(), e);
        return CollectionsKt.emptyList();
    }

    public static void c(String r30, String r31) {
        ExifInterface r3 = new ExifInterface(r30);     // Catch: Exception -> L12 IOException -> L14
        ExifInterface r4 = new ExifInterface(r31);     // Catch: Exception -> L12 IOException -> L14
        String[] r5 = {"DateTime", "GPSLatitude", "GPSLongitude", "Make", "Model", "Orientation", "Flash", "ImageWidth", "ImageLength", "ExposureTime", "FNumber", "ISOSpeedRatings", "FocalLength", "GPSLatitudeRef", "GPSLongitudeRef", "GPSAltitude", "GPSAltitudeRef", "DateTimeOriginal", "DateTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "WhiteBalance", "SceneCaptureType", "FocalLengthIn35mmFilm"};     // Catch: Exception -> L12 IOException -> L14
        int r6 = 0;
    L5:
        if (r6 >= 25) goto L10;
        String r7 = r5[r6];     // Catch: Exception -> L12 IOException -> L14
        String r8 = r3.getAttribute(r7);     // Catch: Exception -> L12 IOException -> L14
        if (r8 == null) goto L9;
        r4.setAttribute(r7, r8);     // Catch: Exception -> L12 IOException -> L14
    L9:
        r6 = r6 + 1;     // Catch: Exception -> L12 IOException -> L14
        goto L5
    L10:
        r4.saveAttributes();     // Catch: Exception -> L12 IOException -> L14
        FLogger.a.d("ImagePackProcessor", "EXIF data copied successfully from " + r30 + " to " + r31);     // Catch: Exception -> L12 IOException -> L14
    L23:
        return;
    L14:
        e = move-exception;
        FLogger.a.e("ImagePackProcessor", "IOException while copying EXIF data: " + e.getMessage(), e);
        return;
    L12:
        e = move-exception;
        FLogger.a.e("ImagePackProcessor", "Exception while copying EXIF data: " + e.getMessage(), e);
    }

    public static String f(String r11, String r12) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r11);
        if (r0.exists() == true) goto L5;
    L56:
        FLogger.a.w("ImagePackProcessor", "Temp directory does not exist or is not a directory: " + r11);
        return null;
    L5:
        if (r0.isDirectory() == false) goto L56;
        File[] r13 = r0.listFiles();
        if (r13 == null) goto L55;
        ArrayList r1 = new ArrayList();
        int r2 = r13.length;
        int r5 = 0;
    L10:
        boolean r6 = true;
        if (r5 >= r2) goto L22;
        File r8 = r13[r5];
        if (r8.isDirectory() == true) goto L15;
    L17:
        r6 = false;
    L18:
        if (r6 == false) goto L20;
        r1.add(r8);
    L20:
        r5 = r5 + 1;
        goto L10
    L15:
        if (StringsKt.contains$default(r8.getName(), r12, false, 2, null) == false) goto L17;
    L22:
        if (r1.isEmpty() == false) goto L25;
        FLogger.a.w("ImagePackProcessor", "No subdirectory found matching mediaId: " + r12);
        return null;
    L25:
        File r14 = (File) CollectionsKt.first(r1);
        FLogger.a.d("ImagePackProcessor", "Found matching subdirectory: " + r14.getName());
        File[] r15 = r14.listFiles();
        if (r15 == null) goto L55;
        ArrayList r3 = new ArrayList();
        int r4 = r15.length;
        int r7 = 0;
    L28:
        if (r7 >= r4) goto L40;
        File r9 = r15[r7];
        if (r9.isFile() == true) goto L32;
    L36:
        boolean r10 = false;
    L37:
        if (r10 == false) goto L39;
        r3.add(r9);
    L39:
        r7 = r7 + 1;
        goto L28
    L32:
        if (StringsKt.endsWith$default(r9.getName(), ".jpg", false, 2, null) == false) goto L34;
    L35:
        r10 = true;
        goto L37
    L34:
        if (StringsKt.endsWith$default(r9.getName(), ".jpeg", false, 2, null) == false) goto L36;
    L40:
        Iterator r16 = r3.iterator();
    L42:
        if (r16.hasNext() == false) goto L47;
        File r17 = (File) r16.next();
        if (StringsKt.contains$default(r17.getName(), "base_1", false, 2, null) == false) goto L42;
        FLogger.a.i("ImagePackProcessor", "Found base_1 image: " + r17.getAbsolutePath());
        return r17.getAbsolutePath();
    L47:
        Iterator r18 = r3.iterator();
    L49:
        if (r18.hasNext() == false) goto L54;
        File r19 = (File) r18.next();
        if (StringsKt.contains$default(r19.getName(), "base_0", false, 2, null) == false) goto L49;
        FLogger.a.i("ImagePackProcessor", "Found base_0 image: " + r19.getAbsolutePath());
        return r19.getAbsolutePath();
    L54:
        FLogger.a.w("ImagePackProcessor", "No suitable image file found in subdirectory: " + r14.getName());
    L55:
        return null;
    }

    public static boolean g(List r13, String r14) {
        if (r13.isEmpty() == false) goto L56;
        return false;
    L56:
        byte[] r1 = FilesKt.readBytes(new PolarisFileWrapper(r14));     // Catch: Exception -> L53
        if (r1.length >= 2) goto L9;
        return false;
    L9:
        if (r1[0] == (-1)) goto L11;
    L52:
        return false;
    L11:
        if (r1[1] != (-40)) goto L52;
        int r6 = 2;
        int r7 = 2;
        boolean r8 = false;
    L14:
        int r9 = r6 + 4;     // Catch: Exception -> L53
        if (r9 > r1.length) goto L40;
        byte r10 = r1[r6];     // Catch: Exception -> L53
        if (r10 != (-1)) goto L40;
        int r11 = ((r10 & 255) << 8) | (r1[r6 + 1] & 255);     // Catch: Exception -> L53
        if (r11 == 65498) goto L40;
        if (r11 < 65504) goto L40;
        if (r11 > 65519) goto L40;
        if (r9 > r1.length) goto L40;
        int r12 = r6 + 2;     // Catch: Exception -> L53
        int r15 = ((r1[r6 + 3] & 255) | ((r1[r12] & 255) << 8)) - 2;     // Catch: Exception -> L53
        int r16 = (r12 + 2) + Math.max(0, r15);     // Catch: Exception -> L53
        if (r16 > r1.length) goto L40;
        if (r11 != 65506) goto L39;
        if (r8 == true) goto L39;
        if (Math.min(11, r15) < 11) goto L39;
        int r17 = r9 + 11;     // Catch: Exception -> L53
        if (r17 > r1.length) goto L39;
        if (Intrinsics.areEqual(new String(ArraysKt.copyOfRange(r1, r9, r17), Charsets.US_ASCII), "ICC_PROFILE") == false) goto L39;
        FLogger.a.d("ImagePackProcessor", "Destination already has ICC profile, skipping insertion");     // Catch: Exception -> L53
        r8 = true;
    L39:
        r6 = r16;
        r7 = r6;
    L40:
        if (r8 == false) goto L42;
        return true;
    L42:
        int r4 = r1.length;     // Catch: Exception -> L53
        Iterator r5 = r13.iterator();     // Catch: Exception -> L53
        int r18 = 0;
    L44:
        if (r5.hasNext() == false) goto L46;
        r18 = r18 + ((byte[]) r5.next()).length;     // Catch: Exception -> L53
        goto L44
    L46:
        byte[] r19 = new byte[r4 + r18];     // Catch: Exception -> L53
        System.arraycopy(r1, 0, r19, 0, r7);     // Catch: Exception -> L53
        int r20 = r7 + 0;     // Catch: Exception -> L53
        Iterator r21 = r13.iterator();     // Catch: Exception -> L53
    L48:
        if (r21.hasNext() == false) goto L50;
        byte[] r22 = (byte[]) r21.next();     // Catch: Exception -> L53
        System.arraycopy(r22, 0, r19, r20, r22.length);     // Catch: Exception -> L53
        r20 = r20 + r22.length;     // Catch: Exception -> L53
        goto L48
    L50:
        System.arraycopy(r1, r7, r19, r20, r1.length - r7);     // Catch: Exception -> L53
        FilesKt.writeBytes(new PolarisFileWrapper(r14), r19);     // Catch: Exception -> L53
        FLogger.a.i("ImagePackProcessor", "Successfully inserted " + r13.size() + " ICC segments into " + r14 + " at offset " + r7);     // Catch: Exception -> L53
        return true;
    L53:
        e = move-exception;
        FLogger.a.e("ImagePackProcessor", "Error inserting ICC segments: " + e.getMessage(), e);
        return false;
    }

    public static void d(String r9, String r10, String r11) {
        String r12 = f(r9, r11);     // Catch: Exception -> L14
        if (r12 == null) goto L12;
        c(r12, r10);     // Catch: Exception -> L14
        FLogger r7 = FLogger.a;     // Catch: Exception -> L14
        r7.i("ImagePackProcessor", "EXIF data copied from " + r12 + " to " + r10 + " for media: " + r11);     // Catch: Exception -> L14
        List r6 = e(r12);     // Catch: Exception -> L14
        if ((!r6.isEmpty()) == true) goto L8;
        r7.d("ImagePackProcessor", "No ICC profile found in source image for media: " + r11);     // Catch: Exception -> L14
    L17:
        return;
    L8:
        if (g(r6, r10) == false) goto L10;
        r7.i("ImagePackProcessor", "ICC profile copied from " + r12 + " to " + r10 + " for media: " + r11);     // Catch: Exception -> L14
        goto L17
    L10:
        r7.w("ImagePackProcessor", "Failed to insert ICC profile for media: " + r11);     // Catch: Exception -> L14
        goto L17
    L12:
        FLogger.a.w("ImagePackProcessor", "No original image found in temp directory for EXIF copying, media: " + r11);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        FLogger.a.e("ImagePackProcessor", "Error copying EXIF data for media: " + r11 + " - " + e.getMessage(), e);
    }

    @Override // com.larus.avlink.gallery.processor.i
    public final Object a(String r4, MediaMetadata r5, Continuation<? super k> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImagePackProcessor$processSync$2(r5, r4, this, null), r6);
    }

    public static final String b(ImagePackProcessor r8, byte[] r9, int[] r10, String r11, MediaMetadata r12, String r13) {
        r8.getClass();
        String r4 = r12.getFileName();     // Catch: Exception -> L23
        if (r4 == null) goto L7;
        String r5 = StringsKt.substringBefore$default(r4, "_", null, 2, null);     // Catch: Exception -> L23
        if (r5 == null) goto L7;
    L8:
        String r14 = r5 + '_' + r11 + "_0_" + r12.getDuration() + '_' + r12.getHeight() + '_' + r12.getWidth() + '_' + r12.getCreateTime() + ".jpeg";     // Catch: Exception -> L23
        PolarisFileWrapper r6 = new PolarisFileWrapper(com.larus.avlink.gallery.k.a(), r14);     // Catch: Exception -> L23
        if (r6.exists() == false) goto L11;
        FLogger.a.w("ImagePackProcessor", "Processed file already exists, deleting: " + r6.getAbsolutePath());     // Catch: Exception -> L23
        r6.delete();     // Catch: Exception -> L23
    L11:
        File r2 = r6.getParentFile();     // Catch: Exception -> L23
        if (r2 == null) goto L14;
        r2.mkdirs();     // Catch: Exception -> L23
    L14:
        String r15 = AlbumUtils.c(r9, r10, r6);     // Catch: Exception -> L23
        if (r15 != null) goto L17;
    L21:
        FLogger.a.w("ImagePackProcessor", "Failed to convert YUV to JPEG or file is empty for: " + r14);     // Catch: Exception -> L23
        return null;
    L17:
        if (new PolarisFileWrapper(r15).exists() == false) goto L21;
        if (new PolarisFileWrapper(r15).length() <= 0) goto L21;
        d(r13, r15, r11);     // Catch: Exception -> L23
        int r16 = j0.a;     // Catch: Exception -> L23
        a.d(r15, r14, r11);     // Catch: Exception -> L23
        FLogger.a.i("ImagePackProcessor", "Processed image saved: ".concat(r15));     // Catch: Exception -> L23
        return r15;
    L7:
        r5 = "media";
    L23:
        e = move-exception;
        FLogger.a.e("ImagePackProcessor", "Error saving processed image: " + e.getMessage(), e);
        return null;
    }
}
