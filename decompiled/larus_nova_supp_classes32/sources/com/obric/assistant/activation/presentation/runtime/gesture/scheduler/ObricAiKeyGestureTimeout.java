package com.obric.assistant.activation.presentation.runtime.gesture.scheduler;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/gesture/scheduler/ObricAiKeyGestureTimeout;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "SINGLE_PRESS", "PRESS_START", "LONG_PRESS", "SECOND_PRESS", "GESTURE", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAiKeyGestureTimeout extends Enum<ObricAiKeyGestureTimeout> {
    public static final ObricAiKeyGestureTimeout GESTURE = null;
    public static final ObricAiKeyGestureTimeout LONG_PRESS = null;
    public static final ObricAiKeyGestureTimeout PRESS_START = null;
    public static final ObricAiKeyGestureTimeout SECOND_PRESS = null;
    public static final ObricAiKeyGestureTimeout SINGLE_PRESS = null;
    public static final /* synthetic */ ObricAiKeyGestureTimeout[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricAiKeyGestureTimeout> getEntries() {
        return b;
    }

    static {
        ObricAiKeyGestureTimeout r0 = new ObricAiKeyGestureTimeout("SINGLE_PRESS", 0);
        SINGLE_PRESS = r0;
        ObricAiKeyGestureTimeout r1 = new ObricAiKeyGestureTimeout("PRESS_START", 1);
        PRESS_START = r1;
        ObricAiKeyGestureTimeout r3 = new ObricAiKeyGestureTimeout("LONG_PRESS", 2);
        LONG_PRESS = r3;
        ObricAiKeyGestureTimeout r5 = new ObricAiKeyGestureTimeout("SECOND_PRESS", 3);
        SECOND_PRESS = r5;
        ObricAiKeyGestureTimeout r7 = new ObricAiKeyGestureTimeout("GESTURE", 4);
        GESTURE = r7;
        ObricAiKeyGestureTimeout[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ObricAiKeyGestureTimeout[] values() {
        return (ObricAiKeyGestureTimeout[]) a.clone();
    }

    public static ObricAiKeyGestureTimeout valueOf(String r1) {
        return (ObricAiKeyGestureTimeout) a.a(ObricAiKeyGestureTimeout.class, r1);
    }

    public ObricAiKeyGestureTimeout(String r1, int r2) {
        super(r1, r2);
    }
}
