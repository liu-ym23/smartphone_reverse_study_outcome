package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements AIPackageManager.b {
    public final /* synthetic */ Function2<Boolean, String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function2<? super Boolean, ? super String, Unit> r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.resource.AIPackageManager.b
    public final void a(AIPackage r1, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r12, "packageType");
        if (r13 != 0) goto L9;
        if (r1 == null) goto L9;
        String r15 = "install package success: packageName: " + r10 + ", appId = " + r11;
        Function2<Boolean, String, Unit> r16 = this.a;
        if (r16 == null) goto L8;
        r16.invoke(Boolean.TRUE, r15);
    L8:
        com.bytedance.ai.utils.g.a.d("AIManager", r15);
        return;
    L9:
        String r17 = "install package failed: packageName: " + r10 + ", appId = " + r11;
        Function2<Boolean, String, Unit> r18 = this.a;
        if (r18 == null) goto L12;
        r18.invoke(Boolean.TRUE, r17);
    L12:
        com.bytedance.ai.utils.g.a.d("AIManager", r17);
    }
}
