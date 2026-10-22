package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 extends com.lynx.tasm.behavior.a {
    public b0() {
        super("inline-image", false, true);
    }

    @Override // com.lynx.tasm.behavior.a
    public final ShadowNode createShadowNode() {
        return new FrescoInlineImageShadowNode();
    }
}
