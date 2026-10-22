package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m4 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ m4(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        CoreInputComponent r0 = this.a;
        MentionFilePickerType r4 = (MentionFilePickerType) r3;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r4, "type");
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r2 = r0.j4();
        if (r2 == null) goto L6;
        r2.Jz(r4);
    L6:
        return Unit.INSTANCE;
    }
}
