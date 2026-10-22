package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.lynx.ui.WebcastImage;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends com.lynx.tasm.behavior.a {
    public n() {
        super("webcast-image");
    }

    public final LynxUI<?> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new WebcastImage(r2);
    }
}
