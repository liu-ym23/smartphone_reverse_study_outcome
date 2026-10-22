package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class DialogCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T requireViewById(Dialog r10, int r11) {
            return (T) r10.requireViewById(r11);
        }
    }

    private DialogCompat() {
    }

    @NonNull
    public static View requireViewById(@NonNull Dialog r10, int r11) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        View r12 = r10.findViewById(r11);
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    L5:
        return (View) Api28Impl.requireViewById(r10, r11);
    }
}
