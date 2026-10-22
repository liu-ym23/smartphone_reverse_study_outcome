package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class UserManagerCompat {

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static boolean isUserUnlocked(Context r10) {
            return ((UserManager) r10.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(@NonNull Context r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return true;
    L5:
        return Api24Impl.isUserUnlocked(r10);
    }
}
