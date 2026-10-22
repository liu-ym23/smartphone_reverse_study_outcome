package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class UserManagerCompat {

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isUserUnlocked(Context r2) {
            return ((UserManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(UserManager.class), UserManager.class, "com.obric.memorydata.plugin")).isUserUnlocked();
        }
    }

    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return true;
    L5:
        return Api24Impl.isUserUnlocked(r3);
    }
}
