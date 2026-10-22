package com.obric.assistant.activation.presentation.contract.gesture;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/gesture/ObricAiKeyGestureState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "IDLE", "FIRST_DOWN", "FIRST_UP", "SECOND_DOWN", "PRESS_START", "LONG_PRESS", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAiKeyGestureState extends Enum<ObricAiKeyGestureState> {
    public static final ObricAiKeyGestureState FIRST_DOWN = null;
    public static final ObricAiKeyGestureState FIRST_UP = null;
    public static final ObricAiKeyGestureState IDLE = null;
    public static final ObricAiKeyGestureState LONG_PRESS = null;
    public static final ObricAiKeyGestureState PRESS_START = null;
    public static final ObricAiKeyGestureState SECOND_DOWN = null;
    public static final /* synthetic */ ObricAiKeyGestureState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricAiKeyGestureState> getEntries() {
        return b;
    }

    static {
        ObricAiKeyGestureState r0 = new ObricAiKeyGestureState("IDLE", 0);
        IDLE = r0;
        ObricAiKeyGestureState r1 = new ObricAiKeyGestureState("FIRST_DOWN", 1);
        FIRST_DOWN = r1;
        ObricAiKeyGestureState r3 = new ObricAiKeyGestureState("FIRST_UP", 2);
        FIRST_UP = r3;
        ObricAiKeyGestureState r5 = new ObricAiKeyGestureState("SECOND_DOWN", 3);
        SECOND_DOWN = r5;
        ObricAiKeyGestureState r7 = new ObricAiKeyGestureState("PRESS_START", 4);
        PRESS_START = r7;
        ObricAiKeyGestureState r9 = new ObricAiKeyGestureState("LONG_PRESS", 5);
        LONG_PRESS = r9;
        ObricAiKeyGestureState[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ObricAiKeyGestureState[] values() {
        return (ObricAiKeyGestureState[]) a.clone();
    }

    public static ObricAiKeyGestureState valueOf(String r1) {
        return (ObricAiKeyGestureState) a.a(ObricAiKeyGestureState.class, r1);
    }

    public ObricAiKeyGestureState(String r1, int r2) {
        super(r1, r2);
    }
}
