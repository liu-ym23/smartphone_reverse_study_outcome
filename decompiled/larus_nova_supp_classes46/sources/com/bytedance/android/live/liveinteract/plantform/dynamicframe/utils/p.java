package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.view.View;
import com.bytedance.android.live.lynx.ui.MultiLinkCustomUIImage;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends com.lynx.tasm.behavior.a {
    public p() {
        super("m-image");
    }

    public final LynxUI<View> createUI(LynxContext r2) {
        return new MultiLinkCustomUIImage(r2);
    }
}
