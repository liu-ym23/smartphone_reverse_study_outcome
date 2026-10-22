package f2;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static AtomicBoolean a;
    public static boolean b;
    public static final HashMap<String, String> c = null;
    public static Context d;

    static {
        a = new AtomicBoolean(false);
        c = new HashMap();
    }

    public static Context a() {
        Context r0 = d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    }

    public static Activity b() {
        Activity r0 = z4.a.a.a();
        if (r0 != null) goto L9;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r1 = AppletRuntimeManager.d;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.currentActivity();
    L9:
        return r0;
    }
}
