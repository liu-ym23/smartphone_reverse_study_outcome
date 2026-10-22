package l59;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.h.HSKU;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.util.DoraSKU;
import g49.b;
import g49.d;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(DoraDevice r5) {
        Lazy r0 = b.a;
        if (AppHost.a.isTestChannel() == false) goto L18;
        String r1 = ((Keva) b.a.getValue()).getString("key_debug_product", "");
        Intrinsics.checkNotNull(r1);
        boolean r2 = false;
        if (r1.length() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        r1 = null;
    L10:
        d.a("HResourceUtils", "getEffectiveProduct, debugProduct = " + r1);
        if (r1 != null) goto L13;
    L14:
        r2 = true;
    L15:
        if (r2 == true) goto L18;
        return r1;
    L13:
        if (r1.length() != 0) goto L15;
    L7:
        r3 = false;
    L18:
        return d(r5);
    }

    public static String c(DoraDevice r6) {
        Lazy r0 = b.a;
        boolean r1 = false;
        Integer r3 = null;
        if (AppHost.a.isTestChannel() == false) goto L19;
        String r2 = ((Keva) b.a.getValue()).getString("key_debug_sku", "");
        Intrinsics.checkNotNull(r2);
        if (r2.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        r2 = null;
    L10:
        d.a("HResourceUtils", "getEffectiveSku, debugSku = " + r2);
        if (r2 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L19;
        return r2;
    L13:
        if (r2.length() == 0) goto L16;
        r5 = false;
        goto L17
    L7:
        r4 = false;
    L19:
        if (r6 != null) goto L21;
    L23:
        if (r1 == false) goto L28;
        HSKU.a r7 = HSKU.Companion;
        if (r6 == null) goto L27;
        r3 = Integer.valueOf(r6.sku);
    L27:
        r7.getClass();
        return HSKU.a.a(r3).getSkuName();
    L28:
        DoraSKU.a r8 = DoraSKU.Companion;
        if (r6 == null) goto L32;
        r3 = Integer.valueOf(r6.sku);
    L32:
        return DoraSKU.a.b(r8, r3).getSkuName();
    L21:
        if (o59.a.r(r6) != true) goto L23;
        r1 = true;
        goto L23
    }

    public static String d(DoraDevice r2) {
        int r0 = n1.c(r2);
        if (r0 != ProductNameType.H_FREE_CLIP_2.id) goto L6;
    L23:
        return "dora_h_free_clip";
    L6:
        if (r0 != ProductNameType.H_FREE_CLIP_2_HE.id) goto L9;
        return "dora_h_free_clip_hardened";
    L9:
        if (r0 != ProductNameType.H_FREE_BUDS_PRO_5.id) goto L12;
        return "dora_h_free_buds_pro";
    L12:
        if (r0 != ProductNameType.H_GUITAR.id) goto L15;
        return "dora_h_guitar";
    L15:
        if (r0 != ProductNameType.H_DOLPHIN.id) goto L17;
        return "dora_h_dolphin";
    L17:
        if (r2 == null) goto L21;
        boolean r1 = true;
        if (o59.a.r(r2) != true) goto L21;
    L22:
        if (r1 == true) goto L23;
        return "dora_lite";
    L21:
        r1 = false;
        goto L22
    }

    public static String a(String r16, DoraDevice r17, String r18) {
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r18, "lightMode");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r16, "${product}", b(r17), false, 4, null), "${sku}", c(r17), false, 4, null), "${light_mode}", r18, false, 4, null);
    }
}
