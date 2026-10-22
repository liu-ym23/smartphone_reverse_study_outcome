package com.larus.tts.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ ChatTitleTtsComponent a;

    public /* synthetic */ h(ChatTitleTtsComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        ChatTitleTtsComponent r0 = this.a;
        Boolean r8 = (Boolean) r7;
        int r1 = ChatTitleTtsComponent.v;
        com.larus.platform.api.g0 r2 = r0.Y2();
        boolean r3 = false;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (r8.booleanValue() == false) goto L12;
        if (r4 == true) goto L12;
        r3 = true;
    L12:
        com.larus.platform.api.g0 r5 = r0.Y2();
        if (r5 == null) goto L15;
        Boolean r6 = Boolean.valueOf(r5.getTtsChecked());
    L17:
        if (Intrinsics.areEqual(r6, r8) == true) goto L22;
        com.larus.platform.api.g0 r9 = r0.Y2();
        if (r9 == null) goto L22;
        Intrinsics.checkNotNull(r8);
        r9.setTtsChecked(r8.booleanValue());
    L22:
        if (Intrinsics.areEqual(r0.j.getValue(), Boolean.valueOf(r3)) == true) goto L25;
        FLogger.a.i("ChatTitleTtsComponent", "[TTS] observeGlobalTtsUserToggle sync: enable=" + r8 + " banned=" + r4 + ' ' + r0.j.getValue() + " -> " + r3);
        r0.j.setValue(Boolean.valueOf(r3));
    L25:
        return Unit.INSTANCE;
    L15:
        r6 = null;
        goto L17
    L5:
        if (r2.getTtsBanned() != true) goto L7;
        r4 = true;
        goto L9
    }
}
