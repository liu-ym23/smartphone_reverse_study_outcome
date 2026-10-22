package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ApiCompatibilityUtils$ApisP {
    private ApiCompatibilityUtils$ApisP() {
    }

    public static String getProcessName() {
        return Application.getProcessName();
    }

    public static Bitmap getBitmapByUri(ContentResolver r0, Uri r1) throws IOException {
        return ImageDecoder.decodeBitmap(ImageDecoder.createSource(r0, r1));
    }
}
