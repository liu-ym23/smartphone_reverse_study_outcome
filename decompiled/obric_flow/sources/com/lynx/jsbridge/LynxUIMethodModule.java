package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public class LynxUIMethodModule extends LynxContextModule {
    public static final String NAME = "LynxUIMethodModule";

    public LynxUIMethodModule(LynxContext r5) {
        super(r5);
    }

    public static /* synthetic */ Callback access$000(Callback r5) {
        return wrapCallback(r5);
    }

    private static Callback wrapCallback(Callback r5) {
        return new ym.j(r5);
    }

    @n
    public void invokeUIMethod(String r10, ReadableArray r11, String r12, ReadableMap r13, Callback r14) {
        q r15 = new q(this, this.mLynxContext, r10, r11, r12, r13, r14);
        com.lynx.tasm.utils.j.a().post(r15);
    }
}
