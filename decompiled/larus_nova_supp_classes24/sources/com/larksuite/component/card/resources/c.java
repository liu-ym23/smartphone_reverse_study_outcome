package com.larksuite.component.card.resources;

import com.larksuite.component.card.service.ICardServiceFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements ICardServiceFactory<e> {
    public c() {
    }

    @Override // com.larksuite.component.card.service.ICardServiceFactory
    public final ICardServiceFactory.Scope a() {
        return ICardServiceFactory.Scope.LIFECYCLE;
    }

    @Override // com.larksuite.component.card.service.ICardServiceFactory
    public final com.larksuite.component.card.service.c b(com.larksuite.component.card.service.b r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceContext");
        return new CardResourceServiceImpl();
    }
}
