package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ManufacturerUtils {
    private static final String LGE = "lge";
    private static final String MEIZU = "meizu";
    private static final String SAMSUNG = "samsung";

    private ManufacturerUtils() {
    }

    @NonNull
    private static String getManufacturer() {
        String r5 = Build.MANUFACTURER;
        if (r5 != null) goto L5;
        return "";
    L5:
        return r5.toLowerCase(Locale.ENGLISH);
    }

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        if (isLGEDevice() == false) goto L5;
    L8:
        return true;
    L5:
        if (isSamsungDevice() == true) goto L8;
        return false;
    }

    public static boolean isLGEDevice() {
        return getManufacturer().equals(LGE);
    }

    public static boolean isMeizuDevice() {
        return getManufacturer().equals(MEIZU);
    }

    public static boolean isSamsungDevice() {
        return getManufacturer().equals(SAMSUNG);
    }
}
