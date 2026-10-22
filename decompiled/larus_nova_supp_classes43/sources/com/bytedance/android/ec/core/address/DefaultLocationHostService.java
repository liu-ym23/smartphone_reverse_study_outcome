package com.bytedance.android.ec.core.address;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.client.BDLocationClient;
import com.bytedance.bdlocation.client.BDLocationClientOption;
import com.bytedance.bdlocation.init.BDLocationAgent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DefaultLocationHostService implements wi.c {
    public static Object a;
    public static final Map<String, Method> b = null;
    public static final String[] c = null;
    public static final Lazy d = null;
    public static final DefaultLocationHostService e = null;

    public DefaultLocationHostService() {
    }

    public final void b(Context r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "cb");
    }

    public final void c(Context r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "cb");
    }

    public final void f() {
    }

    public final boolean onActivityResult() {
        return true;
    }

    static {
        e = new DefaultLocationHostService();
        b = new LinkedHashMap();
        c = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        d = LazyKt.lazy(DefaultLocationHostService$hostAppInfo$2.INSTANCE);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(i());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        a = r1;
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class i() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.bytedance.bdlocation.init.BDLocationAgent");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bdlocation.init.BDLocationAgent");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bdlocation.init.BDLocationAgent");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.bytedance.bdlocation.init.BDLocationAgent");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bdlocation.init.BDLocationAgent");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bdlocation.init.BDLocationAgent");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bdlocation.init.BDLocationAgent");
    }

    public static BDLocation j() {
        f06.c r10 = new f06.c();
        Object[] r11 = {null};
        f06.b r12 = new f06.b();
        f06.d r13 = r10.b(101327, "com/bytedance/bdlocation/init/BDLocationAgent", "getLastKnownLocation", BDLocationAgent.class, r11, "com.bytedance.bdlocation.BDLocation", r12);
        if (r13.a == false) goto L6;
        r10.a(101327, "com/bytedance/bdlocation/init/BDLocationAgent", "getLastKnownLocation", BDLocationAgent.class, r11, null, r12, false);
        return (BDLocation) r13.b;
    L6:
        BDLocation r14 = BDLocationAgent.getLastKnownLocation(null);
        r10.a(101327, "com/bytedance/bdlocation/init/BDLocationAgent", "getLastKnownLocation", BDLocationAgent.class, r11, r14, r12, true);
        return r14;
    }

    public final boolean a() {
        Context r0 = ((vi.a) d.getValue()).getApplicationContext();
        if (r0 == null) goto L52;
        String[] r10 = c;
        int r11 = r10.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (ContextCompat.checkSelfPermission(r0, r10[r12]) == (-1)) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        boolean r13 = false;
    L12:
        if (r13 == true) goto L14;
        return false;
    L14:
        if (Build.VERSION.SDK_INT < 28) goto L48;
        Object r14 = null;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L21
        Object r1 = r0.getSystemService(com.bytedance.android.ec.core.event.a.KEY_LOCATION);     // Catch: Throwable -> L21
        if ((r1 instanceof LocationManager) == true) goto L19;
        r1 = null;
    L19:
        Object r16 = Result.constructor-impl((LocationManager) r1);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r16) == true) goto L27;
        r14 = r16;
    L27:
        LocationManager r17 = (LocationManager) r14;
        if (r17 != null) goto L30;
    L42:
        boolean r18 = false;
    L43:
        if (r18 == false) goto L54;
        return true;
    L54:
        return false;
    L30:
        if (r17.isLocationEnabled() != true) goto L42;
    L41:
        r18 = true;
    L21:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L48:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L34
        Object r21 = Result.constructor-impl(Integer.valueOf(Settings.Secure.getInt(r0.getContentResolver(), "location_mode")));     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r21) == false) goto L40;
        r21 = 0;
    L40:
        if (((Number) r21).intValue() == 0) goto L42;
    L34:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L11:
        r13 = true;
        goto L12
    L52:
        return false;
    }

    public final void release() {
        ((LinkedHashMap) b).clear();
    }

    public final void e(q r10) {
        Intrinsics.checkNotNullParameter("bpea-ecom_address_sdk_listen_submit", "tokenCert");
        Intrinsics.checkNotNullParameter("nclf", "auth");
        Intrinsics.checkNotNullParameter(r10, "listener");
        BDLocationAgent.addSubmitNotification(null, new d0(r10));
    }

    public final void g(r r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        BDLocationAgent.addLightLocationSubmitNotification(c0.a);
    }

    public final wi.a h(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tokenCert");
        Intrinsics.checkNotNullParameter(r11, "auth");
        Object r12 = null;
        if (a() == false) goto L21;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L11
        BDLocation r14 = j();     // Catch: Throwable -> L11
        if (r14 == null) goto L8;
        wi.a r0 = new wi.a(r14.getLatitude(), r14.getLongitude());     // Catch: Throwable -> L11
    L9:
        Object r15 = Result.constructor-impl(r0);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r15) == true) goto L18;
        r12 = r15;
    L18:
        return (wi.a) r12;
    L8:
        r0 = null;
    L11:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L21:
        return null;
    }

    public final void d(String r10, String r11, m r12) {
        Intrinsics.checkNotNullParameter(r10, "tokenCert");
        Intrinsics.checkNotNullParameter(r11, "auth");
        Intrinsics.checkNotNullParameter(r12, "callback");
        BDLocationClient r13 = new BDLocationClient(((vi.a) d.getValue()).getApplicationContext());
        BDLocationClientOption r14 = new BDLocationClientOption();
        r14.setCert(true).setBpeaCert(null).setUploadSource("").setLocationTimeOut(30000).setMaxCacheTime(600000).setAccuracyLevel(4).setTriggerType(1).setLocationMode(2).setUpload(true);
        r13.setClientOption(r14);
        r13.getLocation(new e0(r12));
    }
}
