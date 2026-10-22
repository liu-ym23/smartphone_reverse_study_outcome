package com.larksuite.component.card.component.image;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends com.lynx.tasm.behavior.a {
    public b() {
        super("msg-card-image");
    }

    public final ShadowNode createShadowNode() {
        return new UniversalCardImageShadowNode();
    }

    public final LynxUI<UniversalCardRoundedImageView> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new UniversalCardLynxImageUI(r2);
    }
}
