package com.bytedance.ai.widget;

import com.bytedance.ai.widget.contianer.WidgetContainer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3069b;

    public /* synthetic */ i(String r5, int r10) {
        this.f3068a = r10;
        this.f3069b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        com.bytedance.ai.widget.contianer.f r10 = (com.bytedance.ai.widget.contianer.f) r5;
        switch(this.f3068a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        return Boolean.valueOf(Intrinsics.areEqual(((WidgetContainer) r10).e, this.f3069b));
    L6:
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        com.bytedance.ai.widget.contianer.h r11 = ((WidgetContainer) r10).f;
        if (r11 == null) goto L9;
        String r12 = r11.e;
    L11:
        return Boolean.valueOf(Intrinsics.areEqual(r12, this.f3069b));
    L9:
        r12 = null;
        goto L11
    }
}
