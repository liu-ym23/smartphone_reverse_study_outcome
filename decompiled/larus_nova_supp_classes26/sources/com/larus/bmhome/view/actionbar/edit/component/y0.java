package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.commercemembership.api.ICommerceMembershipService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y0 {
    public static final void a(Context r3, k0 r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r0 = ICommerceMembershipService.a.a();
        if (r0 == null) goto L5;
        r0.v(r4.c, null);
    L5:
        String r1 = r4.a();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        int r2 = uz8.b.e;
        SmartRouter.buildRoute(r3, b(r1, r5, uz8.b.a.a(r4.d))).d();
    }

    public static final String b(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "enterMethod");
        Uri r13 = UriProtector.parse(r10);
        String r1 = com.larus.utils.y0.f(r13, "target_url");
        int r3 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L19;
        Intrinsics.checkNotNull(r13);
        Uri r14 = com.larus.utils.y0.l(r13, "enter_method", r11);
        if (r12 != null) goto L14;
    L16:
        r12 = null;
    L18:
        return com.larus.utils.y0.l(r14, "feature_detail", r12).toString();
    L14:
        if ((!StringsKt.isBlank(r12)) == false) goto L16;
    L19:
        int r5 = 0;
    L21:
        if (UriProtector.parse(r1).getScheme() != null) goto L26;
        String r8 = Uri.decode(r1);
        if (Intrinsics.areEqual(r8, r1) == true) goto L26;
        Intrinsics.checkNotNull(r8);
        r5 = r5 + 1;
        r1 = r8;
    L26:
        Intrinsics.checkNotNullParameter(r1, ShareType.URL);
        Uri r15 = com.larus.utils.y0.l(UriProtector.parse(r1), "enter_method", r11);
        if (r12 != null) goto L29;
    L31:
        r12 = null;
    L32:
        String r16 = com.larus.utils.y0.l(r15, "feature_detail", r12).toString();
        Intrinsics.checkNotNull(r13);
    L33:
        if (r3 >= r5) goto L36;
        r16 = Uri.encode(r16);
        r3 = r3 + 1;
        goto L33
    L36:
        return com.larus.utils.y0.l(r13, "target_url", r16).toString();
    L29:
        if ((!StringsKt.isBlank(r12)) == false) goto L31;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r4 = false;
        goto L10
    }
}
