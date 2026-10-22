package com.larksuite.component.card.component.text;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g extends com.lynx.tasm.behavior.a {
    public g() {
        super("msg-card-text");
    }

    public final ShadowNode createShadowNode() {
        return new UniversalCardTextShadowNode();
    }

    public final LynxUI<UniversalCardLightTextView> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new UniversalCardTextLynxUI(r2);
    }
}
