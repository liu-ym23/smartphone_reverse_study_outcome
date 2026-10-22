package com.lynx.tasm;

import com.lynx.react.bridge.JavaOnlyArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxGetUIResult {
    public final JavaOnlyArray a;

    public LynxGetUIResult(JavaOnlyArray r1) {
        this.a = r1;
    }

    private static LynxGetUIResult create(JavaOnlyArray r0, int r1, String r2) {
        return new LynxGetUIResult(r0);
    }
}
