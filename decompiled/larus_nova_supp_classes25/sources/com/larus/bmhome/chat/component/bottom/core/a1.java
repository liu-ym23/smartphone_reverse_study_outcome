package com.larus.bmhome.chat.component.bottom.core;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a1 implements Function2 {
    public final /* synthetic */ CoreInputAbility a;

    public /* synthetic */ a1(CoreInputAbility r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5, Object r6) {
        final CoreInputAbility r0 = this.a;
        int r7 = ((Integer) r5).intValue();
        final String r8 = (String) r6;
        Intrinsics.checkNotNullParameter(r8, "clickFrom");
        FLogger.a.i("CoreInputAbility", "[onActionEntranceClicked] entranceType:" + r7 + ", clickFrom:" + r8);
        switch(r7) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L13;
        };
    L5:
        r0.o("start_doc_deep_thinking", r0.B(), new c2(r0));
        goto L13
    L6:
        r0.o("start_video_comprehend_album", r0.B(), new x1(r0));
        goto L13
    L7:
        r0.o("start_instruction", r0.B(), new b2(r0));
        goto L13
    L8:
        r0.o("start_realtime_call", ((Boolean) r0.J.getValue()).booleanValue(), new z1(r0, r8));
        goto L13
    L9:
        r0.o("start_file", r0.B(), new y1(r0));
        goto L13
    L10:
        r0.o("start_album", r0.B(), new w1(r0));
        goto L13
    L11:
        r0.o("start_camera", r0.B(), new v1(r0, r8));
    L13:
        return Unit.INSTANCE;
    }
}
