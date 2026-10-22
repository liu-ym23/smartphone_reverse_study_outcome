package com.bytedance.ai.widget;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3065b;

    public /* synthetic */ g(int r5, View r10) {
        this.f3064a = r5;
        this.f3065b = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        com.bytedance.ai.widget.contianer.f r10 = (com.bytedance.ai.widget.contianer.f) r5;
        switch(this.f3064a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        return Boolean.valueOf(Intrinsics.areEqual(((AppletWidgetContainer) r10).C, this.f3065b));
    L6:
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        WidgetContainer r11 = (WidgetContainer) r10;
        r11.getClass();
        View r12 = this.f3065b;
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r12, "view");
        AppletWidgetContainer r13 = (AppletWidgetContainer) r11;
        if (Intrinsics.areEqual(r13.C, r12) == false) goto L9;
    L19:
        boolean r14 = true;
    L21:
        return Boolean.valueOf(r14);
    L9:
        if (Intrinsics.areEqual(r13.d(), r12) == true) goto L19;
        View r15 = r11.d();
        if ((r15 instanceof WebView) == false) goto L14;
        WebView r16 = (WebView) r15;
    L16:
        if (Intrinsics.areEqual(r16, r12) == true) goto L19;
        r14 = false;
        goto L21
    L14:
        r16 = null;
        goto L16
    }
}
