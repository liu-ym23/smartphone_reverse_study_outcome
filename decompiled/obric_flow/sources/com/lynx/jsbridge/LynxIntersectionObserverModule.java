package com.lynx.jsbridge;

import androidx.annotation.Nullable;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public class LynxIntersectionObserverModule extends LynxContextModule {
    public static final String NAME = "IntersectionObserverModule";

    public LynxIntersectionObserverModule(LynxContext r5) {
        super(r5);
    }

    @n
    public void createIntersectionObserver(int r10, String r11, @Nullable ReadableMap r12) {
        j r13 = new j(this, this.mLynxContext, r10, r11, r12, 0);
        com.lynx.tasm.utils.j.a().post(r13);
    }

    @n
    public void disconnect(int r5) {
        m r10 = new m(this, this.mLynxContext, r5);
        com.lynx.tasm.utils.j.a().post(r10);
    }

    @n
    public void observe(int r10, String r11, int r12) {
        l r13 = new l(this, this.mLynxContext, r10, r11, r12);
        com.lynx.tasm.utils.j.a().post(r13);
    }

    @n
    public void relativeTo(int r10, String r11, @Nullable ReadableMap r12) {
        j r13 = new j(this, this.mLynxContext, r10, r11, r12, 1);
        com.lynx.tasm.utils.j.a().post(r13);
    }

    @n
    public void relativeToScreen(int r10, @Nullable ReadableMap r11) {
        k r12 = new k(this, this.mLynxContext, r10, r11, 1);
        com.lynx.tasm.utils.j.a().post(r12);
    }

    @n
    public void relativeToViewport(int r10, @Nullable ReadableMap r11) {
        k r12 = new k(this, this.mLynxContext, r10, r11, 0);
        com.lynx.tasm.utils.j.a().post(r12);
    }
}
