package com.bytedance.memory.model;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ClassNumber implements Serializable {
    private static final long serialVersionUID = -3511673943004282406L;
    private String mClassName;
    private int mCount;

    public ClassNumber() {
    }

    public String getClassName() {
        return this.mClassName;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setClassName(String r10) {
        this.mClassName = r10;
    }

    public void setCount(int r10) {
        this.mCount = r10;
    }

    public String toString() {
        JSONObject r10 = new JSONObject();
        r10.put("object_class", this.mClassName);     // Catch: JSONException -> L5
        r10.put("instance_count", this.mCount);     // Catch: JSONException -> L5
    L8:
        return r10.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
