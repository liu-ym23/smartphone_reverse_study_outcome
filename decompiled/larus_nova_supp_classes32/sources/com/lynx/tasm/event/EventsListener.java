package com.lynx.tasm.event;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class EventsListener {
    private static final String FUNCTION = "function";
    private static final String LEPUS_FUNCTION = "lepusFunction";
    private static final String LEPUS_TYPE = "lepusType";
    private static final String NAME = "name";
    private static final String TYPE = "type";
    public String functionName;
    public String lepusFunctionName;
    public String lepusType;
    public String name;
    public String type;

    public static Map<String, EventsListener> convertEventListeners(ReadableArray r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        int r1 = 0;
    L7:
        if (r1 >= r10.size()) goto L22;
        ReadableMap r2 = r10.getMap(r1);
        String r5 = r2.getString("name");
        EventsListener r3 = (EventsListener) r0.get(r5);
        if (r3 != null) goto L12;
        r3 = new EventsListener(r5, r2.getString("type"), r2.getString(FUNCTION), r2.getString(LEPUS_TYPE), r2.getString(LEPUS_FUNCTION));
    L21:
        r0.put(r3.name, r3);
        r1 = r1 + 1;
        goto L7
    L12:
        if (r3.type != null) goto L17;
        if (r3.functionName != null) goto L17;
        r3.type = r2.getString("type");
        r3.functionName = r2.getString(FUNCTION);
    L17:
        if (r3.lepusType != null) goto L21;
        if (r3.lepusFunctionName != null) goto L21;
        r3.lepusType = r2.getString(LEPUS_TYPE);
        r3.lepusFunctionName = r2.getString(LEPUS_FUNCTION);
        goto L21
    L22:
        return r0;
    }

    public EventsListener(String r1, String r2, String r3, String r4, String r5) {
        this.name = r1;
        this.type = r2;
        this.functionName = r3;
        this.lepusType = r4;
        this.lepusFunctionName = r5;
    }
}
