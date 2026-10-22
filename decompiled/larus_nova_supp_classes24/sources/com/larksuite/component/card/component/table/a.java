package com.larksuite.component.card.component.table;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends com.lynx.tasm.behavior.a {
    public a() {
        super("table-markdown-container");
    }

    public final LynxUI<com.lynx.tasm.behavior.ui.view.a> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new TableMarkdownUI(r2);
    }
}
