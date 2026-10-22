package com.larus.bmhome.chat.component.bottom.core;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g6 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ LarusWidgetInputBinding b;

    public /* synthetic */ g6(CoreInputComponent r1, LarusWidgetInputBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r10) {
        CoreInputComponent r0 = this.a;
        LarusWidgetInputBinding r1 = this.b;
        byte[] r11 = (byte[]) r10;
        int r2 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r11, "it");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new CoreInputComponent$setActionVoiceInputClickListener$7$1(r1, r11, null), 3, null);
        return Unit.INSTANCE;
    }
}
