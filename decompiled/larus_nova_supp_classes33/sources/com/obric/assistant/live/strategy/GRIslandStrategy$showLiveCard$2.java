package com.obric.assistant.live.strategy;

import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class GRIslandStrategy$showLiveCard$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public GRIslandStrategy$showLiveCard$2(Object r8) {
        super(0, r8, ObricLiveServiceDelegate.class, "updateComplexTaskLiveCard", "updateComplexTaskLiveCard()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m7invoke() {
        ((ObricLiveServiceDelegate) ((CallableReference) this).receiver).i();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m7invoke();
        return Unit.INSTANCE;
    }
}
