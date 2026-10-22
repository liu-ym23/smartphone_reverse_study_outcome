package com.larus.asr.session;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class InputTextAsrSession2V2$createComponents$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public InputTextAsrSession2V2$createComponents$1(Object r8) {
        super(0, r8, p.class, "shouldInterruptMessageOnAsrStart", "shouldInterruptMessageOnAsrStart()Z", 0);
    }

    public final Boolean invoke() {
        return Boolean.valueOf(((p) ((CallableReference) this).receiver).xa());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m399invoke() {
        return invoke();
    }
}
