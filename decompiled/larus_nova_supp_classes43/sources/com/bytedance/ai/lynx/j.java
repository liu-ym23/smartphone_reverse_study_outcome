package com.bytedance.ai.lynx;

import com.lynx.animax.util.LynxAnimaX;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends com.lynx.tasm.behavior.a {
    public j() {
        super("animax-view");
    }

    public final LynxUI<?> createUI(LynxContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return LynxAnimaX.inst().createUI(r10);
    }
}
