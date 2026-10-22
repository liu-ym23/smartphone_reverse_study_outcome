package com.larksuite.component.card.component.checkbox;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends com.lynx.tasm.behavior.a {
    public b() {
        super("card-check-box");
    }

    public final LynxUI<?> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new UniversalCardLynxCheckBoxUI(r2);
    }
}
