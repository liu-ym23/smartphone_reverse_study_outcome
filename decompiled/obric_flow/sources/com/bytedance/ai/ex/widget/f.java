package com.bytedance.ai.ex.widget;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2156b;

    public /* synthetic */ f(String r5, int r10) {
        this.f2155a = r10;
        this.f2156b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        int r10 = this.f2155a;
        String r11 = this.f2156b;
        com.bytedance.ai.widget.contianer.f r12 = (com.bytedance.ai.widget.contianer.f) r5;
        switch(r10) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return Boolean.valueOf(WidgetView.b(r11, r12));
    L7:
        return Boolean.valueOf(WidgetRenderService.a(r11, r12));
    L9:
        return Boolean.valueOf(WidgetRenderService.b(r11, r12));
    }
}
