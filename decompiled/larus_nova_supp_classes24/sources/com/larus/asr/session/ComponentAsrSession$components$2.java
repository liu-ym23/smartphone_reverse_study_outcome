package com.larus.asr.session;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class ComponentAsrSession$components$2 extends FunctionReferenceImpl implements Function0<com.larus.asr.session.component.d0> {
    public ComponentAsrSession$components$2(Object r8) {
        super(0, r8, ComponentAsrSession.class, "createComponents", "createComponents()Lcom/larus/asr/session/component/AsrSessionComponents;", 0);
    }

    public final com.larus.asr.session.component.d0 invoke() {
        return ((ComponentAsrSession) ((CallableReference) this).receiver).b();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m398invoke() {
        return invoke();
    }
}
