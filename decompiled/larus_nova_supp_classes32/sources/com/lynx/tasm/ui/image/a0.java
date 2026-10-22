package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a0 extends com.lynx.tasm.behavior.a {
    public a0() {
        super("filter-image", false, true);
    }

    @Override // com.lynx.tasm.behavior.a
    public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
        return new UIFilterImage(r2, r3);
    }
}
