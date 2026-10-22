package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends pm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f9904c;
    public final /* synthetic */ Callback d;
    public final /* synthetic */ LynxAccessibilityModule e;

    public /* synthetic */ c(LynxAccessibilityModule r5, com.lynx.tasm.behavior.f r10, ReadableMap r11, Callback r12, int r13) {
        this.f9903b = r13;
        this.e = r5;
        this.f9904c = r11;
        this.d = r12;
        super(r10);
    }

    @Override // pm.g
    public final void a() {
        switch(this.f9903b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        JavaOnlyMap r5 = new JavaOnlyMap();
        this.e.accessibilityAnnounceInner(this.f9904c, r5);
        this.d.invoke(new Object[]{r5});
        return;
    L6:
        JavaOnlyMap r10 = new JavaOnlyMap();
        this.e.registerMutationStyleInner(this.f9904c, r10);
        this.d.invoke(new Object[]{r10});
    }
}
