package com.larksuite.component.card.resources;

import com.larksuite.component.card.protocol.CardData;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements e {
    public d() {
    }

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
    }

    @Override // com.larksuite.component.card.resources.e
    public final void g(CardData r2) {
        Intrinsics.checkNotNullParameter(r2, "cardData");
    }

    @Override // com.larksuite.component.card.resources.e
    public final CardResource i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileKey");
        return null;
    }

    @Override // com.larksuite.component.card.resources.e
    public final Object b(b r2, Continuation<? super CardResource> r3) {
        return new CardResource(CardResource.ResourceType.AUDIO, "", "");
    }
}
