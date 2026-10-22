package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HarmonizedColors {
    private static final String TAG = "HarmonizedColors";

    private HarmonizedColors() {
    }

    @RequiresApi(api = 30)
    private static void addHarmonizedColorAttributesToReplacementMap(@NonNull Map<Integer, Integer> r5, @NonNull TypedArray r10, @Nullable TypedArray r11, @ColorInt int r12) {
        if (r11 != null) goto L5;
        r11 = r10;
    L5:
        int r13 = 0;
    L7:
        if (r13 >= r10.getIndexCount()) goto L16;
        int r14 = r11.getResourceId(r13, 0);
        if (r14 == 0) goto L15;
        if (r10.hasValue(r13) == false) goto L15;
        if (ResourcesLoaderUtils.isColorResource(r10.getType(r13)) == false) goto L15;
        r5.put(Integer.valueOf(r14), Integer.valueOf(MaterialColors.harmonize(r10.getColor(r13, 0), r12)));
    L15:
        r13 = r13 + 1;
        goto L7
    }

    @NonNull
    public static void applyToContextIfAvailable(@NonNull Context r5, @NonNull HarmonizedColorsOptions r10) {
        if (isHarmonizedColorAvailable() == true) goto L5;
        return;
    L5:
        Map<Integer, Integer> r11 = createHarmonizedColorReplacementMap(r5, r10);
        int r12 = r10.getThemeOverlayResourceId(0);
        if (ResourcesLoaderUtils.addResourcesLoaderToContext(r5, r11) == false) goto L10;
        if (r12 == 0) goto L11;
        ThemeUtils.applyThemeOverlay(r5, r12);
        return;
    L11:
        return;
    }

    @RequiresApi(api = 30)
    private static Map<Integer, Integer> createHarmonizedColorReplacementMap(Context r10, HarmonizedColorsOptions r11) {
        HashMap r5 = new HashMap();
        int r12 = MaterialColors.getColor(r10, r11.getColorAttributeToHarmonizeWith(), TAG);
        int[] r13 = r11.getColorResourceIds();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        int r16 = r13[r15];
        int r17 = MaterialColors.harmonize(ContextCompat.getColor(r10, r16), r12);
        r5.put(Integer.valueOf(r16), Integer.valueOf(r17));
        r15 = r15 + 1;
        goto L3
    L5:
        HarmonizedColorAttributes r18 = r11.getColorAttributes();
        if (r18 == null) goto L16;
        int[] r19 = r18.getAttributes();
        if (r19.length <= 0) goto L16;
        int r20 = r18.getThemeOverlay();
        TypedArray r21 = r10.obtainStyledAttributes(r19);
        if (r20 == 0) goto L12;
        TypedArray r22 = new ContextThemeWrapper(r10, r20).obtainStyledAttributes(r19);
    L13:
        addHarmonizedColorAttributesToReplacementMap(r5, r21, r22, r12);
        r21.recycle();
        if (r22 == null) goto L16;
        r22.recycle();
        goto L16
    L12:
        r22 = null;
    L16:
        return r5;
    }

    @ChecksSdkIntAtLeast(api = 30)
    public static boolean isHarmonizedColorAvailable() {
        return true;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context r5, @NonNull HarmonizedColorsOptions r10) {
        if (isHarmonizedColorAvailable() == true) goto L5;
        return r5;
    L5:
        Map<Integer, Integer> r11 = createHarmonizedColorReplacementMap(r5, r10);
        ContextThemeWrapper r12 = new ContextThemeWrapper(r5, r10.getThemeOverlayResourceId(R.style.ThemeOverlay_Material3_HarmonizedColors_Empty));
        r12.applyOverrideConfiguration(new Configuration());
        if (ResourcesLoaderUtils.addResourcesLoaderToContext(r12, r11) == true) goto L8;
        return r5;
    L8:
        return r12;
    }
}
