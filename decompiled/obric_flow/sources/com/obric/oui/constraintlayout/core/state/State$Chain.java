package com.obric.oui.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final enum State$Chain extends Enum<State$Chain> {
    public static final State$Chain PACKED = null;
    public static final State$Chain SPREAD = null;
    public static final State$Chain SPREAD_INSIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Chain[] f12550a = null;
    public static Map<String, State$Chain> chainMap;
    public static Map<String, Integer> valueMap;

    static {
        State$Chain r5 = new State$Chain("SPREAD", 0);
        SPREAD = r5;
        State$Chain r10 = new State$Chain("SPREAD_INSIDE", 1);
        SPREAD_INSIDE = r10;
        State$Chain r11 = new State$Chain("PACKED", 2);
        PACKED = r11;
        f12550a = new State$Chain[]{r5, r10, r11};
        chainMap = new HashMap();
        valueMap = new HashMap();
        chainMap.put("packed", r11);
        chainMap.put("spread_inside", r10);
        chainMap.put("spread", r5);
        valueMap.put("packed", 2);
        valueMap.put("spread_inside", 1);
        valueMap.put("spread", 0);
    }

    public static State$Chain getChainByString(String r5) {
        if (chainMap.containsKey(r5) == true) goto L5;
        return null;
    L5:
        return chainMap.get(r5);
    }

    public static int getValueByString(String r5) {
        if (valueMap.containsKey(r5) == true) goto L5;
        return -1;
    L5:
        return valueMap.get(r5).intValue();
    }

    public static State$Chain valueOf(String r5) {
        return (State$Chain) Enum.valueOf(State$Chain.class, r5);
    }

    public static State$Chain[] values() {
        return (State$Chain[]) f12550a.clone();
    }
}
