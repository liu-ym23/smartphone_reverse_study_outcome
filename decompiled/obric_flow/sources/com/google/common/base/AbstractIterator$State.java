package com.google.common.base;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;

/* JADX INFO: loaded from: classes2.dex */
final enum AbstractIterator$State extends Enum<AbstractIterator$State> {
    public static final AbstractIterator$State DONE = null;
    public static final AbstractIterator$State FAILED = null;
    public static final AbstractIterator$State NOT_READY = null;
    public static final AbstractIterator$State READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AbstractIterator$State[] f8639a = null;

    static {
        AbstractIterator$State r5 = new AbstractIterator$State("READY", 0);
        READY = r5;
        AbstractIterator$State r10 = new AbstractIterator$State("NOT_READY", 1);
        NOT_READY = r10;
        AbstractIterator$State r11 = new AbstractIterator$State("DONE", 2);
        DONE = r11;
        AbstractIterator$State r12 = new AbstractIterator$State(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 3);
        FAILED = r12;
        f8639a = new AbstractIterator$State[]{r5, r10, r11, r12};
    }

    public static AbstractIterator$State valueOf(String r5) {
        return (AbstractIterator$State) Enum.valueOf(AbstractIterator$State.class, r5);
    }

    public static AbstractIterator$State[] values() {
        return (AbstractIterator$State[]) f8639a.clone();
    }
}
