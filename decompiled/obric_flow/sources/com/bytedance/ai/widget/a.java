package com.bytedance.ai.widget;

import cn.nubia.neopush.commons.Constant;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.bytedance.ai.resource.c {
    @Override // com.bytedance.ai.resource.c
    public final void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
    }

    @Override // com.bytedance.ai.resource.c
    public final void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        BuildersKt.launch$default(h0.a(Dispatchers.getMain()), null, null, new GlobalWidgetCache$1$onCompleteUpdate$1(r10, r11, null), 3, null);
    }

    @Override // com.bytedance.ai.resource.c
    public final void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
    }
}
