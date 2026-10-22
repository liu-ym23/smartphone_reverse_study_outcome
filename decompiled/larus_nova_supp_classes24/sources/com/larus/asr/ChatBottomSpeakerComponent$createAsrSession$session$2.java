package com.larus.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class ChatBottomSpeakerComponent$createAsrSession$session$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    public ChatBottomSpeakerComponent$createAsrSession$session$2(Object r8) {
        super(0, r8, ChatBottomSpeakerComponent.class, "canUseSimultaneousTranslator", "canUseSimultaneousTranslator()Z", 0);
    }

    public final Boolean invoke() {
        return Boolean.valueOf(ChatBottomSpeakerComponent.B3((ChatBottomSpeakerComponent) ((CallableReference) this).receiver));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m397invoke() {
        return invoke();
    }
}
