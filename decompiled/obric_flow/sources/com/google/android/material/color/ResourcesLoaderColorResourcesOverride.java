package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 30)
class ResourcesLoaderColorResourcesOverride implements ColorResourcesOverride {

    /* JADX INFO: renamed from: com.google.android.material.color.ResourcesLoaderColorResourcesOverride$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ResourcesLoaderColorResourcesOverrideSingleton {
        private static final ResourcesLoaderColorResourcesOverride INSTANCE = null;

        static {
            INSTANCE = new ResourcesLoaderColorResourcesOverride(null);
        }

        private ResourcesLoaderColorResourcesOverrideSingleton() {
        }

        public static /* synthetic */ ResourcesLoaderColorResourcesOverride access$000() {
            return INSTANCE;
        }
    }

    public /* synthetic */ ResourcesLoaderColorResourcesOverride(AnonymousClass1 r5) {
        this();
    }

    public static ColorResourcesOverride getInstance() {
        return ResourcesLoaderColorResourcesOverrideSingleton.access$000();
    }

    @Override // com.google.android.material.color.ColorResourcesOverride
    public boolean applyIfPossible(Context r5, Map<Integer, Integer> r10) {
        if (ResourcesLoaderUtils.addResourcesLoaderToContext(r5, r10) == false) goto L6;
        ThemeUtils.applyThemeOverlay(r5, R.style.ThemeOverlay_Material3_PersonalizedColors);
        return true;
    L6:
        return false;
    }

    @Override // com.google.android.material.color.ColorResourcesOverride
    @NonNull
    public Context wrapContextIfPossible(Context r5, Map<Integer, Integer> r10) {
        ContextThemeWrapper r11 = new ContextThemeWrapper(r5, R.style.ThemeOverlay_Material3_PersonalizedColors);
        r11.applyOverrideConfiguration(new Configuration());
        if (ResourcesLoaderUtils.addResourcesLoaderToContext(r11, r10) == true) goto L5;
        return r5;
    L5:
        return r11;
    }

    private ResourcesLoaderColorResourcesOverride() {
    }
}
