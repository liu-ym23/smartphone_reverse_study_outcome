package u5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.k;
import q5.d;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {
    @NonNull
    public static Rect a(@NonNull Context r10, @AttrRes int r11, int r12) {
        TypedArray r13 = k.h(r10, null, l.MaterialAlertDialog, r11, r12, new int[0]);
        int r14 = r13.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetStart, r10.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_start));
        int r15 = r13.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetTop, r10.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_top));
        int r16 = r13.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetEnd, r10.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_end));
        int r17 = r13.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetBottom, r10.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_bottom));
        r13.recycle();
        if (Build.VERSION.SDK_INT < 17) goto L8;
        if (r10.getResources().getConfiguration().getLayoutDirection() != 1) goto L8;
        r16 = r14;
        r14 = r16;
    L8:
        return new Rect(r14, r15, r16, r17);
    }

    @NonNull
    public static InsetDrawable b(@Nullable Drawable r10, @NonNull Rect r11) {
        return new InsetDrawable(r10, r11.left, r11.top, r11.right, r11.bottom);
    }
}
