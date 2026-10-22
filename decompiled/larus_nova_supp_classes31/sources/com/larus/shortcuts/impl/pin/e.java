package com.larus.shortcuts.impl.pin;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.text.TextUtils;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new d());
    }

    public static boolean a(String r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 25) goto L19;
        Iterator<T> r1 = ((ShortcutManager) AppHost.a.getApplication().getSystemService(ShortcutManager.class)).getPinnedShortcuts().iterator();
    L9:
        if (r1.hasNext() == false) goto L19;
        if (TextUtils.equals(((ShortcutInfo) r1.next()).getId(), r4) == false) goto L9;
        return true;
    L19:
        String r2 = a.a;     // Catch: Throwable -> L16
        if (a.f(AppHost.a.getApplication(), r4) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        th = move-exception;
        FLogger.a.e("PinShortcutUtil", "error " + th.getMessage());
        goto L18
    }
}
