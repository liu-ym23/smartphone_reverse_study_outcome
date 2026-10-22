package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeUtils {
    private ThemeUtils() {
    }

    public static void applyThemeOverlay(@NonNull Context r5, @StyleRes int r10) {
        r5.getTheme().applyStyle(r10, true);
        if ((r5 instanceof Activity) == false) goto L8;
        Resources.Theme r11 = getWindowDecorViewTheme((Activity) r5);
        if (r11 == null) goto L9;
        r11.applyStyle(r10, true);
        return;
    L9:
        return;
    }

    @Nullable
    private static Resources.Theme getWindowDecorViewTheme(@NonNull Activity r5) {
        Window r10 = r5.getWindow();
        if (r10 == null) goto L10;
        View r11 = r10.peekDecorView();
        if (r11 == null) goto L12;
        Context r12 = r11.getContext();
        if (r12 != null) goto L9;
        return null;
    L9:
        return r12.getTheme();
    L12:
        return null;
    L10:
        return null;
    }
}
