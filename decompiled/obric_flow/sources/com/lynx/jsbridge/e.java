package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f9906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxView f9907c;
    public final /* synthetic */ Callback d;

    public /* synthetic */ e(ReadableMap r5, LynxView r10, Callback r11, int r12) {
        this.f9905a = r12;
        this.f9906b = r5;
        this.f9907c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f9905a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        g0 r5 = new g0(TemplateData.c(this.f9906b.asHashMap()));
        this.f9907c.updateMetaData(r5);
        Callback r10 = this.d;
        r10.invoke(new Object[0]);
        return;
    L6:
        g0 r11 = new g0(TemplateData.c(this.f9906b.asHashMap()));
        this.f9907c.updateMetaData(r11);
        Callback r12 = this.d;
        r12.invoke(new Object[0]);
    }
}
