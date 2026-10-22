package com.bytedance.apm6.consumer.slardar.persistent;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LogItem {
    private byte[] data;

    public LogItem(byte[] r10) {
        this.data = r10;
    }

    public byte[] getData() {
        return this.data;
    }

    public String toString() {
        return new JSONObject(new String(this.data)).toString();
    L4:
        return "";
    }
}
