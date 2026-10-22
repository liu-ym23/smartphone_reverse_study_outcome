package com.obric.assistant.activation.presentation.contract.gesture;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/gesture/ObricAiKeyGestureAction;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "DOWN", "LONG_PRESS_FAILED", "SINGLE_PRESS", "DOUBLE_PRESS", "PRESS_START", "SHORT_PRESS", "LONG_PRESS_START", "LONG_PRESS_STOP", "CANCEL", "TIMEOUT", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAiKeyGestureAction extends Enum<ObricAiKeyGestureAction> {
    public static final ObricAiKeyGestureAction CANCEL = null;
    public static final ObricAiKeyGestureAction DOUBLE_PRESS = null;
    public static final ObricAiKeyGestureAction DOWN = null;
    public static final ObricAiKeyGestureAction LONG_PRESS_FAILED = null;
    public static final ObricAiKeyGestureAction LONG_PRESS_START = null;
    public static final ObricAiKeyGestureAction LONG_PRESS_STOP = null;
    public static final ObricAiKeyGestureAction PRESS_START = null;
    public static final ObricAiKeyGestureAction SHORT_PRESS = null;
    public static final ObricAiKeyGestureAction SINGLE_PRESS = null;
    public static final ObricAiKeyGestureAction TIMEOUT = null;
    public static final /* synthetic */ ObricAiKeyGestureAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricAiKeyGestureAction> getEntries() {
        return b;
    }

    static {
        ObricAiKeyGestureAction r0 = new ObricAiKeyGestureAction("DOWN", 0);
        DOWN = r0;
        ObricAiKeyGestureAction r1 = new ObricAiKeyGestureAction("LONG_PRESS_FAILED", 1);
        LONG_PRESS_FAILED = r1;
        ObricAiKeyGestureAction r3 = new ObricAiKeyGestureAction("SINGLE_PRESS", 2);
        SINGLE_PRESS = r3;
        ObricAiKeyGestureAction r5 = new ObricAiKeyGestureAction("DOUBLE_PRESS", 3);
        DOUBLE_PRESS = r5;
        ObricAiKeyGestureAction r7 = new ObricAiKeyGestureAction("PRESS_START", 4);
        PRESS_START = r7;
        ObricAiKeyGestureAction r9 = new ObricAiKeyGestureAction("SHORT_PRESS", 5);
        SHORT_PRESS = r9;
        ObricAiKeyGestureAction r11 = new ObricAiKeyGestureAction("LONG_PRESS_START", 6);
        LONG_PRESS_START = r11;
        ObricAiKeyGestureAction r13 = new ObricAiKeyGestureAction("LONG_PRESS_STOP", 7);
        LONG_PRESS_STOP = r13;
        ObricAiKeyGestureAction r15 = new ObricAiKeyGestureAction("CANCEL", 8);
        CANCEL = r15;
        ObricAiKeyGestureAction r14 = new ObricAiKeyGestureAction("TIMEOUT", 9);
        TIMEOUT = r14;
        ObricAiKeyGestureAction[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static ObricAiKeyGestureAction[] values() {
        return (ObricAiKeyGestureAction[]) a.clone();
    }

    public static ObricAiKeyGestureAction valueOf(String r1) {
        return (ObricAiKeyGestureAction) a.a(ObricAiKeyGestureAction.class, r1);
    }

    public ObricAiKeyGestureAction(String r1, int r2) {
        super(r1, r2);
    }
}
