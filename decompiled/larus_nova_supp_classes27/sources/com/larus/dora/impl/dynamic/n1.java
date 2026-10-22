package com.larus.dora.impl.dynamic;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.manage.DoraGDeviceManagementActivity;
import com.larus.dora.impl.dynamic.dsl.DslIdentifierType;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n1 {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DslIdentifierType.values().length];
            r0[DslIdentifierType.STARLING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            r0[DslIdentifierType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L6:
            a = r0;
            int[] r1 = new int[DoraSKU.values().length];
            r1[DoraSKU.BLACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L45:
            r1[DoraSKU.ROUND_BLACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L37:
            r1[DoraSKU.WHITE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L39:
            r1[DoraSKU.ROUND_WHITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L27:
            r1[DoraSKU.SILVER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L41:
            r1[DoraSKU.ROUND_SILVER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L29:
            r1[DoraSKU.PURPLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L31:
            r1[DoraSKU.ROUND_PURPLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L15:
            b = r1;
        }
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static boolean g() {
        if (StringsKt.equals(Build.MANUFACTURER, "HUAWEI", true) == false) goto L5;
        return true;
    L5:
        Intrinsics.checkNotNullParameter("ro.build.version.emui", "key");
        Object r0 = a().getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"ro.build.version.emui"});     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L8
        String r1 = (String) r0;     // Catch: Exception -> L8
    L9:
        if (r1 != null) goto L11;
    L13:
        return false;
    L11:
        if (StringsKt.startsWith$default(r1, "EmotionUI", false, 2, null) == false) goto L13;
        return true;
    L8:
        r1 = null;
        goto L9
    }

    public static void i() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L20;
        t39.d r1 = r0.L();
        if (r1 == null) goto L21;
        int r2 = com.larus.dora.impl.util.s.a;
        if (com.larus.dora.impl.util.s.c(r1.c) == true) goto L10;
    L12:
        String r3 = "//dora_dynamic_list";
    L14:
        if (Intrinsics.areEqual(r3, "//dora_g_device_management") == true) goto L16;
    L18:
        com.bytedance.router.i r4 = SmartRouter.buildRoute(AppHost.a.getApplication(), r3);
        r4.d = 2130772401;
        r4.e = 2130772399;
        Integer r5 = r1.c;
        r4.c.putExtra("product_id", r5);
        r4.c.addFlags(536870912);
        String r6 = r1.e;
        r4.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r6);
        String r7 = r1.b;
        r4.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r7);
        r4.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_manage_v3");
        r4.c.putExtra("page_title", "Ola Friend");
        r4.d();
        return;
    L16:
        if (AppHost.a.a().h(DoraGDeviceManagementActivity.class) == false) goto L18;
        return;
    L10:
        if (o59.a.o(r1.c) == false) goto L12;
        r3 = "//dora_g_device_management";
        goto L14
    L21:
        return;
    }

    public static z49.b b(DoraDevice r11) {
        String r0 = null;
        if (r11 == null) goto L5;
        String r1 = r11.name;
    L6:
        if (r11 == null) goto L8;
        String r2 = r11.mac;
    L9:
        Integer r3 = Integer.valueOf(c(r11));
        if (r11 == null) goto L12;
        String r4 = r11.model;
    L13:
        if (r11 == null) goto L15;
        String r5 = r11.softVersion;
    L16:
        if (r11 == null) goto L18;
        String r6 = r11.sn;
    L19:
        if (r11 == null) goto L21;
        Integer r7 = Integer.valueOf(r11.sku);
    L22:
        if (r11 == null) goto L25;
        r0 = r11.caseSoftVersion;
    L25:
        return new z49.b(r1, r2, r3, r4, r5, r6, r7, r0, r11);
    L21:
        r7 = null;
        goto L22
    L18:
        r6 = null;
        goto L19
    L15:
        r5 = null;
        goto L16
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static int c(DoraDevice r1) {
        if (r1 != null) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L22;
        int r2 = r1.type;
        if (r2 != 16) goto L13;
        return ProductNameType.DORA_G.id;
    L13:
        if (r2 != 17) goto L17;
        return ProductNameType.DORA_G2.id;
    L17:
        if (r2 != 18) goto L21;
        return ProductNameType.DORA_G_AIR.id;
    L21:
        return ProductNameType.DORA_LITE.id;
    L22:
        if (r1 == null) goto L25;
        return r1.productId;
    L25:
        return ProductNameType.DORA_LITE.id;
    L4:
        if (r1.productId != 0) goto L6;
        r0 = true;
        goto L7
    }

    public static int d(z49.b r2) {
        if (r2 == null) goto L10;
        Integer r1 = r2.f();
        if (r1 == null) goto L10;
        if (r1.intValue() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return 1;
    L13:
        if (r2 == null) goto L18;
        Integer r4 = r2.f();
        if (r4 != null) goto L17;
        return 1;
    L17:
        return r4.intValue();
    L18:
        return 1;
    L10:
        r3 = false;
        goto L11
    }

    public static DoraSKU e(DoraSKU r1) {
        Intrinsics.checkNotNullParameter(r1, "sku");
        switch(a.b[r1.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L7:
        return DoraSKU.PURPLE;
    L9:
        return DoraSKU.SILVER;
    L11:
        return DoraSKU.WHITE;
    L13:
        return DoraSKU.BLACK;
    }

    public static boolean h(String r3) {
        kj4.a r0 = kj4.a.g();
        DoraDevice r1 = DoraAdapterExtKt.h(kj4.a.g());
        if (r0.getDoraLinkState(r1) != 2) goto L10;
        if (r1 == null) goto L6;
        String r2 = r1.mac;
    L8:
        if (TextUtils.equals(r3, r2) == false) goto L10;
        return true;
    L6:
        r2 = null;
    L10:
        return false;
    }

    public static DoraDevice j(z49.b r5) {
        DoraDevice r0 = DoraAdapterExtKt.h(kj4.a.g());
        if (r5 == null) goto L5;
        String r2 = r5.c();
    L6:
        if (r0 == null) goto L8;
        String r3 = r0.mac;
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L12;
        return r0;
    L12:
        List r1 = DoraAdapterExtKt.k(kj4.a.g());
        if (r1 == null) goto L28;
        Iterator r4 = r1.iterator();
    L16:
        if (r4.hasNext() == false) goto L24;
        Object r6 = r4.next();
        String r7 = ((DoraDevice) r6).mac;
        if (r5 == null) goto L20;
        String r8 = r5.c();
    L22:
        if (Intrinsics.areEqual(r7, r8) == false) goto L16;
    L25:
        DoraDevice r9 = (DoraDevice) r6;
        if (r9 == null) goto L28;
        return r9;
    L20:
        r8 = null;
        goto L22
    L24:
        r6 = null;
    L28:
        if (r5 == null) goto L30;
        DoraDevice r10 = r5.a;
    L31:
        if (r10 == null) goto L33;
        return r10;
    L33:
        return null;
    L30:
        r10 = null;
        goto L31
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static String f(Context r5, String r6) {
        Object r3 = "";
        if (r5.getResources() != null) goto L21;
        return "";
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        int r0 = r5.getResources().getIdentifier("larus_".concat(r6), "string", r5.getPackageName());     // Catch: Throwable -> L13
        if (r0 != 0) goto L8;
        r0 = r5.getResources().getIdentifier(r6, "string", r5.getPackageName());     // Catch: Throwable -> L13
    L8:
        if (r0 == 0) goto L10;
        String r7 = r5.getResources().getString(r0);     // Catch: Throwable -> L13
    L11:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r8) == true) goto L20;
        r3 = r8;
    L20:
        return (String) r3;
    L10:
        r7 = "";
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}
