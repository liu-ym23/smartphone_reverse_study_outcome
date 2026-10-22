package jg;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.utils.p;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(SkuViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        com.bytedance.android.ec.core.abtest.d r0 = com.bytedance.android.ec.core.abtest.d.a;
        jj4.b r1 = jj4.b.b;
        Object r11 = jj4.a.a("buynow_h5_android_sku_prerender", Boolean.class, Boolean.FALSE, false);
        if (r11 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        boolean r12 = ((Boolean) r11).booleanValue();
        String r13 = p.c(r10);
        if (r13 != null) goto L8;
    L11:
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
        return false;
    L14:
        boolean r15 = UriProtector.parse(r13).getBooleanQueryParameter("canUsePrerender", false);
        if (r12 == false) goto L19;
        if (r15 == false) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L8:
        if (r13.length() == 0) goto L11;
        r14 = false;
        goto L12
    }
}
