package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources {
    private AppCompatResources() {
    }

    public static ColorStateList getColorStateList(@NonNull Context r5, @ColorRes int r10) {
        return ContextCompat.getColorStateList(r5, r10);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r5, @DrawableRes int r10) {
        return ResourceManagerInternal.get().getDrawable(r5, r10);
    }
}
