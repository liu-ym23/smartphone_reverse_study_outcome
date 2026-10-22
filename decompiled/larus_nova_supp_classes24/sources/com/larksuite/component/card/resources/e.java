package com.larksuite.component.card.resources;

import com.larksuite.component.card.protocol.CardData;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface e extends com.larksuite.component.card.service.c {
    Object b(b r1, Continuation<? super CardResource> r2) throws CancellationException, ErrorResult, Throwable;

    void g(CardData r1);

    CardResource i(String r1);
}
