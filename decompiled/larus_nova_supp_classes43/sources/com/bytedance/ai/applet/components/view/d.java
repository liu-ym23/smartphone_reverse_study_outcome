package com.bytedance.ai.applet.components.view;

import com.lynx.animax.util.LynxAnimaX;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends com.lynx.tasm.behavior.a {
    public d() {
        super("animax-view");
    }

    public final LynxUI<?> createUI(LynxContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return LynxAnimaX.inst().createUI(r10);
    }
}
