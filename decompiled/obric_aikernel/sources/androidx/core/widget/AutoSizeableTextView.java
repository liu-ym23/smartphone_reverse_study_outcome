package androidx.core.widget;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface AutoSizeableTextView {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE = false;

    static {
        if (Build.VERSION.SDK_INT < 27) goto L5;
        boolean r10 = true;
    L6:
        PLATFORM_SUPPORTS_AUTOSIZE = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13);

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r10, int r11);

    void setAutoSizeTextTypeWithDefaults(int r10);
}
