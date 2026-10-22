package com.bytedance.ai.widget;

import cn.nubia.neopush.commons.Constant;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements com.bytedance.ai.resource.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f3078a;

    public n(o r5) {
        this.f3078a = r5;
    }

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
        BuildersKt.launch$default(h0.a(Dispatchers.getMain()), null, null, new WidgetManager$widgetUpdateListener$1$onCompleteUpdate$1(r10, r11, this.f3078a, null), 3, null);
    }

    @Override // com.bytedance.ai.resource.c
    public final void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
    }
}
