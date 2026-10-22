package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.s f2745a;

    public n(kotlinx.coroutines.s r5) {
        this.f2745a = r5;
    }

    @Override // com.bytedance.ai.resource.l
    public final void a(AIPackage r5, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        Intrinsics.checkNotNullParameter(r12, "packageType");
        y r15 = y.f2766a;
        if (r13 != 0) goto L5;
        String r16 = "CALLBACK_SUCCEEDED";
    L6:
        y.d(r10, r11, r16, "errorCode=" + r13 + ", errorMsg=" + r14);
        this.f2745a.N(Unit.INSTANCE);
        return;
    L5:
        r16 = "CALLBACK_FAILED";
        goto L6
    }
}
