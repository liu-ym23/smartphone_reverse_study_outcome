package com.larus.bmhome.chat.component.bottom.core;

import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g5 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ g5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((AppCompatImageView) r10, "it");
        if (r0.k4().X() == false) goto L5;
        r0.k4().q0("call_left_to_asr_input", 4);
    L9:
        return Unit.INSTANCE;
    L5:
        xa8.e r11 = new xa8.e("continuous_chat_left_to_asr_input", ILegacyChatUiServiceDelegate.b.u8(s1a.d.a(r0)), null, null, false, 28);
        xa8.b r2 = s1a.d.a(r0).getAbility(xa8.b.class);
        if (r2 == null) goto L9;
        r2.fk(r11);
        goto L9
    }
}
