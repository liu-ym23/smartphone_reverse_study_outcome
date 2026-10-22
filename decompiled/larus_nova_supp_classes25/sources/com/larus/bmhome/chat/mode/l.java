package com.larus.bmhome.chat.mode;

import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.utils.a4;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Function2 {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ l(ModeSwitchComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        ModeSwitchComponent r0 = this.a;
        String r5 = (String) r3;
        boolean r6 = ((Boolean) r4).booleanValue();
        int r1 = ModeSwitchComponent.k0;
        Intrinsics.checkNotNullParameter(r5, "modeKey");
        if (r0.C == false) goto L17;
        if (r0.D3() == true) goto L17;
        ConversationMode r2 = (ConversationMode) r0.Si().getValue();
        if (r2 == null) goto L9;
        String r7 = r2.a();
    L11:
        if (Intrinsics.areEqual(r7, r5) == true) goto L17;
        r0.Y2(r5, r6);
        if (r6 == false) goto L17;
        a4.a.getClass();
        a4.a(a4.b / ((long) 3));
        goto L17
    L9:
        r7 = null;
    L17:
        return Unit.INSTANCE;
    }
}
