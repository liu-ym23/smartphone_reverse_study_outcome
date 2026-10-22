package com.obric.feature.miniapp.widget;

import com.bytedance.ai.ex.widget.WidgetView;
import com.obric.widget.host.runtime.WidgetRendererEngine;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WidgetView f11425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f11426c;

    public /* synthetic */ a(WidgetView r5, String r10, int r11) {
        this.f11424a = r11;
        this.f11425b = r5;
        this.f11426c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f11424a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        String r5 = this.f11426c;
        WidgetRendererEngine.a(this.f11425b, r5);
        return;
    L6:
        MiniAppWidgetManagerWrapper.a(this.f11425b, this.f11426c);
    }
}
