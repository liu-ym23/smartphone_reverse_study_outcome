package vl0;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements a {
    public static final a a = null;
    public static final c b = null;

    public c() {
    }

    static {
        b = new c();
        Object r0 = a().newInstance();     // Catch: Throwable -> L8
        if ((r0 instanceof a) == true) goto L6;
        r0 = null;
    L6:
        a = (a) r0;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        ALogger.e("SaaSInstanceUtil", th);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.android.live.utils.SaaSInstanceCallStub");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.utils.SaaSInstanceCallStub");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.utils.SaaSInstanceCallStub");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.android.live.utils.SaaSInstanceCallStub");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.utils.SaaSInstanceCallStub");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.utils.SaaSInstanceCallStub");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.utils.SaaSInstanceCallStub");
    }

    @Override // vl0.a
    public final Fragment createLiveLynxFragment(Bundle r2, d0 r3, b r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceHolder");
        a r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.createLiveLynxFragment(r2, r3, r4);
    }
}
