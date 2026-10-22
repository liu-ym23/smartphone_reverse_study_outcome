package androidx.appcompat.widget;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class TooltipCompat {

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static void setTooltipText(View r5, CharSequence r10) {
            r5.setTooltipText(r10);
        }
    }

    private TooltipCompat() {
    }

    public static void setTooltipText(@NonNull View r5, @Nullable CharSequence r10) {
        Api26Impl.setTooltipText(r5, r10);
    }
}
