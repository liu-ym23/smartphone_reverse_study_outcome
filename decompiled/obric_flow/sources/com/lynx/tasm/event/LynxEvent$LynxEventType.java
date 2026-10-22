package com.lynx.tasm.event;

/* JADX INFO: loaded from: classes2.dex */
public final enum LynxEvent$LynxEventType extends Enum<LynxEvent$LynxEventType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxEvent$LynxEventType f10839a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxEvent$LynxEventType f10840b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ LynxEvent$LynxEventType[] f10841c = null;

    static {
        LynxEvent$LynxEventType r5 = new LynxEvent$LynxEventType("kNone", 0);
        LynxEvent$LynxEventType r10 = new LynxEvent$LynxEventType("kTouch", 1);
        f10839a = r10;
        LynxEvent$LynxEventType r11 = new LynxEvent$LynxEventType("kMouse", 2);
        LynxEvent$LynxEventType r12 = new LynxEvent$LynxEventType("kWheel", 3);
        LynxEvent$LynxEventType r13 = new LynxEvent$LynxEventType("kKeyboard", 4);
        LynxEvent$LynxEventType r14 = new LynxEvent$LynxEventType("kCustom", 5);
        f10840b = r14;
        f10841c = new LynxEvent$LynxEventType[]{r5, r10, r11, r12, r13, r14};
    }

    public LynxEvent$LynxEventType(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxEvent$LynxEventType valueOf(String r5) {
        return (LynxEvent$LynxEventType) Enum.valueOf(LynxEvent$LynxEventType.class, r5);
    }

    public static LynxEvent$LynxEventType[] values() {
        return (LynxEvent$LynxEventType[]) f10841c.clone();
    }
}
