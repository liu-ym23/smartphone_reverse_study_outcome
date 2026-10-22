package com.obric.assistant.component;

import com.larus.bmhome.view.TitleAvatarImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m6 implements Function1 {
    public final /* synthetic */ OrionInstructionComponent a;

    public /* synthetic */ m6(OrionInstructionComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r11) {
        OrionInstructionComponent r0 = this.a;
        int r1 = OrionInstructionComponent.p1;
        Intrinsics.checkNotNullParameter((TitleAvatarImageView) r11, "it");
        laa.d r2 = r0.d4();
        if (r2 == null) goto L6;
        laa.d.a.d(r2, false, com.obric.assistant.util.m2.b, null, false, false, null, 61);
    L6:
        return Unit.INSTANCE;
    }
}
