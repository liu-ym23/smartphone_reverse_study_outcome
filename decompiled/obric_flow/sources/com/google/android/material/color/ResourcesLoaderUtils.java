package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import androidx.annotation.RequiresApi;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 30)
final class ResourcesLoaderUtils {
    private ResourcesLoaderUtils() {
    }

    public static boolean addResourcesLoaderToContext(Context r5, Map<Integer, Integer> r10) {
        ResourcesLoader r11 = ColorResourcesLoaderCreator.create(r5, r10);
        if (r11 == null) goto L6;
        r5.getResources().addLoaders(new ResourcesLoader[]{r11});
        return true;
    L6:
        return false;
    }

    public static boolean isColorResource(int r5) {
        if (28 <= r5) goto L5;
    L7:
        return false;
    L5:
        if (r5 > 31) goto L7;
        return true;
    }
}
