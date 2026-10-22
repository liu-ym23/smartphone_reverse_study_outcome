package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.image.AutoSizeImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z extends com.lynx.tasm.behavior.a {
    public z() {
        super("image", true, true);
    }

    @Override // com.lynx.tasm.behavior.a
    public final com.lynx.tasm.a createClassWarmer() {
        return new o0();
    }

    @Override // com.lynx.tasm.behavior.a
    public final ShadowNode createShadowNode() {
        return new AutoSizeImage();
    }

    @Override // com.lynx.tasm.behavior.a
    public final LynxFlattenUI createFlattenUIWithParams(LynxContext r2, Object r3) {
        return new FlattenUIImage(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.a
    public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
        return new UIImage(r2, r3);
    }
}
