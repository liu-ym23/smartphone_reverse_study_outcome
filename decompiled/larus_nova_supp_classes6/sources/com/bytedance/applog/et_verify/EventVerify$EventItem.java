package com.bytedance.applog.et_verify;

import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class EventVerify$EventItem {
    JSONArray mEventJsonArray;
    String mEventType;

    public String toString() {
        return "EventItem{mEventType='" + this.mEventType + "', mEventJsonArray=" + this.mEventJsonArray + '}';
    }

    public EventVerify$EventItem(String r1, JSONArray r2) {
        this.mEventType = r1;
        this.mEventJsonArray = r2;
    }
}
