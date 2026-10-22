package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f3520a = 1.0f;

    static {
    }

    public a() {
    }

    public float a(@NonNull ContentResolver r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 17) goto L7;
        return Settings.Global.getFloat(r10, "animator_duration_scale", 1.0f);
    L7:
        if (r11 != 16) goto L11;
        return Settings.System.getFloat(r10, "animator_duration_scale", 1.0f);
    L11:
        return f3520a;
    }
}
