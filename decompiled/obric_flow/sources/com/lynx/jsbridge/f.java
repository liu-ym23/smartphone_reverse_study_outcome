package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxView f9909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Callback f9910c;

    public /* synthetic */ f(LynxView r5, Callback r10, int r11) {
        this.f9908a = r11;
        this.f9909b = r5;
        this.f9910c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f9908a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        TemplateData r5 = this.f9909b.getTemplateData();
        this.f9910c.invoke(new Object[]{r5});
        return;
    L6:
        TemplateData r10 = this.f9909b.getTemplateData();
        this.f9910c.invoke(new Object[]{r10});
    }
}
