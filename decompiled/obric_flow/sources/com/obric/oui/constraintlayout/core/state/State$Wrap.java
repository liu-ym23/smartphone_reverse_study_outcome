package com.obric.oui.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final enum State$Wrap extends Enum<State$Wrap> {
    public static final State$Wrap ALIGNED = null;
    public static final State$Wrap CHAIN = null;
    public static final State$Wrap NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Wrap[] f12554a = null;
    public static Map<String, Integer> valueMap;
    public static Map<String, State$Wrap> wrapMap;

    static {
        State$Wrap r5 = new State$Wrap("NONE", 0);
        NONE = r5;
        State$Wrap r10 = new State$Wrap("CHAIN", 1);
        CHAIN = r10;
        State$Wrap r11 = new State$Wrap("ALIGNED", 2);
        ALIGNED = r11;
        f12554a = new State$Wrap[]{r5, r10, r11};
        wrapMap = new HashMap();
        valueMap = new HashMap();
        wrapMap.put("none", r5);
        wrapMap.put("chain", r10);
        wrapMap.put("aligned", r11);
        valueMap.put("none", 0);
        valueMap.put("chain", 3);
        valueMap.put("aligned", 2);
    }

    public static State$Wrap getChainByString(String r5) {
        if (wrapMap.containsKey(r5) == true) goto L5;
        return null;
    L5:
        return wrapMap.get(r5);
    }

    public static int getValueByString(String r5) {
        if (valueMap.containsKey(r5) == true) goto L5;
        return -1;
    L5:
        return valueMap.get(r5).intValue();
    }

    public static State$Wrap valueOf(String r5) {
        return (State$Wrap) Enum.valueOf(State$Wrap.class, r5);
    }

    public static State$Wrap[] values() {
        return (State$Wrap[]) f12554a.clone();
    }
}
