package com.larus.camera.impl.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y {
    public static final Object b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "imageOutputPath");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (z2.a.d2() == false) goto L7;
        ExifInterface r1 = new ExifInterface(r4);     // Catch: Throwable -> L9
        Date r5 = new Date(System.currentTimeMillis());     // Catch: Throwable -> L9
        SimpleDateFormat r2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);     // Catch: Throwable -> L9
        r2.setTimeZone(TimeZone.getDefault());     // Catch: Throwable -> L9
        String r6 = r2.format(r5);     // Catch: Throwable -> L9
        r1.setAttribute("DateTime", r6);     // Catch: Throwable -> L9
        r1.setAttribute("DateTimeOriginal", r6);     // Catch: Throwable -> L9
        r1.setAttribute("DateTimeDigitized", r6);     // Catch: Throwable -> L9
        r1.setAttribute("Model", Build.MODEL);     // Catch: Throwable -> L9
        r1.setAttribute("Make", Build.MANUFACTURER);     // Catch: Throwable -> L9
        r1.saveAttributes();     // Catch: Throwable -> L9
        FLogger.a.i("manualSetExifAttributes", "success");     // Catch: Throwable -> L9
    L7:
        return Result.constructor-impl(Unit.INSTANCE);
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final void a(ExifInterface r24, String r25) {
        Intrinsics.checkNotNullParameter(r25, "imageOutputPath");
        List r1 = CollectionsKt.mutableListOf(new String[]{"FNumber", "ShutterSpeedValue", "ISOSpeedRatings", "DateTime", "DateTimeOriginal", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance", "ColorSpace", "BrightnessValue", "Contrast", "ISOSpeed", "ImageWidth", "ImageLength"});
        ISettingRepoService r2 = (ISettingRepoService) ServiceManager.get().getService(ISettingRepoService.class);
        int r3 = 0;
        if (r2 == null) goto L7;
        boolean r4 = true;
        if (r2.H() != true) goto L7;
    L9:
        if (r4 == false) goto L22;
        FLogger.a.i("ImageHelper", "copyExif with location");
        r1.addAll(CollectionsKt.listOf(new String[]{"GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp"}));
    L22:
        ExifInterface r5 = new ExifInterface(r25);     // Catch: IOException -> L19
        Iterator r0 = r1.iterator();     // Catch: IOException -> L19
    L13:
        if (r0.hasNext() == false) goto L17;
        String r6 = (String) r0.next();     // Catch: IOException -> L19
        String r7 = r24.getAttribute(r6);     // Catch: IOException -> L19
        if (TextUtils.isEmpty(r7) == true) goto L13;
        r5.setAttribute(r6, r7);     // Catch: IOException -> L19
        r3 = r3 + 1;     // Catch: IOException -> L19
        goto L13
    L17:
        r5.resetOrientation();     // Catch: IOException -> L19
        r5.saveAttributes();     // Catch: IOException -> L19
        FLogger.a.i("ImageHelper", "copyExif success, setAttribute count: " + r3);     // Catch: IOException -> L19
        return;
    L19:
        e = move-exception;
        FLogger.a.e("ImageHelper", "copyExif failed, " + e.getMessage());
        return;
    L7:
        r4 = false;
        goto L9
    }
}
