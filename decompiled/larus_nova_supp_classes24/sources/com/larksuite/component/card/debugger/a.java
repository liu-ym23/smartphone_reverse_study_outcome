package com.larksuite.component.card.debugger;

import com.larksuite.component.card.plugin.OPPlugin;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements ICardDebugger {
    public a() {
    }

    @Override // com.larksuite.component.card.debugger.ICardDebugger
    public final void getEnable() {
    }

    @Override // com.larksuite.component.card.debugger.ICardDebugger
    public final List<OPPlugin> a() {
        return CollectionsKt.emptyList();
    }

    @Override // com.larksuite.component.card.debugger.ICardDebugger
    public final List<com.lynx.tasm.behavior.a> b() {
        return CollectionsKt.emptyList();
    }
}
