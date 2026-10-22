package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements l {
    @Override // com.bytedance.ai.resource.l
    public final void a(AIPackage r5, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        Intrinsics.checkNotNullParameter(r12, "packageType");
        if (r13 != 0) goto L10;
        if (r5 == null) goto L10;
        String r15 = "<initApplet><" + r10 + ", " + r11 + Typography.greater + r12.name() + " install success";
        Intrinsics.checkNotNullParameter("applet_lifecycle", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L8;
        r16.i("applet_lifecycle", r15);
    L8:
        j.k(r5, false);
        return;
    L10:
        String r17 = com.lynx.tasm.utils.b.j("failed to install permanent AI Package with packageName: ", r10, ", appId: ", r11);
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L13;
        r18.e("AIManager", r17);
    L13:
        String r19 = "<initApplet><" + r10 + ", " + r11 + Typography.greater + r12.name() + " install failed";
        Intrinsics.checkNotNullParameter("applet_lifecycle", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L17;
        r20.i("applet_lifecycle", r19);
        return;
    }
}
