package com.bytedance.ai.applet.components.view;

import com.bytedance.ai.applet.render.core.camera.LynxCameraUI;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends com.lynx.tasm.behavior.a {
    public e() {
        super("camera");
    }

    public final LynxUI<?> createUI(LynxContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return new LynxCameraUI(r10);
    }
}
