package com.bytedance.crypto.utils;

import com.bytedance.crypto.bridge.IEventBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EventUtils {
    private static IEventBridge mEventBridge;

    public EventUtils() {
    }

    public static void init(IEventBridge r10) {
        mEventBridge = r10;
    }

    public static void onEvent(String r10, JSONObject r11) {
        IEventBridge r12 = mEventBridge;
        if (r12 == null) goto L6;
        r12.onEvent(r10, r11);
        return;
    }
}
