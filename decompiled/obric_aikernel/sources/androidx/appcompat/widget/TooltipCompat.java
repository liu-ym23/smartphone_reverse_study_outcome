package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class TooltipCompat {

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void setTooltipText(View r10, CharSequence r11) {
            r10.setTooltipText(r11);
        }
    }

    private TooltipCompat() {
    }

    public static void setTooltipText(@NonNull View r10, @Nullable CharSequence r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setTooltipText(r10, r11);
        return;
    L5:
        TooltipCompatHandler.setTooltipText(r10, r11);
    }
}
