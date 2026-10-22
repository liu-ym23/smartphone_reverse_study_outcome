package com.bytedance.crash;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IAnrUploadCallback {
    void onCrash(long r1, long r3, String r5, JSONObject r6);
}
