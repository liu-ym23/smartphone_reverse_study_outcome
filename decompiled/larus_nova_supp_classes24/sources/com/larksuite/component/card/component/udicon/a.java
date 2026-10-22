package com.larksuite.component.card.component.udicon;

import com.larksuite.component.card.component.image.UniversalCardRoundedImageView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends com.lynx.tasm.behavior.a {
    public a() {
        super("card-ud-icon");
    }

    public final LynxUI<UniversalCardRoundedImageView> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new UniversalCardUDIconUI(r2);
    }
}
