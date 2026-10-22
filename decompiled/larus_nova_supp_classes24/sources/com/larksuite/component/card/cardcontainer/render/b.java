package com.larksuite.component.card.cardcontainer.render;

import com.larksuite.component.card.cardcontainer.UniversalCardLynxRender;
import com.larksuite.component.card.protocol.CardConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends a {
    public final String b;

    @Override // com.larksuite.component.card.cardcontainer.render.a
    public final void a() {
    }

    public b(UniversalCardLynxRender r2, CardConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxRender");
        Intrinsics.checkNotNullParameter(r3, "cardConfig");
        super(r2, r3);
        this.b = "";
    }
}
