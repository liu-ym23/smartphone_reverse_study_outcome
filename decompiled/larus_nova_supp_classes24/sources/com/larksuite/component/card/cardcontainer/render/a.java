package com.larksuite.component.card.cardcontainer.render;

import com.larksuite.component.card.cardcontainer.UniversalCardLynxRender;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class a {
    public final UniversalCardLynxRender a;

    public void a() {
    }

    public a(UniversalCardLynxRender r2, CardConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxRender");
        Intrinsics.checkNotNullParameter(r3, "cardConfig");
        this.a = r2;
    }

    public final void b(CardData r8, CardContext r9, CardConfig r10) {
        Intrinsics.checkNotNullParameter(r8, "cardData");
        Intrinsics.checkNotNullParameter(r9, "cardContext");
        Intrinsics.checkNotNullParameter(r10, "cardConfig");
        com.larksuite.component.card.cardcontainer.b r1 = this.a.c;
        String r2 = r8.getCardID();
        String r3 = r8.getUniversalCardID();
        long r4 = System.currentTimeMillis();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "cardId");
        Intrinsics.checkNotNullParameter(r9, "cardContext");
        r1.a = r9;
        r1.f = r2;
        r1.g = r3;
        r1.b = r4;
        this.a.c(r8, r9, r10, r10.getMaxWidth());
    }
}
