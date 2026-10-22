package com.larus.audio.call.mgr;

import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Deprecated(message = "临时兼容使用，仅对齐历史逻辑，不保证对扩展逻辑生效")
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static MajorState.f a(AVKitCoreStates$Error r4) {
        int r1 = r4.a;
        Object r2 = r4.c.get("vui_error_code");
        if ((r2 instanceof Integer) == false) goto L5;
        Integer r3 = (Integer) r2;
    L6:
        if (r3 == null) goto L8;
        int r5 = r3.intValue();
    L10:
        return new MajorState.f(r1, r5, r4.b, 8);
    L8:
        r5 = 0;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static MajorState b(AVKitDuplexState.UpState r2) {
        if ((r2 instanceof AVKitCoreStates$Invalid) == false) goto L6;
        return MajorState.c.c;
    L6:
        if ((r2 instanceof AVKitCoreStates$Connecting) == false) goto L9;
        return MajorState.a.c;
    L9:
        if ((r2 instanceof AVKitCoreStates$Listening) == false) goto L12;
        return MajorState.j.c;
    L12:
        if ((r2 instanceof AVKitCoreStates$Recognizing) == false) goto L15;
        return new MajorState.d(MajorState.From.ASR, MajorState.InterruptType.NOTHING);
    L15:
        if ((r2 instanceof AVKitCoreStates$Error) == false) goto L18;
        return a((AVKitCoreStates$Error) r2);
    L18:
        if ((r2 instanceof AVKitCoreStates$Paused) == false) goto L21;
        return new MajorState.g(MajorState.j.c);
    L21:
        if ((r2 instanceof AVKitCoreStates$Finished) == false) goto L24;
        return MajorState.c.c;
    L24:
        return MajorState.j.c;
    }
}
