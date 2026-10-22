package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class CursorWindowCompat {

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String r10) {
            return new CursorWindow(r10);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String r10, long r11) {
            return new CursorWindow(r10, r11);
        }
    }

    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String r10, long r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 28) goto L7;
        return Api28Impl.createCursorWindow(r10, r11);
    L7:
        if (r12 < 15) goto L11;
        return Api15Impl.createCursorWindow(r10);
    L11:
        return new CursorWindow(false);
    }
}
