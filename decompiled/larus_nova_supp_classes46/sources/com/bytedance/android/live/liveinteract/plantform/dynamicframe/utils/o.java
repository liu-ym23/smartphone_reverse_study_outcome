package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.view.View;
import com.bytedance.android.live.lynx.ui.EcomCustomUIImage;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends com.lynx.tasm.behavior.a {
    public o() {
        super("ecom-image");
    }

    public final LynxUI<View> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new EcomCustomUIImage(r2);
    }
}
