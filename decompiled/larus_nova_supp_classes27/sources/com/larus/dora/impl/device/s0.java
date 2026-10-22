package com.larus.dora.impl.device;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s0 {
    public static final s0 a = null;
    public static final Set<Integer> b = null;
    public static final Set<Integer> c = null;

    public s0() {
    }

    static {
        a = new s0();
        ProductNameType r2 = ProductNameType.DORA_LITE;
        ProductNameType r3 = ProductNameType.H_FREE_CLIP_2;
        ProductNameType r5 = ProductNameType.H_FREE_CLIP_2_HE;
        ProductNameType r7 = ProductNameType.H_FREE_BUDS_PRO_5;
        b = SetsKt.setOf(new Integer[]{Integer.valueOf(r2.id), Integer.valueOf(r3.id), Integer.valueOf(r5.id), Integer.valueOf(r7.id)});
        c = SetsKt.setOf(new Integer[]{Integer.valueOf(r2.deviceType), Integer.valueOf(r3.deviceType), Integer.valueOf(r5.deviceType), Integer.valueOf(r7.deviceType)});
    }

    public static boolean f() {
        List r0 = DoraAdapterExtKt.k(kj4.a.g());
        if (r0.isEmpty() == true) goto L23;
        List r1 = r0;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        DoraDevice r3 = (DoraDevice) r2.next();
        s0 r4 = a;
        Integer r5 = Integer.valueOf(r3.productId);
        Integer r6 = Integer.valueOf(r3.vendorId);
        Integer r7 = Integer.valueOf(r3.type);
        r4.getClass();
        if (g(r5, r6, r7) == false) goto L11;
        boolean r8 = true;
    L16:
        if (r8 == true) goto L24;
        return false;
    L24:
        return true;
    L15:
        r8 = false;
        goto L16
    L7:
        if (r1.isEmpty() == false) goto L9;
    L23:
        return true;
    }

    public static void d(Context r3) {
        com.bytedance.router.i r4 = SmartRouter.buildRoute(r3, "//flow/dora/device_list");
        r4.d = 2130772401;
        r4.e = 2130772399;
        r4.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_list_v2");
        r4.d();
    }

    public static boolean a(Integer r0, Integer r1) {
        if (o59.a.o(r0) == false) goto L5;
    L8:
        return true;
    L5:
        if (o59.a.n(r1) == true) goto L8;
        return false;
    }

    public static boolean b(String r5, Bundle r6) {
        boolean r1 = false;
        if (w0.a() == true) goto L6;
        return false;
    L6:
        if (r5 == null) goto L106;
        int r3 = -1;
        Integer r4 = null;
        switch(r5.hashCode()) {
            case -1955817218: goto L84;
            case -984145675: goto L22;
            case -186833882: goto L19;
            case 1653376398: goto L15;
            case 1653489997: goto L11;
            default: goto L109;
        };
    L109:
        return true;
    L11:
        if (r5.equals("//flow/dora/obric_device_list") == true) goto L107;
        return true;
    L107:
        return f();
    L15:
        if (r5.equals("//flow/dora/obric_device_home") == true) goto L108;
        return true;
    L108:
        return f();
    L19:
        if (r5.equals("//flow/dora/obric_env_auth_onboarding") == false) goto L112;
    L104:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L30
        if (r6 == null) goto L27;
        DoraOnboardingDevice r8 = (DoraOnboardingDevice) r6.getParcelable("key_dora_onboarding_device");     // Catch: Throwable -> L30
    L28:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r9) == false) goto L35;
        r9 = null;
    L35:
        DoraOnboardingDevice r10 = (DoraOnboardingDevice) r9;
        int r11 = com.larus.dora.impl.util.s.a;
        if (r10 == null) goto L39;
        r4 = Integer.valueOf(r10.h);
    L39:
        if (com.larus.dora.impl.util.s.c(r4) == false) goto L103;
        if (r10 == null) goto L43;
        r3 = r10.h;
    L43:
        ProductNameType r12 = ProductNameType.getProduct(r3);
        if (r10 != null) goto L46;
    L48:
        boolean r13 = false;
    L49:
        if (r13 == false) goto L51;
    L101:
        r1 = true;
        goto L103
    L51:
        if (r10 != null) goto L53;
    L55:
        boolean r14 = false;
    L56:
        if (r14 == true) goto L101;
        if (r10 != null) goto L60;
    L62:
        boolean r15 = false;
    L63:
        if (r15 == true) goto L101;
        if (r12 != null) goto L66;
    L68:
        boolean r16 = false;
    L69:
        if (r16 == true) goto L101;
        if (r12 != null) goto L72;
    L74:
        boolean r17 = false;
    L75:
        if (r17 == true) goto L101;
        if (r12 != null) goto L78;
    L80:
        boolean r18 = false;
    L81:
        if (r18 == false) goto L103;
    L78:
        if (r12.deviceType != 19) goto L80;
        r18 = true;
        goto L81
    L72:
        if (r12.deviceType != 18) goto L74;
        r17 = true;
        goto L75
    L66:
        if (r12.deviceType != 17) goto L68;
        r16 = true;
        goto L69
    L60:
        if (r10.getType() != 19) goto L62;
        r15 = true;
        goto L63
    L53:
        if (r10.getType() != 18) goto L55;
        r14 = true;
        goto L56
    L46:
        if (r10.getType() != 17) goto L48;
        r13 = true;
    L103:
        return r1;
    L27:
        r8 = null;
    L30:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L112:
        return true;
    L22:
        if (r5.equals("//flow/dora/obric_onboarding") == true) goto L104;
        return true;
    L84:
        if (r5.equals("//flow/dora/obric_bind_device") == false) goto L114;
        Integer r21 = t0.a(r6, "product_id");
        if (r21 != null) goto L90;
    L92:
        int r22 = ProductNameType.DORA_LITE.id;
        if (r21 == null) goto L98;
        if (r21.intValue() == r22) goto L101;
    L98:
        if (a(r21, null) == false) goto L103;
        if (com.larus.dora.impl.util.s.c(r21) == false) goto L103;
    L90:
        if (r21.intValue() != (-1)) goto L92;
        return true;
    L114:
        return true;
    L106:
        return true;
    }

    public static boolean e(Context r4, DoraOnboardingDevice r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 != null) goto L5;
        return false;
    L5:
        if (w0.a() == true) goto L7;
        return false;
    L7:
        if (g(Integer.valueOf(r5.h), Integer.valueOf(r5.i), Integer.valueOf(r5.getType())) == false) goto L20;
        String r6 = r5.b;
        com.bytedance.router.i r7 = SmartRouter.buildRoute(r4, "//flow/dora/obric_device_home");
        r7.d = 2130772401;
        r7.e = 2130772399;
        r7.c.addFlags(603979776);
        if (r6 != null) goto L11;
        String r1 = "";
    L12:
        r7.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r1);
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r7.c.putExtra("mac", r6);
        r7.d();
        return true;
    L11:
        r1 = r6;
        goto L12
    L20:
        return false;
    }

    public static void c(Context r12, String r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        if (r13 != null) goto L5;
        return;
    L5:
        switch(r13.hashCode()) {
            case -1955817218: goto L72;
            case -984145675: goto L65;
            case -186833882: goto L62;
            case 1653376398: goto L12;
            case 1653489997: goto L8;
            default: goto L95;
        };
    L95:
        return;
    L8:
        if (r13.equals("//flow/dora/obric_device_list") == false) goto L96;
        g49.d.d("DoraDeviceNavigator", "fallback Obric list to legacy device list");
        d(r12);
        return;
    L96:
        return;
    L12:
        if (r13.equals("//flow/dora/obric_device_home") == false) goto L97;
        g49.d.d("DoraDeviceNavigator", "fallback Obric home to legacy management");
        IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        t39.d r16 = null;
        if (r15 == null) goto L17;
        t39.d r17 = r15.L();
    L18:
        if (r17 != null) goto L21;
        d(r12);
        return;
    L21:
        if (a(r17.c, null) == false) goto L25;
        int r0 = com.larus.dora.impl.util.s.a;
        if (com.larus.dora.impl.util.s.c(r17.c) == false) goto L25;
        r16 = r17;
    L40:
        if (r16 == null) goto L42;
        String r1 = "//dora_g_device_management";
    L43:
        com.bytedance.router.i r18 = SmartRouter.buildRoute(r12, r1);
        r18.d = 2130772401;
        r18.e = 2130772399;
        r18.c.addFlags(603979776);
        if (r16 == null) goto L47;
        r17 = r16;
    L47:
        Bundle r110 = new Bundle();
        Integer r2 = r17.c;
        if (r2 == null) goto L50;
        r110.putInt("product_id", r2.intValue());
    L50:
        Integer r3 = r17.d;
        if (r3 == null) goto L53;
        r110.putInt(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, r3.intValue());
    L53:
        String r4 = r17.b;
        String r5 = "";
        if (r4 != null) goto L56;
        r4 = "";
    L56:
        r110.putString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r4);
        String r111 = r17.e;
        if (r111 == null) goto L60;
        r5 = r111;
    L60:
        r110.putString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r5);
        r110.putString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_manage_v3");
        r18.c.putExtras(r110);
        r18.d();
        return;
    L42:
        r1 = "//dora_dynamic_list";
    L25:
        Iterator r6 = DoraAdapterExtKt.k(kj4.a.g()).iterator();
    L27:
        if (r6.hasNext() == false) goto L36;
        Object r7 = r6.next();
        DoraDevice r8 = (DoraDevice) r7;
        s0 r9 = a;
        Integer r10 = Integer.valueOf(r8.productId);
        Integer r11 = Integer.valueOf(r8.type);
        r9.getClass();
        if (a(r10, r11) == false) goto L33;
        int r20 = com.larus.dora.impl.util.s.a;
        if (com.larus.dora.impl.util.s.c(Integer.valueOf(r8.productId)) == false) goto L33;
        boolean r21 = true;
    L34:
        if (r21 == false) goto L27;
    L37:
        DoraDevice r22 = (DoraDevice) r7;
        if (r22 == null) goto L40;
        r16 = new t39.d(r22.name, r22.mac, Integer.valueOf(r22.productId), Integer.valueOf(r22.vendorId), r22.model, r22.sn);
    L33:
        r21 = false;
        goto L34
    L36:
        r7 = null;
        goto L37
    L17:
        r17 = null;
        goto L18
    L97:
        return;
    L62:
        if (r13.equals("//flow/dora/obric_env_auth_onboarding") == false) goto L98;
    L67:
        g49.d.d("DoraDeviceNavigator", "fallback Obric onboarding to legacy onboarding");
        com.bytedance.router.i r112 = SmartRouter.buildRoute(r12, "//dora_onboarding_v2");
        if (r14 != null) goto L70;
        r14 = new Bundle();
    L70:
        r112.c.putExtras(new Bundle(r14));
        r112.d();
        return;
    L98:
        return;
    L65:
        if (r13.equals("//flow/dora/obric_onboarding") == true) goto L67;
        return;
    L72:
        if (r13.equals("//flow/dora/obric_bind_device") == false) goto L100;
        g49.d.d("DoraDeviceNavigator", "fallback Obric bind to legacy bind");
        com.bytedance.router.i r113 = SmartRouter.buildRoute(r12, "//flow/dora/bind_device");
        if (r14 != null) goto L77;
        r14 = new Bundle();
    L77:
        Bundle r114 = new Bundle(r14);
        Integer r115 = t0.a(r114, "product_id");
        if (r115 == null) goto L80;
        r114.putString("product_id", String.valueOf(r115.intValue()));
    L80:
        Integer r116 = t0.a(r114, DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID);
        if (r116 == null) goto L83;
        r114.putString(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, String.valueOf(r116.intValue()));
    L83:
        r114.putString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "bind_device_v2");
        r113.c.putExtras(r114);
        r113.d();
        return;
    }

    public static boolean g(Integer r2, Integer r3, Integer r4) {
        if (a(r2, r4) == false) goto L5;
        return true;
    L5:
        if (r2 != null) goto L7;
    L8:
        if (r4 != null) goto L10;
    L11:
        if (r3 != null) goto L14;
    L20:
        return false;
    L14:
        if (r3.intValue() != 4096) goto L20;
        if (r2 == null) goto L20;
        if (r2.intValue() != (-1)) goto L20;
        return true;
    L10:
        if (c.contains(r4) == false) goto L11;
        return true;
    L7:
        if (b.contains(r2) == false) goto L8;
        return true;
    }
}
