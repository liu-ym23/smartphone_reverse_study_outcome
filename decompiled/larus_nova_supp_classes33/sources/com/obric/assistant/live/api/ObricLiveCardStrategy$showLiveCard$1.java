package com.obric.assistant.live.api;

import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricLiveCardStrategy$showLiveCard$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ObricLiveCardStrategy$showLiveCard$1(Object r8) {
        super(0, r8, ObricLiveServiceDelegate.class, "updateComplexTaskLiveCard", "updateComplexTaskLiveCard()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m4invoke() {
        ((ObricLiveServiceDelegate) ((CallableReference) this).receiver).i();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m4invoke();
        return Unit.INSTANCE;
    }
}
