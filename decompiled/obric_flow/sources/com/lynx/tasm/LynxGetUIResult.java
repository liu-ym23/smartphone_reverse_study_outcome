package com.lynx.tasm;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class LynxGetUIResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaOnlyArray f10002a;

    public LynxGetUIResult(JavaOnlyArray r5) {
        this.f10002a = r5;
    }

    @CalledByNative
    private static LynxGetUIResult create(JavaOnlyArray r5, int r10, String r11) {
        return new LynxGetUIResult(r5);
    }
}
