package com.bytedance.crash;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IAnrUploadCallback {
    void onCrash(long r10, long r11, String r12, JSONObject r13);
}
